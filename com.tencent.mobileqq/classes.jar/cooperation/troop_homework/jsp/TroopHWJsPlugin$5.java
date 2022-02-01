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
          QQToast.makeText(MobileQQ.getContext(), 2131895218, 0).show();
          return;
        }
        QQToast.makeText(MobileQQ.getContext(), 2131895217, 0).show();
        return;
      }
      QQToast.makeText(MobileQQ.getContext(), 2131895231, 0).show();
      return;
    }
    QQToast.makeText(MobileQQ.getContext(), 2131895219, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */