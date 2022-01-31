import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver.Listener;
import com.tencent.qphone.base.util.QLog;

public class mwu
  extends FileObserver
{
  public mwu(ScreenshotContentObserver paramScreenshotContentObserver, String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramInt);
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScreenshotContentObserver", 2, "onEvent->time:" + System.currentTimeMillis() + ", path:" + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (paramInt != 256)) {}
    while ((paramString.equalsIgnoreCase(ScreenshotContentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver))) || (paramString.contains("temp")) || (ScreenshotContentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver) == null)) {
      return;
    }
    ScreenshotContentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver).a(null, this.jdField_a_of_type_JavaLangString + paramString, 1);
    ScreenshotContentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwu
 * JD-Core Version:    0.7.0.1
 */