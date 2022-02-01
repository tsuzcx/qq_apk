package com.tencent.mobileqq.kandian.biz.tab;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.api.impl.RIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.biz.feeds.api.impl.ReadInJoyBaseFragmentEntryPath;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelReporter;
import com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView;
import com.tencent.mobileqq.kandian.biz.framework.CallHotwordChange;
import com.tencent.mobileqq.kandian.biz.framework.util.RIJChannelViewpagerEnterPathHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager.KandianSubscribeMessageObserver;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.db.struct.ChannelSection;
import com.tencent.mobileqq.kandian.repo.feeds.RIJChannelHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.channelcover.RIJMainChannelUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo.RedPoint;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class ReadInJoyChannelViewPagerController
  implements KandianSubscribeManager.KandianSubscribeMessageObserver
{
  private static final int A = ViewUtils.dpToPx(0.0F);
  public static TabChannelCoverInfo a;
  public static int c = 3;
  public static boolean d = false;
  private static boolean q = true;
  private static HashMap<Integer, Boolean> s = new HashMap();
  private static final int z = ViewUtils.dpToPx(0.0F);
  private int B;
  private float C = 0.4F;
  private float D = 1.0F;
  private int E = 1;
  private ViewPager.OnPageChangeListener F = new ReadInJoyChannelViewPagerController.9(this);
  private HorizontalListView.OnScrollStateChangedListener G;
  private int H = 1;
  CallHotwordChange b;
  private Context e;
  private View f;
  private View g;
  private ImageView h;
  private ImageView i;
  private TabLayout j;
  private ReadInJoyTabAdapter k;
  private ReadInJoyChannelViewPager l;
  private ReadInJoyChannelViewPager.CustomFragmentPagerAdapter m;
  private FragmentManager n;
  private List<TabChannelCoverInfo> o = new ArrayList();
  private List<TabChannelCoverInfo> p = new ArrayList();
  private Map<Integer, BaseReportData> r = new HashMap();
  private ReadInJoyLogicEngine t;
  private boolean u = false;
  private ReadInJoyChannelViewPagerController.OnDataChangeListener v;
  private ReadInJoyChannelViewPagerController.OnChannelChangeListener w;
  private boolean x;
  private ReadInJoyObserver y = new ReadInJoyChannelViewPagerController.4(this);
  
  public ReadInJoyChannelViewPagerController(Context paramContext, View paramView, ReadInJoyChannelViewPager paramReadInJoyChannelViewPager)
  {
    this.e = paramContext;
    this.g = paramView;
    this.l = paramReadInJoyChannelViewPager;
    this.j = ((TabLayout)this.g.findViewById(2131446766));
    this.h = ((ImageView)this.g.findViewById(2131436457));
    this.i = ((ImageView)this.g.findViewById(2131436550));
    this.f = ((Activity)this.e).getWindow().getDecorView();
    y();
    o();
  }
  
  private void a(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject1 = this.j;
    paramInt2 = 1;
    if (localObject1 == null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "mChannelTabLayout null");
      return;
    }
    int i3 = this.l.getCurrentItem();
    if (i3 >= this.j.getChildSize())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("currentPosition larger than tablayout childsize, currentPosition ");
      ((StringBuilder)localObject1).append(i3);
      ((StringBuilder)localObject1).append(" childsize: ");
      ((StringBuilder)localObject1).append(this.j.getChildSize());
      QLog.d("ReadInJoyChannelViewPagerController", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.j.a(i3);
    localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    View localView;
    if (localViewGroup != null) {
      localView = localViewGroup.findViewById(2131436062);
    } else {
      localView = null;
    }
    int i4 = i3 - 1;
    int i2 = 0;
    int i1 = 0;
    float f2;
    float f1;
    if (paramInt1 == i4)
    {
      f2 = (1.0F - paramFloat) * this.D;
      f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      paramInt1 = z;
      if ((i4 >= 0) && (i4 < this.j.getChildSize()))
      {
        localObject1 = this.j.a(i4);
        paramInt1 = this.j.b(i4);
        paramInt1 = (int)(z - paramInt1 * f1);
        ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.5(this, paramFloat, i3, localViewGroup, (View)localObject1));
      }
      else
      {
        QLog.d("ReadInJoyChannelViewPagerController", 1, "targetTabView null");
      }
    }
    else
    {
      if (paramInt1 == i3)
      {
        f2 = this.D * paramFloat;
        f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
        paramInt1 = A;
        i1 = i3 + 1;
        if ((i1 >= 0) && (i1 < this.j.getChildSize()))
        {
          localObject1 = this.j.a(i1);
          paramInt1 = this.j.b(i1);
          paramInt1 = (int)(A - paramInt1 * f1);
          ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.6(this, paramFloat, i1, (View)localObject1, localViewGroup, i3));
          break label513;
        }
        QLog.d("ReadInJoyChannelViewPagerController", 1, "targetTabView null");
        localObject1 = localObject3;
        break label513;
      }
      i3 += 1;
      if (paramInt1 == i3)
      {
        paramInt1 = i1;
        localObject1 = localObject2;
        if (i3 >= 0)
        {
          paramInt1 = i1;
          localObject1 = localObject2;
          if (i3 < this.j.getChildSize())
          {
            localObject1 = this.j.a(i3);
            paramInt1 = this.j.b(i3);
            paramInt1 = A - paramInt1;
          }
        }
        ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.7(this, i3, (View)localObject1, localViewGroup));
        break label513;
      }
      QLog.d("ReadInJoyChannelViewPagerController", 1, "targetTabView null");
      paramInt1 = i2;
    }
    paramInt2 = 0;
    label513:
    a(localView, paramInt1, paramInt2);
    ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.8(this, (View)localObject1, localView));
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "line null");
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    if (paramInt2 == 0)
    {
      localMarginLayoutParams.leftMargin = paramInt1;
      localMarginLayoutParams.rightMargin = A;
    }
    else
    {
      localMarginLayoutParams.rightMargin = paramInt1;
      localMarginLayoutParams.leftMargin = z;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("changeChannelLineMargin: left ");
    localStringBuilder.append(localMarginLayoutParams.leftMargin);
    localStringBuilder.append(" right: ");
    localStringBuilder.append(localMarginLayoutParams.rightMargin);
    QLog.d("ReadInJoyChannelViewPagerController", 1, localStringBuilder.toString());
    paramView.setLayoutParams(localMarginLayoutParams);
  }
  
  private void a(View paramView1, View paramView2)
  {
    if ((paramView1 != null) && (paramView2 != null))
    {
      paramView1 = (TextView)paramView1.findViewById(2131448814);
      paramView2 = (TextView)paramView2.findViewById(2131448814);
      a(paramView1);
      b(paramView2);
      return;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 1, "tvSelectTab or tvUnselectTab null");
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView.setTextColor(paramTextView.getResources().getColor(2131167856));
    paramTextView.setTypeface(Typeface.defaultFromStyle(1));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "actionName = ", paramString1, "\n", "r2 = ", paramString2, ", r5 = ", paramString3 });
    PublicAccountReportUtils.a(null, "", paramString1, paramString1, 0, 0, paramString2, "", "", paramString3, false);
  }
  
  private void a(List<TabChannelCoverInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      c = u();
      List localList = b(paramList);
      this.o.clear();
      this.o.addAll(localList);
      this.j.a();
      if (this.v != null)
      {
        paramList = b(paramList);
        this.v.a(paramList);
      }
      ThreadManager.executeOnSubThread(new ReadInJoyChannelViewPagerController.2(this));
      t();
      v();
      this.m.a(localList);
      paramList = a;
      if ((paramList != null) && (h(paramList.mChannelCoverId) != null)) {
        c(a.mChannelCoverId);
      } else {
        c();
      }
      paramList = new StringBuilder();
      paramList.append("setAdapterData: ");
      paramList.append(localList);
      QLog.d("ReadInJoyChannelViewPagerController", 1, paramList.toString());
      return;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, "channel list size is 0");
  }
  
  private void a(Map<Integer, BaseReportData> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.values().iterator();
      while (paramMap.hasNext())
      {
        BaseReportData localBaseReportData = (BaseReportData)paramMap.next();
        TabChannelCoverInfo localTabChannelCoverInfo = localBaseReportData.C;
        int i2 = ChannelCoverView.b;
        int i1;
        if ((localBaseReportData.C != null) && (localBaseReportData.C.redPoint != null) && (localBaseReportData.C.redPoint.a)) {
          i1 = localBaseReportData.C.redPoint.e + 1;
        } else {
          i1 = 0;
        }
        ChannelCoverView.a("0X8009495", localTabChannelCoverInfo, i2, i1, localBaseReportData.D);
      }
    }
  }
  
  private List<TabChannelCoverInfo> b(List<TabChannelCoverInfo> paramList)
  {
    Object localObject = new ArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
      if (localTabChannelCoverInfo != null) {
        paramList.add(localTabChannelCoverInfo.clone());
      }
    }
    return paramList;
  }
  
  private void b(TextView paramTextView)
  {
    paramTextView.setTextColor(paramTextView.getResources().getColor(2131167857));
    paramTextView.setTypeface(Typeface.defaultFromStyle(0));
  }
  
  private void b(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {
      return;
    }
    KandianSubscribeManager localKandianSubscribeManager = (KandianSubscribeManager)ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER);
    TabChannelCoverInfo.RedPoint localRedPoint = new TabChannelCoverInfo.RedPoint();
    localRedPoint.b = 0L;
    localRedPoint.c = 9223372036854775807L;
    localRedPoint.a = localKandianSubscribeManager.a();
    paramTabChannelCoverInfo.redPoint = localRedPoint;
    a(paramTabChannelCoverInfo);
  }
  
  private void c(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {
      return;
    }
    if (this.p.size() > 0)
    {
      int i1 = 0;
      while (i1 < this.p.size())
      {
        if (paramTabChannelCoverInfo.mChannelCoverId == ((TabChannelCoverInfo)this.p.get(i1)).mChannelCoverId)
        {
          this.p.remove(i1);
          break;
        }
        i1 += 1;
      }
    }
    if (paramTabChannelCoverInfo.reason != 4) {
      this.p.add(0, paramTabChannelCoverInfo);
    }
  }
  
  private void c(List<TabChannelCoverInfo> paramList)
  {
    List localList = this.t.H();
    if ((localList != null) && (localList.size() > 0))
    {
      ((ChannelSection)localList.get(0)).d = paramList;
      this.t.a(localList, 1, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "updateMyChannelData channelCoverSectionList is null");
    }
  }
  
  public static void d(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "refreshChannel, channelID = ", Integer.valueOf(paramInt) });
    if (paramInt != -1) {
      s.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
    }
  }
  
  private boolean d(List<TabChannelCoverInfo> paramList)
  {
    paramList = e(paramList);
    int i1 = paramList.size();
    int i2 = this.o.size();
    boolean bool = true;
    if (i1 == i2)
    {
      i1 = 0;
      while (i1 < paramList.size())
      {
        if (((TabChannelCoverInfo)paramList.get(i1)).mChannelCoverId != ((TabChannelCoverInfo)this.o.get(i1)).mChannelCoverId) {
          return true;
        }
        i1 += 1;
      }
      bool = false;
    }
    return bool;
  }
  
  private List<TabChannelCoverInfo> e(List<TabChannelCoverInfo> paramList)
  {
    int i3 = paramList.size();
    List localList = b(this.o);
    Iterator localIterator = localList.iterator();
    int i1;
    label105:
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      i1 = 0;
      i2 = 0;
      if (!bool) {
        break;
      }
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
      i1 = i2;
      for (;;)
      {
        if (i1 >= paramList.size()) {
          break label105;
        }
        if (localTabChannelCoverInfo.mChannelCoverId == ((TabChannelCoverInfo)paramList.get(i1)).mChannelCoverId)
        {
          localIterator.remove();
          break;
        }
        i1 += 1;
      }
    }
    int i2 = 0;
    while (i1 <= i3 - 1)
    {
      localList.add(c + i2, paramList.get(i1));
      i2 += 1;
      i1 += 1;
    }
    return localList;
  }
  
  public static boolean e(int paramInt)
  {
    boolean bool2 = false;
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "isNeedRefreshChannel, channelID = ", Integer.valueOf(paramInt) });
    boolean bool1 = bool2;
    if (paramInt != -1)
    {
      bool1 = bool2;
      if ((Boolean)s.remove(Integer.valueOf(paramInt)) != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void f(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.o.size()) {
        return;
      }
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.o.get(paramInt);
      if ((localTabChannelCoverInfo != null) && (localTabChannelCoverInfo.redPoint != null) && (localTabChannelCoverInfo.redPoint.a))
      {
        localTabChannelCoverInfo.redPoint.a = false;
        a(localTabChannelCoverInfo);
      }
    }
  }
  
  private void g(int paramInt)
  {
    Object localObject = (TabChannelCoverInfo)this.o.get(paramInt);
    boolean bool;
    if (((((TabChannelCoverInfo)localObject).redPoint != null) && (((TabChannelCoverInfo)localObject).redPoint.a)) || (RIJChannelStayTimeMonitor.INSTANCE.isLastExitChannelOverTimeLimit(((TabChannelCoverInfo)localObject).mChannelCoverId))) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "checkBackToTopAndRefresh, position = ", Integer.valueOf(paramInt), ", channelID = ", Integer.valueOf(((TabChannelCoverInfo)localObject).mChannelCoverId), ", isNeedRefresh = ", Boolean.valueOf(bool) });
    if (bool)
    {
      QBaseFragment localQBaseFragment = this.m.a(paramInt);
      if ((localQBaseFragment instanceof ReadInJoyBaseFragment))
      {
        localObject = (ReadInJoyBaseFragment)localQBaseFragment;
        QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "isShowingSelf = ", Boolean.valueOf(((ReadInJoyBaseFragment)localObject).e()) });
        ((ReadInJoyBaseFragment)localObject).a(3);
        return;
      }
      d(((TabChannelCoverInfo)localObject).mChannelCoverId);
    }
  }
  
  private TabChannelCoverInfo h(int paramInt)
  {
    Iterator localIterator = this.o.iterator();
    while (localIterator.hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
      if (localTabChannelCoverInfo.mChannelCoverId == paramInt) {
        return localTabChannelCoverInfo;
      }
    }
    return null;
  }
  
  public static boolean n()
  {
    return q;
  }
  
  private void o()
  {
    Context localContext = this.e;
    if ((localContext instanceof BaseActivity)) {
      this.n = ((BaseActivity)localContext).getSupportFragmentManager();
    }
    this.k = new ReadInJoyTabAdapter(this.g.getContext(), this.o, this.j, this);
    this.r.clear();
    this.k.a(this.r);
    this.j.setAdapter(this.k);
    this.m = ((ReadInJoyChannelViewPager.CustomFragmentPagerAdapter)this.l.getAdapter());
    this.l.addOnPageChangeListener(this.F);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.y);
    q();
    c();
    s();
    c = u();
    RIJChannelStayTimeMonitor.INSTANCE.startMonitor();
    p();
  }
  
  private void p()
  {
    VideoReport.setElementId(this.h, "more_channel_button");
    VideoReport.setElementParams(this.h, new RIJDtParamBuilder().a("14").c("click_more_channel").b("channel_bar").a().c());
    VideoReport.setElementReportPolicy(this.h, ReportPolicy.REPORT_POLICY_CLICK);
  }
  
  private void q()
  {
    Object localObject = (ReadInJoyLogicManager)ReadInJoyUtils.b().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine();
      if (localObject != null)
      {
        List localList = ((ReadInJoyLogicEngine)localObject).J();
        if ((localList != null) && (localList.size() != 0))
        {
          a(localList);
        }
        else
        {
          ((ReadInJoyLogicEngine)localObject).K();
          QLog.d("ReadInJoyChannelViewPagerController", 1, "No channel Cache info.");
        }
      }
    }
    r();
  }
  
  private void r()
  {
    if (ChannelModeConfigHandler.a())
    {
      this.h.setImageResource(2130851409);
      return;
    }
    this.h.setImageResource(2130844001);
  }
  
  private void s()
  {
    this.h.setOnClickListener(new ReadInJoyChannelViewPagerController.1(this));
  }
  
  private void t()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = h(0);
    if (localTabChannelCoverInfo == null) {
      return;
    }
    if ((localTabChannelCoverInfo.redPoint != null) && (localTabChannelCoverInfo.redPoint.a))
    {
      localTabChannelCoverInfo.redPoint.a = false;
      a(localTabChannelCoverInfo);
    }
  }
  
  private int u()
  {
    Object localObject = this.t.J();
    int i1 = 0;
    int i2 = 0;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      int i3;
      for (i1 = 0; i2 < ((List)localObject).size(); i1 = i3)
      {
        TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)((List)localObject).get(i2);
        i3 = i1;
        if (localTabChannelCoverInfo != null)
        {
          if (localTabChannelCoverInfo.reason != 4) {
            break;
          }
          i3 = i1 + 1;
        }
        i2 += 1;
      }
    }
    else
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "No channel Cache info.");
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getChannelLockCount lockCount：");
      ((StringBuilder)localObject).append(i1);
      QLog.d("ReadInJoyChannelViewPagerController", 2, ((StringBuilder)localObject).toString());
    }
    return i1;
  }
  
  private void v()
  {
    this.j.a();
    w();
  }
  
  private void w()
  {
    this.j.setOverScrollMode(2);
    int i2 = j();
    if (this.H == i2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mLastCenterPosition = ");
      localStringBuilder.append(this.H);
      localStringBuilder.append(", no need to move again.");
      QLog.i("ReadInJoyChannelViewPagerController", 1, localStringBuilder.toString());
      return;
    }
    this.H = i2;
    int i1 = this.j.b(i2);
    int i3 = (int)(DeviceInfoUtil.H() - i1) / 2 - ViewUtils.dip2px(12.0F);
    i1 = 200;
    if ((i2 < this.j.getFirstVisiblePosition()) || (i2 > this.j.getLastVisiblePosition())) {
      i1 = 0;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "smoothScrollToPosition, position = ", Integer.valueOf(i2), ", offset = ", Integer.valueOf(i3) });
    this.j.smoothScrollToPositionFromLeftOrRight(i2, -i3, i1);
    if (this.G == null) {
      this.G = new ReadInJoyChannelViewPagerController.11(this);
    }
    this.j.setOnScrollStateChangedListener(this.G);
  }
  
  private void x()
  {
    if (!q)
    {
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (localKandianMergeManager != null)
      {
        localKandianMergeManager.W();
        QLog.d("ReadInJoyChannelViewPagerController", 1, "clearKandianRedPoint");
      }
    }
  }
  
  private void y()
  {
    this.t = ((ReadInJoyLogicManager)ReadInJoyUtils.b().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine();
  }
  
  public void a()
  {
    QLog.i("ReadInJoyChannelViewPagerController", 1, "[onReceiveKandianSubscribeMessage] ");
    Object localObject = this.o;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      localObject = h(70);
      if (localObject != null)
      {
        TabChannelCoverInfo.RedPoint localRedPoint = new TabChannelCoverInfo.RedPoint();
        localRedPoint.a = true;
        localRedPoint.b = 0L;
        localRedPoint.c = 9223372036854775807L;
        ((TabChannelCoverInfo)localObject).redPoint = localRedPoint;
        a((TabChannelCoverInfo)localObject);
        this.j.a();
      }
    }
  }
  
  public void a(int paramInt)
  {
    int i2 = 1;
    Object localObject;
    if ((paramInt >= 0) && (paramInt < this.o.size()))
    {
      localObject = (TabChannelCoverInfo)this.o.get(paramInt);
      if ((localObject != null) && (RIJChannelViewpagerEnterPathHelper.a().get(Integer.valueOf(((TabChannelCoverInfo)localObject).mChannelCoverId)) == null))
      {
        RIJChannelViewpagerEnterPathHelper.a().put(Integer.valueOf(((TabChannelCoverInfo)localObject).mChannelCoverId), Integer.valueOf(1));
        RIJChannelReporter.a(((TabChannelCoverInfo)localObject).mChannelCoverId, "302");
      }
    }
    if (j() == paramInt)
    {
      localObject = this.m.a(paramInt);
      if ((localObject instanceof ReadInJoyBaseFragment)) {
        ((ReadInJoyBaseFragment)localObject).a(5);
      }
      localObject = (TabChannelCoverInfo)this.o.get(paramInt);
      if (localObject != null) {
        try
        {
          a("0X8009665", "", RIJTransMergeKanDianReport.g().addChannelId(((TabChannelCoverInfo)localObject).mChannelCoverId).addContentType(RIJChannelHelper.a((ChannelCoverInfo)localObject)).addRedDotStatus(RIJChannelHelper.a((TabChannelCoverInfo)localObject)).build());
        }
        catch (JSONException localJSONException)
        {
          QLog.d("ReadInJoyChannelViewPagerController", 1, "report channel title click again exception, e = ", localJSONException);
        }
      }
    }
    boolean bool = ReadInJoyHelper.R();
    int i1;
    if ((paramInt >= 0) && (paramInt < this.o.size()) && (((TabChannelCoverInfo)this.o.get(paramInt)).dynamicSort == 1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((bool) && (i1 != 0)) {
      i1 = i2;
    } else {
      i1 = 0;
    }
    if ((paramInt >= c) && (i1 != 0))
    {
      if ((paramInt >= 0) && (paramInt < this.o.size()))
      {
        TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.o.get(paramInt);
        if ((localTabChannelCoverInfo != null) && (RIJChannelViewpagerEnterPathHelper.a().get(Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId)) == null)) {
          RIJChannelViewpagerEnterPathHelper.a().put(Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId), Integer.valueOf(0));
        }
      }
      f(paramInt);
      this.j.a();
      this.l.postDelayed(new ReadInJoyChannelViewPagerController.10(this, paramInt), 0L);
      return;
    }
    b(paramInt);
  }
  
  public void a(CallHotwordChange paramCallHotwordChange)
  {
    this.b = paramCallHotwordChange;
  }
  
  public void a(ReadInJoyChannelViewPagerController.OnChannelChangeListener paramOnChannelChangeListener)
  {
    this.w = paramOnChannelChangeListener;
  }
  
  @UiThread
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {
      return;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "updateChannelToCacheAndDB channelID = ", Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId) });
    Object localObject = (ReadInJoyLogicManager)ReadInJoyUtils.b().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine();
      if (localObject != null)
      {
        if (RIJThreadHandler.f())
        {
          ((ReadInJoyLogicEngine)localObject).a(paramTabChannelCoverInfo);
          return;
        }
        RIJThreadHandler.b().post(new ReadInJoyChannelViewPagerController.3(this, (ReadInJoyLogicEngine)localObject, paramTabChannelCoverInfo));
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onTabChanged, visible = ", Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      a(this.r);
    } else {
      this.k.notifyDataSetChanged();
    }
    this.r.clear();
    if (paramBoolean) {
      FrameHelperActivity.I();
    }
    if (this.p.size() > 0)
    {
      boolean bool1 = d(this.p);
      boolean bool2 = ReadInJoyHelper.S();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("has changed :");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" ,isDynamicOrderSwitchOn : ");
      ((StringBuilder)localObject).append(bool2);
      QLog.d("ReadInJoyChannelViewPagerController", 1, ((StringBuilder)localObject).toString());
      if ((bool1) && (bool2) && (!paramBoolean))
      {
        int i1 = this.p.size() - 1;
        while (i1 > 0)
        {
          localObject = (TabChannelCoverInfo)this.p.get(i1);
          RIJChannelViewpagerEnterPathHelper.a().put(Integer.valueOf(((TabChannelCoverInfo)localObject).mChannelCoverId), Integer.valueOf(2));
          this.t.a(((TabChannelCoverInfo)localObject).mChannelCoverId, 5, false, false);
          i1 -= 1;
        }
        c(e(this.p));
        a(e(this.p));
        com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule.a = true;
        this.p.clear();
      }
    }
    else if (!paramBoolean)
    {
      com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule.a = false;
      w();
    }
    FrameHelperActivity.b(paramBoolean ^ true);
  }
  
  public void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.o.size()))
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.o.get(paramInt);
      if ((localTabChannelCoverInfo != null) && (RIJChannelViewpagerEnterPathHelper.a().get(Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId)) == null)) {
        RIJChannelViewpagerEnterPathHelper.a().put(Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId), Integer.valueOf(0));
      }
    }
    f(paramInt);
    this.l.setCurrentItem(paramInt, false);
    this.j.a();
  }
  
  public boolean b()
  {
    return this.x;
  }
  
  public void c()
  {
    int i1 = RIJMainChannelUtil.a.c();
    if (i1 == -1) {
      i1 = 0;
    }
    c(i1);
  }
  
  public void c(int paramInt)
  {
    int i1 = 0;
    int i2 = 0;
    while (i1 < this.o.size())
    {
      if (((TabChannelCoverInfo)this.o.get(i1)).mChannelCoverId == paramInt) {
        break label70;
      }
      if (((TabChannelCoverInfo)this.o.get(i1)).mChannelCoverId == 0) {
        i2 = i1;
      }
      i1 += 1;
    }
    i1 = -1;
    label70:
    int i3 = i1;
    if (i1 == -1)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "setCurrentItemByChannelID error,channelID= ", Integer.valueOf(paramInt), " recommendIndex=", Integer.valueOf(i2) });
      i3 = i2;
    }
    b(i3);
    this.E = i3;
  }
  
  public int d()
  {
    return this.B;
  }
  
  public void e()
  {
    c = u();
    d = true;
    this.f.setY(0.0F);
    r();
  }
  
  public void f()
  {
    d = false;
    this.f.setY(0.0F);
  }
  
  public void g()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.y);
    ((KandianSubscribeManager)ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER)).a(this);
    Object localObject = this.l;
    if (localObject != null) {
      ((ReadInJoyChannelViewPager)localObject).removeOnPageChangeListener(this.F);
    }
    if (this.m != null)
    {
      localObject = this.e;
      if (((localObject instanceof SplashActivity)) && (!((SplashActivity)localObject).isFinishing())) {
        this.m.a();
      }
    }
    localObject = s;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    if (RIJChannelViewpagerEnterPathHelper.a() != null)
    {
      RIJChannelViewpagerEnterPathHelper.a().clear();
      ReadInJoyBaseFragmentEntryPath.INSTANCE.clear();
    }
    RIJChannelStayTimeMonitor.INSTANCE.endMonitor();
    this.j.setOnScrollStateChangedListener(null);
    this.G = null;
    this.f = null;
    q = true;
  }
  
  public int h()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = i();
    if (localTabChannelCoverInfo != null) {
      return localTabChannelCoverInfo.mChannelCoverId;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 1, "current channel id is null, return -1");
    return -1;
  }
  
  public TabChannelCoverInfo i()
  {
    int i1 = j();
    if ((i1 >= 0) && (i1 < this.o.size())) {
      return (TabChannelCoverInfo)this.o.get(i1);
    }
    return null;
  }
  
  public int j()
  {
    return this.l.getCurrentItem();
  }
  
  public int k()
  {
    return this.E;
  }
  
  public QBaseFragment l()
  {
    return this.m.d();
  }
  
  public void m()
  {
    a = null;
    this.o.clear();
    this.k = new ReadInJoyTabAdapter(this.g.getContext(), this.o, this.j, this);
    this.r.clear();
    this.k.a(this.r);
    this.j.setAdapter(this.k);
    Object localObject = this.m;
    if (localObject != null) {
      ((ReadInJoyChannelViewPager.CustomFragmentPagerAdapter)localObject).a();
    }
    localObject = this.n;
    if (localObject != null)
    {
      this.m = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter((FragmentManager)localObject);
    }
    else
    {
      localObject = this.e;
      if ((localObject instanceof BaseActivity)) {
        this.m = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(((BaseActivity)localObject).getSupportFragmentManager());
      }
    }
    this.l.setAdapter(this.m);
    q();
    c();
    y();
    r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController
 * JD-Core Version:    0.7.0.1
 */