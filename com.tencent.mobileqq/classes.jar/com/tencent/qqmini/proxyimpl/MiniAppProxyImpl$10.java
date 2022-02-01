package com.tencent.qqmini.proxyimpl;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.UpdateUIActionBridge;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;

class MiniAppProxyImpl$10
  implements IActivityResultListener
{
  MiniAppProxyImpl$10(MiniAppProxyImpl paramMiniAppProxyImpl, IActivityResultManager paramIActivityResultManager) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 9527) {
      return false;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
    QLog.d("MiniAppProxyImpl", 1, "set isMiniMsgTabShow false");
    MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl, false);
    if (paramInt2 != -1)
    {
      QLog.w("MiniAppProxyImpl", 1, "onShareActivityResult, resultCode not Activity.RESULT_OK, but " + paramInt2);
      return true;
    }
    paramInt1 = paramIntent.getIntExtra("clickID", -1);
    String str = "";
    switch (paramInt1)
    {
    default: 
      paramIntent = str;
    }
    for (;;)
    {
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl, MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl), paramIntent);
      ActionBridge.UpdateUIActionBridge.updateRedDot(MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl));
      return true;
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(2);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(6);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(7);
      paramIntent = "share_WX";
      continue;
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(8);
      paramIntent = "share_Moments";
      continue;
      Message localMessage = new Message();
      localMessage.what = 13;
      localMessage.setData(paramIntent.getExtras());
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendMessage(localMessage);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(3);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(4);
      paramIntent = "about";
      continue;
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(5);
      paramIntent = str;
      continue;
      paramIntent = "cancel";
      continue;
      paramIntent = "cancel_system";
      continue;
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(9);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(11);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(10);
      paramIntent = "back_home";
      continue;
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(12);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(14);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(15);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(16);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(17);
      paramIntent = str;
      continue;
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(18);
      paramIntent = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.10
 * JD-Core Version:    0.7.0.1
 */