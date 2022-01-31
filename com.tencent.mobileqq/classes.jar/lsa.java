import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyFooterPresenter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.OnLastReadRefreshListener;
import cooperation.readinjoy.ReadInJoyHelper;

public class lsa
  implements View.OnClickListener
{
  public lsa(ReadInJoyFooterPresenter paramReadInJoyFooterPresenter) {}
  
  public void onClick(View paramView)
  {
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, ReadInJoyHelper.a(), "", "", ReadInJoyUtils.c(), false);
    if (ReadInJoyFooterPresenter.a(this.a) != null) {
      ReadInJoyFooterPresenter.a(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lsa
 * JD-Core Version:    0.7.0.1
 */