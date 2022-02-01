package com.tencent.mobileqq.kandian.glue.report.dt;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.expand.IProteusDtReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/report/dt/RIJProteusDtImpl;", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/expand/IProteusDtReporter;", "needCallDtReportFun", "", "(Z)V", "getNeedCallDtReportFun", "()Z", "handleProteusViewClick", "", "view", "Landroid/view/View;", "setDtElementIdWithParams", "id", "", "params", "", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class RIJProteusDtImpl
  implements IProteusDtReporter
{
  private final boolean a;
  
  public RIJProteusDtImpl()
  {
    this(false, 1, null);
  }
  
  public RIJProteusDtImpl(boolean paramBoolean)
  {
    this.a = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init needCallDtClckFun: ");
    localStringBuilder.append(this.a);
    QLog.d("RIJProteusDtImpl", 1, localStringBuilder.toString());
  }
  
  public void handleProteusViewClick(@Nullable View paramView)
  {
    if (this.a) {
      EventCollector.getInstance().onViewClicked(paramView);
    }
  }
  
  public void setDtElementIdWithParams(@Nullable View paramView, @Nullable String paramString, @Nullable Map<String, Object> paramMap)
  {
    VideoReport.setElementId(paramView, paramString);
    if (paramMap != null) {
      VideoReport.setElementParams(paramView, new RIJDtParamBuilder().a(paramMap).a());
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("id : ");
      paramView.append(paramString);
      paramView.append(", params : ");
      paramView.append(paramMap);
      QLog.d("RIJProteusDtImpl", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.dt.RIJProteusDtImpl
 * JD-Core Version:    0.7.0.1
 */