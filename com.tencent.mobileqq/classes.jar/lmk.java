import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInjoyWebRenderSoLoader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.earlydownload.handler.ViolaLibHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public final class lmk
  implements Runnable
{
  public lmk(String paramString) {}
  
  public void run()
  {
    localStringBuilder = new StringBuilder("native_render loadLibrary from: ").append(this.a);
    l1 = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        if (ViolaLibHandler.c()) {
          continue;
        }
        localStringBuilder.append("viola lib not exist");
        localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("readinjoy_web_render_sp", 0);
        long l2 = localSharedPreferences.getLong("js_lib", 0L);
        if (l2 <= 0L) {
          continue;
        }
        if (System.currentTimeMillis() - l2 > 120000L)
        {
          ViolaLibHandler.a();
          localSharedPreferences.edit().putLong("js_lib", System.currentTimeMillis()).commit();
        }
        ReadInJoyWebRenderEngine.a(1);
      }
      catch (Throwable localThrowable)
      {
        SharedPreferences localSharedPreferences;
        ReadInJoyWebRenderEngine.a(false);
        localStringBuilder.append(localThrowable.getMessage());
        return;
        String str1 = ReadInjoyWebRenderSoLoader.a();
        String[] arrayOfString = ViolaLibHandler.a;
        int j = arrayOfString.length;
        int i = 0;
        if (i >= j) {
          continue;
        }
        String str2 = arrayOfString[i];
        File localFile = new File(str1, str2);
        if (!localFile.exists()) {
          continue;
        }
        System.load(localFile.getAbsolutePath());
        i += 1;
        continue;
        localStringBuilder.append(str2).append(" not exist");
        ReadInJoyWebRenderEngine.a(1);
        ReadInJoyWebRenderEngine.a(true);
        continue;
      }
      finally
      {
        ReadInJoyWebRenderEngine.a().set(false);
        localStringBuilder.append(", isLoaded: ").append(ReadInJoyWebRenderEngine.b()).append(", cost: ").append(System.currentTimeMillis() - l1);
        QLog.i("viola.ReadInJoyWebRenderEngine", 1, localStringBuilder.toString());
      }
      ReadInJoyWebRenderEngine.a().set(false);
      localStringBuilder.append(", isLoaded: ").append(ReadInJoyWebRenderEngine.b()).append(", cost: ").append(System.currentTimeMillis() - l1);
      QLog.i("viola.ReadInJoyWebRenderEngine", 1, localStringBuilder.toString());
      return;
      localSharedPreferences.edit().putLong("js_lib", System.currentTimeMillis()).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lmk
 * JD-Core Version:    0.7.0.1
 */