import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class sin
  implements View.OnClickListener
{
  public sin(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyListViewGroup.c(this.a);
    Object localObject = ((KandianMergeManager)ozs.a().getManager(162)).a();
    if ((localObject != null) && (((KandianMsgBoxRedPntInfo)localObject).isFromNotification))
    {
      ozs.a(this.a.getContext(), 5, false, ((KandianMsgBoxRedPntInfo)localObject).mMsgId);
      if (Aladdin.getConfig(338).getIntegerFromString("allow_report_in_dau", 0) == 1)
      {
        if (!(this.a.getContext() instanceof ReadInJoyNewFeedsActivity)) {
          break label115;
        }
        ((ReadInJoyNewFeedsActivity)this.a.getContext()).g(2);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ozs.a(this.a.getContext(), 3);
      break;
      label115:
      if ((this.a.getContext() instanceof SplashActivity))
      {
        localObject = ozs.a(this.a.getContext());
        if (localObject != null) {
          ((ReadinjoyTabFrame)localObject).a(2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sin
 * JD-Core Version:    0.7.0.1
 */