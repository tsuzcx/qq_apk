package cooperation.qzone.webviewplugin;

import android.graphics.BitmapFactory;
import begz;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.util.QZLog;
import java.io.IOException;
import java.util.Map;
import ndd;

public final class QZoneWebViewJsHandleLogic$3
  implements Runnable
{
  public QZoneWebViewJsHandleLogic$3(String paramString, Map paramMap, begz parambegz, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      Object localObject = ndd.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString, "GET", null, null);
      if (localObject != null)
      {
        localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
        if (localObject != null) {
          this.jdField_a_of_type_JavaUtilMap.put("image", localObject);
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
    this.jdField_a_of_type_Begz.a().runOnUiThread(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.3
 * JD-Core Version:    0.7.0.1
 */