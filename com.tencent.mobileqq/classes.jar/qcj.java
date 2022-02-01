import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class qcj
  implements pre
{
  qcj(qcf paramqcf, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "followPubAccount() onFollowPublicAccount uin=" + paramString + ", isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo.isFollowed = true;
      qcf.a(this.jdField_a_of_type_Qcf, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo);
      qcf.a(this.jdField_a_of_type_Qcf).notifyDataSetChanged();
      return;
    }
    QQToast.a(qcf.b(this.jdField_a_of_type_Qcf).getContext(), 1, 2131717203, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qcj
 * JD-Core Version:    0.7.0.1
 */