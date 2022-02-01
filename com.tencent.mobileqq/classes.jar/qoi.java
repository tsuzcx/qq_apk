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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class qoi
  implements View.OnClickListener
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  qwe jdField_a_of_type_Qwe;
  TextView b;
  
  protected qoi(ComponentContentHotSearch paramComponentContentHotSearch) {}
  
  public void onClick(View paramView)
  {
    Object localObject = new Intent(this.b.getContext(), PublicAccountBrowser.class);
    ((Intent)localObject).putExtra("url", this.jdField_a_of_type_Qwe.b);
    this.b.getContext().startActivity((Intent)localObject);
    localObject = ozs.a(this.jdField_a_of_type_Qwe.a, ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).innerUniqueID, ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).hotWordInfo.a.indexOf(this.jdField_a_of_type_Qwe) + 1);
    try
    {
      ocd.a(null, "CliOper", "", "", "0X80096DD", "0X80096DD", 0, 0, "", "", "", ((JSONObject)localObject).toString(), false);
      ozs.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch.getContext(), ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch), ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch), (int)ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).mChannelID);
      localObject = new ArrayList();
      ReportInfo localReportInfo = new ReportInfo();
      localReportInfo.mUin = ozs.a();
      localReportInfo.mOperation = 53;
      localReportInfo.mInnerId = ComponentContentHotSearch.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentHotSearch).innerUniqueID;
      localReportInfo.mHotWord = this.jdField_a_of_type_Qwe.a;
      ((List)localObject).add(localReportInfo);
      pfa.a().a((List)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(ComponentContentHotSearch.a, 1, "onClick, e = " + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qoi
 * JD-Core Version:    0.7.0.1
 */