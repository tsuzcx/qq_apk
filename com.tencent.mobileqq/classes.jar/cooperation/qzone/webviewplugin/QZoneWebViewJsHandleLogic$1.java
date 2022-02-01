package cooperation.qzone.webviewplugin;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.qzonehub.api.IQzoneShareApi.WXShareListener;

final class QZoneWebViewJsHandleLogic$1
  implements IQzoneShareApi.WXShareListener
{
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((!TextUtils.isEmpty(QZoneWebViewJsHandleLogic.mShareMsgCallback)) && (QZoneWebViewJsHandleLogic.webview != null))
    {
      QZoneWebViewJsHandleLogic.webview.callJs(QZoneWebViewJsHandleLogic.mShareMsgCallback, new String[] { String.valueOf(paramBaseResp.errCode) });
    }
    else
    {
      int i = paramBaseResp.errCode;
      if (i != -2) {
        if (i != 0) {
          QRUtils.a(1, 2131719009);
        } else {
          QRUtils.a(2, 2131719027);
        }
      }
    }
    QZoneWebViewJsHandleLogic.mShareMsgCallback = null;
    QZoneWebViewJsHandleLogic.webview = null;
    ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.1
 * JD-Core Version:    0.7.0.1
 */