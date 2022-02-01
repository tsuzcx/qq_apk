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
  public static int a = 10;
  protected static long b;
  public static final boolean b;
  protected static long c;
  public static int d;
  public static final int e;
  public static final int f;
  public static final int g;
  public static final int h;
  protected long a;
  Handler jdField_a_of_type_AndroidOsHandler;
  protected SpannableStringBuilder a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  protected View a;
  protected Button a;
  protected ImageView a;
  protected LinearLayout a;
  protected TextView a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  protected URLImageView a;
  protected BaseMessageObserver a;
  protected IFaceDecoder a;
  ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver;
  StrangerObserver jdField_a_of_type_ComTencentMobileqqStrangerObserverStrangerObserver;
  protected ITroopMngHandler a;
  protected TroopMngObserver a;
  protected TroopObserver a;
  TroopNotificationUtils.TroopPrivilegeCallback jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationUtilsTroopNotificationUtils$TroopPrivilegeCallback;
  protected QQProgressDialog a;
  protected String a;
  protected structmsg.StructMsg a;
  protected short a;
  protected boolean a;
  private LinearLayout[] jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout;
  private RelativeLayout[] jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout;
  protected int b;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener;
  protected View b;
  protected Button b;
  protected ImageView b;
  protected LinearLayout b;
  protected TextView b;
  ProfileCardObserver jdField_b_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver;
  protected String b;
  protected int c;
  View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  protected LinearLayout c;
  protected TextView c;
  protected String c;
  protected boolean c;
  View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  protected TextView d;
  protected String d;
  protected boolean d;
  View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener;
  private LinearLayout jdField_e_of_type_AndroidWidgetLinearLayout;
  protected TextView e;
  protected String e;
  View.OnClickListener jdField_f_of_type_AndroidViewView$OnClickListener;
  private LinearLayout jdField_f_of_type_AndroidWidgetLinearLayout;
  protected TextView f;
  protected String f;
  View.OnClickListener g;
  protected TextView g;
  protected String g;
  private View.OnClickListener h;
  protected TextView h;
  protected String h;
  protected int i;
  protected TextView i;
  protected String i;
  int j;
  protected TextView j;
  protected String j;
  int k;
  protected TextView k;
  protected String k;
  int l;
  protected TextView l;
  protected String l;
  protected TextView m;
  protected String m;
  protected TextView n;
  protected String n;
  TextView o;
  protected String o;
  TextView p;
  protected String p;
  TextView q;
  protected String q;
  protected TextView r;
  protected String r;
  private TextView s;
  protected String s;
  private TextView t;
  protected String t;
  private TextView u;
  protected String u;
  private TextView jdField_v_of_type_AndroidWidgetTextView;
  private String jdField_v_of_type_JavaLangString;
  
  static
  {
    int i1 = jdField_d_of_type_Int;
    jdField_d_of_type_Int = i1 + 1;
    jdField_e_of_type_Int = i1;
    i1 = jdField_d_of_type_Int;
    jdField_d_of_type_Int = i1 + 1;
    jdField_f_of_type_Int = i1;
    i1 = jdField_d_of_type_Int;
    jdField_d_of_type_Int = i1 + 1;
    jdField_g_of_type_Int = i1;
    i1 = jdField_d_of_type_Int;
    jdField_d_of_type_Int = i1 + 1;
    jdField_h_of_type_Int = i1;
    jdField_b_of_type_Boolean = AppSetting.jdField_d_of_type_Boolean;
    jdField_b_of_type_Long = 0L;
    jdField_c_of_type_Long = 0L;
  }
  
  public TroopRequestActivity()
  {
    int i1 = jdField_d_of_type_Int;
    this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout = new LinearLayout[i1];
    this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout = new RelativeLayout[i1 - 1];
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = null;
    this.jdField_s_of_type_JavaLangString = null;
    this.jdField_t_of_type_JavaLangString = "";
    this.jdField_u_of_type_JavaLangString = "";
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new TroopRequestActivity.7(this);
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new TroopRequestActivity.8(this);
    this.jdField_a_of_type_AndroidOsHandler = new TroopRequestActivity.11(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopRequestActivity.12(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new TroopRequestActivity.13(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver = new TroopRequestActivity.14(this);
    this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new TroopRequestActivity.15(this);
    this.jdField_b_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new TroopRequestActivity.16(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new TroopRequestActivity.17(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new TroopRequestActivity.18(this);
    this.jdField_e_of_type_AndroidViewView$OnClickListener = new TroopRequestActivity.19(this);
    this.jdField_f_of_type_AndroidViewView$OnClickListener = new TroopRequestActivity.20(this);
    this.jdField_g_of_type_AndroidViewView$OnClickListener = new TroopRequestActivity.21(this);
    this.jdField_a_of_type_ComTencentMobileqqStrangerObserverStrangerObserver = new TroopRequestActivity.22(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationUtilsTroopNotificationUtils$TroopPrivilegeCallback = new TroopRequestActivity.24(this);
    this.jdField_h_of_type_AndroidViewView$OnClickListener = new TroopRequestActivity.25(this);
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
    int i1 = ViewUtils.a();
    int i2 = ViewUtils.b();
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
    int i1 = (int)paramResources.getDimension(2131297268);
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
      localDrawable = paramResources.getDrawable(2130847298);
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
      localDrawable = paramResources.getDrawable(2130847299);
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
      localObject = paramResources.getDrawable(2130846061);
      ((Drawable)localObject).setBounds(0, 0, (int)paramResources.getDimension(2131297239), i1);
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
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      paramInt = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      if (paramInt == 2)
      {
        this.jdField_o_of_type_JavaLangString = getString(2131699516);
        return;
      }
      if (paramInt == 3)
      {
        this.jdField_o_of_type_JavaLangString = getString(2131699525);
        return;
      }
      if (paramInt == 4) {
        this.jdField_o_of_type_JavaLangString = getString(2131699519);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject;
    if (paramInt1 == 1)
    {
      paramString = new StringBuilder();
      paramString.append(getString(2131699524));
      paramString.append(" ");
      paramString.append(getString(2131699522));
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder(paramString.toString());
      paramString = new ForegroundColorSpan(Color.parseColor("#00CAFC"));
      localObject = this.jdField_a_of_type_AndroidTextSpannableStringBuilder;
      ((SpannableStringBuilder)localObject).setSpan(paramString, 5, ((SpannableStringBuilder)localObject).length(), 33);
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(new TroopRequestActivity.1(this), 5, this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length(), 33);
      this.jdField_s_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      return;
    }
    if (paramInt1 == 2)
    {
      if (paramInt2 == 2) {
        paramString = getString(2131699531);
      } else if (paramInt2 == 3) {
        paramString = getString(2131699533);
      } else {
        paramString = "";
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(getString(2131699521));
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder(((StringBuilder)localObject).toString());
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
        paramString2.append(getString(2131699523));
        paramString2.append(" ");
        paramString2.append(paramString3);
        paramString2.append(getString(2131699520));
        paramString2.append(paramString1);
        this.jdField_l_of_type_JavaLangString = paramString2.toString();
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
        this.jdField_e_of_type_JavaLangString = paramString1;
      }
    }
  }
  
  private void a(int paramInt, String paramString, long paramLong, TroopInfo paramTroopInfo)
  {
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
    {
      paramString = TroopInfoUIUtil.a(this.jdField_a_of_type_JavaLangString, 5);
      paramTroopInfo = (ITroopSysMsgDependApiService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopSysMsgDependApiService.class, "");
      if (paramTroopInfo != null)
      {
        paramTroopInfo.openTroopProfile(getActivity(), paramString);
        if (paramInt == 91) {
          ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_JavaLangString), "0X800B4B8", "0X800B4B8", 0, 0, String.valueOf(paramLong), "", "", "");
        }
      }
      return;
    }
    if (paramTroopInfo == null) {
      TroopRemindSettingManager.a().b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    if (((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 11) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 3)) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 7))
    {
      g();
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).requestTroopPrivilege(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationUtilsTroopNotificationUtils$TroopPrivilegeCallback);
      TroopReportor.a("Grp_contacts_news", "notice", "again_join", 0, 0, new String[] { paramString });
      return;
    }
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 10) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 3))
    {
      g();
      paramTroopInfo = new ArrayList();
      paramTroopInfo.add(this.jdField_v_of_type_JavaLangString);
      if ((paramTroopInfo.size() > 0) && (this.jdField_a_of_type_JavaLangString.length() > 0))
      {
        String str = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName();
        ((ITroopMngHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(str)).a(this.jdField_a_of_type_JavaLangString, paramTroopInfo, "");
      }
      TroopReportor.a("Grp_contacts_news", "notice", "again_invite", 0, 0, new String[] { paramString });
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if (this.jdField_b_of_type_Int == 82)
    {
      if (a(0)) {
        g();
      }
      TroopReportor.a("Grp_contacts_news", "notice", "ignore_invite", 0, 0, new String[] { paramString1, paramString2 });
    }
    if (paramInt == 91) {
      ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_JavaLangString), "0X800B4B6", "0X800B4B6", 0, 0, String.valueOf(paramLong), "", "", "");
    }
    if (a(2))
    {
      g();
      if (paramInt == 1)
      {
        TroopReportor.a("Grp_contacts_news", "notice", "ignore_ask", 0, 0, new String[] { paramString1, paramString2 });
      }
      else if (paramInt == 2)
      {
        paramInt = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
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
    paramInt = this.jdField_j_of_type_Int;
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_ignore", 1, 0, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get()), "");
      return;
    }
    if (paramInt == 1) {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_ignore", 2, 0, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get()), "");
    }
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong, TroopInfo paramTroopInfo)
  {
    if (paramInt == 91) {
      ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_JavaLangString), "0X800B4B3", "0X800B4B3", 0, 0, String.valueOf(paramLong), "", "", "");
    }
    if (this.jdField_l_of_type_Int != 0) {
      ReportController.b(null, "dc00898", "", "", "0X800B5B1", "0X800B5B1", 0, 0, "", "", "", "");
    }
    if (paramTroopInfo == null) {
      TroopRemindSettingManager.a().b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 80)
    {
      QLog.e("Q.systemmsg.TroopRequestActivity", 1, "TroopProxyActivity 已在725下架");
      return;
    }
    if (this.jdField_d_of_type_Boolean) {
      TroopSuspiciousHelper.a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit_join");
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
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).requestTroopPrivilege(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString1, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationUtilsTroopNotificationUtils$TroopPrivilegeCallback);
      i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
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
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "agree_invite", 0, 0, paramString1, paramString2, paramString3, "1");
    }
    else if (paramInt == 82)
    {
      g();
      a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg);
      paramString1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      paramString2 = new StringBuilder();
      paramString2.append(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
      paramString2.append("");
      ReportController.b(paramString1, "P_CliOper", "Grp_public", "", "oper", "focus_invite", 0, 0, "", "", "", paramString2.toString());
    }
    else if (a(1))
    {
      g();
      if (paramInt == 1)
      {
        paramString3 = this.jdField_s_of_type_JavaLangString;
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
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "agree_ask", 0, 0, paramString1, paramString2, paramString3, "1");
      }
    }
    paramInt = this.jdField_j_of_type_Int;
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_confirm", 1, 0, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get()), "");
      return;
    }
    if (paramInt == 1) {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_confirm", 2, 0, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get()), "");
    }
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    paramStructMsg = (ITroopSysMsgDependApiService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (paramStructMsg != null) {
      paramStructMsg.followPublicAccountReq(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramLong, new TroopRequestActivity.23(this), localBundle);
    }
  }
  
  private void a(LinearLayout paramLinearLayout, List<structmsg.SystemMsgAction> paramList)
  {
    Object localObject;
    int i1;
    if ((paramList != null) && (paramList.size() >= 2) && (this.jdField_k_of_type_Int != 2))
    {
      if (this.jdField_b_of_type_Int == 82)
      {
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText(((structmsg.SystemMsgAction)paramList.get(0)).detail_name.get());
        this.rightViewText.setContentDescription(((structmsg.SystemMsgAction)paramList.get(0)).detail_name.get());
        this.rightViewText.setEnabled(true);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramList.get(1)).detail_name.get());
        localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).leftMargin = 0;
        this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(((structmsg.SystemMsgAction)paramList.get(1)).detail_name.get());
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
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
        this.jdField_b_of_type_AndroidWidgetButton.setContentDescription((CharSequence)localObject);
      }
      else if (i1 == 1)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject);
        this.jdField_a_of_type_AndroidWidgetButton.setContentDescription((CharSequence)localObject);
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
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setTextAppearance(this, 2131755249);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(((structmsg.SystemMsgAction)paramList.get(0)).detail_name.get());
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(((structmsg.SystemMsgAction)paramList.get(0)).detail_name.get());
        this.jdField_d_of_type_AndroidWidgetTextView.setBackgroundResource(2130839280);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
      }
      if ((this.jdField_d_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString)))
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextAppearance(getApplicationContext(), 2131756338);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_o_of_type_JavaLangString);
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_o_of_type_JavaLangString);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
  }
  
  private void a(Card paramCard)
  {
    if (this.jdField_b_of_type_Int == 82) {
      return;
    }
    if (paramCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.systemmsg.TroopRequestActivity", 2, "updateSimpleInfo card is null!");
      }
      return;
    }
    Object localObject1 = this.jdField_o_of_type_AndroidWidgetTextView;
    if (localObject1 != null)
    {
      if (this.jdField_p_of_type_AndroidWidgetTextView == null) {
        return;
      }
      ((TextView)localObject1).setVisibility(0);
      this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(0);
      int i1 = paramCard.shGender;
      Object localObject2 = "";
      if (i1 == 0)
      {
        localObject1 = getString(2131693879);
      }
      else if (paramCard.shGender == 1)
      {
        localObject1 = getString(2131692259);
      }
      else
      {
        this.jdField_o_of_type_AndroidWidgetTextView.setVisibility(8);
        localObject1 = "";
      }
      this.jdField_o_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      if (paramCard.age > 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramCard.age);
        ((StringBuilder)localObject1).append(getString(2131719391));
        localObject1 = ((StringBuilder)localObject1).toString();
        this.jdField_p_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_p_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject1);
        this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        this.jdField_p_of_type_AndroidWidgetTextView.setText("");
        this.jdField_p_of_type_AndroidWidgetTextView.setContentDescription("");
        this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramCard.strCountry))
      {
        localObject1 = localObject2;
        if (!paramCard.strCountry.equals(getString(2131716550))) {
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
        this.jdField_q_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        this.jdField_q_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject1);
        this.jdField_q_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      localObject1 = new SpannableStringBuilder();
      i1 = this.jdField_b_of_type_Int;
      if (((i1 == 1) || (i1 == 22) || (i1 == 60)) && (this.jdField_v_of_type_AndroidWidgetTextView != null))
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
          ((SpannableStringBuilder)localObject1).append(a(this.jdField_v_of_type_AndroidWidgetTextView, (Resources)localObject2, bool1, bool2, i1));
        }
        if (paramCard.iQQLevel >= 0) {
          ((SpannableStringBuilder)localObject1).append(LevelUtil.a(this, 15, paramCard.mQQLevelType, paramCard.iQQLevel, false));
        }
        this.jdField_v_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1, TextView.BufferType.SPANNABLE);
        this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        return;
      }
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
  }
  
  private boolean a()
  {
    Object localObject = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a((String)localObject);
    localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    boolean bool = true;
    if (localObject != null)
    {
      int i1 = ((structmsg.StructMsg)localObject).msg_type.get();
      long l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int i3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int i4 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int i5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        ((structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(0)).action_info.get()).blacklist.set(true);
        IMessageHandler localIMessageHandler = (IMessageHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageHandler.class, "");
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
  
  private boolean a(int paramInt)
  {
    Object localObject = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a((String)localObject);
    localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    if (localObject != null)
    {
      int i1 = ((structmsg.StructMsg)localObject).msg_type.get();
      long l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get();
      long l2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get();
      int i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      int i3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int i4 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
      int i5 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
      if ((localObject != null) && (paramInt < ((List)localObject).size()))
      {
        IMessageHandler localIMessageHandler = (IMessageHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageHandler.class, "");
        if (localIMessageHandler != null) {
          localIMessageHandler.sendGroupSystemMsgAction(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get(), paramInt);
        }
        return true;
      }
    }
    return false;
  }
  
  private void b(int paramInt, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if (paramInt == 91) {
      ReportController.b(null, "dc00898", "", String.valueOf(this.jdField_a_of_type_JavaLangString), "0X800B4B5", "0X800B4B5", 0, 0, String.valueOf(paramLong), "", "", "");
    }
    int i1 = this.jdField_b_of_type_Int;
    if ((i1 != 1) && (i1 != 22))
    {
      i1 = 0;
      int i2 = 0;
      if (a(0))
      {
        g();
        if (paramInt == 1)
        {
          paramString3 = this.jdField_s_of_type_JavaLangString;
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
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask", 0, 0, paramString1, paramString2, paramString3, "1");
          return;
        }
        if (paramInt == 2)
        {
          i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
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
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "refuse_invite", 0, 0, paramString1, paramString2, paramString3, "1");
        }
      }
      return;
    }
    startActivityForResult(new Intent(this, TroopRequestRefuseActivity.class), 1005);
    if (this.jdField_d_of_type_Boolean) {
      TroopSuspiciousHelper.a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit_reject");
    }
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "refuse_ask_has_reason", 0, 0, paramString1, paramString2, paramString3, "1");
    paramInt = this.jdField_j_of_type_Int;
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_reject", 1, 0, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get()), "");
      return;
    }
    if (paramInt == 1) {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_contacts_news", "", "notice", "todotab_noticeinfo_reject", 2, 0, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get()), "");
    }
  }
  
  private void i()
  {
    Object localObject1 = GroupSystemMsgController.a().b();
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = GroupSystemMsgController.a().a((String)localObject1);
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg == null)
    {
      finish();
      return;
    }
    if (QLog.isColorLevel())
    {
      long l1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get();
      boolean bool = TroopInfo.isQidianPrivateTroop(l1);
      i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TroopRequestActivity init: msgType=");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(", isQidianPrivateTroop=");
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(", flagExt3=");
      ((StringBuilder)localObject1).append(l1);
      QLog.d(".troop.qidian_private_troop", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = (LinearLayout)findViewById(2131379272);
    ((LinearLayout)localObject1).setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
    this.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
    this.jdField_v_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
    this.jdField_m_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    this.jdField_n_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    if (this.jdField_n_of_type_JavaLangString.startsWith(getString(2131719417))) {
      this.jdField_n_of_type_JavaLangString = this.jdField_n_of_type_JavaLangString.replace(getString(2131719417), "");
    } else if (this.jdField_n_of_type_JavaLangString.startsWith(getString(2131719405))) {
      this.jdField_n_of_type_JavaLangString = this.jdField_n_of_type_JavaLangString.replace(getString(2131719405), "");
    }
    setLeftViewName(2131691102);
    setTitle(a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get()));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131379263);
    this.jdField_b_of_type_AndroidViewView = ((LinearLayout)findViewById(2131379264));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379259));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379268));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379271));
    this.jdField_o_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379269));
    this.jdField_p_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379266));
    this.jdField_q_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379267));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379256));
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)findViewById(2131379265));
    this.jdField_s_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379262));
    this.jdField_t_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379258));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131362312));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131376352));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379261));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379257));
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_g_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379254));
    Object localObject2 = a(BaseApplication.getContext(), 2130839270);
    if (localObject2 != null) {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
    } else {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130839270);
    }
    this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131379255));
    this.jdField_e_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376450));
    this.jdField_f_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376456));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376448));
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131376453));
    localObject2 = (TextView)this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131376455);
    if (localObject2 != null)
    {
      localObject3 = (ITroopSysMsgDependApiService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopSysMsgDependApiService.class, "");
      if (localObject3 != null) {
        ((TextView)localObject2).setText(((ITroopSysMsgDependApiService)localObject3).getSubscriptName(this.jdField_a_of_type_ComTencentCommonAppAppInterface, getApplicationContext()));
      }
    }
    localObject2 = this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout;
    localObject2[jdField_e_of_type_Int] = this.jdField_e_of_type_AndroidWidgetLinearLayout;
    localObject2[jdField_f_of_type_Int] = this.jdField_f_of_type_AndroidWidgetLinearLayout;
    localObject2[jdField_g_of_type_Int] = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    localObject2[jdField_h_of_type_Int] = this.jdField_b_of_type_AndroidWidgetLinearLayout;
    int i4 = this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < i4; i2 = i3)
    {
      i3 = i2;
      if ((this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildAt(i1) instanceof RelativeLayout))
      {
        this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i2] = ((RelativeLayout)this.jdField_d_of_type_AndroidWidgetLinearLayout.getChildAt(i1));
        i3 = i2 + 1;
      }
      i1 += 1;
    }
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376452));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376451));
    this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376454));
    localObject2 = (LinearLayout)findViewById(2131376457);
    Object localObject3 = (ITroopSysMsgDependApiService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (localObject3 != null) {
      this.jdField_v_of_type_AndroidWidgetTextView = ((ITroopSysMsgDependApiService)localObject3).getAnimationTextInstance(getActivity());
    }
    localObject3 = this.jdField_v_of_type_AndroidWidgetTextView;
    if (localObject3 != null)
    {
      ((LinearLayout)localObject2).addView((View)localObject3, -2, -2);
      this.jdField_v_of_type_AndroidWidgetTextView.setTextAppearance(this, 2131755732);
      this.jdField_v_of_type_AndroidWidgetTextView.setGravity(17);
    }
    else
    {
      ((LinearLayout)localObject2).setVisibility(8);
    }
    this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376449));
    this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373225));
    this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365549));
    this.jdField_o_of_type_JavaLangString = getIntent().getExtras().getString("troopMsgDealInfo");
    this.jdField_c_of_type_AndroidViewView = findViewById(2131381017);
    this.jdField_u_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381018));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131364729));
    this.jdField_r_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379260));
    a();
    localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get();
    a((LinearLayout)localObject1, (List)localObject2);
    if (((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 3) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 19)) && ((TextUtils.equals(String.valueOf(90000000L), this.jdField_v_of_type_JavaLangString)) || (TextUtils.equals(String.valueOf(90000000L), this.jdField_m_of_type_JavaLangString)))) {
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    l();
    if ((localObject2 != null) && (((List)localObject2).size() == 1)) {
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
    }
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
    this.rightViewText.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
    j();
    k();
  }
  
  private void j()
  {
    this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131361937));
    this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131361936));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377442));
    this.jdField_n_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    this.jdField_l_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    super.getString(2131719061);
    super.getString(2131689540);
    this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_t_of_type_JavaLangString = "";
    int i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
    int i1 = 1;
    if (i2 == 1)
    {
      i2 = this.jdField_b_of_type_Int;
      if ((i2 != 1) && (i2 != 22))
      {
        if (i2 == 2)
        {
          this.jdField_t_of_type_JavaLangString = this.jdField_v_of_type_JavaLangString;
          this.jdField_u_of_type_JavaLangString = "0";
          this.jdField_i_of_type_Int = 2131719930;
          break label210;
        }
      }
      else
      {
        this.jdField_t_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString;
        this.jdField_u_of_type_JavaLangString = "1";
        this.jdField_i_of_type_Int = 2131718820;
        break label210;
      }
    }
    i1 = 0;
    label210:
    if (i1 != 0)
    {
      this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  private void k()
  {
    int i1 = this.jdField_b_of_type_Int;
    if (((i1 == 1) || (i1 == 22) || (i1 == 60)) && (QLog.isColorLevel()))
    {
      boolean bool = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has();
      int i3 = -1;
      if ((bool) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.has())) {
        i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      } else {
        i1 = -1;
      }
      int i2 = i3;
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.has())
      {
        i2 = i3;
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.has()) {
          i2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get();
        }
      }
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, String.format("joinGroup subSourceID=%d sourceID=%d msgType=%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379253));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get()))
    {
      this.jdField_b_of_type_AndroidWidgetButton.setTextAppearance(this, 2131755252);
      this.jdField_b_of_type_AndroidWidgetButton.setBackgroundResource(2130839297);
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 1)
      {
        int i1 = this.jdField_b_of_type_Int;
        if ((i1 == 1) || (i1 == 22))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get());
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get());
          return;
        }
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this, 2131755249);
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839280);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void m()
  {
    int i1 = this.jdField_b_of_type_Int;
    if (i1 == 91)
    {
      q();
      return;
    }
    Object localObject;
    if (i1 == 2)
    {
      localObject = (ITroopNotificationService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopNotificationService.class, "");
      if (localObject == null) {
        return;
      }
      localObject = (InviteJoinGroupSecFrontParser.InviteJoinGroupSecFrontInfo)((ITroopNotificationService)localObject).getGeneralGroupNotifyParser(2).a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg);
      if (localObject != null) {
        this.jdField_l_of_type_Int = ((InviteJoinGroupSecFrontParser.InviteJoinGroupSecFrontInfo)localObject).a;
      }
    }
    o();
    p();
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.pic_url.has()) && (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.pic_url.get().toStringUtf8()))) {
      this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.pic_url.get().toStringUtf8();
    }
    n();
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.has()) {
      this.jdField_l_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    }
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.has()) {
      this.jdField_a_of_type_Long = Long.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get()).longValue();
    }
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.has()) {
      this.jdField_h_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
    }
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.has()) {
      this.jdField_i_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get());
    }
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has()) && (this.jdField_b_of_type_Int != 10)) {
      this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();
    }
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.has()) {
      this.jdField_c_of_type_Int = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get();
    }
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.has())
    {
      localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get();
      if ((((String)localObject).contains("%action_uin%")) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.has()))
      {
        this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
      }
      else if ((((String)localObject).contains("%actor_uin%")) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.has()))
      {
        this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.get();
        this.jdField_v_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get());
      }
      else if ((((String)localObject).contains("%req_uin%")) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.has()))
      {
        this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
      }
    }
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_warning_tips.get() != null) {
      this.jdField_r_of_type_JavaLangString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_warning_tips.get().toStringUtf8();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.security_verify", 2, String.format("decodeData reqUin: %s, warningTips: %s", new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_r_of_type_JavaLangString }));
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 83)
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get()))
      {
        this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.has())
    {
      this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(0);
      String str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
      if (a(str))
      {
        this.jdField_a_of_type_AndroidTextSpannableStringBuilder = a(str, true, true);
        this.jdField_s_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
        return;
      }
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder(str);
    }
  }
  
  private void o()
  {
    int i1 = this.jdField_b_of_type_Int;
    if ((i1 != 10) && (i1 != 12) && (i1 != 2))
    {
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.has()) {
        this.jdField_b_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
      }
    }
    else if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.has())
    {
      this.jdField_b_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      this.jdField_m_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    }
  }
  
  private void p()
  {
    int i1 = this.jdField_b_of_type_Int;
    if ((i1 != 12) && (i1 != 35) && (i1 != 10) && (i1 != 2)) {
      this.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
    } else {
      this.jdField_c_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get());
    }
    if ((this.jdField_b_of_type_Int == 2) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      String str2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
      i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint32_src_type.get();
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
            localObject1 = (IDiscussionService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IDiscussionService.class, "");
            str1 = str2;
            if (localObject1 != null) {
              str1 = ((IDiscussionService)localObject1).getDiscussionMemberName(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
            }
          }
        }
        else
        {
          Object localObject2 = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
          str1 = str2;
          if (localObject2 != null)
          {
            localObject1 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
            String str3 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
            str1 = ((ITroopInfoService)localObject2).getTroopCodeByTroopUin((String)localObject1);
            localObject2 = (ITroopSysMsgDependApiService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopSysMsgDependApiService.class, "");
            if (localObject2 != null) {
              str2 = ((ITroopSysMsgDependApiService)localObject2).getTroopNickName(str3, (String)localObject1, str1, true, null);
            }
            str1 = str2;
            if (TextUtils.isEmpty(str2))
            {
              localObject2 = (ITroopMemberNameService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopMemberNameService.class, "");
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
        str1 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get());
      }
      this.jdField_c_of_type_JavaLangString = str1;
    }
  }
  
  private void q()
  {
    Object localObject1 = (ITroopNotificationService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject1 != null)
    {
      Object localObject2 = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)((ITroopNotificationService)localObject1).getGeneralGroupNotifyParser(91).a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg);
      if (localObject2 == null) {
        return;
      }
      int i1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).jdField_c_of_type_Int;
      localObject1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).jdField_b_of_type_JavaLangString;
      long l1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).jdField_b_of_type_Long;
      int i2 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).a;
      long l2 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).jdField_d_of_type_Long;
      long l3 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).jdField_e_of_type_Long;
      String str1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).jdField_e_of_type_JavaLangString;
      String str2 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).jdField_d_of_type_JavaLangString;
      long l4 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).jdField_c_of_type_Long;
      localObject2 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).jdField_c_of_type_JavaLangString;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        this.jdField_i_of_type_JavaLangString = ((String)localObject2);
      } else if (l4 > 0L) {
        this.jdField_i_of_type_JavaLangString = String.valueOf(l4);
      }
      a(i1, i2, String.valueOf(l3));
      a(i1, (String)localObject1, l1, l2, l3, str1, str2);
      a(i1);
      this.jdField_k_of_type_Int = i1;
      this.jdField_h_of_type_JavaLangString = String.valueOf(l4);
      this.jdField_a_of_type_JavaLangString = this.jdField_h_of_type_JavaLangString;
      this.jdField_a_of_type_Long = (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_seq.get() / 1000000L);
      return;
    }
    finish();
  }
  
  private void r()
  {
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(this.jdField_d_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localURLDrawable);
        this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new TroopRequestActivity.2(this));
        this.jdField_a_of_type_ComTencentImageURLImageView.setContentDescription(HardCodeUtil.a(2131715520));
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.systemmsg.TroopRequestActivity", 2, localIllegalArgumentException.toString());
        }
        this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
    }
  }
  
  private void s()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
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
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 83)
    {
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_pay_group_extinfo.has())
      {
        Object localObject = (structmsg.MsgPayGroupExt)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_pay_group_extinfo.get();
        long l1 = ((structmsg.MsgPayGroupExt)localObject).uint64_join_grp_time.get();
        long l2 = ((structmsg.MsgPayGroupExt)localObject).uint64_quit_grp_time.get();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131715522));
        ((StringBuilder)localObject).append(TimeFormatterUtils.a(this, l1 * 1000L, true));
        ((StringBuilder)localObject).append("\n");
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131715521));
        ((StringBuilder)localObject).append(TimeFormatterUtils.a(this, l2 * 1000L, true));
        localObject = ((StringBuilder)localObject).toString();
        this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_k_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    }
    else if (((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 3) || (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 19)) && ((TextUtils.equals(String.valueOf(90000000L), this.jdField_v_of_type_JavaLangString)) || (TextUtils.equals(String.valueOf(90000000L), this.jdField_m_of_type_JavaLangString))))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get()))
      {
        this.jdField_k_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(-16777216);
      this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(null);
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 82)
    {
      if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.size() != 0) && (!TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString)))
      {
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_i_of_type_AndroidWidgetTextView.setText(this.jdField_o_of_type_JavaLangString);
      }
      else
      {
        this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      Object localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.jdField_j_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i(".troop.troop_pubaccount", 2, "mStructMsg.msg.req_uin_nick is empty from StructMsg_IM.proto");
        }
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        localObject = (ITroopSysMsgDependApiService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopSysMsgDependApiService.class, "");
        if (localObject != null) {
          ((ITroopSysMsgDependApiService)localObject).requestForPubAccountInfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get(), new TroopRequestActivity.5(this));
        }
      }
      this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener(new TroopRequestActivity.6(this));
      localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
      localStringBuilder.append("");
      ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_public", "", "oper", "exp_invite", 0, 0, "", "", "", localStringBuilder.toString());
      return;
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void v()
  {
    ITroopSysMsgDependApiService localITroopSysMsgDependApiService = (ITroopSysMsgDependApiService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (localITroopSysMsgDependApiService != null) {
      startActivityForResult(localITroopSysMsgDependApiService.startJoinTroop(this, this.jdField_a_of_type_JavaLangString, this.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_Short, 10014, this.jdField_p_of_type_JavaLangString, this.jdField_q_of_type_JavaLangString, null, null, null), 0);
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
    paramBoolean2 = paramString3.equals(getString(2131719412));
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
    boolean bool = ((String)localObject1).contains(HardCodeUtil.a(2131715523));
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
    if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get()))
    {
      int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
      if ((i1 == 16) || (i1 == 3)) {
        paramBoolean1 = false;
      }
    }
    String str1;
    String str2;
    StringBuilder localStringBuilder;
    if (paramString.contains(getString(2131719417)))
    {
      str1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
      if (TextUtils.isEmpty(str1)) {
        return null;
      }
      str2 = getString(2131719417);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
      localStringBuilder.append("");
      return a(paramString, str1, str2, localStringBuilder.toString(), paramBoolean1, paramBoolean2);
    }
    if (paramString.contains(getString(2131719405)))
    {
      str1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get();
      if (TextUtils.isEmpty(str1)) {
        return null;
      }
      str2 = getString(2131719405);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      localStringBuilder.append("");
      return a(paramString, str1, str2, localStringBuilder.toString(), paramBoolean1, paramBoolean2);
    }
    if (paramString.contains(getString(2131719406)))
    {
      str1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin_nick.get();
      if (TextUtils.isEmpty(str1)) {
        return null;
      }
      str2 = getString(2131719406);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get());
      localStringBuilder.append("");
      return a(paramString, str1, str2, localStringBuilder.toString(), paramBoolean1, paramBoolean2);
    }
    if (paramString.contains(getString(2131719412)))
    {
      str1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get();
      if (TextUtils.isEmpty(str1)) {
        return null;
      }
      str2 = getString(2131719412);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
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
                              str = getString(2131696289);
                              break;
                            case 15: 
                            case 16: 
                              str = getString(2131696288);
                            }
                            break;
                          case 13: 
                            str = getString(2131696298);
                            break;
                          case 12: 
                            str = getString(2131696291);
                            break;
                          case 11: 
                            str = getString(2131696296);
                            break;
                          case 10: 
                            str = getString(2131696292);
                            break;
                          }
                        }
                        str = getString(2131696299);
                        break label301;
                      }
                      str = getString(2131696276);
                      break label301;
                    }
                    str = getString(2131696287);
                    break label301;
                  }
                  str = getString(2131696295);
                  break label301;
                }
              }
              else
              {
                str = getString(2131696301);
                break label301;
              }
            }
            else
            {
              str = getString(2131696290);
              break label301;
            }
          }
          else
          {
            str = getString(2131696297);
            break label301;
          }
        }
        else
        {
          str = getString(2131696300);
          break label301;
        }
      }
      else
      {
        str = getString(2131696293);
        break label301;
      }
    }
    String str = getString(2131696294);
    label301:
    if (QLog.isColorLevel()) {
      QLog.i("Q.systemmsg.TroopRequestActivity", 2, String.format("getTitle msgType:%s subType:%s, srcId:%s, subSrcId:%s, title:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get()), Integer.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get()), str }));
    }
    return str;
  }
  
  public void a()
  {
    m();
    int i1 = this.jdField_b_of_type_Int;
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
    QQToast.a(this, paramString, 0).b(getTitleBarHeight());
    finish();
  }
  
  void a(boolean paramBoolean)
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (localButton != null) {
      localButton.setEnabled(paramBoolean);
    }
    localButton = this.jdField_b_of_type_AndroidWidgetButton;
    if (localButton != null) {
      localButton.setEnabled(paramBoolean);
    }
  }
  
  boolean a(String paramString)
  {
    return (paramString.contains(getString(2131719417))) || (paramString.contains(getString(2131719406))) || (paramString.contains(getString(2131719412))) || (paramString.contains(getString(2131719405)));
  }
  
  public void b()
  {
    Object localObject = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_b_of_type_JavaLangString, 1);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    int i1 = this.jdField_b_of_type_Int;
    if ((i1 != 10) && (i1 != 12))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject).append(getString(2131696517));
      this.jdField_k_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
      ((StringBuilder)localObject).append(getString(2131696516));
      this.jdField_k_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    }
    localObject = this.jdField_d_of_type_AndroidViewView$OnClickListener;
    this.jdField_a_of_type_AndroidViewView.setOnClickListener((View.OnClickListener)localObject);
    if ((TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() == 2))
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(null);
      ((ImageView)findViewById(2131379254)).setVisibility(4);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_k_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_c_of_type_JavaLangString);
    } else {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
    }
    s();
    r();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidTextSpannableStringBuilder)) {
      this.jdField_s_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
    } else {
      this.jdField_s_of_type_AndroidWidgetTextView.setText("");
    }
    if (this.jdField_b_of_type_Int == 80)
    {
      this.jdField_s_of_type_AndroidWidgetTextView.setMaxLines(3);
      this.jdField_s_of_type_AndroidWidgetTextView.setSingleLine(false);
    }
    if (TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString))
    {
      this.jdField_t_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      this.jdField_t_of_type_AndroidWidgetTextView.setText(this.jdField_l_of_type_JavaLangString);
      this.jdField_t_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    long l1 = this.jdField_a_of_type_Long;
    if (l1 != 0L)
    {
      localObject = a(l1 * 1000L);
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get().split("：");
      if (localObject.length > 0)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(localObject[0]);
        TextView localTextView = this.jdField_f_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localObject[0]);
        localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
        localTextView.setContentDescription(localStringBuilder.toString());
        this.jdField_f_of_type_AndroidWidgetTextView.setFocusable(true);
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    else
    {
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    i1 = this.jdField_b_of_type_Int;
    if ((i1 != 1) && (i1 != 22) && (i1 != 60)) {
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    } else {
      this.jdField_f_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    if ((!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) && (this.jdField_b_of_type_Int != 2))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_g_of_type_JavaLangString);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (!TextUtils.isEmpty(this.jdField_r_of_type_JavaLangString))
    {
      this.jdField_u_of_type_AndroidWidgetTextView.setText(this.jdField_r_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_h_of_type_AndroidViewView$OnClickListener);
    }
    else
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_l_of_type_Int != 0)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B5B0", "0X800B5B0", 0, 0, "", "", "", "");
      this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_r_of_type_AndroidWidgetTextView.setText(getString(2131699549));
      return;
    }
    this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void c()
  {
    Object localObject = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, this.jdField_h_of_type_JavaLangString, 4);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable((Drawable)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_i_of_type_JavaLangString);
    ((StringBuilder)localObject).append(getString(2131696518));
    this.jdField_k_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    if (this.jdField_b_of_type_Int == 8)
    {
      this.jdField_a_of_type_AndroidViewView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_k_of_type_JavaLangString);
    if (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
    } else {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_i_of_type_JavaLangString);
    }
    localObject = (ITroopInfoService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopInfoService.class, "");
    if (localObject != null) {
      localObject = ((ITroopInfoService)localObject).findTroopInfo(String.valueOf(this.jdField_a_of_type_JavaLangString));
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((TroopInfo)localObject).dwGroupClassExt != 0L))
    {
      ThreadManager.post(new TroopRequestActivity.4(this, (TroopInfo)localObject), 8, null, true);
    }
    else
    {
      localObject = (ITroopInfoHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(ITroopInfoHandler.class.getName());
      if (localObject != null) {
        ((ITroopInfoHandler)localObject).c(this.jdField_a_of_type_JavaLangString);
      }
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidTextSpannableStringBuilder)) {
      this.jdField_s_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
    } else {
      this.jdField_s_of_type_AndroidWidgetTextView.setText("");
    }
    if (this.jdField_b_of_type_Int == 80)
    {
      this.jdField_s_of_type_AndroidWidgetTextView.setMaxLines(3);
      this.jdField_s_of_type_AndroidWidgetTextView.setSingleLine(false);
    }
    if (TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString))
    {
      this.jdField_t_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      this.jdField_t_of_type_AndroidWidgetTextView.setText(this.jdField_l_of_type_JavaLangString);
      this.jdField_t_of_type_AndroidWidgetTextView.setSingleLine(true);
      this.jdField_t_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    long l1 = this.jdField_a_of_type_Long;
    if (l1 != 0L)
    {
      localObject = a(l1 * 1000L);
      this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    }
    if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
    {
      localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_actor_describe.get();
      String[] arrayOfString = ((String)localObject).split("：");
      if (arrayOfString.length > 0)
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(arrayOfString[0]);
        TextView localTextView = this.jdField_f_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(arrayOfString[0]);
        localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
        localTextView.setContentDescription(localStringBuilder.toString());
        this.jdField_f_of_type_AndroidWidgetTextView.setFocusable(true);
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setText(this.jdField_f_of_type_JavaLangString);
      if (((String)localObject).contains(getString(2131719405))) {
        this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
      } else if (((String)localObject).contains(getString(2131719417))) {
        this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      }
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (TroopInfo.isQidianPrivateTroop(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get()))
      {
        int i1 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get();
        if ((i1 == 7) || (i1 == 11) || (i1 == 3) || (i1 == 16) || (i1 == 15)) {
          this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(null);
        }
      }
    }
    else
    {
      this.jdField_e_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    u();
    t();
    d();
    if (!TextUtils.isEmpty(this.jdField_r_of_type_JavaLangString))
    {
      this.jdField_u_of_type_AndroidWidgetTextView.setText(this.jdField_r_of_type_JavaLangString);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_h_of_type_AndroidViewView$OnClickListener);
    }
    else
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_r_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void d()
  {
    int i1 = 0;
    int i2;
    for (int i3 = 0; i1 < jdField_d_of_type_Int; i3 = i2)
    {
      LinearLayout[] arrayOfLinearLayout = this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout;
      i2 = i3;
      if (arrayOfLinearLayout[i1] != null)
      {
        i2 = i3;
        if (arrayOfLinearLayout[i1].getVisibility() != 8)
        {
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          i2 = 1;
        }
      }
      if (i1 > 0)
      {
        arrayOfLinearLayout = this.jdField_a_of_type_ArrayOfAndroidWidgetLinearLayout;
        i3 = i1 - 1;
        if (arrayOfLinearLayout[i3].getVisibility() == 8) {
          this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i3].setVisibility(8);
        } else {
          this.jdField_a_of_type_ArrayOfAndroidWidgetRelativeLayout[i3].setVisibility(0);
        }
      }
      i1 += 1;
    }
    if (i3 != 0)
    {
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
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
    super.setContentView(2131560693);
    paramBundle = getAppRuntime();
    if ((paramBundle instanceof AppInterface)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)paramBundle);
    } else {
      finish();
    }
    setContentBackgroundResource(2130838739);
    paramBundle = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMngHandlerName();
    this.jdField_a_of_type_ComTencentMobileqqTroopApiHandlerITroopMngHandler = ((ITroopMngHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(paramBundle));
    i();
    if (getIntent().getExtras().getBoolean("groupman_refuse", false))
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("troop_invitee_is_friend", false);
    this.jdField_d_of_type_Boolean = getIntent().getBooleanExtra("troop_suspicious_request", false);
    paramBundle = this.jdField_c_of_type_AndroidWidgetLinearLayout;
    if ((paramBundle != null) && (this.jdField_c_of_type_Boolean))
    {
      paramBundle.setVisibility(0);
    }
    else if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("isShowStrangerTips == ");
      paramBundle.append(this.jdField_c_of_type_Boolean);
      QLog.d("Q.systemmsg.TroopRequestActivity", 2, paramBundle.toString());
    }
    this.jdField_j_of_type_Int = getIntent().getIntExtra("troopfromtab", 0);
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_Int == 82) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
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
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_b_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqStrangerObserverStrangerObserver);
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_b_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqStrangerObserverStrangerObserver);
    if (this.jdField_b_of_type_Int != 82) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver);
    }
    super.doOnStop();
  }
  
  void e()
  {
    ActionSheet localActionSheet = (ActionSheet)a(this, null);
    int i1 = this.jdField_i_of_type_Int;
    String str;
    if (i1 != 0) {
      str = getString(i1);
    } else {
      str = "";
    }
    localActionSheet.setMainTitle(str);
    localActionSheet.addButton(getString(2131719060), 3);
    localActionSheet.setOnButtonClickListener(new TroopRequestActivity.9(this, localActionSheet));
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.show();
  }
  
  void f()
  {
    ActionSheet localActionSheet = (ActionSheet)a(this, null);
    localActionSheet.addButton(getString(2131690749), 3);
    localActionSheet.setOnButtonClickListener(new TroopRequestActivity.10(this, localActionSheet));
    localActionSheet.addCancelButton(2131690728);
    localActionSheet.show();
  }
  
  public void g()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694668);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
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
    paramString = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    paramBitmap = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get();
    if (paramString != null)
    {
      this.jdField_s_of_type_AndroidWidgetTextView.setVisibility(0);
      if (a(paramBitmap))
      {
        paramString = a(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get(), true, true);
        this.jdField_s_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      }
      if (!TextUtils.isEmpty(paramString))
      {
        this.jdField_s_of_type_AndroidWidgetTextView.setText(paramString);
        return;
      }
      this.jdField_s_of_type_AndroidWidgetTextView.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity
 * JD-Core Version:    0.7.0.1
 */