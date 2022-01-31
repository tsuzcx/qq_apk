import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;

public class lvq
  implements UserOperationModule.Ox978RespCallBack
{
  public lvq(ComponentHeaderPolymeric paramComponentHeaderPolymeric, TopicRecommendFeedsInfo.TopicRecommendInfo paramTopicRecommendInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 2))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo$TopicRecommendInfo.c = 1;
      ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric).setEnabled(false);
      ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric).setText("已关注");
      ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric).setTextColor(-4473925);
      ThreadManager.post(new lvr(this), 5, null, true);
      return;
    }
    ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric).setEnabled(true);
    ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric).setText("关注");
    ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric).setTextColor(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric.getResources().getColor(2131493399));
    QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric.getContext(), "关注失败", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lvq
 * JD-Core Version:    0.7.0.1
 */