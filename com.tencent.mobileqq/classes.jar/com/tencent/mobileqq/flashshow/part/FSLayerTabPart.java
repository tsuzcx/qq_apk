package com.tencent.mobileqq.flashshow.part;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.config.RFWCommonConfig;
import com.tencent.mobileqq.flashshow.adapter.FSLayerPageAdapter;
import com.tencent.mobileqq.flashshow.api.bean.FSFolderBean;
import com.tencent.mobileqq.flashshow.api.bean.FSInitBean;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.bean.FSLayerHeadViewRefreshInfo;
import com.tencent.mobileqq.flashshow.bean.FSMainTabInfo;
import com.tencent.mobileqq.flashshow.config.FSConfig;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.data.FSRecentlyFeedStateData;
import com.tencent.mobileqq.flashshow.events.FSFeedEvent;
import com.tencent.mobileqq.flashshow.ioc.IFSFeedIoc;
import com.tencent.mobileqq.flashshow.ioc.IFSTabFragmentIoc;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.mobileqq.flashshow.view.FSPageTurnContainer;
import com.tencent.mobileqq.flashshow.viewmodel.tab.FSTabFeedViewModel;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;

public class FSLayerTabPart
  extends FSLayerBasePart
  implements IFSFeedIoc
{
  private final FSTabFeedViewModel g;
  private final FSMainTabInfo h;
  private int i;
  private IFSTabFragmentIoc j;
  private int k;
  private String l = null;
  private FSFolderBean m;
  
  public FSLayerTabPart(FSMainTabInfo paramFSMainTabInfo)
  {
    y();
    this.h = paramFSMainTabInfo;
    this.g = new FSTabFeedViewModel(paramFSMainTabInfo);
    this.i = 0;
  }
  
  private void A()
  {
    this.a.setOnRefreshViewStatusListener(new FSLayerTabPart.3(this));
    b(false);
  }
  
  private void B()
  {
    if (!TextUtils.isEmpty(this.l)) {
      u();
    }
  }
  
  private boolean H()
  {
    return cr_() == f();
  }
  
  private void a(boolean paramBoolean, int paramInt, float paramFloat)
  {
    if (paramBoolean) {
      return;
    }
    FSLayerHeadViewRefreshInfo localFSLayerHeadViewRefreshInfo = new FSLayerHeadViewRefreshInfo(paramInt);
    localFSLayerHeadViewRefreshInfo.a(paramFloat);
    this.j.a("event_layer_head_view_refresh_status", new Object[] { localFSLayerHeadViewRefreshInfo });
  }
  
  private void c(int paramInt)
  {
    if ((this.b != null) && (this.b.getDataList() != null) && (this.b.getDataList().size() > paramInt))
    {
      if (!H()) {
        return;
      }
      FeedCloudMeta.StFeed localStFeed = ((FSFeedData)this.b.getDataList().get(paramInt)).b();
      FSRecentlyFeedStateData localFSRecentlyFeedStateData = new FSRecentlyFeedStateData();
      localFSRecentlyFeedStateData.a = localStFeed;
      localFSRecentlyFeedStateData.b = ((FeedCloudMeta.StUser)localStFeed.poster.get());
      FSDataCenter.a().b().setValue(localFSRecentlyFeedStateData);
    }
  }
  
  private String x()
  {
    if (this.h.b() == 40) {
      return FSConfig.h();
    }
    if (this.h.b() == 41) {
      return FSConfig.m();
    }
    return "";
  }
  
  private void y()
  {
    if (c() == null) {
      return;
    }
    Object localObject = c().getIntent();
    if ((localObject != null) && (((Intent)localObject).hasExtra("fs_key_bundle_common_init_bean")))
    {
      localObject = ((Intent)localObject).getSerializableExtra("fs_key_bundle_common_init_bean");
      if ((localObject instanceof FSFolderBean)) {
        this.m = ((FSFolderBean)localObject);
      }
    }
  }
  
  private void z()
  {
    this.g.b().observe(j(), new FSLayerTabPart.2(this));
    A();
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FSLayerTabPart_");
    localStringBuilder.append(this.h.a());
    return localStringBuilder.toString();
  }
  
  protected void a(int paramInt)
  {
    super.a(paramInt);
    c(paramInt);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.b.a(this);
    z();
  }
  
  protected void a(FSFeedEvent paramFSFeedEvent)
  {
    super.a(paramFSFeedEvent);
    e(paramFSFeedEvent);
  }
  
  public void a(IFSTabFragmentIoc paramIFSTabFragmentIoc)
  {
    this.j = paramIFSTabFragmentIoc;
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    IFSTabFragmentIoc localIFSTabFragmentIoc = this.j;
    if (localIFSTabFragmentIoc != null) {
      localIFSTabFragmentIoc.a(paramString, paramVarArgs);
    }
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b(int paramInt)
  {
    this.k = paramInt;
  }
  
  protected void b(boolean paramBoolean)
  {
    w();
    if (paramBoolean)
    {
      QLog.i(a(), 1, "requestData() loadMore");
      this.g.a(this.i, true);
      return;
    }
    QLog.i(a(), 1, "requestData() refresh");
    this.g.a(this.i, false);
  }
  
  protected void c(FSFeedEvent paramFSFeedEvent)
  {
    if (this.h.b() != 40) {
      return;
    }
    if (paramFSFeedEvent.getStatus() == 2)
    {
      if (this.b == null) {
        return;
      }
      this.l = paramFSFeedEvent.getUin();
      B();
    }
  }
  
  public int cr_()
  {
    return this.k;
  }
  
  public FSInitBean d()
  {
    return this.m;
  }
  
  public int e()
  {
    IFSTabFragmentIoc localIFSTabFragmentIoc = this.j;
    if (localIFSTabFragmentIoc != null) {
      return localIFSTabFragmentIoc.e();
    }
    return -1;
  }
  
  protected void e(FSFeedEvent paramFSFeedEvent)
  {
    if (this.h.b() != 40) {
      return;
    }
    if (paramFSFeedEvent.getStatus() != 3) {
      return;
    }
    if ((this.b != null) && (t())) {
      b(false);
    }
  }
  
  public int f()
  {
    IFSTabFragmentIoc localIFSTabFragmentIoc = this.j;
    if (localIFSTabFragmentIoc != null) {
      return localIFSTabFragmentIoc.f();
    }
    return -1;
  }
  
  protected boolean m()
  {
    return RFWCommonConfig.d();
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    c(this.d);
  }
  
  protected void q()
  {
    p();
    if (t()) {
      a(x());
    }
  }
  
  protected void u()
  {
    FSThreadUtils.a(new FSLayerTabPart.1(this), 200L);
  }
  
  public void v()
  {
    this.a.d();
  }
  
  protected void w()
  {
    boolean bool = H();
    this.i = (bool ^ true);
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initPullSceneType isRealVisibleToUser :");
    localStringBuilder.append(bool);
    localStringBuilder.append(",SceneType : ");
    localStringBuilder.append(this.i);
    QLog.d(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSLayerTabPart
 * JD-Core Version:    0.7.0.1
 */