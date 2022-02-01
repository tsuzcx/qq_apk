package cooperation.troop_homework.jsp;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.MobileQQ;

class TroopHWJsPlugin$5
  extends Handler
{
  TroopHWJsPlugin$5(TroopHWJsPlugin paramTroopHWJsPlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          QQToast.a(MobileQQ.getContext(), 2131697445, 0).a();
          return;
        }
        QQToast.a(MobileQQ.getContext(), 2131697444, 0).a();
        return;
      }
      QQToast.a(MobileQQ.getContext(), 2131697458, 0).a();
      return;
    }
    QQToast.a(MobileQQ.getContext(), 2131697446, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */