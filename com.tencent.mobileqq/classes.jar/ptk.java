import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.expand.IProteusDtReporter;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/dt/RIJProteusDtImpl;", "Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/expand/IProteusDtReporter;", "()V", "needCallDtReportFun", "", "getNeedCallDtReportFun", "()Z", "setNeedCallDtReportFun", "(Z)V", "handleProteusViewClick", "", "view", "Landroid/view/View;", "setDtElementIdWithParams", "id", "", "params", "", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ptk
  implements IProteusDtReporter
{
  private boolean a = true;
  
  public ptk()
  {
    if (Aladdin.getConfig(381).getIntegerFromString("allow_call_dt_report", 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.a = bool;
      QLog.d("RIJProteusDtImpl", 1, "init needCallDtClckFun: " + this.a);
      return;
    }
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
      VideoReport.setElementParams(paramView, new pti().a(paramMap).a());
    }
    if (QLog.isColorLevel()) {
      QLog.d("RIJProteusDtImpl", 0, "id : " + paramString + ", params : " + paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ptk
 * JD-Core Version:    0.7.0.1
 */