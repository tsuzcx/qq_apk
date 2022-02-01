package com.tencent.mobileqq.troop.troopCard;

import aavz;
import ajfq;
import ajgr;
import ajgu;
import akjf;
import akln;
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
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvx;
import aoep;
import aofp;
import aofu;
import aqxe;
import arjy;
import aslo;
import astl;
import azyi;
import bdfk;
import bdlf;
import bfck;
import bfcm;
import bfco;
import bfxi;
import bgap;
import bgaq;
import bgas;
import bgdd;
import bgde;
import bgdf;
import bgdg;
import bgdh;
import bgdi;
import bgdj;
import bgdk;
import bgdl;
import bgdm;
import bgdn;
import bgdo;
import bgdp;
import bgds;
import bgdt;
import bgdu;
import bgdv;
import bgdw;
import bgdx;
import bgdy;
import bgef;
import bghd;
import bgua;
import bhbu;
import bisl;
import biso;
import bkzh;
import bkzi;
import bkzz;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import nvs;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import ykv;

public class VisitorTroopCardFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, bfco, bgdd
{
  public int a;
  private long jdField_a_of_type_Long;
  private ajgu jdField_a_of_type_Ajgu = new bgdg(this);
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
  protected aofu a;
  private bfcm jdField_a_of_type_Bfcm;
  private bgas jdField_a_of_type_Bgas;
  private bgdy jdField_a_of_type_Bgdy;
  protected bgua a;
  protected bisl a;
  private biso jdField_a_of_type_Biso;
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
  public int c;
  protected View c;
  protected Button c;
  protected ImageView c;
  protected TextView c;
  protected String c;
  public boolean c;
  protected int d;
  protected View d;
  protected ImageView d;
  protected TextView d;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  protected int e;
  private View jdField_e_of_type_AndroidViewView;
  protected ImageView e;
  protected TextView e;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  protected TextView f;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = 2;
  protected TextView g;
  private boolean jdField_g_of_type_Boolean;
  protected TextView h;
  private boolean h;
  
  public VisitorTroopCardFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bgde(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new bgdv(this);
    this.jdField_a_of_type_Aofu = new bgdf(this);
  }
  
  private void A()
  {
    bkzi localbkzi = (bkzi)bkzz.a(getActivity(), null);
    if (!c()) {
      localbkzi.a(new bkzh(getString(2131695932), 9, 0), 5);
    }
    localbkzi.a(new bkzh(bkzz.a(getActivity(), 2131718056), 10, 0), 5);
    localbkzi.c(2131690697);
    localbkzi.a(new bgdi(this, localbkzi));
    if (!localbkzi.isShowing()) {
      localbkzi.show();
    }
  }
  
  private void B()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (!c())) {
      return;
    }
    bkzi localbkzi = (bkzi)bkzz.a(getActivity(), null);
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
    {
      str = getString(2131699010);
      label47:
      localbkzi.a(str);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
        break label151;
      }
      str = getString(2131699011);
      label69:
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
        break label161;
      }
    }
    label151:
    label161:
    for (int i = 12;; i = 9)
    {
      localbkzi.a(new bkzh(str, i, 0), 5);
      localbkzi.c(2131690697);
      localbkzi.a(new bgdj(this, localbkzi));
      localbkzi.a(new bgdk(this, localbkzi));
      if (localbkzi.isShowing()) {
        break;
      }
      localbkzi.show();
      return;
      str = getString(2131699013);
      break label47;
      str = getString(2131699012);
      break label69;
    }
  }
  
  private void C()
  {
    if (this.jdField_a_of_type_Bgua != null) {
      this.jdField_a_of_type_Bgua.e();
    }
    this.jdField_a_of_type_Bgua = TroopUtils.shareTroop(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void D()
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject == null)
    {
      localObject = null;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label107;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L) && ((this.jdField_a_of_type_Bgdy == null) || (this.jdField_a_of_type_Bgdy.jdField_a_of_type_Int == 0))) {
        break label100;
      }
      F();
    }
    for (;;)
    {
      bgef.a(21, new Object());
      return;
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      break;
      label100:
      E();
      continue;
      label107:
      localObject = bkzi.a(getActivity());
      ((bkzi)localObject).a(2131691049);
      ((bkzi)localObject).a(2131692031, 3);
      ((bkzi)localObject).a(new bgdl(this, (bkzi)localObject));
      ((bkzi)localObject).d(getString(2131690697));
      ((bkzi)localObject).show();
    }
  }
  
  private void E()
  {
    String str = getString(2131691043);
    bkzi localbkzi = bkzi.a(getActivity());
    localbkzi.a(str);
    localbkzi.a(getString(2131691042), 3);
    localbkzi.d(getString(2131690697));
    localbkzi.a(new bgdm(this, localbkzi));
    localbkzi.show();
  }
  
  private void F()
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131755829);
    localReportDialog.setContentView(2131561082);
    ((TextView)localReportDialog.findViewById(2131365682)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365669);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365667);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365673);
    String str = anvx.a(2131701230);
    localTextView1.setText(getString(2131691044, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694399);
    localTextView3.setText(2131690697);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new bgdn(this, localReportDialog));
    localTextView3.setOnClickListener(new bgdo(this, localReportDialog));
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
  
  private void G()
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
  
  private void H()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView == null) {
      return;
    }
    l();
  }
  
  private void I()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isShowActivityGrade()) {
      i = 0;
    }
    if (i > 0)
    {
      Object localObject = String.format(getResources().getString(2131693281), new Object[] { Integer.valueOf(i) });
      this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = this.jdField_f_of_type_AndroidWidgetTextView;
      if (b())
      {
        i = getResources().getColor(2131167190);
        ((TextView)localObject).setTextColor(i);
      }
    }
    for (;;)
    {
      if (this.jdField_e_of_type_Boolean) {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      return;
      i = getResources().getColor(2131167026);
      break;
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void J()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = anvx.a(2131701228);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
    localObject2 = this.jdField_c_of_type_AndroidWidgetTextView;
    if (b()) {}
    for (int i = getResources().getColor(2131167190);; i = getResources().getColor(2131167026))
    {
      ((TextView)localObject2).setTextColor(i);
      if (AppSetting.jdField_c_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(anvx.a(2131701216) + (String)localObject1);
      }
      return;
    }
  }
  
  private void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (paramInt == 4)
    {
      a(false);
      if (this.jdField_e_of_type_Int == 2) {
        bgef.a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      paramInt = getActivity().getIntent().getIntExtra("extra_share_group_from", 0);
      if (paramInt != 0) {
        ykv.a("story_grp", "clk_msg", paramInt, 0, new String[0]);
      }
      bhbu.a("grpProfile", "grpProfile_clk", "message_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
    }
    do
    {
      long l;
      do
      {
        do
        {
          return;
          if (paramInt == 3)
          {
            x();
            return;
          }
          if (paramInt == 5)
          {
            TroopUtils.joinGroupOneStep(paramQQAppInterface, getActivity(), getActivity().getIntent(), this.jdField_a_of_type_Bgdy.jdField_a_of_type_Bghi);
            bgef.a(8, new Object());
            bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
            return;
          }
        } while (paramInt != 6);
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Long <= 1000L);
      this.jdField_a_of_type_Long = l;
      bhbu.a("grpProfile", "grpProfile_clk", "join_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 34) {
        break label286;
      }
      if (!aslo.a(paramQQAppInterface.getCurrentAccountUin())) {
        break;
      }
      paramQQAppInterface = astl.a(getActivity());
    } while (getActivity().isFinishing());
    paramQQAppInterface.show();
    bgef.a(11, new Object());
    return;
    bgef.a(12, new Object());
    label286:
    TroopUtils.secRecognize(false, null);
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
    for (String str1 = "1";; str1 = "0")
    {
      bgef.a(13, new Object[] { str2, str1 });
      if ((this.jdField_c_of_type_Int != 0) || ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 1) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))) {
        break label391;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) {
        break;
      }
      b(1);
      return;
    }
    e();
    return;
    label391:
    ((aoep)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue(), Long.valueOf(paramQQAppInterface.getCurrentUin()).longValue(), this.jdField_b_of_type_JavaLangString);
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = TroopUtils.initTroopInfoData(paramBundle, getActivity());
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = TroopUtils.initTroopInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, getActivity());
    TroopUtils.mExposureSource = paramBundle.getInt("exposureSource", 99);
    this.jdField_d_of_type_Int = paramBundle.getInt("filter_id", -1);
    this.jdField_e_of_type_Int = paramBundle.getInt("D2GType");
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("fromThirdAppByOpenSDK");
    this.jdField_c_of_type_JavaLangString = getActivity().getIntent().getStringExtra("is_from_game");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("authKey");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("authSig");
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("troop_info_from_troopsetting", false);
    this.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isQidianPrivateTroop;
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    this.jdField_a_of_type_Bgdy = new bgdy();
    this.jdField_a_of_type_Bgdy.a(this);
    paramBundle = getActivity().getIntent().getStringExtra("appid");
    String str1 = getActivity().getIntent().getStringExtra("openid");
    String str2 = getActivity().getIntent().getStringExtra("share_uin");
    this.jdField_a_of_type_Bgdy.a(paramBundle, str1, str2);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 2;
    Object localObject1 = arjy.c();
    if ((paramBoolean2) && (((QVipBigTroopExpiredConfig)localObject1).mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
    {
      paramBoolean1 = aofp.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
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
        String str2 = anvx.a(2131715022);
        bgdp localbgdp = new bgdp(this, paramBoolean1);
        if (!paramBoolean1) {
          break label183;
        }
        localObject2 = "0X800A57F";
        label131:
        i = j;
        if (paramBoolean1) {
          i = 1;
        }
        VipUtils.a(localFragmentActivity, str1, (String)localObject1, str2, localbgdp, (String)localObject2, i, paramBoolean1);
      }
      for (;;)
      {
        bgef.a(1, new Object());
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
      localObject2 = aavz.a(this.jdField_b_of_type_AndroidWidgetImageView);
      if (localObject2 != null) {
        ((Bundle)localObject1).putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject2);
      }
    }
    if (this.jdField_a_of_type_Bgdy != null) {
      this.jdField_a_of_type_Bgdy.a((Bundle)localObject1, c());
    }
    bgef.a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (c()) {}
    for (localObject1 = "1";; localObject1 = "0")
    {
      bhbu.a("Grp_set_new", "grpData_visitor", "clk_head", 0, 0, new String[] { localObject2, localObject1 });
      return;
    }
  }
  
  private boolean a(boolean paramBoolean, int paramInt)
  {
    int i;
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
      i = 1;
    }
    while (i != 0)
    {
      d();
      if ((paramBoolean) && (paramInt != 0))
      {
        ajgr.a(getActivity(), this.jdField_a_of_type_Ajgu, new Object[0]);
        return true;
        i = 0;
      }
      else
      {
        x();
        return true;
      }
    }
    return false;
  }
  
  private boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a().size() > 0);
  }
  
  private void c(boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool3 = b();
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
      bool1 = bool2;
      if (!bool3) {
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label97;
        }
      }
    }
    label97:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      ImmersiveUtils.a(bool1, getActivity().getWindow());
      if (paramBoolean) {
        bdfk.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, getActivity().getWindow());
      }
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
      break;
    }
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
  }
  
  private void d(boolean paramBoolean)
  {
    String str = " ";
    Object localObject = str;
    if (paramBoolean)
    {
      localObject = str;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
      {
        localObject = str;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin != null) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        }
      }
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setClickable(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isNewTroop)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this);
        bhbu.a("grpProfile", "grpProfile_exp", "grpNumberr_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      }
    }
    localObject = this.jdField_d_of_type_AndroidWidgetTextView;
    if (b()) {}
    for (int i = getResources().getColor(2131167190);; i = getResources().getColor(2131167026))
    {
      ((TextView)localObject).setTextColor(i);
      return;
    }
  }
  
  private void e(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (this.jdField_b_of_type_Int == 1))
    {
      if (this.jdField_c_of_type_Int != 0)
      {
        ajgr.a(getActivity(), this.jdField_a_of_type_Ajgu, new Object[0]);
        return;
      }
      e();
      return;
    }
    f(paramString);
  }
  
  private void f(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 3)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption();
      if ((this.jdField_e_of_type_Int == 1) || (this.jdField_e_of_type_Int == 2)) {
        i = 18;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark))
      {
        startActivity(AddFriendLogicActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark, getResources().getString(2131690784), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString));
        return;
      }
      paramString = AddFriendLogicActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, i, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, getResources().getString(2131690784), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString);
      paramString.putExtra("from_newer_guide", getActivity().getIntent().getBooleanExtra("from_newer_guide", false));
      paramString.putExtra("from_babyq", getActivity().getIntent().getBooleanExtra("from_babyq", false));
      startActivityForResult(paramString, 1);
      return;
    }
    b(2131719621, 0);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      Drawable localDrawable = getResources().getDrawable(2130839466);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131298052));
      ((Animatable)localDrawable).start();
    }
    if (!NetworkUtil.isNetworkAvailable(getActivity())) {
      QQToast.a(getActivity(), 1, getString(2131694255), 1).b(getActivity().getTitleBarHeight());
    }
    ThreadManager.post(new VisitorTroopCardFragment.2(this), 8, null, false);
    o();
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new bgds(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void g(String paramString)
  {
    getActivity().runOnUiThread(new VisitorTroopCardFragment.21(this, paramString));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    a();
    u();
    J();
    m();
    q();
    I();
    l();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.b();
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.mContentView.findViewById(2131379099));
    this.jdField_d_of_type_AndroidViewView = this.mContentView.findViewById(2131363875);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.mContentView.findViewById(2131363699));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131365022));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    int i = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
    int k = getResources().getDimensionPixelOffset(2131297077);
    this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(i, 0, j, k);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getActivity());
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.mContentView.setBackgroundResource(2130838911);
    n();
    j();
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    t();
    p();
  }
  
  @SuppressLint({"NewApi"})
  private void j()
  {
    Object localObject = View.inflate(getActivity(), 2131559915, null);
    this.jdField_e_of_type_AndroidViewView = ((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager = ((AvatarWallViewPager)((View)localObject).findViewById(2131381206));
    this.jdField_f_of_type_AndroidViewView = ((View)localObject).findViewById(2131373996);
    r();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    a();
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373858));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379583));
    q();
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379619));
    m();
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379524));
    I();
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368063));
    ((View)localObject).setContentDescription(getResources().getString(2131699009));
    if (bdfk.b()) {
      ((View)localObject).setBackground(null);
    }
    u();
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379564));
    J();
    azyi.a(this.jdField_c_of_type_AndroidWidgetTextView, anvx.a(2131715031));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379622));
    d(true);
    localObject = anvx.a(2131691267);
    String str = this.jdField_d_of_type_AndroidWidgetTextView.getText().toString();
    localObject = azyi.a(this.jdField_d_of_type_AndroidWidgetTextView, (String)localObject, str);
    if (localObject != null) {
      ((azyi)localObject).a(new bgdt(this));
    }
    this.jdField_b_of_type_AndroidViewView = View.inflate(getActivity(), 2131561567, null);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380232));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369576));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
    k();
    this.jdField_c_of_type_AndroidViewView = View.inflate(getActivity(), 2131560715, null);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView = ((ExpandableTextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131366301));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369425));
    l();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setOnExpandStateChangeListener(new bgdu(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
    localObject = View.inflate(getActivity(), 2131561603, null);
    ((View)localObject).setBackgroundResource(2130850739);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298051);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView = new TroopMoreDetailView(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setGuestVisitor(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView);
  }
  
  private void k()
  {
    Object localObject;
    if (b()) {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130846189);
        localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        this.jdField_b_of_type_AndroidViewView.measure(0, 0);
        ((LinearLayout.LayoutParams)localObject).height = (this.jdField_b_of_type_AndroidViewView.getMeasuredHeight() + AIOUtils.dp2px(6.0F, getResources()));
        if (!b()) {
          break label165;
        }
      }
    }
    label165:
    for (float f1 = -6.0F;; f1 = 0.0F)
    {
      ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.dp2px(f1, getResources());
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = TroopUtils.getDateString(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(new QQText((CharSequence)localObject, 11, 16));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      return;
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839008);
      break;
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839496);
      break;
    }
  }
  
  private void l()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo))
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839496);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setText(new QQText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, 11, 16));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.post(new VisitorTroopCardFragment.6(this));
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void m()
  {
    int j = 8;
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 1)
    {
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
        break label451;
      }
    }
    label451:
    for (int i = 1;; i = 0)
    {
      Object localObject = this.jdField_h_of_type_AndroidWidgetTextView;
      if (i != 0) {
        j = 0;
      }
      ((TextView)localObject).setVisibility(j);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) || (i == 0)) {
        break label456;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131693237, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopNeedPayNumber) }));
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(3));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 0)
      {
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 2)
      {
        localObject = "（" + getString(2131696013) + "）";
        this.jdField_g_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        localObject = this.jdField_g_of_type_AndroidWidgetTextView;
        if (b()) {}
        for (i = getResources().getColor(2131167190);; i = getResources().getColor(2131167026))
        {
          ((TextView)localObject).setTextColor(i);
          break;
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 3) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 4))
      {
        localObject = "（" + getString(2131696013) + "）";
        this.jdField_g_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        localObject = this.jdField_g_of_type_AndroidWidgetTextView;
        if (b()) {}
        for (i = getResources().getColor(2131167190);; i = getResources().getColor(2131167026))
        {
          ((TextView)localObject).setTextColor(i);
          break;
        }
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    label456:
    this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
  }
  
  private void n()
  {
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131379078);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131379020));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName + " " + getResources().getString(2131690784));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131369278));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690784));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131369231));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131694466) + getString(2131690673));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369245));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131691099));
  }
  
  private void o()
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
  
  private void p()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131363792));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131377567));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131366013));
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {}
    for (int i = 1;; i = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        bhbu.a("grpProfile", "grpProfile_exp", "edit_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693174);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(4));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      bhbu.a("grpProfile", "grpProfile_exp", "share_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      bhbu.a("grpProfile", "grpProfile_exp", "message_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      return;
    }
    if (i != 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131693237, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopNeedPayNumber) }));
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(3));
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    if ("true".equals(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693406);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(5));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
      return;
    }
    if (this.jdField_e_of_type_Int == 2) {
      bgef.a(18, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    bhbu.a("grpProfile", "grpProfile_exp", "join_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131699023);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(6));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
    TroopUtils.secRecognize(true, this.jdField_a_of_type_AndroidWidgetButton);
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFlagExt4(3)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFreezeReason(2)))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void r()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter = new AvatarWallViewPagerAdapter(new WeakReference(getActivity()), this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager, getResources().getDisplayMetrics().widthPixels, UIUtils.dip2px(getActivity(), 212.0F), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, null, "Grp_Admin_data");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnPageChangeListener(new bgdw(this));
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorTroopCardFragment.Activity", 2, String.format("updateTitle mStatusBarShow=%b", new Object[] { Boolean.valueOf(this.jdField_d_of_type_Boolean) }));
    }
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.jdField_d_of_type_Boolean) || (bool) || (b())) {}
    for (int i = 2131167023;; i = 2131167026)
    {
      int k = getResources().getColor(i);
      int j = 2130843770;
      i = j;
      if (this.jdField_d_of_type_Boolean)
      {
        i = j;
        if (!bool) {
          i = 2130840365;
        }
      }
      Drawable localDrawable = getResources().getDrawable(2130850724);
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
  private void t()
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new bgdx(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    try
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(((SkinnableNinePatchDrawable)getResources().getDrawable(2130850375)).getBitmap());
      localBitmapDrawable.setAlpha(220);
      this.jdField_d_of_type_AndroidViewView.setBackground(localBitmapDrawable);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      localClassCastException.printStackTrace();
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_Bgdy == null) {}
    do
    {
      return;
      Drawable localDrawable = this.jdField_a_of_type_Bgdy.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      if ((b()) && (!bdfk.a()))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130848349);
        int i = AIOUtils.dp2px(1.3F, getResources());
        this.jdField_b_of_type_AndroidWidgetImageView.setPadding(i, i, i, i);
      }
    } while ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void v()
  {
    try
    {
      if (this.jdField_a_of_type_Bgua != null) {
        this.jdField_a_of_type_Bgua.e();
      }
      this.jdField_a_of_type_Bgua = new bgua(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      this.jdField_a_of_type_Bgua.f();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  private void w()
  {
    Bundle localBundle = TroopInfoActivity.a(this.jdField_d_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
    localBundle.putInt("troop_type_ex", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt);
    localBundle.putString("leftViewText", getString(2131719629));
    localBundle.putInt("troop_auth_submit_time", getActivity().getIntent().getIntExtra("troop_auth_submit_time", 0));
    localBundle.putInt("troop_info_report_from", 4);
    localBundle.putInt("PARAM_EXIT_ANIMATION", 2);
    TroopInfoActivity.a(getActivity(), localBundle, 5);
    getActivity().overridePendingTransition(2130771981, 2130771980);
  }
  
  private void x()
  {
    bgef.a(7, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption() == 40002) {
      str = "3_40002";
    }
    for (;;)
    {
      ajfq.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, str);
      bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption() == 40001) {
        str = "3_40001";
      }
    }
  }
  
  private void y()
  {
    TroopUtils.calJoinTroop(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, TroopUtils.mExposureSource, this.jdField_d_of_type_Int, 2);
    if (!NetworkUtil.isNetSupport(getActivity())) {
      TroopUtils.notifyUser(getActivity(), getActivity().getTitleBarHeight(), 2131694253, 1);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Bgdy != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VisitorTroopCardFragment.Activity", 2, "mVisitorPresenter is null");
    return;
    this.jdField_a_of_type_Bgdy.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 8390784);
    if (super.getActivity().getIntent().getBooleanExtra("from_babyq", false)) {
      bgef.a(14, new Object());
    }
    bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
  }
  
  private void z()
  {
    bkzi localbkzi = (bkzi)bkzz.a(getActivity(), null);
    localbkzi.a(new bkzh(anvx.a(2131701227), 7, 0), 5);
    localbkzi.c(2131690697);
    localbkzi.a(new bgdh(this, localbkzi));
    if (!localbkzi.isShowing()) {
      localbkzi.show();
    }
  }
  
  public void a()
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a();
    if (QLog.isColorLevel()) {
      QLog.i("VisitorTroopCardFragment.Activity", 2, "updateTroopAvatarWall size=" + localList.size());
    }
    LinearLayout.LayoutParams localLayoutParams;
    int j;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
      j = getResources().getDisplayMetrics().widthPixels;
      if (localList.size() <= 0) {
        break label209;
      }
      i = akln.a(j);
    }
    for (;;)
    {
      localLayoutParams.width = j;
      localLayoutParams.height = i;
      this.jdField_e_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      if ((b()) && (this.jdField_f_of_type_AndroidViewView != null))
      {
        this.jdField_f_of_type_AndroidViewView.setBackgroundDrawable(null);
        this.jdField_f_of_type_AndroidViewView.setPadding(this.jdField_f_of_type_AndroidViewView.getPaddingLeft(), this.jdField_f_of_type_AndroidViewView.getPaddingTop(), this.jdField_f_of_type_AndroidViewView.getPaddingRight(), this.jdField_f_of_type_AndroidViewView.getPaddingBottom() + AIOUtils.dp2px(6.0F, getResources()));
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setVisibility(0);
        if (this.jdField_d_of_type_Boolean) {
          this.jdField_d_of_type_Boolean = false;
        }
      }
      for (;;)
      {
        this.jdField_d_of_type_Boolean = false;
        s();
        return;
        label209:
        if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_f_of_type_AndroidViewView == null)) {
          break label294;
        }
        this.jdField_a_of_type_AndroidViewView.measure(0, 0);
        this.jdField_f_of_type_AndroidViewView.measure(0, 0);
        i = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + this.jdField_f_of_type_AndroidViewView.getMeasuredHeight();
        this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130839496);
        break;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setVisibility(8);
        if (!this.jdField_d_of_type_Boolean) {
          this.jdField_d_of_type_Boolean = true;
        }
      }
      label294:
      i = 0;
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt > 0) && (this.jdField_a_of_type_Bgas != null)) {
      this.jdField_a_of_type_Bgas.a();
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
    if (this.jdField_a_of_type_Biso == null) {
      this.jdField_a_of_type_Biso = new biso(getActivity());
    }
    this.jdField_a_of_type_Biso.b(2, 2131692035, 1500);
    getActivity().finish();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    if ((1 == paramInt1) && ((getActivity().isResume()) || ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)) || (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))))
    {
      d();
      if (this.jdField_a_of_type_Biso == null) {
        this.jdField_a_of_type_Biso = new biso(getActivity());
      }
      switch (paramInt2)
      {
      case -1: 
      default: 
        this.jdField_a_of_type_Biso.b(2, 2131693399, 1500);
      }
    }
    label371:
    do
    {
      for (;;)
      {
        return;
        ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(Long.parseLong(paramString), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
        return;
        this.jdField_a_of_type_Biso.b(2, 2131693400, 1500);
        getActivity().finish();
        a(true);
        TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
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
              break label371;
            }
          }
          for (;;)
          {
            QLog.d("VisitorTroopCardFragment.Activity", 2, bool + " : " + paramString);
            if (localObject1 != null) {
              break label411;
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
            this.jdField_a_of_type_Biso.b(2, 2131719621, 1500);
            return;
            if (getActivity().isResume())
            {
              if (paramInt1 != 3) {
                break;
              }
              if (paramInt2 == 0)
              {
                paramString = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                if (paramString == null) {}
                for (paramString = null;; paramString = paramString.b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin))
                {
                  if ((paramString == null) || (paramString.wMemberNum == this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum)) {
                    break label583;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopAdmMemberNum(paramString.Administrator, paramString.wMemberNum, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), getResources());
                  if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView == null) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.a(anvx.a(2131701251) + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + anvx.a(2131701253));
                  return;
                }
              }
            }
          }
        }
      }
    } while (((paramInt1 != 2) && (paramInt1 != 9)) || (paramInt2 != 0));
    label411:
    label583:
    paramString = new Intent();
    paramString.putExtra("isNeedFinish", true);
    getActivity().setResult(-1, paramString);
    getActivity().finish();
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    String str2 = bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    if (paramInt == -1) {}
    for (Object localObject = "0";; localObject = "1")
    {
      bhbu.a("Grp_share", "grpData_admin", "share_qq", 0, 0, new String[] { str1, str2, localObject });
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
    QQToast.a(getActivity(), getString(2131695813), 1).b(getActivity().getTitleBarHeight());
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
        J();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        u();
      }
      if (QLog.isColorLevel())
      {
        i = paramGroupInfo.uint32_group_flagext3.get();
        StringBuilder localStringBuilder = new StringBuilder().append("ChatSettingForToop_handle88dResp, troopUin=");
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
          break label382;
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
          break label394;
        }
        i = 1;
        label231:
        new bdlf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_private").c("Grp_data").d("exp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(i) }).a();
      }
      m();
      if (this.jdField_e_of_type_Boolean) {
        break label429;
      }
    }
    for (;;)
    {
      d(bool);
      k();
      H();
      I();
      q();
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
      label382:
      str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
      break;
      label394:
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
      label429:
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
    e(null);
    return;
    b(2131718500, 1);
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
    bfxi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramLong, getActivity());
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin.equals(paramString1)))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTags = TroopInfo.getTags(paramString2);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setTroopInfoData(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.b();
    }
  }
  
  public void a(boolean paramBoolean, List<akjf> paramList)
  {
    if (paramBoolean) {
      u();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a(paramList))) {
      return;
    }
    u();
    a();
    k();
  }
  
  boolean a()
  {
    bfck localbfck = (bfck)aqxe.a().a(686);
    if ((localbfck != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)) {
      return (localbfck.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasTroopAssociation());
    }
    return false;
  }
  
  public void b()
  {
    getActivity().runOnUiThread(new VisitorTroopCardFragment.22(this));
  }
  
  public void b(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    bghd.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "join");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    TroopUtils.notifyUser(getActivity(), getActivity().getTitleBarHeight(), paramInt1, paramInt2);
  }
  
  public void b(String paramString)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
      u();
    }
  }
  
  void b(boolean paramBoolean)
  {
    Object localObject = (bfck)aqxe.a().a(686);
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (!((bfck)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData))) {
      break label35;
    }
    label35:
    while ((this.jdField_a_of_type_Bfcm != null) && (!paramBoolean)) {
      return;
    }
    if (this.jdField_a_of_type_Bfcm == null) {
      this.jdField_a_of_type_Bfcm = new bfcm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
    }
    localObject = this.jdField_a_of_type_Bfcm;
    if ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasTroopAssociation())) {}
    for (boolean bool = true;; bool = false)
    {
      ((bfcm)localObject).a(bool);
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
      if (this.jdField_a_of_type_Bisl == null)
      {
        this.jdField_a_of_type_Bisl = new bisl(getActivity(), getActivity().getTitleBarHeight());
        this.jdField_a_of_type_Bisl.c(2131694477);
        this.jdField_a_of_type_Bisl.c(false);
      }
      this.jdField_a_of_type_Bisl.show();
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
    g(paramString);
  }
  
  public void d()
  {
    try
    {
      if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
        this.jdField_a_of_type_Bisl.dismiss();
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
    if (!getActivity().isResume()) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      QQToast.a(getActivity(), 2, 2131718060, 1).b(getActivity().getTitleBarHeight());
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
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity() == null) || (getActivity().app == null)) {}
    do
    {
      return;
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.titleRoot.setFitsSystemWindows(false);
        this.titleRoot.setPadding(0, 0, 0, 0);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = getActivity().app;
      hideTitleBar();
      a(getActivity().getIntent().getExtras());
      i();
      TroopUtils.preloadWebProcess(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      bhbu.a("grpProfile", "grpProfile_exp", "grpProfile_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      bhbu.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
      nvs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 65);
      paramLayoutInflater = new IntentFilter();
      paramLayoutInflater.addAction("start_recomend_page");
      paramLayoutInflater.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramLayoutInflater);
    } while (this.jdField_a_of_type_Aofu == null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Bgdy != null)
    {
      c();
      this.jdField_a_of_type_Bgdy.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
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
      bgef.a(15, new Object[] { localObject2, localObject1 });
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember;
      localObject1 = bgap.a();
      if (((bool2) && ((localObject1 == null) || (!((bgaq)localObject1).jdField_a_of_type_Boolean))) || (a())) {
        break label346;
      }
      bool1 = true;
      if ((localObject1 == null) || (TextUtils.isEmpty(((bgaq)localObject1).jdField_a_of_type_JavaLangString))) {
        break label351;
      }
      localObject1 = ((bgaq)localObject1).jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "checkAndInitRecommendList,hasJoinedTroop = " + bool2 + ",displayOrNot = " + bool1 + ",recoomTips = " + (String)localObject1);
      }
      if (this.jdField_a_of_type_Bgas == null)
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
      bgef.a(16, new Object[] { str, localObject2 });
      localObject2 = new TextView(getActivity());
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextColor(getResources().getColor(2131166996));
      ((TextView)localObject2).setTextSize(2, 16.0F);
      ((TextView)localObject2).setPadding(AIOUtils.dp2px(16.0F, getResources()), AIOUtils.dp2px(13.0F, getResources()), 0, AIOUtils.dp2px(5.0F, getResources()));
      ((TextView)localObject2).setClickable(false);
      localObject1 = View.inflate(getActivity(), 2131561603, null);
      ((View)localObject1).setBackgroundResource(2130850739);
      this.jdField_a_of_type_Bgas = new bgas(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentWidgetXListView, null, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bool1, (TextView)localObject2, (View)localObject1);
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
    return 2131563058;
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
          u();
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
    case 4: 
      b(true);
      return;
    }
    h();
  }
  
  public boolean onBackEvent()
  {
    G();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = 1;
    if (UIUtils.isFastDoubleClick()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363792: 
        if ((!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) || (!TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {}
      case 2131379425: 
      case 2131368063: 
      case 2131369231: 
      case 2131369245: 
      case 2131381206: 
        for (;;)
        {
          if (i == 0) {
            break label452;
          }
          c();
          ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(Long.valueOf(this.jdField_d_of_type_JavaLangString).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()).longValue(), this.jdField_b_of_type_JavaLangString);
          break;
          localObject = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_d_of_type_JavaLangString });
          Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
          localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
          localIntent.putExtra("url", (String)localObject);
          super.startActivity(localIntent);
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
            a(false, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
          }
          for (;;)
          {
            bgef.a(3, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner), Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) });
            break;
            if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (this.jdField_a_of_type_Bgdy != null)) {
              this.jdField_a_of_type_Bgdy.d();
            }
          }
          G();
          getActivity().finish();
          break;
          A();
          bhbu.a("grpProfile", "grpProfile_clk", "more_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
          {
            z();
            break;
          }
          a(true, false);
          break;
          i = 0;
        }
        a(((Integer)paramView.getTag()).intValue(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
      case 2131366013: 
        bhbu.a("grpProfile", "grpProfile_clk", "edit_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        w();
        break;
      case 2131377567: 
        C();
        bhbu.a("grpProfile", "grpProfile_clk", "share_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        break;
      case 2131379524: 
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum > this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum) {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {}
        for (i = 0;; i = 1)
        {
          localObject = new Intent(getActivity(), PublicAccountBrowser.class);
          ((Intent)localObject).putExtra("hide_operation_bar", true);
          ((Intent)localObject).putExtra("hideRightButton", true);
          ((Intent)localObject).putExtra("isScreenOrientationPortrait", true);
          ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          ((Intent)localObject).putExtra("url", "https://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&role=1&group_level=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade + "&group_mem_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "&group_active_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum + "&show_level=" + i);
          startActivity((Intent)localObject);
          bhbu.a("grpProfile", "grpProfile_clk", "grpLevel_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          nvs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 72);
          break;
        }
      case 2131369576: 
        bhbu.a("grpProfile", "grpProfile_clk", "QRcode_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        v();
        break;
      case 2131379622: 
        label452:
        bhbu.a("grpProfile", "grpProfile_clk", "grpNumber_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        B();
      }
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
      if (this.jdField_a_of_type_Aofu != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      }
      this.jdField_f_of_type_Boolean = true;
      if (this.jdField_a_of_type_Bgdy != null)
      {
        this.jdField_a_of_type_Bgdy.a();
        this.jdField_a_of_type_Bgdy = null;
      }
      if (this.jdField_a_of_type_Bfcm != null) {
        this.jdField_a_of_type_Bfcm.b();
      }
      if (this.jdField_a_of_type_Bgas != null) {
        this.jdField_a_of_type_Bgas.c();
      }
      if (this.jdField_a_of_type_Bgua != null) {
        this.jdField_a_of_type_Bgua.e();
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
    if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_Bgdy != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VisitorTroopCardFragment.Activity", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.jdField_a_of_type_Bgdy.a(str, paramIntent);
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
          break label149;
        }
      }
    }
    label149:
    for (String str1 = "1";; str1 = "0")
    {
      bhbu.a("Grp_set_new", "grpData_visitor", "exp", 0, 0, new String[] { str2, str1 });
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      s();
      return;
      i = 0;
      break;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Bgdy != null)
    {
      this.jdField_a_of_type_Bgdy.a(null, false);
      this.jdField_a_of_type_Bgdy.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
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
    if ((paramBoolean) && (!this.jdField_h_of_type_Boolean))
    {
      this.jdField_h_of_type_Boolean = true;
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment
 * JD-Core Version:    0.7.0.1
 */