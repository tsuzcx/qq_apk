import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentJump;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.im.oidb.articlesummary.articlesummary.PackJumpInfo;

public class riu
  implements View.OnClickListener
{
  public riu(ComponentJump paramComponentJump, articlesummary.PackJumpInfo paramPackJumpInfo) {}
  
  public void onClick(View paramView)
  {
    String str = this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$PackJumpInfo.str_url.get();
    pkh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentJump.getContext(), str);
    qkw.a(2, this.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$PackJumpInfo.str_wording.get());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     riu
 * JD-Core Version:    0.7.0.1
 */