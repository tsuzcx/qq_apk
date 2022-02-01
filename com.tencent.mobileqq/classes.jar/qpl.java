import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class qpl
  implements View.OnClickListener
{
  public qpl(ComponentHeaderFriendRecommend paramComponentHeaderFriendRecommend, List paramList, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ComponentHeaderFriendRecommend.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend, ((Long)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).longValue());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpl
 * JD-Core Version:    0.7.0.1
 */