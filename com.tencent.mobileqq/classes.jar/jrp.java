import android.os.Handler;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.text.TextUtils;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.BaseCallbackUI;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.av.utils.PSTNNotification;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class jrp
  extends PhoneStateListener
{
  public jrp(CallbackWaitingActivityExt paramCallbackWaitingActivityExt) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    int i = 0;
    super.onCallStateChanged(paramInt, paramString);
    if (QLog.isColorLevel())
    {
      QLog.d(CallbackWaitingActivityExt.a(), 2, "onCallStateChanged state = " + paramInt);
      QLog.d(CallbackWaitingActivityExt.a(), 2, "onCallStateChanged incomingNumber = " + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      CallbackWaitingActivityExt.g = paramString;
    }
    switch (paramInt)
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        do
        {
          return;
          if ((CallbackWaitingActivityExt.a(this.a) != null) && (CallbackWaitingActivityExt.a(this.a).a().e))
          {
            CallbackWaitingActivityExt.a(this.a).a().a().b = -1;
            CallbackWaitingActivityExt.a(this.a).a().e = false;
            CallbackWaitingActivityExt.a(this.a).a().f = false;
            if (this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo != null) {
              CallbackWaitingActivityExt.a(this.a).a().a(3, this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.a, 0);
            }
            PSTNNotification.a(CallbackWaitingActivityExt.a(this.a).getApplication().getApplicationContext()).d();
            if (this.a.jdField_a_of_type_AndroidContentIntent != null)
            {
              CallbackWaitingActivityExt.a(this.a).getApp().stopService(this.a.jdField_a_of_type_AndroidContentIntent);
              this.a.jdField_a_of_type_AndroidContentIntent = null;
            }
          }
        } while ((CallbackWaitingActivityExt.a(this.a) == null) || (CallbackWaitingActivityExt.a(this.a).a().a().b != -1));
        this.a.finish();
        return;
        paramInt = i;
        if (!TextUtils.isEmpty(CallbackWaitingActivityExt.f))
        {
          paramInt = i;
          if (!TextUtils.isEmpty(CallbackWaitingActivityExt.g))
          {
            paramInt = i;
            if (CallbackWaitingActivityExt.f.equals(CallbackWaitingActivityExt.g)) {
              paramInt = 1;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(CallbackWaitingActivityExt.a(), 2, "callBackphone:" + CallbackWaitingActivityExt.g + ", csNumber:" + CallbackWaitingActivityExt.f);
        }
        this.a.jdField_a_of_type_ComTencentAvUiBaseCallbackUI.a.removeCallbacksAndMessages(null);
        paramString = new Message();
        paramString.what = 2;
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramString, 1000L);
      } while (CallbackWaitingActivityExt.a(this.a) == null);
      if ((paramInt != 0) && (!CallbackWaitingActivityExt.a(this.a).a().f))
      {
        paramString = new Message();
        paramString.what = 1;
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramString, 1000L);
      }
      this.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 8000L);
      CallbackWaitingActivityExt.a(this.a).a().e = true;
      return;
    }
    if (CallbackWaitingActivityExt.a(this.a) != null) {
      CallbackWaitingActivityExt.a(this.a).a().e = true;
    }
    AudioUtil.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jrp
 * JD-Core Version:    0.7.0.1
 */