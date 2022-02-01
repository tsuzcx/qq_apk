package cooperation.qqfav.forward;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xd68.oidb_cmd0xd68.RspBody;

class QfavFileForwardManager$1
  extends Handler
{
  QfavFileForwardManager$1(QfavFileForwardManager paramQfavFileForwardManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    boolean bool;
    if (paramMessage.arg1 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("receive passwdredbags from group or disgroup, isSuccess = ");
      localStringBuilder.append(bool);
      QLog.d("QfavFileForwardManager", 2, localStringBuilder.toString());
    }
    if (!bool) {
      return;
    }
    paramMessage = (oidb_cmd0xd68.RspBody)paramMessage.obj;
    if ((i != 1) && (i != 2) && (i != 3)) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqfav.forward.QfavFileForwardManager.1
 * JD-Core Version:    0.7.0.1
 */