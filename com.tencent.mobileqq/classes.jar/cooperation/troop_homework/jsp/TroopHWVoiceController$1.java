package cooperation.troop_homework.jsp;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cooperation.troop_homework.TroopHomeworkHelper;

class TroopHWVoiceController$1
  implements Runnable
{
  TroopHWVoiceController$1(TroopHWVoiceController paramTroopHWVoiceController) {}
  
  public void run()
  {
    String str = TroopHomeworkHelper.a(TroopHWVoiceController.a(this.this$0));
    if (!TextUtils.isEmpty(str))
    {
      Message localMessage = TroopHWVoiceController.b(this.this$0).obtainMessage();
      localMessage.what = 0;
      localMessage.obj = str;
      localMessage.sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWVoiceController.1
 * JD-Core Version:    0.7.0.1
 */