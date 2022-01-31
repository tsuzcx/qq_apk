package cooperation.qzone.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

public class MaskURLImageView
  extends URLImageView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private float c;
  private float d;
  
  static
  {
    if (!MaskURLImageView.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public MaskURLImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MaskURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public MaskURLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = TypedValue.applyDimension(2, 18.0F, localDisplayMetrics);
    this.c = TypedValue.applyDimension(1, 4.0F, localDisplayMetrics);
    this.jdField_b_of_type_Float = TypedValue.applyDimension(1, 12.0F, localDisplayMetrics);
    this.d = TypedValue.applyDimension(1, 28.0F, localDisplayMetrics);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.RIGHT);
  }
  
  private void a(Canvas paramCanvas)
  {
    int i = (int)((getWidth() - this.d) / 2.0F);
    int j = (int)((getHeight() - this.d) / 2.0F);
    Drawable localDrawable = getResources().getDrawable(2130844679);
    if (localDrawable != null)
    {
      localDrawable.setBounds(i, j, (int)(i + this.d), (int)(j + this.d));
      localDrawable.draw(paramCanvas);
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Boolean) {
      a(paramCanvas);
    }
    while (this.jdField_a_of_type_Int <= 0) {
      return;
    }
    paramCanvas.drawColor(1711276032);
    int i = (int)(this.jdField_a_of_type_AndroidGraphicsPaint.measureText(String.valueOf(this.jdField_a_of_type_Int)) + this.c + this.jdField_b_of_type_Float);
    int j = (getWidth() - i) / 2;
    int k = (int)((getHeight() - this.jdField_b_of_type_Float) / 2.0F);
    int m = (int)(j + this.jdField_b_of_type_Float);
    int n = (int)(k + this.jdField_b_of_type_Float);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
    float f1 = ((Paint.FontMetrics)localObject).bottom;
    float f2 = ((Paint.FontMetrics)localObject).top;
    f1 = (getHeight() - (f1 - f2)) / 2.0F;
    f2 = ((Paint.FontMetrics)localObject).top;
    localObject = getResources().getDrawable(2130844253);
    if ((!jdField_a_of_type_Boolean) && (localObject == null)) {
      throw new AssertionError();
    }
    ((Drawable)localObject).setBounds(j, k, m, n);
    ((Drawable)localObject).draw(paramCanvas);
    paramCanvas.drawText(String.valueOf(this.jdField_a_of_type_Int), i + j, f1 - f2, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    b(paramCanvas);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    super.onLoadCanceled(paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public void setHasMore(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setNeedSowPlayIcon(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.widget.MaskURLImageView
 * JD-Core Version:    0.7.0.1
 */