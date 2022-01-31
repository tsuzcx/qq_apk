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

public class nym
  implements oyi
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new pol();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public nym(nyj paramnyj) {}
  
  private View a(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    pbf localpbf = new pbf(this.jdField_a_of_type_Nyj.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_Nyj.b(), this.jdField_a_of_type_Nyj.c(), paramInt2, this.jdField_a_of_type_Nyj.a(), this.jdField_a_of_type_Nyj.d(), null, this.jdField_a_of_type_Nyj.a());
    long l;
    if ((paramView != null) && ((paramView instanceof ProteusItemView)))
    {
      l = System.currentTimeMillis();
      olo.a((ProteusItemView)paramView, paramInt1, paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_Nyj.a(), this.jdField_a_of_type_Nyj.a(), localpbf, paramInt2, "default_feeds");
      paramView = (ProteusItemView)paramView;
      saf.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.convertview#bindData", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      if ((paramView != null) && (paramView.a() != null))
      {
        paramArticleInfo = this.jdField_a_of_type_Nyj.a();
        paramView.a().setTag(2131368790, paramArticleInfo);
        paramView.setTag(2131379213, localpbf);
        paramView.setTag(this);
      }
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_Int = paramInt2;
      return paramView;
      l = System.currentTimeMillis();
      paramView = olo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt1, paramArticleInfo);
      saf.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      olo.a(paramView, paramInt1, paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_Nyj.a(), this.jdField_a_of_type_Nyj.a(), localpbf, paramInt2, "default_feeds");
      saf.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.newview#bindData", System.currentTimeMillis() - l);
    }
  }
  
  private void a()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_Nyj.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_Nyj.a());
        olo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
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
  
  private void a(qtv paramqtv)
  {
    if (paramqtv == null) {}
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
        paramqtv.o = baxn.a(this.jdField_a_of_type_Nyj.a(), 8.0F);
        paramqtv.p = baxn.a(this.jdField_a_of_type_Nyj.a(), 8.0F);
        paramqtv.q = baxn.a(this.jdField_a_of_type_Nyj.a(), 8.0F);
        paramqtv.r = baxn.a(this.jdField_a_of_type_Nyj.a(), 8.0F);
      }
    } while (!((String)localObject).equals("ReadInjoy_ad_video_cell_new_division"));
    paramqtv.q = 0;
    paramqtv.r = 0;
  }
  
  private View b(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    Object localObject = new pbf(this.jdField_a_of_type_Nyj.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_Nyj.b(), this.jdField_a_of_type_Nyj.c(), paramInt2, this.jdField_a_of_type_Nyj.a(), this.jdField_a_of_type_Nyj.d(), null, this.jdField_a_of_type_Nyj.a());
    View localView = pqn.a(paramInt2, localObject, paramInt1, paramView, this.jdField_a_of_type_Nyj.a(), this.jdField_a_of_type_Nyj.a(), this.jdField_a_of_type_Nyj.a());
    if (localView != null)
    {
      localView.setTag(2131379213, localObject);
      if (QLog.isColorLevel()) {
        QLog.d("AdHandler", 2, "CellFactory.getView = " + localView.getTag().getClass().getSimpleName());
      }
      localView.setTag(2131368790, this.jdField_a_of_type_Nyj.a());
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
        localObject = this.jdField_a_of_type_Nyj.c() + "";
        if (paramArticleInfo == null) {
          break label418;
        }
      }
    }
    label413:
    label418:
    for (paramView = String.valueOf(paramArticleInfo.mArticleID);; paramView = "")
    {
      nol.a(null, "", "0X80095B4", "0X80095B4", 0, paramInt1, (String)localObject, paramView, this.jdField_a_of_type_Nyj.b() + "", "", false);
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
  
  public qtv a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    ram localram;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localObject1 = localObject2;
      if ((this.jdField_a_of_type_AndroidViewView instanceof ProteusItemView))
      {
        localObject1 = (pbf)this.jdField_a_of_type_AndroidViewView.getTag(2131379213);
        if (localObject1 == null) {
          break label124;
        }
        localObject2 = ((pbf)localObject1).a();
        if ((!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) || ((((pbf)localObject1).a() != 6) && (((pbf)localObject1).a() != 66) && (((pbf)localObject1).a() != 115))) {
          break label124;
        }
        localObject2 = (AdvertisementInfo)localObject2;
        localram = this.jdField_a_of_type_Nyj.a();
        if ((localram == null) || (localram.a() == null)) {
          break label124;
        }
      }
    }
    label124:
    for (localObject1 = localram.a().a((AdvertisementInfo)localObject2, this.jdField_a_of_type_AndroidViewView, (pbf)localObject1);; localObject1 = null)
    {
      a((qtv)localObject1);
      return localObject1;
    }
  }
  
  public boolean a(View paramView)
  {
    Object localObject;
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ProteusItemView)))
    {
      paramView = (pbf)this.jdField_a_of_type_AndroidViewView.getTag(2131379213);
      if (paramView != null)
      {
        localObject = paramView.a();
        if ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && ((paramView.a() == 6) || (paramView.a() == 66) || (paramView.a() == 115)))
        {
          localObject = (AdvertisementInfo)localObject;
          if (!TextUtils.isEmpty(shq.a((ArticleInfo)localObject, "AdsIconText"))) {
            break label93;
          }
        }
      }
    }
    label93:
    ram localram;
    do
    {
      return false;
      localram = this.jdField_a_of_type_Nyj.a();
    } while ((localram == null) || (localram.a() == null));
    paramView = localram.a().a((AdvertisementInfo)localObject, this.jdField_a_of_type_AndroidViewView, paramView);
    if ((oaq.a((AdvertisementInfo)localObject, null, localram.a(), 1)) && (localram.a().a(paramView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nym
 * JD-Core Version:    0.7.0.1
 */