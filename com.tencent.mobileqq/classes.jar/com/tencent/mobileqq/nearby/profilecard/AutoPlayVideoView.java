package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.image.QQLiveDrawable;
import com.tencent.image.QQLiveDrawable.OnStateListener;
import com.tencent.image.QQLiveDrawable.QQLiveDrawableParams;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

public class AutoPlayVideoView
  extends ImageView
  implements QQLiveDrawable.OnStateListener
{
  private int jdField_a_of_type_Int;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  
  public AutoPlayVideoView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public AutoPlayVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public AutoPlayVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    if (Build.VERSION.SDK_INT >= 16) {
      super.setLayerType(2, null);
    }
    while (Build.VERSION.SDK_INT < 14) {
      return;
    }
    super.setLayerType(1, null);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoPlayVideoView", 2, "pausePlay last mState=" + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int = 3;
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable()).recyleAndKeepPostion();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    int j = getHeight();
    int k = getPaddingTop();
    int m = getPaddingBottom();
    RectF localRectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + i, j - k - m + getPaddingTop());
    if (this.b > 0) {
      i = this.b;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(localRectF, i, i, Path.Direction.CCW);
      this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      super.draw(paramCanvas);
      return;
      i /= 30;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && ((this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))) {}
  }
  
  public void onStateChange(String paramString, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams, int paramInt, Object paramObject)
  {
    if (paramInt == 2) {}
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("should not be less than 0");
    }
    this.b = paramInt;
  }
  
  public void setCoverUrl(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof URLDrawable)) {}
    for (this.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)paramDrawable);; this.jdField_a_of_type_ComTencentImageURLDrawable = null)
    {
      super.setImageDrawable(paramDrawable);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.AutoPlayVideoView
 * JD-Core Version:    0.7.0.1
 */