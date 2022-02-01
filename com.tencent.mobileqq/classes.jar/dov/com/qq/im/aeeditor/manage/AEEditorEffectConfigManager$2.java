package dov.com.qq.im.aeeditor.manage;

import android.os.SystemClock;
import android.text.TextUtils;
import apub;
import bmbx;
import bmew;
import bmex;
import bmey;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;

public class AEEditorEffectConfigManager$2
  implements Runnable
{
  public AEEditorEffectConfigManager$2(bmew parambmew) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(bmew.a())) {
      for (;;)
      {
        try
        {
          synchronized (bmew.a())
          {
            if (new File(bmew.a()).exists())
            {
              if (bmew.a(this.this$0) != null)
              {
                bmew.a(this.this$0).a(bmew.a());
                return;
              }
              bmbx.d("AEEditorEffectConfigManager", "group list back is null.");
            }
          }
          if (bmew.a(this.this$0) == null) {
            break label155;
          }
        }
        catch (Exception localException)
        {
          bmbx.d("AEEditorEffectConfigManager", localException.toString());
          return;
        }
        ((bmey)apub.a().a(643)).a();
        ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(bmew.a(this.this$0));
        ThreadManager.getSubThreadHandler().postAtTime(new AEEditorEffectConfigManager.2.1(this), bmew.a(this.this$0), SystemClock.uptimeMillis() + 5000L);
        continue;
        label155:
        bmbx.d("AEEditorEffectConfigManager", "group list back is null && data empty.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorEffectConfigManager.2
 * JD-Core Version:    0.7.0.1
 */