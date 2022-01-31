package com.tencent.mobileqq.extendfriend.fragment;

import afti;
import aftj;
import ajyc;
import akfl;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import aoep;
import aoes;
import aoeu;
import aogx;
import aogy;
import aogz;
import aoha;
import aokj;
import aokk;
import asfj;
import avpq;
import axqw;
import bdse;
import bgfp;
import bgxy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contacts.view.SimpleSlidingIndicator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatMatchFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.matchchat.MatchChatMsgListFragment;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchReciver;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import mqq.app.AppRuntime;
import mug;
import xhe;

public class ExtendFriendFragment
  extends PublicBaseFragment
  implements afti, aftj, View.OnClickListener
{
  int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  akfl jdField_a_of_type_Akfl = new aogz(this);
  private Fragment jdField_a_of_type_AndroidSupportV4AppFragment;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new aogx(this);
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aoep jdField_a_of_type_Aoep;
  private aoeu jdField_a_of_type_Aoeu = new aoha(this);
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator;
  private ExtendFriendGroupFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment;
  private ExtendFriendSquareFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment;
  private FakeExtendFeedsFragment jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentFakeExtendFeedsFragment;
  private ExtendFriendLimitChatMatchFragment jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment;
  public RedTouch a;
  RedTouchReciver jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchReciver;
  private boolean jdField_a_of_type_Boolean = true;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int = 0;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private final boolean jdField_e_of_type_Boolean = bgfp.f();
  private int f = -1;
  private int g = -1;
  private int h;
  
  private void a()
  {
    String[] arrayOfString = new String[10];
    int[] arrayOfInt = new int[arrayOfString.length];
    if ((this.jdField_a_of_type_Aoep != null) && (this.jdField_a_of_type_Aoep.e()) && (bgfp.e()))
    {
      this.jdField_b_of_type_Boolean = true;
      arrayOfString[0] = ajyc.a(2131704244);
      arrayOfInt[0] = 2131365796;
      this.g = 0;
      this.h = 0;
    }
    for (int i = 1;; i = 0)
    {
      arrayOfString[i] = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getResources().getString(2131699003);
      arrayOfInt[i] = 2131365802;
      this.jdField_d_of_type_Int = i;
      int j = i + 1;
      i = j;
      if (this.jdField_a_of_type_Aoep != null)
      {
        aoes localaoes = this.jdField_a_of_type_Aoep.a();
        i = j;
        if (localaoes != null)
        {
          if (localaoes.i != 1) {
            break label313;
          }
          this.jdField_d_of_type_Boolean = true;
          arrayOfString[j] = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getResources().getString(2131698983);
          arrayOfInt[j] = 2131365794;
          this.jdField_e_of_type_Int = j;
          i = j + 1;
          if (!this.jdField_e_of_type_Boolean) {
            break label323;
          }
          this.jdField_c_of_type_Boolean = true;
          arrayOfString[i] = ajyc.a(2131704266);
          arrayOfInt[i] = 2131365803;
          this.f = i;
          i += 1;
          label206:
          if ((!bgfp.e()) || (this.jdField_b_of_type_Boolean)) {
            break label331;
          }
          this.jdField_b_of_type_Boolean = true;
          arrayOfString[i] = ajyc.a(2131704244);
          arrayOfInt[i] = 2131365796;
          this.g = i;
          this.h = i;
          i += 1;
        }
      }
      label252:
      if (i == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getBaseContext().getResources().getString(2131699003));
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setOnTabListener(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setOnTabClickListener(this);
        return;
        label313:
        this.jdField_d_of_type_Boolean = false;
        i = j;
        break;
        label323:
        this.jdField_c_of_type_Boolean = false;
        break label206;
        label331:
        this.jdField_b_of_type_Boolean = false;
        break label252;
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[i];
        this.jdField_a_of_type_ArrayOfInt = new int[i];
        System.arraycopy(arrayOfString, 0, this.jdField_a_of_type_ArrayOfJavaLangString, 0, i);
        System.arraycopy(arrayOfInt, 0, this.jdField_a_of_type_ArrayOfInt, 0, i);
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setTabData(this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_ArrayOfInt);
        QLog.i("ExtendFriendFragment", 2, " mIndexOfSqure:" + this.jdField_d_of_type_Int + " mIndexOfMatch:" + this.jdField_e_of_type_Int + " mIndexOfLive:" + this.f + " mIndexOfNuanShuoShuo:" + this.g);
      }
    }
  }
  
  private void a(int paramInt)
  {
    QLog.d("ExtendFriendFragment", 2, "loadExtendFeedsFragment pos: " + paramInt);
    this.h = paramInt;
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_qzone_index", this.h);
    ((Intent)localObject).putExtra("key_first_position", this.jdField_b_of_type_Int);
    ((Intent)localObject).putExtra("key_from_top", this.jdField_c_of_type_Int);
    ((Intent)localObject).putExtra("key_tab_lables", this.jdField_a_of_type_ArrayOfJavaLangString);
    ((Intent)localObject).putExtra("key_tab_ids", this.jdField_a_of_type_ArrayOfInt);
    ((Intent)localObject).putExtra("key_is_live_open", this.jdField_e_of_type_Boolean);
    ((Intent)localObject).putExtra("key_qzone_live_index", this.f);
    ((Intent)localObject).putExtra("key_qzone_nuanshuoshuo_index", this.g);
    ((Intent)localObject).putExtra("newflag", false);
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchReciver == null) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchReciver = new RedTouchReciver(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, bdse.a());
    }
    ((Intent)localObject).putExtra("key_red_touch", this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchReciver);
    ((Intent)localObject).putExtra("startup_sceneid", 7);
    ((Intent)localObject).putExtra("refer", "schemeActiveFeeds");
    QzonePluginProxyActivity.a((Intent)localObject, "com.qzone.feed.ui.activity.QZoneExtendFeedActiviy");
    bgxy.d(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getCurrentAccountUin(), (Intent)localObject, 1000);
    localObject = new LpReportInfo_pf00064();
    ((LpReportInfo_pf00064)localObject).actionType = 84;
    ((LpReportInfo_pf00064)localObject).subactionType = 1;
    LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.f(this.h);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentFakeExtendFeedsFragment == null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentFakeExtendFeedsFragment = new FakeExtendFeedsFragment();
      }
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment != this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentFakeExtendFeedsFragment)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentFakeExtendFeedsFragment.isAdded()) {
          break label366;
        }
        this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).add(2131364709, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentFakeExtendFeedsFragment, "feedsFragment").commitAllowingStateLoss();
      }
    }
    for (;;)
    {
      c();
      this.jdField_a_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentFakeExtendFeedsFragment;
      if (paramInt == this.f) {
        aokj.a().a();
      }
      return;
      label366:
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentFakeExtendFeedsFragment).commitAllowingStateLoss();
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == this.f) || (paramInt == this.jdField_e_of_type_Int) || (paramInt == this.g) || (paramInt == this.jdField_d_of_type_Int);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "loadSquareFragment clickPosition: " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int = this.jdField_d_of_type_Int;
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment = new ExtendFriendSquareFragment();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.a(new aogy(this));
      }
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment == this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment) {
        break label176;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.isAdded()) {
        break label148;
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).add(2131364709, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment, "squareFragment").commitAllowingStateLoss();
    }
    for (;;)
    {
      c();
      this.jdField_a_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment;
      return;
      label148:
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment).commitAllowingStateLoss();
    }
    label176:
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.i();
  }
  
  private void c()
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
  
  private void c(int paramInt)
  {
    avpq localavpq = (avpq)BaseApplicationImpl.getApplication().getRuntime().getManager(36);
    String str = "";
    QLog.i("ExtendFriendFragment", 2, "redDotTouchClick position :" + paramInt);
    if (this.jdField_d_of_type_Int == paramInt)
    {
      str = "7720.772001";
      QLog.i("ExtendFriendFragment", 2, "redDotTouchClick mIndexOfSqure :" + this.jdField_d_of_type_Int);
    }
    for (;;)
    {
      localavpq.b(str);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator != null) && (this.jdField_a_of_type_ArrayOfInt.length > paramInt)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.a(this.jdField_a_of_type_ArrayOfInt[paramInt]);
      }
      f();
      return;
      if (this.jdField_e_of_type_Int == paramInt)
      {
        QLog.i("ExtendFriendFragment", 2, "redDotTouchClick mIndexOfMatch :" + this.jdField_e_of_type_Int);
      }
      else if (this.f == paramInt)
      {
        str = "7720.772002";
        QLog.i("ExtendFriendFragment", 2, "redDotTouchClick mIndexOfLive :" + this.f);
      }
      else if (this.g == paramInt)
      {
        str = "7720.772003";
        Object localObject = localavpq.a("7720.772003");
        if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).num.get() > 0))
        {
          localObject = new LpReportInfo_pf00064();
          ((LpReportInfo_pf00064)localObject).actionType = 230;
          ((LpReportInfo_pf00064)localObject).subactionType = 2;
          ((LpReportInfo_pf00064)localObject).reserves = 1;
          LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, true);
        }
        QLog.i("ExtendFriendFragment", 2, "redDotTouchClick mIndexOfNuanShuoShuo :" + this.g);
      }
      else
      {
        QLog.e("ExtendFriendFragment", 2, "redDotTouchClick unkown type :" + paramInt + " mIndexOfSqure:" + this.jdField_d_of_type_Int + " mIndexOfMatch:" + this.jdField_e_of_type_Int + " mIndexOfLive:" + this.f + " mIndexOfNuanShuoShuo:" + this.g);
      }
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_b_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_b_of_type_AndroidViewViewGroup);
      this.jdField_b_of_type_AndroidViewViewGroup = null;
    }
  }
  
  private void d(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "loadChatFragment clickPosition: " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment != null) {
        break label130;
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment = new ExtendFriendLimitChatMatchFragment();
      if (this.jdField_a_of_type_AndroidSupportV4AppFragment != this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment.isAdded()) {
          break label140;
        }
        this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).add(2131364709, this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment, "chatFragment").commitAllowingStateLoss();
      }
    }
    for (;;)
    {
      c();
      this.jdField_a_of_type_AndroidSupportV4AppFragment = this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment;
      return;
      label130:
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment.c();
      break;
      label140:
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction().hide(this.jdField_a_of_type_AndroidSupportV4AppFragment).show(this.jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatExtendFriendLimitChatMatchFragment).commitAllowingStateLoss();
    }
  }
  
  private void e()
  {
    xhe.a("kuolie_list_first_open", xhe.a(999L, 0L));
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("kuolie_list_first_open", 4).edit();
    localEditor.putLong("timeStart", System.currentTimeMillis());
    localEditor.apply();
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator == null)) {
      return;
    }
    Object localObject = (avpq)BaseApplicationImpl.getApplication().getRuntime().getManager(36);
    try
    {
      BusinessInfoCheckUpdate.AppInfo localAppInfo;
      if (this.jdField_d_of_type_Int != -1)
      {
        localAppInfo = ((avpq)localObject).a("7720.772001");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.a(this.jdField_a_of_type_ArrayOfInt[this.jdField_d_of_type_Int], localAppInfo);
      }
      QLog.i("ExtendFriendFragment", 2, "updateExtendRedDot mIndexOfSqure :" + this.jdField_d_of_type_Int);
      if (this.f != -1)
      {
        localAppInfo = ((avpq)localObject).a("7720.772002");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.a(this.jdField_a_of_type_ArrayOfInt[this.f], localAppInfo);
      }
      QLog.i("ExtendFriendFragment", 2, "updateExtendRedDot mIndexOfLive :" + this.f);
      if (this.g != -1)
      {
        localObject = ((avpq)localObject).a("7720.772003");
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.a(this.jdField_a_of_type_ArrayOfInt[this.g], (BusinessInfoCheckUpdate.AppInfo)localObject);
        if ((localObject != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject).num.get() > 0))
        {
          localObject = new LpReportInfo_pf00064();
          ((LpReportInfo_pf00064)localObject).actionType = 230;
          ((LpReportInfo_pf00064)localObject).subactionType = 1;
          ((LpReportInfo_pf00064)localObject).reserves = 1;
          LpReportManager.getInstance().reportToPF00064((LpReportInfo_pf00064)localObject, false, true);
        }
      }
      QLog.i("ExtendFriendFragment", 2, "updateExtendRedDot mIndexOfNuanShuoShuo :" + this.g);
      asfj.a(this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendFragment", 2, "updateExtendRedDot  updateRedDot" + localException.toString());
    }
  }
  
  private void g()
  {
    if (this.jdField_e_of_type_Int != -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setCurrentPosition(this.jdField_e_of_type_Int, true);
      return;
    }
    QLog.e("ExtendFriendFragment", 2, "match un init");
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == this.jdField_d_of_type_Int)
    {
      b();
      axqw.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092D2", "0X80092D2", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      c(paramInt);
      return 0;
      if (paramInt == this.jdField_e_of_type_Int)
      {
        if ((paramBoolean) && (this.jdField_a_of_type_Int != paramInt)) {
          axqw.b(null, "dc00898", "", "", "0X800A68C", "0X800A68C", 1, 0, "", "", "", "");
        }
        d(paramInt);
      }
      else if (paramInt == this.f)
      {
        e();
        a(paramInt);
        axqw.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092D3", "0X80092D3", 0, 0, "", "", "", "");
      }
      else if (paramInt == this.g)
      {
        a(paramInt);
      }
      else
      {
        QLog.e("ExtendFriendFragment", 2, "unknown current onTabChanged :" + paramInt + " mIndexOfSqure:" + this.jdField_d_of_type_Int + " mIndexOfMatch:" + this.jdField_e_of_type_Int + " mIndexOfLive:" + this.f + " mIndexOfNuanShuoShuo:" + this.g + " fromUserClick:" + paramBoolean);
      }
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt == this.jdField_d_of_type_Int)
    {
      b();
      return;
    }
    if (paramInt == this.jdField_e_of_type_Int)
    {
      d(paramInt);
      return;
    }
    if (paramInt == this.f)
    {
      a(paramInt);
      return;
    }
    if (paramInt == this.g)
    {
      a(paramInt);
      return;
    }
    QLog.e("ExtendFriendFragment", 2, "unknown current tab :" + paramInt + " mIndexOfSqure:" + this.jdField_d_of_type_Int + " mIndexOfMatch:" + this.jdField_e_of_type_Int + " mIndexOfLive:" + this.f + " mIndexOfNuanShuoShuo:" + this.g);
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
    if ((paramInt1 == 1031) || (paramInt1 == 1) || (paramInt1 == 3) || (paramInt1 == 2)) {
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    while (1000 != paramInt1) {
      return;
    }
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("key_tab_clicked", 0);
      if ((paramInt1 != -1) && ((paramInt1 == this.jdField_d_of_type_Int) || (paramInt1 == this.jdField_e_of_type_Int)))
      {
        this.jdField_a_of_type_Int = paramInt1;
        if (paramInt1 == this.jdField_e_of_type_Int) {
          axqw.b(null, "dc00898", "", "", "0X800A68C", "0X800A68C", 1, 0, "", "", "", "");
        }
      }
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("key_first_position", 0);
      this.jdField_c_of_type_Int = paramIntent.getIntExtra("key_from_top", 0);
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(2130772097, 2130772097);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131377380: 
    case 2131377381: 
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.doOnBackPressed();
        return;
      } while (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null);
      axqw.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X800A696", "0X800A696", 0, 0, "", "", "", "");
      MatchChatMsgListFragment.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0);
      return;
    }
    d();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app != null))
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager();
      this.jdField_a_of_type_Aoep = ((aoep)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(264));
      paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow();
      if (paramBundle != null)
      {
        paramBundle.setFormat(-3);
        paramBundle.setBackgroundDrawable(new ColorDrawable(-1));
      }
    }
    aokk.a().a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ThreadManagerV2.executeOnSubThread(new ExtendFriendFragment.2(this));
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app != null))
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Akfl);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.addObserver(this.jdField_a_of_type_Aoeu);
      axqw.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092F0", "0X80092F0", 0, 0, "", "", "", "");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2131560736, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator = ((SimpleSlidingIndicator)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376281));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377400);
    paramViewGroup = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377380);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378465));
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377381);
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370840);
    if ((paramLayoutInflater != null) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
      localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      paramLayoutInflater.setLayoutParams(localLayoutParams);
    }
    if (paramViewGroup != null) {
      paramViewGroup.setOnClickListener(this);
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new mug());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null) && (this.jdField_b_of_type_AndroidViewView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getActivity(), this.jdField_b_of_type_AndroidViewView).a(53).a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.f(25);
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
      if (paramBundle != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSquareFragment = ((ExtendFriendSquareFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("squareFragment"));
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendGroupFragment = ((ExtendFriendGroupFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentByTag("groupFragment"));
      }
      a();
      if ((!this.jdField_a_of_type_Aoep.e()) || (!bgfp.e())) {
        break label429;
      }
      a(this.g);
    }
    for (;;)
    {
      f();
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app != null))
      {
        paramLayoutInflater = (avpq)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.getManager(36);
        if (paramLayoutInflater.a("7720.772001").iNewFlag.get() == 1)
        {
          paramLayoutInflater.b("7720.772001");
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.postDelayed(new ExtendFriendFragment.3(this), 1500L);
        }
      }
      return this.jdField_a_of_type_AndroidViewViewGroup;
      i = 8;
      break;
      label429:
      b();
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onDestroy");
    }
    int i = (int)((System.currentTimeMillis() - this.jdField_a_of_type_Long) / 1000L);
    if ((this.jdField_a_of_type_Long > 0L) && (i > 0) && (i < 86400))
    {
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app != null)) {
        axqw.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app, "dc00898", "", "", "0X80092EF", "0X80092EF", 0, i, "", "", "", "");
      }
      aokk.a().a(i);
    }
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app != null))
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Akfl);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app.removeObserver(this.jdField_a_of_type_Aoeu);
    }
    super.onDestroy();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    int i = paramIntent.getIntExtra("position", 0);
    if ((i >= 0) && (a(i)))
    {
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setCurrentPosition(i, false);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendFragment", 2, "onNewIntent position:" + i);
      }
      return;
      QLog.e("ExtendFriendFragment", 2, "onNewIntent wrong position:" + i);
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setAccessibilityMsg();
      if ((this.jdField_a_of_type_Int >= 0) && (a(this.jdField_a_of_type_Int))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewSimpleSlidingIndicator.setCurrentPosition(this.jdField_a_of_type_Int, false);
      }
    }
    else
    {
      return;
    }
    QLog.e("ExtendFriendFragment", 2, "onResume wrong clickPosition:" + this.jdField_a_of_type_Int);
  }
  
  public void onStop()
  {
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment
 * JD-Core Version:    0.7.0.1
 */