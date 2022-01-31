import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;

public class luc
  extends lue
{
  protected final Context a;
  protected final int k;
  
  public luc(Context paramContext, int paramInt)
  {
    bhnt.a(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.k = paramInt;
    a(false);
  }
  
  protected Bitmap a()
  {
    Object localObject = null;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    localOptions.inScaled = false;
    int i = mww.a(this.jdField_a_of_type_AndroidContentContext);
    localOptions.inSampleSize = 1;
    if (i <= 480) {
      localOptions.inSampleSize = 2;
    }
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    try
    {
      Bitmap localBitmap2 = BitmapFactory.decodeResource(localResources, this.k, localOptions);
      localObject = localBitmap2;
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      do
      {
        localOptions.inSampleSize *= 2;
      } while (localResources == null);
      try
      {
        localObject = BitmapFactory.decodeResource(localResources, this.k, localOptions);
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        localOptions.inSampleSize *= 2;
        i = this.k;
        try
        {
          Bitmap localBitmap1 = BitmapFactory.decodeResource(localResources, i, localOptions);
          return localBitmap1;
        }
        catch (OutOfMemoryError localOutOfMemoryError2) {}
      }
    }
    return localObject;
    return null;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    if (!d()) {
      paramBitmap.recycle();
    }
  }
  
  public int[] a(lsv paramlsv)
  {
    if (!c()) {
      b(paramlsv);
    }
    return this.jdField_a_of_type_ArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     luc
 * JD-Core Version:    0.7.0.1
 */