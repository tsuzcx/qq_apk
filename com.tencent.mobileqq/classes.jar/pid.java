import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.component.media.image.drawable.SliceBitmapDrawable;
import com.tencent.component.media.image.drawable.SliceBitmapDrawable.SliceBitmap;

public final class pid
  extends Drawable.ConstantState
{
  public int a;
  public Paint a;
  public SliceBitmapDrawable.SliceBitmap a;
  public int b = 160;
  
  public pid(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
    this.jdField_a_of_type_ComTencentComponentMediaImageDrawableSliceBitmapDrawable$SliceBitmap = new SliceBitmapDrawable.SliceBitmap(paramBitmap);
  }
  
  public pid(SliceBitmapDrawable.SliceBitmap paramSliceBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
    this.jdField_a_of_type_ComTencentComponentMediaImageDrawableSliceBitmapDrawable$SliceBitmap = paramSliceBitmap;
  }
  
  public pid(pid parampid)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
    this.jdField_a_of_type_ComTencentComponentMediaImageDrawableSliceBitmapDrawable$SliceBitmap = parampid.jdField_a_of_type_ComTencentComponentMediaImageDrawableSliceBitmapDrawable$SliceBitmap;
    this.jdField_a_of_type_Int = parampid.jdField_a_of_type_Int;
    this.b = parampid.b;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(parampid.jdField_a_of_type_AndroidGraphicsPaint);
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
 * Qualified Name:     pid
 * JD-Core Version:    0.7.0.1
 */