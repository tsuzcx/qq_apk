import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.FeedItemCell.CellListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentLastRead;
import cooperation.readinjoy.ReadInJoyHelper;

public class lzw
  implements View.OnClickListener
{
  public lzw(ComponentLastRead paramComponentLastRead) {}
  
  public void onClick(View paramView)
  {
    paramView = new ReadInJoyUtils.ReportR5Builder().g().a().d().a(this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.e()).e().f().c().a();
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066FD", "0X80066FD", 0, 0, ReadInJoyHelper.a(), "", "", paramView, false);
    if (this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener != null) {
      this.a.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildFeedItemCell$CellListener.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lzw
 * JD-Core Version:    0.7.0.1
 */