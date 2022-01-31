import android.os.Message;
import android.telephony.PhoneStateListener;
import android.text.TextUtils;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class kax
  extends PhoneStateListener
{
  public kax(PSTNC2CActivity paramPSTNC2CActivity) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    int i = 0;
    super.onCallStateChanged(paramInt, paramString);
    if (QLog.isColorLevel())
    {
      QLog.d("PSTNC2CActivity", 2, "onCallStateChanged state = " + paramInt);
      QLog.d("PSTNC2CActivity", 2, "onCallStateChanged incomingNumber = " + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      PSTNC2CActivity.b = paramString;
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e));
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().b = -1;
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e = false;
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f = false;
        if (this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(4, this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.a, 0);
        }
        this.a.finish();
        return;
        paramInt = i;
        if (!TextUtils.isEmpty(PSTNC2CActivity.c))
        {
          paramInt = i;
          if (!TextUtils.isEmpty(PSTNC2CActivity.b))
          {
            paramInt = i;
            if (PSTNC2CActivity.c.equals(PSTNC2CActivity.b)) {
              paramInt = 1;
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PSTNC2CActivity", 2, "callBackphone:" + PSTNC2CActivity.b + ", csNumber:" + PSTNC2CActivity.c);
        }
      } while (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      if ((paramInt != 0) && (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().f))
      {
        paramString = new Message();
        paramString.what = 1;
        this.a.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramString, 1000L);
      }
      this.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 8000L);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e = true;
      return;
    } while (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kax
 * JD-Core Version:    0.7.0.1
 */