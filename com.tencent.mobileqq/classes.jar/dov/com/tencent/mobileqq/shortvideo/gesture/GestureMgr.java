package dov.com.tencent.mobileqq.shortvideo.gesture;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class GestureMgr
{
  private static volatile GestureMgr jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgr;
  GestureMgrAppDownload jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrAppDownload = null;
  GestureMgrDownload jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrDownload = null;
  
  public static GestureMgr a()
  {
    if (jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgr == null) {}
    try
    {
      if (jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgr == null)
      {
        GestureMgr localGestureMgr = new GestureMgr();
        localGestureMgr.a();
        jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgr = localGestureMgr;
      }
      return jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgr;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrDownload = new GestureMgrDownload();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrAppDownload = new GestureMgrAppDownload();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_DovComTencentMobileqqShortvideoGestureGestureMgrDownload.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.gesture.GestureMgr
 * JD-Core Version:    0.7.0.1
 */