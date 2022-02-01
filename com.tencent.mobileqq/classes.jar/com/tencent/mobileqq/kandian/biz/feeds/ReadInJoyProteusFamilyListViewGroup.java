package com.tencent.mobileqq.kandian.biz.feeds;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInjoySlideAnimLayout;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataFetchManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyPageItemCache;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView.RefreshCallback;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListViewGroup;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController;
import com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyProteusFamilyViewController;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.OnGalleryImageClickListener;
import com.tencent.mobileqq.kandian.biz.framework.click.OnHorizontalSubArticleClick;
import com.tencent.mobileqq.kandian.biz.framework.click.OnSubRegionClickListener;
import com.tencent.mobileqq.kandian.biz.framework.handlers.RIJInvokeHandler;
import com.tencent.mobileqq.kandian.biz.pts.OnLastReadRefreshListener;
import com.tencent.mobileqq.kandian.biz.skin.SlideActiveAnimController;
import com.tencent.mobileqq.kandian.biz.video.VideoUIManager.OnScreenChangeListener;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.push.api.MessageObserver;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.XListView.DrawFinishedListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ReadInJoyProteusFamilyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, ReadInJoyBaseListView.RefreshCallback, OnGalleryImageClickListener, OnHorizontalSubArticleClick, OnSubRegionClickListener, OnLastReadRefreshListener, VideoUIManager.OnScreenChangeListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new ReadInJoyProteusFamilyListViewGroup.7(this);
  protected IFaceDecoder a;
  RIJDataFetchManager jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager;
  private ReadInJoyProteusFamilyAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyProteusFamilyAdapter;
  RIJInvokeHandler jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler;
  private SlideActiveAnimController jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqKandianRepoPushApiMessageObserver = new ReadInJoyProteusFamilyListViewGroup.6(this);
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new ReadInJoyProteusFamilyListViewGroup.1(this);
  private XListView.DrawFinishedListener jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener = new ReadInJoyProteusFamilyListViewGroup.5(this);
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  
  public ReadInJoyProteusFamilyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt1, int paramInt2, int paramInt3, ReadInJoyPageItemCache paramReadInJoyPageItemCache, int paramInt4)
  {
    super(paramReadInJoyBaseViewController, paramInt1, paramReadInJoyPageItemCache);
    this.jdField_a_of_type_AndroidViewView = a().getLayoutInflater().inflate(paramInt4, this);
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Long = paramInt3;
    setId(2131376095);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler = new RIJInvokeHandler();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager = new RIJDataFetchManager(new RIJDataFetchManager.Builder().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache).a(this.jdField_a_of_type_Int).a(a()).a(this.jdField_a_of_type_Long).d(paramInt2).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController));
    n();
    r();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyPageItemCache.c = ReadInJoyHelper.a((QQAppInterface)ReadInJoyUtils.a());
  }
  
  private int b()
  {
    int i = this.jdField_b_of_type_Int;
    if (i != -1) {
      return i;
    }
    return a().getIntent().getIntExtra("channel_type", 0);
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131378123));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)((BaseActivity)a()).app.getRuntimeService(IQQAvatarService.class, "")).getInstance(((BaseActivity)a()).app);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyProteusFamilyAdapter = new ReadInJoyProteusFamilyAdapter(BaseActivity.sTopActivity, BaseActivity.sTopActivity.getLayoutInflater(), this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(), a());
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler;
    ((RIJInvokeHandler)localObject).a(((RIJInvokeHandler)localObject).a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyProteusFamilyAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, this.jdField_a_of_type_Long);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initUI before mListView.setPadding :");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController);
      ((StringBuilder)localObject).append(a());
      QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, ((StringBuilder)localObject).toString());
    }
    p();
    o();
    q();
    s();
    ((BaseActivity)a()).app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoPushApiMessageObserver);
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setContentBackground(new ColorDrawable(-1));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setBackgroundColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.a(0);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setChannelId(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setOnItemLongClickListener(this);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setOverScrollFlingMode(1);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$DrawFinishedListener);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.a(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsControllerReadInJoyBaseViewController instanceof ReadInJoyProteusFamilyViewController))
    {
      Activity localActivity = a();
      ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout;
      View localView;
      Object localObject;
      int i;
      if (localActivity.findViewById(2131362020) != null)
      {
        localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131362020);
        localView = localActivity.findViewById(2131377865);
        localObject = findViewById(2131367155);
        i = getResources().getDimensionPixelOffset(2131298861);
        i = AIOUtils.b(50.0F, getResources()) + ImmersiveUtils.getStatusBarHeight(getContext()) + i;
        ((View)localObject).setPadding(0, i, 0, 0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setPadding(0, i, 0, 0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.initPaddingManual();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("initUI 看点 mListView.setPadding :");
          localStringBuilder.append(i);
          QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, localView, localActivity.findViewById(16908307), new ReadInJoyProteusFamilyListViewGroup.2(this, localView, i, (View)localObject));
        return;
      }
      if (localActivity.findViewById(2131362021) != null)
      {
        localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131362021);
        localView = localActivity.findViewById(2131378810);
        int j = AIOUtils.b(50.0F, getResources());
        i = j;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          i = j + ImmersiveUtils.getStatusBarHeight(getContext());
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setPadding(0, i, 0, 0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.initPaddingManual();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initUI 消息看点 mListView.setPadding heightDef=");
          ((StringBuilder)localObject).append(i);
          QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, ((StringBuilder)localObject).toString());
        }
        localObject = findViewById(2131367155);
        ((View)localObject).setPadding(0, i, 0, 0);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinSlideActiveAnimController = new SlideActiveAnimController(this.jdField_a_of_type_Int, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, localView, null, new ReadInJoyProteusFamilyListViewGroup.3(this, localView, i, (View)localObject));
      }
    }
  }
  
  private void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyProteusFamilyAdapter.c(b());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyProteusFamilyAdapter.c(this.jdField_a_of_type_Long);
    ListenerBuilder localListenerBuilder = new ListenerBuilder().a(this).a(this).a(this).a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyProteusFamilyAdapter.a(localListenerBuilder);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyProteusFamilyAdapter);
  }
  
  private void r()
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyProteusFamilyListViewGroup.4(this), 3000L);
  }
  
  private void s()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131373730);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
  }
  
  public RIJDataFetchManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataFetchManager;
  }
  
  public ReadInJoyProteusFamilyAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyProteusFamilyAdapter;
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadinJoyProteusFamilyListViewGroup", 2, "jumpToGallery failed: atlas has undercarriage");
      }
      ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyProteusFamilyAdapter.notifyDataSetChanged();
      ReadinjoyReportUtils.a(paramAbsBaseArticleInfo);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ReadinJoyProteusFamilyListViewGroup", 2, "rowKey is empty");
    }
  }
  
  public void a(View paramView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt) {}
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt) {}
  
  public void a(VideoPlayParam paramVideoPlayParam1, VideoPlayParam paramVideoPlayParam2) {}
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView, int paramInt, long paramLong) {}
  
  public void a(Map<Integer, Boolean> paramMap) {}
  
  public void a(Map<Long, BaseReportData> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      paramMap = new StringBuilder();
      paramMap.append("ReadinJoyProteusFamilyListViewGroup_");
      paramMap.append(this.jdField_a_of_type_Int);
      QLog.d(paramMap.toString(), 2, "detachFromViewGroup()");
    }
  }
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap) {}
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, 1);
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void a(boolean paramBoolean, List<AbsBaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyProteusFamilyAdapter.a(paramList);
  }
  
  public void b() {}
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt) {}
  
  public void b(Map<Integer, Boolean> paramMap)
  {
    paramMap.put(Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(true));
  }
  
  public void c() {}
  
  public void c(Map<Integer, BaseReportData> paramMap) {}
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    ((BaseActivity)a()).app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  public void i()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      PublicTracker.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE");
      ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Int, 20, 9223372036854775807L, true);
      return;
    }
    QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.jdField_a_of_type_Int) });
  }
  
  public void j()
  {
    ReadInJoyProteusFamilyAdapter localReadInJoyProteusFamilyAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyProteusFamilyAdapter;
    if (localReadInJoyProteusFamilyAdapter != null) {
      localReadInJoyProteusFamilyAdapter.notifyDataSetChanged();
    }
  }
  
  public void k() {}
  
  public void l() {}
  
  public void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView == null) {
      return;
    }
    a(true);
  }
  
  public void onClick(View paramView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void setAdapterData(List<AbsBaseArticleInfo> paramList, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoyProteusFamilyAdapter.a(paramList);
  }
  
  public void setChannelType(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyProteusFamilyListViewGroup
 * JD-Core Version:    0.7.0.1
 */