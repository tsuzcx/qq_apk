package com.tencent.mobileqq.flashshow.part;

import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.qphone.base.util.QLog;

public abstract class FSBasePart
  extends Part
{
  public String i()
  {
    return l().getPageId();
  }
  
  public FSReportBean l()
  {
    Object localObject = D();
    if (!(localObject instanceof FSReportBean))
    {
      if (!RFApplication.isDebug())
      {
        QLog.e("FSBasePart", 1, "getReportBean but FSReportBean is null");
        return new FSReportBean();
      }
      QLog.e("FSBasePart", 1, "getReportBean but FSReportBean is null , debug");
      throw new RuntimeException("getReportBean but FSReportBean is null");
    }
    return (FSReportBean)localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSBasePart
 * JD-Core Version:    0.7.0.1
 */