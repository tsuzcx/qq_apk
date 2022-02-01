package com.tencent.mobileqq.troop.troopcard;

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
import android.support.annotation.Nullable;
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
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.association.TroopAssociationsEntryConfig;
import com.tencent.mobileqq.troop.avatar.AvatarInfo;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.essence.TroopEssenceMsgEntryInCardConfig;
import com.tencent.mobileqq.troop.essence.api.ITroopEssenceHandler;
import com.tencent.mobileqq.troop.observer.TroopEssenceMsgObserver;
import com.tencent.mobileqq.troop.recommend.TDCRecomTroopConfigProcessor;
import com.tencent.mobileqq.troop.recommend.TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean;
import com.tencent.mobileqq.troop.recommend.TroopDataCardRecomTroopListWrapper;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper.OnTroopSafeDialogClickConfirm;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPager;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipBigTroopExpiredProcessor;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
  extends QIphoneTitleBarFragment
  implements View.OnClickListener, IVisitorTroopCardViewInterface, TroopAssociationsListWrapper.ICallbacks
{
  protected int a;
  private long jdField_a_of_type_Long = 0L;
  protected BroadcastReceiver a;
  private Intent jdField_a_of_type_AndroidContentIntent = null;
  protected AlphaAnimation a;
  protected Animation.AnimationListener a;
  protected Button a;
  protected LinearLayout a;
  public AppInterface a;
  protected TroopInfo a;
  protected TroopMngObserver a;
  protected TroopInfoData a;
  protected TroopEssenceMsgObserver a;
  private TroopDataCardRecomTroopListWrapper jdField_a_of_type_ComTencentMobileqqTroopRecommendTroopDataCardRecomTroopListWrapper;
  private TroopAssociationsListWrapper jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopAssociationsListWrapper;
  protected TroopEssenceMsgView a;
  protected TroopMoreDetailView a;
  private VisitorTroopCardPresenter jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter;
  protected ITroopShareUtility a;
  private TroopNotifyHelper.OnTroopSafeDialogClickConfirm jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNotifyHelper$OnTroopSafeDialogClickConfirm = new VisitorTroopCardFragment.12(this);
  private AvatarWallViewPager jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager;
  private AvatarWallViewPagerAdapter jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter;
  protected ExpandableTextView a;
  protected QQCustomDialog a;
  protected QQBlurView a;
  protected QQProgressDialog a;
  private QQProgressNotifier jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected ImmersiveTitleBar2 a;
  protected String a;
  protected boolean a;
  protected int b;
  protected AlphaAnimation b;
  protected Button b;
  protected RelativeLayout b;
  protected String b;
  protected int c;
  protected View c;
  protected Button c;
  protected ImageView c;
  protected String c;
  public boolean c;
  protected int d;
  protected View d;
  protected ImageView d;
  protected String d;
  protected boolean d;
  protected int e;
  protected View e;
  protected ImageView e;
  private String e;
  public boolean e;
  private int jdField_f_of_type_Int;
  protected View f;
  protected ImageView f;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int = 2;
  private View jdField_g_of_type_AndroidViewView;
  protected ImageView g;
  protected TextView g;
  private boolean jdField_g_of_type_Boolean;
  private View jdField_h_of_type_AndroidViewView;
  protected ImageView h;
  protected TextView h;
  private boolean jdField_h_of_type_Boolean = false;
  protected TextView i;
  private boolean i;
  protected TextView j;
  private boolean j;
  protected TextView k;
  protected TextView l;
  protected TextView m;
  protected TextView n;
  
  public VisitorTroopCardFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = new TroopInfoData();
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new VisitorTroopCardFragment.1(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new VisitorTroopCardFragment.7(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopEssenceMsgObserver = new VisitorTroopCardFragment.10(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new VisitorTroopCardFragment.11(this);
  }
  
  private void A()
  {
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).calJoinTroop(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getExposureSource(), this.jdField_d_of_type_Int, 2);
    if (!NetworkUtil.isNetSupport(getActivity()))
    {
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).notifyUser(getActivity(), getQBaseActivity().getTitleBarHeight(), 2131694422, 1);
      return;
    }
    VisitorTroopCardPresenter localVisitorTroopCardPresenter = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter;
    if (localVisitorTroopCardPresenter == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "mVisitorPresenter is null");
      }
      return;
    }
    localVisitorTroopCardPresenter.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 8390784);
    if (super.getActivity().getIntent().getBooleanExtra("from_babyq", false)) {
      VisitorTroopCardReport.a(14, new Object());
    }
    TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption());
  }
  
  private void B()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    localActionSheet.addButton(new ActionMenuItem(HardCodeUtil.a(2131701942), 7, 0), 5);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new VisitorTroopCardFragment.13(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void C()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    if (!d()) {
      localActionSheet.addButton(new ActionMenuItem(getString(2131696199), 9, 0), 5);
    }
    localActionSheet.addButton(new ActionMenuItem(ActionSheetHelper.a(getActivity(), 2131718216), 10, 0), 5);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new VisitorTroopCardFragment.14(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void D()
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()) && (!d())) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(getActivity(), null);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()) {
      str = getString(2131699461);
    } else {
      str = getString(2131699464);
    }
    localActionSheet.setMainTitle(str);
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()) {
      i1 = 2131699462;
    } else {
      i1 = 2131699463;
    }
    String str = getString(i1);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()) {
      i1 = 12;
    } else {
      i1 = 9;
    }
    localActionSheet.addButton(new ActionMenuItem(str, i1, 0), 5);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnBottomCancelListener(new VisitorTroopCardFragment.15(this, localActionSheet));
    localActionSheet.setOnButtonClickListener(new VisitorTroopCardFragment.16(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void E()
  {
    ITroopShareUtility localITroopShareUtility = this.jdField_a_of_type_ComTencentMobileqqTroopTroopshareTempapiITroopShareUtility;
    if (localITroopShareUtility != null)
    {
      localITroopShareUtility.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopshareTempapiITroopShareUtility.troopUtils_shareTroop(getQBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
  }
  
  private void F()
  {
    Object localObject = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((ITroopInfoService)localObject).findTroopInfo(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupFlagExt & 0x800) == 0L)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter;
        if ((localObject == null) || (((VisitorTroopCardPresenter)localObject).jdField_a_of_type_Int == 0))
        {
          G();
          break label154;
        }
      }
      H();
    }
    else
    {
      localObject = ActionSheet.create(getActivity());
      ((ActionSheet)localObject).setMainTitle(2131691076);
      ((ActionSheet)localObject).addButton(2131692081, 3);
      ((ActionSheet)localObject).setOnButtonClickListener(new VisitorTroopCardFragment.17(this, (ActionSheet)localObject));
      ((ActionSheet)localObject).addCancelButton(getString(2131690728));
      ((ActionSheet)localObject).show();
    }
    label154:
    VisitorTroopCardReport.a(21, new Object());
  }
  
  private void G()
  {
    String str = getString(2131691070);
    ActionSheet localActionSheet = ActionSheet.create(getActivity());
    localActionSheet.setMainTitle(str);
    localActionSheet.addButton(getString(2131691069), 3);
    localActionSheet.addCancelButton(getString(2131690728));
    localActionSheet.setOnButtonClickListener(new VisitorTroopCardFragment.18(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void H()
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131756189);
    localReportDialog.setContentView(2131561033);
    ((TextView)localReportDialog.findViewById(2131365681)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131365669);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131365667);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131365673);
    String str = HardCodeUtil.a(2131701945);
    localTextView1.setText(getString(2131691071, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131694583);
    localTextView3.setText(2131690728);
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
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    }
    Intent localIntent2 = this.jdField_a_of_type_AndroidContentIntent;
    Intent localIntent1 = localIntent2;
    if (this.jdField_i_of_type_Boolean)
    {
      localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      localIntent1.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
      this.jdField_i_of_type_Boolean = false;
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
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nTroopGrade;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isShowActivityGrade()) {
      i1 = 0;
    }
    if (i1 > 0)
    {
      Object localObject = String.format(getResources().getString(2131693387), new Object[] { Integer.valueOf(i1) });
      this.l.setText((CharSequence)localObject);
      this.l.setContentDescription((CharSequence)localObject);
      this.l.setVisibility(0);
      TextView localTextView = this.l;
      if (c())
      {
        localObject = getResources();
        i1 = 2131167222;
      }
      else
      {
        localObject = getResources();
        i1 = 2131167056;
      }
      localTextView.setTextColor(((Resources)localObject).getColor(i1));
    }
    else
    {
      this.l.setVisibility(8);
    }
    if (this.jdField_g_of_type_Boolean) {
      this.l.setVisibility(8);
    }
    this.l.setOnClickListener(this);
  }
  
  private void L()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = HardCodeUtil.a(2131701943);
    }
    this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_i_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_i_of_type_AndroidWidgetTextView.setClickable(false);
    Object localObject3 = this.jdField_i_of_type_AndroidWidgetTextView;
    int i1;
    if (c())
    {
      localObject2 = getResources();
      i1 = 2131167222;
    }
    else
    {
      localObject2 = getResources();
      i1 = 2131167056;
    }
    ((TextView)localObject3).setTextColor(((Resources)localObject2).getColor(i1));
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localObject2 = this.jdField_i_of_type_AndroidWidgetTextView;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131701931));
      ((StringBuilder)localObject3).append((String)localObject1);
      ((TextView)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
    }
  }
  
  private void a(int paramInt, AppInterface paramAppInterface)
  {
    if (paramInt == 4)
    {
      c(false);
      if (this.jdField_e_of_type_Int == 2) {
        VisitorTroopCardReport.a(5, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      }
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).storyReportor(getActivity());
      TroopReportor.a("grpProfile", "grpProfile_clk", "message_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
      return;
    }
    if (paramInt == 3)
    {
      z();
      return;
    }
    if (paramInt == 5)
    {
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).joinGroupOneStep(paramAppInterface, getActivity(), getActivity().getIntent(), this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback);
      VisitorTroopCardReport.a(8, new Object());
      TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption());
      return;
    }
    if (paramInt == 6)
    {
      long l1 = System.currentTimeMillis();
      if (l1 - this.jdField_a_of_type_Long > 1000L)
      {
        this.jdField_a_of_type_Long = l1;
        y();
        TroopReportor.a("grpProfile", "grpProfile_clk", "join_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 34)
        {
          if (((ITroopCardApi)QRoute.api(ITroopCardApi.class)).needAnswerQuestion(paramAppInterface.getCurrentAccountUin()))
          {
            paramAppInterface = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).createQuestionDialog(getActivity());
            if (!getActivity().isFinishing())
            {
              paramAppInterface.show();
              VisitorTroopCardReport.a(11, new Object());
            }
            return;
          }
          VisitorTroopCardReport.a(12, new Object());
        }
        ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).secRecognize(false, null);
        String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
        String str1;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember) {
          str1 = "1";
        } else {
          str1 = "0";
        }
        VisitorTroopCardReport.a(13, new Object[] { str2, str1 });
        if ((this.jdField_c_of_type_Int == 0) && ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isHomeworkTroop())
          {
            b(1);
            return;
          }
          e();
          return;
        }
        ((ITroopMngHandler)paramAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName())).a(Long.valueOf(this.jdField_e_of_type_JavaLangString).longValue(), Long.valueOf(paramAppInterface.getCurrentUin()).longValue(), this.jdField_b_of_type_JavaLangString);
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = QVipBigTroopExpiredProcessor.c();
    if ((paramBoolean2) && (((QVipBigTroopExpiredConfig)localObject1).mIsEnable) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mIsFreezed == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()))
    {
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).FreezedLiangGroup(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData);
      VisitorTroopCardReport.a(1, new Object());
      return;
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("IS_COVER", paramBoolean1);
    ((Bundle)localObject1).putBoolean("IS_EDIT", paramBoolean2);
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).handleEditClosed(paramBoolean2, this.jdField_d_of_type_AndroidWidgetImageView, (Bundle)localObject1);
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter;
    if (localObject2 != null) {
      ((VisitorTroopCardPresenter)localObject2).a((Bundle)localObject1, d());
    }
    VisitorTroopCardReport.a(4, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
    if (d()) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    TroopReportor.a("Grp_set_new", "grpData_visitor", "clk_head", 0, 0, new String[] { localObject2, localObject1 });
  }
  
  private boolean a(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  private boolean a(boolean paramBoolean, int paramInt)
  {
    int i1;
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 512))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      d();
      if ((paramBoolean) && (paramInt != 0))
      {
        TroopNotifyHelper.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNotifyHelper$OnTroopSafeDialogClickConfirm, new Object[0]);
        return true;
      }
      z();
      return true;
    }
    return false;
  }
  
  private void c(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).initTroopInfoData(paramBundle, getActivity());
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).initTroopInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, getActivity());
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).setExposureSource(paramBundle.getInt("exposureSource", 99));
    this.jdField_d_of_type_Int = paramBundle.getInt("filter_id", -1);
    this.jdField_e_of_type_Int = paramBundle.getInt("D2GType");
    this.jdField_d_of_type_Boolean = paramBundle.getBoolean("fromThirdAppByOpenSDK");
    this.jdField_d_of_type_JavaLangString = getActivity().getIntent().getStringExtra("is_from_game");
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("authKey");
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("authSig");
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("keyword");
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("isFromNative", false);
    this.jdField_e_of_type_Boolean = paramBundle.getBoolean("troop_info_from_troopsetting", false);
    this.jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isQidianPrivateTroop;
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter = new VisitorTroopCardPresenter();
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter.a(this);
    paramBundle = getActivity().getIntent().getStringExtra("appid");
    String str1 = getActivity().getIntent().getStringExtra("openid");
    String str2 = getActivity().getIntent().getStringExtra("share_uin");
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter.a(paramBundle, str1, str2);
  }
  
  private boolean c()
  {
    AvatarWallViewPagerAdapter localAvatarWallViewPagerAdapter = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter;
    return (localAvatarWallViewPagerAdapter != null) && (localAvatarWallViewPagerAdapter.a().size() > 0);
  }
  
  private boolean d()
  {
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    return (localTroopInfoData != null) && (localTroopInfoData.isMember);
  }
  
  private void e(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption != 1) && (this.jdField_b_of_type_Int != 1))
    {
      f(paramString);
      return;
    }
    if (this.jdField_c_of_type_Int != 0)
    {
      TroopNotifyHelper.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNotifyHelper$OnTroopSafeDialogClickConfirm, new Object[0]);
      return;
    }
    e();
  }
  
  private void e(boolean paramBoolean)
  {
    boolean bool3 = c();
    boolean bool2 = false;
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    }
    boolean bool1 = bool2;
    if (!bool3) {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
        bool1 = bool2;
      } else {
        bool1 = true;
      }
    }
    ImmersiveUtils.setStatusTextColor(bool1, getActivity().getWindow());
    if (paramBoolean) {
      SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, getActivity().getWindow());
    }
  }
  
  private void f(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption != 3)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption();
      int i2 = this.jdField_e_of_type_Int;
      if ((i2 != 1) && (i2 != 2)) {
        break label43;
      }
      i1 = 18;
      label43:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.remark))
      {
        startActivity(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).addFriendLogicActivity_startJoinTroop(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption, i1, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.remark, getResources().getString(2131690818), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString));
        return;
      }
      paramString = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).addFriendLogicActivity_startJoinTroop(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption, i1, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinAnswer, null, getResources().getString(2131690818), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString);
      paramString.putExtra("from_newer_guide", getActivity().getIntent().getBooleanExtra("from_newer_guide", false));
      paramString.putExtra("from_babyq", getActivity().getIntent().getBooleanExtra("from_babyq", false));
      startActivityForResult(paramString, 1);
      return;
    }
    b(2131719932, 0);
  }
  
  private void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      if ((localObject != null) && (((TroopInfoData)localObject).troopUin != null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
        break label35;
      }
    }
    Object localObject = " ";
    label35:
    this.jdField_j_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_j_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if (localObject != null)
    {
      this.jdField_j_of_type_AndroidWidgetTextView.setClickable(((TroopInfoData)localObject).isNewTroop);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop)
      {
        this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener(this);
        TroopReportor.a("grpProfile", "grpProfile_exp", "grpNumberr_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
      }
    }
    TextView localTextView = this.jdField_j_of_type_AndroidWidgetTextView;
    int i1;
    if (c())
    {
      localObject = getResources();
      i1 = 2131167222;
    }
    else
    {
      localObject = getResources();
      i1 = 2131167056;
    }
    localTextView.setTextColor(((Resources)localObject).getColor(i1));
  }
  
  private void g()
  {
    if (this.jdField_g_of_type_AndroidWidgetTextView != null)
    {
      Drawable localDrawable = getResources().getDrawable(2130839401);
      this.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.jdField_g_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131298126));
      ((Animatable)localDrawable).start();
    }
    if (!NetworkUtil.isNetworkAvailable(getActivity())) {
      QQToast.a(getActivity(), 1, getString(2131694424), 1).b(getQBaseActivity().getTitleBarHeight());
    }
    ThreadManager.post(new VisitorTroopCardFragment.2(this), 8, null, false);
    p();
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new VisitorTroopCardFragment.3(this));
    this.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void g(String paramString)
  {
    getActivity().runOnUiThread(new VisitorTroopCardFragment.21(this, paramString));
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateForTroopInfo(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    a();
    v();
    L();
    n();
    r();
    K();
    m();
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView.b();
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)this.jdField_b_of_type_AndroidViewView.findViewById(2131378881));
    this.jdField_f_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131363900);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363722));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365037));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    int i1 = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
    int i2 = this.jdField_a_of_type_ComTencentWidgetXListView.getPaddingLeft();
    int i3 = getResources().getDimensionPixelOffset(2131297080);
    this.jdField_a_of_type_ComTencentWidgetXListView.setPadding(i1, 0, i2, i3);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(getActivity());
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130838739);
    o();
    j();
    this.jdField_a_of_type_ComTencentWidgetXListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    u();
    q();
  }
  
  @SuppressLint({"NewApi"})
  private void j()
  {
    Object localObject = View.inflate(getActivity(), 2131559862, null);
    this.jdField_g_of_type_AndroidViewView = ((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager = ((AvatarWallViewPager)((View)localObject).findViewById(2131380907));
    this.jdField_h_of_type_AndroidViewView = ((View)localObject).findViewById(2131373866);
    s();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    a();
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131373728));
    this.n = ((TextView)((View)localObject).findViewById(2131379335));
    r();
    this.m = ((TextView)((View)localObject).findViewById(2131379374));
    n();
    this.l = ((TextView)((View)localObject).findViewById(2131379276));
    K();
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131368033));
    ((View)localObject).setContentDescription(getResources().getString(2131699460));
    if (SimpleUIUtil.a()) {
      ((View)localObject).setBackground(null);
    }
    v();
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379316));
    L();
    LongClickCopyAction.attachCopyAction(this.jdField_i_of_type_AndroidWidgetTextView, HardCodeUtil.a(2131715447));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131379377));
    f(true);
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject).findViewById(2131379177));
    k();
    localObject = HardCodeUtil.a(2131691297);
    String str = this.jdField_j_of_type_AndroidWidgetTextView.getText().toString();
    localObject = LongClickCopyAction.attachCopyAction(this.jdField_j_of_type_AndroidWidgetTextView, (String)localObject, str);
    if (localObject != null) {
      ((LongClickCopyAction)localObject).setCopyListener(new VisitorTroopCardFragment.4(this));
    }
    this.jdField_d_of_type_AndroidViewView = View.inflate(getActivity(), 2131561526, null);
    this.k = ((TextView)this.jdField_d_of_type_AndroidViewView.findViewById(2131379946));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131369532));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_d_of_type_AndroidViewView);
    l();
    this.jdField_e_of_type_AndroidViewView = View.inflate(getActivity(), 2131560678, null);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView = ((ExpandableTextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131366357));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131369381));
    m();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.a().setMovementMethod(LinkMovementMethod.getInstance());
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setOnExpandStateChangeListener(new VisitorTroopCardFragment.5(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_e_of_type_AndroidViewView);
    localObject = View.inflate(getActivity(), 2131561565, null);
    ((View)localObject).setBackgroundResource(2130851081);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298125);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView = new TroopMoreDetailView(getActivity());
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView.setGuestVisitor(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView);
    localObject = View.inflate(getActivity(), 2131561565, null);
    ((View)localObject).setBackgroundResource(2130851081);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298125);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopEssenceMsgView = new TroopEssenceMsgView(getActivity());
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopEssenceMsgView);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorTroopCardFragment.Activity", 2, "mLinearLayoutContentView.addView mTroopEssenceMsgView");
    }
  }
  
  private void k()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupFlagExt & 0x800) != 0L) && ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwAuthGroupType == 2L) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwAuthGroupType == 1L)))
    {
      this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
      return;
    }
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void l()
  {
    if (c())
    {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
        this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130846388);
      } else {
        this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130838929);
      }
    }
    else {
      this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130839433);
    }
    Object localObject = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
    this.jdField_d_of_type_AndroidViewView.measure(0, 0);
    ((LinearLayout.LayoutParams)localObject).height = (this.jdField_d_of_type_AndroidViewView.getMeasuredHeight() + Utils.a(6.0F, getResources()));
    float f1;
    if (c()) {
      f1 = -6.0F;
    } else {
      f1 = 0.0F;
    }
    ((LinearLayout.LayoutParams)localObject).topMargin = Utils.a(f1, getResources());
    this.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getDateString(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopCreateTime);
    this.k.setText(new QQText((CharSequence)localObject, 11, 16));
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void m()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo))
    {
      this.jdField_e_of_type_AndroidViewView.setBackgroundResource(2130839433);
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.setText(new QQText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo, 11, 16));
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetExpandableTextView.post(new VisitorTroopCardFragment.6(this));
      return;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void n()
  {
    boolean bool = this.jdField_g_of_type_Boolean;
    int i2 = 8;
    if (bool)
    {
      this.m.setVisibility(8);
      this.n.setVisibility(8);
      return;
    }
    this.m.setOnClickListener(this);
    this.m.setVisibility(0);
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt == 1)
    {
      this.m.setVisibility(8);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt == 0)
    {
      this.m.setVisibility(8);
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("（");
      ((StringBuilder)localObject).append(getString(2131696280));
      ((StringBuilder)localObject).append("）");
      localObject = ((StringBuilder)localObject).toString();
      this.m.setText((CharSequence)localObject);
      localObject = this.m;
      if (c()) {
        i1 = getResources().getColor(2131167222);
      } else {
        i1 = getResources().getColor(2131167056);
      }
      ((TextView)localObject).setTextColor(i1);
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt != 3) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt != 4))
      {
        this.m.setVisibility(8);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("（");
      ((StringBuilder)localObject).append(getString(2131696280));
      ((StringBuilder)localObject).append("）");
      localObject = ((StringBuilder)localObject).toString();
      this.m.setText((CharSequence)localObject);
      localObject = this.m;
      if (c()) {
        i1 = getResources().getColor(2131167222);
      } else {
        i1 = getResources().getColor(2131167056);
      }
      ((TextView)localObject).setTextColor(i1);
    }
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 512))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject = this.n;
    if (i1 != 0) {
      i2 = 0;
    }
    ((TextView)localObject).setVisibility(i2);
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember) && (i1 != 0))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131693342, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopNeedPayNumber) }));
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(3));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
  }
  
  private void o()
  {
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131378861);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131378803));
    Object localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName);
    localStringBuilder.append(" ");
    localStringBuilder.append(getResources().getString(2131690818));
    ((RelativeLayout)localObject).setContentDescription(localStringBuilder.toString());
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369249));
    this.jdField_g_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690818));
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369202));
    localObject = this.jdField_h_of_type_AndroidWidgetTextView;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131694652));
    localStringBuilder.append(getString(2131690703));
    ((TextView)localObject).setContentDescription(localStringBuilder.toString());
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369216));
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getString(2131691127));
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
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131363819));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131377399));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131366079));
    int i1;
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 512))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim())
    {
      TroopReportor.a("grpProfile", "grpProfile_exp", "edit_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693279);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(4));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      TroopReportor.a("grpProfile", "grpProfile_exp", "share_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
      TroopReportor.a("grpProfile", "grpProfile_exp", "message_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
      return;
    }
    if (i1 != 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131693342, new Object[] { new DecimalFormat("0.00").format(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopNeedPayNumber) }));
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(3));
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      return;
    }
    if ("true".equals(this.jdField_d_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131693513);
      this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(5));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
      return;
    }
    if (this.jdField_e_of_type_Int == 2) {
      VisitorTroopCardReport.a(18, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    }
    TroopReportor.a("grpProfile", "grpProfile_exp", "join_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131699474);
    this.jdField_a_of_type_AndroidWidgetButton.setTag(Integer.valueOf(6));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).secRecognize(true, this.jdField_a_of_type_AndroidWidgetButton);
  }
  
  private void r()
  {
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if ((localTroopInfoData != null) && (localTroopInfoData.checkFlagExt4(3)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.checkFreezeReason(2)))
    {
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter = new AvatarWallViewPagerAdapter(new WeakReference(getActivity()), this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager, getResources().getDisplayMetrics().widthPixels, ViewUtils.a(212.0F), this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember, null, "Grp_Admin_data");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setOnPageChangeListener(new VisitorTroopCardFragment.8(this));
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorTroopCardFragment.Activity", 2, String.format("updateTitle mStatusBarShow=%b", new Object[] { Boolean.valueOf(this.jdField_f_of_type_Boolean) }));
    }
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if ((!this.jdField_f_of_type_Boolean) && (!bool) && (!c())) {
      i1 = 2131167056;
    } else {
      i1 = 2131167053;
    }
    int i3 = getResources().getColor(i1);
    int i2 = 2130843861;
    int i1 = i2;
    if (this.jdField_f_of_type_Boolean)
    {
      i1 = i2;
      if (!bool) {
        i1 = 2130840347;
      }
    }
    Drawable localDrawable = getResources().getDrawable(2130851066);
    localDrawable.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
    this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(i3);
    this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(i3);
    this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundDrawable(localDrawable);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i1);
    this.jdField_c_of_type_AndroidWidgetImageView.setColorFilter(i3);
    e(this.jdField_f_of_type_Boolean);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    ((QQBlurView)localObject).b((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(4);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new VisitorTroopCardFragment.9(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    try
    {
      localObject = new BitmapDrawable(((SkinnableNinePatchDrawable)getResources().getDrawable(2130850703)).getBitmap());
      ((BitmapDrawable)localObject).setAlpha(220);
      this.jdField_f_of_type_AndroidViewView.setBackground((Drawable)localObject);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      localClassCastException.printStackTrace();
    }
  }
  
  private void v()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter;
    if (localObject == null) {
      return;
    }
    localObject = ((VisitorTroopCardPresenter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    if ((c()) && (!QQTheme.f()))
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setBackgroundResource(2130848585);
      int i1 = Utils.a(1.3F, getResources());
      this.jdField_d_of_type_AndroidWidgetImageView.setPadding(i1, i1, i1, i1);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim())) {
      this.jdField_d_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
  }
  
  private void w()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopshareTempapiITroopShareUtility != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopshareTempapiITroopShareUtility.onDestroy();
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopshareTempapiITroopShareUtility.newTroopShareUtility(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopshareTempapiITroopShareUtility.startTroop2DCode();
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  private void x()
  {
    Bundle localBundle = TroopInfoActivity.a(this.jdField_e_of_type_JavaLangString, 3, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLat, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLon, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cityId, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation);
    localBundle.putInt("troop_type_ex", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTypeExt);
    localBundle.putString("leftViewText", getString(2131719940));
    localBundle.putInt("troop_auth_submit_time", getActivity().getIntent().getIntExtra("troop_auth_submit_time", 0));
    localBundle.putInt("troop_info_report_from", 4);
    localBundle.putInt("PARAM_EXIT_ANIMATION", 2);
    ((ITroopInfoActivityApi)QRoute.api(ITroopInfoActivityApi.class)).openTroopProfileForResult(getActivity(), localBundle, 5);
    getActivity().overridePendingTransition(2130771995, 2130771994);
  }
  
  private void y()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if ((localObject != null) && (!TextUtils.isEmpty(((TroopInfoData)localObject).troopUin)))
    {
      if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
        return;
      }
      if ((this.jdField_c_of_type_JavaLangString.length() > 5) && (this.jdField_c_of_type_JavaLangString.length() <= 11) && (a(this.jdField_c_of_type_JavaLangString))) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      String str;
      if (this.jdField_a_of_type_Boolean) {
        str = "user_grp";
      } else {
        str = "more_result";
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nStatOption == 10008)
      {
        TroopReportor.a("Grp_all_search", str, "clk_info_add", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", localObject, this.jdField_c_of_type_JavaLangString });
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nStatOption != 30014) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nStatOption != 30016))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nStatOption != 30010) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nStatOption != 30012))
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nStatOption == 30018) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nStatOption == 30020)) {
            TroopReportor.a("Grp_all_search", str, "clk_info_add", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", localObject, this.jdField_c_of_type_JavaLangString });
          }
        }
        else {
          TroopReportor.a("Grp_all_search", str, "clk_info_add", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", localObject, this.jdField_c_of_type_JavaLangString });
        }
      }
      else {
        TroopReportor.a("Grp_all_search", str, "clk_info_add", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", localObject, this.jdField_c_of_type_JavaLangString });
      }
    }
  }
  
  private void z()
  {
    VisitorTroopCardReport.a(7, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption() == 40002) {
      str = "3_40002";
    } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption() == 40001) {
      str = "3_40001";
    } else {
      str = "";
    }
    TroopNotificationUtils.a(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, str);
    TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption());
  }
  
  protected int a()
  {
    return 2131563038;
  }
  
  public void a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter.a();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateTroopAvatarWall size=");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      QLog.i("VisitorTroopCardFragment.Activity", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null)
    {
      localObject2 = (LinearLayout.LayoutParams)this.jdField_g_of_type_AndroidViewView.getLayoutParams();
      int i2 = getResources().getDisplayMetrics().widthPixels;
      int i1;
      if (((List)localObject1).size() > 0)
      {
        i1 = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getScaledCoverHeight(i2);
      }
      else
      {
        localObject1 = this.jdField_c_of_type_AndroidViewView;
        if ((localObject1 != null) && (this.jdField_h_of_type_AndroidViewView != null))
        {
          ((View)localObject1).measure(0, 0);
          this.jdField_h_of_type_AndroidViewView.measure(0, 0);
          i1 = this.jdField_c_of_type_AndroidViewView.getMeasuredHeight() + this.jdField_h_of_type_AndroidViewView.getMeasuredHeight();
          this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130839433);
        }
        else
        {
          i1 = 0;
        }
      }
      ((LinearLayout.LayoutParams)localObject2).width = i2;
      ((LinearLayout.LayoutParams)localObject2).height = i1;
      this.jdField_g_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (c())
      {
        localObject1 = this.jdField_h_of_type_AndroidViewView;
        if (localObject1 != null)
        {
          ((View)localObject1).setBackgroundDrawable(null);
          localObject1 = this.jdField_h_of_type_AndroidViewView;
          ((View)localObject1).setPadding(((View)localObject1).getPaddingLeft(), this.jdField_h_of_type_AndroidViewView.getPaddingTop(), this.jdField_h_of_type_AndroidViewView.getPaddingRight(), this.jdField_h_of_type_AndroidViewView.getPaddingBottom() + Utils.a(6.0F, getResources()));
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setVisibility(0);
          if (!this.jdField_f_of_type_Boolean) {
            break label306;
          }
          this.jdField_f_of_type_Boolean = false;
          break label306;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager.setVisibility(8);
      if (!this.jdField_f_of_type_Boolean) {
        this.jdField_f_of_type_Boolean = true;
      }
      label306:
      this.jdField_f_of_type_Boolean = false;
      t();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      TroopDataCardRecomTroopListWrapper localTroopDataCardRecomTroopListWrapper = this.jdField_a_of_type_ComTencentMobileqqTroopRecommendTroopDataCardRecomTroopListWrapper;
      if (localTroopDataCardRecomTroopListWrapper != null) {
        localTroopDataCardRecomTroopListWrapper.f();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((1 == paramInt1) && ((getQBaseActivity().isResume()) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))))
    {
      d();
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).handleJoinTroopFailed(getActivity(), paramInt2);
      return;
    }
    if ((getQBaseActivity().isResume()) && ((paramInt1 == 2) || (paramInt1 == 9)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(getActivity());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131692085, 1500);
      getActivity().finish();
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = true;
    Object localObject1;
    if (1 == paramInt1) {
      if (!getQBaseActivity().isResume())
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
        if (((localObject1 == null) || (((TroopInfoData)localObject1).cGroupOption != 1)) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {}
      }
      else
      {
        d();
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(getActivity());
        }
        if (paramInt2 != -2)
        {
          if ((paramInt2 != 0) && (paramInt2 != 1))
          {
            if (paramInt2 != 2)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131693506, 1500);
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131719932, 1500);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131693507, 1500);
          getActivity().finish();
          c(true);
          localObject1 = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
          if (localObject1 == null) {
            return;
          }
          Object localObject2 = ((ITroopInfoService)localObject1).findTroopInfo(paramString);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("troopInfo is null 1，troopUin : ");
              ((StringBuilder)localObject1).append(paramString);
              QLog.d("VisitorTroopCardFragment.Activity", 2, ((StringBuilder)localObject1).toString());
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
          }
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("troopInfo is null 2 ? : ");
            if (localObject1 != null) {
              bool = false;
            }
            ((StringBuilder)localObject2).append(bool);
            ((StringBuilder)localObject2).append(" : ");
            ((StringBuilder)localObject2).append(paramString);
            QLog.d("VisitorTroopCardFragment.Activity", 2, ((StringBuilder)localObject2).toString());
          }
          if (localObject1 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("troopInfo is null 3, troopUin : ");
              ((StringBuilder)localObject1).append(paramString);
              QLog.d("VisitorTroopCardFragment.Activity", 2, ((StringBuilder)localObject1).toString());
            }
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null)
            {
              ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).addRecentTroopItemIntoRecentMsgList(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName, NetConnInfoCenter.getServerTime());
              return;
            }
            if (!QLog.isColorLevel()) {
              return;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("troopInfo is null 4, mTroopInfoData is null troopUin : ");
            ((StringBuilder)localObject1).append(paramString);
            QLog.d("VisitorTroopCardFragment.Activity", 2, ((StringBuilder)localObject1).toString());
            return;
          }
          ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).addRecentTroopItemIntoRecentMsgList(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localObject1);
          return;
        }
        ((ITroopMngHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName())).a(Long.parseLong(paramString), Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()));
        return;
      }
    }
    if (getQBaseActivity().isResume()) {
      if (paramInt1 == 3)
      {
        if (paramInt2 == 0)
        {
          paramString = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
          if (paramString == null) {
            paramString = null;
          } else {
            paramString = paramString.findTroopInfo(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
          }
          if ((paramString != null) && (paramString.wMemberNum != this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum))
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateTroopAdmMemberNum(paramString.Administrator, paramString.wMemberNum, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), getResources());
            paramString = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView;
            if (paramString != null)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(HardCodeUtil.a(2131701966));
              ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum);
              ((StringBuilder)localObject1).append(HardCodeUtil.a(2131701968));
              paramString.a(((StringBuilder)localObject1).toString());
            }
          }
        }
      }
      else if (((paramInt1 == 2) || (paramInt1 == 9)) && (paramInt2 == 0))
      {
        paramString = new Intent();
        paramString.putExtra("isNeedFinish", true);
        getActivity().setResult(-1, paramString);
        getActivity().finish();
      }
    }
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
    String str3 = TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData);
    String str1;
    if (paramInt == -1) {
      str1 = "0";
    } else {
      str1 = "1";
    }
    TroopReportor.a("Grp_share", "grpData_admin", "share_qq", 0, 0, new String[] { str2, str3, str1 });
    if (paramInt != -1) {
      return;
    }
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).handleAppShareAction(this.jdField_a_of_type_ComTencentCommonAppAppInterface, getActivity(), paramIntent);
  }
  
  public void a(long paramLong, List<oidb_0x899.memberlist> paramList)
  {
    if (!this.jdField_h_of_type_Boolean)
    {
      if (!TextUtils.equals(this.jdField_e_of_type_JavaLangString, String.valueOf(paramLong))) {
        return;
      }
      TroopMoreDetailView localTroopMoreDetailView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView;
      if (localTroopMoreDetailView != null) {
        localTroopMoreDetailView.a(paramList);
      }
    }
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    if (getActivity() != null)
    {
      if (getQBaseActivity() == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopshareTempapiITroopShareUtility = ((ITroopShareUtility)QRoute.api(ITroopShareUtility.class));
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFitsSystemWindows(false);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, 0, 0, 0);
      }
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)getQBaseActivity().getAppRuntime());
      b();
      c(getActivity().getIntent().getExtras());
      i();
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).preloadWebProcess(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      TroopReportor.a("grpProfile", "grpProfile_exp", "grpProfile_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
      TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 0, 1, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption());
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).bnrReport(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 65);
      paramLayoutInflater = new IntentFilter();
      paramLayoutInflater.addAction("start_recomend_page");
      paramLayoutInflater.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      getQBaseActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramLayoutInflater);
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver;
      if (paramLayoutInflater != null) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(paramLayoutInflater);
      }
      paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopEssenceMsgObserver;
      if (paramLayoutInflater != null) {
        this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(paramLayoutInflater);
      }
      paramLayoutInflater = (ITroopEssenceHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopEssenceHandlerName());
      paramLayoutInflater = (TroopEssenceMsgEntryInCardConfig)QConfigManager.a().a(715);
      if ((paramLayoutInflater != null) && (paramLayoutInflater.a(this.jdField_e_of_type_JavaLangString))) {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember)
        {
          paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
          if ((paramLayoutInflater != null) && (paramLayoutInflater.mTroopInfoExtObj.essenceSwitch == 1))
          {
            paramLayoutInflater = (ITroopEssenceHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopEssenceHandlerName());
            if (paramLayoutInflater != null) {
              paramLayoutInflater.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 1);
            }
          }
        }
        else
        {
          try
          {
            ((ITroopEssenceHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopEssenceHandlerName())).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
            return;
          }
          catch (NumberFormatException paramLayoutInflater)
          {
            paramLayoutInflater.printStackTrace();
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QQToast.a(getActivity(), getString(2131696076), 1).b(getQBaseActivity().getTitleBarHeight());
  }
  
  public void a(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if (localObject != null)
    {
      ((TroopInfoData)localObject).coverFrom(paramGroupInfo);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName)) {
        L();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead) {
        v();
      }
      boolean bool = QLog.isColorLevel();
      int i1 = 2;
      if (bool)
      {
        int i2 = paramGroupInfo.uint32_group_flagext3.get();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ChatSettingForToop_handle88dResp, troopUin=");
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
        if (localObject == null) {
          localObject = "";
        } else {
          localObject = ((TroopInfoData)localObject).troopUin;
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", flagExt3=");
        localStringBuilder.append(i2);
        localStringBuilder.append(", isQidianPrivateTroop=");
        localStringBuilder.append(TroopInfo.isQidianPrivateTroop(i2));
        QLog.d(".troop.qidian_private_troop", 2, localStringBuilder.toString());
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      if (localObject != null)
      {
        ((TroopInfo)localObject).coverFrom(paramGroupInfo);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getNewTroopNameOrTroopName();
        if (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
          ((TroopInfo)localObject).newTroopName = ((TroopInfo)localObject).getNewTroopNameOrTroopName();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
        ((TroopInfo)localObject).oldTroopName = ((TroopInfo)localObject).getNewTroopNameOrTroopName();
      }
      this.jdField_g_of_type_Boolean = TroopInfo.isQidianPrivateTroop(paramGroupInfo.uint32_group_flagext3.get());
      if (this.jdField_g_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
          i1 = 1;
        } else if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember) {
            i1 = 3;
          } else {
            i1 = 4;
          }
        }
        ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).reportTask(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, i1);
      }
      n();
      f(this.jdField_g_of_type_Boolean ^ true);
      l();
      J();
      K();
      r();
      a();
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateTroopInfoToDB(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember);
      paramGroupInfo = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView;
      if (paramGroupInfo != null)
      {
        paramGroupInfo.setTroopInfoData(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView.a();
      }
      f();
      d(false);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, TroopInfo paramTroopInfo)
  {
    d();
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if (localTroopInfoData == null) {
      return;
    }
    if (paramLong != Long.parseLong(localTroopInfoData.troopUin)) {
      return;
    }
    if (paramBoolean)
    {
      if ((paramTroopInfo.cGroupOption == 4) || (paramTroopInfo.cGroupOption == 5))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        if (QLog.isColorLevel()) {
          QLog.d("VisitorTroopCardFragment.Activity", 2, "troop.isOnlyTroopMemberInviteOption() true");
        }
        paramTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
        if (paramTroopInfo != null)
        {
          paramTroopInfo.cGroupOption = 2;
          paramTroopInfo.setOnlyTroopMemberInviteOption(false);
        }
        paramTroopInfo = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
        paramTroopInfo.cGroupOption = 2;
        paramTroopInfo.isOnlyTroopMemberInvite = false;
      }
      if (!getQBaseActivity().isResume()) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isHomeworkTroop()) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption != 3))
      {
        b(2);
        return;
      }
      e(null);
      return;
    }
    b(2131718739, 1);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onJoinTroopSecurityTips troopUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",tId = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",time = ");
      localStringBuilder.append(paramLong);
      QLog.d("VisitorTroopCardFragment.Activity", 2, localStringBuilder.toString());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)))
    {
      if (paramBoolean) {
        return;
      }
      if ((getQBaseActivity().isResume()) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption == 1) || (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
        ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).JoinTroopSecurityTipsHelper_showTips(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt, paramLong, getActivity());
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      if ((localTroopInfoData != null) && (!TextUtils.isEmpty(localTroopInfoData.troopUin)) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin.equals(paramString1)))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags = TroopInfo.getTags(paramString2);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView.setTroopInfoData(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView.b();
      }
    }
  }
  
  public void a(boolean paramBoolean, List<AvatarInfo> paramList)
  {
    if (paramBoolean)
    {
      v();
      return;
    }
    AvatarWallViewPagerAdapter localAvatarWallViewPagerAdapter = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPagerAdapter;
    if ((localAvatarWallViewPagerAdapter != null) && (localAvatarWallViewPagerAdapter.a(paramList)))
    {
      v();
      a();
      l();
    }
  }
  
  public void aQ_()
  {
    getActivity().runOnUiThread(new VisitorTroopCardFragment.22(this));
  }
  
  protected void b(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).startModifyHomeworkTroopNickname(getActivity(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "join");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).notifyUser(getActivity(), getQBaseActivity().getTitleBarHeight(), paramInt1, paramInt2);
  }
  
  public void b(String paramString)
  {
    if (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)) {
      v();
    }
  }
  
  boolean b()
  {
    TroopAssociationsEntryConfig localTroopAssociationsEntryConfig = (TroopAssociationsEntryConfig)QConfigManager.a().a(686);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localTroopAssociationsEntryConfig != null)
    {
      TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      bool1 = bool2;
      if (localTroopInfoData != null)
      {
        bool1 = bool2;
        if (localTroopAssociationsEntryConfig.a(localTroopInfoData))
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasTroopAssociation()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694668);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VisitorTroopCardFragment.Activity", 2, localException.toString());
      }
    }
  }
  
  public void c(String paramString)
  {
    g(paramString);
  }
  
  protected void c(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "go2AIO mTroopInfoData == null");
      }
      return;
    }
    if (((TroopInfoData)localObject).pa == 3)
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("isNeedFinish", true);
      getActivity().setResult(-1, (Intent)localObject);
      getActivity().finish();
      return;
    }
    Intent localIntent = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getChatActivityIntent(getActivity(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa);
    BaseAIOUtils.a(localIntent, new int[] { 2 });
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    localIntent.putExtra("uintype", 1);
    String str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName;
    TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    localObject = str;
    if (localTroopInfo != null)
    {
      localObject = str;
      if (!TextUtils.isEmpty(localTroopInfo.troopRemark)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopRemark;
      }
    }
    localIntent.putExtra("uinname", (String)localObject);
    if ((paramBoolean) && (this.jdField_d_of_type_Boolean))
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
  }
  
  public void d()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VisitorTroopCardFragment.Activity", 2, localException.toString());
      }
    }
  }
  
  public void d(String paramString)
  {
    if (!getQBaseActivity().isResume()) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      QQToast.a(getActivity(), 2, 2131718221, 1).b(getQBaseActivity().getTitleBarHeight());
    } else {
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).openAddTroopWebInfo(getActivity(), paramString, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    }
    getActivity().finish();
  }
  
  void d(boolean paramBoolean)
  {
    Object localObject = (TroopAssociationsEntryConfig)QConfigManager.a().a(686);
    if (localObject != null)
    {
      TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      if (localTroopInfoData != null)
      {
        if (!((TroopAssociationsEntryConfig)localObject).a(localTroopInfoData)) {
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopAssociationsListWrapper == null) || (paramBoolean))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopAssociationsListWrapper == null) {
            this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopAssociationsListWrapper = new TroopAssociationsListWrapper(this.jdField_a_of_type_ComTencentCommonAppAppInterface, getActivity(), this, this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt);
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopAssociationsListWrapper;
          boolean bool;
          if ((!paramBoolean) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasTroopAssociation())) {
            bool = false;
          } else {
            bool = true;
          }
          ((TroopAssociationsListWrapper)localObject).a(bool);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("refreshTroopAssocitionListV2 troopUin:");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
            ((StringBuilder)localObject).append(" bForce:");
            ((StringBuilder)localObject).append(paramBoolean);
            ((StringBuilder)localObject).append(" hasTroopAssociation:");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasTroopAssociation());
            QLog.d("VisitorTroopCardFragment.Activity", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter != null)
    {
      c();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    }
  }
  
  void f()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
    boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember;
    Object localObject2 = "1";
    if (bool1) {
      localObject1 = "1";
    } else {
      localObject1 = "2";
    }
    VisitorTroopCardReport.a(15, new Object[] { localObject3, localObject1 });
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember;
    Object localObject1 = TDCRecomTroopConfigProcessor.a();
    if (((!bool2) || ((localObject1 != null) && (((TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean)localObject1).jdField_a_of_type_Boolean))) && (!b())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean)localObject1).jdField_a_of_type_JavaLangString))) {
      localObject1 = ((TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean)localObject1).jdField_a_of_type_JavaLangString;
    } else {
      localObject1 = "相关推荐";
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("checkAndInitRecommendList,hasJoinedTroop = ");
      ((StringBuilder)localObject3).append(bool2);
      ((StringBuilder)localObject3).append(",displayOrNot = ");
      ((StringBuilder)localObject3).append(bool1);
      ((StringBuilder)localObject3).append(",recoomTips = ");
      ((StringBuilder)localObject3).append((String)localObject1);
      QLog.d("VisitorTroopCardFragment.Activity", 2, ((StringBuilder)localObject3).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopRecommendTroopDataCardRecomTroopListWrapper == null)
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember) {
        localObject2 = "2";
      }
      VisitorTroopCardReport.a(16, new Object[] { localObject3, localObject2 });
      localObject2 = new TextView(getActivity());
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextColor(getResources().getColor(2131167026));
      ((TextView)localObject2).setTextSize(2, 16.0F);
      ((TextView)localObject2).setPadding(Utils.a(16.0F, getResources()), Utils.a(13.0F, getResources()), 0, Utils.a(5.0F, getResources()));
      ((TextView)localObject2).setClickable(false);
      localObject1 = View.inflate(getActivity(), 2131561565, null);
      ((View)localObject1).setBackgroundResource(2130851081);
      this.jdField_a_of_type_ComTencentMobileqqTroopRecommendTroopDataCardRecomTroopListWrapper = new TroopDataCardRecomTroopListWrapper(this.jdField_a_of_type_ComTencentCommonAppAppInterface, getActivity(), this.jdField_a_of_type_ComTencentWidgetXListView, null, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, bool1, (TextView)localObject2, (View)localObject1);
    }
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
    if (paramInt1 != 1) {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          if (paramInt1 != 4)
          {
            if (paramInt1 != 5)
            {
              if (paramInt1 != 258)
              {
                if (paramInt1 != 260) {
                  return;
                }
                v();
                return;
              }
              a();
            }
            else
            {
              h();
            }
          }
          else {
            d(true);
          }
        }
        else {
          a(paramInt2, paramIntent);
        }
      }
      else
      {
        if ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("select_member_add_request_ok", false))) {
          return;
        }
        this.jdField_i_of_type_Boolean = true;
        return;
      }
    }
    if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("has_operation", false))) {
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
  }
  
  public boolean onBackEvent()
  {
    I();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (!((ITroopCardApi)QRoute.api(ITroopCardApi.class)).isFastDoubleClick())
    {
      int i1 = paramView.getId();
      int i2 = 0;
      Object localObject1;
      Object localObject2;
      if (i1 == 2131379177)
      {
        localObject1 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_e_of_type_JavaLangString });
        localObject2 = new ActivityURIRequest(getActivity(), "/base/browser");
        Intent localIntent = new Intent();
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        localIntent.putExtra("url", (String)localObject1);
        ((ActivityURIRequest)localObject2).extra().putAll(localIntent.getExtras());
        QRoute.startUri((URIRequest)localObject2, null);
      }
      else if (i1 == 2131368033)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead)
        {
          a(false, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim());
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim())
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter;
            if (localObject1 != null) {
              ((VisitorTroopCardPresenter)localObject1).d();
            }
          }
          VisitorTroopCardReport.a(3, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner), Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) });
        }
      }
      else if (i1 == 2131369202)
      {
        I();
        getActivity().finish();
      }
      else if (i1 == 2131369216)
      {
        C();
        TroopReportor.a("grpProfile", "grpProfile_clk", "more_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
      }
      else if (i1 == 2131380907)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()) {
          B();
        } else {
          a(true, false);
        }
      }
      else if (i1 == 2131363819)
      {
        i1 = i2;
        if (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 128))
        {
          i1 = i2;
          if (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 512)) {
            i1 = 1;
          }
        }
        i2 = ((Integer)paramView.getTag()).intValue();
        if ((i1 != 0) && (i2 != 4))
        {
          c();
          ((ITroopMngHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName())).a(Long.valueOf(this.jdField_e_of_type_JavaLangString).longValue(), Long.valueOf(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin()).longValue(), this.jdField_b_of_type_JavaLangString);
          y();
        }
        else
        {
          a(i2, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        }
      }
      else if (i1 == 2131366079)
      {
        TroopReportor.a("grpProfile", "grpProfile_clk", "edit_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
        x();
      }
      else if (i1 == 2131377399)
      {
        E();
        TroopReportor.a("grpProfile", "grpProfile_clk", "share_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
      }
      else if (i1 == 2131379276)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nActiveMemberNum > this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
          ((TroopInfoData)localObject1).nActiveMemberNum = ((TroopInfoData)localObject1).wMemberNum;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {
          i1 = 0;
        } else {
          i1 = 1;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putBoolean("hide_operation_bar", true);
        ((Bundle)localObject1).putBoolean("hideRightButton", true);
        ((Bundle)localObject1).putBoolean("isScreenOrientationPortrait", true);
        ((Bundle)localObject1).putString("uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("https://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        ((StringBuilder)localObject2).append("&role=1&group_level=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nTroopGrade);
        ((StringBuilder)localObject2).append("&group_mem_num=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum);
        ((StringBuilder)localObject2).append("&group_active_num=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nActiveMemberNum);
        ((StringBuilder)localObject2).append("&show_level=");
        ((StringBuilder)localObject2).append(i1);
        ((Bundle)localObject1).putString("url", ((StringBuilder)localObject2).toString());
        localObject2 = new ActivityURIRequest(getActivity(), "/pubaccount/browser");
        ((ActivityURIRequest)localObject2).extra().putAll((Bundle)localObject1);
        QRoute.startUri((URIRequest)localObject2, null);
        TroopReportor.a("grpProfile", "grpProfile_clk", "grpLevel_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
        ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).bnrReport(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 72);
      }
      else if (i1 == 2131369532)
      {
        TroopReportor.a("grpProfile", "grpProfile_clk", "QRcode_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
        w();
      }
      else if (i1 == 2131379377)
      {
        TroopReportor.a("grpProfile", "grpProfile_clk", "grpNumber_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
        D();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if ((localButton != null) && (localButton.getBackground() != null)) {
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(null);
    }
    super.onDestroy();
    try
    {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnDestroy unregisterReceiver, e:");
        localStringBuilder.append(localException.getMessage());
        QLog.e("VisitorTroopCardFragment.Activity", 2, localStringBuilder.toString());
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (localObject != null)
    {
      ((AppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopEssenceMsgObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
    if (localObject != null) {
      ((QQBlurView)localObject).c();
    }
    this.jdField_h_of_type_Boolean = true;
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter;
    if (localObject != null)
    {
      ((VisitorTroopCardPresenter)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopAssociationsListWrapper;
    if (localObject != null) {
      ((TroopAssociationsListWrapper)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopRecommendTroopDataCardRecomTroopListWrapper;
    if (localObject != null) {
      ((TroopDataCardRecomTroopListWrapper)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopshareTempapiITroopShareUtility;
    if (localObject != null) {
      ((ITroopShareUtility)localObject).onDestroy();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("key_clip_info");
    if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VisitorTroopCardFragment.Activity", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter.a(str, paramIntent);
    }
  }
  
  public void onPause()
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (localButton != null) {
      localButton.getBackground().setColorFilter(null);
    }
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
  }
  
  public void onPostThemeChanged()
  {
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if ((!this.jdField_f_of_type_Boolean) && (!bool) && (!c())) {
      i1 = 2131167056;
    } else {
      i1 = 2131167053;
    }
    int i1 = getResources().getColor(i1);
    this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(i1);
    this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(i1);
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setBackgroundColor(-16777216);
    }
  }
  
  public void onResume()
  {
    int i1;
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 512))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetButton;
    if ((localObject != null) && (i1 != 0)) {
      ((Button)localObject).getBackground().setColorFilter(new LightingColorFilter(0, -158425));
    }
    super.onResume();
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      String str = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      TroopReportor.a("Grp_set_new", "grpData_visitor", "exp", 0, 0, new String[] { str, localObject });
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    t();
  }
  
  public void onStart()
  {
    super.onStart();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter;
    if (localObject != null)
    {
      ((VisitorTroopCardPresenter)localObject).a(null, false);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardVisitorTroopCardPresenter.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager;
    if (localObject != null) {
      ((AvatarWallViewPager)localObject).b();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    AvatarWallViewPager localAvatarWallViewPager = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallViewPager;
    if (localAvatarWallViewPager != null) {
      localAvatarWallViewPager.c();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_j_of_type_Boolean))
    {
      this.jdField_j_of_type_Boolean = true;
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.VisitorTroopCardFragment
 * JD-Core Version:    0.7.0.1
 */