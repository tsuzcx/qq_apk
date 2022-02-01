package dov.com.tencent.mobileqq.shortvideo.gesture;

import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GestureMgrDownload
{
  int jdField_a_of_type_Int = 0;
  DownloadInfo jdField_a_of_type_DovComTencentMobileqqShortvideoGestureDownloadInfo = null;
  ArrayList<GestureMgr.GestureStatusListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  GestureMgrDownload()
  {
    a(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.a();
    this.jdField_a_of_type_Int = GestureUtil.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureDownloadInfo);
    QLog.d("QavGesture", 1, String.format("GestureMgr, mStatusGesture[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  boolean a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("registReceiver[%s]", new Object[] { paramBaseApplicationImpl.getQQProcessName() }));
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.video.gesturemgr.notify");
    return paramBaseApplicationImpl.registerReceiver(new GestureMgrDownload.1(this), localIntentFilter) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.gesture.GestureMgrDownload
 * JD-Core Version:    0.7.0.1
 */