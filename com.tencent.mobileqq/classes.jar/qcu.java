import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class qcu
  implements phj
{
  public qcu(ComponentContentRecommend paramComponentContentRecommend, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d(ComponentContentRecommend.a, 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
    }
    if (paramBoolean)
    {
      paramString = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo;
      if (paramInt == 2) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramString.isFollowed = paramBoolean;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommend.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo);
        ComponentContentRecommend.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommend).notifyDataSetChanged();
        return;
      }
    }
    QQToast.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommend.getContext(), 1, 2131718961, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qcu
 * JD-Core Version:    0.7.0.1
 */