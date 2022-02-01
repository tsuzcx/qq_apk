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
  private Dialog a;
  private QQCustomDialog b;
  private long c;
  private MqqHandler d = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private volatile boolean e = false;
  private BroadcastReceiver f;
  private Bundle g;
  private Intent h;
  private Activity i;
  private BaseChatPie j;
  private String k;
  private final DialogInterface.OnClickListener l = new ForwardSDKB77AIOHelper.3(this);
  
  public ForwardSDKB77AIOHelper(BaseChatPie paramBaseChatPie)
  {
    this.j = paramBaseChatPie;
  }
  
  private void a()
  {
    b();
    this.k = this.h.getStringExtra("key_b77_sdk_share");
    if (TextUtils.isEmpty(this.k))
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showB77ResultDialog cachedKey empty");
      return;
    }
    this.h.removeExtra("key_b77_sdk_share");
    Object localObject = ((ForwardSdkStatusManager)this.j.d.getManager(QQManagerFactory.SDK_SHARE)).a(this.k);
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "showB77ResultDialog cachedKey:", this.k });
    if (localObject == null)
    {
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "initBroadcastReceiver");
      e();
      localObject = this.d;
      ((MqqHandler)localObject).sendMessageDelayed(((MqqHandler)localObject).obtainMessage(93), 500L);
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showB77ResultDialog_parseB77Result");
    a((Map)localObject);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    ForwardStatisticsReporter.a("KEY_STAGE_2_TOTAL", false);
    ForwardShareByServerHelper.a(this.g, c(), this.c, false);
    Bundle localBundle = this.g;
    if ((localBundle != null) && (localBundle.getBoolean("forward_mini_program_ark_from_sdk", false))) {
      ReportController.b((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "dc00898", "", "", "0X8009F7C", "0X8009F7C", 0, 0, "2", String.valueOf(paramInt), "", "");
    }
    ForwardDialogMgr.a(this.i, paramString1, new ForwardSDKB77AIOHelper.1(this, paramInt, paramString2));
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
      a(paramString, this.i);
    }
    ForwardStatisticsReporter.a("KEY_STAGE_2_TOTAL", false);
    ForwardShareByServerHelper.a(this.g, c(), this.c, false);
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
    d();
  }
  
  public static boolean a(MessageForArkApp paramMessageForArkApp)
  {
    paramMessageForArkApp = paramMessageForArkApp.getExtInfoFromExtStr(MessageConstants.w);
    boolean bool = false;
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "resend forbid msg openSdkShareState=", paramMessageForArkApp });
    if (25201 == ForwardUtils.b(paramMessageForArkApp)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(MessageForArkApp paramMessageForArkApp, Context paramContext)
  {
    String str = paramMessageForArkApp.getExtInfoFromExtStr(MessageConstants.w);
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { "resend forbid msg openSdkShareState=", str, ", uinseq=", Long.valueOf(paramMessageForArkApp.uniseq) });
    int m = ForwardUtils.b(str);
    if ((m != 0) && (m != 25201))
    {
      if (m == -2) {
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
    Object localObject = this.j;
    if (localObject != null)
    {
      this.i = ((BaseChatPie)localObject).f;
      this.h = this.i.getIntent();
      this.g = this.h.getExtras();
      localObject = this.g;
      if (localObject != null) {
        this.c = ((Bundle)localObject).getLong("req_share_id");
      }
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, new Object[] { " updateCurrentInfo mExtra=", this.g, ", mShareAppId=", Long.valueOf(this.c) });
  }
  
  private int c()
  {
    return this.h.getIntExtra("req_type", 2147483647);
  }
  
  private void d()
  {
    Object localObject1 = this.g;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getString("app_name");
      Object localObject2 = StructMsgFactory.a(this.g);
      if ((localObject2 instanceof AbsShareMsg))
      {
        localObject2 = (AbsShareMsg)localObject2;
        this.b = ForwardShareByServerHelper.a(this.i, this.b, this.j, ((AbsShareMsg)localObject2).mSourceAppid, ((AbsShareMsg)localObject2).mMsgServiceID, (String)localObject1);
      }
    }
    ForwardShareByServerHelper.a(this.g, c(), this.c, true);
  }
  
  private void e()
  {
    if (this.f == null)
    {
      this.f = new ForwardSDKB77AIOHelper.2(this);
      this.i.registerReceiver(this.f, new IntentFilter("action_notify_aio_activity_by_b77"));
    }
  }
  
  private void f()
  {
    this.d.removeMessages(94);
    this.d.removeMessages(93);
    h();
    Object localObject = this.b;
    if (localObject != null) {
      ((QQCustomDialog)localObject).dismiss();
    }
    this.e = false;
    localObject = this.f;
    if (localObject != null)
    {
      this.i.unregisterReceiver((BroadcastReceiver)localObject);
      this.f = null;
    }
  }
  
  private void g()
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showWaitDialog");
    Object localObject = this.i;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localObject = this.a;
      if (localObject != null)
      {
        if (!((Dialog)localObject).isShowing()) {
          this.a.show();
        }
        return;
      }
      this.a = new ReportDialog(this.i, 2131953338);
      this.a.setCancelable(false);
      this.a.setContentView(2131625585);
      ((TextView)this.a.findViewById(2131440191)).setText(2131892581);
      this.a.show();
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "showWaitDialog mActivity status invalid");
  }
  
  private void h()
  {
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "hideWaiteDialog");
    if (!i()) {
      return;
    }
    this.i.runOnUiThread(new ForwardSDKB77AIOHelper.4(this));
  }
  
  private boolean i()
  {
    Object localObject = this.i;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localObject = this.a;
      if ((localObject != null) && (((Dialog)localObject).isShowing())) {
        return true;
      }
    }
    return false;
  }
  
  public String getTag()
  {
    return "SDK_SHARE.ForwardSDKB77AIOHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int m = paramMessage.what;
    if (m != 93)
    {
      if (m != 94) {
        return true;
      }
      paramMessage = this.i;
      if ((paramMessage != null) && (!paramMessage.isFinishing()) && (this.e))
      {
        ReportController.b(null, "dc00898", "", "", "0X8009CF9", "0X8009CF9", 0, 0, "", "", "", "");
        h();
        ForwardDialogMgr.a(this.i, HardCodeUtil.a(2131902785), this.l);
        return true;
      }
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "msg_sdk_share_request_timeout_status mActivity == null || mActivity.isFinishing()");
      return true;
    }
    if (this.e)
    {
      g();
      paramMessage = this.d;
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
      f();
      QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onMoveToState DESTROY");
      return;
    }
    QLog.d("SDK_SHARE.ForwardSDKB77AIOHelper", 1, "onMoveToState SHOW_FIRST_BEGIN");
    this.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper
 * JD-Core Version:    0.7.0.1
 */