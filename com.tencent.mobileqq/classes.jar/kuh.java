import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class kuh
  implements ActionSheet.OnButtonClickListener
{
  public kuh(AccountDetailActivity paramAccountDetailActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.a.r) {
      return;
    }
    this.a.r = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a.b.dismiss();
      return;
      this.a.l = false;
      this.a.x();
      if (((EcShopAssistantManager)this.a.a.getManager(87)).a(this.a.d)) {
        ((EcshopReportHandler)this.a.a.a(88)).a(134243868, this.a.d, null, null, null, 2L, false);
      }
      com.tencent.mobileqq.activity.aio.AIOUtils.m = false;
      if ("2290230341".equals(this.a.d)) {
        ReportController.b(this.a.a, "CliOper", "", "", "0X80090E7", "0X80090E7", 0, 0, "", "", "", "");
      } else if (TextUtils.equals(String.valueOf(2062433139L), this.a.d)) {
        PublicAccountReportUtils.a(null, null, "0X800932F", "0X800932F", 0, 0, "", "", "", VideoReporter.a(null), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kuh
 * JD-Core Version:    0.7.0.1
 */