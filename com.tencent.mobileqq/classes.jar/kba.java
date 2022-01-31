import android.os.Handler;
import android.telephony.PhoneStateListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.PstnCallbackWaitingUi;
import com.tencent.qphone.base.util.QLog;

public class kba
  extends PhoneStateListener
{
  public kba(PstnCallbackWaitingUi paramPstnCallbackWaitingUi) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    super.onCallStateChanged(paramInt, paramString);
    if (QLog.isColorLevel())
    {
      QLog.d("PstnCallbackWaitingUi", 2, "onCallStateChanged state = " + paramInt);
      QLog.d("PstnCallbackWaitingUi", 2, "onCallStateChanged incomingNumber = " + paramString);
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
      } while ((this.a.jdField_a_of_type_ComTencentAvVideoController == null) || (this.a.jdField_a_of_type_ComTencentAvVideoController.a().x != 1) || (this.a.jdField_a_of_type_AndroidOsHandler == null) || (this.a.jdField_a_of_type_JavaLangRunnable == null) || (paramString == null) || (!paramString.equals("03162412023")));
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 1000L);
    } while (!QLog.isColorLevel());
    QLog.d("PstnCallbackWaitingUi", 2, "onCallStateChanged CALL_STATE_OFFHOOK");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kba
 * JD-Core Version:    0.7.0.1
 */