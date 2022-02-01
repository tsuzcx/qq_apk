package com.tencent.mobileqq.troop.troopsetting.activity;

import KQQ.BatchResponse;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.InflateException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHandler;
import com.tencent.mobileqq.troop.announcement.api.TroopAnnouncementObserver;
import com.tencent.mobileqq.troop.api.IBizTroopInfoService;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.api.handler.ITroopBatchInfohandler;
import com.tencent.mobileqq.troop.api.handler.ITroopCommonlyUsedHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberCardHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopModifyHandler;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopModifyObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.mobileqq.troop.association.api.ITroopAssociationHandler;
import com.tencent.mobileqq.troop.association.api.TroopAssociationObserver;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig.EffectInfo;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectConfig.EffectInfoData;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.troop.fans.api.ITroopFansHandler;
import com.tencent.mobileqq.troop.fans.api.ITroopFansService;
import com.tencent.mobileqq.troop.fans.api.TroopFansObserver;
import com.tencent.mobileqq.troop.fans.data.TroopFansInfo.IdolItem;
import com.tencent.mobileqq.troop.handler.TroopBatchInfoHandler;
import com.tencent.mobileqq.troop.handler.TroopListHandler;
import com.tencent.mobileqq.troop.handler.TroopMemberCardHandler;
import com.tencent.mobileqq.troop.handler.TroopMemberInfoHandler;
import com.tencent.mobileqq.troop.handler.TroopMngHandler;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.keyword.EntryStatus;
import com.tencent.mobileqq.troop.luckycharacter.api.ITroopLuckyCharacterHandler;
import com.tencent.mobileqq.troop.luckycharacter.api.TroopLuckyCharacterObserver;
import com.tencent.mobileqq.troop.luckycharacter.config.TroopLuckyCharacterConfig;
import com.tencent.mobileqq.troop.observer.TroopRedDotObserver;
import com.tencent.mobileqq.troop.onlinemember.api.TroopOnlineMemberObserver;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotHandler;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.robot.api.TroopRobotObserver;
import com.tencent.mobileqq.troop.showexternal.api.ITroopShowExternalHandler;
import com.tencent.mobileqq.troop.showexternal.api.TroopShowExternalObserver;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppHandler;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi;
import com.tencent.mobileqq.troop.troopapps.api.ITroopCardAppInfoHelperApi.IGetAppInfoCB;
import com.tencent.mobileqq.troop.troopapps.api.TroopAppObserver;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import com.tencent.mobileqq.troop.troopcard.ui.TroopMoreDetailView;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameHandler;
import com.tencent.mobileqq.troop.troopgame.api.TroopGameObserver;
import com.tencent.mobileqq.troop.troopgame.handler.TroopGameHandler;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.troopsetting.api.ITroopSettingHandler;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.mobileqq.troop.troopsetting.ui.RobotMemberFormItem;
import com.tencent.mobileqq.troop.troopsetting.ui.RoundedBackgroundSpan;
import com.tencent.mobileqq.troop.troopurl.config.TroopUrlConfBean;
import com.tencent.mobileqq.troop.troopurl.config.TroopUrlConfProcessor;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troop.widget.ExpandableTextView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.DeleteRecordDialog;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.QMultiImageTextView;
import com.tencent.widget.Switch;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import com.tencent.widget.XSimpleListAdapter;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Ltencent.im.oidb.cmd0x899.oidb_0x899.memberlist;>;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x787.oidb_0x787.LevelName;
import tencent.im.oidb.cmd0x787.oidb_0x787.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.RspBody;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.AppInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopSettingActivity
  extends QBaseActivity
  implements View.OnClickListener, View.OnLongClickListener, CompoundButton.OnCheckedChangeListener, DecodeTaskCompletionListener, HttpWebCgiAsyncTask.Callback
{
  public static final ArrayList<Integer> L = new ArrayList(6);
  public static String ar = "https://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi";
  protected TroopSettingActivity.ListAdapter A;
  protected List<oidb_0x899.memberlist> B;
  protected List<Long> C = new ArrayList();
  protected IFaceDecoder D;
  protected int E = 0;
  protected int F = 0;
  protected int G = 0;
  protected int H = 0;
  protected int I = 5;
  boolean J = false;
  boolean K = false;
  protected int M;
  protected List<oidb_0x899.memberlist> N;
  protected DisplayMetrics O;
  protected boolean P = false;
  protected boolean Q = false;
  protected boolean R = false;
  protected Drawable S;
  View.OnClickListener T;
  XListView U;
  protected ImageView V;
  protected ITroopCardAppInfoHelperApi W;
  protected IRoamSettingService X;
  protected boolean Y = false;
  protected ArrayList<TroopAppInfo> Z;
  protected ImmersiveTitleBar2 a;
  long aA = 0L;
  public QQProgressDialog aB = null;
  protected int aC = -1;
  public Handler aD = new TroopSettingActivity.27(this);
  TroopObserver aE = new TroopSettingActivity.28(this);
  TroopRedDotObserver aF = new TroopSettingActivity.29(this);
  TroopModifyObserver aG = new TroopSettingActivity.30(this);
  TroopSettingObserver aH = new TroopSettingActivity.31(this);
  TroopAnnouncementObserver aI = new TroopSettingActivity.32(this);
  TroopAppObserver aJ = new TroopSettingActivity.33(this);
  TroopShowExternalObserver aK = new TroopSettingActivity.34(this);
  TroopOnlineMemberObserver aL = new TroopSettingActivity.35(this);
  TroopMngObserver aM = new TroopSettingActivity.36(this);
  TroopGameObserver aN = new TroopSettingActivity.37(this);
  TroopLuckyCharacterObserver aO = new TroopSettingActivity.38(this);
  AvatarObserver aP = new TroopSettingActivity.39(this);
  RoamSettingObserver aQ = new TroopSettingActivity.40(this);
  protected boolean aR = false;
  TroopCommonlyUsedObserver aS = new TroopSettingActivity.53(this);
  TroopFansObserver aT = new TroopSettingActivity.54(this);
  protected QQProgressDialog aU;
  protected View.OnClickListener aV = new TroopSettingActivity.55(this);
  protected QQCustomDialog aW = null;
  protected Handler aX;
  protected boolean aY = false;
  protected BaseMessageObserver aZ = new TroopSettingActivity.60(this);
  protected String aa;
  protected String ab;
  protected boolean ac;
  protected int ad = 0;
  protected GroupCatalogBean ae = null;
  public Intent af = null;
  public TextView ag;
  public TextView ah;
  protected String ai = "";
  String aj;
  String ak;
  String al;
  String am;
  String an;
  String ao;
  String ap;
  String aq;
  public boolean as = true;
  public TroopUrlConfBean at;
  protected BroadcastReceiver au = new TroopSettingActivity.6(this);
  protected View av = null;
  protected Runnable aw = new TroopSettingActivity.14(this);
  protected int ax;
  protected ITroopCardAppInfoHelperApi.IGetAppInfoCB ay = new TroopSettingActivity.20(this);
  protected Runnable az = new TroopSettingActivity.23(this);
  protected LinearLayout b;
  View.OnTouchListener ba = new TroopSettingActivity.MyViewAlphaOnTouchListener();
  IApolloExtensionObserver bb = new TroopSettingActivity.64(this);
  private String bc;
  private QQCustomDialog bd;
  private RobotMemberFormItem be;
  private boolean bf = false;
  private boolean bg;
  private boolean bh;
  private boolean bi = false;
  private Dialog bj = null;
  private boolean bk = false;
  private ArrayList<Long> bl = new ArrayList();
  private boolean bm = false;
  private AppInterface bn;
  private TroopPushObserver bo = new TroopSettingActivity.1(this);
  private TroopAssociationObserver bp = new TroopSettingActivity.2(this);
  private TroopRobotObserver bq = new TroopSettingActivity.3(this);
  private int br = 2;
  private boolean bs;
  private QFormSimpleItem bt;
  private View.OnLayoutChangeListener bu = new TroopSettingActivity.13(this);
  private boolean bv = true;
  protected View c;
  protected Button d;
  protected Button e;
  protected QQBlurView f;
  protected Button g;
  protected View[] h;
  protected TroopInfoData i = new TroopInfoData();
  protected boolean j = false;
  protected volatile boolean k = false;
  protected boolean l = false;
  protected int m;
  protected QQProgressNotifier n;
  protected View o;
  protected RelativeLayout p;
  protected TextView q;
  protected TextView r;
  protected ImageView s;
  protected TroopInfo t;
  protected boolean u;
  protected List<Integer> v;
  List<ImageView> w;
  TroopMoreDetailView x;
  protected View y = null;
  protected MyGridView z;
  
  static
  {
    L.add(Integer.valueOf(2131448102));
    L.add(Integer.valueOf(2131448103));
    L.add(Integer.valueOf(2131448104));
    L.add(Integer.valueOf(2131448105));
    L.add(Integer.valueOf(2131448106));
    L.add(Integer.valueOf(2131448107));
  }
  
  private void A()
  {
    c(getResources().getString(2131897586));
    Object localObject = new QFormSimpleItem(this);
    this.h[17] = localObject;
    a(17, 1, (QFormSimpleItem)localObject, HardCodeUtil.a(2131899975), "", true);
    this.b.addView((View)localObject);
    TroopReportor.a("Grp_set_new", "grpData_admin", "chatBG_exp", 0, 0, new String[] { this.i.troopUin });
    if (!this.u)
    {
      localObject = new QFormSimpleItem(this);
      this.h[18] = localObject;
      this.b.addView((View)localObject);
      a(18, 2, (QFormSimpleItem)localObject, getString(2131917436), "", true);
      ((QFormSimpleItem)localObject).setVisibility(8);
      localObject = (ITroopEnterEffectService)this.bn.getRuntimeService(ITroopEnterEffectService.class, "all");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initUI  effectManager.isAllTroopShowEnterance() = ");
        localStringBuilder.append(((ITroopEnterEffectService)localObject).isAllTroopShowEnterance());
        QLog.d("Q.chatopttroop", 2, localStringBuilder.toString());
      }
      if (((ITroopEnterEffectService)localObject).isAllTroopShowEnterance()) {
        a(true);
      }
    }
    c(false);
    localObject = new QFormSimpleItem(this);
    a(1010, 2, (QFormSimpleItem)localObject, getString(2131892202), getString(2131916309), true);
    this.b.addView((View)localObject);
    this.bt = ((QFormSimpleItem)localObject);
    TroopReportor.a("Grp_set_new", "grpData_admin", "grpNotice_exp", 0, 0, new String[] { this.i.troopUin });
    if ((!((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) && (((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).keyWordIsEnable()))
    {
      localObject = new QFormSimpleItem(this);
      this.h[40] = localObject;
      a(40, 2, (QFormSimpleItem)localObject, getString(2131897528), "", true);
      this.b.addView((View)localObject);
    }
    localObject = new FormSwitchItem(this, null);
    ((FormSwitchItem)localObject).setBackgroundResource(2130839629);
    ((FormSwitchItem)localObject).setText(getString(2131894125));
    ((FormSwitchItem)localObject).getTextView().setTextColor(getResources().getColorStateList(2131167993));
    ((FormSwitchItem)localObject).setFocusable(true);
    ((FormSwitchItem)localObject).getBackground().setAlpha(255);
    ((FormSwitchItem)localObject).setContentDescription(getString(2131894125));
    this.h[10] = localObject;
    ((FormSwitchItem)localObject).getSwitch().setTag(Integer.valueOf(10));
    aA();
    this.b.addView((View)localObject);
    TroopReportor.a("Grp_set_new", "grpData_admin", "hideMessage_exp", 0, 0, new String[] { this.i.troopUin });
    localObject = View.inflate(this, 2131627926, null);
    ((View)localObject).setBackgroundResource(2130853313);
    this.b.addView((View)localObject);
    ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298801);
  }
  
  private void A(int paramInt)
  {
    if (paramInt != 49) {
      return;
    }
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/browser");
    String str = "https://qun.qq.com/v2/luckyword/index?qunid={GROUPCODE}&_wv=67108865&_nav_txtclr=FFFFFF&_wvSb=0&source=enter".replace("{GROUPCODE}", this.i.troopUin);
    localActivityURIRequest.extra().putString("url", str);
    localActivityURIRequest.setRequestCode(19);
    QRoute.startUri(localActivityURIRequest, null);
    TroopReportor.a("Grp_set_new", "grpData_admin", "Luckyword_entry_clk", 0, 0, new String[] { this.i.troopUin });
  }
  
  private void B()
  {
    c(getResources().getString(2131897587));
    if (((ITroopHonorService)this.bn.getRuntimeService(ITroopHonorService.class, "")).isGrayTroopHonor(this.i.troopUin))
    {
      localObject1 = new FormSwitchItem(this, null);
      localObject2 = new QFormSimpleItem(this, null);
      ((QFormSimpleItem)localObject2).a(true);
      ((QFormSimpleItem)localObject2).setBgType(1);
      ((QFormSimpleItem)localObject2).setLeftText(getResources().getString(2131897518));
      int i2 = 2131897515;
      TroopInfo localTroopInfo = this.t;
      int i1 = i2;
      if (localTroopInfo != null)
      {
        i1 = i2;
        if (localTroopInfo.isHomeworkTroop()) {
          i1 = 2131897516;
        }
      }
      ((QFormSimpleItem)localObject2).setRightText(getResources().getString(i1));
      ((QFormSimpleItem)localObject2).setContentDescription(getResources().getString(2131897518));
      ((FormSwitchItem)localObject1).getTextView().setTextColor(getResources().getColorStateList(2131167993));
      ((QFormSimpleItem)localObject2).setFocusable(true);
      ((QFormSimpleItem)localObject2).getBackground().setAlpha(255);
      this.h[32] = localObject2;
      ((QFormSimpleItem)localObject2).setTag(Integer.valueOf(32));
      ((QFormSimpleItem)localObject2).setOnClickListener(this);
      this.b.addView((View)localObject2);
      TroopReportor.a("Grp_set_new", "grpData_admin", "grpHonour_exp", 0, 0, new String[] { this.i.troopUin });
      ReportController.b(null, "dc00898", "", "", "0X800A6EE", "0X800A6EE", 0, 0, "", "", "", "");
    }
    Object localObject1 = View.inflate(this, 2131627911, null);
    this.h[49] = localObject1;
    a(49, 3, (View)localObject1, getString(2131897530), "", true);
    ((View)localObject1).setTag(Integer.valueOf(49));
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131429628);
    if (localObject2 != null) {
      ((TextView)localObject2).setVisibility(8);
    }
    ((View)localObject1).setOnClickListener(this);
    if (this.K)
    {
      TroopReportor.a("Grp_set_new", "grpData_admin", "Luckyword_entry_exp", 0, 0, new String[] { this.i.troopUin });
      ((View)localObject1).setVisibility(0);
    }
    else
    {
      ((View)localObject1).setVisibility(8);
    }
    this.b.addView((View)localObject1);
  }
  
  private void B(int paramInt)
  {
    if (paramInt != 34) {
      return;
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).troopShareUtilityDestroy();
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).initTroopShareUtility(this, this.i, this.bn);
    AppInterface localAppInterface = this.bn;
    if (!this.i.hasSetNewTroopHead) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getExposureSourceReportVal());
    localStringBuilder.append("");
    ReportController.b(localAppInterface, "dc00898", "", "", "0X800A525", "0X800A525", paramInt, 0, localStringBuilder.toString(), "", "", "");
  }
  
  private void C()
  {
    c(getResources().getString(2131897583));
    Object localObject1 = this.t;
    boolean bool = false;
    if ((localObject1 != null) && (((TroopInfo)localObject1).isHomeworkTroop()))
    {
      localObject1 = new QFormSimpleItem(this);
      a(1006, 1, (QFormSimpleItem)localObject1, HardCodeUtil.a(2131899990), "", true);
      this.b.addView((View)localObject1);
      TroopReportor.a("Grp_edu", "Grp_data", "teachermsg_Show", 0, 0, new String[] { this.i.troopUin });
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    localObject1 = new QFormSimpleItem(this);
    if (i1 != 0) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    a(1001, i1, (QFormSimpleItem)localObject1, getString(2131893871), HardCodeUtil.a(2131899956), true);
    this.b.addView((View)localObject1);
    TroopReportor.a("Grp_set_new", "grpData_admin", "chatRecord_exp", 0, 0, new String[] { this.i.troopUin });
    localObject1 = new FormSwitchItem(this, null);
    ((FormSwitchItem)localObject1).setBgType(2);
    ((FormSwitchItem)localObject1).setText(getString(2131890183));
    ((FormSwitchItem)localObject1).getTextView().setTextColor(getResources().getColorStateList(2131167993));
    ((FormSwitchItem)localObject1).setFocusable(true);
    ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
    ((FormSwitchItem)localObject1).setContentDescription(getString(2131890183));
    this.h[7] = localObject1;
    Object localObject2 = ((FormSwitchItem)localObject1).getSwitch();
    if (((ITroopInfoService)this.bn.getRuntimeService(ITroopInfoService.class, "")).isCommonlyUsedTroop(this.i.troopUin)) {
      ((Switch)localObject2).setChecked(true);
    } else {
      ((Switch)localObject2).setChecked(false);
    }
    ((Switch)localObject2).setTag(Integer.valueOf(7));
    ((Switch)localObject2).setOnCheckedChangeListener(this);
    this.b.addView((View)localObject1);
    localObject1 = new FormSwitchItem(this, null);
    ((FormSwitchItem)localObject1).setBackgroundResource(2130839632);
    ((FormSwitchItem)localObject1).setBgType(2);
    ((FormSwitchItem)localObject1).setText(getString(2131890184));
    ((FormSwitchItem)localObject1).getTextView().setTextColor(getResources().getColorStateList(2131167993));
    ((FormSwitchItem)localObject1).setFocusable(true);
    ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
    ((FormSwitchItem)localObject1).setContentDescription(getString(2131890184));
    this.h[8] = localObject1;
    localObject2 = ((FormSwitchItem)localObject1).getSwitch();
    ((Switch)localObject2).setTag(Boolean.FALSE);
    int i1 = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getTroopMask(this.bn, this.i.troopUin);
    Object localObject3 = this.t;
    if (localObject3 != null) {
      ((TroopInfo)localObject3).troopmask = i1;
    }
    if (i1 != 1) {
      bool = true;
    }
    ((Switch)localObject2).setChecked(bool);
    ((Switch)localObject2).setOnCheckedChangeListener(new TroopSettingActivity.11(this));
    this.b.addView((View)localObject1);
    localObject1 = View.inflate(this, 2131627908, null);
    localObject2 = (QFormSimpleItem)((View)localObject1).findViewById(2131436145);
    a(9, 0, (QFormSimpleItem)localObject2, getString(2131917405), "", true);
    this.V = new ImageView(this);
    localObject3 = new RelativeLayout.LayoutParams(Utils.a(17.0F, getResources()), Utils.a(17.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = Utils.a(30.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject3).addRule(11);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((QFormSimpleItem)localObject2).addView(this.V, (ViewGroup.LayoutParams)localObject3);
    this.V.setImageDrawable(getResources().getDrawable(2130839585));
    this.V.setVisibility(8);
    this.h[9] = localObject1;
    this.b.addView((View)localObject1);
  }
  
  private void C(int paramInt)
  {
    if (paramInt != 46) {
      return;
    }
    Object localObject = this.i;
    if ((localObject != null) && (!TextUtils.isEmpty(((TroopInfoData)localObject).troopUin)))
    {
      if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch())
      {
        QQToast.makeText(this, getString(2131897590), 0).show(getTitleBarHeight());
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, new Object[] { "onclick:StudyMode Forbidden context = ", this });
        }
        return;
      }
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startFansTroopIdolPage(this, this.i.troopUin, this.t.getFansTroopStarId(), 21);
      ReportController.b(this.bn, "dc00898", "", "", "0X800B596", "0X800B596", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel())
    {
      localObject = this.i;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = ((TroopInfoData)localObject).troopUin;
      }
      QLog.d("Q.chatopttroop", 2, new Object[] { "onclick: troopUin = ", localObject });
    }
  }
  
  private void D()
  {
    if (!this.i.isOwnerOrAdim()) {
      return;
    }
    c(getResources().getString(2131897585));
    Object localObject2 = (FormItemRelativeLayout)View.inflate(this, 2131627911, null);
    this.h[5] = localObject2;
    this.b.addView((View)localObject2);
    a((View)localObject2, null);
    ((FormItemRelativeLayout)localObject2).setTag(Integer.valueOf(5));
    ((FormItemRelativeLayout)localObject2).setBGType(1);
    ((FormItemRelativeLayout)localObject2).setOnClickListener(this);
    int i1;
    if (this.i.bOwner) {
      i1 = 2131899943;
    } else {
      i1 = 2131899949;
    }
    Object localObject3 = HardCodeUtil.a(i1);
    a(5, 3, (View)localObject2, getString(2131917507), (CharSequence)localObject3, true);
    if ((this.i.isOwnerOrAdim()) && (this.k)) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((FormItemRelativeLayout)localObject2).setVisibility(i1);
    if (i1 == 0) {
      TroopReportor.a("Grp_set_new", "grpData_admin", "manageGrp_exp", 0, 0, new String[] { this.i.troopUin });
    }
    Object localObject1 = (TextView)((FormItemRelativeLayout)localObject2).findViewById(2131444790);
    ((TextView)localObject1).setText((CharSequence)localObject3);
    b((View)localObject2);
    localObject2 = (ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("RED_POINT_KEY_TROOP_ASSOCIATION_MANAGE_ENTRY");
    ((StringBuilder)localObject3).append(this.bn.getCurrentAccountUin());
    this.bh = ((ITroopUtilsApi)localObject2).isEmptyRedPointSP(((StringBuilder)localObject3).toString());
    localObject2 = (ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class);
    localObject3 = this.t;
    boolean bool;
    if (localObject3 == null) {
      bool = false;
    } else {
      bool = ((TroopInfo)localObject3).isKingBattleTroop();
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_");
    ((StringBuilder)localObject3).append(this.bn.getCurrentAccountUin());
    this.bg = ((ITroopUtilsApi)localObject2).isShowKingTeamRedPoint(bool, ((StringBuilder)localObject3).toString());
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isUpdateBeforeSomeVersion(this, "8.0.5"), "RED_POINT_KEY_TROOP_ADMIN", this.bg, this.bh, (TextView)localObject1);
    this.k = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).checkPlugin(this.bn, new TroopSettingActivity.12(this));
    if (((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).isRobotSwitchOn(this.bn))
    {
      this.be = new RobotMemberFormItem(this, getString(2131917610));
      this.be.a().setBackgroundResource(2130839629);
      localObject1 = this.be.a();
      if (localObject1 != null)
      {
        if (((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getBeAllMemberShowRed(this.bn)) {
          this.bf = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getRobotItemRedShowed(this.bn);
        } else if (this.i.isOwnerOrAdim()) {
          this.bf = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getRobotItemRedShowed(this.bn);
        } else {
          this.bf = false;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("bShowRed red robot");
          ((StringBuilder)localObject2).append(this.bf);
          QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject2).toString());
        }
        this.be.a(this.bf);
        this.b.addView((View)localObject1);
        ((View)localObject1).setOnClickListener(this);
        ((View)localObject1).setTag(Integer.valueOf(1009));
        ReportController.b(this.bn, "dc00898", "", "", "", "0X8009F9B", 0, 0, "", "", "", "");
      }
    }
    else
    {
      QLog.i("Q.chatopttroop", 2, "RobotSwithOff");
    }
  }
  
  private void D(int paramInt)
  {
    if (paramInt != 50) {
      return;
    }
    TroopInfoData localTroopInfoData = this.i;
    if ((localTroopInfoData != null) && (this.t != null)) {
      a(localTroopInfoData.troopUin, this.i.troopCode, this.i.troopName, this.t.troopRemark);
    }
  }
  
  private void E()
  {
    c(getResources().getString(2131897584));
    Object localObject = View.inflate(this, 2131627911, null);
    this.h[14] = localObject;
    this.b.addView((View)localObject);
    ((View)localObject).setTag(Integer.valueOf(14));
    a(14, 2, (View)localObject, getString(2131888754), "", true);
    f();
    b((View)localObject);
    localObject = View.inflate(this, 2131627911, null);
    this.h[25] = localObject;
    this.b.addView((View)localObject);
    ((View)localObject).setTag(Integer.valueOf(25));
    a(25, 2, (View)localObject, getString(2131897499), "", true);
    a(this.u ^ true, this.i.isNewTroop);
    b((View)localObject);
    if ((!this.u) && (this.i.isNewTroop)) {
      TroopReportor.a("Grp_set_new", "grpData_admin", "search_upgrade_exp", 0, 0, new String[] { this.i.troopUin });
    }
    localObject = View.inflate(this, 2131627911, null);
    this.h[4] = localObject;
    this.b.addView((View)localObject);
    a((View)localObject, null);
    a(4, 2, (View)localObject, getString(2131897545), "", true);
    ((View)localObject).setTag(Integer.valueOf(4));
    ((View)localObject).setOnClickListener(this);
    QFormSimpleItem localQFormSimpleItem = new QFormSimpleItem(this);
    this.h[6] = localQFormSimpleItem;
    this.b.addView(localQFormSimpleItem);
    String str = getString(2131892062);
    if (TextUtils.isEmpty(this.i.troopColorNick)) {
      localObject = getString(2131895353);
    } else {
      localObject = this.i.troopColorNick;
    }
    a(6, 3, localQFormSimpleItem, str, (CharSequence)localObject, true);
    if (!TextUtils.isEmpty(this.i.troopColorNick))
    {
      localObject = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(this.i.troopColorNick, 16);
      localQFormSimpleItem.setRightText((CharSequence)localObject);
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).setColorText(this.bn, localQFormSimpleItem.getRightTextView(), (Spannable)localObject);
    }
    if (localQFormSimpleItem.getRightTextView() != null) {
      localQFormSimpleItem.getRightTextView().setCompoundDrawablePadding(ViewUtils.dpToPx(9.0F));
    }
    S();
  }
  
  private void E(int paramInt)
  {
    if (this.t == null)
    {
      localObject = (ITroopInfoService)this.bn.getRuntimeService(ITroopInfoService.class, "");
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((ITroopInfoService)localObject).findTroopInfo(this.i.troopUin);
      }
      this.t = ((TroopInfo)localObject);
    }
    Object localObject = this.t;
    if ((localObject != null) && ((paramInt & 0x1) > 0)) {
      c(((TroopInfo)localObject).cGroupOption);
    }
  }
  
  private void F()
  {
    View localView = View.inflate(this, 2131625902, null);
    this.h[13] = localView;
    localView.getBackground().setAlpha(255);
    this.b.addView(localView);
    localView.setVisibility(8);
  }
  
  private void F(int paramInt)
  {
    if (paramInt != -1) {
      return;
    }
    Intent localIntent = BaseAIOUtils.a(new Intent(), null);
    localIntent.putExtra("uin", this.i.troopUin);
    localIntent.putExtra("uinname", this.t.getTroopDisplayName());
    localIntent.putExtra("uintype", 1);
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/start/splash");
    localActivityURIRequest.extra().putAll(localIntent.getExtras());
    localActivityURIRequest.setFlags(localIntent.getFlags());
    QRoute.startUri(localActivityURIRequest, null);
    setResult(-1);
    finish();
  }
  
  private void G()
  {
    View localView = View.inflate(this, 2131627919, null);
    this.h[0] = localView;
    localView.setTag(Integer.valueOf(0));
    localView.setBackgroundResource(2130839632);
    localView.setOnClickListener(this);
    this.b.addView(localView);
    this.ag = ((TextView)localView.findViewById(2131438047));
    TextView localTextView = this.ag;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131899964));
    localStringBuilder.append(this.i.wMemberNum);
    localStringBuilder.append(HardCodeUtil.a(2131899971));
    localTextView.setText(localStringBuilder.toString());
    if (AppSetting.e)
    {
      localTextView = this.ag;
      localTextView.setPadding(0, Utils.a(12.0F, localTextView.getResources()), Utils.a(3.0F, this.ag.getResources()), Utils.a(12.0F, this.ag.getResources()));
    }
    a(localView);
    this.z = ((MyGridView)localView.findViewById(2131438045));
    this.z.setFadingEdgeLength(0);
    I();
    localView = View.inflate(this, 2131627926, null);
    localView.setBackgroundResource(2130853313);
    this.b.addView(localView);
    localView.getLayoutParams().height = getResources().getDimensionPixelSize(2131298801);
  }
  
  private void G(int paramInt)
  {
    this.br = paramInt;
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startModifyHomeworkTroopNickname(this, this.bn.getCurrentAccountUin(), this.i.troopUin, "join");
  }
  
  private void H()
  {
    QFormSimpleItem localQFormSimpleItem = (QFormSimpleItem)this.h[40];
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).initKeyword(this.bn, this.i.troopUin, this.P, localQFormSimpleItem);
  }
  
  private void H(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, String.format("count = %s", new Object[] { Integer.valueOf(paramInt) }));
    }
    View localView = this.h[43];
    if (localView == null) {
      return;
    }
    if (paramInt > 0)
    {
      Object localObject = this.i;
      if (localObject != null) {
        ReportController.b(this.bn, "dc00898", "", ((TroopInfoData)localObject).troopUin, "0X800B4AD", "0X800B4AD", 0, 0, String.valueOf(this.i.dwGroupClassExt), "", "", "");
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getResources().getString(2131897488));
      ((StringBuilder)localObject).append(String.valueOf(paramInt));
      ((StringBuilder)localObject).append(getResources().getString(2131897489));
      localObject = ((StringBuilder)localObject).toString();
      a(43, 2, localView, getResources().getString(2131897490), " ", true);
      TextView localTextView1 = (TextView)localView.findViewById(2131429628);
      TextView localTextView2 = (TextView)localView.findViewById(2131444790);
      if (localTextView1 != null) {
        localTextView1.setVisibility(8);
      }
      if (localTextView2 != null) {
        localTextView2.setText((CharSequence)localObject);
      }
      localView.setTag(Integer.valueOf(43));
      localView.setOnClickListener(this);
      localView.setVisibility(0);
      return;
    }
    localView.setVisibility(8);
  }
  
  private void I()
  {
    int i1 = getResources().getDisplayMetrics().widthPixels;
    float f1 = getResources().getDisplayMetrics().density;
    int i2 = (int)(24.0F * f1);
    int i3 = (int)(20.0F * f1);
    i1 = (i1 - i2) / ((int)(50.0F * f1) + i3);
    i2 = (int)(10.0F * f1);
    this.E = i2;
    this.F = i2;
    this.G = ((int)(5.0F * f1));
    this.H = ((int)(f1 * 17.0F));
    this.I = i1;
    this.z.setPadding(this.E, this.G, this.F, this.H);
  }
  
  private void J()
  {
    View localView = this.h[26];
    if (localView != null)
    {
      if (this.i.hasSetNewTroopHead)
      {
        SpannableString localSpannableString = new SpannableString("[Avatar]");
        Drawable localDrawable = K();
        if (localDrawable != null)
        {
          localDrawable.setBounds(0, 0, ScreenUtil.dip2px(32.0F), ScreenUtil.dip2px(32.0F));
          localSpannableString.setSpan(new ImageSpan(localDrawable, 0), 0, localSpannableString.length(), 17);
          a(localView, localSpannableString, null, null);
        }
      }
      else
      {
        a(localView, null, null, HardCodeUtil.a(2131899984));
      }
      localView.setOnClickListener(this);
    }
    localView = this.h[35];
    if (localView != null) {
      ((ImageView)localView).setImageDrawable(K());
    }
  }
  
  private Drawable K()
  {
    Object localObject1 = this.D;
    if (localObject1 != null)
    {
      localObject2 = ((IFaceDecoder)localObject1).getBitmapFromCache(4, this.i.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.D.isPausing())
        {
          this.D.requestDecodeFace(this.i.troopUin, 4, true);
          localObject1 = localObject2;
        }
      }
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = BaseImageUtil.k();
    }
    return new BitmapDrawable((Bitmap)localObject2);
  }
  
  private boolean L()
  {
    byte[] arrayOfByte = ((ITroopAppService)this.bn.getRuntimeService(ITroopAppService.class, "all")).getTroopAppListData(this.i.troopUin);
    if (arrayOfByte != null) {}
    try
    {
      oidb_0xe83.RspBody localRspBody = new oidb_0xe83.RspBody();
      localRspBody.mergeFrom(arrayOfByte);
      a(localRspBody);
      return true;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      label54:
      label89:
      break label54;
    }
    if (QLog.isColorLevel())
    {
      QLog.w("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData exception");
      break label89;
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData==null");
      }
    }
    return false;
  }
  
  private void M()
  {
    byte[] arrayOfByte = ((ITroopAppService)this.bn.getRuntimeService(ITroopAppService.class, "all")).getTroopAppListData(this.i.troopUin);
    if (arrayOfByte != null) {}
    try
    {
      oidb_0xe83.RspBody localRspBody = new oidb_0xe83.RspBody();
      localRspBody.mergeFrom(arrayOfByte);
      a(localRspBody);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      label53:
      break label53;
    }
    if (QLog.isColorLevel())
    {
      QLog.w("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData exception");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop.troop.troop_app", 2, "init, cached troopAppListData==null");
      }
    }
  }
  
  private void N()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ChatSettingForTroop quitTroop mTroopInfoData.bOwner = ");
      ((StringBuilder)localObject).append(this.i.bOwner);
      QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
    }
    if (this.t == null)
    {
      localObject = (ITroopInfoService)this.bn.getRuntimeService(ITroopInfoService.class, "");
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((ITroopInfoService)localObject).findTroopInfo(this.i.troopUin);
      }
      this.t = ((TroopInfo)localObject);
    }
    if (this.i.bOwner)
    {
      if (((this.i.dwGroupFlagExt & 0x800) == 0L) && (this.ad == 0)) {
        P();
      } else {
        O();
      }
    }
    else
    {
      localObject = ActionSheet.create(this);
      ((ActionSheet)localObject).setMainTitle(2131888022);
      ((ActionSheet)localObject).addButton(2131889053, 3);
      ((ActionSheet)localObject).setOnButtonClickListener(new TroopSettingActivity.16(this, (ActionSheet)localObject));
      ((ActionSheet)localObject).addCancelButton(getString(2131887648));
      ((ActionSheet)localObject).show();
    }
    if (this.i.bOwner) {
      localObject = "0";
    } else if (this.i.bAdmin) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    ReportController.b(this.bn, "dc00899", "Grp_set", "", "Grp_data", "Clk_quitgrp", 0, 0, this.i.troopUin, (String)localObject, "", "");
  }
  
  private void O()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop showDisbandTroopAlertWindow");
    }
    ReportDialog localReportDialog = new ReportDialog(this, 2131953338);
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
    localTextView2.setOnClickListener(new TroopSettingActivity.17(this, localReportDialog));
    localTextView3.setOnClickListener(new TroopSettingActivity.18(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void P()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop troopDisband");
    }
    getString(2131888717);
    String str = getString(2131888016);
    ActionSheet localActionSheet = ActionSheet.create(this);
    localActionSheet.setMainTitle(str);
    localActionSheet.addButton(getString(2131888015), 3);
    localActionSheet.addCancelButton(getString(2131887648));
    localActionSheet.setOnButtonClickListener(new TroopSettingActivity.19(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void Q()
  {
    TroopInfo localTroopInfo = this.t;
    if (localTroopInfo != null)
    {
      if (TextUtils.isEmpty(localTroopInfo.troopuin)) {
        return;
      }
      long l1 = 0L;
      try
      {
        long l2 = Long.valueOf(this.t.troopuin).longValue();
        l1 = l2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      ((ITroopBatchInfohandler)this.bn.getBusinessHandler(TroopBatchInfoHandler.class.getName())).a(l1, true, 1);
      this.W.getAppInfoBriefList(this.i.troopUin, this.ay);
    }
  }
  
  private void R()
  {
    ITroopMemberListHandler localITroopMemberListHandler = (ITroopMemberListHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberListHandlerName());
    if (this.i.wMemberNum <= 100) {
      localITroopMemberListHandler.a(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).stringToLong(this.i.troopUin), 0L, 5, 100, 0);
    }
  }
  
  private void S()
  {
    Object localObject = View.inflate(this, 2131627926, null);
    ((View)localObject).setBackgroundResource(2130853313);
    this.b.addView((View)localObject);
    ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131299336);
    localObject = View.inflate(this, 2131627911, null);
    this.h[50] = localObject;
    this.b.addView((View)localObject);
    ((View)localObject).setTag(Integer.valueOf(50));
    localObject = this.t;
    if (localObject != null) {
      localObject = ((TroopInfo)localObject).troopRemark;
    } else {
      localObject = "";
    }
    e((String)localObject);
    ReportController.b(this.bn, "dc00899", "Grp_set_new", "", "groupnameRemarks", "entrance_exp", 0, 0, this.i.troopUin, "", "", "");
  }
  
  private void T()
  {
    int i1;
    if ((((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).isGroupEntranceSwitchOn()) && (this.i.isFansTroop())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      View localView = View.inflate(this, 2131627926, null);
      localView.setBackgroundResource(2130853313);
      this.b.addView(localView);
      localView.getLayoutParams().height = getResources().getDimensionPixelSize(2131299336);
      if (this.t != null)
      {
        localView = View.inflate(this, 2131627911, null);
        if (this.t.getFansTroopStarId() == 0)
        {
          this.h[45] = localView;
          this.b.addView(localView);
          localView.setTag(Integer.valueOf(45));
          e(localView);
        }
        else
        {
          this.h[46] = localView;
          this.b.addView(localView);
          localView.setTag(Integer.valueOf(46));
          localView.setVisibility(8);
          U();
        }
        b(localView);
        ReportController.b(this.bn, "dc00898", "", "", "0X800B595", "0X800B595", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void U()
  {
    TroopFansInfo.IdolItem localIdolItem = ((ITroopFansService)this.bn.getRuntimeService(ITroopFansService.class, "")).getTroopIdolInfoDate(this.i.troopUin);
    if (localIdolItem != null) {
      a(localIdolItem.b, localIdolItem.e);
    }
  }
  
  private void V()
  {
    if (!((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).isGroupEntranceSwitchOn()) {
      return;
    }
    Object localObject1 = this.t;
    if ((localObject1 != null) && (((TroopInfo)localObject1).isFansTroop()) && (this.t.getFansTroopStarId() != 0))
    {
      localObject1 = (ITroopFansHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopFansHandlerName());
      if (localObject1 != null) {
        ((ITroopFansHandler)localObject1).a(this.t.troopuin);
      }
    }
    else
    {
      localObject1 = this.h;
      Object localObject2 = localObject1[45];
      localObject1 = localObject1[46];
      if ((localObject2 == null) && (localObject1 == null)) {
        return;
      }
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
      e((View)localObject1);
    }
  }
  
  private void W()
  {
    if (this.t == null) {
      return;
    }
    Object localObject1 = (Boolean)this.X.getMapRequest().get(this.t.troopuin);
    if ((localObject1 != null) && (((Boolean)localObject1).booleanValue())) {
      return;
    }
    ReportController.b(this.bn, "P_CliOper", "Grp_msg", "", "data_page", "Clk_set", 0, 0, this.t.troopuin, "", "0", "");
    Object localObject2 = this.t.getTroopDisplayName();
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.t.troopuin;
    }
    localObject2 = (ActionSheet)((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).actionSheetHelperCreateDialog(this, null);
    ((ActionSheet)localObject2).setMainTitle(getString(2131917048, new Object[] { localObject1 }));
    ((ActionSheet)localObject2).addRadioButton(getString(2131895430), false);
    ((ActionSheet)localObject2).addRadioButton(getString(2131895426), false);
    ((ActionSheet)localObject2).addRadioButton(getString(2131895422), false);
    int i1 = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getTroopMask(this.bn, this.i.troopUin);
    if (i1 != 1) {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 == 4) {
            ((ActionSheet)localObject2).setRadioButtonChecked(0);
          }
        }
        else {
          ((ActionSheet)localObject2).setRadioButtonChecked(2);
        }
      }
      else {
        ((ActionSheet)localObject2).setRadioButtonChecked(1);
      }
    }
    ((ActionSheet)localObject2).addCancelButton(2131887648);
    ((ActionSheet)localObject2).setOnButtonClickListener(new TroopSettingActivity.24(this, i1, (ActionSheet)localObject2));
    ((ActionSheet)localObject2).show();
  }
  
  private boolean X()
  {
    TroopInfoData localTroopInfoData = this.i;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool2;
    if (localTroopInfoData != null)
    {
      bool1 = bool2;
      if (this.t != null)
      {
        bool1 = bool2;
        if (localTroopInfoData.bOwner)
        {
          boolean bool4 = this.i.hasSetNewTroopHead;
          boolean bool5 = TextUtils.isEmpty(this.t.mTroopPicListJson);
          boolean bool6 = TextUtils.isEmpty(this.i.troopLocation);
          if (this.i.dwGroupClassExt <= 0L) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          bool2 = bool3;
          if (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopTagNeedRedDot(this.i.dwGroupClassExt)) {
            if (this.i.troopTags != null)
            {
              bool2 = bool3;
              if (!this.i.troopTags.isEmpty()) {}
            }
            else
            {
              bool2 = true;
            }
          }
          bool3 = TextUtils.isEmpty(this.i.mRichFingerMemo);
          bool1 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopEditInfoRedExist(this.bn, this.i.troopUin, new boolean[] { bool4 ^ true, bool5, bool6, bool1, bool2, bool3 }, new int[] { 11, 12, 5, 4, 8, 6 });
        }
      }
    }
    return bool1;
  }
  
  private void Y()
  {
    try
    {
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).troopShareUtilityDestroy();
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).newTroopShareUtility(this, this.i);
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startTroop2DCode();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.d("Q.chatopttroop", 1, "gotoTroopQRCodeActivity NullPointerException ", localNullPointerException);
    }
  }
  
  private void Z()
  {
    QQCustomDialog localQQCustomDialog = this.bd;
    if ((localQQCustomDialog == null) || (localQQCustomDialog.isShowing())) {}
    try
    {
      this.bd.dismiss();
      label23:
      this.bd = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
  
  private String a(String paramString, int paramInt)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4) {
          return paramString;
        }
        return getString(2131895430);
      }
      return getString(2131890189);
    }
    return getString(2131895426);
  }
  
  private String a(oidb_0xe83.AppInfo paramAppInfo)
  {
    String str = paramAppInfo.name.get();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    paramAppInfo = str;
    if (str.length() > 4)
    {
      paramAppInfo = new StringBuilder();
      paramAppInfo.append(str.substring(0, 4));
      paramAppInfo.append("...");
      paramAppInfo = paramAppInfo.toString();
    }
    return paramAppInfo;
  }
  
  private void a(int paramInt, View paramView)
  {
    if (paramInt != 3) {
      return;
    }
    paramView = paramView.getTag(2131446818);
    if ((paramView instanceof String))
    {
      paramView = (String)paramView;
      if (((ITroopRobotService)this.bn.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramView))
      {
        ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).openRobotProfileCard(this, this.i.troopUin, paramView);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("selfSet_leftViewText", getString(2131917557));
      localBundle.putString("custom_leftbackbutton_name", getTitle().toString());
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).openTroopmemberCard(this.bn, this, this.i.troopUin, paramView, 1, -1, localBundle);
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    o();
    if (this.n == null) {
      this.n = new QQProgressNotifier(this);
    }
    if (paramInt != -2)
    {
      if ((paramInt != 0) && (paramInt != 1))
      {
        if (paramInt != 2) {
          this.n.b(2, 2131891060, 1500);
        } else {
          this.n.b(2, 2131917537, 1500);
        }
      }
      else
      {
        this.n.b(2, 2131891061, 1500);
        finish();
        d(true);
        ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).addRecentTroopItemIntoRecentMsgList(this.bn, paramString);
      }
    }
    else {
      ((ITroopMngHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName())).a(Long.parseLong(paramString), Long.parseLong(this.bn.getAccount()));
    }
    this.aa = null;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(BatchResponse paramBatchResponse, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    if (paramBatchResponse.seq != 0) {
      return;
    }
    if (paramOIDBSSOPkg != null)
    {
      if (!paramOIDBSSOPkg.bytes_bodybuffer.has()) {
        return;
      }
      paramBatchResponse = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      try
      {
        paramOIDBSSOPkg = new oidb_0x88d.RspBody();
        paramOIDBSSOPkg.mergeFrom(paramBatchResponse);
        paramBatchResponse = null;
        paramOIDBSSOPkg = paramOIDBSSOPkg.stzrspgroupinfo.get();
        int i2 = 0;
        int i1;
        if (paramOIDBSSOPkg == null) {
          i1 = 0;
        } else {
          i1 = paramOIDBSSOPkg.size();
        }
        while ((paramBatchResponse == null) && (i2 < i1))
        {
          Object localObject = (oidb_0x88d.RspGroupInfo)paramOIDBSSOPkg.get(i2);
          if (localObject != null)
          {
            int i3 = ((oidb_0x88d.RspGroupInfo)localObject).uint32_result.get();
            if ((i3 == 72) && (i2 == 0))
            {
              aj();
            }
            else if ((i3 == 0) && (((oidb_0x88d.RspGroupInfo)localObject).stgroupinfo.has()))
            {
              paramBatchResponse = (oidb_0x88d.GroupInfo)((oidb_0x88d.RspGroupInfo)localObject).stgroupinfo.get();
              if (paramBatchResponse != null)
              {
                if (QLog.isColorLevel())
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("long troop name ");
                  ((StringBuilder)localObject).append(paramBatchResponse.string_long_group_name.get().toStringUtf8());
                  QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
                }
                a(paramBatchResponse);
              }
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("receive 0x88d error:");
              ((StringBuilder)localObject).append(i3);
              QLog.e("vip_pretty.Q.chatopttroop", 1, ((StringBuilder)localObject).toString());
            }
          }
          i2 += 1;
        }
        return;
      }
      catch (Exception paramBatchResponse)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.", 2, paramBatchResponse.toString());
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).inviteMember(paramActivity, paramString, paramBoolean, paramArrayList, 1);
  }
  
  private void a(Intent paramIntent)
  {
    if (this.N == null) {
      return;
    }
    Object localObject1 = paramIntent.getStringExtra("troopUin");
    paramIntent = paramIntent.getStringArrayListExtra("delMemberUins");
    if ((localObject1 != null) && (((String)localObject1).equals(this.i.troopUin)) && (paramIntent != null))
    {
      localObject1 = new HashSet();
      Object localObject2 = paramIntent.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        Iterator localIterator = this.N.iterator();
        while (localIterator.hasNext())
        {
          oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)localIterator.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localmemberlist.uint64_member_uin.get());
          localStringBuilder.append("");
          if (str.equals(localStringBuilder.toString())) {
            ((Collection)localObject1).add(localmemberlist);
          }
        }
      }
      localObject1 = ((Collection)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (oidb_0x899.memberlist)((Iterator)localObject1).next();
        this.N.remove(localObject2);
      }
      localObject1 = new ArrayList();
      localObject2 = this.N.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(String.valueOf(((oidb_0x899.memberlist)((Iterator)localObject2).next()).uint64_member_uin.get()));
      }
      if (this.t != null)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onReceive wMemberNumClient:");
          ((StringBuilder)localObject2).append(this.t.wMemberNumClient);
          ((StringBuilder)localObject2).append("  wMemberNum:");
          ((StringBuilder)localObject2).append(this.t.wMemberNum);
          ((StringBuilder)localObject2).append(" delMembers.size():");
          ((StringBuilder)localObject2).append(paramIntent.size());
          ((StringBuilder)localObject2).append(" troopUin:");
          ((StringBuilder)localObject2).append(this.t.troopuin);
          QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = this.t;
        ((TroopInfo)localObject2).wMemberNumClient -= paramIntent.size();
      }
      paramIntent = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).saveMemberUinStringToDB(this.bn, this.i.isMember, this.t, (ArrayList)localObject1);
      if (!TextUtils.isEmpty(paramIntent)) {
        this.t.memberListToShow = paramIntent;
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onReceive ACTION_DEL_MEMBER,memberListForCard.size = ");
        paramIntent.append(this.N.size());
        QLog.d("Q.chatopttroop", 2, paramIntent.toString());
      }
      a(this.N);
    }
  }
  
  private void a(Message paramMessage)
  {
    View localView = this.h[4];
    if (localView != null)
    {
      String str = null;
      if (paramMessage.obj != null) {
        str = (String)paramMessage.obj;
      }
      a(localView, str);
    }
  }
  
  @TargetApi(11)
  public static void a(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(paramFloat);
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = paramView.findViewById(2131447901);
    if (paramInt <= 5)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "showGetAppListResult: appList.size() <= 5");
      }
      paramView.setVisibility(8);
      return;
    }
    paramView.setVisibility(0);
  }
  
  private static void a(View paramView, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131429628);
    paramView = (TextView)paramView.findViewById(2131444790);
    if (TextUtils.isEmpty(paramCharSequence1))
    {
      if (TextUtils.isEmpty(paramCharSequence3))
      {
        paramView.setVisibility(8);
      }
      else
      {
        paramView.setVisibility(0);
        paramView.setText(paramCharSequence3);
      }
    }
    else
    {
      paramView.setVisibility(0);
      paramView.setText(paramCharSequence1);
    }
    if (TextUtils.isEmpty(paramCharSequence2))
    {
      localTextView.setVisibility(8);
      return;
    }
    localTextView.setVisibility(0);
    localTextView.setText(paramCharSequence2);
  }
  
  private void a(View paramView, String paramString)
  {
    TextView localTextView = (TextView)paramView.findViewById(2131429628);
    paramView = (TextView)paramView.findViewById(2131444790);
    if (TextUtils.isEmpty(paramString))
    {
      localTextView.setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText(getString(2131895412));
      return;
    }
    paramView.setVisibility(8);
    localTextView.setVisibility(0);
    localTextView.setText(paramString);
  }
  
  private void a(View paramView, oidb_0xe83.AppInfo paramAppInfo)
  {
    boolean bool2 = ThemeUtil.isInNightMode(this.bn);
    ImageView localImageView = (ImageView)paramView.findViewById(2131428619);
    if (paramAppInfo.icon.has()) {
      paramView = paramAppInfo.icon.get();
    } else {
      paramView = "";
    }
    IChatSettingForTroopApi localIChatSettingForTroopApi = (IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class);
    Context localContext = localImageView.getContext();
    boolean bool1;
    if (paramAppInfo.show_frame.get() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localIChatSettingForTroopApi.setAppIcon(localContext, localImageView, paramView, 40.0F, bool1);
    if (bool2)
    {
      localImageView.setColorFilter(1996488704);
      return;
    }
    localImageView.setColorFilter(0);
  }
  
  private void a(View paramView, oidb_0xe83.AppInfo paramAppInfo, String paramString, long paramLong)
  {
    paramString = new StringBuffer(paramString);
    TextView localTextView = (TextView)paramView.findViewById(2131428642);
    int i1 = paramAppInfo.push_red_point.get();
    if (i1 == -1)
    {
      localTextView.setVisibility(0);
      localTextView.setText("");
      localTextView.setBackgroundResource(0);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2130852588, 0, 0, 0);
      paramString.append("，新");
    }
    else if (i1 > 0)
    {
      localTextView.setVisibility(0);
      localTextView.setText(String.valueOf(i1));
      localTextView.setBackgroundResource(2130852592);
      paramString.append("，");
      paramString.append(i1);
      paramString.append("未读");
    }
    else
    {
      localTextView.setVisibility(8);
    }
    paramView.setContentDescription(paramString.toString());
    if ((i1 != -1) && (paramLong == 1L))
    {
      if (((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).getGroupTIMFileNewsInfo(this.bn.getCurrentAccountUin(), "group_file_reddot_tim", this.i.troopUin, false))
      {
        localTextView.setVisibility(0);
        localTextView.setText("");
        localTextView.setBackgroundResource(0);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2130852588, 0, 0, 0);
        return;
      }
      localTextView.setVisibility(8);
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    Object localObject1 = this.h;
    Object localObject2 = localObject1[45];
    localObject1 = localObject1[46];
    if ((localObject2 == null) && (localObject1 == null)) {
      return;
    }
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    localObject2 = (TextView)((View)localObject1).findViewById(2131429628);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131444790);
    ((View)localObject1).setVisibility(0);
    ((TextView)localObject2).setVisibility(8);
    localTextView.setVisibility(0);
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(false, localTextView);
    if (TextUtils.isEmpty(paramString))
    {
      e((View)localObject1);
      return;
    }
    String str = getString(2131897592);
    localObject2 = str;
    if (paramLong > 0L)
    {
      localObject2 = str;
      if (paramLong <= 50L) {
        localObject2 = String.format(getString(2131897567), new Object[] { Long.valueOf(paramLong) });
      }
    }
    a(46, 3, (View)localObject1, paramString, "", true);
    localTextView.setText((CharSequence)localObject2);
    b((View)localObject1);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startTroopRemarkActivity(this, paramString1, paramString2, paramString3, paramString4, 20);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    label217:
    label218:
    do
    {
      try
      {
        i1 = ((Integer)paramJSONObject.get("retcode")).intValue();
        paramJSONObject = (JSONObject)paramJSONObject.get("result");
        boolean bool = QLog.isColorLevel();
        if (!bool) {
          break label218;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkApiState onResult. retCode = ");
        localStringBuilder.append(i1);
        localStringBuilder.append("\n");
        QLog.i("Q.chatopttroop", 2, localStringBuilder.toString());
      }
      catch (Exception paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          break label217;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkApiState onResult ");
        localStringBuilder.append(paramJSONObject.toString());
        QLog.d("Q.chatopttroop", 2, localStringBuilder.toString());
        return;
      }
      b(paramJSONObject);
      c(paramJSONObject);
      int i1 = ((Integer)paramJSONObject.get("appid")).intValue();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkApiState onResult, appid =");
        localStringBuilder.append(i1);
        localStringBuilder.append("\n");
        QLog.i("Q.chatopttroop", 2, localStringBuilder.toString());
      }
      d(paramJSONObject);
      return;
      while (i1 != 0) {
        return;
      }
    } while (paramJSONObject != null);
  }
  
  private void a(oidb_0x787.RspBody paramRspBody, List<oidb_0x787.LevelName> paramList1, List<oidb_0x787.LevelName> paramList2, long paramLong, TroopInfo paramTroopInfo)
  {
    int i1;
    if (paramList1 != null)
    {
      paramTroopInfo.setTroopLevelMap787(paramList1, paramList2);
      if (paramRspBody.uint32_level_name_seq.has())
      {
        i1 = paramRspBody.uint32_level_name_seq.get();
        paramTroopInfo.dwGroupLevelSeq = i1;
        if (QLog.isColorLevel())
        {
          paramList1 = new StringBuilder();
          paramList1.append("levelMap seq=");
          paramList1.append(i1);
          QLog.d("Q.getTroopMemberLevelInfo", 2, paramList1.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.getTroopMemberLevelInfo", 2, "has levelMap but no seq");
      }
    }
    if (paramRspBody.bytes_owner_name != null) {
      paramTroopInfo.ownerNameShow = paramRspBody.bytes_owner_name.get().toStringUtf8();
    }
    if (paramRspBody.bytes_admin_name != null) {
      paramTroopInfo.adminNameShow = paramRspBody.bytes_admin_name.get().toStringUtf8();
    }
    boolean bool = paramRspBody.uint32_sys_show_flag.has();
    int i3 = -1;
    if (bool)
    {
      paramTroopInfo.cGroupRankSysFlag = ((byte)paramRspBody.uint32_sys_show_flag.get());
      i1 = paramTroopInfo.cGroupRankSysFlag;
    }
    else
    {
      i1 = -1;
    }
    int i2;
    if (paramRspBody.uint32_user_show_flag.has())
    {
      paramTroopInfo.cGroupRankUserFlag = ((byte)paramRspBody.uint32_user_show_flag.get());
      i2 = paramTroopInfo.cGroupRankUserFlag;
    }
    else
    {
      i2 = -1;
    }
    if (paramRspBody.uint32_user_show_flag_new.has())
    {
      paramTroopInfo.cNewGroupRankUserFlag = ((byte)paramRspBody.uint32_user_show_flag_new.get());
      i3 = paramTroopInfo.cNewGroupRankUserFlag;
    }
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append(paramLong);
      paramRspBody.append(", sysFlag:");
      paramRspBody.append(i1);
      paramRspBody.append(", userFlag:");
      paramRspBody.append(i2);
      paramRspBody.append(",newUserFlag:");
      paramRspBody.append(i3);
      QLog.d("Q.getTroopMemberLevelInfo", 2, paramRspBody.toString());
    }
  }
  
  private void a(@NonNull oidb_0x88d.GroupInfo paramGroupInfo)
  {
    Object localObject = this.i;
    if (localObject == null) {
      return;
    }
    ((TroopInfoData)localObject).coverFrom(paramGroupInfo);
    if (!TextUtils.isEmpty(this.i.newTroopName)) {
      f();
    }
    if (this.i.hasSetNewTroopHead) {
      J();
    }
    if (QLog.isColorLevel())
    {
      int i1 = paramGroupInfo.uint32_group_flagext3.get();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ChatSettingForToop_handle88dResp, troopUin=");
      ((StringBuilder)localObject).append(this.i.troopUin);
      ((StringBuilder)localObject).append(", flagExt3=");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(", isQidianPrivateTroop=");
      ((StringBuilder)localObject).append(TroopInfo.isQidianPrivateTroop(i1));
      QLog.d(".troop.qidian_private_troop", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.t;
    if (localObject != null)
    {
      ((TroopInfo)localObject).coverFrom(paramGroupInfo);
      this.i.newTroopName = this.t.getNewTroopNameOrTroopName();
      if (!this.t.isNewTroop)
      {
        localObject = this.t;
        ((TroopInfo)localObject).newTroopName = ((TroopInfo)localObject).getNewTroopNameOrTroopName();
      }
      localObject = this.t;
      ((TroopInfo)localObject).oldTroopName = ((TroopInfo)localObject).getNewTroopNameOrTroopName();
    }
    b(paramGroupInfo);
    a(this.u ^ true, this.i.isNewTroop);
    k();
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).requestForPubAccountInfo(this.bn, this.i.publicAccountUin, 16, this.aD);
    j();
    am();
    e();
    ar();
    p();
    if (this.t != null) {
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateTroopInfoToDB(this.t, this.bn, this.i.isMember);
    }
    g();
    paramGroupInfo = this.x;
    if (paramGroupInfo != null)
    {
      paramGroupInfo.setTroopInfoData(this.i);
      this.x.a();
    }
    k(false);
  }
  
  private void a(oidb_0xe83.AppInfo paramAppInfo, long paramLong)
  {
    if (paramLong == 0L) {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQqunInfo("qun", "qun_info", "expo_more", this.i.troopUin);
    }
    if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramAppInfo.url.get())) {
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).reportQunMiniApp(paramAppInfo, "expo", this.i.troopUin);
    }
    if (paramLong == 101914115.0D) {
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).reportClockTroopAppShowOrClick(this.t, true);
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean) {
      return;
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      Object localObject2 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject2).optString("groupCode");
      if (!TextUtils.equals(this.i.troopUin, paramString)) {
        return;
      }
      String str1 = ((JSONObject)localObject2).optString("content");
      String str2 = ((JSONObject)localObject2).optString("source");
      int i1 = ((JSONObject)localObject2).optInt("rankId", 333);
      String str3 = ((JSONObject)localObject2).optString("nickName");
      ((JSONObject)localObject2).optInt("nickNameId");
      Object localObject1 = ((JSONObject)localObject2).optString("uin");
      String str4 = ((JSONObject)localObject2).optString("course");
      localObject2 = ((JSONObject)localObject2).optString("name");
      if ("troopProfile".equals(str2))
      {
        ThreadManager.post(new TroopSettingActivity.7(this, (String)localObject1, str3, i1, str4, (String)localObject2), 8, null, false);
      }
      else if ("join".equals(str2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("wyx", 2, new Object[] { "mHomeworkTroopIdentityChangedReceiver source=join. cGroupOption=", Short.valueOf(this.i.cGroupOption), ", joinType=", Integer.valueOf(this.br) });
        }
        if (this.br == 1) {
          ap();
        } else if (this.br == 2) {
          f(str1);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("mHomeworkTroopIdentityChangedReceiver troopUin = ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(", content = ");
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(", source = ");
        ((StringBuilder)localObject1).append(str2);
        ((StringBuilder)localObject1).append(", rankId = ");
        ((StringBuilder)localObject1).append(i1);
        ((StringBuilder)localObject1).append(", nickName = ");
        ((StringBuilder)localObject1).append(str3);
        QLog.d("zivonchen", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateUinQREntry isShowUin = ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(",showUinLockIcon = ");
      ((StringBuilder)localObject1).append(paramBoolean2);
      QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject1).toString());
    }
    View localView = null;
    Object localObject1 = this.h;
    if (localObject1 != null) {
      localView = localObject1[25];
    }
    if (localView != null)
    {
      if (paramBoolean1)
      {
        localObject1 = this.i;
        if ((localObject1 != null) && (((TroopInfoData)localObject1).troopUin != null))
        {
          localObject1 = this.i.troopUin;
          break label125;
        }
      }
      localObject1 = "";
      label125:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = " ";
      }
      localView.setVisibility(0);
      if (paramBoolean1) {
        i1 = 2131897498;
      } else if (!paramBoolean1) {
        i1 = 2131897499;
      } else {
        i1 = 0;
      }
      a(25, 2, localView, getString(i1), "", true);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("PT[QR]");
      localObject2 = new SpannableString(((StringBuilder)localObject2).toString());
      a(paramBoolean1, paramBoolean2, (String)localObject1, (SpannableString)localObject2);
      a(paramBoolean1, paramBoolean2, localView);
      Object localObject3 = getResources().getDrawable(2130844946);
      ((Drawable)localObject3).setBounds(0, 0, ScreenUtil.dip2px(18.0F), ScreenUtil.dip2px(18.0F));
      localObject3 = new TroopSettingActivity.43(this, (Drawable)localObject3, 0);
      Object localObject4;
      if (this.t != null)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("show the pretty troop icon :");
        ((StringBuilder)localObject4).append(this.t.groupFlagExt4);
        QLog.e("vip_pretty.Q.chatopttroop", 1, ((StringBuilder)localObject4).toString());
        if (((this.t.checkFlagExt4(1)) && (!this.t.checkFreezeReason(2))) || (this.t.checkFlagExt4(2)))
        {
          i1 = 1;
          break label394;
        }
      }
      else
      {
        QLog.e("vip_pretty.Q.chatopttroop", 1, "not show the pretty troop icon");
      }
      int i1 = 0;
      label394:
      if (i1 != 0)
      {
        localObject4 = getResources().getDrawable(2130848717);
        ((Drawable)localObject4).setBounds(0, 0, ScreenUtil.dip2px(40.0F), ScreenUtil.dip2px(15.0F));
        ((SpannableString)localObject2).setSpan(new TroopSettingActivity.44(this, (Drawable)localObject4, 0), ((String)localObject1).length(), ((String)localObject1).length() + 2, 17);
        ((SpannableString)localObject2).setSpan(localObject3, ((String)localObject1).length() + 2, ((String)localObject1).length() + 6, 17);
      }
      else
      {
        ((SpannableString)localObject2).setSpan(localObject3, ((String)localObject1).length(), ((SpannableString)localObject2).length(), 17);
      }
      if ((!" ".equals(localObject1)) && (!this.i.isNewTroop)) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("updateUinQREntry troopNameAndQr = ");
        ((StringBuilder)localObject3).append(localObject2);
        QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject3).toString());
      }
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).updateEntryItem(this.bn, localView, (CharSequence)localObject2, null, null, paramBoolean1, (String)localObject1, HardCodeUtil.a(2131888248));
      localView.setOnClickListener(this);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      paramView = (TextView)paramView.findViewById(2131444790);
      paramView.setOnClickListener(new TroopSettingActivity.45(this));
      paramView.setOnLongClickListener(new TroopSettingActivity.46(this));
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, String paramString, SpannableString paramSpannableString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("appendRoundBgAndLockIcon isShowUin = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",showUinLockIcon = ");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean1) && (paramBoolean2))
    {
      localObject = new RoundedBackgroundSpan(-1315339, -7894119, ViewUtils.dip2px(3.0F), ViewUtils.dip2px(21.0F), ViewUtils.dip2px(6.0F));
      ((RoundedBackgroundSpan)localObject).a(getResources().getDrawable(2130844953), ViewUtils.dip2px(16.0F), ViewUtils.dip2px(16.0F), ViewUtils.dip2px(4.0F));
      paramSpannableString.setSpan(localObject, 0, paramString.length(), 33);
    }
  }
  
  private boolean a(long paramLong, TroopInfo paramTroopInfo)
  {
    return ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).appOnClick_Special(this.bn, this, paramLong, paramTroopInfo, this.i);
  }
  
  private void aA()
  {
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.bn.getRuntimeService(ITroopInfoService.class, "");
    Object localObject2 = this.t;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localITroopInfoService.findTroopInfo(this.i.troopUin);
    }
    this.t = ((TroopInfo)localObject1);
    long l1 = 0L;
    localObject1 = this.t;
    if (localObject1 != null) {
      l1 = ((TroopInfo)localObject1).cmdUinFlagEx2;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mTroopInfo.mask=");
      if (this.t == null)
      {
        localObject1 = "no troopInfo";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.t.cmdUinFlagEx2);
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject2).toString());
    }
    boolean bool = TroopInfo.isCmdUinFlagEx2Open(l1, 512);
    localObject1 = (FormSwitchItem)this.h[10];
    if (localObject1 != null)
    {
      localObject1 = ((FormSwitchItem)localObject1).getSwitch();
      ((Switch)localObject1).setOnCheckedChangeListener(null);
      ((Switch)localObject1).setChecked(bool);
      aB();
      ((Switch)localObject1).setOnCheckedChangeListener(this);
    }
  }
  
  private void aB()
  {
    boolean bool1 = ((FormSwitchItem)this.h[10]).a();
    Object localObject = this.h;
    int i2 = 8;
    localObject = localObject[8];
    int i1;
    if (!bool1) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((View)localObject).setVisibility(i1);
    if (!bool1) {
      TroopReportor.a("Grp_set_new", "grpData_admin", "Grp_msg_exp", 0, 0, new String[] { this.i.troopUin });
    }
    if ((this.bt != null) && ((localObject instanceof FormSwitchItem)))
    {
      boolean bool2 = ((FormSwitchItem)localObject).a();
      localObject = this.bt;
      i1 = i2;
      if (!bool1)
      {
        i1 = i2;
        if (!bool2) {
          i1 = 0;
        }
      }
      ((QFormSimpleItem)localObject).setVisibility(i1);
    }
  }
  
  private void aC()
  {
    boolean bool = ((IBizTroopInfoService)this.bn.getRuntimeService(IBizTroopInfoService.class, "")).isShowExternalTroop(this.i.troopUin);
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.h[19];
    if (localFormSwitchItem != null)
    {
      Switch localSwitch = localFormSwitchItem.getSwitch();
      localSwitch.setOnCheckedChangeListener(null);
      localSwitch.setChecked(bool);
      localSwitch.setOnCheckedChangeListener(this);
      localFormSwitchItem.setContentDescription(getString(2131893979));
    }
  }
  
  private void aD()
  {
    boolean bool = this.i.isOwnerOrAdim();
    f();
    Object localObject = this.h[5];
    int i2 = 0;
    int i1;
    if ((bool) && (this.k)) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    if (localObject != null) {
      ((View)localObject).setVisibility(i1);
    }
    localObject = (QFormSimpleItem)this.h[6];
    if (localObject != null)
    {
      if (i1 == 0) {
        i2 = 3;
      }
      ((QFormSimpleItem)localObject).setBgType(i2);
    }
  }
  
  private void aa()
  {
    Z();
    this.bd = DialogUtil.a(this, 230).setTitle(getString(2131895411));
    this.bd.setPositiveButton(getString(2131895410), new TroopSettingActivity.26(this));
    try
    {
      this.bd.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void ab()
  {
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_notice", 0, 0, new String[] { this.i.troopUin, TroopReportor.a(this.i), "8.8.17" });
    if ((!this.i.isOwnerOrAdim()) && (TextUtils.isEmpty(this.bc)))
    {
      aa();
      return;
    }
    Object localObject2 = this.at;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = TroopUrlConfProcessor.a();
      this.at = ((TroopUrlConfBean)localObject1);
    }
    localObject1 = ((TroopUrlConfBean)localObject1).a;
    localObject2 = new ActivityURIRequest(this, "/base/browser");
    ((ActivityURIRequest)localObject2).extra().putString("url", ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).replaceSpecialTag((String)localObject1, 0L, 0, this.i, this.bn, true));
    ((ActivityURIRequest)localObject2).extra().putString("webStyle", "noBottomBar");
    ((ActivityURIRequest)localObject2).extra().putLong("startOpenPageTime", System.currentTimeMillis());
    ((ActivityURIRequest)localObject2).setRequestCode(17);
    QRoute.startUri((URIRequest)localObject2, null);
  }
  
  private void ac()
  {
    QQProgressDialog localQQProgressDialog = this.aB;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.aB.dismiss();
    }
  }
  
  private void ad()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "MSG_UPDATE_TROOP_MEMBER_CARD");
    }
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = (QFormSimpleItem)localObject[6];
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(this.i.troopColorNick))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "handle MSG_UPDATE_TROOP_MEMBER_CARD message and update nick");
          }
          SpannableString localSpannableString = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(this.i.troopColorNick, 16);
          ((QFormSimpleItem)localObject).setRightText(localSpannableString);
          ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).setColorText(((QFormSimpleItem)localObject).getRightTextView(), localSpannableString, this.i.troopColorNickId);
        }
        else
        {
          ((QFormSimpleItem)localObject).setRightText(getString(2131895353));
          ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).setColorText(((QFormSimpleItem)localObject).getRightTextView(), new SpannableString(""), this.i.troopColorNickId);
        }
        if (((QFormSimpleItem)localObject).getRightTextView() != null) {
          ((QFormSimpleItem)localObject).getRightTextView().setCompoundDrawablePadding(ViewUtils.dpToPx(9.0F));
        }
      }
    }
  }
  
  private void ae()
  {
    if (QLog.isColorLevel())
    {
      localObject = this.N;
      int i1;
      if (localObject != null) {
        i1 = ((List)localObject).size();
      } else {
        i1 = -1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("MSG_UPDATE_INFO memberListForCard.size = ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.ag;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131899981));
      localStringBuilder.append(this.i.wMemberNum);
      localStringBuilder.append(HardCodeUtil.a(2131899987));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    b(true);
    f();
    a(this.N);
    ar();
    a(true ^ this.u, this.i.isNewTroop);
    localObject = this.t;
    if (localObject != null) {
      e(((TroopInfo)localObject).troopRemark);
    }
  }
  
  private void af()
  {
    Object localObject2 = this.i.troopTags;
    Intent localIntent = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getTroopTagViewIntent(this);
    localIntent.putExtra("troopuin", this.i.troopUin);
    int i1 = 0;
    localIntent.putExtra("isAdmin", false);
    if (!TextUtils.isEmpty(this.i.mTroopClassExtText)) {}
    for (Object localObject1 = this.i.mTroopClassExtText;; localObject1 = this.ae.b)
    {
      i1 = 1;
      break label133;
      localObject1 = this.ae;
      if ((localObject1 == null) || (TextUtils.isEmpty(((GroupCatalogBean)localObject1).b)) || (HardCodeUtil.a(2131899974).equals(this.ae.b))) {
        break;
      }
    }
    localObject1 = "";
    label133:
    if (i1 != 0) {
      localIntent.putExtra("subclass", (String)localObject1);
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject1 = new StringBuffer();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("\n");
        ((StringBuffer)localObject1).append(localStringBuilder.toString());
      }
      ((StringBuffer)localObject1).deleteCharAt(((StringBuffer)localObject1).length() - 1);
      localIntent.putExtra("tags", ((StringBuffer)localObject1).toString());
    }
    localIntent.putExtra("act_type", 1);
    localIntent.putExtra("uin", this.bn.getCurrentAccountUin());
    if (this.i.isOwnerOrAdim())
    {
      startActivityForResult(localIntent, 11);
      return;
    }
    startActivity(localIntent);
  }
  
  private void ag()
  {
    Object localObject1 = this.h;
    Object localObject3 = localObject1[8];
    Object localObject4 = localObject1[9];
    if ((localObject4 != null) && (localObject3 != null) && ((localObject3 instanceof FormSwitchItem)))
    {
      QFormSimpleItem localQFormSimpleItem = (QFormSimpleItem)localObject4.findViewById(2131436145);
      Switch localSwitch = ((FormSwitchItem)localObject3).getSwitch();
      ((TextView)localObject4.findViewById(2131435749)).setVisibility(8);
      localObject1 = "";
      Object localObject2 = Boolean.valueOf(false);
      if (this.X.getMapRequest().containsKey(this.i.troopUin)) {
        localObject2 = (Boolean)this.X.getMapRequest().get(this.i.troopUin);
      }
      if ((localObject2 != null) && (((Boolean)localObject2).booleanValue()))
      {
        localObject4.setVisibility(0);
        localObject3.setBackgroundResource(2130839632);
        localObject3.getBackground().setAlpha(255);
        this.V.setVisibility(0);
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = this.t;
        if (localObject2 == null) {
          return;
        }
        int i1 = ((TroopInfo)localObject2).troopmask;
        if (i1 == 1)
        {
          localObject3.setBackgroundResource(2130839629);
          localObject3.getBackground().setAlpha(255);
          if (localSwitch.isChecked())
          {
            localSwitch.setTag(Boolean.TRUE);
            localSwitch.setChecked(false);
          }
          localObject4.setVisibility(8);
        }
        else
        {
          localObject3.setBackgroundResource(2130839632);
          localObject3.getBackground().setAlpha(255);
          if (!localSwitch.isChecked())
          {
            localSwitch.setTag(Boolean.TRUE);
            localSwitch.setChecked(true);
          }
          localObject4.setVisibility(0);
          localObject1 = a("", i1);
        }
        this.V.setVisibility(8);
        localObject2 = localObject1;
        if (this.bt != null)
        {
          aB();
          localObject2 = localObject1;
        }
      }
      localQFormSimpleItem.setRightText(new QQText((CharSequence)localObject2, 3));
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).clearTroopAssistTipTime(this.bn, this.i.troopUin);
  }
  
  private void ah()
  {
    Object localObject = this.h[27];
    if (localObject != null)
    {
      TextView localTextView = (TextView)((View)localObject).findViewById(2131447463);
      if (localTextView != null)
      {
        localTextView.setTextColor(Color.parseColor("#00b6f9"));
        if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
          localTextView.setAlpha(0.5F);
        }
      }
      localObject = (ProgressBar)((View)localObject).findViewById(2131440663);
      if (localObject != null) {
        ((ProgressBar)localObject).setVisibility(8);
      }
    }
    QQToast.makeText(this, 2, getString(2131887802), 0).show();
  }
  
  private void ai()
  {
    View localView = this.h[14];
    if (localView != null)
    {
      localView.setOnTouchListener(null);
      localView.setOnClickListener(null);
    }
  }
  
  private void aj()
  {
    QQToast.makeText(this, 2131892173, 1).show(getTitleBarHeight());
    ThreadManagerV2.excute(new TroopSettingActivity.41(this), 32, null, false);
    this.t = null;
    this.i.isMember = false;
    getIntent().putExtra("troop_info_is_member", false);
    finish();
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).openTroopInfoActivity(this, getIntent().getExtras(), 2);
  }
  
  private void ak()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "showNotSearchableActionSheet");
    }
    ActionSheet localActionSheet = (ActionSheet)((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).actionSheetHelperCreateDialog(this, null);
    boolean bool = this.i.isOwnerOrAdim();
    int i1;
    if (bool) {
      i1 = 2131890173;
    } else {
      i1 = 2131890172;
    }
    localActionSheet.setMainTitle(getString(i1));
    if (bool) {
      i1 = 2131890170;
    } else {
      i1 = 2131890171;
    }
    localActionSheet.addButton(i1);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new TroopSettingActivity.47(this, localActionSheet));
    localActionSheet.setOnBottomCancelListener(new TroopSettingActivity.48(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void al()
  {
    boolean bool = this.i.isOwnerOrAdim();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoSettingOrShare ,isOwnerOrAdmin = ");
      localStringBuilder.append(bool);
      QLog.d("Q.chatopttroop", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).openTroopProfole(this, this.i, this.ad);
      return;
    }
    Y();
  }
  
  private void am()
  {
    View localView = this.h[33];
    Object localObject1;
    if ((localView != null) && ((localView instanceof ExpandableTextView)))
    {
      localObject2 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getDateString(this, this.i.mTroopCreateTime);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.i.mRichFingerMemo))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("\r\n");
        ((StringBuilder)localObject1).append(this.i.mRichFingerMemo);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((ExpandableTextView)localView).setText(new QQText((CharSequence)localObject1, 11, 16));
    }
    Object localObject2 = this.h[37];
    if ((localObject2 != null) && ((localObject2 instanceof TextView)))
    {
      if (!TextUtils.isEmpty(this.i.mRichFingerMemo)) {
        localObject1 = this.i.mRichFingerMemo;
      } else {
        localObject1 = getString(2131893911);
      }
      ((TextView)localObject2).setText(new QQText((CharSequence)localObject1, 11, 16));
    }
  }
  
  private void an()
  {
    ITroopEnterEffectService localITroopEnterEffectService = (ITroopEnterEffectService)this.bn.getRuntimeService(ITroopEnterEffectService.class, "all");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnActivityResult REQUEST_FOR_ENTER_EFFECT_SETTING  effectManager.isAllTroopShowEnterance() = ");
      localStringBuilder.append(localITroopEnterEffectService.isAllTroopShowEnterance());
      QLog.d("Q.chatopttroop", 2, localStringBuilder.toString());
    }
    if (localITroopEnterEffectService.isAllTroopShowEnterance()) {
      a(true);
    }
  }
  
  private void ao()
  {
    ITroopLuckyCharacterHandler localITroopLuckyCharacterHandler = (ITroopLuckyCharacterHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopLuckyCharacterHandlerName());
    TroopInfoData localTroopInfoData = this.i;
    if ((localTroopInfoData != null) && (!TextUtils.isEmpty(localTroopInfoData.troopUin))) {
      localITroopLuckyCharacterHandler.a(this.i.troopUin);
    }
  }
  
  private void ap()
  {
    n();
    ((ITroopMngHandler)this.bn.getBusinessHandler(TroopMngHandler.class.getName())).a(this.i.troopUin, "", this.i.getStatOption(), this.aa, this.ab, null, null);
  }
  
  private void aq()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, String.format("updateTitle mStatusBarShow=%b", new Object[] { Boolean.valueOf(this.bv) }));
    }
    boolean bool = ThemeUtil.isInNightMode(this.bn);
    if (!this.bv) {
      this.bv = true;
    }
    if ((!this.bv) && (!bool)) {
      i1 = 2131167662;
    } else {
      i1 = 2131167990;
    }
    int i3 = getResources().getColor(i1);
    int i2 = 2130848505;
    int i1 = i2;
    if (this.bv)
    {
      i1 = i2;
      if (!bool) {
        i1 = 2130848502;
      }
    }
    Drawable localDrawable = getResources().getDrawable(2130853297);
    localDrawable.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
    this.q.setTextColor(i3);
    this.r.setTextColor(i3);
    this.r.setBackgroundDrawable(localDrawable);
    this.s.setImageResource(i1);
    this.s.setColorFilter(i3);
    e(this.bv);
  }
  
  private void ar()
  {
    ImageView localImageView = (ImageView)this.h[12].findViewById(2131441402);
    TroopInfoData localTroopInfoData = this.i;
    if ((localTroopInfoData != null) && (localTroopInfoData.checkFlagExt4(3)) && (!this.i.checkFreezeReason(2)))
    {
      localImageView.setVisibility(0);
      return;
    }
    localImageView.setVisibility(8);
  }
  
  private void as()
  {
    Object localObject1 = this.h;
    if (localObject1 != null)
    {
      if (localObject1.length <= 0) {
        return;
      }
      Object localObject2 = localObject1[13];
      if (localObject2 != null)
      {
        localObject1 = null;
        int i1 = 0;
        while (i1 <= 7)
        {
          switch (i1)
          {
          default: 
            break;
          case 7: 
            localObject1 = localObject2.findViewById(2131447894);
            break;
          case 6: 
            localObject1 = localObject2.findViewById(2131447893);
            break;
          case 5: 
            localObject1 = localObject2.findViewById(2131447892);
            break;
          case 4: 
            localObject1 = localObject2.findViewById(2131447891);
            break;
          case 3: 
            localObject1 = localObject2.findViewById(2131447890);
            break;
          case 2: 
            localObject1 = localObject2.findViewById(2131447889);
            break;
          case 1: 
            localObject1 = localObject2.findViewById(2131447888);
            break;
          case 0: 
            localObject1 = localObject2.findViewById(2131447887);
          }
          if ((localObject1 != null) && (((View)localObject1).getVisibility() == 0))
          {
            Object localObject3 = ((View)localObject1).getTag();
            if ((localObject3 != null) && ((localObject3 instanceof oidb_0xe83.AppInfo)))
            {
              localObject3 = (oidb_0xe83.AppInfo)localObject3;
              long l1 = -1000L;
              int i2 = -1000;
              if (((oidb_0xe83.AppInfo)localObject3).push_red_point.has()) {
                i2 = ((oidb_0xe83.AppInfo)localObject3).push_red_point.get();
              }
              if (((oidb_0xe83.AppInfo)localObject3).appid.has()) {
                l1 = ((oidb_0xe83.AppInfo)localObject3).appid.get();
              }
              if (l1 == 1L)
              {
                boolean bool = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).getGroupTIMFileNewsInfo(this.bn.getCurrentAccountUin(), "group_file_reddot_tim", this.i.troopUin, false);
                if ((i2 != -1) && (!bool)) {
                  i1 = 0;
                } else {
                  i1 = 1;
                }
                localObject1 = (TextView)((View)localObject1).findViewById(2131428642);
                if (i1 != 0)
                {
                  ((TextView)localObject1).setVisibility(0);
                  ((TextView)localObject1).setText("");
                  ((TextView)localObject1).setBackgroundResource(0);
                  ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130852588, 0, 0, 0);
                  return;
                }
                ((TextView)localObject1).setVisibility(8);
                return;
              }
            }
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void at()
  {
    if ((this.af == null) && (getIntent().getBooleanExtra("from_newer_guide", false)))
    {
      this.af = new Intent();
      this.af.putExtra("uin", this.i.troopUin);
    }
    Intent localIntent2 = this.af;
    Intent localIntent1 = localIntent2;
    if (this.bs)
    {
      localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      localIntent1.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
      this.bs = false;
    }
    setResult(-1, localIntent1);
  }
  
  private void au()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.h[47];
    if (localFormSwitchItem == null) {
      return;
    }
    TroopInfo localTroopInfo = this.t;
    if (localTroopInfo == null) {
      return;
    }
    boolean bool = localTroopInfo.isTroopGameCardEnabled();
    localFormSwitchItem.setChecked(bool);
    localFormSwitchItem = (FormSwitchItem)this.h[48];
    if (localFormSwitchItem != null)
    {
      if (bool)
      {
        localFormSwitchItem.setVisibility(0);
        av();
        return;
      }
      localFormSwitchItem.setVisibility(8);
    }
  }
  
  private void av()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.h[48];
    if (localFormSwitchItem == null) {
      return;
    }
    TroopInfo localTroopInfo = this.t;
    if (localTroopInfo == null) {
      return;
    }
    localFormSwitchItem.setChecked(localTroopInfo.isShowMyGameCardEnabled());
  }
  
  private void aw()
  {
    SharedPreferences localSharedPreferences = this.bn.getApp().getSharedPreferences(this.bn.getCurrentAccountUin(), 0);
    if (!localSharedPreferences.getBoolean("Change_Game_Card_Switch_Tips_Value", false))
    {
      if (this.bj == null)
      {
        this.bj = DialogUtil.a(this, 230, getString(2131895197), getString(2131895196), 2131887648, 2131895195, new TroopSettingActivity.57(this), null);
        this.bj.setOnDismissListener(new TroopSettingActivity.58(this));
        this.bj.show();
      }
      localSharedPreferences.edit().putBoolean("Change_Game_Card_Switch_Tips_Value", true).apply();
    }
  }
  
  private void ax()
  {
    if (TextUtils.isEmpty(this.ai)) {
      return;
    }
    int i1 = -1;
    if (this.ai.equals("wangzhe"))
    {
      i1 = 48;
      TroopReportor.a("Grp_AIO", "AIO_clk", "game_on_clk", 0, 0, new String[] { this.i.troopUin });
    }
    if (i1 >= 0)
    {
      if (i1 >= 51) {
        return;
      }
      View localView = this.h[i1];
      if ((this.U != null) && (localView != null) && (localView.getVisibility() == 0))
      {
        i1 = localView.getTop();
        int i2 = localView.getHeight();
        this.U.smoothScrollBy(i1 - i2, 1000);
      }
    }
  }
  
  private void ay()
  {
    boolean bool = ((ITroopInfoService)this.bn.getRuntimeService(ITroopInfoService.class, "")).isCommonlyUsedTroop(this.i.troopUin);
    Object localObject = (FormSwitchItem)this.h[7];
    if (localObject != null)
    {
      localObject = ((FormSwitchItem)localObject).getSwitch();
      ((Switch)localObject).setOnCheckedChangeListener(null);
      ((Switch)localObject).setChecked(bool);
      ((Switch)localObject).setOnCheckedChangeListener(this);
    }
  }
  
  private void az()
  {
    Object localObject = (FormSwitchItem)this.h[31];
    TroopInfo localTroopInfo = this.t;
    if ((localTroopInfo != null) && (localObject != null))
    {
      if (localTroopInfo.showGameSwitchStatus == 1)
      {
        boolean bool = false;
        ((FormSwitchItem)localObject).setVisibility(0);
        localObject = ((FormSwitchItem)localObject).getSwitch();
        ((Switch)localObject).setOnCheckedChangeListener(null);
        if (this.t.gameSwitchStatus == 1) {
          bool = true;
        }
        ((Switch)localObject).setChecked(bool);
        ((Switch)localObject).setOnCheckedChangeListener(this);
        ((Switch)localObject).setClickable(true);
        return;
      }
      ((FormSwitchItem)localObject).setVisibility(8);
    }
  }
  
  private View b(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 9: 
      return paramView.findViewById(2131447896);
    case 8: 
      return paramView.findViewById(2131447895);
    case 7: 
      return paramView.findViewById(2131447894);
    case 6: 
      return paramView.findViewById(2131447893);
    case 5: 
      return paramView.findViewById(2131447892);
    case 4: 
      return paramView.findViewById(2131447891);
    case 3: 
      return paramView.findViewById(2131447890);
    case 2: 
      return paramView.findViewById(2131447889);
    case 1: 
      return paramView.findViewById(2131447888);
    }
    return paramView.findViewById(2131447887);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      Object localObject = (ITroopInfoService)this.bn.getRuntimeService(ITroopInfoService.class, "");
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((ITroopInfoService)localObject).findTroopInfo(this.i.troopUin);
      }
      if ((localObject != null) && (((TroopInfo)localObject).wMemberNum != this.i.wMemberNum))
      {
        this.i.updateTroopAdmMemberNum(((TroopInfo)localObject).Administrator, ((TroopInfo)localObject).wMemberNum, this.bn.getCurrentAccountUin(), getResources());
        localObject = this.ag;
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131899980));
          localStringBuilder.append(this.i.wMemberNum);
          localStringBuilder.append(HardCodeUtil.a(2131899982));
          ((TextView)localObject).setText(localStringBuilder.toString());
        }
      }
    }
  }
  
  private void b(int paramInt, View paramView)
  {
    if (paramInt != 5) {
      return;
    }
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).setRedPointSP("RED_POINT_KEY_TROOP_ADMIN");
    if (this.bg)
    {
      localObject1 = (ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_");
      ((StringBuilder)localObject2).append(this.bn.getCurrentAccountUin());
      ((ITroopUtilsApi)localObject1).setRedPointSP(((StringBuilder)localObject2).toString());
    }
    if (this.bh)
    {
      localObject1 = (ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("RED_POINT_KEY_TROOP_ASSOCIATION_MANAGE_ENTRY");
      ((StringBuilder)localObject2).append(this.bn.getCurrentAccountUin());
      ((ITroopUtilsApi)localObject1).setRedPointSP(((StringBuilder)localObject2).toString());
    }
    paramView = (TextView)paramView.findViewById(2131444790);
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(false, paramView);
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("uin", this.bn.getCurrentAccountUin());
    ((Intent)localObject2).putExtra("troop_uin", this.i.troopUin);
    ((Intent)localObject2).putExtra("forward_location", this.i.troopLocation);
    ((Intent)localObject2).putExtra("forward_latitude", this.i.troopLat);
    ((Intent)localObject2).putExtra("forward_longitude", this.i.troopLon);
    ((Intent)localObject2).putExtra("forward_cityid", this.i.cityId);
    ((Intent)localObject2).putExtra("troop_auth_submit_time", this.ad);
    ((Intent)localObject2).putExtra("leftViewText", getResources().getString(2131887748));
    ((Intent)localObject2).putExtra("key_qidian_private_troop", this.u);
    ((Intent)localObject2).putExtra("key_is_update_before_805", ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isUpdateBeforeSomeVersion(this, "8.0.5"));
    paramView = (ITroopHonorService)this.bn.getRuntimeService(ITroopHonorService.class, "");
    Object localObject1 = this.t;
    boolean bool;
    if (localObject1 != null)
    {
      ((Intent)localObject2).putExtra("key_support_troop_honor", paramView.isGrayTroopHonor(((TroopInfo)localObject1).troopuin));
      bool = this.t.isKingBattleTroop();
    }
    else
    {
      bool = false;
    }
    ((Intent)localObject2).putExtra("key_customed_troop", bool);
    if (bool) {
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).reportDC00087(null, "846", "205605", "", "84601", "1", "145");
    }
    localObject1 = this.at;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      paramView = TroopUrlConfProcessor.a();
      this.at = paramView;
    }
    ((Intent)localObject2).putExtra("autoApprovalUrl", paramView.b);
    ((Intent)localObject2).putExtra("frequencyLimitVisible", paramView.c);
    ((Intent)localObject2).putExtra("key_is_need_update_Group_info", true);
    if (QLog.isDevelopLevel())
    {
      paramView = this.t;
      if (paramView != null) {
        QLog.i("TroopMngTest", 4, String.format("start troop mng [flag: %s, msgLimitFreq: %s]", new Object[] { Long.valueOf(paramView.dwGroupFlagExt3 & 0x100000), Integer.valueOf(this.t.nMsgLimitFreq) }));
      }
    }
    ((Intent)localObject2).putExtra("troop_manager_edit_red_show", X());
    ((Intent)localObject2).putExtra("troop_manager_edit_current_uin", this.bn.getCurrentUin());
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).OpenTroopManagePluginActivity(this.bn, this, (Intent)localObject2, 8);
    localObject1 = this.bn;
    localObject2 = this.i.troopUin;
    if (this.i.bOwner) {
      paramView = "0";
    } else {
      paramView = "1";
    }
    ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrp", 0, 0, (String)localObject2, paramView, "", "");
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_manageGrp", 0, 0, new String[] { this.i.troopUin, TroopReportor.a(this.i) });
  }
  
  private void b(BatchResponse paramBatchResponse, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    if (paramBatchResponse.seq != 1) {
      return;
    }
    if (paramOIDBSSOPkg != null)
    {
      if (!paramOIDBSSOPkg.bytes_bodybuffer.has()) {
        return;
      }
      paramBatchResponse = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
      try
      {
        paramOIDBSSOPkg = new oidb_0x899.RspBody();
        paramOIDBSSOPkg.mergeFrom(paramBatchResponse);
        if (paramOIDBSSOPkg.rpt_memberlist.has()) {
          if (!this.i.isMember)
          {
            if (this.x != null) {
              this.x.a(paramOIDBSSOPkg.rpt_memberlist.get());
            }
          }
          else
          {
            b(paramOIDBSSOPkg.rpt_memberlist.get());
            return;
          }
        }
      }
      catch (Exception paramBatchResponse)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.", 2, paramBatchResponse.toString());
        }
      }
    }
  }
  
  private void b(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("isNeedFinish")))
    {
      paramIntent = new Intent();
      paramIntent.putExtra("isNeedFinish", true);
      setResult(-1, paramIntent);
      finish();
      return;
    }
    if (this.h[6] != null) {
      ThreadManager.post(new TroopSettingActivity.52(this), 8, null, true);
    }
    g();
  }
  
  private static void b(Intent paramIntent, long paramLong)
  {
    if (paramIntent == null) {
      return;
    }
    String str = null;
    if (paramLong == 101914115L) {
      str = "biz_src_zf_games";
    }
    if (!TextUtils.isEmpty(str)) {
      paramIntent.putExtra("big_brother_source_key", str);
    }
  }
  
  private void b(String paramString)
  {
    OpenID localOpenID = (OpenID)((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getStrOpenIDFromCacheAndDB(this.bn, paramString);
    if (localOpenID == null)
    {
      n();
      this.aX = new Handler();
      this.aX.postDelayed(new TroopSettingActivity.5(this), 3000L);
      addObserver(this.aZ);
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getOpenID(this.bn, paramString);
      return;
    }
    if (!this.ak.equals(localOpenID.openID))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "-->preForward--openid doesn't equal current local openid");
      }
      r();
    }
  }
  
  private void b(List<oidb_0x899.memberlist> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ITroopRobotService localITroopRobotService = (ITroopRobotService)this.bn.getRuntimeService(ITroopRobotService.class, "all");
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      localObject = (oidb_0x899.memberlist)localIterator.next();
      String str = String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get());
      if ((!TextUtils.isEmpty(this.i.troopowneruin)) && (str.equals(this.i.troopowneruin))) {
        paramList = (List<oidb_0x899.memberlist>)localObject;
      } else if (localITroopRobotService.isRobotUin(str)) {
        localArrayList1.add(localObject);
      } else if (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(this.bn, this.i.troopUin, str)) {
        localArrayList2.add(localObject);
      } else {
        localArrayList3.add(localObject);
      }
    }
    this.N = new ArrayList();
    Object localObject = paramList;
    if (paramList == null) {}
    try
    {
      localObject = new oidb_0x899.memberlist();
      ((oidb_0x899.memberlist)localObject).uint64_member_uin.set(Long.parseLong(this.i.troopowneruin));
      this.N.add(0, localObject);
    }
    catch (NumberFormatException paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.chatopttroop", 2, paramList.toString());
      }
    }
    this.N.addAll(localArrayList2);
    this.N.addAll(localArrayList3);
    this.N.addAll(localArrayList1);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("handle0X899_0,memberListForCard.size = ");
      paramList.append(this.N.size());
      QLog.d("Q.chatopttroop", 2, paramList.toString());
    }
    paramList = new ArrayList();
    localObject = this.N.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(String.valueOf(((oidb_0x899.memberlist)((Iterator)localObject).next()).uint64_member_uin.get()));
    }
    localObject = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).saveMemberUinStringToDB(this.bn, this.i.isMember, this.t, paramList);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.t.memberListToShow = ((String)localObject);
    }
    a(this.N);
    ((ITroopMemberInfoHandler)this.bn.getBusinessHandler(TroopMemberInfoHandler.class.getName())).a(this.i.troopUin, paramList, true, null);
  }
  
  private void b(@NonNull JSONObject paramJSONObject)
  {
    paramJSONObject = (JSONObject)paramJSONObject.get("basics");
    if (paramJSONObject != null)
    {
      paramJSONObject = (JSONArray)paramJSONObject.get("datas");
      if (paramJSONObject != null)
      {
        int i1 = 0;
        while (i1 < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(i1);
          String str1 = (String)((JSONObject)localObject).get("name");
          int i2 = ((Integer)((JSONObject)localObject).get("state")).intValue();
          String str2 = (String)((JSONObject)localObject).get("api");
          localObject = (String)((JSONObject)localObject).get("msg");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkApiState onResult, basics name = ");
            localStringBuilder.append(str1);
            localStringBuilder.append(" state = ");
            localStringBuilder.append(i2);
            localStringBuilder.append(" api = ");
            localStringBuilder.append(str2);
            localStringBuilder.append(" msg = ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("\n");
            QLog.i("Q.chatopttroop", 2, localStringBuilder.toString());
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void b(@NonNull oidb_0x88d.GroupInfo paramGroupInfo)
  {
    this.u = TroopInfo.isQidianPrivateTroop(paramGroupInfo.uint32_group_flagext3.get());
    if (this.u)
    {
      int i1;
      if (this.i.bOwner) {
        i1 = 1;
      } else if (this.i.bAdmin) {
        i1 = 2;
      } else {
        i1 = 3;
      }
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).newReportTask(this.bn, this.i.troopUin, i1);
    }
  }
  
  private void c(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            localTroopInfoData = this.i;
            localTroopInfoData.cGroupOption = 5;
            localTroopInfoData.troopAuthen = getString(2131917524);
            return;
          }
          localTroopInfoData = this.i;
          localTroopInfoData.cGroupOption = 4;
          localTroopInfoData.troopAuthen = getString(2131917525);
          return;
        }
        localTroopInfoData = this.i;
        localTroopInfoData.cGroupOption = 3;
        localTroopInfoData.troopAuthen = getString(2131917530);
        return;
      }
      localTroopInfoData = this.i;
      localTroopInfoData.cGroupOption = 2;
      localTroopInfoData.troopAuthen = getString(2131917528);
      return;
    }
    TroopInfoData localTroopInfoData = this.i;
    localTroopInfoData.cGroupOption = 1;
    localTroopInfoData.troopAuthen = getString(2131917523);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      setResult(-1, localIntent);
      finish();
    }
  }
  
  private void c(int paramInt, View paramView)
  {
    if (paramInt != 43) {
      return;
    }
    this.bm = true;
    TroopInfoData localTroopInfoData = this.i;
    if ((localTroopInfoData != null) && (!TextUtils.isEmpty(localTroopInfoData.troopUin))) {
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).openTroopAssociationWebPage(this, this.i.troopUin);
    }
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).setRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION");
    paramView = (TextView)paramView.findViewById(2131444790);
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(false, paramView);
    paramView = this.i;
    if (paramView != null) {
      ReportController.b(this.bn, "dc00898", "", paramView.troopUin, "0X800B4AE", "0X800B4AE", 0, 0, String.valueOf(this.i.dwGroupClassExt), "", "", "");
    }
  }
  
  private void c(BatchResponse paramBatchResponse, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    if (paramBatchResponse.seq != 2) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.getTroopMemberLevelInfo", 2, "batchOidbResp, seq=0X787");
    }
    if (paramOIDBSSOPkg != null)
    {
      if (!paramOIDBSSOPkg.bytes_bodybuffer.has()) {
        return;
      }
      paramBatchResponse = paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray();
    }
    for (;;)
    {
      try
      {
        oidb_0x787.RspBody localRspBody = new oidb_0x787.RspBody();
        localRspBody.mergeFrom(paramBatchResponse);
        if (!localRspBody.uint64_group_code.has()) {
          return;
        }
        if (localRspBody.rpt_msg_level_name.isEmpty()) {
          break label220;
        }
        paramBatchResponse = localRspBody.rpt_msg_level_name.get();
        if (localRspBody.rpt_msg_level_name_new.isEmpty()) {
          break label225;
        }
        paramOIDBSSOPkg = localRspBody.rpt_msg_level_name_new.get();
        ITroopInfoService localITroopInfoService = (ITroopInfoService)this.bn.getRuntimeService(ITroopInfoService.class, "");
        long l1 = localRspBody.uint64_group_code.get();
        TroopInfo localTroopInfo = localITroopInfoService.findTroopInfo(String.valueOf(l1));
        if (localTroopInfo != null)
        {
          a(localRspBody, paramBatchResponse, paramOIDBSSOPkg, l1, localTroopInfo);
          ThreadManager.post(new TroopSettingActivity.42(this, localITroopInfoService, localTroopInfo), 8, null, false);
          return;
        }
      }
      catch (Exception paramBatchResponse)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.getTroopMemberLevelInfo", 2, paramBatchResponse.toString());
        }
      }
      return;
      label220:
      paramBatchResponse = null;
      continue;
      label225:
      paramOIDBSSOPkg = null;
    }
  }
  
  private void c(Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("disabled", true);
    QFormSimpleItem localQFormSimpleItem = (QFormSimpleItem)this.h[41];
    if (localQFormSimpleItem != null)
    {
      if (bool) {
        paramIntent = getResources().getString(2131893969);
      } else {
        paramIntent = getResources().getString(2131893970);
      }
      localQFormSimpleItem.setRightText(paramIntent);
    }
  }
  
  private void c(View paramView)
  {
    this.c = paramView.findViewById(2131429850);
    this.d = ((Button)paramView.findViewById(2131429754));
    this.e = ((Button)paramView.findViewById(2131445798));
    this.f = ((QQBlurView)paramView.findViewById(2131429645));
    this.d.setOnTouchListener(new TroopSettingActivity.8(this));
  }
  
  private void c(String paramString)
  {
    TextView localTextView = new TextView(this);
    localTextView.setFocusable(true);
    localTextView.setText(paramString);
    localTextView.setPadding(ViewUtils.dip2px(16.0F), 0, ViewUtils.dip2px(16.0F), 0);
    localTextView.setTextAppearance(this, 2131953513);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.topMargin = ViewUtils.dpToPx(14.0F);
    paramString.bottomMargin = ViewUtils.dpToPx(4.0F);
    this.b.addView(localTextView, paramString);
  }
  
  private void c(@NonNull JSONObject paramJSONObject)
  {
    paramJSONObject = (JSONObject)paramJSONObject.get("friendlink");
    if (paramJSONObject != null)
    {
      paramJSONObject = (JSONArray)paramJSONObject.get("datas");
      if (paramJSONObject != null)
      {
        int i1 = 0;
        while (i1 < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(i1);
          String str1 = (String)((JSONObject)localObject).get("name");
          int i2 = ((Integer)((JSONObject)localObject).get("state")).intValue();
          String str2 = (String)((JSONObject)localObject).get("api");
          localObject = (String)((JSONObject)localObject).get("msg");
          if (("add_group".equals(str2)) && (i2 != 1)) {
            runOnUiThread(new TroopSettingActivity.63(this));
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkApiState onResult, friendlink name = ");
            localStringBuilder.append(str1);
            localStringBuilder.append(" state = ");
            localStringBuilder.append(i2);
            localStringBuilder.append(" api = ");
            localStringBuilder.append(str2);
            localStringBuilder.append(" msg= ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("\n");
            QLog.i("Q.chatopttroop", 2, localStringBuilder.toString());
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.t;
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((TroopInfo)localObject).troopuin)) {
        return;
      }
      boolean bool = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).isGrayTroopForTroopGameCard(this.t.troopuin);
      int i1;
      if ((!this.t.isHomeworkTroop()) && (bool) && (!((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        bool = this.t.isTroopGameCardEnabled();
        if (this.t.isOwnerOrAdmin(this.bn.getCurrentAccountUin()))
        {
          localObject = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject).setBackgroundResource(2130839632);
          ((FormSwitchItem)localObject).setBgType(2);
          ((FormSwitchItem)localObject).setText(getString(2131895192));
          ((FormSwitchItem)localObject).getTextView().setTextColor(getResources().getColorStateList(2131167993));
          ((FormSwitchItem)localObject).setFocusable(true);
          ((FormSwitchItem)localObject).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject).setContentDescription(getString(2131895192));
          this.h[47] = localObject;
          localSwitch = ((FormSwitchItem)localObject).getSwitch();
          localSwitch.setTag(Integer.valueOf(47));
          if (bool) {
            localSwitch.setChecked(true);
          } else {
            localSwitch.setChecked(false);
          }
          localSwitch.setOnCheckedChangeListener(this);
          this.b.addView((View)localObject);
          TroopReportor.a("Grp_set_new", "grpData_admin", "game_switch", 0, 0, new String[] { this.i.troopUin });
        }
        localObject = new FormSwitchItem(this, null);
        ((FormSwitchItem)localObject).setBackgroundResource(2130839632);
        ((FormSwitchItem)localObject).setText(getString(2131895193));
        ((FormSwitchItem)localObject).getTextView().setTextColor(getResources().getColorStateList(2131167993));
        ((FormSwitchItem)localObject).setFocusable(true);
        ((FormSwitchItem)localObject).getBackground().setAlpha(255);
        ((FormSwitchItem)localObject).setContentDescription(getString(2131895193));
        this.h[48] = localObject;
        Switch localSwitch = ((FormSwitchItem)localObject).getSwitch();
        localSwitch.setTag(Integer.valueOf(48));
        if (this.t.shouldShowMyGameCard()) {
          localSwitch.setChecked(true);
        } else {
          localSwitch.setChecked(false);
        }
        localSwitch.setOnCheckedChangeListener(this);
        this.b.addView((View)localObject);
        if (!bool) {
          ((FormSwitchItem)localObject).setVisibility(8);
        } else {
          TroopReportor.a("Grp_manage_new", "game", "game_switch", 0, 0, new String[] { this.i.troopUin });
        }
      }
      if (paramBoolean)
      {
        localObject = View.inflate(this, 2131627926, null);
        ((View)localObject).setBackgroundResource(2130853313);
        this.b.addView((View)localObject);
        ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298801);
      }
    }
  }
  
  private void d(int paramInt)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (this.n == null) {
        this.n = new QQProgressNotifier(this);
      }
      this.n.b(2, 2131892104, 1500);
      this.aD.sendEmptyMessage(17);
      return;
    }
    if (this.t == null) {
      return;
    }
    this.X.getMapUploading().clear();
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).setTroopMsgFilterToServer(this.bn, this.t.troopuin, paramInt);
    this.X.getMapRequest().put(this.t.troopuin, Boolean.valueOf(true));
    if (!this.bi)
    {
      SharedPreferences localSharedPreferences = this.bn.getApp().getSharedPreferences(this.bn.getCurrentAccountUin(), 0);
      if (!localSharedPreferences.getBoolean("Change_Msg_Notify_Tips_Value", false))
      {
        this.bi = true;
        localSharedPreferences.edit().putBoolean("Change_Msg_Notify_Tips_Value", true).commit();
        DialogUtil.a(this, getString(2131895421), 2131916601, 2131916601, new DialogUtil.DialogOnClickAdapter(), null).show();
      }
    }
    this.aD.sendEmptyMessage(17);
    ReportController.b(this.bn, "P_CliOper", "Grp_msg", "", "data_page", "Clk_setmsg", 0, 0, this.t.troopuin, String.valueOf(paramInt - 1), "", "");
  }
  
  private void d(int paramInt, View paramView)
  {
    if (paramInt != 45) {
      return;
    }
    Object localObject = this.i;
    if ((localObject != null) && (!TextUtils.isEmpty(((TroopInfoData)localObject).troopUin)))
    {
      paramView = (TextView)paramView.findViewById(2131444790);
      localObject = (ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RED_POINT_KEY_TROOP_IDOL_RANK");
      localStringBuilder.append(this.i.troopUin);
      ((ITroopUtilsApi)localObject).setRedPointSP(localStringBuilder.toString());
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(false, paramView);
      if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch())
      {
        QQToast.makeText(this, getString(2131897590), 0).show(getTitleBarHeight());
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, new Object[] { "onclick:StudyMode Forbidden context = ", this });
        }
        return;
      }
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startFansTroopIdolRank(this, this.i.troopUin, 21);
      ReportController.b(this.bn, "dc00898", "", "", "0X800B596", "0X800B596", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel())
    {
      paramView = this.i;
      if (paramView == null) {
        paramView = "null";
      } else {
        paramView = paramView.troopUin;
      }
      QLog.d("Q.chatopttroop", 2, new Object[] { "onclick: troopUin = ", paramView });
    }
  }
  
  private void d(View paramView)
  {
    View localView = View.inflate(this, 2131626719, null);
    this.h[12] = localView;
    ar();
    this.o.measure(0, 0);
    localView = View.inflate(this, 2131627926, null);
    localView.setBackgroundResource(2130853313);
    this.b.addView(localView);
    localView.getLayoutParams().height = this.o.getMeasuredHeight();
    localView = View.inflate(this, 2131627923, null);
    this.h[23] = localView;
    localView.setTag(Integer.valueOf(23));
    localView.setOnClickListener(this);
    localView.setContentDescription(HardCodeUtil.a(2131899954));
    this.b.addView(localView);
    paramView.findViewById(2131447988).setVisibility(8);
    boolean bool = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).isShowTroopGameCardRedPoint(this.bn.getCurrentUin(), this.i.troopUin, false);
    paramView = (TextView)localView.findViewById(2131444790);
    if (paramView != null) {
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(bool, paramView);
    }
    paramView = localView.findViewById(2131434878);
    paramView.setTag(Integer.valueOf(35));
    paramView.setContentDescription(getResources().getString(2131897491));
    if (SimpleUIUtil.e()) {
      paramView.setBackground(null);
    }
    if ((paramView instanceof ThemeImageView)) {
      ((ThemeImageView)paramView).setSupportMaskView(false);
    }
    this.h[35] = paramView;
    J();
    paramView = localView.findViewById(2131448053);
    paramView.setTag(Integer.valueOf(36));
    this.h[36] = paramView;
    f();
    if (!TextUtils.isEmpty(this.i.mRichFingerMemo)) {
      paramView = this.i.mRichFingerMemo;
    } else {
      paramView = getString(2131893911);
    }
    localView = localView.findViewById(2131446515);
    ((TextView)localView).setText(new QQText(paramView, 11, 16));
    this.h[37] = localView;
    if (!this.i.hasSetNewTroopHead) {
      localView.setVisibility(8);
    }
    e();
    T();
    if ((this.i != null) && (((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).isGrayTroopForTroopAssociations(this.i.troopUin, this.i.troopMemberMaxNum, this.i.dwGroupClassExt)))
    {
      paramView = View.inflate(this, 2131627926, null);
      paramView.setBackgroundResource(2130853313);
      this.b.addView(paramView);
      paramView.getLayoutParams().height = getResources().getDimensionPixelSize(2131299336);
      paramView = View.inflate(this, 2131627911, null);
      this.h[43] = paramView;
      this.b.addView(paramView);
      int i1 = ((IBizTroopInfoService)this.bn.getRuntimeService(IBizTroopInfoService.class, "")).getAssociatedTroopCount(this.i.troopUin);
      paramView = (TextView)paramView.findViewById(2131444790);
      bool = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isEmptyRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION");
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(bool, paramView);
      H(i1);
    }
    paramView = View.inflate(this, 2131627926, null);
    paramView.setBackgroundResource(2130853313);
    this.b.addView(paramView);
    paramView.getLayoutParams().height = getResources().getDimensionPixelSize(2131298801);
  }
  
  private void d(String paramString)
  {
    IQQAvatarHandlerService localIQQAvatarHandlerService = (IQQAvatarHandlerService)this.bn.getRuntimeService(IQQAvatarHandlerService.class, "");
    if (localIQQAvatarHandlerService != null) {
      localIQQAvatarHandlerService.getTroopHead(paramString);
    }
  }
  
  private void d(@NonNull JSONObject paramJSONObject)
  {
    paramJSONObject = (JSONObject)paramJSONObject.get("qqpay");
    if (paramJSONObject != null)
    {
      paramJSONObject = (JSONArray)paramJSONObject.get("datas");
      if (paramJSONObject != null)
      {
        int i1 = 0;
        while (i1 < paramJSONObject.length())
        {
          Object localObject = (JSONObject)paramJSONObject.get(i1);
          String str1 = (String)((JSONObject)localObject).get("name");
          int i2 = ((Integer)((JSONObject)localObject).get("state")).intValue();
          String str2 = (String)((JSONObject)localObject).get("api");
          localObject = (String)((JSONObject)localObject).get("msg");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("checkApiState onResult, qqpay name = ");
            localStringBuilder.append(str1);
            localStringBuilder.append(" state = ");
            localStringBuilder.append(i2);
            localStringBuilder.append(" api = ");
            localStringBuilder.append(str2);
            localStringBuilder.append(" msg= ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("\n");
            QLog.i("Q.chatopttroop", 2, localStringBuilder.toString());
          }
          i1 += 1;
        }
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (this.i.pa == 3)
    {
      localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      setResult(-1, localIntent);
      finish();
      return;
    }
    if (this.i.pa == 30) {
      localIntent = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getChatActivityIntent(this);
    } else {
      localIntent = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getSplashActivityIntent(this);
    }
    Intent localIntent = BaseAIOUtils.a(localIntent, new int[] { 2 });
    localIntent.putExtra("uin", this.i.troopUin);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", this.i.newTroopName);
    if ((paramBoolean) && (this.ac))
    {
      localIntent.putExtra("fromThirdAppByOpenSDK", true);
      localIntent.putExtra("appid", getIntent().getExtras().getString("appid"));
      localIntent.putExtra("pkg_name", getIntent().getExtras().getString("pkg_name"));
      localIntent.putExtra("app_name", getIntent().getExtras().getString("app_name"));
      localIntent.putExtra("action", getIntent().getExtras().getInt("pkg_name"));
    }
    startActivity(localIntent);
  }
  
  private void e(int paramInt)
  {
    if (paramInt != 4) {
      return;
    }
    if (!((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).troopNoticeFreezed(this, this.i)) {
      ab();
    }
  }
  
  private void e(View paramView)
  {
    Object localObject = (TextView)paramView.findViewById(2131429628);
    TextView localTextView = (TextView)paramView.findViewById(2131444790);
    ((TextView)localObject).setVisibility(8);
    localTextView.setVisibility(0);
    localTextView.setText(getString(2131897591));
    a(45, 3, paramView, getString(2131897593), "", true);
    paramView = (ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("RED_POINT_KEY_TROOP_IDOL_RANK");
    ((StringBuilder)localObject).append(this.i.troopUin);
    boolean bool = paramView.isEmptyRedPointSP(((StringBuilder)localObject).toString());
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(bool, localTextView);
  }
  
  private void e(String paramString)
  {
    View localView = this.h[50];
    TextView localTextView1 = (TextView)localView.findViewById(2131429628);
    TextView localTextView2 = (TextView)localView.findViewById(2131444790);
    localTextView1.setVisibility(8);
    localTextView2.setVisibility(0);
    a(50, 3, localView, getString(2131897571), "", true);
    if (TextUtils.isEmpty(paramString)) {
      localTextView2.setText(getString(2131897576));
    } else {
      localTextView2.setText(paramString);
    }
    b(localView);
  }
  
  private void e(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      paramJSONObject = (JSONObject)paramJSONObject.get("data");
      if (paramJSONObject == null) {
        return;
      }
      paramJSONObject = (JSONObject)paramJSONObject.get("key");
      if (paramJSONObject == null) {
        return;
      }
      int i1 = ((Integer)paramJSONObject.get("retCode")).intValue();
      localObject = (String)paramJSONObject.get("retMsg");
      if (i1 == 0)
      {
        d(true);
        ReportController.b(this.bn, "CliOper", "", "", "0x80084B5", "0x80084B5", 0, 0, "", "", "", "");
      }
      else
      {
        paramJSONObject = getActivity().getResources().getString(2131917514);
        if (i1 != 221002)
        {
          if (i1 == 221020) {
            paramJSONObject = getActivity().getResources().getString(2131917515);
          }
        }
        else {
          paramJSONObject = getActivity().getResources().getString(2131917509);
        }
        h(paramJSONObject);
      }
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("joinGroup onResult retCode = ");
        paramJSONObject.append(i1);
        paramJSONObject.append(" retMsg = ");
        paramJSONObject.append((String)localObject);
        QLog.i("Q.chatopttroop", 2, paramJSONObject.toString());
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      Object localObject;
      h(getActivity().getResources().getString(2131917514));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("joinGroup onResult ");
        ((StringBuilder)localObject).append(paramJSONObject.toString());
        QLog.e("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void e(boolean paramBoolean)
  {
    this.p.setVisibility(0);
    this.a.setVisibility(0);
    ImmersiveUtils.setStatusTextColor(false, getWindow());
    SimpleUIUtil.a(this.a, getActivity().getWindow());
  }
  
  private void f(int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    i();
    a("Grp_Admin_data", "Clk_mber", "");
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_mber", 0, 0, new String[] { this.i.troopUin, TroopReportor.a(this.i) });
  }
  
  private void f(int paramInt, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramInt == -1))
    {
      paramIntent = paramIntent.getExtras();
      this.i.troopLocation = paramIntent.getString("location");
      this.i.troopLat = paramIntent.getInt("lat", 0);
      this.i.troopLon = paramIntent.getInt("lon", 0);
      j();
    }
  }
  
  private void f(View paramView)
  {
    this.ah = ((TextView)paramView.findViewById(2131447986));
    if (this.i.bAdmin)
    {
      this.ah.setText(getString(2131906732));
      this.ah.setVisibility(0);
      this.ah.setOnClickListener(new TroopSettingActivity.56(this));
      return;
    }
    this.ah.setVisibility(8);
  }
  
  private void f(String paramString)
  {
    if (this.i.cGroupOption == 1)
    {
      ap();
      return;
    }
    g(paramString);
  }
  
  private void f(boolean paramBoolean)
  {
    Object localObject = this.t;
    if (localObject == null) {
      return;
    }
    if (paramBoolean == ((TroopInfo)localObject).isTroopGameCardEnabled()) {
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.makeText(this, 2131893961, 0).show(getTitleBarHeight());
      au();
      return;
    }
    if (paramBoolean) {
      aw();
    }
    localObject = (FormSwitchItem)this.h[48];
    if (localObject != null) {
      if (paramBoolean)
      {
        ((FormSwitchItem)localObject).setVisibility(0);
        av();
      }
      else
      {
        ((FormSwitchItem)localObject).setVisibility(8);
      }
    }
    localObject = (ITroopGameHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopGameHandlerName());
    if (localObject != null) {
      ((ITroopGameHandler)localObject).a(this.i.troopUin, paramBoolean);
    }
    if (paramBoolean) {
      localObject = "game_switch_on";
    } else {
      localObject = "game_switch_off";
    }
    TroopReportor.a("Grp_set_new", "grpData_admin", (String)localObject, 0, 0, new String[] { this.i.troopUin });
  }
  
  private void g(int paramInt)
  {
    if (paramInt != 2) {
      return;
    }
    h();
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_invite_new", 0, 0, new String[] { this.i.troopUin, TroopReportor.a(this.i) });
  }
  
  private void g(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramIntent.getExtras().getBoolean("isNeedFinish")))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("isNeedFinish", true);
        setResult(-1, paramIntent);
      }
      finish();
    }
  }
  
  private void g(String paramString)
  {
    if (this.i.cGroupOption != 3)
    {
      int i1 = this.i.getStatOption();
      int i2 = this.M;
      if ((i2 != 1) && (i2 != 2)) {
        break label43;
      }
      i1 = 18;
      label43:
      if (!TextUtils.isEmpty(this.i.remark))
      {
        startActivity(((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startJoinTroop(this, this.i.troopUin, this.i.newTroopName, this.i.cGroupOption, i1, this.i.mStrJoinQuestion, this.i.mStrJoinAnswer, this.i.remark, this.q.getText().toString(), this.aa, this.ab, paramString));
        return;
      }
      paramString = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startJoinTroop(this, this.i.troopUin, this.i.newTroopName, this.i.cGroupOption, i1, this.i.mStrJoinQuestion, this.i.mStrJoinAnswer, null, this.q.getText().toString(), this.aa, this.ab, paramString);
      paramString.putExtra("from_newer_guide", getIntent().getBooleanExtra("from_newer_guide", false));
      paramString.putExtra("from_babyq", getIntent().getBooleanExtra("from_babyq", false));
      startActivityForResult(paramString, 10);
      return;
    }
    a(2131917537, 0);
  }
  
  private void g(boolean paramBoolean)
  {
    Object localObject = this.t;
    if (localObject == null) {
      return;
    }
    if (((TroopInfo)localObject).isShowMyGameCardEnabled() == paramBoolean) {
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.makeText(this, 2131893961, 0).show(getTitleBarHeight());
      av();
      return;
    }
    localObject = (ITroopGameHandler)this.bn.getBusinessHandler(TroopGameHandler.class.getName());
    if (localObject != null) {
      ((ITroopGameHandler)localObject).b(this.i.troopUin, paramBoolean);
    }
    if (paramBoolean) {
      localObject = "game_switch_on";
    } else {
      localObject = "game_switch_off";
    }
    TroopReportor.a("Grp_manage_new", "game", (String)localObject, 0, 0, new String[] { this.i.troopUin });
  }
  
  private void h(int paramInt)
  {
    if (paramInt != 22) {
      return;
    }
    String str = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.i.troopUin });
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/browser");
    localActivityURIRequest.extra().putLong("startOpenPageTime", System.currentTimeMillis());
    localActivityURIRequest.extra().putString("url", str);
    QRoute.startUri(localActivityURIRequest, null);
    ReportController.b(this.bn, "dc00899", "Grp_certified", "", "data", "clk_data", 2, 0, this.i.troopUin, "", "", "");
  }
  
  private void h(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      boolean bool1 = NetworkUtil.isNetworkAvailable(this);
      boolean bool2 = false;
      if (!bool1)
      {
        QQToast.makeText(this, 1, 2131892105, 0).show(getTitleBarHeight());
        return;
      }
      paramIntent = paramIntent.getStringExtra("result");
      if (!TextUtils.isEmpty(paramIntent))
      {
        Object localObject = this.t;
        if ((localObject != null) && (!paramIntent.equals(((TroopInfo)localObject).troopname)))
        {
          bool1 = bool2;
          if (!this.i.isOwnerOrAdim())
          {
            bool1 = bool2;
            if (this.i.allowMemberModifTroopName == 1) {
              bool1 = true;
            }
          }
          ((ITroopModifyHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopModifyHandlerName())).a(this.t.troopuin, paramIntent, bool1);
          if ((this.t.isNewTroop) && (this.t.hasSetTroopHead())) {
            this.J = true;
          }
          localObject = this.t;
          ((TroopInfo)localObject).oldTroopName = ((TroopInfo)localObject).troopname;
          localObject = this.i;
          ((TroopInfoData)localObject).troopName = paramIntent;
          ((TroopInfoData)localObject).newTroopName = this.t.getTroopDisplayName();
          f();
        }
      }
    }
  }
  
  private void h(String paramString)
  {
    runOnUiThread(new TroopSettingActivity.62(this, paramString));
  }
  
  private void h(boolean paramBoolean)
  {
    Object localObject = this.t;
    if ((localObject != null) && (((TroopInfo)localObject).troopcode != null)) {
      localObject = this.t.troopcode;
    } else {
      localObject = this.i.troopCode;
    }
    if (((ITroopCommonlyUsedHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopCommonlyUsedHandlerName())).a((String)localObject, paramBoolean ^ true))
    {
      if (paramBoolean) {
        localObject = "open_stick";
      } else {
        localObject = "close_stick";
      }
      ReportController.b(this.bn, "dc00899", "Grp_set", "", "Grp_data", (String)localObject, 0, 0, this.i.troopUin, "", "", "");
      TroopReportor.a("Grp_set_new", "grpData_admin", (String)localObject, 0, 0, new String[] { this.i.troopUin, TroopReportor.a(this.i) });
      return;
    }
    ay();
  }
  
  private void i(int paramInt)
  {
    if (paramInt != 39) {
      return;
    }
    if (this.i.nActiveMemberNum > this.i.wMemberNum)
    {
      localObject1 = this.i;
      ((TroopInfoData)localObject1).nActiveMemberNum = ((TroopInfoData)localObject1).wMemberNum;
    }
    if ((this.i.dwGroupFlagExt & 0x800000) != 8388608L) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("hide_operation_bar", true);
    ((Intent)localObject1).putExtra("hideRightButton", true);
    ((Intent)localObject1).putExtra("isScreenOrientationPortrait", true);
    ((Intent)localObject1).putExtra("uin", this.bn.getCurrentAccountUin());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("https://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=");
    ((StringBuilder)localObject2).append(this.i.troopUin);
    ((StringBuilder)localObject2).append("&role=1&group_level=");
    ((StringBuilder)localObject2).append(this.i.nTroopGrade);
    ((StringBuilder)localObject2).append("&group_mem_num=");
    ((StringBuilder)localObject2).append(this.i.wMemberNum);
    ((StringBuilder)localObject2).append("&group_active_num=");
    ((StringBuilder)localObject2).append(this.i.nActiveMemberNum);
    ((StringBuilder)localObject2).append("&show_level=");
    ((StringBuilder)localObject2).append(paramInt);
    ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject2).toString());
    localObject2 = new ActivityURIRequest(this, "/pubaccount/browser");
    ((ActivityURIRequest)localObject2).extra().putAll(((Intent)localObject1).getExtras());
    QRoute.startUri((URIRequest)localObject2, null);
    ReportController.b(this.bn, "P_CliOper", "Grp_rank", "", "Grp_data", "Clk_grprank", 0, 0, this.i.troopUin, "", "", "");
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).bnrReport(this.bn, 72);
  }
  
  private void i(int paramInt, Intent paramIntent)
  {
    String str2 = this.i.troopUin;
    long l1 = 0L;
    boolean bool1;
    if ((paramInt == -1) && (paramIntent != null))
    {
      boolean bool2 = paramIntent.getBooleanExtra("updateFromWeb", false);
      String str1 = paramIntent.getStringExtra("lastAnnouncement");
      long l2 = paramIntent.getLongExtra("groupCode", 0L);
      l1 = l2;
      paramIntent = str1;
      bool1 = bool2;
      if (bool2)
      {
        l1 = l2;
        paramIntent = str1;
        bool1 = bool2;
        if (TextUtils.equals(str2, String.valueOf(l2)))
        {
          paramIntent = this.aD.obtainMessage();
          paramIntent.what = 20;
          paramIntent.obj = str1;
          this.aD.sendMessage(paramIntent);
          ITroopInfoService localITroopInfoService = (ITroopInfoService)this.bn.getRuntimeService(ITroopInfoService.class, "");
          if (this.t == null) {
            this.t = localITroopInfoService.findTroopInfo(str2);
          }
          TroopInfo localTroopInfo = this.t;
          l1 = l2;
          paramIntent = str1;
          bool1 = bool2;
          if (localTroopInfo != null)
          {
            localTroopInfo.updateLastMemoFromWeb(str1);
            localITroopInfoService.updateEntity(this.t);
            l1 = l2;
            paramIntent = str1;
            bool1 = bool2;
          }
        }
      }
    }
    else
    {
      paramIntent = null;
      bool1 = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, String.format("doOnActivityResult get last memo [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(bool1), str2, Long.valueOf(l1), paramIntent }));
    }
  }
  
  private void i(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void j(int paramInt)
  {
    if (paramInt != 9) {
      return;
    }
    W();
    TroopReportor.a("Grp_msg", "grpData_admin", "Clk_msgSet", 0, 0, new String[] { this.i.troopUin, TroopReportor.a(this.i) });
  }
  
  private void j(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      if (!NetworkUtil.isNetworkAvailable(this))
      {
        QQToast.makeText(this, 1, 2131892105, 0).show(getTitleBarHeight());
        return;
      }
      e(paramIntent.getStringExtra("result"));
    }
  }
  
  private void j(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "switchTroopShowExternal");
    }
    if (NetworkUtil.getSystemNetwork(this) == 0)
    {
      QQToast.makeText(this, 2131893961, 0).show(getTitleBarHeight());
      aC();
      return;
    }
    ((ITroopShowExternalHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopShowExternalHandlerName())).a(this.i.troopCode, this.i.troopUin, paramBoolean, false);
    if (paramBoolean) {
      ReportController.b(this.bn, "P_CliOper", "Grp_set", "", "Grp_data", "set_open", 0, 0, this.i.troopUin, "", "", "");
    } else {
      ReportController.b(this.bn, "P_CliOper", "Grp_set", "", "Grp_data", "set_close", 0, 0, this.i.troopUin, "", "", "");
    }
    String str;
    if (paramBoolean) {
      str = "showGrp_open";
    } else {
      str = "showGrp_close";
    }
    TroopReportor.a("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.i.troopUin, TroopReportor.a(this.i) });
  }
  
  private void k(int paramInt)
  {
    if (paramInt != 1001) {
      return;
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startActivityForTroop(this, this.i.troopUin, 1001);
    ReportController.b(this.bn, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_chatrecord", 0, 0, this.i.troopUin, "", "", "");
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_chatRecord", 1, 0, new String[] { this.i.troopUin, TroopReportor.a(this.i) });
    ReportController.b(this.bn, "dc00898", "", "", "0X800A0B8", "0X800A0B8", 0, 0, "", "", "", "");
  }
  
  private void k(boolean paramBoolean)
  {
    if (this.i == null) {
      return;
    }
    if (!((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).isGrayTroopForTroopAssociations(this.i.troopUin, this.i.troopMemberMaxNum, this.i.dwGroupClassExt)) {
      return;
    }
    if ((!this.i.hasTroopAssociation()) && (!paramBoolean))
    {
      H(0);
      return;
    }
    ITroopAssociationHandler localITroopAssociationHandler = (ITroopAssociationHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAssociationHandlerName());
    if (localITroopAssociationHandler != null) {
      localITroopAssociationHandler.a(this.i.troopUin, 3, "");
    }
  }
  
  private void l(int paramInt)
  {
    if (paramInt != 1010) {
      return;
    }
    TroopReportor.a("Grp_set_new", "grpData_admin", "grpNotice_click", 0, 0, new String[] { this.i.troopUin });
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", this.i.troopUin);
    localIntent.putExtra("uintype", 1);
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).messageNotificationSettingFragmentLaunch(this, localIntent);
  }
  
  private void m(int paramInt)
  {
    if (paramInt != 1006) {
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("troop_uin", this.i.troopUin);
    ((Intent)localObject).putExtra("param_from", 19);
    ((Intent)localObject).putExtra("TROOP_INFO_MEMBER_NUM", this.i.wMemberNum);
    RouteUtils.a(this, (Intent)localObject, "/troop/memberlist/TroopMemberList", 9);
    localObject = ((ITroopMemberInfoService)this.bn.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(this.i.troopUin, this.bn.getCurrentAccountUin());
    TroopReportor.a("Grp_edu", "Grp_data", "teachermsg_Clk", 0, 0, new String[] { this.i.troopUin, TroopReportor.a((TroopMemberInfo)localObject) });
  }
  
  private void n(int paramInt)
  {
    if (paramInt != 1002) {
      return;
    }
    d(false);
    if (this.M == 2) {
      ReportController.b(this.bn, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_grpaio", 0, 0, this.i.troopUin, "", "", "");
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).StoryReportor(this);
    AppInterface localAppInterface = this.bn;
    if (!this.i.hasSetNewTroopHead) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getExposureSourceReportVal());
    localStringBuilder.append("");
    ReportController.b(localAppInterface, "dc00898", "", "", "0X800A526", "0X800A526", paramInt, 0, localStringBuilder.toString(), "", "", "");
  }
  
  private void o(int paramInt)
  {
    if (paramInt != 1004) {
      return;
    }
    ReportController.b(this.bn, "P_CliOper", "Grp_payjoin", "", "join_grp", "Clk_data", 0, 0, this.i.troopUin, "", "", "");
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).jump2PayJoinTroopWeb(this, this.i.troopUin, "");
    TroopReportor.a(this.i.troopUin, 0, 0, this.i.getStatOption());
  }
  
  private void p(int paramInt)
  {
    if (paramInt != 1005) {
      return;
    }
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).joinGroupOneStep(this.bn, this, getIntent(), this);
    ReportController.b(this.bn, "CliOper", "", "", "0x80084B4", "0x80084B4", 0, 0, "", "", "", "");
    TroopReportor.a(this.i.troopUin, 0, 0, this.i.getStatOption());
  }
  
  private void q(int paramInt)
  {
    if (paramInt != 1003) {
      return;
    }
    Object localObject = this.bn;
    if (!this.i.hasSetNewTroopHead) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getExposureSourceReportVal());
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800A527", "0X800A527", paramInt, 0, localStringBuilder.toString(), "", "", "");
    if (this.i.pa == 34)
    {
      if (((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).needAnswerQuestion(this.bn.getCurrentAccountUin()))
      {
        localObject = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).createQuestionDialog(this);
        if (!isFinishing())
        {
          ((Dialog)localObject).show();
          ReportController.b(this.bn, "dc00898", "", "", "kuolie", "0X80097DC", 0, 0, "", "", "", "");
        }
        return;
      }
      ReportController.b(this.bn, "dc00898", "", "", "0X80092D7", "0X80092D7", 0, 0, "", "", "", "");
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).secRecognize(false, null);
    if ((this.i.cGroupOption != 1) && (TextUtils.isEmpty(this.aa)))
    {
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).calJoinTroop(this.i, ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getExposureSource(), this.aC, 2);
      if (!NetworkUtil.isNetSupport(this))
      {
        a(2131892102, 1);
        return;
      }
      localObject = (ITroopMngHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName());
      if (localObject != null) {
        try
        {
          long l1 = Long.parseLong(this.i.troopUin);
          n();
          ((ITroopMngHandler)localObject).a(l1, 8390784);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, localException.toString());
          }
        }
      }
      if (super.getIntent().getBooleanExtra("from_babyq", false)) {
        ReportController.b(this.bn, "dc00898", "", "", "0X8007246", "0X8007246", 0, 0, "", "", "", "");
      }
      TroopReportor.a(this.i.troopUin, 0, 0, this.i.getStatOption());
      return;
    }
    if (this.i.isHomeworkTroop())
    {
      G(1);
      return;
    }
    ap();
  }
  
  private void r(int paramInt)
  {
    if (paramInt != 17) {
      return;
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startChatBackgroundSettingActivity(this, this.bn, this.i.troopUin, 6);
    ReportController.b(this.bn, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
    ReportController.b(this.bn, "dc00899", "Grp_set", "", "Grp_data", "Set_chatBG", 0, 0, this.i.troopUin, "", "", "");
    TroopReportor.a("Grp_set_new", "grpData_admin", "set_chatBG", 0, 0, new String[] { this.i.troopUin, TroopReportor.a(this.i) });
  }
  
  private void s(int paramInt)
  {
    if (40 != paramInt) {
      return;
    }
    Object localObject = (EntryStatus)((QFormSimpleItem)this.h[40]).getTag(2131443127);
    if (localObject != null)
    {
      long l1 = ((EntryStatus)localObject).g;
      ((EntryStatus)localObject).g = SystemClock.uptimeMillis();
      if (((EntryStatus)localObject).g < l1 + 1000L) {
        return;
      }
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).setStringForQVipConfigManager_keyWordExpireList(this.bn, this.i.troopUin, ((EntryStatus)localObject).b);
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).setBooleanForQVipConfigManager_keyWordGuideClicked(this.bn);
      String str = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getUrlFromIndividuationUrlHelper_keyWord().replace("[groupid]", this.i.troopUin);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClick: ");
        localStringBuilder.append(str);
        QLog.d("Q.chatopttroop.troop.special_msg.keyword", 2, localStringBuilder.toString());
      }
      ReportController.b(null, "dc00898", "", this.i.troopUin, "qq_vip", "0X800A8F8", ((EntryStatus)localObject).f, 1, 0, "", "", "", "");
      localObject = new ActivityURIRequest(this, "/base/browser");
      ((ActivityURIRequest)localObject).extra().putLong("startOpenPageTime", System.currentTimeMillis());
      ((ActivityURIRequest)localObject).extra().putString("url", str);
      ((ActivityURIRequest)localObject).extra().putBoolean("isShowAd", false);
      QRoute.startUri((URIRequest)localObject, null);
      return;
    }
    QLog.e("Q.chatopttroop.troop.special_msg.keyword", 1, "onClick status is null");
  }
  
  private void t()
  {
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    this.aj = getIntent().getStringExtra("appid");
    this.ak = getIntent().getStringExtra("openid");
    this.al = getIntent().getStringExtra("share_uin");
    this.am = getIntent().getStringExtra("is_from_game");
    if (("true".equals(this.am)) && (!TextUtils.isEmpty(this.aj)))
    {
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).checkApiState(this.bn, getApplicationContext(), this.aj, this, 0, null);
      this.an = getIntent().getStringExtra("guild_id");
      this.ao = getIntent().getStringExtra("zone_id");
      this.ap = getIntent().getStringExtra("role_id");
      this.aq = getIntent().getStringExtra("gc");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("joinGroup appid = ");
        ((StringBuilder)localObject).append(this.aj);
        ((StringBuilder)localObject).append(" openid = ");
        ((StringBuilder)localObject).append(this.ak);
        ((StringBuilder)localObject).append(" guild id = ");
        ((StringBuilder)localObject).append(this.an);
        ((StringBuilder)localObject).append("zone_id = ");
        ((StringBuilder)localObject).append(this.ao);
        ((StringBuilder)localObject).append(" role id = ");
        ((StringBuilder)localObject).append(this.ap);
        ((StringBuilder)localObject).append("  group code= ");
        ((StringBuilder)localObject).append(this.aq);
        QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("Q.chatopttroop", 2, " joinGroup is from game = false");
    }
    Object localObject = String.valueOf(this.aj);
    if ((!TextUtils.isEmpty(this.al)) && (!this.al.equals(this.bn.getAccount())))
    {
      r();
      return;
    }
    if (!TextUtils.isEmpty(this.ak)) {
      b((String)localObject);
    }
  }
  
  private void t(int paramInt)
  {
    if (paramInt != 18) {
      return;
    }
    TroopReportor.a("Grp_set_new", "grpData_admin", "specialEntrance_click", 0, 0, new String[] { this.i.troopUin });
    Object localObject = new ActivityURIRequest(this, "/base/browser");
    String str = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getUrlFromIndividuationUrlHelper_entryEffect();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("&gc=");
    localStringBuilder.append(this.i.troopUin);
    str = VasWebviewUtil.b(localStringBuilder.toString(), 52);
    ((ActivityURIRequest)localObject).extra().putString("url", str);
    ((ActivityURIRequest)localObject).setRequestCode(15);
    QRoute.startUri((URIRequest)localObject, null);
    localObject = (ITroopEnterEffectService)this.bn.getRuntimeService(ITroopEnterEffectService.class, "all");
    ((ITroopEnterEffectService)localObject).report("grp_data", "entry_clk", new String[] { this.i.troopUin });
    paramInt = ((ITroopEnterEffectService)localObject).getEffectId(this.i.troopUin);
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).reportCommercialDrainage(this.bn.getCurrentUin(), "style", "0X8008E62", "", 1, 0, 0, "", Integer.toString(paramInt), "");
  }
  
  private void u()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("start_recomend_page");
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    localIntentFilter.addAction("com.tencent.mobileqq.actoino.ACTIONO_DEL_TROOP_MEMBER");
    registerReceiver(this.au, localIntentFilter);
    addObserver(this.aH);
    addObserver(this.aF);
    addObserver(this.bq);
    addObserver(this.bo);
    addObserver(this.aG);
    addObserver(this.aO);
    addObserver(this.aM);
    addObserver(this.aN);
    addObserver(this.aL);
    addObserver(this.bb);
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).preloadWebProcess(this.bn);
  }
  
  private void u(int paramInt)
  {
    if (paramInt != 23) {
      return;
    }
    if (this.i.troopUin == null)
    {
      localObject = this.t;
      if ((localObject != null) && (((TroopInfo)localObject).troopuin != null)) {
        this.i.troopUin = this.t.troopuin;
      }
    }
    if (((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).isShowTroopGameCardRedPoint(this.bn.getCurrentUin(), this.i.troopUin, false))
    {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setTroopGameCardRedPoint(this.bn.getCurrentUin(), this.i.troopUin, false);
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setTroopGameCardRedPointHasShowed(this.bn.getCurrentUin(), this.i.troopUin, true);
      ((IRedPointUtilsApi)QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(this.bn, this.i.troopUin, "troop", 3, 0);
      localObject = this.h[23];
      if (localObject != null)
      {
        localObject = (TextView)((View)localObject).findViewById(2131444790);
        if (localObject != null) {
          ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(false, (TextView)localObject);
        }
      }
    }
    Object localObject = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getTroopProfileExtra(this.i.troopUin, 0);
    ((Bundle)localObject).putBoolean("troop_info_from_troopsetting", true);
    ((Bundle)localObject).putInt("exposureSource", 1);
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).openTroopInfoActivity(this, (Bundle)localObject, 2);
    localObject = this.bn;
    if (!this.i.hasSetNewTroopHead) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800A524", "0X800A524", paramInt, 0, "", "", "", "");
  }
  
  private void v()
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      if (((TroopInfoData)localObject).isOwnerOrAdim()) {
        localObject = "0";
      } else {
        localObject = "1";
      }
      a("Grp_Admin_data", "Clk_data", (String)localObject);
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).bnrReport(this.bn, 65);
    localObject = (ITroopInfoService)this.bn.getRuntimeService(ITroopInfoService.class, "");
    if (localObject != null)
    {
      TroopInfoData localTroopInfoData = this.i;
      if (localTroopInfoData != null)
      {
        localObject = ((ITroopInfoService)localObject).findTroopInfo(localTroopInfoData.troopUin);
        if ((localObject != null) && (((TroopInfo)localObject).isGameBind())) {
          TroopReportor.a("Grp_game", "Grp_data", "data_exp", 0, 0, new String[] { this.i.troopUin });
        }
      }
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).reportCommercialDrainage(this.bn.getCurrentUin(), "group_nickname", "group_nickname_1", "", 1, 0, 0, "", "", "");
    ReportController.b(this.bn, "dc00898", "", "", "0X800A523", "0X800A523", 0, 0, "", "", "", "");
    ReportController.b(this.bn, "dc00899", "Grp_create", "", "search", "grpedit_grpcreate_exp", 0, 0, "", "", "", "");
  }
  
  private void v(int paramInt)
  {
    if (paramInt != 27) {
      return;
    }
    DeleteRecordDialog localDeleteRecordDialog = new DeleteRecordDialog(this, this.bn, false);
    localDeleteRecordDialog.a(new TroopSettingActivity.25(this));
    localDeleteRecordDialog.a(2);
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_delRecord", 0, 0, new String[] { this.i.troopUin, TroopReportor.a(this.i) });
  }
  
  private void w()
  {
    if (this.h != null)
    {
      Object localObject = this.i;
      if (localObject != null)
      {
        if (TextUtils.isEmpty(((TroopInfoData)localObject).troopUin)) {
          return;
        }
        localObject = this.h[49];
        if (localObject == null) {
          return;
        }
        TextView localTextView = (TextView)((View)localObject).findViewById(2131444790);
        int i1;
        if ((this.i.groupFlagExt4 & 0x8000) == 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 == 0)
        {
          localTextView.setText(getResources().getString(2131895338));
          return;
        }
        localTextView.setText("");
        long l1 = 0L;
        localObject = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).getKeyTroopLuckyCharacterStatus(this.bn.getCurrentAccountUin(), this.i.troopUin, getString(2131895340));
        if ((localObject != null) && (localObject.length == 2))
        {
          l1 = ((Long)localObject[0]).longValue();
          localObject = (String)localObject[1];
        }
        else
        {
          localObject = "";
        }
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTime(new Date());
        localCalendar.set(11, 0);
        localCalendar.set(12, 0);
        localCalendar.set(13, 0);
        ITroopLuckyCharacterHandler localITroopLuckyCharacterHandler = (ITroopLuckyCharacterHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopLuckyCharacterHandlerName());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localITroopLuckyCharacterHandler.a(this.i.troopUin);
          return;
        }
        if (l1 > localCalendar.getTimeInMillis())
        {
          localTextView.setText("");
          return;
        }
        localITroopLuckyCharacterHandler.a(this.i.troopUin);
      }
    }
  }
  
  private void w(int paramInt)
  {
    if (paramInt != 1009) {
      return;
    }
    if (this.bf)
    {
      ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).setRobotItemRedShowed(this.bn, false);
      this.be.a(false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "setRobotItemRedDotShowed");
      }
    }
    ReportController.b(this.bn, "dc00898", "", "", "", "0X8009F9C", 0, 0, "", "", "", "");
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).jumpRobotPage(this, this.i.troopUin, this.i.isOwnerOrAdim());
  }
  
  private void x()
  {
    TextView localTextView = new TextView(this);
    localTextView.setOnClickListener(new TroopSettingActivity.9(this));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localTextView.setGravity(1);
    if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
      localTextView.setAlpha(0.5F);
    }
    localTextView.setTextColor(Color.parseColor("#4799DF"));
    localTextView.setTextSize(1, 14.0F);
    localTextView.setText(2131917538);
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = ViewUtils.dpToPx(15.0F);
    localLayoutParams.bottomMargin = ViewUtils.dpToPx(24.0F);
    this.b.addView(localTextView, localLayoutParams);
    TroopReportor.a("Grp_set_new", "grpData_admin", "tipoff_exp", 0, 0, new String[] { this.i.troopUin });
  }
  
  private void x(int paramInt)
  {
    if (paramInt != 14) {
      return;
    }
    if (this.i != null)
    {
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).TroopNameEntry(this.i, this, this.u, 96, 16);
      TroopReportor.a("Grp_set_new", "grpData_admin", "clk_editInfo", 0, 0, new String[] { this.i.troopUin, TroopReportor.a(this.i) });
      AppInterface localAppInterface = this.bn;
      String str2 = this.i.troopUin;
      String str1;
      if (this.i.bOwner) {
        str1 = "0";
      }
      for (;;)
      {
        break;
        if (this.i.bAdmin) {
          str1 = "1";
        } else {
          str1 = "2";
        }
      }
      ReportController.b(localAppInterface, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_name", 0, 0, str2, "0", str1, "");
    }
  }
  
  private void y()
  {
    View localView = View.inflate(this, 2131627924, null);
    this.b.addView(localView);
    this.g = ((Button)localView.findViewById(2131431710));
    if (this.i.bOwner) {
      this.g.setText(2131888718);
    } else {
      this.g.setText(2131914219);
    }
    this.g.setOnClickListener(new TroopSettingActivity.10(this));
  }
  
  private void y(int paramInt)
  {
    if (paramInt != 25) {
      return;
    }
    Y();
    AppInterface localAppInterface = this.bn;
    String str2 = this.i.troopUin;
    String str1;
    if (this.i.bOwner) {
      str1 = "0";
    }
    for (;;)
    {
      break;
      if (this.i.bAdmin) {
        str1 = "1";
      } else {
        str1 = "2";
      }
    }
    ReportController.b(localAppInterface, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_num", 0, 0, str2, "0", str1, "");
  }
  
  private void z()
  {
    Object localObject = View.inflate(this, 2131627904, null);
    this.h[27] = localObject;
    this.b.addView((View)localObject);
    a(27, 0, (View)localObject, getString(2131893873), null, false);
    ((View)localObject).setTag(Integer.valueOf(27));
    ((View)localObject).setOnClickListener(this);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131447463);
    if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
      localTextView.setAlpha(0.5F);
    }
    localTextView.setTextColor(Color.parseColor("#4799DF"));
    localObject = (TextView)((View)localObject).findViewById(2131435692);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  private void z(int paramInt)
  {
    if (paramInt != 32) {
      return;
    }
    String str = ((ITroopLinkApi)QRoute.api(ITroopLinkApi.class)).getTroopHonorUrl(this.t.troopuin, 1);
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/browser");
    localActivityURIRequest.extra().putString("url", str);
    QRoute.startUri(localActivityURIRequest, null);
    TroopReportor.a("Grp_set_new", "grpData_admin", "grpHonour_click", 0, 0, new String[] { this.i.troopUin });
    ReportController.b(null, "dc00898", "", "", "0X800A6EF", "0X800A6EF", 0, 0, "", "", "", "");
  }
  
  protected void a(int paramInt)
  {
    if (paramInt != 6) {
      return;
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startTroopMemberCard(this, this.bn, this.t, this.i, 2);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this).notifyUser(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramString = (TextView)paramView.findViewById(2131435692);
    if (paramString != null)
    {
      paramString.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
      if (TextUtils.isEmpty(paramCharSequence)) {
        paramView = "";
      } else {
        paramView = new QQText(paramCharSequence, 3);
      }
      paramString.setText(paramView);
      paramString.setTextColor(getResources().getColor(2131168118));
    }
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView.setTag(Integer.valueOf(paramInt1));
      paramView.setOnClickListener(this);
    }
    else
    {
      paramView.setTag(null);
      paramView.setOnClickListener(null);
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 != 3)
          {
            if (paramInt2 == 4) {
              paramView.setBackgroundColor(Color.parseColor("#00000000"));
            }
          }
          else {
            paramView.setBackgroundResource(2130839629);
          }
        }
        else {
          paramView.setBackgroundResource(2130839632);
        }
      }
      else {
        paramView.setBackgroundResource(2130839638);
      }
    }
    else {
      paramView.setBackgroundResource(2130839622);
    }
    paramView.getBackground().setAlpha(255);
    TextView localTextView = (TextView)paramView.findViewById(2131447463);
    if (localTextView != null) {
      if (TextUtils.isEmpty(paramString))
      {
        localTextView.setText("");
        localTextView.setVisibility(8);
      }
      else
      {
        localTextView.setText(paramString);
        localTextView.setVisibility(0);
      }
    }
    a(paramInt1, paramView, paramBoolean);
  }
  
  protected void a(int paramInt1, int paramInt2, QFormSimpleItem paramQFormSimpleItem, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramQFormSimpleItem.setTag(Integer.valueOf(paramInt1));
      paramQFormSimpleItem.setOnClickListener(this);
      paramQFormSimpleItem.a(true);
    }
    else
    {
      paramQFormSimpleItem.setTag(null);
      paramQFormSimpleItem.setOnClickListener(null);
      paramQFormSimpleItem.a(false);
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 != 3)
          {
            if (paramInt2 == 4) {
              paramQFormSimpleItem.setBackgroundColor(Color.parseColor("#00000000"));
            }
          }
          else {
            paramQFormSimpleItem.setBgType(3);
          }
        }
        else {
          paramQFormSimpleItem.setBgType(2);
        }
      }
      else {
        paramQFormSimpleItem.setBgType(1);
      }
    }
    else {
      paramQFormSimpleItem.setBgType(0);
    }
    paramQFormSimpleItem.setRightTextColor(2);
    paramQFormSimpleItem.setLeftTextColor(0);
    paramQFormSimpleItem.getBackground().setAlpha(255);
    String str2 = "";
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    paramQFormSimpleItem.setLeftText(str1);
    paramQFormSimpleItem.getRightTextView().setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    if (paramCharSequence == null) {
      paramString = str2;
    } else {
      paramString = new QQText(paramCharSequence, 3);
    }
    paramQFormSimpleItem.setRightText(paramString);
  }
  
  protected void a(int paramInt, Intent paramIntent)
  {
    String str2 = this.i.troopUin;
    String str3 = TroopReportor.a(this.i);
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
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).handleAppShareAction(this.bn, this, paramIntent);
  }
  
  protected void a(int paramInt, View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    int i1 = 0;
    if (33 == paramInt) {
      paramBoolean = false;
    }
    paramView = paramView.findViewById(2131428774);
    if (paramView != null)
    {
      if (paramBoolean) {
        paramInt = i1;
      } else {
        paramInt = 8;
      }
      paramView.setVisibility(paramInt);
    }
  }
  
  protected void a(long paramLong)
  {
    if (this.w == null) {
      return;
    }
    ThreadManager.post(new TroopSettingActivity.22(this, paramLong), 8, null, true);
  }
  
  protected void a(BatchResponse paramBatchResponse)
  {
    if (paramBatchResponse != null)
    {
      if (paramBatchResponse.result != 0) {
        return;
      }
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      try
      {
        localOIDBSSOPkg.mergeFrom((byte[])paramBatchResponse.buffer);
        a(paramBatchResponse, localOIDBSSOPkg);
        b(paramBatchResponse, localOIDBSSOPkg);
        c(paramBatchResponse, localOIDBSSOPkg);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBatchResponse)
      {
        paramBatchResponse.printStackTrace();
      }
    }
  }
  
  protected void a(View paramView)
  {
    int[] arrayOfInt = new int[6];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 2131448043;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 2131448044;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131448045;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131448046;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131448047;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131448048;
    tmp38_32;
    this.w = new ArrayList(6);
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = arrayOfInt[i1];
      this.w.add((ImageView)paramView.findViewById(i3));
      i1 += 1;
    }
  }
  
  protected void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null)
    {
      this.C = paramTroopInfo.parseTroopMemeberList();
      if (QLog.isColorLevel())
      {
        paramTroopInfo = new StringBuilder();
        paramTroopInfo.append("getMemberListFromTroopInfo,memberUins.size = ");
        List localList = this.C;
        int i1;
        if (localList != null) {
          i1 = localList.size();
        } else {
          i1 = -1;
        }
        paramTroopInfo.append(i1);
        QLog.d("Q.chatopttroop", 2, paramTroopInfo.toString());
      }
      g();
    }
  }
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    String str1 = null;
    String str2;
    if (paramTroopMemberInfo != null)
    {
      str2 = paramTroopMemberInfo.troopColorNick;
      str1 = paramTroopMemberInfo.troopnick;
    }
    else
    {
      str2 = null;
    }
    if (!TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateNickUseTroopMemberInfo and colorNick is ");
        ((StringBuilder)localObject).append(str2);
        QLog.i("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.i;
      ((TroopInfoData)localObject).troopColorNick = str2;
      ((TroopInfoData)localObject).troopColorNickId = paramTroopMemberInfo.troopColorNickId;
      this.i.troopCard = str1;
      this.aD.sendEmptyMessage(6);
    }
  }
  
  protected void a(TroopSettingActivity.ViewHolder paramViewHolder, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramViewHolder.a == null) {
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = this.D.getBitmapFromCacheFrom(paramViewHolder.d, paramViewHolder.c, 5);
    }
    paramBitmap = localBitmap;
    if (localBitmap == null)
    {
      if (paramBoolean) {
        localBitmap = BaseImageUtil.k();
      }
      paramBitmap = localBitmap;
      if (!this.D.isPausing())
      {
        this.D.requestDecodeFace(paramViewHolder.c, paramViewHolder.d, false);
        paramBitmap = localBitmap;
      }
    }
    if (paramBitmap != null) {
      paramViewHolder.a.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
    }
  }
  
  protected void a(String paramString)
  {
    TroopInfoData localTroopInfoData = this.i;
    localTroopInfoData.troopName = paramString;
    if ((!localTroopInfoData.isNewTroop) || (this.i.hasSetNewTroopName)) {
      this.i.newTroopName = paramString;
    }
    f();
    paramString = this.i;
    paramString.hasSetNewTroopName = true;
    if (paramString.hasSetNewTroopHead) {
      this.i.isNewTroop = false;
    }
    paramString = this.t;
    if (paramString != null)
    {
      paramString.troopname = this.i.troopName;
      this.t.hasSetNewTroopName = this.i.hasSetNewTroopName;
      this.t.isNewTroop = this.i.isNewTroop;
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateTroopInfoToDB(this.t, this.bn, this.i.isMember);
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(this.bn, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.i.troopUin, paramString3, "", "");
  }
  
  protected void a(List<oidb_0x899.memberlist> paramList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateGridTroopMemberFace,list = ");
      ((StringBuilder)localObject).append(paramList);
      QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
    }
    if (paramList == null) {
      return;
    }
    this.B = paramList;
    Object localObject = new ArrayList();
    int i1 = 0;
    while (i1 < this.B.size())
    {
      ((ArrayList)localObject).add(Long.valueOf(((oidb_0x899.memberlist)paramList.get(i1)).uint64_member_uin.get()));
      i1 += 1;
    }
    this.C = ((List)localObject);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("updateGridTroopMemberFace,memberUins.size = ");
      localObject = this.C;
      if (localObject != null) {
        i1 = ((List)localObject).size();
      } else {
        i1 = -1;
      }
      paramList.append(i1);
      QLog.d("Q.chatopttroop", 2, paramList.toString());
    }
    this.aD.post(new TroopSettingActivity.21(this));
  }
  
  public void a(AppRuntime paramAppRuntime, TroopInfo paramTroopInfo, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramAppRuntime != null))
    {
      if (paramTroopInfo == null) {
        return;
      }
      paramAppRuntime = new StringBuffer();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("|");
        paramAppRuntime.append(localStringBuilder.toString());
      }
      paramTroopInfo.Administrator = paramAppRuntime.toString();
      ((ITroopInfoService)this.bn.getRuntimeService(ITroopInfoService.class, "")).saveTroopInfo(paramTroopInfo);
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      e(paramJSONObject);
      return;
    }
    a(paramJSONObject);
  }
  
  protected void a(oidb_0xe83.RspBody paramRspBody)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("showGetAppListResult: respBody isNull=");
      boolean bool;
      if (paramRspBody == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject1).append(bool);
      QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramRspBody == null) {
      return;
    }
    Object localObject1 = this.h[13];
    this.bl.clear();
    if (localObject1 == null) {
      return;
    }
    paramRspBody = paramRspBody.infos.get();
    Object localObject2;
    int i4;
    int i1;
    int i2;
    if ((paramRspBody != null) && (paramRspBody.size() != 0))
    {
      ((View)localObject1).setVisibility(0);
      f((View)localObject1);
      localObject2 = this.y;
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
      i4 = paramRspBody.size();
      a((View)localObject1, i4);
      if (i4 <= 5) {
        i1 = 4;
      } else {
        i1 = 9;
      }
      i2 = 0;
    }
    while (i2 <= i1)
    {
      localObject2 = b((View)localObject1, i2);
      if (localObject2 != null)
      {
        Object localObject3;
        Object localObject4;
        long l1;
        int i3;
        if ((i2 <= i1) && (i2 < i4))
        {
          ((View)localObject2).setVisibility(0);
          localObject3 = (oidb_0xe83.AppInfo)paramRspBody.get(i2);
          localObject4 = a((oidb_0xe83.AppInfo)localObject3);
          if (localObject4 != null)
          {
            ((TextView)((View)localObject2).findViewById(2131428644)).setText((CharSequence)localObject4);
            l1 = ((oidb_0xe83.AppInfo)localObject3).appid.get();
            a((View)localObject2, (oidb_0xe83.AppInfo)localObject3, (String)localObject4, l1);
            a((View)localObject2, (oidb_0xe83.AppInfo)localObject3);
            a((oidb_0xe83.AppInfo)localObject3, l1);
            ((View)localObject2).setTag(localObject3);
            ((View)localObject2).setTag(-1, Integer.valueOf(i2 + 1));
            ((View)localObject2).setOnClickListener(this.aV);
            i3 = 0;
          }
        }
        else
        {
          while (i3 < i4)
          {
            localObject2 = (oidb_0xe83.AppInfo)paramRspBody.get(i3);
            if ((localObject2 != null) && (((oidb_0xe83.AppInfo)localObject2).appid != null))
            {
              localObject3 = this.i.troopUin;
              l1 = this.i.dwGroupClassExt;
              long l2 = ((oidb_0xe83.AppInfo)localObject2).appid.get();
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(String.valueOf(((oidb_0xe83.AppInfo)localObject2).appid.get()));
              ((StringBuilder)localObject4).append("-");
              ((StringBuilder)localObject4).append(String.valueOf(i3 + 1));
              ReportController.b(null, "dc00898", "", (String)localObject3, "0X800AFC3", "0X800AFC3", 0, 0, String.valueOf(l1), String.valueOf(l2), ((StringBuilder)localObject4).toString(), "");
            }
            i3 += 1;
            continue;
            ((View)localObject2).setVisibility(4);
          }
        }
      }
      i2 += 1;
      continue;
      ((View)localObject1).setVisibility(8);
      paramRspBody = this.y;
      if (paramRspBody != null) {
        paramRspBody.setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "showGetAppListResult: appList == null || appList.size() == 0");
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateEnterEffectStatus  isShow = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (QFormSimpleItem)this.h[18];
    if (localObject1 == null) {
      return;
    }
    if (paramBoolean)
    {
      TroopReportor.a("Grp_set_new", "grpData_admin", "specialEntrance_exp", 0, 0, new String[] { this.i.troopUin });
      ((QFormSimpleItem)localObject1).setVisibility(0);
      Object localObject2 = this.h[17];
      if ((localObject2 != null) && ((localObject2 instanceof QFormSimpleItem))) {
        ((QFormSimpleItem)localObject2).setBgType(2);
      }
      Object localObject3 = (ITroopEnterEffectService)this.bn.getRuntimeService(ITroopEnterEffectService.class, "all");
      localObject2 = ((ITroopEnterEffectService)localObject3).getAllEffectInfo();
      if (localObject2 != null)
      {
        localObject3 = ((ITroopEnterEffectService)localObject3).getEffectInfo(this.i.troopUin);
        if ((localObject3 != null) && (((TroopEnterEffectConfig.EffectInfoData)localObject3).b > 0))
        {
          ((QFormSimpleItem)localObject1).setRightText(((TroopEnterEffectConfig.EffectInfoData)localObject3).c);
          return;
        }
        if (((TroopEnterEffectConfig.EffectInfo)localObject2).b > 0)
        {
          ((QFormSimpleItem)localObject1).setRightText(((TroopEnterEffectConfig.EffectInfo)localObject2).c);
          return;
        }
        ((QFormSimpleItem)localObject1).setRightText(HardCodeUtil.a(2131899968));
        return;
      }
      ((QFormSimpleItem)localObject1).setRightText(HardCodeUtil.a(2131899976));
      return;
    }
    ((QFormSimpleItem)localObject1).setVisibility(8);
  }
  
  protected boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "checkParams");
    }
    Object localObject = this.bn;
    boolean bool3 = false;
    boolean bool1 = false;
    if (localObject == null) {
      return false;
    }
    boolean bool2 = bool3;
    try
    {
      this.l = false;
      bool2 = bool3;
      this.j = false;
      bool2 = bool3;
      localObject = getIntent().getExtras();
      bool2 = bool3;
      this.i = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).initTroopInfoData((Bundle)localObject, this);
      bool2 = bool3;
      TroopInfo localTroopInfo = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).initTroopInfo(this.bn, this.i, this);
      if (localTroopInfo != null)
      {
        bool2 = bool3;
        this.t = localTroopInfo;
      }
      bool2 = bool3;
      this.i.troopUin = ((Bundle)localObject).getString("troop_uin");
      bool2 = bool3;
      if (Long.parseLong(this.i.troopUin) > 0L) {
        bool1 = true;
      }
      bool2 = bool1;
      this.M = ((Bundle)localObject).getInt("D2GType");
      bool2 = bool1;
      this.aC = ((Bundle)localObject).getInt("filter_id", -1);
      bool2 = bool1;
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).setExposureSource(((Bundle)localObject).getInt("exposureSource", 99));
      bool2 = bool1;
      this.ac = ((Bundle)localObject).getBoolean("fromThirdAppByOpenSDK");
      bool2 = bool1;
      this.aa = ((Bundle)localObject).getString("authKey");
      bool2 = bool1;
      this.ab = ((Bundle)localObject).getString("authSig");
      return bool1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, localException.toString());
      }
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).bnrReport(this.bn, 69);
    }
    return bool2;
  }
  
  protected boolean a(ArrayList<TroopMemberCardInfo> paramArrayList)
  {
    Object localObject = null;
    int i1 = 0;
    while ((localObject == null) && (i1 < paramArrayList.size()))
    {
      TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList.get(i1);
      if (localTroopMemberCardInfo == null)
      {
        localObject = localTroopMemberCardInfo;
      }
      else if (Utils.a(localTroopMemberCardInfo.troopuin, this.i.troopUin))
      {
        localObject = localTroopMemberCardInfo;
        if (Utils.a(localTroopMemberCardInfo.memberuin, this.bn.getCurrentAccountUin())) {}
      }
      else
      {
        localObject = null;
      }
      i1 += 1;
    }
    paramArrayList = this.i.troopCard;
    if ((localObject != null) && (!Utils.a(paramArrayList, this.i.troopCard)))
    {
      paramArrayList = localObject.name;
      this.i.troopColorNick = localObject.colorNick;
      this.i.troopColorNickId = localObject.colorNickId;
      this.i.troopCard = localObject.name;
      this.aD.sendEmptyMessage(6);
    }
    return localObject != null;
  }
  
  void b()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      View localView = View.inflate(this, 2131629570, null);
      this.U = ((XListView)localView.findViewById(2131431170));
      this.a = ((ImmersiveTitleBar2)localView.findViewById(2131447582));
      this.U.setVerticalScrollBarEnabled(false);
      this.U.setDivider(null);
      this.h = new View[51];
      this.b = new LinearLayout(this);
      Object localObject = new AbsListView.LayoutParams(-1, -2);
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.b.setOrientation(1);
      localObject = new XSimpleListAdapter(this.b);
      this.U.setAdapter((ListAdapter)localObject);
      this.u = ((ITroopInfoService)this.bn.getRuntimeService(ITroopInfoService.class, "")).isQidianPrivateTroop(this.i.troopUin);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("intNewStyleUI mIsQidianPrivateTroop : ");
        ((StringBuilder)localObject).append(this.u);
        ((StringBuilder)localObject).append(", troopUin = ");
        ((StringBuilder)localObject).append(this.i.troopUin);
        QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
      }
      super.setContentView(localView);
      this.av = localView;
      this.av.setBackgroundResource(2130838958);
      this.o = localView.findViewById(2131447561);
      this.p = ((RelativeLayout)localView.findViewById(2131447484));
      localObject = this.p;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.i.newTroopName);
      localStringBuilder.append(" ");
      localStringBuilder.append(getResources().getString(2131887749));
      ((RelativeLayout)localObject).setContentDescription(localStringBuilder.toString());
      this.p.setFocusable(true);
      this.q = ((TextView)localView.findViewById(2131436227));
      this.q.setText(getResources().getString(2131887749));
      this.r = ((TextView)localView.findViewById(2131436180));
      localObject = this.r;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131892338));
      localStringBuilder.append(getString(2131887622));
      ((TextView)localObject).setContentDescription(localStringBuilder.toString());
      this.s = ((ImageView)localView.findViewById(2131436194));
      this.s.setContentDescription(getString(2131890913));
      TroopReportor.a("Grp_set_new", "grpData_admin", "share_exp", 0, 0, new String[] { this.i.troopUin });
      this.D = ((IQQAvatarService)this.bn.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.bn);
      this.D.setDecodeTaskCompletionListener(this);
      d(localView);
      G();
      F();
      E();
      D();
      C();
      B();
      A();
      z();
      y();
      x();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initNewStyleUI  mIsQidianPrivateTroop = ");
        ((StringBuilder)localObject).append(this.u);
        ((StringBuilder)localObject).append(",time = ");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
        QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
      }
      c(localView);
      b(false);
      this.aD.sendEmptyMessage(17);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      finish();
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt != 11) {
      return;
    }
    if ((this.i.pa == 15) || (this.i.pa == 10) || (this.i.pa == 11)) {
      ReportController.b(this.bn, "P_CliOper", "Grp_nearby", "", "nearbygrp_data", "Clk_place", 0, 0, this.i.troopUin, "", "", "");
    }
    if ((!TextUtils.isEmpty(this.i.troopLocation)) && (this.i.troopLat != 0) && (this.i.troopLon != 0))
    {
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/browser");
      double d1 = this.i.troopLat;
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      double d2 = this.i.troopLon;
      Double.isNaN(d2);
      String str = String.format("https://nearby.qq.com/hot_chat/qun_class.html?_wv=1031&latitude=%1$s&longitude=%2$s", new Object[] { String.valueOf(d1), String.valueOf(d2 / 1000000.0D) });
      localActivityURIRequest.extra().putString("url", str);
      QRoute.startUri(localActivityURIRequest, null);
      a("Grp", "Clk_grp_map", "0");
      return;
    }
    if (this.i.isOwnerOrAdim())
    {
      ReportController.b(this.bn, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.i.troopUin, "", "", "");
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startModifyLocationActivityForResult(this, this.i.troopUin, this.i.troopLocation, 12);
    }
  }
  
  protected void b(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      boolean bool = paramIntent.getBooleanExtra(((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getQzoneHelperQunPhotoDataHasChange(), true);
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("resultForRequestQzonePhoto|needRereshed = ");
        paramIntent.append(bool);
        QLog.i("Q.chatopttroop", 2, paramIntent.toString());
      }
      if (bool) {
        l();
      }
    }
    ThreadManager.post(new TroopSettingActivity.49(this), 8, null, true);
  }
  
  protected void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    TextView localTextView = (TextView)paramView.findViewById(2131447463);
    paramView = paramView.findViewById(2131444790);
    if ((localTextView != null) && (paramView != null) && (!TextUtils.isEmpty(localTextView.getText())))
    {
      int i1 = (int)localTextView.getPaint().measureText(localTextView.getText().toString());
      ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).leftMargin = (i1 + Utils.a(30.0F, getResources()));
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    Object localObject = this.i;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "mTroopInfoData is null!");
      }
      return;
    }
    View localView = this.h[5];
    paramBoolean = ((TroopInfoData)localObject).isOwnerOrAdim();
    int i2 = 0;
    int i1;
    if ((paramBoolean) && (this.k)) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    if (localView != null) {
      localView.setVisibility(i1);
    }
    localObject = (QFormSimpleItem)this.h[6];
    if (localObject != null)
    {
      if (i1 == 0) {
        i2 = 3;
      }
      ((QFormSimpleItem)localObject).setBgType(i2);
    }
  }
  
  protected void c()
  {
    if (!NetworkUtil.isNetworkAvailable(getApplicationContext())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "initNetworkRequests");
    }
    Object localObject1 = (ITroopSettingHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopSettingHandlerName());
    ITroopListHandler localITroopListHandler = (ITroopListHandler)this.bn.getBusinessHandler(TroopListHandler.class.getName());
    Object localObject2 = (ITroopMemberCardHandler)this.bn.getBusinessHandler(TroopMemberCardHandler.class.getName());
    ITroopAppHandler localITroopAppHandler = (ITroopAppHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAppHandlerName());
    if (localObject2 != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.bn.getCurrentAccountUin());
      ((ITroopMemberCardHandler)localObject2).a(this.i.troopUin, this.i.troopCode, localArrayList);
    }
    if ((localITroopListHandler != null) && (localObject1 != null))
    {
      l();
      if (this.i.isMember)
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(Long.valueOf(Long.parseLong(this.i.troopUin)));
        localITroopListHandler.a((ArrayList)localObject2);
        ((ITroopSettingHandler)localObject1).a(this.i.troopUin);
      }
    }
    this.W = ((ITroopCardAppInfoHelperApi)QRoute.api(ITroopCardAppInfoHelperApi.class));
    this.W.init(this.bn);
    Q();
    if (localITroopAppHandler != null)
    {
      localObject1 = this.i.troopUin;
      int i1;
      if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
        i1 = 1;
      } else {
        i1 = -1;
      }
      localITroopAppHandler.a((String)localObject1, false, 0, 1, i1);
    }
  }
  
  protected void c(int paramInt, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      if (paramIntent.getExtras().getBoolean("isNeedFinish"))
      {
        paramIntent = new Intent();
        paramIntent.putExtra("isNeedFinish", true);
        setResult(-1, paramIntent);
        finish();
        return;
      }
      if (paramIntent.getExtras().getBoolean("finish_chat_setting"))
      {
        finish();
        return;
      }
    }
    paramIntent = (ITroopInfoService)this.bn.getRuntimeService(ITroopInfoService.class, "");
    if (paramIntent == null) {
      paramIntent = null;
    } else {
      paramIntent = paramIntent.findTroopInfo(this.i.troopUin);
    }
    if ((paramIntent != null) && (paramIntent.wMemberNum != this.i.wMemberNum))
    {
      this.i.updateTroopAdmMemberNum(paramIntent.Administrator, paramIntent.wMemberNum, this.bn.getCurrentAccountUin(), getResources());
      paramIntent = this.ag;
      if (paramIntent != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.i.wMemberNum);
        localStringBuilder.append(HardCodeUtil.a(2131899977));
        paramIntent.setText(localStringBuilder.toString());
      }
    }
    if (this.N != null)
    {
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("resultForTroopMemberList,memberListForCard.size = ");
        paramIntent.append(this.N.size());
        QLog.d("Q.chatopttroop", 2, paramIntent.toString());
      }
      a(this.N);
    }
    paramIntent = (ITroopMemberInfoService)this.bn.getRuntimeService(ITroopMemberInfoService.class, "");
    if (this.h[6] != null) {
      ThreadManager.post(new TroopSettingActivity.50(this, paramIntent), 8, null, true);
    }
  }
  
  protected void d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init(), isInitialized = ");
      localStringBuilder.append(this.j);
      QLog.i("Q.chatopttroop", 2, localStringBuilder.toString());
    }
    if (this.j) {
      return;
    }
    this.j = true;
    if (!this.l) {
      this.aD.sendEmptyMessage(3);
    }
    if (this.q != null)
    {
      this.S = getResources().getDrawable(2130839585);
      this.q.setCompoundDrawablesWithIntrinsicBounds(this.S, null, null, null);
      this.q.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131298802));
      ((Animatable)this.S).start();
    }
    if (!NetworkUtil.isNetworkAvailable(getApplicationContext())) {
      QQToast.makeText(getApplicationContext(), 1, getString(2131892104), 1).show(getTitleBarHeight());
    }
    ThreadManager.post(this.aw, 8, null, false);
    this.T = new TroopSettingActivity.15(this);
    this.p.setOnClickListener(this.T);
    this.r.setOnClickListener(this.T);
    this.s.setOnClickListener(this.T);
  }
  
  protected void d(int paramInt, Intent paramIntent)
  {
    m();
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
      ThreadManager.post(new TroopSettingActivity.51(this, paramIntent), 8, null, true);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onActivityResult, requestCode = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", resultCode = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", data = ");
      ((StringBuilder)localObject).append(paramIntent);
      QLog.i("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 != 145)
    {
      switch (paramInt1)
      {
      default: 
        switch (paramInt1)
        {
        default: 
          return;
        case 21: 
          V();
          return;
        case 20: 
          j(paramInt2, paramIntent);
          return;
        case 19: 
          ao();
          return;
        case 18: 
          c(paramIntent);
          return;
        case 17: 
          i(paramInt2, paramIntent);
          return;
        case 16: 
          h(paramInt2, paramIntent);
          return;
        }
        an();
        return;
      case 13: 
        g(paramInt2, paramIntent);
        return;
      case 12: 
        f(paramInt2, paramIntent);
        return;
      case 11: 
        ((ITroopInfoHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName())).d(this.i.troopUin);
        return;
      case 10: 
        if ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("has_operation", false))) {
          break;
        }
        this.af = paramIntent;
        return;
      case 9: 
        c(paramInt2, paramIntent);
        return;
      case 8: 
        d(paramInt2, paramIntent);
        e(paramInt2, paramIntent);
        return;
      case 7: 
        b(paramInt2, paramIntent);
        return;
      case 6: 
        F(paramInt2);
        return;
      case 5: 
        if (paramInt2 != -1) {
          break;
        }
        setResult(-1);
        this.aR = true;
        return;
      case 4: 
        e(paramInt2, paramIntent);
        return;
      case 3: 
        a(paramInt2, paramIntent);
        return;
      case 2: 
        b(paramIntent);
        return;
      case 1: 
        if ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("select_member_add_request_ok", false))) {
          break;
        }
        this.bs = true;
        return;
      }
    }
    else
    {
      localObject = this.i.troopUin;
      String str = TroopReportor.a(this.i);
      if (paramInt2 == -1) {
        paramIntent = "0";
      } else {
        paramIntent = "1";
      }
      TroopReportor.a("Grp_share", "grpData_admin", "share_qzone", 0, 0, new String[] { localObject, str, paramIntent });
    }
  }
  
  public void doOnBackPressed()
  {
    at();
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.bn = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    t();
    long l1;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    } else {
      l1 = 0L;
    }
    if (!a())
    {
      if ((QLog.isColorLevel()) && (this.t != null))
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCreate, illegal param, troopuin = ");
        paramBundle.append(this.i.troopUin);
        QLog.i("Q.chatopttroop", 2, paramBundle.toString());
      }
      finish();
      return false;
    }
    this.O = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(this.O);
    try
    {
      if ((this.i != null) && (!TextUtils.isEmpty(this.i.troopUin))) {
        ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).checkIsShowCacheAppInfos(this.bn, this.i.troopUin, this.Z);
      }
      paramBundle = (TroopLuckyCharacterConfig)QConfigManager.b().b(696);
      if (paramBundle != null) {
        this.K = paramBundle.b(this.i.troopUin);
      }
      this.X = ((IRoamSettingService)this.bn.getRuntimeService(IRoamSettingService.class, ""));
      b();
      a(this.t);
      if (!L()) {
        M();
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCreate(), time = ");
        paramBundle.append(System.currentTimeMillis() - l1);
        QLog.i("Q.chatopttroop", 2, paramBundle.toString());
      }
      ThreadManager.getSubThreadHandler().post(new TroopSettingActivity.4(this));
      u();
      v();
      this.ai = getIntent().getStringExtra("focusItem");
      if (this.K) {
        w();
      }
      this.aB = new QQProgressDialog(this, getTitleBarHeight());
      this.aB.setCancelable(false);
      return true;
    }
    catch (InflateException paramBundle)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("init UI got InflateException, e:");
        localStringBuilder.append(paramBundle.getMessage());
        QLog.e("Q.chatopttroop", 2, localStringBuilder.toString());
      }
      System.gc();
      finish();
      return false;
    }
    catch (OutOfMemoryError paramBundle)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initUI got OOM, e:");
        localStringBuilder.append(paramBundle.getMessage());
        QLog.e("Q.chatopttroop", 2, localStringBuilder.toString());
      }
      System.gc();
      finish();
    }
    return false;
  }
  
  public void doOnDestroy()
  {
    Object localObject1 = this.d;
    if (localObject1 != null) {
      ((Button)localObject1).getBackground().setColorFilter(null);
    }
    this.P = true;
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    }
    try
    {
      this.l = true;
      localObject1 = this.D;
      if (localObject1 != null) {
        ((IFaceDecoder)localObject1).destory();
      }
      localObject1 = this.be;
      if (localObject1 != null) {
        ((RobotMemberFormItem)localObject1).b();
      }
      removeObserver(this.aZ);
      removeObserver(this.aQ);
      removeObserver(this.aP);
      removeObserver(this.aS);
      removeObserver(this.aT);
      removeObserver(this.aK);
      removeObserver(this.bp);
      removeObserver(this.aH);
      removeObserver(this.aI);
      removeObserver(this.aJ);
      removeObserver(this.aE);
      removeObserver(this.aF);
      removeObserver(this.bq);
      removeObserver(this.bo);
      removeObserver(this.aO);
      removeObserver(this.aM);
      removeObserver(this.aG);
      removeObserver(this.aN);
      removeObserver(this.aL);
      removeObserver(this.bb);
      localObject1 = this.aD;
      if (localObject1 != null) {
        ((Handler)localObject1).removeCallbacksAndMessages(null);
      }
      localObject1 = this.S;
      if ((localObject1 != null) && (((Animatable)localObject1).isRunning())) {
        ((Animatable)this.S).stop();
      }
      localObject1 = this.bj;
      if ((localObject1 != null) && (((Dialog)localObject1).isShowing())) {
        this.bj.dismiss();
      }
      GroupCatalogTool.a(this).c();
      localObject1 = this.aU;
      if (localObject1 != null) {
        ((QQProgressDialog)localObject1).dismiss();
      }
      localObject1 = this.W;
      if (localObject1 != null) {
        ((ITroopCardAppInfoHelperApi)localObject1).destroy();
      }
      try
      {
        unregisterReceiver(this.au);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doOnDestroy unregisterReceiver, e:");
          localStringBuilder.append(localException.getMessage());
          QLog.e("Q.chatopttroop", 2, localStringBuilder.toString());
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("doOnDestroy unregisterReceiver, e:");
          localStringBuilder.append(localIllegalArgumentException.getMessage());
          QLog.e("Q.chatopttroop", 2, localStringBuilder.toString());
        }
      }
      Object localObject2 = this.aX;
      if (localObject2 != null) {
        ((Handler)localObject2).removeCallbacksAndMessages(null);
      }
      this.aW = null;
      localObject2 = this.f;
      if (localObject2 != null) {
        ((QQBlurView)localObject2).c();
      }
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).troopShareUtilityDestroy();
      Z();
      super.doOnDestroy();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onDestroy(), time = ");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l1);
        QLog.i("Q.chatopttroop", 2, ((StringBuilder)localObject2).toString());
      }
      ac();
      return;
    }
    finally {}
  }
  
  protected void doOnPause()
  {
    Button localButton = this.d;
    if (localButton != null) {
      localButton.getBackground().setColorFilter(null);
    }
    super.doOnPause();
    this.f.b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    URLDrawable.resume();
    int i1;
    if ((TroopInfo.hasPayPrivilege(this.i.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.i.mTroopPrivilegeFlag, 512))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((this.d != null) && (i1 != 0) && (!this.i.isMember)) {
      this.d.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
    }
    Object localObject1 = (ITroopAppHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAppHandlerName());
    Object localObject2;
    if (this.as)
    {
      this.as = false;
      localObject2 = this.i.troopUin;
      String str = TroopReportor.a(this.i);
      if (this.i.hasSetNewTroopHead) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      TroopReportor.a("Grp_set_new", "grpData_admin", "exp", 0, 0, new String[] { localObject2, str, localObject1 });
    }
    else
    {
      localObject2 = (ITroopAppService)this.bn.getRuntimeService(ITroopAppService.class, "all");
      if ((localObject2 != null) && (((ITroopAppService)localObject2).getProfileAppListChangedFromWebOperate(this.i.troopUin)) && (localObject1 != null))
      {
        localObject2 = this.i.troopUin;
        if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
          i1 = 1;
        } else {
          i1 = -1;
        }
        ((ITroopAppHandler)localObject1).a((String)localObject2, true, 0, 1, i1);
      }
      if (this.bk)
      {
        l();
        this.bk = false;
      }
    }
    if ((this.i.isMember) && (((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).isRobotSwitchOn(this.bn)))
    {
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(this.i.troopUin);
        l1 = l2;
      }
      catch (Exception localException)
      {
        QLog.e("Q.chatopttroop", 2, "onResume  parseLong err", localException);
      }
      ITroopRobotHandler localITroopRobotHandler = (ITroopRobotHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopRobotHandlerName());
      if (localITroopRobotHandler != null) {
        localITroopRobotHandler.b(l1);
      }
    }
    if (this.bm)
    {
      k(true);
      this.bm = false;
    }
    this.f.a();
    as();
    aq();
    ReportController.b(null, "dc00898", "", this.i.troopUin, "qq_vip", "0X800A8F6", 0, 1, 0, "", "", "", "");
    if (this.h[40] != null) {
      H();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (!this.Q)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStart add observer");
      }
      addObserver(this.aQ);
      addObserver(this.aP);
      addObserver(this.aS);
      addObserver(this.aT);
      addObserver(this.aF);
      addObserver(this.aK);
      addObserver(this.aH);
      addObserver(this.aI);
      addObserver(this.aJ);
      addObserver(this.aG);
      addObserver(this.aO);
      addObserver(this.aM);
      addObserver(this.aN);
      addObserver(this.aE);
      addObserver(this.bp);
      this.Q = true;
    }
    if (this.R) {
      this.R = false;
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.Q)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStop remove observer");
      }
      removeObserver(this.aQ);
      removeObserver(this.aP);
      removeObserver(this.aF);
      removeObserver(this.aK);
      removeObserver(this.bp);
      removeObserver(this.aH);
      removeObserver(this.aI);
      removeObserver(this.aJ);
      removeObserver(this.aG);
      removeObserver(this.aE);
      this.Q = false;
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.j)) {
      this.aD.sendEmptyMessage(1);
    }
  }
  
  protected void e()
  {
    Object localObject = this.h[23];
    if (localObject != null)
    {
      if (this.i == null) {
        return;
      }
      localObject = (TextView)((View)localObject).findViewById(2131448013);
      ((TextView)localObject).setTag(Integer.valueOf(39));
      int i1 = this.i.nTroopGrade;
      if (!this.i.isShowActivityGrade()) {
        i1 = 0;
      }
      if (i1 > 0)
      {
        String str = String.format(getResources().getString(2131890936), new Object[] { Integer.valueOf(i1) });
        ((TextView)localObject).setText(str);
        ((TextView)localObject).setContentDescription(str);
        ((TextView)localObject).setVisibility(0);
      }
      else
      {
        ((TextView)localObject).setVisibility(8);
      }
      if (this.u) {
        ((TextView)localObject).setVisibility(8);
      }
      ((TextView)localObject).setOnClickListener(this);
    }
  }
  
  protected void e(int paramInt, Intent paramIntent)
  {
    if (paramInt != -1) {
      return;
    }
    if (paramIntent != null)
    {
      boolean bool = paramIntent.getBooleanExtra("isNeedFinish", false);
      String str = paramIntent.getStringExtra("fin_tip_msg");
      paramIntent = paramIntent.getStringExtra("uin");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ChatSettingActivity|onActivityResult|REQUEST_FOR_TROOP_DISBAND|isNeedFinish = ");
        localStringBuilder.append(bool);
        localStringBuilder.append(", strTip = ");
        localStringBuilder.append(str);
        QLog.i("Q.troopdisband.", 2, localStringBuilder.toString());
      }
      if ((!TextUtils.isEmpty(str)) && (bool))
      {
        if (this.n == null) {
          this.n = new QQProgressNotifier(this);
        }
        this.n.a(5, str, 1000);
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        if (!TextUtils.isEmpty(paramIntent)) {
          this.i.updateTroopOwner(paramIntent, this.bn.getCurrentAccountUin());
        }
        aD();
        R();
        if (this.n == null) {
          this.n = new QQProgressNotifier(this);
        }
        this.n.a(1, str, 1000);
        return;
      }
      if (bool)
      {
        paramIntent = new Intent();
        paramIntent.putExtra("isNeedFinish", true);
        setResult(-1, paramIntent);
        finish();
      }
    }
  }
  
  protected void f()
  {
    boolean bool = this.i.isOwnerOrAdim();
    View localView = this.h[14];
    Object localObject1;
    Object localObject2;
    if (localView != null)
    {
      if (this.i.hasSetNewTroopName) {
        localObject1 = this.i.newTroopName;
      } else {
        localObject1 = HardCodeUtil.a(2131899988);
      }
      localView.setOnClickListener(this);
      if (AppSetting.e)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131899962));
        localStringBuilder.append((String)localObject1);
        if (bool) {
          localObject2 = HardCodeUtil.a(2131899951);
        } else {
          localObject2 = "";
        }
        localStringBuilder.append((String)localObject2);
        localView.setContentDescription(localStringBuilder.toString());
      }
      a(localView, ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText((CharSequence)localObject1, 32), null, null);
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("updateTroopNameEntry %s", new Object[] { localObject1 }));
      }
    }
    localView = this.h[36];
    if (localView != null)
    {
      localObject2 = this.i.newTroopName;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = HardCodeUtil.a(2131899978);
      }
      ((TextView)localView).setText((CharSequence)localObject1);
      if (AppSetting.e)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131899946));
        ((StringBuilder)localObject2).append((String)localObject1);
        localView.setContentDescription(((StringBuilder)localObject2).toString());
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("updateHostTroopNameEntry %s", new Object[] { localObject1 }));
      }
    }
  }
  
  protected void g()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateShowFace  memberUins.size = ");
      ((StringBuilder)localObject).append(this.C);
      int i1;
      if (((StringBuilder)localObject).toString() != null) {
        i1 = this.C.size();
      } else {
        i1 = -1;
      }
      QLog.d("Q.chatopttroop", 2, new Object[] { Integer.valueOf(i1) });
    }
    Object localObject = this.z;
    if (localObject != null)
    {
      ((MyGridView)localObject).setPadding(this.E, this.G, this.F, this.H);
      localObject = this.A;
      if (localObject == null)
      {
        this.A = new TroopSettingActivity.ListAdapter(this);
        this.z.setAdapter(this.A);
        return;
      }
      ((TroopSettingActivity.ListAdapter)localObject).notifyDataSetChanged();
    }
  }
  
  protected void h()
  {
    if (!this.i.canInviteMember()) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("last_update_time");
    ((StringBuilder)localObject1).append(this.bn.getCurrentAccountUin());
    localObject1 = getSharedPreferences(((StringBuilder)localObject1).toString(), 4);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("key_last_update_time");
    ((StringBuilder)localObject2).append(this.i.troopUin);
    long l1 = ((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), 0L);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("TroopMemberList lastUpdateTime:");
      ((StringBuilder)localObject2).append(l1);
      QLog.i("Q.chatopttroop", 2, ((StringBuilder)localObject2).toString());
    }
    if (l1 == 0L)
    {
      localObject2 = (ITroopMemberListHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberListHandlerName());
      if (localObject2 != null) {
        ((ITroopMemberListHandler)localObject2).a(true, this.i.troopUin, this.i.troopCode, 6);
      }
      localObject1 = ((SharedPreferences)localObject1).edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("key_last_update_time");
      ((StringBuilder)localObject2).append(this.i.troopUin);
      ((SharedPreferences.Editor)localObject1).putLong(((StringBuilder)localObject2).toString(), System.currentTimeMillis()).commit();
    }
    ThreadManager.post(this.az, 5, null, false);
  }
  
  protected void i()
  {
    if (System.currentTimeMillis() - this.aA < 1500L) {
      return;
    }
    this.aA = System.currentTimeMillis();
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("troop_uin", this.i.troopUin);
    ((Intent)localObject).putExtra("param_from", 0);
    ((Intent)localObject).putExtra("TROOP_INFO_MEMBER_NUM", this.i.wMemberNum);
    RouteUtils.a(this, (Intent)localObject, "/troop/memberlist/TroopMemberList", 9);
    localObject = "2";
    for (;;)
    {
      try
      {
        if (this.i.bOwner) {
          localObject = "0";
        } else if (this.i.bAdmin) {
          localObject = "1";
        }
      }
      catch (Exception localException)
      {
        return;
      }
      ReportController.b(this.bn, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, this.i.troopUin, "0", (String)localObject, "");
      return;
    }
  }
  
  public void j()
  {
    View localView = this.h[11];
    if (localView != null)
    {
      if ((localView instanceof QFormSimpleItem))
      {
        TroopInfoData localTroopInfoData = this.i;
        if ((localTroopInfoData != null) && (!TextUtils.isEmpty(localTroopInfoData.troopLocation)))
        {
          localView.setVisibility(0);
          a(11, 3, (QFormSimpleItem)localView, this.i.troopLocation, null, true);
          return;
        }
      }
      localView.setVisibility(8);
    }
  }
  
  public void k()
  {
    View localView = this.h[22];
    if (localView != null)
    {
      if ((localView instanceof QFormSimpleItem))
      {
        TroopInfoData localTroopInfoData = this.i;
        if ((localTroopInfoData != null) && (!TextUtils.isEmpty(localTroopInfoData.troopAuthenticateInfo)))
        {
          localView.setVisibility(0);
          a(22, 1, (QFormSimpleItem)localView, this.i.troopAuthenticateInfo, null, true);
          return;
        }
      }
      localView.setVisibility(8);
    }
  }
  
  protected void l()
  {
    ITroopAnnouncementHandler localITroopAnnouncementHandler = (ITroopAnnouncementHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAnnouncementHandlerName());
    ITroopInfoHandler localITroopInfoHandler = (ITroopInfoHandler)this.bn.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName());
    if (localITroopAnnouncementHandler != null)
    {
      if (localITroopInfoHandler == null) {
        return;
      }
      try
      {
        if (this.t == null) {
          this.t = ((ITroopInfoService)this.bn.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.i.troopUin);
        }
        TroopInfo localTroopInfo = this.t;
        if (localTroopInfo != null) {
          localITroopInfoHandler.a(this.t.troopuin, 1000L, "getGroupInfoFromChatSettingForTroop");
        } else {
          localITroopInfoHandler.a(this.i.troopUin, 1000L, "getGroupInfoFromChatSettingForTroop");
        }
        if (this.t != null)
        {
          localITroopAnnouncementHandler.a(this.t.troopuin);
          return;
        }
        localITroopAnnouncementHandler.a(this.i.troopUin);
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, localException.toString());
        }
      }
    }
  }
  
  protected void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "refreshTroopBasicInfo");
    }
    this.t = ((ITroopInfoService)this.bn.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.i.troopUin);
    this.i.updateForTroopChatSetting(this.t, getResources(), this.bn.getCurrentAccountUin());
    if ((this.i.isNewTroop) && (this.i.hasSetNewTroopHead) && (this.i.hasSetNewTroopName))
    {
      this.i.isNewTroop = false;
      TroopInfo localTroopInfo = this.t;
      if (localTroopInfo != null)
      {
        localTroopInfo.isNewTroop = false;
        ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateTroopInfoToDB(this.t, this.bn, this.i.isMember);
      }
    }
    f();
    am();
    p();
    a(this.u ^ true, this.i.isNewTroop);
  }
  
  public void n()
  {
    try
    {
      if (this.aU == null)
      {
        this.aU = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.aU.c(2131892360);
        this.aU.c(false);
      }
      this.aU.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, localException.toString());
      }
    }
  }
  
  public void o()
  {
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).hideJuhua(this.aU, "Q.chatopttroop");
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = paramCompoundButton.getTag();
    if ((localObject instanceof Integer))
    {
      int i1 = ((Integer)localObject).intValue();
      if (i1 != 7)
      {
        if (i1 != 10)
        {
          if (i1 != 19)
          {
            if (i1 != 31)
            {
              if (i1 != 47)
              {
                if (i1 == 48) {
                  g(paramBoolean);
                }
              }
              else {
                f(paramBoolean);
              }
            }
            else {
              a(1, paramBoolean);
            }
          }
          else {
            j(paramBoolean);
          }
        }
        else {
          i(paramBoolean);
        }
      }
      else {
        h(paramBoolean);
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView == null) {
      localObject = null;
    } else {
      localObject = paramView.getTag();
    }
    if ((this.i != null) && ((localObject instanceof Integer)))
    {
      int i1 = ((Integer)localObject).intValue();
      e(i1);
      a(i1);
      f(i1);
      g(i1);
      a(i1, paramView);
      h(i1);
      i(i1);
      j(i1);
      k(i1);
      l(i1);
      m(i1);
      n(i1);
      b(i1, paramView);
      o(i1);
      p(i1);
      q(i1);
      b(i1);
      r(i1);
      s(i1);
      t(i1);
      u(i1);
      v(i1);
      w(i1);
      x(i1);
      y(i1);
      z(i1);
      A(i1);
      B(i1);
      c(i1, paramView);
      d(i1, paramView);
      C(i1);
      D(i1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("onDecodeTaskCompleted uin=%s", new Object[] { paramString }));
      }
      if ((paramString != null) && (paramString.equals(this.i.troopUin)))
      {
        J();
        return;
      }
      Object localObject = this.z;
      if (localObject != null)
      {
        paramInt2 = ((MyGridView)localObject).getChildCount();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          localObject = this.z.getChildAt(paramInt1).getTag();
          if ((localObject != null) && ((localObject instanceof TroopSettingActivity.ViewHolder)))
          {
            localObject = (TroopSettingActivity.ViewHolder)localObject;
            if (paramString == null)
            {
              a((TroopSettingActivity.ViewHolder)localObject, null, false);
            }
            else if (paramString.equals(((TroopSettingActivity.ViewHolder)localObject).c))
            {
              ((TroopSettingActivity.ViewHolder)localObject).a.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
              return;
            }
          }
          paramInt1 += 1;
        }
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  protected void p()
  {
    View localView = this.h[19];
    if (localView != null)
    {
      TroopInfo localTroopInfo = this.t;
      if (localTroopInfo != null)
      {
        if ((!localTroopInfo.mCanSearchByKeywords) && (!this.t.mCanSearchByTroopUin))
        {
          localView.setVisibility(8);
          return;
        }
        localView.setVisibility(0);
      }
    }
  }
  
  public void q()
  {
    Context localContext = getApplicationContext();
    Object localObject = this.i;
    if (localObject != null)
    {
      localObject = Long.toString(((TroopInfoData)localObject).dwGroupClassExt);
      GroupCatalogTool.a(localContext).a((String)localObject, null);
    }
  }
  
  public void r()
  {
    Object localObject = this.aW;
    if (localObject != null)
    {
      if (!((QQCustomDialog)localObject).isShowing()) {
        this.aW.show();
      }
      return;
    }
    this.aW = DialogUtil.a(this, 230);
    this.aW.setMessage(2131892939);
    this.aW.setTitle(2131889094);
    localObject = new TroopSettingActivity.59(this);
    this.aW.setNegativeButton(2131887648, (DialogInterface.OnClickListener)localObject);
    this.aW.setPositiveButton(2131892907, (DialogInterface.OnClickListener)localObject);
    this.aW.show();
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void s()
  {
    if (this.bn != null)
    {
      Object localObject = this.i;
      if (localObject != null)
      {
        if (TextUtils.isEmpty(((TroopInfoData)localObject).troopUin)) {
          return;
        }
        localObject = (ITroopMemberInfoService)this.bn.getRuntimeService(ITroopMemberInfoService.class, "");
        if (((ITroopMemberInfoService)localObject).isMemberInCache(this.i.troopUin, this.bn.getCurrentAccountUin()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "updateNick use cache");
          }
          a(((ITroopMemberInfoService)localObject).getTroopMember(this.i.troopUin, this.bn.getCurrentAccountUin()));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, "updateNick async");
        }
        ThreadManager.post(new TroopSettingActivity.61(this, (ITroopMemberInfoService)localObject), 5, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity
 * JD-Core Version:    0.7.0.1
 */