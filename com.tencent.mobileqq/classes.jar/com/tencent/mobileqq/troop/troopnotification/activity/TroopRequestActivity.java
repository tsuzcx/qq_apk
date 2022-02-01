package com.tencent.mobileqq.troop.troopnotification.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msg.api.IMessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stranger.observer.StrangerObserver;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo;
import com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.IGeneralGroupNotifyParser;
import com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.InviteJoinGroupSecFrontParser.InviteJoinGroupSecFrontInfo;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils.TroopPrivilegeCallback;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopSuspiciousHelper;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopRemindSettingManager;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.MsgPayGroupExt;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopRequestActivity
  extends QIphoneTitleBarActivity
  implements AppConstants, DecodeTaskCompletionListener
{
  public static int O = 0;
  public static final int P;
  public static final int Q;
  public static final int R;
  public static final int S;
  public static final boolean Y = AppSetting.e;
  public static int a = 10;
  protected static long am = 0L;
  protected static long an = 0L;
  protected LinearLayout A;
  protected ImageView B;
  protected TextView C;
  protected TextView D;
  protected TextView E;
  protected LinearLayout F;
  protected TextView G;
  protected ImageView H;
  protected TextView I;
  protected TextView J;
  protected TextView K;
  protected TextView L;
  protected TextView M;
  protected TextView N;
  protected boolean T;
  protected Button U;
  protected Button V;
  protected structmsg.StructMsg W;
  protected String X;
  protected TextView Z;
  protected BaseMessageObserver aA;
  ProfileCardObserver aB;
  ProfileCardObserver aC;
  protected QQProgressDialog aD;
  View.OnClickListener aE;
  View.OnClickListener aF;
  View.OnClickListener aG;
  View.OnClickListener aH;
  View.OnClickListener aI;
  StrangerObserver aJ;
  TroopNotificationUtils.TroopPrivilegeCallback aK;
  private String aL;
  private TextView aM;
  private TextView aN;
  private LinearLayout aO;
  private LinearLayout aP;
  private LinearLayout aQ;
  private LinearLayout[] aR;
  private RelativeLayout[] aS;
  private View aT;
  private TextView aU;
  private ImageView aV;
  private AppInterface aW;
  private TextView aX;
  private View.OnClickListener aY;
  protected TextView aa;
  protected TextView ab;
  protected String ac;
  protected String ad;
  protected int ae;
  protected IFaceDecoder af;
  protected View ag;
  protected View ah;
  protected URLImageView ai;
  TextView aj;
  TextView ak;
  TextView al;
  protected boolean ao;
  protected boolean ap;
  protected ITroopMngHandler aq;
  int ar;
  int as;
  int at;
  protected TextView au;
  View.OnClickListener av;
  View.OnClickListener aw;
  Handler ax;
  protected TroopObserver ay;
  protected TroopMngObserver az;
  protected int b;
  protected String c;
  protected long d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  protected String i;
  protected String j;
  protected int k;
  protected String l;
  protected String m;
  protected String n;
  protected String o;
  protected SpannableStringBuilder p;
  protected String q;
  protected String r;
  protected String s;
  protected String t;
  protected short u;
  protected String v;
  protected String w;
  protected String x;
  protected TextView y;
  protected LinearLayout z;
  
  static
  {
    int i1 = O;
    O = i1 + 1;
    P = i1;
    i1 = O;
    O = i1 + 1;
    Q = i1;
    i1 = O;
    O = i1 + 1;
    R = i1;
    i1 = O;
    O = i1 + 1;
    S = i1;
  }
  
  public TroopRequestActivity()
  {
    int i1 = O;
    this.aR = new LinearLayout[i1];
    this.aS = new RelativeLayout[i1 - 1];
    this.W = null;
    this.X = null;
    this.ac = "";
    this.ad = "";
    this.ae = 0;
    this.af = null;
    this.ao = false;
    this.ap = false;
    this.ar = 0;
    this.as = 0;
    this.at = 0;
    this.av = new TroopRequestActivity.7(this);
    this.aw = new TroopRequestActivity.8(this);
    this.ax = new TroopRequestActivity.11(this);
    this.ay = new TroopRequestActivity.12(this);
    this.az = new TroopRequestActivity.13(this);
    this.aA = new TroopRequestActivity.14(this);
    this.aB = new TroopRequestActivity.15(this);
    this.aC = new TroopRequestActivity.16(this);
    this.aE = new TroopRequestActivity.17(this);
    this.aF = new TroopRequestActivity.18(this);
    this.aG = new TroopRequestActivity.19(this);
    this.aH = new TroopRequestActivity.20(this);
    this.aI = new TroopRequestActivity.21(this);
    this.aJ = new TroopRequestActivity.22(this);
    this.aK = new TroopRequestActivity.24(this);
    this.aY = new TroopRequestActivity.25(this);
  }
  
  public static int a(Context paramContext, String paramString)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append("show");
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static Dialog a(Context paramContext, View paramView)
  {
    paramContext = ActionSheet.create(paramContext, -1, null);
    paramContext.setActionContentView(paramView, null);
    return paramContext;
  }
  
  public static Drawable a(Context paramContext, int paramInt)
  {
    int i1 = ViewUtils.getScreenWidth();
    int i2 = ViewUtils.getScreenHeight();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("screenWidth = ");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append(" # screenHeight =");
      ((StringBuilder)localObject).append(i2);
      QLog.d("BitmapTools", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new BitmapFactory.Options();
    if (i1 <= 480)
    {
      ((BitmapFactory.Options)localObject).inSampleSize = 4;
    }
    else
    {
      if (i1 > 720) {
        break label135;
      }
      ((BitmapFactory.Options)localObject).inSampleSize = 2;
    }
    label135:
    try
    {
      ((BitmapFactory.Options)localObject).inScaled = false;
      paramContext = new BitmapDrawable(paramContext.getResources(), BitmapFactory.decodeResource(paramContext.getResources(), paramInt, (BitmapFactory.Options)localObject));
      return paramContext;
    }
    catch (Exception|OutOfMemoryError paramContext) {}
    return null;
    return null;
  }
  
  private SpannableString a(View paramView, Resources paramResources, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    WeakReference localWeakReference = new WeakReference(paramView);
    paramView = new SpannableString("");
    int i1 = (int)paramResources.getDimension(2131297699);
    Object localObject;
    Drawable localDrawable;
    double d1;
    if ((paramBoolean1) && (paramInt > 0))
    {
      paramView = new SpannableString("sb");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://i.gtimg.cn/club/mobile/profile/vipicon2016/android/svip_");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
      localDrawable = paramResources.getDrawable(2130848949);
      localObject = URLDrawable.getDrawable((String)localObject, localDrawable, localDrawable);
      d1 = i1;
      Double.isNaN(d1);
      ((Drawable)localObject).setBounds(0, 0, (int)(d1 / 24.0D * 68.0D), i1);
    }
    else if ((paramBoolean2) && (paramInt > 0))
    {
      paramView = new SpannableString("vb");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://i.gtimg.cn/club/mobile/profile/vipicon2016/android/vip_");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(".png");
      localObject = ((StringBuilder)localObject).toString();
      localDrawable = paramResources.getDrawable(2130848950);
      localObject = URLDrawable.getDrawable((String)localObject, localDrawable, localDrawable);
      d1 = i1;
      Double.isNaN(d1);
      ((Drawable)localObject).setBounds(0, 0, (int)(d1 / 24.0D * 58.0D), i1);
    }
    else
    {
      localObject = null;
    }
    if (localObject != null)
    {
      ((Drawable)localObject).mutate();
      ((URLDrawable)localObject).setURLDrawableListener(new TroopRequestActivity.26(this, localWeakReference));
      paramView.setSpan(new ImageSpan((Drawable)localObject), 0, 1, 33);
      localObject = paramResources.getDrawable(2130847531);
      ((Drawable)localObject).setBounds(0, 0, (int)paramResources.getDimension(2131297670), i1);
      paramView.setSpan(new ImageSpan((Drawable)localObject), 1, 2, 33);
    }
    if (QLog.isDevelopLevel())
    {
      paramResources = new StringBuilder();
      paramResources.append("parseClubLevel, bSuperVipOpen=");
      paramResources.append(paramBoolean1);
      paramResources.append(", bQQVipOpen=");
      paramResources.append(paramBoolean2);
      paramResources.append(",iVipLevel=");
      paramResources.append(paramInt);
      QLog.i("Q.systemmsg.TroopRequestActivity", 4, paramResources.toString());
    }
    return paramView;
  }
  
  public static String a(long paramLong)
  {
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    long l1 = System.currentTimeMillis();
    Time localTime2 = new Time();
    localTime2.set(l1);
    if (localTime1.year == localTime2.year) {
      return TimeFormatterUtils.a(paramLong, true, "MM-dd");
    }
    return TimeFormatterUtils.a(paramLong, true, "yyyy-MM-dd");
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject;
    if (paramInt1 == 1)
    {
      paramString = new StringBuilder();
      paramString.append(getString(2131897555));
      paramString.append(" ");
      paramString.append(getString(2131897553));
      this.p = new SpannableStringBuilder(paramString.toString());
      paramString = new ForegroundColorSpan(Color.parseColor("#00CAFC"));
      localObject = this.p;
      ((SpannableStringBuilder)localObject).setSpan(paramString, 5, ((SpannableStringBuilder)localObject).length(), 33);
      this.p.setSpan(new TroopRequestActivity.1(this), 5, this.p.length(), 33);
      this.aM.setMovementMethod(LinkMovementMethod.getInstance());
      return;
    }
    if (paramInt1 == 2)
    {
      if (paramInt2 == 2) {
        paramString = getString(2131897562);
      } else if (paramInt2 == 3) {
        paramString = getString(2131897564);
      } else {
        paramString = "";
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(getString(2131897552));
      this.p = new SpannableStringBuilder(((StringBuilder)localObject).toString());
    }
  }
  
  private void a(int paramInt, String paramString1, long paramLong1, long paramLong2, long paramLong3, String paramString2, String paramString3)
  {
    if (paramInt == 1)
    {
      if (TextUtils.isEmpty(paramString3)) {
        if (paramLong2 > 0L) {
          paramString3 = String.valueOf(paramLong2);
        } else {
          paramString3 = "";
        }
      }
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        paramString1 = paramString2;
        if (paramLong3 > 0L) {
          paramString1 = String.valueOf(paramLong3);
        }
      }
      if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString1)))
      {
        paramString2 = new StringBuilder();
        paramString2.append(getString(2131897554));
        paramString2.append(" ");
        paramString2.append(paramString3);
        paramString2.append(getString(2131897551));
        paramString2.append(paramString1);
        this.q = paramString2.toString();
      }
    }
    else if (paramInt == 2)
    {
      if (TextUtils.isEmpty(paramString1)) {
        if (paramLong1 > 0L) {
          paramString1 = String.valueOf(paramLong1);
        } else {
          paramString1 = "";
        }
      }
      if (!TextUtils.isEmpty(paramString1)) {
        this.h = paramString1;
      }
    }
  }
  
  private void a(int paramInt, String paramString, long paramLong, TroopInfo paramTroopInfo)
  {
    if (this.W.msg.group_msg_type.get() == 80)
    {
      paramString = TroopInfoUIUtil.a(this.c, 5);
      paramTroopInfo = (ITroopSysMsgDependApiService)this.aW.getRuntimeService(ITroopSysMsgDependApiService.class, "");
      if (paramTroopInfo != null)
      {
        paramTroopInfo.openTroopProfile(getActivity(), paramString);
        if (paramInt == 91) {
          ReportController.b(null, "dc00898", "", String.valueOf(this.c), "0X800B4B8", "0X800B4B8", 0, 0, String.valueOf(paramLong), "", "", "");
        }
      }
      return;
    }
    if (paramTroopInfo == null) {
      TroopRemindSettingManager.a().c(this.c, this.aW);
    }
    if (((this.W.msg.group_msg_type.get() == 11) && (this.W.msg.sub_type.get() == 3)) || (this.W.msg.group_msg_type.get() == 7))
    {
      g();
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).requestTroopPrivilege(this, this.aW, paramString, this.W, this.aK);
      TroopReportor.a("Grp_contacts_news", "notice", "again_join", 0, 0, new String[] { paramString });
      return;
    }
    if ((this.W.msg.group_msg_type.get() == 10) && (this.W.msg.sub_type.get() == 3))
    {
      g();
      paramTroopInfo = new ArrayList();
      paramTroopInfo.add(this.aL);
      if ((paramTroopInfo.size() > 0) && (this.c.length() > 0))
      {
        String str = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName();
        ((ITroopMngHandler)this.aW.getBusinessHandler(str)).a(this.c, paramTroopInfo, "");
      }
      TroopReportor.a("Grp_contacts_news", "notice", "again_invite", 0, 0, new String[] { paramString });
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if (this.b == 82)
    {
      if (c(0)) {
        g();
      }
      TroopReportor.a("Grp_contacts_news", "notice", "ignore_invite", 0, 0, new String[] { paramString1, paramString2 });
    }
    if (paramInt == 91) {
      ReportController.b(null, "dc00898", "", String.valueOf(this.c), "0X800B4B6", "0X800B4B6", 0, 0, String.valueOf(paramLong), "", "", "");
    }
    if (c(2))
    {
      g();
      if (paramInt == 1)
      {
        TroopReportor.a("Grp_contacts_news", "notice", "ignore_ask", 0, 0, new String[] { paramString1, paramString2 });
      }
      else if (paramInt == 2)
      {
        paramInt = this.W.msg.group_inviter_role.get();
        if ((paramInt != 2) && (paramInt != 3)) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if (paramInt != 0) {
          paramString3 = "0";
        } else {
          paramString3 = "1";
        }
        TroopReportor.a("Grp_contacts_news", "notice", "ignore_invite", 0, 0, new String[] { paramString1, paramString2, paramString3 });
      }
    }
    paramInt = this.ar;
    if (paramInt == 0)
    {
      ReportController.b(this.aW, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_ignore", 1, 0, String.valueOf(this.W.msg.group_code.get()), String.valueOf(this.W.msg.group_msg_type.get()), String.valueOf(this.W.msg_seq.get()), "");
      return;
    }
    if (paramInt == 1) {
      ReportController.b(this.aW, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_ignore", 2, 0, String.valueOf(this.W.msg.group_code.get()), String.valueOf(this.W.msg.group_msg_type.get()), String.valueOf(this.W.msg_seq.get()), "");
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, TroopInfo paramTroopInfo)
  {
    if (paramInt == 91) {
      ReportController.b(null, "dc00898", "", String.valueOf(this.c), "0X800B4B3", "0X800B4B3", 0, 0, String.valueOf(paramLong), "", "", "");
    }
    if (this.at != 0) {
      ReportController.b(null, "dc00898", "", "", "0X800B5B1", "0X800B5B1", 0, 0, "", "", "", "");
    }
    if (paramTroopInfo == null) {
      TroopRemindSettingManager.a().c(this.c, this.aW);
    }
    if (this.W.msg.group_msg_type.get() == 80)
    {
      QLog.e("Q.systemmsg.TroopRequestActivity", 1, "TroopProxyActivity 已在725下架");
      return;
    }
    if (this.ap) {
      TroopSuspiciousHelper.a(this.W, "unnormal_edit_join");
    }
    int i2 = 0;
    int i1 = 0;
    if (paramInt == 2)
    {
      if (QLog.isColorLevel())
      {
        paramString3 = new StringBuilder();
        paramString3.append("doCheckPayTroopReq start: ");
        paramString3.append(paramString1);
        QLog.d("Q.systemmsg.TroopRequestActivity", 2, paramString3.toString());
      }
      g();
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).requestTroopPrivilege(this, this.aW, paramString1, this.W, this.aK);
      i2 = this.W.msg.group_inviter_role.get();
      paramInt = i1;
      if (i2 != 2)
      {
        paramInt = i1;
        if (i2 != 3) {
          paramInt = 1;
        }
      }
      if (paramInt != 0) {
        paramString3 = "0";
      } else {
        paramString3 = "1";
      }
      ReportController.b(this.aW, "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, paramString1, paramString2, paramString3, "1");
    }
    else if (paramInt == 82)
    {
      g();
      a(this.W.req_uin.get(), this.W);
      paramString1 = this.aW;
      paramString2 = new StringBuilder();
      paramString2.append(this.W.req_uin.get());
      paramString2.append("");
      ReportController.b(paramString1, "P_CliOper", "Grp_public", "", "oper", "focus_invite", 0, 0, "", "", "", paramString2.toString());
    }
    else if (c(1))
    {
      g();
      if (paramInt == 1)
      {
        paramString3 = this.X;
        if (paramString3 != null)
        {
          paramInt = i2;
          if (!"".equals(paramString3)) {}
        }
        else
        {
          paramInt = 1;
        }
        if (paramInt != 0) {
          paramString3 = "1";
        } else {
          paramString3 = "0";
        }
        ReportController.b(this.aW, "P_CliOper", "Grp_contacts", "", "notice", "agree_ask", 0, 0, paramString1, paramString2, paramString3, "1");
      }
    }
    paramInt = this.ar;
    if (paramInt == 0)
    {
      ReportController.b(this.aW, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_confirm", 1, 0, String.valueOf(this.W.msg.group_code.get()), String.valueOf(this.W.msg.group_msg_type.get()), String.valueOf(this.W.msg_seq.get()), "");
      return;
    }
    if (paramInt == 1) {
      ReportController.b(this.aW, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_confirm", 2, 0, String.valueOf(this.W.msg.group_code.get()), String.valueOf(this.W.msg.group_msg_type.get()), String.valueOf(this.W.msg_seq.get()), "");
    }
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    paramStructMsg = (ITroopSysMsgDependApiService)this.aW.getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (paramStructMsg != null) {
      paramStructMsg.followPublicAccountReq(this.aW, paramLong, new TroopRequestActivity.23(this), localBundle);
    }
  }
  
  private void a(LinearLayout paramLinearLayout, List<structmsg.SystemMsgAction> paramList)
  {
    Object localObject;
    int i1;
    if ((paramList != null) && (paramList.size() >= 2) && (this.as != 2))
    {
      if (this.b == 82)
      {
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText(((structmsg.SystemMsgAction)paramList.get(0)).detail_name.get());
        this.rightViewText.setContentDescription(((structmsg.SystemMsgAction)paramList.get(0)).detail_name.get());
        this.rightViewText.setEnabled(true);
        this.U.setVisibility(0);
        this.U.setText(((structmsg.SystemMsgAction)paramList.get(1)).detail_name.get());
        localObject = (LinearLayout.LayoutParams)this.U.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        this.U.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.U.setContentDescription(((structmsg.SystemMsgAction)paramList.get(1)).detail_name.get());
        paramLinearLayout.setVisibility(0);
        return;
      }
      i1 = 0;
    }
    while (i1 < paramList.size())
    {
      localObject = ((structmsg.SystemMsgAction)paramList.get(i1)).detail_name.get();
      if (i1 == 0)
      {
        this.V.setVisibility(0);
        this.V.setText((CharSequence)localObject);
        this.V.setContentDescription((CharSequence)localObject);
      }
      else if (i1 == 1)
      {
        this.U.setVisibility(0);
        this.U.setText((CharSequence)localObject);
        this.U.setContentDescription((CharSequence)localObject);
      }
      else if (i1 == 2)
      {
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText((CharSequence)localObject);
        this.rightViewText.setContentDescription((CharSequence)localObject);
        this.rightViewText.setEnabled(true);
      }
      paramLinearLayout.setVisibility(0);
      i1 += 1;
      continue;
      if ((paramList != null) && (paramList.size() == 1))
      {
        this.E.setVisibility(0);
        this.E.setTextAppearance(this, 2131951938);
        this.E.setText(((structmsg.SystemMsgAction)paramList.get(0)).detail_name.get());
        this.E.setContentDescription(((structmsg.SystemMsgAction)paramList.get(0)).detail_name.get());
        this.E.setBackgroundResource(2130839460);
        this.E.setVisibility(0);
        return;
      }
      if ((this.E != null) && (!TextUtils.isEmpty(this.t)))
      {
        this.E.setTextAppearance(getApplicationContext(), 2131953501);
        this.E.setText(this.t);
        this.E.setContentDescription(this.t);
        this.E.setVisibility(0);
      }
    }
  }
  
  private void a(Card paramCard)
  {
    if (this.b == 82) {
      return;
    }
    if (paramCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.TroopRequestActivity", 2, "updateSimpleInfo card is null!");
      }
      return;
    }
    Object localObject1 = this.aj;
    if (localObject1 != null)
    {
      if (this.ak == null) {
        return;
      }
      ((TextView)localObject1).setVisibility(0);
      this.ak.setVisibility(0);
      int i1 = paramCard.shGender;
      Object localObject2 = "";
      if (i1 == 0)
      {
        localObject1 = getString(2131891484);
      }
      else if (paramCard.shGender == 1)
      {
        localObject1 = getString(2131889246);
      }
      else
      {
        this.aj.setVisibility(8);
        localObject1 = "";
      }
      this.aj.setText((CharSequence)localObject1);
      if (paramCard.age > 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramCard.age);
        ((StringBuilder)localObject1).append(getString(2131916946));
        localObject1 = ((StringBuilder)localObject1).toString();
        this.ak.setText((CharSequence)localObject1);
        this.ak.setContentDescription((CharSequence)localObject1);
        this.ak.setVisibility(0);
      }
      else
      {
        this.ak.setText("");
        this.ak.setContentDescription("");
        this.ak.setVisibility(8);
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramCard.strCountry))
      {
        localObject1 = localObject2;
        if (!paramCard.strCountry.equals(getString(2131914013))) {
          localObject1 = paramCard.strCountry;
        }
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(paramCard.strProvince))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" ");
        ((StringBuilder)localObject2).append(paramCard.strProvince);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramCard.strCity))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject2);
        ((StringBuilder)localObject1).append(" ");
        ((StringBuilder)localObject1).append(paramCard.strCity);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.al.setText((CharSequence)localObject1);
        this.al.setContentDescription((CharSequence)localObject1);
        this.al.setVisibility(0);
      }
      localObject1 = new SpannableStringBuilder();
      i1 = this.b;
      if (((i1 == 1) || (i1 == 22) || (i1 == 60)) && (this.aX != null))
      {
        localObject2 = getResources();
        boolean bool1;
        if (paramCard.bSuperVipOpen == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        boolean bool2;
        if (paramCard.bQQVipOpen == 1) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        i1 = paramCard.iQQVipLevel;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateLevelAndVip bSuperVipOpen=");
          localStringBuilder.append(bool1);
          localStringBuilder.append(",bQQVipOpen=");
          localStringBuilder.append(bool2);
          localStringBuilder.append(",VipLevel=");
          localStringBuilder.append(i1);
          localStringBuilder.append(",QQLevel=");
          localStringBuilder.append(paramCard.iQQLevel);
          QLog.d("Q.systemmsg.TroopRequestActivity", 2, localStringBuilder.toString());
        }
        if ((bool1) || (bool2))
        {
          i1 = Math.max(i1, 1);
          ((SpannableStringBuilder)localObject1).append(a(this.aX, (Resources)localObject2, bool1, bool2, i1));
        }
        if (paramCard.iQQLevel >= 0) {
          ((SpannableStringBuilder)localObject1).append(LevelUtil.a(this, 15, paramCard.mQQLevelType, paramCard.iQQLevel, false));
        }
        this.aX.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        this.aQ.setVisibility(0);
        return;
      }
      this.aQ.setVisibility(8);
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = this.W.msg.sub_type.get();
      if (paramInt == 2)
      {
        this.t = getString(2131897547);
        return;
      }
      if (paramInt == 3)
      {
        this.t = getString(2131897556);
        return;
      }
      if (paramInt == 4) {
        this.t = getString(2131897550);
      }
    }
  }
  
  private void b(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if (paramInt == 91) {
      ReportController.b(null, "dc00898", "", String.valueOf(this.c), "0X800B4B5", "0X800B4B5", 0, 0, String.valueOf(paramLong), "", "", "");
    }
    int i1 = this.b;
    if ((i1 != 1) && (i1 != 22))
    {
      i1 = 0;
      int i2 = 0;
      if (c(0))
      {
        g();
        if (paramInt == 1)
        {
          paramString3 = this.X;
          if (paramString3 != null)
          {
            paramInt = i2;
            if (!"".equals(paramString3)) {}
          }
          else
          {
            paramInt = 1;
          }
          if (paramInt != 0) {
            paramString3 = "1";
          } else {
            paramString3 = "0";
          }
          ReportController.b(this.aW, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask", 0, 0, paramString1, paramString2, paramString3, "1");
          return;
        }
        if (paramInt == 2)
        {
          i2 = this.W.msg.group_inviter_role.get();
          paramInt = i1;
          if (i2 != 2)
          {
            paramInt = i1;
            if (i2 != 3) {
              paramInt = 1;
            }
          }
          if (paramInt != 0) {
            paramString3 = "0";
          } else {
            paramString3 = "1";
          }
          ReportController.b(this.aW, "P_CliOper", "Grp_contacts", "", "notice", "refuse_invite", 0, 0, paramString1, paramString2, paramString3, "1");
        }
      }
      return;
    }
    startActivityForResult(new Intent(this, TroopRequestRefuseActivity.class), 1005);
    if (this.ap) {
      TroopSuspiciousHelper.a(this.W, "unnormal_edit_reject");
    }
    ReportController.b(this.aW, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask_has_reason", 0, 0, paramString1, paramString2, paramString3, "1");
    paramInt = this.ar;
    if (paramInt == 0)
    {
      ReportController.b(this.aW, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_reject", 1, 0, String.valueOf(this.W.msg.group_code.get()), String.valueOf(this.W.msg.group_msg_type.get()), String.valueOf(this.W.msg_seq.get()), "");
      return;
    }
    if (paramInt == 1) {
      ReportController.b(this.aW, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_reject", 2, 0, String.valueOf(this.W.msg.group_code.get()), String.valueOf(this.W.msg.group_msg_type.get()), String.valueOf(this.W.msg_seq.get()), "");
    }
  }
  
  private boolean c(int paramInt)
  {
    Object localObject = GroupSystemMsgController.a().f();
    this.W = GroupSystemMsgController.a().b((String)localObject);
    localObject = this.W;
    if (localObject != null)
    {
      int i1 = ((structmsg.StructMsg)localObject).msg_type.get();
      long l1 = this.W.msg_seq.get();
      long l2 = this.W.req_uin.get();
      int i2 = this.W.msg.sub_type.get();
      int i3 = this.W.msg.src_id.get();
      int i4 = this.W.msg.sub_src_id.get();
      int i5 = this.W.msg.group_msg_type.get();
      localObject = this.W.msg.actions.get();
      if ((localObject != null) && (paramInt < ((List)localObject).size()))
      {
        IMessageHandler localIMessageHandler = (IMessageHandler)this.aW.getRuntimeService(IMessageHandler.class, "");
        if (localIMessageHandler != null) {
          localIMessageHandler.sendGroupSystemMsgAction(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get(), paramInt);
        }
        return true;
      }
    }
    return false;
  }
  
  private void i()
  {
    Object localObject1 = GroupSystemMsgController.a().f();
    this.W = GroupSystemMsgController.a().b((String)localObject1);
    if (this.W == null)
    {
      finish();
      return;
    }
    if (QLog.isColorLevel())
    {
      long l1 = this.W.msg.uint32_group_flagext3.get();
      boolean bool = TroopInfo.isQidianPrivateTroop(l1);
      i1 = this.W.msg.group_msg_type.get();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TroopRequestActivity init: msgType=");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(", isQidianPrivateTroop=");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(", flagExt3=");
      ((StringBuilder)localObject1).append(l1);
      QLog.d(".troop.qidian_private_troop", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = (LinearLayout)findViewById(2131448009);
    ((LinearLayout)localObject1).setVisibility(8);
    this.af = ((IQQAvatarService)this.aW.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.aW);
    this.af.setDecodeTaskCompletionListener(this);
    this.b = this.W.msg.group_msg_type.get();
    this.c = String.valueOf(this.W.msg.group_code.get());
    this.aL = String.valueOf(this.W.msg.action_uin.get());
    this.r = String.valueOf(this.W.req_uin.get());
    this.s = this.W.msg.msg_describe.get();
    if (this.s.startsWith(getString(2131916976))) {
      this.s = this.s.replace(getString(2131916976), "");
    } else if (this.s.startsWith(getString(2131916964))) {
      this.s = this.s.replace(getString(2131916964), "");
    }
    setLeftViewName(2131888048);
    setTitle(a(this.W.msg.group_msg_type.get()));
    this.ag = findViewById(2131448000);
    this.ah = ((LinearLayout)findViewById(2131448001));
    this.D = ((TextView)findViewById(2131447996));
    this.B = ((ImageView)findViewById(2131448005));
    this.C = ((TextView)findViewById(2131448008));
    this.aj = ((TextView)findViewById(2131448006));
    this.ak = ((TextView)findViewById(2131448003));
    this.al = ((TextView)findViewById(2131448004));
    this.E = ((TextView)findViewById(2131447993));
    this.ai = ((URLImageView)findViewById(2131448002));
    this.aM = ((TextView)findViewById(2131447999));
    this.aN = ((TextView)findViewById(2131447995));
    this.U = ((Button)findViewById(2131427911));
    this.V = ((Button)findViewById(2131444568));
    this.F = ((LinearLayout)findViewById(2131447998));
    this.G = ((TextView)findViewById(2131447994));
    this.G.setOnClickListener(this.aI);
    this.H = ((ImageView)findViewById(2131447991));
    Object localObject2 = a(BaseApplication.getContext(), 2130839446);
    if (localObject2 != null) {
      this.H.setImageDrawable((Drawable)localObject2);
    } else {
      this.H.setImageResource(2130839446);
    }
    this.aO = ((LinearLayout)findViewById(2131447992));
    this.aP = ((LinearLayout)findViewById(2131444683));
    this.aQ = ((LinearLayout)findViewById(2131444689));
    this.z = ((LinearLayout)findViewById(2131444681));
    this.A = ((LinearLayout)findViewById(2131444686));
    localObject2 = (TextView)this.A.findViewById(2131444688);
    if (localObject2 != null)
    {
      localObject3 = (ITroopSysMsgDependApiService)this.aW.getRuntimeService(ITroopSysMsgDependApiService.class, "");
      if (localObject3 != null) {
        ((TextView)localObject2).setText(((ITroopSysMsgDependApiService)localObject3).getSubscriptName(this.aW, getApplicationContext()));
      }
    }
    localObject2 = this.aR;
    localObject2[P] = this.aP;
    localObject2[Q] = this.aQ;
    localObject2[R] = this.z;
    localObject2[S] = this.A;
    int i4 = this.aO.getChildCount();
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < i4; i2 = i3)
    {
      i3 = i2;
      if ((this.aO.getChildAt(i1) instanceof RelativeLayout))
      {
        this.aS[i2] = ((RelativeLayout)this.aO.getChildAt(i1));
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    this.I = ((TextView)findViewById(2131444685));
    this.J = ((TextView)findViewById(2131444684));
    this.M = ((TextView)findViewById(2131444687));
    localObject2 = (LinearLayout)findViewById(2131444690);
    Object localObject3 = (ITroopSysMsgDependApiService)this.aW.getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (localObject3 != null) {
      this.aX = ((ITroopSysMsgDependApiService)localObject3).getAnimationTextInstance(getActivity());
    }
    localObject3 = this.aX;
    if (localObject3 != null)
    {
      ((LinearLayout)localObject2).addView((View)localObject3, -2, -2);
      this.aX.setTextAppearance(this, 2131952697);
      this.aX.setGravity(17);
    }
    else
    {
      ((LinearLayout)localObject2).setVisibility(8);
    }
    this.K = ((TextView)findViewById(2131444682));
    this.L = ((TextView)findViewById(2131440834));
    this.N = ((TextView)findViewById(2131431776));
    this.t = getIntent().getExtras().getString("troopMsgDealInfo");
    this.aT = findViewById(2131450026);
    this.aU = ((TextView)findViewById(2131450027));
    this.aV = ((ImageView)findViewById(2131430837));
    this.au = ((TextView)findViewById(2131447997));
    a();
    localObject2 = this.W.msg.actions.get();
    a((LinearLayout)localObject1, (List)localObject2);
    if (((this.W.msg.group_msg_type.get() == 3) || (this.W.msg.group_msg_type.get() == 19)) && ((TextUtils.equals(String.valueOf(90000000L), this.aL)) || (TextUtils.equals(String.valueOf(90000000L), this.r)))) {
      this.E.setVisibility(8);
    }
    l();
    if ((localObject2 != null) && (((List)localObject2).size() == 1)) {
      this.E.setOnClickListener(this.aH);
    }
    this.U.setOnClickListener(this.aH);
    this.V.setOnClickListener(this.aH);
    this.rightViewText.setOnClickListener(this.aH);
    j();
    k();
  }
  
  private void j()
  {
    this.ab = ((TextView)findViewById(2131427491));
    this.aa = ((TextView)findViewById(2131427490));
    this.Z = ((TextView)findViewById(2131445841));
    this.ab.setOnClickListener(this.aw);
    this.Z.setOnClickListener(this.av);
    super.getString(2131916597);
    super.getString(2131886148);
    this.ab.setVisibility(8);
    this.aa.setVisibility(8);
    this.Z.setVisibility(8);
    this.ac = "";
    int i2 = this.W.msg.sub_type.get();
    int i1 = 1;
    if (i2 == 1)
    {
      i2 = this.b;
      if ((i2 != 1) && (i2 != 22))
      {
        if (i2 == 2)
        {
          this.ac = this.aL;
          this.ad = "0";
          this.ae = 2131917535;
          break label210;
        }
      }
      else
      {
        this.ac = this.r;
        this.ad = "1";
        this.ae = 2131916328;
        break label210;
      }
    }
    i1 = 0;
    label210:
    if (i1 != 0)
    {
      this.ab.setVisibility(0);
      this.aa.setVisibility(0);
      this.Z.setVisibility(0);
    }
  }
  
  private void k()
  {
    int i1 = this.b;
    if (((i1 == 1) || (i1 == 22) || (i1 == 60)) && (QLog.isColorLevel()))
    {
      boolean bool = this.W.msg.has();
      int i3 = -1;
      if ((bool) && (this.W.msg.src_id.has())) {
        i1 = this.W.msg.src_id.get();
      } else {
        i1 = -1;
      }
      int i2 = i3;
      if (this.W.msg.has())
      {
        i2 = i3;
        if (this.W.msg.sub_src_id.has()) {
          i2 = this.W.msg.sub_src_id.get();
        }
      }
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, String.format("joinGroup subSourceID=%d sourceID=%d msgType=%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(this.b) }));
    }
  }
  
  private void l()
  {
    this.y = ((TextView)findViewById(2131447990));
    if (!TextUtils.isEmpty(this.W.msg.group_info.msg_alert.get()))
    {
      this.V.setTextAppearance(this, 2131951941);
      this.V.setBackgroundResource(2130839477);
      if (this.W.msg.sub_type.get() == 1)
      {
        int i1 = this.b;
        if ((i1 == 1) || (i1 == 22))
        {
          this.y.setVisibility(0);
          this.y.setContentDescription(this.W.msg.group_info.msg_alert.get());
          this.y.setText(this.W.msg.group_info.msg_alert.get());
          return;
        }
      }
      this.y.setVisibility(8);
      return;
    }
    this.U.setTextAppearance(this, 2131951938);
    this.U.setBackgroundResource(2130839460);
    this.y.setVisibility(8);
  }
  
  private void m()
  {
    int i1 = this.b;
    if (i1 == 91)
    {
      q();
      return;
    }
    Object localObject;
    if (i1 == 2)
    {
      localObject = (ITroopNotificationService)this.aW.getRuntimeService(ITroopNotificationService.class, "");
      if (localObject == null) {
        return;
      }
      localObject = (InviteJoinGroupSecFrontParser.InviteJoinGroupSecFrontInfo)((ITroopNotificationService)localObject).getGeneralGroupNotifyParser(2).a(this.W);
      if (localObject != null) {
        this.at = ((InviteJoinGroupSecFrontParser.InviteJoinGroupSecFrontInfo)localObject).a;
      }
    }
    o();
    p();
    if ((this.W.msg.pic_url.has()) && (!TextUtils.isEmpty(this.W.msg.pic_url.get().toStringUtf8()))) {
      this.g = this.W.msg.pic_url.get().toStringUtf8();
    }
    n();
    if (this.W.msg.msg_additional.has()) {
      this.q = String.valueOf(this.W.msg.msg_additional.get());
    }
    if (this.W.msg_time.has()) {
      this.d = Long.valueOf(this.W.msg_time.get()).longValue();
    }
    if (this.W.msg.group_code.has()) {
      this.l = String.valueOf(this.W.msg.group_code.get());
    }
    if (this.W.msg.group_name.has()) {
      this.m = String.valueOf(this.W.msg.group_name.get());
    }
    if ((this.W.msg.msg_source.has()) && (this.b != 10)) {
      this.j = this.W.msg.msg_source.get();
    }
    if (this.W.msg.group_inviter_role.has()) {
      this.k = this.W.msg.group_inviter_role.get();
    }
    if (this.W.msg.msg_actor_describe.has())
    {
      localObject = this.W.msg.msg_actor_describe.get();
      if ((((String)localObject).contains("%action_uin%")) && (this.W.msg.action_uin_nick.has()))
      {
        this.i = this.W.msg.action_uin_nick.get();
      }
      else if ((((String)localObject).contains("%actor_uin%")) && (this.W.msg.actor_uin_nick.has()))
      {
        this.i = this.W.msg.actor_uin_nick.get();
        this.aL = String.valueOf(this.W.msg.actor_uin.get());
      }
      else if ((((String)localObject).contains("%req_uin%")) && (this.W.msg.req_uin_nick.has()))
      {
        this.i = this.W.msg.req_uin_nick.get();
      }
    }
    if (this.W.msg.bytes_warning_tips.get() != null) {
      this.x = this.W.msg.bytes_warning_tips.get().toStringUtf8();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.security_verify", 2, String.format("decodeData reqUin: %s, warningTips: %s", new Object[] { this.e, this.x }));
    }
  }
  
  private void n()
  {
    if (this.W.msg.group_msg_type.get() == 83)
    {
      if (!TextUtils.isEmpty(this.W.msg.msg_detail.get()))
      {
        this.aM.setVisibility(0);
        this.p = new SpannableStringBuilder(this.W.msg.msg_detail.get());
      }
      this.D.setVisibility(8);
      return;
    }
    if (this.W.msg.msg_describe.has())
    {
      this.aM.setVisibility(0);
      String str = this.W.msg.msg_describe.get();
      if (a(str))
      {
        this.p = a(str, true, true);
        this.aM.setMovementMethod(LinkMovementMethod.getInstance());
        return;
      }
      this.p = new SpannableStringBuilder(str);
    }
  }
  
  private void o()
  {
    int i1 = this.b;
    if ((i1 != 10) && (i1 != 12) && (i1 != 2))
    {
      if (this.W.req_uin.has()) {
        this.e = String.valueOf(this.W.req_uin.get());
      }
    }
    else if (this.W.msg.action_uin.has())
    {
      this.e = String.valueOf(this.W.msg.action_uin.get());
      this.r = this.e;
    }
  }
  
  private void p()
  {
    int i1 = this.b;
    if ((i1 != 12) && (i1 != 35) && (i1 != 10) && (i1 != 2)) {
      this.f = String.valueOf(this.W.msg.req_uin_nick.get());
    } else {
      this.f = String.valueOf(this.W.msg.action_uin_nick.get());
    }
    if ((this.b == 2) && (this.W.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str2 = this.W.msg.action_uin_qq_nick.get().toStringUtf8();
      i1 = this.W.msg.msg_invite_extinfo.uint32_src_type.get();
      String str1;
      if (i1 != 0)
      {
        Object localObject1;
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            str1 = str2;
          }
          else
          {
            localObject1 = (IDiscussionService)this.aW.getRuntimeService(IDiscussionService.class, "");
            str1 = str2;
            if (localObject1 != null) {
              str1 = ((IDiscussionService)localObject1).getDiscussionMemberName(String.valueOf(this.W.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(this.W.msg.action_uin.get()));
            }
          }
        }
        else
        {
          Object localObject2 = (ITroopInfoService)this.aW.getRuntimeService(ITroopInfoService.class, "");
          str1 = str2;
          if (localObject2 != null)
          {
            localObject1 = String.valueOf(this.W.msg.msg_invite_extinfo.uint64_src_code.get());
            String str3 = String.valueOf(this.W.msg.action_uin.get());
            str1 = ((ITroopInfoService)localObject2).getTroopCodeByTroopUin((String)localObject1);
            localObject2 = (ITroopSysMsgDependApiService)this.aW.getRuntimeService(ITroopSysMsgDependApiService.class, "");
            if (localObject2 != null) {
              str2 = ((ITroopSysMsgDependApiService)localObject2).getTroopNickName(str3, (String)localObject1, str1, true, null);
            }
            str1 = str2;
            if (TextUtils.isEmpty(str2))
            {
              localObject2 = (ITroopMemberNameService)this.aW.getRuntimeService(ITroopMemberNameService.class, "");
              str1 = str2;
              if (localObject2 != null) {
                str1 = ((ITroopMemberNameService)localObject2).getTroopMemberName((String)localObject1, str3);
              }
            }
          }
        }
      }
      else
      {
        str1 = String.valueOf(this.W.msg.action_uin_nick.get());
      }
      this.f = str1;
    }
  }
  
  private void q()
  {
    Object localObject1 = (ITroopNotificationService)this.aW.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject1 != null)
    {
      Object localObject2 = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)((ITroopNotificationService)localObject1).getGeneralGroupNotifyParser(91).a(this.W);
      if (localObject2 == null) {
        return;
      }
      int i1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).m;
      localObject1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).c;
      long l1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).d;
      int i2 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).e;
      long l2 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).h;
      long l3 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).j;
      String str1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).k;
      String str2 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).i;
      long l4 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).f;
      localObject2 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).g;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.m = ((String)localObject2);
      } else if (l4 > 0L) {
        this.m = String.valueOf(l4);
      }
      a(i1, i2, String.valueOf(l3));
      a(i1, (String)localObject1, l1, l2, l3, str1, str2);
      b(i1);
      this.as = i1;
      this.l = String.valueOf(l4);
      this.c = this.l;
      this.d = (this.W.msg_seq.get() / 1000000L);
      return;
    }
    finish();
  }
  
  private void r()
  {
    if (!TextUtils.isEmpty(this.g))
    {
      this.ai.setVisibility(0);
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(this.g);
        this.ai.setImageDrawable(localURLDrawable);
        this.ai.setOnClickListener(new TroopRequestActivity.2(this));
        this.ai.setContentDescription(HardCodeUtil.a(2131912993));
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.TroopRequestActivity", 2, localIllegalArgumentException.toString());
        }
        this.ai.setVisibility(8);
      }
    }
  }
  
  private void s()
  {
    try
    {
      if (this.aW == null) {
        break label39;
      }
      ThreadManager.post(new TroopRequestActivity.3(this), 8, null, true);
      return;
    }
    catch (Exception localException)
    {
      label23:
      label39:
      break label23;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TroopRequestActivity", 2, "getCard Exception! ");
    }
  }
  
  private void t()
  {
    if (this.W.msg.group_msg_type.get() == 83)
    {
      if (this.W.msg.msg_pay_group_extinfo.has())
      {
        Object localObject = (structmsg.MsgPayGroupExt)this.W.msg.msg_pay_group_extinfo.get();
        long l1 = ((structmsg.MsgPayGroupExt)localObject).uint64_join_grp_time.get();
        long l2 = ((structmsg.MsgPayGroupExt)localObject).uint64_quit_grp_time.get();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131912995));
        ((StringBuilder)localObject).append(TimeFormatterUtils.a(this, l1 * 1000L, true));
        ((StringBuilder)localObject).append("\n");
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131912994));
        ((StringBuilder)localObject).append(TimeFormatterUtils.a(this, l2 * 1000L, true));
        localObject = ((StringBuilder)localObject).toString();
        this.N.setVisibility(0);
        this.N.setText((CharSequence)localObject);
      }
    }
    else if (((this.W.msg.group_msg_type.get() == 3) || (this.W.msg.group_msg_type.get() == 19)) && ((TextUtils.equals(String.valueOf(90000000L), this.aL)) || (TextUtils.equals(String.valueOf(90000000L), this.r))))
    {
      if (!TextUtils.isEmpty(this.W.msg.msg_detail.get()))
      {
        this.N.setVisibility(0);
        this.N.setText(this.W.msg.msg_detail.get());
      }
      this.J.setTextColor(-16777216);
      this.J.setOnClickListener(null);
    }
  }
  
  private void u()
  {
    if (this.W.msg.group_msg_type.get() == 82)
    {
      if ((this.W.msg.actions.size() != 0) && (!TextUtils.isEmpty(this.t)))
      {
        this.L.setVisibility(0);
        this.L.setText(this.t);
      }
      else
      {
        this.L.setVisibility(8);
      }
      Object localObject = this.W.msg.req_uin_nick.get();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.M.setText((CharSequence)localObject);
        this.A.setVisibility(0);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i(".troop.troop_pubaccount", 2, "mStructMsg.msg.req_uin_nick is empty from StructMsg_IM.proto");
        }
        this.A.setVisibility(8);
        localObject = (ITroopSysMsgDependApiService)this.aW.getRuntimeService(ITroopSysMsgDependApiService.class, "");
        if (localObject != null) {
          ((ITroopSysMsgDependApiService)localObject).requestForPubAccountInfo(this.aW, this.W.req_uin.get(), new TroopRequestActivity.5(this));
        }
      }
      this.M.setOnClickListener(new TroopRequestActivity.6(this));
      localObject = this.aW;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.W.req_uin.get());
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_public", "", "oper", "exp_invite", 0, 0, "", "", "", localStringBuilder.toString());
      return;
    }
    this.A.setVisibility(8);
    this.L.setVisibility(8);
  }
  
  private boolean v()
  {
    Object localObject = GroupSystemMsgController.a().f();
    this.W = GroupSystemMsgController.a().b((String)localObject);
    localObject = this.W;
    boolean bool = true;
    if (localObject != null)
    {
      int i1 = ((structmsg.StructMsg)localObject).msg_type.get();
      long l1 = this.W.msg_seq.get();
      long l2 = this.W.req_uin.get();
      int i2 = this.W.msg.sub_type.get();
      int i3 = this.W.msg.src_id.get();
      int i4 = this.W.msg.sub_src_id.get();
      int i5 = this.W.msg.group_msg_type.get();
      localObject = this.W.msg.actions.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        ((structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get()).blacklist.set(true);
        IMessageHandler localIMessageHandler = (IMessageHandler)this.aW.getRuntimeService(IMessageHandler.class, "");
        if (localIMessageHandler == null) {
          break label248;
        }
        localIMessageHandler.sendGroupSystemMsgAction(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get(), 0);
        return true;
      }
    }
    bool = false;
    label248:
    return bool;
  }
  
  private void w()
  {
    ITroopSysMsgDependApiService localITroopSysMsgDependApiService = (ITroopSysMsgDependApiService)this.aW.getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (localITroopSysMsgDependApiService != null) {
      startActivityForResult(localITroopSysMsgDependApiService.startJoinTroop(this, this.c, this.m, this.u, 10014, this.v, this.w, null, null, null), 0);
    }
  }
  
  public SpannableStringBuilder a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      i1 = paramString1.indexOf(paramString3);
      if (i1 > 0)
      {
        localObject1 = paramString1.substring(paramString3.length() + i1, paramString1.length());
        localObject2 = paramString1.substring(0, i1 + paramString3.length());
        paramString1 = (String)localObject1;
        localObject1 = localObject2;
        break label68;
      }
    }
    Object localObject2 = "";
    Object localObject1 = paramString1;
    paramString1 = (String)localObject2;
    label68:
    localObject2 = Pattern.compile(paramString3).matcher((CharSequence)localObject1);
    if (!((Matcher)localObject2).find()) {
      return null;
    }
    paramBoolean2 = paramString3.equals(getString(2131916971));
    paramString3 = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(paramString3);
    float f1 = paramString3.density;
    paramString3 = new StringBuilder((String)localObject1);
    int i1 = ((Matcher)localObject2).end();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString2);
    paramString3.insert(i1, localStringBuilder.toString());
    paramString3 = new SpannableStringBuilder(paramString3.toString());
    int i2 = ((Matcher)localObject2).end() + 1;
    boolean bool = ((String)localObject1).contains(HardCodeUtil.a(2131912996));
    if (paramBoolean1)
    {
      paramString4 = new TroopRequestActivity.NumberSpan(this, bool, paramString2, paramString4, paramBoolean2);
      if (paramString2.length() + i2 > paramString3.length()) {
        i1 = paramString3.length();
      } else {
        i1 = paramString2.length() + i2;
      }
      paramString3.setSpan(paramString4, i2, i1, 33);
    }
    if (((Matcher)localObject2).end() > paramString3.length()) {
      i1 = paramString3.length();
    } else {
      i1 = ((Matcher)localObject2).end();
    }
    paramString3.delete(((Matcher)localObject2).start(), i1);
    paramString3.append(paramString1);
    return paramString3;
  }
  
  public SpannableStringBuilder a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      return null;
    }
    if (TroopInfo.isQidianPrivateTroop(this.W.msg.uint32_group_flagext3.get()))
    {
      int i1 = this.W.msg.group_msg_type.get();
      if ((i1 == 16) || (i1 == 3)) {
        paramBoolean1 = false;
      }
    }
    String str1;
    String str2;
    StringBuilder localStringBuilder;
    if (paramString.contains(getString(2131916976)))
    {
      str1 = this.W.msg.req_uin_nick.get();
      if (TextUtils.isEmpty(str1)) {
        return null;
      }
      str2 = getString(2131916976);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.W.req_uin.get());
      localStringBuilder.append("");
      return a(paramString, str1, str2, localStringBuilder.toString(), paramBoolean1, paramBoolean2);
    }
    if (paramString.contains(getString(2131916964)))
    {
      str1 = this.W.msg.action_uin_nick.get();
      if (TextUtils.isEmpty(str1)) {
        return null;
      }
      str2 = getString(2131916964);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.W.msg.action_uin.get());
      localStringBuilder.append("");
      return a(paramString, str1, str2, localStringBuilder.toString(), paramBoolean1, paramBoolean2);
    }
    if (paramString.contains(getString(2131916965)))
    {
      str1 = this.W.msg.actor_uin_nick.get();
      if (TextUtils.isEmpty(str1)) {
        return null;
      }
      str2 = getString(2131916965);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.W.msg.actor_uin.get());
      localStringBuilder.append("");
      return a(paramString, str1, str2, localStringBuilder.toString(), paramBoolean1, paramBoolean2);
    }
    if (paramString.contains(getString(2131916971)))
    {
      str1 = this.W.msg.group_name.get();
      if (TextUtils.isEmpty(str1)) {
        return null;
      }
      str2 = getString(2131916971);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.W.msg.group_code.get());
      localStringBuilder.append("");
      return a(paramString, str1, str2, localStringBuilder.toString(), paramBoolean1, paramBoolean2);
    }
    return new SpannableStringBuilder(paramString);
  }
  
  public String a(int paramInt)
  {
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if ((paramInt != 6) && (paramInt != 7))
          {
            if (paramInt != 8)
            {
              if (paramInt != 19)
              {
                if (paramInt != 22)
                {
                  if (paramInt != 60)
                  {
                    if (paramInt != 91)
                    {
                      if (paramInt != 82)
                      {
                        if (paramInt != 83) {
                          switch (paramInt)
                          {
                          default: 
                            switch (paramInt)
                            {
                            default: 
                              str = getString(2131894055);
                              break;
                            case 15: 
                            case 16: 
                              str = getString(2131894054);
                            }
                            break;
                          case 13: 
                            str = getString(2131894064);
                            break;
                          case 12: 
                            str = getString(2131894057);
                            break;
                          case 11: 
                            str = getString(2131894062);
                            break;
                          case 10: 
                            str = getString(2131894058);
                            break;
                          }
                        }
                        str = getString(2131894065);
                        break label301;
                      }
                      str = getString(2131894042);
                      break label301;
                    }
                    str = getString(2131894053);
                    break label301;
                  }
                  str = getString(2131894061);
                  break label301;
                }
              }
              else
              {
                str = getString(2131894067);
                break label301;
              }
            }
            else
            {
              str = getString(2131894056);
              break label301;
            }
          }
          else
          {
            str = getString(2131894063);
            break label301;
          }
        }
        else
        {
          str = getString(2131894066);
          break label301;
        }
      }
      else
      {
        str = getString(2131894059);
        break label301;
      }
    }
    String str = getString(2131894060);
    label301:
    if (QLog.isColorLevel()) {
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, String.format("getTitle msgType:%s subType:%s, srcId:%s, subSrcId:%s, title:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.W.msg.sub_type.get()), Integer.valueOf(this.W.msg.src_id.get()), Integer.valueOf(this.W.msg.sub_src_id.get()), str }));
    }
    return str;
  }
  
  public void a()
  {
    m();
    int i1 = this.b;
    if ((i1 != 1) && (i1 != 2)) {
      if ((i1 != 3) && (i1 != 6) && (i1 != 7) && (i1 != 8) && (i1 != 19))
      {
        if ((i1 == 22) || (i1 == 35) || (i1 == 60)) {
          break label154;
        }
        if ((i1 == 91) || (i1 == 82) || (i1 == 83)) {}
      }
    }
    switch (i1)
    {
    default: 
      switch (i1)
      {
      }
      break;
    case 11: 
      c();
      break;
    case 10: 
    case 12: 
    case 13: 
      label154:
      b();
    }
    d();
  }
  
  void a(int paramInt, String paramString)
  {
    if (!isResume()) {
      return;
    }
    QQToast.makeText(this, paramString, 0).show(getTitleBarHeight());
    finish();
  }
  
  void a(boolean paramBoolean)
  {
    Button localButton = this.U;
    if (localButton != null) {
      localButton.setEnabled(paramBoolean);
    }
    localButton = this.V;
    if (localButton != null) {
      localButton.setEnabled(paramBoolean);
    }
  }
  
  boolean a(String paramString)
  {
    return (paramString.contains(getString(2131916976))) || (paramString.contains(getString(2131916965))) || (paramString.contains(getString(2131916971))) || (paramString.contains(getString(2131916964)));
  }
  
  public void b()
  {
    Object localObject = TroopNotificationUtils.a(this.af, this.e, 1);
    this.B.setBackgroundDrawable((Drawable)localObject);
    int i1 = this.b;
    if ((i1 != 10) && (i1 != 12))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append(getString(2131894291));
      this.o = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append(getString(2131894290));
      this.o = ((StringBuilder)localObject).toString();
    }
    localObject = this.aF;
    this.ag.setOnClickListener((View.OnClickListener)localObject);
    if ((TroopInfo.isQidianPrivateTroop(this.W.msg.uint32_group_flagext3.get())) && (this.W.msg.group_msg_type.get() == 2))
    {
      this.ag.setOnClickListener(null);
      ((ImageView)findViewById(2131447991)).setVisibility(4);
    }
    this.B.setContentDescription(this.o);
    if (!TextUtils.isEmpty(this.f)) {
      this.C.setText(this.f);
    } else {
      this.C.setText(this.e);
    }
    s();
    r();
    if (!TextUtils.isEmpty(this.p)) {
      this.aM.setText(this.p);
    } else {
      this.aM.setText("");
    }
    if (this.b == 80)
    {
      this.aM.setMaxLines(3);
      this.aM.setSingleLine(false);
    }
    if (TextUtils.isEmpty(this.q))
    {
      this.aN.setVisibility(8);
    }
    else
    {
      this.aN.setText(this.q);
      this.aN.setVisibility(0);
    }
    long l1 = this.d;
    if (l1 != 0L)
    {
      localObject = a(l1 * 1000L);
      this.D.setText((CharSequence)localObject);
    }
    if (!TextUtils.isEmpty(this.i))
    {
      localObject = this.W.msg.msg_actor_describe.get().split("：");
      if (localObject.length > 0)
      {
        this.I.setText(localObject[0]);
        TextView localTextView = this.I;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localObject[0]);
        localStringBuilder.append(this.i);
        localTextView.setContentDescription(localStringBuilder.toString());
        this.I.setFocusable(true);
      }
      this.J.setText(this.i);
      this.J.setOnClickListener(this.aG);
      this.aP.setVisibility(0);
    }
    else
    {
      this.aP.setVisibility(8);
    }
    i1 = this.b;
    if ((i1 != 1) && (i1 != 22) && (i1 != 60)) {
      this.aQ.setVisibility(8);
    } else {
      this.aQ.setVisibility(0);
    }
    if ((!TextUtils.isEmpty(this.j)) && (this.b != 2))
    {
      this.z.setVisibility(0);
      this.K.setText(this.j);
    }
    else
    {
      this.z.setVisibility(8);
    }
    if (!TextUtils.isEmpty(this.x))
    {
      this.aU.setText(this.x);
      this.aT.setVisibility(0);
      this.aV.setOnClickListener(this.aY);
    }
    else
    {
      this.aT.setVisibility(8);
    }
    if (this.at != 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B5B0", "0X800B5B0", 0, 0, "", "", "", "");
      this.au.setVisibility(0);
      this.au.setText(getString(2131897580));
      return;
    }
    this.au.setVisibility(8);
  }
  
  public void c()
  {
    Object localObject = TroopNotificationUtils.a(this.af, this.l, 4);
    this.B.setBackgroundDrawable((Drawable)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.m);
    ((StringBuilder)localObject).append(getString(2131894292));
    this.o = ((StringBuilder)localObject).toString();
    if (this.b == 8)
    {
      this.ag.setEnabled(false);
      this.H.setVisibility(8);
    }
    else
    {
      this.ag.setOnClickListener(this.aE);
    }
    this.B.setContentDescription(this.o);
    if (TextUtils.isEmpty(this.m)) {
      this.C.setText(this.c);
    } else {
      this.C.setText(this.m);
    }
    localObject = (ITroopInfoService)this.aW.getRuntimeService(ITroopInfoService.class, "");
    if (localObject != null) {
      localObject = ((ITroopInfoService)localObject).findTroopInfo(String.valueOf(this.c));
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((TroopInfo)localObject).dwGroupClassExt != 0L))
    {
      ThreadManager.post(new TroopRequestActivity.4(this, (TroopInfo)localObject), 8, null, true);
    }
    else
    {
      localObject = (ITroopInfoHandler)this.aW.getBusinessHandler(ITroopInfoHandler.class.getName());
      if (localObject != null) {
        ((ITroopInfoHandler)localObject).c(this.c);
      }
    }
    if (!TextUtils.isEmpty(this.p)) {
      this.aM.setText(this.p);
    } else {
      this.aM.setText("");
    }
    if (this.b == 80)
    {
      this.aM.setMaxLines(3);
      this.aM.setSingleLine(false);
    }
    if (TextUtils.isEmpty(this.q))
    {
      this.aN.setVisibility(8);
    }
    else
    {
      this.aN.setText(this.q);
      this.aN.setSingleLine(true);
      this.aN.setVisibility(0);
    }
    long l1 = this.d;
    if (l1 != 0L)
    {
      localObject = a(l1 * 1000L);
      this.D.setText((CharSequence)localObject);
    }
    if (!TextUtils.isEmpty(this.i))
    {
      localObject = this.W.msg.msg_actor_describe.get();
      String[] arrayOfString = ((String)localObject).split("：");
      if (arrayOfString.length > 0)
      {
        this.I.setText(arrayOfString[0]);
        TextView localTextView = this.I;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(arrayOfString[0]);
        localStringBuilder.append(this.i);
        localTextView.setContentDescription(localStringBuilder.toString());
        this.I.setFocusable(true);
      }
      this.J.setText(this.i);
      if (((String)localObject).contains(getString(2131916964))) {
        this.J.setOnClickListener(this.aG);
      } else if (((String)localObject).contains(getString(2131916976))) {
        this.J.setOnClickListener(this.aF);
      }
      this.aP.setVisibility(0);
      if (TroopInfo.isQidianPrivateTroop(this.W.msg.uint32_group_flagext3.get()))
      {
        int i1 = this.W.msg.group_msg_type.get();
        if ((i1 == 7) || (i1 == 11) || (i1 == 3) || (i1 == 16) || (i1 == 15)) {
          this.J.setOnClickListener(null);
        }
      }
    }
    else
    {
      this.aP.setVisibility(8);
    }
    u();
    t();
    d();
    if (!TextUtils.isEmpty(this.x))
    {
      this.aU.setText(this.x);
      this.aT.setVisibility(0);
      this.aV.setOnClickListener(this.aY);
    }
    else
    {
      this.aT.setVisibility(8);
    }
    this.au.setVisibility(8);
  }
  
  public void d()
  {
    int i1 = 0;
    int i2;
    for (int i3 = 0; i1 < O; i3 = i2)
    {
      LinearLayout[] arrayOfLinearLayout = this.aR;
      i2 = i3;
      if (arrayOfLinearLayout[i1] != null)
      {
        i2 = i3;
        if (arrayOfLinearLayout[i1].getVisibility() != 8)
        {
          this.aO.setVisibility(0);
          i2 = 1;
        }
      }
      if (i1 > 0)
      {
        arrayOfLinearLayout = this.aR;
        i3 = i1 - 1;
        if (arrayOfLinearLayout[i3].getVisibility() == 8) {
          this.aS[i3].setVisibility(8);
        } else {
          this.aS[i3].setVisibility(0);
        }
      }
      i1 += 1;
    }
    if (i3 != 0)
    {
      this.aO.setVisibility(0);
      return;
    }
    this.aO.setVisibility(8);
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
    if ((-1 == paramInt2) && (paramInt1 == 0)) {
      h();
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131626738);
    paramBundle = getAppRuntime();
    if ((paramBundle instanceof AppInterface)) {
      this.aW = ((AppInterface)paramBundle);
    } else {
      finish();
    }
    setContentBackgroundResource(2130838958);
    paramBundle = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName();
    this.aq = ((ITroopMngHandler)this.aW.getBusinessHandler(paramBundle));
    i();
    if (getIntent().getExtras().getBoolean("groupman_refuse", false))
    {
      this.U.setVisibility(8);
      this.V.setVisibility(8);
    }
    this.ao = getIntent().getBooleanExtra("troop_invitee_is_friend", false);
    this.ap = getIntent().getBooleanExtra("troop_suspicious_request", false);
    paramBundle = this.F;
    if ((paramBundle != null) && (this.ao))
    {
      paramBundle.setVisibility(0);
    }
    else if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("isShowStrangerTips == ");
      paramBundle.append(this.ao);
      QLog.d("Q.systemmsg.TroopRequestActivity", 2, paramBundle.toString());
    }
    this.ar = getIntent().getIntExtra("troopfromtab", 0);
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.ax;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    if (this.b == 82) {
      this.aW.removeObserver(this.aA);
    }
    localObject = this.af;
    if (localObject != null) {
      ((IFaceDecoder)localObject).setDecodeTaskCompletionListener(null);
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void doOnStart()
  {
    this.aW.addObserver(this.az);
    this.aW.addObserver(this.ay);
    this.aW.addObserver(this.aA);
    this.aW.addObserver(this.aB);
    this.aW.addObserver(this.aC);
    this.aW.addObserver(this.aJ);
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    this.aW.removeObserver(this.az);
    this.aW.removeObserver(this.ay);
    this.aW.removeObserver(this.aB);
    this.aW.removeObserver(this.aC);
    this.aW.removeObserver(this.aJ);
    if (this.b != 82) {
      this.aW.removeObserver(this.aA);
    }
    super.doOnStop();
  }
  
  void e()
  {
    ActionSheet localActionSheet = (ActionSheet)a(this, null);
    int i1 = this.ae;
    String str;
    if (i1 != 0) {
      str = getString(i1);
    } else {
      str = "";
    }
    localActionSheet.setMainTitle(str);
    localActionSheet.addButton(getString(2131916596), 3);
    localActionSheet.setOnButtonClickListener(new TroopRequestActivity.9(this, localActionSheet));
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.show();
  }
  
  void f()
  {
    ActionSheet localActionSheet = (ActionSheet)a(this, null);
    localActionSheet.addButton(getString(2131887669), 3);
    localActionSheet.setOnButtonClickListener(new TroopRequestActivity.10(this, localActionSheet));
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.show();
  }
  
  public void g()
  {
    try
    {
      if (this.aD == null)
      {
        this.aD = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.aD.c(2131892360);
        this.aD.c(false);
      }
      this.aD.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.systemmsg.TroopRequestActivity", 2, localException.toString());
      }
    }
  }
  
  public void h()
  {
    try
    {
      if ((this.aD != null) && (this.aD.isShowing()))
      {
        this.aD.dismiss();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.systemmsg.TroopRequestActivity", 2, localException.toString());
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramString = this.W.msg.msg_describe.get();
    paramBitmap = this.W.msg.msg_describe.get();
    if (paramString != null)
    {
      this.aM.setVisibility(0);
      if (a(paramBitmap))
      {
        paramString = a(this.W.msg.msg_describe.get(), true, true);
        this.aM.setMovementMethod(LinkMovementMethod.getInstance());
      }
      if (!TextUtils.isEmpty(paramString))
      {
        this.aM.setText(paramString);
        return;
      }
      this.aM.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity
 * JD-Core Version:    0.7.0.1
 */