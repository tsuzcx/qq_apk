package com.tencent.mobileqq.flashshow.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;
import com.tencent.biz.qqcircle.utils.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.BlockMerger;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.block.base.NestScrollRecyclerView;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.flashshow.api.bean.FSLayerPageInitBean;
import com.tencent.mobileqq.flashshow.api.data.DataBuilder;
import com.tencent.mobileqq.flashshow.basedata.FSFeedData;
import com.tencent.mobileqq.flashshow.config.FSConfig;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.data.FSRecentlyFeedStateData;
import com.tencent.mobileqq.flashshow.events.FSFeedLikeStateUpdateEvent;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.mobileqq.flashshow.part.FSBaseBlockPart;
import com.tencent.mobileqq.flashshow.personal.adapter.FSPersonalFeedAdapter;
import com.tencent.mobileqq.flashshow.personal.bean.FSPersonalFeedInfo;
import com.tencent.mobileqq.flashshow.personal.part.FSPersonalHintViewPart;
import com.tencent.mobileqq.flashshow.personal.viewmodel.FSPersonalViewModel;
import com.tencent.mobileqq.flashshow.personal.widget.FSPersonalBottomWidget.OnJustSeeListener;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11001;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.DataBuilder;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FSPersonalFeedFragment
  extends FSBaseFragment
  implements Observer<FSRecentlyFeedStateData>
{
  private BlockPart b;
  private FSPersonalHintViewPart c;
  private RecyclerView d;
  private SafeGridLayoutManager e;
  private FSPersonalFeedAdapter f;
  private FSPersonalHomeFragment g;
  private FSPersonalViewModel h;
  private FSPersonalBottomWidget.OnJustSeeListener i;
  private RecyclerView.OnScrollListener j;
  private String k;
  private FeedCloudMeta.StFeed l;
  private int m = -1;
  private String n = "";
  
  public static FSPersonalFeedFragment a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("fs_key_bundle_params_feed_type", paramString);
    paramString = new FSPersonalFeedFragment();
    paramString.setArguments(localBundle);
    return paramString;
  }
  
  private void a(int paramInt, FSPersonalFeedInfo paramFSPersonalFeedInfo)
  {
    if (paramFSPersonalFeedInfo == null) {
      return;
    }
    FSLayerPageInitBean localFSLayerPageInitBean = new FSLayerPageInitBean(f());
    localFSLayerPageInitBean.setSourceType(1);
    localFSLayerPageInitBean.setFeedId(paramFSPersonalFeedInfo.a().id.get());
    localFSLayerPageInitBean.setUserId(paramFSPersonalFeedInfo.a().poster.id.get());
    localFSLayerPageInitBean.setCreateTime(paramFSPersonalFeedInfo.a().createTime.get());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(2001);
    ((StringBuilder)localObject).append(y());
    localFSLayerPageInitBean.setGlobalViewModelKey(((StringBuilder)localObject).toString());
    localFSLayerPageInitBean.setPersonFeedType(this.k);
    localFSLayerPageInitBean.setFeedPosition(paramInt);
    if (paramFSPersonalFeedInfo.a() != null) {
      localObject = paramFSPersonalFeedInfo.a().id.get();
    } else {
      localObject = "";
    }
    localFSLayerPageInitBean.setFeedId((String)localObject);
    FSNativeLauncher.a(getContext(), localFSLayerPageInitBean);
    a(paramFSPersonalFeedInfo);
  }
  
  private void a(FSFeedLikeStateUpdateEvent paramFSFeedLikeStateUpdateEvent)
  {
    Object localObject = this.h;
    if ((localObject != null) && (FSCommonUtil.a(((FSPersonalViewModel)localObject).h())) && (TextUtils.equals(this.k, "fs_feed_type_personal_praised")))
    {
      localObject = paramFSFeedLikeStateUpdateEvent.getFeedId();
      if (paramFSFeedLikeStateUpdateEvent.getLikeState() == 1)
      {
        paramFSFeedLikeStateUpdateEvent = (FSFeedData)FSDataCenter.a().a("FSFeedDataStore", (String)localObject);
        if (paramFSFeedLikeStateUpdateEvent != null) {
          this.f.addData(paramFSFeedLikeStateUpdateEvent, 0);
        }
      }
      else
      {
        paramFSFeedLikeStateUpdateEvent = this.f.getDataList().iterator();
        while (paramFSFeedLikeStateUpdateEvent.hasNext()) {
          if (TextUtils.equals(((FSFeedData)paramFSFeedLikeStateUpdateEvent.next()).b().id.get(), (CharSequence)localObject)) {
            paramFSFeedLikeStateUpdateEvent.remove();
          }
        }
      }
    }
    this.f.notifyDataSetChanged();
  }
  
  private void a(FSPersonalFeedInfo paramFSPersonalFeedInfo)
  {
    if (paramFSPersonalFeedInfo == null) {
      return;
    }
    Object localObject = new DataBuilder(f()).setActionType(11);
    if (TextUtils.equals(this.k, "fs_feed_type_personal_praised")) {
      i1 = 21;
    } else if (paramFSPersonalFeedInfo.d()) {
      i1 = 60;
    } else {
      i1 = 19;
    }
    localObject = ((DataBuilder)localObject).setSubActionType(i1);
    boolean bool = TextUtils.equals(this.k, "fs_feed_type_personal_praised");
    int i1 = 7;
    if ((!bool) && (paramFSPersonalFeedInfo.d())) {
      i1 = 4;
    }
    FSLpReportDc11001.a(((DataBuilder)localObject).setThrActionType(i1).setToUin(y()).setExt6(paramFSPersonalFeedInfo.a().id.get()));
    localObject = new FSLpReportDc11002.DataBuilder(paramFSPersonalFeedInfo.a(), f());
    if (TextUtils.equals(this.k, "fs_feed_type_personal_production")) {
      i1 = 144;
    } else {
      i1 = 145;
    }
    FSLpReportDc11002.a(((FSLpReportDc11002.DataBuilder)localObject).a(i1).b(2).q(paramFSPersonalFeedInfo.b()));
  }
  
  private void a(UIStateData<List<FSFeedData>> paramUIStateData)
  {
    boolean bool = paramUIStateData.h();
    int i3 = paramUIStateData.c();
    int i1 = 0;
    int i2 = 0;
    if (i3 != 0)
    {
      if (i3 == 1) {
        break label118;
      }
      i1 = i2;
      if (i3 != 2)
      {
        if (i3 != 3)
        {
          if (i3 == 4) {
            b(paramUIStateData.f());
          }
        }
        else {
          i1 = 1;
        }
      }
      else
      {
        n();
        if (!paramUIStateData.i()) {
          this.m = -1;
        }
        a((List)paramUIStateData.e());
        b((List)paramUIStateData.e());
        b(paramUIStateData.m());
        break label118;
      }
    }
    else
    {
      o();
    }
    i1 = 1;
    label118:
    paramUIStateData = this.f;
    if (paramUIStateData != null)
    {
      paramUIStateData.getLoadInfo().a(bool);
      if (i1 != 0) {
        this.f.notifyLoadingComplete(true, bool);
      }
    }
  }
  
  private void a(List<FSFeedData> paramList)
  {
    FSPersonalFeedAdapter localFSPersonalFeedAdapter = this.f;
    if (localFSPersonalFeedAdapter == null) {
      return;
    }
    localFSPersonalFeedAdapter.clearData();
    this.f.getDataList().addAll(paramList);
    this.f.notifyDataSetChanged();
    this.c.d();
  }
  
  private void b(String paramString)
  {
    QLog.i("FSPersonalFeedFragment", 1, paramString);
    this.c.b(paramString);
  }
  
  private void b(List<FSFeedData> paramList)
  {
    Object localObject = this.l;
    if (localObject != null)
    {
      if (this.m != -1) {
        return;
      }
      localObject = ((FeedCloudMeta.StFeed)localObject).id.get();
      int i1 = 0;
      while (i1 < paramList.size())
      {
        if (TextUtils.equals((CharSequence)localObject, ((FSFeedData)paramList.get(i1)).b().id.get()))
        {
          this.m = i1;
          w();
        }
        i1 += 1;
      }
      if (!x()) {
        c(true);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    FeedCloudMeta.StFeed localStFeed = this.l;
    if ((localStFeed != null) && (this.m == -1))
    {
      if (paramBoolean) {
        return;
      }
      this.h.a(localStFeed.id.get(), this.l.createTime.get());
    }
  }
  
  private void c(boolean paramBoolean)
  {
    FSPersonalBottomWidget.OnJustSeeListener localOnJustSeeListener = this.i;
    if (localOnJustSeeListener != null) {
      localOnJustSeeListener.a(paramBoolean);
    }
  }
  
  private List<MultiViewBlock> h()
  {
    ArrayList localArrayList = new ArrayList();
    this.f = new FSPersonalFeedAdapter(getArguments());
    this.f.setOnLoadDataDelegate(new FSPersonalFeedFragment.1(this));
    this.f.a(new FSPersonalFeedFragment.2(this));
    localArrayList.add(this.f);
    return localArrayList;
  }
  
  private void i()
  {
    this.b.i().getRecyclerView().setNestedScrollingEnabled(true);
    this.b.i().setEnableRefresh(false);
    this.b.i().setEnableLoadMore(true);
    this.b.i().setParentFragment(this);
  }
  
  private void k()
  {
    Object localObject = this.g;
    if (localObject == null)
    {
      QLog.i("FSPersonalFeedFragment", 1, "fsPersonalHomeFragment is null");
      return;
    }
    this.h = ((FSPersonalViewModel)getViewModel((IPartHost)localObject, null, FSPersonalViewModel.class));
    if (this.h == null)
    {
      QLog.i("FSPersonalFeedFragment", 1, "mViewModel is null");
      return;
    }
    localObject = this.k;
    int i1 = ((String)localObject).hashCode();
    if (i1 != -1956787041)
    {
      if ((i1 == -508647646) && (((String)localObject).equals("fs_feed_type_personal_production")))
      {
        i1 = 0;
        break label111;
      }
    }
    else if (((String)localObject).equals("fs_feed_type_personal_praised"))
    {
      i1 = 1;
      break label111;
    }
    i1 = -1;
    label111:
    if (i1 != 0)
    {
      if (i1 != 1) {
        return;
      }
      m();
      return;
    }
    l();
  }
  
  private void l()
  {
    FSPersonalViewModel localFSPersonalViewModel = this.h;
    if (localFSPersonalViewModel != null)
    {
      if (localFSPersonalViewModel.e() == null) {
        return;
      }
      this.h.e().observe(this, new FSPersonalFeedFragment.3(this));
      FSDataCenter.a().a(this);
    }
  }
  
  private void m()
  {
    FSPersonalViewModel localFSPersonalViewModel = this.h;
    if (localFSPersonalViewModel != null)
    {
      if (localFSPersonalViewModel.f() == null) {
        return;
      }
      this.h.f().observe(this, new FSPersonalFeedFragment.4(this));
    }
  }
  
  private void n()
  {
    BlockPart localBlockPart = this.b;
    if (localBlockPart != null)
    {
      localBlockPart.i().getBlockMerger().b(1);
      this.b.i().getBlockMerger().l();
    }
  }
  
  private void o()
  {
    String str = this.k;
    int i1 = str.hashCode();
    if (i1 != -1956787041)
    {
      if ((i1 == -508647646) && (str.equals("fs_feed_type_personal_production")))
      {
        i1 = 0;
        break label58;
      }
    }
    else if (str.equals("fs_feed_type_personal_praised"))
    {
      i1 = 1;
      break label58;
    }
    i1 = -1;
    label58:
    if (i1 != 0)
    {
      if (i1 != 1) {
        return;
      }
      this.c.a(FSConfig.k());
      return;
    }
    this.c.a(FSConfig.j());
  }
  
  private void u()
  {
    FSPersonalFeedAdapter localFSPersonalFeedAdapter = this.f;
    if (localFSPersonalFeedAdapter != null)
    {
      if (this.h == null) {
        return;
      }
      this.d = localFSPersonalFeedAdapter.getParentRecyclerView();
      if ((this.d.getLayoutManager() instanceof SafeGridLayoutManager)) {
        this.e = ((SafeGridLayoutManager)this.d.getLayoutManager());
      }
      this.d.addOnScrollListener(new FSPersonalFeedFragment.5(this));
      this.f.a(this.h.h());
    }
  }
  
  private void w()
  {
    if (this.f != null)
    {
      if (this.d == null) {
        return;
      }
      this.j = new FSPersonalFeedFragment.6(this);
      this.d.addOnScrollListener(this.j);
    }
  }
  
  private boolean x()
  {
    SafeGridLayoutManager localSafeGridLayoutManager = this.e;
    boolean bool = true;
    if (localSafeGridLayoutManager == null) {
      return true;
    }
    int i1 = localSafeGridLayoutManager.findFirstVisibleItemPosition();
    int i2 = this.e.findLastVisibleItemPosition();
    if (this.m >= i1 + 6)
    {
      if (i2 + 1 == this.f.getDataList().size()) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private String y()
  {
    if (TextUtils.isEmpty(this.n))
    {
      FSPersonalViewModel localFSPersonalViewModel = this.h;
      if (localFSPersonalViewModel != null) {
        this.n = localFSPersonalViewModel.h();
      }
    }
    return this.n;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    this.g = ((FSPersonalHomeFragment)getParentFragment());
    i();
    k();
    u();
  }
  
  public void a(FSRecentlyFeedStateData paramFSRecentlyFeedStateData)
  {
    if ((paramFSRecentlyFeedStateData != null) && (!FSCommonUtil.a(y())))
    {
      if (!TextUtils.equals(paramFSRecentlyFeedStateData.b.id.get(), y())) {
        return;
      }
      this.l = paramFSRecentlyFeedStateData.a;
      paramFSRecentlyFeedStateData = this.f;
      if (paramFSRecentlyFeedStateData != null)
      {
        FeedCloudMeta.StFeed localStFeed = this.l;
        if ((localStFeed != null) && (this.i != null)) {
          paramFSRecentlyFeedStateData.b(localStFeed.id.get());
        }
      }
    }
  }
  
  public void a(FSPersonalBottomWidget.OnJustSeeListener paramOnJustSeeListener)
  {
    this.i = paramOnJustSeeListener;
  }
  
  protected boolean a(RecyclerView paramRecyclerView)
  {
    boolean bool = false;
    if (paramRecyclerView == null) {
      return false;
    }
    if (paramRecyclerView.computeVerticalScrollExtent() + paramRecyclerView.computeVerticalScrollOffset() >= paramRecyclerView.computeVerticalScrollRange()) {
      bool = true;
    }
    return bool;
  }
  
  public String b()
  {
    return "FSPersonalFeedFragment";
  }
  
  protected int c()
  {
    return 2131624836;
  }
  
  protected List<Part> d()
  {
    ArrayList localArrayList = new ArrayList();
    this.b = new BlockPart(2131433866, h(), 2, 3);
    this.c = new FSPersonalHintViewPart();
    localArrayList.add(this.b);
    localArrayList.add(this.c);
    return localArrayList;
  }
  
  public String e()
  {
    return "pg_ks_profile";
  }
  
  public void g()
  {
    if (this.d == null)
    {
      QLog.i("FSPersonalFeedFragment", 1, "mRecyclerView is null");
      return;
    }
    if (this.m != -1)
    {
      try
      {
        this.g.g().i().getRecyclerView().smoothScrollBy(0, DisplayUtil.e());
      }
      catch (Exception localException)
      {
        QLog.i("FSPersonalFeedFragment", 1, localException.getMessage());
      }
      this.d.smoothScrollToPosition(this.m + 6);
      c(false);
      this.d.removeOnScrollListener(this.j);
      FSLpReportDc11001.a(new DataBuilder(f()).setActionType(11).setSubActionType(60).setThrActionType(2).setToUin(y()));
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = super.getEventClass();
    localArrayList.add(FSFeedLikeStateUpdateEvent.class);
    return localArrayList;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() == null) {
      return;
    }
    this.k = getArguments().getString("fs_key_bundle_params_feed_type");
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
    if ((paramSimpleBaseEvent instanceof FSFeedLikeStateUpdateEvent)) {
      a((FSFeedLikeStateUpdateEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.fragment.FSPersonalFeedFragment
 * JD-Core Version:    0.7.0.1
 */