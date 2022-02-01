package com.tencent.mobileqq.vas.gldrawable;

import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class GLDrawableLoaderImpl$MyReporter
  extends GLDrawableProxy.Reporter
{
  public void a(String paramString)
  {
    QLog.i("GLDrawable", 1, paramString);
  }
  
  public void a(String paramString, Exception paramException)
  {
    QLog.e("GLDrawable", 1, paramString, paramException);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("status_code", paramString2);
    localHashMap.put("status_msg", paramString3);
    localHashMap.put("scid", "GLDrawableV8417");
    VasStatisticCollector.a(paramString1, paramLong, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.GLDrawableLoaderImpl.MyReporter
 * JD-Core Version:    0.7.0.1
 */