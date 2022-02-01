package com.tencent.mobileqq.shortvideo.gesture;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class GestureMgr
{
  private static volatile GestureMgr jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgr;
  GestureMgrAppDownload jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrAppDownload = null;
  GestureMgrDownload jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrDownload = null;
  
  public static GestureMgr a()
  {
    if (jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgr == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgr == null)
        {
          GestureMgr localGestureMgr = new GestureMgr();
          localGestureMgr.b();
          jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgr = localGestureMgr;
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgr;
  }
  
  public static void a()
  {
    GestureMgr localGestureMgr = a();
    if (QLog.isDevelopLevel()) {
      QLog.d("QavGesture", 4, String.format("onDownloadRequest, mStatusGesture[%s]", new Object[] { Integer.valueOf(localGestureMgr.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrDownload.a) }));
    }
    GestureMgrAppDownload.a();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrDownload = new GestureMgrDownload();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrAppDownload = new GestureMgrAppDownload();
    }
  }
  
  public void a(boolean paramBoolean, GestureMgr.GestureStatusListener paramGestureStatusListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrDownload.a(paramBoolean, paramGestureStatusListener);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrDownload.a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrDownload.c();
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrDownload.b();
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureGestureMgrDownload.a == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgr
 * JD-Core Version:    0.7.0.1
 */