package com.tencent.mobileqq.kandian.glue.viola.modules;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaDatongReportUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.module.BaseModule;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.utils.ViolaUtils;
import java.util.Map;

public class DtReportModule
  extends BaseModule
{
  public static final String MODULE_NAME = "report";
  
  @JSMethod
  public void dtReport(String paramString1, Object paramObject, String paramString2)
  {
    if ((getViolaInstance() != null) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString2 = ViolaUtils.findComponent(getViolaInstance().getInstanceId(), paramString2);
      if (paramString2 != null) {
        paramString2 = paramString2.getHostView();
      } else {
        paramString2 = null;
      }
      if (paramString2 == null) {
        return;
      }
      Map localMap = ViolaDatongReportUtils.a(paramObject.toString());
      if (localMap.containsKey("dt_eid")) {
        VideoReport.setElementId(paramString2, ViolaUtils.getString(localMap.get("dt_eid"), ""));
      }
      VideoReport.setElementParams(paramString2, localMap);
      ViolaDatongReportUtils.a(paramString1, paramObject, paramString2);
    }
  }
  
  public String getModuleName()
  {
    return "report";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.DtReportModule
 * JD-Core Version:    0.7.0.1
 */