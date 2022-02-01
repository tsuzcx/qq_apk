package com.tencent.mobileqq.troop.troopCard;

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
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopNotificationUtils;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyHelper;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyHelper.OnTroopSafeDialogClickConfirm;
import com.tencent.mobileqq.activity.photo.AvatarInfo;
import com.tencent.mobileqq.activity.photo.TroopPhotoUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.LiangGroupHelper;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.api.essence.ITroopEssenceService;
import com.tencent.mobileqq.troop.associations.TroopAssociationsEntryConfig;
import com.tencent.mobileqq.troop.associations.TroopAssociationsListWrapper;
import com.tencent.mobileqq.troop.associations.TroopAssociationsListWrapper.ICallbacks;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgEntryInCardConfig;
import com.tencent.mobileqq.troop.jointroopsecuritytips.JoinTroopSecurityTipsHelper;
import com.tencent.mobileqq.troop.observer.TroopApiObserver;
import com.tencent.mobileqq.troop.recommend.TDCRecomTroopConfigProcessor;
import com.tencent.mobileqq.troop.recommend.TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean;
import com.tencent.mobileqq.troop.recommend.TroopDataCardRecomTroopListWrapper;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPager;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.troop.widget.TroopEssenceMsgView;
import com.tencent.mobileqq.troop.widget.TroopMoreDetailView;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopshare.TroopShareUtility;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.theme.SkinnableNinePatchDrawable;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.util.WeakReference;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class VisitorTroopCardFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, TroopAssociationsListWrapper.ICallbacks, IVisitorTroopCardViewInterface
{
  protected int a;
  private long jdField_a_of_type_Long = 0L;
  protected BroadcastReceiver a;
  private Intent jdField_a_of_type_AndroidContentIntent = null;
  protected View a;
  protected AlphaAnimation a;
  protected Animation.AnimationListener a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  private TroopNotifyHelper.OnTroopSafeDialogClickConfirm jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyHelper$OnTroopSafeDialogClickConfirm = new VisitorTroopCardFragment.12(this);
  public QQAppInterface a;
  protected TroopBusinessObserver a;
  protected TroopInfo a;
  private TroopAssociationsListWrapper jdField_a_of_type_ComTencentMobileqqTroopAssociationsTroopAssociationsListWrapper;
  protected TroopApiObserver a;
  private TroopDataCardRecomTroopListWrapper jdField_a_of_type_ComTencentMobileqqTroopRecommendTroopDataCardRecomTroopListWrapper;
  private VisitorTroopCardPresenter jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter;
  private AvatarWallViewPager jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager;
  private AvatarWallViewPagerAdapter jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter;
  protected ExpandableTextView a;
  protected TroopEssenceMsgView a;
  protected TroopMoreDetailView a;
  protected TroopInfoData a;
  protected TroopShareUtility a;
  protected QQCustomDialog a;
  protected QQBlurView a;
  protected QQProgressDialog a;
  private QQProgressNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected ImmersiveTitleBar2 a;
  protected String a;
  protected boolean a;
  protected int b;
  protected View b;
  protected AlphaAnimation b;
  protected Button b;
  protected ImageView b;
  protected TextView b;
  protected String b;
  public boolean b;
  protected int c;
  protected View c;
  protected Button c;
  protected ImageView c;
  protected TextView c;
  protected String c;
  protected boolean c;
  protected int d;
  protected View d;
  protected ImageView d;
  protected TextView d;
  protected String d;
  public boolean d;
  protected int e;
  private View jdField_e_of_type_AndroidViewView;
  protected ImageView e;
  protected TextView e;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int;
  private View jdField_f_of_type_AndroidViewView;
  protected ImageView f;
  protected TextView f;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = 2;
  protected TextView g;
  private boolean jdField_g_of_type_Boolean = false;
  protected TextView h;
  private boolean h;
  private boolean i;
  
  public VisitorTroopCardFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = new TroopInfoData();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new VisitorTroopCardFragment.1(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new VisitorTroopCardFragment.7(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopApiObserver = new VisitorTroopCardFragment.10(this);
    this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver = new VisitorTroopCardFragment.11(this);
  }
  
  private void A()
  {
    TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, TroopUtils.jdField_a_of_type_Int, this.jdField_d_of_type_Int, 2);
    if (!NetworkUtil.d(getActivity())) {
      TroopUtils.a(getActivity(), getActivity().getTitleBarHeight(), 2131694457, 1);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VisitorTroopCardFragment.Activity", 2, "mVisitorPresenter is null");
    return;
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 8390784);
    if (super.getActivity().getIntent().getBooleanExtra("from_babyq", false)) {
      VisitorTroopCardReport.a(14, new Object());
    }
    TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
  }
  
  private void B()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    localActionSheet.addButton(new ActionMenuItem(HardCodeUtil.a(2131701802), 7, 0), 5);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new VisitorTroopCardFragment.13(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void C()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    if (!c()) {
      localActionSheet.addButton(new ActionMenuItem(getString(2131696180), 9, 0), 5);
    }
    localActionSheet.addButton(new ActionMenuItem(ActionSheetHelper.a(getActivity(), 2131718548), 10, 0), 5);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new VisitorTroopCardFragment.14(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void D()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (!c())) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
    {
      str = getString(2131699356);
      label47:
      localActionSheet.setMainTitle(str);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
        break label152;
      }
      str = getString(2131699357);
      label69:
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) {
        break label163;
      }
    }
    label152:
    label163:
    for (int j = 12;; j = 9)
    {
      localActionSheet.addButton(new ActionMenuItem(str, j, 0), 5);
      localActionSheet.addCancelButton(2131690800);
      localActionSheet.setOnBottomCancelListener(new VisitorTroopCardFragment.15(this, localActionSheet));
      localActionSheet.setOnButtonClickListener(new VisitorTroopCardFragment.16(this, localActionSheet));
      if (localActionSheet.isShowing()) {
        break;
      }
      localActionSheet.show();
      return;
      str = getString(2131699359);
      break label47;
      str = getString(2131699358);
      break label69;
    }
  }
  
  private void E()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.e();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility = TroopUtils.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void F()
  {
    Object localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject == null)
    {
      localObject = null;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
        break label107;
      }
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) == 0L) && ((this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter.jdField_a_of_type_Int == 0))) {
        break label100;
      }
      H();
    }
    for (;;)
    {
      VisitorTroopCardReport.a(21, new Object());
      return;
      localObject = ((TroopManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      break;
      label100:
      G();
      continue;
      label107:
      localObject = ActionSheet.create(getActivity());
      ((ActionSheet)localObject).setMainTitle(2131691156);
      ((ActionSheet)localObject).addButton(2131692161, 3);
      ((ActionSheet)localObject).setOnButtonClickListener(new VisitorTroopCardFragment.17(this, (ActionSheet)localObject));
      ((ActionSheet)localObject).addCancelButton(getString(2131690800));
      ((ActionSheet)localObject).show();
    }
  }
  
  private void G()
  {
    String str = getString(2131691150);
    ActionSheet localActionSheet = ActionSheet.create(getActivity());
    localActionSheet.setMainTitle(str);
    localActionSheet.addButton(getString(2131691149), 3);
    localActionSheet.addCancelButton(getString(2131690800));
    localActionSheet.setOnButtonClickListener(new VisitorTroopCardFragment.18(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void H()
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131755842);
    localReportDialog.setContentView(2131561170);
    ((TextView)localReportDialog.findViewById(2131365845)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365832);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365830);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365836);
    String str = HardCodeUtil.a(2131701805);
    localTextView1.setText(getString(2131691151, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694615);
    localTextView3.setText(2131690800);
    localReportDialog.setCanceledOnTouchOutside(false);
    localTextView2.setOnClickListener(new VisitorTroopCardFragment.19(this, localReportDialog));
    localTextView3.setOnClickListener(new VisitorTroopCardFragment.20(this, localReportDialog));
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
  
  private void I()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) && (getActivity().getIntent().getBooleanExtra("from_newer_guide", false)))
    {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    Intent localIntent2 = this.jdField_a_of_type_AndroidContentIntent;
    Intent localIntent1 = localIntent2;
    if (this.jdField_h_of_type_Boolean)
    {
      localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      localIntent1.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
      this.jdField_h_of_type_Boolean = false;
    }
    getActivity().setResult(-1, localIntent1);
  }
  
  private void J()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView == null) {
      return;
    }
    m();
  }
  
  private void K()
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isShowActivityGrade()) {
      j = 0;
    }
    if (j > 0)
    {
      Object localObject = String.format(getResources().getString(2131693432), new Object[] { Integer.valueOf(j) });
      this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      localObject = this.jdField_f_of_type_AndroidWidgetTextView;
      if (b())
      {
        j = getResources().getColor(2131167197);
        ((TextView)localObject).setTextColor(j);
      }
    }
    for (;;)
    {
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
      return;
      j = getResources().getColor(2131167033);
      break;
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void L()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = HardCodeUtil.a(2131701803);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_c_of_type_AndroidWidgetTextView.setClickable(false);
    localObject2 = this.jdField_c_of_type_AndroidWidgetTextView;
    if (b()) {}
    for (int j = getResources().getColor(2131167197);; j = getResources().getColor(2131167033))
    {
      ((TextView)localObject2).setTextColor(j);
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131701791) + (String)localObject1);
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
        VisitorTroopCardReport.a(5, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      }
      paramInt = getActivity().getIntent().getIntExtra("extra_share_group_from", 0);
      if (paramInt != 0) {
        StoryReportor.a("story_grp", "clk_msg", paramInt, 0, new String[0]);
      }
      TroopReportor.a("grpProfile", "grpProfile_clk", "message_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
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
            z();
            return;
          }
          if (paramInt == 5)
          {
            TroopUtils.a(paramQQAppInterface, getActivity(), getActivity().getIntent(), this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback);
            VisitorTroopCardReport.a(8, new Object());
            TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
            return;
          }
        } while (paramInt != 6);
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_Long <= 1000L);
      this.jdField_a_of_type_Long = l;
      y();
      TroopReportor.a("grpProfile", "grpProfile_clk", "join_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.pa != 34) {
        break label290;
      }
      if (!ExtendFriendManager.a(paramQQAppInterface.getCurrentAccountUin())) {
        break;
      }
      paramQQAppInterface = ProfileGuideDialogUtils.a(getActivity());
    } while (getActivity().isFinishing());
    paramQQAppInterface.show();
    VisitorTroopCardReport.a(11, new Object());
    return;
    VisitorTroopCardReport.a(12, new Object());
    label290:
    TroopUtils.a(false, null);
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {}
    for (String str1 = "1";; str1 = "0")
    {
      VisitorTroopCardReport.a(13, new Object[] { str2, str1 });
      if ((this.jdField_c_of_type_Int != 0) || ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption != 1) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))) {
        break label395;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isHomeworkTroop()) {
        break;
      }
      b(1);
      return;
    }
    e();
    return;
    label395:
    ((TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(Long.valueOf(this.jdField_e_of_type_JavaLangString).longValue(), Long.valueOf(paramQQAppInterface.getCurrentUin()).longValue(), this.jdField_b_of_type_JavaLangString);
  }
  
  private void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData = TroopUtils.a(paramBundle, getActivity());
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData, getActivity());
    TroopUtils.jdField_a_of_type_Int = paramBundle.getInt("exposureSource", 99);
    this.jdField_d_of_type_Int = paramBundle.getInt("filter_id", -1);
    this.jdField_e_of_type_Int = paramBundle.getInt("D2GType");
    this.jdField_c_of_type_Boolean = paramBundle.getBoolean("fromThirdAppByOpenSDK");
    this.jdField_d_of_type_JavaLangString = getActivity().getIntent().getStringExtra("is_from_game");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("authKey");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("authSig");
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("keyword");
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("isFromNative", false);
    this.jdField_d_of_type_Boolean = paramBundle.getBoolean("troop_info_from_troopsetting", false);
    this.jdField_f_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isQidianPrivateTroop;
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter = new VisitorTroopCardPresenter();
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter.a(this);
    paramBundle = getActivity().getIntent().getStringExtra("appid");
    String str1 = getActivity().getIntent().getStringExtra("openid");
    String str2 = getActivity().getIntent().getStringExtra("share_uin");
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter.a(paramBundle, str1, str2);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 2;
    Object localObject1 = QVipBigTroopExpiredProcessor.c();
    if ((paramBoolean2) && (((QVipBigTroopExpiredConfig)localObject1).mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()))
    {
      paramBoolean1 = TroopManager.LiangGroupHelper.c(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.groupFreezeReason);
      int j;
      if (paramBoolean1)
      {
        j = 15;
        localObject1 = VipUtils.a(0, j);
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
        String str2 = HardCodeUtil.a(2131715516);
        VisitorTroopCardFragment.21 local21 = new VisitorTroopCardFragment.21(this, paramBoolean1);
        if (!paramBoolean1) {
          break label183;
        }
        localObject2 = "0X800A57F";
        label131:
        j = k;
        if (paramBoolean1) {
          j = 1;
        }
        VipUtils.a(localFragmentActivity, str1, (String)localObject1, str2, local21, (String)localObject2, j, paramBoolean1);
      }
      for (;;)
      {
        VisitorTroopCardReport.a(1, new Object());
        return;
        j = 8;
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
      localObject2 = AnimationUtils.a(this.jdField_b_of_type_AndroidWidgetImageView);
      if (localObject2 != null) {
        ((Bundle)localObject1).putParcelable("KEY_THUMBNAL_BOUND", (Parcelable)localObject2);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter.a((Bundle)localObject1, c());
    }
    VisitorTroopCardReport.a(4, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    if (c()) {}
    for (localObject1 = "1";; localObject1 = "0")
    {
      TroopReportor.a("Grp_set_new", "grpData_visitor", "clk_head", 0, 0, new String[] { localObject2, localObject1 });
      return;
    }
  }
  
  private boolean a(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  private boolean a(boolean paramBoolean, int paramInt)
  {
    int j;
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {
      j = 1;
    }
    while (j != 0)
    {
      d();
      if ((paramBoolean) && (paramInt != 0))
      {
        TroopNotifyHelper.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyHelper$OnTroopSafeDialogClickConfirm, new Object[0]);
        return true;
        j = 0;
      }
      else
      {
        z();
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
      ImmersiveUtils.setStatusTextColor(bool1, getActivity().getWindow());
      if (paramBoolean) {
        SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, getActivity().getWindow());
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
        TroopReportor.a("grpProfile", "grpProfile_exp", "grpNumberr_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      }
    }
    localObject = this.jdField_d_of_type_AndroidWidgetTextView;
    if (b()) {}
    for (int j = getResources().getColor(2131167197);; j = getResources().getColor(2131167033))
    {
      ((TextView)localObject).setTextColor(j);
      return;
    }
  }
  
  private void e(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (this.jdField_b_of_type_Int == 1))
    {
      if (this.jdField_c_of_type_Int != 0)
      {
        TroopNotifyHelper.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyHelper$OnTroopSafeDialogClickConfirm, new Object[0]);
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
      int j = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption();
      if ((this.jdField_e_of_type_Int == 1) || (this.jdField_e_of_type_Int == 2)) {
        j = 18;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark))
      {
        startActivity(AddFriendLogicActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, j, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.remark, getResources().getString(2131690889), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString));
        return;
      }
      paramString = AddFriendLogicActivity.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption, j, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mStrJoinAnswer, null, getResources().getString(2131690889), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString);
      paramString.putExtra("from_newer_guide", getActivity().getIntent().getBooleanExtra("from_newer_guide", false));
      paramString.putExtra("from_babyq", getActivity().getIntent().getBooleanExtra("from_babyq", false));
      startActivityForResult(paramString, 1);
      return;
    }
    b(2131720199, 0);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      Drawable localDrawable = getResources().getDrawable(2130839545);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131298132));
      ((Animatable)localDrawable).start();
    }
    if (!NetworkUtil.g(getActivity())) {
      QQToast.a(getActivity(), 1, getString(2131694459), 1).b(getActivity().getTitleBarHeight());
    }
    ThreadManager.post(new VisitorTroopCardFragment.2(this), 8, null, false);
    p();
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new VisitorTroopCardFragment.3(this));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void g(String paramString)
  {
    getActivity().runOnUiThread(new VisitorTroopCardFragment.22(this, paramString));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateForTroopInfo(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    a();
    v();
    L();
    n();
    r();
    K();
    m();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.b();
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.mContentView.findViewById(2131379533));
    this.jdField_d_of_type_AndroidViewView = this.mContentView.findViewById(2131363973);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.mContentView.findViewById(2131363792));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.mContentView.findViewById(2131365157));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
    int k = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
    int m = getResources().getDimensionPixelOffset(2131297098);
    this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(j, 0, k, m);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getActivity());
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.mContentView.setBackgroundResource(2130838979);
    o();
    j();
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    u();
    q();
  }
  
  @SuppressLint({"NewApi"})
  private void j()
  {
    Object localObject = View.inflate(getActivity(), 2131559991, null);
    this.jdField_e_of_type_AndroidViewView = ((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager = ((AvatarWallViewPager)((View)localObject).findViewById(2131381672));
    this.jdField_f_of_type_AndroidViewView = ((View)localObject).findViewById(2131374310);
    s();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    a();
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131374172));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131380006));
    r();
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131380045));
    n();
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379947));
    K();
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368281));
    ((View)localObject).setContentDescription(getResources().getString(2131699355));
    if (SimpleUIUtil.a()) {
      ((View)localObject).setBackground(null);
    }
    v();
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379987));
    L();
    LongClickCopyAction.attachCopyAction(this.jdField_c_of_type_AndroidWidgetTextView, HardCodeUtil.a(2131715525));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131380048));
    d(true);
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131379848));
    k();
    localObject = HardCodeUtil.a(2131691375);
    String str = this.jdField_d_of_type_AndroidWidgetTextView.getText().toString();
    localObject = LongClickCopyAction.attachCopyAction(this.jdField_d_of_type_AndroidWidgetTextView, (String)localObject, str);
    if (localObject != null) {
      ((LongClickCopyAction)localObject).setCopyListener(new VisitorTroopCardFragment.4(this));
    }
    this.jdField_b_of_type_AndroidViewView = View.inflate(getActivity(), 2131561684, null);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131380672));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369846));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_b_of_type_AndroidViewView);
    l();
    this.jdField_c_of_type_AndroidViewView = View.inflate(getActivity(), 2131560805, null);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView = ((ExpandableTextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131366475));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131369684));
    m();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setOnExpandStateChangeListener(new VisitorTroopCardFragment.5(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
    localObject = View.inflate(getActivity(), 2131561722, null);
    ((View)localObject).setBackgroundResource(2130851165);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298131);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView = new TroopMoreDetailView(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.setGuestVisitor(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView);
    localObject = View.inflate(getActivity(), 2131561722, null);
    ((View)localObject).setBackgroundResource(2130851165);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298131);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopEssenceMsgView = new TroopEssenceMsgView(getActivity());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopEssenceMsgView);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorTroopCardFragment.Activity", 2, "mLinearLayoutContentView.addView mTroopEssenceMsgView");
    }
  }
  
  private void k()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800) != 0L) && ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwAuthGroupType == 2L) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwAuthGroupType == 1L)))
    {
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
      return;
    }
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void l()
  {
    Object localObject;
    if (b()) {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130846513);
        localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        this.jdField_b_of_type_AndroidViewView.measure(0, 0);
        ((LinearLayout.LayoutParams)localObject).height = (this.jdField_b_of_type_AndroidViewView.getMeasuredHeight() + AIOUtils.a(6.0F, getResources()));
        if (!b()) {
          break label165;
        }
      }
    }
    label165:
    for (float f1 = -6.0F;; f1 = 0.0F)
    {
      ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.a(f1, getResources());
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopCreateTime);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(new QQText((CharSequence)localObject, 11, 16));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      return;
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839076);
      break;
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130839575);
      break;
    }
  }
  
  private void m()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo))
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130839575);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setText(new QQText(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mRichFingerMemo, 11, 16));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.post(new VisitorTroopCardFragment.6(this));
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void n()
  {
    int k = 8;
    if (this.jdField_f_of_type_Boolean)
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
    for (int j = 1;; j = 0)
    {
      Object localObject = this.jdField_h_of_type_AndroidWidgetTextView;
      if (j != 0) {
        k = 0;
      }
      ((TextView)localObject).setVisibility(k);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) || (j == 0)) {
        break label456;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131693387, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopNeedPayNumber) }));
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
        localObject = "（" + getString(2131696261) + "）";
        this.jdField_g_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        localObject = this.jdField_g_of_type_AndroidWidgetTextView;
        if (b()) {}
        for (j = getResources().getColor(2131167197);; j = getResources().getColor(2131167033))
        {
          ((TextView)localObject).setTextColor(j);
          break;
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 3) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt == 4))
      {
        localObject = "（" + getString(2131696261) + "）";
        this.jdField_g_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        localObject = this.jdField_g_of_type_AndroidWidgetTextView;
        if (b()) {}
        for (j = getResources().getColor(2131167197);; j = getResources().getColor(2131167033))
        {
          ((TextView)localObject).setTextColor(j);
          break;
        }
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    label456:
    this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131379512);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.mContentView.findViewById(2131379451));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName + " " + getResources().getString(2131690889));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131369534));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690889));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131369487));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131694683) + getString(2131690775));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.mContentView.findViewById(2131369501));
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131691206));
  }
  
  private void p()
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
  
  private void q()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131363891));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131377978));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.mContentView.findViewById(2131366178));
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512))) {}
    for (int j = 1;; j = 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
      {
        TroopReportor.a("grpProfile", "grpProfile_exp", "edit_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693324);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(4));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      TroopReportor.a("grpProfile", "grpProfile_exp", "share_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      TroopReportor.a("grpProfile", "grpProfile_exp", "message_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
      return;
    }
    if (j != 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131693387, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopNeedPayNumber) }));
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(3));
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    if ("true".equals(this.jdField_d_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693558);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(5));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
      return;
    }
    if (this.jdField_e_of_type_Int == 2) {
      VisitorTroopCardReport.a(18, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    }
    TroopReportor.a("grpProfile", "grpProfile_exp", "join_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131699369);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(6));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
    TroopUtils.a(true, this.jdField_a_of_type_AndroidWidgetButton);
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFlagExt4(3)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.checkFreezeReason(2)))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter = new AvatarWallViewPagerAdapter(new WeakReference(getActivity()), this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager, getResources().getDisplayMetrics().widthPixels, UIUtils.a(getActivity(), 212.0F), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember, null, "Grp_Admin_data");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnPageChangeListener(new VisitorTroopCardFragment.8(this));
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorTroopCardFragment.Activity", 2, String.format("updateTitle mStatusBarShow=%b", new Object[] { Boolean.valueOf(this.jdField_e_of_type_Boolean) }));
    }
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.jdField_e_of_type_Boolean) || (bool) || (b())) {}
    for (int j = 2131167030;; j = 2131167033)
    {
      int m = getResources().getColor(j);
      int k = 2130843941;
      j = k;
      if (this.jdField_e_of_type_Boolean)
      {
        j = k;
        if (!bool) {
          j = 2130840478;
        }
      }
      Drawable localDrawable = getResources().getDrawable(2130851150);
      localDrawable.setColorFilter(m, PorterDuff.Mode.SRC_ATOP);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(m);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(m);
      this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localDrawable);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(m);
      c(this.jdField_e_of_type_Boolean);
      return;
    }
  }
  
  @TargetApi(19)
  private void u()
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new VisitorTroopCardFragment.9(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    try
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(((SkinnableNinePatchDrawable)getResources().getDrawable(2130850777)).getBitmap());
      localBitmapDrawable.setAlpha(220);
      this.jdField_d_of_type_AndroidViewView.setBackground(localBitmapDrawable);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      localClassCastException.printStackTrace();
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter == null) {}
    do
    {
      return;
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(localDrawable);
      if ((b()) && (!QQTheme.e()))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130848706);
        int j = AIOUtils.a(1.3F, getResources());
        this.jdField_b_of_type_AndroidWidgetImageView.setPadding(j, j, j, j);
      }
    } while ((!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) && (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void w()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.e();
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility = new TroopShareUtility(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
      this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.f();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  private void x()
  {
    Bundle localBundle = TroopInfoActivity.a(this.jdField_e_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLat, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLon, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cityId, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopLocation);
    localBundle.putInt("troop_type_ex", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopTypeExt);
    localBundle.putString("leftViewText", getString(2131720207));
    localBundle.putInt("troop_auth_submit_time", getActivity().getIntent().getIntExtra("troop_auth_submit_time", 0));
    localBundle.putInt("troop_info_report_from", 4);
    localBundle.putInt("PARAM_EXIT_ANIMATION", 2);
    TroopInfoActivity.a(getActivity(), localBundle, 5);
    getActivity().overridePendingTransition(2130771983, 2130771982);
  }
  
  private void y()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) || (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
      return;
    }
    if ((this.jdField_c_of_type_JavaLangString.length() > 5) && (this.jdField_c_of_type_JavaLangString.length() <= 11) && (a(this.jdField_c_of_type_JavaLangString))) {}
    for (String str1 = "2";; str1 = "1")
    {
      if (this.jdField_a_of_type_Boolean) {}
      for (String str2 = "user_grp"; this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption == 10008; str2 = "more_result")
      {
        TroopReportor.a("Grp_all_search", str2, "clk_info_add", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", str1, this.jdField_c_of_type_JavaLangString });
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption == 30014) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption == 30016))
      {
        TroopReportor.a("Grp_all_search", str2, "clk_info_add", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", str1, this.jdField_c_of_type_JavaLangString });
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption == 30010) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption == 30012))
      {
        TroopReportor.a("Grp_all_search", str2, "clk_info_add", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", str1, this.jdField_c_of_type_JavaLangString });
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption != 30018) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nStatOption != 30020)) {
        break;
      }
      TroopReportor.a("Grp_all_search", str2, "clk_info_add", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "", str1, this.jdField_c_of_type_JavaLangString });
      return;
    }
  }
  
  private void z()
  {
    VisitorTroopCardReport.a(7, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption() == 40002) {
      str = "3_40002";
    }
    for (;;)
    {
      TroopNotificationUtils.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, str);
      TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption() == 40001) {
        str = "3_40001";
      }
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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      localLayoutParams = (LinearLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams();
      k = getResources().getDisplayMetrics().widthPixels;
      if (localList.size() <= 0) {
        break label208;
      }
      j = TroopPhotoUtil.a(k);
    }
    for (;;)
    {
      localLayoutParams.width = k;
      localLayoutParams.height = j;
      this.jdField_e_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      if ((b()) && (this.jdField_f_of_type_AndroidViewView != null))
      {
        this.jdField_f_of_type_AndroidViewView.setBackgroundDrawable(null);
        this.jdField_f_of_type_AndroidViewView.setPadding(this.jdField_f_of_type_AndroidViewView.getPaddingLeft(), this.jdField_f_of_type_AndroidViewView.getPaddingTop(), this.jdField_f_of_type_AndroidViewView.getPaddingRight(), this.jdField_f_of_type_AndroidViewView.getPaddingBottom() + AIOUtils.a(6.0F, getResources()));
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setVisibility(0);
        if (this.jdField_e_of_type_Boolean) {
          this.jdField_e_of_type_Boolean = false;
        }
      }
      for (;;)
      {
        this.jdField_e_of_type_Boolean = false;
        t();
        return;
        label208:
        if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_f_of_type_AndroidViewView == null)) {
          break label293;
        }
        this.jdField_a_of_type_AndroidViewView.measure(0, 0);
        this.jdField_f_of_type_AndroidViewView.measure(0, 0);
        j = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight() + this.jdField_f_of_type_AndroidViewView.getMeasuredHeight();
        this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130839575);
        break;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setVisibility(8);
        if (!this.jdField_e_of_type_Boolean) {
          this.jdField_e_of_type_Boolean = true;
        }
      }
      label293:
      j = 0;
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt > 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopRecommendTroopDataCardRecomTroopListWrapper != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopRecommendTroopDataCardRecomTroopListWrapper.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((1 == paramInt1) && ((getActivity().isResume()) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))))
    {
      d();
      TroopUtils.a(getActivity(), paramInt2);
    }
    while ((!getActivity().isResume()) || ((paramInt1 != 2) && (paramInt1 != 9))) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(getActivity());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131692165, 1500);
    getActivity().finish();
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    if ((1 == paramInt1) && ((getActivity().isResume()) || ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.cGroupOption == 1)) || (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))))
    {
      d();
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(getActivity());
      }
      switch (paramInt2)
      {
      case -1: 
      default: 
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131693551, 1500);
      }
    }
    label368:
    do
    {
      for (;;)
      {
        return;
        ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(Long.parseLong(paramString), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
        return;
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131693552, 1500);
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
              break label368;
            }
          }
          for (;;)
          {
            QLog.d("VisitorTroopCardFragment.Activity", 2, bool + " : " + paramString);
            if (localObject1 != null) {
              break label407;
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
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131720199, 1500);
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
                    break label579;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.updateTroopAdmMemberNum(paramString.Administrator, paramString.wMemberNum, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), getResources());
                  if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView == null) {
                    break;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopMoreDetailView.a(HardCodeUtil.a(2131701826) + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + HardCodeUtil.a(2131701828));
                  return;
                }
              }
            }
          }
        }
      }
    } while (((paramInt1 != 2) && (paramInt1 != 9)) || (paramInt2 != 0));
    label407:
    label579:
    paramString = new Intent();
    paramString.putExtra("isNeedFinish", true);
    getActivity().setResult(-1, paramString);
    getActivity().finish();
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
    String str2 = TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData);
    if (paramInt == -1) {}
    for (Object localObject = "0";; localObject = "1")
    {
      TroopReportor.a("Grp_share", "grpData_admin", "share_qq", 0, 0, new String[] { str1, str2, localObject });
      if (paramInt == -1) {
        break;
      }
      return;
    }
    localObject = AIOUtils.a(new Intent(getActivity(), SplashActivity.class), null);
    ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
    paramIntent = ForwardUtils.a((Intent)localObject);
    ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), paramIntent, (Intent)localObject);
  }
  
  public void a(long paramLong, List<oidb_0x899.memberlist> paramList)
  {
    if ((this.jdField_g_of_type_Boolean) || (!TextUtils.equals(this.jdField_e_of_type_JavaLangString, String.valueOf(paramLong)))) {}
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
    QQToast.a(getActivity(), getString(2131696061), 1).b(getActivity().getTitleBarHeight());
  }
  
  public void a(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    boolean bool = true;
    int j;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.coverFrom(paramGroupInfo);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName)) {
        L();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
        v();
      }
      if (QLog.isColorLevel())
      {
        j = paramGroupInfo.uint32_group_flagext3.get();
        StringBuilder localStringBuilder = new StringBuilder().append("ChatSettingForToop_handle88dResp, troopUin=");
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null) {
          break label382;
        }
        str = "";
        QLog.d(".troop.qidian_private_troop", 2, str + ", flagExt3=" + j + ", isQidianPrivateTroop=" + TroopInfo.isQidianPrivateTroop(j));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.coverFrom(paramGroupInfo);
        this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getNewTroopNameOrTroopName();
        if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.newTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getNewTroopNameOrTroopName();
        }
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.oldTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getNewTroopNameOrTroopName();
      }
      this.jdField_f_of_type_Boolean = TroopInfo.isQidianPrivateTroop(paramGroupInfo.uint32_group_flagext3.get());
      if (this.jdField_f_of_type_Boolean)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner) {
          break label394;
        }
        j = 1;
        label231:
        new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_private").c("Grp_data").d("exp").a(new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, String.valueOf(j) }).a();
      }
      n();
      if (this.jdField_f_of_type_Boolean) {
        break label429;
      }
    }
    for (;;)
    {
      d(bool);
      l();
      J();
      K();
      r();
      a();
      TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember);
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
        j = 2;
        break label231;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember)
      {
        j = 3;
        break label231;
      }
      j = 4;
      break label231;
      label429:
      bool = false;
    }
  }
  
  protected void a(boolean paramBoolean)
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
      AIOUtils.a(localIntent, new int[] { 2 });
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      localIntent.putExtra("uintype", 1);
      String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.newTroopName;
      String str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopRemark)) {
          str1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopRemark;
        }
      }
      localIntent.putExtra("uinname", str1);
      if ((paramBoolean) && (this.jdField_c_of_type_Boolean))
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
    b(2131719023, 1);
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
    JoinTroopSecurityTipsHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramLong, getActivity());
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
  
  public void a(boolean paramBoolean, List<AvatarInfo> paramList)
  {
    if (paramBoolean) {
      v();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a(paramList))) {
      return;
    }
    v();
    a();
    l();
  }
  
  boolean a()
  {
    TroopAssociationsEntryConfig localTroopAssociationsEntryConfig = (TroopAssociationsEntryConfig)QConfigManager.a().a(686);
    if ((localTroopAssociationsEntryConfig != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData != null)) {
      return (localTroopAssociationsEntryConfig.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData)) && (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasTroopAssociation());
    }
    return false;
  }
  
  public void b()
  {
    getActivity().runOnUiThread(new VisitorTroopCardFragment.23(this));
  }
  
  protected void b(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    HWTroopUtils.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, "join");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    TroopUtils.a(getActivity(), getActivity().getTitleBarHeight(), paramInt1, paramInt2);
  }
  
  public void b(String paramString)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin)) {
      v();
    }
  }
  
  void b(boolean paramBoolean)
  {
    Object localObject = (TroopAssociationsEntryConfig)QConfigManager.a().a(686);
    if ((localObject == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (!((TroopAssociationsEntryConfig)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData))) {
      break label35;
    }
    label35:
    while ((this.jdField_a_of_type_ComTencentMobileqqTroopAssociationsTroopAssociationsListWrapper != null) && (!paramBoolean)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopAssociationsTroopAssociationsListWrapper == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopAssociationsTroopAssociationsListWrapper = new TroopAssociationsListWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupClassExt);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopAssociationsTroopAssociationsListWrapper;
    if ((paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasTroopAssociation())) {}
    for (boolean bool = true;; bool = false)
    {
      ((TroopAssociationsListWrapper)localObject).a(bool);
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
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getActivity().getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694694);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
      QQToast.a(getActivity(), 2, 2131718553, 1).b(getActivity().getTitleBarHeight());
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
      getActivity().overridePendingTransition(2130771999, 2130771992);
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity() == null) || (getActivity().app == null)) {}
    do
    {
      do
      {
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
          TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          TroopReportor.a("grpProfile", "grpProfile_exp", "grpProfile_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 0, 1, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.getStatOption());
          BnrReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 65);
          paramLayoutInflater = new IntentFilter();
          paramLayoutInflater.addAction("start_recomend_page");
          paramLayoutInflater.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
          getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramLayoutInflater);
          if (this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopApiObserver != null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopApiObserver);
          }
          paramLayoutInflater = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
          paramViewGroup = (TroopEssenceMsgEntryInCardConfig)QConfigManager.a().a(715);
        } while ((paramViewGroup == null) || (!paramViewGroup.a(this.jdField_e_of_type_JavaLangString)));
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
          break;
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTroopInfoExtObj.essenceSwitch != 1));
      paramLayoutInflater = (ITroopEssenceService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopEssenceService.class, "");
    } while (paramLayoutInflater == null);
    paramLayoutInflater.getEssenceMsgList(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, 1);
    return;
    try
    {
      paramLayoutInflater.d(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
      return;
    }
    catch (NumberFormatException paramLayoutInflater)
    {
      paramLayoutInflater.printStackTrace();
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter != null)
    {
      c();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
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
      VisitorTroopCardReport.a(15, new Object[] { localObject2, localObject1 });
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember;
      localObject1 = TDCRecomTroopConfigProcessor.a();
      if (((bool2) && ((localObject1 == null) || (!((TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean)localObject1).jdField_a_of_type_Boolean))) || (a())) {
        break label345;
      }
      bool1 = true;
      if ((localObject1 == null) || (TextUtils.isEmpty(((TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean)localObject1).jdField_a_of_type_JavaLangString))) {
        break label350;
      }
      localObject1 = ((TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean)localObject1).jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "checkAndInitRecommendList,hasJoinedTroop = " + bool2 + ",displayOrNot = " + bool1 + ",recoomTips = " + (String)localObject1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopRecommendTroopDataCardRecomTroopListWrapper == null)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
          break label357;
        }
      }
    }
    label345:
    label350:
    label357:
    for (localObject2 = "1";; localObject2 = "2")
    {
      VisitorTroopCardReport.a(16, new Object[] { str, localObject2 });
      localObject2 = new TextView(getActivity());
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextColor(getResources().getColor(2131167003));
      ((TextView)localObject2).setTextSize(2, 16.0F);
      ((TextView)localObject2).setPadding(AIOUtils.a(16.0F, getResources()), AIOUtils.a(13.0F, getResources()), 0, AIOUtils.a(5.0F, getResources()));
      ((TextView)localObject2).setClickable(false);
      localObject1 = View.inflate(getActivity(), 2131561722, null);
      ((View)localObject1).setBackgroundResource(2130851165);
      this.jdField_a_of_type_ComTencentMobileqqTroopRecommendTroopDataCardRecomTroopListWrapper = new TroopDataCardRecomTroopListWrapper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentWidgetXListView, null, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, bool1, (TextView)localObject2, (View)localObject1);
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
    return 2131563214;
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
          v();
          return;
          a();
        } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("has_operation", false)));
        this.jdField_a_of_type_AndroidContentIntent = paramIntent;
        return;
      } while ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("select_member_add_request_ok", false)));
      this.jdField_h_of_type_Boolean = true;
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
    I();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int k = 0;
    if (UIUtils.b()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int j;
      Object localObject1;
      Object localObject2;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131363891: 
        j = k;
        if (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128))
        {
          j = k;
          if (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512)) {
            j = 1;
          }
        }
        k = ((Integer)paramView.getTag()).intValue();
        if ((j != 0) && (k != 4))
        {
          c();
          ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(Long.valueOf(this.jdField_e_of_type_JavaLangString).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()).longValue(), this.jdField_b_of_type_JavaLangString);
          y();
        }
        break;
      case 2131379848: 
        localObject1 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_e_of_type_JavaLangString });
        localObject2 = new Intent(getActivity(), QQBrowserActivity.class);
        ((Intent)localObject2).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject2).putExtra("url", (String)localObject1);
        super.startActivity((Intent)localObject2);
        break;
      case 2131368281: 
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.hasSetNewTroopHead) {
          a(false, this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim());
        }
        for (;;)
        {
          VisitorTroopCardReport.a(3, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bOwner), Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.bAdmin) });
          break;
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim()) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter != null)) {
            this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter.d();
          }
        }
      case 2131369487: 
        I();
        getActivity().finish();
        break;
      case 2131369501: 
        C();
        TroopReportor.a("grpProfile", "grpProfile_clk", "more_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        break;
      case 2131381672: 
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isOwnerOrAdim())
        {
          B();
        }
        else
        {
          a(true, false);
          continue;
          a(k, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        break;
      case 2131366178: 
        TroopReportor.a("grpProfile", "grpProfile_clk", "edit_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        x();
        break;
      case 2131377978: 
        E();
        TroopReportor.a("grpProfile", "grpProfile_clk", "share_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        break;
      case 2131379947: 
        if (this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum > this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum) {
          this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {}
        for (j = 0;; j = 1)
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putBoolean("hide_operation_bar", true);
          ((Bundle)localObject1).putBoolean("hideRightButton", true);
          ((Bundle)localObject1).putBoolean("isScreenOrientationPortrait", true);
          ((Bundle)localObject1).putString("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          ((Bundle)localObject1).putString("url", "https://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin + "&role=1&group_level=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nTroopGrade + "&group_mem_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.wMemberNum + "&group_active_num=" + this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.nActiveMemberNum + "&show_level=" + j);
          localObject2 = new ActivityURIRequest(getActivity(), "/pubaccount/browser");
          ((ActivityURIRequest)localObject2).extra().putAll((Bundle)localObject1);
          QRoute.startUri((URIRequest)localObject2, null);
          TroopReportor.a("grpProfile", "grpProfile_clk", "grpLevel_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
          BnrReport.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 72);
          break;
        }
      case 2131369846: 
        TroopReportor.a("grpProfile", "grpProfile_clk", "QRcode_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        w();
        break;
      case 2131380048: 
        TroopReportor.a("grpProfile", "grpProfile_clk", "grpNumber_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin });
        D();
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
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopApiObserver);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      }
      this.jdField_g_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter.a();
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopAssociationsTroopAssociationsListWrapper != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopAssociationsTroopAssociationsListWrapper.b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopRecommendTroopDataCardRecomTroopListWrapper != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopRecommendTroopDataCardRecomTroopListWrapper.c();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopshareTroopShareUtility.e();
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
    if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VisitorTroopCardFragment.Activity", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter.a(str, paramIntent);
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
  
  public void onPostThemeChanged()
  {
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.jdField_e_of_type_Boolean) || (bool) || (b())) {}
    for (int j = 2131167030;; j = 2131167033)
    {
      j = getResources().getColor(j);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(j);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(j);
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setBackgroundColor(-16777216);
      }
      return;
    }
  }
  
  public void onResume()
  {
    int j;
    String str2;
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.mTroopPrivilegeFlag, 512)))
    {
      j = 1;
      if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (j != 0)) {
        this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      }
      super.onResume();
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        str2 = this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin;
        if (!this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.isMember) {
          break label149;
        }
      }
    }
    label149:
    for (String str1 = "1";; str1 = "0")
    {
      TroopReportor.a("Grp_set_new", "grpData_visitor", "exp", 0, 0, new String[] { str2, str1 });
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      t();
      return;
      j = 0;
      break;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter.a(null, false);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardPresenter.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin);
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
    if ((paramBoolean) && (!this.i))
    {
      this.i = true;
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment
 * JD-Core Version:    0.7.0.1
 */