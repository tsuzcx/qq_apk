import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyFooterPresenter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.OnLastReadRefreshListener;
import cooperation.readinjoy.ReadInJoyHelper;

public class lsj
  implements View.OnClickListener
{
  public lsj(ReadInJoyFooterPresenter paramReadInJoyFooterPresenter) {}
  
  public void onClick(View paramView)
  {
    paramView = new ReadInJoyUtils.ReportR5Builder().g().a().d().a(ReadInJoyFooterPresenter.a(this.a).e()).e().f().c().a();
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, ReadInJoyHelper.a(), "", "", paramView, false);
    if (ReadInJoyFooterPresenter.a(this.a) != null) {
      ReadInJoyFooterPresenter.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lsj
 * JD-Core Version:    0.7.0.1
 */