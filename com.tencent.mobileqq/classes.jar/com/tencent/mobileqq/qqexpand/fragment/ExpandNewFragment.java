package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qqexpand.chat.ExtendFriendSendMsgHelper;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.qqexpand.utils.ExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.widget.AbsSlidingIndicator.OnCurrentTabClickListener;
import com.tencent.mobileqq.widget.AbsSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.widget.SimpleSlidingIndicator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class ExpandNewFragment
  extends QPublicBaseFragment
  implements View.OnClickListener, AbsSlidingIndicator.OnCurrentTabClickListener, AbsSlidingIndicator.OnTabListener
{
  private static volatile boolean a = false;
  private static volatile boolean b = true;
  private final ExpandObserver A = new ExpandNewFragment.2(this);
  private QBaseActivity c;
  private QQAppInterface d;
  private FragmentManager e;
  private IExpandManager f;
  private QBaseFragment g;
  private ExpandCampusNewFragment h;
  private ExtendFriendSquareFragment i;
  private ViewGroup j;
  private ViewGroup k;
  private SimpleSlidingIndicator l;
  private TextView m;
  private View n;
  private String o;
  private RedTouch p;
  private long q;
  private long r = 0L;
  private int s = -1;
  private int t = -1;
  private String[] u;
  private int[] v;
  private int w = 0;
  private boolean x;
  private boolean y;
  private final RedpointObserver z = new ExpandNewFragment.1(this);
  
  static {}
  
  static void a()
  {
    b = false;
  }
  
  private void a(String paramString)
  {
    if (!this.x)
    {
      if (this.y) {
        return;
      }
      this.y = true;
      f();
      b(paramString);
      j();
      b();
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == this.s) || (paramInt == this.t);
  }
  
  private void b()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      localObject = (IRedTouchManager)((QQAppInterface)localObject).getRuntimeService(IRedTouchManager.class, "");
      if (((IRedTouchManager)localObject).getAppInfoByPath("7720.772001").iNewFlag.get() == 1)
      {
        ((IRedTouchManager)localObject).onRedTouchItemClick("7720.772001");
        this.l.postDelayed(new ExpandNewFragment.3(this), 1500L);
      }
    }
  }
  
  private void b(String paramString)
  {
    ViewGroup localViewGroup = this.k;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(0);
    }
    if ((paramString != null) && (paramString.equals("voice")))
    {
      this.w = this.t;
      g();
    }
    else if (this.s == 0)
    {
      h();
    }
    else
    {
      this.w = 0;
      g();
    }
    this.l.setCurrentPosition(this.w, false);
  }
  
  private void c()
  {
    boolean bool = QZoneApiProxy.needLoadQZoneEnv(new ExpandNewFragment.4(this));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preLoadData qzone plugin loaded ");
      localStringBuilder.append(bool);
      QLog.i("ExtendFriendNewFragment", 2, localStringBuilder.toString());
    }
    if (bool) {
      d();
    } else {
      a = true;
    }
    a(this.o);
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendNewFragment", 2, String.format("redDotTouchClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject2 = this.d;
    Object localObject1 = "";
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)((QQAppInterface)localObject2).getRuntimeService(IRedTouchManager.class, "");
    if (this.t == paramInt)
    {
      localObject1 = "7720.772001";
    }
    else if (this.s == paramInt)
    {
      localObject2 = "7720.772003";
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("7720.772003");
      localObject1 = localObject2;
      if (localAppInfo != null)
      {
        localObject1 = localObject2;
        if (localAppInfo.num.get() > 0)
        {
          localObject1 = new LpReportInfo_pf00064();
          ((LpReportInfo_pf00064)localObject1).actionType = 230;
          ((LpReportInfo_pf00064)localObject1).subactionType = 2;
          ((LpReportInfo_pf00064)localObject1).reserves = 1;
          LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject1, false, true);
          localObject1 = localObject2;
        }
      }
    }
    localIRedTouchManager.onRedTouchItemClick((String)localObject1);
    localObject1 = this.l;
    if (localObject1 != null)
    {
      localObject2 = this.v;
      if (localObject2.length > paramInt) {
        ((SimpleSlidingIndicator)localObject1).a(localObject2[paramInt]);
      }
    }
    j();
  }
  
  private void d()
  {
    Object localObject = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preLoadData: start to load qzone plugin ");
      boolean bool;
      if (localObject != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.i("ExtendFriendNewFragment", 2, localStringBuilder.toString());
    }
    if (localObject == null)
    {
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new ExpandNewFragment.5(this));
      a = false;
      return;
    }
    a = QZoneApiProxy.needShowSchoolExtendFeed(getActivity(), this.d);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("preLoadData: needShowSchoolExtendFeed to load qzone plugin ");
    ((StringBuilder)localObject).append(a);
    QLog.i("ExtendFriendNewFragment", 1, ((StringBuilder)localObject).toString());
    if (a) {
      QZoneApiProxy.initSchoolExtendListCreator();
    }
  }
  
  private void e()
  {
    Object localObject1 = this.g;
    if (localObject1 == this.h) {
      localObject1 = "exit#school_tab#view";
    }
    for (;;)
    {
      break;
      if (localObject1 == this.i) {
        localObject1 = "exit#voice_tab#view";
      } else {
        localObject1 = "";
      }
    }
    if ((this.r != 0L) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.r;
      localObject2 = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1 - l2);
      localStringBuilder.append("");
      ((Map)localObject2).put("duration", localStringBuilder.toString());
      ExpandReportUtils.a((String)localObject1, true, -1L, -1L, (Map)localObject2, true, true);
      this.r = 0L;
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("report error ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.w("ExtendFriendNewFragment", 4, ((StringBuilder)localObject2).toString());
  }
  
  private void f()
  {
    String[] arrayOfString = new String[10];
    int[] arrayOfInt = new int[10];
    int i1;
    if ((a) && (b))
    {
      arrayOfString[0] = getString(2131896892);
      arrayOfInt[0] = 2131432680;
      this.s = 0;
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    arrayOfString[i1] = getString(2131896891);
    arrayOfInt[i1] = 2131432686;
    this.t = i1;
    i1 += 1;
    this.l.setVisibility(0);
    this.m.setVisibility(8);
    this.u = new String[i1];
    this.v = new int[i1];
    System.arraycopy(arrayOfString, 0, this.u, 0, i1);
    System.arraycopy(arrayOfInt, 0, this.v, 0, i1);
    this.l.setTabData(this.u, this.v);
    this.l.setOnTabListener(this);
    this.l.setOnTabClickListener(this);
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendNewFragment", 2, "loadSquareFragment");
    }
    if (this.e != null)
    {
      if (this.i == null)
      {
        this.i = new ExtendFriendSquareFragment();
        this.i.b(this.t);
      }
      Object localObject1 = this.g;
      Object localObject2 = this.i;
      if (localObject1 != localObject2)
      {
        localObject1 = this.e.beginTransaction();
        localObject2 = this.g;
        if (localObject2 != null) {
          ((FragmentTransaction)localObject1).hide((Fragment)localObject2);
        }
        if (!this.i.isAdded()) {
          ((FragmentTransaction)localObject1).add(2131431349, this.i, "squareFragment");
        } else {
          ((FragmentTransaction)localObject1).show(this.i);
        }
        ((FragmentTransaction)localObject1).commitAllowingStateLoss();
        i();
        this.g = this.i;
        return;
      }
      ((ExtendFriendSquareFragment)localObject2).b();
    }
  }
  
  private void h()
  {
    QLog.d("ExtendFriendNewFragment", 2, "loadExtendFeedsFragment");
    if (this.e != null)
    {
      if (this.h == null)
      {
        this.h = new ExpandCampusNewFragment();
        this.h.b(this.s);
      }
      Object localObject1 = this.g;
      Object localObject2 = this.h;
      if (localObject1 != localObject2)
      {
        localObject1 = this.e.beginTransaction();
        localObject2 = this.g;
        if (localObject2 != null) {
          ((FragmentTransaction)localObject1).hide((Fragment)localObject2);
        }
        if (!this.h.isAdded()) {
          ((FragmentTransaction)localObject1).add(2131431349, this.h, "campusFragment");
        } else {
          ((FragmentTransaction)localObject1).show(this.h);
        }
        ((FragmentTransaction)localObject1).commitAllowingStateLoss();
        i();
        this.g = this.h;
      }
      else
      {
        ((ExpandCampusNewFragment)localObject2).b();
      }
    }
    this.l.e(this.s);
  }
  
  private void i()
  {
    ExtendFriendSquareFragment localExtendFriendSquareFragment = this.i;
    if ((localExtendFriendSquareFragment != null) && (localExtendFriendSquareFragment == this.g)) {
      localExtendFriendSquareFragment.n();
    }
  }
  
  private void j()
  {
    if (this.c != null)
    {
      Object localObject = this.d;
      if (localObject != null)
      {
        if (this.l == null) {
          return;
        }
        try
        {
          localObject = (IRedTouchManager)((QQAppInterface)localObject).getRuntimeService(IRedTouchManager.class, "");
          if (this.t != -1)
          {
            BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)localObject).getAppInfoByPath("7720.772001");
            this.l.a(this.v[this.t], localAppInfo);
          }
          if (this.s != -1)
          {
            localObject = ((IRedTouchManager)localObject).getAppInfoByPath("7720.772003");
            this.l.a(this.v[this.s], (BusinessInfoCheckUpdate.AppInfo)localObject);
            if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).num.get() > 0))
            {
              localObject = new LpReportInfo_pf00064();
              ((LpReportInfo_pf00064)localObject).actionType = 230;
              ((LpReportInfo_pf00064)localObject).subactionType = 1;
              ((LpReportInfo_pf00064)localObject).reserves = 1;
              LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, true);
            }
          }
          MatchChatMsgUtil.a(this.p, this.d);
          return;
        }
        catch (Exception localException)
        {
          QLog.e("ExtendFriendNewFragment", 1, "updateExtendRedDot fail.", localException);
        }
      }
    }
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    e();
    if (paramInt == this.t)
    {
      g();
      Object localObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("extend_friend");
      String str = "";
      if ((localObject != null) && (((SosoLbsInfo)localObject).mLocation != null))
      {
        localObject = ((SosoLbsInfo)localObject).mLocation;
        if (!TextUtils.isEmpty(((SosoLocation)localObject).city)) {
          str = ((SosoLocation)localObject).city;
        }
        localObject = String.format("%s;%s", new Object[] { Double.valueOf(((SosoLocation)localObject).mLat02), Double.valueOf(((SosoLocation)localObject).mLon02) });
      }
      else
      {
        str = "";
        localObject = str;
      }
      ReportController.b(this.d, "dc00898", "", "", "0X80092D2", "0X80092D2", 0, 0, "", "", str, (String)localObject);
      ExpandReportUtils.a("click#voice_tab#voice_btn", true, -1L, -1L, null, true, true);
    }
    else if (paramInt == this.s)
    {
      h();
      ExpandReportUtils.a("click#school_tab#school_btn", true, -1L, -1L, null, true, true);
    }
    this.f.d(paramInt);
    c(paramInt);
    this.r = System.currentTimeMillis();
    return 0;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == this.t)
    {
      g();
      return;
    }
    if (paramInt == this.s) {
      h();
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendNewFragment", 2, String.format("onActivityResult requestCode=%s resultCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject;
    if ((paramInt1 == 1031) || (paramInt1 == 1) || (paramInt1 == 3) || (paramInt1 == 2))
    {
      localObject = this.i;
      if (localObject != null) {
        ((ExtendFriendSquareFragment)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = -1;
      break;
    case 1208: 
      paramInt1 = 1208;
      break;
    case 1207: 
      paramInt1 = 1207;
      break;
    case 1206: 
      paramInt1 = 1206;
      break;
    case 1205: 
      paramInt1 = 1205;
    }
    if (paramInt1 != -1)
    {
      localObject = this.h;
      if (localObject != null) {
        ((ExpandCampusNewFragment)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131447501: 
      if (this.c != null)
      {
        ReportController.b(this.d, "dc00898", "", "", "0X800A696", "0X800A696", 0, 0, "", "", "", "");
        MatchChatMsgListFragment.a(this.c, 0);
        return;
      }
      break;
    case 2131447500: 
      paramView = this.c;
      if (paramView != null) {
        paramView.doOnBackPressed();
      }
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.i("ExtendFriendNewFragment", 4, "onCreate");
    super.onCreate(paramBundle);
    this.x = false;
    this.y = false;
    this.c = getQBaseActivity();
    this.d = ((QQAppInterface)this.c.getAppRuntime());
    if (this.d != null)
    {
      this.e = this.c.getSupportFragmentManager();
      this.f = ((IExpandManager)this.d.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
      this.f.d(0);
      this.d.addObserver(this.z);
      this.d.addObserver(this.A);
      paramBundle = (IWebProcessManagerService)this.d.getRuntimeService(IWebProcessManagerService.class, "");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendNewFragment", 2, "onCreate, preload web process");
        }
        paramBundle.startWebProcess(-1, null);
      }
      this.f.a(this.c, this.d);
    }
    ExtendFriendReport.a().g();
    this.q = System.currentTimeMillis();
    this.r = System.currentTimeMillis();
    ReportController.b(this.d, "dc00898", "", "", "0X80092F0", "0X80092F0", 0, 0, "", "", "", "");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("onCreateView ");
    paramViewGroup.append(a);
    QLog.i("ExtendFriendNewFragment", 4, paramViewGroup.toString());
    this.j = ((ViewGroup)paramLayoutInflater.inflate(2131627406, null));
    this.k = ((ViewGroup)this.j.findViewById(2131447534));
    this.l = ((SimpleSlidingIndicator)this.j.findViewById(2131446094));
    this.m = ((TextView)this.j.findViewById(2131448932));
    this.n = this.j.findViewById(2131439329);
    this.o = getActivity().getIntent().getStringExtra("extend_frient_type_url");
    paramLayoutInflater = this.k;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.setVisibility(4);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        paramLayoutInflater = (FrameLayout.LayoutParams)this.k.getLayoutParams();
        paramLayoutInflater.topMargin = ImmersiveUtils.getStatusBarHeight(this.c);
        this.k.setLayoutParams(paramLayoutInflater);
      }
    }
    paramLayoutInflater = this.j.findViewById(2131447500);
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setOnClickListener(this);
    }
    if (this.n != null)
    {
      boolean bool = ThemeUtil.isInNightMode(this.d);
      paramLayoutInflater = this.n;
      int i1;
      if (bool) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      paramLayoutInflater.setVisibility(i1);
    }
    if (paramBundle != null) {
      this.i = ((ExtendFriendSquareFragment)this.e.findFragmentByTag("squareFragment"));
    }
    if (a) {
      a(this.o);
    } else {
      c();
    }
    ((IExpandManager)this.d.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).T();
    return this.j;
  }
  
  public void onDestroy()
  {
    ((IExpandManager)this.d.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).U();
    QLog.i("ExtendFriendNewFragment", 4, "onDestroy");
    this.x = true;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendNewFragment", 2, "onDestroy");
    }
    super.onDestroy();
    Object localObject = this.d;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.z);
      this.d.removeObserver(this.A);
      CampusHelper.a(this.d, false);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.q;
    int i1 = (int)((l1 - l2) / 1000L);
    if ((l2 > 0L) && (i1 > 0) && (i1 < 86400))
    {
      localObject = this.d;
      if (localObject != null) {
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X80092EF", "0X80092EF", 0, i1, "", "", "", "");
      }
      ExtendFriendReport.a().a(i1);
    }
    localObject = ExtendFriendSendMsgHelper.a(this.d);
    if (localObject != null) {
      ((ExtendFriendSendMsgHelper)localObject).a();
    }
    this.f.d(-1);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    int i1 = paramIntent.getIntExtra("position", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendNewFragment", 2, String.format("onNewIntent position=%s", new Object[] { Integer.valueOf(i1) }));
    }
    if ((i1 >= 0) && (a(i1))) {
      this.l.setCurrentPosition(i1, false);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseAll();
    e();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.resumeAll();
    int i1 = getActivity().getIntent().getIntExtra("extend_frient_from", 0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("frompage", String.valueOf(i1));
    ExpandReportUtils.a("expose#all_page#view", true, -1L, -1L, localHashMap, true, true);
    if (this.r == 0L) {
      this.r = System.currentTimeMillis();
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandNewFragment
 * JD-Core Version:    0.7.0.1
 */