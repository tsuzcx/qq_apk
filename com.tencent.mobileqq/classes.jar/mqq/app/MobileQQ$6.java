package mqq.app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

class MobileQQ$6
  implements Runnable
{
  MobileQQ$6(MobileQQ paramMobileQQ) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localFileOutputStream = this.this$0.openFileOutput("Properties", 0);
        localObject1 = localFileOutputStream;
        localObject3 = localFileOutputStream;
        MobileQQ.access$900(this.this$0).store(localFileOutputStream, null);
        localObject1 = localFileOutputStream;
        localObject3 = localFileOutputStream;
        localFileOutputStream.flush();
      }
      catch (Exception localException)
      {
        FileOutputStream localFileOutputStream;
        localObject3 = localIOException1;
        localException.printStackTrace();
        if (localIOException1 == null) {
          continue;
        }
        try
        {
          localIOException1.close();
          return;
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
          return;
        }
      }
      finally
      {
        if (localObject3 == null) {
          break label85;
        }
      }
      try
      {
        localFileOutputStream.close();
        return;
      }
      catch (IOException localIOException1)
      {
        localIOException1.printStackTrace();
        return;
      }
    }
    try
    {
      localObject3.close();
      label85:
      throw localObject2;
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        localIOException3.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.app.MobileQQ.6
 * JD-Core Version:    0.7.0.1
 */