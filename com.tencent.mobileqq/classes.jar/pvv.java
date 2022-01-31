import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotSearch;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class pvv
  implements View.OnClickListener
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  qbg jdField_a_of_type_Qbg;
  TextView b;
  
  protected pvv(ComponentContentHotSearch paramComponentContentHotSearch) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.b.getContext(), PublicAccountBrowser.class);
    paramView.putExtra("url", this.jdField_a_of_type_Qbg.b);
    this.b.getContext().startActivity(paramView);
    paramView = onk.a(this.jdField_a_of_type_Qbg.a, ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).innerUniqueID, ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).hotWordInfo.a.indexOf(this.jdField_a_of_type_Qbg) + 1);
    try
    {
      noo.a(null, "CliOper", "", "", "0X80096DD", "0X80096DD", 0, 0, "", "", "", paramView.toString(), false);
      onk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch.getContext(), ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch), ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch), (int)ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).mChannelID);
      paramView = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = onk.a();
      localReportInfo.mOperation = 53;
      localReportInfo.mInnerId = ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).innerUniqueID;
      localReportInfo.mHotWord = this.jdField_a_of_type_Qbg.a;
      paramView.add(localReportInfo);
      osj.a().a(paramView);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        QLog.e(ComponentContentHotSearch.a, 1, "onClick, e = " + paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pvv
 * JD-Core Version:    0.7.0.1
 */