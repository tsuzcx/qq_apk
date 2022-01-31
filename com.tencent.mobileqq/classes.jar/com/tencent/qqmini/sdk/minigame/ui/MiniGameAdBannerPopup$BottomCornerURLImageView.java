package com.tencent.qqmini.sdk.minigame.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

class MiniGameAdBannerPopup$BottomCornerURLImageView
  extends ImageView
{
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private float[] jdField_a_of_type_ArrayOfFloat;
  
  public MiniGameAdBannerPopup$BottomCornerURLImageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0);
  }
  
  public MiniGameAdBannerPopup$BottomCornerURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public MiniGameAdBannerPopup$BottomCornerURLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    float f = TypedValue.applyDimension(1, 6.0F, paramContext.getResources().getDisplayMetrics());
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f, f, f, f };
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = paramCanvas.save();
    if (this.jdField_a_of_type_AndroidGraphicsPath != null)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_ArrayOfFloat, Path.Direction.CCW);
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
    super.onDraw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.ui.MiniGameAdBannerPopup.BottomCornerURLImageView
 * JD-Core Version:    0.7.0.1
 */