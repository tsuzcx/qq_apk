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
import com.tencent.mobileqq.pb.MessageMicro;
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
  public static final String a;
  private int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long = 10000L;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  final DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ForwardShareByServerHelper.6(this);
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private OpenSdkShareModel jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel;
  final UpCallBack jdField_a_of_type_ComTencentMobileqqPicUpCallBack = new ForwardShareByServerHelper.1(this);
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long;
  private QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private long jdField_c_of_type_Long = -1L;
  private volatile boolean jdField_c_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131719152);
  }
  
  public ForwardShareByServerHelper(BaseChatPie paramBaseChatPie)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, " init ");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a;
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      }
    }
  }
  
  public static long a()
  {
    OpenSdkConfBean localOpenSdkConfBean = OpenSdkConfProcessor.a();
    if (localOpenSdkConfBean == null) {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "getVerifyAppinfoTimeoutDuration null == confBean");
    }
    long l;
    do
    {
      return 5000L;
      l = localOpenSdkConfBean.a();
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "getVerifyAppinfoTimeoutDuration, timeoutDuration = ", Long.valueOf(l) });
    } while (l == 0L);
    return l;
  }
  
  private AbsStructMsg a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    Intent localIntent;
    do
    {
      return null;
      localIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
    } while (localIntent == null);
    return StructMsgFactory.a(localIntent.getByteArrayExtra("stuctmsg_bytes"));
  }
  
  public static QQCustomDialog a(Activity paramActivity, QQCustomDialog paramQQCustomDialog, BaseChatPie paramBaseChatPie, long paramLong, int paramInt, String paramString)
  {
    ForwardStatisticsReporter.b("KEY_STAGE_2_TOTAL");
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, " qbShowShareResultDialog error mActivity = null or finished");
      }
      paramActivity = null;
      return paramActivity;
    }
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = ((QQAppInterface)localObject).getApplication().getString(2131719148);
    if (paramString != null) {}
    for (paramString = str + paramString;; paramString = str)
    {
      str = ((QQAppInterface)localObject).getApplication().getString(2131719154);
      localObject = ((QQAppInterface)localObject).getApplication().getString(2131719149);
      ForwardShareByServerHelper.2 local2 = new ForwardShareByServerHelper.2(paramLong, paramInt, paramActivity);
      ForwardShareByServerHelper.3 local3 = new ForwardShareByServerHelper.3(paramLong, paramInt, paramActivity, paramBaseChatPie);
      paramBaseChatPie = paramQQCustomDialog;
      if (paramQQCustomDialog == null) {
        paramBaseChatPie = DialogUtil.a(paramActivity, 232, null, str, paramString, (String)localObject, local2, local3);
      }
      paramBaseChatPie.setNegativeButton(paramString, local3);
      paramBaseChatPie.setPositiveButton((String)localObject, local2);
      try
      {
        paramBaseChatPie.show();
        return paramBaseChatPie;
      }
      catch (Throwable paramQQCustomDialog)
      {
        paramActivity = paramBaseChatPie;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "qbShowShareResultDialog: failed. ", paramQQCustomDialog);
      return paramBaseChatPie;
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64).signatures;
      paramString = MessageDigest.getInstance("MD5");
      paramString.update(paramContext[0].toByteArray());
      paramContext = HexUtil.bytes2HexStr(paramString.digest());
      if (paramContext == null) {
        return "";
      }
      paramContext = paramContext.toLowerCase();
      paramString.reset();
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = "";
      }
    }
    return paramContext;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return HardCodeUtil.a(2131719148) + str;
  }
  
  public static oidb_cmd0xb77.ReqBody a(Bundle paramBundle, String paramString1, String paramString2, oidb_cmd0xb77.ImageInfo paramImageInfo)
  {
    return a(paramBundle, paramString1, paramString2, paramImageInfo, 0L);
  }
  
  public static oidb_cmd0xb77.ReqBody a(Bundle paramBundle, String paramString1, String paramString2, oidb_cmd0xb77.ImageInfo paramImageInfo, long paramLong)
  {
    int i = paramBundle.getInt("uintype");
    long l1 = paramBundle.getLong("req_share_id");
    int j = paramBundle.getInt("req_type");
    long l2 = ForwardUtils.a(paramBundle.getString("uin"));
    String str4 = paramBundle.getString("title");
    String str1 = paramBundle.getString("desc");
    String str2 = paramBundle.getString("detail_url");
    String str3 = paramBundle.getString("image_url_remote");
    Object localObject2 = paramBundle.getString("res_pkg_name");
    Object localObject1 = paramBundle.getString("share_comment_message");
    String str5 = paramBundle.getString("share_comment_message_for_server");
    boolean bool = ArkFullScreenAppActivity.a(paramBundle);
    paramBundle = paramBundle.getString("shareArkInfo");
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "buildcmd0xb77ReqBody picture_url =" + str3 + ", musicUrl=" + paramString2 + "\n, appId=" + l1 + ", reqType = " + j + ", uinType = " + i + ", uin =" + l2 + "\n, title = " + str4 + ", summary = " + str1 + ", url = " + str2 + "\n, mRemoteImgUrl = " + paramString1 + ", pkgName =" + (String)localObject2 + ", commentText = " + (String)localObject1 + ", commentTextExt =" + str5 + "\n, displayArkJson + " + bool + ", arkInfo = " + paramBundle + ", localUniSeq=" + paramLong);
    localObject1 = new oidb_cmd0xb77.ReqBody();
    ((oidb_cmd0xb77.ReqBody)localObject1).appid.set(l1);
    ((oidb_cmd0xb77.ReqBody)localObject1).app_type.set(1);
    ((oidb_cmd0xb77.ReqBody)localObject1).recv_uin.set(l2);
    if (i == 0)
    {
      ((oidb_cmd0xb77.ReqBody)localObject1).send_type.set(0);
      if (j != 1) {
        break label671;
      }
      label363:
      paramBundle = new oidb_cmd0xb77.ClientInfo();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        paramBundle.android_package_name.set((String)localObject2);
      }
      paramBundle.platform.set(1);
      localObject2 = a(BaseApplicationImpl.getContext(), (String)localObject2);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        paramBundle.android_signature.set((String)localObject2);
      }
      paramBundle.sdk_version.set("0.0.0");
      ((oidb_cmd0xb77.ReqBody)localObject1).client_info.set(paramBundle);
      localObject2 = new oidb_cmd0xb77.RichMsgBody();
      if (paramImageInfo != null) {
        ((oidb_cmd0xb77.RichMsgBody)localObject2).image_info.set(paramImageInfo);
      }
      if (!TextUtils.isEmpty(str4)) {
        ((oidb_cmd0xb77.RichMsgBody)localObject2).title.set(str4);
      }
      if (!TextUtils.isEmpty(str1))
      {
        paramBundle = str1;
        if (str1.contains(HardCodeUtil.a(2131704834))) {
          paramBundle = str1.replace(HardCodeUtil.a(2131704861), "");
        }
        ((oidb_cmd0xb77.RichMsgBody)localObject2).summary.set(paramBundle);
      }
      if (!TextUtils.isEmpty(str2)) {
        ((oidb_cmd0xb77.RichMsgBody)localObject2).url.set(str2);
      }
      if (TextUtils.isEmpty(paramString1)) {
        break label738;
      }
      ((oidb_cmd0xb77.RichMsgBody)localObject2).picture_url.set(paramString1);
    }
    for (;;)
    {
      if ((j == 2) && (!TextUtils.isEmpty(paramString2))) {
        ((oidb_cmd0xb77.RichMsgBody)localObject2).music_url.set(paramString2);
      }
      ((oidb_cmd0xb77.ReqBody)localObject1).rich_msg_body.set((MessageMicro)localObject2);
      if (paramLong != 0L)
      {
        paramBundle = new oidb_cmd0xb77.ExtInfo();
        paramBundle.msg_seq.set(paramLong);
        ((oidb_cmd0xb77.ReqBody)localObject1).ext_info.set(paramBundle);
      }
      return localObject1;
      if (i == 1)
      {
        ((oidb_cmd0xb77.ReqBody)localObject1).send_type.set(1);
        break;
      }
      if (i != 3000) {
        break;
      }
      ((oidb_cmd0xb77.ReqBody)localObject1).send_type.set(2);
      break;
      label671:
      if (j == 2)
      {
        ((oidb_cmd0xb77.ReqBody)localObject1).msg_style.set(4);
        break label363;
      }
      if (j == 4)
      {
        ((oidb_cmd0xb77.ReqBody)localObject1).msg_style.set(5);
        break label363;
      }
      if (j == 5)
      {
        ((oidb_cmd0xb77.ReqBody)localObject1).msg_style.set(6);
        break label363;
      }
      ((oidb_cmd0xb77.ReqBody)localObject1).msg_style.set(0);
      break label363;
      label738:
      if (!TextUtils.isEmpty(str3)) {
        ((oidb_cmd0xb77.RichMsgBody)localObject2).picture_url.set(str3);
      } else {
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "richMsgBody picture_url not set");
      }
    }
  }
  
  public static void a(long paramLong, int paramInt, Activity paramActivity)
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Util.a((AppRuntime)localObject1, "", "choose", paramLong, paramInt, "stay");
    ReportCenter.a().a(((QQAppInterface)localObject1).getAccount(), "", String.valueOf(paramLong), "1000", "52", "0", false, true);
    Object localObject2 = paramActivity.getIntent();
    Object localObject3 = "com.tencent.tauth.opensdk.SHARE_SUCCESS_AND_STAY_QQ_" + ((Intent)localObject2).getLongExtra("activity_finish_run_appId", 0L);
    localObject1 = ((Intent)localObject2).getStringExtra("res_pkg_name");
    localObject3 = new Intent((String)localObject3);
    localObject2 = (Uri)((Intent)localObject2).getParcelableExtra("activity_finish_run_uriData");
    ((Intent)localObject3).setPackage((String)localObject1);
    ((Intent)localObject3).putExtra("uriData", (Parcelable)localObject2);
    paramActivity.sendBroadcast((Intent)localObject3);
  }
  
  public static void a(long paramLong, int paramInt, Activity paramActivity, BaseChatPie paramBaseChatPie)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Util.a(localQQAppInterface, "", "choose", paramLong, paramInt, "back");
    ReportCenter.a().a(localQQAppInterface.getAccount(), "", String.valueOf(paramLong), "1000", "51", "0", false, true);
    Util.a(paramActivity, 0, "", "");
    if (paramBaseChatPie != null) {
      paramBaseChatPie.b(1);
    }
    if (paramActivity.getIntent().getBooleanExtra("show_share_result_dialog_return_thirdapp", true)) {
      try
      {
        paramBaseChatPie = (PendingIntent)paramActivity.getIntent().getParcelableExtra("activity_finish_run_pendingIntent");
        if ((paramBaseChatPie != null) && (!paramActivity.getIntent().getBooleanExtra("share_from_aio", false))) {
          if (QLog.isColorLevel()) {
            QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "-->finish--send callback using PendingIntent");
          }
        }
        try
        {
          paramBaseChatPie.send();
          paramActivity.moveTaskToBack(true);
          return;
        }
        catch (PendingIntent.CanceledException paramBaseChatPie)
        {
          for (;;)
          {
            QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "failed to send PendingIntent", paramBaseChatPie);
          }
        }
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
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "sdk_share:sdk callback= appid=" + paramLong + " action=" + paramString1);
      }
      Intent localIntent = new Intent();
      localIntent.setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=error&response={\"ret\":%3$d, \"msg\":\"%4$s\"}", new Object[] { Long.valueOf(paramLong), paramString1, Integer.valueOf(paramInt), paramString2 })));
      if (paramActivity.getIntent() != null)
      {
        paramString2 = paramActivity.getIntent().getStringExtra("pkg_name");
        paramString1 = paramString2;
        if (!TextUtils.isEmpty(paramString2)) {}
      }
      try
      {
        paramString1 = paramActivity.getIntent().getBundleExtra("share_data").getString("pkg_name");
        localIntent.setPackage(paramString1);
        try
        {
          paramActivity.startActivity(localIntent);
          return;
        }
        catch (ActivityNotFoundException paramActivity) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, paramActivity.getMessage());
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1 = null;
        }
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    String str = paramBundle.getString("app_name");
    paramBundle = StructMsgFactory.a(paramBundle);
    if ((paramBundle != null) && ((paramBundle instanceof AbsShareMsg))) {}
    for (paramBundle = (AbsShareMsg)paramBundle;; paramBundle = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, paramBundle.mSourceAppid, paramBundle.mMsgServiceID, str);
      return;
    }
  }
  
  public static void a(Bundle paramBundle, int paramInt, long paramLong, boolean paramBoolean)
  {
    if ((paramBundle != null) && (paramBundle.getBoolean("forward_mini_program_ark_from_sdk", false))) {
      ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X8009F7C", "0X8009F7C", 0, 0, "1", "", "", "");
    }
    if (paramBundle != null) {}
    for (;;)
    {
      int j;
      String str1;
      try
      {
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        j = paramBundle.getInt("uintype");
        str3 = paramBundle.getString("uin");
        switch (j)
        {
        default: 
          OpenSdkStatic.a().a(0, "SHARE_TO_QQ", ((QQAppInterface)localObject).getCurrentAccountUin(), String.valueOf(paramLong), String.valueOf(i), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
          if (paramInt != 1) {
            break label349;
          }
          str1 = "1";
        }
      }
      catch (Exception paramBundle)
      {
        Object localObject;
        String str3;
        label170:
        ReportCenter localReportCenter;
        String str4;
        String str5;
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "shareToQQ success report:", paramBundle);
        return;
      }
      localReportCenter = ReportCenter.a();
      str4 = ((QQAppInterface)localObject).getAccount();
      str5 = paramLong + "";
      String str2;
      if (paramBoolean)
      {
        localObject = "0";
        localReportCenter.a(str4, "", str5, "10", "12", (String)localObject, str1, str3, str2, false, true);
        if (paramBoolean) {
          b(paramBundle, paramInt, paramLong);
        }
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "shareToQQ success report:reportType=10,actType=12,result=0,type=", str1, ",toType=", str2 });
        return;
      }
      localObject = "1";
      continue;
      int i = 1;
      continue;
      for (;;)
      {
        str2 = "1";
        if (j != 0) {
          break label383;
        }
        str2 = "1";
        break label170;
        return;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
        label349:
        if (paramInt == 2) {
          str1 = "3";
        } else if (paramInt == 5) {
          str1 = "2";
        } else {
          str1 = "4";
        }
      }
      label383:
      if (1 == j) {
        str2 = "2";
      } else if (3000 == j) {
        str2 = "3";
      }
    }
  }
  
  private void a(Bundle paramBundle, String paramString1, String paramString2)
  {
    paramString1 = a(paramBundle, paramString1, paramString2, null);
    a(this.jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel, paramBundle, paramString1);
    paramString2 = BaseApplicationImpl.getApplication().getRuntime();
    if (paramString2 == null)
    {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, "notifyServerSendMessage send runtime = null ");
      b(jdField_a_of_type_JavaLangString);
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    Bundle localBundle = new Bundle();
    localBundle.putLong("0xb77_9_sendTime", this.jdField_c_of_type_Long);
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
    }
    while (!ArkFullScreenAppActivity.a(paramBundle)) {
      return;
    }
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
  
  private void a(UpCallBack paramUpCallBack, AbsStructMsg paramAbsStructMsg)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = new WeakReference(paramUpCallBack);
    if ((this.jdField_a_of_type_AndroidOsBundle == null) || (localQQAppInterface == null) || (this.jdField_a_of_type_AndroidAppActivity == null))
    {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, " requestShareMessage error mExtra = " + this.jdField_a_of_type_AndroidOsBundle + ", app=" + localQQAppInterface + ", mActivity =" + this.jdField_a_of_type_AndroidAppActivity);
      return;
    }
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidAppActivity))
    {
      b(HardCodeUtil.a(2131704818));
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, " requestShareMessage net error");
      return;
    }
    paramUpCallBack = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("uintype");
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("troop_uin");
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
    if (paramAbsStructMsg == null)
    {
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 1, " requestShareMessage error structMsg = null ");
      return;
    }
    QLog.i("SDK_SHARE.ForwardShareByServerHelper", 1, "requestShareMessage structMsg=" + paramAbsStructMsg.getXml());
    localObject = (UpCallBack)((WeakReference)localObject).get();
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(93), 500L);
    ForwardStatisticsReporter.a("KEY_STAGE_2_SEND_MSG_BY_SERVER");
    AbsShareMsg.sendSdkShareMessageByServer(localQQAppInterface, (AbsShareMsg)paramAbsStructMsg, paramUpCallBack, i, str, (UpCallBack)localObject);
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      a(paramString, this.jdField_a_of_type_AndroidAppActivity);
    }
    ForwardStatisticsReporter.a("KEY_STAGE_2_TOTAL", false);
    a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, this.jdField_b_of_type_Long, false);
  }
  
  private void a(String paramString, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SDK_SHARE.ForwardShareByServerHelper", 2, "jumpToErrorWeb: invoked. info: jumpUrl = " + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramContext != null)) {}
    try
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "jumpToErrorWeb: Failed. info: exception = ", paramString);
    }
  }
  
  public static boolean a()
  {
    OpenSdkConfBean localOpenSdkConfBean = OpenSdkConfProcessor.a();
    if (localOpenSdkConfBean != null) {}
    for (boolean bool = localOpenSdkConfBean.a();; bool = false)
    {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "isOpenedSDKShareImageByServer, shareImageByServer = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  private void b(int paramInt, String paramString1, String paramString2)
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("forward_mini_program_ark_from_sdk", false))) {
      ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X8009F7C", "0X8009F7C", 0, 0, "2", String.valueOf(paramInt), "", "");
    }
    a(paramInt, paramString1, paramString2);
    a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, this.jdField_b_of_type_Long, false);
  }
  
  private static void b(Bundle paramBundle, int paramInt, long paramLong)
  {
    String str = paramBundle.getString("title");
    int i = paramBundle.getInt("uintype");
    ReportController.b(null, "dc00898", "", "", "0X800B2DB", "0X800B2DB", 0, 0, String.valueOf(paramLong), ForwardUtils.c(paramInt), ForwardUtils.a(i), str);
  }
  
  private void b(String paramString)
  {
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "showOtherErrorDialog ", paramString });
    this.jdField_a_of_type_MqqOsMqqHandler.post(new ForwardShareByServerHelper.5(this, paramString));
  }
  
  private void c(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity != null) && (!TextUtils.isEmpty(paramString))) {}
    while (!QLog.isColorLevel()) {
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        SessionInfo localSessionInfo = ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity.getIntent());
        AnonymousChatHelper.a().jdField_a_of_type_Boolean = true;
        ChatActivityFacade.b(localQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localSessionInfo, paramString);
        return;
      }
      catch (Exception paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "sendCommentMsg exception", paramString);
        return;
      }
    }
    QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "sendCommentMsg null ");
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a;
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidAppActivity.getIntent().getExtras();
      }
    }
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, " updateCurrentInfo mActivity = " + this.jdField_a_of_type_AndroidAppActivity + ", mExtra=" + this.jdField_a_of_type_AndroidOsBundle + ", mBaseChatPie =" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
    }
  }
  
  private void e()
  {
    String str;
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      if (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("refuse_show_share_result_dialog", false))
      {
        localObject = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
        if (!(localObject instanceof AbsShareMsg)) {
          break label97;
        }
      }
    }
    label97:
    for (Object localObject = (AbsShareMsg)localObject;; localObject = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, ((AbsShareMsg)localObject).mSourceAppid, ((AbsShareMsg)localObject).mMsgServiceID, str);
      a(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, this.jdField_b_of_type_Long, true);
      return;
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ForwardShareByServerHelper.8(this);
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("action_notify_aio_activity"));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(94);
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Long = -1L;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    ForwardStatisticsReporter.a("KEY_STAGE_2_TOTAL", false);
    if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 230);
    }
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(paramString1);
    paramString1 = new ForwardShareByServerHelper.7(this, paramInt, paramString2);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(2131694615, paramString1);
    this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  public void a(Intent paramIntent)
  {
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "forwardShare");
    Object localObject;
    if (paramIntent != null)
    {
      localObject = paramIntent.getExtras();
      if (localObject == null) {
        break label352;
      }
    }
    label352:
    for (boolean bool = ((Bundle)localObject).getBoolean("share_send_msg_by_server", false);; bool = false)
    {
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("req_type", 2147483647);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "forwardShare sendMsgByServer =", Boolean.valueOf(bool), ",mForwardSubType=", Integer.valueOf(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_ComTencentMobileqqMiniShareOpensdkOpenSdkShareModel = ((OpenSdkShareModel)paramIntent.getParcelableExtra("KEY_MINI_PROGRAM_SHARE_OBJ"));
      if (bool)
      {
        localObject = a();
        String str1 = ForwardUtils.c(this.jdField_a_of_type_AndroidOsBundle.getInt("req_type"));
        String str2 = ForwardUtils.a(this.jdField_a_of_type_AndroidOsBundle.getInt("uintype"));
        if ((localObject instanceof AbsShareMsg))
        {
          paramIntent = ((AbsShareMsg)localObject).mContentTitle;
          ReportController.b(null, "dc00898", "", "", "0X8009C93", "0X8009C93", 0, 0, String.valueOf(this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id")), str1, str2, paramIntent);
          d();
          a(this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack, (AbsStructMsg)localObject);
        }
      }
      do
      {
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.e("SDK_SHARE.ForwardShareByServerHelper", 2, "forwardShare: intent.null ");
        return;
        paramIntent = "";
        break;
        paramIntent = paramIntent.getExtras();
      } while ((paramIntent == null) || (paramIntent.getBoolean("refuse_show_share_result_dialog", false)));
      localObject = paramIntent.getString("key_share_image_by_server");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        a(paramIntent);
        b(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, this.jdField_b_of_type_Long);
        return;
      }
      localObject = ForwardImageDownUpMgr.a((String)localObject);
      QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, new Object[] { "forwardShare errorMsg = ", localObject });
      if (localObject == null)
      {
        f();
        return;
      }
      if (((String)localObject).length() == 0)
      {
        a(paramIntent);
        b(this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_Int, this.jdField_b_of_type_Long);
        return;
      }
      b((String)localObject);
      return;
    }
  }
  
  public void b()
  {
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "showWaitDialog");
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_AndroidAppActivity, 2131755842);
      if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())
      {
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559683);
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373066)).setText(2131694889);
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
    }
    while (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void c()
  {
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "hideWaiteDialog");
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new ForwardShareByServerHelper.4(this));
    }
  }
  
  public String getTag()
  {
    return "SDK_SHARE.ForwardShareByServerHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
        if ((!this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
        {
          b();
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(94), 10000L);
          return true;
        }
      } while (!QLog.isColorLevel());
      QLog.i("SDK_SHARE.ForwardShareByServerHelper", 2, "isRequestDone do not show dialog");
      return true;
    } while ((this.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (!this.jdField_b_of_type_Boolean));
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 1, "MSG_SDK_SHARE_REQUEST_TIMEOUT_STATUS");
    ReportController.b(null, "dc00898", "", "", "0X8009CF9", "0X8009CF9", 0, 0, "", "", "", "");
    this.jdField_a_of_type_Boolean = true;
    c();
    b(HardCodeUtil.a(2131704817));
    return true;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 7, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "onMoveToState SHOW_FIRST_BEGIN ");
      }
      this.jdField_b_of_type_Boolean = true;
      return;
      a();
    } while (!QLog.isColorLevel());
    QLog.d("SDK_SHARE.ForwardShareByServerHelper", 2, "onMoveToState DESTROY =");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShareByServerHelper
 * JD-Core Version:    0.7.0.1
 */