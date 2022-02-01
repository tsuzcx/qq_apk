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
  protected IFaceDecoder j;
  RIJDataFetchManager k;
  RIJInvokeHandler l;
  private ReadInJoyProteusFamilyAdapter m;
  private View n;
  private View o;
  private long p;
  private AbsBaseArticleInfo q;
  private int r = -1;
  private long s;
  private SlideActiveAnimController t;
  private AbsListView.OnScrollListener u = new ReadInJoyProteusFamilyListViewGroup.1(this);
  private XListView.DrawFinishedListener v = new ReadInJoyProteusFamilyListViewGroup.5(this);
  private MessageObserver w = new ReadInJoyProteusFamilyListViewGroup.6(this);
  private FriendListObserver x = new ReadInJoyProteusFamilyListViewGroup.7(this);
  
  public ReadInJoyProteusFamilyListViewGroup(ReadInJoyBaseViewController paramReadInJoyBaseViewController, int paramInt1, int paramInt2, int paramInt3, ReadInJoyPageItemCache paramReadInJoyPageItemCache, int paramInt4)
  {
    super(paramReadInJoyBaseViewController, paramInt1, paramReadInJoyPageItemCache);
    this.n = getCurrentActivity().getLayoutInflater().inflate(paramInt4, this);
    this.r = paramInt2;
    this.s = paramInt3;
    setId(2131444298);
    this.l = new RIJInvokeHandler();
    this.l.a(this);
    this.k = new RIJDataFetchManager(new RIJDataFetchManager.Builder().a(this.b).a(this.a).a(getCurrentActivity()).a(this.s).d(paramInt2).a(this.c));
    n();
    r();
    this.b.d = ReadInJoyHelper.c((QQAppInterface)ReadInJoyUtils.b());
  }
  
  private int getChannelType()
  {
    int i = this.r;
    if (i != -1) {
      return i;
    }
    return getCurrentActivity().getIntent().getIntExtra("channel_type", 0);
  }
  
  private void n()
  {
    this.d = ((ReadInJoyXListView)findViewById(2131446630));
    this.j = ((IQQAvatarService)((BaseActivity)getCurrentActivity()).app.getRuntimeService(IQQAvatarService.class, "")).getInstance(((BaseActivity)getCurrentActivity()).app);
    this.m = new ReadInJoyProteusFamilyAdapter(BaseActivity.sTopActivity, BaseActivity.sTopActivity.getLayoutInflater(), this.a, this.d, this.l.a(), getCurrentActivity());
    Object localObject = this.l;
    ((RIJInvokeHandler)localObject).a(((RIJInvokeHandler)localObject).a(), this.m);
    this.l.a(this.n, this.d, this.s);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initUI before mListView.setPadding :");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(getCurrentActivity());
      QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, ((StringBuilder)localObject).toString());
    }
    p();
    o();
    q();
    s();
    ((BaseActivity)getCurrentActivity()).app.addObserver(this.x);
    ((KandianMergeManager)ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(this.w);
  }
  
  private void o()
  {
    this.d.setContentBackground(new ColorDrawable(-1));
    this.d.setBackgroundColor(-1);
    this.d.b(0);
    this.d.setChannelId(this.a);
    this.d.setOnItemClickListener(this);
    this.d.setRefreshCallback(this);
    this.d.setOnItemLongClickListener(this);
    if (this.a == 0)
    {
      this.d.setOverScrollTouchMode(1);
      this.d.setOverScrollFlingMode(1);
    }
    this.d.setDrawFinishedListener(this.v);
    this.d.a(this.u);
  }
  
  private void p()
  {
    if ((this.c instanceof ReadInJoyProteusFamilyViewController))
    {
      Activity localActivity = getCurrentActivity();
      ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout;
      View localView;
      Object localObject;
      int i;
      if (localActivity.findViewById(2131427598) != null)
      {
        localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131427598);
        localView = localActivity.findViewById(2131446342);
        localObject = findViewById(2131433609);
        i = getResources().getDimensionPixelOffset(2131299578);
        i = AIOUtils.b(50.0F, getResources()) + ImmersiveUtils.getStatusBarHeight(getContext()) + i;
        ((View)localObject).setPadding(0, i, 0, 0);
        this.d.setPadding(0, i, 0, 0);
        this.d.initPaddingManual();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("initUI 看点 mListView.setPadding :");
          localStringBuilder.append(i);
          QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, localStringBuilder.toString());
        }
        this.t = new SlideActiveAnimController(this.a, localActivity, localReadInjoySlideAnimLayout, this.d, localView, localActivity.findViewById(16908307), new ReadInJoyProteusFamilyListViewGroup.2(this, localView, i, (View)localObject));
        return;
      }
      if (localActivity.findViewById(2131427599) != null)
      {
        localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131427599);
        localView = localActivity.findViewById(2131447492);
        int i1 = AIOUtils.b(50.0F, getResources());
        i = i1;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
          i = i1 + ImmersiveUtils.getStatusBarHeight(getContext());
        }
        this.d.setPadding(0, i, 0, 0);
        this.d.initPaddingManual();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("initUI 消息看点 mListView.setPadding heightDef=");
          ((StringBuilder)localObject).append(i);
          QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, ((StringBuilder)localObject).toString());
        }
        localObject = findViewById(2131433609);
        ((View)localObject).setPadding(0, i, 0, 0);
        this.t = new SlideActiveAnimController(this.a, localActivity, localReadInjoySlideAnimLayout, this.d, localView, null, new ReadInJoyProteusFamilyListViewGroup.3(this, localView, i, (View)localObject));
      }
    }
  }
  
  private void q()
  {
    this.m.e(getChannelType());
    this.m.c(this.s);
    ListenerBuilder localListenerBuilder = new ListenerBuilder().a(this).a(this).a(this).a(this);
    this.m.a(localListenerBuilder);
    this.d.setAdapter(this.m);
  }
  
  private void r()
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyProteusFamilyListViewGroup.4(this), 3000L);
  }
  
  private void s()
  {
    View localView = this.o;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = findViewById(2131441404);
    this.d.setEmptyView(localView);
    localView.setOnClickListener(null);
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
      this.m.notifyDataSetChanged();
      ReadinjoyReportUtils.b(paramAbsBaseArticleInfo);
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
      paramMap.append(this.a);
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
    this.m.a(paramList);
  }
  
  public void b() {}
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt) {}
  
  public void b(Map<Integer, Boolean> paramMap)
  {
    paramMap.put(Integer.valueOf(this.a), Boolean.valueOf(true));
  }
  
  public void c() {}
  
  public void c(Map<Integer, BaseReportData> paramMap) {}
  
  public void cW_() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    ((BaseActivity)getCurrentActivity()).app.removeObserver(this.x);
  }
  
  public ReadInJoyProteusFamilyAdapter getAdapter()
  {
    return this.m;
  }
  
  public RIJDataFetchManager getDataFetchManager()
  {
    return this.k;
  }
  
  public String getLastActionBrief()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.q;
    if (localAbsBaseArticleInfo != null) {
      return localAbsBaseArticleInfo.mTitle;
    }
    return null;
  }
  
  public long getLastActionTime()
  {
    return this.p;
  }
  
  public void i()
  {
    if (!this.e)
    {
      this.e = true;
      PublicTracker.a(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE");
      ReadInJoyLogicEngine.a().a(this.a, 20, 9223372036854775807L, true);
      return;
    }
    QLog.d("ReadinJoyProteusFamilyListViewGroup", 2, new Object[] { "has loaded article, mChannelID = ", Integer.valueOf(this.a) });
  }
  
  public void j()
  {
    ReadInJoyProteusFamilyAdapter localReadInJoyProteusFamilyAdapter = this.m;
    if (localReadInJoyProteusFamilyAdapter != null) {
      localReadInJoyProteusFamilyAdapter.notifyDataSetChanged();
    }
  }
  
  public void k() {}
  
  public void m()
  {
    if (this.d == null) {
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
    this.m.a(paramList);
  }
  
  public void setChannelType(int paramInt)
  {
    this.r = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyProteusFamilyListViewGroup
 * JD-Core Version:    0.7.0.1
 */