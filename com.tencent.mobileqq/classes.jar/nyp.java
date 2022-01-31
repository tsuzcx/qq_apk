import android.text.TextUtils;
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

public class nyp
  implements oyl
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new poo();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public nyp(nym paramnym) {}
  
  private View a(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    pbi localpbi = new pbi(this.jdField_a_of_type_Nym.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_Nym.b(), this.jdField_a_of_type_Nym.c(), paramInt2, this.jdField_a_of_type_Nym.a(), this.jdField_a_of_type_Nym.d(), null, this.jdField_a_of_type_Nym.a());
    long l;
    if ((paramView != null) && ((paramView instanceof ProteusItemView)))
    {
      l = System.currentTimeMillis();
      olr.a((ProteusItemView)paramView, paramInt1, paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_Nym.a(), this.jdField_a_of_type_Nym.a(), localpbi, paramInt2, "default_feeds");
      paramView = (ProteusItemView)paramView;
      sai.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.convertview#bindData", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      if ((paramView != null) && (paramView.a() != null))
      {
        paramArticleInfo = this.jdField_a_of_type_Nym.a();
        paramView.a().setTag(2131368790, paramArticleInfo);
        paramView.setTag(2131379208, localpbi);
        paramView.setTag(this);
      }
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_Int = paramInt2;
      return paramView;
      l = System.currentTimeMillis();
      paramView = olr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt1, paramArticleInfo);
      sai.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      olr.a(paramView, paramInt1, paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_Nym.a(), this.jdField_a_of_type_Nym.a(), localpbi, paramInt2, "default_feeds");
      sai.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.newview#bindData", System.currentTimeMillis() - l);
    }
  }
  
  private void a()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_Nym.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_Nym.a());
        olr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
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
  
  private void a(qty paramqty)
  {
    if (paramqty == null) {}
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
      if (localViewBean != null)
      {
        paramqty.o = bawz.a(this.jdField_a_of_type_Nym.a(), 8.0F);
        paramqty.p = bawz.a(this.jdField_a_of_type_Nym.a(), 8.0F);
        paramqty.q = bawz.a(this.jdField_a_of_type_Nym.a(), 8.0F);
        paramqty.r = bawz.a(this.jdField_a_of_type_Nym.a(), 8.0F);
      }
    } while (!((String)localObject).equals("ReadInjoy_ad_video_cell_new_division"));
    paramqty.q = 0;
    paramqty.r = 0;
  }
  
  private View b(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    Object localObject = new pbi(this.jdField_a_of_type_Nym.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_Nym.b(), this.jdField_a_of_type_Nym.c(), paramInt2, this.jdField_a_of_type_Nym.a(), this.jdField_a_of_type_Nym.d(), null, this.jdField_a_of_type_Nym.a());
    View localView = pqq.a(paramInt2, localObject, paramInt1, paramView, this.jdField_a_of_type_Nym.a(), this.jdField_a_of_type_Nym.a(), this.jdField_a_of_type_Nym.a());
    if (localView != null)
    {
      localView.setTag(2131379208, localObject);
      if (QLog.isColorLevel()) {
        QLog.d("AdHandler", 2, "CellFactory.getView = " + localView.getTag().getClass().getSimpleName());
      }
      localView.setTag(2131368790, this.jdField_a_of_type_Nym.a());
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
          break label413;
        }
        paramInt1 = 0;
        label256:
        localObject = this.jdField_a_of_type_Nym.c() + "";
        if (paramArticleInfo == null) {
          break label418;
        }
      }
    }
    label413:
    label418:
    for (paramView = String.valueOf(paramArticleInfo.mArticleID);; paramView = "")
    {
      noo.a(null, "", "0X80095B4", "0X80095B4", 0, paramInt1, (String)localObject, paramView, this.jdField_a_of_type_Nym.b() + "", "", false);
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
  
  public qty a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    rap localrap;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localObject1 = localObject2;
      if ((this.jdField_a_of_type_AndroidViewView instanceof ProteusItemView))
      {
        localObject1 = (pbi)this.jdField_a_of_type_AndroidViewView.getTag(2131379208);
        if (localObject1 == null) {
          break label124;
        }
        localObject2 = ((pbi)localObject1).a();
        if ((!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) || ((((pbi)localObject1).a() != 6) && (((pbi)localObject1).a() != 66) && (((pbi)localObject1).a() != 115))) {
          break label124;
        }
        localObject2 = (AdvertisementInfo)localObject2;
        localrap = this.jdField_a_of_type_Nym.a();
        if ((localrap == null) || (localrap.a() == null)) {
          break label124;
        }
      }
    }
    label124:
    for (localObject1 = localrap.a().a((AdvertisementInfo)localObject2, this.jdField_a_of_type_AndroidViewView, (pbi)localObject1);; localObject1 = null)
    {
      a((qty)localObject1);
      return localObject1;
    }
  }
  
  public boolean a(View paramView)
  {
    Object localObject;
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ProteusItemView)))
    {
      paramView = (pbi)this.jdField_a_of_type_AndroidViewView.getTag(2131379208);
      if (paramView != null)
      {
        localObject = paramView.a();
        if ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && ((paramView.a() == 6) || (paramView.a() == 66) || (paramView.a() == 115)))
        {
          localObject = (AdvertisementInfo)localObject;
          if (!TextUtils.isEmpty(sht.a((ArticleInfo)localObject, "AdsIconText"))) {
            break label93;
          }
        }
      }
    }
    label93:
    rap localrap;
    do
    {
      return false;
      localrap = this.jdField_a_of_type_Nym.a();
    } while ((localrap == null) || (localrap.a() == null));
    paramView = localrap.a().a((AdvertisementInfo)localObject, this.jdField_a_of_type_AndroidViewView, paramView);
    if ((oat.a((AdvertisementInfo)localObject, null, localrap.a(), 1)) && (localrap.a().a(paramView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyp
 * JD-Core Version:    0.7.0.1
 */