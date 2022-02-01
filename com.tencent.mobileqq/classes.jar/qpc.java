import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class qpc
  implements pre
{
  public qpc(ComponentContentRecommendFollowList paramComponentContentRecommendFollowList, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentRecommendFollowList", 2, "followPubAccount() onFollowPublicAccount uin=" + paramString + ", isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo.isFollowed = true;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowList.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo);
      ComponentContentRecommendFollowList.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowList).notifyDataSetChanged();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowList.getContext(), 1, 2131717203, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpc
 * JD-Core Version:    0.7.0.1
 */