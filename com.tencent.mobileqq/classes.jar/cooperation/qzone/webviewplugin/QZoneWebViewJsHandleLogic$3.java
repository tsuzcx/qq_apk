package cooperation.qzone.webviewplugin;

import android.graphics.BitmapFactory;
import bgve;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.util.QZLog;
import java.io.IOException;
import java.util.Map;

final class QZoneWebViewJsHandleLogic$3
  implements Runnable
{
  QZoneWebViewJsHandleLogic$3(String paramString, Map paramMap, bgve parambgve, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      Object localObject = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), this.val$picUrl, "GET", null, null);
      if (localObject != null)
      {
        localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
        if (localObject != null) {
          this.val$wrapper.put("image", localObject);
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QZLog.e("QZoneWebViewJsHandleLogic", "download pic error", localIOException);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        QZLog.e("QZoneWebViewJsHandleLogic", "download pic error", localOutOfMemoryError);
      }
    }
    this.val$runtime.a().runOnUiThread(this.val$r);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.3
 * JD-Core Version:    0.7.0.1
 */