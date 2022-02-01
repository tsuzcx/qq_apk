import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentJump;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.im.oidb.articlesummary.articlesummary.PackJumpInfo;

public class qwp
  implements View.OnClickListener
{
  public qwp(ComponentJump paramComponentJump, articlesummary.PackJumpInfo paramPackJumpInfo) {}
  
  public void onClick(View paramView)
  {
    String str = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$PackJumpInfo.str_url.get();
    pay.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump.getContext(), str);
    pyr.a(2, this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$PackJumpInfo.str_wording.get());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qwp
 * JD-Core Version:    0.7.0.1
 */