package com.tencent.mobileqq.kandian.biz.daily;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.util.SneakyCallback;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyListViewGroup;
import com.tencent.mobileqq.kandian.biz.diandian.DailyFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.diandian.RecommendFeedsDiandianEntranceManager;
import com.tencent.mobileqq.kandian.biz.diandian.view.DailyDianDianEntranceView;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoAudioControlUtil;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeControl;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoySrtUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.Map;
import org.json.JSONObject;

public class ReadInJoyDailyViewController
  extends ReadInJoyBaseViewController
  implements View.OnClickListener
{
  private static String jdField_a_of_type_JavaLangString = "readinjoy_daily_old_version_cache_deal";
  private static boolean jdField_a_of_type_Boolean = true;
  private static boolean jdField_b_of_type_Boolean = ((Boolean)RIJSPUtils.a(jdField_a_of_type_JavaLangString, Boolean.valueOf(false))).booleanValue();
  private static int e;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
  private ReadInJoyDailyPullToZoomHeaderXListView jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyPullToZoomHeaderXListView;
  private DailyDianDianEntranceView jdField_a_of_type_ComTencentMobileqqKandianBizDiandianViewDailyDianDianEntranceView;
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  private VideoUIManager jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager;
  private VideoPlayManager jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
  protected ReadInJoyObserver a;
  private int jdField_b_of_type_Int = -1;
  private int jdField_c_of_type_Int = -1;
  private volatile boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean = false;
  
  public ReadInJoyDailyViewController(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyDailyViewController.1(this);
  }
  
  public static int a()
  {
    return e;
  }
  
  private int b()
  {
    int i = this.jdField_b_of_type_Int;
    if (i != -1) {
      return i;
    }
    return this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("channel_id", 0);
  }
  
  private void b(ListView paramListView, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    for (Object localObject1 = DailyModeConfigHandler.a();; localObject1 = null)
    {
      try
      {
        Object localObject2 = ((JSONObject)localObject1).optString("style_ID", "null");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[initPTSFooterView] ");
        localStringBuilder.append((String)localObject2);
        QLog.i("ReadInJoyDailyViewController", 1, localStringBuilder.toString());
        localObject2 = TemplateFactory.a("default_feeds", true);
        if (localObject2 == null) {
          continue;
        }
        localObject1 = ((TemplateFactory)localObject2).getTemplateBean((JSONObject)localObject1);
        if (localObject1 != null)
        {
          paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.a();
          paramReadInJoyBaseAdapter = paramReadInJoyBaseAdapter.getViewFactory().inflate(paramReadInJoyBaseAdapter, (TemplateBean)localObject1);
          ProteusSupportUtil.a(paramReadInJoyBaseAdapter, null, (TemplateBean)localObject1);
          paramReadInJoyBaseAdapter.setTag(localObject1);
          paramListView.addFooterView(paramReadInJoyBaseAdapter);
          if ((paramListView instanceof ReadInJoyDailyXListView)) {
            ((ReadInJoyDailyXListView)paramListView).setPTSFooterView(paramReadInJoyBaseAdapter);
          }
        }
        else
        {
          QLog.e("ReadInJoyDailyViewController", 1, "[initPTSFooterView] template bean is null");
          return;
        }
      }
      catch (Exception paramListView)
      {
        QLog.e("ReadInJoyDailyViewController", 1, "[initPTSFooterView] ", paramListView);
      }
      return;
    }
  }
  
  private int c()
  {
    int i = this.jdField_c_of_type_Int;
    if (i != -1) {
      return i;
    }
    return this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("channel_type", 0);
  }
  
  private void l()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if (localReadInJoyBaseListViewGroup != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizDiandianViewDailyDianDianEntranceView = ((DailyDianDianEntranceView)localReadInJoyBaseListViewGroup.findViewById(2131366280));
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizDiandianViewDailyDianDianEntranceView != null)
      {
        if (!DailyFeedsDiandianEntranceManager.a().a())
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizDiandianViewDailyDianDianEntranceView.setVisibility(8);
          QLog.d("ReadInJoyDailyViewController", 1, "hide entry Icon");
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizDiandianViewDailyDianDianEntranceView.a(DailyFeedsDiandianEntranceManager.a().a(a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizDiandianViewDailyDianDianEntranceView, this));
        if (DailyFeedsDiandianEntranceManager.a().a() == 1) {
          RecommendFeedsDiandianEntranceManager.getInstance().addEntryRefreshListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizDiandianViewDailyDianDianEntranceView);
        }
      }
    }
  }
  
  private void n()
  {
    if (e == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyPullToZoomHeaderXListView.setCanLoadMore(true);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyPullToZoomHeaderXListView.getOverScrollFooterView() == null)
    {
      View localView = LayoutInflater.from(a()).inflate(2131560165, this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyPullToZoomHeaderXListView, false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyPullToZoomHeaderXListView.setOverScrollFooter(localView);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyPullToZoomHeaderXListView.a(new ReadInJoyDailyOverScrollListener());
    }
  }
  
  private void o()
  {
    ArticleInfoModule localArticleInfoModule = ReadInJoyLogicEngine.a().a();
    if ((localArticleInfoModule != null) && (!jdField_b_of_type_Boolean)) {
      localArticleInfoModule.a(new ReadInJoyDailyViewController.2(this, localArticleInfoModule));
    }
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public VafContext a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.a();
  }
  
  public VideoPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(ListView paramListView, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    if ((paramListView != null) && (a() != 2)) {
      b(paramListView, paramReadInJoyBaseAdapter);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(paramBoolean);
  }
  
  public void aw_()
  {
    super.aw_();
    VideoVolumeControl.getInstance().inKandianModule(a());
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager = new VideoPlayManager(a());
    e = DailyModeConfigHandler.a();
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(b()), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, b(), c(), this.jdField_d_of_type_Int, null, 2131560164);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyPullToZoomHeaderXListView = ((ReadInJoyDailyPullToZoomHeaderXListView)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.findViewById(2131378123));
    l();
    n();
    o();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup).a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager = new VideoUIManager((FrameLayout)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.findViewById(2131380736), this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyReadInJoyDailyPullToZoomHeaderXListView, this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoUIManager);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      ReadInJoyLogicEngine.a().c();
    }
    b();
    SneakyCallback.a(8);
    ReadInJoySrtUtils.a().a();
    ReadInJoySrtUtils.a().a(String.valueOf(b()));
    VideoAudioControlUtil.a.a(VideoAudioControlUtil.a.a(), "ENTER_DAILY_FEEDS");
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    super.b();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if (localObject != null)
    {
      ((ReadInJoyBaseListViewGroup)localObject).a(a(Integer.valueOf(b())), b(Integer.valueOf(b())));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.b(this.jdField_b_of_type_JavaUtilMap);
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        localObject = new ViewGroup.LayoutParams(-1, -1);
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup, (ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void c()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    super.c();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if (localObject != null)
    {
      ((ReadInJoyBaseListViewGroup)localObject).a(b(Integer.valueOf(b())), a(Integer.valueOf(b())));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.a(this.jdField_b_of_type_JavaUtilMap);
      d();
      localObject = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup);
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
  }
  
  public void e()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    Object localObject = ReadInJoyLogicEngine.a().a();
    if (localObject != null) {
      ((ArticleInfoModule)localObject).a(null);
    }
    super.e();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizDiandianViewDailyDianDianEntranceView != null)
    {
      RecommendFeedsDiandianEntranceManager.getInstance().removeEntryRefreshListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizDiandianViewDailyDianDianEntranceView);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizDiandianViewDailyDianDianEntranceView.a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (localObject != null) {
      ((VideoPlayManager)localObject).d();
    }
    VideoVolumeControl.getInstance().outKandianModule(a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.f();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.c();
    VideoAudioControlUtil.a.a(VideoAudioControlUtil.a.a(), "LEAVE_DAILY_FEEDS");
  }
  
  public void f()
  {
    super.f();
    ReadInJoyBaseAdapter localReadInJoyBaseAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
    if (localReadInJoyBaseAdapter != null) {
      localReadInJoyBaseAdapter.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.d();
    if (!this.jdField_d_of_type_Boolean)
    {
      DailyFeedsDiandianEntranceManager.a().a();
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.e();
  }
  
  public void h()
  {
    super.h();
    VideoPlayManager localVideoPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (localVideoPlayManager != null) {
      localVideoPlayManager.e();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.c();
  }
  
  public void i()
  {
    super.i();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.b();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if ((localObject1 instanceof ReadInJoyListViewGroup)) {
      localObject1 = ((ReadInJoyListViewGroup)localObject1).a();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject2 = ((VideoPlayManager)localObject2).a();
      if ((localObject2 != null) && (((VideoPlayParam)localObject2).jdField_b_of_type_Boolean)) {
        ((ReadInJoyBaseAdapter)localObject1).g();
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
    if (localObject1 != null) {
      ((VideoPlayManager)localObject1).d(b());
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup.b();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if ((localObject1 instanceof ReadInJoyListViewGroup)) {
      ((ReadInJoyListViewGroup)localObject1).k();
    }
  }
  
  public void j()
  {
    ReadInJoyBaseListViewGroup localReadInJoyBaseListViewGroup = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListViewGroup;
    if ((localReadInJoyBaseListViewGroup != null) && ((localReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      localReadInJoyBaseListViewGroup.a(true, 1);
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyViewController
 * JD-Core Version:    0.7.0.1
 */