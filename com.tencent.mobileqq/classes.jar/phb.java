import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class phb
  implements View.OnClickListener
{
  phb(pgz parampgz) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    Object localObject = ((KandianMergeManager)pay.a().getManager(162)).a();
    if ((localObject != null) && (((KandianMsgBoxRedPntInfo)localObject).isFromNotification))
    {
      pay.a(pgz.a(this.a).a(), 5, false, ((KandianMsgBoxRedPntInfo)localObject).mMsgId);
      if (Aladdin.getConfig(338).getIntegerFromString("allow_report_in_dau", 0) == 1)
      {
        if (!(pgz.a(this.a).a() instanceof ReadInJoyNewFeedsActivity)) {
          break label127;
        }
        ((ReadInJoyNewFeedsActivity)pgz.a(this.a).a()).g(2);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      pay.a(pgz.a(this.a).a(), 3);
      break;
      label127:
      if ((pgz.a(this.a).a() instanceof SplashActivity))
      {
        localObject = pay.a(pgz.a(this.a).a());
        if (localObject != null) {
          ((ReadinjoyTabFrame)localObject).a(2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     phb
 * JD-Core Version:    0.7.0.1
 */