package mqq.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.qphone.base.util.QLog;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;

public class NativeUtil
{
  private static boolean sLoadSO;
  
  static
  {
    try
    {
      System.loadLibrary("mqq");
      sLoadSO = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.e("mqq", 2, "load mqq.so error!" + localThrowable.toString());
    }
  }
  
  private static native byte[] getFrameBuffer();
  
  private static native int getHeight();
  
  private static native int getWidth();
  
  public static Bitmap screenshot(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (sLoadSO) {}
    try
    {
      localObject1 = getFrameBuffer();
      paramContext = (Context)localObject1;
      if (localObject1 == null)
      {
        paramContext = Runtime.getRuntime().exec("su");
        localObject1 = new DataOutputStream(paramContext.getOutputStream());
        ((DataOutputStream)localObject1).writeBytes("chmod 666 /dev/graphics/fb0\n");
        ((DataOutputStream)localObject1).writeBytes("exit\n");
        ((DataOutputStream)localObject1).flush();
        new Thread()
        {
          public void run()
          {
            try
            {
              this.val$process.waitFor();
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }.start();
        paramContext = getFrameBuffer();
      }
      localObject1 = localObject2;
      if (paramContext != null)
      {
        int i = getWidth();
        int j = getHeight();
        paramContext = ByteBuffer.wrap(paramContext);
        localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        ((Bitmap)localObject1).copyPixelsFromBuffer(paramContext);
      }
      return localObject1;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     mqq.util.NativeUtil
 * JD-Core Version:    0.7.0.1
 */