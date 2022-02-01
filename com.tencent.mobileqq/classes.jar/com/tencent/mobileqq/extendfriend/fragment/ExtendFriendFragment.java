package com.tencent.mobileqq.extendfriend.fragment;

import adlk;
import ajkg;
import ajkh;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
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
import aocm;
import aslm;
import aslo;
import aslx;
import aslz;
import asow;
import asox;
import asoy;
import asoz;
import aspa;
import aspb;
import aspc;
import aspd;
import aspe;
import asru;
import assp;
import asss;
import assw;
import assy;
import asur;
import awui;
import bbbq;
import bdla;
import bhdj;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.HashMap;
import mvl;

public class ExtendFriendFragment
  extends PublicBaseFragment
  implements ajkg, ajkh, View.OnClickListener
{
  private static volatile boolean jdField_a_of_type_Boolean;
  private static volatile boolean jdField_b_of_type_Boolean = true;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new aspb(this);
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aocm jdField_a_of_type_Aocm = new asow(this);
  private aslo jdField_a_of_type_Aslo;
  private aslz jdField_a_of_type_Aslz = new asoy(this);
  private aspe jdField_a_of_type_Aspe = new aspa(this);
  private asur jdField_a_of_type_Asur;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExtendFriendCampusFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment;
  private ExtendFriendSquareFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment;
  private ExtendFriendLimitChatMatchFragment jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  static
  {
    UserAction.registerTunnel(new TunnelInfo("0AND0Y11VZ3PFHQD"));
  }
  
  static void a()
  {
    jdField_b_of_type_Boolean = false;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "showFillBirthdayDialog birthday = " + paramInt);
    }
    if (!a(paramInt)) {
      return;
    }
    if (this.jdField_a_of_type_Asur == null) {
      this.jdField_a_of_type_Asur = new asur(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramInt, new asoz(this));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "showFillBirthdayDialog do show");
    }
    this.jdField_a_of_type_Asur.show();
    assp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
      QLog.d("ExtendFriendFragment", 1, "checkCanShowFillBirthdayDialog isFinishing ");
    }
    do
    {
      do
      {
        return false;
      } while (assp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      if (paramInt <= 0) {
        return true;
      }
      paramInt = adlk.a(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendFragment", 2, "checkCanShowFillBirthdayDialog age = " + paramInt);
      }
    } while ((paramInt >= 7) && (paramInt <= 40));
    return true;
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == this.jdField_c_of_type_Int) || (paramInt == this.jdField_a_of_type_Int) || (paramInt == this.jdField_b_of_type_Int);
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendFragment", 2, String.format("redDotTouchClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    bbbq localbbbq = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    Object localObject = "";
    if (this.jdField_b_of_type_Int == paramInt) {
      localObject = "7720.772001";
    }
    for (;;)
    {
      localbbbq.b((String)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null) && (this.jdField_a_of_type_ArrayOfInt.length > paramInt)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(this.jdField_a_of_type_ArrayOfInt[paramInt]);
      }
      m();
      return;
      if (this.jdField_a_of_type_Int == paramInt)
      {
        String str = "7720.772003";
        BusinessInfoCheckUpdate.AppInfo localAppInfo = localbbbq.a("7720.772003");
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
  
  private void d()
  {
    if ((this.jdField_c_of_type_Boolean) || (this.d)) {
      return;
    }
    this.d = true;
    g();
    h();
    o();
    m();
    e();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      bbbq localbbbq = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (localbbbq.a("7720.772001").iNewFlag.get() == 1)
      {
        localbbbq.b("7720.772001");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.postDelayed(new ExtendFriendFragment.6(this), 1500L);
      }
    }
  }
  
  private void f()
  {
    QzoneHandlerThreadFactory.getHandlerThread("Normal_HandlerThread").post(new ExtendFriendFragment.7(this));
  }
  
  private void g()
  {
    String[] arrayOfString = new String[10];
    int[] arrayOfInt = new int[10];
    if (this.jdField_a_of_type_Aslo != null)
    {
      aslx localaslx = this.jdField_a_of_type_Aslo.a();
      if ((localaslx == null) || (localaslx.i != 1)) {}
    }
    for (int i = 1;; i = 0)
    {
      if ((jdField_a_of_type_Boolean) && (jdField_b_of_type_Boolean))
      {
        arrayOfString[0] = getString(2131698424);
        arrayOfInt[0] = 2131366315;
        this.jdField_a_of_type_Int = 0;
      }
      for (int j = 1;; j = 0)
      {
        arrayOfString[j] = getString(2131698536);
        arrayOfInt[j] = 2131366322;
        this.jdField_b_of_type_Int = j;
        j += 1;
        if (i != 0)
        {
          arrayOfString[j] = getString(2131698498);
          arrayOfInt[j] = 2131366316;
          this.jdField_c_of_type_Int = j;
        }
        for (i = j + 1;; i = j)
        {
          if (i == 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131698536));
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(this);
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabClickListener(this);
            return;
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setVisibility(0);
            this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_a_of_type_ArrayOfJavaLangString = new String[i];
            this.jdField_a_of_type_ArrayOfInt = new int[i];
            System.arraycopy(arrayOfString, 0, this.jdField_a_of_type_ArrayOfJavaLangString, 0, i);
            System.arraycopy(arrayOfInt, 0, this.jdField_a_of_type_ArrayOfInt, 0, i);
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setTabData(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfInt);
          }
        }
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    if (this.jdField_a_of_type_Int == 0) {
      j();
    }
    while (this.jdField_b_of_type_Int != 0) {
      return;
    }
    i();
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "loadSquareFragment");
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment = new ExtendFriendSquareFragment();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.i(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.a(this.jdField_a_of_type_Aspe);
      }
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment) {
        break label155;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.isAdded()) {
        break label127;
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).add(2131365174, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment, "squareFragment").commitAllowingStateLoss();
    }
    for (;;)
    {
      l();
      this.jdField_a_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment;
      return;
      label127:
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment).commitAllowingStateLoss();
    }
    label155:
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.i();
  }
  
  private void j()
  {
    QLog.d("ExtendFriendFragment", 2, "loadExtendFeedsFragment");
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment = new ExtendFriendCampusFragment();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment.i(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment.a(this.jdField_a_of_type_Aspe);
      }
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment) {
        break label160;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment.isAdded()) {
        break label132;
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).add(2131365174, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment, "campusFragment").commitAllowingStateLoss();
      l();
      this.jdField_a_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.f(this.jdField_a_of_type_Int);
      return;
      label132:
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment).commitAllowingStateLoss();
      break;
      label160:
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment.i();
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "loadChatFragment");
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment != null) {
        break label105;
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment = new ExtendFriendLimitChatMatchFragment();
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment != this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment.isAdded()) {
          break label115;
        }
        this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).add(2131365174, this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment, "chatFragment").commitAllowingStateLoss();
      }
    }
    for (;;)
    {
      l();
      this.jdField_a_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment;
      return;
      label105:
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment.c();
      break;
      label115:
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment).commitAllowingStateLoss();
    }
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment == this.jdField_a_of_type_AndroidSupportV4AppFragment)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.j();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment == this.jdField_a_of_type_AndroidSupportV4AppFragment))
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment.a();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment.b();
    }
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator == null)) {
      return;
    }
    try
    {
      Object localObject = (bbbq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (this.jdField_b_of_type_Int != -1)
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = ((bbbq)localObject).a("7720.772001");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(this.jdField_a_of_type_ArrayOfInt[this.jdField_b_of_type_Int], localAppInfo);
      }
      if (this.jdField_a_of_type_Int != -1)
      {
        localObject = ((bbbq)localObject).a("7720.772003");
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
      awui.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendFragment", 1, "updateExtendRedDot fail.", localException);
    }
  }
  
  private void n()
  {
    if (this.jdField_c_of_type_Int != -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(this.jdField_c_of_type_Int, true);
      return;
    }
    QLog.e("ExtendFriendFragment", 1, "match un init");
  }
  
  private void o()
  {
    aslm localaslm = (aslm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localaslm != null) {
      localaslm.a(true, true);
    }
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    String str;
    Object localObject;
    if (paramInt == this.jdField_b_of_type_Int)
    {
      i();
      str = "";
      localObject = "";
      SosoInterface.SosoLbsInfo localSosoLbsInfo = LbsManagerService.getCachedLbsInfo("extend_friend");
      if ((localSosoLbsInfo == null) || (localSosoLbsInfo.mLocation == null)) {
        break label243;
      }
      localObject = localSosoLbsInfo.mLocation;
      if (!TextUtils.isEmpty(((SosoInterface.SosoLocation)localObject).city)) {
        str = ((SosoInterface.SosoLocation)localObject).city;
      }
      localObject = String.format("%s;%s", new Object[] { Double.valueOf(((SosoInterface.SosoLocation)localObject).mLat02), Double.valueOf(((SosoInterface.SosoLocation)localObject).mLon02) });
    }
    for (;;)
    {
      bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092D2", "0X80092D2", 0, 0, "", "", str, (String)localObject);
      UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#voice_tab#voice_btn", true, -1L, -1L, null, true, true);
      for (;;)
      {
        this.jdField_a_of_type_Aslo.a(paramInt);
        c(paramInt);
        return 0;
        if (paramInt == this.jdField_c_of_type_Int)
        {
          k();
          if (paramBoolean) {
            assw.a().b(1);
          }
          UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#chat_tab#chat_btn", true, -1L, -1L, null, true, true);
        }
        else if (paramInt == this.jdField_a_of_type_Int)
        {
          j();
          UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "click#school_tab#school_btn", true, -1L, -1L, null, true, true);
        }
      }
      label243:
      str = "";
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    asss localasss = asss.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698435), localasss.a(3), "", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698460), new aspc(this), null);
    this.jdField_a_of_type_AndroidAppDialog.show();
    localasss.a(false);
    bdla.b(null, "dc00898", "", "", "0X800B2CC", "0X800B2CC", 0, 0, "", "", "", "");
  }
  
  public void b(int paramInt)
  {
    if (paramInt == this.jdField_b_of_type_Int) {
      i();
    }
    do
    {
      return;
      if (paramInt == this.jdField_c_of_type_Int)
      {
        k();
        return;
      }
    } while (paramInt != this.jdField_a_of_type_Int);
    j();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    Object localObject2 = asss.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    long l = ((asss)localObject2).a(NetConnInfoCenter.getServerTime());
    Object localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    localObject2 = ((asss)localObject2).a(4);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (l == -1L) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = aslo.a((BaseActivity)localObject1, (String)localObject2, localQQAppInterface, bool, l);
      this.jdField_a_of_type_AndroidAppDialog = bhdj.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698433), (CharSequence)localObject1, "", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698460), new aspd(this), null);
      this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new asox(this));
      this.jdField_a_of_type_AndroidAppDialog.show();
      bdla.b(null, "dc00898", "", "", "0X800B2CE", "0X800B2CE", 0, 0, "", "", "", "");
      return;
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
      QLog.d("ExtendFriendFragment", 2, String.format("onActivityResult requestCode=%s resultCode=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
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
      if ((paramInt1 != -1) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment != null)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
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
          bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A696", "0X800A696", 0, 0, "", "", "", "");
          MatchChatMsgListFragment.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.i("ExtendFriendFragment", 4, "onCreate");
    super.onCreate(paramBundle);
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager();
      this.jdField_a_of_type_Aslo = ((aslo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
      this.jdField_a_of_type_Aslo.a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aocm);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aslz);
      paramBundle = (WebProcessManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.WEBPROCESS_MANAGER);
      if (paramBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendFragment", 2, "onCreate, preload web process");
        }
        paramBundle.e();
      }
    }
    assw.a().a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    bdla.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092F0", "0X80092F0", 0, 0, "", "", "", "");
    aslo.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.i("ExtendFriendFragment", 4, "onCreateView " + jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131561106, null));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379056));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377844));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380319));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379035);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131371991);
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
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379034);
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setOnClickListener(this);
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new mvl());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getActivity(), this.jdField_a_of_type_AndroidViewView).b(53).a();
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.g(25);
    }
    int i;
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      paramLayoutInflater = this.jdField_b_of_type_AndroidViewView;
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
        break label381;
      }
      d();
    }
    for (;;)
    {
      ((aslo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).e();
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      i = 8;
      break;
      label381:
      f();
    }
  }
  
  public void onDestroy()
  {
    ((aslo)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f();
    QLog.i("ExtendFriendFragment", 4, "onDestroy");
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onDestroy");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocm);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aslz);
      assp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false);
    }
    int i = (int)((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L);
    if ((this.jdField_a_of_type_Long > 0L) && (i > 0) && (i < 86400))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092EF", "0X80092EF", 0, i, "", "", "", "");
      }
      assw.a().a(i);
    }
    assy localassy = assy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localassy != null) {
      localassy.a();
    }
    this.jdField_a_of_type_Aslo.a(-1);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    int i = paramIntent.getIntExtra("position", 0);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, String.format("onNewIntent position=%s", new Object[] { Integer.valueOf(i) }));
    }
    if ((i >= 0) && (b(i))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(i, false);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseAll();
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.resumeAll();
    int i = getActivity().getIntent().getIntExtra("extend_frient_from", 0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("frompage", String.valueOf(i));
    UserAction.onUserActionToTunnel("0AND0Y11VZ3PFHQD", "expose#all_page#view", true, -1L, -1L, localHashMap, true, true);
  }
  
  public void onStart()
  {
    super.onStart();
    if (!this.e) {
      this.e = asru.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment
 * JD-Core Version:    0.7.0.1
 */