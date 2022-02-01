import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;

public class mvx
  extends ClipDrawable
{
  private int jdField_a_of_type_Int;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_b_of_type_Int;
  private final Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  private mvx()
  {
    super(null, 17, 1);
  }
  
  public mvx(Drawable paramDrawable1, Drawable paramDrawable2, int paramInt1, int paramInt2)
  {
    super(paramDrawable1, paramInt1, 1);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable1;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  private float a(float paramFloat1, float paramFloat2)
  {
    return a(0.0F, paramFloat2, paramFloat1, this.jdField_b_of_type_Int / 2 + 0, paramFloat2 - this.jdField_b_of_type_Int / 2);
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    paramFloat2 = (paramFloat1 + paramFloat2) / 2.0F;
    paramFloat5 = (paramFloat4 + paramFloat5) / 2.0F;
    return (paramFloat3 - paramFloat2) * (paramFloat5 - paramFloat4) / (paramFloat2 - paramFloat1) + paramFloat5;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect1 = this.jdField_a_of_type_AndroidGraphicsRect;
    Rect localRect2 = this.jdField_b_of_type_AndroidGraphicsRect;
    Rect localRect3 = getBounds();
    float f1 = getLevel() / 10000.0F;
    localRect1.set(localRect3);
    localRect2.set(localRect3);
    float f2;
    if ((this.jdField_a_of_type_Int & 0x1) != 0)
    {
      f2 = a(localRect3.left + localRect3.width() * f1, localRect3.width());
      localRect1.right = ((int)(f2 - this.jdField_b_of_type_Int / 2) + localRect3.width() / 45);
      localRect2.left = ((int)(f2 + this.jdField_b_of_type_Int / 2) - localRect3.width() / 45);
    }
    if ((this.jdField_a_of_type_Int & 0x2) != 0)
    {
      f2 = localRect3.top;
      f1 = a(f1 * localRect3.height() + f2, localRect3.height());
      localRect1.bottom = ((int)(f1 - this.jdField_b_of_type_Int / 2) + localRect3.height() / 45);
      localRect2.top = ((int)(f1 + this.jdField_b_of_type_Int / 2) - localRect3.height() / 45);
    }
    paramCanvas.save();
    paramCanvas.clipRect(localRect1);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.clipRect(localRect2);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramRect);
    super.onBoundsChange(paramRect);
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setLevel(paramInt);
    return super.onLevelChange(paramInt);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setState(paramArrayOfInt);
    return super.onStateChange(paramArrayOfInt);
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setAlpha(paramInt);
    super.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(paramColorFilter);
    super.setColorFilter(paramColorFilter);
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mvx
 * JD-Core Version:    0.7.0.1
 */