import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class pxd
  implements pbx
{
  public pxd(ComponentHeaderPolymeric paramComponentHeaderPolymeric, ArticleInfo paramArticleInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderPolymeric", 2, "followPubAccount() unfollowUin uin=" + paramString + ", isSuccess=" + paramBoolean + " followStatus = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mPolymericInfo.e);
    }
    if (!paramString.equals(ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric).getTag())) {
      return;
    }
    ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric, true);
    if (paramBoolean)
    {
      ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric, false);
      ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, 1);
      return;
    }
    ComponentHeaderPolymeric.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pxd
 * JD-Core Version:    0.7.0.1
 */