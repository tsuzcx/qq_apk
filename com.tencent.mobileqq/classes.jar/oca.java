import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class oca
  extends sah
{
  private ProteusItemData jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  
  public oca(obz paramobz, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    if ((paramView instanceof Container)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = ((Container)paramView);
    }
  }
  
  private void a(BaseData paramBaseData, Context paramContext, JSONObject paramJSONObject)
  {
    paramJSONObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView();
    ViewFactory.findClickableViewListener(paramJSONObject, new ocb(this, paramContext, paramBaseData, paramJSONObject));
  }
  
  private void a(Container paramContainer, ProteusItemData paramProteusItemData)
  {
    if (paramContainer != null)
    {
      ViewBase localViewBase = paramContainer.getVirtualView();
      Object localObject = localViewBase.findViewBaseByName("id_view_AdDownloadView");
      if ((localObject != null) && ((localObject instanceof ogy)))
      {
        localObject = (ogy)localObject;
        ((ogy)localObject).b(false);
        ((ogy)localObject).a(false);
        ((ogy)localObject).a(null, true);
      }
      if (((paramProteusItemData instanceof AdData)) && (((AdData)paramProteusItemData).a != null) && (odv.a((AdData)paramProteusItemData)))
      {
        localObject = localViewBase.findViewBaseByName("id_inner_small_img");
        if ((localObject != null) && ((localObject instanceof psj)) && (((AdData)paramProteusItemData).a.a != null) && (!TextUtils.isEmpty(((AdData)paramProteusItemData).a.k))) {
          odv.a(paramContainer.getContext(), (ViewBase)localObject, ((AdData)paramProteusItemData).a.k, 10);
        }
        localObject = localViewBase.findViewBaseByName("id_inner_game_img1");
        if ((localObject != null) && ((localObject instanceof psj)) && (((AdData)paramProteusItemData).a.a != null) && (!TextUtils.isEmpty(((AdData)paramProteusItemData).a.a.d))) {
          odv.a(paramContainer.getContext(), (ViewBase)localObject, ((AdData)paramProteusItemData).a.a.d, 10);
        }
        localObject = localViewBase.findViewBaseByName("id_inner_game_img2");
        if ((localObject != null) && ((localObject instanceof psj)) && (((AdData)paramProteusItemData).a.a != null) && (!TextUtils.isEmpty(((AdData)paramProteusItemData).a.a.e))) {
          odv.a(paramContainer.getContext(), (ViewBase)localObject, ((AdData)paramProteusItemData).a.a.e, 10);
        }
        localViewBase = localViewBase.findViewBaseByName("id_inner_game_img3");
        if ((localViewBase != null) && ((localViewBase instanceof psj)) && (((AdData)paramProteusItemData).a.a != null) && (!TextUtils.isEmpty(((AdData)paramProteusItemData).a.a.f))) {
          odv.a(paramContainer.getContext(), localViewBase, ((AdData)paramProteusItemData).a.a.f, 10);
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
    } while ((paramViewBase == null) || (!(paramViewBase instanceof ogy)));
    ((ogy)paramViewBase).a(false);
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
    if (paramBaseData1 != paramBaseData2) {}
    try
    {
      localTemplateBean.bindData(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.c);
      opy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.a.getViewBean());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData;
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData);
      if (obz.a(this.jdField_a_of_type_Obz) != null) {
        a(paramBaseData2, (Context)obz.a(this.jdField_a_of_type_Obz).get(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataProteusItemData.c);
      }
      this.jdField_a_of_type_AndroidViewView.setTag(2131362036, paramBaseData2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oca
 * JD-Core Version:    0.7.0.1
 */