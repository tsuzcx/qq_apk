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
import com.tencent.mobileqq.troop.troopcard.TroopMoreDetailView;
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
  public static final ArrayList<Integer> a;
  public static String l;
  protected int a;
  long jdField_a_of_type_Long = 0L;
  private Dialog jdField_a_of_type_AndroidAppDialog = null;
  protected BroadcastReceiver a;
  public Intent a;
  protected Drawable a;
  public Handler a;
  protected DisplayMetrics a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new TroopSettingActivity.13(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new TroopSettingActivity.MyViewAlphaOnTouchListener();
  protected View a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  IApolloExtensionObserver jdField_a_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver = new TroopSettingActivity.64(this);
  protected BaseMessageObserver a;
  protected IFaceDecoder a;
  AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new TroopSettingActivity.39(this);
  protected TroopInfo a;
  TroopAnnouncementObserver jdField_a_of_type_ComTencentMobileqqTroopAnnouncementApiTroopAnnouncementObserver = new TroopSettingActivity.32(this);
  TroopCommonlyUsedObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver = new TroopSettingActivity.53(this);
  TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new TroopSettingActivity.36(this);
  TroopModifyObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver = new TroopSettingActivity.30(this);
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopSettingActivity.28(this);
  private TroopPushObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver = new TroopSettingActivity.1(this);
  private TroopAssociationObserver jdField_a_of_type_ComTencentMobileqqTroopAssociationApiTroopAssociationObserver = new TroopSettingActivity.2(this);
  protected TroopInfoData a;
  TroopFansObserver jdField_a_of_type_ComTencentMobileqqTroopFansApiTroopFansObserver = new TroopSettingActivity.54(this);
  TroopLuckyCharacterObserver jdField_a_of_type_ComTencentMobileqqTroopLuckycharacterApiTroopLuckyCharacterObserver = new TroopSettingActivity.38(this);
  TroopRedDotObserver jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver = new TroopSettingActivity.29(this);
  TroopOnlineMemberObserver jdField_a_of_type_ComTencentMobileqqTroopOnlinememberApiTroopOnlineMemberObserver = new TroopSettingActivity.35(this);
  RoamSettingObserver jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver = new TroopSettingActivity.40(this);
  protected IRoamSettingService a;
  private TroopRobotObserver jdField_a_of_type_ComTencentMobileqqTroopRobotApiTroopRobotObserver = new TroopSettingActivity.3(this);
  TroopShowExternalObserver jdField_a_of_type_ComTencentMobileqqTroopShowexternalApiTroopShowExternalObserver = new TroopSettingActivity.34(this);
  protected ITroopCardAppInfoHelperApi.IGetAppInfoCB a;
  protected ITroopCardAppInfoHelperApi a;
  TroopAppObserver jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver = new TroopSettingActivity.33(this);
  TroopMoreDetailView jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView;
  protected GroupCatalogBean a;
  TroopGameObserver jdField_a_of_type_ComTencentMobileqqTroopTroopgameApiTroopGameObserver = new TroopSettingActivity.37(this);
  protected TroopSettingActivity.ListAdapter a;
  TroopSettingObserver jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver = new TroopSettingActivity.31(this);
  private RobotMemberFormItem jdField_a_of_type_ComTencentMobileqqTroopTroopsettingUiRobotMemberFormItem;
  public TroopUrlConfBean a;
  protected QQCustomDialog a;
  protected MyGridView a;
  private QFormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem;
  protected QQBlurView a;
  public QQProgressDialog a;
  protected QQProgressNotifier a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  protected ImmersiveTitleBar2 a;
  protected Runnable a;
  protected String a;
  protected List<Integer> a;
  protected boolean a;
  protected View[] a;
  protected int b;
  protected Handler b;
  protected View.OnClickListener b;
  protected View b;
  protected Button b;
  protected ImageView b;
  protected TextView b;
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  protected QQProgressDialog b;
  protected Runnable b;
  protected String b;
  protected ArrayList<TroopAppInfo> b;
  List<ImageView> jdField_b_of_type_JavaUtilList;
  protected volatile boolean b;
  protected int c;
  protected View c;
  protected Button c;
  public TextView c;
  protected String c;
  private ArrayList<Long> c;
  protected List<oidb_0x899.memberlist> c;
  protected boolean c;
  protected int d;
  protected View d;
  public TextView d;
  String d;
  protected List<Long> d;
  protected boolean d;
  protected int e;
  String jdField_e_of_type_JavaLangString;
  protected List<oidb_0x899.memberlist> e;
  boolean jdField_e_of_type_Boolean = false;
  protected int f;
  String jdField_f_of_type_JavaLangString;
  boolean jdField_f_of_type_Boolean = false;
  protected int g;
  String g;
  protected boolean g;
  protected int h;
  String h;
  protected boolean h;
  protected int i;
  String i;
  protected boolean i;
  protected int j;
  String j;
  protected boolean j;
  private int jdField_k_of_type_Int = 2;
  String jdField_k_of_type_JavaLangString;
  protected boolean k;
  public boolean l;
  private String m;
  protected boolean m;
  protected boolean n = false;
  private boolean o = false;
  private boolean p;
  private boolean q;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private boolean u;
  private boolean v = true;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(6);
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379365));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379366));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379367));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379368));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379369));
    jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(2131379370));
    jdField_l_of_type_JavaLangString = "https://bindgroup.gamecenter.qq.com/cgi-bin/gc_bind_group_v2_async_fcgi";
  }
  
  public TroopSettingActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = new TroopInfoData();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_AndroidViewView = null;
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 5;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean = null;
    this.jdField_a_of_type_AndroidContentIntent = null;
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_l_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new TroopSettingActivity.6(this);
    this.jdField_d_of_type_AndroidViewView = null;
    this.jdField_a_of_type_JavaLangRunnable = new TroopSettingActivity.14(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiITroopCardAppInfoHelperApi$IGetAppInfoCB = new TroopSettingActivity.20(this);
    this.jdField_b_of_type_JavaLangRunnable = new TroopSettingActivity.23(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_j_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new TroopSettingActivity.27(this);
    this.jdField_m_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new TroopSettingActivity.55(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver = new TroopSettingActivity.60(this);
  }
  
  private void A()
  {
    c(getResources().getString(2131699556));
    if (((ITroopHonorService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopHonorService.class, "")).isGrayTroopHonor(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin))
    {
      localObject1 = new FormSwitchItem(this, null);
      localObject2 = new QFormSimpleItem(this, null);
      ((QFormSimpleItem)localObject2).a(true);
      ((QFormSimpleItem)localObject2).setBgType(1);
      ((QFormSimpleItem)localObject2).setLeftText(getResources().getString(2131699487));
      int i2 = 2131699484;
      TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      int i1 = i2;
      if (localTroopInfo != null)
      {
        i1 = i2;
        if (localTroopInfo.isHomeworkTroop()) {
          i1 = 2131699485;
        }
      }
      ((QFormSimpleItem)localObject2).setRightText(getResources().getString(i1));
      ((QFormSimpleItem)localObject2).setContentDescription(getResources().getString(2131699487));
      ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColorStateList(2131167056));
      ((QFormSimpleItem)localObject2).setFocusable(true);
      ((QFormSimpleItem)localObject2).getBackground().setAlpha(255);
      this.jdField_a_of_type_ArrayOfAndroidViewView[32] = localObject2;
      ((QFormSimpleItem)localObject2).setTag(Integer.valueOf(32));
      ((QFormSimpleItem)localObject2).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
      TroopReportor.a("Grp_set_new", "grpData_admin", "grpHonour_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
      ReportController.b(null, "dc00898", "", "", "0X800A6EE", "0X800A6EE", 0, 0, "", "", "", "");
    }
    Object localObject1 = View.inflate(this, 2131561550, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[49] = localObject1;
    a(49, 3, (View)localObject1, getString(2131699499), "", true);
    ((View)localObject1).setTag(Integer.valueOf(49));
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131363707);
    if (localObject2 != null) {
      ((TextView)localObject2).setVisibility(8);
    }
    ((View)localObject1).setOnClickListener(this);
    if (this.jdField_f_of_type_Boolean)
    {
      TroopReportor.a("Grp_set_new", "grpData_admin", "Luckyword_entry_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
      ((View)localObject1).setVisibility(0);
    }
    else
    {
      ((View)localObject1).setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
  }
  
  private void A(int paramInt)
  {
    if (paramInt != 49) {
      return;
    }
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/browser");
    String str = "https://qun.qq.com/v2/luckyword/index?qunid={GROUPCODE}&_wv=67108865&_nav_txtclr=FFFFFF&_wvSb=0&source=enter".replace("{GROUPCODE}", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    localActivityURIRequest.extra().putString("url", str);
    localActivityURIRequest.setRequestCode(19);
    QRoute.startUri(localActivityURIRequest, null);
    TroopReportor.a("Grp_set_new", "grpData_admin", "Luckyword_entry_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
  }
  
  private void B()
  {
    c(getResources().getString(2131699552));
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    boolean bool = false;
    if ((localObject1 != null) && (((TroopInfo)localObject1).isHomeworkTroop()))
    {
      localObject1 = new QFormSimpleItem(this);
      a(1006, 1, (QFormSimpleItem)localObject1, HardCodeUtil.a(2131701976), "", true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      TroopReportor.a("Grp_edu", "Grp_data", "teachermsg_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
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
    a(1001, i1, (QFormSimpleItem)localObject1, getString(2131696106), HardCodeUtil.a(2131701941), true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    TroopReportor.a("Grp_set_new", "grpData_admin", "chatRecord_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
    localObject1 = new FormSwitchItem(this, null);
    ((FormSwitchItem)localObject1).setBgType(2);
    ((FormSwitchItem)localObject1).setText(getString(2131693069));
    ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColorStateList(2131167056));
    ((FormSwitchItem)localObject1).setFocusable(true);
    ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
    ((FormSwitchItem)localObject1).setContentDescription(getString(2131693069));
    this.jdField_a_of_type_ArrayOfAndroidViewView[7] = localObject1;
    Object localObject2 = ((FormSwitchItem)localObject1).a();
    if (((ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).isCommonlyUsedTroop(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)) {
      ((Switch)localObject2).setChecked(true);
    } else {
      ((Switch)localObject2).setChecked(false);
    }
    ((Switch)localObject2).setTag(Integer.valueOf(7));
    ((Switch)localObject2).setOnCheckedChangeListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    localObject1 = new FormSwitchItem(this, null);
    ((FormSwitchItem)localObject1).setBackgroundResource(2130839443);
    ((FormSwitchItem)localObject1).setBgType(2);
    ((FormSwitchItem)localObject1).setText(getString(2131693070));
    ((FormSwitchItem)localObject1).a().setTextColor(getResources().getColorStateList(2131167056));
    ((FormSwitchItem)localObject1).setFocusable(true);
    ((FormSwitchItem)localObject1).getBackground().setAlpha(255);
    ((FormSwitchItem)localObject1).setContentDescription(getString(2131693070));
    this.jdField_a_of_type_ArrayOfAndroidViewView[8] = localObject1;
    localObject2 = ((FormSwitchItem)localObject1).a();
    ((Switch)localObject2).setTag(Boolean.FALSE);
    int i1 = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getTroopMask(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if (localObject3 != null) {
      ((TroopInfo)localObject3).troopmask = i1;
    }
    if (i1 != 1) {
      bool = true;
    }
    ((Switch)localObject2).setChecked(bool);
    ((Switch)localObject2).setOnCheckedChangeListener(new TroopSettingActivity.11(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
    localObject1 = View.inflate(this, 2131561547, null);
    localObject2 = (QFormSimpleItem)((View)localObject1).findViewById(2131369172);
    a(9, 0, (QFormSimpleItem)localObject2, getString(2131719801), "", true);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this);
    localObject3 = new RelativeLayout.LayoutParams(Utils.a(17.0F, getResources()), Utils.a(17.0F, getResources()));
    ((RelativeLayout.LayoutParams)localObject3).rightMargin = Utils.a(30.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject3).addRule(11);
    ((RelativeLayout.LayoutParams)localObject3).addRule(15);
    ((QFormSimpleItem)localObject2).addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject3);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(getResources().getDrawable(2130839401));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ArrayOfAndroidViewView[9] = localObject1;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
  }
  
  private void B(int paramInt)
  {
    if (paramInt != 34) {
      return;
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).troopShareUtilityDestroy();
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).initTroopShareUtility(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead) {
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
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()) {
      return;
    }
    c(getResources().getString(2131699554));
    Object localObject2 = (FormItemRelativeLayout)View.inflate(this, 2131561550, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[5] = localObject2;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
    a((View)localObject2, null);
    ((FormItemRelativeLayout)localObject2).setTag(Integer.valueOf(5));
    ((FormItemRelativeLayout)localObject2).setBGType(1);
    ((FormItemRelativeLayout)localObject2).setOnClickListener(this);
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
      i1 = 2131701927;
    } else {
      i1 = 2131701934;
    }
    Object localObject3 = HardCodeUtil.a(i1);
    a(5, 3, (View)localObject2, getString(2131719902), (CharSequence)localObject3, true);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()) && (this.jdField_b_of_type_Boolean)) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((FormItemRelativeLayout)localObject2).setVisibility(i1);
    if (i1 == 0) {
      TroopReportor.a("Grp_set_new", "grpData_admin", "manageGrp_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
    }
    Object localObject1 = (TextView)((FormItemRelativeLayout)localObject2).findViewById(2131376541);
    ((TextView)localObject1).setText((CharSequence)localObject3);
    b((View)localObject2);
    localObject2 = (ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("RED_POINT_KEY_TROOP_ASSOCIATION_MANAGE_ENTRY");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.q = ((ITroopUtilsApi)localObject2).isEmptyRedPointSP(((StringBuilder)localObject3).toString());
    localObject2 = (ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class);
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    boolean bool;
    if (localObject3 == null) {
      bool = false;
    } else {
      bool = ((TroopInfo)localObject3).isKingBattleTroop();
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    this.p = ((ITroopUtilsApi)localObject2).isShowKingTeamRedPoint(bool, ((StringBuilder)localObject3).toString());
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isUpdateBeforeSomeVersion(this, "8.0.5"), "RED_POINT_KEY_TROOP_ADMIN", this.p, this.q, (TextView)localObject1);
    this.jdField_b_of_type_Boolean = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).checkPlugin(this.jdField_a_of_type_ComTencentCommonAppAppInterface, new TroopSettingActivity.12(this));
    if (((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).isRobotSwitchOn(this.jdField_a_of_type_ComTencentCommonAppAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingUiRobotMemberFormItem = new RobotMemberFormItem(this, getString(2131720005));
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingUiRobotMemberFormItem.a().setBackgroundResource(2130839440);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingUiRobotMemberFormItem.a();
      if (localObject1 != null)
      {
        if (((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getBeAllMemberShowRed(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
          this.o = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getRobotItemRedShowed(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()) {
          this.o = ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).getRobotItemRedShowed(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        } else {
          this.o = false;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("bShowRed red robot");
          ((StringBuilder)localObject2).append(this.o);
          QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject2).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingUiRobotMemberFormItem.a(this.o);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
        ((View)localObject1).setOnClickListener(this);
        ((View)localObject1).setTag(Integer.valueOf(1009));
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "", "0X8009F9B", 0, 0, "", "", "", "");
      }
    }
    else
    {
      QLog.i("Q.chatopttroop", 2, "RobotSwithOff");
    }
  }
  
  private void C(int paramInt)
  {
    if (paramInt != 46) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if ((localObject != null) && (!TextUtils.isEmpty(((TroopInfoData)localObject).troopUin)))
    {
      if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch())
      {
        QQToast.a(this, getString(2131699559), 0).b(getTitleBarHeight());
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, new Object[] { "onclick:StudyMode Forbidden context = ", this });
        }
        return;
      }
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startFansTroopIdolPage(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getFansTroopStarId(), 21);
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800B596", "0X800B596", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
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
    c(getResources().getString(2131699553));
    Object localObject = View.inflate(this, 2131561550, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[14] = localObject;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).setTag(Integer.valueOf(14));
    a(14, 2, (View)localObject, getString(2131691792), "", true);
    e();
    b((View)localObject);
    localObject = View.inflate(this, 2131561550, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[25] = localObject;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).setTag(Integer.valueOf(25));
    a(25, 2, (View)localObject, getString(2131699468), "", true);
    a(this.jdField_d_of_type_Boolean ^ true, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop);
    b((View)localObject);
    if ((!this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop)) {
      TroopReportor.a("Grp_set_new", "grpData_admin", "search_upgrade_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
    }
    localObject = View.inflate(this, 2131561550, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[4] = localObject;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    a((View)localObject, null);
    a(4, 2, (View)localObject, getString(2131699514), "", true);
    ((View)localObject).setTag(Integer.valueOf(4));
    ((View)localObject).setOnClickListener(this);
    QFormSimpleItem localQFormSimpleItem = new QFormSimpleItem(this);
    this.jdField_a_of_type_ArrayOfAndroidViewView[6] = localQFormSimpleItem;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localQFormSimpleItem);
    String str = getString(2131694383);
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopColorNick)) {
      localObject = getString(2131697580);
    } else {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopColorNick;
    }
    a(6, 3, localQFormSimpleItem, str, (CharSequence)localObject, true);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopColorNick))
    {
      localObject = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopColorNick, 16);
      localQFormSimpleItem.setRightText((CharSequence)localObject);
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).setColorText(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localQFormSimpleItem.a(), (Spannable)localObject);
    }
    if (localQFormSimpleItem.a() != null) {
      localQFormSimpleItem.a().setCompoundDrawablePadding(ViewUtils.b(9.0F));
    }
    P();
  }
  
  private void D(int paramInt)
  {
    if (paramInt != 50) {
      return;
    }
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if ((localTroopInfoData != null) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)) {
      a(localTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopCode, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopRemark);
    }
  }
  
  private void E()
  {
    View localView = View.inflate(this, 2131559859, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[13] = localView;
    localView.getBackground().setAlpha(255);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    localView.setVisibility(8);
  }
  
  private void E(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)
    {
      localObject = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((ITroopInfoService)localObject).findTroopInfo(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if ((localObject != null) && ((paramInt & 0x1) > 0)) {
      c(((TroopInfo)localObject).cGroupOption);
    }
  }
  
  private void F()
  {
    View localView = View.inflate(this, 2131561558, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = localView;
    localView.setTag(Integer.valueOf(0));
    localView.setBackgroundResource(2130839443);
    localView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131370746));
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131701949));
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum);
    localStringBuilder.append(HardCodeUtil.a(2131701957));
    localTextView.setText(localStringBuilder.toString());
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
      localTextView.setPadding(0, Utils.a(12.0F, localTextView.getResources()), Utils.a(3.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()), Utils.a(12.0F, this.jdField_c_of_type_AndroidWidgetTextView.getResources()));
    }
    a(localView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)localView.findViewById(2131370744));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setFadingEdgeLength(0);
    H();
    localView = View.inflate(this, 2131561565, null);
    localView.setBackgroundResource(2130851081);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    localView.getLayoutParams().height = getResources().getDimensionPixelSize(2131298125);
  }
  
  private void F(int paramInt)
  {
    if (paramInt != -1) {
      return;
    }
    Intent localIntent = BaseAIOUtils.a(new Intent(), null);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName());
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
    QFormSimpleItem localQFormSimpleItem = (QFormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[40];
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).initKeyword(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_g_of_type_Boolean, localQFormSimpleItem);
  }
  
  private void G(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startModifyHomeworkTroopNickname(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "join");
  }
  
  private void H()
  {
    int i1 = getResources().getDisplayMetrics().widthPixels;
    float f1 = getResources().getDisplayMetrics().density;
    int i2 = (int)(24.0F * f1);
    int i3 = (int)(20.0F * f1);
    i1 = (i1 - i2) / ((int)(50.0F * f1) + i3);
    i2 = (int)(10.0F * f1);
    this.jdField_b_of_type_Int = i2;
    this.jdField_c_of_type_Int = i2;
    this.jdField_d_of_type_Int = ((int)(5.0F * f1));
    this.jdField_e_of_type_Int = ((int)(f1 * 17.0F));
    this.jdField_f_of_type_Int = i1;
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setPadding(this.jdField_b_of_type_Int, this.jdField_d_of_type_Int, this.jdField_c_of_type_Int, this.jdField_e_of_type_Int);
  }
  
  private void H(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, String.format("count = %s", new Object[] { Integer.valueOf(paramInt) }));
    }
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[43];
    if (localView == null) {
      return;
    }
    if (paramInt > 0)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      if (localObject != null) {
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", ((TroopInfoData)localObject).troopUin, "0X800B4AD", "0X800B4AD", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt), "", "", "");
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getResources().getString(2131699457));
      ((StringBuilder)localObject).append(String.valueOf(paramInt));
      ((StringBuilder)localObject).append(getResources().getString(2131699458));
      localObject = ((StringBuilder)localObject).toString();
      a(43, 2, localView, getResources().getString(2131699459), " ", true);
      TextView localTextView1 = (TextView)localView.findViewById(2131363707);
      TextView localTextView2 = (TextView)localView.findViewById(2131376541);
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
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[26];
    if (localView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead)
      {
        SpannableString localSpannableString = new SpannableString("[Avatar]");
        Drawable localDrawable = a();
        if (localDrawable != null)
        {
          localDrawable.setBounds(0, 0, ScreenUtil.dip2px(32.0F), ScreenUtil.dip2px(32.0F));
          localSpannableString.setSpan(new ImageSpan(localDrawable, 0), 0, localSpannableString.length(), 17);
          a(localView, localSpannableString, null, null);
        }
      }
      else
      {
        a(localView, null, null, HardCodeUtil.a(2131701970));
      }
      localView.setOnClickListener(this);
    }
    localView = this.jdField_a_of_type_ArrayOfAndroidViewView[35];
    if (localView != null) {
      ((ImageView)localView).setImageDrawable(a());
    }
  }
  
  private void J()
  {
    byte[] arrayOfByte = ((ITroopAppService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopAppService.class, "all")).getTroopAppListData(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
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
  
  private void K()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ChatSettingForTroop quitTroop mTroopInfoData.bOwner = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner);
      QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)
    {
      localObject = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((ITroopInfoService)localObject).findTroopInfo(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner)
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupFlagExt & 0x800) == 0L) && (this.jdField_h_of_type_Int == 0)) {
        M();
      } else {
        L();
      }
    }
    else
    {
      localObject = ActionSheet.create(this);
      ((ActionSheet)localObject).setMainTitle(2131691076);
      ((ActionSheet)localObject).addButton(2131692081, 3);
      ((ActionSheet)localObject).setOnButtonClickListener(new TroopSettingActivity.16(this, (ActionSheet)localObject));
      ((ActionSheet)localObject).addCancelButton(getString(2131690728));
      ((ActionSheet)localObject).show();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
      localObject = "0";
    } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_set", "", "Grp_data", "Clk_quitgrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, (String)localObject, "", "");
  }
  
  private void L()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop showDisbandTroopAlertWindow");
    }
    ReportDialog localReportDialog = new ReportDialog(this, 2131756189);
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
    localTextView2.setOnClickListener(new TroopSettingActivity.17(this, localReportDialog));
    localTextView3.setOnClickListener(new TroopSettingActivity.18(this, localReportDialog));
    try
    {
      localReportDialog.show();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void M()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "ChatSettingForTroop troopDisband");
    }
    getString(2131691755);
    String str = getString(2131691070);
    ActionSheet localActionSheet = ActionSheet.create(this);
    localActionSheet.setMainTitle(str);
    localActionSheet.addButton(getString(2131691069), 3);
    localActionSheet.addCancelButton(getString(2131690728));
    localActionSheet.setOnButtonClickListener(new TroopSettingActivity.19(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void N()
  {
    TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if (localTroopInfo != null)
    {
      if (TextUtils.isEmpty(localTroopInfo.troopuin)) {
        return;
      }
      long l1 = 0L;
      try
      {
        long l2 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin).longValue();
        l1 = l2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      ((ITroopBatchInfohandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(TroopBatchInfoHandler.class.getName())).a(l1, true, 1);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiITroopCardAppInfoHelperApi.getAppInfoBriefList(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiITroopCardAppInfoHelperApi$IGetAppInfoCB);
    }
  }
  
  private void O()
  {
    ITroopMemberListHandler localITroopMemberListHandler = (ITroopMemberListHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberListHandlerName());
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum <= 100) {
      localITroopMemberListHandler.a(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).stringToLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin), 0L, 5, 100, 0);
    }
  }
  
  private void P()
  {
    Object localObject = View.inflate(this, 2131561565, null);
    ((View)localObject).setBackgroundResource(2130851081);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298619);
    localObject = View.inflate(this, 2131561550, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[50] = localObject;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).setTag(Integer.valueOf(50));
    localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if (localObject != null) {
      localObject = ((TroopInfo)localObject).troopRemark;
    } else {
      localObject = "";
    }
    e((String)localObject);
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_set_new", "", "groupnameRemarks", "entrance_exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", "", "");
  }
  
  private void Q()
  {
    int i1;
    if ((((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).isGroupEntranceSwitchOn()) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isFansTroop())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      View localView = View.inflate(this, 2131561565, null);
      localView.setBackgroundResource(2130851081);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      localView.getLayoutParams().height = getResources().getDimensionPixelSize(2131298619);
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        localView = View.inflate(this, 2131561550, null);
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getFansTroopStarId() == 0)
        {
          this.jdField_a_of_type_ArrayOfAndroidViewView[45] = localView;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
          localView.setTag(Integer.valueOf(45));
          e(localView);
        }
        else
        {
          this.jdField_a_of_type_ArrayOfAndroidViewView[46] = localView;
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
          localView.setTag(Integer.valueOf(46));
          localView.setVisibility(8);
          R();
        }
        b(localView);
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800B595", "0X800B595", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void R()
  {
    TroopFansInfo.IdolItem localIdolItem = ((ITroopFansService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopFansService.class, "")).getTroopIdolInfoDate(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    if (localIdolItem != null) {
      a(localIdolItem.jdField_a_of_type_JavaLangString, localIdolItem.jdField_a_of_type_Long);
    }
  }
  
  private void S()
  {
    if (!((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).isGroupEntranceSwitchOn()) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if ((localObject1 != null) && (((TroopInfo)localObject1).isFansTroop()) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getFansTroopStarId() != 0))
    {
      localObject1 = (ITroopFansHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopFansHandlerName());
      if (localObject1 != null) {
        ((ITroopFansHandler)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
      }
    }
    else
    {
      localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView;
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
  
  private void T()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
      return;
    }
    Object localObject1 = (Boolean)this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingApiIRoamSettingService.getMapRequest().get(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
    if ((localObject1 != null) && (((Boolean)localObject1).booleanValue())) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_msg", "", "data_page", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, "", "0", "");
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName();
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
    }
    localObject2 = (ActionSheet)((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).actionSheetHelperCreateDialog(this, null);
    ((ActionSheet)localObject2).setMainTitle(getString(2131719485, new Object[] { localObject1 }));
    ((ActionSheet)localObject2).addRadioButton(getString(2131697657), false);
    ((ActionSheet)localObject2).addRadioButton(getString(2131697653), false);
    ((ActionSheet)localObject2).addRadioButton(getString(2131697649), false);
    int i1 = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getTroopMask(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
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
    ((ActionSheet)localObject2).addCancelButton(2131690728);
    ((ActionSheet)localObject2).setOnButtonClickListener(new TroopSettingActivity.24(this, i1, (ActionSheet)localObject2));
    ((ActionSheet)localObject2).show();
  }
  
  private void U()
  {
    try
    {
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).troopShareUtilityDestroy();
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).newTroopShareUtility(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData);
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startTroop2DCode();
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      QLog.d("Q.chatopttroop", 1, "gotoTroopQRCodeActivity NullPointerException ", localNullPointerException);
    }
  }
  
  private void V()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog == null) || (localQQCustomDialog.isShowing())) {}
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label23:
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
  
  private void W()
  {
    V();
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131697638));
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(getString(2131697637), new TroopSettingActivity.26(this));
    try
    {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void X()
  {
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_notice", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData), "8.7.0" });
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()) && (TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)))
    {
      W();
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopurlConfigTroopUrlConfBean;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = TroopUrlConfProcessor.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopurlConfigTroopUrlConfBean = ((TroopUrlConfBean)localObject1);
    }
    localObject1 = ((TroopUrlConfBean)localObject1).jdField_a_of_type_JavaLangString;
    localObject2 = new ActivityURIRequest(this, "/base/browser");
    ((ActivityURIRequest)localObject2).extra().putString("url", ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).replaceSpecialTag((String)localObject1, 0L, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, this.jdField_a_of_type_ComTencentCommonAppAppInterface, true));
    ((ActivityURIRequest)localObject2).extra().putString("webStyle", "noBottomBar");
    ((ActivityURIRequest)localObject2).extra().putLong("startOpenPageTime", System.currentTimeMillis());
    ((ActivityURIRequest)localObject2).setRequestCode(17);
    QRoute.startUri((URIRequest)localObject2, null);
  }
  
  private void Y()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
  }
  
  private void Z()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "MSG_UPDATE_TROOP_MEMBER_CARD");
    }
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView;
    if (localObject != null)
    {
      localObject = (QFormSimpleItem)localObject[6];
      if (localObject != null)
      {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopColorNick))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "handle MSG_UPDATE_TROOP_MEMBER_CARD message and update nick");
          }
          SpannableString localSpannableString = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getSpannableStringFromColorNickText(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopColorNick, 16);
          ((QFormSimpleItem)localObject).setRightText(localSpannableString);
          ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).setColorText(((QFormSimpleItem)localObject).a(), localSpannableString, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopColorNickId);
        }
        else
        {
          ((QFormSimpleItem)localObject).setRightText(getString(2131697580));
          ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).setColorText(((QFormSimpleItem)localObject).a(), new SpannableString(""), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopColorNickId);
        }
        if (((QFormSimpleItem)localObject).a() != null) {
          ((QFormSimpleItem)localObject).a().setCompoundDrawablePadding(ViewUtils.b(9.0F));
        }
      }
    }
  }
  
  private Drawable a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject1 != null)
    {
      localObject2 = ((IFaceDecoder)localObject1).getBitmapFromCache(4, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 4, true);
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
      localObject2 = BaseImageUtil.f();
    }
    return new BitmapDrawable((Bitmap)localObject2);
  }
  
  private View a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 9: 
      return paramView.findViewById(2131379160);
    case 8: 
      return paramView.findViewById(2131379159);
    case 7: 
      return paramView.findViewById(2131379158);
    case 6: 
      return paramView.findViewById(2131379157);
    case 5: 
      return paramView.findViewById(2131379156);
    case 4: 
      return paramView.findViewById(2131379155);
    case 3: 
      return paramView.findViewById(2131379154);
    case 2: 
      return paramView.findViewById(2131379153);
    case 1: 
      return paramView.findViewById(2131379152);
    }
    return paramView.findViewById(2131379151);
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
        return getString(2131697657);
      }
      return getString(2131693075);
    }
    return getString(2131697653);
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
    paramView = paramView.getTag(2131378299);
    if ((paramView instanceof String))
    {
      paramView = (String)paramView;
      if (((ITroopRobotService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramView))
      {
        ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).openRobotProfileCard(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, paramView);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("selfSet_leftViewText", getString(2131719952));
      localBundle.putString("custom_leftbackbutton_name", getTitle().toString());
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).openTroopmemberCard(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, paramView, 1, -1, localBundle);
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    n();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
    }
    if (paramInt != -2)
    {
      if ((paramInt != 0) && (paramInt != 1))
      {
        if (paramInt != 2) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131693506, 1500);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131719932, 1500);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131693507, 1500);
        finish();
        d(true);
        ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).addRecentTroopItemIntoRecentMsgList(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString);
      }
    }
    else {
      ((ITroopMngHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName())).a(Long.parseLong(paramString), Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount()));
    }
    this.jdField_a_of_type_JavaLangString = null;
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
              af();
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
    if (this.jdField_e_of_type_JavaUtilList == null) {
      return;
    }
    Object localObject1 = paramIntent.getStringExtra("troopUin");
    paramIntent = paramIntent.getStringArrayListExtra("delMemberUins");
    if ((localObject1 != null) && (((String)localObject1).equals(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)) && (paramIntent != null))
    {
      localObject1 = new HashSet();
      Object localObject2 = paramIntent.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        Iterator localIterator = this.jdField_e_of_type_JavaUtilList.iterator();
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
        this.jdField_e_of_type_JavaUtilList.remove(localObject2);
      }
      localObject1 = new ArrayList();
      localObject2 = this.jdField_e_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(String.valueOf(((oidb_0x899.memberlist)((Iterator)localObject2).next()).uint64_member_uin.get()));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onReceive wMemberNumClient:");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNumClient);
          ((StringBuilder)localObject2).append("  wMemberNum:");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.wMemberNum);
          ((StringBuilder)localObject2).append(" delMembers.size():");
          ((StringBuilder)localObject2).append(paramIntent.size());
          ((StringBuilder)localObject2).append(" troopUin:");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
          QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
        ((TroopInfo)localObject2).wMemberNumClient -= paramIntent.size();
      }
      paramIntent = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).saveMemberUinStringToDB(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, (ArrayList)localObject1);
      if (!TextUtils.isEmpty(paramIntent)) {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.memberListToShow = paramIntent;
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onReceive ACTION_DEL_MEMBER,memberListForCard.size = ");
        paramIntent.append(this.jdField_e_of_type_JavaUtilList.size());
        QLog.d("Q.chatopttroop", 2, paramIntent.toString());
      }
      a(this.jdField_e_of_type_JavaUtilList);
    }
  }
  
  private void a(Message paramMessage)
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[4];
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
    paramView = paramView.findViewById(2131379165);
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
    TextView localTextView = (TextView)paramView.findViewById(2131363707);
    paramView = (TextView)paramView.findViewById(2131376541);
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
    TextView localTextView = (TextView)paramView.findViewById(2131363707);
    paramView = (TextView)paramView.findViewById(2131376541);
    if (TextUtils.isEmpty(paramString))
    {
      localTextView.setVisibility(8);
      paramView.setVisibility(0);
      paramView.setText(getString(2131697639));
      return;
    }
    paramView.setVisibility(8);
    localTextView.setVisibility(0);
    localTextView.setText(paramString);
  }
  
  private void a(View paramView, oidb_0xe83.AppInfo paramAppInfo)
  {
    boolean bool2 = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    ImageView localImageView = (ImageView)paramView.findViewById(2131362839);
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
    TextView localTextView = (TextView)paramView.findViewById(2131362859);
    int i1 = paramAppInfo.push_red_point.get();
    if (i1 == -1)
    {
      localTextView.setVisibility(0);
      localTextView.setText("");
      localTextView.setBackgroundResource(0);
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2130850766, 0, 0, 0);
      paramString.append("，新");
    }
    else if (i1 > 0)
    {
      localTextView.setVisibility(0);
      localTextView.setText(String.valueOf(i1));
      localTextView.setBackgroundResource(2130850770);
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
      if (((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).getGroupTIMFileNewsInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, false))
      {
        localTextView.setVisibility(0);
        localTextView.setText("");
        localTextView.setBackgroundResource(0);
        localTextView.setCompoundDrawablesWithIntrinsicBounds(2130850766, 0, 0, 0);
        return;
      }
      localTextView.setVisibility(8);
    }
  }
  
  private void a(String paramString, long paramLong)
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView;
    Object localObject2 = localObject1[45];
    localObject1 = localObject1[46];
    if ((localObject2 == null) && (localObject1 == null)) {
      return;
    }
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    localObject2 = (TextView)((View)localObject1).findViewById(2131363707);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131376541);
    ((View)localObject1).setVisibility(0);
    ((TextView)localObject2).setVisibility(8);
    localTextView.setVisibility(0);
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(false, localTextView);
    if (TextUtils.isEmpty(paramString))
    {
      e((View)localObject1);
      return;
    }
    String str = getString(2131699561);
    localObject2 = str;
    if (paramLong > 0L)
    {
      localObject2 = str;
      if (paramLong <= 50L) {
        localObject2 = String.format(getString(2131699536), new Object[] { Long.valueOf(paramLong) });
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if (localObject == null) {
      return;
    }
    ((TroopInfoData)localObject).coverFrom(paramGroupInfo);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName)) {
      e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead) {
      I();
    }
    if (QLog.isColorLevel())
    {
      int i1 = paramGroupInfo.uint32_group_flagext3.get();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ChatSettingForToop_handle88dResp, troopUin=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      ((StringBuilder)localObject).append(", flagExt3=");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(", isQidianPrivateTroop=");
      ((StringBuilder)localObject).append(TroopInfo.isQidianPrivateTroop(i1));
      QLog.d(".troop.qidian_private_troop", 2, ((StringBuilder)localObject).toString());
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
    b(paramGroupInfo);
    a(this.jdField_d_of_type_Boolean ^ true, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop);
    j();
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).requestForPubAccountInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.publicAccountUin, 16, this.jdField_a_of_type_AndroidOsHandler);
    i();
    ai();
    d();
    an();
    o();
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null) {
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateTroopInfoToDB(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember);
    }
    f();
    paramGroupInfo = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView;
    if (paramGroupInfo != null)
    {
      paramGroupInfo.setTroopInfoData(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView.a();
    }
    k(false);
  }
  
  private void a(oidb_0xe83.AppInfo paramAppInfo, long paramLong)
  {
    if (paramLong == 0L) {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).reportByQQqunInfo("qun", "qun_info", "expo_more", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    }
    if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramAppInfo.url.get())) {
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).reportQunMiniApp(paramAppInfo, "expo", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    }
    if (paramLong == 101914115.0D) {
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).reportClockTroopAppShowOrClick(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, true);
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
      if (!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, paramString)) {
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
          QLog.d("wyx", 2, new Object[] { "mHomeworkTroopIdentityChangedReceiver source=join. cGroupOption=", Short.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption), ", joinType=", Integer.valueOf(this.jdField_k_of_type_Int) });
        }
        if (this.jdField_k_of_type_Int == 1) {
          al();
        } else if (this.jdField_k_of_type_Int == 2) {
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
    Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView;
    if (localObject1 != null) {
      localView = localObject1[25];
    }
    if (localView != null)
    {
      if (paramBoolean1)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
        if ((localObject1 != null) && (((TroopInfoData)localObject1).troopUin != null))
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
          break label124;
        }
      }
      localObject1 = "";
      label124:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = " ";
      }
      localView.setVisibility(0);
      if (paramBoolean1) {
        i1 = 2131699467;
      } else if (!paramBoolean1) {
        i1 = 2131699468;
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
      Object localObject3 = getResources().getDrawable(2130843991);
      ((Drawable)localObject3).setBounds(0, 0, ScreenUtil.dip2px(18.0F), ScreenUtil.dip2px(18.0F));
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
        ((Drawable)localObject3).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      }
      localObject3 = new TroopSettingActivity.43(this, (Drawable)localObject3, 0);
      Object localObject4;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("show the pretty troop icon :");
        ((StringBuilder)localObject4).append(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.groupFlagExt4);
        QLog.e("vip_pretty.Q.chatopttroop", 1, ((StringBuilder)localObject4).toString());
        if (((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.checkFlagExt4(1)) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.checkFreezeReason(2))) || (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.checkFlagExt4(2)))
        {
          i1 = 1;
          break label413;
        }
      }
      else
      {
        QLog.e("vip_pretty.Q.chatopttroop", 1, "not show the pretty troop icon");
      }
      int i1 = 0;
      label413:
      if (i1 != 0)
      {
        localObject4 = getResources().getDrawable(2130847165);
        ((Drawable)localObject4).setBounds(0, 0, ScreenUtil.dip2px(40.0F), ScreenUtil.dip2px(15.0F));
        ((SpannableString)localObject2).setSpan(new TroopSettingActivity.44(this, (Drawable)localObject4, 0), ((String)localObject1).length(), ((String)localObject1).length() + 2, 17);
        ((SpannableString)localObject2).setSpan(localObject3, ((String)localObject1).length() + 2, ((String)localObject1).length() + 6, 17);
      }
      else
      {
        ((SpannableString)localObject2).setSpan(localObject3, ((String)localObject1).length(), ((SpannableString)localObject2).length(), 17);
      }
      if ((!" ".equals(localObject1)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop)) {
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
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).updateEntryItem(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localView, (CharSequence)localObject2, null, null, paramBoolean1, (String)localObject1, HardCodeUtil.a(2131691297));
      localView.setOnClickListener(this);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, View paramView)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      paramView = (TextView)paramView.findViewById(2131376541);
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
      localObject = new RoundedBackgroundSpan(-1315339, -7894119, ViewUtils.a(3.0F), ViewUtils.a(21.0F), ViewUtils.a(6.0F));
      ((RoundedBackgroundSpan)localObject).a(getResources().getDrawable(2130843998), ViewUtils.a(16.0F), ViewUtils.a(16.0F), ViewUtils.a(4.0F));
      paramSpannableString.setSpan(localObject, 0, paramString.length(), 33);
    }
  }
  
  private boolean a(long paramLong, TroopInfo paramTroopInfo)
  {
    return ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).appOnClick_Special(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramLong, paramTroopInfo, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData);
  }
  
  private void aa()
  {
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_e_of_type_JavaUtilList;
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
    Object localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131701967));
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum);
      localStringBuilder.append(HardCodeUtil.a(2131701973));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    b(true);
    e();
    a(this.jdField_e_of_type_JavaUtilList);
    an();
    a(true ^ this.jdField_d_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop);
    localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if (localObject != null) {
      e(((TroopInfo)localObject).troopRemark);
    }
  }
  
  private void ab()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags;
    Intent localIntent = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getTroopTagViewIntent(this);
    localIntent.putExtra("troopuin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    int i1 = 0;
    localIntent.putExtra("isAdmin", false);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopClassExtText)) {}
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopClassExtText;; localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean.jdField_a_of_type_JavaLangString)
    {
      i1 = 1;
      break label132;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean;
      if ((localObject1 == null) || (TextUtils.isEmpty(((GroupCatalogBean)localObject1).jdField_a_of_type_JavaLangString)) || (HardCodeUtil.a(2131701960).equals(this.jdField_a_of_type_ComTencentMobileqqTroopTroopcatalogGroupCatalogBean.jdField_a_of_type_JavaLangString))) {
        break;
      }
    }
    localObject1 = "";
    label132:
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
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim())
    {
      startActivityForResult(localIntent, 11);
      return;
    }
    startActivity(localIntent);
  }
  
  private void ac()
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView;
    Object localObject3 = localObject1[8];
    Object localObject4 = localObject1[9];
    if ((localObject4 != null) && (localObject3 != null) && ((localObject3 instanceof FormSwitchItem)))
    {
      QFormSimpleItem localQFormSimpleItem = (QFormSimpleItem)localObject4.findViewById(2131369172);
      Switch localSwitch = ((FormSwitchItem)localObject3).a();
      ((TextView)localObject4.findViewById(2131368828)).setVisibility(8);
      localObject1 = "";
      Object localObject2 = Boolean.valueOf(false);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingApiIRoamSettingService.getMapRequest().containsKey(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)) {
        localObject2 = (Boolean)this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingApiIRoamSettingService.getMapRequest().get(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      }
      if ((localObject2 != null) && (((Boolean)localObject2).booleanValue()))
      {
        localObject4.setVisibility(0);
        localObject3.setBackgroundResource(2130839443);
        localObject3.getBackground().setAlpha(255);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
        if (localObject2 == null) {
          return;
        }
        int i1 = ((TroopInfo)localObject2).troopmask;
        if (i1 == 1)
        {
          localObject3.setBackgroundResource(2130839440);
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
          localObject3.setBackgroundResource(2130839443);
          localObject3.getBackground().setAlpha(255);
          if (!localSwitch.isChecked())
          {
            localSwitch.setTag(Boolean.TRUE);
            localSwitch.setChecked(true);
          }
          localObject4.setVisibility(0);
          localObject1 = a("", i1);
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localObject2 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem != null)
        {
          ax();
          localObject2 = localObject1;
        }
      }
      localQFormSimpleItem.setRightText(new QQText((CharSequence)localObject2, 3));
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).clearTroopAssistTipTime(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
  }
  
  private void ad()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[27];
    if (localObject != null)
    {
      TextView localTextView = (TextView)((View)localObject).findViewById(2131378784);
      if (localTextView != null)
      {
        localTextView.setTextColor(Color.parseColor("#00b6f9"));
        if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
          localTextView.setAlpha(0.5F);
        }
      }
      localObject = (ProgressBar)((View)localObject).findViewById(2131373076);
      if (localObject != null) {
        ((ProgressBar)localObject).setVisibility(8);
      }
    }
    QQToast.a(this, 2, getString(2131690865), 0).a();
  }
  
  private void ae()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[14];
    if (localView != null)
    {
      localView.setOnTouchListener(null);
      localView.setOnClickListener(null);
    }
  }
  
  private void af()
  {
    QQToast.a(this, 2131694491, 1).b(getTitleBarHeight());
    ThreadManagerV2.excute(new TroopSettingActivity.41(this), 32, null, false);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember = false;
    getIntent().putExtra("troop_info_is_member", false);
    finish();
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).openTroopInfoActivity(this, getIntent().getExtras(), 2);
  }
  
  private void ag()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "showNotSearchableActionSheet");
    }
    ActionSheet localActionSheet = (ActionSheet)((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).actionSheetHelperCreateDialog(this, null);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim();
    int i1;
    if (bool) {
      i1 = 2131693059;
    } else {
      i1 = 2131693058;
    }
    localActionSheet.setMainTitle(getString(i1));
    if (bool) {
      i1 = 2131693056;
    } else {
      i1 = 2131693057;
    }
    localActionSheet.addButton(i1);
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.setOnButtonClickListener(new TroopSettingActivity.47(this, localActionSheet));
    localActionSheet.setOnBottomCancelListener(new TroopSettingActivity.48(this, localActionSheet));
    if (!localActionSheet.isShowing()) {
      localActionSheet.show();
    }
  }
  
  private void ah()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("gotoSettingOrShare ,isOwnerOrAdmin = ");
      localStringBuilder.append(bool);
      QLog.d("Q.chatopttroop", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).openTroopProfole(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, this.jdField_h_of_type_Int);
      return;
    }
    U();
  }
  
  private void ai()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[33];
    Object localObject1;
    if ((localView != null) && ((localView instanceof ExpandableTextView)))
    {
      localObject2 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getDateString(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopCreateTime);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append("\r\n");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((ExpandableTextView)localView).setText(new QQText((CharSequence)localObject1, 11, 16));
    }
    Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[37];
    if ((localObject2 != null) && ((localObject2 instanceof TextView)))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo)) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo;
      } else {
        localObject1 = getString(2131696146);
      }
      ((TextView)localObject2).setText(new QQText((CharSequence)localObject1, 11, 16));
    }
  }
  
  private void aj()
  {
    ITroopEnterEffectService localITroopEnterEffectService = (ITroopEnterEffectService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopEnterEffectService.class, "all");
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
  
  private void ak()
  {
    ITroopLuckyCharacterHandler localITroopLuckyCharacterHandler = (ITroopLuckyCharacterHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopLuckyCharacterHandlerName());
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if ((localTroopInfoData != null) && (!TextUtils.isEmpty(localTroopInfoData.troopUin))) {
      localITroopLuckyCharacterHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    }
  }
  
  private void al()
  {
    m();
    ((ITroopMngHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(TroopMngHandler.class.getName())).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, null, null);
  }
  
  private void am()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, String.format("updateTitle mStatusBarShow=%b", new Object[] { Boolean.valueOf(this.v) }));
    }
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (!this.v) {
      this.v = true;
    }
    if ((!this.v) && (!bool)) {
      i1 = 2131166742;
    } else {
      i1 = 2131167053;
    }
    int i3 = getResources().getColor(i1);
    int i2 = 2130846953;
    int i1 = i2;
    if (this.v)
    {
      i1 = i2;
      if (!bool) {
        i1 = 2130846950;
      }
    }
    Drawable localDrawable = getResources().getDrawable(2130851066);
    localDrawable.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i3);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i3);
    this.jdField_b_of_type_AndroidWidgetTextView.setBackgroundDrawable(localDrawable);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i1);
    this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(i3);
    e(this.v);
  }
  
  private void an()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_ArrayOfAndroidViewView[12].findViewById(2131373728);
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if ((localTroopInfoData != null) && (localTroopInfoData.checkFlagExt4(3)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.checkFreezeReason(2)))
    {
      localImageView.setVisibility(0);
      return;
    }
    localImageView.setVisibility(8);
  }
  
  private void ao()
  {
    Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView;
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
            localObject1 = localObject2.findViewById(2131379158);
            break;
          case 6: 
            localObject1 = localObject2.findViewById(2131379157);
            break;
          case 5: 
            localObject1 = localObject2.findViewById(2131379156);
            break;
          case 4: 
            localObject1 = localObject2.findViewById(2131379155);
            break;
          case 3: 
            localObject1 = localObject2.findViewById(2131379154);
            break;
          case 2: 
            localObject1 = localObject2.findViewById(2131379153);
            break;
          case 1: 
            localObject1 = localObject2.findViewById(2131379152);
            break;
          case 0: 
            localObject1 = localObject2.findViewById(2131379151);
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
                boolean bool = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).getGroupTIMFileNewsInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, false);
                if ((i2 != -1) && (!bool)) {
                  i1 = 0;
                } else {
                  i1 = 1;
                }
                localObject1 = (TextView)((View)localObject1).findViewById(2131362859);
                if (i1 != 0)
                {
                  ((TextView)localObject1).setVisibility(0);
                  ((TextView)localObject1).setText("");
                  ((TextView)localObject1).setBackgroundResource(0);
                  ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(2130850766, 0, 0, 0);
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
  
  private void ap()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent == null) && (getIntent().getBooleanExtra("from_newer_guide", false)))
    {
      this.jdField_a_of_type_AndroidContentIntent = new Intent();
      this.jdField_a_of_type_AndroidContentIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    }
    Intent localIntent2 = this.jdField_a_of_type_AndroidContentIntent;
    Intent localIntent1 = localIntent2;
    if (this.u)
    {
      localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = new Intent();
      }
      localIntent1.putExtra("KEY_SHOULD_SHOW_KEYBOARD", true);
      this.u = false;
    }
    setResult(-1, localIntent1);
  }
  
  private void aq()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[47];
    if (localFormSwitchItem == null) {
      return;
    }
    TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if (localTroopInfo == null) {
      return;
    }
    boolean bool = localTroopInfo.isTroopGameCardEnabled();
    localFormSwitchItem.setChecked(bool);
    localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[48];
    if (localFormSwitchItem != null)
    {
      if (bool)
      {
        localFormSwitchItem.setVisibility(0);
        ar();
        return;
      }
      localFormSwitchItem.setVisibility(8);
    }
  }
  
  private void ar()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[48];
    if (localFormSwitchItem == null) {
      return;
    }
    TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if (localTroopInfo == null) {
      return;
    }
    localFormSwitchItem.setChecked(localTroopInfo.isShowMyGameCardEnabled());
  }
  
  private void as()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0);
    if (!localSharedPreferences.getBoolean("Change_Game_Card_Switch_Tips_Value", false))
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this, 230, getString(2131697424), getString(2131697423), 2131690728, 2131697422, new TroopSettingActivity.57(this), null);
        this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new TroopSettingActivity.58(this));
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      localSharedPreferences.edit().putBoolean("Change_Game_Card_Switch_Tips_Value", true).apply();
    }
  }
  
  private void at()
  {
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return;
    }
    int i1 = -1;
    if (this.jdField_c_of_type_JavaLangString.equals("wangzhe"))
    {
      i1 = 48;
      TroopReportor.a("Grp_AIO", "AIO_clk", "game_on_clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
    }
    if (i1 >= 0)
    {
      if (i1 >= 51) {
        return;
      }
      View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[i1];
      if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (localView != null) && (localView.getVisibility() == 0))
      {
        i1 = localView.getTop();
        int i2 = localView.getHeight();
        this.jdField_a_of_type_ComTencentWidgetXListView.smoothScrollBy(i1 - i2, 1000);
      }
    }
  }
  
  private void au()
  {
    boolean bool = ((ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).isCommonlyUsedTroop(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    Object localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[7];
    if (localObject != null)
    {
      localObject = ((FormSwitchItem)localObject).a();
      ((Switch)localObject).setOnCheckedChangeListener(null);
      ((Switch)localObject).setChecked(bool);
      ((Switch)localObject).setOnCheckedChangeListener(this);
    }
  }
  
  private void av()
  {
    Object localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[31];
    TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if ((localTroopInfo != null) && (localObject != null))
    {
      if (localTroopInfo.showGameSwitchStatus == 1)
      {
        boolean bool = false;
        ((FormSwitchItem)localObject).setVisibility(0);
        localObject = ((FormSwitchItem)localObject).a();
        ((Switch)localObject).setOnCheckedChangeListener(null);
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.gameSwitchStatus == 1) {
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
  
  private void aw()
  {
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localITroopInfoService.findTroopInfo(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    }
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject1);
    long l1 = 0L;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if (localObject1 != null) {
      l1 = ((TroopInfo)localObject1).cmdUinFlagEx2;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mTroopInfo.mask=");
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null)
      {
        localObject1 = "no troopInfo";
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.cmdUinFlagEx2);
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject2).toString());
    }
    boolean bool = TroopInfo.isCmdUinFlagEx2Open(l1, 512);
    localObject1 = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[10];
    if (localObject1 != null)
    {
      localObject1 = ((FormSwitchItem)localObject1).a();
      ((Switch)localObject1).setOnCheckedChangeListener(null);
      ((Switch)localObject1).setChecked(bool);
      ax();
      ((Switch)localObject1).setOnCheckedChangeListener(this);
    }
  }
  
  private void ax()
  {
    boolean bool1 = ((FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[10]).a();
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView;
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
      TroopReportor.a("Grp_set_new", "grpData_admin", "Grp_msg_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem != null) && ((localObject instanceof FormSwitchItem)))
    {
      boolean bool2 = ((FormSwitchItem)localObject).a();
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem;
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
  
  private void ay()
  {
    boolean bool = ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).isShowExternalTroop(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[19];
    if (localFormSwitchItem != null)
    {
      Switch localSwitch = localFormSwitchItem.a();
      localSwitch.setOnCheckedChangeListener(null);
      localSwitch.setChecked(bool);
      localSwitch.setOnCheckedChangeListener(this);
      localFormSwitchItem.setContentDescription(getString(2131696213));
    }
  }
  
  private void az()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim();
    e();
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[5];
    int i2 = 0;
    int i1;
    if ((bool) && (this.jdField_b_of_type_Boolean)) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    if (localObject != null) {
      ((View)localObject).setVisibility(i1);
    }
    localObject = (QFormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[6];
    if (localObject != null)
    {
      if (i1 == 0) {
        i2 = 3;
      }
      ((QFormSimpleItem)localObject).setBgType(i2);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0)
    {
      Object localObject = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = ((ITroopInfoService)localObject).findTroopInfo(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      }
      if ((localObject != null) && (((TroopInfo)localObject).wMemberNum != this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateTroopAdmMemberNum(((TroopInfo)localObject).Administrator, ((TroopInfo)localObject).wMemberNum, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), getResources());
        localObject = this.jdField_c_of_type_AndroidWidgetTextView;
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131701966));
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum);
          localStringBuilder.append(HardCodeUtil.a(2131701968));
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
    if (this.p)
    {
      localObject1 = (ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("RED_POINT_KEY_TROOP_ADMIN_FOR_SOMEGAME_");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      ((ITroopUtilsApi)localObject1).setRedPointSP(((StringBuilder)localObject2).toString());
    }
    if (this.q)
    {
      localObject1 = (ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("RED_POINT_KEY_TROOP_ASSOCIATION_MANAGE_ENTRY");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      ((ITroopUtilsApi)localObject1).setRedPointSP(((StringBuilder)localObject2).toString());
    }
    paramView = (TextView)paramView.findViewById(2131376541);
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(false, paramView);
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    ((Intent)localObject2).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    ((Intent)localObject2).putExtra("forward_location", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation);
    ((Intent)localObject2).putExtra("forward_latitude", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLat);
    ((Intent)localObject2).putExtra("forward_longitude", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLon);
    ((Intent)localObject2).putExtra("forward_cityid", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cityId);
    ((Intent)localObject2).putExtra("troop_auth_submit_time", this.jdField_h_of_type_Int);
    ((Intent)localObject2).putExtra("leftViewText", getResources().getString(2131690818));
    ((Intent)localObject2).putExtra("key_qidian_private_troop", this.jdField_d_of_type_Boolean);
    ((Intent)localObject2).putExtra("key_is_update_before_805", ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isUpdateBeforeSomeVersion(this, "8.0.5"));
    paramView = (ITroopHonorService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopHonorService.class, "");
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    boolean bool;
    if (localObject1 != null)
    {
      ((Intent)localObject2).putExtra("key_support_troop_honor", paramView.isGrayTroopHonor(((TroopInfo)localObject1).troopuin));
      bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isKingBattleTroop();
    }
    else
    {
      bool = false;
    }
    ((Intent)localObject2).putExtra("key_customed_troop", bool);
    if (bool) {
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).reportDC00087(null, "846", "205605", "", "84601", "1", "145");
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopurlConfigTroopUrlConfBean;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      paramView = TroopUrlConfProcessor.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopurlConfigTroopUrlConfBean = paramView;
    }
    ((Intent)localObject2).putExtra("autoApprovalUrl", paramView.jdField_b_of_type_JavaLangString);
    ((Intent)localObject2).putExtra("frequencyLimitVisible", paramView.jdField_a_of_type_Boolean);
    ((Intent)localObject2).putExtra("key_is_need_update_Group_info", true);
    if (QLog.isDevelopLevel())
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      if (paramView != null) {
        QLog.i("TroopMngTest", 4, String.format("start troop mng [flag: %s, msgLimitFreq: %s]", new Object[] { Long.valueOf(paramView.dwGroupFlagExt3 & 0x100000), Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.nMsgLimitFreq) }));
      }
    }
    ((Intent)localObject2).putExtra("troop_manager_edit_red_show", c());
    ((Intent)localObject2).putExtra("troop_manager_edit_current_uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin());
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).OpenTroopManagePluginActivity(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, (Intent)localObject2, 8);
    localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
      paramView = "0";
    } else {
      paramView = "1";
    }
    ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_manage", "", "manage_grp", "Clk_managegrp", 0, 0, (String)localObject2, paramView, "", "");
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_manageGrp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData) });
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
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView != null) {
              this.jdField_a_of_type_ComTencentMobileqqTroopTroopcardTroopMoreDetailView.a(paramOIDBSSOPkg.rpt_memberlist.get());
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
    if (this.jdField_a_of_type_ArrayOfAndroidViewView[6] != null) {
      ThreadManager.post(new TroopSettingActivity.52(this), 8, null, true);
    }
    f();
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
    OpenID localOpenID = (OpenID)((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getStrOpenIDFromCacheAndDB(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString);
    if (localOpenID == null)
    {
      m();
      this.jdField_b_of_type_AndroidOsHandler = new Handler();
      this.jdField_b_of_type_AndroidOsHandler.postDelayed(new TroopSettingActivity.5(this), 3000L);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver);
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getOpenID(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString);
      return;
    }
    if (!this.jdField_e_of_type_JavaLangString.equals(localOpenID.openID))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.chatopttroop", 2, "-->preForward--openid doesn't equal current local openid");
      }
      q();
    }
  }
  
  private void b(List<oidb_0x899.memberlist> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ITroopRobotService localITroopRobotService = (ITroopRobotService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopRobotService.class, "all");
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      localObject = (oidb_0x899.memberlist)localIterator.next();
      String str = String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin)) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin))) {
        paramList = (List<oidb_0x899.memberlist>)localObject;
      } else if (localITroopRobotService.isRobotUin(str)) {
        localArrayList1.add(localObject);
      } else if (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, str)) {
        localArrayList2.add(localObject);
      } else {
        localArrayList3.add(localObject);
      }
    }
    this.jdField_e_of_type_JavaUtilList = new ArrayList();
    Object localObject = paramList;
    if (paramList == null) {}
    try
    {
      localObject = new oidb_0x899.memberlist();
      ((oidb_0x899.memberlist)localObject).uint64_member_uin.set(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopowneruin));
      this.jdField_e_of_type_JavaUtilList.add(0, localObject);
    }
    catch (NumberFormatException paramList)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.chatopttroop", 2, paramList.toString());
      }
    }
    this.jdField_e_of_type_JavaUtilList.addAll(localArrayList2);
    this.jdField_e_of_type_JavaUtilList.addAll(localArrayList3);
    this.jdField_e_of_type_JavaUtilList.addAll(localArrayList1);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("handle0X899_0,memberListForCard.size = ");
      paramList.append(this.jdField_e_of_type_JavaUtilList.size());
      QLog.d("Q.chatopttroop", 2, paramList.toString());
    }
    paramList = new ArrayList();
    localObject = this.jdField_e_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.add(String.valueOf(((oidb_0x899.memberlist)((Iterator)localObject).next()).uint64_member_uin.get()));
    }
    localObject = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).saveMemberUinStringToDB(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, paramList);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.memberListToShow = ((String)localObject);
    }
    a(this.jdField_e_of_type_JavaUtilList);
    ((ITroopMemberInfoHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(TroopMemberInfoHandler.class.getName())).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, paramList, true, null);
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
    this.jdField_d_of_type_Boolean = TroopInfo.isQidianPrivateTroop(paramGroupInfo.uint32_group_flagext3.get());
    if (this.jdField_d_of_type_Boolean)
    {
      int i1;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
        i1 = 1;
      } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
        i1 = 2;
      } else {
        i1 = 3;
      }
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).newReportTask(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, i1);
    }
  }
  
  private boolean b()
  {
    byte[] arrayOfByte = ((ITroopAppService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopAppService.class, "all")).getTroopAppListData(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
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
            localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
            localTroopInfoData.cGroupOption = 5;
            localTroopInfoData.troopAuthen = getString(2131719919);
            return;
          }
          localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
          localTroopInfoData.cGroupOption = 4;
          localTroopInfoData.troopAuthen = getString(2131719920);
          return;
        }
        localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
        localTroopInfoData.cGroupOption = 3;
        localTroopInfoData.troopAuthen = getString(2131719925);
        return;
      }
      localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      localTroopInfoData.cGroupOption = 2;
      localTroopInfoData.troopAuthen = getString(2131719923);
      return;
    }
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    localTroopInfoData.cGroupOption = 1;
    localTroopInfoData.troopAuthen = getString(2131719918);
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
    this.t = true;
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if ((localTroopInfoData != null) && (!TextUtils.isEmpty(localTroopInfoData.troopUin))) {
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).openTroopAssociationWebPage(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    }
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).setRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION");
    paramView = (TextView)paramView.findViewById(2131376541);
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(false, paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if (paramView != null) {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", paramView.troopUin, "0X800B4AE", "0X800B4AE", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt), "", "", "");
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
          break label219;
        }
        paramBatchResponse = localRspBody.rpt_msg_level_name.get();
        if (localRspBody.rpt_msg_level_name_new.isEmpty()) {
          break label224;
        }
        paramOIDBSSOPkg = localRspBody.rpt_msg_level_name_new.get();
        ITroopInfoService localITroopInfoService = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
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
      label219:
      paramBatchResponse = null;
      continue;
      label224:
      paramOIDBSSOPkg = null;
    }
  }
  
  private void c(Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra("disabled", true);
    QFormSimpleItem localQFormSimpleItem = (QFormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[41];
    if (localQFormSimpleItem != null)
    {
      if (bool) {
        paramIntent = getResources().getString(2131696203);
      } else {
        paramIntent = getResources().getString(2131696204);
      }
      localQFormSimpleItem.setRightText(paramIntent);
    }
  }
  
  private void c(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363900);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131363819));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131377399));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)paramView.findViewById(2131363722));
    this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(new TroopSettingActivity.8(this));
  }
  
  private void c(String paramString)
  {
    TextView localTextView = new TextView(this);
    localTextView.setFocusable(true);
    localTextView.setText(paramString);
    localTextView.setPadding(ViewUtils.a(16.0F), 0, ViewUtils.a(16.0F), 0);
    localTextView.setTextAppearance(this, 2131756350);
    paramString = new LinearLayout.LayoutParams(-2, -2);
    paramString.topMargin = ViewUtils.b(14.0F);
    paramString.bottomMargin = ViewUtils.b(4.0F);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTextView, paramString);
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if (localObject != null)
    {
      if (TextUtils.isEmpty(((TroopInfo)localObject).troopuin)) {
        return;
      }
      boolean bool = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).isGrayTroopForTroopGameCard(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
      int i1;
      if ((!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isHomeworkTroop()) && (bool) && (!((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        bool = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isTroopGameCardEnabled();
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isOwnerOrAdmin(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()))
        {
          localObject = new FormSwitchItem(this, null);
          ((FormSwitchItem)localObject).setBackgroundResource(2130839443);
          ((FormSwitchItem)localObject).setBgType(2);
          ((FormSwitchItem)localObject).setText(getString(2131697419));
          ((FormSwitchItem)localObject).a().setTextColor(getResources().getColorStateList(2131167056));
          ((FormSwitchItem)localObject).setFocusable(true);
          ((FormSwitchItem)localObject).getBackground().setAlpha(255);
          ((FormSwitchItem)localObject).setContentDescription(getString(2131697419));
          this.jdField_a_of_type_ArrayOfAndroidViewView[47] = localObject;
          localSwitch = ((FormSwitchItem)localObject).a();
          localSwitch.setTag(Integer.valueOf(47));
          if (bool) {
            localSwitch.setChecked(true);
          } else {
            localSwitch.setChecked(false);
          }
          localSwitch.setOnCheckedChangeListener(this);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
          TroopReportor.a("Grp_set_new", "grpData_admin", "game_switch", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
        }
        localObject = new FormSwitchItem(this, null);
        ((FormSwitchItem)localObject).setBackgroundResource(2130839443);
        ((FormSwitchItem)localObject).setText(getString(2131697420));
        ((FormSwitchItem)localObject).a().setTextColor(getResources().getColorStateList(2131167056));
        ((FormSwitchItem)localObject).setFocusable(true);
        ((FormSwitchItem)localObject).getBackground().setAlpha(255);
        ((FormSwitchItem)localObject).setContentDescription(getString(2131697420));
        this.jdField_a_of_type_ArrayOfAndroidViewView[48] = localObject;
        Switch localSwitch = ((FormSwitchItem)localObject).a();
        localSwitch.setTag(Integer.valueOf(48));
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.shouldShowMyGameCard()) {
          localSwitch.setChecked(true);
        } else {
          localSwitch.setChecked(false);
        }
        localSwitch.setOnCheckedChangeListener(this);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
        if (!bool) {
          ((FormSwitchItem)localObject).setVisibility(8);
        } else {
          TroopReportor.a("Grp_manage_new", "game", "game_switch", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
        }
      }
      if (paramBoolean)
      {
        localObject = View.inflate(this, 2131561565, null);
        ((View)localObject).setBackgroundResource(2130851081);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
        ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298125);
      }
    }
  }
  
  private boolean c()
  {
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = bool2;
    if (localTroopInfoData != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        bool1 = bool2;
        if (localTroopInfoData.bOwner)
        {
          boolean bool4 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead;
          boolean bool5 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mTroopPicListJson);
          boolean bool6 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation);
          if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt <= 0L) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          bool2 = bool3;
          if (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopTagNeedRedDot(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt)) {
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags != null)
            {
              bool2 = bool3;
              if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopTags.isEmpty()) {}
            }
            else
            {
              bool2 = true;
            }
          }
          bool3 = TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo);
          bool1 = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopEditInfoRedExist(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, new boolean[] { bool4 ^ true, bool5, bool6, bool1, bool2, bool3 }, new int[] { 11, 12, 5, 4, 8, 6 });
        }
      }
    }
    return bool1;
  }
  
  private void d(int paramInt)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b(2, 2131694424, 1500);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingApiIRoamSettingService.getMapUploading().clear();
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).setTroopMsgFilterToServer(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingApiIRoamSettingService.getMapRequest().put(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, Boolean.valueOf(true));
    if (!this.r)
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), 0);
      if (!localSharedPreferences.getBoolean("Change_Msg_Notify_Tips_Value", false))
      {
        this.r = true;
        localSharedPreferences.edit().putBoolean("Change_Msg_Notify_Tips_Value", true).commit();
        DialogUtil.a(this, getString(2131697648), 2131719065, 2131719065, new DialogUtil.DialogOnClickAdapter(), null).show();
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_msg", "", "data_page", "Clk_setmsg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, String.valueOf(paramInt - 1), "", "");
  }
  
  private void d(int paramInt, View paramView)
  {
    if (paramInt != 45) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if ((localObject != null) && (!TextUtils.isEmpty(((TroopInfoData)localObject).troopUin)))
    {
      paramView = (TextView)paramView.findViewById(2131376541);
      localObject = (ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RED_POINT_KEY_TROOP_IDOL_RANK");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      ((ITroopUtilsApi)localObject).setRedPointSP(localStringBuilder.toString());
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(false, paramView);
      if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch())
      {
        QQToast.a(this, getString(2131699559), 0).b(getTitleBarHeight());
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, new Object[] { "onclick:StudyMode Forbidden context = ", this });
        }
        return;
      }
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startFansTroopIdolRank(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 21);
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800B596", "0X800B596", 0, 0, "", "", "", "");
    }
    if (QLog.isColorLevel())
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
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
    View localView = View.inflate(this, 2131560674, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[12] = localView;
    an();
    this.jdField_b_of_type_AndroidViewView.measure(0, 0);
    localView = View.inflate(this, 2131561565, null);
    localView.setBackgroundResource(2130851081);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    localView.getLayoutParams().height = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();
    localView = View.inflate(this, 2131561562, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[23] = localView;
    localView.setTag(Integer.valueOf(23));
    localView.setOnClickListener(this);
    localView.setContentDescription(HardCodeUtil.a(2131701939));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    paramView.findViewById(2131379251).setVisibility(8);
    boolean bool = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).isShowTroopGameCardRedPoint(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, false);
    paramView = (TextView)localView.findViewById(2131376541);
    if (paramView != null) {
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(bool, paramView);
    }
    paramView = localView.findViewById(2131368033);
    paramView.setTag(Integer.valueOf(35));
    paramView.setContentDescription(getResources().getString(2131699460));
    if (SimpleUIUtil.a()) {
      paramView.setBackground(null);
    }
    if ((paramView instanceof ThemeImageView)) {
      ((ThemeImageView)paramView).setSupportMaskView(false);
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView[35] = paramView;
    I();
    paramView = localView.findViewById(2131379316);
    paramView.setTag(Integer.valueOf(36));
    this.jdField_a_of_type_ArrayOfAndroidViewView[36] = paramView;
    e();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo)) {
      paramView = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mRichFingerMemo;
    } else {
      paramView = getString(2131696146);
    }
    localView = localView.findViewById(2131378018);
    ((TextView)localView).setText(new QQText(paramView, 11, 16));
    this.jdField_a_of_type_ArrayOfAndroidViewView[37] = localView;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead) {
      localView.setVisibility(8);
    }
    d();
    Q();
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null) && (((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).isGrayTroopForTroopAssociations(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopMemberMaxNum, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt)))
    {
      paramView = View.inflate(this, 2131561565, null);
      paramView.setBackgroundResource(2130851081);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
      paramView.getLayoutParams().height = getResources().getDimensionPixelSize(2131298619);
      paramView = View.inflate(this, 2131561550, null);
      this.jdField_a_of_type_ArrayOfAndroidViewView[43] = paramView;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
      int i1 = ((IBizTroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IBizTroopInfoService.class, "")).getAssociatedTroopCount(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      paramView = (TextView)paramView.findViewById(2131376541);
      bool = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isEmptyRedPointSP("RED_POINT_KEY_TROOP_ASSOCIATION");
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(bool, paramView);
      H(i1);
    }
    paramView = View.inflate(this, 2131561565, null);
    paramView.setBackgroundResource(2130851081);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
    paramView.getLayoutParams().height = getResources().getDimensionPixelSize(2131298125);
  }
  
  private void d(String paramString)
  {
    IQQAvatarHandlerService localIQQAvatarHandlerService = (IQQAvatarHandlerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarHandlerService.class, "");
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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 3)
    {
      localIntent = new Intent();
      localIntent.putExtra("isNeedFinish", true);
      setResult(-1, localIntent);
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 30) {
      localIntent = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getChatActivityIntent(this);
    } else {
      localIntent = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getSplashActivityIntent(this);
    }
    Intent localIntent = BaseAIOUtils.a(localIntent, new int[] { 2 });
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    localIntent.putExtra("uintype", 1);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName);
    if ((paramBoolean) && (this.jdField_k_of_type_Boolean))
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
    if (!((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).troopNoticeFreezed(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData)) {
      X();
    }
  }
  
  private void e(View paramView)
  {
    Object localObject = (TextView)paramView.findViewById(2131363707);
    TextView localTextView = (TextView)paramView.findViewById(2131376541);
    ((TextView)localObject).setVisibility(8);
    localTextView.setVisibility(0);
    localTextView.setText(getString(2131699560));
    a(45, 3, paramView, getString(2131699562), "", true);
    paramView = (ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("RED_POINT_KEY_TROOP_IDOL_RANK");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    boolean bool = paramView.isEmptyRedPointSP(((StringBuilder)localObject).toString());
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(bool, localTextView);
  }
  
  private void e(String paramString)
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[50];
    TextView localTextView1 = (TextView)localView.findViewById(2131363707);
    TextView localTextView2 = (TextView)localView.findViewById(2131376541);
    localTextView1.setVisibility(8);
    localTextView2.setVisibility(0);
    a(50, 3, localView, getString(2131699540), "", true);
    if (TextUtils.isEmpty(paramString)) {
      localTextView2.setText(getString(2131699545));
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
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0x80084B5", "0x80084B5", 0, 0, "", "", "", "");
      }
      else
      {
        paramJSONObject = getActivity().getResources().getString(2131719909);
        if (i1 != 221002)
        {
          if (i1 == 221020) {
            paramJSONObject = getActivity().getResources().getString(2131719910);
          }
        }
        else {
          paramJSONObject = getActivity().getResources().getString(2131719904);
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
      h(getActivity().getResources().getString(2131719909));
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
    ImmersiveUtils.setStatusTextColor(false, getWindow());
    SimpleUIUtil.a(this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2, getActivity().getWindow());
  }
  
  private void f(int paramInt)
  {
    if (paramInt != 0) {
      return;
    }
    h();
    a("Grp_Admin_data", "Clk_mber", "");
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_mber", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData) });
  }
  
  private void f(int paramInt, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && (paramInt == -1))
    {
      paramIntent = paramIntent.getExtras();
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation = paramIntent.getString("location");
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLat = paramIntent.getInt("lat", 0);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLon = paramIntent.getInt("lon", 0);
      i();
    }
  }
  
  private void f(View paramView)
  {
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379249));
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131708966));
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new TroopSettingActivity.56(this));
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void f(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption == 1)
    {
      al();
      return;
    }
    g(paramString);
  }
  
  private void f(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if (localObject == null) {
      return;
    }
    if (paramBoolean == ((TroopInfo)localObject).isTroopGameCardEnabled()) {
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(this, 2131696195, 0).b(getTitleBarHeight());
      aq();
      return;
    }
    if (paramBoolean) {
      as();
    }
    localObject = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[48];
    if (localObject != null) {
      if (paramBoolean)
      {
        ((FormSwitchItem)localObject).setVisibility(0);
        ar();
      }
      else
      {
        ((FormSwitchItem)localObject).setVisibility(8);
      }
    }
    localObject = (ITroopGameHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopGameHandlerName());
    if (localObject != null) {
      ((ITroopGameHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, paramBoolean);
    }
    if (paramBoolean) {
      localObject = "game_switch_on";
    } else {
      localObject = "game_switch_off";
    }
    TroopReportor.a("Grp_set_new", "grpData_admin", (String)localObject, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
  }
  
  private void g(int paramInt)
  {
    if (paramInt != 2) {
      return;
    }
    g();
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_invite_new", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData) });
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
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption != 3)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption();
      int i2 = this.jdField_g_of_type_Int;
      if ((i2 != 1) && (i2 != 2)) {
        break label43;
      }
      i1 = 18;
      label43:
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.remark))
      {
        startActivity(((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startJoinTroop(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption, i1, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinAnswer, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.remark, this.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString));
        return;
      }
      paramString = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startJoinTroop(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption, i1, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinQuestion, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mStrJoinAnswer, null, this.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramString);
      paramString.putExtra("from_newer_guide", getIntent().getBooleanExtra("from_newer_guide", false));
      paramString.putExtra("from_babyq", getIntent().getBooleanExtra("from_babyq", false));
      startActivityForResult(paramString, 10);
      return;
    }
    a(2131719932, 0);
  }
  
  private void g(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if (localObject == null) {
      return;
    }
    if (((TroopInfo)localObject).isShowMyGameCardEnabled() == paramBoolean) {
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      QQToast.a(this, 2131696195, 0).b(getTitleBarHeight());
      ar();
      return;
    }
    localObject = (ITroopGameHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(TroopGameHandler.class.getName());
    if (localObject != null) {
      ((ITroopGameHandler)localObject).b(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, paramBoolean);
    }
    if (paramBoolean) {
      localObject = "game_switch_on";
    } else {
      localObject = "game_switch_off";
    }
    TroopReportor.a("Grp_manage_new", "game", (String)localObject, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
  }
  
  private void h(int paramInt)
  {
    if (paramInt != 22) {
      return;
    }
    String str = String.format("https://qun.qq.com/certification/index.html?_wv=7&_bid=2589&gc=%1$s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/browser");
    localActivityURIRequest.extra().putLong("startOpenPageTime", System.currentTimeMillis());
    localActivityURIRequest.extra().putString("url", str);
    QRoute.startUri(localActivityURIRequest, null);
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_certified", "", "data", "clk_data", 2, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", "", "");
  }
  
  private void h(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      boolean bool1 = NetworkUtil.isNetworkAvailable(this);
      boolean bool2 = false;
      if (!bool1)
      {
        QQToast.a(this, 1, 2131694425, 0).b(getTitleBarHeight());
        return;
      }
      paramIntent = paramIntent.getStringExtra("result");
      if (!TextUtils.isEmpty(paramIntent))
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
        if ((localObject != null) && (!paramIntent.equals(((TroopInfo)localObject).troopname)))
        {
          bool1 = bool2;
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim())
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.allowMemberModifTroopName == 1) {
              bool1 = true;
            }
          }
          ((ITroopModifyHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopModifyHandlerName())).a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, paramIntent, bool1);
          if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetTroopHead())) {
            this.jdField_e_of_type_Boolean = true;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
          ((TroopInfo)localObject).oldTroopName = ((TroopInfo)localObject).troopname;
          localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
          ((TroopInfoData)localObject).troopName = paramIntent;
          ((TroopInfoData)localObject).newTroopName = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.getTroopDisplayName();
          e();
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if ((localObject != null) && (((TroopInfo)localObject).troopcode != null)) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode;
    } else {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopCode;
    }
    if (((ITroopCommonlyUsedHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopCommonlyUsedHandlerName())).a((String)localObject, paramBoolean ^ true))
    {
      if (paramBoolean) {
        localObject = "open_stick";
      } else {
        localObject = "close_stick";
      }
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_set", "", "Grp_data", (String)localObject, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", "", "");
      TroopReportor.a("Grp_set_new", "grpData_admin", (String)localObject, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData) });
      return;
    }
    au();
  }
  
  private void i(int paramInt)
  {
    if (paramInt != 39) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nActiveMemberNum > this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      ((TroopInfoData)localObject1).nActiveMemberNum = ((TroopInfoData)localObject1).wMemberNum;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupFlagExt & 0x800000) != 8388608L) {
      paramInt = 0;
    } else {
      paramInt = 1;
    }
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("hide_operation_bar", true);
    ((Intent)localObject1).putExtra("hideRightButton", true);
    ((Intent)localObject1).putExtra("isScreenOrientationPortrait", true);
    ((Intent)localObject1).putExtra("uin", this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("https://qinfo.clt.qq.com/group_level/qlevel.html?_bid=151&groupuin=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    ((StringBuilder)localObject2).append("&role=1&group_level=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nTroopGrade);
    ((StringBuilder)localObject2).append("&group_mem_num=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum);
    ((StringBuilder)localObject2).append("&group_active_num=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nActiveMemberNum);
    ((StringBuilder)localObject2).append("&show_level=");
    ((StringBuilder)localObject2).append(paramInt);
    ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject2).toString());
    localObject2 = new ActivityURIRequest(this, "/pubaccount/browser");
    ((ActivityURIRequest)localObject2).extra().putAll(((Intent)localObject1).getExtras());
    QRoute.startUri((URIRequest)localObject2, null);
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_rank", "", "Grp_data", "Clk_grprank", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", "", "");
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).bnrReport(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 72);
  }
  
  private void i(int paramInt, Intent paramIntent)
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
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
          paramIntent = this.jdField_a_of_type_AndroidOsHandler.obtainMessage();
          paramIntent.what = 20;
          paramIntent.obj = str1;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramIntent);
          ITroopInfoService localITroopInfoService = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
          if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
            this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localITroopInfoService.findTroopInfo(str2);
          }
          TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
          l1 = l2;
          paramIntent = str1;
          bool1 = bool2;
          if (localTroopInfo != null)
          {
            localTroopInfo.updateLastMemoFromWeb(str1);
            localITroopInfoService.updateEntity(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
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
    T();
    TroopReportor.a("Grp_msg", "grpData_admin", "Clk_msgSet", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData) });
  }
  
  private void j(int paramInt, Intent paramIntent)
  {
    if ((paramInt == -1) && (paramIntent != null))
    {
      if (!NetworkUtil.isNetworkAvailable(this))
      {
        QQToast.a(this, 1, 2131694425, 0).b(getTitleBarHeight());
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
      QQToast.a(this, 2131696195, 0).b(getTitleBarHeight());
      ay();
      return;
    }
    ((ITroopShowExternalHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopShowExternalHandlerName())).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopCode, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, paramBoolean, false);
    if (paramBoolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_set", "", "Grp_data", "set_open", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", "", "");
    } else {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_set", "", "Grp_data", "set_close", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", "", "");
    }
    String str;
    if (paramBoolean) {
      str = "showGrp_open";
    } else {
      str = "showGrp_close";
    }
    TroopReportor.a("Grp_set_new", "grpData_admin", str, 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData) });
  }
  
  private void k(int paramInt)
  {
    if (paramInt != 1001) {
      return;
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startActivityForTroop(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 1001);
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_set", "", "Grp_data", "Clk_chatrecord", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", "", "");
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_chatRecord", 1, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData) });
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800A0B8", "0X800A0B8", 0, 0, "", "", "", "");
  }
  
  private void k(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData == null) {
      return;
    }
    if (!((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).isGrayTroopForTroopAssociations(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopMemberMaxNum, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt)) {
      return;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasTroopAssociation()) && (!paramBoolean))
    {
      H(0);
      return;
    }
    ITroopAssociationHandler localITroopAssociationHandler = (ITroopAssociationHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAssociationHandlerName());
    if (localITroopAssociationHandler != null) {
      localITroopAssociationHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 3, "");
    }
  }
  
  private void l(int paramInt)
  {
    if (paramInt != 1010) {
      return;
    }
    TroopReportor.a("Grp_set_new", "grpData_admin", "grpNotice_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    localIntent.putExtra("uintype", 1);
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).messageNotificationSettingFragmentLaunch(this, localIntent);
  }
  
  private void m(int paramInt)
  {
    if (paramInt != 1006) {
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    ((Intent)localObject).putExtra("param_from", 19);
    ((Intent)localObject).putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum);
    RouteUtils.a(this, (Intent)localObject, "/troop/memberlist/TroopMemberList", 9);
    localObject = ((ITroopMemberInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopMemberInfoService.class, "")).getTroopMember(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    TroopReportor.a("Grp_edu", "Grp_data", "teachermsg_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a((TroopMemberInfo)localObject) });
  }
  
  private void n(int paramInt)
  {
    if (paramInt != 1002) {
      return;
    }
    d(false);
    if (this.jdField_g_of_type_Int == 2) {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_discuss", "", "discuss_AIO", "Clk_grpaio", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", "", "");
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).StoryReportor(this);
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead) {
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
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_payjoin", "", "join_grp", "Clk_data", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", "", "");
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).jump2PayJoinTroopWeb(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "");
    TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption());
  }
  
  private void p(int paramInt)
  {
    if (paramInt != 1005) {
      return;
    }
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).joinGroupOneStep(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, getIntent(), this);
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0x80084B4", "0x80084B4", 0, 0, "", "", "", "");
    TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption());
  }
  
  private void q(int paramInt)
  {
    if (paramInt != 1003) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getExposureSourceReportVal());
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800A527", "0X800A527", paramInt, 0, localStringBuilder.toString(), "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 34)
    {
      if (((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).needAnswerQuestion(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()))
      {
        localObject = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).createQuestionDialog(this);
        if (!isFinishing())
        {
          ((Dialog)localObject).show();
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "kuolie", "0X80097DC", 0, 0, "", "", "", "");
        }
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X80092D7", "0X80092D7", 0, 0, "", "", "", "");
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).secRecognize(false, null);
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption != 1) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).calJoinTroop(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getExposureSource(), this.jdField_j_of_type_Int, 2);
      if (!NetworkUtil.isNetSupport(this))
      {
        a(2131694422, 1);
        return;
      }
      localObject = (ITroopMngHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName());
      if (localObject != null) {
        try
        {
          long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
          m();
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
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8007246", "0X8007246", 0, 0, "", "", "", "");
      }
      TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.getStatOption());
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isHomeworkTroop())
    {
      G(1);
      return;
    }
    al();
  }
  
  private void r(int paramInt)
  {
    if (paramInt != 17) {
      return;
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startChatBackgroundSettingActivity(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 6);
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8004E0E", "0X8004E0E", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_set", "", "Grp_data", "Set_chatBG", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", "", "");
    TroopReportor.a("Grp_set_new", "grpData_admin", "set_chatBG", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData) });
  }
  
  private void s()
  {
    ImmersiveUtils.setStatusTextColor(true, getWindow());
    this.jdField_d_of_type_JavaLangString = getIntent().getStringExtra("appid");
    this.jdField_e_of_type_JavaLangString = getIntent().getStringExtra("openid");
    this.jdField_f_of_type_JavaLangString = getIntent().getStringExtra("share_uin");
    this.jdField_g_of_type_JavaLangString = getIntent().getStringExtra("is_from_game");
    if (("true".equals(this.jdField_g_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)))
    {
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).checkApiState(this.jdField_a_of_type_ComTencentCommonAppAppInterface, getApplicationContext(), this.jdField_d_of_type_JavaLangString, this, 0, null);
      this.jdField_h_of_type_JavaLangString = getIntent().getStringExtra("guild_id");
      this.jdField_i_of_type_JavaLangString = getIntent().getStringExtra("zone_id");
      this.jdField_j_of_type_JavaLangString = getIntent().getStringExtra("role_id");
      this.jdField_k_of_type_JavaLangString = getIntent().getStringExtra("gc");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("joinGroup appid = ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaLangString);
        ((StringBuilder)localObject).append(" openid = ");
        ((StringBuilder)localObject).append(this.jdField_e_of_type_JavaLangString);
        ((StringBuilder)localObject).append(" guild id = ");
        ((StringBuilder)localObject).append(this.jdField_h_of_type_JavaLangString);
        ((StringBuilder)localObject).append("zone_id = ");
        ((StringBuilder)localObject).append(this.jdField_i_of_type_JavaLangString);
        ((StringBuilder)localObject).append(" role id = ");
        ((StringBuilder)localObject).append(this.jdField_j_of_type_JavaLangString);
        ((StringBuilder)localObject).append("  group code= ");
        ((StringBuilder)localObject).append(this.jdField_k_of_type_JavaLangString);
        QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("Q.chatopttroop", 2, " joinGroup is from game = false");
    }
    Object localObject = String.valueOf(this.jdField_d_of_type_JavaLangString);
    if ((!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) && (!this.jdField_f_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount())))
    {
      q();
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
      b((String)localObject);
    }
  }
  
  private void s(int paramInt)
  {
    if (40 != paramInt) {
      return;
    }
    Object localObject = (EntryStatus)((QFormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[40]).getTag(2131374942);
    if (localObject != null)
    {
      long l1 = ((EntryStatus)localObject).jdField_a_of_type_Long;
      ((EntryStatus)localObject).jdField_a_of_type_Long = SystemClock.uptimeMillis();
      if (((EntryStatus)localObject).jdField_a_of_type_Long < l1 + 1000L) {
        return;
      }
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).setStringForQVipConfigManager_keyWordExpireList(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, ((EntryStatus)localObject).jdField_b_of_type_JavaLangString);
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).setBooleanForQVipConfigManager_keyWordGuideClicked(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      String str = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getUrlFromIndividuationUrlHelper_keyWord().replace("[groupid]", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onClick: ");
        localStringBuilder.append(str);
        QLog.d("Q.chatopttroop.troop.special_msg.keyword", 2, localStringBuilder.toString());
      }
      ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "qq_vip", "0X800A8F8", ((EntryStatus)localObject).jdField_c_of_type_Int, 1, 0, "", "", "", "");
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
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("start_recomend_page");
    localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    localIntentFilter.addAction("com.tencent.mobileqq.actoino.ACTIONO_DEL_TROOP_MEMBER");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiTroopRobotObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopLuckycharacterApiTroopLuckyCharacterObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameApiTroopGameObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinememberApiTroopOnlineMemberObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver);
    ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).preloadWebProcess(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  private void t(int paramInt)
  {
    if (paramInt != 18) {
      return;
    }
    TroopReportor.a("Grp_set_new", "grpData_admin", "specialEntrance_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
    Object localObject = new ActivityURIRequest(this, "/base/browser");
    String str = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getUrlFromIndividuationUrlHelper_entryEffect();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("&gc=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    str = VasWebviewUtil.a(localStringBuilder.toString(), 52);
    ((ActivityURIRequest)localObject).extra().putString("url", str);
    ((ActivityURIRequest)localObject).setRequestCode(15);
    QRoute.startUri((URIRequest)localObject, null);
    localObject = (ITroopEnterEffectService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopEnterEffectService.class, "all");
    ((ITroopEnterEffectService)localObject).report("grp_data", "entry_clk", new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
    paramInt = ((ITroopEnterEffectService)localObject).getEffectId(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).reportCommercialDrainage(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin(), "style", "0X8008E62", "", 1, 0, 0, "", Integer.toString(paramInt), "");
  }
  
  private void u()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if (localObject != null)
    {
      if (((TroopInfoData)localObject).isOwnerOrAdim()) {
        localObject = "0";
      } else {
        localObject = "1";
      }
      a("Grp_Admin_data", "Clk_data", (String)localObject);
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).bnrReport(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 65);
    localObject = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
    if (localObject != null)
    {
      TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      if (localTroopInfoData != null)
      {
        localObject = ((ITroopInfoService)localObject).findTroopInfo(localTroopInfoData.troopUin);
        if ((localObject != null) && (((TroopInfo)localObject).isGameBind())) {
          TroopReportor.a("Grp_game", "Grp_data", "data_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
        }
      }
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).reportCommercialDrainage(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin(), "group_nickname", "group_nickname_1", "", 1, 0, 0, "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800A523", "0X800A523", 0, 0, "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_create", "", "search", "grpedit_grpcreate_exp", 0, 0, "", "", "", "");
  }
  
  private void u(int paramInt)
  {
    if (paramInt != 23) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      if ((localObject != null) && (((TroopInfo)localObject).troopuin != null)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin;
      }
    }
    if (((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).isShowTroopGameCardRedPoint(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, false))
    {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setTroopGameCardRedPoint(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, false);
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setTroopGameCardRedPointHasShowed(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, true);
      ((IRedPointUtilsApi)QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "troop", 3, 0);
      localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[23];
      if (localObject != null)
      {
        localObject = (TextView)((View)localObject).findViewById(2131376541);
        if (localObject != null) {
          ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateRedPoint(false, (TextView)localObject);
        }
      }
    }
    Object localObject = ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).getTroopProfileExtra(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 0);
    ((Bundle)localObject).putBoolean("troop_info_from_troopsetting", true);
    ((Bundle)localObject).putInt("exposureSource", 1);
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).openTroopInfoActivity(this, (Bundle)localObject, 2);
    localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead) {
      paramInt = 1;
    } else {
      paramInt = 2;
    }
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800A524", "0X800A524", paramInt, 0, "", "", "", "");
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ArrayOfAndroidViewView != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      if (localObject != null)
      {
        if (TextUtils.isEmpty(((TroopInfoData)localObject).troopUin)) {
          return;
        }
        localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[49];
        if (localObject == null) {
          return;
        }
        TextView localTextView = (TextView)((View)localObject).findViewById(2131376541);
        int i1;
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.groupFlagExt4 & 0x8000) == 0) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 == 0)
        {
          localTextView.setText(getResources().getString(2131697565));
          return;
        }
        localTextView.setText("");
        long l1 = 0L;
        localObject = ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).getKeyTroopLuckyCharacterStatus(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, getString(2131697567));
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
        ITroopLuckyCharacterHandler localITroopLuckyCharacterHandler = (ITroopLuckyCharacterHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopLuckyCharacterHandlerName());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localITroopLuckyCharacterHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
          return;
        }
        if (l1 > localCalendar.getTimeInMillis())
        {
          localTextView.setText("");
          return;
        }
        localITroopLuckyCharacterHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      }
    }
  }
  
  private void v(int paramInt)
  {
    if (paramInt != 27) {
      return;
    }
    DeleteRecordDialog localDeleteRecordDialog = new DeleteRecordDialog(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
    localDeleteRecordDialog.a(new TroopSettingActivity.25(this));
    localDeleteRecordDialog.a(2);
    TroopReportor.a("Grp_set_new", "grpData_admin", "clk_delRecord", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData) });
  }
  
  private void w()
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
    localTextView.setText(2131719933);
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = ViewUtils.b(15.0F);
    localLayoutParams.bottomMargin = ViewUtils.b(24.0F);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localTextView, localLayoutParams);
    TroopReportor.a("Grp_set_new", "grpData_admin", "tipoff_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
  }
  
  private void w(int paramInt)
  {
    if (paramInt != 1009) {
      return;
    }
    if (this.o)
    {
      ((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).setRobotItemRedShowed(this.jdField_a_of_type_ComTencentCommonAppAppInterface, false);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingUiRobotMemberFormItem.a(false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "setRobotItemRedDotShowed");
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "", "0X8009F9C", 0, 0, "", "", "", "");
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).jumpRobotPage(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim());
  }
  
  private void x()
  {
    View localView = View.inflate(this, 2131561563, null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131365495));
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
      this.jdField_c_of_type_AndroidWidgetButton.setText(2131691756);
    } else {
      this.jdField_c_of_type_AndroidWidgetButton.setText(2131716747);
    }
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(new TroopSettingActivity.10(this));
  }
  
  private void x(int paramInt)
  {
    if (paramInt != 14) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null)
    {
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).TroopNameEntry(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, this, this.jdField_d_of_type_Boolean, 96, 16);
      TroopReportor.a("Grp_set_new", "grpData_admin", "clk_editInfo", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData) });
      AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
      String str1;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
        str1 = "0";
      }
      for (;;)
      {
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
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
    Object localObject = View.inflate(this, 2131561543, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[27] = localObject;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    a(27, 0, (View)localObject, getString(2131696108), null, false);
    ((View)localObject).setTag(Integer.valueOf(27));
    ((View)localObject).setOnClickListener(this);
    TextView localTextView = (TextView)((View)localObject).findViewById(2131378784);
    if ("1103".equals(ThemeUtil.getCurrentThemeId())) {
      localTextView.setAlpha(0.5F);
    }
    localTextView.setTextColor(Color.parseColor("#4799DF"));
    localObject = (TextView)((View)localObject).findViewById(2131368773);
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  private void y(int paramInt)
  {
    if (paramInt != 25) {
      return;
    }
    U();
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
    String str1;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
      str1 = "0";
    }
    for (;;)
    {
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
        str1 = "1";
      } else {
        str1 = "2";
      }
    }
    ReportController.b(localAppInterface, "dc00899", "Grp_set_new", "", "grpData_admin", "clk_num", 0, 0, str2, "0", str1, "");
  }
  
  private void z()
  {
    c(getResources().getString(2131699555));
    Object localObject = new QFormSimpleItem(this);
    this.jdField_a_of_type_ArrayOfAndroidViewView[17] = localObject;
    a(17, 1, (QFormSimpleItem)localObject, HardCodeUtil.a(2131701961), "", true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    TroopReportor.a("Grp_set_new", "grpData_admin", "chatBG_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
    if (!this.jdField_d_of_type_Boolean)
    {
      localObject = new QFormSimpleItem(this);
      this.jdField_a_of_type_ArrayOfAndroidViewView[18] = localObject;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
      a(18, 2, (QFormSimpleItem)localObject, getString(2131719831), "", true);
      ((QFormSimpleItem)localObject).setVisibility(8);
      localObject = (ITroopEnterEffectService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopEnterEffectService.class, "all");
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
    a(1010, 2, (QFormSimpleItem)localObject, getString(2131694519), getString(2131718801), true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQFormSimpleItem = ((QFormSimpleItem)localObject);
    TroopReportor.a("Grp_set_new", "grpData_admin", "grpNotice_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
    if (((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).keyWordIsEnable())
    {
      localObject = new QFormSimpleItem(this);
      this.jdField_a_of_type_ArrayOfAndroidViewView[40] = localObject;
      a(40, 2, (QFormSimpleItem)localObject, getString(2131699497), "", true);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    }
    localObject = new FormSwitchItem(this, null);
    ((FormSwitchItem)localObject).setBackgroundResource(2130839440);
    ((FormSwitchItem)localObject).setText(getString(2131696353));
    ((FormSwitchItem)localObject).a().setTextColor(getResources().getColorStateList(2131167056));
    ((FormSwitchItem)localObject).setFocusable(true);
    ((FormSwitchItem)localObject).getBackground().setAlpha(255);
    ((FormSwitchItem)localObject).setContentDescription(getString(2131696353));
    this.jdField_a_of_type_ArrayOfAndroidViewView[10] = localObject;
    ((FormSwitchItem)localObject).a().setTag(Integer.valueOf(10));
    aw();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    TroopReportor.a("Grp_set_new", "grpData_admin", "hideMessage_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
    localObject = View.inflate(this, 2131561565, null);
    ((View)localObject).setBackgroundResource(2130851081);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject);
    ((View)localObject).getLayoutParams().height = getResources().getDimensionPixelSize(2131298125);
  }
  
  private void z(int paramInt)
  {
    if (paramInt != 32) {
      return;
    }
    String str = ((ITroopLinkApi)QRoute.api(ITroopLinkApi.class)).getTroopHonorUrl(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, 1);
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/browser");
    localActivityURIRequest.extra().putString("url", str);
    QRoute.startUri(localActivityURIRequest, null);
    TroopReportor.a("Grp_set_new", "grpData_admin", "grpHonour_click", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
    ReportController.b(null, "dc00898", "", "", "0X800A6EF", "0X800A6EF", 0, 0, "", "", "", "");
  }
  
  void a()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      View localView = View.inflate(this, 2131562962, null);
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131365037));
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)localView.findViewById(2131378881));
      this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[51];
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
      Object localObject = new AbsListView.LayoutParams(-1, -2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      localObject = new XSimpleListAdapter(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter((ListAdapter)localObject);
      this.jdField_d_of_type_Boolean = ((ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).isQidianPrivateTroop(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("intNewStyleUI mIsQidianPrivateTroop : ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
        ((StringBuilder)localObject).append(", troopUin = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
      }
      super.setContentView(localView);
      this.jdField_d_of_type_AndroidViewView = localView;
      this.jdField_d_of_type_AndroidViewView.setBackgroundResource(2130838739);
      this.jdField_b_of_type_AndroidViewView = localView.findViewById(2131378861);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131378803));
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName);
      localStringBuilder.append(" ");
      localStringBuilder.append(getResources().getString(2131690819));
      ((RelativeLayout)localObject).setContentDescription(localStringBuilder.toString());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369249));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690819));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369202));
      localObject = this.jdField_b_of_type_AndroidWidgetTextView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getString(2131694652));
      localStringBuilder.append(getString(2131690703));
      ((TextView)localObject).setContentDescription(localStringBuilder.toString());
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131369216));
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(getString(2131693364));
      TroopReportor.a("Grp_set_new", "grpData_admin", "share_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
      d(localView);
      F();
      E();
      D();
      C();
      B();
      A();
      z();
      y();
      x();
      w();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initNewStyleUI  mIsQidianPrivateTroop = ");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
        ((StringBuilder)localObject).append(",time = ");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
        QLog.d("Q.chatopttroop", 2, ((StringBuilder)localObject).toString());
      }
      c(localView);
      b(false);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(17);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      finish();
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  protected void a(int paramInt)
  {
    if (paramInt != 6) {
      return;
    }
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startTroopMemberCard(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, 2);
  }
  
  void a(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this).a(paramInt1, getTitleBarHeight(), 0, paramInt2);
  }
  
  protected void a(int paramInt1, int paramInt2, View paramView, String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramInt1, paramInt2, paramView, paramString, paramBoolean);
    paramString = (TextView)paramView.findViewById(2131368773);
    if (paramString != null)
    {
      paramString.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
      if (TextUtils.isEmpty(paramCharSequence)) {
        paramView = "";
      } else {
        paramView = new QQText(paramCharSequence, 3);
      }
      paramString.setText(paramView);
      paramString.setTextColor(getResources().getColor(2131167138));
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
            paramView.setBackgroundResource(2130839440);
          }
        }
        else {
          paramView.setBackgroundResource(2130839443);
        }
      }
      else {
        paramView.setBackgroundResource(2130839449);
      }
    }
    else {
      paramView.setBackgroundResource(2130839433);
    }
    paramView.getBackground().setAlpha(255);
    TextView localTextView = (TextView)paramView.findViewById(2131378784);
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
    paramQFormSimpleItem.a().setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
    if (paramCharSequence == null) {
      paramString = str2;
    } else {
      paramString = new QQText(paramCharSequence, 3);
    }
    paramQFormSimpleItem.setRightText(paramString);
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
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).handleAppShareAction(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this, paramIntent);
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
    paramView = paramView.findViewById(2131362975);
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
    if (this.jdField_b_of_type_JavaUtilList == null) {
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
    tmp8_6[0] = 2131379306;
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = 2131379307;
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = 2131379308;
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = 2131379309;
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = 2131379310;
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = 2131379311;
    tmp38_32;
    this.jdField_b_of_type_JavaUtilList = new ArrayList(6);
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = arrayOfInt[i1];
      this.jdField_b_of_type_JavaUtilList.add((ImageView)paramView.findViewById(i3));
      i1 += 1;
    }
  }
  
  protected void a(TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo != null)
    {
      this.jdField_d_of_type_JavaUtilList = paramTroopInfo.parseTroopMemeberList();
      if (QLog.isColorLevel())
      {
        paramTroopInfo = new StringBuilder();
        paramTroopInfo.append("getMemberListFromTroopInfo,memberUins.size = ");
        List localList = this.jdField_d_of_type_JavaUtilList;
        int i1;
        if (localList != null) {
          i1 = localList.size();
        } else {
          i1 = -1;
        }
        paramTroopInfo.append(i1);
        QLog.d("Q.chatopttroop", 2, paramTroopInfo.toString());
      }
      f();
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
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      ((TroopInfoData)localObject).troopColorNick = str2;
      ((TroopInfoData)localObject).troopColorNickId = paramTroopMemberInfo.troopColorNickId;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopCard = str1;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    }
  }
  
  protected void a(TroopSettingActivity.ViewHolder paramViewHolder, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramViewHolder.jdField_a_of_type_AndroidWidgetImageView == null) {
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCacheFrom(paramViewHolder.jdField_a_of_type_Int, paramViewHolder.jdField_a_of_type_JavaLangString, 5);
    }
    paramBitmap = localBitmap;
    if (localBitmap == null)
    {
      if (paramBoolean) {
        localBitmap = BaseImageUtil.f();
      }
      paramBitmap = localBitmap;
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.jdField_a_of_type_Int, false);
        paramBitmap = localBitmap;
      }
    }
    if (paramBitmap != null) {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
    }
  }
  
  protected void a(String paramString)
  {
    TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    localTroopInfoData.troopName = paramString;
    if ((!localTroopInfoData.isNewTroop) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopName)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName = paramString;
    }
    e();
    paramString = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    paramString.hasSetNewTroopName = true;
    if (paramString.hasSetNewTroopHead) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop = false;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if (paramString != null)
    {
      paramString.troopname = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopName;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.hasSetNewTroopName = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopName;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.isNewTroop = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop;
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateTroopInfoToDB(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember);
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_set", "", paramString1, paramString2, 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, paramString3, "", "");
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
    this.jdField_c_of_type_JavaUtilList = paramList;
    Object localObject = new ArrayList();
    int i1 = 0;
    while (i1 < this.jdField_c_of_type_JavaUtilList.size())
    {
      ((ArrayList)localObject).add(Long.valueOf(((oidb_0x899.memberlist)paramList.get(i1)).uint64_member_uin.get()));
      i1 += 1;
    }
    this.jdField_d_of_type_JavaUtilList = ((List)localObject);
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("updateGridTroopMemberFace,memberUins.size = ");
      localObject = this.jdField_d_of_type_JavaUtilList;
      if (localObject != null) {
        i1 = ((List)localObject).size();
      } else {
        i1 = -1;
      }
      paramList.append(i1);
      QLog.d("Q.chatopttroop", 2, paramList.toString());
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new TroopSettingActivity.21(this));
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
      ((ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).saveTroopInfo(paramTroopInfo);
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
    Object localObject1 = this.jdField_a_of_type_ArrayOfAndroidViewView[13];
    this.jdField_c_of_type_JavaUtilArrayList.clear();
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
      localObject2 = this.jdField_c_of_type_AndroidViewView;
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
      localObject2 = a((View)localObject1, i2);
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
            ((TextView)((View)localObject2).findViewById(2131362861)).setText((CharSequence)localObject4);
            l1 = ((oidb_0xe83.AppInfo)localObject3).appid.get();
            a((View)localObject2, (oidb_0xe83.AppInfo)localObject3, (String)localObject4, l1);
            a((View)localObject2, (oidb_0xe83.AppInfo)localObject3);
            a((oidb_0xe83.AppInfo)localObject3, l1);
            ((View)localObject2).setTag(localObject3);
            ((View)localObject2).setTag(-1, Integer.valueOf(i2 + 1));
            ((View)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
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
              localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
              l1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.dwGroupClassExt;
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
      paramRspBody = this.jdField_c_of_type_AndroidViewView;
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
    Object localObject1 = (QFormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[18];
    if (localObject1 == null) {
      return;
    }
    if (paramBoolean)
    {
      TroopReportor.a("Grp_set_new", "grpData_admin", "specialEntrance_exp", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin });
      ((QFormSimpleItem)localObject1).setVisibility(0);
      Object localObject2 = this.jdField_a_of_type_ArrayOfAndroidViewView[17];
      if ((localObject2 != null) && ((localObject2 instanceof QFormSimpleItem))) {
        ((QFormSimpleItem)localObject2).setBgType(2);
      }
      Object localObject3 = (ITroopEnterEffectService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopEnterEffectService.class, "all");
      localObject2 = ((ITroopEnterEffectService)localObject3).getAllEffectInfo();
      if (localObject2 != null)
      {
        localObject3 = ((ITroopEnterEffectService)localObject3).getEffectInfo(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        if ((localObject3 != null) && (((TroopEnterEffectConfig.EffectInfoData)localObject3).jdField_a_of_type_Int > 0))
        {
          ((QFormSimpleItem)localObject1).setRightText(((TroopEnterEffectConfig.EffectInfoData)localObject3).jdField_a_of_type_JavaLangString);
          return;
        }
        if (((TroopEnterEffectConfig.EffectInfo)localObject2).jdField_b_of_type_Int > 0)
        {
          ((QFormSimpleItem)localObject1).setRightText(((TroopEnterEffectConfig.EffectInfo)localObject2).jdField_a_of_type_JavaLangString);
          return;
        }
        ((QFormSimpleItem)localObject1).setRightText(HardCodeUtil.a(2131701954));
        return;
      }
      ((QFormSimpleItem)localObject1).setRightText(HardCodeUtil.a(2131701962));
      return;
    }
    ((QFormSimpleItem)localObject1).setVisibility(8);
  }
  
  protected boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.chatopttroop", 2, "checkParams");
    }
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    boolean bool3 = false;
    boolean bool1 = false;
    if (localObject == null) {
      return false;
    }
    boolean bool2 = bool3;
    try
    {
      this.jdField_c_of_type_Boolean = false;
      bool2 = bool3;
      this.jdField_a_of_type_Boolean = false;
      bool2 = bool3;
      localObject = getIntent().getExtras();
      bool2 = bool3;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).initTroopInfoData((Bundle)localObject, this);
      bool2 = bool3;
      TroopInfo localTroopInfo = ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).initTroopInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData, this);
      if (localTroopInfo != null)
      {
        bool2 = bool3;
        this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localTroopInfo;
      }
      bool2 = bool3;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin = ((Bundle)localObject).getString("troop_uin");
      bool2 = bool3;
      if (Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin) > 0L) {
        bool1 = true;
      }
      bool2 = bool1;
      this.jdField_g_of_type_Int = ((Bundle)localObject).getInt("D2GType");
      bool2 = bool1;
      this.jdField_j_of_type_Int = ((Bundle)localObject).getInt("filter_id", -1);
      bool2 = bool1;
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).setExposureSource(((Bundle)localObject).getInt("exposureSource", 99));
      bool2 = bool1;
      this.jdField_k_of_type_Boolean = ((Bundle)localObject).getBoolean("fromThirdAppByOpenSDK");
      bool2 = bool1;
      this.jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("authKey");
      bool2 = bool1;
      this.jdField_b_of_type_JavaLangString = ((Bundle)localObject).getString("authSig");
      return bool1;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, localException.toString());
      }
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).bnrReport(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 69);
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
      else if (Utils.a(localTroopMemberCardInfo.troopuin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin))
      {
        localObject = localTroopMemberCardInfo;
        if (Utils.a(localTroopMemberCardInfo.memberuin, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())) {}
      }
      else
      {
        localObject = null;
      }
      i1 += 1;
    }
    paramArrayList = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopCard;
    if ((localObject != null) && (!Utils.a(paramArrayList, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopCard)))
    {
      paramArrayList = localObject.name;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopColorNick = localObject.colorNick;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopColorNickId = localObject.colorNickId;
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopCard = localObject.name;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    }
    return localObject != null;
  }
  
  protected void b()
  {
    if (!NetworkUtil.isNetworkAvailable(getApplicationContext())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "initNetworkRequests");
    }
    Object localObject1 = (ITroopSettingHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopSettingHandlerName());
    ITroopListHandler localITroopListHandler = (ITroopListHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(TroopListHandler.class.getName());
    Object localObject2 = (ITroopMemberCardHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(TroopMemberCardHandler.class.getName());
    ITroopAppHandler localITroopAppHandler = (ITroopAppHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAppHandlerName());
    if (localObject2 != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
      ((ITroopMemberCardHandler)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopCode, localArrayList);
    }
    if ((localITroopListHandler != null) && (localObject1 != null))
    {
      k();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember)
      {
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)));
        localITroopListHandler.a((ArrayList)localObject2);
        ((ITroopSettingHandler)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiITroopCardAppInfoHelperApi = ((ITroopCardAppInfoHelperApi)QRoute.api(ITroopCardAppInfoHelperApi.class));
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiITroopCardAppInfoHelperApi.init(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    N();
    if (localITroopAppHandler != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
      int i1;
      if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
        i1 = 1;
      } else {
        i1 = -1;
      }
      localITroopAppHandler.a((String)localObject1, false, 0, 1, i1);
    }
  }
  
  public void b(int paramInt)
  {
    if (paramInt != 11) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 15) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 10) || (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.pa == 11)) {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_nearby", "", "nearbygrp_data", "Clk_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", "", "");
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation)) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLat != 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLon != 0))
    {
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this, "/base/browser");
      double d1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLat;
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      double d2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLon;
      Double.isNaN(d2);
      String str = String.format("https://nearby.qq.com/hot_chat/qun_class.html?_wv=1031&latitude=%1$s&longitude=%2$s", new Object[] { String.valueOf(d1), String.valueOf(d2 / 1000000.0D) });
      localActivityURIRequest.extra().putString("url", str);
      QRoute.startUri(localActivityURIRequest, null);
      a("Grp", "Clk_grp_map", "0");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim())
    {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_set", "", "Grp_data", "add_place", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "", "", "");
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).startModifyLocationActivityForResult(this, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation, 12);
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
        k();
      }
    }
    ThreadManager.post(new TroopSettingActivity.49(this), 8, null, true);
  }
  
  protected void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    TextView localTextView = (TextView)paramView.findViewById(2131378784);
    paramView = paramView.findViewById(2131376541);
    if ((localTextView != null) && (paramView != null) && (!TextUtils.isEmpty(localTextView.getText())))
    {
      int i1 = (int)localTextView.getPaint().measureText(localTextView.getText().toString());
      ((RelativeLayout.LayoutParams)paramView.getLayoutParams()).leftMargin = (i1 + Utils.a(30.0F, getResources()));
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "mTroopInfoData is null!");
      }
      return;
    }
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[5];
    paramBoolean = ((TroopInfoData)localObject).isOwnerOrAdim();
    int i2 = 0;
    int i1;
    if ((paramBoolean) && (this.jdField_b_of_type_Boolean)) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    if (localView != null) {
      localView.setVisibility(i1);
    }
    localObject = (QFormSimpleItem)this.jdField_a_of_type_ArrayOfAndroidViewView[6];
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init(), isInitialized = ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.i("Q.chatopttroop", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839401);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131298126));
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
    if (!NetworkUtil.isNetworkAvailable(getApplicationContext())) {
      QQToast.a(getApplicationContext(), 1, getString(2131694424), 1).b(getTitleBarHeight());
    }
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 8, null, false);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new TroopSettingActivity.15(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
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
    paramIntent = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
    if (paramIntent == null) {
      paramIntent = null;
    } else {
      paramIntent = paramIntent.findTroopInfo(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    }
    if ((paramIntent != null) && (paramIntent.wMemberNum != this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateTroopAdmMemberNum(paramIntent.Administrator, paramIntent.wMemberNum, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), getResources());
      paramIntent = this.jdField_c_of_type_AndroidWidgetTextView;
      if (paramIntent != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum);
        localStringBuilder.append(HardCodeUtil.a(2131701963));
        paramIntent.setText(localStringBuilder.toString());
      }
    }
    if (this.jdField_e_of_type_JavaUtilList != null)
    {
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("resultForTroopMemberList,memberListForCard.size = ");
        paramIntent.append(this.jdField_e_of_type_JavaUtilList.size());
        QLog.d("Q.chatopttroop", 2, paramIntent.toString());
      }
      a(this.jdField_e_of_type_JavaUtilList);
    }
    paramIntent = (ITroopMemberInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopMemberInfoService.class, "");
    if (this.jdField_a_of_type_ArrayOfAndroidViewView[6] != null) {
      ThreadManager.post(new TroopSettingActivity.50(this, paramIntent), 8, null, true);
    }
  }
  
  protected void d()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfAndroidViewView[23];
    if (localObject != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData == null) {
        return;
      }
      localObject = (TextView)((View)localObject).findViewById(2131379276);
      ((TextView)localObject).setTag(Integer.valueOf(39));
      int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.nTroopGrade;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isShowActivityGrade()) {
        i1 = 0;
      }
      if (i1 > 0)
      {
        String str = String.format(getResources().getString(2131693387), new Object[] { Integer.valueOf(i1) });
        ((TextView)localObject).setText(str);
        ((TextView)localObject).setContentDescription(str);
        ((TextView)localObject).setVisibility(0);
      }
      else
      {
        ((TextView)localObject).setVisibility(8);
      }
      if (this.jdField_d_of_type_Boolean) {
        ((TextView)localObject).setVisibility(8);
      }
      ((TextView)localObject).setOnClickListener(this);
    }
  }
  
  protected void d(int paramInt, Intent paramIntent)
  {
    l();
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
          S();
          return;
        case 20: 
          j(paramInt2, paramIntent);
          return;
        case 19: 
          ak();
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
        aj();
        return;
      case 13: 
        g(paramInt2, paramIntent);
        return;
      case 12: 
        f(paramInt2, paramIntent);
        return;
      case 11: 
        ((ITroopInfoHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName())).d(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        return;
      case 10: 
        if ((paramInt2 != -1) || (paramIntent == null) || (!paramIntent.getBooleanExtra("has_operation", false))) {
          break;
        }
        this.jdField_a_of_type_AndroidContentIntent = paramIntent;
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
        this.jdField_m_of_type_Boolean = true;
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
        this.u = true;
        return;
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
      String str = TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData);
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
    ap();
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    s();
    long l1;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    } else {
      l1 = 0L;
    }
    if (!a())
    {
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null))
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCreate, illegal param, troopuin = ");
        paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        QLog.i("Q.chatopttroop", 2, paramBundle.toString());
      }
      finish();
      return false;
    }
    this.jdField_a_of_type_AndroidUtilDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(this.jdField_a_of_type_AndroidUtilDisplayMetrics);
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin))) {
        ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).checkIsShowCacheAppInfos(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_b_of_type_JavaUtilArrayList);
      }
      paramBundle = (TroopLuckyCharacterConfig)QConfigManager.a().a(696);
      if (paramBundle != null) {
        this.jdField_f_of_type_Boolean = paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingApiIRoamSettingService = ((IRoamSettingService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IRoamSettingService.class, ""));
      a();
      a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
      if (!b()) {
        J();
      }
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCreate(), time = ");
        paramBundle.append(System.currentTimeMillis() - l1);
        QLog.i("Q.chatopttroop", 2, paramBundle.toString());
      }
      ThreadManager.getSubThreadHandler().post(new TroopSettingActivity.4(this));
      t();
      u();
      this.jdField_c_of_type_JavaLangString = getIntent().getStringExtra("focusItem");
      if (this.jdField_f_of_type_Boolean) {
        v();
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
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
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetButton;
    if (localObject1 != null) {
      ((Button)localObject1).getBackground().setColorFilter(null);
    }
    this.jdField_g_of_type_Boolean = true;
    long l1 = 0L;
    if (QLog.isColorLevel()) {
      l1 = System.currentTimeMillis();
    }
    try
    {
      this.jdField_c_of_type_Boolean = true;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
      if (localObject1 != null) {
        ((IFaceDecoder)localObject1).destory();
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingUiRobotMemberFormItem;
      if (localObject1 != null) {
        ((RobotMemberFormItem)localObject1).a();
      }
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopFansApiTroopFansObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopShowexternalApiTroopShowExternalObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopAssociationApiTroopAssociationObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopAnnouncementApiTroopAnnouncementObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRobotApiTroopRobotObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopLuckycharacterApiTroopLuckyCharacterObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameApiTroopGameObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinememberApiTroopOnlineMemberObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloHandlerIApolloExtensionObserver);
      localObject1 = this.jdField_a_of_type_AndroidOsHandler;
      if (localObject1 != null) {
        ((Handler)localObject1).removeCallbacksAndMessages(null);
      }
      localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if ((localObject1 != null) && (((Animatable)localObject1).isRunning())) {
        ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      }
      localObject1 = this.jdField_a_of_type_AndroidAppDialog;
      if ((localObject1 != null) && (((Dialog)localObject1).isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      GroupCatalogTool.a(this).a();
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if (localObject1 != null) {
        ((QQProgressDialog)localObject1).dismiss();
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiITroopCardAppInfoHelperApi;
      if (localObject1 != null) {
        ((ITroopCardAppInfoHelperApi)localObject1).destroy();
      }
      try
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
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
      Object localObject2 = this.jdField_b_of_type_AndroidOsHandler;
      if (localObject2 != null) {
        ((Handler)localObject2).removeCallbacksAndMessages(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      if (localObject2 != null) {
        ((QQBlurView)localObject2).c();
      }
      ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).troopShareUtilityDestroy();
      V();
      super.doOnDestroy();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onDestroy(), time = ");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l1);
        QLog.i("Q.chatopttroop", 2, ((StringBuilder)localObject2).toString());
      }
      Y();
      return;
    }
    finally {}
  }
  
  protected void doOnPause()
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (localButton != null) {
      localButton.getBackground().setColorFilter(null);
    }
    super.doOnPause();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    URLDrawable.resume();
    int i1;
    if ((TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 512))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((this.jdField_a_of_type_AndroidWidgetButton != null) && (i1 != 0) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember)) {
      this.jdField_a_of_type_AndroidWidgetButton.getBackground().setColorFilter(new LightingColorFilter(0, -158425));
    }
    Object localObject1 = (ITroopAppHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAppHandlerName());
    Object localObject2;
    if (this.jdField_l_of_type_Boolean)
    {
      this.jdField_l_of_type_Boolean = false;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
      String str = TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead) {
        localObject1 = "1";
      } else {
        localObject1 = "0";
      }
      TroopReportor.a("Grp_set_new", "grpData_admin", "exp", 0, 0, new String[] { localObject2, str, localObject1 });
    }
    else
    {
      localObject2 = (ITroopAppService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopAppService.class, "all");
      if ((localObject2 != null) && (((ITroopAppService)localObject2).getProfileAppListChangedFromWebOperate(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)) && (localObject1 != null))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin;
        if (((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
          i1 = 1;
        } else {
          i1 = -1;
        }
        ((ITroopAppHandler)localObject1).a((String)localObject2, true, 0, 1, i1);
      }
      if (this.s)
      {
        k();
        this.s = false;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember) && (((IRobotUtilApi)QRoute.api(IRobotUtilApi.class)).isRobotSwitchOn(this.jdField_a_of_type_ComTencentCommonAppAppInterface)))
    {
      long l1 = 0L;
      try
      {
        long l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        l1 = l2;
      }
      catch (Exception localException)
      {
        QLog.e("Q.chatopttroop", 2, "onResume  parseLong err", localException);
      }
      ITroopRobotHandler localITroopRobotHandler = (ITroopRobotHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopRobotHandlerName());
      if (localITroopRobotHandler != null) {
        localITroopRobotHandler.b(l1);
      }
    }
    if (this.t)
    {
      k(true);
      this.t = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
    ao();
    am();
    ReportController.b(null, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "qq_vip", "0X800A8F6", 0, 1, 0, "", "", "", "");
    if (this.jdField_a_of_type_ArrayOfAndroidViewView[40] != null) {
      G();
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    if (!this.jdField_h_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStart add observer");
      }
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopCommonlyUsedObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopFansApiTroopFansObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopShowexternalApiTroopShowExternalObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopAnnouncementApiTroopAnnouncementObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopLuckycharacterApiTroopLuckyCharacterObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopgameApiTroopGameObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopAssociationApiTroopAssociationObserver);
      this.jdField_h_of_type_Boolean = true;
    }
    if (this.jdField_i_of_type_Boolean) {
      this.jdField_i_of_type_Boolean = false;
    }
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    if (this.jdField_h_of_type_Boolean)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.chatopttroop", 4, "doOnStop remove observer");
      }
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopRoamsettingRoamSettingObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopObserverTroopRedDotObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopShowexternalApiTroopShowExternalObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopAssociationApiTroopAssociationObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingApiTroopSettingObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopAnnouncementApiTroopAnnouncementObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiTroopAppObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopModifyObserver);
      removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      this.jdField_h_of_type_Boolean = false;
    }
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  protected void e()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim();
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[14];
    Object localObject1;
    Object localObject2;
    if (localView != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopName) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName;
      } else {
        localObject1 = HardCodeUtil.a(2131701974);
      }
      localView.setOnClickListener(this);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131701947));
        localStringBuilder.append((String)localObject1);
        if (bool) {
          localObject2 = HardCodeUtil.a(2131701936);
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
    localView = this.jdField_a_of_type_ArrayOfAndroidViewView[36];
    if (localView != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.newTroopName;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = HardCodeUtil.a(2131701964);
      }
      ((TextView)localView).setText((CharSequence)localObject1);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131701931));
        ((StringBuilder)localObject2).append((String)localObject1);
        localView.setContentDescription(((StringBuilder)localObject2).toString());
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("updateHostTroopNameEntry %s", new Object[] { localObject1 }));
      }
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
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(5, str, 1000);
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        if (!TextUtils.isEmpty(paramIntent)) {
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateTroopOwner(paramIntent, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        }
        az();
        O();
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier = new QQProgressNotifier(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.a(1, str, 1000);
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateShowFace  memberUins.size = ");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_JavaUtilList);
      int i1;
      if (((StringBuilder)localObject).toString() != null) {
        i1 = this.jdField_d_of_type_JavaUtilList.size();
      } else {
        i1 = -1;
      }
      QLog.d("Q.chatopttroop", 2, new Object[] { Integer.valueOf(i1) });
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView;
    if (localObject != null)
    {
      ((MyGridView)localObject).setPadding(this.jdField_b_of_type_Int, this.jdField_d_of_type_Int, this.jdField_c_of_type_Int, this.jdField_e_of_type_Int);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity$ListAdapter;
      if (localObject == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity$ListAdapter = new TroopSettingActivity.ListAdapter(this);
        this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopTroopsettingActivityTroopSettingActivity$ListAdapter);
        return;
      }
      ((TroopSettingActivity.ListAdapter)localObject).notifyDataSetChanged();
    }
  }
  
  protected void g()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.canInviteMember()) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("last_update_time");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localObject1 = getSharedPreferences(((StringBuilder)localObject1).toString(), 4);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("key_last_update_time");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
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
      localObject2 = (ITroopMemberListHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberListHandlerName());
      if (localObject2 != null) {
        ((ITroopMemberListHandler)localObject2).a(true, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopCode, 6);
      }
      localObject1 = ((SharedPreferences)localObject1).edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("key_last_update_time");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
      ((SharedPreferences.Editor)localObject1).putLong(((StringBuilder)localObject2).toString(), System.currentTimeMillis()).commit();
    }
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 5, null, false);
  }
  
  protected void h()
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1500L) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    ((Intent)localObject).putExtra("param_from", 0);
    ((Intent)localObject).putExtra("TROOP_INFO_MEMBER_NUM", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.wMemberNum);
    RouteUtils.a(this, (Intent)localObject, "/troop/memberlist/TroopMemberList", 9);
    localObject = "2";
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bOwner) {
          localObject = "0";
        } else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.bAdmin) {
          localObject = "1";
        }
      }
      catch (Exception localException)
      {
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_mber", "", "mber_list", "Clk_mberlist", 0, 0, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, "0", (String)localObject, "");
      return;
    }
  }
  
  public void i()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[11];
    if (localView != null)
    {
      if ((localView instanceof QFormSimpleItem))
      {
        TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
        if ((localTroopInfoData != null) && (!TextUtils.isEmpty(localTroopInfoData.troopLocation)))
        {
          localView.setVisibility(0);
          a(11, 3, (QFormSimpleItem)localView, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopLocation, null, true);
          return;
        }
      }
      localView.setVisibility(8);
    }
  }
  
  public void j()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[22];
    if (localView != null)
    {
      if ((localView instanceof QFormSimpleItem))
      {
        TroopInfoData localTroopInfoData = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
        if ((localTroopInfoData != null) && (!TextUtils.isEmpty(localTroopInfoData.troopAuthenticateInfo)))
        {
          localView.setVisibility(0);
          a(22, 1, (QFormSimpleItem)localView, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopAuthenticateInfo, null, true);
          return;
        }
      }
      localView.setVisibility(8);
    }
  }
  
  protected void k()
  {
    ITroopAnnouncementHandler localITroopAnnouncementHandler = (ITroopAnnouncementHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAnnouncementHandlerName());
    ITroopInfoHandler localITroopInfoHandler = (ITroopInfoHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName());
    if (localITroopAnnouncementHandler != null)
    {
      if (localITroopInfoHandler == null) {
        return;
      }
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
        }
        TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
        if (localTroopInfo != null) {
          localITroopInfoHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin, 1000L, "getGroupInfoFromChatSettingForTroop");
        } else {
          localITroopInfoHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, 1000L, "getGroupInfoFromChatSettingForTroop");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
        {
          localITroopAnnouncementHandler.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
          return;
        }
        localITroopAnnouncementHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
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
  
  protected void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.chatopttroop", 2, "refreshTroopBasicInfo");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.updateForTroopChatSetting(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, getResources(), this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopHead) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.hasSetNewTroopName))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop = false;
      TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      if (localTroopInfo != null)
      {
        localTroopInfo.isNewTroop = false;
        ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).updateTroopInfoToDB(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember);
      }
    }
    e();
    ai();
    o();
    a(this.jdField_d_of_type_Boolean ^ true, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isNewTroop);
  }
  
  public void m()
  {
    try
    {
      if (this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694668);
        this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, localException.toString());
      }
    }
  }
  
  public void n()
  {
    ((IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class)).hideJuhua(this.jdField_b_of_type_ComTencentMobileqqWidgetQQProgressDialog, "Q.chatopttroop");
  }
  
  protected void o()
  {
    View localView = this.jdField_a_of_type_ArrayOfAndroidViewView[19];
    if (localView != null)
    {
      TroopInfo localTroopInfo = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      if (localTroopInfo != null)
      {
        if ((!localTroopInfo.mCanSearchByKeywords) && (!this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.mCanSearchByTroopUin))
        {
          localView.setVisibility(8);
          return;
        }
        localView.setVisibility(0);
      }
    }
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
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData != null) && ((localObject instanceof Integer)))
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
      if ((paramString != null) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)))
      {
        I();
        return;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView;
      if (localObject != null)
      {
        paramInt2 = ((MyGridView)localObject).getChildCount();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.getChildAt(paramInt1).getTag();
          if ((localObject != null) && ((localObject instanceof TroopSettingActivity.ViewHolder)))
          {
            localObject = (TroopSettingActivity.ViewHolder)localObject;
            if (paramString == null)
            {
              a((TroopSettingActivity.ViewHolder)localObject, null, false);
            }
            else if (paramString.equals(((TroopSettingActivity.ViewHolder)localObject).jdField_a_of_type_JavaLangString))
            {
              ((TroopSettingActivity.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new BitmapDrawable(getResources(), paramBitmap));
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
  
  public void p()
  {
    Context localContext = getApplicationContext();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
    if (localObject != null)
    {
      localObject = Long.toString(((TroopInfoData)localObject).dwGroupClassExt);
      GroupCatalogTool.a(localContext).a((String)localObject, null);
    }
  }
  
  public void q()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null)
    {
      if (!((QQCustomDialog)localObject).isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(2131695206);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setTitle(2131692113);
    localObject = new TroopSettingActivity.59(this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(2131690728, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131695174, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData;
      if (localObject != null)
      {
        if (TextUtils.isEmpty(((TroopInfoData)localObject).troopUin)) {
          return;
        }
        localObject = (ITroopMemberInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopMemberInfoService.class, "");
        if (((ITroopMemberInfoService)localObject).isMemberInCache(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.chatopttroop", 2, "updateNick use cache");
          }
          a(((ITroopMemberInfoService)localObject).getTroopMember(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()));
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.chatopttroop", 2, "updateNick async");
        }
        ThreadManager.post(new TroopSettingActivity.61(this, (ITroopMemberInfoService)localObject), 5, null, false);
      }
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity
 * JD-Core Version:    0.7.0.1
 */