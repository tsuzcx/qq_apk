package com.tencent.mobileqq.shortvideo.error;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class ErrorCenter
  implements ErrorCode, ReportError
{
  private static ErrorCenter jdField_a_of_type_ComTencentMobileqqShortvideoErrorErrorCenter = new ErrorCenter();
  private static String jdField_a_of_type_JavaLangString;
  private ErrorCenter.ErrorHandleCallback jdField_a_of_type_ComTencentMobileqqShortvideoErrorErrorCenter$ErrorHandleCallback;
  
  private ErrorCenter()
  {
    jdField_a_of_type_JavaLangString = getClass().getSimpleName();
  }
  
  public static ErrorCenter a()
  {
    return jdField_a_of_type_ComTencentMobileqqShortvideoErrorErrorCenter;
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoErrorErrorCenter$ErrorHandleCallback != null)
    {
      if (paramBoolean1) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoErrorErrorCenter$ErrorHandleCallback.a(paramInt, paramString, paramBoolean2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoErrorErrorCenter$ErrorHandleCallback.b(paramInt, paramString, paramBoolean2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoErrorErrorCenter$ErrorHandleCallback = null;
  }
  
  public void a(ErrorCenter.ErrorHandleCallback paramErrorHandleCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoErrorErrorCenter$ErrorHandleCallback = paramErrorHandleCallback;
  }
  
  public boolean a(Object paramObject, int paramInt, String paramString)
  {
    if ((paramObject instanceof AudioCapture)) {}
    switch (paramInt)
    {
    default: 
      return true;
    }
    a(true, 2001, HardCodeUtil.a(2131704225) + 2001 + "）", true);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.error.ErrorCenter
 * JD-Core Version:    0.7.0.1
 */