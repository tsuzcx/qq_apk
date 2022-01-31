package com.tencent.mobileqq.troop.troopCard;

import aepi;
import ahpp;
import ainn;
import aiqe;
import alud;
import amdu;
import amel;
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
import aouu;
import aqbg;
import aqhx;
import awrq;
import azmk;
import azqx;
import bamp;
import bamz;
import bcid;
import bcie;
import bcig;
import bciu;
import bciv;
import bciw;
import bcix;
import bciy;
import bciz;
import bcja;
import bcjb;
import bcje;
import bcjf;
import bcjg;
import bcjh;
import bcji;
import bcjj;
import bcjk;
import bcjl;
import bcjs;
import bckt;
import bcpx;
import bdes;
import bdin;
import bdjz;
import bety;
import beub;
import bhue;
import bhuf;
import bhus;
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
import com.tencent.theme.SkinnableNinePatchDrawable;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.DecimalFormat;
import java.util.List;
import mqq.util.WeakReference;
import nco;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import wxj;
import xsm;
import zjc;

public class VisitorTroopCardFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, bciu
{
  public int a;
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
  private bcig jdField_a_of_type_Bcig;
  private bcjl jdField_a_of_type_Bcjl;
  public bdjz a;
  protected bety a;
  private beub jdField_a_of_type_Beub;
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
  protected int b;
  protected View b;
  public AlphaAnimation b;
  protected Button b;
  protected ImageView b;
  protected TextView b;
  protected String b;
  protected boolean b;
  protected int c;
  protected View c;
  protected ImageView c;
  protected TextView c;
  protected String c;
  public boolean c;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  protected TextView d;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = 2;
  protected TextView e;
  private boolean jdField_e_of_type_Boolean;
  protected TextView f;
  private boolean f;
  protected TextView g;
  private boolean g;
  private boolean h;
  
  public VisitorTroopCardFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bciv(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new bcjh(this);
  }
  
  private void A()
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = alud.a(2131702115);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(str1);
    this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131702103) + str1);
    }
  }
  
  private void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramInt == 4)
    {
      a(false);
      if (this.jdField_c_of_type_Int == 2) {
        bcjs.a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      paramInt = getActivity().getIntent().getIntExtra("extra_share_group_from", 0);
      if (paramInt != 0) {
        wxj.a("story_grp", "clk_msg", paramInt, 0, new String[0]);
      }
      bdes.a("Grp_set_new", "grpData_visitor", "clk_sendMsg", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
      {
        paramInt = 1;
        bcjs.a(5, new Object[] { Integer.valueOf(paramInt), bcpx.a() + "" });
      }
    }
    do
    {
      return;
      paramInt = 2;
      break;
      if (paramInt == 3)
      {
        bcjs.a(7, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        ahpp.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
        bdes.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
        return;
      }
      if (paramInt == 5)
      {
        bcpx.a(paramQQAppInterface, getActivity(), getActivity().getIntent(), this.jdField_a_of_type_Bcjl.jdField_a_of_type_Bckx);
        bcjs.a(8, new Object());
        bdes.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
        return;
      }
    } while (paramInt != 6);
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
    for (paramInt = 1;; paramInt = 2)
    {
      bcjs.a(10, new Object[] { Integer.valueOf(paramInt), bcpx.a() + "" });
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 34) {
        break label384;
      }
      if (!aqbg.a(paramQQAppInterface.getCurrentAccountUin())) {
        break label372;
      }
      paramQQAppInterface = aqhx.a(getActivity());
      if (getActivity().isFinishing()) {
        break;
      }
      paramQQAppInterface.show();
      bcjs.a(11, new Object());
      return;
    }
    label372:
    bcjs.a(12, new Object());
    label384:
    bcpx.a(false, null);
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
    for (paramQQAppInterface = "1";; paramQQAppInterface = "0")
    {
      bcjs.a(13, new Object[] { str, paramQQAppInterface });
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 1) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        break label477;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) {
        break;
      }
      a(1);
      return;
    }
    e();
    return;
    label477:
    bcpx.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, bcpx.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 2);
    if (!bdin.d(getActivity()))
    {
      bcpx.a(getActivity(), getActivity().getTitleBarHeight(), 2131694766, 1);
      return;
    }
    this.jdField_a_of_type_Bcjl.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 8390784);
    if (super.getActivity().getIntent().getBooleanExtra("from_babyq", false)) {
      bcjs.a(14, new Object());
    }
    bdes.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = bcpx.a(paramBundle, getActivity());
    this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = bcpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, getActivity());
    bcpx.jdField_a_of_type_Int = paramBundle.getInt("exposureSource", 99);
    this.jdField_b_of_type_Int = paramBundle.getInt("filter_id", -1);
    this.jdField_c_of_type_Int = paramBundle.getInt("D2GType");
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("fromThirdAppByOpenSDK");
    this.jdField_c_of_type_JavaLangString = getActivity().getIntent().getStringExtra("is_from_game");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("authKey");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("authSig");
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("troop_info_from_troopsetting", false);
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isQidianPrivateTroop;
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    this.jdField_a_of_type_Bcjl = new bcjl();
    this.jdField_a_of_type_Bcjl.a(this);
    paramBundle = getActivity().getIntent().getStringExtra("appid");
    String str1 = getActivity().getIntent().getStringExtra("openid");
    String str2 = getActivity().getIntent().getStringExtra("share_uin");
    this.jdField_a_of_type_Bcjl.a(paramBundle, str1, str2);
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
      this.jdField_a_of_type_Bcig.d();
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 2;
    Object localObject1 = aouu.c();
    if ((paramBoolean2) && (((QVipBigTroopExpiredConfig)localObject1).mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
    {
      paramBoolean1 = amel.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
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
        String str2 = alud.a(2131716053);
        bcjb localbcjb = new bcjb(this, paramBoolean1);
        if (!paramBoolean1) {
          break label182;
        }
        localObject2 = "0X800A57F";
        label131:
        i = j;
        if (paramBoolean1) {
          i = 1;
        }
        VipUtils.a(localFragmentActivity, str1, (String)localObject1, str2, localbcjb, (String)localObject2, i, paramBoolean1);
      }
      for (;;)
      {
        bcjs.a(1, new Object());
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
      localObject2 = zjc.a(this.jdField_b_of_type_AndroidWidgetImageView);
      if (localObject2 != null) {
        ((Bundle)localObject1).putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject2);
      }
    }
    if (this.jdField_a_of_type_Bcjl != null) {
      this.jdField_a_of_type_Bcjl.a((Bundle)localObject1, a());
    }
    bcjs.a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (a()) {}
    for (localObject1 = "1";; localObject1 = "0")
    {
      bdes.a("Grp_set_new", "grpData_visitor", "clk_head", 0, 0, new String[] { localObject2, localObject1 });
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
        azmk.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, getActivity().getWindow());
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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)
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
      Drawable localDrawable = getResources().getDrawable(2130839225);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131297901));
      ((Animatable)localDrawable).start();
    }
    if (!bdin.g(getActivity())) {
      QQToast.a(getActivity(), 1, getString(2131694768), 1).b(getActivity().getTitleBarHeight());
    }
    ThreadManager.post(new VisitorTroopCardFragment.2(this), 8, null, false);
    l();
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bcje(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void g(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption();
      if ((this.jdField_c_of_type_Int == 1) || (this.jdField_c_of_type_Int == 2)) {
        i = 18;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark))
      {
        startActivity(AddFriendLogicActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark, getResources().getString(2131690795), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString));
        return;
      }
      paramString = AddFriendLogicActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, getResources().getString(2131690795), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString);
      paramString.putExtra("from_newer_guide", getActivity().getIntent().getBooleanExtra("from_newer_guide", false));
      paramString.putExtra("from_babyq", getActivity().getIntent().getBooleanExtra("from_babyq", false));
      startActivityForResult(paramString, 1);
      return;
    }
    b(2131721057, 0);
  }
  
  private void h()
  {
    View localView = View.inflate(getActivity(), 2131562828, null);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)localView.findViewById(2131378030));
    this.jdField_c_of_type_AndroidViewView = localView.findViewById(2131363552);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)localView.findViewById(2131363384));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131364645));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    int i = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
    int k = getResources().getDimensionPixelOffset(2131296956);
    this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(i, 0, j, k);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getActivity());
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    f();
    getActivity().setContentView(localView);
    this.jdField_b_of_type_AndroidViewView = localView;
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838592);
    k();
    i();
    q();
    m();
  }
  
  private void h(String paramString)
  {
    getActivity().runOnUiThread(new VisitorTroopCardFragment.16(this, paramString));
  }
  
  @SuppressLint({"NewApi"})
  private void i()
  {
    Object localObject = View.inflate(getActivity(), 2131559723, null);
    this.jdField_d_of_type_AndroidViewView = ((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager = ((AvatarWallViewPager)((View)localObject).findViewById(2131379995));
    o();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    a();
    localObject = View.inflate(getActivity(), 2131560478, null);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131372975));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131378476));
    n();
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131378512));
    j();
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131378433));
    z();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367516));
    ((View)localObject).setContentDescription(getResources().getString(2131699965));
    if (azmk.b()) {
      ((View)localObject).setBackground(null);
    }
    r();
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131378468));
    A();
    awrq.a(this.jdField_c_of_type_AndroidWidgetTextView, alud.a(2131716061));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131378515));
    c(true);
    awrq.a(this.jdField_d_of_type_AndroidWidgetTextView, this.jdField_d_of_type_AndroidWidgetTextView.getText().toString(), alud.a(2131691364), new bcjf(this));
    localObject = bcpx.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      localObject = (String)localObject + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView = ((ExpandableTextView)View.inflate(getActivity(), 2131560483, null));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setText(new bamp((CharSequence)localObject, 11, 16));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().setEditableFactory(bamz.a);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().setMovementMethod(LinkMovementMethod.getInstance());
      int i = aepi.a(12.0F, getResources());
      int j = aepi.a(15.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setBackgroundResource(2130849827);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setOnExpandStateChangeListener(new bcjg(this));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setPadding(i, j, i, j);
      localObject = View.inflate(getActivity(), 2131561382, null);
      ((View)localObject).setBackgroundResource(2130850075);
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
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131693598, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopNeedPayNumber) }));
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
        localObject = "（" + getString(2131696754) + "）";
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 3) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 4))
      {
        localObject = "（" + getString(2131696754) + "）";
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
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131378011);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131377957));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName + " " + getResources().getString(2131690795));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368670));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690795));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368624));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131695072) + getString(2131690617));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368638));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131691171));
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
    this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131363471));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131376589));
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {}
    for (int i = 1; this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember; i = 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693528);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(4));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    if (i != 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131693598, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopNeedPayNumber) }));
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(3));
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    if ("true".equals(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693812);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(5));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
      return;
    }
    if (this.jdField_c_of_type_Int == 2) {
      bcjs.a(18, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131693811);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(6));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
    bcpx.a(true, this.jdField_a_of_type_AndroidWidgetButton);
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
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter = new AvatarWallViewPagerAdapter(new WeakReference(getActivity()), this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager, getResources().getDisplayMetrics().widthPixels, xsm.a(getActivity(), 212.0F), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, null, "Grp_Admin_data");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnPageChangeListener(new bcji(this));
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorTroopCardFragment.Activity", 2, String.format("updateTitle mStatusBarShow=%b", new Object[] { Boolean.valueOf(this.jdField_d_of_type_Boolean) }));
    }
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.jdField_d_of_type_Boolean) || (bool)) {}
    for (int i = 2131166900;; i = 2131166606)
    {
      int k = getResources().getColor(i);
      int j = 2130843291;
      i = j;
      if (this.jdField_d_of_type_Boolean)
      {
        i = j;
        if (!bool) {
          i = 2130840102;
        }
      }
      Drawable localDrawable = getResources().getDrawable(2130850060);
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new bcjj(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    try
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(((SkinnableNinePatchDrawable)getResources().getDrawable(2130849752)).getBitmap());
      localBitmapDrawable.setAlpha(220);
      this.jdField_c_of_type_AndroidViewView.setBackground(localBitmapDrawable);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      localClassCastException.printStackTrace();
    }
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Bcjl == null) {}
    do
    {
      return;
      Drawable localDrawable = this.jdField_a_of_type_Bcjl.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    } while ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void s()
  {
    bhuf localbhuf = (bhuf)bhus.a(getActivity(), null);
    localbhuf.a(new bhue(alud.a(2131702114), 7, 0), 5);
    localbhuf.a(new bhue(alud.a(2131702120), 8, 0), 5);
    localbhuf.c(2131690648);
    localbhuf.a(new bcjk(this, localbhuf));
    if (!localbhuf.isShowing()) {
      localbhuf.show();
    }
  }
  
  private void t()
  {
    bhuf localbhuf = (bhuf)bhus.a(getActivity(), null);
    if (!a()) {
      localbhuf.a(new bhue(getString(2131696673), 9, 0), 5);
    }
    localbhuf.a(new bhue(bhus.a(getActivity(), 2131719229), 10, 0), 5);
    localbhuf.c(2131690648);
    localbhuf.a(new bciw(this, localbhuf));
    if (!localbhuf.isShowing()) {
      localbhuf.show();
    }
  }
  
  private void u()
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject == null)
    {
      localObject = null;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo = ((TroopInfo)localObject);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label106;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L) && ((this.jdField_a_of_type_Bcjl == null) || (this.jdField_a_of_type_Bcjl.jdField_a_of_type_Int == 0))) {
        break label99;
      }
      w();
    }
    for (;;)
    {
      bcjs.a(21, new Object());
      return;
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      break;
      label99:
      v();
      continue;
      label106:
      localObject = bhuf.a(getActivity());
      ((bhuf)localObject).a(2131691104);
      ((bhuf)localObject).a(2131692278, 3);
      ((bhuf)localObject).a(new bcix(this, (bhuf)localObject));
      ((bhuf)localObject).d(getString(2131690648));
      ((bhuf)localObject).show();
    }
  }
  
  private void v()
  {
    String str = getString(2131691097);
    bhuf localbhuf = bhuf.a(getActivity());
    localbhuf.a(str);
    localbhuf.a(getString(2131691096), 3);
    localbhuf.d(getString(2131690648));
    localbhuf.a(new bciy(this, localbhuf));
    localbhuf.show();
  }
  
  private void w()
  {
    Dialog localDialog = new Dialog(getActivity(), 2131755801);
    localDialog.setContentView(2131560906);
    ((TextView)localDialog.findViewById(2131365271)).setVisibility(8);
    TextView localTextView1 = (TextView)localDialog.findViewById(2131365260);
    TextView localTextView2 = (TextView)localDialog.findViewById(2131365258);
    TextView localTextView3 = (TextView)localDialog.findViewById(2131365264);
    String str = alud.a(2131702117);
    localTextView1.setText(getString(2131691098, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694953);
    localTextView3.setText(2131690648);
    localDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new bciz(this, localDialog));
    localTextView3.setOnClickListener(new bcja(this, localDialog));
    try
    {
      localDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void x()
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
  
  private void y()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView == null) {
      return;
    }
    String str2 = bcpx.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
    String str1 = str2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      str1 = str2 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setText(new bamp(str1, 11, 16));
  }
  
  private void z()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isShowActivityGrade()) {
      i = 0;
    }
    if (i > 0)
    {
      String str = String.format(getResources().getString(2131693675), new Object[] { Integer.valueOf(i) });
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
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
      k = getResources().getDisplayMetrics().widthPixels;
      if (localList.size() <= 0) {
        break label155;
      }
      j = 1;
      if (localList.size() <= 0) {
        break label160;
      }
      i = aiqe.a(k);
    }
    for (;;)
    {
      label105:
      localLayoutParams.width = k;
      localLayoutParams.height = i;
      this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
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
  
  protected void a(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    bckt.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "join");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((1 == paramInt1) && ((getActivity().isResume()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))))
    {
      d();
      bcpx.a(getActivity(), paramInt2);
    }
    while ((!getActivity().isResume()) || ((paramInt1 != 2) && (paramInt1 != 9))) {
      return;
    }
    if (this.jdField_a_of_type_Beub == null) {
      this.jdField_a_of_type_Beub = new beub(getActivity());
    }
    this.jdField_a_of_type_Beub.b(2, 2131692289, 1500);
    getActivity().finish();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    if ((1 == paramInt1) && ((getActivity().isResume()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))))
    {
      d();
      if (this.jdField_a_of_type_Beub == null) {
        this.jdField_a_of_type_Beub = new beub(getActivity());
      }
      switch (paramInt2)
      {
      case -1: 
      default: 
        this.jdField_a_of_type_Beub.b(2, 2131693805, 1500);
      }
    }
    label361:
    do
    {
      for (;;)
      {
        return;
        ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b(Long.parseLong(paramString), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
        return;
        this.jdField_a_of_type_Beub.b(2, 2131693806, 1500);
        getActivity().finish();
        a(true);
        TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
        if (localTroopManager != null)
        {
          localTroopManager.e(localTroopManager.b(paramString));
          return;
          this.jdField_a_of_type_Beub.b(2, 2131721057, 1500);
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
                  break label361;
                }
                this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopAdmMemberNum(paramString.Administrator, paramString.wMemberNum, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), getResources());
                if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView == null) {
                  break;
                }
                this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.a(alud.a(2131702138) + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + alud.a(2131702140));
                return;
              }
            }
          }
        }
      }
    } while (((paramInt1 != 2) && (paramInt1 != 9)) || (paramInt2 != 0));
    paramString = new Intent();
    paramString.putExtra("isNeedFinish", true);
    getActivity().setResult(-1, paramString);
    getActivity().finish();
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    String str2 = bdes.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    if (paramInt == -1) {}
    for (Object localObject = "0";; localObject = "1")
    {
      bdes.a("Grp_share", "grpData_admin", "share_qq", 0, 0, new String[] { str1, str2, localObject });
      if (paramInt == -1) {
        break;
      }
      return;
    }
    localObject = aepi.a(new Intent(getActivity(), SplashActivity.class), null);
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
    QQToast.a(getActivity(), getString(2131696553), 1).b(getActivity().getTitleBarHeight());
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
        A();
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
        new azqx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_private").c("Grp_data").d("exp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(i) }).a();
      }
      j();
      if ((this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
        break label425;
      }
    }
    for (;;)
    {
      c(bool);
      y();
      z();
      n();
      a();
      bcpx.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
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
      aepi.a(localIntent, new int[] { 2 });
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
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        b(2131721048, 0);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
    } while (!getActivity().isResume());
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3))
    {
      a(2);
      return;
    }
    f(null);
    return;
    b(2131719755, 1);
  }
  
  public void a(boolean paramBoolean, List<ainn> paramList)
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
    getActivity().runOnUiThread(new VisitorTroopCardFragment.17(this));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    bcpx.a(getActivity(), getActivity().getTitleBarHeight(), paramInt1, paramInt2);
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
      if (this.jdField_a_of_type_Bety == null)
      {
        this.jdField_a_of_type_Bety = new bety(getActivity(), getActivity().getTitleBarHeight());
        this.jdField_a_of_type_Bety.c(2131695090);
        this.jdField_a_of_type_Bety.c(false);
      }
      this.jdField_a_of_type_Bety.show();
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
      if ((this.jdField_a_of_type_Bety != null) && (this.jdField_a_of_type_Bety.isShowing())) {
        this.jdField_a_of_type_Bety.dismiss();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
    hideTitleBar();
    ImmersiveUtils.a(true, getActivity().getWindow());
    a(getActivity().getIntent().getExtras());
    h();
    bcpx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
    for (paramLayoutInflater = "0";; paramLayoutInflater = "1")
    {
      bcjs.a(17, new Object[] { paramViewGroup, paramLayoutInflater });
      bdes.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
      nco.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 65);
      paramLayoutInflater = new IntentFilter();
      paramLayoutInflater.addAction("start_recomend_page");
      paramLayoutInflater.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramLayoutInflater);
      return;
    }
  }
  
  public void e()
  {
    c();
    this.jdField_a_of_type_Bcjl.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
  }
  
  public void e(String paramString)
  {
    if (!getActivity().isResume()) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      QQToast.a(getActivity(), 2, 2131719238, 1).b(getActivity().getTitleBarHeight());
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
      bcjs.a(15, new Object[] { localObject2, localObject1 });
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember;
      localObject1 = bcid.a();
      if ((bool2) && (!((bcie)localObject1).jdField_a_of_type_Boolean)) {
        break label342;
      }
      bool1 = true;
      if (TextUtils.isEmpty(((bcie)localObject1).jdField_a_of_type_JavaLangString)) {
        break label347;
      }
      localObject1 = ((bcie)localObject1).jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "checkAndInitRecommendList,hasJoinedTroop = " + bool2 + ",displayOrNot = " + bool1 + ",recoomTips = " + (String)localObject1);
      }
      if (this.jdField_a_of_type_Bcig == null)
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
      bcjs.a(16, new Object[] { str, localObject2 });
      localObject2 = new TextView(getActivity());
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextColor(getResources().getColor(2131166876));
      ((TextView)localObject2).setTextSize(2, 16.0F);
      ((TextView)localObject2).setPadding(aepi.a(16.0F, getResources()), aepi.a(13.0F, getResources()), 0, aepi.a(5.0F, getResources()));
      ((TextView)localObject2).setClickable(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      localObject1 = View.inflate(getActivity(), 2131561382, null);
      ((View)localObject1).setBackgroundResource(2130850075);
      this.jdField_a_of_type_Bcig = new bcig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentWidgetXListView, null, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bool1, (TextView)localObject2, (View)localObject1);
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
    return 2131562828;
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
    x();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (xsm.b()) {
      return;
    }
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363471: 
      a(((Integer)paramView.getTag()).intValue(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    case 2131378344: 
      paramView = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_d_of_type_JavaLangString });
      localObject = new Intent(getActivity(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      ((Intent)localObject).putExtra("url", paramView);
      super.startActivity((Intent)localObject);
      return;
    case 2131367516: 
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        a(false, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
      }
      for (;;)
      {
        bcjs.a(3, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner), Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) });
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (this.jdField_a_of_type_Bcjl != null)) {
          this.jdField_a_of_type_Bcjl.d();
        }
      }
    case 2131368624: 
      x();
      getActivity().finish();
      return;
    case 2131368638: 
      t();
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (a()) {}
      for (paramView = "1";; paramView = "0")
      {
        bdes.a("Grp_set_new", "grpData_visitor", "clk_upright", 0, 0, new String[] { localObject, paramView });
        return;
      }
    case 2131379995: 
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        s();
        return;
      }
      a(true, false);
      return;
    case 2131376589: 
      bcpx.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
      for (i = 1;; i = 2)
      {
        bcjs.a(19, new Object[] { Integer.valueOf(i), bcpx.a() + "" });
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum > this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum) {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {}
    for (;;)
    {
      paramView = new Intent(getActivity(), PublicAccountBrowser.class);
      paramView.putExtra("hide_operation_bar", true);
      paramView.putExtra("hideRightButton", true);
      paramView.putExtra("isScreenOrientationPortrait", true);
      paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramView.putExtra("url", "https://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&role=1&group_level=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade + "&group_mem_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "&group_active_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum + "&show_level=" + i);
      startActivity(paramView);
      bcjs.a(20, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      nco.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 72);
      return;
      i = 1;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      }
      this.jdField_f_of_type_Boolean = true;
      if (this.jdField_a_of_type_Bcjl != null)
      {
        this.jdField_a_of_type_Bcjl.a();
        this.jdField_a_of_type_Bcjl = null;
      }
      if (this.jdField_a_of_type_Bcig != null) {
        this.jdField_a_of_type_Bcig.e();
      }
      this.jdField_a_of_type_Bdjz = null;
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
    if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_Bcjl != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VisitorTroopCardFragment.Activity", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.jdField_a_of_type_Bcjl.a(str, paramIntent);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
  }
  
  public void onResume()
  {
    super.onResume();
    String str2;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break label74;
      }
    }
    label74:
    for (String str1 = "1";; str1 = "0")
    {
      bdes.a("Grp_set_new", "grpData_visitor", "exp", 0, 0, new String[] { str2, str1 });
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      p();
      return;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Bcjl != null)
    {
      this.jdField_a_of_type_Bcjl.a(null, false);
      this.jdField_a_of_type_Bcjl.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment
 * JD-Core Version:    0.7.0.1
 */