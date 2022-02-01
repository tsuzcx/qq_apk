package com.tencent.mobileqq.nearby.profilecard;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.image.VideoDrawable.VideoDrawableParams;
import com.tencent.jungle.nearby.nio.proto.nearby.BarInfo;
import com.tencent.jungle.nearby.nio.proto.nearby.Cmd0x1RspBody;
import com.tencent.jungle.nearby.nio.proto.nearby.FansInfo;
import com.tencent.jungle.nearby.nio.proto.nearby.FeedInfo;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearbyHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.MsgBoxUtil;
import com.tencent.mobileqq.dating.NewVoteAnimHelper;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity;
import com.tencent.mobileqq.nearby.FaceScoreConfig;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager;
import com.tencent.mobileqq.nearby.INearbyLikeLimitManager.LikeItem;
import com.tencent.mobileqq.nearby.ImgDownloadListener;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyFaceScoreManager;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.NearbyTribeAppController;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.QQNearbyManager;
import com.tencent.mobileqq.nearby.api.FaceScoreUtils;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.nearby.api.INearbyVideoUtils;
import com.tencent.mobileqq.nearby.api.NearbyProxy;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter.ViewHolder;
import com.tencent.mobileqq.nearby.widget.AvatarWallViewPager;
import com.tencent.mobileqq.nearpeople.api.INearbyMineHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.entity.ProfileBusiEntry;
import com.tencent.mobileqq.profilecard.utils.ProfileEntryUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.AsynLoadDrawable;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.BounceScrollView.OnScrollChangedListener;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.CustomImgView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class NearbyProfileDisplayTribePanel
  extends NearbyProfileDisplayBasePanel
  implements View.OnClickListener, OnTagClickListener, BounceScrollView.OnScrollChangedListener
{
  public static String[] ay = { "0X800553B", "0X800553C", "0X800553D", "0X800553E", "0X800553F", "0X8005540", "0X8005541" };
  public static String[] az = { "0X8005542", "0X8005543", "0X8005544", "0X8005545", "0X8005546", "0X8005547", "0X8005548" };
  SavorTagIcon[] A;
  SavorTagImg[] B;
  RelativeLayout[] C;
  RelativeLayout[] D;
  int[] E = { 2131436992, 2131436986, 2131436985, 2131436993 };
  int[] F = { 2131436990, 2131436991, 2131436987 };
  InterestTag[] G;
  public boolean H;
  public boolean I;
  public boolean J;
  public boolean K;
  public boolean L;
  public boolean M;
  public boolean N;
  public boolean O;
  public boolean P;
  public boolean Q;
  public boolean R;
  ProfileQiqiLiveController S = null;
  ProgressButton T;
  int U = 0;
  boolean V;
  boolean W;
  WeakReferenceHandler X;
  AtomicInteger Y;
  boolean Z;
  Handler aA;
  DialogInterface.OnClickListener aB;
  private NearbyPeopleCard aC;
  private TextView aD;
  private View aE;
  private NearbyCardVoteView aF;
  private HeartLayout aG;
  private BounceScrollView aH;
  private LinearLayout aI;
  private LinearLayout aJ;
  private View aK;
  private Button aL;
  private RelativeLayout aM;
  private TextView aN;
  private View aO;
  private TextView aP;
  private TextView aQ;
  private ImageView aR;
  private TextView aS;
  private AvatarWallViewPager aT;
  private URLImageView aU;
  private ImageView aV;
  private TextView aW;
  private TextView aX;
  private TextView aY;
  private TextView aZ;
  boolean aa;
  AtomicInteger ab;
  AtomicInteger ac;
  Handler.Callback ad;
  RedTouch ae;
  LinearLayout af;
  int ag;
  int ah;
  List<String> ai;
  String aj;
  int ak;
  boolean al;
  boolean am;
  String an;
  String ao;
  int ap;
  View aq;
  boolean ar;
  String as;
  String at;
  boolean au;
  protected String av;
  protected ProfileBusiEntry aw;
  protected boolean ax;
  private WeakReference<FaceDrawable> bA;
  private View.OnClickListener bB;
  private DownloadListener bC;
  private TextView ba;
  private RelativeLayout bb;
  private LinearLayout bc;
  private LinearLayout bd;
  private ImageView be;
  private ImmersiveTitleBar2 bf;
  private Animation bg;
  private Animation bh;
  private NewVoteAnimHelper bi;
  private RelativeLayout bj;
  private URLImageView[] bk;
  private RelativeLayout bl;
  private RelativeLayout bm;
  private RelativeLayout bn;
  private LinearLayout bo;
  private LinearLayout bp;
  private LinearLayout bq;
  private int br;
  private boolean bs = false;
  private NearbyProfileDisplayTribePanel.AvatarWallAdapter bt;
  private byte[] bu;
  private boolean bv;
  private NearbyTribeAppController bw;
  private LinearLayout bx;
  private TextView by;
  private Animation.AnimationListener bz;
  protected final Map<String, View> d = new HashMap();
  NearbyPeopleProfileActivity e;
  CustomImgView f;
  ImageView g;
  ImageView h;
  ImageView i;
  RelativeLayout j;
  TextView k;
  TextView l;
  TextView m;
  RelativeLayout n;
  RelativeLayout o;
  RelativeLayout p;
  RelativeLayout q;
  RelativeLayout r;
  SavorTagImg s;
  protected FaceScoreConfig t;
  TextView u;
  TextView v;
  TextView w;
  TextView x;
  TextView y;
  String[] z;
  
  public NearbyProfileDisplayTribePanel(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
    boolean bool = true;
    this.V = true;
    this.W = true;
    this.Y = new AtomicInteger(0);
    this.Z = false;
    this.aa = false;
    this.ab = new AtomicInteger(0);
    this.ac = new AtomicInteger(0);
    this.ad = new NearbyProfileDisplayTribePanel.1(this);
    this.al = false;
    this.am = false;
    this.an = "";
    this.ao = "";
    this.ap = 0;
    this.ar = false;
    this.bz = new NearbyProfileDisplayTribePanel.5(this);
    this.as = "";
    this.at = "";
    this.au = false;
    this.av = null;
    this.ax = true;
    this.bB = new NearbyProfileDisplayTribePanel.27(this);
    this.aA = new NearbyProfileDisplayTribePanel.29(this);
    this.aB = new NearbyProfileDisplayTribePanel.30(this);
    this.bC = new NearbyProfileDisplayTribePanel.31(this);
    this.e = paramNearbyPeopleProfileActivity;
    this.X = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), this.ad);
    if (paramNearbyPeopleProfileActivity.getIntent().getIntExtra("frome_where", 0) != 35) {
      bool = false;
    }
    this.aa = bool;
    this.Z = paramNearbyPeopleProfileActivity.getIntent().getBooleanExtra("is_from_werewolves", false);
  }
  
  private int A()
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
  
  private int B()
  {
    if (this.e != null)
    {
      NearbyPeopleCard localNearbyPeopleCard = this.aC;
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
  
  private void C()
  {
    this.aU.setBackgroundColor(this.e.getResources().getColor(2131168189));
    try
    {
      this.aU.setImageDrawable(this.e.getResources().getDrawable(2130847172));
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      label43:
      Object localObject1;
      Object localObject2;
      boolean bool;
      double d1;
      int i1;
      int i2;
      int i3;
      break label43;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onHeadSizeIsSmall getDrawable oom.");
    }
    this.aU.setOnClickListener(null);
    localObject1 = FaceDrawable.getStrangerFaceDrawable(this.e.app, 200, String.valueOf(this.aC.uin), 3);
    this.bA = new WeakReference(localObject1);
    localObject2 = this.f;
    bool = false;
    ((CustomImgView)localObject2).setVisibility(0);
    this.f.setImageDrawable((Drawable)localObject1);
    d1 = this.e.mDensity * 70.0F;
    Double.isNaN(d1);
    i1 = (int)(d1 + 0.5D);
    d1 = this.e.mDensity * 2.0F;
    Double.isNaN(d1);
    i2 = (int)(d1 + 0.5D);
    localObject1 = new Paint();
    ((Paint)localObject1).setColor(-1);
    ((Paint)localObject1).setStyle(Paint.Style.STROKE);
    ((Paint)localObject1).setStrokeWidth(i2);
    ((Paint)localObject1).setAntiAlias(true);
    i3 = i2 * 2 + i1;
    try
    {
      localObject2 = Bitmap.createBitmap(i3, i3, Bitmap.Config.ARGB_8888);
      if (localObject2 == null) {
        break label309;
      }
      new Canvas((Bitmap)localObject2).drawCircle(i1 / 2 + i2, i1 / 2 + i2, i1 / 2, (Paint)localObject1);
      this.g.setVisibility(0);
      this.g.setImageBitmap((Bitmap)localObject2);
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      label293:
      break label293;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.nearby_people_card.", 2, "onHeadSizeIsSmall create bitmap oom.");
    }
    label309:
    this.aO.setBackgroundDrawable(null);
    if (this.e.mMode == 2)
    {
      this.h.setVisibility(0);
      this.i.setVisibility(0);
      if (!this.e.mPicInfo.isEmpty())
      {
        this.i.setBackgroundResource(2130847175);
        bool = true;
      }
      else
      {
        this.i.setBackgroundResource(2130847174);
      }
      this.f.setTag(Boolean.valueOf(bool));
      this.f.setOnClickListener(this);
    }
    else if (this.e.mMode == 3)
    {
      this.h.setVisibility(8);
      this.i.setVisibility(8);
      this.f.setOnClickListener(this);
    }
    this.e.refreshStrangerFace();
  }
  
  private void D()
  {
    this.e.finish();
    AlbumUtil.anim(this.e, false, false);
  }
  
  private byte[] E()
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
        localObject2 = this.bu;
      }
    }
    if ((localObject2 == null) && (QLog.isColorLevel())) {
      QLog.e("Q.nearby_people_card.", 2, "nearbySig is null ");
    }
    return localObject2;
  }
  
  private void F()
  {
    if ((this.e.mCardHandler != null) && (this.aC != null))
    {
      int i1;
      if (this.e.isFriend)
      {
        if (this.Y.get() != 0)
        {
          this.e.mCardHandler.a(Long.valueOf(this.e.app.getCurrentAccountUin()).longValue(), Long.valueOf(this.aC.uin).longValue(), this.aC.vCookies, this.aC.favoriteSource, this.Y.get(), 0);
          boolean bool = ((INearbyLikeLimitManager)this.e.app.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).a(Long.valueOf(this.aC.uin).longValue());
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
          ReportController.b(this.e.app, "CliOper", "", "", "P_prof", "Prof_good", 2, this.Y.get(), i1, Integer.toString(ProfileEntryUtils.getProfileEntryType(this.e.allinone.profileEntryType)), String.valueOf(this.Y.get()), this.e.app.getCurrentAccountUin(), this.aC.uin);
          this.Y.set(0);
        }
      }
      else if ((this.ab.get() != 0) || (this.ac.get() != 0))
      {
        ArrayList localArrayList = new ArrayList();
        INearbyLikeLimitManager.LikeItem localLikeItem = new INearbyLikeLimitManager.LikeItem();
        localLikeItem.b = this.ab.get();
        localLikeItem.c = this.ac.get();
        localLikeItem.a = Long.valueOf(this.aC.uin).longValue();
        localLikeItem.e = this.aC.favoriteSource;
        localArrayList.add(localLikeItem);
        if (NearbyProfileCardUtils.a(this.e.from)) {
          i1 = 510;
        } else {
          i1 = 509;
        }
        this.e.mCardHandler.a(localArrayList, i1);
        this.ab.set(0);
        this.ac.set(0);
      }
    }
  }
  
  private List<StrangerInfo> a(List<Object> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if ((localObject instanceof StrangerInfo)) {
        localArrayList.add((StrangerInfo)localObject);
      }
    }
    return localArrayList;
  }
  
  private void a(TextView paramTextView)
  {
    int i1 = paramTextView.getWidth();
    int i2 = paramTextView.getHeight();
    Object localObject2 = new StringBuilder();
    if (this.br > 0) {
      localObject1 = "+ ";
    } else {
      localObject1 = "- ";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(String.valueOf(Math.abs(this.br)));
    paramTextView.setText(((StringBuilder)localObject2).toString());
    if (paramTextView.getVisibility() != 0) {
      paramTextView.setVisibility(0);
    }
    Object localObject1 = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, i1 / 2, i2 / 2);
    localObject2 = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setInterpolator(this.e, 17432584);
    localAnimationSet.addAnimation((Animation)localObject1);
    localAnimationSet.addAnimation((Animation)localObject2);
    localAnimationSet.setDuration(1500L);
    paramTextView.setAnimation(localAnimationSet);
    localAnimationSet.start();
    this.br = 0;
  }
  
  private void a(String paramString)
  {
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject = String.format("https://y.qq.com/m/gene/index.html?uin=%s&_bid=155&_wv=10017", new Object[] { this.aC.uin });
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
  
  private void a(String paramString, int paramInt)
  {
    if ((this.e.mFromDatingSubject == 5) && (!TextUtils.isEmpty(this.e.mFromDatingId)) && (this.e.mIsPub))
    {
      String str = NearbyManagerHelper.a(this.e.app).a();
      localObject = str;
      if (str == null) {
        localObject = this.e.getResources().getString(2131896705);
      }
      AddMessageHelper.a(this.e.app, paramString, (String)localObject, 1010);
    }
    Object localObject = new Intent(this.e, ChatActivity.class);
    ((Intent)localObject).putExtra("PREVIOUS_WINDOW", QQNearbyManager.b().getName());
    ((Intent)localObject).putExtra("PREVIOUS_UIN", this.aC.uin);
    ((Intent)localObject).putExtra("cSpecialFlag", this.e.mEnterProfileIntent.getExtras().getInt("cSpecialFlag"));
    ((Intent)localObject).putExtra("uin", paramString);
    ((Intent)localObject).putExtra("uintype", paramInt);
    ((Intent)localObject).putExtra("aio_msg_source", 3);
    if (this.e.allinone.chatEntrance != 0) {
      ((Intent)localObject).putExtra("entrance", this.e.allinone.chatEntrance);
    }
    if (paramInt == 1001)
    {
      ((Intent)localObject).putExtra("rich_accost_sig", this.e.allinone.chatCookie);
      ((Intent)localObject).putExtra("gender", this.aC.gender);
    }
    else if (paramInt == 1010)
    {
      ((Intent)localObject).putExtra("rich_date_sig", this.e.allinone.chatCookie);
      ((Intent)localObject).putExtra("gender", this.aC.gender);
    }
    ((Intent)localObject).putExtra("uinname", this.e.allinone.nickname);
    ((Intent)localObject).addFlags(67108864);
    this.e.startActivity((Intent)localObject);
    this.e.finish();
  }
  
  private void b(int paramInt)
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
        QLog.e("NearbyProfileDisplayTribePanel", 2, localJSONException.toString());
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    int i1;
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
            if (this.bv) {
              i1 = 2131894140;
            } else {
              i1 = 2131894138;
            }
            if (this.bv) {
              localObject1 = "exp_followed";
            } else {
              localObject1 = "exp_follow";
            }
            ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", (String)localObject1, 0, 0, "", "", "", "");
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
      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_msg", 0, 0, "", "", "", "");
    }
    if (i1 == 0)
    {
      this.aI.setVisibility(8);
      return;
    }
    Object localObject1 = this.aI.getChildAt(paramInt1);
    ((View)localObject1).setVisibility(0);
    if (paramInt1 == 0) {
      ((View)localObject1).setVisibility(8);
    }
    Object localObject2;
    Object localObject3;
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
      localObject3 = new DataTag(paramInt2, null);
      ((Button)localObject2).setTag(localObject3);
      ((View)localObject1).setTag(localObject3);
      if ((paramInt2 == 60) && (this.bv))
      {
        ((Button)localObject2).setTextColor(this.e.getResources().getColor(2131168043));
        ((Button)localObject2).setBackgroundDrawable(this.e.getResources().getDrawable(2130839499));
        return;
      }
      if ((paramInt2 == 8) && (this.al) && (!this.e.isFriend))
      {
        ((Button)localObject2).setBackgroundResource(2130852171);
        ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
        return;
      }
      if ((paramInt2 == 36) && (this.am) && (!this.e.isFriend))
      {
        ((Button)localObject2).setBackgroundResource(2130852171);
        ((Button)localObject2).setTextColor(Color.parseColor("#BBBBBB"));
      }
    }
    else
    {
      ((Button)((View)localObject1).findViewById(2131448897)).setVisibility(8);
      localObject2 = new DataTag(paramInt2, null);
      localObject3 = (ProgressButton)((View)localObject1).findViewById(2131440741);
      if (localObject3 != null)
      {
        ((ProgressButton)localObject3).setVisibility(0);
        ((ProgressButton)localObject3).setText(i1);
        if (paramInt2 == 38)
        {
          ((ProgressButton)localObject3).setBackgroundResource(2130852171);
          ((ProgressButton)localObject3).setTextColor(this.e.getResources().getColor(2131165935));
        }
        ((ProgressButton)localObject3).setOnClickListener(this);
        ((ProgressButton)localObject3).setTag(localObject2);
      }
      ((View)localObject1).setTag(localObject2);
    }
  }
  
  private void b(List<StrangerInfo> paramList)
  {
    int i1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateVistorHeader visitor count:");
      if (paramList == null) {
        i1 = 0;
      } else {
        i1 = paramList.size();
      }
      ((StringBuilder)localObject1).append(i1);
      QLog.d("Q.nearby.visitor", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = ((INearbyMineHelper)QRoute.api(INearbyMineHelper.class)).buildRedTouchAppInfo(this.e.app, new Object[] { Integer.valueOf(4105), "100510.100523" });
    this.ae.a((BusinessInfoCheckUpdate.AppInfo)localObject1);
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramList.size() > 3) {
        i1 = 3;
      } else {
        i1 = paramList.size();
      }
      localObject1 = new ArrayList(3);
      int i2 = 0;
      while (i2 < i1)
      {
        localObject2 = (StrangerInfo)paramList.get(i2);
        if (localObject2 != null) {
          ((List)localObject1).add(localObject2);
        }
        i2 += 1;
      }
      int i3 = ((List)localObject1).size();
      paramList = this.e.getResources();
      Object localObject2 = (RelativeLayout.LayoutParams)this.af.getLayoutParams();
      i1 = ((RelativeLayout.LayoutParams)localObject2).width;
      i2 = this.ag;
      int i4 = i3 - 1;
      int i5 = this.ah;
      if (i1 != i3 * i2 + i4 * i5)
      {
        ((RelativeLayout.LayoutParams)localObject2).width = (i2 * i3 + i4 * i5);
        i1 = 1;
      }
      else
      {
        i1 = 0;
      }
      if ((!this.ae.h()) && (((RelativeLayout.LayoutParams)localObject2).rightMargin != AIOUtils.b(35.0F, paramList))) {}
      for (((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(35.0F, paramList);; ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(45.0F, paramList))
      {
        i2 = 1;
        break;
        i2 = i1;
        if (!this.ae.h()) {
          break;
        }
        i2 = i1;
        if (((RelativeLayout.LayoutParams)localObject2).rightMargin == AIOUtils.b(45.0F, paramList)) {
          break;
        }
      }
      if (i2 != 0) {
        this.af.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      i1 = 0;
      while (i1 < i3)
      {
        localObject2 = new LinearLayout.LayoutParams(AIOUtils.b(30.0F, paramList), AIOUtils.b(30.0F, paramList));
        ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(5.0F, paramList);
        StrangerInfo localStrangerInfo = (StrangerInfo)((List)localObject1).get(i1);
        if (localStrangerInfo != null)
        {
          CustomImgView localCustomImgView = new CustomImgView(this.e);
          Drawable localDrawable = localCustomImgView.getDrawable();
          if ((localDrawable != null) && ((localDrawable instanceof AsynLoadDrawable))) {
            ((AsynLoadDrawable)localDrawable).cancel();
          }
          localCustomImgView.setImageDrawable(FaceDrawable.getStrangerFaceDrawable(this.e.app, 200, String.valueOf(localStrangerInfo.tinyId), true));
          this.af.addView(localCustomImgView, (ViewGroup.LayoutParams)localObject2);
        }
        i1 += 1;
      }
      if (this.af.getVisibility() != 0) {
        this.af.setVisibility(0);
      }
      return;
    }
    this.af.setVisibility(8);
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    this.ba.setVisibility(0);
    if (paramArrayOfByte != null)
    {
      RichStatus localRichStatus = RichStatus.parseStatus(paramArrayOfByte);
      paramArrayOfByte = null;
      if (localRichStatus != null) {
        paramArrayOfByte = localRichStatus.toSpannableString(null, -8947849, this.e.getResources().getColor(2131165564));
      }
      Object localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = new SpannableString("");
      }
      if ((localRichStatus != null) && (!TextUtils.isEmpty(localRichStatus.actionText)))
      {
        localObject = new SpannableStringBuilder((CharSequence)localObject);
        ((SpannableStringBuilder)localObject).insert(0, "[S] ");
        if (this.e.mStatusManager != null) {
          paramArrayOfByte = this.e.mStatusManager.a(localRichStatus.actionId, 200);
        } else {
          paramArrayOfByte = BitmapManager.a(this.e.getResources(), 2130851609);
        }
        paramArrayOfByte = new StatableBitmapDrawable(this.e.getResources(), paramArrayOfByte, false, false);
        int i1 = (int)(this.ba.getTextSize() * 1.1F + 0.5F);
        paramArrayOfByte.setBounds(0, 0, i1, i1);
        paramArrayOfByte = new OffsetableImageSpan(paramArrayOfByte, 0);
        paramArrayOfByte.setOffset(-0.1F);
        ((SpannableStringBuilder)localObject).setSpan(paramArrayOfByte, 0, 3, 17);
        this.ba.setText((CharSequence)localObject);
        ReportController.b(this.e.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
        ReportController.b(this.e.app, "dc00899", "grp_lbs", "", "data_card", "exp_word", 0, 0, "", "", "", "");
        return;
      }
      paramArrayOfByte = StringUtil.trim(((SpannableString)localObject).toString());
      if (TextUtils.isEmpty(paramArrayOfByte))
      {
        if (this.e.mMode == 2)
        {
          this.ba.setVisibility(8);
          return;
        }
        this.ba.setVisibility(8);
        return;
      }
      this.ba.setText(paramArrayOfByte.trim());
      return;
    }
    if (this.e.mMode == 2)
    {
      this.ba.setVisibility(8);
      return;
    }
    this.ba.setVisibility(8);
  }
  
  private void u()
  {
    this.bw.a();
  }
  
  private void v()
  {
    ArrayList localArrayList1 = new ArrayList(4);
    Object localObject = new ArrayList(3);
    ArrayList localArrayList2 = new ArrayList(9);
    if (this.r.getVisibility() == 0) {
      localArrayList2.add(this.r);
    }
    int i1 = 0;
    String str;
    StringBuilder localStringBuilder;
    int i2;
    while (i1 < 3)
    {
      if (this.G[(i1 + 4)].b.size() > 0)
      {
        ((List)localObject).add(this.B[i1]);
        localArrayList2.add(this.D[i1]);
        this.D[i1].setVisibility(0);
        QQAppInterface localQQAppInterface = this.e.app;
        if (this.e.mMode == 2) {
          str = "1";
        } else {
          str = "2";
        }
        if (this.G[i1].a <= 4)
        {
          localStringBuilder = new StringBuilder();
          i2 = this.G[i1].a + 3;
        }
        else
        {
          localStringBuilder = new StringBuilder();
          i2 = this.G[i1].a - 4;
        }
        localStringBuilder.append(i2);
        localStringBuilder.append("");
        ReportController.b(localQQAppInterface, "dc00899", "grp_lbs", "", "data_card", "exp_tag", 0, 0, str, "", localStringBuilder.toString(), "");
      }
      else
      {
        this.D[i1].setVisibility(8);
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < 4)
    {
      if (this.G[i1].b.size() > 0)
      {
        localArrayList1.add(this.A[i1]);
        localArrayList2.add(this.C[i1]);
        this.C[i1].setVisibility(0);
        localObject = this.e.app;
        if (this.e.mMode == 2) {
          str = "1";
        } else {
          str = "2";
        }
        if (this.G[i1].a <= 4)
        {
          localStringBuilder = new StringBuilder();
          i2 = this.G[i1].a + 3;
        }
        else
        {
          localStringBuilder = new StringBuilder();
          i2 = this.G[i1].a - 4;
        }
        localStringBuilder.append(i2);
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject, "dc00899", "grp_lbs", "", "data_card", "exp_tag", 0, 0, str, "", localStringBuilder.toString(), "");
      }
      else
      {
        this.C[i1].setVisibility(8);
      }
      i1 += 1;
    }
    if (localArrayList2.size() > 0) {
      ((View)localArrayList2.get(0)).setBackgroundDrawable(null);
    } else if (localArrayList2.size() == 0) {
      this.aE.findViewById(2131436942).setVisibility(8);
    }
    if (localArrayList2.size() > 1) {
      ((View)localArrayList2.get(localArrayList2.size() - 1)).setBackgroundResource(2130852512);
    }
  }
  
  private void w()
  {
    this.bp.setVisibility(8);
    LinearLayout localLinearLayout = this.bq;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(8);
    }
  }
  
  private void x()
  {
    if ((!this.e.mHasNewPhoto) && (TextUtils.isEmpty(this.aC.bVideoHeadUrl)))
    {
      C();
      return;
    }
    this.aU.setVisibility(8);
    this.f.setVisibility(8);
    this.g.setVisibility(8);
    this.h.setVisibility(8);
    this.i.setVisibility(8);
  }
  
  private void y()
  {
    this.aO.setBackgroundResource(2130847176);
    this.aS.setOnClickListener(null);
    if (this.e.mMode == 2)
    {
      this.aR.setVisibility(8);
      this.aQ.setVisibility(0);
      this.aQ.setText(2131892850);
      this.aQ.setOnClickListener(new NearbyProfileDisplayTribePanel.15(this));
      return;
    }
    this.aR.setVisibility(8);
    this.aQ.setVisibility(0);
    this.aQ.setText(2131892850);
    this.aQ.setOnClickListener(new NearbyProfileDisplayTribePanel.16(this));
  }
  
  private void z()
  {
    ProfileBusiEntry localProfileBusiEntry = this.aw;
    if (localProfileBusiEntry != null)
    {
      this.aC.addOrUpdateBuisEntry(localProfileBusiEntry);
      return;
    }
    if ((this.e.mCardHandler != null) && (this.aC != null)) {}
    try
    {
      this.e.mCardHandler.a(this.aC.uin, 0, 1);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label57:
      break label57;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.nearby_people_card.", 2, "NumberFormatException");
    }
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
      QLog.d("NearbyProfileDisplayTribePanel", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new RelativeLayout(this.e);
    ((RelativeLayout)localObject1).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    Object localObject2 = new CustomImgView(this.e);
    ((CustomImgView)localObject2).setLayoutParams(new LinearLayout.LayoutParams(this.e.imageWidth, this.e.imageWidth));
    ((RelativeLayout)localObject1).addView((View)localObject2, new LinearLayout.LayoutParams(-1, -1));
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
    ((CustomImgView)localObject2).setOnClickListener(this.bB);
    if (AppSetting.e)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131905184));
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
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(this.br);
    if ((!this.bs) && (this.e.mMode == 3))
    {
      SavorTagIcon[] arrayOfSavorTagIcon = this.A;
      int i3 = 0;
      if (arrayOfSavorTagIcon != null)
      {
        i1 = 0;
        while (i1 < 4)
        {
          if (this.A[i1].d())
          {
            i1 = 1;
            break label73;
          }
          i1 += 1;
        }
      }
      int i1 = 0;
      label73:
      int i2 = i1;
      if (i1 == 0)
      {
        i2 = i1;
        if (this.B != null) {
          for (;;)
          {
            i2 = i1;
            if (i3 >= 3) {
              break;
            }
            if (this.B[i3].a())
            {
              i2 = 1;
              break;
            }
            i3 += 1;
          }
        }
      }
      if (i2 != 0)
      {
        this.bs = true;
        ReportController.b(this.e.app, "CliOper", "", "", "0X8005549", "0X8005549", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.br = paramInt;
    if (this.br == 0) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("prepare2ScoreAnim() diff=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("Charm", 2, ((StringBuilder)localObject).toString());
    }
    TextView localTextView = (TextView)this.aM.findViewById(2131431987);
    if (localTextView.getTag() == null)
    {
      localObject = new Rect();
      localTextView.setTag(localObject);
    }
    else
    {
      localObject = (Rect)localTextView.getTag();
    }
    View localView = this.e.getWindow().getDecorView();
    localTextView.getGlobalVisibleRect((Rect)localObject);
    if (((Rect)localObject).bottom < localView.getHeight())
    {
      a(localTextView);
      this.e.mHandler.sendEmptyMessageDelayed(202, 2500L);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      try
      {
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.i.setVisibility(8);
        String str = FaceUtil.b(String.valueOf(this.aC.uin));
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
        if (this.bt != null) {
          this.bt.a(this.e.mPicInfo);
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
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = this.e.bigImageWidth - this.e.mDensity * 150.0F;
    Animation localAnimation;
    if ((paramInt2 > paramInt4) && (paramInt2 >= f1) && (this.bb.getVisibility() == 8)) {
      localAnimation = this.bg;
    } else if ((paramInt2 < paramInt4) && (paramInt2 <= f1) && (this.bb.getVisibility() == 0)) {
      localAnimation = this.bh;
    } else {
      localAnimation = null;
    }
    if ((localAnimation != null) && (localAnimation != this.bb.getAnimation()))
    {
      localAnimation.reset();
      this.bb.startAnimation(localAnimation);
      this.bf.startAnimation(localAnimation);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    long l2;
    if (paramInt1 != 1000) {
      if (paramInt1 != 1018)
      {
        if (paramInt1 != 1028) {
          return;
        }
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
        l2 = 0L;
      }
    }
    try
    {
      l1 = Long.parseLong(this.aC.uin);
    }
    catch (Exception localException)
    {
      long l1;
      label120:
      StringBuilder localStringBuilder;
      break label120;
    }
    l1 = l2;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnActivityResult req NearbyLikeLimitInfo: mCard.uin=");
      localStringBuilder.append(this.aC.uin);
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
  }
  
  protected void a(View paramView)
  {
    this.aE = paramView;
    this.bm = ((RelativeLayout)this.aE.findViewById(2131436918));
    this.bn = ((RelativeLayout)this.aE.findViewById(2131436921));
    this.bo = ((LinearLayout)this.aE.findViewById(2131436948));
    this.u = ((TextView)this.aE.findViewById(2131447250));
    this.v = ((TextView)this.aE.findViewById(2131447181));
    this.w = ((TextView)this.aE.findViewById(2131447137));
    this.x = ((TextView)this.aE.findViewById(2131447140));
    this.y = ((TextView)this.aE.findViewById(2131448981));
    this.bj = ((RelativeLayout)this.aE.findViewById(2131436947));
    this.bl = ((RelativeLayout)this.aE.findViewById(2131437028));
    paramView = this.e.getResources();
    this.ag = paramView.getDimensionPixelSize(2131298121);
    this.ah = paramView.getDimensionPixelSize(2131298120);
    this.af = ((LinearLayout)this.aE.findViewById(2131449954));
    this.ae = new RedTouch(this.e, this.bl).c(21).b(30.0F).a();
    this.bk = new URLImageView[] { (URLImageView)this.aE.findViewById(2131435584), (URLImageView)this.aE.findViewById(2131435585), (URLImageView)this.aE.findViewById(2131435586) };
    this.aV = ((ImageView)this.aE.findViewById(2131435630));
    this.aD = ((TextView)this.aE.findViewById(2131448989));
    this.aF = ((NearbyCardVoteView)this.aE.findViewById(2131449991));
    if (this.aa) {
      this.aF.setVisibility(8);
    }
    this.aG = ((HeartLayout)this.aE.findViewById(2131435008));
    this.aH = ((BounceScrollView)this.aE.findViewById(2131429717));
    this.aX = ((TextView)this.aE.findViewById(2131447116));
    this.aY = ((TextView)this.aE.findViewById(2131447166));
    this.aZ = ((TextView)this.aE.findViewById(2131447115));
    this.ba = ((TextView)this.aE.findViewById(2131450351));
    this.k = ((TextView)this.aE.findViewById(2131447187));
    this.l = ((TextView)this.aE.findViewById(2131447183));
    this.m = ((TextView)this.aE.findViewById(2131447182));
    this.n = ((RelativeLayout)this.aE.findViewById(2131436955));
    this.o = ((RelativeLayout)this.aE.findViewById(2131436903));
    this.p = ((RelativeLayout)this.aE.findViewById(2131436943));
    this.q = ((RelativeLayout)this.aE.findViewById(2131436899));
    this.aM = ((RelativeLayout)this.aE.findViewById(2131431925));
    this.aN = ((TextView)this.aE.findViewById(2131447113));
    this.aO = this.aE.findViewById(2131445041);
    this.aS = ((TextView)this.aE.findViewById(2131436227));
    this.aP = ((TextView)this.aE.findViewById(2131436180));
    this.aQ = ((TextView)this.aE.findViewById(2131436211));
    this.aR = ((ImageView)this.aE.findViewById(2131436202));
    this.aU = ((URLImageView)this.aE.findViewById(2131435633));
    this.aU.setColorFilter(436207616);
    this.f = ((CustomImgView)this.aE.findViewById(2131435652));
    this.g = ((ImageView)this.aE.findViewById(2131435653));
    this.h = ((ImageView)this.aE.findViewById(2131435642));
    this.i = ((ImageView)this.aE.findViewById(2131435643));
    if (this.aa)
    {
      paramView = this.aE.findViewById(2131449301);
      localObject = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = DisplayUtil.a(this.e, 90.0F);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    this.bf = ((ImmersiveTitleBar2)this.aE.findViewById(2131447582));
    this.aI = ((LinearLayout)this.aE.findViewById(2131429654));
    this.aK = this.aE.findViewById(2131429714);
    paramView = (ImageView)this.aK.findViewById(2131439400);
    Object localObject = (ImageView)this.aK.findViewById(2131449433);
    ImageView localImageView = (ImageView)this.aK.findViewById(2131437182);
    NearbyProfileDisplayTribePanel.2 local2 = new NearbyProfileDisplayTribePanel.2(this, paramView, (ImageView)localObject, localImageView);
    paramView.setOnClickListener(local2);
    ((ImageView)localObject).setOnClickListener(local2);
    localImageView.setOnClickListener(local2);
    if (ThemeUtil.isNowThemeIsNight(this.e.app, false, null))
    {
      paramView.setImageResource(2130847196);
      ((ImageView)localObject).setImageResource(2130847198);
      localImageView.setImageResource(2130847194);
      this.aK.setBackgroundColor(0);
    }
    this.aJ = ((LinearLayout)this.aE.findViewById(2131435155));
    this.j = ((RelativeLayout)this.aE.findViewById(2131436954));
    this.aW = ((TextView)this.aE.findViewById(2131447186));
    this.aL = ((Button)this.aE.findViewById(2131429875));
    paramView = (RelativeLayout)this.aE.findViewById(2131439324);
    if (ThemeUtil.isNowThemeIsNight(this.e.app, false, null)) {
      paramView.setBackgroundResource(2130847152);
    } else {
      paramView.setBackgroundResource(2130847151);
    }
    this.aT = ((AvatarWallViewPager)this.aE.findViewById(2131429042));
    paramView = new RelativeLayout.LayoutParams(-1, -2);
    paramView.addRule(12);
    paramView.bottomMargin = UIUtils.a(this.e, 28.0F);
    this.aT.setDotLayoutParams(paramView);
    this.bb = ((RelativeLayout)this.aE.findViewById(2131445045));
    this.bd = ((LinearLayout)this.aE.findViewById(2131447848));
    this.bc = ((LinearLayout)this.aE.findViewById(2131437587));
    this.aq = this.aE.findViewById(2131444986);
    this.be = ((ImageView)this.aE.findViewById(2131435641));
    if (this.e.mMode == 3)
    {
      this.bl.setVisibility(8);
      this.bj.setVisibility(8);
      this.j.setVisibility(8);
      this.bo.setVisibility(8);
    }
    paramView = (LinearLayout.LayoutParams)((RelativeLayout)this.aE.findViewById(2131444964)).getLayoutParams();
    if (paramView != null) {
      paramView.height = this.e.bigImageWidth;
    }
    this.f.setBackgroundDrawable(this.e.getResources().getDrawable(2130846497));
    this.bf.setVisibility(4);
    this.aH.setVerticalScrollBarEnabled(false);
    paramView = this.aH;
    paramView.mScrollFlag = 1;
    paramView.setOnScrollChangedListener(this);
    this.bg = new AlphaAnimation(0.0F, 1.0F);
    this.bg.setDuration(300L);
    this.bg.setAnimationListener(this.bz);
    this.bg.setInterpolator(new AccelerateInterpolator());
    this.bh = new AlphaAnimation(1.0F, 0.0F);
    this.bh.setDuration(300L);
    this.bh.setAnimationListener(this.bz);
    this.bh.setInterpolator(new AccelerateInterpolator());
    this.aP.setVisibility(0);
    this.aP.setText(2131887440);
    this.aP.setOnClickListener(new NearbyProfileDisplayTribePanel.3(this));
    this.aG.setEnabled(false);
    this.aF.setAppInterface(this.e.app);
    this.bp = ((LinearLayout)this.aE.findViewById(2131437004));
    this.bx = ((LinearLayout)this.aE.findViewById(2131437799));
    this.bx.setOnClickListener(new NearbyProfileDisplayTribePanel.4(this));
    this.by = ((TextView)this.aE.findViewById(2131448399));
    this.bw = new NearbyTribeAppController(this.b, this.e.app);
    this.bw.a(this.by);
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
      ThreadManager.post(new NearbyProfileDisplayTribePanel.28(this, paramInt), 5, null, false);
      return;
    }
    if (NearbyUtils.b()) {
      NearbyUtils.a("NearbyProfileDisplayTribePanel", new Object[] { "onTagClick", Integer.valueOf(this.e.mMode), Integer.valueOf(paramInt), paramInterestTagInfo });
    }
  }
  
  public void a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.aC = paramNearbyPeopleCard;
    paramNearbyPeopleCard = this.aC;
    if (paramNearbyPeopleCard == null) {
      return;
    }
    Object localObject1 = this.aF;
    if (localObject1 != null) {
      ((NearbyCardVoteView)localObject1).setNearbyPeopleCard(paramNearbyPeopleCard);
    }
    paramNearbyPeopleCard = SharedPreUtils.O(this.e);
    if (!TextUtils.isEmpty(paramNearbyPeopleCard)) {
      try
      {
        this.at = new JSONObject(paramNearbyPeopleCard).getString("ownerLikeJumpURL");
      }
      catch (JSONException paramNearbyPeopleCard)
      {
        paramNearbyPeopleCard.printStackTrace();
      }
    }
    this.aU.setContentDescription(this.aC.nickname);
    boolean bool = this.au;
    int i3 = 0;
    if (!bool)
    {
      this.au = true;
      this.z = this.e.getResources().getStringArray(2130968668);
      this.A = new SavorTagIcon[4];
      this.B = new SavorTagImg[3];
      this.D = new RelativeLayout[3];
      this.C = new RelativeLayout[4];
      this.G = new InterestTag[7];
      for (i1 = 0; i1 < 7; i1 = i2)
      {
        paramNearbyPeopleCard = this.G;
        i2 = i1 + 1;
        paramNearbyPeopleCard[i1] = new InterestTag(i2);
      }
      i2 = this.e.getResources().getColor(2131167993);
      i1 = 0;
      while (i1 < 4)
      {
        this.C[i1] = ((RelativeLayout)((ViewStub)this.aE.findViewById(this.E[i1])).inflate());
        this.A[i1] = ((SavorTagIcon)this.C[i1].findViewById(2131445245));
        this.A[i1].a(this.z[i1], this.G[i1].a, this.G[i1].b, this);
        this.A[i1].setRightArrowVisible(false);
        this.A[i1].setTitleTextColor(i2);
        if (AppSetting.e) {
          this.A[i1].setClickable(true);
        }
        i1 += 1;
      }
      i1 = 0;
      while (i1 < 3)
      {
        this.D[i1] = ((RelativeLayout)((ViewStub)this.aE.findViewById(this.F[i1])).inflate());
        i4 = i1 + 4;
        this.B[i1] = ((SavorTagImg)this.D[i1].findViewById(2131445245));
        this.B[i1].a(this.z[i4], this.G[i4].a, this.G[i4].b, this);
        this.B[i1].setRightArrowVisible(false);
        this.B[i1].setTitleTextColor(i2);
        if (AppSetting.e) {
          this.B[i1].setClickable(true);
        }
        i1 += 1;
      }
    }
    if (this.r == null)
    {
      this.r = ((RelativeLayout)((ViewStub)this.aE.findViewById(2131436994)).inflate());
      this.s = ((SavorTagImg)this.r.findViewById(2131445245));
    }
    Object localObject2 = this.e.app;
    paramNearbyPeopleCard = new StringBuilder();
    localObject1 = "";
    paramNearbyPeopleCard.append("");
    paramNearbyPeopleCard.append(this.aC.uin);
    Object localObject3 = paramNearbyPeopleCard.toString();
    if (this.e.mMode == 2) {
      paramNearbyPeopleCard = "1";
    } else {
      paramNearbyPeopleCard = "2";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.e.from % 20);
    ReportController.b((AppRuntime)localObject2, "dc00899", "grp_lbs", (String)localObject3, "data_card", "exp", 0, 0, paramNearbyPeopleCard, localStringBuilder.toString(), "", "");
    if (this.e.mMode != 2)
    {
      this.bl.setVisibility(8);
      this.j.setVisibility(8);
    }
    else
    {
      this.bl.setVisibility(0);
      this.j.setVisibility(0);
      this.bl.setOnClickListener(new NearbyProfileDisplayTribePanel.10(this));
      this.j.setOnClickListener(new NearbyProfileDisplayTribePanel.11(this));
      ((TroopGiftManager)this.e.app.getManager(QQManagerFactory.TROOP_GIFT_MANAGER)).a(1402, new NearbyProfileDisplayTribePanel.12(this));
      ReportController.b(null, "dc00899", "grp_lbs", "", "rank_data", "my_point", 0, 0, "", "", "", "");
    }
    if (NearbyProfileCardUtils.a(this.e.from))
    {
      this.al = this.aC.isForbidSendMsgForTribar;
      this.am = this.aC.isForbidSendGiftMsgForTribar;
      this.an = this.aC.disableSendMsgBtnTipsForTribar;
      this.ao = this.aC.disableSendGiftBtnTipsForTribar;
    }
    else
    {
      this.al = this.aC.isForbidSendMsg;
      this.am = this.aC.isForbidSendGiftMsg;
      this.an = this.aC.disableSendMsgBtnTips;
      this.ao = this.aC.disableSendGiftBtnTips;
    }
    this.ap = this.aC.highScoreNum;
    t();
    a(this.aC.nearbyInfo);
    y();
    l();
    paramNearbyPeopleCard = this.e.getResources();
    int i2 = paramNearbyPeopleCard.getColor(2131167993);
    int i4 = paramNearbyPeopleCard.getColor(2131168125);
    if ((!this.aC.isAuthUser()) && (!this.aC.isFuXiaoJin()))
    {
      this.aV.setVisibility(8);
      this.bb.findViewById(2131435655).setVisibility(8);
      this.bd.findViewById(2131435655).setVisibility(8);
    }
    else
    {
      this.bb.findViewById(2131435655).setVisibility(0);
      this.aV.setVisibility(0);
      this.aV.setImageResource(2130842206);
    }
    if (this.e.mMode != 2)
    {
      paramNearbyPeopleCard = (TextView)this.bo.findViewById(2131447181);
      localObject2 = new StringBuilder();
      if (this.aC.gender == 0) {
        i1 = 2131905159;
      } else {
        i1 = 2131905142;
      }
      ((StringBuilder)localObject2).append(HardCodeUtil.a(i1));
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131905190));
      paramNearbyPeopleCard.setText(((StringBuilder)localObject2).toString());
    }
    else
    {
      ((TextView)this.bo.findViewById(2131447181)).setText(HardCodeUtil.a(2131905138));
    }
    if (this.aC.iIsGodFlag == 1)
    {
      this.be.setVisibility(0);
      if (this.aC.gender == 1) {
        this.be.setImageResource(2130847556);
      } else {
        this.be.setImageResource(2130847555);
      }
      ThreadManager.post(new NearbyProfileDisplayTribePanel.13(this), 8, null, true);
    }
    else
    {
      this.be.setVisibility(8);
    }
    localObject2 = new StringBuilder();
    if (this.aC.gender == 0)
    {
      ((StringBuilder)localObject2).append("男 ");
      this.y.setBackgroundColor(-12348939);
    }
    else if (this.aC.gender == 1)
    {
      ((StringBuilder)localObject2).append("女 ");
      this.y.setBackgroundColor(-38511);
    }
    if (this.aC.age > 0)
    {
      paramNearbyPeopleCard = new StringBuilder();
      paramNearbyPeopleCard.append("");
      paramNearbyPeopleCard.append(this.aC.age);
      paramNearbyPeopleCard.append("岁 ");
      ((StringBuilder)localObject2).append(paramNearbyPeopleCard.toString());
    }
    if ((this.aC.age > 0) || (this.aC.gender == 0) || (this.aC.gender == 1))
    {
      localObject3 = this.e.app;
      if (this.e.mMode == 2) {
        paramNearbyPeopleCard = "1";
      } else {
        paramNearbyPeopleCard = "2";
      }
      ReportController.b((AppRuntime)localObject3, "dc00899", "grp_lbs", "", "data_card", "exp_info", 0, 0, paramNearbyPeopleCard, "", "", "");
    }
    if ((this.aC.constellation != 0) && (ProfileCardUtil.a(this.aC.constellation) != null))
    {
      paramNearbyPeopleCard = new StringBuilder();
      paramNearbyPeopleCard.append(ProfileCardUtil.a(this.aC.constellation));
      paramNearbyPeopleCard.append(" ");
      ((StringBuilder)localObject2).append(paramNearbyPeopleCard.toString());
      localObject3 = this.e.app;
      if (this.e.mMode == 2) {
        paramNearbyPeopleCard = "1";
      } else {
        paramNearbyPeopleCard = "2";
      }
      ReportController.b((AppRuntime)localObject3, "dc00899", "grp_lbs", "", "data_card", "exp_xing", 0, 0, paramNearbyPeopleCard, "", "", "");
    }
    if ((!StringUtil.isEmpty(NearbyProfileUtil.b(this.aC.maritalStatus - 1))) && (this.aC.maritalStatus != 1))
    {
      ((StringBuilder)localObject2).append(NearbyProfileUtil.b(this.aC.maritalStatus - 1));
      localObject3 = this.e.app;
      if (this.e.mMode == 2) {
        paramNearbyPeopleCard = "1";
      } else {
        paramNearbyPeopleCard = "2";
      }
      ReportController.b((AppRuntime)localObject3, "dc00899", "grp_lbs", "", "data_card", "exp_relation", 0, 0, paramNearbyPeopleCard, "", "", "");
    }
    if (((StringBuilder)localObject2).toString().length() > 0)
    {
      this.k.setText((CharSequence)localObject2);
      this.n.setVisibility(0);
    }
    else
    {
      this.n.setVisibility(8);
    }
    if (this.t == null) {
      this.t = FaceScoreUtils.a(this.e.getAppInterface());
    }
    if (this.t.a()) {
      ((NearbyFaceScoreManager)this.e.getAppInterface().getManager(QQManagerFactory.FACE_SCORE_MANAGER)).a(new NearbyProfileDisplayTribePanel.14(this));
    }
    if ((this.e.allinone.profileEntryType == 31) && (!TextUtils.isEmpty(this.e.allinone.aioDistance)) && (!TextUtils.isEmpty(this.aC.timeDiff)) && (this.e.mMode != 2))
    {
      paramNearbyPeopleCard = this.y;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.e.allinone.aioDistance);
      ((StringBuilder)localObject2).append("·");
      ((StringBuilder)localObject2).append(this.aC.timeDiff);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131905121));
      paramNearbyPeopleCard.setText(((StringBuilder)localObject2).toString());
      this.y.setVisibility(0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotChatDistance", 2, "bindData, use aioDistance");
      }
    }
    else if ((!TextUtils.isEmpty(this.aC.aioDistanceAndTime)) && (this.e.mMode != 2))
    {
      this.y.setText(this.aC.aioDistanceAndTime.replace(" ", "·"));
      this.y.setVisibility(0);
    }
    else if ((!TextUtils.isEmpty(this.aC.distance)) && (this.e.mMode != 2) && (!TextUtils.isEmpty(this.aC.distance)) && (!TextUtils.isEmpty(this.aC.timeDiff)))
    {
      paramNearbyPeopleCard = this.y;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.aC.distance);
      ((StringBuilder)localObject2).append("·");
      ((StringBuilder)localObject2).append(this.aC.timeDiff);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131905211));
      paramNearbyPeopleCard.setText(((StringBuilder)localObject2).toString());
      this.y.setVisibility(0);
    }
    if (QLog.isColorLevel())
    {
      paramNearbyPeopleCard = new StringBuilder();
      paramNearbyPeopleCard.append("bindData, mCard.videoInfo = ");
      paramNearbyPeopleCard.append(this.aC.videoInfo);
      QLog.d("NearbyProfileDisplayTribePanel", 2, paramNearbyPeopleCard.toString());
    }
    if ((((INearbyVideoUtils)QRoute.api(INearbyVideoUtils.class)).isAuthVideoEnable()) && (this.aC.videoInfo != null)) {
      a(this.aC.videoInfo.b, this.aC.videoInfo.e);
    }
    if (this.e.mMode == 3)
    {
      if (((this.aC.lUserFlag & 0x800) != 0L) && (this.aC.strRemark != null) && (!this.aC.strRemark.equals("")))
      {
        paramNearbyPeopleCard = this.aC.strRemark.trim();
      }
      else
      {
        paramNearbyPeopleCard = (NearbyPeopleCard)localObject1;
        if (this.aC.nickname != null) {
          paramNearbyPeopleCard = this.aC.nickname.trim();
        }
      }
    }
    else
    {
      paramNearbyPeopleCard = (NearbyPeopleCard)localObject1;
      if (this.aC.nickname != null) {
        paramNearbyPeopleCard = this.aC.nickname.trim();
      }
    }
    if (!TextUtils.isEmpty(paramNearbyPeopleCard)) {
      this.aD.setText(paramNearbyPeopleCard.trim());
    }
    if (this.e.mMode == 3)
    {
      this.aS.setVisibility(8);
      this.bc.setVisibility(0);
      ((TextView)this.bc.findViewById(2131449009)).setText(paramNearbyPeopleCard);
    }
    else if (this.e.mMode == 2)
    {
      this.bc.setVisibility(8);
      this.aS.setVisibility(0);
      this.aS.setText(HardCodeUtil.a(2131905174));
    }
    b(this.aC.xuanYan);
    if ((this.aC.charm == 0L) && (this.e.mMode == 3))
    {
      this.aM.setVisibility(8);
    }
    else
    {
      this.aM.setVisibility(0);
      this.aN.setText(this.aC.strLevelType);
      if (this.e.mMode == 2)
      {
        paramNearbyPeopleCard = this.aN;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.aC.mHeartNum);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131905179));
        paramNearbyPeopleCard.setText(((StringBuilder)localObject1).toString());
        this.aN.setTextColor(this.e.getResources().getColor(2131167993));
      }
      this.aM.setOnClickListener(this);
    }
    if (this.e.mMode != 2) {
      this.o.setBackgroundDrawable(null);
    }
    paramNearbyPeopleCard = this.aC;
    paramNearbyPeopleCard.company = StringUtil.trim(paramNearbyPeopleCard.company);
    if (StringUtil.isEmpty(this.aC.company))
    {
      if (this.e.mMode == 2)
      {
        this.aX.setTextColor(i4);
        this.aX.setText(HardCodeUtil.a(2131905195));
        this.o.setVisibility(0);
      }
      else
      {
        this.o.setVisibility(8);
        if (this.e.mMode == 2) {
          this.p.setBackgroundResource(2130852521);
        }
      }
    }
    else
    {
      this.aX.setTextColor(i2);
      this.aX.setText(new QQText(this.aC.company, 1, 16));
      this.o.setOnClickListener(null);
      this.o.setVisibility(0);
      ReportController.b(this.e.app, "dc00899", "grp_lbs", "", "data_card", "exp_company", 0, 0, "", "", "", "");
    }
    this.aY.setTextColor(i4);
    if ((this.aC.job > 0) && (this.aC.job < NearbyProfileUtil.e.length))
    {
      ReportController.b(this.e.app, "dc00899", "grp_lbs", "", "data_card", "exp_work", 0, 0, "", "", "", "");
      this.p.setVisibility(0);
      this.aY.setText(NearbyProfileUtil.e[this.aC.job]);
      this.aY.setTextColor(i2);
    }
    else if (this.e.mMode == 2)
    {
      this.aY.setText(HardCodeUtil.a(2131905220));
    }
    else
    {
      this.p.setVisibility(8);
      if ((this.o.getVisibility() == 8) && (this.e.mMode == 2)) {
        this.q.setBackgroundResource(2130852521);
      }
    }
    paramNearbyPeopleCard = this.aC;
    paramNearbyPeopleCard.college = StringUtil.trim(paramNearbyPeopleCard.college);
    if (StringUtil.isEmpty(this.aC.college))
    {
      if (this.e.mMode == 2)
      {
        this.aZ.setTextColor(i4);
        this.aZ.setText(HardCodeUtil.a(2131905113));
        this.q.setVisibility(0);
      }
      else
      {
        this.q.setVisibility(8);
      }
    }
    else
    {
      this.aZ.setTextColor(i2);
      this.aZ.setText(new QQText(this.aC.college, 1, 16));
      this.q.setOnClickListener(null);
      this.q.setVisibility(0);
      ReportController.b(this.e.app, "dc00899", "grp_lbs", "", "data_card", "exp_school", 0, 0, "", "", "", "");
    }
    z();
    if (this.e.mMode == 3)
    {
      if (this.aa)
      {
        this.aI.setVisibility(8);
        this.aJ.setVisibility(8);
        this.aK.setVisibility(0);
        new ReportTask(this.e.app).a("dc00899").b("grp_lbs").c("data_card").d("exp_face_score").e(this.e.allinone.uin).a();
      }
      else
      {
        this.aI.setVisibility(0);
        this.aJ.setVisibility(8);
        this.aK.setVisibility(8);
        m();
      }
    }
    else
    {
      this.aI.setVisibility(8);
      this.aJ.setVisibility(0);
      this.aK.setVisibility(8);
      r();
    }
    x();
    n();
    this.aC.getTagInfos(this.G);
    int i1 = 0;
    for (;;)
    {
      i2 = i3;
      if (i1 >= 4) {
        break;
      }
      this.A[i1].a(this.G[i1].b);
      if (AppSetting.e)
      {
        paramNearbyPeopleCard = this.A;
        paramNearbyPeopleCard[i1].setContentDescription(paramNearbyPeopleCard[i1].getContentsDesc());
      }
      i1 += 1;
    }
    while (i2 < 3)
    {
      this.B[i2].a(this.G[(i2 + 4)].b);
      if (AppSetting.e)
      {
        paramNearbyPeopleCard = this.B;
        paramNearbyPeopleCard[i2].setContentDescription(paramNearbyPeopleCard[i2].getContentsDesc());
      }
      i2 += 1;
    }
    v();
    new StringBuilder();
    w();
  }
  
  public void a(PicInfo paramPicInfo, RelativeLayout paramRelativeLayout)
  {
    CustomImgView localCustomImgView = (CustomImgView)paramRelativeLayout.getChildAt(0);
    paramRelativeLayout = (ImageView)paramRelativeLayout.getChildAt(1);
    Object localObject = this.e.getResources().getDrawable(2130853313);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = this.e.bigImageWidth;
    localURLDrawableOptions.mRequestHeight = this.e.bigImageWidth;
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
    localURLDrawableOptions.mUseMemoryCache = false;
    if (ShortVideoUtils.isVideoSoLibLoaded())
    {
      localObject = new VideoDrawable.VideoDrawableParams();
      ((VideoDrawable.VideoDrawableParams)localObject).mPlayVideoFrame = true;
      ((VideoDrawable.VideoDrawableParams)localObject).mRequestedFPS = this.e.mDynamicAvatarFPS;
      localURLDrawableOptions.mExtraInfo = localObject;
      localCustomImgView.setImageDrawable(URLDrawable.getDrawable(DynamicAvatarDownloadManager.d(paramPicInfo.e), localURLDrawableOptions));
    }
    else if (!TextUtils.isEmpty(paramPicInfo.b))
    {
      localCustomImgView.setImageDrawable(URLDrawable.getDrawable(paramPicInfo.b, localURLDrawableOptions));
    }
    if (paramRelativeLayout.getVisibility() == 0) {
      paramRelativeLayout.setVisibility(8);
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    this.aC.videoInfo.e = paramString2;
    this.aC.videoInfo.b = paramString1;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = URLDrawable.URLDrawableOptions.obtain();
      paramString1.mRequestWidth = AIOUtils.b(43.0F, this.e.getResources());
      paramString1.mRequestHeight = AIOUtils.b(43.0F, this.e.getResources());
      paramString1.mFailedDrawable = ImageUtil.j();
      paramString1.mLoadingDrawable = ImageUtil.j();
      paramString1.mMemoryCacheKeySuffix = "NearbyVideoRoundIcon";
      paramString1 = URLDrawable.getDrawable(this.aC.videoInfo.b, paramString1);
      paramString1.setDecodeHandler(URLDrawableDecodeHandler.b);
      if (paramString1.getStatus() != 1) {
        paramString1.restartDownload();
      }
    }
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
      QLog.d("NearbyProfileDisplayTribePanel", 2, ((StringBuilder)localObject).toString());
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
            QLog.e("NearbyProfileDisplayTribePanel", 2, "onDownloadVideoHeadFinish went error .., holder is null or holder.data is null");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("NearbyProfileDisplayTribePanel", 2, "onDownloadVideoHeadFinish went error .., view is not a instance of RelativeLayout");
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideCharmChanged() showAnim=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Charm", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (TextView)this.aM.findViewById(2131431987);
    if (paramBoolean)
    {
      int i1 = ((TextView)localObject).getWidth();
      int i2 = ((TextView)localObject).getHeight();
      ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, i1 / 2, i2 / 2);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.setInterpolator(this.e, 17432584);
      localAnimationSet.addAnimation(localScaleAnimation);
      localAnimationSet.addAnimation(localAlphaAnimation);
      localAnimationSet.setDuration(1500L);
      localAnimationSet.setFillAfter(true);
      localAnimationSet.setFillBefore(false);
      ((TextView)localObject).setAnimation(localAnimationSet);
      localAnimationSet.start();
      return;
    }
    ((TextView)localObject).setVisibility(4);
  }
  
  public void a(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList)
  {
    ProfileBusiEntry localProfileBusiEntry;
    if ((paramBoolean) && (paramList != null) && (paramList.size() != 0) && (paramInt == 0))
    {
      paramList = (ShowExternalTroop)paramList.get(0);
      this.av = paramList.troopUin;
      this.aw = new ProfileBusiEntry();
      localProfileBusiEntry = this.aw;
      localProfileBusiEntry.nBusiEntryType = 1024;
      localProfileBusiEntry.strTitle = this.e.getResources().getString(2131893930);
      this.aw.strContent = paramList.troopName;
      this.aw.strLogoUrl = paramList.strFaceUrl;
      if ((this.aC != null) && (this.aw.strContent != null))
      {
        this.aC.addOrUpdateBuisEntry(this.aw);
        if (this.e.mMode == 2)
        {
          ReportController.b(this.e.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.av, "1", "", "");
          return;
        }
        ReportController.b(this.e.app, "P_CliOper", "Grp_join", "", "person_data", "exp", 0, 0, this.av, "0", "", "");
      }
      return;
    }
    paramList = this.aC;
    if (paramList != null)
    {
      localProfileBusiEntry = this.aw;
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
    if (paramArrayOfByte == null)
    {
      this.bn.setVisibility(8);
      this.bm.setVisibility(8);
      this.bj.setVisibility(8);
      this.bo.setVisibility(8);
      this.r.setVisibility(8);
      return;
    }
    Object localObject2 = new nearby.Cmd0x1RspBody();
    try
    {
      ((nearby.Cmd0x1RspBody)localObject2).mergeFrom(paramArrayOfByte);
      localObject1 = ((nearby.Cmd0x1RspBody)localObject2).bytes_bars_url.get().toStringUtf8();
      this.as = ((nearby.Cmd0x1RspBody)localObject2).bytes_qunlist_url.get().toStringUtf8();
      this.bu = ((nearby.Cmd0x1RspBody)localObject2).bytes_chat_sig.get().toByteArray();
      this.e.app.getMsgCache().h(this.aC.uin, this.bu);
      this.bv = ((nearby.Cmd0x1RspBody)localObject2).bool_follow.get();
      int i1 = ((nearby.Cmd0x1RspBody)localObject2).uint32_if_mask_msg.get();
      boolean bool2 = true;
      int i2 = 0;
      boolean bool1;
      if (i1 == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.al = bool1;
      if (((nearby.Cmd0x1RspBody)localObject2).uint32_if_mask_gift.get() == 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      this.am = bool1;
      paramArrayOfByte = ((nearby.Cmd0x1RspBody)localObject2).bytes_feed_wording_title.get().toStringUtf8();
      Object localObject3 = ((nearby.Cmd0x1RspBody)localObject2).bytes_feed_wording.get().toStringUtf8();
      this.l.setText(paramArrayOfByte);
      paramArrayOfByte = MsgBoxUtil.b((String)localObject3);
      this.m.setText(MsgBoxUtil.a(paramArrayOfByte, 16));
      if (((nearby.Cmd0x1RspBody)localObject2).bytes_mask_msg_reason.has()) {
        this.an = ((nearby.Cmd0x1RspBody)localObject2).bytes_mask_msg_reason.get().toStringUtf8();
      }
      if (((nearby.Cmd0x1RspBody)localObject2).bytes_mask_gift_reason.has()) {
        this.ao = ((nearby.Cmd0x1RspBody)localObject2).bytes_mask_gift_reason.get().toStringUtf8();
      }
      localObject3 = new ArrayList();
      if ((((nearby.Cmd0x1RspBody)localObject2).rpt_BarInfo_bars.has()) && (((nearby.Cmd0x1RspBody)localObject2).rpt_BarInfo_bars.get().size() > 0))
      {
        this.r.setVisibility(0);
        paramArrayOfByte = ((nearby.Cmd0x1RspBody)localObject2).rpt_BarInfo_bars.get().iterator();
      }
      Object localObject4;
      while (paramArrayOfByte.hasNext())
      {
        localObject4 = (nearby.BarInfo)paramArrayOfByte.next();
        if (((ArrayList)localObject3).size() < 12)
        {
          InterestTagInfo localInterestTagInfo = new InterestTagInfo();
          localInterestTagInfo.tagName = ((nearby.BarInfo)localObject4).bytes_bar_name.get().toStringUtf8();
          localInterestTagInfo.tagIconUrl = ((nearby.BarInfo)localObject4).bytes_bar_pic.get().toStringUtf8();
          localInterestTagInfo.tagJumpUrl = ((nearby.BarInfo)localObject4).bytes_bar_url.get().toStringUtf8();
          localInterestTagInfo.tagType = 10;
          ((ArrayList)localObject3).add(localInterestTagInfo);
          continue;
          this.r.setVisibility(8);
        }
      }
      i1 = ((nearby.Cmd0x1RspBody)localObject2).uint32_bars_num.get();
      if (i1 > 12)
      {
        if (((ArrayList)localObject3).size() > 11)
        {
          ((ArrayList)localObject3).remove(11);
        }
        else if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("buluo num > 12 but the list's size < 12??? buluoNum:");
          paramArrayOfByte.append(i1);
          paramArrayOfByte.append("   list.Size:");
          paramArrayOfByte.append(((ArrayList)localObject3).size());
          QLog.w("NearbyProfileDisplayTribePanel", 2, paramArrayOfByte.toString());
        }
        paramArrayOfByte = new InterestTagInfo();
        paramArrayOfByte.tagName = " ";
        paramArrayOfByte.tagIconUrl = "icon_more_url";
        paramArrayOfByte.tagJumpUrl = "icon_more_url";
        paramArrayOfByte.tagType = 10;
        ((ArrayList)localObject3).add(paramArrayOfByte);
        localObject4 = this.e.app;
        if (this.e.mMode == 2) {
          paramArrayOfByte = "1";
        } else {
          paramArrayOfByte = "2";
        }
        ReportController.b((AppRuntime)localObject4, "dc00899", "grp_lbs", "", "data_card", "exp_more_tribe", 0, 0, paramArrayOfByte, "", "", "");
      }
      if (this.s.d != null)
      {
        this.s.a((List)localObject3);
      }
      else
      {
        this.s.a(HardCodeUtil.a(2131905157), 10, (List)localObject3, new NearbyProfileDisplayTribePanel.6(this, (String)localObject1));
        this.s.setRightArrowVisible(false);
      }
      paramArrayOfByte = this.s.c;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131905196));
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(")");
      paramArrayOfByte.setText(((StringBuilder)localObject1).toString());
      if (this.e.mMode == 2)
      {
        localObject1 = (nearby.FansInfo)((nearby.Cmd0x1RspBody)localObject2).FansInfo_fans.get();
        i1 = ((nearby.FansInfo)localObject1).uint32_fans_num.get();
        int i3 = ((nearby.FansInfo)localObject1).uint32_follows_num.get();
        paramArrayOfByte = ((nearby.FansInfo)localObject1).bytes_fans_url.get().toStringUtf8();
        localObject1 = ((nearby.FansInfo)localObject1).bytes_follows_url.get().toStringUtf8();
        localObject3 = this.w;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(HardCodeUtil.a(2131905198));
        ((StringBuilder)localObject4).append(i1);
        ((StringBuilder)localObject4).append(HardCodeUtil.a(2131905218));
        ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
        localObject3 = this.x;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(HardCodeUtil.a(2131905199));
        ((StringBuilder)localObject4).append(i3);
        ((StringBuilder)localObject4).append(HardCodeUtil.a(2131905125));
        ((TextView)localObject3).setText(((StringBuilder)localObject4).toString());
        this.bm.setOnClickListener(new NearbyProfileDisplayTribePanel.7(this, paramArrayOfByte));
        this.bn.setOnClickListener(new NearbyProfileDisplayTribePanel.8(this, (String)localObject1));
      }
      else
      {
        this.bn.setVisibility(8);
        this.bm.setVisibility(8);
        this.bn.setVisibility(8);
      }
      if ((((nearby.Cmd0x1RspBody)localObject2).rpt_FeedInfo_feeds.has()) && (((nearby.Cmd0x1RspBody)localObject2).rpt_FeedInfo_feeds.get().size() > 0))
      {
        localObject3 = ((nearby.Cmd0x1RspBody)localObject2).rpt_FeedInfo_feeds.get();
        i2 = ((List)localObject3).size();
        if (((List)localObject3).size() > 0)
        {
          i1 = 0;
          while ((i1 < i2) && (i1 < 3))
          {
            paramArrayOfByte = URLDrawable.URLDrawableOptions.obtain();
            paramArrayOfByte.mLoadingDrawable = paramArrayOfByte.mFailedDrawable;
            paramArrayOfByte.mRequestWidth = ((int)(SavorTagImg.a[0] * this.e.mDensity));
            paramArrayOfByte.mRequestHeight = ((int)(SavorTagImg.a[0] * this.e.mDensity));
            if (!TextUtils.isEmpty(((nearby.FeedInfo)((List)localObject3).get(i1)).bytes_pic.get().toStringUtf8())) {
              try
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("");
                ((StringBuilder)localObject1).append(((nearby.FeedInfo)((List)localObject3).get(i1)).bytes_pic.get().toStringUtf8());
                paramArrayOfByte = URLDrawable.getDrawable(((StringBuilder)localObject1).toString(), paramArrayOfByte);
              }
              catch (Exception paramArrayOfByte)
              {
                QLog.w("NearbyProfileDisplayTribePanel", 2, paramArrayOfByte.toString());
              }
            } else {
              paramArrayOfByte = null;
            }
            localObject4 = this.bk[i1];
            localObject1 = paramArrayOfByte;
            if (paramArrayOfByte == null) {
              localObject1 = new ColorDrawable(this.e.getResources().getColor(2131166580));
            }
            ((URLImageView)localObject4).setImageDrawable((Drawable)localObject1);
            this.bk[i1].setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.bk[i1].setBackgroundColor(0);
            i1 += 1;
          }
        }
        i1 = 2;
        while ((i1 >= i2) && (i1 >= 0))
        {
          this.bk[i1].setVisibility(8);
          i1 -= 1;
        }
        this.bj.setVisibility(0);
        this.bo.setVisibility(0);
        i1 = i2;
      }
      else
      {
        i1 = 0;
        while (i1 < 3)
        {
          this.bk[i1].setVisibility(8);
          i1 += 1;
        }
        this.bj.setVisibility(8);
        this.bo.setVisibility(8);
        i1 = i2;
      }
      paramArrayOfByte = new NearbyProfileDisplayTribePanel.9(this, ((nearby.Cmd0x1RspBody)localObject2).bytes_feeds_url.get().toStringUtf8());
      this.bj.setOnClickListener(paramArrayOfByte);
      this.bo.setOnClickListener(paramArrayOfByte);
      if (this.bo.getVisibility() == 0)
      {
        localObject1 = this.e.app;
        if (this.e.mMode == 2) {
          paramArrayOfByte = "1";
        } else {
          paramArrayOfByte = "2";
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(i1);
        ReportController.b((AppRuntime)localObject1, "dc00899", "grp_lbs", "", "data_card", "exp_pub", 0, 0, paramArrayOfByte, "", ((StringBuilder)localObject2).toString(), "");
      }
      if (this.r.getVisibility() == 0)
      {
        localObject1 = this.e.app;
        if (this.e.mMode == 2) {
          paramArrayOfByte = "1";
        } else {
          paramArrayOfByte = "2";
        }
        ReportController.b((AppRuntime)localObject1, "dc00899", "grp_lbs", "", "data_card", "exp_tribe", 0, 0, paramArrayOfByte, "", "", "");
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Cmd0x1RspBody error !:");
        ((StringBuilder)localObject1).append(paramArrayOfByte);
        QLog.w("NearbyProfileDisplayTribePanel", 2, ((StringBuilder)localObject1).toString());
      }
      this.bn.setVisibility(8);
      this.bm.setVisibility(8);
      this.bj.setVisibility(8);
      this.bo.setVisibility(8);
      this.r.setVisibility(8);
    }
  }
  
  protected int b()
  {
    return 2131627571;
  }
  
  public void b(NearbyPeopleCard paramNearbyPeopleCard)
  {
    this.aC.vGiftInfo = paramNearbyPeopleCard.vGiftInfo;
  }
  
  public void c()
  {
    DownloadApi.a(this.bC);
  }
  
  void c(boolean paramBoolean)
  {
    Object localObject = this.aC;
    if ((localObject != null) && (((NearbyPeopleCard)localObject).shouldShowLikeBtn()))
    {
      this.aF.setVisibility(0);
      this.aF.setHeartLayout(this.aG);
      boolean bool1;
      if (this.e.mMode == 2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject = this.aF;
      boolean bool2;
      if (this.aC.bVoted != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      ((NearbyCardVoteView)localObject).a(bool1, bool2, this.aC.likeCount, this.aC.likeCountInc, null, true, paramBoolean, this.aC.praiseList);
      this.aF.setOnClickListener(this);
    }
    else
    {
      this.aF.setVisibility(4);
    }
    if (this.bi != null) {
      this.aF.j = false;
    }
  }
  
  public void d()
  {
    Object localObject = this.S;
    if (localObject != null) {
      ((ProfileQiqiLiveController)localObject).a(10);
    }
    DownloadApi.b(this.bC);
    this.aA.removeMessages(1);
    this.aA.removeMessages(2);
    this.aA.removeMessages(3);
    this.aA.removeMessages(4);
    this.aA.removeMessages(5);
    this.aA.removeMessages(6);
    this.aA.removeCallbacksAndMessages(null);
    localObject = this.aC;
    if ((localObject != null) && (((NearbyPeopleCard)localObject).uRoomid != 0L)) {
      ReportController.b(this.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "content_timer", 0, 0, this.aC.uin, "", "yes", "android");
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.e.isFriend) {
      this.Y.incrementAndGet();
    } else if (paramBoolean) {
      this.ab.incrementAndGet();
    } else {
      this.ac.incrementAndGet();
    }
    Object localObject = this.aC;
    ((NearbyPeopleCard)localObject).likeCount += 1;
    localObject = this.aC;
    ((NearbyPeopleCard)localObject).bAvailVoteCnt = ((short)(((NearbyPeopleCard)localObject).bAvailVoteCnt - 1));
    this.aC.bVoted = 1;
    if (!this.X.hasMessages(1))
    {
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      this.X.sendMessageDelayed((Message)localObject, 2000L);
    }
    this.e.mHasEverVote = true;
    c(paramBoolean);
  }
  
  public int e()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:629)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void e(boolean paramBoolean)
  {
    if ((this.am) && (!this.e.isFriend))
    {
      if (!TextUtils.isEmpty(this.ao)) {
        QQToast.makeText(this.e, this.ao, 0).show(this.e.getTitleBarHeight());
      }
      return;
    }
    this.I = true;
    NearbyPeopleProfileActivity.testGiftCount += 1;
    String str = this.e.allinone.uin;
    Object localObject2 = Utils.b(E());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    if (Friends.isValidUin(str))
    {
      localObject2 = NearbyURLSafeUtil.b(str);
      str = ((String)localObject1).toLowerCase();
      if (B() == 10002) {
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
    NewVoteAnimHelper localNewVoteAnimHelper = this.bi;
    if (localNewVoteAnimHelper != null) {
      return localNewVoteAnimHelper.e;
    }
    return false;
  }
  
  public void g()
  {
    NearbyCardVoteView localNearbyCardVoteView = this.aF;
    if (localNearbyCardVoteView != null) {
      localNearbyCardVoteView.a(true);
    }
  }
  
  public void h() {}
  
  public void i() {}
  
  public void j()
  {
    Object localObject = this.bi;
    if (localObject != null) {
      ((NewVoteAnimHelper)localObject).d();
    }
    localObject = this.aF;
    if (localObject != null) {
      ((NearbyCardVoteView)localObject).a(false);
    }
    if (this.X.hasMessages(1))
    {
      this.X.removeMessages(1);
      F();
    }
  }
  
  public void k()
  {
    Object localObject = this.bA;
    if (localObject != null)
    {
      localObject = (FaceDrawable)((WeakReference)localObject).get();
      if (localObject != null) {
        ((FaceDrawable)localObject).cancel();
      }
    }
    if (NearbyManagerHelper.a(this.e.app).g() != null) {
      NearbyManagerHelper.a(this.e.app).g().clear();
    }
    this.bw.b();
  }
  
  public void l()
  {
    Object localObject = this.aC;
    if ((localObject != null) && (((NearbyPeopleCard)localObject).shouldShowLikeBtn()) && (!this.aa))
    {
      this.aF.setVisibility(0);
      this.aF.setHeartLayout(this.aG);
      boolean bool1;
      if (this.e.mMode == 2) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject = this.aF;
      boolean bool2;
      if (this.aC.bVoted != 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      ((NearbyCardVoteView)localObject).a(bool1, bool2, this.aC.likeCount, this.aC.likeCountInc, null, false, false, this.aC.praiseList);
      this.aF.setOnClickListener(this);
    }
    else
    {
      this.aF.setVisibility(4);
    }
    if (this.bi != null) {
      this.aF.j = false;
    }
  }
  
  public void m()
  {
    DatingUtil.c(this.e.getClass().getSimpleName(), new Object[] { "card godflag is `", Boolean.valueOf(this.aC.godFlag), " sayhello flag is ", Integer.valueOf(this.aC.sayHelloFlag) });
    if ((this.aC.lUserFlag & 0x800) != 0L)
    {
      this.aI.getChildAt(0).setVisibility(8);
      this.aI.getChildAt(1).setVisibility(8);
      if (!this.Z) {
        b(2, 8);
      } else {
        this.aI.setVisibility(8);
      }
    }
    else
    {
      if ((this.e.allinone.pa != 41) && (this.e.allinone.pa != 42) && (this.e.allinone.profileEntryType != 14) && (this.e.allinone.pa != 86) && (this.e.allinone.pa != 87) && (this.e.allinone.pa != 88) && (this.e.allinone.pa != 79) && (this.e.allinone.pa != 75) && (this.e.allinone.pa != 89))
      {
        if (this.aC.uRoomid == 0L) {
          this.aI.getChildAt(0).setVisibility(8);
        } else {
          this.aI.getChildAt(2).setVisibility(8);
        }
      }
      else if ((this.aC.uRoomid == 0L) && (this.aC.shouldShowSendMsg())) {
        b(0, 36);
      } else {
        b(2, 40);
      }
      if (this.aC.uRoomid == 0L)
      {
        if ((this.e.allinone.pa == 75) && (this.e.allinone.chatCookie == null) && (!s())) {
          this.aI.getChildAt(2).setVisibility(8);
        } else if ((this.aC.shouldShowSendMsg()) && (!this.Z)) {
          b(2, 8);
        } else {
          this.aI.getChildAt(2).setVisibility(8);
        }
      }
      else if ((this.e.allinone.pa == 75) && (this.e.allinone.chatCookie == null) && (!s())) {
        this.aI.getChildAt(0).setVisibility(8);
      } else if ((this.aC.shouldShowSendMsg()) && (!this.Z)) {
        b(0, 8);
      } else {
        this.aI.getChildAt(0).setVisibility(8);
      }
      b(1, 60);
    }
    Button localButton;
    if ((!this.bv) && (this.aI.getChildAt(2).getVisibility() != 0))
    {
      localButton = (Button)this.aI.getChildAt(1).findViewById(2131448897);
      localButton.setTextColor(this.e.getResources().getColor(2131168041));
      localButton.setBackgroundDrawable(this.e.getResources().getDrawable(2130839460));
    }
    else
    {
      ((Button)this.aI.getChildAt(1).findViewById(2131448897)).setBackgroundDrawable(this.e.getResources().getDrawable(2130839499));
    }
    if ((this.aI.getChildAt(1).getVisibility() != 0) && (this.aI.getChildAt(2).getVisibility() != 0))
    {
      localButton = (Button)this.aI.getChildAt(0).findViewById(2131448897);
      localButton.setTextColor(this.e.getResources().getColor(2131168041));
      localButton.setBackgroundDrawable(this.e.getResources().getDrawable(2130839460));
    }
  }
  
  public void n()
  {
    Object localObject;
    if ((!this.e.mHasNewPhoto) && (TextUtils.isEmpty(this.aC.bVideoHeadUrl)))
    {
      this.aT.setVisibility(8);
    }
    else
    {
      this.aT.setVisibility(0);
      if (this.bt == null)
      {
        this.bt = new NearbyProfileDisplayTribePanel.AvatarWallAdapter(this, this.aT);
        this.aT.setAdapter(this.bt);
      }
      if (this.e.mHasNewPhoto)
      {
        this.bt.a(this.e.mPicInfo);
      }
      else if (!TextUtils.isEmpty(this.aC.bVideoHeadUrl))
      {
        localObject = new PicInfo();
        ((PicInfo)localObject).e = this.aC.bVideoHeadUrl;
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject);
        this.bt.a(localArrayList);
      }
    }
    if (this.e.mMode == 3) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "exp_head", 0, 0, (String)localObject, "", "", "");
  }
  
  public void o()
  {
    if (((this.e.mHeadSize == 640) || (this.e.mHeadSize == 0)) && (!TextUtils.isEmpty(this.e.mGetHeadUrl)) && (!this.e.mHasNewPhoto)) {
      this.e.downloadHDAvatar(this.aC.uin, this.e.mHeadSize, this.e.mGetHeadUrl, false);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = paramView.getTag();
    Object localObject1 = "";
    int i4 = 0;
    boolean bool = false;
    int i3 = 2;
    int i1;
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
        QLog.i("NearbyProfileDisplayTribePanel", 2, ((StringBuilder)localObject2).toString());
      }
      i1 = paramView.a;
      i2 = 8;
      if (i1 != 8) {
        if (i1 != 30) {
          if (i1 != 33) {
            if (i1 != 42) {
              if (i1 != 58) {
                if (i1 != 60) {
                  if ((i1 != 27) && (i1 != 28)) {
                    if (i1 != 36) {
                      if (i1 != 37) {
                        if (i1 != 39) {
                          if (i1 != 40) {
                            switch (i1)
                            {
                            default: 
                              return;
                            case 22: 
                              if ((paramView.b instanceof ProfileBusiEntry))
                              {
                                paramView = (ProfileBusiEntry)paramView.b;
                                if (!StringUtil.isEmpty(paramView.strJumpUrl)) {
                                  a(paramView.strJumpUrl);
                                }
                              }
                              ReportController.b(this.e.app, "CliOper", "", "", "0X80050CB", "0X80050CB ", ProfileEntryUtils.getProfileEntryType(this.e.allinone.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.e.allinone)), "", "", "");
                              return;
                            case 21: 
                              if ((paramView.b instanceof ProfileBusiEntry))
                              {
                                localObject2 = (ProfileBusiEntry)paramView.b;
                                if (!StringUtil.isEmpty(((ProfileBusiEntry)localObject2).strJumpUrl))
                                {
                                  paramView = new Intent(this.e, QQBrowserActivity.class);
                                  paramView.putExtra("portraitOnly", true);
                                  if (!StringUtil.isEmpty(((ProfileBusiEntry)localObject2).strJumpUrl)) {
                                    localObject1 = ((ProfileBusiEntry)localObject2).strJumpUrl;
                                  }
                                  paramView.putExtra("url", (String)localObject1);
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
      this.e.startActivity(paramView);
      label436:
      ReportController.b(this.e.app, "CliOper", "", "", "0X80050CC", "0X80050CC", ProfileEntryUtils.getProfileEntryType(this.e.allinone.profileEntryType), 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.e.allinone)), "", "", "");
      return;
      if (this.e.isFriend)
      {
        paramView = this.aC;
        if ((paramView != null) && (!TextUtils.isEmpty(paramView.uin)))
        {
          paramView = this.aC.uin;
          localObject1 = this.aC.nickname;
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
        if (this.S != null)
        {
          if (this.aC == null) {
            return;
          }
          if (!NetworkUtil.isNetSupport(this.e))
          {
            QQToast.makeText(this.e, 2131889169, 0).show(this.e.getResources().getDimensionPixelSize(2131299920));
            return;
          }
          if (PackageUtil.a(this.e, "com.guagua.qiqi"))
          {
            this.S.a(this.aC.uRoomid);
            ReportController.b(this.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "click_bootstrap", 0, 0, this.aC.uin, "", "yes", "android");
            return;
          }
          if (this.U == 1)
          {
            paramView = this.T;
            if (paramView != null) {
              paramView.setText(2131897193);
            }
            this.S.a(3);
            this.U = 2;
            ReportController.b(this.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_pause", 0, 0, this.aC.uin, "", "yes", "android");
            return;
          }
          if (NetworkUtil.isWifiConnected(this.e))
          {
            if (this.V)
            {
              paramView = this.e;
              DialogUtil.a(paramView, 230, paramView.getString(2131896712), this.e.getString(2131896711), 0, 2131897194, new NearbyProfileDisplayTribePanel.19(this), null).show();
              this.V = false;
              ReportController.b(this.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_trigger", 0, 0, this.aC.uin, "", "yes", "android");
            }
            else
            {
              ReportController.b(this.e.app, "P_CliOper", "Grp_qiqiqun", "", "qiqi_qq_mob_nearby", "download_goon", 0, 0, this.aC.uin, "", "yes", "android");
            }
            this.S.a(2);
            i1 = this.U;
            if ((i1 == 2) || (i1 == 0)) {
              this.U = 1;
            }
          }
          else
          {
            i1 = this.U;
            if ((i1 != 2) && (i1 != 0))
            {
              this.S.a(2);
              return;
            }
            paramView = this.e;
            localObject1 = paramView.getString(2131896712);
            localObject2 = this.e.getString(2131896710);
            localObject3 = this.aB;
            DialogUtil.a(paramView, 230, (String)localObject1, (String)localObject2, (DialogInterface.OnClickListener)localObject3, (DialogInterface.OnClickListener)localObject3).show();
            this.U = 1;
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
              i1 = i2;
              if (((NearbyPeopleProfileActivity)localObject1).allinone.profileEntryType != 17)
              {
                i1 = i2;
                if (this.e.allinone.profileEntryType != 18) {
                  if (this.e.allinone.profileEntryType == 19) {
                    i1 = i2;
                  } else {
                    i1 = 4;
                  }
                }
              }
              i2 = i1;
              if (this.aC.iIsGodFlag == 1)
              {
                i2 = i3;
                if (this.aC.gender == 0) {
                  i2 = 1;
                }
                i2 = i1 | i2;
              }
              paramView.a(Long.parseLong(this.aC.uin), i2, this.e.allinone.chatCookie);
              if (this.e.mHandler != null)
              {
                this.e.mHandler.sendEmptyMessageDelayed(204, 1000L);
                return;
                e(false);
                if (this.e.app != null)
                {
                  if ((this.aC.iIsGodFlag == 1) && (this.aC.gender == 0))
                  {
                    ReportController.b(this.e.app, "CliOper", "", "", "0X800528A", "0X800528A", 0, 0, "", "", "", "");
                    return;
                  }
                  if ((this.aC.iIsGodFlag == 1) && (this.aC.gender == 1))
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
                      if (this.bv) {
                        paramView = "clk_followed";
                      } else {
                        paramView = "clk_follow";
                      }
                      ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", paramView, 0, 0, "", "", "", "");
                      ((INearbyCardManager)this.e.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).f().put(this.aC.uin, Integer.valueOf(1));
                      bool = NearbyProfileCardUtils.a(this.e.from);
                      if (bool) {
                        paramView = "1";
                      } else if (this.Z) {
                        paramView = "6";
                      } else {
                        paramView = "2";
                      }
                      if (!bool) {
                        bool = this.Z;
                      }
                      localObject2 = this.e.app;
                      localObject3 = this.aC.uin;
                      if (this.bv) {
                        localObject1 = "2";
                      } else {
                        localObject1 = "1";
                      }
                      NearbyHandler.a((QQAppInterface)localObject2, (String)localObject3, paramView, (String)localObject1, 1, new NearbyProfileDisplayTribePanel.18(this));
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
                                ReportController.b(this.e.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.av, "1", "", "");
                                return;
                              }
                              if (this.e.mMode == 3)
                              {
                                ReportController.b(this.e.app, "CliOper", "", "", "0X80050CF", "0X80050CF", 0, 0, this.av, "0", "", "");
                                return;
                                if ((this.al) && (!this.e.isFriend))
                                {
                                  if (QLog.isColorLevel())
                                  {
                                    paramView = new StringBuilder();
                                    paramView.append("sendMsgBtnClick, isSendMsgBtnDownloadAppOpen=");
                                    paramView.append(this.aC.isSendMsgBtnDownloadAppOpen);
                                    paramView.append(", sendMsgBtnDownloadAppTips:");
                                    paramView.append(this.aC.sendMsgBtnDownloadAppTips);
                                    paramView.append(", tribeAppDownloadPageUrl=");
                                    paramView.append(this.aC.tribeAppDownloadPageUrl);
                                    QLog.d("Q.nearby.tribeAppDownload", 2, paramView.toString());
                                  }
                                  if ((this.aC.isSendMsgBtnDownloadAppOpen) && (!TextUtils.isEmpty(this.aC.sendMsgBtnDownloadAppTips)) && (!TextUtils.isEmpty(this.aC.tribeAppDownloadPageUrl))) {
                                    NearbyCardManager.a(this.e, this.aC.sendMsgBtnDownloadAppTips, this.aC.tribeAppDownloadPageUrl, 1);
                                  } else if (!TextUtils.isEmpty(this.an)) {
                                    QQToast.makeText(this.e, this.an, 0).show(this.e.getTitleBarHeight());
                                  }
                                  ReportController.b(this.e.app, "dc00899", "grp_lbs", "", "data_card", "msg_fail", 0, 0, "", "", "", "");
                                  return;
                                }
                                ReportController.b(this.e.app, "dc00899", "grp_lbs", "", "data_card", "msg_suc", 0, 0, "", "", "", "");
                                this.J = true;
                                p();
                                ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_msg", 0, 0, "", "", "", "");
                                localObject2 = this.e.app;
                                i1 = this.e.allinone.profileEntryType;
                                localObject3 = this.aC;
                                paramView = (View)localObject1;
                                if (localObject3 != null)
                                {
                                  paramView = (View)localObject1;
                                  if (((NearbyPeopleCard)localObject3).uin != null) {
                                    paramView = this.aC.uin;
                                  }
                                }
                                ReportController.b((AppRuntime)localObject2, "CliOper", "", "", "0X8004826", "0X8004826", i1, 0, paramView, "", "", "");
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
      if (paramView == this.aF)
      {
        if (2 == this.e.mMode)
        {
          ReportController.b(this.e.app, "dc00899", "grp_lbs", "", "data_card", "clk_list", 0, 0, "", "", "", "");
          if (TextUtils.isEmpty(this.at))
          {
            paramView = new Intent(this.e, VisitorsActivity.class);
            localObject1 = this.aC;
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
            if (B() == 10002) {
              paramView = "6";
            } else {
              paramView = "1";
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(this.at);
            ((StringBuilder)localObject2).append("&SOURCETYPE=");
            ((StringBuilder)localObject2).append(paramView);
            ((StringBuilder)localObject2).append("&SIGN=");
            ((StringBuilder)localObject2).append(E());
            ((StringBuilder)localObject2).append("&UIN=");
            ((StringBuilder)localObject2).append(this.e.getAppInterface().getCurrentAccountUin());
            ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject2).toString());
            this.e.startActivity((Intent)localObject1);
          }
          NearbyProxy.a(this.e.app);
          paramView = this.aC;
          if (paramView != null)
          {
            paramView.likeCountInc = 0;
            l();
            this.e.app.execute(new NearbyProfileDisplayTribePanel.20(this));
          }
          paramView = this.bi;
          if (paramView != null) {
            paramView.e = true;
          }
          if (this.e.mEnterProfileIntent.getBooleanExtra("IS_NEARBY_REDDOT_INCOME", false)) {
            ReportController.b(this.e.app, "CliOper", "", "", "0X8005249", "0X8005249", 0, 0, "", "", "", "");
          }
          ReportController.b(this.e.app, "CliOper", "", "", "0X800657A", "0X800657A", 2, 0, Integer.toString(ProfileEntryUtils.getIdentityFlag(this.e.allinone)), "", "", "");
          if ((this.aF.a != null) && (this.aF.a.getVisibility() == 0)) {
            paramView = "1";
          } else {
            paramView = "2";
          }
          ReportController.b(this.e.app, "dc00898", "", "", "0X8007610", "0X8007610", 2, 0, paramView, "", "", "");
          return;
        }
        if (3 == this.e.mMode)
        {
          this.H = true;
          localObject1 = new HashMap();
          localObject2 = this.e.app.getCurrentAccountUin();
          if (this.aC == null)
          {
            paramView = this.e;
            paramView.showToast(paramView.getString(2131890920));
            ((HashMap)localObject1).put("param_FailCode", "-210");
            StatisticCollector.getInstance(this.e.app.getApp()).collectPerformance((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
            if (QLog.isColorLevel()) {
              QLog.i("NearbyProfileDisplayTribePanel", 2, "mCard is null,vote failed !");
            }
            return;
          }
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("Click Vote View, mCard.bAvailVoteCnt = ");
            paramView.append(this.aC.bAvailVoteCnt);
            paramView.append(",mCard.bHaveVotedCnt = ");
            paramView.append(this.aC.bHaveVotedCnt);
            paramView.append(",mCard.strVoteLimitedNotice = ");
            paramView.append(this.aC.strVoteLimitedNotice);
            QLog.i("NearbyProfileDisplayTribePanel", 2, paramView.toString());
          }
          if (this.aC.bAvailVoteCnt <= 0) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          i2 = i4;
          if (this.aC.bHaveVotedCnt <= 0)
          {
            i2 = i4;
            if (this.aC.bAvailVoteCnt <= 0) {
              i2 = 1;
            }
          }
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("Profile->onClickVote, uin=");
            paramView.append(this.aC.uin);
            paramView.append(", isFriend=");
            paramView.append(this.e.isFriend);
            paramView.append(", bAvailVoteCnt=");
            paramView.append(this.aC.bAvailVoteCnt);
            paramView.append(", bHaveVotedCnt=");
            paramView.append(this.aC.bHaveVotedCnt);
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
                localObject3 = this.aC.uin;
                localObject4 = new NearbyProfileDisplayTribePanel.21(this);
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(i3);
                localStringBuilder.append("");
                paramView.a((Activity)localObject1, localObject2, (String)localObject3, localObject4, localStringBuilder.toString());
              }
              else
              {
                d(true);
                this.ax = true;
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
            paramView.append(this.aC.uin);
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
            if (this.ax) {
              localObject2 = "2";
            } else {
              localObject2 = "1";
            }
            ReportController.b(null, "dc00899", "grp_lbs", (String)localObject3, "data_card", "like_head", 0, 0, paramView, (String)localObject4, (String)localObject1, (String)localObject2);
            ReportController.b(this.e.app, "CliOper", "", "", "0X8004825", "0X8004825", A(), 0, this.aC.uin, "", "", "");
            if (ProfileEntryUtils.isFromHotChat(this.e.allinone.profileEntryType)) {
              ReportController.b(this.e.app, "CliOper", "", "", "0X8005241", "0X8005241", 0, 0, "", "", "", "");
            }
          }
          else
          {
            if (this.aC.gender == 0) {
              i3 = 2131905208;
            } else {
              i3 = 2131905133;
            }
            paramView = HardCodeUtil.a(i3);
            if (!this.ar)
            {
              if (this.e.isFriend)
              {
                paramView = DialogUtil.a(this.e, 230, null, HardCodeUtil.a(2131905224), "", HardCodeUtil.a(2131899883), new NearbyProfileDisplayTribePanel.22(this), null);
              }
              else
              {
                localObject3 = this.e;
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append(HardCodeUtil.a(2131905118));
                ((StringBuilder)localObject4).append(paramView);
                ((StringBuilder)localObject4).append(HardCodeUtil.a(2131905200));
                paramView = DialogUtil.a((Context)localObject3, 230, null, ((StringBuilder)localObject4).toString(), HardCodeUtil.a(2131898212), HardCodeUtil.a(2131905186), new NearbyProfileDisplayTribePanel.23(this), new NearbyProfileDisplayTribePanel.24(this));
              }
              paramView.show();
              this.ar = true;
              paramView.setOnDismissListener(new NearbyProfileDisplayTribePanel.25(this));
            }
            ReportController.b(null, "dc00899", "grp_lbs", "", "data_like", "exp_toast", 0, 0, "", "", "", "");
            if (i2 != 0) {
              ReportController.b(this.e.app, "CliOper", "", "", "0X8006579", "0X8006579", 2, 0, Integer.toString(ProfileEntryUtils.getProfileEntryType(this.e.allinone.profileEntryType)), "", "", "");
            } else if (i1 != 0) {
              ReportController.b(this.e.app, "CliOper", "", "", "0X8006578", "0X8006578", 2, 0, Integer.toString(ProfileEntryUtils.getProfileEntryType(this.e.allinone.profileEntryType)), "", "", "");
            }
            StatisticCollector.getInstance(this.e.app.getApp()).collectPerformance((String)localObject2, "profileCardSendFavorite", false, 0L, 0L, (HashMap)localObject1, "", false);
          }
          if (this.aC.iIsGodFlag == 1)
          {
            if (this.aC.gender == 0)
            {
              ReportController.b(this.e.app, "CliOper", "", "", "0X800528C", "0X800528C", 1, 0, "", "", "", "");
              return;
            }
            if (this.aC.gender == 1) {
              ReportController.b(this.e.app, "CliOper", "", "", "0X800528D", "0X800528D", 1, 0, "", "", "", "");
            }
          }
        }
      }
      else if (paramView == this.f)
      {
        if (this.e.mMode == 2)
        {
          paramView = (Boolean)paramView.getTag();
          this.e.switchToEditPanel(100L);
          if ((paramView != null) && (!paramView.booleanValue())) {
            this.e.mHandler.postDelayed(new NearbyProfileDisplayTribePanel.26(this), 300L);
          }
          ReportController.b(this.e.app, "CliOper", "", "", "0X80050C9", "0X80050C9", 0, 0, "", "", "", "");
        }
        else if (this.e.mMode == 3)
        {
          localObject1 = new PicInfo();
          ((PicInfo)localObject1).d = this.e.app.getCustomFaceFilePath(32, String.valueOf(this.aC.uin), 200);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("on mode guest small head clicked: uin is: ");
            ((StringBuilder)localObject2).append(this.aC.uin);
            ((StringBuilder)localObject2).append(" local path is: ");
            ((StringBuilder)localObject2).append(((PicInfo)localObject1).d);
            QLog.e("Q.nearby_people_card.", 2, ((StringBuilder)localObject2).toString());
          }
          paramView = AnimationUtils.a(paramView);
          this.e.showBigPhoto((PicInfo)localObject1, paramView);
        }
        if (ProfileEntryUtils.isFromHotChat(this.e.allinone.profileEntryType)) {
          ReportController.b(this.e.app, "CliOper", "", "", "0X8005240", "0X8005240", 0, 0, "", "", "", "");
        }
      }
      else if (paramView == this.aM)
      {
        this.O = true;
        localObject1 = "https://buluo.qq.com/mobile/my_heart.html?from=zlk";
        if (this.e.mMode == 3)
        {
          paramView = NearbyURLSafeUtil.b(this.e.allinone.uin);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("https://buluo.qq.com/mobile/my_heart.html?from=zlk");
          ((StringBuilder)localObject1).append("&strangerUin=");
          ((StringBuilder)localObject1).append(paramView);
          paramView = ((StringBuilder)localObject1).toString();
          this.c = true;
        }
        else
        {
          paramView = (View)localObject1;
          if (this.e.mMode == 2)
          {
            this.c = true;
            paramView = (View)localObject1;
          }
        }
        if (this.e.mMode == 3) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
        ReportController.b(null, "dc00899", "grp_lbs", "", "rank_data", "clk_rank", 0, 0, (String)localObject1, "", "", "");
        if (this.e.mMode == 3) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
        ReportController.b(null, "dc00899", "grp_lbs", "", "data_card", "clk_rank", 0, 0, (String)localObject1, "", "", "");
        localObject1 = new Intent(this.e, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", paramView);
        this.e.startActivity((Intent)localObject1);
        if (this.e.mMode == 2)
        {
          ReportController.b(this.e.app, "CliOper", "", "", "0X80052AC", "0X80052AC", 0, 0, "", "", "", "");
          return;
        }
        if (this.e.mMode == 3) {
          ReportController.b(this.e.app, "CliOper", "", "", "0X80052AD", "0X80052AD", 0, 0, "", "", "", "");
        }
      }
      else if (paramView == this.be)
      {
        paramView = this.e.app.getCurrentAccountUin();
        if ((Friends.isValidUin(paramView)) && (Friends.isValidUin(this.aC.uin)))
        {
          bool = paramView.equals(this.aC.uin);
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
        if (paramView == this.aL)
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
        if (paramView != this.bp) {
          paramView = this.bq;
        }
      }
      return;
    }
    catch (SecurityException paramView)
    {
      break label436;
    }
  }
  
  public void p()
  {
    ThreadPriorityManager.a(true);
    int i1 = B();
    if (s())
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("finchat", true);
      this.e.setResult(0, (Intent)localObject);
      this.e.finish();
      return;
    }
    Object localObject = this.aC;
    if ((localObject != null) && (!StringUtil.isEmpty(((NearbyPeopleCard)localObject).uin))) {
      a(this.aC.uin, i1);
    }
  }
  
  void r()
  {
    this.aL.setOnClickListener(this);
  }
  
  boolean s()
  {
    return (Utils.a(this.e.allinone.preWinUin, this.e.allinone.uin)) && (this.e.allinone.preWinType != 3000) && (this.e.allinone.preWinType != 1) && (this.e.allinone.preWinType != 2);
  }
  
  public void t()
  {
    Oidb_0x66b.ReqBody localReqBody = new Oidb_0x66b.ReqBody();
    Object localObject = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(Long.parseLong(this.e.app.getCurrentUin())));
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.set(localArrayList);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_nick.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_stranger_nick.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_gender.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_god_flag.set(1);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_age.set(1);
    localReqBody.bytes_reqbody_5eb.set(ByteStringMicro.copyFrom(((oidb_0x5eb.ReqBody)localObject).toByteArray()));
    localReqBody.uint32_req_likeinfo.set(1);
    localReqBody.uint32_req_pansocialinfo.set(1);
    localReqBody.uint32_req_giftinfo.set(1);
    localReqBody.uint32_req_configinfo.set(1);
    localReqBody.uint32_req_visitor.set(3);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1643);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).str_client_version.set(AppSetting.h());
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    ProtoUtils.a(this.e.app, new NearbyProfileDisplayTribePanel.32(this), ((oidb_sso.OIDBSSOPkg)localObject).toByteArray(), "OidbSvc.0x66b");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel
 * JD-Core Version:    0.7.0.1
 */