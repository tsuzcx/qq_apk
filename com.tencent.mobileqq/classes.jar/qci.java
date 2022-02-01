import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class qci
  implements pre
{
  qci(qcf paramqcf, RecommendFollowInfo paramRecommendFollowInfo) {}
  
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
        qcf.a(this.jdField_a_of_type_Qcf, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo);
        qcf.a(this.jdField_a_of_type_Qcf).notifyDataSetChanged();
        return;
      }
    }
    QQToast.a(qcf.a(this.jdField_a_of_type_Qcf).getContext(), 1, 2131717203, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qci
 * JD-Core Version:    0.7.0.1
 */