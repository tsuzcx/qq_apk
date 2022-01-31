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

public class qcm
  implements View.OnClickListener
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  qkz jdField_a_of_type_Qkz;
  TextView b;
  
  protected qcm(ComponentContentHotSearch paramComponentContentHotSearch) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.b.getContext(), PublicAccountBrowser.class);
    paramView.putExtra("url", this.jdField_a_of_type_Qkz.b);
    this.b.getContext().startActivity(paramView);
    paramView = ors.a(this.jdField_a_of_type_Qkz.a, ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).innerUniqueID, ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).hotWordInfo.a.indexOf(this.jdField_a_of_type_Qkz) + 1);
    try
    {
      nrt.a(null, "CliOper", "", "", "0X80096DD", "0X80096DD", 0, 0, "", "", "", paramView.toString(), false);
      ors.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch.getContext(), ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch), ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch), (int)ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).mChannelID);
      paramView = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = ors.a();
      localReportInfo.mOperation = 53;
      localReportInfo.mInnerId = ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).innerUniqueID;
      localReportInfo.mHotWord = this.jdField_a_of_type_Qkz.a;
      paramView.add(localReportInfo);
      owy.a().a(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qcm
 * JD-Core Version:    0.7.0.1
 */