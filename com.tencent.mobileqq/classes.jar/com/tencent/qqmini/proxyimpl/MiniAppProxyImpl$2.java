package com.tencent.qqmini.proxyimpl;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.FavoritesActionBridge;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.RestartActionBridge;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.ShareActionBridge;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge.UpdateUIActionBridge;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.PageGestureProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.DebugUtil;

class MiniAppProxyImpl$2
  implements Handler.Callback
{
  MiniAppProxyImpl$2(MiniAppProxyImpl paramMiniAppProxyImpl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("MiniAppProxyImpl", 1, "handleMessage error, msg is null.");
      }
      return false;
    }
    if (MiniAppProxyImpl.a(this.a) == null)
    {
      QLog.e("MiniAppProxyImpl", 1, "handleMessage error, MiniAppContext is null.");
      return false;
    }
    int i = paramMessage.what;
    if (i != 1000) {}
    switch (i)
    {
    default: 
      return false;
    case 18: 
      MiniAppProxyImpl.a(this.a).performAction(ActionBridge.FavoritesActionBridge.obtain(1, null));
      return false;
    case 17: 
      paramMessage = this.a;
      MiniAppProxyImpl.c(paramMessage, MiniAppProxyImpl.a(paramMessage));
      return false;
    case 16: 
      paramMessage = this.a;
      MiniAppProxyImpl.b(paramMessage, MiniAppProxyImpl.a(paramMessage));
      return false;
    case 15: 
      MiniAppProxyImpl.a(this.a).performAction(ActionBridge.RestartActionBridge.obtain());
      return false;
    case 14: 
      paramMessage = MiniAppProxyImpl.a(this.a).getMiniAppInfo();
      if ((paramMessage != null) && (paramMessage.isEngineTypeMiniApp()))
      {
        paramMessage = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
        if ((paramMessage instanceof PageGestureProxyImpl))
        {
          paramMessage = (PageGestureProxyImpl)paramMessage;
          MiniAppProxyImpl.a(this.a, paramMessage.a());
          return false;
        }
      }
      else
      {
        if (!(MiniAppProxyImpl.a(this.a).getAttachedActivity() instanceof GameActivity1)) {
          return false;
        }
        paramMessage = ((GameActivity1)MiniAppProxyImpl.a(this.a).getAttachedActivity()).getColorNoteController();
        MiniAppProxyImpl.a(this.a, paramMessage);
        return false;
      }
      break;
    case 13: 
      MiniAppProxyImpl.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(5, paramMessage.getData()));
      return false;
    case 12: 
      paramMessage = this.a;
      MiniAppProxyImpl.a(paramMessage, MiniAppProxyImpl.a(paramMessage));
      return false;
    case 11: 
      paramMessage = MiniAppProxyImpl.a(this.a).getAttachedActivity();
      if ((paramMessage != null) && (MiniAppProxyImpl.a(this.a).getMiniAppInfo() != null))
      {
        try
        {
          ShortcutUtils.a(paramMessage, MiniAppProxyImpl.a(this.a).getMiniAppInfo());
        }
        catch (Exception paramMessage)
        {
          QLog.e("MiniAppProxyImpl", 1, "addShortcut error", paramMessage);
        }
        paramMessage = this.a;
        MiniAppProxyImpl.a(paramMessage, MiniAppProxyImpl.a(paramMessage), "add_desktop");
        return false;
      }
      break;
    case 9: 
      paramMessage = MiniAppProxyImpl.a(this.a).getMiniAppInfo();
      if (paramMessage == null) {
        return false;
      }
      if (paramMessage.topType == 0) {
        i = 1;
      } else {
        i = 0;
      }
      paramMessage.topType = i;
      MiniAppProxyImpl.a(this.a, paramMessage);
      MiniAppProxyImpl localMiniAppProxyImpl = this.a;
      IMiniAppContext localIMiniAppContext = MiniAppProxyImpl.a(localMiniAppProxyImpl);
      if (paramMessage.topType == 1) {
        paramMessage = "settop_on";
      } else {
        paramMessage = "settop_off";
      }
      MiniAppProxyImpl.a(localMiniAppProxyImpl, localIMiniAppContext, paramMessage);
      return false;
    case 8: 
      MiniAppProxyImpl.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(4, null));
      return false;
    case 7: 
      MiniAppProxyImpl.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(3, null));
      return false;
    case 6: 
      MiniAppProxyImpl.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(2, null));
      return false;
    case 5: 
      MiniAppProxyImpl.a(ActionBridge.UpdateUIActionBridge.toggleMonitorPanel(MiniAppProxyImpl.a(this.a)).booleanValue());
      return false;
    case 3: 
      paramMessage = MiniAppProxyImpl.a(this.a).getMiniAppInfo();
      if (paramMessage == null) {
        return false;
      }
      if (DebugUtil.getDebugEnabled(paramMessage)) {
        DebugUtil.setDebugEnabled(paramMessage, false);
      } else {
        DebugUtil.setDebugEnabled(paramMessage, true);
      }
      MiniAppProxyImpl.a(MiniAppProxyImpl.a(this.a));
      return false;
    case 2: 
      MiniAppProxyImpl.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(1, null));
      return false;
      this.a.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */