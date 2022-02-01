package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import cooperation.qzone.share.WXShareFromQZHelper;
import cooperation.qzone.share.WXShareFromQZHelper.WXShareListener;
import yyi;

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
        yyi.a(1, 2131718380);
        break;
      case 0: 
        yyi.a(2, 2131718398);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.1
 * JD-Core Version:    0.7.0.1
 */