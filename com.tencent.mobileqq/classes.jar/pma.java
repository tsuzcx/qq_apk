import android.util.Log;
import com.tencent.component.media.IDownloader;
import com.tencent.component.media.image.CancelStreamDecodeGifTask;
import com.tencent.component.media.image.DecodeImageTask;
import com.tencent.component.media.image.DownloadImageTask;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageTaskTracer;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class pma
{
  private static long jdField_a_of_type_Long = 0L;
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static pma jdField_a_of_type_Pma;
  private static ConcurrentHashMap b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_Pma = new pma();
  }
  
  public static pma a()
  {
    return jdField_a_of_type_Pma;
  }
  
  @Deprecated
  public static void a(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {}
    plz localplz;
    do
    {
      return;
      localplz = (plz)b.remove(paramImageKey);
    } while ((localplz == null) || (!(localplz instanceof CancelStreamDecodeGifTask)));
    Log.d("ImageTaskManager", "removeImageTask | imageKey:" + paramImageKey.hashCodeEx() + " url:" + paramImageKey.url);
    ((CancelStreamDecodeGifTask)localplz).removeRecord(paramImageKey.url);
  }
  
  public static void a(plz paramplz)
  {
    if ((paramplz == null) || (paramplz.getImageKey() == null)) {
      return;
    }
    Log.d("ImageTaskManager", "addImageTask | imageKey:" + paramplz.getImageKey() + " url:" + paramplz.getImageKey().url);
    b.put(paramplz.getImageKey(), paramplz);
  }
  
  public static void b(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {}
    plz localplz;
    do
    {
      return;
      localplz = (plz)b.get(paramImageKey);
    } while (localplz == null);
    Log.d("ImageTaskManager", "cancelImageTask | imageKey:" + paramImageKey.hashCodeEx() + " url:" + paramImageKey.url);
    localplz.cancel();
  }
  
  public void a()
  {
    synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      Object localObject1 = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet();
      if (localObject1 != null)
      {
        localObject1 = ((Set)localObject1).iterator();
        if (localObject1 != null) {
          while (((Iterator)localObject1).hasNext())
          {
            int i = ((Integer)((Iterator)localObject1).next()).intValue();
            DecodeImageTask localDecodeImageTask = (DecodeImageTask)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
            if (localDecodeImageTask != null) {
              localDecodeImageTask.startDecodeTask();
            }
          }
        }
      }
    }
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(DecodeImageTask paramDecodeImageTask)
  {
    synchronized (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramDecodeImageTask.getImageKey().hashCodeEx()), paramDecodeImageTask);
      return;
    }
  }
  
  public void a(String paramString)
  {
    DownloadImageTask.getDownloader().cancel(paramString);
  }
  
  public boolean a(int paramInt)
  {
    if ((ImageTaskTracer.OPEN_GET_IMAGE_SUCCESS_RECORDER) && (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      return jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pma
 * JD-Core Version:    0.7.0.1
 */