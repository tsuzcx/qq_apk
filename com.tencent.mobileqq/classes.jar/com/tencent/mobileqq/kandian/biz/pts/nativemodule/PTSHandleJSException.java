package com.tencent.mobileqq.kandian.biz.pts.nativemodule;

import com.tencent.mobileqq.kandian.biz.pts.util.PTSReport;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSReport.R5Builder;
import com.tencent.pts.nativemodule.IPTSHandleJSException;

public class PTSHandleJSException
  implements IPTSHandleJSException
{
  public void handleJSException(int paramInt1, int paramInt2, String paramString)
  {
    PTSReport.R5Builder localR5Builder = new PTSReport.R5Builder().a("type", "1");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt1);
    localR5Builder = localR5Builder.a("line", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt2);
    PTSReport.a("0X800A7C6", "", "", "", localR5Builder.a("column", localStringBuilder.toString()).a("msg", paramString).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.nativemodule.PTSHandleJSException
 * JD-Core Version:    0.7.0.1
 */