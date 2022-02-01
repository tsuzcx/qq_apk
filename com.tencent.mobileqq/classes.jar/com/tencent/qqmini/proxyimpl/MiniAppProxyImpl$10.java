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
      paramIntent = new StringBuilder();
      paramIntent.append("onShareActivityResult, resultCode not Activity.RESULT_OK, but ");
      paramIntent.append(paramInt2);
      QLog.w("MiniAppProxyImpl", 1, paramIntent.toString());
      return true;
    }
    switch (paramIntent.getIntExtra("clickID", -1))
    {
    default: 
      break;
    case 17: 
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(18);
      break;
    case 16: 
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(17);
      break;
    case 15: 
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(16);
      break;
    case 14: 
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(15);
      break;
    case 13: 
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(14);
      break;
    case 12: 
      localObject = new Message();
      ((Message)localObject).what = 13;
      ((Message)localObject).setData(paramIntent.getExtras());
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendMessage((Message)localObject);
      break;
    case 11: 
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(12);
      break;
    case 10: 
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(11);
      break;
    case 9: 
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(10);
      paramIntent = "back_home";
      break;
    case 8: 
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(9);
      break;
    case 7: 
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(8);
      paramIntent = "share_Moments";
      break;
    case 6: 
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(7);
      paramIntent = "share_WX";
      break;
    case 5: 
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(6);
      break;
    case 4: 
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(4);
      paramIntent = "about";
      break;
    case 3: 
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(5);
      break;
    case 2: 
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(3);
      break;
    case 1: 
      MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl).sendEmptyMessage(2);
      break;
    case 0: 
      paramIntent = "cancel_system";
      break;
    case -1: 
      paramIntent = "cancel";
      break;
    }
    paramIntent = "";
    Object localObject = this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl;
    MiniAppProxyImpl.a((MiniAppProxyImpl)localObject, MiniAppProxyImpl.a((MiniAppProxyImpl)localObject), paramIntent);
    ActionBridge.UpdateUIActionBridge.updateRedDot(MiniAppProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplMiniAppProxyImpl));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.10
 * JD-Core Version:    0.7.0.1
 */