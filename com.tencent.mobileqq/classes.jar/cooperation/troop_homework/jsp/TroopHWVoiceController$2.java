package cooperation.troop_homework.jsp;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.ptt.IQQRecorder;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.utils.AudioUtil;
import java.lang.ref.WeakReference;

class TroopHWVoiceController$2
  extends Handler
{
  TroopHWVoiceController$2(TroopHWVoiceController paramTroopHWVoiceController) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        TroopHWVoiceController.d(this.a).c();
        AudioUtil.b(2131230816, false);
        if (this.a.f == null) {
          return;
        }
        paramMessage = (Context)this.a.f.get();
        if (paramMessage == null) {
          return;
        }
        QQAudioUtils.a(paramMessage, false);
      }
    }
    else
    {
      if (TroopHWVoiceController.c(this.a) != null) {
        TroopHWVoiceController.c(this.a).a(1, TroopHWVoiceController.a(this.a));
      }
      if ((paramMessage.obj instanceof String))
      {
        paramMessage = (String)paramMessage.obj;
        this.a.d(paramMessage);
        this.a.b(paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWVoiceController.2
 * JD-Core Version:    0.7.0.1
 */