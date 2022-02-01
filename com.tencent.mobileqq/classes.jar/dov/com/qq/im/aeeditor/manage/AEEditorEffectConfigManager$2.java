package dov.com.qq.im.aeeditor.manage;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import dov.com.qq.im.ae.util.AEQLog;
import java.io.File;
import mqq.os.MqqHandler;

class AEEditorEffectConfigManager$2
  implements Runnable
{
  AEEditorEffectConfigManager$2(AEEditorEffectConfigManager paramAEEditorEffectConfigManager) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(AEEditorEffectConfigManager.a())) {
      for (;;)
      {
        try
        {
          synchronized (AEEditorEffectConfigManager.a())
          {
            if (new File(AEEditorEffectConfigManager.a()).exists())
            {
              if (AEEditorEffectConfigManager.a(this.this$0) != null)
              {
                AEEditorEffectConfigManager.a(this.this$0).a(AEEditorEffectConfigManager.a());
                return;
              }
              AEQLog.d("AEEditorEffectConfigManager", "group list back is null.");
            }
          }
          if (AEEditorEffectConfigManager.a(this.this$0) == null) {
            break label155;
          }
        }
        catch (Exception localException)
        {
          AEQLog.d("AEEditorEffectConfigManager", localException.toString());
          return;
        }
        ((AEEditorEffectConfigProcessor)QConfigManager.a().a(643)).a();
        ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(AEEditorEffectConfigManager.a(this.this$0));
        ThreadManager.getSubThreadHandler().postAtTime(new AEEditorEffectConfigManager.2.1(this), AEEditorEffectConfigManager.a(this.this$0), SystemClock.uptimeMillis() + 5000L);
        continue;
        label155:
        AEQLog.d("AEEditorEffectConfigManager", "group list back is null && data empty.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.manage.AEEditorEffectConfigManager.2
 * JD-Core Version:    0.7.0.1
 */