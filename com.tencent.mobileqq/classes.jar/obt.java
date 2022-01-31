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

public class obt
  implements pdn
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new put();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public obt(obq paramobq) {}
  
  private View a(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    pgq localpgq = new pgq(this.jdField_a_of_type_Obq.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_Obq.b(), this.jdField_a_of_type_Obq.c(), paramInt2, this.jdField_a_of_type_Obq.a(), this.jdField_a_of_type_Obq.d(), null, this.jdField_a_of_type_Obq.a());
    long l;
    if ((paramView != null) && ((paramView instanceof ProteusItemView)))
    {
      l = System.currentTimeMillis();
      opy.a((ProteusItemView)paramView, paramInt1, paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_Obq.a(), this.jdField_a_of_type_Obq.a(), localpgq, paramInt2, "default_feeds");
      paramView = (ProteusItemView)paramView;
      srq.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.convertview#bindData", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      if ((paramView != null) && (paramView.a() != null))
      {
        paramArticleInfo = this.jdField_a_of_type_Obq.a();
        paramView.a().setTag(2131369027, paramArticleInfo);
        paramView.setTag(2131379971, localpgq);
        paramView.setTag(this);
      }
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_Int = paramInt2;
      return paramView;
      l = System.currentTimeMillis();
      paramView = opy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt1, paramArticleInfo);
      srq.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      opy.a(paramView, paramInt1, paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_Obq.a(), this.jdField_a_of_type_Obq.a(), localpgq, paramInt2, "default_feeds");
      srq.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.newview#bindData", System.currentTimeMillis() - l);
    }
  }
  
  private void a()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_Obq.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_Obq.a());
        opy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
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
  
  private void a(rjk paramrjk)
  {
    if (paramrjk == null) {}
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
        paramrjk.o = bdaq.a(this.jdField_a_of_type_Obq.a(), 8.0F);
        paramrjk.p = bdaq.a(this.jdField_a_of_type_Obq.a(), 8.0F);
        paramrjk.q = bdaq.a(this.jdField_a_of_type_Obq.a(), 8.0F);
        paramrjk.r = bdaq.a(this.jdField_a_of_type_Obq.a(), 8.0F);
      }
    } while (!((String)localObject).equals("ReadInjoy_ad_video_cell_new_division"));
    paramrjk.q = 0;
    paramrjk.r = 0;
  }
  
  private View b(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    Object localObject = new pgq(this.jdField_a_of_type_Obq.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_Obq.b(), this.jdField_a_of_type_Obq.c(), paramInt2, this.jdField_a_of_type_Obq.a(), this.jdField_a_of_type_Obq.d(), null, this.jdField_a_of_type_Obq.a());
    View localView = pxi.a(paramInt2, localObject, paramInt1, paramView, this.jdField_a_of_type_Obq.a(), this.jdField_a_of_type_Obq.a(), this.jdField_a_of_type_Obq.a());
    if (localView != null)
    {
      localView.setTag(2131379971, localObject);
      if (QLog.isColorLevel()) {
        QLog.d("AdHandler", 2, "CellFactory.getView = " + localView.getTag().getClass().getSimpleName());
      }
      localView.setTag(2131369027, this.jdField_a_of_type_Obq.a());
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
        localObject = this.jdField_a_of_type_Obq.c() + "";
        if (paramArticleInfo == null) {
          break label418;
        }
      }
    }
    label413:
    label418:
    for (paramView = String.valueOf(paramArticleInfo.mArticleID);; paramView = "")
    {
      nrt.a(null, "", "0X80095B4", "0X80095B4", 0, paramInt1, (String)localObject, paramView, this.jdField_a_of_type_Obq.b() + "", "", false);
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
  
  public rjk a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    rqj localrqj;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localObject1 = localObject2;
      if ((this.jdField_a_of_type_AndroidViewView instanceof ProteusItemView))
      {
        localObject1 = (pgq)this.jdField_a_of_type_AndroidViewView.getTag(2131379971);
        if (localObject1 == null) {
          break label124;
        }
        localObject2 = ((pgq)localObject1).a();
        if ((!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) || ((((pgq)localObject1).a() != 6) && (((pgq)localObject1).a() != 66) && (((pgq)localObject1).a() != 115))) {
          break label124;
        }
        localObject2 = (AdvertisementInfo)localObject2;
        localrqj = this.jdField_a_of_type_Obq.a();
        if ((localrqj == null) || (localrqj.a() == null)) {
          break label124;
        }
      }
    }
    label124:
    for (localObject1 = localrqj.a().a((AdvertisementInfo)localObject2, this.jdField_a_of_type_AndroidViewView, (pgq)localObject1);; localObject1 = null)
    {
      a((rjk)localObject1);
      return localObject1;
    }
  }
  
  public boolean a(View paramView)
  {
    Object localObject;
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ProteusItemView)))
    {
      paramView = (pgq)this.jdField_a_of_type_AndroidViewView.getTag(2131379971);
      if (paramView != null)
      {
        localObject = paramView.a();
        if ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && ((paramView.a() == 6) || (paramView.a() == 66) || (paramView.a() == 115)))
        {
          localObject = (AdvertisementInfo)localObject;
          if (!TextUtils.isEmpty(szl.a((ArticleInfo)localObject, "AdsIconText"))) {
            break label93;
          }
        }
      }
    }
    label93:
    rqj localrqj;
    do
    {
      return false;
      localrqj = this.jdField_a_of_type_Obq.a();
    } while ((localrqj == null) || (localrqj.a() == null));
    paramView = localrqj.a().a((AdvertisementInfo)localObject, this.jdField_a_of_type_AndroidViewView, paramView);
    if ((oed.a((AdvertisementInfo)localObject, null, localrqj.a(), 1)) && (localrqj.a().a(paramView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     obt
 * JD-Core Version:    0.7.0.1
 */