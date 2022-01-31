package com.tencent.qqmini.proxyimpl;

import amgn;
import android.os.Handler.Callback;
import android.os.Message;
import besz;
import betc;
import bfhj;
import com.tencent.mobileqq.minigame.ui.GameActivity1;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class MiniAppProxyImpl$2
  implements Handler.Callback
{
  MiniAppProxyImpl$2(MiniAppProxyImpl paramMiniAppProxyImpl) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      if (betc.a()) {
        betc.d("MiniAppProxyImpl", "handleMessage error, msg is null.");
      }
    }
    label445:
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
                betc.d("MiniAppProxyImpl", "handleMessage error, MiniAppContext is null.");
                return false;
              }
              switch (paramMessage.what)
              {
              case 4: 
              case 10: 
              default: 
                return false;
              case 2: 
                MiniAppProxyImpl.access$000(this.this$0).a(1, null);
                return false;
              case 1000: 
                this.this$0.doShowShareView();
                return false;
              case 6: 
                MiniAppProxyImpl.access$000(this.this$0).a(2, null);
                return false;
              case 7: 
                MiniAppProxyImpl.access$000(this.this$0).a(3, null);
                return false;
              case 8: 
                MiniAppProxyImpl.access$000(this.this$0).a(4, null);
                return false;
              case 13: 
                MiniAppProxyImpl.access$000(this.this$0).a(5, paramMessage.getData());
                return false;
              }
            } while (MiniAppProxyImpl.access$000(this.this$0).a() == null);
            if (this.this$0.getEnableDebug(MiniAppProxyImpl.access$000(this.this$0).a().appId)) {
              this.this$0.setEnableDebug(MiniAppProxyImpl.access$000(this.this$0).a().appId, false);
            }
            for (;;)
            {
              bfhj.a(MiniAppProxyImpl.access$000(this.this$0).a());
              return false;
              this.this$0.setEnableDebug(MiniAppProxyImpl.access$000(this.this$0).a().appId, true);
            }
            MiniAppProxyImpl.access$102(MiniAppProxyImpl.access$000(this.this$0).b());
            return false;
            paramMessage = MiniAppProxyImpl.access$000(this.this$0).a();
            int i;
            MiniAppProxyImpl localMiniAppProxyImpl;
            if (paramMessage.topType == 0)
            {
              i = 1;
              paramMessage.topType = i;
              MiniAppProxyImpl.access$200(this.this$0, paramMessage);
              localMiniAppProxyImpl = this.this$0;
              if (paramMessage.topType != 1) {
                break label445;
              }
            }
            for (paramMessage = "settop_on";; paramMessage = "settop_off")
            {
              MiniAppProxyImpl.access$300(localMiniAppProxyImpl, paramMessage);
              return false;
              i = 0;
              break;
            }
            paramMessage = MiniAppProxyImpl.access$000(this.this$0).a();
          } while ((paramMessage == null) || (MiniAppProxyImpl.access$000(this.this$0).a() == null));
          ShortcutUtils.addShortcut(paramMessage, MiniAppProxyImpl.access$000(this.this$0).a());
          MiniAppProxyImpl.access$300(this.this$0, "add_desktop");
          return false;
          MiniAppProxyImpl.access$400(this.this$0, MiniAppProxyImpl.access$000(this.this$0));
          return false;
        } while (!(MiniAppProxyImpl.access$000(this.this$0).a() instanceof GameActivity1));
        paramMessage = ((GameActivity1)MiniAppProxyImpl.access$000(this.this$0).a()).getColorNoteController();
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */