package com.tencent.mobileqq.kandian.biz.pts.util;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.JsonUtils;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.pts.utils.PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import org.json.JSONObject;

final class PTSHelper$3
  implements PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo
{
  public void onBindNodeInfoFinished(String paramString1, View paramView, String paramString2, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    if ((paramView != null) && (paramMap2 != null))
    {
      paramString1 = paramMap2.get("dt:element-id");
      paramString2 = paramMap2.get("dt:params");
      if (paramString1 == null) {}
    }
    try
    {
      VideoReport.setElementId(paramView, (String)paramString1);
      if (paramString2 == null) {
        break label116;
      }
      paramString1 = JsonUtils.covertJsonObjectToMap(new JSONObject((String)paramString2));
      VideoReport.setElementParams(paramView, new RIJDtParamBuilder().a(paramString1).c());
      return;
    }
    catch (Exception paramView)
    {
      label85:
      break label85;
    }
    paramString1 = new StringBuilder();
    paramString1.append("[onBindNodeInfoFinished] e = ");
    paramString1.append(paramView);
    QLog.e("PTSHelper", 1, paramString1.toString());
    label116:
    return;
    QLog.i("PTSHelper", 1, "[onBindNodeInfoFinished] view is null or attributes is empty.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSHelper.3
 * JD-Core Version:    0.7.0.1
 */