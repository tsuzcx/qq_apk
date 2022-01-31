import android.app.Activity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;

class ogd
  implements MediaScanner.OnMediaInfoScannerListener
{
  ogd(ogc paramogc, String paramString) {}
  
  public void a(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (QQStoryFlowCallback.a(this.jdField_a_of_type_Ogc.a.a.a, paramLocalMediaInfo))
    {
      paramLocalMediaInfo.addedDate = 0L;
      this.jdField_a_of_type_Ogc.a.a.a.runOnUiThread(new oge(this, paramLocalMediaInfo));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SlideShowPhotoListManager", 2, "isValidMedia, false:" + paramLocalMediaInfo.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ogd
 * JD-Core Version:    0.7.0.1
 */