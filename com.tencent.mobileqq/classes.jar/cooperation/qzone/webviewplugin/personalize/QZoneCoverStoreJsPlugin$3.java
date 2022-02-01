package cooperation.qzone.webviewplugin.personalize;

import android.app.Activity;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.QZoneVideoCommonUtils.onForwardVideoActivityFailedListener;

class QZoneCoverStoreJsPlugin$3
  implements QZoneVideoCommonUtils.onForwardVideoActivityFailedListener
{
  QZoneCoverStoreJsPlugin$3(QZoneCoverStoreJsPlugin paramQZoneCoverStoreJsPlugin, int paramInt) {}
  
  public void onFail(Activity paramActivity, String paramString)
  {
    QQToast.a(paramActivity, paramString, 0).b(this.val$offset);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */