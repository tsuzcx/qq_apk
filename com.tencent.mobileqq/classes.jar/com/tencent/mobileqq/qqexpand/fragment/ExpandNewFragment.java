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
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.OnCurrentTabClickListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.OnTabListener;
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
  implements View.OnClickListener, SimpleSlidingIndicator.OnCurrentTabClickListener, SimpleSlidingIndicator.OnTabListener
{
  private static volatile boolean jdField_a_of_type_Boolean = false;
  private static volatile boolean jdField_b_of_type_Boolean = true;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FragmentManager jdField_a_of_type_AndroidxFragmentAppFragmentManager;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private QBaseFragment jdField_a_of_type_ComTencentMobileqqAppQBaseFragment;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExpandCampusNewFragment jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandCampusNewFragment;
  private ExtendFriendSquareFragment jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSquareFragment;
  private IExpandManager jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager;
  private final ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new ExpandNewFragment.2(this);
  private final RedpointObserver jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver = new ExpandNewFragment.1(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private String jdField_a_of_type_JavaLangString;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long = 0L;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  static {}
  
  static void a()
  {
    jdField_b_of_type_Boolean = false;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendNewFragment", 2, String.format("redDotTouchClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject1 = "";
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)((QQAppInterface)localObject2).getRuntimeService(IRedTouchManager.class, "");
    if (this.jdField_b_of_type_Int == paramInt)
    {
      localObject1 = "7720.772001";
    }
    else if (this.jdField_a_of_type_Int == paramInt)
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
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
    if (localObject1 != null)
    {
      localObject2 = this.jdField_a_of_type_ArrayOfInt;
      if (localObject2.length > paramInt) {
        ((SimpleSlidingIndicator)localObject1).a(localObject2[paramInt]);
      }
    }
    j();
  }
  
  private void a(String paramString)
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      if (this.d) {
        return;
      }
      this.d = true;
      f();
      b(paramString);
      j();
      b();
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == this.jdField_a_of_type_Int) || (paramInt == this.jdField_b_of_type_Int);
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      localObject = (IRedTouchManager)((QQAppInterface)localObject).getRuntimeService(IRedTouchManager.class, "");
      if (((IRedTouchManager)localObject).getAppInfoByPath("7720.772001").iNewFlag.get() == 1)
      {
        ((IRedTouchManager)localObject).onRedTouchItemClick("7720.772001");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.postDelayed(new ExpandNewFragment.3(this), 1500L);
      }
    }
  }
  
  private void b(String paramString)
  {
    ViewGroup localViewGroup = this.jdField_b_of_type_AndroidViewViewGroup;
    if (localViewGroup != null) {
      localViewGroup.setVisibility(0);
    }
    if ((paramString != null) && (paramString.equals("voice")))
    {
      this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      g();
    }
    else if (this.jdField_a_of_type_Int == 0)
    {
      h();
    }
    else
    {
      this.jdField_c_of_type_Int = 0;
      g();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(this.jdField_c_of_type_Int, false);
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
      jdField_a_of_type_Boolean = true;
    }
    a(this.jdField_a_of_type_JavaLangString);
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
      jdField_a_of_type_Boolean = false;
      return;
    }
    jdField_a_of_type_Boolean = QZoneApiProxy.needShowSchoolExtendFeed(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("preLoadData: needShowSchoolExtendFeed to load qzone plugin ");
    ((StringBuilder)localObject).append(jdField_a_of_type_Boolean);
    QLog.i("ExtendFriendNewFragment", 1, ((StringBuilder)localObject).toString());
    if (jdField_a_of_type_Boolean) {
      QZoneApiProxy.initSchoolExtendListCreator();
    }
  }
  
  private void e()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseFragment;
    if (localObject1 == this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandCampusNewFragment) {
      localObject1 = "exit#school_tab#view";
    }
    for (;;)
    {
      break;
      if (localObject1 == this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSquareFragment) {
        localObject1 = "exit#voice_tab#view";
      } else {
        localObject1 = "";
      }
    }
    if ((this.jdField_b_of_type_Long != 0L) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_b_of_type_Long;
      localObject2 = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1 - l2);
      localStringBuilder.append("");
      ((Map)localObject2).put("duration", localStringBuilder.toString());
      ExpandReportUtils.a((String)localObject1, true, -1L, -1L, (Map)localObject2, true, true);
      this.jdField_b_of_type_Long = 0L;
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
    int i;
    if ((jdField_a_of_type_Boolean) && (jdField_b_of_type_Boolean))
    {
      arrayOfString[0] = getString(2131698918);
      arrayOfInt[0] = 2131366372;
      this.jdField_a_of_type_Int = 0;
      i = 1;
    }
    else
    {
      i = 0;
    }
    arrayOfString[i] = getString(2131698917);
    arrayOfInt[i] = 2131366376;
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
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendNewFragment", 2, "loadSquareFragment");
    }
    if (this.jdField_a_of_type_AndroidxFragmentAppFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSquareFragment == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSquareFragment = new ExtendFriendSquareFragment();
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSquareFragment.b(this.jdField_b_of_type_Int);
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseFragment;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSquareFragment;
      if (localObject1 != localObject2)
      {
        localObject1 = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.beginTransaction();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseFragment;
        if (localObject2 != null) {
          ((FragmentTransaction)localObject1).hide((Fragment)localObject2);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSquareFragment.isAdded()) {
          ((FragmentTransaction)localObject1).add(2131365187, this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSquareFragment, "squareFragment");
        } else {
          ((FragmentTransaction)localObject1).show(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSquareFragment);
        }
        ((FragmentTransaction)localObject1).commitAllowingStateLoss();
        i();
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseFragment = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSquareFragment;
        return;
      }
      ((ExtendFriendSquareFragment)localObject2).b();
    }
  }
  
  private void h()
  {
    QLog.d("ExtendFriendNewFragment", 2, "loadExtendFeedsFragment");
    if (this.jdField_a_of_type_AndroidxFragmentAppFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandCampusNewFragment == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandCampusNewFragment = new ExpandCampusNewFragment();
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandCampusNewFragment.b(this.jdField_a_of_type_Int);
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseFragment;
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandCampusNewFragment;
      if (localObject1 != localObject2)
      {
        localObject1 = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.beginTransaction();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseFragment;
        if (localObject2 != null) {
          ((FragmentTransaction)localObject1).hide((Fragment)localObject2);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandCampusNewFragment.isAdded()) {
          ((FragmentTransaction)localObject1).add(2131365187, this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandCampusNewFragment, "campusFragment");
        } else {
          ((FragmentTransaction)localObject1).show(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandCampusNewFragment);
        }
        ((FragmentTransaction)localObject1).commitAllowingStateLoss();
        i();
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseFragment = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandCampusNewFragment;
      }
      else
      {
        ((ExpandCampusNewFragment)localObject2).b();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.f(this.jdField_a_of_type_Int);
  }
  
  private void i()
  {
    ExtendFriendSquareFragment localExtendFriendSquareFragment = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSquareFragment;
    if ((localExtendFriendSquareFragment != null) && (localExtendFriendSquareFragment == this.jdField_a_of_type_ComTencentMobileqqAppQBaseFragment)) {
      localExtendFriendSquareFragment.j();
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator == null) {
          return;
        }
        try
        {
          localObject = (IRedTouchManager)((QQAppInterface)localObject).getRuntimeService(IRedTouchManager.class, "");
          if (this.jdField_b_of_type_Int != -1)
          {
            BusinessInfoCheckUpdate.AppInfo localAppInfo = ((IRedTouchManager)localObject).getAppInfoByPath("7720.772001");
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(this.jdField_a_of_type_ArrayOfInt[this.jdField_b_of_type_Int], localAppInfo);
          }
          if (this.jdField_a_of_type_Int != -1)
          {
            localObject = ((IRedTouchManager)localObject).getAppInfoByPath("7720.772003");
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
    }
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    e();
    if (paramInt == this.jdField_b_of_type_Int)
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
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092D2", "0X80092D2", 0, 0, "", "", str, (String)localObject);
      ExpandReportUtils.a("click#voice_tab#voice_btn", true, -1L, -1L, null, true, true);
    }
    else if (paramInt == this.jdField_a_of_type_Int)
    {
      h();
      ExpandReportUtils.a("click#school_tab#school_btn", true, -1L, -1L, null, true, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.b(paramInt);
    a(paramInt);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    return 0;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int)
    {
      g();
      return;
    }
    if (paramInt == this.jdField_a_of_type_Int) {
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSquareFragment;
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExpandCampusNewFragment;
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
    case 2131378818: 
      if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A696", "0X800A696", 0, 0, "", "", "", "");
        MatchChatMsgListFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 0);
        return;
      }
      break;
    case 2131378817: 
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
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
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getQBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_AndroidxFragmentAppFragmentManager = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSupportFragmentManager();
      this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager = ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
      this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.b(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
      paramBundle = (IWebProcessManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IWebProcessManagerService.class, "");
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendNewFragment", 2, "onCreate, preload web process");
        }
        paramBundle.startWebProcess(-1, null);
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    ExtendFriendReport.a().b();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092F0", "0X80092F0", 0, 0, "", "", "", "");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("onCreateView ");
    paramViewGroup.append(jdField_a_of_type_Boolean);
    QLog.i("ExtendFriendNewFragment", 4, paramViewGroup.toString());
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131561063, null));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378837));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377670));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380027));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371886);
    this.jdField_a_of_type_JavaLangString = getActivity().getIntent().getStringExtra("extend_frient_type_url");
    paramLayoutInflater = this.jdField_b_of_type_AndroidViewViewGroup;
    if (paramLayoutInflater != null)
    {
      paramLayoutInflater.setVisibility(4);
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        paramLayoutInflater = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewViewGroup.getLayoutParams();
        paramLayoutInflater.topMargin = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
        this.jdField_b_of_type_AndroidViewViewGroup.setLayoutParams(paramLayoutInflater);
      }
    }
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378817);
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setOnClickListener(this);
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      int i;
      if (bool) {
        i = 0;
      } else {
        i = 8;
      }
      paramLayoutInflater.setVisibility(i);
    }
    if (paramBundle != null) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendSquareFragment = ((ExtendFriendSquareFragment)this.jdField_a_of_type_AndroidxFragmentAppFragmentManager.findFragmentByTag("squareFragment"));
    }
    if (jdField_a_of_type_Boolean) {
      a(this.jdField_a_of_type_JavaLangString);
    } else {
      c();
    }
    ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).e();
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void onDestroy()
  {
    ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f();
    QLog.i("ExtendFriendNewFragment", 4, "onDestroy");
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendNewFragment", 2, "onDestroy");
    }
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
      CampusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    int i = (int)((l1 - l2) / 1000L);
    if ((l2 > 0L) && (i > 0) && (i < 86400))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (localObject != null) {
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X80092EF", "0X80092EF", 0, i, "", "", "", "");
      }
      ExtendFriendReport.a().a(i);
    }
    localObject = ExtendFriendSendMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localObject != null) {
      ((ExtendFriendSendMsgHelper)localObject).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.b(-1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandNewFragment
 * JD-Core Version:    0.7.0.1
 */