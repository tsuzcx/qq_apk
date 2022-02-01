package cooperation.troop_homework.jsp;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import bnsn;
import bnte;

public class TroopHWVoiceController$1
  implements Runnable
{
  public TroopHWVoiceController$1(bnte parambnte) {}
  
  public void run()
  {
    String str = bnsn.a(bnte.a(this.this$0));
    if (!TextUtils.isEmpty(str))
    {
      Message localMessage = bnte.a(this.this$0).obtainMessage();
      localMessage.what = 0;
      localMessage.obj = str;
      localMessage.sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWVoiceController.1
 * JD-Core Version:    0.7.0.1
 */