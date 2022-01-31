package cooperation.troop_homework.jsp;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bkcy;
import bkdp;

public class TroopHWVoiceController$1
  implements Runnable
{
  public TroopHWVoiceController$1(bkdp parambkdp) {}
  
  public void run()
  {
    String str = bkcy.a(bkdp.a(this.this$0));
    if (!TextUtils.isEmpty(str))
    {
      Message localMessage = bkdp.a(this.this$0).obtainMessage();
      localMessage.what = 0;
      localMessage.obj = str;
      localMessage.sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWVoiceController.1
 * JD-Core Version:    0.7.0.1
 */