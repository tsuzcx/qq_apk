package com.tencent.mobileqq.dinifly.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieProperty;
import com.tencent.mobileqq.dinifly.TextDelegate;
import com.tencent.mobileqq.dinifly.animation.content.ContentGroup;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.TextKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.TransformKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.DocumentData;
import com.tencent.mobileqq.dinifly.model.DocumentData.Justification;
import com.tencent.mobileqq.dinifly.model.Font;
import com.tencent.mobileqq.dinifly.model.FontCharacter;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextFrame;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextProperties;
import com.tencent.mobileqq.dinifly.model.content.ShapeGroup;
import com.tencent.mobileqq.dinifly.utils.Utils;
import com.tencent.mobileqq.dinifly.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiresApi(api=16)
public class TextLayer
  extends BaseLayer
{
  private final LongSparseArray<String> codePointCache = new LongSparseArray();
  @Nullable
  private BaseKeyframeAnimation<Integer, Integer> colorAnimation;
  private final LottieComposition composition;
  private final Map<FontCharacter, List<ContentGroup>> contentsForCharacter = new HashMap();
  private final Paint fillPaint = new TextLayer.1(this, 1);
  private final LottieDrawable lottieDrawable;
  private final Matrix matrix = new Matrix();
  private final RectF rectF = new RectF();
  private final StringBuilder stringBuilder = new StringBuilder(2);
  @Nullable
  private BaseKeyframeAnimation<Integer, Integer> strokeColorAnimation;
  private final Paint strokePaint = new TextLayer.2(this, 1);
  @Nullable
  private BaseKeyframeAnimation<Float, Float> strokeWidthAnimation;
  private final TextKeyframeAnimation textAnimation;
  @Nullable
  private BaseKeyframeAnimation<Float, Float> trackingAnimation;
  
  TextLayer(LottieDrawable paramLottieDrawable, Layer paramLayer)
  {
    super(paramLottieDrawable, paramLayer);
    this.lottieDrawable = paramLottieDrawable;
    this.composition = paramLayer.getComposition();
    this.textAnimation = paramLayer.getText().createAnimation();
    this.textAnimation.addUpdateListener(this);
    addAnimation(this.textAnimation);
    paramLottieDrawable = paramLayer.getTextProperties();
    if ((paramLottieDrawable != null) && (paramLottieDrawable.color != null))
    {
      this.colorAnimation = paramLottieDrawable.color.createAnimation();
      this.colorAnimation.addUpdateListener(this);
      addAnimation(this.colorAnimation);
    }
    if ((paramLottieDrawable != null) && (paramLottieDrawable.stroke != null))
    {
      this.strokeColorAnimation = paramLottieDrawable.stroke.createAnimation();
      this.strokeColorAnimation.addUpdateListener(this);
      addAnimation(this.strokeColorAnimation);
    }
    if ((paramLottieDrawable != null) && (paramLottieDrawable.strokeWidth != null))
    {
      this.strokeWidthAnimation = paramLottieDrawable.strokeWidth.createAnimation();
      this.strokeWidthAnimation.addUpdateListener(this);
      addAnimation(this.strokeWidthAnimation);
    }
    if ((paramLottieDrawable != null) && (paramLottieDrawable.tracking != null))
    {
      this.trackingAnimation = paramLottieDrawable.tracking.createAnimation();
      this.trackingAnimation.addUpdateListener(this);
      addAnimation(this.trackingAnimation);
    }
  }
  
  private void applyJustification(DocumentData.Justification paramJustification, Canvas paramCanvas, float paramFloat)
  {
    switch (TextLayer.3.$SwitchMap$com$tencent$mobileqq$dinifly$model$DocumentData$Justification[paramJustification.ordinal()])
    {
    case 1: 
    default: 
      return;
    case 2: 
      paramCanvas.translate(-paramFloat, 0.0F);
      return;
    }
    paramCanvas.translate(-paramFloat / 2.0F, 0.0F);
  }
  
  private String codePointToString(String paramString, int paramInt)
  {
    int i = paramString.codePointAt(paramInt);
    int j = Character.charCount(i) + paramInt;
    int k;
    for (;;)
    {
      if (j < paramString.length())
      {
        k = paramString.codePointAt(j);
        if (isModifier(k)) {}
      }
      else
      {
        if (!this.codePointCache.containsKey(i)) {
          break;
        }
        return (String)this.codePointCache.get(i);
      }
      j += Character.charCount(k);
      i = i * 31 + k;
    }
    this.stringBuilder.setLength(0);
    while (paramInt < j)
    {
      k = paramString.codePointAt(paramInt);
      this.stringBuilder.appendCodePoint(k);
      paramInt += Character.charCount(k);
    }
    paramString = this.stringBuilder.toString();
    this.codePointCache.put(i, paramString);
    return paramString;
  }
  
  private void drawCharacter(String paramString, Paint paramPaint, Canvas paramCanvas)
  {
    if (paramPaint.getColor() == 0) {}
    while ((paramPaint.getStyle() == Paint.Style.STROKE) && (paramPaint.getStrokeWidth() == 0.0F)) {
      return;
    }
    paramCanvas.drawText(paramString, 0, paramString.length(), 0.0F, 0.0F, paramPaint);
  }
  
  private void drawCharacterAsGlyph(FontCharacter paramFontCharacter, Matrix paramMatrix, float paramFloat, DocumentData paramDocumentData, Canvas paramCanvas)
  {
    paramFontCharacter = getContentsForCharacter(paramFontCharacter);
    int i = 0;
    if (i < paramFontCharacter.size())
    {
      Path localPath = ((ContentGroup)paramFontCharacter.get(i)).getPath();
      localPath.computeBounds(this.rectF, false);
      this.matrix.set(paramMatrix);
      this.matrix.preTranslate(0.0F, (float)-paramDocumentData.baselineShift * Utils.dpScale());
      this.matrix.preScale(paramFloat, paramFloat);
      localPath.transform(this.matrix);
      if (paramDocumentData.strokeOverFill)
      {
        drawGlyph(localPath, this.fillPaint, paramCanvas);
        drawGlyph(localPath, this.strokePaint, paramCanvas);
      }
      for (;;)
      {
        i += 1;
        break;
        drawGlyph(localPath, this.strokePaint, paramCanvas);
        drawGlyph(localPath, this.fillPaint, paramCanvas);
      }
    }
  }
  
  private void drawCharacterFromFont(String paramString, DocumentData paramDocumentData, Canvas paramCanvas)
  {
    if (paramDocumentData.strokeOverFill)
    {
      drawCharacter(paramString, this.fillPaint, paramCanvas);
      drawCharacter(paramString, this.strokePaint, paramCanvas);
      return;
    }
    drawCharacter(paramString, this.strokePaint, paramCanvas);
    drawCharacter(paramString, this.fillPaint, paramCanvas);
  }
  
  private void drawFontTextLine(String paramString, DocumentData paramDocumentData, Canvas paramCanvas, float paramFloat)
  {
    int i = 0;
    int j;
    float f2;
    float f1;
    if (i < paramString.length())
    {
      String str = codePointToString(paramString, i);
      j = str.length();
      drawCharacterFromFont(str, paramDocumentData, paramCanvas);
      f2 = this.fillPaint.measureText(str, 0, 1);
      f1 = paramDocumentData.tracking / 10.0F;
      if (this.trackingAnimation == null) {
        break label109;
      }
      f1 = ((Float)this.trackingAnimation.getValue()).floatValue() + f1;
    }
    label109:
    for (;;)
    {
      paramCanvas.translate(f1 * paramFloat + f2, 0.0F);
      i = j + i;
      break;
      return;
    }
  }
  
  private void drawGlyph(Path paramPath, Paint paramPaint, Canvas paramCanvas)
  {
    if (paramPaint.getColor() == 0) {}
    while ((paramPaint.getStyle() == Paint.Style.STROKE) && (paramPaint.getStrokeWidth() == 0.0F)) {
      return;
    }
    paramCanvas.drawPath(paramPath, paramPaint);
  }
  
  private void drawGlyphTextLine(String paramString, DocumentData paramDocumentData, Matrix paramMatrix, Font paramFont, Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    int i = 0;
    float f2;
    float f3;
    float f1;
    while (i < paramString.length())
    {
      int j = FontCharacter.hashFor(paramString.charAt(i), paramFont.getFamily(), paramFont.getStyle());
      FontCharacter localFontCharacter = (FontCharacter)this.composition.getCharacters().get(j);
      if (localFontCharacter == null)
      {
        i += 1;
      }
      else
      {
        drawCharacterAsGlyph(localFontCharacter, paramMatrix, paramFloat2, paramDocumentData, paramCanvas);
        f2 = (float)localFontCharacter.getWidth();
        f3 = Utils.dpScale();
        f1 = paramDocumentData.tracking / 10.0F;
        if (this.trackingAnimation == null) {
          break label152;
        }
        f1 = ((Float)this.trackingAnimation.getValue()).floatValue() + f1;
      }
    }
    label152:
    for (;;)
    {
      paramCanvas.translate(f1 * paramFloat1 + f2 * paramFloat2 * f3 * paramFloat1, 0.0F);
      break;
      return;
    }
  }
  
  private void drawTextGlyphs(DocumentData paramDocumentData, Matrix paramMatrix, Font paramFont, Canvas paramCanvas)
  {
    float f1 = (float)paramDocumentData.size / 100.0F;
    float f2 = Utils.getScale(paramMatrix);
    Object localObject = paramDocumentData.text;
    float f3 = (float)paramDocumentData.lineHeight * Utils.dpScale();
    localObject = getTextLines((String)localObject);
    int j = ((List)localObject).size();
    int i = 0;
    while (i < j)
    {
      String str = (String)((List)localObject).get(i);
      float f4 = getTextLineWidthForGlyphs(str, paramFont, f1, f2);
      paramCanvas.save();
      applyJustification(paramDocumentData.justification, paramCanvas, f4);
      f4 = (j - 1) * f3 / 2.0F;
      paramCanvas.translate(0.0F, i * f3 - f4);
      drawGlyphTextLine(str, paramDocumentData, paramMatrix, paramFont, paramCanvas, f2, f1);
      paramCanvas.restore();
      i += 1;
    }
  }
  
  private void drawTextWithFont(DocumentData paramDocumentData, Font paramFont, Matrix paramMatrix, Canvas paramCanvas)
  {
    float f1 = Utils.getScale(paramMatrix);
    Typeface localTypeface = this.lottieDrawable.getTypeface(paramFont.getFamily(), paramFont.getStyle());
    if (localTypeface == null) {}
    for (;;)
    {
      return;
      String str = paramDocumentData.text;
      TextDelegate localTextDelegate = this.lottieDrawable.getTextDelegate();
      paramFont = str;
      if (localTextDelegate != null) {
        paramFont = localTextDelegate.getTextInternal(str);
      }
      this.fillPaint.setTypeface(localTypeface);
      this.fillPaint.setTextSize((float)(paramDocumentData.size * Utils.dpScale()));
      this.strokePaint.setTypeface(this.fillPaint.getTypeface());
      this.strokePaint.setTextSize(this.fillPaint.getTextSize());
      float f2 = (float)paramDocumentData.lineHeight;
      f2 = Utils.dpScale() * f2;
      paramFont = getTextLines(paramFont);
      int j = paramFont.size();
      int i = 0;
      while (i < j)
      {
        str = (String)paramFont.get(i);
        float f3 = this.strokePaint.measureText(str);
        applyJustification(paramDocumentData.justification, paramCanvas, f3);
        f3 = (j - 1) * f2 / 2.0F;
        paramCanvas.translate(0.0F, i * f2 - f3);
        drawFontTextLine(str, paramDocumentData, paramCanvas, f1);
        paramCanvas.setMatrix(paramMatrix);
        i += 1;
      }
    }
  }
  
  private List<ContentGroup> getContentsForCharacter(FontCharacter paramFontCharacter)
  {
    if (this.contentsForCharacter.containsKey(paramFontCharacter)) {
      return (List)this.contentsForCharacter.get(paramFontCharacter);
    }
    List localList = paramFontCharacter.getShapes();
    int j = localList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      ShapeGroup localShapeGroup = (ShapeGroup)localList.get(i);
      localArrayList.add(new ContentGroup(this.lottieDrawable, this, localShapeGroup));
      i += 1;
    }
    this.contentsForCharacter.put(paramFontCharacter, localArrayList);
    return localArrayList;
  }
  
  private float getTextLineWidthForGlyphs(String paramString, Font paramFont, float paramFloat1, float paramFloat2)
  {
    float f = 0.0F;
    int i = 0;
    if (i < paramString.length())
    {
      int j = FontCharacter.hashFor(paramString.charAt(i), paramFont.getFamily(), paramFont.getStyle());
      FontCharacter localFontCharacter = (FontCharacter)this.composition.getCharacters().get(j);
      if (localFontCharacter == null) {}
      for (;;)
      {
        i += 1;
        break;
        f = (float)(f + localFontCharacter.getWidth() * paramFloat1 * Utils.dpScale() * paramFloat2);
      }
    }
    return f;
  }
  
  private List<String> getTextLines(String paramString)
  {
    return Arrays.asList(paramString.replaceAll("\r\n", "\r").replaceAll("\n", "\r").split("\r"));
  }
  
  private boolean isModifier(int paramInt)
  {
    return (Character.getType(paramInt) == 16) || (Character.getType(paramInt) == 27) || (Character.getType(paramInt) == 6) || (Character.getType(paramInt) == 28) || (Character.getType(paramInt) == 19);
  }
  
  public <T> void addValueCallback(T paramT, @Nullable LottieValueCallback<T> paramLottieValueCallback)
  {
    super.addValueCallback(paramT, paramLottieValueCallback);
    if ((paramT == LottieProperty.COLOR) && (this.colorAnimation != null)) {
      this.colorAnimation.setValueCallback(paramLottieValueCallback);
    }
    do
    {
      return;
      if ((paramT == LottieProperty.STROKE_COLOR) && (this.strokeColorAnimation != null))
      {
        this.strokeColorAnimation.setValueCallback(paramLottieValueCallback);
        return;
      }
      if ((paramT == LottieProperty.STROKE_WIDTH) && (this.strokeWidthAnimation != null))
      {
        this.strokeWidthAnimation.setValueCallback(paramLottieValueCallback);
        return;
      }
    } while ((paramT != LottieProperty.TEXT_TRACKING) || (this.trackingAnimation == null));
    this.trackingAnimation.setValueCallback(paramLottieValueCallback);
  }
  
  void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    paramCanvas.save();
    if (!this.lottieDrawable.useTextGlyphs()) {
      paramCanvas.setMatrix(paramMatrix);
    }
    DocumentData localDocumentData = (DocumentData)this.textAnimation.getValue();
    Font localFont = (Font)this.composition.getFonts().get(localDocumentData.fontName);
    if (localFont == null)
    {
      paramCanvas.restore();
      return;
    }
    if (this.colorAnimation != null)
    {
      this.fillPaint.setColor(((Integer)this.colorAnimation.getValue()).intValue());
      if (this.strokeColorAnimation == null) {
        break label223;
      }
      this.strokePaint.setColor(((Integer)this.strokeColorAnimation.getValue()).intValue());
      label118:
      if (this.transform.getOpacity() != null) {
        break label238;
      }
      paramInt = 100;
      label131:
      paramInt = paramInt * 255 / 100;
      this.fillPaint.setAlpha(paramInt);
      this.strokePaint.setAlpha(paramInt);
      if (this.strokeWidthAnimation == null) {
        break label258;
      }
      this.strokePaint.setStrokeWidth(((Float)this.strokeWidthAnimation.getValue()).floatValue());
      label183:
      if (!this.lottieDrawable.useTextGlyphs()) {
        break label289;
      }
      drawTextGlyphs(localDocumentData, paramMatrix, localFont, paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      this.fillPaint.setColor(localDocumentData.color);
      break;
      label223:
      this.strokePaint.setColor(localDocumentData.strokeColor);
      break label118;
      label238:
      paramInt = ((Integer)this.transform.getOpacity().getValue()).intValue();
      break label131;
      label258:
      float f = Utils.getScale(paramMatrix);
      this.strokePaint.setStrokeWidth((float)(localDocumentData.strokeWidth * Utils.dpScale() * f));
      break label183;
      label289:
      drawTextWithFont(localDocumentData, localFont, paramMatrix, paramCanvas);
    }
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    super.getBounds(paramRectF, paramMatrix, paramBoolean);
    paramRectF.set(0.0F, 0.0F, this.composition.getBounds().width(), this.composition.getBounds().height());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.TextLayer
 * JD-Core Version:    0.7.0.1
 */