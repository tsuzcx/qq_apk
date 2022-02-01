package com.tencent.mobileqq.dinifly.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieProperty;
import com.tencent.mobileqq.dinifly.TextDelegate;
import com.tencent.mobileqq.dinifly.animation.content.ContentGroup;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.TextKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.TransformKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.ValueCallbackKeyframeAnimation;
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

public class TextLayer
  extends BaseLayer
{
  private final LongSparseArray<String> codePointCache = new LongSparseArray();
  @Nullable
  private BaseKeyframeAnimation<Integer, Integer> colorAnimation;
  @Nullable
  private BaseKeyframeAnimation<Integer, Integer> colorCallbackAnimation;
  private final LottieComposition composition;
  private final Map<FontCharacter, List<ContentGroup>> contentsForCharacter = new HashMap();
  private final Paint fillPaint = new TextLayer.1(this, 1);
  private final LottieDrawable lottieDrawable;
  private final Matrix matrix = new Matrix();
  private final RectF rectF = new RectF();
  private final StringBuilder stringBuilder = new StringBuilder(2);
  @Nullable
  private BaseKeyframeAnimation<Integer, Integer> strokeColorAnimation;
  @Nullable
  private BaseKeyframeAnimation<Integer, Integer> strokeColorCallbackAnimation;
  private final Paint strokePaint = new TextLayer.2(this, 1);
  @Nullable
  private BaseKeyframeAnimation<Float, Float> strokeWidthAnimation;
  @Nullable
  private BaseKeyframeAnimation<Float, Float> strokeWidthCallbackAnimation;
  private final TextKeyframeAnimation textAnimation;
  @Nullable
  private BaseKeyframeAnimation<Float, Float> textSizeAnimation;
  @Nullable
  private BaseKeyframeAnimation<Float, Float> textSizeCallbackAnimation;
  @Nullable
  private BaseKeyframeAnimation<Float, Float> trackingAnimation;
  @Nullable
  private BaseKeyframeAnimation<Float, Float> trackingCallbackAnimation;
  
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
    if (localLongSparseArray.containsKey(l)) {
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
      this.matrix.preTranslate(0.0F, -paramDocumentData.baselineShift * Utils.dpScale());
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
      String str = codePointToString(paramString, i);
      i += str.length();
      drawCharacterFromFont(str, paramDocumentData, paramCanvas);
      paramCanvas.translate(this.fillPaint.measureText(str) + paramFloat, 0.0F);
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
        localObject = this.trackingCallbackAnimation;
        if (localObject != null) {}
        for (float f1 = ((Float)((BaseKeyframeAnimation)localObject).getValue()).floatValue();; f1 = ((Float)((BaseKeyframeAnimation)localObject).getValue()).floatValue())
        {
          f1 = f2 + f1;
          break;
          localObject = this.trackingAnimation;
          f1 = f2;
          if (localObject == null) {
            break;
          }
        }
        paramCanvas.translate(f3 * paramFloat2 * f4 * paramFloat1 + f1 * paramFloat1, 0.0F);
      }
      i += 1;
    }
  }
  
  private void drawTextGlyphs(DocumentData paramDocumentData, Matrix paramMatrix, Font paramFont, Canvas paramCanvas)
  {
    Object localObject = this.textSizeCallbackAnimation;
    float f1;
    if (localObject != null)
    {
      f1 = ((Float)((BaseKeyframeAnimation)localObject).getValue()).floatValue();
    }
    else
    {
      localObject = this.textSizeAnimation;
      if (localObject != null) {
        f1 = ((Float)((BaseKeyframeAnimation)localObject).getValue()).floatValue();
      } else {
        f1 = paramDocumentData.size;
      }
    }
    f1 /= 100.0F;
    float f2 = Utils.getScale(paramMatrix);
    localObject = paramDocumentData.text;
    float f3 = paramDocumentData.lineHeight * Utils.dpScale();
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
    Utils.getScale(paramMatrix);
    Typeface localTypeface = this.lottieDrawable.getTypeface(paramFont.getFamily(), paramFont.getStyle());
    if (localTypeface == null) {
      return;
    }
    paramMatrix = paramDocumentData.text;
    TextDelegate localTextDelegate = this.lottieDrawable.getTextDelegate();
    paramFont = paramMatrix;
    if (localTextDelegate != null) {
      paramFont = localTextDelegate.getTextInternal(paramMatrix);
    }
    this.fillPaint.setTypeface(localTypeface);
    paramMatrix = this.textSizeCallbackAnimation;
    if (paramMatrix != null)
    {
      f1 = ((Float)paramMatrix.getValue()).floatValue();
    }
    else
    {
      paramMatrix = this.textSizeAnimation;
      if (paramMatrix != null) {
        f1 = ((Float)paramMatrix.getValue()).floatValue();
      } else {
        f1 = paramDocumentData.size;
      }
    }
    this.fillPaint.setTextSize(Utils.dpScale() * f1);
    this.strokePaint.setTypeface(this.fillPaint.getTypeface());
    this.strokePaint.setTextSize(this.fillPaint.getTextSize());
    float f4 = paramDocumentData.lineHeight * Utils.dpScale();
    float f3 = paramDocumentData.tracking / 10.0F;
    paramMatrix = this.trackingCallbackAnimation;
    if (paramMatrix != null) {}
    for (float f2 = ((Float)paramMatrix.getValue()).floatValue();; f2 = ((Float)paramMatrix.getValue()).floatValue())
    {
      f2 = f3 + f2;
      break;
      paramMatrix = this.trackingAnimation;
      f2 = f3;
      if (paramMatrix == null) {
        break;
      }
    }
    float f1 = f2 * Utils.dpScale() * f1 / 100.0F;
    paramFont = getTextLines(paramFont);
    int j = paramFont.size();
    int i = 0;
    while (i < j)
    {
      paramMatrix = (String)paramFont.get(i);
      f2 = this.strokePaint.measureText(paramMatrix);
      f3 = paramMatrix.length() - 1;
      paramCanvas.save();
      applyJustification(paramDocumentData.justification, paramCanvas, f2 + f3 * f1);
      f2 = (j - 1) * f4 / 2.0F;
      paramCanvas.translate(0.0F, i * f4 - f2);
      drawFontTextLine(paramMatrix, paramDocumentData, paramCanvas, f1);
      paramCanvas.restore();
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
    if (paramT == LottieProperty.COLOR)
    {
      paramT = this.colorCallbackAnimation;
      if (paramT != null) {
        removeAnimation(paramT);
      }
      if (paramLottieValueCallback == null)
      {
        this.colorCallbackAnimation = null;
        return;
      }
      this.colorCallbackAnimation = new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
      this.colorCallbackAnimation.addUpdateListener(this);
      addAnimation(this.colorCallbackAnimation);
      return;
    }
    if (paramT == LottieProperty.STROKE_COLOR)
    {
      paramT = this.strokeColorCallbackAnimation;
      if (paramT != null) {
        removeAnimation(paramT);
      }
      if (paramLottieValueCallback == null)
      {
        this.strokeColorCallbackAnimation = null;
        return;
      }
      this.strokeColorCallbackAnimation = new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
      this.strokeColorCallbackAnimation.addUpdateListener(this);
      addAnimation(this.strokeColorCallbackAnimation);
      return;
    }
    if (paramT == LottieProperty.STROKE_WIDTH)
    {
      paramT = this.strokeWidthCallbackAnimation;
      if (paramT != null) {
        removeAnimation(paramT);
      }
      if (paramLottieValueCallback == null)
      {
        this.strokeWidthCallbackAnimation = null;
        return;
      }
      this.strokeWidthCallbackAnimation = new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
      this.strokeWidthCallbackAnimation.addUpdateListener(this);
      addAnimation(this.strokeWidthCallbackAnimation);
      return;
    }
    if (paramT == LottieProperty.TEXT_TRACKING)
    {
      paramT = this.trackingCallbackAnimation;
      if (paramT != null) {
        removeAnimation(paramT);
      }
      if (paramLottieValueCallback == null)
      {
        this.trackingCallbackAnimation = null;
        return;
      }
      this.trackingCallbackAnimation = new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
      this.trackingCallbackAnimation.addUpdateListener(this);
      addAnimation(this.trackingCallbackAnimation);
      return;
    }
    if (paramT == LottieProperty.TEXT_SIZE)
    {
      paramT = this.textSizeCallbackAnimation;
      if (paramT != null) {
        removeAnimation(paramT);
      }
      if (paramLottieValueCallback == null)
      {
        this.textSizeCallbackAnimation = null;
        return;
      }
      this.textSizeCallbackAnimation = new ValueCallbackKeyframeAnimation(paramLottieValueCallback);
      this.textSizeCallbackAnimation.addUpdateListener(this);
      addAnimation(this.textSizeCallbackAnimation);
    }
  }
  
  void drawLayer(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    paramCanvas.save();
    if (!this.lottieDrawable.useTextGlyphs()) {
      paramCanvas.concat(paramMatrix);
    }
    DocumentData localDocumentData = (DocumentData)this.textAnimation.getValue();
    Font localFont = (Font)this.composition.getFonts().get(localDocumentData.fontName);
    if (localFont == null)
    {
      paramCanvas.restore();
      return;
    }
    BaseKeyframeAnimation localBaseKeyframeAnimation = this.colorCallbackAnimation;
    if (localBaseKeyframeAnimation != null)
    {
      this.fillPaint.setColor(((Integer)localBaseKeyframeAnimation.getValue()).intValue());
    }
    else
    {
      localBaseKeyframeAnimation = this.colorAnimation;
      if (localBaseKeyframeAnimation != null) {
        this.fillPaint.setColor(((Integer)localBaseKeyframeAnimation.getValue()).intValue());
      } else {
        this.fillPaint.setColor(localDocumentData.color);
      }
    }
    localBaseKeyframeAnimation = this.strokeColorCallbackAnimation;
    if (localBaseKeyframeAnimation != null)
    {
      this.strokePaint.setColor(((Integer)localBaseKeyframeAnimation.getValue()).intValue());
    }
    else
    {
      localBaseKeyframeAnimation = this.strokeColorAnimation;
      if (localBaseKeyframeAnimation != null) {
        this.strokePaint.setColor(((Integer)localBaseKeyframeAnimation.getValue()).intValue());
      } else {
        this.strokePaint.setColor(localDocumentData.strokeColor);
      }
    }
    if (this.transform.getOpacity() == null) {
      paramInt = 100;
    } else {
      paramInt = ((Integer)this.transform.getOpacity().getValue()).intValue();
    }
    paramInt = paramInt * 255 / 100;
    this.fillPaint.setAlpha(paramInt);
    this.strokePaint.setAlpha(paramInt);
    localBaseKeyframeAnimation = this.strokeWidthCallbackAnimation;
    if (localBaseKeyframeAnimation != null)
    {
      this.strokePaint.setStrokeWidth(((Float)localBaseKeyframeAnimation.getValue()).floatValue());
    }
    else
    {
      localBaseKeyframeAnimation = this.strokeWidthAnimation;
      if (localBaseKeyframeAnimation != null)
      {
        this.strokePaint.setStrokeWidth(((Float)localBaseKeyframeAnimation.getValue()).floatValue());
      }
      else
      {
        float f = Utils.getScale(paramMatrix);
        this.strokePaint.setStrokeWidth(localDocumentData.strokeWidth * Utils.dpScale() * f);
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.TextLayer
 * JD-Core Version:    0.7.0.1
 */