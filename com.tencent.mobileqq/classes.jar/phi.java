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

public class phi
{
  private static long jdField_a_of_type_Long = 0L;
  private static ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private static phi jdField_a_of_type_Phi;
  private static ConcurrentHashMap b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_Phi = new phi();
  }
  
  public static phi a()
  {
    return jdField_a_of_type_Phi;
  }
  
  @Deprecated
  public static void a(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {}
    phh localphh;
    do
    {
      return;
      localphh = (phh)b.remove(paramImageKey);
    } while ((localphh == null) || (!(localphh instanceof CancelStreamDecodeGifTask)));
    Log.d("ImageTaskManager", "removeImageTask | imageKey:" + paramImageKey.hashCodeEx() + " url:" + paramImageKey.url);
    ((CancelStreamDecodeGifTask)localphh).removeRecord(paramImageKey.url);
  }
  
  public static void a(phh paramphh)
  {
    if ((paramphh == null) || (paramphh.getImageKey() == null)) {
      return;
    }
    Log.d("ImageTaskManager", "addImageTask | imageKey:" + paramphh.getImageKey() + " url:" + paramphh.getImageKey().url);
    b.put(paramphh.getImageKey(), paramphh);
  }
  
  public static void b(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {}
    phh localphh;
    do
    {
      return;
      localphh = (phh)b.get(paramImageKey);
    } while (localphh == null);
    Log.d("ImageTaskManager", "cancelImageTask | imageKey:" + paramImageKey.hashCodeEx() + " url:" + paramImageKey.url);
    localphh.cancel();
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
 * Qualified Name:     phi
 * JD-Core Version:    0.7.0.1
 */