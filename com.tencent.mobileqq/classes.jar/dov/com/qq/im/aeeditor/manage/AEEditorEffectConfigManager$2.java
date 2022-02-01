package dov.com.qq.im.aeeditor.manage;

import android.os.SystemClock;
import android.text.TextUtils;
import aqlk;
import bnzb;
import bobr;
import bobs;
import bobt;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;

public class AEEditorEffectConfigManager$2
  implements Runnable
{
  public AEEditorEffectConfigManager$2(bobr parambobr) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(bobr.a())) {
      for (;;)
      {
        try
        {
          synchronized (bobr.a())
          {
            if (new File(bobr.a()).exists())
            {
              if (bobr.a(this.this$0) != null)
              {
                bobr.a(this.this$0).a(bobr.a());
                return;
              }
              bnzb.d("AEEditorEffectConfigManager", "group list back is null.");
            }
          }
          if (bobr.a(this.this$0) == null) {
            break label155;
          }
        }
        catch (Exception localException)
        {
          bnzb.d("AEEditorEffectConfigManager", localException.toString());
          return;
        }
        ((bobt)aqlk.a().a(643)).a();
        ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(bobr.a(this.this$0));
        ThreadManager.getSubThreadHandler().postAtTime(new AEEditorEffectConfigManager.2.1(this), bobr.a(this.this$0), SystemClock.uptimeMillis() + 5000L);
        continue;
        label155:
        bnzb.d("AEEditorEffectConfigManager", "group list back is null && data empty.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorEffectConfigManager.2
 * JD-Core Version:    0.7.0.1
 */