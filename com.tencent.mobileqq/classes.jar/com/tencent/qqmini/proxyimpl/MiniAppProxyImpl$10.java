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
    this.a.removeActivityResultListener(this);
    QLog.d("MiniAppProxyImpl", 1, "set isMiniMsgTabShow false");
    MiniAppProxyImpl.a(this.b, false);
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
      MiniAppProxyImpl.b(this.b).sendEmptyMessage(18);
      break;
    case 16: 
      MiniAppProxyImpl.b(this.b).sendEmptyMessage(17);
      break;
    case 15: 
      MiniAppProxyImpl.b(this.b).sendEmptyMessage(16);
      break;
    case 14: 
      MiniAppProxyImpl.b(this.b).sendEmptyMessage(15);
      break;
    case 13: 
      MiniAppProxyImpl.b(this.b).sendEmptyMessage(14);
      break;
    case 12: 
      localObject = new Message();
      ((Message)localObject).what = 13;
      ((Message)localObject).setData(paramIntent.getExtras());
      MiniAppProxyImpl.b(this.b).sendMessage((Message)localObject);
      break;
    case 11: 
      MiniAppProxyImpl.b(this.b).sendEmptyMessage(12);
      break;
    case 10: 
      MiniAppProxyImpl.b(this.b).sendEmptyMessage(11);
      break;
    case 9: 
      MiniAppProxyImpl.b(this.b).sendEmptyMessage(10);
      paramIntent = "back_home";
      break;
    case 8: 
      MiniAppProxyImpl.b(this.b).sendEmptyMessage(9);
      break;
    case 7: 
      MiniAppProxyImpl.b(this.b).sendEmptyMessage(8);
      paramIntent = "share_Moments";
      break;
    case 6: 
      MiniAppProxyImpl.b(this.b).sendEmptyMessage(7);
      paramIntent = "share_WX";
      break;
    case 5: 
      MiniAppProxyImpl.b(this.b).sendEmptyMessage(6);
      break;
    case 4: 
      MiniAppProxyImpl.b(this.b).sendEmptyMessage(4);
      paramIntent = "about";
      break;
    case 3: 
      MiniAppProxyImpl.b(this.b).sendEmptyMessage(5);
      break;
    case 2: 
      MiniAppProxyImpl.b(this.b).sendEmptyMessage(3);
      break;
    case 1: 
      MiniAppProxyImpl.b(this.b).sendEmptyMessage(2);
      break;
    case 0: 
      paramIntent = "cancel_system";
      break;
    case -1: 
      paramIntent = "cancel";
      break;
    }
    paramIntent = "";
    Object localObject = this.b;
    MiniAppProxyImpl.a((MiniAppProxyImpl)localObject, MiniAppProxyImpl.a((MiniAppProxyImpl)localObject), paramIntent);
    ActionBridge.UpdateUIActionBridge.updateRedDot(MiniAppProxyImpl.a(this.b));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.10
 * JD-Core Version:    0.7.0.1
 */