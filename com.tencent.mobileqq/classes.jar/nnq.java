import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusBannerTriplePicItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import org.json.JSONObject;

class nnq
  extends qxr
{
  private ProteusItemData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  
  public nnq(nnp paramnnp, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    if ((paramView instanceof Container)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = ((Container)paramView);
    }
  }
  
  private void a(BaseData paramBaseData, Context paramContext, JSONObject paramJSONObject)
  {
    paramJSONObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView();
    ViewFactory.findClickableViewListener(paramJSONObject, new nnr(this, paramBaseData, paramContext, paramJSONObject));
  }
  
  private void a(Container paramContainer, ProteusItemData paramProteusItemData)
  {
    if (paramContainer != null)
    {
      ViewBase localViewBase = paramContainer.getVirtualView();
      Object localObject = localViewBase.findViewBaseByName("id_view_AdDownloadView");
      if ((localObject != null) && ((localObject instanceof nrw)))
      {
        localObject = (nrw)localObject;
        ((nrw)localObject).a(false);
        ((nrw)localObject).b(false);
        ((nrw)localObject).a(null, true);
      }
      if (((paramProteusItemData instanceof AdData)) && (((AdData)paramProteusItemData).a != null) && (npa.a((AdData)paramProteusItemData)))
      {
        localViewBase = localViewBase.findViewBaseByName("id_game_small_img");
        if ((localViewBase != null) && ((localViewBase instanceof pap)) && (!TextUtils.isEmpty(((AdData)paramProteusItemData).J)))
        {
          int i = aciy.a(40.0F, paramContainer.getContext().getResources());
          npa.a(paramContainer.getContext(), localViewBase, ((AdData)paramProteusItemData).J, 10, i, i);
        }
      }
    }
  }
  
  private void a(ViewBase paramViewBase)
  {
    if (paramViewBase == null) {}
    do
    {
      return;
      paramViewBase = paramViewBase.findViewBaseByName("id_view_AdDownloadView");
    } while ((paramViewBase == null) || (!(paramViewBase instanceof nrw)));
    ((nrw)paramViewBase).a(false);
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
      } while (!(paramBaseData2 instanceof ProteusItemData));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData = ((ProteusItemData)paramBaseData2);
      localTemplateBean = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.a;
    } while (localTemplateBean == null);
    if ((paramBaseData1 == paramBaseData2) && ((paramBaseData2 instanceof ProteusBannerTriplePicItemData))) {
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData);
    }
    if (paramBaseData1 != paramBaseData2) {}
    try
    {
      localTemplateBean.getViewBean().bindData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.b, localTemplateBean.getViewDataBinding());
      oag.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.a.getViewBean());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
      a(paramBaseData2, nnp.a(this.jdField_a_of_type_Nnp), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.b);
      this.jdField_a_of_type_AndroidViewView.setTag(2131296492, paramBaseData2);
      return;
    }
    catch (Exception paramBaseData1)
    {
      for (;;)
      {
        paramBaseData1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nnq
 * JD-Core Version:    0.7.0.1
 */