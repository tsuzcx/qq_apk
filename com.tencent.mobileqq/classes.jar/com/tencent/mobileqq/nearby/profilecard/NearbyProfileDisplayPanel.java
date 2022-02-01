package com.tencent.mobileqq.nearby.profilecard;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.jungle.nearby.nio.proto.nearby.Cmd0x1RspBody;
import com.tencent.jungle.nearby.nio.proto.nearby.FansInfo;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.config.NearbyDataManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.nearby.CikeConfigData;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager.LikeItem;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.QQNearbyManager;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.nearby.api.NearbyProxy;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.now.NowSmallVideoObserver;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment;
import com.tencent.mobileqq.nearby.profilecard.moment.NewNearbyMomentFragment;
import com.tencent.mobileqq.nearby.widget.AutoScrollImageView;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter.ViewHolder;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager;
import com.tencent.mobileqq.nearby.widget.NearbyAppDownloadDialog;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenu;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenu.OnItemClickListener;
import com.tencent.mobileqq.nearby.widget.NearbyPublishMenuHelper;
import com.tencent.mobileqq.newnearby.INearbyCGIReporter;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.newnearby.INearbyVersionControl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.entity.ProfileBusiEntry;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.NestViewPager;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.mobileqq.widget.TabBarView.OnTabChangeListener;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyUserFollowReq;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.qqprotect.qsec.QSecFramework;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.GridView;
import com.tencent.widget.ScrollView;
import com.tencent.widget.ScrollView.OnScrollStateChangedListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NowAnchorState;

public class NearbyProfileDisplayPanel
  extends NearbyProfileDisplayBasePanel
  implements View.OnClickListener, DecodeTaskCompletionListener, OnTagClickListener, TabBarView.OnTabChangeListener, ScrollView.OnScrollStateChangedListener
{
  public static String[] am = { "0X800553B", "0X800553C", "0X800553D", "0X800553E", "0X800553F", "0X8005540", "0X8005541" };
  public static String[] an = { "0X8005542", "0X8005543", "0X8005544", "0X8005545", "0X8005546", "0X8005547", "0X8005548" };
  boolean A;
  boolean B;
  WeakReferenceHandler C;
  AtomicInteger D;
  boolean E;
  boolean F;
  AtomicInteger G;
  AtomicInteger H;
  protected NestViewPager I;
  protected TabBarView J;
  protected LinearLayout K;
  protected NearbyMomentFragment L;
  protected NearbyProfileFragment M;
  protected ArrayList<BaseFragment> N;
  protected FragmentManager O;
  protected ImageView P;
  Handler.Callback Q;
  int R;
  int S;
  protected boolean T;
  int U;
  boolean V;
  boolean W;
  String X;
  String Y;
  int Z;
  private TextView aA;
  private View aB;
  private ImageView aC;
  private TextView aD;
  private TextView aE;
  private AutoScrollImageView aF;
  private ImageView aG;
  private RelativeLayout aH;
  private LinearLayout aI;
  private ImageView aJ;
  private Animation aK;
  private Animation aL;
  private NewVoteAnimHelper aM;
  private TextView aN;
  private NearbyProfileDisplayPanel.AvatarWallAdapter aO;
  private byte[] aP;
  private IFaceDecoder aQ;
  private boolean aR;
  private boolean aS;
  private Animation.AnimationListener aT;
  private CustomImgView aU;
  private View.OnClickListener aV;
  private DownloadListener aW;
  boolean aa;
  protected int ab;
  protected int ac;
  int ad;
  ViewPager.OnPageChangeListener ae;
  String af;
  String ag;
  boolean ah;
  protected String ai;
  protected ProfileBusiEntry aj;
  protected boolean ak;
  NearbyPublishMenu.OnItemClickListener al;
  NowSmallVideoObserver ao;
  Handler ap;
  DialogInterface.OnClickListener aq;
  private View ar;
  private NearbyCardVoteView as;
  private HeartLayout at;
  private View au;
  private View av;
  private TextView aw;
  private AvatarWallViewPager ax;
  private int ay;
  private ImageView az;
  protected final Map<String, View> d = new HashMap();
  NearbyPeopleProfileActivity e;
  protected NearbyPeopleCard f;
  protected NestScrollLayout g;
  protected ViewGroup h;
  protected TextView i;
  protected ImageView j;
  protected List<PicInfo> k;
  protected TextView l;
  protected TextView m;
  public boolean n;
  public boolean o;
  public boolean p;
  public boolean q;
  public boolean r;
  public boolean s;
  public boolean t;
  public boolean u;
  public boolean v;
  public boolean w;
  ProfileQiqiLiveController x = null;
  ProgressButton y;
  int z = 0;
  
  public NearbyProfileDisplayPanel(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    boolean bool = true;
    this.A = true;
    this.B = true;
    this.D = new AtomicInteger(0);
    this.E = false;
    this.F = false;
    this.G = new AtomicInteger(0);
    this.H = new AtomicInteger(0);
    this.Q = new NearbyProfileDisplayPanel.1(this);
    this.U = 0;
    this.V = false;
    this.W = false;
    this.X = "";
    this.Y = "";
    this.Z = 0;
    this.aa = false;
    this.ab = 1;
    this.ac = 0;
    this.aS = false;
    this.aT = new NearbyProfileDisplayPanel.5(this);
    this.ad = -1;
    this.ae = new NearbyProfileDisplayPanel.6(this);
    this.af = "";
    this.ag = "";
    this.ah = false;
    this.ai = null;
    this.ak = true;
    this.al = new NearbyProfileDisplayPanel.34(this);
    this.aV = new NearbyProfileDisplayPanel.35(this);
    this.ao = new NearbyProfileDisplayPanel.37(this);
    this.ap = new NearbyProfileDisplayPanel.40(this);
    this.aq = new NearbyProfileDisplayPanel.41(this);
    this.aW = new NearbyProfileDisplayPanel.42(this);
    this.e = paramNearbyPeopleProfileActivity;
    this.C = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.Q);
    if (paramNearbyPeopleProfileActivity.getIntent().getIntExtra("frome_where", 0) != 35) {
      bool = false;
    }
    this.F = bool;
    this.E = paramNearbyPeopleProfileActivity.getIntent().getBooleanExtra("is_from_werewolves", false);
    this.aR = paramNearbyPeopleProfileActivity.getIntent().getBooleanExtra("is_from_now_plugin", false);
    this.aQ = ((IQQAvatarService)paramNearbyPeopleProfileActivity.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramNearbyPeopleProfileActivity.app);
    this.aQ.setDecodeTaskCompletionListener(this);
    J();
  }
  
  private void J()
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = true;
    localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
    localURLDrawableOptions.mRequestWidth = ((int)DeviceInfoUtil.F());
    localURLDrawableOptions.mRequestHeight = (localURLDrawableOptions.mRequestWidth / 2);
    URLDrawable.getDrawable(r(), localURLDrawableOptions);
  }
  
  private void K()
  {
    this.K.removeAllViews();
    int i1 = this.f.gender;
    Object localObject1;
    if ((i1 == 0) || (i1 == 1) || (this.f.age > 0))
    {
      localObject2 = this.K;
      Pair localPair = c(i1);
      if (this.f.age > 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.f.age);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131905181));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = "";
      }
      ((LinearLayout)localObject2).addView(a(localPair, (String)localObject1, b(i1), UIUtils.a(this.e, 3.0F)));
    }
    Object localObject2 = this.e.app;
    if (this.e.mMode == 2) {
      localObject1 = "1";
    } else {
      localObject1 = "2";
    }
    ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_info", 0, 0, (String)localObject1, "", "", "");
    if ((this.f.constellation >= 1) && (this.f.constellation <= 12))
    {
      this.K.addView(a(B(), NearbyProfileUtil.e(this.f.constellation)));
      localObject2 = this.e.app;
      if (this.e.mMode == 2) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_xing", 0, 0, (String)localObject1, "", "", "");
    }
    if ((this.f.maritalStatus >= 2) && (this.f.maritalStatus <= 5))
    {
      this.K.addView(a(C(), NearbyProfileUtil.b(this.f.maritalStatus - 1)));
      localObject2 = this.e.app;
      if (this.e.mMode == 2) {
        localObject1 = "1";
      } else {
        localObject1 = "2";
      }
      ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", "", "data_card", "exp_relation", 0, 0, (String)localObject1, "", "", "");
    }
    if ((this.f.nearbyNowData != null) && (this.f.nearbyNowData.is_authen.get() == 1))
    {
      localObject1 = a(D(), HardCodeUtil.a(2131905147), 2130847065, UIUtils.a(this.e, 3.0F));
      localObject2 = new GradientDrawable(GradientDrawable.Orientation.BL_TR, new int[] { Color.parseColor("#ffa98df7"), Color.parseColor("#ff8aafff") });
      ((GradientDrawable)localObject2).setCornerRadius(DisplayUtil.a(this.b, 2.0F));
      ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
      ((TextView)localObject1).setOnClickListener(new NearbyProfileDisplayPanel.16(this));
      this.K.addView((View)localObject1);
      new ReportTask(this.e.app).a("dc00899").b("grp_lbs").c("data_card").d("cike_icon_exp").e(String.valueOf(this.f.tinyId)).a();
    }
  }
  
  private void L()
  {
    if (this.e.mMode == 2)
    {
      this.j.setVisibility(8);
      this.aw.setVisibility(0);
      this.aw.setOnClickListener(this);
      return;
    }
    this.j.setVisibility(0);
    this.aw.setVisibility(8);
    this.j.setOnClickListener(F());
  }
  
  private String M()
  {
    NearbyPeopleCard localNearbyPeopleCard = this.f;
    if (localNearbyPeopleCard != null) {
      return localNearbyPeopleCard.uin;
    }
    return "";
  }
  
  private void N()
  {
    if (!TextUtils.isEmpty(this.X)) {
      QQToast.makeText(this.e, this.X, 0).show(this.e.getTitleBarHeight());
    }
    if (this.f != null) {
      NearbyUtils.a(this.e.app, "blocked", this.f.uin);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("opername", "now#nearby#datacard");
      localJSONObject.put("module", "blacklist_toast");
      localJSONObject.put("action", "view");
      localJSONObject.put("fromuin", this.e.app.getCurrentAccountUin());
      localJSONObject.put("appid", String.valueOf(this.e.app.getAppid()));
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  private boolean O()
  {
    return ((INearbyVersionControl)QRoute.api(INearbyVersionControl.class)).getVersion() == 2;
  }
  
  private void P()
  {
    DialogUtil.a(this.e, this.X, 2131887648, 2131897030, new NearbyProfileDisplayPanel.26(this), new NearbyProfileDisplayPanel.27(this)).show();
    if (this.f != null) {
      NearbyUtils.a(this.e.app, "phone", this.f.uin);
    }
  }
  
  private void Q()
  {
    boolean bool = PackageUtil.a(this.e, this.f.guideAppNowPackage);
    NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.e;
    String str1 = this.f.guideAppNowTip;
    String str2 = this.f.guideAppNowTipLeftBtn;
    if (bool) {
      localObject = this.f.guideAppNowTipRightBtnInstalled;
    } else {
      localObject = this.f.guideAppNowTipRightBtnNotInstalled;
    }
    Object localObject = DialogUtil.a(localNearbyPeopleProfileActivity, 230, null, str1, str2, (String)localObject, new NearbyProfileDisplayPanel.28(this, bool), new NearbyProfileDisplayPanel.29(this));
    ((QQCustomDialog)localObject).getBtnight().setTextColor(-15550475);
    ((QQCustomDialog)localObject).show();
  }
  
  private void R()
  {
    int i1;
    if (this.T) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    NowSummaryCard.NearbyUserFollowReq localNearbyUserFollowReq = new NowSummaryCard.NearbyUserFollowReq();
    localNearbyUserFollowReq.from.set(0);
    localNearbyUserFollowReq.id_type.set(0);
    localNearbyUserFollowReq.target_id.set(this.f.tinyId);
    localNearbyUserFollowReq.operation.set(i1);
    ProtoUtils.a(this.e.app, new NearbyProfileDisplayPanel.32(this), localNearbyUserFollowReq.toByteArray(), "NowSummaryCard.NearbyUserFollow");
  }
  
  private void S()
  {
    int i1;
    if (this.E) {
      i1 = 6;
    } else {
      i1 = 2;
    }
    ((INowShortVideoProtoManager)QRoute.api(INowShortVideoProtoManager.class)).init(this.e.app).follow(Long.valueOf(this.f.uin).longValue(), this.f.nowId, this.f.nowUserType, i1, this.T ^ true, new NearbyProfileDisplayPanel.33(this));
  }
  
  private int T()
  {
    Intent localIntent = this.e.mEnterProfileIntent;
    int i1 = 6;
    int i2 = localIntent.getIntExtra("frome_where", 6);
    if ((i2 > 0) && (i2 < 6)) {
      return i2;
    }
    i2 = this.e.allinone.profileEntryType;
    if (i2 == 5) {
      return 1;
    }
    if (ProfileEntryUtils.isFromHotChat(i2)) {
      return 3;
    }
    if (((i2 >= 10) && (i2 <= 19)) || (i2 == 30)) {
      i1 = 2;
    }
    return i1;
  }
  
  private int U()
  {
    if (this.e != null)
    {
      NearbyPeopleCard localNearbyPeopleCard = this.f;
      if (localNearbyPeopleCard != null)
      {
        if ((localNearbyPeopleCard.lUserFlag & 0x800) != 0L) {
          return 0;
        }
        return ProfileCardUtil.b(this.e.allinone);
      }
    }
    return 1001;
  }
  
  private void V()
  {
    this.e.finish();
    AlbumUtil.anim(this.e, false, false);
  }
  
  private byte[] W()
  {
    Object localObject2 = this.e.allinone.chatCookie;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localObject2.length != 0) {}
    }
    else
    {
      localObject1 = localObject2;
      if (this.e.fetchFromType != 51) {
        localObject1 = this.e.app.getMsgCache().r(this.e.allinone.uin);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (localObject1.length != 0) {}
    }
    else
    {
      localObject2 = localObject1;
      if (this.e.fetchFromType == 51) {
        localObject2 = this.aP;
      }
    }
    if ((localObject2 == null) && (QLog.isColorLevel())) {
      QLog.e("Q.nearby_people_card.", 2, "nearbySig is null ");
    }
    return localObject2;
  }
  
  private void X()
  {
    if ((this.e.mCardHandler != null) && (this.f != null))
    {
      int i1;
      if (this.e.isFriend)
      {
        if (this.D.get() != 0)
        {
          this.e.mCardHandler.a(Long.valueOf(this.e.app.getCurrentAccountUin()).longValue(), Long.valueOf(this.f.uin).longValue(), this.f.vCookies, this.f.favoriteSource, this.D.get(), 0);
          boolean bool = ((INearbyLikeLimitManager)this.e.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).a(Long.valueOf(this.f.uin).longValue());
          if (PraiseManager.a(this.e.app) > 0)
          {
            if (bool) {
              i1 = 3;
            } else {
              i1 = 2;
            }
          }
          else if (bool) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          ReportController.b(this.e.app, "CliOper", "", "", "P_prof", "Prof_good", 2, this.D.get(), i1, Integer.toString(ProfileEntryUtils.getProfileEntryType(this.e.allinone.profileEntryType)), String.valueOf(this.D.get()), this.e.app.getCurrentAccountUin(), this.f.uin);
          this.D.set(0);
        }
      }
      else if ((this.G.get() != 0) || (this.H.get() != 0))
      {
        ArrayList localArrayList = new ArrayList();
        INearbyLikeLimitManager.LikeItem localLikeItem = new INearbyLikeLimitManager.LikeItem();
        localLikeItem.b = this.G.get();
        localLikeItem.c = this.H.get();
        localLikeItem.a = Long.valueOf(this.f.uin).longValue();
        localLikeItem.e = this.f.favoriteSource;
        localArrayList.add(localLikeItem);
        if (NearbyProfileCardUtils.a(this.e.from)) {
          i1 = 510;
        } else {
          i1 = 509;
        }
        this.e.mCardHandler.a(localArrayList, i1);
        this.G.set(0);
        this.H.set(0);
      }
    }
  }
  
  private boolean Y()
  {
    Object localObject = this.f;
    if ((localObject != null) && (((NearbyPeopleCard)localObject).nearbyNowData != null) && (this.f.nearbyNowData.now_msg_switch.has()) && (this.f.nearbyNowData.now_msg_switch.get() == 0))
    {
      localObject = this.e;
      localObject = CikeConfigData.a((Context)localObject, ((NearbyPeopleProfileActivity)localObject).app.getAccount(), 1);
      if (localObject != null)
      {
        ((CikeConfigData)localObject).a(this.f.nearbyNowData.uint64_uid.get());
        ((CikeConfigData)localObject).f = "14";
        ((CikeConfigData)localObject).g = this.f.uin;
        NearbyAppDownloadDialog localNearbyAppDownloadDialog = new NearbyAppDownloadDialog(this.e);
        localNearbyAppDownloadDialog.a((CikeConfigData)localObject);
        localNearbyAppDownloadDialog.show();
        ((INearbyCardHandler)this.e.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER)).a(this.f.uin, this.f.tinyId);
        return false;
      }
    }
    return true;
  }
  
  private void Z()
  {
    if (this.f != null) {
      NearbyUtils.a(this.e.app, "pass", String.valueOf(this.f.tinyId));
    }
    this.p = true;
    p();
    ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_msg", 0, 0, "", "", "", "");
    QQAppInterface localQQAppInterface = this.e.app;
    int i1 = this.e.allinone.profileEntryType;
    Object localObject = this.f;
    if ((localObject != null) && (((NearbyPeopleCard)localObject).uin != null)) {
      localObject = this.f.uin;
    } else {
      localObject = "";
    }
    ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004826", "0X8004826", i1, 0, (String)localObject, "", "", "");
    if ((this.e.allinone.pa == 75) || (this.e.allinone.pa == 76)) {
      ReportController.b(this.e.app, "CliOper", "", "", "0X8004944", "0X8004944", 0, 0, "", "", "", "");
    }
    NearbyPeopleProfileActivity.testGiftCount = 0;
    if (ProfileEntryUtils.isFromHotChat(this.e.allinone.profileEntryType))
    {
      ReportController.b(this.e.app, "CliOper", "", "", "0X800523D", "0X800523D", 0, 0, "", "", "", "");
      return;
    }
    if (ProfileEntryUtils.isFromFreshNews(this.e.allinone.profileEntryType)) {
      ReportController.b(this.e.app, "CliOper", "", "", "0X8005CAA", "0X8005CAA", 0, 0, "", "", "", "");
    }
  }
  
  private TextView a(Pair<String, String> paramPair, String paramString)
  {
    return a(paramPair, paramString, -1, 0);
  }
  
  private GridView a(List<PicInfo> paramList, int paramInt)
  {
    GridView localGridView = new GridView(this.b);
    paramList = new NearbyProfileDisplayPanel.AvatarGridViewAdapter(this, paramList, paramInt);
    Resources localResources = this.e.getResources();
    paramInt = AIOUtils.b(1.0F, localResources);
    this.e.imageWidth = ((localResources.getDisplayMetrics().widthPixels - paramInt * 2) / 3);
    localGridView.setNumColumns(3);
    localGridView.setStretchMode(2);
    localGridView.setSelector(new ColorDrawable(0));
    localGridView.setHorizontalSpacing(paramInt);
    localGridView.setVerticalSpacing(paramInt);
    localGridView.setAdapter(paramList);
    return localGridView;
  }
  
  private void a(Bitmap paramBitmap)
  {
    if ((this.f.nearbyNowData.now_anchor_state.uint32_live_status.get() == 1) && (this.aF != null) && (this.e.mPicInfo.size() == 0))
    {
      this.aF.setImageBitmap(paramBitmap);
      this.aF.setVisibility(0);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if ((this.e.mFromDatingSubject == 5) && (!TextUtils.isEmpty(this.e.mFromDatingId)) && (this.e.mIsPub))
    {
      String str = NearbyManagerHelper.a(this.e.app).a();
      paramString3 = str;
      if (str == null) {
        paramString3 = this.e.getResources().getString(2131896705);
      }
      AddMessageHelper.a(this.e.app, paramString1, paramString3, 1010);
    }
    paramString1 = new Intent(this.e, ChatActivity.class);
    paramString1.putExtra("PREVIOUS_WINDOW", QQNearbyManager.b().getName());
    paramString1.putExtra("PREVIOUS_UIN", this.f.uin);
    paramString1.putExtra("NEARBY_MSG_REPORT_SOURCE", this.e.mEnterProfileIntent.getStringExtra("NEARBY_MSG_REPORT_SOURCE"));
    paramString1.putExtra("cSpecialFlag", this.e.mEnterProfileIntent.getExtras().getInt("cSpecialFlag"));
    paramString1.putExtra("uin", paramString2);
    paramString1.putExtra("uintype", paramInt);
    paramString1.putExtra("ProfileCard_flag", "ProfileCard");
    if (this.f.firstOfficialMsg != null)
    {
      paramString1.putExtra("OFFICIAL_MSG", this.f.firstOfficialMsg);
      if (this.U == 4) {
        paramString1.putExtra("VERIFY_GRAY_TIPS", this.f.unverifyGrayTips);
      }
      this.f.firstOfficialMsg = null;
    }
    paramString1.putExtra("aio_msg_source", 3);
    if (this.e.allinone.chatEntrance != 0) {
      paramString1.putExtra("entrance", this.e.allinone.chatEntrance);
    }
    if (paramInt == 1001)
    {
      paramString1.putExtra("rich_accost_sig", this.e.allinone.chatCookie);
      paramString1.putExtra("gender", this.f.gender);
    }
    else if (paramInt == 1010)
    {
      paramString1.putExtra("rich_date_sig", this.e.allinone.chatCookie);
      paramString1.putExtra("gender", this.f.gender);
    }
    paramString1.putExtra("uinname", this.e.allinone.nickname);
    paramString1.addFlags(67108864);
    this.e.startActivity(paramString1);
    c(paramString2);
  }
  
  private void b(String paramString)
  {
    Object localObject = this.f.nearbyNowData;
    if (localObject == null) {
      return;
    }
    if ((((cmd0xac5.NearbyNowData)localObject).now_anchor_state.uint32_live_status.get() == 1) && (this.aF != null))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = 640;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = 640;
      paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      if (paramString.getStatus() == 1)
      {
        localObject = paramString.getCurrDrawable();
        if ((localObject instanceof RegionDrawable))
        {
          localObject = ((RegionDrawable)localObject).getBitmap();
          this.aF.setImageBitmap((Bitmap)localObject);
          this.aF.setVisibility(0);
        }
      }
      else
      {
        paramString.setURLDrawableListener(new NearbyProfileDisplayPanel.11(this));
      }
      ThreadManagerV2.excute(new NearbyProfileDisplayPanel.12(this, paramString), 128, null, true);
    }
  }
  
  private void c(String paramString)
  {
    JSONObject localJSONObject = this.e.getNearbyReportJson();
    if (localJSONObject == null) {
      return;
    }
    try
    {
      localJSONObject.put("touin", paramString);
      localJSONObject.put("module", "msg_button");
      localJSONObject.put("action", "click");
      ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
      this.e.onEnterChat();
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private void d(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("operation", paramInt);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("nearby.qq.com");
      EventApiPlugin.a("nearbyYanzhiCallback", localJSONObject, localArrayList, null);
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("NearbyProfileDisplayPanel", 2, localJSONException.toString());
      }
    }
  }
  
  private void d(String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = String.format("https://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017", new Object[] { this.f.uin });
    }
    paramString = new Intent(this.e, MusicGeneQQBrowserActivity.class);
    paramString.putExtra("uin", this.e.app.getCurrentAccountUin());
    paramString.putExtra("url", (String)localObject);
    if (this.e.allinone.pa == 0) {
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", true);
    } else {
      paramString.putExtra("BUDNLE_KEY_IS_MY_PROFILE", false);
    }
    localObject = Calendar.getInstance();
    if ((localObject != null) && (QLog.isColorLevel()))
    {
      localObject = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(((Calendar)localObject).getTime());
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("musicgene123 startactivity ");
        localStringBuilder.append((String)localObject);
        QLog.d("Q.nearby_people_card.", 4, localStringBuilder.toString());
      }
    }
    this.e.startActivity(paramString);
    ReportController.b(this.e.app, "CliOper", "", "", "0X8004182 ", "0X8004182", ProfileEntryUtils.getProfileEntryType(this.e.allinone.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.e.allinone)), "", "", "");
  }
  
  protected void A()
  {
    if ((!this.f.isAuthUser()) && (!this.f.isFuXiaoJin()))
    {
      this.az.setVisibility(8);
    }
    else
    {
      this.az.setVisibility(0);
      this.az.setImageResource(2130842206);
    }
    if (this.f.iIsGodFlag == 1)
    {
      this.aJ.setVisibility(0);
      if (this.f.gender == 1) {
        this.aJ.setImageResource(2130847556);
      } else {
        this.aJ.setImageResource(2130847555);
      }
      ThreadManager.post(new NearbyProfileDisplayPanel.15(this), 8, null, true);
      return;
    }
    this.aJ.setVisibility(8);
  }
  
  protected Pair<String, String> B()
  {
    return new Pair("#ffbfa4f6", "#FFFFFFFF");
  }
  
  protected Pair<String, String> C()
  {
    return new Pair("#ff89e1b5", "#FFFFFFFF");
  }
  
  protected Pair<String, String> D()
  {
    return new Pair("#000000", "#FFFFFFFF");
  }
  
  protected void E()
  {
    Object localObject1 = new NearbyProfileDisplayPanel.AvatarViewPagerAdatper(this, this.ax);
    this.ax.setAdapter((AvatarWallPagerAdapter)localObject1);
    Object localObject2 = new ArrayList();
    this.ay = ((int)Math.ceil(this.k.size() / 6.0F));
    int i1 = 0;
    while (i1 < this.ay)
    {
      ((List)localObject2).add(a(this.k, i1));
      i1 += 1;
    }
    ((AvatarWallPagerAdapter)localObject1).a((List)localObject2);
    if (this.e.mMode == 3) {
      localObject1 = "2";
    } else {
      localObject1 = "1";
    }
    ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_head", 0, 0, (String)localObject1, "", "", "");
    localObject1 = (RelativeLayout)this.ar.findViewById(2131444964);
    localObject2 = (LinearLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ax.getLayoutParams();
    if (localObject2 != null)
    {
      if (this.k.size() > 3)
      {
        ((LinearLayout.LayoutParams)localObject2).height = (this.e.getResources().getDisplayMetrics().widthPixels / 3 * 2);
        localLayoutParams.height = (this.e.getResources().getDisplayMetrics().widthPixels / 3 * 2);
      }
      else
      {
        ((LinearLayout.LayoutParams)localObject2).height = (this.e.getResources().getDisplayMetrics().widthPixels / 3);
        localLayoutParams.height = (this.e.getResources().getDisplayMetrics().widthPixels / 3);
      }
      ((LinearLayout.LayoutParams)localObject2).topMargin = (this.e.getResources().getDimensionPixelSize(2131299920) + ImmersiveUtils.getStatusBarHeight(this.e));
      ((RelativeLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    ((RelativeLayout.LayoutParams)localObject1).bottomMargin = UIUtils.a(this.e, 4.0F);
    this.ax.setDotLayoutParams((RelativeLayout.LayoutParams)localObject1);
  }
  
  protected View.OnClickListener F()
  {
    return new NearbyProfileDisplayPanel.17(this);
  }
  
  protected void G()
  {
    long l1 = System.currentTimeMillis();
    DialogUtil.a(this.e, 230, this.f.guideVerifiedDialogTitle, this.f.guideAppNowTip, this.f.guideAppNowTipLeftBtn, this.f.guideVerifiedDialogRightBtnText, new NearbyProfileDisplayPanel.30(this, l1), new NearbyProfileDisplayPanel.31(this, l1)).show();
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("opername", "now#nearby#datacard");
        localJSONObject.put("module", "limit_pop");
        localJSONObject.put("action", "view");
        localJSONObject.put("fromuin", this.e.app.getCurrentAccountUin());
        if (this.U == 4)
        {
          String str1 = "0";
          localJSONObject.put("d4", str1);
          localJSONObject.put("appid", String.valueOf(this.e.app.getAppid()));
          localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
          ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      String str2 = "1";
    }
  }
  
  protected boolean H()
  {
    return true;
  }
  
  boolean I()
  {
    return (Utils.a(this.e.allinone.preWinUin, this.e.allinone.uin)) && (this.e.allinone.preWinType != 3000) && (this.e.allinone.preWinType != 1) && (this.e.allinone.preWinType != 2);
  }
  
  View a(int paramInt, PicInfo paramPicInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getAvatarWallItemView, position = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", info = ");
      ((StringBuilder)localObject1).append(paramPicInfo.toString());
      QLog.d("NearbyProfileDisplayPanel", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new RelativeLayout(this.e);
    ((RelativeLayout)localObject1).setLayoutParams(new AbsListView.LayoutParams(-2, -2));
    Object localObject2 = new CustomImgView(this.e);
    ((RelativeLayout)localObject1).addView((View)localObject2, new LinearLayout.LayoutParams(this.e.imageWidth, this.e.imageWidth));
    Object localObject3 = new ImageView(this.e);
    ((ImageView)localObject3).setBackgroundResource(2130842185);
    ((ImageView)localObject3).setImageResource(2130847501);
    ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_XY);
    ((ImageView)localObject3).setVisibility(8);
    int i1 = UIUtils.a(this.e, 24.0F);
    Object localObject4 = new RelativeLayout.LayoutParams(i1, i1);
    ((RelativeLayout.LayoutParams)localObject4).addRule(13);
    ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    ((RelativeLayout)localObject1).addView((View)localObject3);
    ((CustomImgView)localObject2).setBackgroundDrawable(this.e.getResources().getDrawable(2130846492));
    ((CustomImgView)localObject2).setTag(paramPicInfo);
    ((CustomImgView)localObject2).setOnClickListener(this.aV);
    if (AppSetting.e)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131905110));
      ((StringBuilder)localObject3).append(paramInt);
      ((RelativeLayout)localObject1).setContentDescription(((StringBuilder)localObject3).toString());
    }
    localObject3 = this.e.getResources().getDrawable(2130847338);
    try
    {
      if ((this.e.mIsPlayDynamicAvatar) && (!TextUtils.isEmpty(paramPicInfo.e)))
      {
        this.d.put(paramPicInfo.e, localObject1);
        if (DynamicAvatarDownloadManager.e(paramPicInfo.e))
        {
          ((RelativeLayout)localObject1).getChildAt(1).setVisibility(8);
          a(paramPicInfo, (RelativeLayout)localObject1);
          return localObject1;
        }
        if (NetworkUtil.isWifiConnected(this.e))
        {
          this.e.downDynamicAvatar(paramPicInfo.e);
          ((RelativeLayout)localObject1).getChildAt(1).setVisibility(0);
        }
        else
        {
          ((RelativeLayout)localObject1).getChildAt(1).setVisibility(0);
        }
      }
      else
      {
        ((RelativeLayout)localObject1).getChildAt(1).setVisibility(8);
      }
      if ((paramPicInfo.d != null) && (paramPicInfo.d.length() > 0))
      {
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = this.e.imageWidth;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = this.e.imageWidth;
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
        ((CustomImgView)localObject2).setImageDrawable(URLDrawable.getDrawable(new File(paramPicInfo.d).toURL(), (URLDrawable.URLDrawableOptions)localObject4));
        return localObject1;
      }
      if (!StringUtil.isEmpty(paramPicInfo.b))
      {
        paramPicInfo = NearbyImgDownloader.convertURL(paramPicInfo.b);
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = this.e.imageWidth;
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = this.e.imageWidth;
        ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = ((Drawable)localObject3);
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject3);
        paramPicInfo = URLDrawable.getDrawable(paramPicInfo, (URLDrawable.URLDrawableOptions)localObject4);
        paramPicInfo.setDownloadListener(new ImgDownloadListener(BaseApplicationImpl.getApplication(), "actNearbyPeoplePicDownload"));
        ((CustomImgView)localObject2).setImageDrawable(paramPicInfo);
        return localObject1;
      }
      if (paramPicInfo.h == "type_qq_head_pic")
      {
        ((CustomImgView)localObject2).setImageDrawable(this.e.getResources().getDrawable(2130841061));
        return localObject1;
      }
    }
    catch (MalformedURLException paramPicInfo)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("PicGallery.getView() new URL(). ");
        ((StringBuilder)localObject2).append(paramPicInfo.getMessage());
        QLog.d("Q.nearby_people_card.", 2, ((StringBuilder)localObject2).toString(), paramPicInfo);
      }
    }
    return localObject1;
  }
  
  protected TextView a(Pair<String, String> paramPair, String paramString, int paramInt1, int paramInt2)
  {
    int i1 = DisplayUtil.a(this.b, 5.0F);
    int i2 = DisplayUtil.a(this.b, 14.0F);
    int i3 = DisplayUtil.a(this.b, 2.0F);
    TextView localTextView = new TextView(this.b);
    localTextView.setTextSize(1, 10.0F);
    Object localObject = new LinearLayout.LayoutParams(-2, i2);
    ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, DisplayUtil.a(this.b, 2.0F), 0);
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor((String)paramPair.first));
    ((GradientDrawable)localObject).setCornerRadius(i3);
    localTextView.setBackgroundDrawable((Drawable)localObject);
    localTextView.setTextColor(Color.parseColor((String)paramPair.second));
    localTextView.setText(paramString);
    localTextView.setPadding(i1, 0, i1, 0);
    localTextView.setGravity(17);
    if (paramInt1 > 0)
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(this.e.getResources().getDrawable(paramInt1), null, null, null);
      if (!TextUtils.isEmpty(paramString)) {
        localTextView.setCompoundDrawablePadding(paramInt2);
      }
    }
    return localTextView;
  }
  
  protected void a(int paramInt)
  {
    String str = "1";
    if (paramInt == 0)
    {
      localReportTask = new ReportTask(this.e.app).a("dc00899").b("grp_lbs").c("data_card").d("datatab_exp");
      if (this.e.mMode != 2) {
        str = "2";
      }
      localReportTask.a(new String[] { str }).a();
      ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportProfileInfoTabExp(this.e.app.getCurrentAccountUin(), String.valueOf(this.f.tinyId));
      return;
    }
    ReportTask localReportTask = new ReportTask(this.e.app).a("dc00899").b("grp_lbs").c("data_card").d("feedtab_exp").e(String.valueOf(this.f.tinyId));
    if (this.e.mMode != 2) {
      str = "2";
    }
    localReportTask.a(new String[] { str }).a();
    ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportProfileTrendsTabExp(this.e.app.getCurrentAccountUin(), String.valueOf(this.f.tinyId));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      try
      {
        String str = FaceUtil.b(String.valueOf(this.f.uin));
        Object localObject = new URL("profile_img_big", null, str);
        if (paramInt2 == 1) {
          URLDrawable.removeMemoryCacheByUrl(((URL)localObject).toString());
        }
        localObject = new PicInfo();
        ((PicInfo)localObject).d = str;
        if (!this.e.mIsUsingBigHead)
        {
          this.e.mPicInfo.add(0, localObject);
          this.e.mIsUsingBigHead = true;
        }
        else if (!this.e.mPicInfo.isEmpty())
        {
          this.e.mPicInfo.set(0, localObject);
        }
        if (this.aO != null) {
          this.aO.a(this.e.mPicInfo);
        }
        if (paramInt2 != 1)
        {
          this.e.refreshStrangerFace();
          return;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.nearby_people_card.", 2, localMalformedURLException.getMessage());
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 != 1000) && (paramInt1 != 1001))
    {
      if (paramInt1 == 1002) {
        this.L.b = true;
      }
    }
    else
    {
      NearbyPublishMenuHelper.a(this.b, paramInt1, paramInt2, paramIntent);
      this.L.b = true;
    }
    if (paramInt1 != 1000) {
      if (paramInt1 != 1018) {
        if (paramInt1 != 1028)
        {
          if (paramInt1 != 1032) {
            return;
          }
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("doOnActivityResult, requestCode=");
            paramIntent.append(paramInt1);
            paramIntent.append(", resultCode=");
            paramIntent.append(paramInt2);
            QLog.d("nearby.bindphone", 2, paramIntent.toString());
          }
          if (paramInt2 != -1) {
            break label619;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        this.U = 0;
        this.V = false;
        paramInt2 = this.h.getChildCount();
        paramInt1 = 0;
        if (paramInt1 < paramInt2)
        {
          paramIntent = this.h.getChildAt(paramInt1);
          if ((!(paramIntent.getTag() instanceof DataTag)) || (((DataTag)paramIntent.getTag()).a != 8)) {
            break label625;
          }
          if (QLog.isColorLevel())
          {
            paramIntent = new StringBuilder();
            paramIntent.append("updateBottomBtn, idx=");
            paramIntent.append(paramInt1);
            QLog.d("nearby.bindphone", 2, paramIntent.toString());
          }
          c(paramInt1, 8);
        }
        ((INearbyCardManager)this.e.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).a();
        if (QLog.isColorLevel()) {
          QLog.d("nearby.bindphone", 2, "doOnActivityResult, cleanProfileCardCache");
        }
        try
        {
          paramIntent = (InputMethodManager)this.e.getSystemService("input_method");
          if (paramIntent == null) {
            break label619;
          }
          paramIntent.hideSoftInputFromWindow(this.e.getWindow().getDecorView().getWindowToken(), 0);
          return;
        }
        catch (Exception paramIntent)
        {
          if (!QLog.isColorLevel()) {
            break label619;
          }
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnActivityResult, hideSoftInputPanel exp:");
        localStringBuilder.append(paramIntent);
        QLog.e("nearby.bindphone", 2, localStringBuilder.toString());
        return;
      }
      catch (Exception paramIntent)
      {
        if (!QLog.isColorLevel()) {
          break label619;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnActivityResult, exp=");
      localStringBuilder.append(paramIntent.toString());
      QLog.e("nearby.bindphone", 2, localStringBuilder.toString());
      return;
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("NearbyPeopleProfileActivity->doOnActivityResult, resultCode=");
        paramIntent.append(paramInt2);
        QLog.d("NearbyLikeLimitManager", 2, paramIntent.toString());
      }
      if (NearbyProfileCardUtils.a(this.e.from)) {
        paramInt1 = 510;
      } else {
        paramInt1 = 509;
      }
      paramIntent = (INearbyCardHandler)this.e.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
      long l2 = 0L;
      try
      {
        l1 = Long.parseLong(this.f.uin);
      }
      catch (Exception localException)
      {
        long l1;
        label514:
        break label514;
      }
      l1 = l2;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnActivityResult req NearbyLikeLimitInfo: mCard.uin=");
        localStringBuilder.append(this.f.uin);
        QLog.e("NearbyLikeLimitManager", 2, localStringBuilder.toString());
        l1 = l2;
      }
      paramIntent.a(l1, 0L, paramInt1);
      return;
      if (paramInt2 == -1)
      {
        this.e.allinone.pa = 25;
        m();
        return;
        this.e.setResult(-1);
        this.e.finish();
      }
      label619:
      return;
      label625:
      paramInt1 += 1;
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    this.aS = true;
    TabBarView localTabBarView = this.J;
    if (localTabBarView != null) {
      localTabBarView.setSelectedTab(paramInt, paramBoolean);
    }
  }
  
  protected void a(View paramView)
  {
    this.ar = paramView;
    this.l = ((TextView)this.ar.findViewById(2131448471));
    this.m = ((TextView)this.ar.findViewById(2131448442));
    this.aN = ((TextView)this.ar.findViewById(2131448981));
    paramView = this.e.getResources();
    this.R = paramView.getDimensionPixelSize(2131298121);
    this.S = paramView.getDimensionPixelSize(2131298120);
    this.az = ((ImageView)this.ar.findViewById(2131435630));
    this.as = ((NearbyCardVoteView)this.ar.findViewById(2131449991));
    this.as.setIsTribe(false);
    this.as.setVisibility(8);
    this.at = ((HeartLayout)this.ar.findViewById(2131435008));
    this.g = ((NestScrollLayout)this.ar.findViewById(2131429717));
    paramView = this.at;
    if (paramView != null)
    {
      paramView.setVisibility(8);
      this.at.setEnabled(false);
    }
    this.av = this.ar.findViewById(2131445041);
    this.i = ((TextView)this.ar.findViewById(2131436180));
    this.j = ((ImageView)this.ar.findViewById(2131436202));
    this.aw = ((TextView)this.ar.findViewById(2131436234));
    this.h = ((ViewGroup)this.ar.findViewById(2131429654));
    this.au = this.ar.findViewById(2131429714);
    u();
    this.P = ((ImageView)this.ar.findViewById(2131440861));
    this.P.setOnClickListener(this);
    this.ax = ((AvatarWallViewPager)this.ar.findViewById(2131429042));
    this.aH = ((RelativeLayout)this.ar.findViewById(2131445045));
    this.aA = ((TextView)this.ar.findViewById(2131439484));
    this.aB = this.ar.findViewById(2131439482);
    this.aC = ((ImageView)this.ar.findViewById(2131439481));
    this.aD = ((TextView)this.ar.findViewById(2131439487));
    this.aE = ((TextView)this.ar.findViewById(2131439486));
    this.aF = ((AutoScrollImageView)this.ar.findViewById(2131439485));
    this.aG = ((ImageView)this.ar.findViewById(2131439480));
    this.aI = ((LinearLayout)this.ar.findViewById(2131437587));
    this.aJ = ((ImageView)this.ar.findViewById(2131435641));
    this.g.setVerticalScrollBarEnabled(false);
    this.aK = new AlphaAnimation(0.0F, 1.0F);
    this.aK.setDuration(300L);
    this.aK.setAnimationListener(this.aT);
    this.aK.setInterpolator(new AccelerateInterpolator());
    this.aL = new AlphaAnimation(1.0F, 0.0F);
    this.aL.setDuration(300L);
    this.aL.setAnimationListener(this.aT);
    this.aL.setInterpolator(new AccelerateInterpolator());
    this.i.setVisibility(0);
    this.i.setText(2131887440);
    this.i.setOnClickListener(new NearbyProfileDisplayPanel.2(this));
    this.as.setAppInterface(this.e.app);
    this.I = ((NestViewPager)this.ar.findViewById(2131449829));
    this.I.setOnPageChangeListener(this.ae);
    this.O = this.e.getSupportFragmentManager();
    this.N = new ArrayList();
    w();
    this.g.setViewPager(this.I);
    int i1 = -1;
    if (this.e.mMode == 2) {
      i1 = NearbyDataManager.a(this.e.app);
    } else if (this.e.mMode == 3) {
      i1 = NearbyDataManager.b(this.e.app);
    }
    this.L.a(new NearbyProfileDisplayPanel.3(this, i1));
    this.K = ((LinearLayout)this.ar.findViewById(2131446796));
  }
  
  public void a(View paramView, int paramInt, InterestTagInfo paramInterestTagInfo)
  {
    if ((paramInterestTagInfo != null) && (paramInt != 0) && (this.e.mMode != 1))
    {
      Object localObject;
      if (paramInterestTagInfo.bid != 0L)
      {
        paramView = new StringBuilder();
        paramView.append("https://buluo.qq.com/mobile/barindex.html?bid=");
        paramView.append(paramInterestTagInfo.bid);
        paramView.append("&_wv=1027");
        paramView = paramView.toString();
        localObject = new Intent(this.e, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        this.e.startActivity((Intent)localObject);
      }
      else
      {
        paramView = new Intent(this.e, QQBrowserActivity.class);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://buluo.qq.com/mobile/search_result.html?_bid=128&_wv=1027&search_keyword=");
        ((StringBuilder)localObject).append(paramInterestTagInfo.tagName);
        ((StringBuilder)localObject).append("&from=nearby_tag");
        paramView.putExtra("url", ((StringBuilder)localObject).toString());
        this.e.startActivity(paramView);
      }
      QQAppInterface localQQAppInterface = this.e.app;
      if (paramInterestTagInfo.bid != 0L) {
        paramView = "tag_same";
      } else {
        paramView = "clk_tag";
      }
      if (this.e.mMode == 2) {
        paramInterestTagInfo = "1";
      } else {
        paramInterestTagInfo = "2";
      }
      int i1;
      if (paramInt <= 4)
      {
        localObject = new StringBuilder();
        i1 = paramInt + 3;
      }
      else
      {
        localObject = new StringBuilder();
        i1 = paramInt - 4;
      }
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("");
      ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "data_card", paramView, 0, 0, paramInterestTagInfo, "", ((StringBuilder)localObject).toString(), "");
      ThreadManager.post(new NearbyProfileDisplayPanel.36(this, paramInt), 5, null, false);
      return;
    }
    if (NearbyUtils.b()) {
      NearbyUtils.a("NearbyProfileDisplayPanel", new Object[] { "onTagClick", Integer.valueOf(this.e.mMode), Integer.valueOf(paramInt), paramInterestTagInfo });
    }
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.f = paramNearbyPeopleCard;
    if (this.f == null) {
      return;
    }
    if ((this.e.mMode == 2) || (this.e.mMode == 3)) {
      if (this.f.getIsHostSelf(this.e.app.getCurrentAccountUin())) {
        this.e.mMode = 2;
      } else {
        this.e.mMode = 3;
      }
    }
    paramNearbyPeopleCard = this.as;
    if (paramNearbyPeopleCard != null) {
      paramNearbyPeopleCard.setNearbyPeopleCard(this.f);
    }
    paramNearbyPeopleCard = SharedPreUtils.O(this.e);
    if (!TextUtils.isEmpty(paramNearbyPeopleCard)) {
      try
      {
        this.ag = new JSONObject(paramNearbyPeopleCard).getString("ownerLikeJumpURL");
      }
      catch (JSONException paramNearbyPeopleCard)
      {
        paramNearbyPeopleCard.printStackTrace();
      }
    }
    if (!this.ah) {
      this.ah = true;
    }
    y();
    Object localObject = this.e.app;
    paramNearbyPeopleCard = new StringBuilder();
    paramNearbyPeopleCard.append("");
    paramNearbyPeopleCard.append(this.f.tinyId);
    String str2 = paramNearbyPeopleCard.toString();
    int i1 = this.e.mMode;
    String str1 = "1";
    if (i1 == 2) {
      paramNearbyPeopleCard = "1";
    } else {
      paramNearbyPeopleCard = "2";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.e.from % 20);
    ReportController.b((AppRuntime)localObject, "dc00899", "grp_lbs", str2, "data_card", "exp", 0, 0, paramNearbyPeopleCard, localStringBuilder.toString(), "", "");
    this.L.a(this.f, new NearbyProfileDisplayPanel.13(this));
    this.M.a(this.f);
    if (this.I.getAdapter() == null)
    {
      this.I.setAdapter(new NearbyProfileDisplayPanel.NearbyProfilePagerAdapter(this, this.O, this.N));
      a(this.ab, false);
    }
    if (NearbyProfileCardUtils.a(this.e.from))
    {
      this.V = this.f.isForbidSendMsgForTribar;
      this.W = this.f.isForbidSendGiftMsgForTribar;
      this.X = this.f.disableSendMsgBtnTipsForTribar;
      this.Y = this.f.disableSendGiftBtnTipsForTribar;
    }
    else
    {
      this.U = this.f.maskMsgFlag;
      this.V = this.f.isForbidSendMsg;
      this.W = this.f.isForbidSendGiftMsg;
      this.X = this.f.disableSendMsgBtnTips;
      this.Y = this.f.disableSendGiftBtnTips;
    }
    this.Z = this.f.highScoreNum;
    a(this.f.nearbyInfo);
    L();
    K();
    l();
    A();
    if ((this.e.allinone.profileEntryType == 31) && (!TextUtils.isEmpty(this.e.allinone.aioDistance)) && (!TextUtils.isEmpty(this.f.timeDiff)) && (this.e.mMode != 2))
    {
      paramNearbyPeopleCard = this.aN;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.e.allinone.aioDistance);
      ((StringBuilder)localObject).append(" · ");
      ((StringBuilder)localObject).append(this.f.timeDiff);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131905135));
      paramNearbyPeopleCard.setText(((StringBuilder)localObject).toString());
      this.aN.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotChatDistance", 2, "bindData, use aioDistance");
      }
    }
    else if ((!TextUtils.isEmpty(this.f.aioDistanceAndTime)) && (this.e.mMode != 2))
    {
      paramNearbyPeopleCard = this.aN;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.f.aioDistanceAndTime);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131905119));
      paramNearbyPeopleCard.setText(((StringBuilder)localObject).toString());
      this.aN.setVisibility(0);
    }
    else if ((!TextUtils.isEmpty(this.f.distance)) && (this.e.mMode != 2) && (!TextUtils.isEmpty(this.f.distance)) && (!TextUtils.isEmpty(this.f.timeDiff)))
    {
      paramNearbyPeopleCard = this.aN;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.f.distance);
      ((StringBuilder)localObject).append("·");
      ((StringBuilder)localObject).append(this.f.timeDiff);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131905227));
      paramNearbyPeopleCard.setText(((StringBuilder)localObject).toString());
      this.aN.setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      paramNearbyPeopleCard = new StringBuilder();
      paramNearbyPeopleCard.append("bindData, mCard.videoInfo = ");
      paramNearbyPeopleCard.append(this.f.videoInfo);
      QLog.d("NearbyProfileDisplayPanel", 2, paramNearbyPeopleCard.toString());
    }
    if (this.e.mMode == 3)
    {
      if (((this.f.lUserFlag & 0x800) != 0L) && (this.f.strRemark != null) && (!this.f.strRemark.equals("")))
      {
        paramNearbyPeopleCard = this.f.strRemark.trim();
        break label1035;
      }
      if (this.f.nickname != null)
      {
        paramNearbyPeopleCard = this.f.nickname.trim();
        break label1035;
      }
    }
    else if (this.f.nickname != null)
    {
      paramNearbyPeopleCard = this.f.nickname.trim();
      break label1035;
    }
    paramNearbyPeopleCard = "";
    label1035:
    a(paramNearbyPeopleCard);
    this.e.app.addObserver(this.ao);
    if (this.e.mMode == 3)
    {
      if (this.F)
      {
        this.h.setVisibility(8);
        this.au.setVisibility(0);
        new ReportTask(this.e.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_face_score").e(this.e.allinone.uin).a();
      }
      else
      {
        this.h.setVisibility(0);
        this.au.setVisibility(8);
        m();
      }
    }
    else
    {
      this.h.setVisibility(8);
      this.au.setVisibility(8);
    }
    n();
    if (this.e.mMode == 2) {
      if (v() == x())
      {
        this.P.setVisibility(8);
      }
      else
      {
        this.P.setVisibility(0);
        localObject = new ReportTask(this.e.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_pub").e(String.valueOf(this.f.tinyId));
        if (this.e.mMode == 2) {
          paramNearbyPeopleCard = "1";
        } else {
          paramNearbyPeopleCard = "2";
        }
        ((ReportTask)localObject).a(new String[] { paramNearbyPeopleCard }).a();
      }
    }
    if (v() == 1)
    {
      localObject = new ReportTask(this.e.app).a("dc00899").b("grp_lbs").c("data_card").d("feedtab_exp").e(String.valueOf(this.f.tinyId));
      if (this.e.mMode == 2) {
        paramNearbyPeopleCard = str1;
      } else {
        paramNearbyPeopleCard = "2";
      }
      ((ReportTask)localObject).a(new String[] { paramNearbyPeopleCard }).a();
    }
    z();
  }
  
  public void a(PicInfo paramPicInfo, RelativeLayout paramRelativeLayout)
  {
    CustomImgView localCustomImgView = (CustomImgView)paramRelativeLayout.getChildAt(0);
    paramRelativeLayout = (ImageView)paramRelativeLayout.getChildAt(1);
    Drawable localDrawable = this.e.getResources().getDrawable(2130853313);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.e.bigImageWidth;
    localURLDrawableOptions.mRequestHeight = this.e.bigImageWidth;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mUseMemoryCache = false;
    if (!TextUtils.isEmpty(paramPicInfo.b)) {
      localCustomImgView.setImageDrawable(URLDrawable.getDrawable(paramPicInfo.b, localURLDrawableOptions));
    }
    paramRelativeLayout.setVisibility(0);
  }
  
  protected void a(ActionSheet paramActionSheet, View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.f.nowUserType == 1)
      {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new NearbyProfileDisplayPanel.18(this), 500L);
        paramActionSheet.dismiss();
        return;
      }
      this.r = true;
      Object localObject1 = this.e.allinone.uin;
      paramView = (View)localObject1;
      Object localObject2;
      if (StringUtil.isEmpty((String)localObject1))
      {
        localObject2 = this.f;
        paramView = (View)localObject1;
        if (localObject2 != null) {
          paramView = ((NearbyPeopleCard)localObject2).uin;
        }
      }
      if (StringUtil.isEmpty(paramView)) {
        paramView = "0";
      }
      long l1;
      if (this.e.mTinyId == 0L)
      {
        localObject1 = this.f;
        if (localObject1 != null) {
          l1 = ((NearbyPeopleCard)localObject1).tinyId;
        } else {
          l1 = 0L;
        }
      }
      else
      {
        l1 = this.e.mTinyId;
      }
      if ((!"0".equals(paramView)) || (l1 != 0L))
      {
        if (this.e.app != null) {
          localObject1 = this.e.app.getHotChatMng(false);
        } else {
          localObject1 = null;
        }
        if (((localObject1 == null) || (!((HotChatManager)localObject1).b(this.e.allinone.troopUin))) && (this.e.allinone.profileEntryType != 33) && (this.e.allinone.profileEntryType != 4) && (this.e.allinone.profileEntryType != 31))
        {
          localObject1 = null;
          paramInt = 20003;
        }
        else
        {
          localObject1 = this.e.allinone.troopUin;
          paramInt = 20012;
        }
        localObject2 = this.e;
        NewReportPlugin.a((QBaseActivity)localObject2, ((NearbyPeopleProfileActivity)localObject2).mTinyId, paramView, (String)localObject1, paramInt, "", this.e.allinone.reportExtra);
      }
      ReportController.b(this.e.app, "CliOper", "", "", "0X8004828", "0X8004828", 0, 0, "", "", "", "");
      paramView = this.f;
      if ((paramView != null) && (paramView.iIsGodFlag == 1)) {
        if (this.f.gender == 0) {
          ReportController.b(this.e.app, "CliOper", "", "", "0X800528E", "0X800528E", 0, 0, "", "", "", "");
        } else if (this.f.gender == 1) {
          ReportController.b(this.e.app, "CliOper", "", "", "0X800528F", "0X800528F", 0, 0, "", "", "", "");
        }
      }
      ReportController.b(this.e.app, "dc00899", "grp_lbs", M(), "data_card", "clk_report", 0, 0, "", "", "", "");
      if (ProfileEntryUtils.isFromHotChat(this.e.allinone.profileEntryType)) {
        ReportController.b(this.e.app, "CliOper", "", "", "0X800523E", "0X800523E", 0, 0, "", "", "", "");
      }
    }
    if (paramActionSheet != null) {
      paramActionSheet.dismiss();
    }
  }
  
  protected void a(@NonNull String paramString)
  {
    ((TextView)this.aI.findViewById(2131449009)).setText(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (!NetworkUtil.isNetSupport(this.e))
    {
      QQToast.makeText(this.e, 2131889169, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    QQToast.makeText(this.e, 0, HardCodeUtil.a(2131905177), 0).show();
    Bundle localBundle = new Bundle();
    localBundle.putString("_filename_from_dlg", paramString2);
    localBundle.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_hdsp_nearby");
    ((IUniformDownloadMgr)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IUniformDownloadMgr.class, "")).startDownload(paramString1, localBundle, new NearbyProfileDisplayPanel.43(this, paramString3));
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDownloadVideoHeadFinish, url = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("NearbyProfileDisplayPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      paramString = (View)this.d.get(paramString);
      if (paramString != null) {
        if ((paramString instanceof RelativeLayout))
        {
          paramString = (RelativeLayout)paramString;
          localObject = (AvatarWallPagerAdapter.ViewHolder)paramString.getTag(2131446791);
          if ((localObject != null) && (((AvatarWallPagerAdapter.ViewHolder)localObject).a != null))
          {
            a((PicInfo)((AvatarWallPagerAdapter.ViewHolder)localObject).a, paramString);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.e("NearbyProfileDisplayPanel", 2, "onDownloadVideoHeadFinish went error .., holder is null or holder.data is null");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("NearbyProfileDisplayPanel", 2, "onDownloadVideoHeadFinish went error .., view is not a instance of RelativeLayout");
        }
      }
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList)
  {
    ProfileBusiEntry localProfileBusiEntry;
    if ((paramBoolean) && (paramList != null) && (paramList.size() != 0) && (paramInt == 0))
    {
      paramList = (ShowExternalTroop)paramList.get(0);
      this.ai = paramList.troopUin;
      this.aj = new ProfileBusiEntry();
      localProfileBusiEntry = this.aj;
      localProfileBusiEntry.nBusiEntryType = 1024;
      localProfileBusiEntry.strTitle = this.e.getResources().getString(2131893930);
      this.aj.strContent = paramList.troopName;
      this.aj.strLogoUrl = paramList.strFaceUrl;
      if ((this.f != null) && (this.aj.strContent != null))
      {
        this.f.addOrUpdateBuisEntry(this.aj);
        if (this.e.mMode == 2)
        {
          ReportController.b(this.e.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.ai, "1", "", "");
          return;
        }
        ReportController.b(this.e.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.ai, "0", "", "");
      }
      return;
    }
    paramList = this.f;
    if (paramList != null)
    {
      localProfileBusiEntry = this.aj;
      if (localProfileBusiEntry != null) {
        paramList.removeBuisEntry(localProfileBusiEntry);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!TextUtils.isEmpty(this.e.allinone.uin))
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = "https://gamecenter.qq.com/gamecenter/index/recent_play.html";
      }
      paramString = new Intent(this.e, GameCenterActivity.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("plat=qq&tt=1&_wv=3&qappid=");
      localStringBuilder.append(AppSetting.d());
      localStringBuilder.append("&osv=");
      localStringBuilder.append(Build.VERSION.RELEASE);
      localStringBuilder.append("&vuin=");
      localStringBuilder.append(NearbyURLSafeUtil.b(this.e.allinone.uin));
      localStringBuilder.append("&vname=");
      localStringBuilder.append(this.e.allinone.nickname);
      localStringBuilder.append("&bn=");
      localStringBuilder.append(paramBoolean);
      paramString.putExtra("url", HtmlOffline.a(str, localStringBuilder.toString()));
      paramString.putExtra("big_brother_source_key", "biz_src_zf_games");
      this.e.startActivity(paramString);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject = new nearby.Cmd0x1RspBody();
    try
    {
      ((nearby.Cmd0x1RspBody)localObject).mergeFrom(paramArrayOfByte);
      this.af = ((nearby.Cmd0x1RspBody)localObject).bytes_qunlist_url.get().toStringUtf8();
      this.aP = ((nearby.Cmd0x1RspBody)localObject).bytes_chat_sig.get().toByteArray();
      this.e.app.getMsgCache().h(this.f.uin, this.aP);
      this.T = ((nearby.Cmd0x1RspBody)localObject).bool_follow.get();
      this.U = ((nearby.Cmd0x1RspBody)localObject).uint32_if_mask_msg.get();
      int i1 = ((nearby.Cmd0x1RspBody)localObject).uint32_if_mask_msg.get();
      boolean bool2 = true;
      boolean bool1;
      if (i1 == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.V = bool1;
      if (((nearby.Cmd0x1RspBody)localObject).uint32_if_mask_gift.get() == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      this.W = bool1;
      if (((nearby.Cmd0x1RspBody)localObject).bytes_mask_msg_reason.has()) {
        this.X = ((nearby.Cmd0x1RspBody)localObject).bytes_mask_msg_reason.get().toStringUtf8();
      }
      if (((nearby.Cmd0x1RspBody)localObject).bytes_mask_gift_reason.has()) {
        this.Y = ((nearby.Cmd0x1RspBody)localObject).bytes_mask_gift_reason.get().toStringUtf8();
      }
      localObject = (nearby.FansInfo)((nearby.Cmd0x1RspBody)localObject).FansInfo_fans.get();
      i1 = ((nearby.FansInfo)localObject).uint32_follows_num.get();
      int i2 = ((nearby.FansInfo)localObject).uint32_fans_num.get();
      paramArrayOfByte = ((nearby.FansInfo)localObject).bytes_follows_url.get().toStringUtf8();
      localObject = ((nearby.FansInfo)localObject).bytes_fans_url.get().toStringUtf8();
      this.ar.findViewById(2131433516).setVisibility(0);
      b(i2, i1);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNearByInfo, followsNum=");
        localStringBuilder.append(i1);
        localStringBuilder.append(", fansNum=");
        localStringBuilder.append(i2);
        QLog.d("NearbyProfileDisplayPanel", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(paramArrayOfByte)) {
        this.l.setOnClickListener(new NearbyProfileDisplayPanel.7(this, paramArrayOfByte));
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.m.setOnClickListener(new NearbyProfileDisplayPanel.8(this, (String)localObject));
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Cmd0x1RspBody error !:");
        ((StringBuilder)localObject).append(paramArrayOfByte);
        QLog.w("NearbyProfileDisplayPanel", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected int b()
  {
    return 2131627569;
  }
  
  protected int b(int paramInt)
  {
    return NearbyProfileUtil.d(paramInt);
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    TextView localTextView = this.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131899712));
    localStringBuilder.append(paramInt2);
    localTextView.setText(localStringBuilder.toString());
    localTextView = this.m;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131905136));
    localStringBuilder.append(paramInt1);
    localTextView.setText(localStringBuilder.toString());
  }
  
  public void b(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.f.vGiftInfo = paramNearbyPeopleCard.vGiftInfo;
  }
  
  protected Pair<String, String> c(int paramInt)
  {
    String str;
    if (paramInt == 1) {
      str = "#ffffafea";
    } else {
      str = "#ff96beff";
    }
    return new Pair(str, "#FFFFFFFF");
  }
  
  public void c()
  {
    DownloadApi.a(this.aW);
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    int i1;
    Object localObject2;
    if (paramInt2 != 8)
    {
      if (paramInt2 != 20)
      {
        if (paramInt2 != 40)
        {
          if (paramInt2 != 60)
          {
            switch (paramInt2)
            {
            default: 
              i1 = 0;
              break;
            case 38: 
              i1 = 2131892094;
              break;
            case 37: 
              i1 = 2131897209;
              break;
            case 36: 
              i1 = 2131896704;
              ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_gift", 0, 0, "", "", "", "");
              break;
            }
          }
          else
          {
            if (this.T) {
              i1 = 2131894140;
            } else {
              i1 = 2131894138;
            }
            localObject2 = M();
            if (this.T) {
              localObject1 = "exp_followed";
            } else {
              localObject1 = "exp_follow";
            }
            ReportController.b(null, "dc00899", "grp_lbs", (String)localObject2, "data_card", (String)localObject1, 0, 0, "", "", "", "");
          }
        }
        else {
          i1 = 2131896715;
        }
      }
      else {
        i1 = 2131890851;
      }
    }
    else
    {
      i1 = 2131916257;
      localObject1 = (Button)this.h.getChildAt(paramInt1).findViewById(2131448897);
      ((Button)localObject1).setTextColor(this.e.getResources().getColor(2131168041));
      ((Button)localObject1).setBackgroundDrawable(this.e.getResources().getDrawable(2130847156));
      ReportController.b(null, "dc00899", "grp_lbs", M(), "data_card", "exp_msg", 0, 0, "", "", "", "");
    }
    if (i1 == 0)
    {
      this.h.setVisibility(8);
      return;
    }
    Object localObject1 = this.h.getChildAt(paramInt1);
    ((View)localObject1).setVisibility(0);
    if (paramInt2 != 40)
    {
      localObject2 = (Button)((View)localObject1).findViewById(2131448897);
      ((Button)localObject2).setText(i1);
      if (paramInt2 == 38)
      {
        ((Button)localObject2).setBackgroundResource(2130852171);
        ((Button)localObject2).setTextColor(this.e.getResources().getColor(2131165935));
      }
      ((Button)localObject2).setOnClickListener(this);
      DataTag localDataTag = new DataTag(paramInt2, null);
      ((Button)localObject2).setTag(localDataTag);
      ((View)localObject1).setTag(localDataTag);
      if ((paramInt2 == 60) && (this.T))
      {
        ((Button)localObject2).setTextColor(this.e.getResources().getColor(2131168043));
        ((Button)localObject2).setBackgroundDrawable(this.e.getResources().getDrawable(2130839499));
        return;
      }
      if ((paramInt2 == 8) && (this.U != 0) && (!this.e.isFriend))
      {
        ((Button)localObject2).setBackgroundResource(2130852171);
        ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
      if ((paramInt2 == 36) && (this.W) && (!this.e.isFriend))
      {
        ((Button)localObject2).setBackgroundResource(2130852171);
        ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
      }
    }
    else
    {
      ((View)localObject1).setVisibility(8);
    }
  }
  
  void c(boolean paramBoolean)
  {
    Object localObject = this.f;
    if ((localObject != null) && (((NearbyPeopleCard)localObject).shouldShowLikeBtn()))
    {
      this.as.setHeartLayout(this.at);
      boolean bool1;
      if (this.e.mMode == 2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject = this.as;
      boolean bool2;
      if (this.f.bVoted != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      ((NearbyCardVoteView)localObject).a(bool1, bool2, this.f.likeCount, this.f.likeCountInc, null, true, paramBoolean, this.f.praiseList);
      this.as.setOnClickListener(this);
      if (QSecFramework.c().a(1001).booleanValue())
      {
        localObject = this.as;
        QSecFramework.c().a(5, 0, 1, new Object[] { Integer.valueOf(41), localObject }, null);
      }
    }
    else
    {
      this.as.setVisibility(8);
    }
    if (this.aM != null) {
      this.as.j = false;
    }
  }
  
  public void d()
  {
    Object localObject = this.x;
    if (localObject != null) {
      ((ProfileQiqiLiveController)localObject).a(10);
    }
    DownloadApi.b(this.aW);
    this.ap.removeMessages(1);
    this.ap.removeMessages(2);
    this.ap.removeMessages(3);
    this.ap.removeMessages(4);
    this.ap.removeMessages(5);
    this.ap.removeMessages(6);
    this.ap.removeCallbacksAndMessages(null);
    localObject = this.f;
    if ((localObject != null) && (((NearbyPeopleCard)localObject).uRoomid != 0L)) {
      ReportController.b(this.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "content_timer", 0, 0, String.valueOf(this.f.tinyId), "", "yes", "android");
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.e.isFriend) {
      this.D.incrementAndGet();
    } else if (paramBoolean) {
      this.G.incrementAndGet();
    } else {
      this.H.incrementAndGet();
    }
    Object localObject = this.f;
    ((NearbyPeopleCard)localObject).likeCount += 1;
    localObject = this.f;
    ((NearbyPeopleCard)localObject).bAvailVoteCnt = ((short)(((NearbyPeopleCard)localObject).bAvailVoteCnt - 1));
    this.f.bVoted = 1;
    if (!this.C.hasMessages(1))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      this.C.sendMessageDelayed((Message)localObject, 2000L);
    }
    this.e.mHasEverVote = true;
    c(paramBoolean);
    if (QSecFramework.c().a(1001).booleanValue()) {
      QSecFramework.c().a(5, 0, 2, new Object[] { Integer.valueOf(41), Integer.valueOf(1), Integer.valueOf(6), "vote", null }, null);
    }
  }
  
  public int e()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void e(boolean paramBoolean)
  {
    if ((this.W) && (!this.e.isFriend))
    {
      if (!TextUtils.isEmpty(this.Y)) {
        QQToast.makeText(this.e, this.Y, 0).show(this.e.getTitleBarHeight());
      }
      return;
    }
    this.o = true;
    NearbyPeopleProfileActivity.testGiftCount += 1;
    String str = this.e.allinone.uin;
    Object localObject2 = Utils.b(W());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    if (Friends.isValidUin(str))
    {
      localObject2 = NearbyURLSafeUtil.b(str);
      str = ((String)localObject1).toLowerCase();
      if (U() == 10002) {
        i1 = 6;
      } else {
        i1 = 1;
      }
      if (paramBoolean) {
        localObject1 = "near.card.like";
      } else {
        localObject1 = "near.card.s";
      }
      localObject1 = String.format("https://imgcache.qq.com/club/client/flower/release/html/index.html?strangerUin=%s&sign=%s&sourceType=%d&ADTAG=%s&groupCode=%s&_wv=2147347&_bid=2050", new Object[] { localObject2, str, Integer.valueOf(i1), localObject1, "" });
      localObject2 = new Intent(this.e, QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("portraitOnly", true);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      this.e.startActivity((Intent)localObject2);
      int i1 = NearbyProfileUtil.i(this.e.allinone.profileEntryType);
      if (NearbyProfileCardUtils.a(this.e.from)) {
        i1 = 6;
      }
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_gift", 0, 0, "", "", "", "");
      ReportController.b(this.e.app, "CliOper", "", "", "0X80052BA", "0X80052BA", i1, 0, "", "", "", "");
      return;
    }
    localObject1 = this.e;
    ((NearbyPeopleProfileActivity)localObject1).showToast(((NearbyPeopleProfileActivity)localObject1).getString(2131891025));
  }
  
  public boolean f()
  {
    NewVoteAnimHelper localNewVoteAnimHelper = this.aM;
    if (localNewVoteAnimHelper != null) {
      return localNewVoteAnimHelper.e;
    }
    return false;
  }
  
  public void g()
  {
    NearbyCardVoteView localNearbyCardVoteView = this.as;
    if (localNearbyCardVoteView != null) {
      localNearbyCardVoteView.a(true);
    }
  }
  
  public void h()
  {
    NearbyMomentFragment localNearbyMomentFragment = this.L;
    if (localNearbyMomentFragment != null) {
      localNearbyMomentFragment.e();
    }
    if (this.aR) {
      ThreadManagerV2.excute(new NearbyProfileDisplayPanel.38(this), 16, null, false);
    }
  }
  
  public void i()
  {
    if (this.aR) {
      ThreadManagerV2.excute(new NearbyProfileDisplayPanel.39(this), 16, null, false);
    }
  }
  
  public void j()
  {
    Object localObject = this.aM;
    if (localObject != null) {
      ((NewVoteAnimHelper)localObject).d();
    }
    localObject = this.as;
    if (localObject != null) {
      ((NearbyCardVoteView)localObject).a(false);
    }
    if (this.C.hasMessages(1))
    {
      this.C.removeMessages(1);
      X();
    }
  }
  
  public void k()
  {
    if (((NearbyProxy)NearbyManagerHelper.a(this.e.app)).g() != null) {
      ((NearbyProxy)NearbyManagerHelper.a(this.e.app)).g().clear();
    }
    this.e.app.removeObserver(this.ao);
    this.aQ.setDecodeTaskCompletionListener(null);
    this.aQ.destory();
  }
  
  public void l()
  {
    Object localObject = this.f;
    if ((localObject != null) && (((NearbyPeopleCard)localObject).shouldShowLikeBtn()) && (!this.F))
    {
      this.as.setHeartLayout(this.at);
      int i1 = this.e.mMode;
      this.as.setOnClickListener(this);
      if (QSecFramework.c().a(1001).booleanValue())
      {
        localObject = this.as;
        QSecFramework.c().a(5, 0, 1, new Object[] { Integer.valueOf(41), localObject }, null);
      }
    }
    else
    {
      this.as.setVisibility(8);
    }
    if (this.aM != null) {
      this.as.j = false;
    }
  }
  
  public void m()
  {
    DatingUtil.c(this.e.getClass().getSimpleName(), new Object[] { "card godflag is `", Boolean.valueOf(this.f.godFlag), " sayhello flag is ", Integer.valueOf(this.f.sayHelloFlag) });
    if ((this.f.lUserFlag & 0x800) != 0L)
    {
      this.h.getChildAt(0).setVisibility(8);
      this.h.getChildAt(1).setVisibility(8);
      if (!this.E) {
        c(2, 8);
      } else {
        this.h.setVisibility(8);
      }
    }
    else
    {
      this.h.getChildAt(0).setVisibility(8);
      if ((this.e.allinone.pa == 75) && (this.e.allinone.chatCookie == null) && (!I())) {
        this.h.getChildAt(2).setVisibility(8);
      } else if ((this.f.shouldShowSendMsg()) && (!this.E)) {
        c(2, 8);
      } else {
        this.h.getChildAt(2).setVisibility(8);
      }
      c(1, 60);
    }
    if (!H()) {
      return;
    }
    Button localButton;
    if ((!this.T) && (this.h.getChildAt(2).getVisibility() != 0))
    {
      localButton = (Button)this.h.getChildAt(1).findViewById(2131448897);
      localButton.setTextColor(this.e.getResources().getColor(2131168041));
      localButton.setBackgroundDrawable(this.e.getResources().getDrawable(2130847156));
    }
    else
    {
      ((Button)this.h.getChildAt(1).findViewById(2131448897)).setBackgroundDrawable(this.e.getResources().getDrawable(2130847157));
    }
    if ((this.h.getChildAt(1).getVisibility() != 0) && (this.h.getChildAt(2).getVisibility() != 0))
    {
      localButton = (Button)this.h.getChildAt(0).findViewById(2131448897);
      localButton.setTextColor(this.e.getResources().getColor(2131168041));
      localButton.setBackgroundDrawable(this.e.getResources().getDrawable(2130847156));
    }
  }
  
  public void n()
  {
    this.k = new ArrayList();
    if (this.e.mHasNewPhoto)
    {
      this.k = this.e.mPicInfo;
    }
    else
    {
      PicInfo localPicInfo;
      if (!TextUtils.isEmpty(this.f.bVideoHeadUrl))
      {
        localPicInfo = new PicInfo();
        localPicInfo.e = this.f.bVideoHeadUrl;
        this.k.add(localPicInfo);
      }
      else
      {
        localPicInfo = new PicInfo();
        localPicInfo.h = "type_qq_head_pic";
        this.k.add(localPicInfo);
      }
    }
    if ((this.e.mPicInfo != null) && (this.e.mPicInfo.size() > 0)) {
      b(((PicInfo)this.e.mPicInfo.get(0)).b);
    }
    E();
  }
  
  public void o()
  {
    if (((this.e.mHeadSize == 640) || (this.e.mHeadSize == 0)) && (!TextUtils.isEmpty(this.e.mGetHeadUrl)) && (!this.e.mHasNewPhoto)) {
      this.e.downloadHDAvatar(String.valueOf(this.f.tinyId), this.e.mHeadSize, this.e.mGetHeadUrl, false);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = paramView.getTag();
    int i1 = 4;
    Object localObject1 = "";
    int i4 = 0;
    boolean bool = false;
    int i3 = 2;
    int i2;
    if ((localObject2 != null) && ((localObject2 instanceof DataTag)))
    {
      ReportController.b(this.e.app, "CliOper", "", "", "0X800482E", "0X800482E", 0, 0, "", "", "", "");
      paramView = (DataTag)localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("click  data.nType= [");
        ((StringBuilder)localObject2).append(paramView.a);
        ((StringBuilder)localObject2).append("]");
        QLog.i("NearbyProfileDisplayPanel", 2, ((StringBuilder)localObject2).toString());
      }
      i2 = paramView.a;
      if (i2 != 8) {
        if (i2 != 30) {
          if (i2 != 33) {
            if (i2 != 42) {
              if (i2 != 58) {
                if (i2 != 60) {
                  if ((i2 != 27) && (i2 != 28)) {
                    if (i2 != 36) {
                      if (i2 != 37) {
                        if (i2 != 39) {
                          if (i2 != 40) {
                            switch (i2)
                            {
                            default: 
                              return;
                            case 22: 
                              if ((paramView.b instanceof ProfileBusiEntry))
                              {
                                paramView = (ProfileBusiEntry)paramView.b;
                                if (!StringUtil.isEmpty(paramView.strJumpUrl)) {
                                  d(paramView.strJumpUrl);
                                }
                              }
                              ReportController.b(this.e.app, "CliOper", "", "", "0X80050CB", "0X80050CB ", ProfileEntryUtils.getProfileEntryType(this.e.allinone.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.e.allinone)), "", "", "");
                              return;
                            case 21: 
                              if ((paramView.b instanceof ProfileBusiEntry))
                              {
                                paramView = (ProfileBusiEntry)paramView.b;
                                if (!StringUtil.isEmpty(paramView.strJumpUrl))
                                {
                                  localObject2 = new Intent(this.e, QQBrowserActivity.class);
                                  ((Intent)localObject2).putExtra("portraitOnly", true);
                                  if (StringUtil.isEmpty(paramView.strJumpUrl)) {
                                    paramView = (View)localObject1;
                                  } else {
                                    paramView = paramView.strJumpUrl;
                                  }
                                  ((Intent)localObject2).putExtra("url", paramView);
                                }
                              }
                              break;
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    try
    {
      this.e.startActivity((Intent)localObject2);
      label424:
      ReportController.b(this.e.app, "CliOper", "", "", "0X80050CC", "0X80050CC", ProfileEntryUtils.getProfileEntryType(this.e.allinone.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.e.allinone)), "", "", "");
      return;
      if (this.e.isFriend)
      {
        paramView = this.f;
        if ((paramView != null) && (!TextUtils.isEmpty(paramView.uin)))
        {
          paramView = this.f.uin;
          localObject1 = this.f.nickname;
          ChatActivityUtils.a(this.e.app, this.e, 0, paramView, (String)localObject1, null, true, null, true, true, null, "from_internal");
          return;
        }
      }
      Object localObject3;
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("mCard == null , or mCard.uin is Empty, ");
        paramView.append(this.e.isFriend);
        QLog.i("Q.nearby_people_card.", 2, paramView.toString());
        return;
        if ((paramView.b instanceof Object[]))
        {
          paramView = (Object[])paramView.b;
          a(((Boolean)paramView[0]).booleanValue(), (String)paramView[1]);
        }
        ReportController.b(this.e.app, "CliOper", "", "", "0X80050CA", "0X80050CA ", ProfileEntryUtils.getProfileEntryType(this.e.allinone.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.e.allinone)), "", "", "");
        return;
        if (this.x != null)
        {
          if (this.f == null) {
            return;
          }
          if (!NetworkUtil.isNetSupport(this.e))
          {
            QQToast.makeText(this.e, 2131889169, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
            return;
          }
          if (PackageUtil.a(this.e, "com.guagua.qiqi"))
          {
            this.x.a(this.f.uRoomid);
            ReportController.b(this.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "click_bootstrap", 0, 0, String.valueOf(this.f.tinyId), "", "yes", "android");
            return;
          }
          if (this.z == 1)
          {
            paramView = this.y;
            if (paramView != null) {
              paramView.setText(2131897193);
            }
            this.x.a(3);
            this.z = 2;
            ReportController.b(this.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_pause", 0, 0, String.valueOf(this.f.tinyId), "", "yes", "android");
            return;
          }
          if (NetworkUtil.isWifiConnected(this.e))
          {
            if (this.A)
            {
              paramView = this.e;
              DialogUtil.a(paramView, 230, paramView.getString(2131896712), this.e.getString(2131896711), 0, 2131897194, new NearbyProfileDisplayPanel.19(this), null).show();
              this.A = false;
              ReportController.b(this.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_trigger", 0, 0, String.valueOf(this.f.tinyId), "", "yes", "android");
            }
            else
            {
              ReportController.b(this.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_goon", 0, 0, String.valueOf(this.f.tinyId), "", "yes", "android");
            }
            this.x.a(2);
            i1 = this.z;
            if ((i1 == 2) || (i1 == 0)) {
              this.z = 1;
            }
          }
          else
          {
            i1 = this.z;
            if ((i1 != 2) && (i1 != 0))
            {
              this.x.a(2);
              return;
            }
            paramView = this.e;
            localObject1 = paramView.getString(2131896712);
            localObject2 = this.e.getString(2131896710);
            localObject3 = this.aq;
            DialogUtil.a(paramView, 230, (String)localObject1, (String)localObject2, (DialogInterface.OnClickListener)localObject3, (DialogInterface.OnClickListener)localObject3).show();
            this.z = 1;
          }
        }
        else
        {
          return;
          if ((paramView.b instanceof ProfileBusiEntry))
          {
            ReportController.b(this.e.app, "CliOper", "", "", "0X80055CA", "0X80055CA", 0, 0, "", "", "", "");
            paramView = (ProfileBusiEntry)paramView.b;
            localObject1 = new Intent(this.e, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("url", paramView.strJumpUrl);
            ((Intent)localObject1).putExtra("hide_operation_bar", true);
            ((Intent)localObject1).putExtra("hide_more_button", true);
            this.e.startActivity((Intent)localObject1);
            return;
            if (this.e.waitingForSayhelloLimit)
            {
              DatingUtil.c("nearbyprofilecard", new Object[] { "have click sayhello, wating for resp" });
              return;
            }
            paramView = (INearbyCardHandler)this.e.app.getBusinessHandler(BusinessHandlerFactory.NEARBY_CARD_HANDLER);
            if (paramView != null)
            {
              localObject1 = this.e;
              ((NearbyPeopleProfileActivity)localObject1).waitingForSayhelloLimit = true;
              if ((((NearbyPeopleProfileActivity)localObject1).allinone.profileEntryType == 17) || (this.e.allinone.profileEntryType == 18) || (this.e.allinone.profileEntryType == 19)) {
                i1 = 8;
              }
              i2 = i1;
              if (this.f.iIsGodFlag == 1)
              {
                i2 = i3;
                if (this.f.gender == 0) {
                  i2 = 1;
                }
                i2 = i1 | i2;
              }
              paramView.a(this.f.tinyId, i2, this.e.allinone.chatCookie);
              if (this.e.mHandler != null)
              {
                this.e.mHandler.sendEmptyMessageDelayed(204, 1000L);
                return;
                e(false);
                if (this.e.app != null)
                {
                  if ((this.f.iIsGodFlag == 1) && (this.f.gender == 0))
                  {
                    ReportController.b(this.e.app, "CliOper", "", "", "0X800528A", "0X800528A", 0, 0, "", "", "", "");
                    return;
                  }
                  if ((this.f.iIsGodFlag == 1) && (this.f.gender == 1))
                  {
                    ReportController.b(this.e.app, "CliOper", "", "", "0X800528B", "0X800528B", 0, 0, "", "", "", "");
                    return;
                    if ((paramView.b instanceof ProfileBusiEntry))
                    {
                      localObject1 = (ProfileBusiEntry)paramView.b;
                      if (!StringUtil.isEmpty(((ProfileBusiEntry)localObject1).strJumpUrl))
                      {
                        localObject2 = new Intent(this.e, QQBrowserActivity.class);
                        ((Intent)localObject2).putExtra("url", ((ProfileBusiEntry)localObject1).strJumpUrl);
                        ((Intent)localObject2).putExtra("hide_operation_bar", true);
                        ((Intent)localObject2).putExtra("hide_more_button", true);
                        this.e.startActivity((Intent)localObject2);
                      }
                    }
                    if (28 == paramView.a)
                    {
                      ReportController.b(this.e.app, "CliOper", "", "", "0X80050CD", "0X80050CD", ProfileEntryUtils.getProfileEntryType(this.e.allinone.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.e.allinone)), "", "", "");
                      return;
                      localObject1 = M();
                      if (this.T) {
                        paramView = "clk_followed";
                      } else {
                        paramView = "clk_follow";
                      }
                      ReportController.b(null, "dc00899", "grp_lbs", (String)localObject1, "data_card", paramView, 0, 0, "", "", "", "");
                      if (!NearbyUtils.a(this.e))
                      {
                        paramView = this.e;
                        QQToast.makeText(paramView, 0, paramView.getResources().getString(2131892102), 0).show();
                        return;
                      }
                      ((INearbyCardManager)this.e.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).f().put(String.valueOf(this.f.tinyId), Integer.valueOf(1));
                      if (this.f.nowUserType == 1)
                      {
                        S();
                        return;
                      }
                      R();
                      return;
                      if ((paramView.b instanceof ProfileBusiEntry))
                      {
                        VipUtils.a(this.e.app, "CliOper", "0X8006E05", "0X8006E05", 1, 0, new String[0]);
                        paramView = (ProfileBusiEntry)paramView.b;
                        localObject1 = new Intent(this.e, QQBrowserActivity.class);
                        ((Intent)localObject1).putExtra("url", paramView.strJumpUrl);
                        ((Intent)localObject1).putExtra("hide_operation_bar", true);
                        ((Intent)localObject1).putExtra("hide_more_button", true);
                        this.e.startActivity((Intent)localObject1);
                        return;
                        if ((paramView.b instanceof ProfileBusiEntry))
                        {
                          ReportController.b(this.e.app, "CliOper", "", "", "0X8005D14", "0X8005D14", 0, 0, "", "", "", "");
                          paramView = (ProfileBusiEntry)paramView.b;
                          localObject1 = new Intent(this.e, QQBrowserActivity.class);
                          ((Intent)localObject1).putExtra("url", paramView.strJumpUrl);
                          ((Intent)localObject1).putExtra("hide_operation_bar", true);
                          ((Intent)localObject1).putExtra("hide_more_button", true);
                          this.e.startActivity((Intent)localObject1);
                          return;
                          if ((paramView.b instanceof ProfileBusiEntry))
                          {
                            paramView = (ProfileBusiEntry)paramView.b;
                            localObject1 = new Intent(this.e, QQBrowserActivity.class);
                            localObject2 = new StringBuilder();
                            ((StringBuilder)localObject2).append(paramView.strJumpUrl);
                            ((StringBuilder)localObject2).append("&_webviewtype=1");
                            ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject2).toString());
                            ((Intent)localObject1).putExtra("hide_operation_bar", true);
                            ((Intent)localObject1).putExtra("hide_more_button", true);
                            this.e.startActivity((Intent)localObject1);
                            ReportController.b(this.e.app, "CliOper", "", "", "0X8005102", "0X8005102", 0, 0, "", "", "", "");
                            return;
                            if ((paramView.b instanceof ProfileBusiEntry))
                            {
                              paramView = new Intent(this.e, ShowExternalTroopListActivity.class);
                              if (this.e.allinone.pa == 0) {
                                bool = true;
                              }
                              paramView.putExtra("isHost", bool);
                              paramView.putExtra("dest_uin_str", this.e.allinone.uin);
                              this.e.startActivity(paramView);
                              if (this.e.mMode == 2)
                              {
                                ReportController.b(this.e.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.ai, "1", "", "");
                                return;
                              }
                              if (this.e.mMode == 3)
                              {
                                ReportController.b(this.e.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.ai, "0", "", "");
                                return;
                                if (O()) {
                                  NearbyProfileReportKt.d(this.e);
                                }
                                if (this.f != null)
                                {
                                  if (QLog.isColorLevel())
                                  {
                                    paramView = new StringBuilder();
                                    paramView.append("sendMsgBtnClick, isSendMsgBtnDownloadAppOpen=");
                                    paramView.append(this.f.isSendMsgBtnDownloadAppOpen);
                                    paramView.append(", sendMsgBtnDownloadAppTips:");
                                    paramView.append(this.f.sendMsgBtnDownloadAppTips);
                                    paramView.append(", tribeAppDownloadPageUrl=");
                                    paramView.append(this.f.tribeAppDownloadPageUrl);
                                    QLog.d("Q.nearby.tribeAppDownload", 2, paramView.toString());
                                  }
                                }
                                else {
                                  QLog.w("NearbyProfileDisplayPanel", 1, "onClick DATA_TYPE_CHAT mcard == null!");
                                }
                                if (!this.e.isFriend)
                                {
                                  i1 = this.U;
                                  if (i1 != 0)
                                  {
                                    if ((i1 != 4) && (i1 != 5))
                                    {
                                      if (i1 == 3)
                                      {
                                        if (this.f == null)
                                        {
                                          QLog.i("NearbyProfileDisplayPanel", 1, "mMaskMsgFlag == STATE_WX, mCard == null");
                                          return;
                                        }
                                        Q();
                                        return;
                                      }
                                      if (i1 == 2)
                                      {
                                        P();
                                        return;
                                      }
                                      if (i1 == 1) {
                                        N();
                                      }
                                    }
                                    else
                                    {
                                      if ((this.f == null) || (!Y())) {
                                        break label2648;
                                      }
                                      G();
                                    }
                                    return;
                                    label2648:
                                    QLog.i("NearbyProfileDisplayPanel", 1, "mMaskMsgFlag == STATE_VERIFY, mCard == null");
                                    return;
                                  }
                                }
                                if (Y()) {
                                  Z();
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      return;
      if (paramView == this.as)
      {
        if (2 == this.e.mMode)
        {
          ReportController.b(this.e.app, "dc00899", "grp_lbs", "", "data_card", "clk_list", 0, 0, "", "", "", "");
          if (TextUtils.isEmpty(this.ag))
          {
            paramView = new Intent(this.e, VisitorsActivity.class);
            localObject1 = this.f;
            if (localObject1 == null) {
              i1 = 0;
            } else {
              i1 = ((NearbyPeopleCard)localObject1).likeCount;
            }
            localObject1 = new Bundle();
            ((Bundle)localObject1).putLong("toUin", Long.valueOf(this.e.app.getCurrentAccountUin()).longValue());
            ((Bundle)localObject1).putLong("totalVoters", i1);
            ((Bundle)localObject1).putBoolean("isStartedByProfileCard", true);
            ((Bundle)localObject1).putBoolean("votersOnly", true);
            if (i1 > 0) {
              bool = true;
            } else {
              bool = false;
            }
            ((Bundle)localObject1).putBoolean("hasVoters", bool);
            ((Bundle)localObject1).putBoolean("extra_show_rank", true);
            ((Bundle)localObject1).putInt("frome_where", 4);
            paramView.putExtras((Bundle)localObject1);
            this.e.startActivity(paramView);
          }
          else
          {
            localObject1 = new Intent(this.e, QQBrowserActivity.class);
            if (U() == 10002) {
              paramView = "6";
            } else {
              paramView = "1";
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(this.ag);
            ((StringBuilder)localObject2).append("&SOURCETYPE=");
            ((StringBuilder)localObject2).append(paramView);
            ((StringBuilder)localObject2).append("&SIGN=");
            ((StringBuilder)localObject2).append(W());
            ((StringBuilder)localObject2).append("&UIN=");
            ((StringBuilder)localObject2).append(this.e.getAppInterface().getCurrentAccountUin());
            ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject2).toString());
            this.e.startActivity((Intent)localObject1);
          }
          NearbyProxy.a(this.e.app);
          paramView = this.f;
          if (paramView != null)
          {
            paramView.likeCountInc = 0;
            l();
            this.e.app.execute(new NearbyProfileDisplayPanel.20(this));
          }
          paramView = this.aM;
          if (paramView != null) {
            paramView.e = true;
          }
          if (this.e.mEnterProfileIntent.getBooleanExtra("IS_NEARBY_REDDOT_INCOME", false)) {
            ReportController.b(this.e.app, "CliOper", "", "", "0X8005249", "0X8005249", 0, 0, "", "", "", "");
          }
          ReportController.b(this.e.app, "CliOper", "", "", "0X800657A", "0X800657A", 2, 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.e.allinone)), "", "", "");
          if ((this.as.a != null) && (this.as.a.getVisibility() == 0)) {
            paramView = "1";
          } else {
            paramView = "2";
          }
          ReportController.b(this.e.app, "dc00898", "", "", "0X8007610", "0X8007610", 2, 0, paramView, "", "", "");
          return;
        }
        if (3 == this.e.mMode)
        {
          this.n = true;
          localObject1 = new HashMap();
          localObject2 = this.e.app.getCurrentAccountUin();
          if (this.f == null)
          {
            paramView = this.e;
            paramView.showToast(paramView.getString(2131890920));
            ((HashMap)localObject1).put("param_FailCode", "-210");
            StatisticCollector.getInstance(this.e.app.getApp()).collectPerformance((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
            if (QLog.isColorLevel()) {
              QLog.i("NearbyProfileDisplayPanel", 2, "mCard is null,vote failed !");
            }
            return;
          }
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("Click Vote View, mCard.bAvailVoteCnt = ");
            paramView.append(this.f.bAvailVoteCnt);
            paramView.append(",mCard.bHaveVotedCnt = ");
            paramView.append(this.f.bHaveVotedCnt);
            paramView.append(",mCard.strVoteLimitedNotice = ");
            paramView.append(this.f.strVoteLimitedNotice);
            QLog.i("NearbyProfileDisplayPanel", 2, paramView.toString());
          }
          if (this.f.bAvailVoteCnt <= 0) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          i2 = i4;
          if (this.f.bHaveVotedCnt <= 0)
          {
            i2 = i4;
            if (this.f.bAvailVoteCnt <= 0) {
              i2 = 1;
            }
          }
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("Profile->onClickVote, tinyId=");
            paramView.append(this.f.tinyId);
            paramView.append(", isFriend=");
            paramView.append(this.e.isFriend);
            paramView.append(", bAvailVoteCnt=");
            paramView.append(this.f.bAvailVoteCnt);
            paramView.append(", bHaveVotedCnt=");
            paramView.append(this.f.bHaveVotedCnt);
            QLog.d("NearbyLikeLimitManager", 2, paramView.toString());
          }
          if (NearbyProfileCardUtils.a(this.e.from)) {
            i3 = 510;
          } else {
            i3 = 509;
          }
          Object localObject4;
          if ((i1 == 0) && (i2 == 0))
          {
            if ((this.e.mCardHandler != null) && (NetworkUtil.isNetSupport(BaseApplication.getContext())))
            {
              if (!this.e.isFriend)
              {
                paramView = (INearbyLikeLimitManager)this.e.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
                localObject1 = this.e;
                localObject2 = ((NearbyPeopleProfileActivity)localObject1).app;
                localObject3 = this.f.uin;
                localObject4 = new NearbyProfileDisplayPanel.21(this);
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(i3);
                localStringBuilder.append("");
                paramView.a((Activity)localObject1, localObject2, (String)localObject3, localObject4, localStringBuilder.toString());
              }
              else
              {
                d(true);
                this.ak = true;
              }
            }
            else if (this.e.mCardHandler != null)
            {
              ((HashMap)localObject1).put("param_FailCode", "-203");
              StatisticCollector.getInstance(this.e.app.getApp()).collectPerformance((String)localObject2, "profileCardSendFavorite", true, 0L, 0L, (HashMap)localObject1, "", false);
              paramView = this.e;
              paramView.showToast(paramView.getString(2131918210));
            }
            else
            {
              ((HashMap)localObject1).put("param_FailCode", "-204");
              StatisticCollector.getInstance(this.e.app.getApp()).collectPerformance((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
              paramView = this.e;
              paramView.showToast(paramView.getString(2131890920));
            }
            paramView = new StringBuilder();
            paramView.append("");
            paramView.append(this.f.uin);
            localObject3 = paramView.toString();
            if (this.e.mMode == 3) {
              paramView = "2";
            } else {
              paramView = "1";
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(i3);
            ((StringBuilder)localObject1).append("");
            localObject4 = ((StringBuilder)localObject1).toString();
            if (this.e.isFriend) {
              localObject1 = "1";
            } else {
              localObject1 = "2";
            }
            if (this.ak) {
              localObject2 = "2";
            } else {
              localObject2 = "1";
            }
            ReportController.b(null, "dc00899", "grp_lbs", (String)localObject3, "data_card", "like_head", 0, 0, paramView, (String)localObject4, (String)localObject1, (String)localObject2);
            ReportController.b(this.e.app, "CliOper", "", "", "0X8004825", "0X8004825", T(), 0, this.f.uin, "", "", "");
            if (ProfileEntryUtils.isFromHotChat(this.e.allinone.profileEntryType)) {
              ReportController.b(this.e.app, "CliOper", "", "", "0X8005241", "0X8005241", 0, 0, "", "", "", "");
            }
          }
          else
          {
            if (this.f.gender == 0) {
              paramView = HardCodeUtil.a(2131905192);
            } else {
              paramView = HardCodeUtil.a(2131905127);
            }
            if (!this.aa)
            {
              if (this.e.isFriend)
              {
                paramView = DialogUtil.a(this.e, 230, null, HardCodeUtil.a(2131905167), "", HardCodeUtil.a(2131899883), new NearbyProfileDisplayPanel.22(this), null);
              }
              else
              {
                localObject3 = this.e;
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(HardCodeUtil.a(2131905115));
                ((StringBuilder)localObject4).append(paramView);
                ((StringBuilder)localObject4).append(HardCodeUtil.a(2131905185));
                paramView = DialogUtil.a((Context)localObject3, 230, null, ((StringBuilder)localObject4).toString(), HardCodeUtil.a(2131898212), HardCodeUtil.a(2131905162), new NearbyProfileDisplayPanel.23(this), new NearbyProfileDisplayPanel.24(this));
              }
              paramView.show();
              this.aa = true;
              paramView.setOnDismissListener(new NearbyProfileDisplayPanel.25(this));
            }
            ReportController.b(null, "dc00899", "grp_lbs", "", "data_like", "exp_toast", 0, 0, "", "", "", "");
            if (i2 != 0) {
              ReportController.b(this.e.app, "CliOper", "", "", "0X8006579", "0X8006579", 2, 0, Integer.toString(ProfileEntryUtils.getProfileEntryType(this.e.allinone.profileEntryType)), "", "", "");
            } else if (i1 != 0) {
              ReportController.b(this.e.app, "CliOper", "", "", "0X8006578", "0X8006578", 2, 0, Integer.toString(ProfileEntryUtils.getProfileEntryType(this.e.allinone.profileEntryType)), "", "", "");
            }
            StatisticCollector.getInstance(this.e.app.getApp()).collectPerformance((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
          }
          if (this.f.iIsGodFlag == 1)
          {
            if (this.f.gender == 0)
            {
              ReportController.b(this.e.app, "CliOper", "", "", "0X800528C", "0X800528C", 1, 0, "", "", "", "");
              return;
            }
            if (this.f.gender == 1) {
              ReportController.b(this.e.app, "CliOper", "", "", "0X800528D", "0X800528D", 1, 0, "", "", "", "");
            }
          }
        }
      }
      else
      {
        localObject1 = "2";
        if (paramView == this.aJ)
        {
          paramView = this.e.app.getCurrentAccountUin();
          if ((Friends.isValidUin(paramView)) && (Friends.isValidUin(this.f.uin)))
          {
            bool = paramView.equals(this.f.uin);
            if (!bool) {
              paramView = "";
            }
            paramView = String.format("https://ti.qq.com/paihangbanggl/index.html?_wv=1027&isguest=%d&uin=%s", new Object[] { Integer.valueOf(bool ^ true), paramView });
            localObject1 = new Intent(this.e, QQBrowserActivity.class);
            ((Intent)localObject1).putExtra("portraitOnly", true);
            ((Intent)localObject1).putExtra("url", paramView);
            this.e.startActivity((Intent)localObject1);
          }
        }
        else
        {
          if (paramView == this.aw)
          {
            ReportController.b(this.e.app, "dc00899", "grp_lbs", "", "data_card", "clk_edit", 0, 0, "", "", "", "");
            if (this.e.mIsProfileOk == 0)
            {
              this.e.showPromptDialog();
              return;
            }
            this.e.switchToEditPanel(300L);
            ReportController.b(this.e.app, "CliOper", "", "", "0X8004B38", "0X8004B38", 0, 0, "", "", "", "");
            return;
          }
          if (paramView == this.P)
          {
            paramView = NearbyPublishMenuHelper.a();
            paramView = new NearbyPublishMenu(this.e, paramView);
            paramView.a(this.al);
            paramView.a(DisplayUtil.a(this.e, 18.0F), DisplayUtil.a(this.e, 22.0F) + this.P.getHeight(), 0.2F);
            localObject2 = new ReportTask(this.e.app).a("dc00899").b("grp_lbs").c("data_card").d("pub_download_exp").e(String.valueOf(this.f.tinyId));
            paramView = (View)localObject1;
            if (this.e.mMode == 2) {
              paramView = "1";
            }
            ((ReportTask)localObject2).a(new String[] { paramView }).a();
          }
        }
      }
      return;
    }
    catch (SecurityException paramView)
    {
      break label424;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    Object localObject = this.e;
    if ((localObject != null) && (!((NearbyPeopleProfileActivity)localObject).isFinishing()))
    {
      localObject = this.f;
      if ((localObject != null) && (TextUtils.equals(paramString, ((NearbyPeopleCard)localObject).uin)))
      {
        paramString = this.aU;
        if (paramString != null) {
          paramString.setImageBitmap(paramBitmap);
        }
        a(paramBitmap);
      }
    }
  }
  
  public void onScrollStateChanged(ScrollView paramScrollView, int paramInt, boolean paramBoolean) {}
  
  public void onTabSelected(int paramInt1, int paramInt2)
  {
    this.ad = paramInt2;
    this.I.setCurrentItem(paramInt2, false);
  }
  
  public void p()
  {
    ThreadPriorityManager.a(true);
    int i1 = U();
    if (I())
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("finchat", true);
      this.e.setResult(0, (Intent)localObject);
      this.e.finish();
      return;
    }
    Object localObject = this.f;
    if ((localObject != null) && (!StringUtil.isEmpty(String.valueOf(((NearbyPeopleCard)localObject).tinyId)))) {
      a(this.f.uin, String.valueOf(this.f.chatId), String.valueOf(this.f.tinyId), i1);
    }
  }
  
  protected String r()
  {
    return "https://pub.idqqimg.com/pc/misc/files/20171226/bab1a27be690414dbe509a7eaedecf4b.gif";
  }
  
  protected void s()
  {
    if (((INearbyVersionControl)QRoute.api(INearbyVersionControl.class)).getVersion() == 2) {
      this.L = new NewNearbyMomentFragment();
    } else {
      this.L = new NearbyMomentFragment();
    }
    this.N.add(this.L);
  }
  
  protected void t()
  {
    if (((INearbyVersionControl)QRoute.api(INearbyVersionControl.class)).getVersion() == 2) {
      this.M = new NewNearbyProfileFragment();
    } else {
      this.M = new NearbyProfileFragment();
    }
    this.M.a(this);
    this.N.add(this.M);
  }
  
  protected void u()
  {
    ImageView localImageView1 = (ImageView)this.au.findViewById(2131439400);
    ImageView localImageView2 = (ImageView)this.au.findViewById(2131449433);
    ImageView localImageView3 = (ImageView)this.au.findViewById(2131437182);
    NearbyProfileDisplayPanel.4 local4 = new NearbyProfileDisplayPanel.4(this, localImageView1, localImageView2, localImageView3);
    localImageView1.setOnClickListener(local4);
    localImageView2.setOnClickListener(local4);
    localImageView3.setOnClickListener(local4);
    if (ThemeUtil.isNowThemeIsNight(this.e.app, false, null))
    {
      localImageView1.setImageResource(2130847196);
      localImageView2.setImageResource(2130847198);
      localImageView3.setImageResource(2130847194);
      this.au.setBackgroundColor(0);
    }
  }
  
  protected int v()
  {
    TabBarView localTabBarView = this.J;
    if (localTabBarView != null) {
      return localTabBarView.getSelectedTabIndex();
    }
    return -1;
  }
  
  protected void w()
  {
    this.J = ((TabBarView)this.ar.findViewById(2131446735));
    this.J.setBackgroundDrawable(this.b.getResources().getDrawable(2130853592));
    this.J.setOnTabChangeListener(this);
    this.J.setEnableRepeatedClick(true);
    this.J.setTabTextSize(16);
    this.J.setSelectColor(Color.parseColor("#0dc4fd"));
    this.J.setUnselectColor(Color.parseColor("#777777"));
    this.J.setSelectBgRes(2130847187);
    this.J.setUnSelectBgRes(2130847188);
    this.J.setUnderLineHeight(DisplayUtil.a(this.e, 0.0F));
    this.J.setUnderLineMargin(DisplayUtil.a(this.e, 44.0F));
    this.J.setTabHeight(DisplayUtil.a(this.e, 45.0F));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.gravity = 17;
    localLayoutParams.weight = 1.0F;
    this.J.setTabLayoutParams(localLayoutParams);
    this.ac = 0;
    this.J.a(0, HardCodeUtil.a(2131905105), true, true);
    t();
    this.ab = 1;
    this.J.a(1, HardCodeUtil.a(2131905160), true, true);
    s();
  }
  
  protected int x()
  {
    return 0;
  }
  
  public void y()
  {
    if (this.f.nearbyNowData == null)
    {
      this.aB.setVisibility(8);
      return;
    }
    Object localObject2 = this.f.nearbyNowData.now_anchor_state.bytes_live_url.get().toStringUtf8();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("now anchor, jumpUrl=");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.i("NearbyProfileDisplayPanel", 2, ((StringBuilder)localObject1).toString());
    }
    int i1 = this.f.nearbyNowData.now_anchor_state.uint32_level.get();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("level: ");
    ((StringBuilder)localObject1).append(i1);
    QLog.i("NearbyProfileDisplayPanel", 1, ((StringBuilder)localObject1).toString());
    if (i1 > 0)
    {
      this.aB.setVisibility(0);
      Object localObject3 = this.e.app;
      long l1 = this.f.tinyId;
      int i2 = this.f.gender;
      String str = "2";
      if (i2 == 0) {
        localObject1 = "1";
      } else if (this.f.gender == 1) {
        localObject1 = "2";
      } else {
        localObject1 = "0";
      }
      ReportController.b((AppRuntime)localObject3, "dc00899", "grp_lbs", String.valueOf(l1), "status_bar", "bar_exp", 0, 0, (String)localObject1, "", "", "");
      localObject1 = HardCodeUtil.a(2131905209);
      i2 = ((String)localObject1).length();
      if (this.f.nearbyNowData.now_anchor_state.uint32_live_status.get() == 1)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(i1);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(HardCodeUtil.a(2131905225));
        localObject1 = new SpannableString(localStringBuilder.toString());
        ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-4352), i2, ((String)localObject3).length() + i2, 33);
        this.aA.setText((CharSequence)localObject1);
        this.aA.setTextColor(-1);
        this.aF.setRadius(UIUtils.a(this.e, 3.0F));
        this.aG.setImageResource(2130847160);
        this.aD.setVisibility(8);
        this.aE.setVisibility(0);
        this.aC.setImageResource(2130847149);
        this.aB.setOnClickListener(new NearbyProfileDisplayPanel.9(this, (String)localObject2));
        localObject2 = new ReportTask(this.e.app).b("grp_lbs").c("data_card").d("live_exp").e(String.valueOf(this.f.tinyId));
        if (this.f.gender == 0) {
          localObject1 = "1";
        } else if (this.f.gender == 1) {
          localObject1 = str;
        } else {
          localObject1 = "0";
        }
        ((ReportTask)localObject2).a(new String[] { localObject1 }).a();
        return;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(i1);
      ((StringBuilder)localObject3).append("");
      localObject3 = ((StringBuilder)localObject3).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append((String)localObject3);
      localStringBuilder.append(HardCodeUtil.a(2131905165));
      localObject1 = new SpannableString(localStringBuilder.toString());
      ((SpannableString)localObject1).setSpan(new ForegroundColorSpan(-65536), i2, ((String)localObject3).length() + i2, 33);
      this.aA.setTextColor(-16777216);
      this.aA.setText((CharSequence)localObject1);
      this.aF.setVisibility(8);
      this.aG.setImageResource(2130847150);
      this.aD.setVisibility(0);
      this.aE.setVisibility(8);
      this.aC.setImageResource(2130847167);
      this.aB.setOnClickListener(new NearbyProfileDisplayPanel.10(this, (String)localObject2));
      localObject2 = new ReportTask(this.e.app).b("grp_lbs").c("data_card").d("nonlive_exp").e(String.valueOf(this.f.tinyId));
      if (this.f.gender == 0) {
        localObject1 = "1";
      } else if (this.f.gender == 1) {
        localObject1 = str;
      } else {
        localObject1 = "0";
      }
      ((ReportTask)localObject2).a(new String[] { localObject1 }).a();
      return;
    }
    this.aB.setVisibility(8);
  }
  
  protected void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel
 * JD-Core Version:    0.7.0.1
 */