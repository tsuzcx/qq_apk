package dov.com.tencent.mobileqq.shortvideo.gesture;

import android.content.IntentFilter;
import aoyf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GestureMgrDownload
{
  public int a;
  public DownloadInfo a;
  public ArrayList a;
  
  GestureMgrDownload()
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureDownloadInfo = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    a(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.a();
    this.jdField_a_of_type_Int = GestureUtil.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureDownloadInfo);
    QLog.d("QavGesture", 1, String.format("GestureMgr, mStatusGesture[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  boolean a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("registReceiver[%s]", new Object[] { paramBaseApplicationImpl.getProcessName() }));
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.video.gesturemgr.notify");
    return paramBaseApplicationImpl.registerReceiver(new aoyf(this), localIntentFilter) != null;
  }
  
  boolean b()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureDownloadInfo == null) {
      return false;
    }
    if ((this.jdField_a_of_type_Int == 1) && (GestureUtil.a(this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureDownloadInfo))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.gesture.GestureMgrDownload
 * JD-Core Version:    0.7.0.1
 */