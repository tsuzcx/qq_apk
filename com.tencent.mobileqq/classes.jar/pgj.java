import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.component.media.image.drawable.SliceBitmapDrawable;
import com.tencent.component.media.image.drawable.SliceBitmapDrawable.SliceBitmap;

public final class pgj
  extends Drawable.ConstantState
{
  public int a;
  public Paint a;
  public SliceBitmapDrawable.SliceBitmap a;
  public int b = 160;
  
  public pgj(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
    this.jdField_a_of_type_ComTencentComponentMediaImageDrawableSliceBitmapDrawable$SliceBitmap = new SliceBitmapDrawable.SliceBitmap(paramBitmap);
  }
  
  public pgj(SliceBitmapDrawable.SliceBitmap paramSliceBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
    this.jdField_a_of_type_ComTencentComponentMediaImageDrawableSliceBitmapDrawable$SliceBitmap = paramSliceBitmap;
  }
  
  public pgj(pgj parampgj)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
    this.jdField_a_of_type_ComTencentComponentMediaImageDrawableSliceBitmapDrawable$SliceBitmap = parampgj.jdField_a_of_type_ComTencentComponentMediaImageDrawableSliceBitmapDrawable$SliceBitmap;
    this.jdField_a_of_type_Int = parampgj.jdField_a_of_type_Int;
    this.b = parampgj.b;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(parampgj.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getChangingConfigurations()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable newDrawable()
  {
    return new SliceBitmapDrawable(this, null, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new SliceBitmapDrawable(this, paramResources, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pgj
 * JD-Core Version:    0.7.0.1
 */