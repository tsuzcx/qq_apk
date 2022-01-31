import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import org.json.JSONObject;

class ocm
  extends sah
{
  private ReadInJoyArticleBottomVideoView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView;
  private ProteusItemData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  
  public ocm(ocl paramocl, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    if ((paramView instanceof Container)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = ((Container)paramView);
    }
    if ((paramView != null) && (((Container)paramView).getVirtualView() != null)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView = ((ReadInJoyArticleBottomVideoView)((Container)paramView).getVirtualView().findViewBaseByName("id_ad_banner_bottom_video"));
    }
  }
  
  private void a(BaseData paramBaseData, Context paramContext, JSONObject paramJSONObject)
  {
    ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new ocn(this, paramBaseData, paramContext));
  }
  
  private void a(Container paramContainer)
  {
    if (paramContainer != null)
    {
      ViewBase localViewBase1 = paramContainer.getVirtualView();
      ViewBase localViewBase2 = localViewBase1.findViewBaseByName("id_view_AdDownloadView");
      if ((localViewBase2 != null) && ((localViewBase2 instanceof ogy))) {
        ((ogy)localViewBase2).a(null, true);
      }
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData instanceof AdData)) && (((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData).a != null) && (odv.a((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData)))
      {
        localViewBase1 = localViewBase1.findViewBaseByName("id_game_small_img");
        if ((localViewBase1 != null) && ((localViewBase1 instanceof psj)) && (!TextUtils.isEmpty(((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData).J)))
        {
          int i = aekt.a(40.0F, paramContainer.getContext().getResources());
          odv.a(paramContainer.getContext(), localViewBase1, ((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData).J, 10, i, i);
        }
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView.j();
    }
  }
  
  public void a(ProteusBannerVideoItemData paramProteusBannerVideoItemData1, ProteusBannerVideoItemData paramProteusBannerVideoItemData2)
  {
    if ((paramProteusBannerVideoItemData1 == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView.setVisibility(0);
      nom localnom = new nom();
      AdvertisementInfo localAdvertisementInfo = oef.a(paramProteusBannerVideoItemData1);
      localnom.e = paramProteusBannerVideoItemData1.l;
      localnom.d = paramProteusBannerVideoItemData1.w;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView.a(localnom, localAdvertisementInfo, paramProteusBannerVideoItemData1, paramProteusBannerVideoItemData2);
    } while (!paramProteusBannerVideoItemData1.a);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView.r();
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null) || (paramBaseData2 == null)) {}
    TemplateBean localTemplateBean;
    do
    {
      do
      {
        return;
      } while (!(paramBaseData2 instanceof ProteusBannerVideoItemData));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData = ((ProteusBannerVideoItemData)paramBaseData2);
      localTemplateBean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.a;
    } while (localTemplateBean == null);
    if (paramBaseData1 == paramBaseData2) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
    }
    if (paramBaseData1 != paramBaseData2) {}
    try
    {
      localTemplateBean.bindData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.c);
      opy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.a.getViewBean());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
      if ((paramBaseData1 != null) && (paramBaseData1.s == 17))
      {
        paramBaseData1 = (ProteusBannerVideoItemData)paramBaseData1;
        a((ProteusBannerVideoItemData)paramBaseData2, paramBaseData1);
        a(paramBaseData2, ocl.a(this.jdField_a_of_type_Ocl), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.c);
        this.jdField_a_of_type_AndroidViewView.setTag(2131362036, paramBaseData2);
        b();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        a((ProteusBannerVideoItemData)paramBaseData2, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ocm
 * JD-Core Version:    0.7.0.1
 */