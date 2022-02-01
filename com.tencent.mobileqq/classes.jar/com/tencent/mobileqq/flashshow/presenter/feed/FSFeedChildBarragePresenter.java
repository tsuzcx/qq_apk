package com.tencent.mobileqq.flashshow.presenter.feed;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.flashshow.bean.FSFeedSelectInfo;
import com.tencent.mobileqq.flashshow.config.FSConfig;
import com.tencent.mobileqq.flashshow.events.FSCloseBarrageEvent;
import com.tencent.mobileqq.flashshow.events.FSGetBarrageEvent;
import com.tencent.mobileqq.flashshow.events.FSOpenBarrageEvent;
import com.tencent.mobileqq.flashshow.events.FSSeekEvent;
import com.tencent.mobileqq.flashshow.events.FSUpdateCommentTotalEvent;
import com.tencent.mobileqq.flashshow.helper.FSGlobalInfoHelper;
import com.tencent.mobileqq.flashshow.model.barrage.FSBarrageModel;
import com.tencent.mobileqq.flashshow.model.barrage.IFSBarrageModel;
import com.tencent.mobileqq.flashshow.model.barrage.bean.FSLoadBarrageListBean;
import com.tencent.mobileqq.flashshow.model.comment.FSCommentManager;
import com.tencent.mobileqq.flashshow.model.comment.IFSCommentManager;
import com.tencent.mobileqq.flashshow.presenter.feed.event.FSBaseFeedPresenterEvent;
import com.tencent.mobileqq.flashshow.presenter.feed.event.FSVideoProgressChangeEvent;
import com.tencent.mobileqq.flashshow.presenter.feed.event.FSVideoStatusEvent;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.utils.FSSafeListUtils;
import com.tencent.mobileqq.flashshow.utils.FSViewUtils;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.FSBarrageViewModel;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.IFSBarrageViewModel;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.holder.bean.BarrageHolderParam;
import com.tencent.mobileqq.flashshow.viewmodel.barrage.popup.FSBarragePopupWindow;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.List;

public class FSFeedChildBarragePresenter
  extends FSBaseFeedChildPresenter<FeedCloudMeta.StFeed>
  implements SimpleEventReceiver
{
  private IFSBarrageViewModel<FeedCloudMeta.StComment> f;
  private ViewGroup g;
  private long h = -1L;
  private int i = 0;
  private List<FeedCloudMeta.StComment> j;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o;
  
  private void a(FSCloseBarrageEvent paramFSCloseBarrageEvent)
  {
    if (this.b == null) {
      return;
    }
    QLog.d("DM-FSFeedChildBarragePresenter", 1, "[handlerCloseBarrageEvent] handler close barrage event.");
    FSViewUtils.a(this.g, 8);
    l();
  }
  
  private void a(@NonNull FSGetBarrageEvent paramFSGetBarrageEvent)
  {
    String str;
    if (this.b == null) {
      str = "";
    } else {
      str = ((FeedCloudMeta.StFeed)this.b).id.get();
    }
    if (!TextUtils.equals(str, paramFSGetBarrageEvent.getFeedId())) {
      return;
    }
    List localList = paramFSGetBarrageEvent.getCommentList();
    int i1 = paramFSGetBarrageEvent.getTotal();
    int i2 = FSSafeListUtils.b(localList);
    int i3 = paramFSGetBarrageEvent.getStartIndex();
    boolean bool = paramFSGetBarrageEvent.isLoadMore();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i1);
    localStringBuilder.append(" ｜ feedId: ");
    QLog.d("DM-FSFeedChildBarragePresenter", 1, new Object[] { "[handlerGetBarrageEvent] is load more: ", Boolean.valueOf(bool), " | barrage size: ", Integer.valueOf(i2), " | total: ", localStringBuilder.toString(), str, " | hash code: ", Integer.valueOf(hashCode()) });
    if (paramFSGetBarrageEvent.isLoadMore())
    {
      a(localList, i1, i3);
      return;
    }
    a(localList, i1);
  }
  
  private void a(FSOpenBarrageEvent paramFSOpenBarrageEvent)
  {
    if (this.b == null) {
      return;
    }
    if (!TextUtils.equals(paramFSOpenBarrageEvent.getFeedId(), ((FeedCloudMeta.StFeed)this.b).id.get())) {
      return;
    }
    QLog.d("DM-FSFeedChildBarragePresenter", 1, "[handlerOpenBarrageEvent] handler open barrage event.");
    FSViewUtils.a(this.g, 0);
    i();
    k();
  }
  
  private void a(@NonNull FSSeekEvent paramFSSeekEvent)
  {
    if (this.f == null)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[handlerSeekBarEvent] barrage view model should not be null.");
      return;
    }
    if (!FSGlobalInfoHelper.b())
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[handlerSeekBarEvent] barrage is close, flow end.");
      return;
    }
    if (paramFSSeekEvent.mIsOnSeek)
    {
      this.g.setVisibility(8);
      return;
    }
    this.g.setVisibility(0);
  }
  
  private void a(FSVideoProgressChangeEvent paramFSVideoProgressChangeEvent)
  {
    if (paramFSVideoProgressChangeEvent == null) {
      return;
    }
    if (paramFSVideoProgressChangeEvent.a() != this.h)
    {
      this.h = paramFSVideoProgressChangeEvent.a();
      b(false);
      o();
      return;
    }
    if (this.o)
    {
      b(false);
      h();
    }
  }
  
  private void a(@NonNull FSVideoStatusEvent paramFSVideoStatusEvent)
  {
    QLog.d("DM-FSFeedChildBarragePresenter", 1, new Object[] { "[handlerVideoStatusEvent] event: ", Boolean.valueOf(paramFSVideoStatusEvent.a()) });
    b(paramFSVideoStatusEvent.a());
    if ((this.f == null) && (!this.o))
    {
      this.n = false;
      o();
      return;
    }
    if (this.o)
    {
      n();
      return;
    }
    m();
  }
  
  private void a(BarrageHolderParam paramBarrageHolderParam)
  {
    FSFeedChildBarragePresenter.1 local1 = new FSFeedChildBarragePresenter.1(this);
    FSBarragePopupWindow localFSBarragePopupWindow = FSBarragePopupWindow.a();
    localFSBarragePopupWindow.a(local1);
    localFSBarragePopupWindow.a(paramBarrageHolderParam);
    localFSBarragePopupWindow.a((FeedCloudMeta.StFeed)this.b);
    localFSBarragePopupWindow.a(p(), this.g);
  }
  
  private void a(List<FeedCloudMeta.StComment> paramList, int paramInt)
  {
    if (FSSafeListUtils.a(paramList))
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[handlerGetBarrageEvent] set data source, barrage list should not is empty.");
      return;
    }
    List localList = this.j;
    if (localList == null) {
      this.j = new ArrayList();
    } else {
      localList.clear();
    }
    this.l = false;
    this.j.addAll(paramList);
    this.i = paramInt;
    o();
  }
  
  private void a(List<FeedCloudMeta.StComment> paramList, int paramInt1, int paramInt2)
  {
    if (FSSafeListUtils.a(paramList))
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[appendBarrageDataSource] comments data source is empty, flow return.");
      return;
    }
    if (this.f == null)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[appendBarrageDataSource] barrage view model should be null, flow return.");
      return;
    }
    if (this.h <= 0L)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[appendBarrageDataSource] barrage view model should be null, flow return.");
      return;
    }
    QLog.d("DM-FSFeedChildBarragePresenter", 1, new Object[] { "[appendBarrageDataSource] size: ", Integer.valueOf(FSSafeListUtils.b(paramList)), " | total: ", Integer.valueOf(paramInt1), " | startIndex: ", Integer.valueOf(paramInt2) });
    this.f.a(paramList, paramInt1, this.h, paramInt2);
    this.l = false;
  }
  
  private void b(View paramView)
  {
    if (paramView == null)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[addTextureLayoutToBarrageLayout] barrage layout should not be null.");
      return;
    }
    ViewGroup localViewGroup = this.g;
    if (localViewGroup == null)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[addTextureViewToBarrageLayout] barrage layout should not be null.");
      return;
    }
    localViewGroup.removeAllViews();
    this.g.addView(paramView);
    if (FSGlobalInfoHelper.b()) {
      FSViewUtils.a(this.g, 0);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateVideoPause] isVideoPause: ");
    localStringBuilder.append(paramBoolean);
    QLog.w("DM-FSFeedChildBarragePresenter", 1, localStringBuilder.toString());
    this.o = paramBoolean;
  }
  
  private void c(boolean paramBoolean)
  {
    QLog.d("DM-FSFeedChildBarragePresenter", 1, new Object[] { "[loadMeasureFinish] load measure isLoadMore: ", Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      r();
      return;
    }
    s();
  }
  
  private IFSBarrageViewModel<FeedCloudMeta.StComment> f()
  {
    if (this.f == null) {
      this.f = new FSBarrageViewModel();
    }
    g();
    return this.f;
  }
  
  private void g()
  {
    IFSBarrageViewModel localIFSBarrageViewModel = this.f;
    if (localIFSBarrageViewModel == null) {
      return;
    }
    if (localIFSBarrageViewModel.e() == null) {
      return;
    }
    this.f.a(e());
  }
  
  private void h()
  {
    if (this.f == null)
    {
      i();
      k();
      return;
    }
    if (this.m)
    {
      m();
      return;
    }
    k();
  }
  
  private void i()
  {
    List localList = this.j;
    if (localList != null) {
      localList.clear();
    }
    this.k = false;
    this.n = false;
  }
  
  private boolean j()
  {
    return FSConfig.a("qqflash", "qqflash_show_barrage_enabled", Integer.valueOf(1)).intValue() == 1;
  }
  
  private void k()
  {
    Object localObject = t();
    if (!j())
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, new Object[] { "[loadBarrageSource] current wns barrage not enabled, not load source, feed id: ", localObject });
      return;
    }
    if (!FSGlobalInfoHelper.b())
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, new Object[] { "[loadBarrageSource] current barrage is close state, not load source, feed id: ", localObject });
      return;
    }
    if (this.k)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, new Object[] { "[loadBarrageSource] current barrage update data source flag == true, not load source, feed id: ", localObject });
      return;
    }
    localObject = FSLoadBarrageListBean.a();
    ((FSLoadBarrageListBean)localObject).a((FeedCloudMeta.StFeed)this.b);
    ((FSLoadBarrageListBean)localObject).a(hashCode());
    ((FSLoadBarrageListBean)localObject).a(false);
    FSBarrageModel.a().a((FSLoadBarrageListBean)localObject);
    this.k = true;
  }
  
  private void l()
  {
    Object localObject = this.f;
    if (localObject != null) {
      ((IFSBarrageViewModel)localObject).d();
    }
    localObject = this.g;
    if (localObject != null) {
      ((ViewGroup)localObject).removeAllViews();
    }
    this.f = null;
  }
  
  private void m()
  {
    IFSBarrageViewModel localIFSBarrageViewModel = this.f;
    if (localIFSBarrageViewModel == null)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[handlerResumeBarrage] barrage view model should not be null.");
      return;
    }
    localIFSBarrageViewModel.c();
  }
  
  private void n()
  {
    IFSBarrageViewModel localIFSBarrageViewModel = this.f;
    if (localIFSBarrageViewModel == null)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[handlerPauseBarrage] barrage view model should not be null.");
      return;
    }
    localIFSBarrageViewModel.b();
  }
  
  private void o()
  {
    if (this.o)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[tryUpdateDataSourceToBarrageView] video pause state, not play barrage.");
      return;
    }
    if (!FSSafeListUtils.a(this.j))
    {
      if (this.h <= 0L) {
        return;
      }
      if (this.n)
      {
        QLog.d("DM-FSFeedChildBarragePresenter", 1, "[tryUpdateDataSourceToBarrageView] isStartDataSource == true, flow return.");
        return;
      }
      this.n = true;
      Context localContext = p();
      TextureView localTextureView = q();
      if (localTextureView == null) {
        i1 = -1;
      } else {
        i1 = localTextureView.hashCode();
      }
      int i2 = this.j.size();
      String str = t();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[tryUpdateDataSourceToBarrageView] barrage view hash code:");
      localStringBuilder.append(i1);
      localStringBuilder.append(" | net barrage total: ");
      localStringBuilder.append(this.i);
      localStringBuilder.append(" | barrage size: ");
      localStringBuilder.append(i2);
      localStringBuilder.append(" | video duration: ");
      localStringBuilder.append(this.h);
      localStringBuilder.append(" | feed id: ");
      localStringBuilder.append(str);
      QLog.d("DM-FSFeedChildBarragePresenter", 1, localStringBuilder.toString());
      this.f = f();
      this.f.a(localContext, localTextureView);
      this.f.a(new FSFeedChildBarragePresenter.FSBarrageListenerImpl(this));
      this.f.a(new FSFeedChildBarragePresenter.FSBarrageLoadMoreListenerImpl(this));
      this.f.a(new FSFeedChildBarragePresenter.FSBarrageClickPopupListenerImpl(this, this));
      this.f.a((FeedCloudMeta.StFeed)this.b);
      this.f.a(this.j, this.i, this.h);
      int i1 = FSCommentManager.a().c(str);
      if (i1 == 0)
      {
        i2 = this.i;
        if (i2 > 0)
        {
          QLog.d("DM-FSFeedChildBarragePresenter", 1, new Object[] { "[tryUpdateDataSourceToBarrageView] send update comment total event, count: ", Integer.valueOf(i2), " | comment cache num: ", Integer.valueOf(i1) });
          SimpleEventBus.getInstance().dispatchEvent(new FSUpdateCommentTotalEvent(str, this.i));
        }
      }
    }
  }
  
  private Context p()
  {
    ViewGroup localViewGroup = this.g;
    if (localViewGroup == null)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[getViewContext()] barrage layout should not be null.");
      return null;
    }
    return localViewGroup.getContext();
  }
  
  private TextureView q()
  {
    Object localObject = p();
    if (localObject == null)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[createTextureView] context should not be null.");
      return null;
    }
    localObject = LayoutInflater.from((Context)localObject).inflate(2131624796, null);
    b((View)localObject);
    return (TextureView)((View)localObject).findViewById(2131433360);
  }
  
  private void r()
  {
    IFSBarrageViewModel localIFSBarrageViewModel = this.f;
    if (localIFSBarrageViewModel == null)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[checkBarrageStart] barrage view model should not be null.");
      return;
    }
    if (localIFSBarrageViewModel.f() == 4) {
      s();
    }
  }
  
  private void s()
  {
    IFSBarrageViewModel localIFSBarrageViewModel = this.f;
    if (localIFSBarrageViewModel == null)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[startBarrage] barrage view mode should not be null.");
      return;
    }
    if (this.o)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[startBarrage] video pause, not start barrage.");
      return;
    }
    localIFSBarrageViewModel.a();
  }
  
  private String t()
  {
    if (this.b == null) {
      return "null";
    }
    return ((FeedCloudMeta.StFeed)this.b).id.get();
  }
  
  private void u()
  {
    if (this.l)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[handlerBarrageLoadMore] request more loading flag is true.");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[handlerBarrageLoadMore] handler barrage load more, current feed id: ");
    ((StringBuilder)localObject).append(t());
    ((StringBuilder)localObject).append(" | hash code: ");
    ((StringBuilder)localObject).append(hashCode());
    QLog.d("DM-FSFeedChildBarragePresenter", 1, ((StringBuilder)localObject).toString());
    this.l = true;
    localObject = FSLoadBarrageListBean.a();
    ((FSLoadBarrageListBean)localObject).a((FeedCloudMeta.StFeed)this.b);
    ((FSLoadBarrageListBean)localObject).a(true);
    ((FSLoadBarrageListBean)localObject).a(hashCode());
    FSBarrageModel.a().a((FSLoadBarrageListBean)localObject);
  }
  
  private void v()
  {
    IFSBarrageViewModel localIFSBarrageViewModel = this.f;
    if (localIFSBarrageViewModel == null)
    {
      QLog.d("DM-FSFeedChildBarragePresenter", 1, "[handleBarragePopupDismiss] barrage view model should not be null.");
      return;
    }
    localIFSBarrageViewModel.g();
  }
  
  public void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.g = ((ViewGroup)paramView.findViewById(2131433359));
  }
  
  public void a(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    if (paramFSFeedSelectInfo == null) {
      return;
    }
    if (paramFSFeedSelectInfo.b() != this.c) {
      return;
    }
    String str = t();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" | isPausedState: ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(" | hashCode: ");
    QLog.d("DM-FSFeedChildBarragePresenter", 1, new Object[] { "[onResumed] selectInfo: ", paramFSFeedSelectInfo, localStringBuilder.toString(), Integer.valueOf(hashCode()), " | feedId: ", str });
    h();
    this.m = false;
  }
  
  public void a(FSBaseFeedPresenterEvent paramFSBaseFeedPresenterEvent)
  {
    if ((paramFSBaseFeedPresenterEvent instanceof FSVideoProgressChangeEvent))
    {
      a((FSVideoProgressChangeEvent)paramFSBaseFeedPresenterEvent);
      return;
    }
    if ((paramFSBaseFeedPresenterEvent instanceof FSVideoStatusEvent)) {
      a((FSVideoStatusEvent)paramFSBaseFeedPresenterEvent);
    }
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.b;
    super.a(paramStFeed, paramInt);
    if (FSCommonUtil.a(paramStFeed, localStFeed)) {
      return;
    }
    if (paramStFeed == null)
    {
      paramStFeed = new StringBuilder();
      paramStFeed.append("onBindData is null: ");
      paramStFeed.append(paramInt);
      QLog.d("DM-FSFeedChildBarragePresenter", 1, paramStFeed.toString());
      return;
    }
    this.b = paramStFeed;
    QLog.d("DM-FSFeedChildBarragePresenter", 1, new Object[] { "[onBindData] position: ", Integer.valueOf(paramInt) });
  }
  
  public void b()
  {
    QLog.d("DM-FSFeedChildBarragePresenter", 1, new Object[] { "[onAttachedToWindow] current attached to window, hash code: ", Integer.valueOf(hashCode()) });
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  public void c()
  {
    QLog.d("DM-FSFeedChildBarragePresenter", 1, new Object[] { "[onDetachedFromWindow] current detached from window, hash code: ", Integer.valueOf(hashCode()) });
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    l();
  }
  
  public void c(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    super.c(paramFSFeedSelectInfo);
    if (paramFSFeedSelectInfo == null) {
      return;
    }
    if (paramFSFeedSelectInfo.b() != this.c) {
      return;
    }
    String str = t();
    QLog.d("DM-FSFeedChildBarragePresenter", 1, new Object[] { "[onPaused] selectInfo: ", paramFSFeedSelectInfo, " | hashCode: ", Integer.valueOf(hashCode()), " | feedId: ", str });
    n();
    this.m = true;
  }
  
  public void d(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    if (paramFSFeedSelectInfo == null) {
      return;
    }
    if (paramFSFeedSelectInfo.b() != this.c) {
      return;
    }
    i();
    QLog.d("DM-FSFeedChildBarragePresenter", 1, new Object[] { "[onFeedSelected] selectInfo: ", paramFSFeedSelectInfo, " | hashCode: ", Integer.valueOf(hashCode()) });
    k();
  }
  
  public void e(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    if (paramFSFeedSelectInfo == null) {
      return;
    }
    if (paramFSFeedSelectInfo.b() != this.c) {
      return;
    }
    String str = t();
    QLog.d("DM-FSFeedChildBarragePresenter", 1, new Object[] { "[onFeedUnSelected] selectInfo: ", paramFSFeedSelectInfo, " | hashCode: ", Integer.valueOf(hashCode()), " | feedId: ", str });
    l();
    i();
  }
  
  public ArrayList getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(FSGetBarrageEvent.class);
    localArrayList.add(FSCloseBarrageEvent.class);
    localArrayList.add(FSOpenBarrageEvent.class);
    localArrayList.add(FSSeekEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof FSGetBarrageEvent))
    {
      a((FSGetBarrageEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof FSCloseBarrageEvent))
    {
      a((FSCloseBarrageEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof FSOpenBarrageEvent))
    {
      a((FSOpenBarrageEvent)paramSimpleBaseEvent);
      return;
    }
    if ((paramSimpleBaseEvent instanceof FSSeekEvent)) {
      a((FSSeekEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildBarragePresenter
 * JD-Core Version:    0.7.0.1
 */