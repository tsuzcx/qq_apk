package cooperation.qqreader.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import bmrb;

public class LoadingImageView
  extends ImageView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = bmrb.a("https://qzonestyle.gtimg.cn/aoi/sola/20191212143823_h3cZSvL8ed.png");
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  
  public LoadingImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LoadingImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    invalidate();
  }
  
  private void b()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_Int = getMeasuredWidth();
      this.jdField_b_of_type_Int = getMeasuredHeight();
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    b();
    paramCanvas.save();
    paramCanvas.rotate(this.jdField_a_of_type_Float, this.jdField_a_of_type_Int / 2.0F, this.jdField_b_of_type_Int / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    super.onDraw(paramCanvas);
    paramCanvas.restore();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Float = ((this.jdField_a_of_type_Float + 5.0F) % 360.0F);
      postDelayed(new LoadingImageView.1(this), 30L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.view.LoadingImageView
 * JD-Core Version:    0.7.0.1
 */