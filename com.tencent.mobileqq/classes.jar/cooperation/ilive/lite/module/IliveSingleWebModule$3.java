package cooperation.ilive.lite.module;

import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.IliveLiteMonitorUtil;

class IliveSingleWebModule$3
  implements Runnable
{
  IliveSingleWebModule$3(IliveSingleWebModule paramIliveSingleWebModule, Bundle paramBundle) {}
  
  public void run()
  {
    TouchWebView localTouchWebView = IliveSingleWebModule.a(this.this$0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setWebViewVisibility , webView = ");
    ((StringBuilder)localObject).append(localTouchWebView);
    ((StringBuilder)localObject).append(" mWebView = ");
    ((StringBuilder)localObject).append(IliveSingleWebModule.b(this.this$0));
    ((StringBuilder)localObject).append(" consumeTime = ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - IliveSingleWebModule.a(this.this$0));
    ((StringBuilder)localObject).append(" currentId = ");
    ((StringBuilder)localObject).append(this.this$0.a());
    QLog.e("IliveSingleWebModule", 1, ((StringBuilder)localObject).toString());
    if (localTouchWebView == null) {
      return;
    }
    IliveSingleWebModule.a(this.this$0, true);
    if (IliveSingleWebModule.a(this.this$0) != 0L) {
      IliveLiteMonitorUtil.c("live_switch_consume");
    }
    IliveSingleWebModule.a(this.this$0, 0L);
    this.this$0.e();
    localObject = this.a;
    int i = 0;
    if (!((Bundle)localObject).getBoolean("webview_visible", false)) {
      i = 4;
    }
    localTouchWebView.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveSingleWebModule.3
 * JD-Core Version:    0.7.0.1
 */