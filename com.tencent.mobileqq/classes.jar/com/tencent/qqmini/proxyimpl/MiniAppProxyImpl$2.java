package com.tencent.qqmini.proxyimpl;

import android.os.Handler.Callback;
import android.os.Message;
import anxn;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniRuntime;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.ProcessUtil;

class MiniAppProxyImpl$2
  implements Handler.Callback
{
  MiniAppProxyImpl$2(MiniAppProxyImpl paramMiniAppProxyImpl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      if (QMLog.isColorLevel()) {
        QMLog.e("MiniAppProxyImpl", "handleMessage error, msg is null.");
      }
    }
    label453:
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
              if (MiniAppProxyImpl.access$000(this.this$0) == null)
              {
                QMLog.e("MiniAppProxyImpl", "handleMessage error, MiniAppContext is null.");
                return false;
              }
              switch (paramMessage.what)
              {
              case 4: 
              case 10: 
              default: 
                return false;
              case 2: 
                MiniAppProxyImpl.access$000(this.this$0).share(1, null);
                return false;
              case 1000: 
                this.this$0.doShowShareView();
                return false;
              case 6: 
                MiniAppProxyImpl.access$000(this.this$0).share(2, null);
                return false;
              case 7: 
                MiniAppProxyImpl.access$000(this.this$0).share(3, null);
                return false;
              case 8: 
                MiniAppProxyImpl.access$000(this.this$0).share(4, null);
                return false;
              case 13: 
                MiniAppProxyImpl.access$000(this.this$0).share(5, paramMessage.getData());
                return false;
              }
            } while (MiniAppProxyImpl.access$000(this.this$0).getMiniAppInfo() == null);
            if (this.this$0.getEnableDebug(MiniAppProxyImpl.access$000(this.this$0).getMiniAppInfo().appId)) {
              this.this$0.setEnableDebug(MiniAppProxyImpl.access$000(this.this$0).getMiniAppInfo().appId, false);
            }
            for (;;)
            {
              ProcessUtil.exitProcess(MiniAppProxyImpl.access$000(this.this$0).getAttachedActivity());
              return false;
              this.this$0.setEnableDebug(MiniAppProxyImpl.access$000(this.this$0).getMiniAppInfo().appId, true);
            }
            MiniAppProxyImpl.access$102(MiniAppProxyImpl.access$000(this.this$0).toggleMonitorPanel());
            return false;
            paramMessage = MiniAppProxyImpl.access$000(this.this$0).getMiniAppInfo();
            int i;
            MiniAppProxyImpl localMiniAppProxyImpl;
            if (paramMessage.topType == 0)
            {
              i = 1;
              paramMessage.topType = i;
              MiniAppProxyImpl.access$200(this.this$0, paramMessage);
              localMiniAppProxyImpl = this.this$0;
              if (paramMessage.topType != 1) {
                break label453;
              }
            }
            for (paramMessage = "settop_on";; paramMessage = "settop_off")
            {
              MiniAppProxyImpl.access$300(localMiniAppProxyImpl, paramMessage);
              return false;
              i = 0;
              break;
            }
            paramMessage = MiniAppProxyImpl.access$000(this.this$0).getAttachedActivity();
          } while ((paramMessage == null) || (MiniAppProxyImpl.access$000(this.this$0).getMiniAppInfo() == null));
          ShortcutUtils.addShortcut(paramMessage, MiniAppProxyImpl.access$000(this.this$0).getMiniAppInfo());
          MiniAppProxyImpl.access$300(this.this$0, "add_desktop");
          return false;
          MiniAppProxyImpl.access$400(this.this$0, MiniAppProxyImpl.access$000(this.this$0));
          return false;
        } while (!(MiniAppProxyImpl.access$000(this.this$0).getAttachedActivity() instanceof GameActivity1));
        paramMessage = ((GameActivity1)MiniAppProxyImpl.access$000(this.this$0).getAttachedActivity()).getColorNoteController();
      } while (paramMessage == null);
      if (!paramMessage.c())
      {
        if (paramMessage.b())
        {
          paramMessage.e();
          return false;
        }
        paramMessage.i();
        return false;
      }
    } while (!paramMessage.c());
    paramMessage.f();
    return false;
    MiniAppProxyImpl.access$000(this.this$0).restart();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */