package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ForwardSDKB77AIOHelper$2
  extends BroadcastReceiver
{
  ForwardSDKB77AIOHelper$2(ForwardSDKB77AIOHelper paramForwardSDKB77AIOHelper, String paramString) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((ForwardSDKB77AIOHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77AIOHelper) == null) || (ForwardSDKB77AIOHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77AIOHelper).isFinishing()))
    {
      QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive null == mActivity || mActivity.isFinishing()");
      return;
    }
    ForwardSDKB77AIOHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77AIOHelper);
    ForwardSDKB77AIOHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77AIOHelper).removeMessages(93);
    ForwardSDKB77AIOHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77AIOHelper).removeMessages(94);
    paramContext = ((ForwardSdkStatusManager)ForwardSDKB77AIOHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77AIOHelper).a.getManager(QQManagerFactory.SDK_SHARE)).a(this.jdField_a_of_type_JavaLangString);
    if (paramContext == null)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive b77Result == null");
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onReceive parseB77Result");
    ForwardSDKB77AIOHelper.a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSDKB77AIOHelper, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper.2
 * JD-Core Version:    0.7.0.1
 */