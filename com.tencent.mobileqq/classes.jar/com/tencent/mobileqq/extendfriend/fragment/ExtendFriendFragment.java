package com.tencent.mobileqq.extendfriend.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
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
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.BirthdayPickHelper;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.OnCurrentTabClickListener;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator.OnTabListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.config.ExtendFriendConfig;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.extendfriend.limitchat.SignalBombHelper;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.utils.CampusHelper;
import com.tencent.mobileqq.extendfriend.utils.ColdPalaceHelper;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper;
import com.tencent.mobileqq.extendfriend.wiget.FillBirthdayDialog;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
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
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.HashMap;
import java.util.Map;

public class ExtendFriendFragment
  extends PublicBaseFragment
  implements View.OnClickListener, SimpleSlidingIndicator.OnCurrentTabClickListener, SimpleSlidingIndicator.OnTabListener
{
  private static volatile boolean jdField_a_of_type_Boolean = false;
  private static volatile boolean jdField_b_of_type_Boolean = true;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new ExtendFriendFragment.5(this);
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExtendFriendManager jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager;
  private ExtendFriendCampusFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment;
  private ExtendFriendFragment.OnTabRequiredListener jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$OnTabRequiredListener = new ExtendFriendFragment.4(this);
  private ExtendFriendRecommendFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendRecommendFragment;
  private ExtendFriendSquareFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment;
  private ExtendFriendLimitChatMatchFragment jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment;
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new ExtendFriendFragment.2(this);
  private FillBirthdayDialog jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFillBirthdayDialog;
  private RedpointObserver jdField_a_of_type_ComTencentMobileqqTianshuObserverRedpointObserver = new ExtendFriendFragment.1(this);
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ExtendFriendFragment.8(this);
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int = -1;
  private long jdField_b_of_type_Long = 0L;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private int jdField_c_of_type_Int = -1;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 0;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean f = true;
  
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
      QLog.d("ExtendFriendFragment", 2, "showFillBirthdayDialog birthday = " + paramInt);
    }
    if (!a(paramInt)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFillBirthdayDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFillBirthdayDialog = new FillBirthdayDialog(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramInt, new ExtendFriendFragment.3(this));
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "showFillBirthdayDialog do show");
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFillBirthdayDialog.show();
    CampusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      } while (CampusHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      if (paramInt <= 0) {
        return true;
      }
      paramInt = BirthdayPickHelper.a(paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendFragment", 2, "checkCanShowFillBirthdayDialog age = " + paramInt);
      }
    } while ((paramInt >= 7) && (paramInt <= 40));
    return true;
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt == this.jdField_d_of_type_Int) || (paramInt == this.jdField_b_of_type_Int) || (paramInt == this.jdField_c_of_type_Int);
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendFragment", 2, String.format("redDotTouchClick position=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
    Object localObject = "";
    if (this.jdField_c_of_type_Int == paramInt) {
      localObject = "7720.772001";
    }
    for (;;)
    {
      localRedTouchManager.b((String)localObject);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator != null) && (this.jdField_a_of_type_ArrayOfInt.length > paramInt)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(this.jdField_a_of_type_ArrayOfInt[paramInt]);
      }
      p();
      return;
      if (this.jdField_b_of_type_Int == paramInt)
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
  
  private void d()
  {
    if ((this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean)) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    i();
    j();
    r();
    p();
    e();
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (localRedTouchManager.a("7720.772001").iNewFlag.get() == 1)
      {
        localRedTouchManager.b("7720.772001");
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
    String str = "";
    if (this.jdField_a_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment) {
      str = "exit#school_tab#view";
    }
    while ((this.jdField_b_of_type_Long == 0L) || (TextUtils.isEmpty(str)))
    {
      QLog.w("ExtendFriendFragment", 4, "report error " + str);
      return;
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment) {
        str = "exit#voice_tab#view";
      } else if (this.jdField_a_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment) {
        str = "exit#chat_tab#view";
      }
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_b_of_type_Long;
    HashMap localHashMap = new HashMap();
    localHashMap.put("duration", l1 - l2 + "");
    ExpandReportUtils.a(str, true, -1L, -1L, localHashMap, true, true);
    this.jdField_b_of_type_Long = 0L;
  }
  
  private void h()
  {
    long l = System.currentTimeMillis() - this.jdField_c_of_type_Long;
    if ((this.jdField_c_of_type_Long > 0L) && (l > 0L))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("duration", l + "");
      localHashMap.put("ext_int1", "1");
      ExpandReportUtils.a("exit#all_page#view", true, -1L, -1L, localHashMap, true, true);
      this.jdField_c_of_type_Long = 0L;
    }
  }
  
  private void i()
  {
    String[] arrayOfString = new String[10];
    int[] arrayOfInt = new int[10];
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager != null)
    {
      ExtendFriendConfig localExtendFriendConfig = this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a();
      if ((localExtendFriendConfig == null) || (localExtendFriendConfig.p != 1)) {}
    }
    for (int i = 1;; i = 0)
    {
      if ((jdField_a_of_type_Boolean) && (jdField_b_of_type_Boolean))
      {
        arrayOfString[0] = getString(2131698707);
        arrayOfInt[0] = 2131366489;
        this.jdField_b_of_type_Int = 0;
      }
      for (int j = 1;; j = 0)
      {
        arrayOfString[j] = getString(2131698828);
        arrayOfInt[j] = 2131366496;
        this.jdField_c_of_type_Int = j;
        j += 1;
        if (i != 0)
        {
          arrayOfString[j] = getString(2131698782);
          arrayOfInt[j] = 2131366490;
          this.jdField_d_of_type_Int = j;
        }
        for (i = j + 1;; i = j)
        {
          if (i == 1)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131698828));
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
  
  private void j()
  {
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    if ((this.jdField_d_of_type_Int != -1) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.e() == 1))
    {
      this.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(this.jdField_e_of_type_Int, false);
    }
    do
    {
      return;
      this.jdField_e_of_type_Int = 0;
      if (this.jdField_a_of_type_Int == 0)
      {
        k();
        return;
      }
      if (this.jdField_b_of_type_Int == 0)
      {
        m();
        return;
      }
    } while (this.jdField_c_of_type_Int != 0);
    l();
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "loadRecommendFragment");
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendRecommendFragment == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendRecommendFragment = new ExtendFriendRecommendFragment();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendRecommendFragment.i(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendRecommendFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$OnTabRequiredListener);
      }
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendRecommendFragment) {
        break label155;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendRecommendFragment.isAdded()) {
        break label127;
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).add(2131365312, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendRecommendFragment, "recommendFragment").commitAllowingStateLoss();
    }
    for (;;)
    {
      o();
      this.jdField_a_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendRecommendFragment;
      return;
      label127:
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendRecommendFragment).commitAllowingStateLoss();
    }
    label155:
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendRecommendFragment.j();
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "loadSquareFragment");
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment = new ExtendFriendSquareFragment();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.i(this.jdField_c_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$OnTabRequiredListener);
      }
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment) {
        break label155;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.isAdded()) {
        break label127;
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).add(2131365312, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment, "squareFragment").commitAllowingStateLoss();
    }
    for (;;)
    {
      o();
      this.jdField_a_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment;
      return;
      label127:
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment).commitAllowingStateLoss();
    }
    label155:
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.j();
  }
  
  private void m()
  {
    QLog.d("ExtendFriendFragment", 2, "loadExtendFeedsFragment");
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment = new ExtendFriendCampusFragment();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment.i(this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$OnTabRequiredListener);
      }
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment) {
        break label160;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment.isAdded()) {
        break label132;
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).add(2131365312, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment, "campusFragment").commitAllowingStateLoss();
      o();
      this.jdField_a_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.f(this.jdField_b_of_type_Int);
      return;
      label132:
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment).commitAllowingStateLoss();
      break;
      label160:
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment.j();
    }
  }
  
  private void n()
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
        this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).add(2131365312, this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment, "chatFragment").commitAllowingStateLoss();
      }
    }
    for (;;)
    {
      o();
      this.jdField_a_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment;
      return;
      label105:
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment.c();
      break;
      label115:
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment).commitAllowingStateLoss();
    }
  }
  
  private void o()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment == this.jdField_a_of_type_AndroidSupportV4AppFragment)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.k();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment == this.jdField_a_of_type_AndroidSupportV4AppFragment))
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment.a();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment.b();
    }
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator == null)) {
      return;
    }
    try
    {
      Object localObject = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (this.jdField_c_of_type_Int != -1)
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = ((RedTouchManager)localObject).a("7720.772001");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(this.jdField_a_of_type_ArrayOfInt[this.jdField_c_of_type_Int], localAppInfo);
      }
      if (this.jdField_b_of_type_Int != -1)
      {
        localObject = ((RedTouchManager)localObject).a("7720.772003");
        if (this.jdField_a_of_type_ArrayOfInt != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.a(this.jdField_a_of_type_ArrayOfInt[this.jdField_b_of_type_Int], (BusinessInfoCheckUpdate.AppInfo)localObject);
        }
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
      QLog.e("ExtendFriendFragment", 1, "updateExtendRedDot fail.", localException);
    }
  }
  
  private void q()
  {
    if (this.jdField_d_of_type_Int != -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setCurrentPosition(this.jdField_d_of_type_Int, true);
      return;
    }
    QLog.e("ExtendFriendFragment", 1, "match un init");
  }
  
  private void r()
  {
    ExtendFriendHandler localExtendFriendHandler = (ExtendFriendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localExtendFriendHandler != null) {
      localExtendFriendHandler.a(true, true);
    }
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      g();
    }
    if (paramInt == this.jdField_a_of_type_Int)
    {
      k();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a(paramInt);
      c(paramInt);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      return 0;
    }
    Object localObject2;
    Object localObject1;
    if (paramInt == this.jdField_c_of_type_Int)
    {
      l();
      localObject2 = "";
      localObject1 = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("extend_friend");
      if ((localObject1 == null) || (((SosoLbsInfo)localObject1).mLocation == null)) {
        break label274;
      }
      localObject2 = ((SosoLbsInfo)localObject1).mLocation;
      if (TextUtils.isEmpty(((SosoLocation)localObject2).city)) {
        break label268;
      }
      localObject1 = ((SosoLocation)localObject2).city;
      label110:
      localObject2 = String.format("%s;%s", new Object[] { Double.valueOf(((SosoLocation)localObject2).mLat02), Double.valueOf(((SosoLocation)localObject2).mLon02) });
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092D2", "0X80092D2", 0, 0, "", "", (String)localObject1, (String)localObject2);
      ExpandReportUtils.a("click#voice_tab#voice_btn", true, -1L, -1L, null, true, true);
      break;
      if (paramInt == this.jdField_d_of_type_Int)
      {
        n();
        if (paramBoolean) {
          ExtendFriendReport.a().b(1);
        }
        ExpandReportUtils.a("click#chat_tab#chat_btn", true, -1L, -1L, null, true, true);
        break;
      }
      if (paramInt != this.jdField_b_of_type_Int) {
        break;
      }
      m();
      ExpandReportUtils.a("click#school_tab#school_btn", true, -1L, -1L, null, true, true);
      break;
      label268:
      localObject1 = "";
      break label110;
      label274:
      localObject1 = "";
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
    ColdPalaceHelper localColdPalaceHelper = ColdPalaceHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698718), localColdPalaceHelper.a(3), "", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698743), new ExtendFriendFragment.9(this), null);
    this.jdField_a_of_type_AndroidAppDialog.show();
    localColdPalaceHelper.a(false);
    ReportController.b(null, "dc00898", "", "", "0X800B2CC", "0X800B2CC", 0, 0, "", "", "", "");
  }
  
  public void b(int paramInt)
  {
    if (paramInt == this.jdField_c_of_type_Int) {
      l();
    }
    do
    {
      return;
      if (paramInt == this.jdField_d_of_type_Int)
      {
        n();
        return;
      }
      if (paramInt == this.jdField_b_of_type_Int)
      {
        m();
        return;
      }
    } while (paramInt != this.jdField_a_of_type_Int);
    k();
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidAppDialog != null) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    Object localObject2 = ColdPalaceHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    long l = ((ColdPalaceHelper)localObject2).a(NetConnInfoCenter.getServerTime());
    Object localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    localObject2 = ((ColdPalaceHelper)localObject2).a(4);
    if (l == -1L) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = ExtendFriendManager.a((Activity)localObject1, (String)localObject2, bool, l);
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131698716), (CharSequence)localObject1, "", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131698743), new ExtendFriendFragment.10(this), null);
      this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new ExtendFriendFragment.11(this));
      this.jdField_a_of_type_AndroidAppDialog.show();
      ReportController.b(null, "dc00898", "", "", "0X800B2CE", "0X800B2CE", 0, 0, "", "", "", "");
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
          ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A696", "0X800A696", 0, 0, "", "", "", "");
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
    this.jdField_d_of_type_Boolean = false;
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
          QLog.d("ExtendFriendFragment", 2, "onCreate, preload web process");
        }
        paramBundle.startWebProcess(-1, null);
      }
    }
    ExtendFriendReport.a().a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    ReportController.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092F0", "0X80092F0", 0, 0, "", "", "", "");
    ExtendFriendManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.i("ExtendFriendFragment", 4, "onCreateView " + jdField_a_of_type_Boolean);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131561194, null));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379487));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378256));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380762));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131379466);
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372298);
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
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(getActivity(), this.jdField_a_of_type_AndroidViewView).b(53).a();
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.g(25);
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
      ((ExtendFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).f();
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
    ((ExtendFriendManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).g();
    QLog.i("ExtendFriendFragment", 4, "onDestroy");
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onDestroy");
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
    h();
    ExtendFriendSendMsgHelper localExtendFriendSendMsgHelper = ExtendFriendSendMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localExtendFriendSendMsgHelper != null) {
      localExtendFriendSendMsgHelper.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a(-1);
    QzoneHandlerThreadFactory.getMainHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
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
    g();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.f)
    {
      if (QLog.isDebugVersion()) {
        QLog.d("ExtendFriendFragment", 4, "time cost " + (System.currentTimeMillis() - getActivity().getIntent().getLongExtra("startTime", 0L)));
      }
      this.f = false;
    }
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
    if (!this.jdField_e_of_type_Boolean) {
      this.jdField_e_of_type_Boolean = SignalBombHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment
 * JD-Core Version:    0.7.0.1
 */