import android.support.v4.util.MQLruCache;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager;
import com.tencent.mobileqq.app.AppConstants;
import java.io.File;

public class mzc
  extends Thread
{
  public mzc(PublicAccountImageCollectionPreloadManager paramPublicAccountImageCollectionPreloadManager) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.releaseLargeCache();
    }
    long l = System.currentTimeMillis();
    Object localObject1 = new File(AppConstants.ct);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (l - localObject2.lastModified() > 172800000L) {
          localObject2.delete();
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mzc
 * JD-Core Version:    0.7.0.1
 */