package dov.com.qq.im.aeeditor.manage;

import android.os.SystemClock;
import android.text.TextUtils;
import aran;
import bpam;
import bpdm;
import bpdn;
import bpdo;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;

public class AEEditorEffectConfigManager$2
  implements Runnable
{
  public AEEditorEffectConfigManager$2(bpdm parambpdm) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(bpdm.a())) {
      for (;;)
      {
        try
        {
          synchronized (bpdm.a())
          {
            if (new File(bpdm.a()).exists())
            {
              if (bpdm.a(this.this$0) != null)
              {
                bpdm.a(this.this$0).a(bpdm.a());
                return;
              }
              bpam.d("AEEditorEffectConfigManager", "group list back is null.");
            }
          }
          if (bpdm.a(this.this$0) == null) {
            break label155;
          }
        }
        catch (Exception localException)
        {
          bpam.d("AEEditorEffectConfigManager", localException.toString());
          return;
        }
        ((bpdo)aran.a().a(643)).a();
        ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(bpdm.a(this.this$0));
        ThreadManager.getSubThreadHandler().postAtTime(new AEEditorEffectConfigManager.2.1(this), bpdm.a(this.this$0), SystemClock.uptimeMillis() + 5000L);
        continue;
        label155:
        bpam.d("AEEditorEffectConfigManager", "group list back is null && data empty.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorEffectConfigManager.2
 * JD-Core Version:    0.7.0.1
 */