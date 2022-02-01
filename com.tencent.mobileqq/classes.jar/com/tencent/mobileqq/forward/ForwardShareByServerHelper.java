package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.OpenSdkConfBean;
import com.tencent.mobileqq.config.business.OpenSdkConfProcessor;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.sdk.report.SdkShareReporter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ArkJsonBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ClientInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ExtInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ImageInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.MiniAppMsgBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ReqBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.RichMsgBody;

public class ForwardShareByServerHelper
  implements Handler.Callback, ILifeCycleHelper
{
  public static final String a = HardCodeUtil.a(2131916403);
  final long b = 10000L;
  final UpCallBack c = new ForwardShareByServerHelper.1(this);
  final DialogInterface.OnClickListener d = new ForwardShareByServerHelper.6(this);
  private Dialog e;
  private QQCustomDialog f = null;
  private QQCustomDialog g;
  private BaseChatPie h;
  private Activity i;
  private Bundle j;
  private long k;
  private final MqqHandler l = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private boolean m = false;
  private long n = -1L;
  private volatile boolean o = false;
  private volatile boolean p = false;
  private OpenSdkShareModel q;
  private int r;
  private BroadcastReceiver s;
  
  public ForwardShareByServerHelper(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, " init ");
    }
    this.h = paramBaseChatPie;
    paramBaseChatPie = this.h;
    if (paramBaseChatPie != null)
    {
      this.i = paramBaseChatPie.f;
      paramBaseChatPie = this.i;
      if (paramBaseChatPie != null) {
        this.j = paramBaseChatPie.getIntent().getExtras();
      }
    }
  }
  
  public static QQCustomDialog a(Activity paramActivity, QQCustomDialog paramQQCustomDialog, BaseChatPie paramBaseChatPie, long paramLong, int paramInt, String paramString)
  {
    ForwardStatisticsReporter.b("KEY_STAGE_2_TOTAL");
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      String str = ((QQAppInterface)localObject1).getApplication().getString(2131916399);
      if (paramString != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(paramString);
        paramString = ((StringBuilder)localObject2).toString();
      }
      else
      {
        paramString = str;
      }
      Object localObject2 = ((QQAppInterface)localObject1).getApplication().getString(2131916405);
      str = ((QQAppInterface)localObject1).getApplication().getString(2131916400);
      localObject1 = new ForwardShareByServerHelper.2(paramLong, paramInt, paramActivity);
      paramBaseChatPie = new ForwardShareByServerHelper.3(paramLong, paramInt, paramActivity, paramBaseChatPie);
      if (paramQQCustomDialog == null) {
        paramActivity = DialogUtil.a(paramActivity, 232, null, (CharSequence)localObject2, paramString, str, (DialogInterface.OnClickListener)localObject1, paramBaseChatPie);
      } else {
        paramActivity = paramQQCustomDialog;
      }
      paramActivity.setNegativeButton(paramString, paramBaseChatPie);
      paramActivity.setPositiveButton(str, (DialogInterface.OnClickListener)localObject1);
      try
      {
        paramActivity.show();
        return paramActivity;
      }
      catch (Throwable paramQQCustomDialog)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "qbShowShareResultDialog: failed. ", paramQQCustomDialog);
        }
        return paramActivity;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, " qbShowShareResultDialog error mActivity = null or finished");
    }
    return null;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramString = paramContext.getPackageManager().getPackageInfo(paramString, 64).signatures;
      paramContext = MessageDigest.getInstance("MD5");
      paramContext.update(paramString[0].toByteArray());
      paramString = HexUtil.bytes2HexStr(paramContext.digest());
      if (paramString == null) {
        return "";
      }
      paramString = paramString.toLowerCase();
      paramContext.reset();
      return paramString;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    paramString = new StringBuilder();
    paramString.append(HardCodeUtil.a(2131916399));
    paramString.append(str);
    return paramString.toString();
  }
  
  public static oidb_cmd0xb77.ReqBody a(Bundle paramBundle, String paramString1, String paramString2, oidb_cmd0xb77.ImageInfo paramImageInfo)
  {
    return a(paramBundle, paramString1, paramString2, paramImageInfo, 0L);
  }
  
  public static oidb_cmd0xb77.ReqBody a(Bundle paramBundle, String paramString1, String paramString2, oidb_cmd0xb77.ImageInfo paramImageInfo, long paramLong)
  {
    int i1 = paramBundle.getInt("uintype");
    long l1 = ForwardUtils.a(paramBundle.getString("guild_id"));
    long l2 = paramBundle.getLong("req_share_id");
    int i2 = paramBundle.getInt("req_type");
    long l3 = ForwardUtils.a(paramBundle.getString("uin"));
    String str4 = paramBundle.getString("title");
    String str1 = paramBundle.getString("desc");
    String str2 = paramBundle.getString("detail_url");
    String str3 = paramBundle.getString("image_url_remote");
    Object localObject2 = paramBundle.getString("res_pkg_name");
    Object localObject1 = paramBundle.getString("share_comment_message");
    Object localObject3 = paramBundle.getString("share_comment_message_for_server");
    boolean bool = ArkFullScreenAppActivity.a(paramBundle);
    String str5 = paramBundle.getString("shareArkInfo");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buildcmd0xb77ReqBody picture_url =");
    localStringBuilder.append(str3);
    localStringBuilder.append(", musicUrl=");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\n, appId=");
    localStringBuilder.append(l2);
    localStringBuilder.append(", reqType = ");
    localStringBuilder.append(i2);
    localStringBuilder.append(", uinType = ");
    localStringBuilder.append(i1);
    localStringBuilder.append(", uin =");
    localStringBuilder.append(l3);
    localStringBuilder.append("\n, title = ");
    localStringBuilder.append(str4);
    localStringBuilder.append(", summary = ");
    localStringBuilder.append(str1);
    localStringBuilder.append(", url = ");
    localStringBuilder.append(str2);
    localStringBuilder.append("\n, mRemoteImgUrl = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", pkgName =");
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(", commentText = ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(", commentTextExt =");
    localStringBuilder.append((String)localObject3);
    localStringBuilder.append("\n, displayArkJson + ");
    localStringBuilder.append(bool);
    localStringBuilder.append(", arkInfo = ");
    localStringBuilder.append(str5);
    localStringBuilder.append(", localUniSeq =");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", guildId =");
    localStringBuilder.append(l1);
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, localStringBuilder.toString());
    localObject1 = new oidb_cmd0xb77.ReqBody();
    ((oidb_cmd0xb77.ReqBody)localObject1).appid.set(l2);
    ((oidb_cmd0xb77.ReqBody)localObject1).app_type.set(1);
    ((oidb_cmd0xb77.ReqBody)localObject1).recv_uin.set(l3);
    if (i1 == 0) {
      ((oidb_cmd0xb77.ReqBody)localObject1).send_type.set(0);
    }
    for (;;)
    {
      break;
      if (i1 == 1)
      {
        ((oidb_cmd0xb77.ReqBody)localObject1).send_type.set(1);
      }
      else if (i1 == 3000)
      {
        ((oidb_cmd0xb77.ReqBody)localObject1).send_type.set(2);
      }
      else if (i1 == 10014)
      {
        ((oidb_cmd0xb77.ReqBody)localObject1).send_type.set(3);
        ((oidb_cmd0xb77.ReqBody)localObject1).recv_guild_id.set(l1);
      }
    }
    if (i2 != 1) {
      if (i2 == 2) {
        ((oidb_cmd0xb77.ReqBody)localObject1).msg_style.set(4);
      } else if (i2 == 4) {
        ((oidb_cmd0xb77.ReqBody)localObject1).msg_style.set(5);
      } else if (i2 == 5) {
        ((oidb_cmd0xb77.ReqBody)localObject1).msg_style.set(6);
      } else {
        ((oidb_cmd0xb77.ReqBody)localObject1).msg_style.set(0);
      }
    }
    localObject3 = new oidb_cmd0xb77.ClientInfo();
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((oidb_cmd0xb77.ClientInfo)localObject3).android_package_name.set((String)localObject2);
    }
    ((oidb_cmd0xb77.ClientInfo)localObject3).platform.set(1);
    localObject2 = a(BaseApplicationImpl.getContext(), (String)localObject2);
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      ((oidb_cmd0xb77.ClientInfo)localObject3).android_signature.set((String)localObject2);
    }
    ((oidb_cmd0xb77.ClientInfo)localObject3).sdk_version.set("0.0.0");
    ((oidb_cmd0xb77.ReqBody)localObject1).client_info.set((MessageMicro)localObject3);
    localObject2 = new oidb_cmd0xb77.RichMsgBody();
    if (paramImageInfo != null) {
      ((oidb_cmd0xb77.RichMsgBody)localObject2).image_info.set(paramImageInfo);
    }
    if (!TextUtils.isEmpty(str4)) {
      ((oidb_cmd0xb77.RichMsgBody)localObject2).title.set(str4);
    }
    if (!TextUtils.isEmpty(str1))
    {
      paramImageInfo = str1;
      if (str1.contains(HardCodeUtil.a(2131902802))) {
        paramImageInfo = str1.replace(HardCodeUtil.a(2131902829), "");
      }
      ((oidb_cmd0xb77.RichMsgBody)localObject2).summary.set(paramImageInfo);
    }
    if (!TextUtils.isEmpty(str2)) {
      ((oidb_cmd0xb77.RichMsgBody)localObject2).url.set(str2);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      ((oidb_cmd0xb77.RichMsgBody)localObject2).picture_url.set(paramString1);
    } else if (!TextUtils.isEmpty(str3)) {
      ((oidb_cmd0xb77.RichMsgBody)localObject2).picture_url.set(str3);
    } else {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "richMsgBody picture_url not set");
    }
    if ((i2 == 2) && (!TextUtils.isEmpty(paramString2))) {
      ((oidb_cmd0xb77.RichMsgBody)localObject2).music_url.set(paramString2);
    }
    ((oidb_cmd0xb77.ReqBody)localObject1).rich_msg_body.set((MessageMicro)localObject2);
    paramString1 = new oidb_cmd0xb77.ExtInfo();
    if (paramLong != 0L) {
      paramString1.msg_seq.set(paramLong);
    }
    paramString2 = paramBundle.getString("game_tag_name");
    paramBundle = paramBundle.getString("game_message_ext");
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.tag_name.set(ByteStringMicro.copyFrom(paramString2.getBytes()));
    }
    if (!TextUtils.isEmpty(paramBundle)) {
      paramString1.message_ext.set(ByteStringMicro.copyFrom(paramBundle.getBytes()));
    }
    ((oidb_cmd0xb77.ReqBody)localObject1).ext_info.set(paramString1);
    return localObject1;
  }
  
  public static void a(long paramLong, int paramInt, Activity paramActivity)
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Util.a((AppRuntime)localObject1, "", "choose", paramLong, paramInt, "stay");
    ReportCenter.a().a(((QQAppInterface)localObject1).getAccount(), "", String.valueOf(paramLong), "1000", "52", "0", false, true);
    localObject1 = paramActivity.getIntent();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("com.tencent.tauth.opensdk.SHARE_SUCCESS_AND_STAY_QQ_");
    ((StringBuilder)localObject2).append(((Intent)localObject1).getLongExtra("activity_finish_run_appId", 0L));
    Object localObject3 = ((StringBuilder)localObject2).toString();
    localObject2 = ((Intent)localObject1).getStringExtra("res_pkg_name");
    localObject3 = new Intent((String)localObject3);
    localObject1 = (Uri)((Intent)localObject1).getParcelableExtra("activity_finish_run_uriData");
    ((Intent)localObject3).setPackage((String)localObject2);
    ((Intent)localObject3).putExtra("uriData", (Parcelable)localObject1);
    paramActivity.sendBroadcast((Intent)localObject3);
  }
  
  public static void a(long paramLong, int paramInt, Activity paramActivity, BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Util.a(localQQAppInterface, "", "choose", paramLong, paramInt, "back");
    ReportCenter.a().a(localQQAppInterface.getAccount(), "", String.valueOf(paramLong), "1000", "51", "0", false, true);
    Util.a(paramActivity, 0, "", "");
    if (paramBaseChatPie != null) {
      paramBaseChatPie.f(1);
    }
    if (paramActivity.getIntent().getBooleanExtra("show_share_result_dialog_return_thirdapp", true)) {
      try
      {
        paramBaseChatPie = (PendingIntent)paramActivity.getIntent().getParcelableExtra("activity_finish_run_pendingIntent");
        if ((paramBaseChatPie != null) && (!paramActivity.getIntent().getBooleanExtra("share_from_aio", false)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "-->finish--send callback using PendingIntent");
          }
          try
          {
            paramBaseChatPie.send();
          }
          catch (PendingIntent.CanceledException paramBaseChatPie)
          {
            QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "failed to send PendingIntent", paramBaseChatPie);
          }
        }
        paramActivity.moveTaskToBack(true);
        return;
      }
      catch (Throwable paramActivity)
      {
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "qbShowShareResultDialog ", paramActivity);
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, long paramLong, int paramInt, String paramString2)
  {
    if (paramActivity == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sdk_share:sdk callback= appid=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" action=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent();
    ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error&response={\"ret\":%3$d, \"msg\":\"%4$s\"}", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt), paramString2 })));
    if (paramActivity.getIntent() != null)
    {
      paramString2 = paramActivity.getIntent().getStringExtra("pkg_name");
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(paramString2)) {}
    }
    try
    {
      paramString1 = paramActivity.getIntent().getBundleExtra("share_data").getString("pkg_name");
    }
    catch (Exception paramString1)
    {
      label165:
      break label165;
    }
    paramString1 = null;
    ((Intent)localObject).setPackage(paramString1);
    try
    {
      paramActivity.startActivity((Intent)localObject);
      return;
    }
    catch (ActivityNotFoundException paramActivity)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, paramActivity.getMessage());
      }
      return;
    }
  }
  
  private void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("app_name");
    paramBundle = StructMsgFactory.a(paramBundle);
    if ((paramBundle != null) && ((paramBundle instanceof AbsShareMsg))) {
      paramBundle = (AbsShareMsg)paramBundle;
    } else {
      paramBundle = null;
    }
    this.f = a(this.i, this.f, this.h, paramBundle.mSourceAppid, paramBundle.mMsgServiceID, str);
  }
  
  public static void a(Bundle paramBundle, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("forward_mini_program_ark_from_sdk", false))) {
      ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X8009F7C", "0X8009F7C", 0, 0, "1", "", "", "");
    }
    int i2;
    int i1;
    if (paramBundle != null)
    {
      try
      {
        localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        i2 = paramBundle.getInt("uintype");
        str4 = paramBundle.getString("uin");
        if (i2 == 0) {
          break label334;
        }
        if (i2 == 1) {
          break label346;
        }
        if (i2 == 3000) {
          break label340;
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject1;
        String str4;
        String str3;
        String str1;
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "shareToQQ success report:", paramBundle);
      }
      OpenSdkStatic.a().a(0, "SHARE_TO_QQ", ((QQAppInterface)localObject1).getCurrentAccountUin(), String.valueOf(paramLong), String.valueOf(i1), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
      str3 = "1";
      if (paramInt == 1)
      {
        str1 = "1";
        break label352;
      }
      if (paramInt == 2)
      {
        str1 = "3";
        break label352;
      }
      if (paramInt == 5)
      {
        str1 = "2";
        break label352;
      }
      str1 = "4";
      break label352;
    }
    for (;;)
    {
      ReportCenter localReportCenter = ReportCenter.a();
      localObject1 = ((QQAppInterface)localObject1).getAccount();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      if (paramBoolean) {
        str3 = "0";
      }
      localReportCenter.a((String)localObject1, "", (String)localObject2, "10", "12", str3, str1, str4, str2, false, true);
      if (paramBoolean) {
        SdkShareReporter.a(paramBundle, paramInt, paramLong);
      }
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "shareToQQ success report:reportType=10,actType=12,result=0,type=", str1, ",toType=", str2 });
      return;
      return;
      label334:
      i1 = 1;
      break;
      label340:
      i1 = 3;
      break;
      label346:
      i1 = 2;
      break;
      label352:
      if (i2 != 0)
      {
        if (1 == i2)
        {
          str2 = "2";
          continue;
        }
        if (3000 == i2)
        {
          str2 = "3";
          continue;
        }
      }
      String str2 = "1";
    }
  }
  
  private void a(Bundle paramBundle, String paramString1, String paramString2)
  {
    paramString1 = a(paramBundle, paramString1, paramString2, null);
    a(this.q, paramBundle, paramString1);
    paramString2 = BaseApplicationImpl.getApplication().getRuntime();
    if (paramString2 == null)
    {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage send runtime = null ");
      c(a);
      return;
    }
    this.n = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putLong("0xb77_9_sendTime", this.n);
    QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage sendOIDBRequest");
    ForwardStatisticsReporter.a("KEY_STAGE_2_NORMAL_B77");
    ProtoUtils.a(paramString2, new ForwardShareByServerHelper.9(this, paramBundle), paramString1.toByteArray(), "OidbSvc.0xb77_9", 2935, 9, localBundle, 0L);
  }
  
  static void a(OpenSdkShareModel paramOpenSdkShareModel, Bundle paramBundle, oidb_cmd0xb77.ReqBody paramReqBody)
  {
    if (paramOpenSdkShareModel != null)
    {
      paramBundle = new oidb_cmd0xb77.MiniAppMsgBody();
      paramBundle.mini_app_appid.set(Long.parseLong(paramOpenSdkShareModel.miniAppAppid));
      paramBundle.mini_app_path.set(paramOpenSdkShareModel.miniAppPath);
      paramBundle.web_page_url.set(paramOpenSdkShareModel.webPageUrl);
      paramBundle.title.set(paramOpenSdkShareModel.title);
      paramBundle.desc.set(paramOpenSdkShareModel.desc);
      paramBundle.json_str.set(paramOpenSdkShareModel.jsonStr);
      paramReqBody.mini_app_msg_body.set(paramBundle);
      paramReqBody.msg_style.set(10);
      return;
    }
    if (ArkFullScreenAppActivity.a(paramBundle))
    {
      paramOpenSdkShareModel = paramBundle.getString("forward_ark_app_name");
      String str1 = paramBundle.getString("forward_ark_app_view");
      String str2 = paramBundle.getString("forward_ark_app_desc");
      String str3 = paramBundle.getString("forward_ark_app_ver");
      paramOpenSdkShareModel = new ArkAppMessage(paramBundle.getString("forward_ark_app_prompt"), paramOpenSdkShareModel, str2, str1, str3, paramBundle.getString("forward_ark_app_meta"), paramBundle.getString("forward_ark_app_config"), paramBundle.getString("forward_ark_app_compat"));
      paramBundle = new oidb_cmd0xb77.ArkJsonBody();
      paramBundle.json_str.set(paramOpenSdkShareModel.toAppXml());
      paramReqBody.ark_json_body.set(paramBundle);
      paramReqBody.msg_style.set(8);
    }
  }
  
  private void a(UpCallBack paramUpCallBack, AbsStructMsg paramAbsStructMsg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = new WeakReference(paramUpCallBack);
    if ((this.j != null) && (localQQAppInterface != null))
    {
      paramUpCallBack = this.i;
      if (paramUpCallBack != null)
      {
        if (!NetworkUtil.isNetSupport(paramUpCallBack))
        {
          c(HardCodeUtil.a(2131902786));
          QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, " requestShareMessage net error");
          return;
        }
        paramUpCallBack = this.j.getString("uin");
        int i1 = this.j.getInt("uintype");
        String str = this.j.getString("troop_uin");
        this.k = this.j.getLong("req_share_id");
        if (paramAbsStructMsg == null)
        {
          QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, " requestShareMessage error structMsg = null ");
          return;
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("requestShareMessage structMsg=");
        ((StringBuilder)localObject2).append(paramAbsStructMsg.getXml());
        QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, ((StringBuilder)localObject2).toString());
        localObject1 = (UpCallBack)((WeakReference)localObject1).get();
        localObject2 = this.l;
        ((MqqHandler)localObject2).sendMessageDelayed(((MqqHandler)localObject2).obtainMessage(93), 500L);
        ForwardStatisticsReporter.a("KEY_STAGE_2_SEND_MSG_BY_SERVER");
        AbsShareMsg.sendSdkShareMessageByServer(localQQAppInterface, (AbsShareMsg)paramAbsStructMsg, paramUpCallBack, i1, str, (UpCallBack)localObject1);
        return;
      }
    }
    paramUpCallBack = new StringBuilder();
    paramUpCallBack.append(" requestShareMessage error mExtra = ");
    paramUpCallBack.append(this.j);
    paramUpCallBack.append(", app=");
    paramUpCallBack.append(localQQAppInterface);
    paramUpCallBack.append(", mActivity =");
    paramUpCallBack.append(this.i);
    QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, paramUpCallBack.toString());
  }
  
  private void a(String paramString, Context paramContext)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpToErrorWeb: invoked. info: jumpUrl = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("SDK_SHARE.ForwardShareByServerHelper", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramContext != null)) {
      try
      {
        localObject = new Intent(paramContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramString);
        paramContext.startActivity((Intent)localObject);
        return;
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "jumpToErrorWeb: Failed. info: exception = ", paramString);
        }
      }
    }
  }
  
  private void b(int paramInt, String paramString1, String paramString2)
  {
    Bundle localBundle = this.i.getIntent().getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("forward_mini_program_ark_from_sdk", false))) {
      ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X8009F7C", "0X8009F7C", 0, 0, "2", String.valueOf(paramInt), "", "");
    }
    a(paramInt, paramString1, paramString2);
    a(this.j, this.r, this.k, false);
  }
  
  private void b(Bundle paramBundle)
  {
    int i1 = paramBundle.getInt("uintype");
    String str = paramBundle.getString("share_comment_message_for_server");
    if ((this.i != null) && (!TextUtils.isEmpty(str)))
    {
      if (i1 != 10014)
      {
        d(str);
        return;
      }
      ForwardUtils.b(paramBundle);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "sendCommentMsg null ");
    }
  }
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      a(paramString, this.i);
    }
    ForwardStatisticsReporter.a("KEY_STAGE_2_TOTAL", false);
    a(this.j, this.r, this.k, false);
  }
  
  private void c(String paramString)
  {
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "showOtherErrorDialog ", paramString });
    this.l.post(new ForwardShareByServerHelper.5(this, paramString));
  }
  
  public static long d()
  {
    OpenSdkConfBean localOpenSdkConfBean = OpenSdkConfProcessor.a();
    if (localOpenSdkConfBean == null)
    {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "getVerifyAppinfoTimeoutDuration null == confBean");
      return 5000L;
    }
    long l1 = localOpenSdkConfBean.a();
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "getVerifyAppinfoTimeoutDuration, timeoutDuration = ", Long.valueOf(l1) });
    if (l1 == 0L) {
      return 5000L;
    }
    return l1;
  }
  
  private void d(String paramString)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      SessionInfo localSessionInfo = ForwardUtils.a(this.i.getIntent());
      AnonymousChatHelper.a().j = true;
      ChatActivityFacade.b(localQQAppInterface, this.i, localSessionInfo, paramString);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "sendCommentMsgToC2C exception", paramString);
      }
    }
  }
  
  public static boolean e()
  {
    OpenSdkConfBean localOpenSdkConfBean = OpenSdkConfProcessor.a();
    boolean bool;
    if (localOpenSdkConfBean != null) {
      bool = localOpenSdkConfBean.b();
    } else {
      bool = false;
    }
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "isOpenedSDKShareImageByServer, shareImageByServer = ", Boolean.valueOf(bool) });
    return bool;
  }
  
  private void f()
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      this.i = ((BaseChatPie)localObject).f;
      localObject = this.i;
      if (localObject != null) {
        this.j = ((Activity)localObject).getIntent().getExtras();
      }
    }
    this.p = false;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" updateCurrentInfo mActivity = ");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append(", mExtra=");
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append(", mBaseChatPie =");
      ((StringBuilder)localObject).append(this.h);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private AbsStructMsg g()
  {
    Object localObject = this.i;
    if (localObject == null) {
      return null;
    }
    localObject = ((Activity)localObject).getIntent();
    if (localObject == null) {
      return null;
    }
    return StructMsgFactory.a(((Intent)localObject).getByteArrayExtra("stuctmsg_bytes"));
  }
  
  private void h()
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      String str = ((Bundle)localObject).getString("app_name");
      if (!this.j.getBoolean("refuse_show_share_result_dialog", false))
      {
        AbsStructMsg localAbsStructMsg = StructMsgFactory.a(this.j);
        localObject = null;
        if ((localAbsStructMsg instanceof AbsShareMsg)) {
          localObject = (AbsShareMsg)localAbsStructMsg;
        }
        this.f = a(this.i, this.f, this.h, ((AbsShareMsg)localObject).mSourceAppid, ((AbsShareMsg)localObject).mMsgServiceID, str);
      }
    }
    a(this.j, this.r, this.k, true);
  }
  
  private void i()
  {
    if (this.s == null)
    {
      this.s = new ForwardShareByServerHelper.8(this);
      this.i.registerReceiver(this.s, new IntentFilter("action_notify_aio_activity"));
    }
  }
  
  public void a()
  {
    this.l.removeMessages(94);
    c();
    Object localObject = this.f;
    if (localObject != null) {
      ((QQCustomDialog)localObject).dismiss();
    }
    this.p = false;
    this.m = false;
    this.o = false;
    this.n = -1L;
    localObject = this.s;
    if (localObject != null)
    {
      this.i.unregisterReceiver((BroadcastReceiver)localObject);
      this.s = null;
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    ForwardStatisticsReporter.a("KEY_STAGE_2_TOTAL", false);
    if (this.g == null) {
      this.g = DialogUtil.a(this.i, 230);
    }
    this.g.setMessage(paramString1);
    paramString1 = new ForwardShareByServerHelper.7(this, paramInt, paramString2);
    this.g.setPositiveButton(2131892267, paramString1);
    this.g.show();
  }
  
  public void a(Intent paramIntent)
  {
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "forwardShare");
    if (paramIntent != null)
    {
      Object localObject = paramIntent.getExtras();
      boolean bool;
      if (localObject != null) {
        bool = ((Bundle)localObject).getBoolean("share_send_msg_by_server", false);
      } else {
        bool = false;
      }
      this.r = paramIntent.getIntExtra("req_type", 2147483647);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "forwardShare sendMsgByServer =", Boolean.valueOf(bool), ",mForwardSubType=", Integer.valueOf(this.r) });
      this.q = ((OpenSdkShareModel)paramIntent.getParcelableExtra("KEY_MINI_PROGRAM_SHARE_OBJ"));
      if (bool)
      {
        paramIntent = g();
        SdkShareReporter.a(paramIntent, this.j);
        f();
        a(this.c, paramIntent);
        return;
      }
      paramIntent = paramIntent.getExtras();
      if ((paramIntent != null) && (!paramIntent.getBoolean("refuse_show_share_result_dialog", false)))
      {
        localObject = paramIntent.getString("key_share_image_by_server");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          a(paramIntent);
          SdkShareReporter.a(this.j, this.r, this.k);
          return;
        }
        localObject = ForwardImageDownUpMgr.a((String)localObject);
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "forwardShare errorMsg = ", localObject });
        if (localObject == null)
        {
          i();
          return;
        }
        if (((String)localObject).length() == 0)
        {
          a(paramIntent);
          SdkShareReporter.a(this.j, this.r, this.k);
          return;
        }
        c((String)localObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "forwardShare: intent.null ");
    }
  }
  
  public void b()
  {
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "showWaitDialog");
    Dialog localDialog = this.e;
    if (localDialog == null)
    {
      this.e = new ReportDialog(this.i, 2131953338);
      if (!this.i.isFinishing())
      {
        this.e.setCancelable(false);
        this.e.setContentView(2131625585);
        ((TextView)this.e.findViewById(2131440191)).setText(2131892581);
        this.e.show();
      }
      return;
    }
    if (!localDialog.isShowing()) {
      this.e.show();
    }
  }
  
  public void c()
  {
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "hideWaiteDialog");
    Dialog localDialog = this.e;
    if ((localDialog != null) && (localDialog.isShowing()) && (!this.i.isFinishing())) {
      this.l.post(new ForwardShareByServerHelper.4(this));
    }
  }
  
  public String getTag()
  {
    return "SDK_SHARE.ForwardShareByServerHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 93)
    {
      if (i1 != 94) {
        return true;
      }
      if ((!this.i.isFinishing()) && (this.o))
      {
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "MSG_SDK_SHARE_REQUEST_TIMEOUT_STATUS");
        ReportController.b(null, "dc00898", "", "", "0X8009CF9", "0X8009CF9", 0, 0, "", "", "", "");
        this.m = true;
        c();
        c(HardCodeUtil.a(2131902785));
        return true;
      }
    }
    else
    {
      if ((!this.p) && (this.o))
      {
        b();
        paramMessage = this.l;
        paramMessage.sendMessageDelayed(paramMessage.obtainMessage(94), 10000L);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("SDK_SHARE.ForwardShareByServerHelper", 2, "isRequestDone do not show dialog");
      }
    }
    return true;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 8)
    {
      if (paramInt != 15) {
        return;
      }
      a();
      if (QLog.isColorLevel()) {
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "onMoveToState DESTROY =");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "onMoveToState SHOW_FIRST_BEGIN ");
      }
      this.o = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper
 * JD-Core Version:    0.7.0.1
 */