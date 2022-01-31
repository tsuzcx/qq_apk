import android.os.StatFs;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageManager;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class pgo
  implements Runnable
{
  public void run()
  {
    synchronized ()
    {
      ImageManager.a().clear();
      ImageManager.a("");
      ImageManager.a(0L);
      ImageManager.a("/etc/vold.fstab");
      ImageManager.a("/etc/internal_sd.fstab");
      ImageManager.a("/etc/external_sd.fstab");
      Iterator localIterator = ImageManager.a().values().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            Object localObject2 = new File(str);
            if ((((File)localObject2).exists()) && (((File)localObject2).canWrite()) && (ImageManager.a(str)))
            {
              localObject2 = new StatFs(str);
              long l = ((StatFs)localObject2).getAvailableBlocks() * ((StatFs)localObject2).getBlockSize();
              if ((l > 0L) && (ImageManager.a() < l))
              {
                ImageManager.a(l);
                ImageManager.a(str);
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
      }
    }
    ImageManager.b(null);
    ImageManager.getCachePath(ImageManagerEnv.getAppContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     pgo
 * JD-Core Version:    0.7.0.1
 */