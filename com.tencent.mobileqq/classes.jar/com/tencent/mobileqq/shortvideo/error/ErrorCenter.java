package com.tencent.mobileqq.shortvideo.error;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;

public class ErrorCenter
  implements ErrorCode, ReportError
{
  private static ErrorCenter a = new ErrorCenter();
  private static String b;
  private ErrorCenter.ErrorHandleCallback c;
  
  private ErrorCenter()
  {
    b = getClass().getSimpleName();
  }
  
  public static ErrorCenter a()
  {
    return a;
  }
  
  private void a(boolean paramBoolean1, int paramInt, String paramString, boolean paramBoolean2)
  {
    ErrorCenter.ErrorHandleCallback localErrorHandleCallback = this.c;
    if (localErrorHandleCallback != null)
    {
      if (paramBoolean1)
      {
        localErrorHandleCallback.a(paramInt, paramString, paramBoolean2);
        return;
      }
      localErrorHandleCallback.b(paramInt, paramString, paramBoolean2);
    }
  }
  
  public void a(ErrorCenter.ErrorHandleCallback paramErrorHandleCallback)
  {
    this.c = paramErrorHandleCallback;
  }
  
  public boolean a(Object paramObject, int paramInt, String paramString)
  {
    boolean bool2 = paramObject instanceof AudioCapture;
    boolean bool1 = true;
    if (bool2)
    {
      if (paramInt != 3) {
        return true;
      }
      paramObject = new StringBuilder();
      paramObject.append(HardCodeUtil.a(2131902230));
      paramObject.append(2001);
      paramObject.append("）");
      a(true, 2001, paramObject.toString(), true);
      bool1 = false;
    }
    return bool1;
  }
  
  public void b()
  {
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.error.ErrorCenter
 * JD-Core Version:    0.7.0.1
 */