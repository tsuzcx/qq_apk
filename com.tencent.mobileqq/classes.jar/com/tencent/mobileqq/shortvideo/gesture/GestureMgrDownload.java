package com.tencent.mobileqq.shortvideo.gesture;

import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GestureMgrDownload
{
  int jdField_a_of_type_Int = 0;
  DownloadInfo jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = null;
  ArrayList<GestureMgr.GestureStatusListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  GestureMgrDownload()
  {
    a(BaseApplicationImpl.getApplication());
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.get();
    this.jdField_a_of_type_Int = GestureUtil.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo);
    QLog.d("QavGesture", 1, String.format("GestureMgr, mStatusGesture[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
  }
  
  void a(boolean paramBoolean, GestureMgr.GestureStatusListener paramGestureStatusListener)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (paramBoolean) {}
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramGestureStatusListener);
      break label32;
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramGestureStatusListener);
      label32:
      return;
    }
    finally {}
  }
  
  boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.get();
    this.jdField_a_of_type_Int = GestureUtil.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo);
    boolean bool2 = QLog.isDevelopLevel();
    boolean bool1 = false;
    if (bool2) {
      QLog.d("QavGesture", 4, String.format("checkResReady, mStatusGesture[%s]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    if (11 != this.jdField_a_of_type_Int) {
      bool1 = true;
    }
    return bool1;
  }
  
  boolean a(BaseApplicationImpl paramBaseApplicationImpl)
  {
    boolean bool2 = QLog.isDevelopLevel();
    boolean bool1 = false;
    if (bool2) {
      QLog.d("QavGesture", 4, String.format("registReceiver[%s]", new Object[] { paramBaseApplicationImpl.getQQProcessName() }));
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.video.gesturemgr.notify");
    if (paramBaseApplicationImpl.registerReceiver(new GestureMgrDownload.1(this), localIntentFilter) != null) {
      bool1 = true;
    }
    return bool1;
  }
  
  boolean b()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  boolean c()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = DownloadInfo.get();
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = GestureUtil.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo);
    boolean bool;
    if (this.jdField_a_of_type_Int == 11)
    {
      this.jdField_a_of_type_Int = 12;
      BusinessCommonConfig.notifyQQDownload(1, null, 0);
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavGesture", 2, String.format("nodifyDownloadRes, lastStatus[%s], mStatusGesture[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_Int) }));
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrDownload
 * JD-Core Version:    0.7.0.1
 */