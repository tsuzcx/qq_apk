import android.content.Intent;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.CallbackWaitingActivity;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.av.utils.PSTNNotification;
import com.tencent.av.utils.PstnUtils;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcall.PstnHandler.CallTypeRspParam;
import com.tencent.mobileqq.qcall.PstnObserver;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class jzd
  extends PstnObserver
{
  public jzd(PSTNC2CActivity paramPSTNC2CActivity) {}
  
  public void a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int = -1;
    }
    this.a.finish();
  }
  
  public void a(Boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d("PSTNC2CActivity", 2, "isSuccess = " + paramBoolean);
    }
    Object localObject;
    if ((paramObject instanceof PstnHandler.CallTypeRspParam))
    {
      localObject = (PstnHandler.CallTypeRspParam)paramObject;
      VideoMsgTools.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), true, ((PstnHandler.CallTypeRspParam)localObject).jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      if (paramBoolean.booleanValue())
      {
        if (localObject != null)
        {
          QLog.d("PSTNC2CActivity", 2, " retCode = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_a_of_type_Int + " callType = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_b_of_type_Int + " callbackPhone = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_c_of_type_JavaLangString + " callbackPrompt = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_b_of_type_JavaLangString + " toPhone = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_d_of_type_JavaLangString + " callbackId = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_a_of_type_JavaLangString + " peerCallId = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_a_of_type_Long + " ability = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_c_of_type_Int + " phoneNumType = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_d_of_type_Int);
          if (((PstnHandler.CallTypeRspParam)localObject).jdField_b_of_type_Int == 5)
          {
            PSTNC2CActivity.jdField_c_of_type_JavaLangString = ((PstnHandler.CallTypeRspParam)localObject).jdField_c_of_type_JavaLangString;
            paramBoolean = new Intent(this.a, CallbackWaitingActivity.class);
            paramBoolean.putExtra("callbackId", ((PstnHandler.CallTypeRspParam)localObject).jdField_a_of_type_JavaLangString);
            paramBoolean.putExtra("toPhone", this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString);
            paramBoolean.putExtra("fromPhone", this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_c_of_type_JavaLangString);
            paramBoolean.putExtra("toUin", this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString);
            paramBoolean.putExtra("fromUin", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
            paramBoolean.putExtra("uinType", this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int);
            paramBoolean.putExtra("type", 1001);
            this.a.startActivity(paramBoolean);
          }
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().e = ((PstnHandler.CallTypeRspParam)localObject).jdField_c_of_type_JavaLangString;
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int = 1;
          this.a.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new jze(this), 500L);
        }
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int = -1;
      paramBoolean = "呼叫失败，请稍后再试。";
      int i;
      if ((paramObject != null) && ((paramObject instanceof Integer))) {
        switch (((Integer)paramObject).intValue())
        {
        case 2: 
        case 4: 
        case 5: 
        case 9: 
        case 10: 
        default: 
          paramBoolean = "呼叫失败，请稍后再试。";
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 2)
        {
          paramBoolean = PstnUtils.b(this.a.app, 1);
          paramObject = PstnUtils.c(this.a.app, 1);
          localObject = PstnUtils.d(this.a.app, 1);
          DialogUtil.a(this.a, 230, paramBoolean, paramObject, this.a.getString(2131428669), (String)localObject, new jzf(this), new jzg(this)).show();
          return;
          paramBoolean = "你拨打的号码有误，请加拨区号后再试。";
          i = 1;
          continue;
          i = 2;
          continue;
          paramBoolean = "呼叫失败，暂不支持呼叫此类号码。";
          i = 1;
          continue;
          paramBoolean = "你拨打的号码有误，请检查后再试。";
          i = 1;
          continue;
          paramBoolean = "呼叫失败，暂不支持呼叫国外号码。";
          i = 1;
          continue;
          paramBoolean = "呼叫失败，最多支持同时接入9个手机//固话用户。";
          i = 1;
        }
        else
        {
          DialogUtil.b(this.a, 230, "", paramBoolean, 2131428668, 2131428668, null, new jzh(this)).show();
          return;
          i = 1;
        }
      }
      localObject = null;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("PSTNC2CActivity", 2, " callId = " + paramString + ", time = " + paramInt);
    }
    this.a.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    this.a.jdField_c_of_type_AndroidWidgetTextView.setText(this.a.getResources().getString(2131429556));
    this.a.jdField_a_of_type_ComTencentAvUtilsPSTNNotification.a(1);
    this.a.a(this.a.b, false, 2130840119);
    this.a.b.setClickable(true);
    this.a.a(this.a.jdField_a_of_type_AndroidWidgetButton, false, 2130840130);
    this.a.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().jdField_b_of_type_Int = 2;
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().g = true;
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e(true);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jzd
 * JD-Core Version:    0.7.0.1
 */