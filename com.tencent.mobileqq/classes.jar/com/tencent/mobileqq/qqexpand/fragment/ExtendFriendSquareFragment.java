package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.qqexpand.bean.feed.CacheData;
import com.tencent.mobileqq.qqexpand.bean.feed.CacheData.TagCache;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.bean.match.MatchFeedInfo;
import com.tencent.mobileqq.qqexpand.config.banner.ExpandBannerConfBean.BannerItem;
import com.tencent.mobileqq.qqexpand.feed.FeedBannerInfo;
import com.tencent.mobileqq.qqexpand.feed.FeedBannerTabItem;
import com.tencent.mobileqq.qqexpand.feed.FeedViewHolder;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendBottomBarView;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView.OnClickListener;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendCampusVerifyTipsView.TipsType;
import com.tencent.mobileqq.qqexpand.widget.WrapContentLinearLayoutManager;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.ILoadingLayout;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.OnRefreshListener2;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase.State;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.extras.PullToRefreshRecyclerView;
import com.tencent.mobileqq.qqexpand.widget.search.ExpandSearchBarView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.NearbyZanAnimLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class ExtendFriendSquareFragment
  extends ExtendFriendBaseFragment
  implements ExtendFriendCampusVerifyTipsView.OnClickListener, PullToRefreshBase.OnRefreshListener2<RecyclerView>
{
  public boolean T = false;
  public int U = 0;
  public int V = 480;
  public long W = -1L;
  private WeakReferenceHandler X;
  private final FriendObserver Y = new ExtendFriendSquareFragment.1(this);
  private boolean Z;
  private boolean aa;
  private boolean ab;
  private boolean ac;
  private int ad = 1;
  private byte[] ae;
  private int af;
  private long ag;
  private int ah = -1;
  private boolean ai;
  private final MatchFeedInfo aj = new MatchFeedInfo();
  private final FeedBannerInfo ak = new FeedBannerInfo();
  private ExpandSearchBarView al;
  private ExtendFriendBottomBarView am;
  private boolean an;
  private ExtendFriendReporter ao;
  private int ap;
  private boolean aq = false;
  private final ExpandObserver ar = new ExtendFriendSquareFragment.2(this);
  
  private void a(int paramInt, float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateSearchBarState scrollY: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("  speed: ");
      ((StringBuilder)localObject).append(paramFloat);
      QLog.i("ExtendFriendSquareFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.al;
    if (localObject != null) {
      if (paramInt < this.V)
      {
        if (paramInt > this.ap / 2)
        {
          if (paramFloat > 0.0F) {
            ((ExpandSearchBarView)localObject).b();
          }
        }
        else {
          ((ExpandSearchBarView)localObject).a();
        }
      }
      else if (paramFloat < -5.0F) {
        ((ExpandSearchBarView)localObject).a();
      } else if (paramFloat > 0.5D) {
        ((ExpandSearchBarView)localObject).b();
      }
    }
    d(false);
  }
  
  private void a(View paramView)
  {
    VideoReport.addToDetectionWhitelist(getQBaseActivity());
    VideoReport.setPageId(paramView, "voice_tab");
    VideoReport.setPageParams(paramView, new ExpandDTParamBuilder().a());
    QLog.i("ExtendFriendSquareFragment", 1, "reportDaTongRegister");
  }
  
  private void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendSquareFragment", 2, String.format("updateAddFrdState count=%d", new Object[] { Integer.valueOf(paramList.size()) }));
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (String)paramList.next();
      int i = this.m.a((String)localObject);
      if (i >= 0)
      {
        localObject = this.m.b(i);
        if ((localObject != null) && (!((StrangerInfo)localObject).mAddFriendVerified))
        {
          ((StrangerInfo)localObject).mAddFriendVerified = true;
          this.m.notifyItemChanged(i);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<StrangerInfo> paramList, MatchFeedInfo paramMatchFeedInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList success=%s searchKey=%s", new Object[] { Boolean.valueOf(paramBoolean1), paramString }));
    }
    if (isAdded())
    {
      if (this.m == null) {
        return;
      }
      paramString = this.p.getTag(2131444519);
      int i;
      if ((paramString != null) && ((paramString instanceof Integer))) {
        i = ((Integer)paramString).intValue();
      } else {
        i = 0;
      }
      this.m.d(paramBoolean1 ^ true);
      int j = 2131896879;
      if ((paramBoolean1) && (paramList != null))
      {
        this.ac = paramBoolean2;
        this.ae = paramArrayOfByte;
        this.y = paramBoolean3;
        this.z = paramBoolean4;
        this.af = paramInt;
        this.aj.a = paramMatchFeedInfo.a;
        this.aj.b = paramMatchFeedInfo.b;
        this.aj.d = paramMatchFeedInfo.d;
        this.aj.c.clear();
        this.aj.c.addAll(paramMatchFeedInfo.c);
        this.am.a(this.aj.c);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendSquareFragment", 2, String.format("handleGetSquareStrangerList mLoadOver=%s mRequestCookies=%s mProfileComplete=%s mShowCard=%s mMaxLikeCount=%s matchCount=%d limitDuration=%d", new Object[] { Boolean.valueOf(this.ac), this.ae, Boolean.valueOf(this.y), Boolean.valueOf(this.z), Integer.valueOf(this.af), Integer.valueOf(paramMatchFeedInfo.a), Integer.valueOf(paramMatchFeedInfo.b) }));
        }
        if (!this.ab)
        {
          this.m.c();
          w();
        }
        if (this.ac) {
          this.m.a(2, false);
        }
        this.m.a(paramList);
        if (this.n != null)
        {
          paramString = this.n.a(true, false);
          if (paramString != null)
          {
            this.ag = System.currentTimeMillis();
            this.ah = Calendar.getInstance().get(6);
            paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131916800), TimeFormatterUtils.a(this.ag, true, "yyyy-MM-dd") }));
          }
        }
        x();
      }
      else
      {
        if (this.ab) {
          this.m.a(1, true);
        }
        if (this.ad == 0) {
          paramInt = 2131892406;
        } else {
          paramInt = 2131896879;
        }
        if (i == 1) {
          if (this.ad == 0) {
            paramInt = 2131892406;
          } else {
            paramInt = 2131896857;
          }
        }
        a(getString(paramInt), 1);
      }
      if (this.m.getItemCount() == 0) {
        this.m.a(true);
      }
      this.m.notifyDataSetChanged();
      if ((!this.ab) && (this.n != null))
      {
        paramInt = j;
        if (paramBoolean1) {
          paramInt = 2131896881;
        }
        if (i == 1) {
          if (paramBoolean1) {
            paramInt = 2131896858;
          } else {
            paramInt = 2131896857;
          }
        }
        paramString = getResources().getString(paramInt);
        this.n.a(true, false).setRefreshResultLabel(paramString);
        this.n.f();
        j(0);
      }
      this.aa = false;
      l();
      c(true);
    }
  }
  
  private boolean a(boolean paramBoolean, String paramString)
  {
    List localList = this.l.b(2);
    Object localObject2 = ((IExpandManager)this.i.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).m();
    if ((localObject2 != null) && (((CacheData)localObject2).a != null) && (((CacheData)localObject2).a.size() > 0))
    {
      Object localObject1;
      if (paramBoolean)
      {
        localObject1 = ((CacheData)localObject2).a();
        paramString = (String)localObject1;
        if (localObject1 != null)
        {
          paramString = (String)localObject1;
          if (((CacheData.TagCache)localObject1).a.size() > 0)
          {
            paramString = (String)localObject1;
            if (!localList.contains(((CacheData.TagCache)localObject1).e)) {}
          }
        }
      }
      boolean bool;
      for (paramString = (String)localObject1;; paramString = (String)localObject1)
      {
        bool = true;
        break;
        do
        {
          do
          {
            bool = false;
            break;
            localObject1 = ((CacheData)localObject2).a(paramString);
            paramString = (String)localObject1;
          } while (localObject1 == null);
          paramString = (String)localObject1;
        } while (((CacheData.TagCache)localObject1).a.size() <= 0);
      }
      if (bool)
      {
        this.y = ((CacheData)localObject2).b;
        this.z = ((CacheData)localObject2).c;
        this.af = ((CacheData)localObject2).d;
        this.ac = paramString.f;
        this.ae = paramString.d;
        this.ag = paramString.b;
        this.ah = paramString.c;
        this.N = paramString.e;
        int i = paramString.g;
        int j = paramString.h;
        if (paramString.a.size() > 0)
        {
          localObject1 = (StrangerInfo)paramString.a.get(0);
          if ((localObject1 instanceof MatchFeedInfo))
          {
            localObject1 = (MatchFeedInfo)localObject1;
            localObject2 = this.aj;
            if (localObject2 != localObject1)
            {
              ((MatchFeedInfo)localObject2).a = ((MatchFeedInfo)localObject1).a;
              this.aj.b = ((MatchFeedInfo)localObject1).b;
              this.aj.d = ((MatchFeedInfo)localObject1).d;
              this.aj.c.clear();
              this.aj.c.addAll(((MatchFeedInfo)localObject1).c);
              this.am.a(this.aj.c);
            }
          }
        }
        if (paramBoolean)
        {
          int k = localList.indexOf(this.N);
          this.al.setSearchTags((ArrayList)localList, k);
        }
        if (this.m != null)
        {
          if (this.ac) {
            this.m.a(2, false);
          } else {
            this.m.a(0, false);
          }
          this.m.c();
          this.m.a(paramString.a);
          w();
          this.m.notifyDataSetChanged();
          if (Math.abs(System.currentTimeMillis() - this.ag) < 60000L) {
            this.p.postDelayed(new ExtendFriendSquareFragment.9(this, i, j), 100L);
          }
          l();
          c(true);
        }
        if (this.n != null)
        {
          paramString = this.n.a(true, false);
          if (paramString != null) {
            paramString.setLastUpdatedLabel(String.format("%s%s", new Object[] { getResources().getString(2131916800), TimeFormatterUtils.a(this.ag, true, "yyyy-MM-dd") }));
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendSquareFragment", 2, String.format("loadCacheData result=%b ts=%d tag=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(this.ag), this.N }));
      }
      return bool;
    }
    return false;
  }
  
  private void j(int paramInt)
  {
    Object localObject = this.n;
    int i = 0;
    localObject = ((PullToRefreshRecyclerView)localObject).a(true, false);
    if (paramInt == 1) {
      i = 1;
    }
    if (i != 0) {
      i = 2131896859;
    } else {
      i = 2131896880;
    }
    ((ILoadingLayout)localObject).setRefreshingLabel(getResources().getString(i));
    this.p.setTag(2131444519, Integer.valueOf(paramInt));
  }
  
  private void s()
  {
    this.ak.a = new ArrayList(5);
    Object localObject = new FeedBannerTabItem();
    ((FeedBannerTabItem)localObject).a = 0;
    ((FeedBannerTabItem)localObject).c = getResources().getString(2131896811);
    ((FeedBannerTabItem)localObject).f = -20771;
    ((FeedBannerTabItem)localObject).g = -31578;
    ((FeedBannerTabItem)localObject).j = new ArrayList(10);
    this.ak.a.add(localObject);
    localObject = ((IExpandManager)this.i.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).N();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ExpandBannerConfBean.BannerItem localBannerItem = (ExpandBannerConfBean.BannerItem)((Iterator)localObject).next();
        FeedBannerTabItem localFeedBannerTabItem = new FeedBannerTabItem();
        localFeedBannerTabItem.c = localBannerItem.title;
        localFeedBannerTabItem.b = localBannerItem.id;
        localFeedBannerTabItem.d = localBannerItem.subTitle;
        if ("0".equals(localBannerItem.type)) {
          localFeedBannerTabItem.a = 0;
        } else if ("1".equals(localBannerItem.type)) {
          localFeedBannerTabItem.a = 1;
        } else if ("2".equals(localBannerItem.type)) {
          localFeedBannerTabItem.a = 2;
        } else if ("3".equals(localBannerItem.type)) {
          localFeedBannerTabItem.a = 3;
        } else {
          localFeedBannerTabItem.a = -1;
        }
        localFeedBannerTabItem.h = localBannerItem.schemeOrUrl;
        localFeedBannerTabItem.e = localBannerItem.iconUrl;
        localFeedBannerTabItem.i = localBannerItem.extra;
        try
        {
          if (localBannerItem.bgBeginColor != null) {
            localFeedBannerTabItem.f = Color.parseColor(localBannerItem.bgBeginColor);
          }
          if (localBannerItem.bgEndColor != null) {
            localFeedBannerTabItem.g = Color.parseColor(localBannerItem.bgEndColor);
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("parse banner color ");
            localStringBuilder.append(localException);
            QLog.d("ExtendFriendSquareFragment", 2, localStringBuilder.toString());
          }
        }
        this.ak.a.add(localFeedBannerTabItem);
      }
    }
  }
  
  private boolean t()
  {
    int i = this.ah;
    boolean bool = false;
    if (i < 0) {
      return false;
    }
    if (Calendar.getInstance().get(6) != this.ah) {
      bool = true;
    }
    return bool;
  }
  
  private void u()
  {
    if (isAdded())
    {
      if (this.m == null) {
        return;
      }
      if (this.ai) {
        return;
      }
      if (NetworkUtil.isNetworkAvailable(this.h))
      {
        if (this.n != null)
        {
          j(1);
          if (this.n.d())
          {
            b(false);
            return;
          }
          this.n.setRefreshing();
          this.m.a(0, true);
        }
      }
      else
      {
        this.ad = 0;
        v();
      }
    }
  }
  
  private void v()
  {
    a(false, this.N, false, null, false, false, 0, null, null);
  }
  
  private void w()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void x()
  {
    IExpandManager localIExpandManager = (IExpandManager)this.i.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    Object localObject2 = localIExpandManager.m();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new CacheData();
    }
    if (this.m != null)
    {
      localObject2 = new CacheData.TagCache();
      ((CacheData.TagCache)localObject2).a.addAll(this.m.a());
      ((CacheData.TagCache)localObject2).b = this.ag;
      ((CacheData.TagCache)localObject2).c = this.ah;
      ((CacheData.TagCache)localObject2).f = this.ac;
      ((CacheData.TagCache)localObject2).d = this.ae;
      ((CacheData.TagCache)localObject2).e = this.N;
      ((CacheData.TagCache)localObject2).g = this.o.findFirstVisibleItemPosition();
      if (((CacheData.TagCache)localObject2).g < 0) {
        ((CacheData.TagCache)localObject2).g = 0;
      }
      View localView = this.o.findViewByPosition(((CacheData.TagCache)localObject2).g);
      if (localView != null) {
        ((CacheData.TagCache)localObject2).h = localView.getTop();
      }
      ((CacheData)localObject1).b = this.y;
      ((CacheData)localObject1).c = this.z;
      ((CacheData)localObject1).d = this.af;
      ((CacheData)localObject1).a((CacheData.TagCache)localObject2, this.y, this.z, this.af);
    }
    localIExpandManager.a((CacheData)localObject1);
    if (QLog.isColorLevel())
    {
      if (localObject1 == null) {
        localObject1 = "null";
      } else {
        localObject1 = ((CacheData)localObject1).toString();
      }
      QLog.i("ExtendFriendSquareFragment", 2, String.format("saveCacheData %s", new Object[] { localObject1 }));
    }
  }
  
  private void y()
  {
    List localList;
    if (this.l != null) {
      localList = this.l.b(2);
    } else {
      localList = null;
    }
    if (localList != null)
    {
      this.al.setSearchTags((ArrayList)localList, 0);
      this.X.post(new ExtendFriendSquareFragment.10(this));
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "limitchat enter match");
    }
    if (q())
    {
      ReportController.b(null, "dc00898", "", "", "kuolie", "0X80097DD", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, "onMatchItemClick, showExtendFriendQuestionDialog");
      }
      return;
    }
    if (this.c != null)
    {
      this.c.a();
      ExtendFriendReport.a().b(2);
    }
    ReportController.b(this.i, "dc00898", "", "", "0X80096A5", "0X80096A5", 0, 0, "", "", "", "");
  }
  
  public void a(ExtendFriendCampusVerifyTipsView.TipsType paramTipsType)
  {
    ExtendFriendCampusVerifyTipsView.a(this.h, this.i);
  }
  
  public void a(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPullDownToRefresh  mRecyclerViewScrollY:");
      localStringBuilder.append(this.U);
      QLog.d("ExtendFriendSquareFragment", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPullDownToRefresh state:");
      localStringBuilder.append(paramPullToRefreshBase.getState());
      localStringBuilder.append(" lastCacheOk:");
      localStringBuilder.append(this.ai);
      QLog.i("ExtendFriendSquareFragment", 2, localStringBuilder.toString());
    }
    if (this.s.hasMessages(10))
    {
      this.s.removeMessages(10);
      j();
    }
    ReportController.b(this.i, "dc00898", "", "", "0X80092D4", "0X80092D4", 0, 0, "", "", "", "");
    if ((paramPullToRefreshBase.getState() == PullToRefreshBase.State.MANUAL_REFRESHING) && (this.ai))
    {
      this.n.f();
    }
    else if (NetworkUtil.isNetworkAvailable(this.h))
    {
      b(false);
      n();
      this.m.a(0, true);
    }
    else
    {
      this.ad = 0;
      v();
    }
    a(this.U, 0.0F);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramBoolean2);
    if ((paramBoolean1) || (paramBoolean2)) {
      x();
    }
  }
  
  public void b(ExtendFriendCampusVerifyTipsView.TipsType paramTipsType)
  {
    CampusHelper.a(this.i, false);
    w();
  }
  
  public void b(PullToRefreshBase<RecyclerView> paramPullToRefreshBase)
  {
    if (QLog.isColorLevel())
    {
      paramPullToRefreshBase = new StringBuilder();
      paramPullToRefreshBase.append("onPullUpToRefresh  mRecyclerViewScrollY:");
      paramPullToRefreshBase.append(this.U);
      QLog.d("ExtendFriendSquareFragment", 2, paramPullToRefreshBase.toString());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("requestSquareStrangerList loadMore=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    this.ab = paramBoolean;
    if (!this.ab)
    {
      this.ac = false;
      this.ae = null;
    }
    if (this.k != null)
    {
      this.O = System.currentTimeMillis();
      this.k.a(this.i.getCurrentUin(), this.ae, 20, this.N, this.O, "推荐", true);
      this.aa = true;
    }
  }
  
  protected void c()
  {
    LinearLayoutManager localLinearLayoutManager = this.o;
    boolean bool3 = false;
    boolean bool1 = false;
    Object localObject3 = null;
    Object localObject1 = null;
    boolean bool2 = bool3;
    Object localObject2 = localObject3;
    if (localLinearLayoutManager != null)
    {
      bool2 = bool3;
      localObject2 = localObject3;
      if (this.m != null)
      {
        int i = this.o.findFirstVisibleItemPosition();
        int j = this.o.findLastVisibleItemPosition();
        for (;;)
        {
          bool2 = bool1;
          localObject2 = localObject1;
          if (i > j) {
            break;
          }
          localObject3 = this.m.b(i);
          localObject2 = this.p.findViewHolderForPosition(i);
          if ((localObject3 != null) && (localObject2 != null) && ((localObject2 instanceof FeedViewHolder)))
          {
            localObject2 = (FeedViewHolder)localObject2;
            localObject3 = a(((StrangerInfo)localObject3).mUin, ((StrangerInfo)localObject3).mNickName, ((FeedViewHolder)localObject2).c);
            ((FeedViewHolder)localObject2).c.setImageDrawable((Drawable)localObject3);
            bool2 = bool1;
            localObject2 = localObject1;
          }
          else
          {
            bool2 = bool1;
            localObject2 = localObject1;
            if ((localObject3 instanceof FeedBannerInfo))
            {
              localObject3 = ((FeedBannerInfo)localObject3).a.iterator();
              do
              {
                bool2 = bool1;
                localObject2 = localObject1;
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject2 = (FeedBannerTabItem)((Iterator)localObject3).next();
              } while (((FeedBannerTabItem)localObject2).a != 0);
              localObject2 = ((FeedBannerTabItem)localObject2).j;
              bool2 = true;
            }
          }
          i += 1;
          bool1 = bool2;
          localObject1 = localObject2;
        }
      }
    }
    if (this.an)
    {
      this.am.a(bool2);
      this.am.a((List)localObject2);
    }
  }
  
  protected int d()
  {
    return 1031;
  }
  
  public void d(boolean paramBoolean)
  {
    if ((!this.T) || (paramBoolean))
    {
      if ((this.al != null) && (this.n != null)) {
        this.al.a(this.n.getHeight());
      }
      this.T = true;
    }
  }
  
  protected int e()
  {
    return this.af;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 11) {
      u();
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, String.format("onActivityResult requestCode=%s resultCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (paramInt1 == 1031)
    {
      p();
      a(true, true);
      if (paramInt2 == 8193) {
        o();
      }
      this.w = -1;
      return;
    }
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      paramIntent = this.m.b(this.v);
      if ((paramIntent != null) && (!paramIntent.mAddFriendVerified))
      {
        paramIntent.mAddFriendVerified = true;
        this.m.notifyItemChanged(this.v);
      }
    }
    else
    {
      if ((paramInt1 == 2) && (paramInt2 == -1))
      {
        a(false, true);
        return;
      }
      if ((paramInt1 == 3) && (paramInt2 == -1) && (paramIntent != null))
      {
        if (paramIntent.getBooleanExtra("has_entered_profile", false)) {
          a(true, true);
        }
        if (paramIntent.hasExtra("add_frd_list")) {
          a(paramIntent.getStringArrayListExtra("add_frd_list"));
        }
        if (paramIntent.hasExtra("remain_match_count"))
        {
          paramInt1 = paramIntent.getIntExtra("remain_match_count", 0);
          if (paramInt1 != this.aj.a)
          {
            this.aj.a = paramInt1;
            if (QLog.isColorLevel()) {
              QLog.i("ExtendFriendSquareFragment", 2, String.format("onActivityResult update remainMatchCount=%d", new Object[] { Integer.valueOf(this.aj.a) }));
            }
          }
        }
        if (paramIntent.hasExtra("limit_chat_duration"))
        {
          paramInt1 = paramIntent.getIntExtra("limit_chat_duration", 0);
          if (paramInt1 != this.aj.b)
          {
            this.aj.b = paramInt1;
            if (QLog.isColorLevel()) {
              QLog.i("ExtendFriendSquareFragment", 2, String.format("onActivityResult update limitChatDuration=%d", new Object[] { Integer.valueOf(this.aj.b) }));
            }
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onCreate");
    }
    super.onCreate(paramBundle);
    if (this.i != null)
    {
      this.i.addObserver(this.ar);
      this.i.addObserver(this.Y);
      ((IExpandManager)this.i.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(this.h);
    }
    this.X = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.ao = new ExtendFriendReporter(this.i);
    s();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onCreateView");
    }
    this.ap = AIOUtils.b(35.0F, getResources());
    this.V = AIOUtils.b(160.0F, getResources());
    paramLayoutInflater = paramLayoutInflater.inflate(2131627443, null);
    this.n = ((PullToRefreshRecyclerView)paramLayoutInflater.findViewById(2131440880));
    this.n.setOnRefreshListener(this);
    this.o = new WrapContentLinearLayoutManager(this.h);
    this.p = ((RecyclerView)this.n.getRefreshableView());
    this.p.setId(2131444519);
    this.p.setLayoutManager(this.o);
    ((SimpleItemAnimator)this.p.getItemAnimator()).setSupportsChangeAnimations(false);
    this.p.setOnScrollListener(new ExtendFriendSquareFragment.3(this));
    this.r = new RecyclerViewItemDecoration(this);
    this.q = new ExtendFriendSquareFragment.4(this);
    this.m = new RecyclerViewAdapter(this, this, this, this, this.p, this.h, 0, this.M);
    this.m.a(AIOUtils.b(0.0F, getResources()));
    this.m.registerAdapterDataObserver(this.q);
    this.m.a(this.ao);
    this.p.setAdapter(this.m);
    this.G = ((NearbyZanAnimLayout)this.h.findViewById(2131435008));
    paramViewGroup = this.h.findViewById(2131431349);
    if (paramViewGroup != null) {
      paramViewGroup.getViewTreeObserver().addOnGlobalLayoutListener(new ExtendFriendSquareFragment.5(this, paramViewGroup));
    }
    this.al = ((ExpandSearchBarView)paramLayoutInflater.findViewById(2131445383));
    this.al.setVisibility(8);
    this.al.setItemClickListener(new ExtendFriendSquareFragment.6(this));
    this.am = ((ExtendFriendBottomBarView)paramLayoutInflater.findViewById(2131429638));
    this.am.a(this.i, this.n);
    this.am.setOnClickListener(new ExtendFriendSquareFragment.7(this));
    a(paramViewGroup);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onDestroy");
    }
    super.onDestroy();
    ExtendFriendReporter localExtendFriendReporter = this.ao;
    if (localExtendFriendReporter != null)
    {
      localExtendFriendReporter.a();
      this.ao = null;
    }
    if (this.i != null)
    {
      this.i.removeObserver(this.ar);
      this.i.removeObserver(this.Y);
      this.i = null;
    }
    if (this.q != null) {
      this.m.unregisterAdapterDataObserver(this.q);
    }
    this.m.d();
    this.h = null;
    this.k = null;
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSquareFragment", 2, "onResume");
    }
    super.onResume();
    if ((!this.Z) && (isAdded()))
    {
      boolean bool = a(true, null);
      long l = System.currentTimeMillis() - this.ag;
      if ((bool) && (l <= 60000L) && (!t()))
      {
        this.ai = true;
      }
      else
      {
        this.ai = false;
        this.N = "推荐";
        List localList = this.l.b(2);
        this.al.setSearchTags((ArrayList)localList, 0);
        this.X.removeMessages(11);
        this.X.sendEmptyMessageDelayed(11, 500L);
      }
      this.Z = true;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSquareFragment", 2, String.format("onResume loadSuccess=%s interval=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) }));
      }
      this.X.postDelayed(new ExtendFriendSquareFragment.8(this), 100L);
    }
    else if (t())
    {
      this.ai = false;
      this.X.removeMessages(11);
      this.X.sendEmptyMessageDelayed(11, 500L);
    }
    else
    {
      w();
      this.m.notifyDataSetChanged();
    }
    a(this.U, 0.0F);
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#voice_tab#view", true, -1L, -1L, null, true, true);
  }
  
  public int r()
  {
    if (this.o == null) {
      return 0;
    }
    int i = this.o.findFirstVisibleItemPosition();
    View localView = this.o.findViewByPosition(i);
    if (localView != null) {
      return i * localView.getHeight() - (localView.getTop() - AIOUtils.b(11.0F, getResources()));
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment
 * JD-Core Version:    0.7.0.1
 */