import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.album.tools.PhotoSelecter;

public class srj
  implements Comparable<srj>
{
  public int a;
  Bitmap a;
  public sqc a;
  
  public int a(@NonNull srj paramsrj)
  {
    return (int)(this.jdField_a_of_type_Sqc.b - paramsrj.jdField_a_of_type_Sqc.b);
  }
  
  public Bitmap a(Context paramContext)
  {
    BitmapFactory.Options localOptions;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      localOptions = new BitmapFactory.Options();
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Sqc.a(paramContext, 1, localOptions);
      this.jdField_a_of_type_AndroidGraphicsBitmap = srk.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        veg.c(PhotoSelecter.a, "get thumbnail failed!", paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     srj
 * JD-Core Version:    0.7.0.1
 */