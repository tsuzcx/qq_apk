import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;

class plq
  implements pbx
{
  plq(plm paramplm, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "followPubAccount() onFollowPublicAccount uin=" + paramString + ", isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo.isFollowed = true;
      plm.a(this.jdField_a_of_type_Plm, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo);
      plm.a(this.jdField_a_of_type_Plm).notifyDataSetChanged();
      return;
    }
    bcql.a(plm.b(this.jdField_a_of_type_Plm).getContext(), 1, 2131718513, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     plq
 * JD-Core Version:    0.7.0.1
 */