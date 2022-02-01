package dov.com.qq.im.aeeditor.module.autotemplate;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FrameExtractor
{
  public Bitmap a(String paramString, long paramLong)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    paramString = Bitmap.createBitmap(localMediaMetadataRetriever.getFrameAtTime(paramLong, 3));
    localMediaMetadataRetriever.release();
    return paramString;
  }
  
  @RequiresApi(api=17)
  public Bitmap a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      Bitmap localBitmap = ExtractUtil.a.a(paramString, paramLong, paramInt);
      return localBitmap;
    }
    catch (Exception localException) {}
    return a(paramString, paramLong);
  }
  
  public List<Bitmap> a(List<FrameExtractor.MediaWithType> paramList, List<Long> paramList1, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = paramList.iterator();
    long l = 0L;
    while (((Iterator)localObject).hasNext())
    {
      l = ((FrameExtractor.MediaWithType)((Iterator)localObject).next()).jdField_a_of_type_Long + l;
      localArrayList2.add(Long.valueOf(l));
    }
    if ((paramList1 == null) || (paramList1.isEmpty())) {
      return localArrayList1;
    }
    paramList1 = new ArrayList(paramList1);
    int k = 0;
    int i = 0;
    int j;
    if (k < paramList1.size())
    {
      do
      {
        j = i;
        i = j;
        if (((Long)localArrayList2.get(j)).longValue() > ((Long)paramList1.get(k)).longValue()) {
          break;
        }
        j += 1;
        i = j;
      } while (j < localArrayList2.size());
      i = j;
      if (i < localArrayList2.size()) {}
    }
    else
    {
      return localArrayList1;
    }
    if (((Long)localArrayList2.get(i)).longValue() > ((Long)paramList1.get(k)).longValue())
    {
      if (((FrameExtractor.MediaWithType)paramList.get(i)).jdField_a_of_type_Int != 2) {
        break label393;
      }
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(((FrameExtractor.MediaWithType)paramList.get(i)).jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
      j = ((BitmapFactory.Options)localObject).outWidth;
      int m = ((BitmapFactory.Options)localObject).outHeight;
      if (paramInt <= 0) {
        break label445;
      }
      if (m <= j) {
        break label378;
      }
      if (m <= paramInt) {
        break label445;
      }
      j = m / paramInt;
    }
    for (;;)
    {
      label320:
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      ((BitmapFactory.Options)localObject).inSampleSize = j;
      localArrayList1.add(BitmapFactory.decodeFile(((FrameExtractor.MediaWithType)paramList.get(i)).jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject));
      for (;;)
      {
        k += 1;
        break;
        label378:
        if (j <= paramInt) {
          break label445;
        }
        j /= paramInt;
        break label320;
        label393:
        if (Build.VERSION.SDK_INT >= 17) {
          localArrayList1.add(a(((FrameExtractor.MediaWithType)paramList.get(i)).jdField_a_of_type_JavaLangString, ((Long)paramList1.get(k)).longValue(), paramInt));
        }
      }
      label445:
      j = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.FrameExtractor
 * JD-Core Version:    0.7.0.1
 */