import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class pqn
  implements View.OnClickListener
{
  pqn(pqk parampqk) {}
  
  public void onClick(View paramView)
  {
    this.a.c();
    Object localObject = ((KandianMergeManager)pkh.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
    if ((localObject != null) && (((KandianMsgBoxRedPntInfo)localObject).isFromNotification))
    {
      pro.a(pqk.a(this.a).a(), 5, false, ((KandianMsgBoxRedPntInfo)localObject).mMsgId);
      if (Aladdin.getConfig(338).getIntegerFromString("allow_report_in_dau", 0) == 1)
      {
        if (!(pqk.a(this.a).a() instanceof ReadInJoyNewFeedsActivity)) {
          break label127;
        }
        ((ReadInJoyNewFeedsActivity)pqk.a(this.a).a()).g(2);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      pro.a(pqk.a(this.a).a(), 3);
      break;
      label127:
      if ((pqk.a(this.a).a() instanceof SplashActivity))
      {
        localObject = pqx.a(pqk.a(this.a).a());
        if (localObject != null) {
          ((ReadinjoyTabFrame)localObject).a(2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pqn
 * JD-Core Version:    0.7.0.1
 */