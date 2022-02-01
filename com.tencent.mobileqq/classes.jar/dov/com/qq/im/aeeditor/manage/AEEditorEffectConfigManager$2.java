package dov.com.qq.im.aeeditor.manage;

import android.os.SystemClock;
import android.text.TextUtils;
import aqxe;
import bnrh;
import bnuo;
import bnup;
import bnuq;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;

public class AEEditorEffectConfigManager$2
  implements Runnable
{
  public AEEditorEffectConfigManager$2(bnuo parambnuo) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(bnuo.a())) {
      for (;;)
      {
        try
        {
          synchronized (bnuo.a())
          {
            if (new File(bnuo.a()).exists())
            {
              if (bnuo.a(this.this$0) != null)
              {
                bnuo.a(this.this$0).a(bnuo.a());
                return;
              }
              bnrh.d("AEEditorEffectConfigManager", "group list back is null.");
            }
          }
          if (bnuo.a(this.this$0) == null) {
            break label155;
          }
        }
        catch (Exception localException)
        {
          bnrh.d("AEEditorEffectConfigManager", localException.toString());
          return;
        }
        ((bnuq)aqxe.a().a(643)).a();
        ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(bnuo.a(this.this$0));
        ThreadManager.getSubThreadHandler().postAtTime(new AEEditorEffectConfigManager.2.1(this), bnuo.a(this.this$0), SystemClock.uptimeMillis() + 5000L);
        continue;
        label155:
        bnrh.d("AEEditorEffectConfigManager", "group list back is null && data empty.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorEffectConfigManager.2
 * JD-Core Version:    0.7.0.1
 */