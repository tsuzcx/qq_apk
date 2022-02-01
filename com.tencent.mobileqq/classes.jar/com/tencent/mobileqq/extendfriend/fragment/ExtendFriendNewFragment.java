package com.tencent.mobileqq.extendfriend.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.OnCurrentTabClickListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.utils.CampusHelper;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.HashMap;
import java.util.Map;

public class ExtendFriendNewFragment
  extends PublicBaseFragment
  implements View.OnClickListener, SimpleSlidingIndicator.OnCurrentTabClickListener, SimpleSlidingIndicator.OnTabListener
{
  private static volatile boolean jdField_a_of_type_Boolean = false;
  private static volatile boolean jdField_b_of_type_Boolean = true;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExtendFriendManager jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager;
  private ExtendFriendCampusNewFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusNewFragment;
  private ExtendFriendSquareFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment;
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new ExtendFriendNewFragment.2(this);
  private RedpointObserver jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver = new ExtendFriendNewFragment.1(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private String jdField_a_of_type_JavaLangString;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long = 0L;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private final String jdField_b_of_type_JavaLangString = "campus";
  private int jdField_c_of_type_Int = 0;
  private final String jdField_c_of_type_JavaLangString = "voice";
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  static
  {
    ExpandReportUtils.a();
  }
  
  static void a()
  {
    jdField_b_of_type_Boolean = false;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendNewFragment", 2, String.format("redDotTouchClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    Object localObject = "";
    if (this.jdField_b_of_type_Int == paramInt) {
      localObject = "7720.772001";
    }
    for (;;)
    {
      localRedTouchManager.b((String)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null) && (this.jdField_a_of_type_ArrayOfInt.length > paramInt)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(this.jdField_a_of_type_ArrayOfInt[paramInt]);
      }
      j();
      return;
      if (this.jdField_a_of_type_Int == paramInt)
      {
        String str = "7720.772003";
        BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("7720.772003");
        localObject = str;
        if (localAppInfo != null)
        {
          localObject = str;
          if (localAppInfo.num.get() > 0)
          {
            localObject = new LpReportInfo_pf00064();
            ((LpReportInfo_pf00064)localObject).actionType = 230;
            ((LpReportInfo_pf00064)localObject).subactionType = 2;
            ((LpReportInfo_pf00064)localObject).reserves = 1;
            LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, true);
            localObject = str;
          }
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    if ((this.jdField_c_of_type_Boolean) || (this.d)) {
      return;
    }
    this.d = true;
    f();
    b(paramString);
    j();
    b();
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == this.jdField_a_of_type_Int) || (paramInt == this.jdField_b_of_type_Int);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (localRedTouchManager.a("7720.772001").iNewFlag.get() == 1)
      {
        localRedTouchManager.b("7720.772001");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.postDelayed(new ExtendFriendNewFragment.3(this), 1500L);
      }
    }
  }
  
  private void b(String paramString)
  {
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    if ((paramString != null) && (paramString.equals("voice")))
    {
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      g();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(this.jdField_c_of_type_Int, false);
      return;
      if (this.jdField_a_of_type_Int == 0)
      {
        h();
      }
      else
      {
        this.jdField_c_of_type_Int = 0;
        g();
      }
    }
  }
  
  private void c()
  {
    boolean bool = QZoneApiProxy.needLoadQZoneEnv(new ExtendFriendNewFragment.4(this));
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendNewFragment", 2, "preLoadData qzone plugin loaded " + bool);
    }
    if (bool) {
      d();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_JavaLangString);
      return;
      jdField_a_of_type_Boolean = true;
    }
  }
  
  private void d()
  {
    ClassLoader localClassLoader = QzonePluginProxyActivity.getQZonePluginClassLoaderInUI();
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("preLoadData: start to load qzone plugin ");
      if (localClassLoader != null)
      {
        bool = true;
        QLog.i("ExtendFriendNewFragment", 2, bool);
      }
    }
    else
    {
      if (localClassLoader != null) {
        break label75;
      }
      QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new ExtendFriendNewFragment.5(this));
      jdField_a_of_type_Boolean = false;
    }
    label75:
    do
    {
      return;
      bool = false;
      break;
      jdField_a_of_type_Boolean = QZoneApiProxy.needShowSchoolExtendFeed(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      QLog.i("ExtendFriendNewFragment", 1, "preLoadData: needShowSchoolExtendFeed to load qzone plugin " + jdField_a_of_type_Boolean);
    } while (!jdField_a_of_type_Boolean);
    QZoneApiProxy.initSchoolExtendListCreator();
  }
  
  private void e()
  {
    String str = "";
    if (this.jdField_a_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusNewFragment) {
      str = "exit#school_tab#view";
    }
    while ((this.jdField_b_of_type_Long == 0L) || (TextUtils.isEmpty(str)))
    {
      QLog.w("ExtendFriendNewFragment", 4, "report error " + str);
      return;
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment) {
        str = "exit#voice_tab#view";
      }
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_b_of_type_Long;
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", l1 - l2 + "");
    ExpandReportUtils.a(str, true, -1L, -1L, localHashMap, true, true);
    this.jdField_b_of_type_Long = 0L;
  }
  
  private void f()
  {
    String[] arrayOfString = new String[10];
    int[] arrayOfInt = new int[10];
    if ((jdField_a_of_type_Boolean) && (jdField_b_of_type_Boolean))
    {
      arrayOfString[0] = getString(2131698842);
      arrayOfInt[0] = 2131366489;
      this.jdField_a_of_type_Int = 0;
    }
    for (int i = 1;; i = 0)
    {
      arrayOfString[i] = getString(2131698841);
      arrayOfInt[i] = 2131366496;
      this.jdField_b_of_type_Int = i;
      i += 1;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[i];
      this.jdField_a_of_type_ArrayOfInt = new int[i];
      System.arraycopy(arrayOfString, 0, this.jdField_a_of_type_ArrayOfJavaLangString, 0, i);
      System.arraycopy(arrayOfInt, 0, this.jdField_a_of_type_ArrayOfInt, 0, i);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabClickListener(this);
      return;
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendNewFragment", 2, "loadSquareFragment");
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment = new ExtendFriendSquareFragment();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.i(this.jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment) {
        break label144;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.isAdded()) {
        break label116;
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).add(2131365312, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment, "squareFragment").commitAllowingStateLoss();
    }
    for (;;)
    {
      i();
      this.jdField_a_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment;
      return;
      label116:
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment).commitAllowingStateLoss();
    }
    label144:
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.j();
  }
  
  private void h()
  {
    QLog.d("ExtendFriendNewFragment", 2, "loadExtendFeedsFragment");
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusNewFragment == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusNewFragment = new ExtendFriendCampusNewFragment();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusNewFragment.i(this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusNewFragment) {
        break label149;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusNewFragment.isAdded()) {
        break label121;
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).add(2131365312, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusNewFragment, "campusFragment").commitAllowingStateLoss();
      i();
      this.jdField_a_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusNewFragment;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.f(this.jdField_a_of_type_Int);
      return;
      label121:
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusNewFragment).commitAllowingStateLoss();
      break;
      label149:
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusNewFragment.j();
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment == this.jdField_a_of_type_AndroidSupportV4AppFragment)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.k();
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator == null)) {
      return;
    }
    try
    {
      Object localObject = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (this.jdField_b_of_type_Int != -1)
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject).a("7720.772001");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(this.jdField_a_of_type_ArrayOfInt[this.jdField_b_of_type_Int], localAppInfo);
      }
      if (this.jdField_a_of_type_Int != -1)
      {
        localObject = ((RedTouchManager)localObject).a("7720.772003");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(this.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int], (BusinessInfoCheckUpdate.AppInfo)localObject);
        if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).num.get() > 0))
        {
          localObject = new LpReportInfo_pf00064();
          ((LpReportInfo_pf00064)localObject).actionType = 230;
          ((LpReportInfo_pf00064)localObject).subactionType = 1;
          ((LpReportInfo_pf00064)localObject).reserves = 1;
          LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, true);
        }
      }
      MatchChatMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendNewFragment", 1, "updateExtendRedDot fail.", localException);
    }
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    e();
    Object localObject2;
    Object localObject1;
    if (paramInt == this.jdField_b_of_type_Int)
    {
      g();
      localObject2 = "";
      localObject1 = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("extend_friend");
      if ((localObject1 == null) || (((SosoLbsInfo)localObject1).mLocation == null)) {
        break label213;
      }
      localObject2 = ((SosoLbsInfo)localObject1).mLocation;
      if (TextUtils.isEmpty(((SosoLocation)localObject2).city)) {
        break label207;
      }
      localObject1 = ((SosoLocation)localObject2).city;
      localObject2 = String.format("%s;%s", new Object[] { Double.valueOf(((SosoLocation)localObject2).mLat02), Double.valueOf(((SosoLocation)localObject2).mLon02) });
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092D2", "0X80092D2", 0, 0, "", "", (String)localObject1, (String)localObject2);
      ExpandReportUtils.a("click#voice_tab#voice_btn", true, -1L, -1L, null, true, true);
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a(paramInt);
        a(paramInt);
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        return 0;
        if (paramInt == this.jdField_a_of_type_Int)
        {
          h();
          ExpandReportUtils.a("click#school_tab#school_btn", true, -1L, -1L, null, true, true);
        }
      }
      label207:
      localObject1 = "";
      break;
      label213:
      localObject1 = "";
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int) {
      g();
    }
    while (paramInt != this.jdField_a_of_type_Int) {
      return;
    }
    h();
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
    if (((paramInt1 == 1031) || (paramInt1 == 1) || (paramInt1 == 3) || (paramInt1 == 2)) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment != null)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      if ((paramInt1 != -1) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusNewFragment != null)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusNewFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      return;
      paramInt1 = 20121205;
      continue;
      paramInt1 = 20121206;
      continue;
      paramInt1 = 20121207;
      continue;
      paramInt1 = 20121208;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.doOnBackPressed();
        continue;
        if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
        {
          ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A696", "0X800A696", 0, 0, "", "", "", "");
          MatchChatMsgListFragment.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.i("ExtendFriendNewFragment", 4, "onCreate");
    super.onCreate(paramBundle);
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager = ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
      paramBundle = (IWebProcessManagerService)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getRuntimeService(IWebProcessManagerService.class, "");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendNewFragment", 2, "onCreate, preload web process");
        }
        paramBundle.startWebProcess(-1, null);
      }
    }
    ExtendFriendReport.a().a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092F0", "0X80092F0", 0, 0, "", "", "", "");
    ExtendFriendManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.i("ExtendFriendNewFragment", 4, "onCreateView " + jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131561195, null));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379487));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378256));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380762));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372298);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("extend_frient_type_url");
    if (this.jdField_b_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        paramLayoutInflater = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
        paramLayoutInflater.topMargin = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(paramLayoutInflater);
      }
    }
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379465);
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setOnClickListener(this);
    }
    int i;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      if (bool)
      {
        i = 0;
        paramLayoutInflater.setVisibility(i);
      }
    }
    else
    {
      if (paramBundle != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment = ((ExtendFriendSquareFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("squareFragment"));
      }
      if (!jdField_a_of_type_Boolean) {
        break label308;
      }
      a(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      ((ExtendFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f();
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      i = 8;
      break;
      label308:
      c();
    }
  }
  
  public void onDestroy()
  {
    ((ExtendFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).g();
    QLog.i("ExtendFriendNewFragment", 4, "onDestroy");
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendNewFragment", 2, "onDestroy");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
      CampusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    }
    int i = (int)((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L);
    if ((this.jdField_a_of_type_Long > 0L) && (i > 0) && (i < 86400))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092EF", "0X80092EF", 0, i, "", "", "", "");
      }
      ExtendFriendReport.a().a(i);
    }
    ExtendFriendSendMsgHelper localExtendFriendSendMsgHelper = ExtendFriendSendMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localExtendFriendSendMsgHelper != null) {
      localExtendFriendSendMsgHelper.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a(-1);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    int i = paramIntent.getIntExtra("position", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendNewFragment", 2, String.format("onNewIntent position=%s", new Object[] { Integer.valueOf(i) }));
    }
    if ((i >= 0) && (a(i))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(i, false);
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
    int i = getActivity().getIntent().getIntExtra("extend_frient_from", 0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("frompage", String.valueOf(i));
    ExpandReportUtils.a("expose#all_page#view", true, -1L, -1L, localHashMap, true, true);
    if (this.jdField_b_of_type_Long == 0L) {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendNewFragment
 * JD-Core Version:    0.7.0.1
 */