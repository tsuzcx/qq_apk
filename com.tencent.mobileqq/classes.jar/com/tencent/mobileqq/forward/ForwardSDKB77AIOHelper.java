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
    String str = this.jdField_a_of_type_AndroidContentIntent.getStringExtra("key_b77_sdk_share");
    if (TextUtils.isEmpty(str))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showB77ResultDialog cachedKey empty");
      return;
    }
    this.jdField_a_of_type_AndroidContentIntent.removeExtra("key_b77_sdk_share");
    Map localMap = ((ForwardSdkStatusManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SDK_SHARE)).a(str);
    if (localMap == null)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "initBroadcastReceiver");
      b(str);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(93), 500L);
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showB77ResultDialog_parseB77Result");
    a(localMap);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    ForwardStatisticsReporter.a("KEY_STAGE_2_TOTAL", false);
    ForwardShareByServerHelper.a(this.jdField_a_of_type_AndroidOsBundle, a(), this.jdField_a_of_type_Long, false);
    if ((this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_mini_program_ark_from_sdk", false))) {
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
    do
    {
      return;
      paramActivity = (ForwardSDKB77AIOHelper)paramHelperProvider.a(57);
    } while (paramActivity == null);
    paramActivity.a();
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
      QLog.e("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "jumpToErrorWeb: Failed. info: exception = ", paramString);
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
  
  public static boolean a(MessageForArkApp paramMessageForArkApp)
  {
    paramMessageForArkApp = paramMessageForArkApp.getExtInfoFromExtStr(MessageConstants.w);
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "resend forbid msg openSdkShareState=", paramMessageForArkApp });
    return 25201 == ForwardUtils.a(paramMessageForArkApp);
  }
  
  public static boolean a(MessageForArkApp paramMessageForArkApp, Context paramContext)
  {
    String str = paramMessageForArkApp.getExtInfoFromExtStr(MessageConstants.w);
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "resend forbid msg openSdkShareState=", str, ", uinseq=", Long.valueOf(paramMessageForArkApp.uniseq) });
    int i = ForwardUtils.a(str);
    if ((i == 0) || (i == 25201) || (i == -2)) {
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
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
      this.jdField_a_of_type_AndroidContentIntent = this.jdField_a_of_type_AndroidAppActivity.getIntent();
      this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_AndroidContentIntent.getExtras();
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("req_share_id");
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
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      String str = this.jdField_a_of_type_AndroidOsBundle.getString("app_name");
      Object localObject = StructMsgFactory.a(this.jdField_a_of_type_AndroidOsBundle);
      if ((localObject instanceof AbsShareMsg))
      {
        localObject = (AbsShareMsg)localObject;
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = ForwardShareByServerHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, ((AbsShareMsg)localObject).mSourceAppid, ((AbsShareMsg)localObject).mMsgServiceID, str);
      }
    }
    ForwardShareByServerHelper.a(this.jdField_a_of_type_AndroidOsBundle, a(), this.jdField_a_of_type_Long, true);
  }
  
  private void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(94);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(93);
    f();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.jdField_a_of_type_AndroidAppActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  private void e()
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showWaitDialog");
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showWaitDialog mActivity status invalid");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidAppDialog == null) {
        break;
      }
    } while (this.jdField_a_of_type_AndroidAppDialog.isShowing());
    this.jdField_a_of_type_AndroidAppDialog.show();
    return;
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_AndroidAppActivity, 2131755842);
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559683);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131373066)).setText(2131694889);
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private void f()
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "hideWaiteDialog");
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.jdField_a_of_type_MqqOsMqqHandler.post(new ForwardSDKB77AIOHelper.4(this));
    }
  }
  
  public String getTag()
  {
    return "SDK_SHARE.ForwardSDKB77AIOHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 93: 
      do
      {
        return true;
      } while (!this.jdField_a_of_type_Boolean);
      e();
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(94), 10000L);
      return true;
    }
    if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (!this.jdField_a_of_type_Boolean))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "msg_sdk_share_request_timeout_status mActivity == null || mActivity.isFinishing()");
      return true;
    }
    ReportController.b(null, "dc00898", "", "", "0X8009CF9", "0X8009CF9", 0, 0, "", "", "", "");
    f();
    ForwardDialogMgr.a(this.jdField_a_of_type_AndroidAppActivity, HardCodeUtil.a(2131704817), this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
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
    default: 
      return;
    case 7: 
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onMoveToState SHOW_FIRST_BEGIN");
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    d();
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onMoveToState DESTROY");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper
 * JD-Core Version:    0.7.0.1
 */