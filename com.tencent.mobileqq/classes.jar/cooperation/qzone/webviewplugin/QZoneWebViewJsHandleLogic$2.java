package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.graphics.Bitmap;
import bgve;
import cooperation.qzone.share.WXShareFromQZHelper;
import java.util.Map;

final class QZoneWebViewJsHandleLogic$2
  implements Runnable
{
  QZoneWebViewJsHandleLogic$2(bgve parambgve, Map paramMap, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    Object localObject = this.val$runtime.a();
    if ((localObject == null) || (((Activity)localObject).isFinishing())) {
      return;
    }
    localObject = (Bitmap)this.val$wrapper.remove("image");
    WXShareFromQZHelper.getInstance().addObserver(QZoneWebViewJsHandleLogic.wxShareListener);
    WXShareFromQZHelper.getInstance().shareMiniProgram(this.val$title, (Bitmap)localObject, this.val$description, this.val$webpageUrl, this.val$path, this.val$userName, null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.2
 * JD-Core Version:    0.7.0.1
 */