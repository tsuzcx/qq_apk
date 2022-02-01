package com.tencent.mobileqq.troop.troopCard;

import abke;
import agej;
import ajpz;
import akps;
import aksj;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AndroidRuntimeException;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anzj;
import aoip;
import aojn;
import aojs;
import armu;
import asvi;
import atcx;
import baex;
import bdgb;
import bdlq;
import begp;
import bggy;
import bgkb;
import bgkc;
import bgke;
import bgmi;
import bgmj;
import bgmk;
import bgml;
import bgmm;
import bgmn;
import bgmo;
import bgmp;
import bgmq;
import bgmt;
import bgmu;
import bgmv;
import bgmw;
import bgmx;
import bgmy;
import bgmz;
import bgna;
import bgnh;
import bgpk;
import bguq;
import bhju;
import bhnv;
import bhpc;
import bjbs;
import bjbv;
import bliq;
import blir;
import blji;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPager;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.theme.SkinnableNinePatchDrawable;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.DecimalFormat;
import java.util.List;
import mqq.util.WeakReference;
import nnc;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import yup;
import zps;

public class VisitorTroopCardFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, bgmi
{
  public int a;
  private long jdField_a_of_type_Long;
  protected BroadcastReceiver a;
  private Intent jdField_a_of_type_AndroidContentIntent;
  protected View a;
  public AlphaAnimation a;
  protected Animation.AnimationListener a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  public RelativeLayout a;
  public TextView a;
  protected aojs a;
  private bgke jdField_a_of_type_Bgke;
  private bgna jdField_a_of_type_Bgna;
  public bhpc a;
  protected bjbs a;
  private bjbv jdField_a_of_type_Bjbv;
  public QQAppInterface a;
  public TroopInfo a;
  private AvatarWallViewPager jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager;
  private AvatarWallViewPagerAdapter jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter;
  protected ExpandableTextView a;
  public TroopMoreDetailView a;
  public TroopInfoData a;
  protected QQBlurView a;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  public ImmersiveTitleBar2 a;
  protected String a;
  public boolean a;
  public int b;
  protected View b;
  public AlphaAnimation b;
  protected Button b;
  protected ImageView b;
  protected TextView b;
  protected String b;
  protected boolean b;
  protected int c;
  private View c;
  protected ImageView c;
  protected TextView c;
  protected String c;
  public boolean c;
  protected int d;
  protected TextView d;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int;
  protected TextView e;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 2;
  protected TextView f;
  private boolean jdField_f_of_type_Boolean;
  protected TextView g;
  private boolean g;
  private boolean h;
  
  public VisitorTroopCardFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bgmj(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new bgmw(this);
  }
  
  private void A()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isShowActivityGrade()) {
      i = 0;
    }
    if (i > 0)
    {
      String str = String.format(getResources().getString(2131693055), new Object[] { Integer.valueOf(i) });
      this.jdField_e_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(str);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      if (this.jdField_e_of_type_Boolean) {
        this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void B()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = anzj.a(2131700642);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(str1);
    this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(anzj.a(2131700630) + str1);
    }
  }
  
  private void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramInt == 4)
    {
      a(false);
      if (this.jdField_d_of_type_Int == 2) {
        bgnh.a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      paramInt = getActivity().getIntent().getIntExtra("extra_share_group_from", 0);
      if (paramInt != 0) {
        yup.a("story_grp", "clk_msg", paramInt, 0, new String[0]);
      }
      bhju.a("Grp_set_new", "grpData_visitor", "clk_sendMsg", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
      {
        paramInt = 1;
        bgnh.a(5, new Object[] { Integer.valueOf(paramInt), bguq.a() + "" });
      }
    }
    long l;
    do
    {
      do
      {
        return;
        paramInt = 2;
        break;
        if (paramInt == 3)
        {
          bgnh.a(7, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          paramQQAppInterface = "";
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption() == 40002) {
            paramQQAppInterface = "3_40002";
          }
          for (;;)
          {
            ajpz.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramQQAppInterface);
            bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption() == 40001) {
              paramQQAppInterface = "3_40001";
            }
          }
        }
        if (paramInt == 5)
        {
          bguq.a(paramQQAppInterface, getActivity(), getActivity().getIntent(), this.jdField_a_of_type_Bgna.jdField_a_of_type_Bgpp);
          bgnh.a(8, new Object());
          bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
          return;
        }
      } while (paramInt != 6);
      l = System.currentTimeMillis();
    } while (l - this.jdField_a_of_type_Long <= 1000L);
    this.jdField_a_of_type_Long = l;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
    for (paramInt = 1;; paramInt = 2)
    {
      bgnh.a(10, new Object[] { Integer.valueOf(paramInt), bguq.a() + "" });
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 34) {
        break label445;
      }
      if (!asvi.a(paramQQAppInterface.getCurrentAccountUin())) {
        break label433;
      }
      paramQQAppInterface = atcx.a(getActivity());
      if (getActivity().isFinishing()) {
        break;
      }
      paramQQAppInterface.show();
      bgnh.a(11, new Object());
      return;
    }
    label433:
    bgnh.a(12, new Object());
    label445:
    bguq.a(false, null);
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
    for (Object localObject = "1";; localObject = "0")
    {
      bgnh.a(13, new Object[] { str, localObject });
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 1) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        break label543;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) {
        break;
      }
      a(1);
      return;
    }
    e();
    return;
    label543:
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = (aoip)paramQQAppInterface.a(20);
      if (this.jdField_a_of_type_Aojs == null)
      {
        this.jdField_a_of_type_Aojs = new bgmz(this);
        paramQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
      }
      ((aoip)localObject).b(Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue(), Long.valueOf(paramQQAppInterface.c()).longValue(), this.jdField_b_of_type_JavaLangString);
      return;
    }
    s();
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = bguq.a(paramBundle, getActivity());
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = bguq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, getActivity());
    bguq.jdField_a_of_type_Int = paramBundle.getInt("exposureSource", 99);
    this.jdField_c_of_type_Int = paramBundle.getInt("filter_id", -1);
    this.jdField_d_of_type_Int = paramBundle.getInt("D2GType");
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("fromThirdAppByOpenSDK");
    this.jdField_c_of_type_JavaLangString = getActivity().getIntent().getStringExtra("is_from_game");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("authKey");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("authSig");
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("troop_info_from_troopsetting", false);
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isQidianPrivateTroop;
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    this.jdField_a_of_type_Bgna = new bgna();
    this.jdField_a_of_type_Bgna.a(this);
    paramBundle = getActivity().getIntent().getStringExtra("appid");
    String str1 = getActivity().getIntent().getStringExtra("openid");
    String str2 = getActivity().getIntent().getStringExtra("share_uin");
    this.jdField_a_of_type_Bgna.a(paramBundle, str1, str2);
  }
  
  private void a(AbsListView paramAbsListView)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)
    {
      View localView = paramAbsListView.getChildAt(paramAbsListView.getLastVisiblePosition() - paramAbsListView.getFirstVisiblePosition());
      bool1 = bool2;
      if (paramAbsListView.getHeight() >= localView.getBottom()) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("VisitorTroopCardFragment.Activity", 2, "checkReachListBottomAndLoadMoreRecommList, reachBottom = " + bool1);
    }
    if (bool1) {
      this.jdField_a_of_type_Bgke.f();
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 2;
    Object localObject1 = armu.c();
    if ((paramBoolean2) && (((QVipBigTroopExpiredConfig)localObject1).mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
    {
      paramBoolean1 = aojn.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
      int i;
      if (paramBoolean1)
      {
        i = 15;
        localObject1 = VipUtils.a(0, i);
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label190;
        }
        FragmentActivity localFragmentActivity = getActivity();
        String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (localObject1 == null) {
          break label175;
        }
        localObject1 = ((SpannableString)localObject1).toString();
        label103:
        String str2 = anzj.a(2131714443);
        bgmq localbgmq = new bgmq(this, paramBoolean1);
        if (!paramBoolean1) {
          break label182;
        }
        localObject2 = "0X800A57F";
        label131:
        i = j;
        if (paramBoolean1) {
          i = 1;
        }
        VipUtils.a(localFragmentActivity, str1, (String)localObject1, str2, localbgmq, (String)localObject2, i, paramBoolean1);
      }
      for (;;)
      {
        bgnh.a(1, new Object());
        return;
        i = 8;
        break;
        label175:
        localObject1 = "";
        break label103;
        label182:
        localObject2 = "0X8009E38";
        break label131;
        label190:
        VipUtils.a(getActivity(), paramBoolean1);
      }
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("IS_COVER", paramBoolean1);
    ((Bundle)localObject1).putBoolean("IS_EDIT", paramBoolean2);
    if (!paramBoolean2)
    {
      localObject2 = abke.a(this.jdField_b_of_type_AndroidWidgetImageView);
      if (localObject2 != null) {
        ((Bundle)localObject1).putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject2);
      }
    }
    if (this.jdField_a_of_type_Bgna != null) {
      this.jdField_a_of_type_Bgna.a((Bundle)localObject1, a());
    }
    bgnh.a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (a()) {}
    for (localObject1 = "1";; localObject1 = "0")
    {
      bhju.a("Grp_set_new", "grpData_visitor", "clk_head", 0, 0, new String[] { localObject2, localObject1 });
      return;
    }
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
  }
  
  private void b(boolean paramBoolean)
  {
    int k = 1;
    int i;
    int j;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a().size() > 0))
    {
      i = 1;
      j = k;
      if (!paramBoolean)
      {
        if (i != 0) {
          break label97;
        }
        j = k;
      }
      label41:
      if (j == 0) {
        break label102;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
    }
    for (;;)
    {
      ImmersiveUtils.a(false, getActivity().getWindow());
      if (j != 0) {
        bdgb.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, getActivity().getWindow());
      }
      return;
      i = 0;
      break;
      label97:
      j = 0;
      break label41;
      label102:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    String str2 = " ";
    String str1 = str2;
    if (paramBoolean)
    {
      str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin != null) {
          str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        }
      }
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(str1);
    this.jdField_d_of_type_AndroidWidgetTextView.setClickable(false);
  }
  
  private void f(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (this.jdField_b_of_type_Int == 1))
    {
      e();
      return;
    }
    g(paramString);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      Drawable localDrawable = getResources().getDrawable(2130839410);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131297994));
      ((Animatable)localDrawable).start();
    }
    if (!bhnv.g(getActivity())) {
      QQToast.a(getActivity(), 1, getString(2131693965), 1).b(getActivity().getTitleBarHeight());
    }
    ThreadManager.post(new VisitorTroopCardFragment.2(this), 8, null, false);
    l();
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bgmt(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void g(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption();
      if ((this.jdField_d_of_type_Int == 1) || (this.jdField_d_of_type_Int == 2)) {
        i = 18;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark))
      {
        startActivity(AddFriendLogicActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark, getResources().getString(2131690667), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString));
        return;
      }
      paramString = AddFriendLogicActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, getResources().getString(2131690667), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString);
      paramString.putExtra("from_newer_guide", getActivity().getIntent().getBooleanExtra("from_newer_guide", false));
      paramString.putExtra("from_babyq", getActivity().getIntent().getBooleanExtra("from_babyq", false));
      startActivityForResult(paramString, 1);
      return;
    }
    b(2131718941, 0);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.mContentView.findViewById(2131379037));
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131363774);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.mContentView.findViewById(2131363601));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131364907));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    int i = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
    int k = getResources().getDimensionPixelOffset(2131297021);
    this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(i, 0, j, k);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getActivity());
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    f();
    this.mContentView.setBackgroundResource(2130838778);
    k();
    i();
    q();
    m();
  }
  
  private void h(String paramString)
  {
    getActivity().runOnUiThread(new VisitorTroopCardFragment.17(this, paramString));
  }
  
  @SuppressLint({"NewApi"})
  private void i()
  {
    Object localObject = View.inflate(getActivity(), 2131559869, null);
    this.jdField_c_of_type_AndroidViewView = ((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager = ((AvatarWallViewPager)((View)localObject).findViewById(2131381135));
    o();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    a();
    localObject = View.inflate(getActivity(), 2131560648, null);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373719));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379498));
    n();
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379533));
    j();
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379450));
    A();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367895));
    ((View)localObject).setContentDescription(getResources().getString(2131698491));
    if (bdgb.b()) {
      ((View)localObject).setBackground(null);
    }
    r();
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379490));
    B();
    baex.a(this.jdField_c_of_type_AndroidWidgetTextView, anzj.a(2131714451));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379536));
    c(true);
    localObject = anzj.a(2131691143);
    String str = this.jdField_d_of_type_AndroidWidgetTextView.getText().toString();
    localObject = baex.a(this.jdField_d_of_type_AndroidWidgetTextView, (String)localObject, str);
    if (localObject != null) {
      ((baex)localObject).a(new bgmu(this));
    }
    localObject = bguq.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      localObject = (String)localObject + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView = ((ExpandableTextView)View.inflate(getActivity(), 2131560652, null));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setText(new begp((CharSequence)localObject, 11, 16));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().setMovementMethod(LinkMovementMethod.getInstance());
      int i = agej.a(12.0F, getResources());
      int j = agej.a(15.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setBackgroundResource(2130850427);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setOnExpandStateChangeListener(new bgmv(this));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setPadding(i, j, i, j);
      localObject = View.inflate(getActivity(), 2131561658, null);
      ((View)localObject).setBackgroundResource(2130850683);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView = new TroopMoreDetailView(getActivity());
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setGuestVisitor(true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView);
      return;
    }
  }
  
  private void j()
  {
    int j = 8;
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 1)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
        break label367;
      }
    }
    label367:
    for (int i = 1;; i = 0)
    {
      Object localObject = this.jdField_g_of_type_AndroidWidgetTextView;
      if (i != 0) {
        j = 0;
      }
      ((TextView)localObject).setVisibility(j);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) || (i == 0)) {
        break label372;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131693015, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopNeedPayNumber) }));
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(3));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 0)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2)
      {
        localObject = "（" + getString(2131695622) + "）";
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 3) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 4))
      {
        localObject = "（" + getString(2131695622) + "）";
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        break;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    label372:
    this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131379015);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131378956));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName + " " + getResources().getString(2131690667));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131369088));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690667));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131369042));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131694165) + getString(2131690556));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369056));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131690974));
  }
  
  private void l()
  {
    this.jdField_a_of_type_Int = 30;
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(getActivity(), 17432581);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(getActivity(), 17432581);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
  }
  
  private void m()
  {
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131363692));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131377526));
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {}
    for (int i = 1; this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember; i = 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131692983);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(4));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    if (i != 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131693015, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopNeedPayNumber) }));
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(3));
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    if ("true".equals(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693163);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(5));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
      return;
    }
    if (this.jdField_d_of_type_Int == 2) {
      bgnh.a(18, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131693162);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(6));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
    bguq.a(true, this.jdField_a_of_type_AndroidWidgetButton);
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFlagExt4(3)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFreezeReason(2)))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter = new AvatarWallViewPagerAdapter(new WeakReference(getActivity()), this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager, getResources().getDisplayMetrics().widthPixels, zps.a(getActivity(), 212.0F), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, null, "Grp_Admin_data");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnPageChangeListener(new bgmx(this));
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorTroopCardFragment.Activity", 2, String.format("updateTitle mStatusBarShow=%b", new Object[] { Boolean.valueOf(this.jdField_d_of_type_Boolean) }));
    }
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.jdField_d_of_type_Boolean) || (bool)) {}
    for (int i = 2131166987;; i = 2131166690)
    {
      int k = getResources().getColor(i);
      int j = 2130843670;
      i = j;
      if (this.jdField_d_of_type_Boolean)
      {
        i = j;
        if (!bool) {
          i = 2130840291;
        }
      }
      Drawable localDrawable = getResources().getDrawable(2130850668);
      localDrawable.setColorFilter(k, PorterDuff.Mode.SRC_ATOP);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(k);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(k);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(k);
      b(this.jdField_d_of_type_Boolean);
      return;
    }
  }
  
  @TargetApi(19)
  private void q()
  {
    if (!ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_a_of_type_ComTencentWidgetXListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new bgmy(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    try
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(((SkinnableNinePatchDrawable)getResources().getDrawable(2130850350)).getBitmap());
      localBitmapDrawable.setAlpha(220);
      this.jdField_b_of_type_AndroidViewView.setBackground(localBitmapDrawable);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      localClassCastException.printStackTrace();
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Bgna == null) {}
    do
    {
      return;
      Drawable localDrawable = this.jdField_a_of_type_Bgna.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    } while ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void s()
  {
    bguq.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, bguq.jdField_a_of_type_Int, this.jdField_c_of_type_Int, 2);
    if (!bhnv.d(getActivity())) {
      bguq.a(getActivity(), getActivity().getTitleBarHeight(), 2131693963, 1);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bgna != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VisitorTroopCardFragment.Activity", 2, "mVisitorPresenter is null");
    return;
    this.jdField_a_of_type_Bgna.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 8390784);
    if (super.getActivity().getIntent().getBooleanExtra("from_babyq", false)) {
      bgnh.a(14, new Object());
    }
    bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
  }
  
  private void t()
  {
    blir localblir = (blir)blji.a(getActivity(), null);
    localblir.a(new bliq(anzj.a(2131700641), 7, 0), 5);
    localblir.a(new bliq(anzj.a(2131700647), 8, 0), 5);
    localblir.c(2131690580);
    localblir.a(new bgmk(this, localblir));
    if (!localblir.isShowing()) {
      localblir.show();
    }
  }
  
  private void u()
  {
    blir localblir = (blir)blji.a(getActivity(), null);
    if (!a()) {
      localblir.a(new bliq(getString(2131695541), 9, 0), 5);
    }
    localblir.a(new bliq(blji.a(getActivity(), 2131717453), 10, 0), 5);
    localblir.c(2131690580);
    localblir.a(new bgml(this, localblir));
    if (!localblir.isShowing()) {
      localblir.show();
    }
  }
  
  private void v()
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject == null)
    {
      localObject = null;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label106;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L) && ((this.jdField_a_of_type_Bgna == null) || (this.jdField_a_of_type_Bgna.jdField_a_of_type_Int == 0))) {
        break label99;
      }
      x();
    }
    for (;;)
    {
      bgnh.a(21, new Object());
      return;
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      break;
      label99:
      w();
      continue;
      label106:
      localObject = blir.a(getActivity());
      ((blir)localObject).a(2131690924);
      ((blir)localObject).a(2131691895, 3);
      ((blir)localObject).a(new bgmm(this, (blir)localObject));
      ((blir)localObject).d(getString(2131690580));
      ((blir)localObject).show();
    }
  }
  
  private void w()
  {
    String str = getString(2131690918);
    blir localblir = blir.a(getActivity());
    localblir.a(str);
    localblir.a(getString(2131690917), 3);
    localblir.d(getString(2131690580));
    localblir.a(new bgmn(this, localblir));
    localblir.show();
  }
  
  private void x()
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131755824);
    localReportDialog.setContentView(2131561147);
    ((TextView)localReportDialog.findViewById(2131365556)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365544);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365542);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365548);
    String str = anzj.a(2131700644);
    localTextView1.setText(getString(2131690919, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694098);
    localTextView3.setText(2131690580);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new bgmo(this, localReportDialog));
    localTextView3.setOnClickListener(new bgmp(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void y()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) && (getActivity().getIntent().getBooleanExtra("from_newer_guide", false)))
    {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    Intent localIntent2 = this.jdField_a_of_type_AndroidContentIntent;
    Intent localIntent1 = localIntent2;
    if (this.jdField_g_of_type_Boolean)
    {
      localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      localIntent1.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
      this.jdField_g_of_type_Boolean = false;
    }
    getActivity().setResult(-1, localIntent1);
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView == null) {
      return;
    }
    String str2 = bguq.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
    String str1 = str2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      str1 = str2 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setText(new begp(str1, 11, 16));
  }
  
  public void a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a();
    if (QLog.isColorLevel()) {
      QLog.i("VisitorTroopCardFragment.Activity", 2, "updateTroopAvatarWall size=" + localList.size());
    }
    LinearLayout.LayoutParams localLayoutParams;
    int k;
    int j;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      k = getResources().getDisplayMetrics().widthPixels;
      if (localList.size() <= 0) {
        break label155;
      }
      j = 1;
      if (localList.size() <= 0) {
        break label160;
      }
      i = aksj.a(k);
    }
    for (;;)
    {
      label105:
      localLayoutParams.width = k;
      localLayoutParams.height = i;
      this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      if (j != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setVisibility(0);
        if (this.jdField_d_of_type_Boolean) {
          this.jdField_d_of_type_Boolean = false;
        }
      }
      for (;;)
      {
        p();
        return;
        label155:
        j = 0;
        break;
        label160:
        if (this.jdField_a_of_type_AndroidViewView == null) {
          break label211;
        }
        this.jdField_a_of_type_AndroidViewView.measure(0, 0);
        i = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
        break label105;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setVisibility(8);
        if (!this.jdField_d_of_type_Boolean) {
          this.jdField_d_of_type_Boolean = true;
        }
      }
      label211:
      i = 0;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    bgpk.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "join");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((1 == paramInt1) && ((getActivity().isResume()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))))
    {
      d();
      bguq.a(getActivity(), paramInt2);
    }
    while ((!getActivity().isResume()) || ((paramInt1 != 2) && (paramInt1 != 9))) {
      return;
    }
    if (this.jdField_a_of_type_Bjbv == null) {
      this.jdField_a_of_type_Bjbv = new bjbv(getActivity());
    }
    this.jdField_a_of_type_Bjbv.b(2, 2131691899, 1500);
    getActivity().finish();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    if ((1 == paramInt1) && ((getActivity().isResume()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))))
    {
      d();
      if (this.jdField_a_of_type_Bjbv == null) {
        this.jdField_a_of_type_Bjbv = new bjbv(getActivity());
      }
      switch (paramInt2)
      {
      case -1: 
      default: 
        this.jdField_a_of_type_Bjbv.b(2, 2131693156, 1500);
      }
    }
    label361:
    do
    {
      for (;;)
      {
        return;
        ((aoip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(Long.parseLong(paramString), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
        return;
        this.jdField_a_of_type_Bjbv.b(2, 2131693157, 1500);
        getActivity().finish();
        a(true);
        TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (localTroopManager != null)
        {
          Object localObject2 = localTroopManager.b(paramString);
          Object localObject1 = localObject2;
          if (localObject2 == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("VisitorTroopCardFragment.Activity", 2, "troopInfo is null 1，troopUin : " + paramString);
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("troopInfo is null 2 ? : ");
            if (localObject1 != null) {
              break label361;
            }
          }
          for (;;)
          {
            QLog.d("VisitorTroopCardFragment.Activity", 2, bool + " : " + paramString);
            if (localObject1 != null) {
              break label401;
            }
            if (QLog.isColorLevel()) {
              QLog.d("VisitorTroopCardFragment.Activity", 2, "troopInfo is null 3, troopUin : " + paramString);
            }
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {
              break;
            }
            localTroopManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, NetConnInfoCenter.getServerTime());
            return;
            bool = false;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("VisitorTroopCardFragment.Activity", 2, "troopInfo is null 4, mTroopInfoData is null troopUin : " + paramString);
            return;
            localTroopManager.e((TroopInfo)localObject1);
            return;
            this.jdField_a_of_type_Bjbv.b(2, 2131718941, 1500);
            return;
            if (getActivity().isResume())
            {
              if (paramInt1 != 3) {
                break;
              }
              if (paramInt2 == 0)
              {
                paramString = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                if (paramString == null) {}
                for (paramString = null;; paramString = paramString.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
                {
                  if ((paramString == null) || (paramString.wMemberNum == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum)) {
                    break label572;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopAdmMemberNum(paramString.Administrator, paramString.wMemberNum, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), getResources());
                  if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView == null) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.a(anzj.a(2131700665) + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + anzj.a(2131700667));
                  return;
                }
              }
            }
          }
        }
      }
    } while (((paramInt1 != 2) && (paramInt1 != 9)) || (paramInt2 != 0));
    label401:
    label572:
    paramString = new Intent();
    paramString.putExtra("isNeedFinish", true);
    getActivity().setResult(-1, paramString);
    getActivity().finish();
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    String str2 = bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    if (paramInt == -1) {}
    for (Object localObject = "0";; localObject = "1")
    {
      bhju.a("Grp_share", "grpData_admin", "share_qq", 0, 0, new String[] { str1, str2, localObject });
      if (paramInt == -1) {
        break;
      }
      return;
    }
    localObject = agej.a(new Intent(getActivity(), SplashActivity.class), null);
    ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
    paramIntent = ForwardUtils.a((Intent)localObject);
    ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), paramIntent, (Intent)localObject);
  }
  
  public void a(long paramLong, List<oidb_0x899.memberlist> paramList)
  {
    if ((this.jdField_f_of_type_Boolean) || (!TextUtils.equals(this.jdField_d_of_type_JavaLangString, String.valueOf(paramLong)))) {}
    while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.a(paramList);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QQToast.a(getActivity(), getString(2131695422), 1).b(getActivity().getTitleBarHeight());
  }
  
  public void a(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    boolean bool = true;
    int i;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.coverFrom(paramGroupInfo);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName)) {
        B();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        r();
      }
      if (QLog.isColorLevel())
      {
        i = paramGroupInfo.uint32_group_flagext3.get();
        StringBuilder localStringBuilder = new StringBuilder().append("ChatSettingForToop_handle88dResp, troopUin=");
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
          break label378;
        }
        str = "";
        QLog.d(".troop.qidian_private_troop", 2, str + ", flagExt3=" + i + ", isQidianPrivateTroop=" + TroopInfo.isQidianPrivateTroop(i));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.coverFrom(paramGroupInfo);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
        if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isNewTroop) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.newTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
        }
        this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.oldTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.getTroopName();
      }
      this.jdField_e_of_type_Boolean = TroopInfo.isQidianPrivateTroop(paramGroupInfo.uint32_group_flagext3.get());
      if (this.jdField_e_of_type_Boolean)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label390;
        }
        i = 1;
        label230:
        new bdlq(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_private").c("Grp_data").d("exp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(i) }).a();
      }
      j();
      if ((this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
        break label425;
      }
    }
    for (;;)
    {
      c(bool);
      z();
      A();
      n();
      a();
      bguq.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setTroopInfoData(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.a();
      }
      return;
      label378:
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      break;
      label390:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin)
      {
        i = 2;
        break label230;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
      {
        i = 3;
        break label230;
      }
      i = 4;
      break label230;
      label425:
      bool = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 3)
    {
      localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      getActivity().setResult(-1, localIntent);
      getActivity().finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa == 30) {}
    for (Intent localIntent = new Intent(getActivity(), ChatActivity.class);; localIntent = new Intent(getActivity(), SplashActivity.class))
    {
      agej.a(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName);
      if ((paramBoolean) && (this.jdField_b_of_type_Boolean))
      {
        localIntent.putExtra("fromThirdAppByOpenSDK", true);
        if ((getActivity().getIntent() != null) && (getActivity().getIntent().getExtras() != null))
        {
          localIntent.putExtra("appid", getActivity().getIntent().getExtras().getString("appid"));
          localIntent.putExtra("pkg_name", getActivity().getIntent().getExtras().getString("pkg_name"));
          localIntent.putExtra("app_name", getActivity().getIntent().getExtras().getString("app_name"));
          localIntent.putExtra("action", getActivity().getIntent().getExtras().getInt("pkg_name"));
        }
      }
      startActivity(localIntent);
      return;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, TroopInfo paramTroopInfo)
  {
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    do
    {
      do
      {
        return;
      } while (paramLong != Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin));
      if (!paramBoolean) {
        break;
      }
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        if (QLog.isColorLevel()) {
          QLog.d("VisitorTroopCardFragment.Activity", 2, "troop.isOnlyTroopMemberInviteOption() true");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.cGroupOption = 2;
          this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.setOnlyTroopMemberInviteOption(false);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 2;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOnlyTroopMemberInvite = false;
      }
    } while (!getActivity().isResume());
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3))
    {
      a(2);
      return;
    }
    f(null);
    return;
    b(2131717877, 1);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VisitorTroopCardFragment.Activity", 2, "onJoinTroopSecurityTips troopUin:" + paramString + ",tId = " + paramInt + ",time = " + paramLong);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) || (paramBoolean)) {}
    while ((!getActivity().isResume()) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 1) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    bggy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramLong, getActivity());
  }
  
  public void a(boolean paramBoolean, List<akps> paramList)
  {
    if (paramBoolean) {
      r();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a(paramList))) {
      return;
    }
    r();
    a();
  }
  
  public void b()
  {
    getActivity().runOnUiThread(new VisitorTroopCardFragment.18(this));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    bguq.a(getActivity(), getActivity().getTitleBarHeight(), paramInt1, paramInt2);
  }
  
  public void b(String paramString)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
      r();
    }
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_Bjbs == null)
      {
        this.jdField_a_of_type_Bjbs = new bjbs(getActivity(), getActivity().getTitleBarHeight());
        this.jdField_a_of_type_Bjbs.c(2131694176);
        this.jdField_a_of_type_Bjbs.c(false);
      }
      this.jdField_a_of_type_Bjbs.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("VisitorTroopCardFragment.Activity", 2, localException.toString());
    }
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(paramString);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setTroopInfoData(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.b();
    }
  }
  
  public void d()
  {
    try
    {
      if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing())) {
        this.jdField_a_of_type_Bjbs.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("VisitorTroopCardFragment.Activity", 2, localException.toString());
    }
  }
  
  public void d(String paramString)
  {
    h(paramString);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity() == null) || (getActivity().app == null)) {
      return;
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.titleRoot.setFitsSystemWindows(false);
      this.titleRoot.setPadding(0, 0, 0, 0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    hideTitleBar();
    ImmersiveUtils.a(true, getActivity().getWindow());
    a(getActivity().getIntent().getExtras());
    h();
    bguq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
    for (paramLayoutInflater = "0";; paramLayoutInflater = "1")
    {
      bgnh.a(17, new Object[] { paramViewGroup, paramLayoutInflater });
      bhju.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
      nnc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 65);
      paramLayoutInflater = new IntentFilter();
      paramLayoutInflater.addAction("start_recomend_page");
      paramLayoutInflater.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramLayoutInflater);
      return;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bgna != null)
    {
      c();
      this.jdField_a_of_type_Bgna.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void e(String paramString)
  {
    if (!getActivity().isResume()) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      QQToast.a(getActivity(), 2, 2131717457, 1).b(getActivity().getTitleBarHeight());
    }
    for (;;)
    {
      getActivity().finish();
      return;
      paramString = paramString + "?_wv=1031&troopUin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&isVerify=" + 0;
      Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("hide_left_button", true);
      localIntent.putExtra("show_right_close_button", true);
      localIntent.putExtra("finish_animation_up_down", true);
      startActivity(localIntent);
      getActivity().overridePendingTransition(2130771997, 2130771990);
    }
  }
  
  void f()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    Object localObject1;
    boolean bool1;
    label66:
    label81:
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
    {
      localObject1 = "1";
      bgnh.a(15, new Object[] { localObject2, localObject1 });
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember;
      localObject1 = bgkb.a();
      if ((bool2) && (!((bgkc)localObject1).jdField_a_of_type_Boolean)) {
        break label342;
      }
      bool1 = true;
      if (TextUtils.isEmpty(((bgkc)localObject1).jdField_a_of_type_JavaLangString)) {
        break label347;
      }
      localObject1 = ((bgkc)localObject1).jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "checkAndInitRecommendList,hasJoinedTroop = " + bool2 + ",displayOrNot = " + bool1 + ",recoomTips = " + (String)localObject1);
      }
      if (this.jdField_a_of_type_Bgke == null)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
          break label354;
        }
      }
    }
    label342:
    label347:
    label354:
    for (localObject2 = "1";; localObject2 = "2")
    {
      bgnh.a(16, new Object[] { str, localObject2 });
      localObject2 = new TextView(getActivity());
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextColor(getResources().getColor(2131166962));
      ((TextView)localObject2).setTextSize(2, 16.0F);
      ((TextView)localObject2).setPadding(agej.a(16.0F, getResources()), agej.a(13.0F, getResources()), 0, agej.a(5.0F, getResources()));
      ((TextView)localObject2).setClickable(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      localObject1 = View.inflate(getActivity(), 2131561658, null);
      ((View)localObject1).setBackgroundResource(2130850683);
      this.jdField_a_of_type_Bgke = new bgke(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentWidgetXListView, null, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bool1, (TextView)localObject2, (View)localObject1);
      return;
      localObject1 = "2";
      break;
      bool1 = false;
      break label66;
      localObject1 = "相关推荐";
      break label81;
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131563100;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    try
    {
      paramActivity.requestWindowFeature(1);
      return;
    }
    catch (AndroidRuntimeException paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
    case 260: 
    case 258: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          return;
          r();
          return;
          a();
        } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("has_operation", false)));
        this.jdField_a_of_type_AndroidContentIntent = paramIntent;
        return;
      } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("select_member_add_request_ok", false)));
      this.jdField_g_of_type_Boolean = true;
      return;
    }
    a(paramInt2, paramIntent);
  }
  
  public boolean onBackEvent()
  {
    y();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (zps.b()) {}
    Object localObject1;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject2;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363692: 
        a(((Integer)paramView.getTag()).intValue(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
      case 2131379360: 
        localObject1 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_d_of_type_JavaLangString });
        localObject2 = new Intent(getActivity(), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        super.startActivity((Intent)localObject2);
        break;
      case 2131367895: 
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
          a(false, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        }
        for (;;)
        {
          bgnh.a(3, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner), Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) });
          break;
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (this.jdField_a_of_type_Bgna != null)) {
            this.jdField_a_of_type_Bgna.d();
          }
        }
      case 2131369042: 
        y();
        getActivity().finish();
        break;
      case 2131369056: 
        u();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (a()) {}
        for (localObject1 = "1";; localObject1 = "0")
        {
          bhju.a("Grp_set_new", "grpData_visitor", "clk_upright", 0, 0, new String[] { localObject2, localObject1 });
          break;
        }
      case 2131381135: 
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
          t();
        } else {
          a(true, false);
        }
        break;
      }
    }
    bguq.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
    for (i = 1;; i = 2)
    {
      bgnh.a(19, new Object[] { Integer.valueOf(i), bguq.a() + "" });
      break;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum > this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum) {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {}
    for (;;)
    {
      localObject1 = new Intent(getActivity(), PublicAccountBrowser.class);
      ((Intent)localObject1).putExtra("hide_operation_bar", true);
      ((Intent)localObject1).putExtra("hideRightButton", true);
      ((Intent)localObject1).putExtra("isScreenOrientationPortrait", true);
      ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("url", "https://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&role=1&group_level=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade + "&group_mem_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "&group_active_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum + "&show_level=" + i);
      startActivity((Intent)localObject1);
      bgnh.a(20, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      nnc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 72);
      break;
      i = 1;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
    }
    super.onDestroy();
    try
    {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_Aojs != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      }
      this.jdField_f_of_type_Boolean = true;
      if (this.jdField_a_of_type_Bgna != null)
      {
        this.jdField_a_of_type_Bgna.a();
        this.jdField_a_of_type_Bgna = null;
      }
      if (this.jdField_a_of_type_Bgke != null) {
        this.jdField_a_of_type_Bgke.c();
      }
      this.jdField_a_of_type_Bhpc = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VisitorTroopCardFragment.Activity", 2, "doOnDestroy unregisterReceiver, e:" + localException.getMessage());
        }
      }
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("key_clip_info");
    if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_Bgna != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VisitorTroopCardFragment.Activity", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.jdField_a_of_type_Bgna.a(str, paramIntent);
    }
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
    }
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
  }
  
  public void onResume()
  {
    int i;
    String str2;
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512)))
    {
      i = 1;
      if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (i != 0)) {
        this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      }
      super.onResume();
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
          break label147;
        }
      }
    }
    label147:
    for (String str1 = "1";; str1 = "0")
    {
      bhju.a("Grp_set_new", "grpData_visitor", "exp", 0, 0, new String[] { str2, str1 });
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      p();
      return;
      i = 0;
      break;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Bgna != null)
    {
      this.jdField_a_of_type_Bgna.a(null, false);
      this.jdField_a_of_type_Bgna.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.b();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.c();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.h))
    {
      this.h = true;
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment
 * JD-Core Version:    0.7.0.1
 */