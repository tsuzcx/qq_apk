import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.album.tools.PhotoSelecter;

public class sen
  implements Comparable<sen>
{
  public int a;
  Bitmap a;
  public sdg a;
  
  public int a(@NonNull sen paramsen)
  {
    return (int)(this.jdField_a_of_type_Sdg.b - paramsen.jdField_a_of_type_Sdg.b);
  }
  
  public Bitmap a(Context paramContext)
  {
    BitmapFactory.Options localOptions;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      localOptions = new BitmapFactory.Options();
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_Sdg.a(paramContext, 1, localOptions);
      this.jdField_a_of_type_AndroidGraphicsBitmap = seo.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      return this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        urk.c(PhotoSelecter.a, "get thumbnail failed!", paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sen
 * JD-Core Version:    0.7.0.1
 */