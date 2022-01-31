import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.model.SelfInfoModule.BusinessCountInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoySelfInnerListViewAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;

public class mjo
  implements AdapterView.OnItemClickListener
{
  public mjo(ReadInjoySelfInnerListViewAdapter paramReadInjoySelfInnerListViewAdapter, Context paramContext) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (SelfInfoModule.BusinessCountInfo)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySelfInnerListViewAdapter.getItem(paramInt);
    if ((paramAdapterView != null) && (!TextUtils.isEmpty(paramAdapterView.b)))
    {
      if (!paramAdapterView.b.startsWith("mqq://")) {
        break label154;
      }
      paramView = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.jdField_a_of_type_AndroidContentContext, paramAdapterView.b);
      if (paramView != null) {
        paramView.b();
      }
    }
    for (;;)
    {
      paramView = new ReadInJoyUtils.ReportR5Builder().a().a();
      if (!TextUtils.isEmpty(paramView)) {
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80092FE", "0X80092FE", 0, 0, "" + paramAdapterView.c, "" + paramAdapterView.a, "", paramView, false);
      }
      return;
      label154:
      ReadInJoyUtils.b(ReadInjoySelfInnerListViewAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySelfInnerListViewAdapter), paramAdapterView.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mjo
 * JD-Core Version:    0.7.0.1
 */