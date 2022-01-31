import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

class nne
  implements omw
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new pcw();
  private volatile boolean jdField_a_of_type_Boolean;
  
  private nne(nnb paramnnb) {}
  
  private View a(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    oqh localoqh = new oqh(this.jdField_a_of_type_Nnb.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_Nnb.b(), this.jdField_a_of_type_Nnb.c(), paramInt2, this.jdField_a_of_type_Nnb.a(), this.jdField_a_of_type_Nnb.d(), null, this.jdField_a_of_type_Nnb.a());
    long l;
    if ((paramView != null) && ((paramView instanceof ProteusItemView)))
    {
      l = System.currentTimeMillis();
      oag.a((ProteusItemView)paramView, paramInt1, paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_Nnb.a(), this.jdField_a_of_type_Nnb.a(), localoqh, paramInt2, "default_feeds");
      paramView = (ProteusItemView)paramView;
      rnr.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.convertview#bindData", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      if ((paramView != null) && (paramView.a() != null))
      {
        paramArticleInfo = this.jdField_a_of_type_Nnb.a();
        paramView.a().setTag(2131303150, paramArticleInfo);
        paramView.setTag(2131313373, localoqh);
        paramView.setTag(this);
      }
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_Int = paramInt2;
      return paramView;
      l = System.currentTimeMillis();
      paramView = oag.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt1, paramArticleInfo);
      rnr.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      oag.a(paramView, paramInt1, paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_Nnb.a(), this.jdField_a_of_type_Nnb.a(), localoqh, paramInt2, "default_feeds");
      rnr.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.newview#bindData", System.currentTimeMillis() - l);
    }
  }
  
  private void a()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_Nnb.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_Nnb.a());
        oag.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
        this.jdField_a_of_type_Boolean = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(qht paramqht)
  {
    if (paramqht == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = ((ProteusItemView)this.jdField_a_of_type_AndroidViewView).a();
      } while (localObject == null);
      ViewBean localViewBean = ((TemplateBean)localObject).findViewById("id_top_left_mask");
      localObject = ((TemplateBean)localObject).getStyleName();
      if (localViewBean != null) {
        paramqht.d = true;
      }
    } while (!((String)localObject).equals("ReadInjoy_ad_video_cell_new_division"));
    paramqht.e = true;
  }
  
  private View b(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    Object localObject = new oqh(this.jdField_a_of_type_Nnb.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_Nnb.b(), this.jdField_a_of_type_Nnb.c(), paramInt2, this.jdField_a_of_type_Nnb.a(), this.jdField_a_of_type_Nnb.d(), null, this.jdField_a_of_type_Nnb.a());
    View localView = pew.a(paramInt2, localObject, paramInt1, paramView, this.jdField_a_of_type_Nnb.a(), this.jdField_a_of_type_Nnb.a(), this.jdField_a_of_type_Nnb.a());
    if (localView != null)
    {
      localView.setTag(2131313373, localObject);
      if (QLog.isColorLevel()) {
        QLog.d("AdHandler", 2, "CellFactory.getView = " + localView.getTag().getClass().getSimpleName());
      }
      localView.setTag(2131303150, this.jdField_a_of_type_Nnb.a());
      if (paramArticleInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdHandler", 2, "getView() article is null, set view gone, position: " + paramInt2);
        }
        if (localView.getVisibility() != 8) {
          localView.setVisibility(8);
        }
        if ((localView.getLayoutParams() instanceof AbsListView.LayoutParams))
        {
          paramView = (AbsListView.LayoutParams)localView.getLayoutParams();
          if (paramView.height != 1)
          {
            paramView.height = 1;
            localView.setLayoutParams(paramView);
          }
        }
        if (localView != null) {
          break label410;
        }
        paramInt1 = 0;
        label256:
        localObject = this.jdField_a_of_type_Nnb.c() + "";
        if (paramArticleInfo == null) {
          break label415;
        }
      }
    }
    label410:
    label415:
    for (paramView = String.valueOf(paramArticleInfo.mArticleID);; paramView = "")
    {
      ndn.a(null, "", "0X80095B4", "0X80095B4", 0, paramInt1, (String)localObject, paramView, this.jdField_a_of_type_Nnb.b() + "", "", false);
      return localView;
      if (localView.getVisibility() != 0) {
        localView.setVisibility(0);
      }
      if (!(localView.getLayoutParams() instanceof AbsListView.LayoutParams)) {
        break;
      }
      paramView = (AbsListView.LayoutParams)localView.getLayoutParams();
      if (paramView.height == -2) {
        break;
      }
      paramView.height = -2;
      localView.setLayoutParams(paramView);
      break;
      QLog.w("AdHandler", 1, "CellFactory.getView = null");
      break;
      paramInt1 = 1;
      break label256;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public qht a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    qoe localqoe;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localObject1 = localObject2;
      if ((this.jdField_a_of_type_AndroidViewView instanceof ProteusItemView))
      {
        localObject1 = (oqh)this.jdField_a_of_type_AndroidViewView.getTag(2131313373);
        if (localObject1 == null) {
          break label124;
        }
        localObject2 = ((oqh)localObject1).a();
        if ((!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) || ((((oqh)localObject1).a() != 6) && (((oqh)localObject1).a() != 66) && (((oqh)localObject1).a() != 115))) {
          break label124;
        }
        localObject2 = (AdvertisementInfo)localObject2;
        localqoe = this.jdField_a_of_type_Nnb.a();
        if ((localqoe == null) || (localqoe.a() == null)) {
          break label124;
        }
      }
    }
    label124:
    for (localObject1 = localqoe.a().a((AdvertisementInfo)localObject2, this.jdField_a_of_type_AndroidViewView, (oqh)localObject1);; localObject1 = null)
    {
      a((qht)localObject1);
      return localObject1;
    }
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ProteusItemView)))
    {
      paramView = (oqh)this.jdField_a_of_type_AndroidViewView.getTag(2131313373);
      if (paramView != null)
      {
        Object localObject = paramView.a();
        if ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && ((paramView.a() == 6) || (paramView.a() == 66) || (paramView.a() == 115)))
        {
          localObject = (AdvertisementInfo)localObject;
          qoe localqoe = this.jdField_a_of_type_Nnb.a();
          if ((localqoe != null) && (localqoe.a() != null))
          {
            paramView = localqoe.a().a((AdvertisementInfo)localObject, this.jdField_a_of_type_AndroidViewView, paramView);
            return (npi.a((AdvertisementInfo)localObject, null, localqoe.a(), 1)) && (localqoe.a().a(paramView));
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nne
 * JD-Core Version:    0.7.0.1
 */