import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class ooe
  extends onq
{
  private ReadInJoyArticleBottomVideoView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView;
  private qkl jdField_a_of_type_Qkl;
  private qkq jdField_a_of_type_Qkq;
  
  public ooe(View paramView, BaseData paramBaseData, WeakReference<Context> paramWeakReference)
  {
    super(paramBaseData, paramWeakReference, localWeakReference);
    if ((paramBaseData != null) && (((Container)paramBaseData).getVirtualView() != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView = ((ReadInJoyArticleBottomVideoView)((Container)paramBaseData).getVirtualView().findViewBaseByName("id_ad_banner_bottom_video"));
    }
    try
    {
      this.jdField_a_of_type_Qkl = ((qkl)((Container)paramBaseData).getVirtualView().findViewBaseByName("id_ad_title_mask"));
      this.jdField_a_of_type_Qkq = ((qkq)((Container)paramBaseData).getVirtualView().findViewBaseByName("id_tv_title_inner"));
      return;
    }
    catch (Exception paramView)
    {
      oqh.a("WebFastProteusViewAdBannerVideoCreator", "ProteusItemViewHolder create error: " + paramView.getMessage());
    }
  }
  
  private void a(ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    if ((paramProteusBannerVideoItemData1 == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView.setVisibility(0);
      nxm localnxm = new nxm();
      AdvertisementInfo localAdvertisementInfo = oqk.a(paramProteusBannerVideoItemData1);
      localnxm.e = paramProteusBannerVideoItemData1.l;
      localnxm.d = paramProteusBannerVideoItemData1.w;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView.a(localnxm, localAdvertisementInfo, paramProteusBannerVideoItemData1, paramProteusBannerVideoItemData2);
    } while (!paramProteusBannerVideoItemData1.a);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView.s();
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView.j();
    }
  }
  
  protected void a(BaseData paramBaseData, Context paramContext, JSONObject paramJSONObject)
  {
    ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new oof(this, paramBaseData, paramContext));
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2)
  {
    if (!(paramBaseData1 instanceof ProteusBannerVideoItemData)) {
      return;
    }
    if ((paramBaseData2 != null) && (paramBaseData2.t == 17))
    {
      paramBaseData2 = (ProteusBannerVideoItemData)paramBaseData2;
      a((ProteusBannerVideoItemData)paramBaseData1, paramBaseData2);
      return;
    }
    a((ProteusBannerVideoItemData)paramBaseData1, null);
  }
  
  protected boolean a(BaseData paramBaseData1, BaseData paramBaseData2)
  {
    return paramBaseData1 == paramBaseData2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ooe
 * JD-Core Version:    0.7.0.1
 */