package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.RspBody;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.BatchSendRsp;

final class ForwardPluginShareWebViewHelper$1
  extends ProtoUtils.TroopProtocolObserver
{
  ForwardPluginShareWebViewHelper$1(QQProgressDialog paramQQProgressDialog, Activity paramActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    int i;
    if (paramInt == 0)
    {
      paramArrayOfByte = ForwardUtils.a(paramArrayOfByte);
      if ((paramArrayOfByte == null) || (paramArrayOfByte.size() <= 0)) {
        break label219;
      }
      paramArrayOfByte = (oidb_cmd0xdc2.BatchSendRsp)paramArrayOfByte.get(0);
      if (paramArrayOfByte.err_code.get() == 0)
      {
        paramArrayOfByte = "";
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_JavaLangString);
        paramBundle = BaseApplicationImpl.getContext().getString(2131692688);
      }
      for (;;)
      {
        ThreadManager.getUIHandler().postDelayed(new ForwardPluginShareWebViewHelper.1.1(this, paramBundle), 300L);
        this.jdField_a_of_type_AndroidAppActivity.finish();
        QLog.d("ForwardPluginShareWebViewHelper", 1, new Object[] { "webview send oidb_cmd0xdc2 errorCode=", Integer.valueOf(paramInt), ",errorMsg = ", paramArrayOfByte });
        return;
        paramArrayOfByte = paramArrayOfByte.rsp_body.wording.get();
        i = 0;
        break;
        paramArrayOfByte = "sso error";
        i = 0;
        break;
        paramBundle = BaseApplicationImpl.getContext().getString(2131719291) + ":" + paramArrayOfByte;
        QQToast.a(BaseApplicationImpl.getContext(), paramBundle, 0).a();
      }
      label219:
      paramArrayOfByte = "";
      i = 0;
    }
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    QQToast.a(BaseApplicationImpl.getContext(), 2131719291, 0).a();
    this.jdField_a_of_type_AndroidAppActivity.finish();
    QLog.e("ForwardPluginShareWebViewHelper", 1, new Object[] { "onError msg =", paramString });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareWebViewHelper.1
 * JD-Core Version:    0.7.0.1
 */