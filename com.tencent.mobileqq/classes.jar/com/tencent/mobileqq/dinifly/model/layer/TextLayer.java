package com.tencent.mobileqq.dinifly.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.TextDelegate;
import com.tencent.mobileqq.dinifly.animation.content.ContentGroup;
import com.tencent.mobileqq.dinifly.animation.keyframe.BaseKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.TextKeyframeAnimation;
import com.tencent.mobileqq.dinifly.animation.keyframe.TransformKeyframeAnimation;
import com.tencent.mobileqq.dinifly.model.DocumentData;
import com.tencent.mobileqq.dinifly.model.Font;
import com.tencent.mobileqq.dinifly.model.FontCharacter;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableColorValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableFloatValue;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextFrame;
import com.tencent.mobileqq.dinifly.model.animatable.AnimatableTextProperties;
import com.tencent.mobileqq.dinifly.model.content.ShapeGroup;
import com.tencent.mobileqq.dinifly.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextLayer
  extends BaseLayer
{
  @Nullable
  private BaseKeyframeAnimation<Integer, Integer> colorAnimation;
  private final LottieComposition composition;
  private final Map<FontCharacter, List<ContentGroup>> contentsForCharacter = new HashMap();
  private final Paint fillPaint = new Paint(1) {};
  private final LottieDrawable lottieDrawable;
  private final Matrix matrix = new Matrix();
  private final RectF rectF = new RectF();
  @Nullable
  private BaseKeyframeAnimation<Integer, Integer> strokeAnimation;
  private final Paint strokePaint = new Paint(1) {};
  @Nullable
  private BaseKeyframeAnimation<Float, Float> strokeWidthAnimation;
  private final char[] tempCharArray = new char[1];
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
      this.strokeAnimation = paramLottieDrawable.stroke.createAnimation();
      this.strokeAnimation.addUpdateListener(this);
      addAnimation(this.strokeAnimation);
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
  
  private void drawCharacter(char[] paramArrayOfChar, Paint paramPaint, Canvas paramCanvas)
  {
    if (paramPaint.getColor() == 0) {}
    while ((paramPaint.getStyle() == Paint.Style.STROKE) && (paramPaint.getStrokeWidth() == 0.0F)) {
      return;
    }
    paramCanvas.drawText(paramArrayOfChar, 0, 1, 0.0F, 0.0F, paramPaint);
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
  
  private void drawCharacterFromFont(char paramChar, DocumentData paramDocumentData, Canvas paramCanvas)
  {
    this.tempCharArray[0] = paramChar;
    if (paramDocumentData.strokeOverFill)
    {
      drawCharacter(this.tempCharArray, this.fillPaint, paramCanvas);
      drawCharacter(this.tempCharArray, this.strokePaint, paramCanvas);
      return;
    }
    drawCharacter(this.tempCharArray, this.strokePaint, paramCanvas);
    drawCharacter(this.tempCharArray, this.fillPaint, paramCanvas);
  }
  
  private void drawGlyph(Path paramPath, Paint paramPaint, Canvas paramCanvas)
  {
    if (paramPaint.getColor() == 0) {}
    while ((paramPaint.getStyle() == Paint.Style.STROKE) && (paramPaint.getStrokeWidth() == 0.0F)) {
      return;
    }
    paramCanvas.drawPath(paramPath, paramPaint);
  }
  
  private void drawTextGlyphs(DocumentData paramDocumentData, Matrix paramMatrix, Font paramFont, Canvas paramCanvas)
  {
    float f3 = paramDocumentData.size / 100.0F;
    float f4 = Utils.getScale(paramMatrix);
    String str = paramDocumentData.text;
    int i = 0;
    if (i < str.length())
    {
      int j = FontCharacter.hashFor(str.charAt(i), paramFont.getFamily(), paramFont.getStyle());
      FontCharacter localFontCharacter = (FontCharacter)this.composition.getCharacters().get(j);
      if (localFontCharacter == null) {}
      for (;;)
      {
        i += 1;
        break;
        drawCharacterAsGlyph(localFontCharacter, paramMatrix, f3, paramDocumentData, paramCanvas);
        float f5 = (float)localFontCharacter.getWidth();
        float f6 = this.composition.getDpScale();
        float f2 = paramDocumentData.tracking / 10.0F;
        float f1 = f2;
        if (this.trackingAnimation != null) {
          f1 = f2 + ((Float)this.trackingAnimation.getValue()).floatValue();
        }
        paramCanvas.translate(f5 * f3 * f6 * f4 + f1 * f4, 0.0F);
      }
    }
  }
  
  private void drawTextWithFont(DocumentData paramDocumentData, Font paramFont, Matrix paramMatrix, Canvas paramCanvas)
  {
    float f3 = Utils.getScale(paramMatrix);
    Typeface localTypeface = this.lottieDrawable.getTypeface(paramFont.getFamily(), paramFont.getStyle());
    if (localTypeface == null) {}
    for (;;)
    {
      return;
      paramMatrix = paramDocumentData.text;
      TextDelegate localTextDelegate = this.lottieDrawable.getTextDelegate();
      paramFont = paramMatrix;
      if (localTextDelegate != null) {
        paramFont = localTextDelegate.getTextInternal(paramMatrix);
      }
      this.fillPaint.setTypeface(localTypeface);
      this.fillPaint.setTextSize(paramDocumentData.size * this.composition.getDpScale());
      this.strokePaint.setTypeface(this.fillPaint.getTypeface());
      this.strokePaint.setTextSize(this.fillPaint.getTextSize());
      int i = 0;
      while (i < paramFont.length())
      {
        char c = paramFont.charAt(i);
        drawCharacterFromFont(c, paramDocumentData, paramCanvas);
        this.tempCharArray[0] = c;
        float f4 = this.fillPaint.measureText(this.tempCharArray, 0, 1);
        float f2 = paramDocumentData.tracking / 10.0F;
        float f1 = f2;
        if (this.trackingAnimation != null) {
          f1 = f2 + ((Float)this.trackingAnimation.getValue()).floatValue();
        }
        paramCanvas.translate(f4 + f1 * f3, 0.0F);
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
      if (this.strokeAnimation == null) {
        break label225;
      }
      this.strokePaint.setColor(((Integer)this.strokeAnimation.getValue()).intValue());
      label118:
      paramInt = ((Integer)this.transform.getOpacity().getValue()).intValue() * 255 / 100;
      this.fillPaint.setAlpha(paramInt);
      this.strokePaint.setAlpha(paramInt);
      if (this.strokeWidthAnimation == null) {
        break label240;
      }
      this.strokePaint.setStrokeWidth(((Float)this.strokeWidthAnimation.getValue()).floatValue());
      label185:
      if (!this.lottieDrawable.useTextGlyphs()) {
        break label273;
      }
      drawTextGlyphs(localDocumentData, paramMatrix, localFont, paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      this.fillPaint.setColor(localDocumentData.color);
      break;
      label225:
      this.strokePaint.setColor(localDocumentData.strokeColor);
      break label118;
      label240:
      float f = Utils.getScale(paramMatrix);
      this.strokePaint.setStrokeWidth(localDocumentData.strokeWidth * this.composition.getDpScale() * f);
      break label185;
      label273:
      drawTextWithFont(localDocumentData, localFont, paramMatrix, paramCanvas);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.TextLayer
 * JD-Core Version:    0.7.0.1
 */