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
    int i = TextLayer.3.$SwitchMap$com$tencent$mobileqq$dinifly$model$DocumentData$Justification[paramJustification.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        paramCanvas.translate(-paramFloat / 2.0F, 0.0F);
        return;
      }
      paramCanvas.translate(-paramFloat, 0.0F);
    }
  }
  
  private String codePointToString(String paramString, int paramInt)
  {
    int j = paramString.codePointAt(paramInt);
    int i = Character.charCount(j) + paramInt;
    while (i < paramString.length())
    {
      int k = paramString.codePointAt(i);
      if (!isModifier(k)) {
        break;
      }
      i += Character.charCount(k);
      j = j * 31 + k;
    }
    LongSparseArray localLongSparseArray = this.codePointCache;
    long l = j;
    if (localLongSparseArray.get(l) != null) {
      return (String)this.codePointCache.get(l);
    }
    this.stringBuilder.setLength(0);
    while (paramInt < i)
    {
      j = paramString.codePointAt(paramInt);
      this.stringBuilder.appendCodePoint(j);
      paramInt += Character.charCount(j);
    }
    paramString = this.stringBuilder.toString();
    this.codePointCache.put(l, paramString);
    return paramString;
  }
  
  private void drawCharacter(String paramString, Paint paramPaint, Canvas paramCanvas)
  {
    if (paramPaint.getColor() == 0) {
      return;
    }
    if ((paramPaint.getStyle() == Paint.Style.STROKE) && (paramPaint.getStrokeWidth() == 0.0F)) {
      return;
    }
    paramCanvas.drawText(paramString, 0, paramString.length(), 0.0F, 0.0F, paramPaint);
  }
  
  private void drawCharacterAsGlyph(FontCharacter paramFontCharacter, Matrix paramMatrix, float paramFloat, DocumentData paramDocumentData, Canvas paramCanvas)
  {
    paramFontCharacter = getContentsForCharacter(paramFontCharacter);
    int i = 0;
    while (i < paramFontCharacter.size())
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
      else
      {
        drawGlyph(localPath, this.strokePaint, paramCanvas);
        drawGlyph(localPath, this.fillPaint, paramCanvas);
      }
      i += 1;
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
    while (i < paramString.length())
    {
      Object localObject = codePointToString(paramString, i);
      i += ((String)localObject).length();
      drawCharacterFromFont((String)localObject, paramDocumentData, paramCanvas);
      float f3 = this.fillPaint.measureText((String)localObject, 0, 1);
      float f2 = paramDocumentData.tracking / 10.0F;
      localObject = this.trackingAnimation;
      float f1 = f2;
      if (localObject != null) {
        f1 = f2 + ((Float)((BaseKeyframeAnimation)localObject).getValue()).floatValue();
      }
      paramCanvas.translate(f3 + f1 * paramFloat, 0.0F);
    }
  }
  
  private void drawGlyph(Path paramPath, Paint paramPaint, Canvas paramCanvas)
  {
    if (paramPaint.getColor() == 0) {
      return;
    }
    if ((paramPaint.getStyle() == Paint.Style.STROKE) && (paramPaint.getStrokeWidth() == 0.0F)) {
      return;
    }
    paramCanvas.drawPath(paramPath, paramPaint);
  }
  
  private void drawGlyphTextLine(String paramString, DocumentData paramDocumentData, Matrix paramMatrix, Font paramFont, Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    int i = 0;
    while (i < paramString.length())
    {
      int j = FontCharacter.hashFor(paramString.charAt(i), paramFont.getFamily(), paramFont.getStyle());
      Object localObject = (FontCharacter)this.composition.getCharacters().get(j);
      if (localObject != null)
      {
        drawCharacterAsGlyph((FontCharacter)localObject, paramMatrix, paramFloat2, paramDocumentData, paramCanvas);
        float f3 = (float)((FontCharacter)localObject).getWidth();
        float f4 = Utils.dpScale();
        float f2 = paramDocumentData.tracking / 10.0F;
        localObject = this.trackingAnimation;
        float f1 = f2;
        if (localObject != null) {
          f1 = f2 + ((Float)((BaseKeyframeAnimation)localObject).getValue()).floatValue();
        }
        paramCanvas.translate(f3 * paramFloat2 * f4 * paramFloat1 + f1 * paramFloat1, 0.0F);
      }
      i += 1;
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
    if (localTypeface == null) {
      return;
    }
    Object localObject = paramDocumentData.text;
    TextDelegate localTextDelegate = this.lottieDrawable.getTextDelegate();
    paramFont = (Font)localObject;
    if (localTextDelegate != null) {
      paramFont = localTextDelegate.getTextInternal((String)localObject);
    }
    this.fillPaint.setTypeface(localTypeface);
    localObject = this.fillPaint;
    double d1 = paramDocumentData.size;
    double d2 = Utils.dpScale();
    Double.isNaN(d2);
    ((Paint)localObject).setTextSize((float)(d1 * d2));
    this.strokePaint.setTypeface(this.fillPaint.getTypeface());
    this.strokePaint.setTextSize(this.fillPaint.getTextSize());
    float f2 = (float)paramDocumentData.lineHeight * Utils.dpScale();
    paramFont = getTextLines(paramFont);
    int j = paramFont.size();
    int i = 0;
    while (i < j)
    {
      localObject = (String)paramFont.get(i);
      float f3 = this.strokePaint.measureText((String)localObject);
      applyJustification(paramDocumentData.justification, paramCanvas, f3);
      f3 = (j - 1) * f2 / 2.0F;
      paramCanvas.translate(0.0F, i * f2 - f3);
      drawFontTextLine((String)localObject, paramDocumentData, paramCanvas, f1);
      paramCanvas.setMatrix(paramMatrix);
      i += 1;
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
    while (i < paramString.length())
    {
      int j = FontCharacter.hashFor(paramString.charAt(i), paramFont.getFamily(), paramFont.getStyle());
      FontCharacter localFontCharacter = (FontCharacter)this.composition.getCharacters().get(j);
      if (localFontCharacter != null)
      {
        double d1 = f;
        double d2 = localFontCharacter.getWidth();
        double d3 = paramFloat1;
        Double.isNaN(d3);
        double d4 = Utils.dpScale();
        Double.isNaN(d4);
        double d5 = paramFloat2;
        Double.isNaN(d5);
        Double.isNaN(d1);
        f = (float)(d1 + d2 * d3 * d4 * d5);
      }
      i += 1;
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
    BaseKeyframeAnimation localBaseKeyframeAnimation;
    if (paramT == LottieProperty.COLOR)
    {
      localBaseKeyframeAnimation = this.colorAnimation;
      if (localBaseKeyframeAnimation != null)
      {
        localBaseKeyframeAnimation.setValueCallback(paramLottieValueCallback);
        return;
      }
    }
    if (paramT == LottieProperty.STROKE_COLOR)
    {
      localBaseKeyframeAnimation = this.strokeColorAnimation;
      if (localBaseKeyframeAnimation != null)
      {
        localBaseKeyframeAnimation.setValueCallback(paramLottieValueCallback);
        return;
      }
    }
    if (paramT == LottieProperty.STROKE_WIDTH)
    {
      localBaseKeyframeAnimation = this.strokeWidthAnimation;
      if (localBaseKeyframeAnimation != null)
      {
        localBaseKeyframeAnimation.setValueCallback(paramLottieValueCallback);
        return;
      }
    }
    if (paramT == LottieProperty.TEXT_TRACKING)
    {
      paramT = this.trackingAnimation;
      if (paramT != null) {
        paramT.setValueCallback(paramLottieValueCallback);
      }
    }
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
    Object localObject = this.colorAnimation;
    if (localObject != null) {
      this.fillPaint.setColor(((Integer)((BaseKeyframeAnimation)localObject).getValue()).intValue());
    } else {
      this.fillPaint.setColor(localDocumentData.color);
    }
    localObject = this.strokeColorAnimation;
    if (localObject != null) {
      this.strokePaint.setColor(((Integer)((BaseKeyframeAnimation)localObject).getValue()).intValue());
    } else {
      this.strokePaint.setColor(localDocumentData.strokeColor);
    }
    if (this.transform.getOpacity() == null) {
      paramInt = 100;
    } else {
      paramInt = ((Integer)this.transform.getOpacity().getValue()).intValue();
    }
    paramInt = paramInt * 255 / 100;
    this.fillPaint.setAlpha(paramInt);
    this.strokePaint.setAlpha(paramInt);
    localObject = this.strokeWidthAnimation;
    if (localObject != null)
    {
      this.strokePaint.setStrokeWidth(((Float)((BaseKeyframeAnimation)localObject).getValue()).floatValue());
    }
    else
    {
      float f = Utils.getScale(paramMatrix);
      localObject = this.strokePaint;
      double d1 = localDocumentData.strokeWidth;
      double d2 = Utils.dpScale();
      Double.isNaN(d2);
      double d3 = f;
      Double.isNaN(d3);
      ((Paint)localObject).setStrokeWidth((float)(d1 * d2 * d3));
    }
    if (this.lottieDrawable.useTextGlyphs()) {
      drawTextGlyphs(localDocumentData, paramMatrix, localFont, paramCanvas);
    } else {
      drawTextWithFont(localDocumentData, localFont, paramMatrix, paramCanvas);
    }
    paramCanvas.restore();
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    super.getBounds(paramRectF, paramMatrix, paramBoolean);
    paramRectF.set(0.0F, 0.0F, this.composition.getBounds().width(), this.composition.getBounds().height());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.TextLayer
 * JD-Core Version:    0.7.0.1
 */