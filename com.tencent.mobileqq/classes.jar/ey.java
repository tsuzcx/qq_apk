import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;

public class ey
{
  public static int a(String paramString)
  {
    switch (JpegExifReader.readOrientation(paramString))
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  @TargetApi(8)
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    int i = 1;
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    apdc.a(paramString, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    int j = ((BitmapFactory.Options)localObject).outHeight;
    paramInt1 = ((BitmapFactory.Options)localObject).outWidth / paramInt1;
    paramInt2 = j / paramInt2;
    if (paramInt1 < paramInt2)
    {
      if (paramInt1 > 0) {
        break label141;
      }
      paramInt1 = i;
    }
    label141:
    for (;;)
    {
      ((BitmapFactory.Options)localObject).inSampleSize = paramInt1;
      try
      {
        localObject = apdc.a(paramString, (BitmapFactory.Options)localObject);
        return localObject;
      }
      catch (Exception localException)
      {
        QLog.d("wifiphoto", 2, "getImageThumbnail error imagePath is " + paramString);
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.d("wifiphoto", 2, "getImageThumbnail error(OOM)! imagePath is " + paramString);
        return null;
      }
      paramInt1 = paramInt2;
      break;
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (JpegExifReader.isCrashJpeg(paramString)) {
          return;
        }
        ExifInterface localExifInterface = new ExifInterface(paramString);
        switch (paramInt)
        {
        case 90: 
          paramString = Integer.toString(1);
          localExifInterface.setAttribute("Orientation", paramString);
          localExifInterface.saveAttributes();
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = Integer.toString(6);
      continue;
      paramString = Integer.toString(3);
      continue;
      paramString = Integer.toString(8);
    }
  }
  
  @TargetApi(8)
  public static Bitmap b(String paramString, int paramInt1, int paramInt2)
  {
    int j = 1;
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
    int k = ((BitmapFactory.Options)localObject).outHeight;
    int i = ((BitmapFactory.Options)localObject).outWidth / paramInt1;
    k /= paramInt2;
    if (i < k)
    {
      if (i > 0) {
        break label152;
      }
      i = j;
    }
    label152:
    for (;;)
    {
      ((BitmapFactory.Options)localObject).inSampleSize = i;
      try
      {
        localObject = SafeBitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
        return ThumbnailUtils.extractThumbnail((Bitmap)localObject, paramInt1, paramInt2, 2);
      }
      catch (Exception localException)
      {
        QLog.d("wifiphoto", 2, "getImageThumbnailForSize error imagePath is " + paramString);
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.d("wifiphoto", 2, "getImageThumbnailForSize error(OOM)! imagePath is " + paramString);
        return null;
      }
      i = k;
      break;
    }
  }
  
  @TargetApi(8)
  public static Bitmap c(String paramString, int paramInt1, int paramInt2)
  {
    return ThumbnailUtils.createVideoThumbnail(paramString, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ey
 * JD-Core Version:    0.7.0.1
 */