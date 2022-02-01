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

public class onj
  implements puj
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = new qmv();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public onj(ong paramong) {}
  
  private View a(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    pya localpya = new pya(this.jdField_a_of_type_Ong.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_Ong.b(), this.jdField_a_of_type_Ong.c(), paramInt2, this.jdField_a_of_type_Ong.a(), this.jdField_a_of_type_Ong.d(), null, this.jdField_a_of_type_Ong.a());
    long l;
    if ((paramView != null) && ((paramView instanceof ProteusItemView)))
    {
      l = System.currentTimeMillis();
      pfr.a((ProteusItemView)paramView, paramInt1, paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_Ong.a(), this.jdField_a_of_type_Ong.a(), localpya, paramInt2, "default_feeds");
      paramView = (ProteusItemView)paramView;
      ttf.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.convertview#bindData", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      if ((paramView != null) && (paramView.a() != null))
      {
        paramArticleInfo = this.jdField_a_of_type_Ong.a();
        paramView.a().setTag(2131369412, paramArticleInfo);
        paramView.setTag(2131380929, localpya);
        paramView.setTag(this);
      }
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.jdField_a_of_type_Int = paramInt2;
      return paramView;
      l = System.currentTimeMillis();
      paramView = pfr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt1, paramArticleInfo);
      ttf.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      pfr.a(paramView, paramInt1, paramArticleInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_Ong.a(), this.jdField_a_of_type_Ong.a(), localpya, paramInt2, "default_feeds");
      ttf.a("AdHandler", String.valueOf(paramInt1), "getProteusNormalView.newview#bindData", System.currentTimeMillis() - l);
    }
  }
  
  private void a()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setContext(this.jdField_a_of_type_Ong.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext.setCurActivity(this.jdField_a_of_type_Ong.a());
        pfr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, "default_feeds");
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
  
  private void a(sey paramsey)
  {
    if (paramsey == null) {}
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
        paramsey.o = bggq.a(this.jdField_a_of_type_Ong.a(), 8.0F);
        paramsey.p = bggq.a(this.jdField_a_of_type_Ong.a(), 8.0F);
        paramsey.q = bggq.a(this.jdField_a_of_type_Ong.a(), 8.0F);
        paramsey.r = bggq.a(this.jdField_a_of_type_Ong.a(), 8.0F);
      }
    } while (!((String)localObject).equals("ReadInjoy_ad_video_cell_new_division"));
    paramsey.q = 0;
    paramsey.r = 0;
  }
  
  private View b(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    Object localObject = new pya(this.jdField_a_of_type_Ong.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_Ong.b(), this.jdField_a_of_type_Ong.c(), paramInt2, this.jdField_a_of_type_Ong.a(), this.jdField_a_of_type_Ong.d(), null, this.jdField_a_of_type_Ong.a());
    View localView = qqq.a(paramInt2, localObject, paramInt1, paramView, this.jdField_a_of_type_Ong.a(), this.jdField_a_of_type_Ong.a(), this.jdField_a_of_type_Ong.a());
    if (localView != null)
    {
      localView.setTag(2131380929, localObject);
      if (QLog.isColorLevel()) {
        QLog.d("AdHandler", 2, "CellFactory.getView = " + localView.getTag().getClass().getSimpleName());
      }
      localView.setTag(2131369412, this.jdField_a_of_type_Ong.a());
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
        localObject = this.jdField_a_of_type_Ong.c() + "";
        if (paramArticleInfo == null) {
          break label418;
        }
      }
    }
    label413:
    label418:
    for (paramView = String.valueOf(paramArticleInfo.mArticleID);; paramView = "")
    {
      oat.a(null, "", "0X80095B4", "0X80095B4", 0, paramInt1, (String)localObject, paramView, this.jdField_a_of_type_Ong.b() + "", "", false);
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
  
  public sey a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    snh localsnh;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localObject1 = localObject2;
      if ((this.jdField_a_of_type_AndroidViewView instanceof ProteusItemView))
      {
        localObject1 = (pya)this.jdField_a_of_type_AndroidViewView.getTag(2131380929);
        if (localObject1 == null) {
          break label124;
        }
        localObject2 = ((pya)localObject1).a();
        if ((!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject2)) || ((((pya)localObject1).a() != 6) && (((pya)localObject1).a() != 66) && (((pya)localObject1).a() != 115))) {
          break label124;
        }
        localObject2 = (AdvertisementInfo)localObject2;
        localsnh = this.jdField_a_of_type_Ong.a();
        if ((localsnh == null) || (localsnh.a() == null)) {
          break label124;
        }
      }
    }
    label124:
    for (localObject1 = localsnh.a().a((AdvertisementInfo)localObject2, this.jdField_a_of_type_AndroidViewView, (pya)localObject1);; localObject1 = null)
    {
      a((sey)localObject1);
      return localObject1;
    }
  }
  
  public boolean a(View paramView)
  {
    Object localObject;
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof ProteusItemView)))
    {
      paramView = (pya)this.jdField_a_of_type_AndroidViewView.getTag(2131380929);
      if (paramView != null)
      {
        localObject = paramView.a();
        if ((AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && ((paramView.a() == 6) || (paramView.a() == 66) || (paramView.a() == 115)))
        {
          localObject = (AdvertisementInfo)localObject;
          if (!TextUtils.isEmpty(ubb.a((ArticleInfo)localObject, "AdsIconText"))) {
            break label93;
          }
        }
      }
    }
    label93:
    snh localsnh;
    do
    {
      return false;
      localsnh = this.jdField_a_of_type_Ong.a();
    } while ((localsnh == null) || (localsnh.a() == null));
    paramView = localsnh.a().a((AdvertisementInfo)localObject, this.jdField_a_of_type_AndroidViewView, paramView);
    if ((oqi.a((AdvertisementInfo)localObject, null, localsnh.a(), 1)) && (localsnh.a().a(paramView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     onj
 * JD-Core Version:    0.7.0.1
 */