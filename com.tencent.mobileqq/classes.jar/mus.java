import android.support.v4.util.MQLruCache;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.mobileqq.app.AppConstants;
import java.io.File;

public class mus
  extends Thread
{
  public mus(PreloadManager paramPreloadManager) {}
  
  public void run()
  {
    int j = 0;
    if (PreloadManager.a(this.a) != null) {
      PreloadManager.a(this.a).releaseLargeCache();
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new File(AppConstants.cn);
    int k;
    int i;
    Object localObject2;
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      k = localObject1.length;
      i = 0;
      while (i < k)
      {
        localObject2 = localObject1[i];
        if (l - localObject2.lastModified() > 172800000L) {
          localObject2.delete();
        }
        i += 1;
      }
    }
    localObject1 = new File(AppConstants.co);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      k = localObject1.length;
      i = j;
      while (i < k)
      {
        localObject2 = localObject1[i];
        if (l - localObject2.lastModified() > 172800000L) {
          localObject2.delete();
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mus
 * JD-Core Version:    0.7.0.1
 */