package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import cooperation.qzone.share.WXShareFromQZHelper;
import cooperation.qzone.share.WXShareFromQZHelper.WXShareListener;

final class QZoneWebViewJsHandleLogic$1
  implements WXShareFromQZHelper.WXShareListener
{
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((!TextUtils.isEmpty(QZoneWebViewJsHandleLogic.mShareMsgCallback)) && (QZoneWebViewJsHandleLogic.webview != null)) {
      QZoneWebViewJsHandleLogic.webview.callJs(QZoneWebViewJsHandleLogic.mShareMsgCallback, new String[] { String.valueOf(paramBaseResp.errCode) });
    }
    for (;;)
    {
      QZoneWebViewJsHandleLogic.mShareMsgCallback = null;
      QZoneWebViewJsHandleLogic.webview = null;
      WXShareFromQZHelper.getInstance().removeObserver(this);
      return;
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        QRUtils.a(1, 2131719291);
        break;
      case 0: 
        QRUtils.a(2, 2131719309);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.1
 * JD-Core Version:    0.7.0.1
 */