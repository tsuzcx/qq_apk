package com.tencent.mobileqq.troop.troopCard;

import aagn;
import aiku;
import ajnr;
import ajpz;
import amtj;
import anca;
import ancy;
import andd;
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
import apub;
import aqgr;
import arhi;
import arpf;
import aytm;
import bbyp;
import bcek;
import bdvh;
import bdvj;
import bdvl;
import beqg;
import betj;
import betk;
import betm;
import bevu;
import bevv;
import bevw;
import bevx;
import bevy;
import bevz;
import bewa;
import bewb;
import bewc;
import bewf;
import bewg;
import bewh;
import bewi;
import bewj;
import bewk;
import bewl;
import bewm;
import bewt;
import beyy;
import bflj;
import bftc;
import bhht;
import bhhw;
import bjnv;
import bjnw;
import bjon;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPager;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.theme.SkinnableNinePatchDrawable;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.DecimalFormat;
import java.util.List;
import mqq.util.WeakReference;
import nor;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import xwa;

public class VisitorTroopCardFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, bdvl, bevu
{
  public int a;
  private long jdField_a_of_type_Long;
  protected andd a;
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
  private bdvj jdField_a_of_type_Bdvj;
  private betm jdField_a_of_type_Betm;
  private bewm jdField_a_of_type_Bewm;
  public bflj a;
  protected bhht a;
  private bhhw jdField_a_of_type_Bhhw;
  public QQAppInterface a;
  public TroopInfo a;
  private AvatarWallViewPager jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager;
  private AvatarWallViewPagerAdapter jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter;
  protected ExpandableTextView a;
  public TroopMoreDetailView a;
  public TroopInfoData a;
  public QQCustomDialog a;
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
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bevv(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new bewi(this);
  }
  
  private void A()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isShowActivityGrade()) {
      i = 0;
    }
    if (i > 0)
    {
      String str = String.format(getResources().getString(2131693113), new Object[] { Integer.valueOf(i) });
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
      str1 = amtj.a(2131700877);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(str1);
    this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
    if (AppSetting.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(amtj.a(2131700865) + str1);
    }
  }
  
  private void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramInt == 4)
    {
      a(false);
      if (this.jdField_d_of_type_Int == 2) {
        bewt.a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      paramInt = getActivity().getIntent().getIntExtra("extra_share_group_from", 0);
      if (paramInt != 0) {
        xwa.a("story_grp", "clk_msg", paramInt, 0, new String[0]);
      }
      bftc.a("Grp_set_new", "grpData_visitor", "clk_sendMsg", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead)
      {
        paramInt = 1;
        bewt.a(5, new Object[] { Integer.valueOf(paramInt), TroopUtils.getExposureSourceReportVal() + "" });
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
          bewt.a(7, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
          paramQQAppInterface = "";
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption() == 40002) {
            paramQQAppInterface = "3_40002";
          }
          for (;;)
          {
            aiku.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, paramQQAppInterface);
            bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption() == 40001) {
              paramQQAppInterface = "3_40001";
            }
          }
        }
        if (paramInt == 5)
        {
          TroopUtils.joinGroupOneStep(paramQQAppInterface, getActivity(), getActivity().getIntent(), this.jdField_a_of_type_Bewm.jdField_a_of_type_Bezd);
          bewt.a(8, new Object());
          bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
          return;
        }
      } while (paramInt != 6);
      l = System.currentTimeMillis();
    } while (l - this.jdField_a_of_type_Long <= 1000L);
    this.jdField_a_of_type_Long = l;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
    for (paramInt = 1;; paramInt = 2)
    {
      bewt.a(10, new Object[] { Integer.valueOf(paramInt), TroopUtils.getExposureSourceReportVal() + "" });
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 34) {
        break label450;
      }
      if (!arhi.a(paramQQAppInterface.getCurrentAccountUin())) {
        break label438;
      }
      paramQQAppInterface = arpf.a(getActivity());
      if (getActivity().isFinishing()) {
        break;
      }
      paramQQAppInterface.show();
      bewt.a(11, new Object());
      return;
    }
    label438:
    bewt.a(12, new Object());
    label450:
    TroopUtils.secRecognize(false, null);
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
    for (Object localObject = "1";; localObject = "0")
    {
      bewt.a(13, new Object[] { str, localObject });
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 1) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        break label548;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) {
        break;
      }
      b(1);
      return;
    }
    e();
    return;
    label548:
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject = (anca)paramQQAppInterface.getBusinessHandler(20);
      if (this.jdField_a_of_type_Andd == null)
      {
        this.jdField_a_of_type_Andd = new bewl(this);
        paramQQAppInterface.addObserver(this.jdField_a_of_type_Andd);
      }
      ((anca)localObject).b(Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue(), Long.valueOf(paramQQAppInterface.getCurrentUin()).longValue(), this.jdField_b_of_type_JavaLangString);
      return;
    }
    s();
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = TroopUtils.initTroopInfoData(paramBundle, getActivity());
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = TroopUtils.initTroopInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, getActivity());
    TroopUtils.mExposureSource = paramBundle.getInt("exposureSource", 99);
    this.jdField_c_of_type_Int = paramBundle.getInt("filter_id", -1);
    this.jdField_d_of_type_Int = paramBundle.getInt("D2GType");
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("fromThirdAppByOpenSDK");
    this.jdField_c_of_type_JavaLangString = getActivity().getIntent().getStringExtra("is_from_game");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("authKey");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("authSig");
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("troop_info_from_troopsetting", false);
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isQidianPrivateTroop;
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    this.jdField_a_of_type_Bewm = new bewm();
    this.jdField_a_of_type_Bewm.a(this);
    paramBundle = getActivity().getIntent().getStringExtra("appid");
    String str1 = getActivity().getIntent().getStringExtra("openid");
    String str2 = getActivity().getIntent().getStringExtra("share_uin");
    this.jdField_a_of_type_Bewm.a(paramBundle, str1, str2);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 2;
    Object localObject1 = aqgr.c();
    if ((paramBoolean2) && (((QVipBigTroopExpiredConfig)localObject1).mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
    {
      paramBoolean1 = ancy.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
      int i;
      if (paramBoolean1)
      {
        i = 15;
        localObject1 = VipUtils.a(0, i);
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label191;
        }
        FragmentActivity localFragmentActivity = getActivity();
        String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (localObject1 == null) {
          break label175;
        }
        localObject1 = ((SpannableString)localObject1).toString();
        label103:
        String str2 = amtj.a(2131714675);
        bewc localbewc = new bewc(this, paramBoolean1);
        if (!paramBoolean1) {
          break label183;
        }
        localObject2 = "0X800A57F";
        label131:
        i = j;
        if (paramBoolean1) {
          i = 1;
        }
        VipUtils.a(localFragmentActivity, str1, (String)localObject1, str2, localbewc, (String)localObject2, i, paramBoolean1);
      }
      for (;;)
      {
        bewt.a(1, new Object());
        return;
        i = 8;
        break;
        label175:
        localObject1 = "";
        break label103;
        label183:
        localObject2 = "0X8009E38";
        break label131;
        label191:
        VipUtils.a(getActivity(), paramBoolean1);
      }
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("IS_COVER", paramBoolean1);
    ((Bundle)localObject1).putBoolean("IS_EDIT", paramBoolean2);
    if (!paramBoolean2)
    {
      localObject2 = aagn.a(this.jdField_b_of_type_AndroidWidgetImageView);
      if (localObject2 != null) {
        ((Bundle)localObject1).putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject2);
      }
    }
    if (this.jdField_a_of_type_Bewm != null) {
      this.jdField_a_of_type_Bewm.a((Bundle)localObject1, b());
    }
    bewt.a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (b()) {}
    for (localObject1 = "1";; localObject1 = "0")
    {
      bftc.a("Grp_set_new", "grpData_visitor", "clk_head", 0, 0, new String[] { localObject2, localObject1 });
      return;
    }
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
  }
  
  private void c(boolean paramBoolean)
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
        bbyp.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, getActivity().getWindow());
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
  
  private void d(boolean paramBoolean)
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
      Drawable localDrawable = getResources().getDrawable(2130839445);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131298049));
      ((Animatable)localDrawable).start();
    }
    if (!NetworkUtil.isNetworkAvailable(getActivity())) {
      QQToast.a(getActivity(), 1, getString(2131694064), 1).b(getActivity().getTitleBarHeight());
    }
    ThreadManager.post(new VisitorTroopCardFragment.2(this), 8, null, false);
    l();
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bewf(this));
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
        startActivity(AddFriendLogicActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark, getResources().getString(2131690707), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString));
        return;
      }
      paramString = AddFriendLogicActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, getResources().getString(2131690707), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString);
      paramString.putExtra("from_newer_guide", getActivity().getIntent().getBooleanExtra("from_newer_guide", false));
      paramString.putExtra("from_babyq", getActivity().getIntent().getBooleanExtra("from_babyq", false));
      startActivityForResult(paramString, 1);
      return;
    }
    b(2131719201, 0);
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.mContentView.findViewById(2131378806));
    this.jdField_b_of_type_AndroidViewView = this.mContentView.findViewById(2131363803);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.mContentView.findViewById(2131363630));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131364934));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    int i = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
    int k = getResources().getDimensionPixelOffset(2131297076);
    this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(i, 0, j, k);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getActivity());
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.mContentView.setBackgroundResource(2130838891);
    k();
    i();
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
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
    Object localObject = View.inflate(getActivity(), 2131559871, null);
    this.jdField_c_of_type_AndroidViewView = ((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager = ((AvatarWallViewPager)((View)localObject).findViewById(2131380854));
    o();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    a();
    localObject = View.inflate(getActivity(), 2131560658, null);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373641));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379279));
    n();
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379315));
    j();
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379220));
    A();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131367927));
    ((View)localObject).setContentDescription(getResources().getString(2131698698));
    if (bbyp.b()) {
      ((View)localObject).setBackground(null);
    }
    r();
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379260));
    B();
    aytm.a(this.jdField_c_of_type_AndroidWidgetTextView, amtj.a(2131714683));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379318));
    d(true);
    localObject = amtj.a(2131691182);
    String str = this.jdField_d_of_type_AndroidWidgetTextView.getText().toString();
    localObject = aytm.a(this.jdField_d_of_type_AndroidWidgetTextView, (String)localObject, str);
    if (localObject != null) {
      ((aytm)localObject).a(new bewg(this));
    }
    localObject = TroopUtils.getDateString(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      localObject = (String)localObject + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView = ((ExpandableTextView)View.inflate(getActivity(), 2131560662, null));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setText(new QQText((CharSequence)localObject, 11, 16));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().setMovementMethod(LinkMovementMethod.getInstance());
      int i = AIOUtils.dp2px(12.0F, getResources());
      int j = AIOUtils.dp2px(15.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setBackgroundResource(2130850348);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setOnExpandStateChangeListener(new bewh(this));
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setPadding(i, j, i, j);
      localObject = View.inflate(getActivity(), 2131561537, null);
      ((View)localObject).setBackgroundResource(2130850608);
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
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131693070, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopNeedPayNumber) }));
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
        localObject = "（" + getString(2131695761) + "）";
        this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 3) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 4))
      {
        localObject = "（" + getString(2131695761) + "）";
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
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131378784);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131378727));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName + " " + getResources().getString(2131690707));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131369115));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690707));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131369068));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131694268) + getString(2131690596));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369082));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131691014));
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
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131363721));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131377294));
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {}
    for (int i = 1; this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember; i = 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693038);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(4));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    if (i != 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131693070, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopNeedPayNumber) }));
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(3));
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    if ("true".equals(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693226);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(5));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
      return;
    }
    if (this.jdField_d_of_type_Int == 2) {
      bewt.a(18, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131693225);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(6));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
    TroopUtils.secRecognize(true, this.jdField_a_of_type_AndroidWidgetButton);
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
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter = new AvatarWallViewPagerAdapter(new WeakReference(getActivity()), this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager, getResources().getDisplayMetrics().widthPixels, UIUtils.dip2px(getActivity(), 212.0F), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, null, "Grp_Admin_data");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnPageChangeListener(new bewj(this));
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorTroopCardFragment.Activity", 2, String.format("updateTitle mStatusBarShow=%b", new Object[] { Boolean.valueOf(this.jdField_d_of_type_Boolean) }));
    }
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.jdField_d_of_type_Boolean) || (bool)) {}
    for (int i = 2131167009;; i = 2131166709)
    {
      int k = getResources().getColor(i);
      int j = 2130843732;
      i = j;
      if (this.jdField_d_of_type_Boolean)
      {
        i = j;
        if (!bool) {
          i = 2130840329;
        }
      }
      Drawable localDrawable = getResources().getDrawable(2130850593);
      localDrawable.setColorFilter(k, PorterDuff.Mode.SRC_ATOP);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(k);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(k);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(k);
      c(this.jdField_d_of_type_Boolean);
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new bewk(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    try
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(((SkinnableNinePatchDrawable)getResources().getDrawable(2130850271)).getBitmap());
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
    if (this.jdField_a_of_type_Bewm == null) {}
    do
    {
      return;
      Drawable localDrawable = this.jdField_a_of_type_Bewm.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
    } while ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void s()
  {
    TroopUtils.calJoinTroop(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, TroopUtils.mExposureSource, this.jdField_c_of_type_Int, 2);
    if (!NetworkUtil.isNetSupport(getActivity())) {
      TroopUtils.notifyUser(getActivity(), getActivity().getTitleBarHeight(), 2131694062, 1);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bewm != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VisitorTroopCardFragment.Activity", 2, "mVisitorPresenter is null");
    return;
    this.jdField_a_of_type_Bewm.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 8390784);
    if (super.getActivity().getIntent().getBooleanExtra("from_babyq", false)) {
      bewt.a(14, new Object());
    }
    bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
  }
  
  private void t()
  {
    bjnw localbjnw = (bjnw)bjon.a(getActivity(), null);
    localbjnw.a(new bjnv(amtj.a(2131700876), 7, 0), 5);
    localbjnw.a(new bjnv(amtj.a(2131700882), 8, 0), 5);
    localbjnw.c(2131690620);
    localbjnw.a(new bevw(this, localbjnw));
    if (!localbjnw.isShowing()) {
      localbjnw.show();
    }
  }
  
  private void u()
  {
    bjnw localbjnw = (bjnw)bjon.a(getActivity(), null);
    if (!b()) {
      localbjnw.a(new bjnv(getString(2131695680), 9, 0), 5);
    }
    localbjnw.a(new bjnv(bjon.a(getActivity(), 2131717685), 10, 0), 5);
    localbjnw.c(2131690620);
    localbjnw.a(new bevx(this, localbjnw));
    if (!localbjnw.isShowing()) {
      localbjnw.show();
    }
  }
  
  private void v()
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localObject == null)
    {
      localObject = null;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label106;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L) && ((this.jdField_a_of_type_Bewm == null) || (this.jdField_a_of_type_Bewm.jdField_a_of_type_Int == 0))) {
        break label99;
      }
      x();
    }
    for (;;)
    {
      bewt.a(21, new Object());
      return;
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      break;
      label99:
      w();
      continue;
      label106:
      localObject = bjnw.a(getActivity());
      ((bjnw)localObject).a(2131690964);
      ((bjnw)localObject).a(2131691941, 3);
      ((bjnw)localObject).a(new bevy(this, (bjnw)localObject));
      ((bjnw)localObject).d(getString(2131690620));
      ((bjnw)localObject).show();
    }
  }
  
  private void w()
  {
    String str = getString(2131690958);
    bjnw localbjnw = bjnw.a(getActivity());
    localbjnw.a(str);
    localbjnw.a(getString(2131690957), 3);
    localbjnw.d(getString(2131690620));
    localbjnw.a(new bevz(this, localbjnw));
    localbjnw.show();
  }
  
  private void x()
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131755826);
    localReportDialog.setContentView(2131561021);
    ((TextView)localReportDialog.findViewById(2131365589)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365577);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365575);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365581);
    String str = amtj.a(2131700879);
    localTextView1.setText(getString(2131690959, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694201);
    localTextView3.setText(2131690620);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new bewa(this, localReportDialog));
    localTextView3.setOnClickListener(new bewb(this, localReportDialog));
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
    String str2 = TroopUtils.getDateString(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
    String str1 = str2;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo)) {
      str1 = str2 + "\r\n" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setText(new QQText(str1, 11, 16));
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
      i = ajpz.a(k);
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
    if ((paramInt > 0) && (this.jdField_a_of_type_Betm != null)) {
      this.jdField_a_of_type_Betm.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((1 == paramInt1) && ((getActivity().isResume()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))))
    {
      d();
      TroopUtils.handleJoinTroopFailed(getActivity(), paramInt2);
    }
    while ((!getActivity().isResume()) || ((paramInt1 != 2) && (paramInt1 != 9))) {
      return;
    }
    if (this.jdField_a_of_type_Bhhw == null) {
      this.jdField_a_of_type_Bhhw = new bhhw(getActivity());
    }
    this.jdField_a_of_type_Bhhw.b(2, 2131691945, 1500);
    getActivity().finish();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    if ((1 == paramInt1) && ((getActivity().isResume()) || ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)) || (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))))
    {
      d();
      if (this.jdField_a_of_type_Bhhw == null) {
        this.jdField_a_of_type_Bhhw = new bhhw(getActivity());
      }
      switch (paramInt2)
      {
      case -1: 
      default: 
        this.jdField_a_of_type_Bhhw.b(2, 2131693219, 1500);
      }
    }
    label369:
    do
    {
      for (;;)
      {
        return;
        ((anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20)).b(Long.parseLong(paramString), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
        return;
        this.jdField_a_of_type_Bhhw.b(2, 2131693220, 1500);
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
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder().append("troopInfo is null 2 ? : ");
            if (localObject1 != null) {
              break label369;
            }
          }
          for (;;)
          {
            QLog.d("VisitorTroopCardFragment.Activity", 2, bool + " : " + paramString);
            if (localObject1 != null) {
              break label409;
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
            this.jdField_a_of_type_Bhhw.b(2, 2131719201, 1500);
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
                    break label580;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopAdmMemberNum(paramString.Administrator, paramString.wMemberNum, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), getResources());
                  if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView == null) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.a(amtj.a(2131700900) + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + amtj.a(2131700902));
                  return;
                }
              }
            }
          }
        }
      }
    } while (((paramInt1 != 2) && (paramInt1 != 9)) || (paramInt2 != 0));
    label409:
    label580:
    paramString = new Intent();
    paramString.putExtra("isNeedFinish", true);
    getActivity().setResult(-1, paramString);
    getActivity().finish();
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    String str2 = bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    if (paramInt == -1) {}
    for (Object localObject = "0";; localObject = "1")
    {
      bftc.a("Grp_share", "grpData_admin", "share_qq", 0, 0, new String[] { str1, str2, localObject });
      if (paramInt == -1) {
        break;
      }
      return;
    }
    localObject = AIOUtils.setOpenAIOIntent(new Intent(getActivity(), SplashActivity.class), null);
    ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
    paramIntent = ForwardUtils.sessionFromIntent((Intent)localObject);
    ForwardUtils.handleAppShareAction(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), paramIntent, (Intent)localObject);
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
    QQToast.a(getActivity(), getString(2131695561), 1).b(getActivity().getTitleBarHeight());
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
          break label388;
        }
        str = "";
        QLog.d(".troop.qidian_private_troop", 2, str + ", flagExt3=" + i + ", isQidianPrivateTroop=" + TroopInfo.isQidianPrivateTroop(i));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.coverFrom(paramGroupInfo);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopName();
        if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.newTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopName();
        }
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.oldTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopName();
      }
      this.jdField_e_of_type_Boolean = TroopInfo.isQidianPrivateTroop(paramGroupInfo.uint32_group_flagext3.get());
      if (this.jdField_e_of_type_Boolean)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label400;
        }
        i = 1;
        label231:
        new bcek(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_private").c("Grp_data").d("exp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(i) }).a();
      }
      j();
      if ((this.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)) {
        break label435;
      }
    }
    for (;;)
    {
      d(bool);
      z();
      A();
      n();
      a();
      TroopUtils.updateTroopInfoToDB(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setTroopInfoData(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.a();
      }
      f();
      b(false);
      return;
      label388:
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      break;
      label400:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin)
      {
        i = 2;
        break label231;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
      {
        i = 3;
        break label231;
      }
      i = 4;
      break label231;
      label435:
      bool = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "go2AIO mTroopInfoData == null");
      }
      return;
    }
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
      AIOUtils.setOpenAIOIntent(localIntent, new int[] { 2 });
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
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.cGroupOption = 2;
          this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.setOnlyTroopMemberInviteOption(false);
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption = 2;
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOnlyTroopMemberInvite = false;
      }
    } while (!getActivity().isResume());
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3))
    {
      b(2);
      return;
    }
    f(null);
    return;
    b(2131718115, 1);
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
    beqg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramLong, getActivity());
  }
  
  public void a(boolean paramBoolean, List<ajnr> paramList)
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
  
  boolean a()
  {
    bdvh localbdvh = (bdvh)apub.a().a(686);
    if ((localbdvh != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)) {
      return (localbdvh.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasTroopAssociation());
    }
    return false;
  }
  
  public void b()
  {
    getActivity().runOnUiThread(new VisitorTroopCardFragment.18(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    beyy.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "join");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    TroopUtils.notifyUser(getActivity(), getActivity().getTitleBarHeight(), paramInt1, paramInt2);
  }
  
  public void b(String paramString)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
      r();
    }
  }
  
  void b(boolean paramBoolean)
  {
    Object localObject = (bdvh)apub.a().a(686);
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (!((bdvh)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData))) {
      break label35;
    }
    label35:
    while ((this.jdField_a_of_type_Bdvj != null) && (!paramBoolean)) {
      return;
    }
    if (this.jdField_a_of_type_Bdvj == null) {
      this.jdField_a_of_type_Bdvj = new bdvj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
    }
    localObject = this.jdField_a_of_type_Bdvj;
    if ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasTroopAssociation())) {}
    for (boolean bool = true;; bool = false)
    {
      ((bdvj)localObject).a(bool);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VisitorTroopCardFragment.Activity", 2, "refreshTroopAssocitionListV2 troopUin:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + " bForce:" + paramBoolean + " hasTroopAssociation:" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasTroopAssociation());
      return;
    }
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_Bhht == null)
      {
        this.jdField_a_of_type_Bhht = new bhht(getActivity(), getActivity().getTitleBarHeight());
        this.jdField_a_of_type_Bhht.c(2131694279);
        this.jdField_a_of_type_Bhht.c(false);
      }
      this.jdField_a_of_type_Bhht.show();
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
      if ((this.jdField_a_of_type_Bhht != null) && (this.jdField_a_of_type_Bhht.isShowing())) {
        this.jdField_a_of_type_Bhht.dismiss();
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
    TroopUtils.preloadWebProcess(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
    for (paramLayoutInflater = "0";; paramLayoutInflater = "1")
    {
      bewt.a(17, new Object[] { paramViewGroup, paramLayoutInflater });
      bftc.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
      nor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 65);
      paramLayoutInflater = new IntentFilter();
      paramLayoutInflater.addAction("start_recomend_page");
      paramLayoutInflater.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramLayoutInflater);
      return;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bewm != null)
    {
      c();
      this.jdField_a_of_type_Bewm.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void e(String paramString)
  {
    if (!getActivity().isResume()) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      QQToast.a(getActivity(), 2, 2131717689, 1).b(getActivity().getTitleBarHeight());
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
    label77:
    label96:
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
    {
      localObject1 = "1";
      bewt.a(15, new Object[] { localObject2, localObject1 });
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember;
      localObject1 = betj.a();
      if (((bool2) && ((localObject1 == null) || (!((betk)localObject1).jdField_a_of_type_Boolean))) || (a())) {
        break label346;
      }
      bool1 = true;
      if ((localObject1 == null) || (TextUtils.isEmpty(((betk)localObject1).jdField_a_of_type_JavaLangString))) {
        break label351;
      }
      localObject1 = ((betk)localObject1).jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "checkAndInitRecommendList,hasJoinedTroop = " + bool2 + ",displayOrNot = " + bool1 + ",recoomTips = " + (String)localObject1);
      }
      if (this.jdField_a_of_type_Betm == null)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
          break label358;
        }
      }
    }
    label346:
    label351:
    label358:
    for (localObject2 = "1";; localObject2 = "2")
    {
      bewt.a(16, new Object[] { str, localObject2 });
      localObject2 = new TextView(getActivity());
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextColor(getResources().getColor(2131166982));
      ((TextView)localObject2).setTextSize(2, 16.0F);
      ((TextView)localObject2).setPadding(AIOUtils.dp2px(16.0F, getResources()), AIOUtils.dp2px(13.0F, getResources()), 0, AIOUtils.dp2px(5.0F, getResources()));
      ((TextView)localObject2).setClickable(false);
      localObject1 = View.inflate(getActivity(), 2131561537, null);
      ((View)localObject1).setBackgroundResource(2130850608);
      this.jdField_a_of_type_Betm = new betm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentWidgetXListView, null, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bool1, (TextView)localObject2, (View)localObject1);
      return;
      localObject1 = "2";
      break;
      bool1 = false;
      break label77;
      localObject1 = "相关推荐";
      break label96;
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131562982;
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
    case 3: 
      a(paramInt2, paramIntent);
      return;
    }
    b(true);
  }
  
  public boolean onBackEvent()
  {
    y();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = 0;
    if (UIUtils.isFastDoubleClick()) {}
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
      case 2131363721: 
        a(((Integer)paramView.getTag()).intValue(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
      case 2131379130: 
        localObject1 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_d_of_type_JavaLangString });
        localObject2 = new Intent(getActivity(), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        super.startActivity((Intent)localObject2);
        break;
      case 2131367927: 
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
          a(false, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        }
        for (;;)
        {
          bewt.a(3, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner), Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) });
          break;
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (this.jdField_a_of_type_Bewm != null)) {
            this.jdField_a_of_type_Bewm.d();
          }
        }
      case 2131369068: 
        y();
        getActivity().finish();
        break;
      case 2131369082: 
        u();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (b()) {}
        for (localObject1 = "1";; localObject1 = "0")
        {
          bftc.a("Grp_set_new", "grpData_visitor", "clk_upright", 0, 0, new String[] { localObject2, localObject1 });
          break;
        }
      case 2131380854: 
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
          t();
        } else {
          a(true, false);
        }
        break;
      }
    }
    if (this.jdField_a_of_type_Bflj != null) {
      this.jdField_a_of_type_Bflj.e();
    }
    this.jdField_a_of_type_Bflj = TroopUtils.shareTroop(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {}
    for (i = 1;; i = 2)
    {
      bewt.a(19, new Object[] { Integer.valueOf(i), TroopUtils.getExposureSourceReportVal() + "" });
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
      bewt.a(20, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      nor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 72);
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
      if (this.jdField_a_of_type_Andd != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Andd);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      }
      this.jdField_f_of_type_Boolean = true;
      if (this.jdField_a_of_type_Bewm != null)
      {
        this.jdField_a_of_type_Bewm.a();
        this.jdField_a_of_type_Bewm = null;
      }
      if (this.jdField_a_of_type_Bdvj != null) {
        this.jdField_a_of_type_Bdvj.b();
      }
      if (this.jdField_a_of_type_Betm != null) {
        this.jdField_a_of_type_Betm.c();
      }
      if (this.jdField_a_of_type_Bflj != null) {
        this.jdField_a_of_type_Bflj.e();
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
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
    if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_Bewm != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VisitorTroopCardFragment.Activity", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.jdField_a_of_type_Bewm.a(str, paramIntent);
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
      bftc.a("Grp_set_new", "grpData_visitor", "exp", 0, 0, new String[] { str2, str1 });
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
    if (this.jdField_a_of_type_Bewm != null)
    {
      this.jdField_a_of_type_Bewm.a(null, false);
      this.jdField_a_of_type_Bewm.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
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