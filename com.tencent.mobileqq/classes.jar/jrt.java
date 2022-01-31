import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.av.app.PstnSessionInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.BaseCallbackUI;
import com.tencent.av.ui.CallbackWaitingActivityExt;
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

public class jrt
  extends PstnObserver
{
  public jrt(CallbackWaitingActivityExt paramCallbackWaitingActivityExt) {}
  
  public void a()
  {
    if (CallbackWaitingActivityExt.a(this.a) != null) {
      CallbackWaitingActivityExt.a(this.a).a().a().jdField_b_of_type_Int = -1;
    }
    this.a.finish();
  }
  
  public void a(Boolean paramBoolean, Object paramObject)
  {
    super.a(paramBoolean, paramObject);
    if (QLog.isColorLevel()) {
      QLog.d(CallbackWaitingActivityExt.a(), 2, "isSuccess = " + paramBoolean);
    }
    PstnHandler.CallTypeRspParam localCallTypeRspParam;
    if ((paramObject instanceof PstnHandler.CallTypeRspParam))
    {
      localCallTypeRspParam = (PstnHandler.CallTypeRspParam)paramObject;
      localObject = localCallTypeRspParam;
      if (this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo != null)
      {
        localObject = localCallTypeRspParam;
        if (CallbackWaitingActivityExt.a(this.a) != null) {
          VideoMsgTools.a(CallbackWaitingActivityExt.a(this.a), this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString, CallbackWaitingActivityExt.a(this.a).getAccount(), true, localCallTypeRspParam.jdField_a_of_type_JavaLangString);
        }
      }
    }
    for (Object localObject = localCallTypeRspParam;; localObject = null)
    {
      if (paramBoolean.booleanValue())
      {
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(CallbackWaitingActivityExt.a(), 2, " retCode = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_a_of_type_Int + " callType = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_b_of_type_Int + " callbackPhone = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_c_of_type_JavaLangString + " callbackPrompt = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_b_of_type_JavaLangString + " toPhone = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_d_of_type_JavaLangString + " callbackId = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_a_of_type_JavaLangString + " peerCallId = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_a_of_type_Long + " ability = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_c_of_type_Int + " phoneNumType = " + ((PstnHandler.CallTypeRspParam)localObject).jdField_d_of_type_Int);
          }
          if ((((PstnHandler.CallTypeRspParam)localObject).jdField_b_of_type_Int == 5) && (this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo != null) && (CallbackWaitingActivityExt.a(this.a) != null))
          {
            CallbackWaitingActivityExt.f = ((PstnHandler.CallTypeRspParam)localObject).jdField_c_of_type_JavaLangString;
            paramBoolean = new Intent();
            paramBoolean.putExtra("callbackId", ((PstnHandler.CallTypeRspParam)localObject).jdField_a_of_type_JavaLangString);
            paramBoolean.putExtra("toPhone", this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_b_of_type_JavaLangString);
            paramBoolean.putExtra("fromPhone", this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_c_of_type_JavaLangString);
            paramBoolean.putExtra("toUin", this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_JavaLangString);
            paramBoolean.putExtra("fromUin", CallbackWaitingActivityExt.a(this.a).getAccount());
            paramBoolean.putExtra("uinType", this.a.jdField_a_of_type_ComTencentAvAppPstnSessionInfo.jdField_a_of_type_Int);
            paramBoolean.putExtra("type", 1001);
            CallbackWaitingActivityExt.a(this.a, paramBoolean);
            this.a.jdField_a_of_type_ComTencentAvUiBaseCallbackUI.a.postDelayed(new jru(this), 30000L);
          }
          if ((CallbackWaitingActivityExt.a(this.a) != null) && (CallbackWaitingActivityExt.a(this.a).a().a() != null)) {
            CallbackWaitingActivityExt.a(this.a).a().a().jdField_b_of_type_Int = 1;
          }
        }
        return;
      }
      CallbackWaitingActivityExt.a(this.a).a().a().jdField_b_of_type_Int = -1;
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
          DialogUtil.a(this.a, 230, paramBoolean, paramObject, this.a.getString(2131428669), (String)localObject, new jrw(this), new jrx(this)).show();
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
          DialogUtil.b(this.a, 230, "", paramBoolean, 2131428668, 2131428668, null, new jry(this)).show();
          return;
          i = 1;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d(CallbackWaitingActivityExt.a(), 2, " callId = " + paramString + ", time = " + paramInt);
    }
    this.a.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    if (this.a.c != null) {
      this.a.c.setText(this.a.getResources().getString(2131429556));
    }
    if (this.a.jdField_a_of_type_ComTencentAvUtilsPSTNNotification != null) {
      this.a.jdField_a_of_type_ComTencentAvUtilsPSTNNotification.a(1);
    }
    if ((this.a.b != null) && (this.a.jdField_a_of_type_AndroidWidgetButton != null))
    {
      this.a.a(this.a.b, false, 2130840119);
      this.a.b.setClickable(true);
      this.a.a(this.a.jdField_a_of_type_AndroidWidgetButton, false, 2130840130);
      this.a.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
    }
    if (CallbackWaitingActivityExt.a(this.a) != null)
    {
      CallbackWaitingActivityExt.a(this.a).a().a().jdField_b_of_type_Int = 2;
      CallbackWaitingActivityExt.a(this.a).a().g = true;
      CallbackWaitingActivityExt.a(this.a).a().e(true);
      CallbackWaitingActivityExt.a(this.a).a().c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jrt
 * JD-Core Version:    0.7.0.1
 */