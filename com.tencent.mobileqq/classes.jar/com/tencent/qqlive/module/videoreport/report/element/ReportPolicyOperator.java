package com.tencent.qqlive.module.videoreport.report.element;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;

public class ReportPolicyOperator
{
  private static final String TAG = "ReportPolicyOperator";
  
  public static <T> T getReportPolicy(Object paramObject, String paramString, Class<T> paramClass)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("ReportPolicyOperator", "getElementExposePolicy: ");
    }
    if (!VideoReportInner.getInstance().checkElementObjectArgument(paramObject)) {
      return null;
    }
    paramObject = DataRWProxy.getInnerParam(paramObject, paramString);
    if (paramClass.isInstance(paramObject)) {
      return paramClass.cast(paramObject);
    }
    return null;
  }
  
  public static void setReportPolicy(Object paramObject1, Object paramObject2, String paramString)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setElementClickPolicy: object=");
      localStringBuilder.append(paramObject1);
      localStringBuilder.append(", policy=");
      localStringBuilder.append(paramObject2);
      Log.i("ReportPolicyOperator", localStringBuilder.toString());
    }
    if (VideoReportInner.getInstance().checkElementObjectArgument(paramObject1)) {
      DataRWProxy.setInnerParam(paramObject1, paramString, paramObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ReportPolicyOperator
 * JD-Core Version:    0.7.0.1
 */