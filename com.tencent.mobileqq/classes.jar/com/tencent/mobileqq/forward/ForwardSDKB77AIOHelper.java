package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.service.message.MessageConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ForwardSDKB77AIOHelper
  implements Handler.Callback, ILifeCycleHelper
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private final DialogInterface.OnClickListener jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ForwardSDKB77AIOHelper.3(this);
  private Intent jdField_a_of_type_AndroidContentIntent;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public ForwardSDKB77AIOHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidContentIntent.getIntExtra("req_type", 2147483647);
  }
  
  private void a()
  {
    b();
    Object localObject = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_b77_sdk_share");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showB77ResultDialog cachedKey empty");
      return;
    }
    this.jdField_a_of_type_AndroidContentIntent.removeExtra("key_b77_sdk_share");
    Map localMap = ((ForwardSdkStatusManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SDK_SHARE)).a((String)localObject);
    if (localMap == null)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "initBroadcastReceiver");
      b((String)localObject);
      localObject = this.jdField_a_of_type_MqqOsMqqHandler;
      ((MqqHandler)localObject).sendMessageDelayed(((MqqHandler)localObject).obtainMessage(93), 500L);
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showB77ResultDialog_parseB77Result");
    a(localMap);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    ForwardStatisticsReporter.a("KEY_STAGE_2_TOTAL", false);
    ForwardShareByServerHelper.a(this.jdField_a_of_type_AndroidOsBundle, a(), this.jdField_a_of_type_Long, false);
    Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
    if ((localBundle != null) && (localBundle.getBoolean("forward_mini_program_ark_from_sdk", false))) {
      ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X8009F7C", "0X8009F7C", 0, 0, "2", String.valueOf(paramInt), "", "");
    }
    ForwardDialogMgr.a(this.jdField_a_of_type_AndroidAppActivity, paramString1, new ForwardSDKB77AIOHelper.1(this, paramInt, paramString2));
  }
  
  public static void a(Activity paramActivity, HelperProvider paramHelperProvider)
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "doSdkShare");
    if (TextUtils.isEmpty(paramActivity.getIntent().getStringExtra("key_b77_sdk_share")))
    {
      paramHelperProvider = (ForwardShareByServerHelper)paramHelperProvider.a(13);
      if (paramHelperProvider != null) {
        paramHelperProvider.a(paramActivity.getIntent());
      }
    }
    else
    {
      paramActivity = (ForwardSDKB77AIOHelper)paramHelperProvider.a(57);
      if (paramActivity != null) {
        paramActivity.a();
      }
    }
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      a(paramString, this.jdField_a_of_type_AndroidAppActivity);
    }
    ForwardStatisticsReporter.a("KEY_STAGE_2_TOTAL", false);
    ForwardShareByServerHelper.a(this.jdField_a_of_type_AndroidOsBundle, a(), this.jdField_a_of_type_Long, false);
  }
  
  private void a(String paramString, Context paramContext)
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "jumpToErrorWeb: invoked. info: jumpUrl = ", paramString });
    if ((!TextUtils.isEmpty(paramString)) && (paramContext != null)) {
      try
      {
        Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
        localIntent.putExtra("url", paramString);
        paramContext.startActivity(localIntent);
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "jumpToErrorWeb: Failed. info: exception = ", paramString);
      }
    }
  }
  
  private void a(Map<String, Object> paramMap)
  {
    Integer localInteger1 = (Integer)paramMap.get("key_b77_error_code");
    Integer localInteger2 = (Integer)paramMap.get("key_b77_jump_result");
    String str1 = (String)paramMap.get("key_b77_jump_url");
    String str2 = (String)paramMap.get("key_b77_wording");
    paramMap = (String)paramMap.get("key_b77_develop_msg");
    if ((localInteger1 != null) && (localInteger1.intValue() != 0))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "errorCode=", localInteger1 });
      a(localInteger1.intValue(), str2, paramMap);
      return;
    }
    if ((localInteger2 != null) && (localInteger2.intValue() != 0))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "jumpResult=", localInteger2 });
      a(str1);
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "handleSendSuccess");
    c();
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localObject = this.jdField_a_of_type_AndroidAppDialog;
      if ((localObject != null) && (((Dialog)localObject).isShowing())) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(MessageForArkApp paramMessageForArkApp)
  {
    paramMessageForArkApp = paramMessageForArkApp.getExtInfoFromExtStr(MessageConstants.w);
    boolean bool = false;
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "resend forbid msg openSdkShareState=", paramMessageForArkApp });
    if (25201 == ForwardUtils.a(paramMessageForArkApp)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(MessageForArkApp paramMessageForArkApp, Context paramContext)
  {
    String str = paramMessageForArkApp.getExtInfoFromExtStr(MessageConstants.w);
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "resend forbid msg openSdkShareState=", str, ", uinseq=", Long.valueOf(paramMessageForArkApp.uniseq) });
    int i = ForwardUtils.a(str);
    if ((i != 0) && (i != 25201))
    {
      if (i == -2) {
        return false;
      }
      str = paramMessageForArkApp.getExtInfoFromExtStr(MessageConstants.y);
      if (TextUtils.isEmpty(str))
      {
        QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "resendSdkFakeMsg fakeShareInfo empty");
        return false;
      }
      ForwardSDKB77Sender localForwardSDKB77Sender = new ForwardSDKB77Sender();
      try
      {
        localForwardSDKB77Sender.a(paramMessageForArkApp, paramContext, new JSONObject(str));
        return true;
      }
      catch (Exception paramMessageForArkApp)
      {
        QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "Exception", paramMessageForArkApp);
      }
    }
    return false;
  }
  
  private void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidAppActivity = ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
      this.jdField_a_of_type_AndroidContentIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidContentIntent.getExtras();
      localObject = this.jdField_a_of_type_AndroidOsBundle;
      if (localObject != null) {
        this.jdField_a_of_type_Long = ((Bundle)localObject).getLong("req_share_id");
      }
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { " updateCurrentInfo mExtra=", this.jdField_a_of_type_AndroidOsBundle, ", mShareAppId=", Long.valueOf(this.jdField_a_of_type_Long) });
  }
  
  private void b(String paramString)
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ForwardSDKB77AIOHelper.2(this, paramString);
      this.jdField_a_of_type_AndroidAppActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("action_notify_aio_activity_by_b77"));
    }
  }
  
  private void c()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidOsBundle;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getString("app_name");
      Object localObject2 = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
      if ((localObject2 instanceof AbsShareMsg))
      {
        localObject2 = (AbsShareMsg)localObject2;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = ForwardShareByServerHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, ((AbsShareMsg)localObject2).mSourceAppid, ((AbsShareMsg)localObject2).mMsgServiceID, (String)localObject1);
      }
    }
    ForwardShareByServerHelper.a(this.jdField_a_of_type_AndroidOsBundle, a(), this.jdField_a_of_type_Long, true);
  }
  
  private void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(94);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(93);
    f();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null) {
      ((QQCustomDialog)localObject).dismiss();
    }
    this.jdField_a_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_AndroidContentBroadcastReceiver;
    if (localObject != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver((BroadcastReceiver)localObject);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void e()
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showWaitDialog");
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localObject = this.jdField_a_of_type_AndroidAppDialog;
      if (localObject != null)
      {
        if (!((Dialog)localObject).isShowing()) {
          this.jdField_a_of_type_AndroidAppDialog.show();
        }
        return;
      }
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_AndroidAppActivity, 2131756189);
      this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559561);
      ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372646)).setText(2131694878);
      this.jdField_a_of_type_AndroidAppDialog.show();
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showWaitDialog mActivity status invalid");
  }
  
  private void f()
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "hideWaiteDialog");
    if (!a()) {
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new ForwardSDKB77AIOHelper.4(this));
  }
  
  public String getTag()
  {
    return "SDK_SHARE.ForwardSDKB77AIOHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 93)
    {
      if (i != 94) {
        return true;
      }
      paramMessage = this.jdField_a_of_type_AndroidAppActivity;
      if ((paramMessage != null) && (!paramMessage.isFinishing()) && (this.jdField_a_of_type_Boolean))
      {
        ReportController.b(null, "dc00898", "", "", "0X8009CF9", "0X8009CF9", 0, 0, "", "", "", "");
        f();
        ForwardDialogMgr.a(this.jdField_a_of_type_AndroidAppActivity, HardCodeUtil.a(2131704893), this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
        return true;
      }
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "msg_sdk_share_request_timeout_status mActivity == null || mActivity.isFinishing()");
      return true;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      e();
      paramMessage = this.jdField_a_of_type_MqqOsMqqHandler;
      paramMessage.sendMessageDelayed(paramMessage.obtainMessage(94), 10000L);
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
      d();
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onMoveToState DESTROY");
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onMoveToState SHOW_FIRST_BEGIN");
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper
 * JD-Core Version:    0.7.0.1
 */