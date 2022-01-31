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
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import org.json.JSONObject;

class nzc
  extends rkg
{
  private ReadInJoyArticleBottomVideoView jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView;
  private ProteusItemData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  
  public nzc(nzb paramnzb, View paramView, BaseData paramBaseData)
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
    ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new nzd(this, paramBaseData, paramContext));
  }
  
  private void a(Container paramContainer)
  {
    if (paramContainer != null)
    {
      ViewBase localViewBase1 = paramContainer.getVirtualView();
      ViewBase localViewBase2 = localViewBase1.findViewBaseByName("id_view_AdDownloadView");
      if ((localViewBase2 != null) && ((localViewBase2 instanceof odd))) {
        ((odd)localViewBase2).a(null, true);
      }
      if (((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData instanceof AdData)) && (((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData).a != null) && (oai.a((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData)))
      {
        localViewBase1 = localViewBase1.findViewBaseByName("id_game_small_img");
        if ((localViewBase1 != null) && ((localViewBase1 instanceof pme)) && (!TextUtils.isEmpty(((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData).J)))
        {
          int i = actj.a(40.0F, paramContainer.getContext().getResources());
          oai.a(paramContainer.getContext(), localViewBase1, ((AdData)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData).J, 10, i, i);
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
      nlq localnlq = new nlq();
      AdvertisementInfo localAdvertisementInfo = oas.a(paramProteusBannerVideoItemData1);
      localnlq.e = paramProteusBannerVideoItemData1.l;
      localnlq.d = paramProteusBannerVideoItemData1.w;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdViewReadInJoyArticleBottomVideoView.a(localnlq, localAdvertisementInfo, paramProteusBannerVideoItemData1, paramProteusBannerVideoItemData2);
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
      localTemplateBean.getViewBean().bindData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.b, localTemplateBean.getViewDataBinding());
      olo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.a.getViewBean());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
      if ((paramBaseData1 != null) && (paramBaseData1.p == 17))
      {
        paramBaseData1 = (ProteusBannerVideoItemData)paramBaseData1;
        a((ProteusBannerVideoItemData)paramBaseData2, paramBaseData1);
        a(paramBaseData2, nzb.a(this.jdField_a_of_type_Nzb), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.b);
        this.jdField_a_of_type_AndroidViewView.setTag(2131362033, paramBaseData2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzc
 * JD-Core Version:    0.7.0.1
 */