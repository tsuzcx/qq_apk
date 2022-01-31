import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

public class pdg
{
  private VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  private ppz jdField_a_of_type_Ppz;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public pdg(pde parampde) {}
  
  private View a(View paramView, ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo != null)
    {
      ArkAppMessage localArkAppMessage = ohf.a(paramArticleInfo.mArkAppFeedsInfo);
      if (QLog.isColorLevel()) {
        QLog.d("FrameworkHandler", 2, new Object[] { "getArkAppView, position: ", Integer.valueOf(paramInt), ", articleInfo: ", paramArticleInfo, ", arkAppMessage: ", localArkAppMessage });
      }
      return a(paramArticleInfo, paramView, localArkAppMessage);
    }
    ohf.b(paramView);
    return paramView;
  }
  
  private View a(View paramView, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    Object localObject = new pgq(this.jdField_a_of_type_Pde.a(), paramArticleInfo, paramInt1, this.jdField_a_of_type_Pde.b(), this.jdField_a_of_type_Pde.c(), paramInt2, this.jdField_a_of_type_Pde.a(), this.jdField_a_of_type_Pde.d(), null, this.jdField_a_of_type_Pde.a());
    View localView = pxi.a(paramInt2, localObject, paramInt1, paramView, this.jdField_a_of_type_Pde.a(), this.jdField_a_of_type_Pde.a(), this.jdField_a_of_type_Pde.a());
    if (localView != null)
    {
      localView.setTag(2131379971, localObject);
      if (QLog.isColorLevel()) {
        QLog.d("FrameworkHandler", 2, "CellFactory.getView = " + localView.getTag().getClass().getSimpleName());
      }
      localView.setTag(2131369027, this.jdField_a_of_type_Pde.a());
      if (paramArticleInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FrameworkHandler", 2, "getView() article is null, set view gone, position: " + paramInt2);
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
        localObject = this.jdField_a_of_type_Pde.c() + "";
        if (paramArticleInfo == null) {
          break label415;
        }
      }
    }
    label410:
    label415:
    for (paramView = String.valueOf(paramArticleInfo.mArticleID);; paramView = "")
    {
      nrt.a(null, "", "0X80095B4", "0X80095B4", 0, paramInt1, (String)localObject, paramView, this.jdField_a_of_type_Pde.b() + "", "", false);
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
      QLog.w("FrameworkHandler", 1, "CellFactory.getView = null");
      break;
      paramInt1 = 1;
      break label256;
    }
  }
  
  private View a(View paramView, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, int paramInt1, int paramInt2)
  {
    paramArticleInfo2 = new pgq(this.jdField_a_of_type_Pde.a(), paramArticleInfo1, paramInt1, this.jdField_a_of_type_Pde.b(), this.jdField_a_of_type_Pde.c(), paramInt2, this.jdField_a_of_type_Pde.a(), this.jdField_a_of_type_Pde.d(), paramArticleInfo2, this.jdField_a_of_type_Pde.a());
    paramArticleInfo2.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext);
    long l;
    if ((paramView != null) && ((paramView instanceof ProteusItemView)))
    {
      l = System.currentTimeMillis();
      opy.a((ProteusItemView)paramView, paramInt1, paramArticleInfo1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_Pde.a(), this.jdField_a_of_type_Pde.a(), paramArticleInfo2, paramInt2, "default_feeds");
      paramView = (ProteusItemView)paramView;
      srq.a("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.convertview#bindData", System.currentTimeMillis() - l);
    }
    for (;;)
    {
      if ((paramView != null) && (paramView.a() != null))
      {
        l = System.currentTimeMillis();
        paramArticleInfo1 = this.jdField_a_of_type_Pde.a();
        paramView.a().setTag(2131369027, paramArticleInfo1);
        paramView.setTag(2131379971, paramArticleInfo2);
        srq.a("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.setTag", System.currentTimeMillis() - l);
      }
      return paramView;
      l = System.currentTimeMillis();
      paramView = opy.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt1, paramArticleInfo1);
      srq.a("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      opy.a(paramView, paramInt1, paramArticleInfo1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_Pde.a(), this.jdField_a_of_type_Pde.a(), paramArticleInfo2, paramInt2, "default_feeds");
      srq.a("FrameworkHandler", String.valueOf(paramInt1), "getProteusNormalView.newview#bindData", System.currentTimeMillis() - l);
    }
  }
  
  private View a(BaseArticleInfo paramBaseArticleInfo, View paramView, ArkAppMessage paramArkAppMessage)
  {
    Object localObject2;
    if (paramBaseArticleInfo == null)
    {
      localObject2 = paramView;
      return localObject2;
    }
    Object localObject1;
    if ((paramView != null) && ((paramView.getTag() instanceof ohd))) {
      localObject1 = (ohd)paramView.getTag();
    }
    for (;;)
    {
      localObject2 = paramView;
      if (localObject1 == null) {
        break;
      }
      localObject2 = paramView;
      if (paramView == null) {
        break;
      }
      if (!ohf.a(paramArkAppMessage)) {
        break label127;
      }
      ((ohd)localObject1).a(paramArkAppMessage, paramBaseArticleInfo);
      ((ohd)localObject1).a();
      ohf.a(paramView);
      return paramView;
      localObject2 = new ohd(paramArkAppMessage, paramBaseArticleInfo);
      ohf.a((ohd)localObject2, this.jdField_a_of_type_Pde.b());
      localObject1 = localObject2;
      if (((ohd)localObject2).a() != null)
      {
        paramView = ((ohd)localObject2).a();
        paramView.setTag(localObject2);
        localObject1 = localObject2;
      }
    }
    label127:
    ohf.a(paramArkAppMessage, 0);
    ohf.b(paramView);
    return paramView;
  }
  
  private View b(View paramView, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2, int paramInt1, int paramInt2)
  {
    paramArticleInfo2 = new pgq(this.jdField_a_of_type_Pde.a(), paramArticleInfo1, paramInt1, this.jdField_a_of_type_Pde.b(), this.jdField_a_of_type_Pde.c(), paramInt2, this.jdField_a_of_type_Pde.a(), this.jdField_a_of_type_Pde.d(), paramArticleInfo2, this.jdField_a_of_type_Pde.a());
    long l;
    if ((paramView != null) && ((paramView instanceof ProteusItemView)))
    {
      l = System.currentTimeMillis();
      this.jdField_a_of_type_Ppz.a((ProteusItemView)paramView, paramInt1, paramArticleInfo1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_Pde.a(), this.jdField_a_of_type_Pde.a(), paramArticleInfo2, paramInt2);
      srq.a("FrameworkHandler", String.valueOf(paramInt1), "getDynamicProteusView.convertview#bindData", System.currentTimeMillis() - l);
      paramView = (ProteusItemView)paramView;
    }
    for (;;)
    {
      paramArticleInfo1 = this.jdField_a_of_type_Pde.a();
      if (paramView.a() != null) {
        paramView.a().setTag(2131369027, paramArticleInfo1);
      }
      paramView.setTag(2131379971, paramArticleInfo2);
      return paramView;
      l = System.currentTimeMillis();
      paramView = this.jdField_a_of_type_Ppz.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, paramInt1, paramArticleInfo1);
      srq.a("FrameworkHandler", String.valueOf(paramInt1), "getDynamicProteusView.getView", System.currentTimeMillis() - l);
      l = System.currentTimeMillis();
      this.jdField_a_of_type_Ppz.a(paramView, paramInt1, paramArticleInfo1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext, this.jdField_a_of_type_Pde.a(), this.jdField_a_of_type_Pde.a(), paramArticleInfo2, paramInt2);
      srq.a("FrameworkHandler", String.valueOf(paramInt1), "getDynamicProteusView.newview#bindData", System.currentTimeMillis() - l);
    }
  }
  
  public void a()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = this.jdField_a_of_type_Pde.a().a();
        this.jdField_a_of_type_Ppz = this.jdField_a_of_type_Pde.a().a();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pdg
 * JD-Core Version:    0.7.0.1
 */