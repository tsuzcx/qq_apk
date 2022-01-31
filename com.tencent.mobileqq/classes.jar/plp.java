import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;

class plp
  implements pbx
{
  plp(plm paramplm, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
    }
    if (paramBoolean)
    {
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo;
      if (paramInt == 2) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramString.isFollowed = paramBoolean;
        plm.a(this.jdField_a_of_type_Plm, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo);
        plm.a(this.jdField_a_of_type_Plm).notifyDataSetChanged();
        return;
      }
    }
    bcql.a(plm.a(this.jdField_a_of_type_Plm).getContext(), 1, 2131718513, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     plp
 * JD-Core Version:    0.7.0.1
 */