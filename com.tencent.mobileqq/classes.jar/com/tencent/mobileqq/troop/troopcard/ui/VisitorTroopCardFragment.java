package com.tencent.mobileqq.troop.troopcard.ui;

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
import com.tencent.mobileqq.troop.temporaryban.TemporaryBanJoinTroopAbilityHelper;
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
import trpc.mizarproto.passthrough.FunctionLockMsg.FunctionLockBeatRsp;

public class VisitorTroopCardFragment
  extends QIphoneTitleBarFragment
  implements View.OnClickListener, IVisitorTroopCardViewInterface, TroopAssociationsListWrapper.ICallbacks
{
  protected View A;
  protected TextView B;
  protected ImageView C;
  protected ImageView D;
  protected View E;
  protected ExpandableTextView F;
  protected ImageView G;
  protected TextView H;
  protected TextView I;
  protected TextView J;
  protected TroopMoreDetailView K;
  protected View L;
  protected Button M;
  protected Button N;
  protected Button O;
  protected ImageView P;
  protected TroopEssenceMsgView Q;
  protected QQProgressDialog R;
  protected QQCustomDialog S = null;
  protected int T;
  protected AlphaAnimation U;
  protected AlphaAnimation V;
  protected TroopInfoData W = new TroopInfoData();
  protected TroopInfo X;
  protected String Y;
  protected String Z;
  protected View a;
  private Intent aA = null;
  private String aB;
  private QQProgressNotifier aC;
  private int aD;
  private TroopAssociationsListWrapper aE;
  private TroopDataCardRecomTroopListWrapper aF;
  private VisitorTroopCardPresenter aG;
  private boolean aH;
  private int aI = 2;
  private long aJ = 0L;
  private TroopNotifyHelper.OnTroopSafeDialogClickConfirm aK = new VisitorTroopCardFragment.12(this);
  protected String aa;
  protected boolean ab;
  protected int ac;
  protected int ad;
  protected int ae = -1;
  public boolean af = true;
  protected int ag = -1;
  protected int ah;
  protected boolean ai;
  protected String aj;
  public boolean ak;
  public AppInterface al;
  protected ITroopShareUtility am;
  protected BroadcastReceiver an = new VisitorTroopCardFragment.1(this);
  protected Animation.AnimationListener ao = new VisitorTroopCardFragment.7(this);
  protected TroopEssenceMsgObserver ap = new VisitorTroopCardFragment.10(this);
  protected TroopMngObserver aq = new VisitorTroopCardFragment.11(this);
  private XListView ar;
  private boolean as = true;
  private AvatarWallViewPagerAdapter at;
  private AvatarWallViewPager au;
  private View av;
  private View aw;
  private boolean ax;
  private boolean ay = false;
  private boolean az;
  protected RelativeLayout b;
  protected TextView c;
  protected TextView d;
  protected ImageView e;
  protected ImmersiveTitleBar2 f;
  protected LinearLayout g;
  protected QQBlurView w;
  protected ImageView x;
  protected TextView y;
  protected TextView z;
  
  private void A()
  {
    TroopInfoData localTroopInfoData = this.W;
    if ((localTroopInfoData != null) && (localTroopInfoData.checkFlagExt4(3)) && (!this.W.checkFreezeReason(2)))
    {
      this.D.setVisibility(0);
      return;
    }
    this.D.setVisibility(8);
  }
  
  private void B()
  {
    this.at = new AvatarWallViewPagerAdapter(new WeakReference(getActivity()), this.au, getResources().getDisplayMetrics().widthPixels, ViewUtils.dip2px(212.0F), this.al, this.W.troopUin, this.W.isMember, null, "Grp_Admin_data");
    this.au.setOnClickListener(this);
    this.au.setAdapter(this.at);
    this.au.setOnPageChangeListener(new VisitorTroopCardFragment.8(this));
  }
  
  private boolean C()
  {
    AvatarWallViewPagerAdapter localAvatarWallViewPagerAdapter = this.at;
    return (localAvatarWallViewPagerAdapter != null) && (localAvatarWallViewPagerAdapter.b().size() > 0);
  }
  
  private void D()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorTroopCardFragment.Activity", 2, String.format("updateTitle mStatusBarShow=%b", new Object[] { Boolean.valueOf(this.as) }));
    }
    boolean bool = ThemeUtil.isInNightMode(this.al);
    if ((!this.as) && (!bool) && (!C())) {
      i = 2131167993;
    } else {
      i = 2131167990;
    }
    int k = getResources().getColor(i);
    int j = 2130844816;
    int i = j;
    if (this.as)
    {
      i = j;
      if (!bool) {
        i = 2130841087;
      }
    }
    Drawable localDrawable = getResources().getDrawable(2130853297);
    localDrawable.setColorFilter(k, PorterDuff.Mode.SRC_ATOP);
    this.c.setTextColor(k);
    this.d.setTextColor(k);
    this.d.setBackgroundDrawable(localDrawable);
    this.e.setImageResource(i);
    this.e.setColorFilter(k);
    e(this.as);
  }
  
  @TargetApi(19)
  private void E()
  {
    if (!ThemeUtil.isDefaultOrDIYTheme(false))
    {
      this.w.setVisibility(8);
      return;
    }
    this.w.setVisibility(0);
    this.w.a(this.ar);
    Object localObject = this.w;
    ((QQBlurView)localObject).b((View)localObject);
    this.w.b(0);
    this.w.a(8.0F);
    this.w.a(4);
    this.w.a(new VisitorTroopCardFragment.9(this));
    this.w.d();
    this.w.a();
    try
    {
      localObject = new BitmapDrawable(((SkinnableNinePatchDrawable)getResources().getDrawable(2130852507)).getBitmap());
      ((BitmapDrawable)localObject).setAlpha(220);
      this.L.setBackground((Drawable)localObject);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      localClassCastException.printStackTrace();
    }
  }
  
  private void F()
  {
    Object localObject = this.aG;
    if (localObject == null) {
      return;
    }
    localObject = ((VisitorTroopCardPresenter)localObject).b(this.W.troopUin);
    this.x.setImageDrawable((Drawable)localObject);
    if ((C()) && (!QQTheme.isNowSimpleUI()))
    {
      this.x.setBackgroundResource(2130850248);
      int i = Utils.a(1.3F, getResources());
      this.x.setPadding(i, i, i, i);
    }
    if ((this.W.hasSetNewTroopHead) || (this.W.isOwnerOrAdim())) {
      this.x.setOnClickListener(this);
    }
  }
  
  private void G()
  {
    try
    {
      if (this.am != null)
      {
        this.am.onDestroy();
        this.am.newTroopShareUtility(getActivity(), this.W);
        this.am.startTroop2DCode();
        return;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      localNullPointerException.printStackTrace();
    }
  }
  
  private void H()
  {
    Bundle localBundle = TroopInfoActivity.a(this.aB, 3, this.W.troopLat, this.W.troopLon, this.W.cityId, this.W.troopLocation);
    localBundle.putInt("troop_type_ex", this.W.troopTypeExt);
    localBundle.putString("leftViewText", getString(2131917545));
    localBundle.putInt("troop_auth_submit_time", getActivity().getIntent().getIntExtra("troop_auth_submit_time", 0));
    localBundle.putInt("troop_info_report_from", 4);
    localBundle.putInt("PARAM_EXIT_ANIMATION", 2);
    ((ITroopInfoActivityApi)QRoute.api(ITroopInfoActivityApi.class)).openTroopProfileForResult(getActivity(), localBundle, 5);
    getActivity().overridePendingTransition(2130771998, 2130771997);
  }
  
  private void I()
  {
    Object localObject = this.W;
    if ((localObject != null) && (!TextUtils.isEmpty(((TroopInfoData)localObject).troopUin)))
    {
      if (TextUtils.isEmpty(this.aa)) {
        return;
      }
      if ((this.aa.length() > 5) && (this.aa.length() <= 11) && (e(this.aa))) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      String str;
      if (this.ab) {
        str = "user_grp";
      } else {
        str = "more_result";
      }
      if (this.W.nStatOption == 10008)
      {
        TroopReportor.a("Grp_all_search", str, "clk_info_add", 0, 0, new String[] { this.W.troopUin, "", localObject, this.aa });
        return;
      }
      if ((this.W.nStatOption != 30014) && (this.W.nStatOption != 30016))
      {
        if ((this.W.nStatOption != 30010) && (this.W.nStatOption != 30012))
        {
          if ((this.W.nStatOption == 30018) || (this.W.nStatOption == 30020)) {
            TroopReportor.a("Grp_all_search", str, "clk_info_add", 0, 0, new String[] { this.W.troopUin, "", localObject, this.aa });
          }
        }
        else {
          TroopReportor.a("Grp_all_search", str, "clk_info_add", 0, 0, new String[] { this.W.troopUin, "", localObject, this.aa });
        }
      }
      else {
        TroopReportor.a("Grp_all_search", str, "clk_info_add", 0, 0, new String[] { this.W.troopUin, "", localObject, this.aa });
      }
    }
  }
  
  private void J()
  {
    VisitorTroopCardReport.a(7, this.W.troopUin);
    String str;
    if (this.W.getStatOption() == 40002) {
      str = "3_40002";
    } else if (this.W.getStatOption() == 40001) {
      str = "3_40001";
    } else {
      str = "";
    }
    TroopNotificationUtils.a(getActivity(), this.W.troopUin, str);
    TroopReportor.a(this.W.troopUin, 0, 0, this.W.getStatOption());
  }
  
  private void K()
  {
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).calJoinTroop(this.W, ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getExposureSource(), this.ag, 2);
    if (!NetworkUtil.isNetSupport(getActivity()))
    {
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).notifyUser(getActivity(), getQBaseActivity().getTitleBarHeight(), 2131892102, 1);
      return;
    }
    VisitorTroopCardPresenter localVisitorTroopCardPresenter = this.aG;
    if (localVisitorTroopCardPresenter == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VisitorTroopCardFragment.Activity", 2, "mVisitorPresenter is null");
      }
      return;
    }
    localVisitorTroopCardPresenter.a(this.W.troopUin, 8390784);
    if (super.getActivity().getIntent().getBooleanExtra("from_babyq", false)) {
      VisitorTroopCardReport.a(14, new Object());
    }
    TroopReportor.a(this.W.troopUin, 0, 0, this.W.getStatOption());
  }
  
  private void L()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(getActivity(), null);
    localActionSheet.addButton(new ActionMenuItem(HardCodeUtil.a(2131899957), 7, 0), 5);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new VisitorTroopCardFragment.13(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void M()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(getActivity(), null);
    if (!P()) {
      localActionSheet.addButton(new ActionMenuItem(getString(2131893965), 9, 0), 5);
    }
    localActionSheet.addButton(new ActionMenuItem(ActionSheetHelper.a(getActivity(), 2131915698), 10, 0), 5);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new VisitorTroopCardFragment.14(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void N()
  {
    if ((!this.W.isOwnerOrAdim()) && (!P())) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(getActivity(), null);
    if (this.W.isOwnerOrAdim()) {
      str = getString(2131897492);
    } else {
      str = getString(2131897495);
    }
    localActionSheet.setMainTitle(str);
    int i;
    if (this.W.isOwnerOrAdim()) {
      i = 2131897493;
    } else {
      i = 2131897494;
    }
    String str = getString(i);
    if (this.W.isOwnerOrAdim()) {
      i = 12;
    } else {
      i = 9;
    }
    localActionSheet.addButton(new ActionMenuItem(str, i, 0), 5);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnBottomCancelListener(new VisitorTroopCardFragment.15(this, localActionSheet));
    localActionSheet.setOnButtonClickListener(new VisitorTroopCardFragment.16(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void O()
  {
    ITroopShareUtility localITroopShareUtility = this.am;
    if (localITroopShareUtility != null)
    {
      localITroopShareUtility.onDestroy();
      this.am.troopUtils_shareTroop(getQBaseActivity(), this.W, this.al);
    }
  }
  
  private boolean P()
  {
    TroopInfoData localTroopInfoData = this.W;
    return (localTroopInfoData != null) && (localTroopInfoData.isMember);
  }
  
  private void Q()
  {
    Object localObject = (ITroopInfoService)this.al.getRuntimeService(ITroopInfoService.class, "");
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((ITroopInfoService)localObject).findTroopInfo(this.W.troopUin);
    }
    this.X = ((TroopInfo)localObject);
    if (this.W.bOwner)
    {
      if ((this.W.dwGroupFlagExt & 0x800) == 0L)
      {
        localObject = this.aG;
        if ((localObject == null) || (((VisitorTroopCardPresenter)localObject).a == 0))
        {
          R();
          break label155;
        }
      }
      S();
    }
    else
    {
      localObject = ActionSheet.create(getActivity());
      ((ActionSheet)localObject).setMainTitle(2131888022);
      ((ActionSheet)localObject).addButton(2131889053, 3);
      ((ActionSheet)localObject).setOnButtonClickListener(new VisitorTroopCardFragment.17(this, (ActionSheet)localObject));
      ((ActionSheet)localObject).addCancelButton(getString(2131887648));
      ((ActionSheet)localObject).show();
    }
    label155:
    VisitorTroopCardReport.a(21, new Object());
  }
  
  private void R()
  {
    String str = getString(2131888016);
    ActionSheet localActionSheet = ActionSheet.create(getActivity());
    localActionSheet.setMainTitle(str);
    localActionSheet.addButton(getString(2131888015), 3);
    localActionSheet.addCancelButton(getString(2131887648));
    localActionSheet.setOnButtonClickListener(new VisitorTroopCardFragment.18(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void S()
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131953338);
    localReportDialog.setContentView(2131627374);
    ((TextView)localReportDialog.findViewById(2131431915)).setVisibility(8);
    TextView localTextView1 = (TextView)localReportDialog.findViewById(2131431902);
    TextView localTextView2 = (TextView)localReportDialog.findViewById(2131431900);
    TextView localTextView3 = (TextView)localReportDialog.findViewById(2131431907);
    String str = HardCodeUtil.a(2131899960);
    localTextView1.setText(getString(2131888017, new Object[] { str, str }));
    localTextView1.setGravity(3);
    localTextView2.setText(2131892267);
    localTextView3.setText(2131887648);
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
  
  private void T()
  {
    if ((this.aA == null) && (getActivity().getIntent().getBooleanExtra("from_newer_guide", false)))
    {
      this.aA = new Intent();
      this.aA.putExtra("uin", this.W.troopUin);
    }
    Intent localIntent2 = this.aA;
    Intent localIntent1 = localIntent2;
    if (this.az)
    {
      localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      localIntent1.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
      this.az = false;
    }
    getActivity().setResult(-1, localIntent1);
  }
  
  private void U()
  {
    if (this.F == null) {
      return;
    }
    v();
  }
  
  private void V()
  {
    int i = this.W.nTroopGrade;
    if (!this.W.isShowActivityGrade()) {
      i = 0;
    }
    if (i > 0)
    {
      Object localObject = String.format(getResources().getString(2131890936), new Object[] { Integer.valueOf(i) });
      this.H.setText((CharSequence)localObject);
      this.H.setContentDescription((CharSequence)localObject);
      this.H.setVisibility(0);
      TextView localTextView = this.H;
      if (C())
      {
        localObject = getResources();
        i = 2131168212;
      }
      else
      {
        localObject = getResources();
        i = 2131167993;
      }
      localTextView.setTextColor(((Resources)localObject).getColor(i));
    }
    else
    {
      this.H.setVisibility(8);
    }
    if (this.ax) {
      this.H.setVisibility(8);
    }
    this.H.setOnClickListener(this);
  }
  
  private void W()
  {
    Object localObject2 = this.W.newTroopName;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = HardCodeUtil.a(2131899958);
    }
    this.y.setVisibility(0);
    this.y.setText((CharSequence)localObject1);
    this.y.setClickable(false);
    Object localObject3 = this.y;
    int i;
    if (C())
    {
      localObject2 = getResources();
      i = 2131168212;
    }
    else
    {
      localObject2 = getResources();
      i = 2131167993;
    }
    ((TextView)localObject3).setTextColor(((Resources)localObject2).getColor(i));
    if (AppSetting.e)
    {
      localObject2 = this.y;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131899946));
      ((StringBuilder)localObject3).append((String)localObject1);
      ((TextView)localObject2).setContentDescription(((StringBuilder)localObject3).toString());
    }
  }
  
  private void a(int paramInt, AppInterface paramAppInterface)
  {
    if (paramInt == 4)
    {
      c(false);
      if (this.ah == 2) {
        VisitorTroopCardReport.a(5, this.W.troopUin);
      }
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).storyReportor(getActivity());
      TroopReportor.a("grpProfile", "grpProfile_clk", "message_click", 0, 0, new String[] { this.W.troopUin });
      return;
    }
    if (paramInt == 3)
    {
      J();
      return;
    }
    if (paramInt == 5)
    {
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).joinGroupOneStep(paramAppInterface, getActivity(), getActivity().getIntent(), this.aG.c);
      VisitorTroopCardReport.a(8, new Object());
      TroopReportor.a(this.W.troopUin, 0, 0, this.W.getStatOption());
      return;
    }
    if (paramInt == 6)
    {
      long l = System.currentTimeMillis();
      if (l - this.aJ > 1000L)
      {
        this.aJ = l;
        I();
        TroopReportor.a("grpProfile", "grpProfile_clk", "join_click", 0, 0, new String[] { this.W.troopUin });
        if (this.W.pa == 34)
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
        String str2 = this.W.troopUin;
        String str1;
        if (this.W.isMember) {
          str1 = "1";
        } else {
          str1 = "0";
        }
        VisitorTroopCardReport.a(13, new Object[] { str2, str1 });
        if ((this.ad == 0) && ((this.W.cGroupOption == 1) || (!TextUtils.isEmpty(this.Y))))
        {
          if (this.W.isHomeworkTroop())
          {
            b(1);
            return;
          }
          f();
          return;
        }
        paramInt = this.ae;
        if ((paramInt != 14) && (paramInt != 5))
        {
          K();
          return;
        }
        ((ITroopMngHandler)paramAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName())).a(Long.valueOf(this.aB).longValue(), Long.valueOf(paramAppInterface.getCurrentUin()).longValue(), this.Z);
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1 = QVipBigTroopExpiredProcessor.e();
    if ((paramBoolean2) && (((QVipBigTroopExpiredConfig)localObject1).mIsEnable) && (this.W.mIsFreezed == 1) && (this.W.isOwnerOrAdim()))
    {
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).FreezedLiangGroup(getActivity(), this.W);
      VisitorTroopCardReport.a(1, new Object());
      return;
    }
    localObject1 = new Bundle();
    ((Bundle)localObject1).putBoolean("IS_COVER", paramBoolean1);
    ((Bundle)localObject1).putBoolean("IS_EDIT", paramBoolean2);
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).handleEditClosed(paramBoolean2, this.x, (Bundle)localObject1);
    Object localObject2 = this.aG;
    if (localObject2 != null) {
      ((VisitorTroopCardPresenter)localObject2).a((Bundle)localObject1, P());
    }
    VisitorTroopCardReport.a(4, this.W.troopUin);
    localObject2 = this.W.troopUin;
    if (P()) {
      localObject1 = "1";
    } else {
      localObject1 = "0";
    }
    TroopReportor.a("Grp_set_new", "grpData_visitor", "clk_head", 0, 0, new String[] { localObject2, localObject1 });
  }
  
  private boolean a(boolean paramBoolean, int paramInt)
  {
    int i;
    if ((TroopInfo.hasPayPrivilege(this.W.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.W.mTroopPrivilegeFlag, 512))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      e();
      if ((paramBoolean) && (paramInt != 0))
      {
        TroopNotifyHelper.a(getActivity(), this.aK, new Object[0]);
        return true;
      }
      J();
      return true;
    }
    return false;
  }
  
  private void c(Bundle paramBundle)
  {
    this.W = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).initTroopInfoData(paramBundle, getActivity());
    this.X = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).initTroopInfo(this.al, this.W, getActivity());
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).setExposureSource(paramBundle.getInt("exposureSource", 99));
    this.ag = paramBundle.getInt("filter_id", -1);
    this.ah = paramBundle.getInt("D2GType");
    this.ai = paramBundle.getBoolean("fromThirdAppByOpenSDK");
    this.aj = getActivity().getIntent().getStringExtra("is_from_game");
    this.Y = paramBundle.getString("authKey");
    this.Z = paramBundle.getString("authSig");
    this.aa = paramBundle.getString("keyword");
    this.ab = paramBundle.getBoolean("isFromNative", false);
    this.ak = paramBundle.getBoolean("troop_info_from_troopsetting", false);
    this.ax = this.W.isQidianPrivateTroop;
    this.aB = this.W.troopUin;
    this.ae = paramBundle.getInt("troop_info_from", -1);
    this.aG = new VisitorTroopCardPresenter();
    this.aG.a(this);
    paramBundle = getActivity().getIntent().getStringExtra("appid");
    String str1 = getActivity().getIntent().getStringExtra("openid");
    String str2 = getActivity().getIntent().getStringExtra("share_uin");
    this.aG.a(paramBundle, str1, str2);
  }
  
  private void e(boolean paramBoolean)
  {
    boolean bool3 = C();
    boolean bool2 = false;
    if (paramBoolean)
    {
      this.b.setVisibility(0);
      this.f.setVisibility(0);
    }
    else
    {
      this.b.setVisibility(4);
      this.f.setVisibility(4);
    }
    boolean bool1 = bool2;
    if (!bool3) {
      if (ThemeUtil.isInNightMode(this.al)) {
        bool1 = bool2;
      } else {
        bool1 = true;
      }
    }
    ImmersiveUtils.setStatusTextColor(bool1, getActivity().getWindow());
    if (paramBoolean) {
      SimpleUIUtil.a(this.f, getActivity().getWindow());
    }
  }
  
  private boolean e(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  private void f(String paramString)
  {
    if ((this.W.cGroupOption != 1) && (this.ac != 1))
    {
      g(paramString);
      return;
    }
    if (this.ad != 0)
    {
      TroopNotifyHelper.a(getActivity(), this.aK, new Object[0]);
      return;
    }
    f();
  }
  
  private void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.W;
      if ((localObject != null) && (((TroopInfoData)localObject).troopUin != null))
      {
        localObject = this.W.troopUin;
        break label35;
      }
    }
    Object localObject = " ";
    label35:
    this.z.setVisibility(0);
    this.z.setText((CharSequence)localObject);
    localObject = this.W;
    if (localObject != null)
    {
      this.z.setClickable(((TroopInfoData)localObject).isNewTroop);
      if (this.W.isNewTroop)
      {
        this.z.setOnClickListener(this);
        TroopReportor.a("grpProfile", "grpProfile_exp", "grpNumberr_exp", 0, 0, new String[] { this.W.troopUin });
      }
    }
    TextView localTextView = this.z;
    int i;
    if (C())
    {
      localObject = getResources();
      i = 2131168212;
    }
    else
    {
      localObject = getResources();
      i = 2131167993;
    }
    localTextView.setTextColor(((Resources)localObject).getColor(i));
  }
  
  private void g(String paramString)
  {
    if (this.W.cGroupOption != 3)
    {
      int i = this.W.getStatOption();
      int j = this.ah;
      if ((j != 1) && (j != 2)) {
        break label43;
      }
      i = 18;
      label43:
      if (!TextUtils.isEmpty(this.W.remark))
      {
        startActivity(((ITroopCardApi)QRoute.api(ITroopCardApi.class)).addFriendLogicActivity_startJoinTroop(getActivity(), this.W.troopUin, this.W.newTroopName, this.W.cGroupOption, i, this.W.mStrJoinQuestion, this.W.mStrJoinAnswer, this.W.remark, getResources().getString(2131887748), this.Y, this.Z, paramString));
        return;
      }
      paramString = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).addFriendLogicActivity_startJoinTroop(getActivity(), this.W.troopUin, this.W.newTroopName, this.W.cGroupOption, i, this.W.mStrJoinQuestion, this.W.mStrJoinAnswer, null, getResources().getString(2131887748), this.Y, this.Z, paramString);
      paramString.putExtra("from_newer_guide", getActivity().getIntent().getBooleanExtra("from_newer_guide", false));
      paramString.putExtra("from_babyq", getActivity().getIntent().getBooleanExtra("from_babyq", false));
      startActivityForResult(paramString, 1);
      return;
    }
    b(2131917537, 0);
  }
  
  private void h(String paramString)
  {
    getActivity().runOnUiThread(new VisitorTroopCardFragment.21(this, paramString));
  }
  
  private void p()
  {
    if (this.c != null)
    {
      Drawable localDrawable = getResources().getDrawable(2130839585);
      this.c.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
      this.c.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131298802));
      ((Animatable)localDrawable).start();
    }
    if (!NetworkUtil.isNetworkAvailable(getActivity())) {
      QQToast.makeText(getActivity(), 1, getString(2131892104), 1).show(getQBaseActivity().getTitleBarHeight());
    }
    ThreadManager.post(new VisitorTroopCardFragment.2(this), 8, null, false);
    y();
    this.ar.setOnScrollListener(new VisitorTroopCardFragment.3(this));
    this.d.setOnClickListener(this);
    this.e.setOnClickListener(this);
  }
  
  private void q()
  {
    this.W.updateForTroopInfo(this.X, this.al.getCurrentAccountUin());
    b();
    F();
    W();
    w();
    A();
    V();
    v();
    this.K.b();
  }
  
  private void r()
  {
    this.f = ((ImmersiveTitleBar2)this.t.findViewById(2131447582));
    this.L = this.t.findViewById(2131429850);
    this.w = ((QQBlurView)this.t.findViewById(2131429645));
    this.ar = ((XListView)this.t.findViewById(2131431170));
    this.ar.setVerticalScrollBarEnabled(false);
    this.ar.setDivider(null);
    int i = this.ar.getPaddingLeft();
    int j = this.ar.getPaddingLeft();
    int k = getResources().getDimensionPixelOffset(2131297461);
    this.ar.setPadding(i, 0, j, k);
    this.g = new LinearLayout(getActivity());
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.g.setLayoutParams(localLayoutParams);
    this.g.setOrientation(1);
    this.t.setBackgroundResource(2130838958);
    x();
    s();
    this.ar.addHeaderView(this.g);
    E();
    z();
  }
  
  @SuppressLint({"NewApi"})
  private void s()
  {
    Object localObject = View.inflate(getActivity(), 2131625905, null);
    this.av = ((View)localObject);
    this.au = ((AvatarWallViewPager)((View)localObject).findViewById(2131449896));
    this.aw = ((View)localObject).findViewById(2131441540);
    B();
    this.g.addView((View)localObject);
    b();
    this.D = ((ImageView)((View)localObject).findViewById(2131441402));
    this.J = ((TextView)((View)localObject).findViewById(2131448072));
    A();
    this.I = ((TextView)((View)localObject).findViewById(2131448114));
    w();
    this.H = ((TextView)((View)localObject).findViewById(2131448013));
    V();
    this.x = ((ImageView)((View)localObject).findViewById(2131434878));
    ((View)localObject).setContentDescription(getResources().getString(2131897491));
    if (SimpleUIUtil.e()) {
      ((View)localObject).setBackground(null);
    }
    F();
    this.y = ((TextView)((View)localObject).findViewById(2131448053));
    W();
    LongClickCopyAction.attachCopyAction(this.y, HardCodeUtil.a(2131912924));
    this.z = ((TextView)((View)localObject).findViewById(2131448117));
    f(true);
    this.P = ((ImageView)((View)localObject).findViewById(2131447913));
    t();
    localObject = HardCodeUtil.a(2131888248);
    String str = this.z.getText().toString();
    localObject = LongClickCopyAction.attachCopyAction(this.z, (String)localObject, str);
    if (localObject != null) {
      ((LongClickCopyAction)localObject).setCopyListener(new VisitorTroopCardFragment.4(this));
    }
    this.A = View.inflate(getActivity(), 2131627887, null);
    this.B = ((TextView)this.A.findViewById(2131448834));
    this.C = ((ImageView)this.A.findViewById(2131436631));
    this.g.addView(this.A);
    u();
    this.E = View.inflate(getActivity(), 2131626723, null);
    this.F = ((ExpandableTextView)this.E.findViewById(2131432665));
    this.G = ((ImageView)this.E.findViewById(2131436414));
    v();
    this.F.getContentTextView().setMovementMethod(LinkMovementMethod.getInstance());
    this.F.setOnExpandStateChangeListener(new VisitorTroopCardFragment.5(this));
    this.g.addView(this.E);
    localObject = View.inflate(getActivity(), 2131627926, null);
    ((View)localObject).setBackgroundResource(2130853313);
    this.g.addView((View)localObject);
    ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298801);
    this.K = new TroopMoreDetailView(getActivity());
    this.K.setGuestVisitor(true);
    this.g.addView(this.K);
    localObject = View.inflate(getActivity(), 2131627926, null);
    ((View)localObject).setBackgroundResource(2130853313);
    this.g.addView((View)localObject);
    ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298801);
    this.Q = new TroopEssenceMsgView(getActivity());
    this.g.addView(this.Q);
    if (QLog.isColorLevel()) {
      QLog.d("VisitorTroopCardFragment.Activity", 2, "mLinearLayoutContentView.addView mTroopEssenceMsgView");
    }
  }
  
  private void t()
  {
    if (((this.W.dwGroupFlagExt & 0x800) != 0L) && ((this.W.dwAuthGroupType == 2L) || (this.W.dwAuthGroupType == 1L)))
    {
      this.P.setVisibility(0);
      this.P.setOnClickListener(this);
      return;
    }
    this.P.setVisibility(8);
  }
  
  private void u()
  {
    if (C())
    {
      if (ThemeUtil.isInNightMode(this.al)) {
        this.A.setBackgroundResource(2130847861);
      } else {
        this.A.setBackgroundResource(2130839083);
      }
    }
    else {
      this.A.setBackgroundResource(2130839622);
    }
    Object localObject = (LinearLayout.LayoutParams)this.A.getLayoutParams();
    this.A.measure(0, 0);
    ((LinearLayout.LayoutParams)localObject).height = (this.A.getMeasuredHeight() + Utils.a(6.0F, getResources()));
    float f1;
    if (C()) {
      f1 = -6.0F;
    } else {
      f1 = 0.0F;
    }
    ((LinearLayout.LayoutParams)localObject).topMargin = Utils.a(f1, getResources());
    this.A.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getDateString(this.W.mTroopCreateTime);
    this.B.setText(new QQText((CharSequence)localObject, 11, 16));
    this.C.setOnClickListener(this);
  }
  
  private void v()
  {
    if (!TextUtils.isEmpty(this.W.mRichFingerMemo))
    {
      this.E.setBackgroundResource(2130839622);
      this.E.setVisibility(0);
      this.F.setText(new QQText(this.W.mRichFingerMemo, 11, 16));
      this.F.post(new VisitorTroopCardFragment.6(this));
      return;
    }
    this.E.setVisibility(8);
  }
  
  private void w()
  {
    boolean bool = this.ax;
    int j = 8;
    if (bool)
    {
      this.I.setVisibility(8);
      this.J.setVisibility(8);
      return;
    }
    this.I.setOnClickListener(this);
    this.I.setVisibility(0);
    int i;
    if (this.W.troopTypeExt == 1)
    {
      this.I.setVisibility(8);
    }
    else if (this.W.troopTypeExt == 0)
    {
      this.I.setVisibility(8);
    }
    else if (this.W.troopTypeExt == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("（");
      ((StringBuilder)localObject).append(getString(2131894046));
      ((StringBuilder)localObject).append("）");
      localObject = ((StringBuilder)localObject).toString();
      this.I.setText((CharSequence)localObject);
      localObject = this.I;
      if (C()) {
        i = getResources().getColor(2131168212);
      } else {
        i = getResources().getColor(2131167993);
      }
      ((TextView)localObject).setTextColor(i);
    }
    else
    {
      if ((this.W.troopTypeExt != 3) && (this.W.troopTypeExt != 4))
      {
        this.I.setVisibility(8);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("（");
      ((StringBuilder)localObject).append(getString(2131894046));
      ((StringBuilder)localObject).append("）");
      localObject = ((StringBuilder)localObject).toString();
      this.I.setText((CharSequence)localObject);
      localObject = this.I;
      if (C()) {
        i = getResources().getColor(2131168212);
      } else {
        i = getResources().getColor(2131167993);
      }
      ((TextView)localObject).setTextColor(i);
    }
    if ((TroopInfo.hasPayPrivilege(this.W.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.W.mTroopPrivilegeFlag, 512))) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject = this.J;
    if (i != 0) {
      j = 0;
    }
    ((TextView)localObject).setVisibility(j);
    if ((!this.W.isMember) && (i != 0))
    {
      this.M.setText(getString(2131890891, new Object[] { new DecimalFormat("0.00").format(this.W.mTroopNeedPayNumber) }));
      this.M.setTag(Integer.valueOf(3));
      this.M.setOnClickListener(this);
      this.M.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      return;
    }
    this.M.getBackground().setColorFilter(null);
  }
  
  private void x()
  {
    this.a = this.t.findViewById(2131447561);
    this.b = ((RelativeLayout)this.t.findViewById(2131447484));
    Object localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.W.newTroopName);
    localStringBuilder.append(" ");
    localStringBuilder.append(getResources().getString(2131887748));
    ((RelativeLayout)localObject).setContentDescription(localStringBuilder.toString());
    this.b.setFocusable(true);
    this.c = ((TextView)this.t.findViewById(2131436227));
    this.c.setText(getResources().getString(2131887748));
    this.d = ((TextView)this.t.findViewById(2131436180));
    localObject = this.d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(getString(2131892338));
    localStringBuilder.append(getString(2131887622));
    ((TextView)localObject).setContentDescription(localStringBuilder.toString());
    this.e = ((ImageView)this.t.findViewById(2131436194));
    this.e.setContentDescription(getString(2131888073));
  }
  
  private void y()
  {
    this.T = 30;
    this.U = new AlphaAnimation(0.0F, 1.0F);
    this.U.setDuration(300L);
    this.U.setInterpolator(getActivity(), 17432581);
    this.U.setAnimationListener(this.ao);
    this.V = new AlphaAnimation(1.0F, 0.0F);
    this.V.setDuration(300L);
    this.V.setInterpolator(getActivity(), 17432581);
    this.V.setAnimationListener(this.ao);
  }
  
  private void z()
  {
    this.L.setVisibility(0);
    this.M = ((Button)this.t.findViewById(2131429754));
    this.M.setVisibility(0);
    this.N = ((Button)this.t.findViewById(2131445798));
    this.O = ((Button)this.t.findViewById(2131432357));
    int i;
    if ((TroopInfo.hasPayPrivilege(this.W.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.W.mTroopPrivilegeFlag, 512))) {
      i = 1;
    } else {
      i = 0;
    }
    if (this.W.isOwnerOrAdim())
    {
      TroopReportor.a("grpProfile", "grpProfile_exp", "edit_exp", 0, 0, new String[] { this.W.troopUin });
      this.O.setVisibility(0);
      this.O.setOnClickListener(this);
    }
    if (this.W.isMember)
    {
      this.M.setText(2131890827);
      this.M.setTag(Integer.valueOf(4));
      this.M.setOnClickListener(this);
      this.N.setVisibility(0);
      this.N.setOnClickListener(this);
      TroopReportor.a("grpProfile", "grpProfile_exp", "share_exp", 0, 0, new String[] { this.W.troopUin });
      TroopReportor.a("grpProfile", "grpProfile_exp", "message_exp", 0, 0, new String[] { this.W.troopUin });
      return;
    }
    if (i != 0)
    {
      this.M.setText(getString(2131890891, new Object[] { new DecimalFormat("0.00").format(this.W.mTroopNeedPayNumber) }));
      this.M.setTag(Integer.valueOf(3));
      this.M.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
      this.M.setOnClickListener(this);
      return;
    }
    if ("true".equals(this.aj))
    {
      this.M.setText(2131891067);
      this.M.setTag(Integer.valueOf(5));
      this.M.setOnClickListener(this);
      this.M.getBackground().setColorFilter(null);
      return;
    }
    if (this.ah == 2) {
      VisitorTroopCardReport.a(18, this.W.troopUin);
    }
    TroopReportor.a("grpProfile", "grpProfile_exp", "join_exp", 0, 0, new String[] { this.W.troopUin });
    this.M.setText(2131897505);
    this.M.setTag(Integer.valueOf(6));
    this.M.setOnClickListener(this);
    this.M.getBackground().setColorFilter(null);
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).secRecognize(true, this.M);
  }
  
  protected int a()
  {
    return 2131629652;
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      TroopDataCardRecomTroopListWrapper localTroopDataCardRecomTroopListWrapper = this.aF;
      if (localTroopDataCardRecomTroopListWrapper != null) {
        localTroopDataCardRecomTroopListWrapper.j();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((1 == paramInt1) && ((getQBaseActivity().isResume()) || (this.W.cGroupOption == 1) || (!TextUtils.isEmpty(this.Y))))
    {
      e();
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).handleJoinTroopFailed(getActivity(), paramInt2);
      return;
    }
    if ((getQBaseActivity().isResume()) && ((paramInt1 == 2) || (paramInt1 == 9)))
    {
      if (this.aC == null) {
        this.aC = new QQProgressNotifier(getActivity());
      }
      this.aC.b(2, 2131889057, 1500);
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
        localObject1 = this.W;
        if (((localObject1 == null) || (((TroopInfoData)localObject1).cGroupOption != 1)) && (TextUtils.isEmpty(this.Y))) {}
      }
      else
      {
        e();
        if (this.aC == null) {
          this.aC = new QQProgressNotifier(getActivity());
        }
        if (paramInt2 != -2)
        {
          if ((paramInt2 != 0) && (paramInt2 != 1))
          {
            if (paramInt2 != 2)
            {
              this.aC.b(2, 2131891060, 1500);
              return;
            }
            this.aC.b(2, 2131917537, 1500);
            return;
          }
          this.aC.b(2, 2131891061, 1500);
          getActivity().finish();
          c(true);
          localObject1 = (ITroopInfoService)this.al.getRuntimeService(ITroopInfoService.class, "");
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
            localObject1 = this.X;
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
            if (this.W != null)
            {
              ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).addRecentTroopItemIntoRecentMsgList(this.al, paramString, this.W.newTroopName, NetConnInfoCenter.getServerTime());
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
          ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).addRecentTroopItemIntoRecentMsgList(this.al, localObject1);
          return;
        }
        ((ITroopMngHandler)this.al.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName())).a(Long.parseLong(paramString), Long.parseLong(this.al.getAccount()));
        return;
      }
    }
    if (getQBaseActivity().isResume()) {
      if (paramInt1 == 3)
      {
        if (paramInt2 == 0)
        {
          paramString = (ITroopInfoService)this.al.getRuntimeService(ITroopInfoService.class, "");
          if (paramString == null) {
            paramString = null;
          } else {
            paramString = paramString.findTroopInfo(this.W.troopUin);
          }
          if ((paramString != null) && (paramString.wMemberNum != this.W.wMemberNum))
          {
            this.W.updateTroopAdmMemberNum(paramString.Administrator, paramString.wMemberNum, this.al.getCurrentAccountUin(), getResources());
            paramString = this.K;
            if (paramString != null)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(HardCodeUtil.a(2131899980));
              ((StringBuilder)localObject1).append(this.W.wMemberNum);
              ((StringBuilder)localObject1).append(HardCodeUtil.a(2131899982));
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
    String str2 = this.W.troopUin;
    String str3 = TroopReportor.a(this.W);
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
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).handleAppShareAction(this.al, getActivity(), paramIntent);
  }
  
  public void a(long paramLong, List<oidb_0x899.memberlist> paramList)
  {
    if (!this.ay)
    {
      if (!TextUtils.equals(this.aB, String.valueOf(paramLong))) {
        return;
      }
      TroopMoreDetailView localTroopMoreDetailView = this.K;
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
      this.am = ((ITroopShareUtility)QRoute.api(ITroopShareUtility.class));
      if (ImmersiveUtils.isSupporImmersive() == 1)
      {
        this.s.setFitsSystemWindows(false);
        this.s.setPadding(0, 0, 0, 0);
      }
      this.al = ((AppInterface)getQBaseActivity().getAppRuntime());
      k();
      c(getActivity().getIntent().getExtras());
      r();
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).preloadWebProcess(this.al);
      TroopReportor.a("grpProfile", "grpProfile_exp", "grpProfile_exp", 0, 0, new String[] { this.W.troopUin });
      TroopReportor.a(this.W.troopUin, 0, 1, this.W.getStatOption());
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).bnrReport(this.al, 65);
      paramLayoutInflater = new IntentFilter();
      paramLayoutInflater.addAction("start_recomend_page");
      paramLayoutInflater.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      getQBaseActivity().registerReceiver(this.an, paramLayoutInflater);
      paramLayoutInflater = this.aq;
      if (paramLayoutInflater != null) {
        this.al.addObserver(paramLayoutInflater);
      }
      paramLayoutInflater = this.ap;
      if (paramLayoutInflater != null) {
        this.al.addObserver(paramLayoutInflater);
      }
      paramLayoutInflater = (ITroopEssenceHandler)this.al.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopEssenceHandlerName());
      paramLayoutInflater = (TroopEssenceMsgEntryInCardConfig)QConfigManager.b().b(715);
      if ((paramLayoutInflater != null) && (paramLayoutInflater.a(this.aB))) {
        if (this.W.isMember)
        {
          paramLayoutInflater = this.X;
          if ((paramLayoutInflater != null) && (paramLayoutInflater.mTroopInfoExtObj.essenceSwitch == 1))
          {
            paramLayoutInflater = (ITroopEssenceHandler)this.al.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopEssenceHandlerName());
            if (paramLayoutInflater != null) {
              paramLayoutInflater.a(this.W.troopUin, 1);
            }
          }
        }
        else
        {
          try
          {
            ((ITroopEssenceHandler)this.al.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopEssenceHandlerName())).a(this.W.troopUin);
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
    QQToast.makeText(getActivity(), getString(2131893841), 1).show(getQBaseActivity().getTitleBarHeight());
  }
  
  public void a(oidb_0x88d.GroupInfo paramGroupInfo)
  {
    Object localObject = this.W;
    if (localObject != null)
    {
      ((TroopInfoData)localObject).coverFrom(paramGroupInfo);
      if (!TextUtils.isEmpty(this.W.newTroopName)) {
        W();
      }
      if (this.W.hasSetNewTroopHead) {
        F();
      }
      boolean bool = QLog.isColorLevel();
      int i = 2;
      if (bool)
      {
        int j = paramGroupInfo.uint32_group_flagext3.get();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ChatSettingForToop_handle88dResp, troopUin=");
        localObject = this.W;
        if (localObject == null) {
          localObject = "";
        } else {
          localObject = ((TroopInfoData)localObject).troopUin;
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", flagExt3=");
        localStringBuilder.append(j);
        localStringBuilder.append(", isQidianPrivateTroop=");
        localStringBuilder.append(TroopInfo.isQidianPrivateTroop(j));
        QLog.d(".troop.qidian_private_troop", 2, localStringBuilder.toString());
      }
      localObject = this.X;
      if (localObject != null)
      {
        ((TroopInfo)localObject).coverFrom(paramGroupInfo);
        this.W.newTroopName = this.X.getNewTroopNameOrTroopName();
        if (!this.X.isNewTroop)
        {
          localObject = this.X;
          ((TroopInfo)localObject).newTroopName = ((TroopInfo)localObject).getNewTroopNameOrTroopName();
        }
        localObject = this.X;
        ((TroopInfo)localObject).oldTroopName = ((TroopInfo)localObject).getNewTroopNameOrTroopName();
      }
      this.ax = TroopInfo.isQidianPrivateTroop(paramGroupInfo.uint32_group_flagext3.get());
      if (this.ax)
      {
        if (this.W.bOwner) {
          i = 1;
        } else if (!this.W.bAdmin) {
          if (this.W.isMember) {
            i = 3;
          } else {
            i = 4;
          }
        }
        ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).reportTask(this.al, this.W.troopUin, i);
      }
      w();
      f(this.ax ^ true);
      u();
      U();
      V();
      A();
      b();
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateTroopInfoToDB(this.X, this.al, this.W.isMember);
      paramGroupInfo = this.K;
      if (paramGroupInfo != null)
      {
        paramGroupInfo.setTroopInfoData(this.W);
        this.K.a();
      }
      h();
      d(false);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, TroopInfo paramTroopInfo)
  {
    e();
    TroopInfoData localTroopInfoData = this.W;
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
        this.W.mStrJoinQuestion = paramTroopInfo.joinTroopQuestion;
        this.W.mStrJoinAnswer = paramTroopInfo.joinTroopAnswer;
      }
      this.W.cGroupOption = ((short)(byte)paramTroopInfo.cGroupOption);
      if (paramTroopInfo.isOnlyTroopMemberInviteOption())
      {
        if (QLog.isColorLevel()) {
          QLog.d("VisitorTroopCardFragment.Activity", 2, "troop.isOnlyTroopMemberInviteOption() true");
        }
        paramTroopInfo = this.X;
        if (paramTroopInfo != null)
        {
          paramTroopInfo.cGroupOption = 2;
          paramTroopInfo.setOnlyTroopMemberInviteOption(false);
        }
        paramTroopInfo = this.W;
        paramTroopInfo.cGroupOption = 2;
        paramTroopInfo.isOnlyTroopMemberInvite = false;
      }
      if (!getQBaseActivity().isResume()) {
        return;
      }
      if ((this.W.isHomeworkTroop()) && (this.W.cGroupOption != 3))
      {
        b(2);
        return;
      }
      f(null);
      return;
    }
    b(2131916242, 1);
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
    if ((this.W != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.W.troopUin)))
    {
      if (paramBoolean) {
        return;
      }
      if ((getQBaseActivity().isResume()) || (this.W.cGroupOption == 1) || (!TextUtils.isEmpty(this.Y))) {
        ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).JoinTroopSecurityTipsHelper_showTips(this.al, paramInt, paramLong, getActivity());
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      TroopInfoData localTroopInfoData = this.W;
      if ((localTroopInfoData != null) && (!TextUtils.isEmpty(localTroopInfoData.troopUin)) && (this.W.troopUin.equals(paramString1)))
      {
        this.W.troopTags = TroopInfo.getTags(paramString2);
        this.K.setTroopInfoData(this.W);
        this.K.b();
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString, FunctionLockMsg.FunctionLockBeatRsp paramFunctionLockBeatRsp)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onJoinTroopTemporaryBan troopUin = ");
      localStringBuilder.append(paramString);
      QLog.d("VisitorTroopCardFragment.Activity", 2, localStringBuilder.toString());
    }
    if ((this.W != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.W.troopUin)))
    {
      if (!getQBaseActivity().isResume()) {
        return;
      }
      e();
      TemporaryBanJoinTroopAbilityHelper.a().a(this.al, getActivity(), paramFunctionLockBeatRsp, paramString);
    }
  }
  
  public void a(boolean paramBoolean, List<AvatarInfo> paramList)
  {
    if (paramBoolean)
    {
      F();
      return;
    }
    AvatarWallViewPagerAdapter localAvatarWallViewPagerAdapter = this.at;
    if ((localAvatarWallViewPagerAdapter != null) && (localAvatarWallViewPagerAdapter.a(paramList)))
    {
      F();
      b();
      u();
    }
  }
  
  public void b()
  {
    Object localObject1 = this.at.b();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateTroopAvatarWall size=");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      QLog.i("VisitorTroopCardFragment.Activity", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.W != null)
    {
      localObject2 = (LinearLayout.LayoutParams)this.av.getLayoutParams();
      int j = getResources().getDisplayMetrics().widthPixels;
      int i;
      if (((List)localObject1).size() > 0)
      {
        i = ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).getScaledCoverHeight(j);
      }
      else
      {
        localObject1 = this.a;
        if ((localObject1 != null) && (this.aw != null))
        {
          ((View)localObject1).measure(0, 0);
          this.aw.measure(0, 0);
          i = this.a.getMeasuredHeight() + this.aw.getMeasuredHeight();
          this.av.setBackgroundResource(2130839622);
        }
        else
        {
          i = 0;
        }
      }
      ((LinearLayout.LayoutParams)localObject2).width = j;
      ((LinearLayout.LayoutParams)localObject2).height = i;
      this.av.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (C())
      {
        localObject1 = this.aw;
        if (localObject1 != null)
        {
          ((View)localObject1).setBackgroundDrawable(null);
          localObject1 = this.aw;
          ((View)localObject1).setPadding(((View)localObject1).getPaddingLeft(), this.aw.getPaddingTop(), this.aw.getPaddingRight(), Utils.a(6.0F, getResources()));
          this.au.setVisibility(0);
          if (!this.as) {
            break label299;
          }
          this.as = false;
          break label299;
        }
      }
      this.au.setVisibility(8);
      if (!this.as) {
        this.as = true;
      }
      label299:
      this.as = false;
      D();
    }
  }
  
  protected void b(int paramInt)
  {
    this.aI = paramInt;
    ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).startModifyHomeworkTroopNickname(getActivity(), this.al.getCurrentAccountUin(), this.W.troopUin, "join");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).notifyUser(getActivity(), getQBaseActivity().getTitleBarHeight(), paramInt1, paramInt2);
  }
  
  public void b(String paramString)
  {
    if (paramString.equals(this.W.troopUin)) {
      F();
    }
  }
  
  public void c()
  {
    getActivity().runOnUiThread(new VisitorTroopCardFragment.22(this));
  }
  
  public void c(String paramString)
  {
    h(paramString);
  }
  
  protected void c(boolean paramBoolean)
  {
    Object localObject = this.W;
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
    Intent localIntent = ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).getChatActivityIntent(getActivity(), this.W.pa);
    BaseAIOUtils.a(localIntent, new int[] { 2 });
    localIntent.putExtra("uin", this.W.troopUin);
    localIntent.putExtra("uintype", 1);
    String str = this.W.newTroopName;
    TroopInfo localTroopInfo = this.X;
    localObject = str;
    if (localTroopInfo != null)
    {
      localObject = str;
      if (!TextUtils.isEmpty(localTroopInfo.troopRemark)) {
        localObject = this.X.troopRemark;
      }
    }
    localIntent.putExtra("uinname", (String)localObject);
    if ((paramBoolean) && (this.ai))
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
      if (this.R == null)
      {
        this.R = new QQProgressDialog(getActivity(), getQBaseActivity().getTitleBarHeight());
        this.R.c(2131892360);
        this.R.c(false);
      }
      this.R.show();
      return;
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
      QQToast.makeText(getActivity(), 2, 2131915703, 1).show(getQBaseActivity().getTitleBarHeight());
    } else {
      ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).openAddTroopWebInfo(getActivity(), paramString, this.W.troopUin);
    }
    getActivity().finish();
  }
  
  void d(boolean paramBoolean)
  {
    Object localObject = (TroopAssociationsEntryConfig)QConfigManager.b().b(686);
    if (localObject != null)
    {
      TroopInfoData localTroopInfoData = this.W;
      if (localTroopInfoData != null)
      {
        if (!((TroopAssociationsEntryConfig)localObject).a(localTroopInfoData)) {
          return;
        }
        if ((this.aE == null) || (paramBoolean))
        {
          if (this.aE == null) {
            this.aE = new TroopAssociationsListWrapper(this.al, getActivity(), this, this.ar, this.g, this.W.troopUin, this.W.dwGroupClassExt);
          }
          localObject = this.aE;
          boolean bool;
          if ((!paramBoolean) && (!this.W.hasTroopAssociation())) {
            bool = false;
          } else {
            bool = true;
          }
          ((TroopAssociationsListWrapper)localObject).a(bool);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("refreshTroopAssocitionListV2 troopUin:");
            ((StringBuilder)localObject).append(this.W.troopUin);
            ((StringBuilder)localObject).append(" bForce:");
            ((StringBuilder)localObject).append(paramBoolean);
            ((StringBuilder)localObject).append(" hasTroopAssociation:");
            ((StringBuilder)localObject).append(this.W.hasTroopAssociation());
            QLog.d("VisitorTroopCardFragment.Activity", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  public void e()
  {
    try
    {
      if ((this.R != null) && (this.R.isShowing()))
      {
        this.R.dismiss();
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
  
  protected void f()
  {
    if (this.aG != null)
    {
      d();
      this.aG.b(this.Y, this.Z);
    }
  }
  
  boolean g()
  {
    TroopAssociationsEntryConfig localTroopAssociationsEntryConfig = (TroopAssociationsEntryConfig)QConfigManager.b().b(686);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localTroopAssociationsEntryConfig != null)
    {
      TroopInfoData localTroopInfoData = this.W;
      bool1 = bool2;
      if (localTroopInfoData != null)
      {
        bool1 = bool2;
        if (localTroopAssociationsEntryConfig.a(localTroopInfoData))
        {
          bool1 = bool2;
          if (this.W.hasTroopAssociation()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  void h()
  {
    Object localObject3 = this.W.troopUin;
    boolean bool1 = this.W.isMember;
    Object localObject2 = "1";
    if (bool1) {
      localObject1 = "1";
    } else {
      localObject1 = "2";
    }
    VisitorTroopCardReport.a(15, new Object[] { localObject3, localObject1 });
    boolean bool2 = this.W.isMember;
    Object localObject1 = TDCRecomTroopConfigProcessor.a();
    if (((!bool2) || ((localObject1 != null) && (((TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean)localObject1).a))) && (!g())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty(((TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean)localObject1).b))) {
      localObject1 = ((TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean)localObject1).b;
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
    if (this.aF == null)
    {
      localObject3 = this.W.troopUin;
      if (!this.W.isMember) {
        localObject2 = "2";
      }
      VisitorTroopCardReport.a(16, new Object[] { localObject3, localObject2 });
      localObject2 = new TextView(getActivity());
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextColor(getResources().getColor(2131167962));
      ((TextView)localObject2).setTextSize(2, 16.0F);
      ((TextView)localObject2).setPadding(Utils.a(16.0F, getResources()), Utils.a(13.0F, getResources()), 0, Utils.a(5.0F, getResources()));
      ((TextView)localObject2).setClickable(false);
      localObject1 = View.inflate(getActivity(), 2131627926, null);
      ((View)localObject1).setBackgroundResource(2130853313);
      this.aF = new TroopDataCardRecomTroopListWrapper(this.al, getActivity(), this.ar, null, this.W.troopUin, bool1, (TextView)localObject2, (View)localObject1);
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
                F();
                return;
              }
              b();
            }
            else
            {
              q();
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
        this.az = true;
        return;
      }
    }
    if ((paramInt2 == -1) && (paramIntent != null) && (paramIntent.getBooleanExtra("has_operation", false))) {
      this.aA = paramIntent;
    }
  }
  
  public boolean onBackEvent()
  {
    T();
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    if (!((ITroopCardApi)QRoute.api(ITroopCardApi.class)).isFastDoubleClick())
    {
      int i = paramView.getId();
      int j = 0;
      Object localObject1;
      Object localObject2;
      if (i == 2131447913)
      {
        localObject1 = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.aB });
        localObject2 = new ActivityURIRequest(getActivity(), "/base/browser");
        Intent localIntent = new Intent();
        localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        localIntent.putExtra("url", (String)localObject1);
        ((ActivityURIRequest)localObject2).extra().putAll(localIntent.getExtras());
        QRoute.startUri((URIRequest)localObject2, null);
      }
      else if (i == 2131434878)
      {
        if (this.W.hasSetNewTroopHead)
        {
          a(false, this.W.isOwnerOrAdim());
        }
        else
        {
          if (this.W.isOwnerOrAdim())
          {
            localObject1 = this.aG;
            if (localObject1 != null) {
              ((VisitorTroopCardPresenter)localObject1).d();
            }
          }
          VisitorTroopCardReport.a(3, new Object[] { this.W.troopUin, Boolean.valueOf(this.W.bOwner), Boolean.valueOf(this.W.bAdmin) });
        }
      }
      else if (i == 2131436180)
      {
        T();
        getActivity().finish();
      }
      else if (i == 2131436194)
      {
        M();
        TroopReportor.a("grpProfile", "grpProfile_clk", "more_exp", 0, 0, new String[] { this.W.troopUin });
      }
      else if (i == 2131449896)
      {
        if (this.W.isOwnerOrAdim()) {
          L();
        } else {
          a(true, false);
        }
      }
      else if (i == 2131429754)
      {
        i = j;
        if (TroopInfo.hasPayPrivilege(this.W.mTroopPrivilegeFlag, 128))
        {
          i = j;
          if (TroopInfo.hasPayPrivilege(this.W.mTroopPrivilegeFlag, 512)) {
            i = 1;
          }
        }
        j = ((Integer)paramView.getTag()).intValue();
        if ((i != 0) && (j != 4))
        {
          d();
          ((ITroopMngHandler)this.al.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName())).a(Long.valueOf(this.aB).longValue(), Long.valueOf(this.al.getCurrentUin()).longValue(), this.Z);
          I();
        }
        else
        {
          a(j, this.al);
        }
      }
      else if (i == 2131432357)
      {
        TroopReportor.a("grpProfile", "grpProfile_clk", "edit_click", 0, 0, new String[] { this.W.troopUin });
        H();
      }
      else if (i == 2131445798)
      {
        O();
        TroopReportor.a("grpProfile", "grpProfile_clk", "share_click", 0, 0, new String[] { this.W.troopUin });
      }
      else if (i == 2131448013)
      {
        if (this.W.nActiveMemberNum > this.W.wMemberNum)
        {
          localObject1 = this.W;
          ((TroopInfoData)localObject1).nActiveMemberNum = ((TroopInfoData)localObject1).wMemberNum;
        }
        if ((this.W.dwGroupFlagExt & 0x800000) != 8388608L) {
          i = 0;
        } else {
          i = 1;
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putBoolean("hide_operation_bar", true);
        ((Bundle)localObject1).putBoolean("hideRightButton", true);
        ((Bundle)localObject1).putBoolean("isScreenOrientationPortrait", true);
        ((Bundle)localObject1).putString("uin", this.al.getCurrentAccountUin());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("https://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=");
        ((StringBuilder)localObject2).append(this.W.troopUin);
        ((StringBuilder)localObject2).append("&role=1&group_level=");
        ((StringBuilder)localObject2).append(this.W.nTroopGrade);
        ((StringBuilder)localObject2).append("&group_mem_num=");
        ((StringBuilder)localObject2).append(this.W.wMemberNum);
        ((StringBuilder)localObject2).append("&group_active_num=");
        ((StringBuilder)localObject2).append(this.W.nActiveMemberNum);
        ((StringBuilder)localObject2).append("&show_level=");
        ((StringBuilder)localObject2).append(i);
        ((Bundle)localObject1).putString("url", ((StringBuilder)localObject2).toString());
        localObject2 = new ActivityURIRequest(getActivity(), "/pubaccount/browser");
        ((ActivityURIRequest)localObject2).extra().putAll((Bundle)localObject1);
        QRoute.startUri((URIRequest)localObject2, null);
        TroopReportor.a("grpProfile", "grpProfile_clk", "grpLevel_click", 0, 0, new String[] { this.W.troopUin });
        ((ITroopCardApi)QRoute.api(ITroopCardApi.class)).bnrReport(this.al, 72);
      }
      else if (i == 2131436631)
      {
        TroopReportor.a("grpProfile", "grpProfile_clk", "QRcode_click", 0, 0, new String[] { this.W.troopUin });
        G();
      }
      else if (i == 2131448117)
      {
        TroopReportor.a("grpProfile", "grpProfile_clk", "grpNumber_click", 0, 0, new String[] { this.W.troopUin });
        N();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    Button localButton = this.M;
    if ((localButton != null) && (localButton.getBackground() != null)) {
      this.M.getBackground().setColorFilter(null);
    }
    super.onDestroy();
    try
    {
      getActivity().unregisterReceiver(this.an);
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
    Object localObject = this.al;
    if (localObject != null)
    {
      ((AppInterface)localObject).removeObserver(this.aq);
      this.al.removeObserver(this.ap);
    }
    localObject = this.w;
    if (localObject != null) {
      ((QQBlurView)localObject).c();
    }
    this.ay = true;
    localObject = this.aG;
    if (localObject != null)
    {
      ((VisitorTroopCardPresenter)localObject).a();
      this.aG = null;
    }
    localObject = this.aE;
    if (localObject != null) {
      ((TroopAssociationsListWrapper)localObject).c();
    }
    localObject = this.aF;
    if (localObject != null) {
      ((TroopDataCardRecomTroopListWrapper)localObject).e();
    }
    localObject = this.am;
    if (localObject != null) {
      ((ITroopShareUtility)localObject).onDestroy();
    }
    this.S = null;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    paramIntent = paramIntent.getStringExtra("key_clip_info");
    if ((!TextUtils.isEmpty(str)) && (this.aG != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VisitorTroopCardFragment.Activity", 2, String.format("doOnNewIntent clip=%s path=%s", new Object[] { paramIntent, str }));
      }
      this.aG.a(str, paramIntent);
    }
  }
  
  public void onPause()
  {
    Button localButton = this.M;
    if (localButton != null) {
      localButton.getBackground().setColorFilter(null);
    }
    super.onPause();
    this.w.b();
  }
  
  public void onPostThemeChanged()
  {
    boolean bool = ThemeUtil.isInNightMode(this.al);
    if ((!this.as) && (!bool) && (!C())) {
      i = 2131167993;
    } else {
      i = 2131167990;
    }
    int i = getResources().getColor(i);
    this.y.setTextColor(i);
    this.z.setTextColor(i);
    if (bool)
    {
      this.w.setVisibility(8);
      this.L.setBackgroundColor(-16777216);
    }
  }
  
  public void onResume()
  {
    int i;
    if ((TroopInfo.hasPayPrivilege(this.W.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.W.mTroopPrivilegeFlag, 512))) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject = this.M;
    if ((localObject != null) && (i != 0)) {
      ((Button)localObject).getBackground().setColorFilter(new LightingColorFilter(0, -158425));
    }
    super.onResume();
    if (this.af)
    {
      this.af = false;
      String str = this.W.troopUin;
      if (this.W.isMember) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      TroopReportor.a("Grp_set_new", "grpData_visitor", "exp", 0, 0, new String[] { str, localObject });
    }
    this.w.a();
    D();
  }
  
  public void onStart()
  {
    super.onStart();
    Object localObject = this.aG;
    if (localObject != null)
    {
      ((VisitorTroopCardPresenter)localObject).a(null, false);
      this.aG.a(this.W.troopUin);
    }
    localObject = this.au;
    if (localObject != null) {
      ((AvatarWallViewPager)localObject).c();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    AvatarWallViewPager localAvatarWallViewPager = this.au;
    if (localAvatarWallViewPager != null) {
      localAvatarWallViewPager.d();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.aH))
    {
      this.aH = true;
      p();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.VisitorTroopCardFragment
 * JD-Core Version:    0.7.0.1
 */