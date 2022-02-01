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
    if (paramMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.e("MiniAppProxyImpl", 1, "handleMessage error, msg is null.");
      }
    }
    label480:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if (MiniAppProxyImpl.a(this.a) == null)
              {
                QLog.e("MiniAppProxyImpl", 1, "handleMessage error, MiniAppContext is null.");
                return false;
              }
              switch (paramMessage.what)
              {
              case 4: 
              case 10: 
              default: 
                return false;
              case 2: 
                MiniAppProxyImpl.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(1, null));
                return false;
              case 1000: 
                this.a.a();
                return false;
              case 6: 
                MiniAppProxyImpl.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(2, null));
                return false;
              case 7: 
                MiniAppProxyImpl.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(3, null));
                return false;
              case 8: 
                MiniAppProxyImpl.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(4, null));
                return false;
              case 13: 
                MiniAppProxyImpl.a(this.a).performAction(ActionBridge.ShareActionBridge.obtain(5, paramMessage.getData()));
                return false;
              case 18: 
                MiniAppProxyImpl.a(this.a).performAction(ActionBridge.FavoritesActionBridge.obtain(1, null));
                return false;
              case 3: 
                paramMessage = MiniAppProxyImpl.a(this.a).getMiniAppInfo();
              }
            } while (paramMessage == null);
            if (DebugUtil.getDebugEnabled(paramMessage)) {
              DebugUtil.setDebugEnabled(paramMessage, false);
            }
            for (;;)
            {
              MiniAppProxyImpl.a(MiniAppProxyImpl.a(this.a));
              return false;
              DebugUtil.setDebugEnabled(paramMessage, true);
            }
            MiniAppProxyImpl.a(ActionBridge.UpdateUIActionBridge.toggleMonitorPanel(MiniAppProxyImpl.a(this.a)).booleanValue());
            return false;
            paramMessage = MiniAppProxyImpl.a(this.a).getMiniAppInfo();
          } while (paramMessage == null);
          int i;
          MiniAppProxyImpl localMiniAppProxyImpl;
          IMiniAppContext localIMiniAppContext;
          if (paramMessage.topType == 0)
          {
            i = 1;
            paramMessage.topType = i;
            MiniAppProxyImpl.a(this.a, paramMessage);
            localMiniAppProxyImpl = this.a;
            localIMiniAppContext = MiniAppProxyImpl.a(this.a);
            if (paramMessage.topType != 1) {
              break label480;
            }
          }
          for (paramMessage = "settop_on";; paramMessage = "settop_off")
          {
            MiniAppProxyImpl.a(localMiniAppProxyImpl, localIMiniAppContext, paramMessage);
            return false;
            i = 0;
            break;
          }
          paramMessage = MiniAppProxyImpl.a(this.a).getAttachedActivity();
        } while ((paramMessage == null) || (MiniAppProxyImpl.a(this.a).getMiniAppInfo() == null));
        try
        {
          ShortcutUtils.a(paramMessage, MiniAppProxyImpl.a(this.a).getMiniAppInfo());
          MiniAppProxyImpl.a(this.a, MiniAppProxyImpl.a(this.a), "add_desktop");
          return false;
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            QLog.e("MiniAppProxyImpl", 1, "addShortcut error", paramMessage);
          }
        }
        MiniAppProxyImpl.a(this.a, MiniAppProxyImpl.a(this.a));
        return false;
        paramMessage = MiniAppProxyImpl.a(this.a).getMiniAppInfo();
        if ((paramMessage == null) || (!paramMessage.isEngineTypeMiniApp())) {
          break;
        }
        paramMessage = (PageGestureProxy)AppLoaderFactory.g().getProxyManager().get(PageGestureProxy.class);
      } while (!(paramMessage instanceof PageGestureProxyImpl));
      paramMessage = (PageGestureProxyImpl)paramMessage;
      MiniAppProxyImpl.a(this.a, paramMessage.a());
      return false;
    } while (!(MiniAppProxyImpl.a(this.a).getAttachedActivity() instanceof GameActivity1));
    paramMessage = ((GameActivity1)MiniAppProxyImpl.a(this.a).getAttachedActivity()).getColorNoteController();
    MiniAppProxyImpl.a(this.a, paramMessage);
    return false;
    MiniAppProxyImpl.a(this.a).performAction(ActionBridge.RestartActionBridge.obtain());
    return false;
    MiniAppProxyImpl.b(this.a, MiniAppProxyImpl.a(this.a));
    return false;
    MiniAppProxyImpl.c(this.a, MiniAppProxyImpl.a(this.a));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */