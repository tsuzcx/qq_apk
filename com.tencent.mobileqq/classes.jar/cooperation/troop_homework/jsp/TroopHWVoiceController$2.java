package cooperation.troop_homework.jsp;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import java.lang.ref.WeakReference;

class TroopHWVoiceController$2
  extends Handler
{
  TroopHWVoiceController$2(TroopHWVoiceController paramTroopHWVoiceController) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if (TroopHWVoiceController.a(this.a) != null) {
            TroopHWVoiceController.a(this.a).a(1, TroopHWVoiceController.a(this.a));
          }
        } while (!(paramMessage.obj instanceof String));
        paramMessage = (String)paramMessage.obj;
        this.a.c(paramMessage);
        this.a.b(paramMessage);
        return;
        TroopHWVoiceController.a(this.a).c();
        AudioUtil.b(2131230744, false);
      } while (this.a.a == null);
      paramMessage = (Context)this.a.a.get();
    } while (paramMessage == null);
    QQAudioUtils.a(paramMessage, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWVoiceController.2
 * JD-Core Version:    0.7.0.1
 */