package com.tencent.mobileqq.dinifly.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.animation.content.ContentGroup;
import com.tencent.mobileqq.dinifly.model.KeyPath;
import com.tencent.mobileqq.dinifly.model.content.ShapeGroup;
import java.util.Collections;
import java.util.List;

public class ShapeLayer
  extends BaseLayer
{
  private final ContentGroup contentGroup;
  
  ShapeLayer(LottieDrawable paramLottieDrawable, Layer paramLayer)
  {
    super(paramLottieDrawable, paramLayer);
    this.contentGroup = new ContentGroup(paramLottieDrawable, this, new ShapeGroup("__container", paramLayer.getShapes(), false));
    this.contentGroup.setContents(Collections.emptyList(), Collections.emptyList());
  }
  
  void drawLayer(@NonNull Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    this.contentGroup.draw(paramCanvas, paramMatrix, paramInt);
  }
  
  public void getBounds(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    super.getBounds(paramRectF, paramMatrix, paramBoolean);
    this.contentGroup.getBounds(paramRectF, this.boundsMatrix, paramBoolean);
  }
  
  protected void resolveChildKeyPath(KeyPath paramKeyPath1, int paramInt, List<KeyPath> paramList, KeyPath paramKeyPath2)
  {
    this.contentGroup.resolveKeyPath(paramKeyPath1, paramInt, paramList, paramKeyPath2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.layer.ShapeLayer
 * JD-Core Version:    0.7.0.1
 */