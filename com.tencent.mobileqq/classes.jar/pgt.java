import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.header.RIJFrameworkHeaderManager.1;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.header.RIJFrameworkHeaderManager.2;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInjoySlideAnimLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ChannelTopPositionView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.ChannelTopBanner;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pgt
{
  private SlideActiveAnimController jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController;
  private ChannelTopPositionView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView;
  private ChannelTopBanner jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner;
  private List<sxf> jdField_a_of_type_JavaUtilList = new ArrayList();
  private opq jdField_a_of_type_Opq;
  private szx jdField_a_of_type_Szx;
  private ChannelTopPositionView b;
  
  private void a(View paramView, Context paramContext)
  {
    if ((paramContext instanceof ReadInJoyNewFeedsActivity)) {
      ((ReadInJoyNewFeedsActivity)paramContext).b(paramView);
    }
    for (;;)
    {
      return;
      if (bkwm.i()) {
        try
        {
          paramContext = (ReadinjoyTabFrame)FrameHelperActivity.a((BaseActivity)paramContext).a(ReadinjoyTabFrame.class);
          if (paramContext != null)
          {
            paramContext.a(paramView);
            return;
          }
        }
        catch (Exception paramView)
        {
          QLog.d("RIJFrameworkReportManager", 2, "readinjoy tab add dispatch touch event view fail ! e : " + paramView);
        }
      }
    }
  }
  
  public List<sxf> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public opq a()
  {
    return this.jdField_a_of_type_Opq;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      sxf localsxf = (sxf)localIterator.next();
      if ((localsxf instanceof ReadInJoyDiandianHeaderController)) {
        localsxf.e();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.b != null) {
      this.b.setVisibility(paramInt);
    }
  }
  
  public void a(int paramInt1, ReadInJoyXListView paramReadInJoyXListView, Activity paramActivity, int paramInt2)
  {
    if ((!rao.b) && ((paramActivity instanceof SplashActivity))) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramReadInJoyXListView.a());
        if (paramInt2 != 0)
        {
          paramReadInJoyXListView.a(0);
          return;
        }
      } while (paramInt1 == -1);
      if (paramInt1 == 0)
      {
        paramReadInJoyXListView.a(0);
        return;
      }
    } while (paramReadInJoyXListView.a());
    paramActivity = paramReadInJoyXListView.a(2);
    a(paramReadInJoyXListView);
    paramActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
  }
  
  public void a(int paramInt1, boolean paramBoolean, ReadInJoyXListView paramReadInJoyXListView, Activity paramActivity, int paramInt2)
  {
    if ((!rao.b) && ((paramActivity instanceof SplashActivity))) {}
    label78:
    do
    {
      do
      {
        do
        {
          return;
        } while (paramReadInJoyXListView.a());
        if (paramInt2 != 0)
        {
          paramReadInJoyXListView.a(0);
          return;
        }
        if (paramInt1 != 0) {
          break label78;
        }
        if (!paramBoolean) {
          break;
        }
      } while (paramReadInJoyXListView.a());
      paramActivity = paramReadInJoyXListView.a(2);
      a(paramReadInJoyXListView);
      paramActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
      return;
      paramReadInJoyXListView.a(0);
      return;
    } while (paramReadInJoyXListView.a());
    paramActivity = paramReadInJoyXListView.a(2);
    a(paramReadInJoyXListView);
    paramActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
  }
  
  public void a(Activity paramActivity, ReadInJoyXListView paramReadInJoyXListView, View paramView, int paramInt)
  {
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)paramActivity.findViewById(2131362001);
    View localView = paramActivity.findViewById(2131378734);
    int j = AIOUtils.dp2px(50.0F, paramActivity.getResources());
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = j + ImmersiveUtils.getStatusBarHeight(paramActivity);
    }
    paramReadInJoyXListView.setPadding(0, i, 0, 0);
    paramReadInJoyXListView.initPaddingManual();
    if (QLog.isColorLevel()) {
      QLog.d("RIJFrameworkReportManager", 2, "initUI 消息看点 mListView.setPadding heightDef=" + i);
    }
    paramView = paramView.findViewById(2131367061);
    paramView.setPadding(0, i, 0, 0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(paramInt, paramActivity, localReadInjoySlideAnimLayout, paramReadInJoyXListView, localView, null, new RIJFrameworkHeaderManager.1(this, localView, i, paramView, paramReadInJoyXListView));
  }
  
  public void a(Activity paramActivity, ReadInJoyXListView paramReadInJoyXListView, View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.d("RIJFrameworkReportManager", 1, "updateListViewPadding,update2StudyMode=" + paramBoolean1 + " ,isOnCreate=" + paramBoolean2);
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)paramActivity.findViewById(2131362000);
    View localView = paramActivity.findViewById(2131377749);
    paramView = paramView.findViewById(2131367061);
    if (paramBoolean1)
    {
      i = 2131298768;
      i = paramActivity.getResources().getDimensionPixelOffset(i);
      if (!paramBoolean1) {
        break label233;
      }
    }
    label233:
    for (int i = ImmersiveUtils.getStatusBarHeight(paramActivity) + i;; i = AIOUtils.dp2px(50.0F, paramActivity.getResources()) + ImmersiveUtils.getStatusBarHeight(paramActivity) + i)
    {
      int j = AIOUtils.dp2px(50.0F, paramActivity.getResources());
      int k = ImmersiveUtils.getStatusBarHeight(paramActivity);
      int m = paramActivity.getResources().getDimensionPixelOffset(2131298772);
      paramView.setPadding(0, i, 0, 0);
      paramReadInJoyXListView.setPadding(0, i, 0, 0);
      paramReadInJoyXListView.initPaddingManual();
      if (QLog.isColorLevel()) {
        QLog.d("RIJFrameworkReportManager", 2, "initUI 看点 mListView.setPadding :" + i);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(paramInt, paramActivity, localReadInjoySlideAnimLayout, paramReadInJoyXListView, localView, paramActivity.findViewById(16908307), new RIJFrameworkHeaderManager.2(this, localView, i, j + k + m, paramView, paramReadInJoyXListView));
      return;
      i = 2131298772;
      break;
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramInt == 41695)
    {
      if (this.b == null) {
        this.b = ((ChannelTopPositionView)paramView.findViewById(2131375991));
      }
      a(0);
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo, ReadInJoyXListView paramReadInJoyXListView, Activity paramActivity, int paramInt, slt paramslt)
  {
    if ((paramTopBannerInfo == null) || (paramTopBannerInfo.mChannelId != paramInt)) {}
    while (paramInt == 41695) {
      return;
    }
    if (paramTopBannerInfo.isEmpty())
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner != null) {
        paramReadInJoyXListView.removeHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner = null;
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner = new ChannelTopBanner(paramActivity);
      paramReadInJoyXListView.addHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner, 2);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.a(paramslt, paramTopBannerInfo);
  }
  
  public void a(ReadInJoyXListView paramReadInJoyXListView)
  {
    if (paramReadInJoyXListView != null) {
      paramReadInJoyXListView.a(this.jdField_a_of_type_Szx);
    }
  }
  
  public void a(ReadInJoyXListView paramReadInJoyXListView, Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView = new ChannelTopPositionView(paramContext);
      paramReadInJoyXListView.addHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView, 2);
    }
  }
  
  public void a(ReadInJoyXListView paramReadInJoyXListView, Context paramContext, int paramInt)
  {
    if (paramInt == 0) {
      if (!bkwm.k()) {
        this.jdField_a_of_type_JavaUtilList.add(new sxp(paramContext));
      }
    }
    for (;;)
    {
      paramContext = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramContext.hasNext()) {
        ((sxf)paramContext.next()).a(paramReadInJoyXListView);
      }
      if (paramInt == 56)
      {
        if (bkwm.v(pay.a()) != 2)
        {
          this.jdField_a_of_type_Opq = new opq(paramContext, paramInt, paramReadInJoyXListView);
          a(this.jdField_a_of_type_Opq.a(), paramContext);
        }
      }
      else if (paramInt == 70)
      {
        this.jdField_a_of_type_JavaUtilList.add(new ReadInJoyDiandianHeaderController(paramContext));
      }
      else if ((paramInt == 41523) && (bkwm.w(pay.a()) != 1))
      {
        this.jdField_a_of_type_Opq = new opq(paramContext, paramInt, paramReadInJoyXListView);
        this.jdField_a_of_type_Opq.a().setBackgroundColor(-1);
        a(this.jdField_a_of_type_Opq.a(), paramContext);
      }
    }
  }
  
  public void a(szx paramszx, ReadInJoyXListView paramReadInJoyXListView)
  {
    if (paramReadInJoyXListView != null)
    {
      paramReadInJoyXListView.a(paramszx);
      this.jdField_a_of_type_Szx = paramszx;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.c());
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((sxf)localIterator.next()).c();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.d();
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((sxf)localIterator.next()).d();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.c();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.e();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Opq != null)
    {
      this.jdField_a_of_type_Opq.a();
      this.jdField_a_of_type_Opq = null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((sxf)localIterator.next()).b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.f();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgt
 * JD-Core Version:    0.7.0.1
 */