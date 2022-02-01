package cooperation.ilive.lite.js;

import android.content.Context;
import android.view.View;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.LiteLiveJsProvider;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.LiteLiveSdkWebViewBaseBuilder;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.LiveBusinessJsInterface;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebviewWrapper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.CloseGuard;

public class IliveSingleWebviewWrapper
  extends WebviewWrapper
{
  public IliveSingleWebviewWrapper(Context paramContext, JsBizAdapter paramJsBizAdapter, LiteLiveJsProvider paramLiteLiveJsProvider, LiveBusinessJsInterface paramLiveBusinessJsInterface, View paramView)
  {
    super(paramContext, paramJsBizAdapter, paramLiteLiveJsProvider, paramLiveBusinessJsInterface, paramView);
  }
  
  public void d()
  {
    QLog.e("IliveSingleWebviewWrapp", 1, "realOnDestory");
    this.d.close();
    onDetach();
    if (this.c != null) {
      this.c.f();
    }
    this.b = null;
    this.a = null;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.js.IliveSingleWebviewWrapper
 * JD-Core Version:    0.7.0.1
 */