import com.tencent.biz.pubaccount.readinjoy.skin.CommonSkinRes;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshRes;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;

public class mhh
  implements Runnable
{
  public mhh(ReadInJoyListViewGroup paramReadInJoyListViewGroup, RefreshData paramRefreshData, ReadInJoyRefreshManager paramReadInJoyRefreshManager, SkinData paramSkinData, ReadInJoySkinManager paramReadInJoySkinManager) {}
  
  public void run()
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData != null) && (i >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.beginTime) && (i <= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.endTime) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.isShown) && (RefreshRes.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.id)) && (RefreshRes.a() != 0))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyRefreshManager.a(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinRefreshData.id);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoyRefreshManager.a(true);
      RefreshRes.a();
      ReadInJoyListViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup).sendEmptyMessage(1);
    }
    while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinSkinData == null) || (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinSkinData.beginTime) || (i > this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinSkinData.endTime) || (!CommonSkinRes.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinSkinData.id)) || (CommonSkinRes.b() == 0)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinReadInJoySkinManager.a(1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinSkinData.id);
    CommonSkinRes.a();
    ReadInJoyListViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup).sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhh
 * JD-Core Version:    0.7.0.1
 */