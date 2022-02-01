package cooperation.troop_homework.jsp;

import android.os.Handler;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

class TroopHWJsPlugin$5
  extends Handler
{
  TroopHWJsPlugin$5(TroopHWJsPlugin paramTroopHWJsPlugin) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return;
    case 0: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131697427, 0).a();
      return;
    case 1: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131697445, 0).a();
      return;
    case 3: 
      QQToast.a(BaseApplicationImpl.getContext(), 2131697425, 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2131697426, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */