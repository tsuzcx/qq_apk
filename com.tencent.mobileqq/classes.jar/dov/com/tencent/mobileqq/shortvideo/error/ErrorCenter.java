package dov.com.tencent.mobileqq.shortvideo.error;

import com.tencent.mobileqq.app.HardCodeUtil;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class ErrorCenter
  implements ErrorCode, ReportError
{
  private static ErrorCenter jdField_a_of_type_DovComTencentMobileqqShortvideoErrorErrorCenter = new ErrorCenter();
  private static String jdField_a_of_type_JavaLangString;
  private ErrorCenter.ErrorHandleCallback jdField_a_of_type_DovComTencentMobileqqShortvideoErrorErrorCenter$ErrorHandleCallback;
  
  private ErrorCenter()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static ErrorCenter a()
  {
    return jdField_a_of_type_DovComTencentMobileqqShortvideoErrorErrorCenter;
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoErrorErrorCenter$ErrorHandleCallback != null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_DovComTencentMobileqqShortvideoErrorErrorCenter$ErrorHandleCallback.a(paramInt, paramString, paramBoolean2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoErrorErrorCenter$ErrorHandleCallback.b(paramInt, paramString, paramBoolean2);
  }
  
  public boolean a(Object paramObject, int paramInt, String paramString)
  {
    if ((paramObject instanceof AudioCapture)) {}
    switch (paramInt)
    {
    default: 
      return true;
    }
    a(true, 2001, HardCodeUtil.a(2131704222) + 2001 + "）", true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.error.ErrorCenter
 * JD-Core Version:    0.7.0.1
 */