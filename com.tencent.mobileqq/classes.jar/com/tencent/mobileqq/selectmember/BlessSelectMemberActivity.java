package com.tencent.mobileqq.selectmember;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.bless.api.IBlessApi;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.shortvideo.ResultListener;
import com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class BlessSelectMemberActivity
  extends SelectMemberActivity
  implements Handler.Callback
{
  public static String a = "";
  public static String b = "";
  private static int f = 1;
  private static long g = 60000L;
  private static long h = 60000L;
  private static AtomicBoolean i = new AtomicBoolean(false);
  private static AtomicBoolean j = new AtomicBoolean(false);
  private static long k = 0L;
  private static long l = 0L;
  private static long p = 0L;
  private static MqqWeakReferenceHandler t;
  private static boolean u = false;
  private BaseMessageObserver A = new BlessSelectMemberActivity.1(this);
  private String B = null;
  private Dialog C = null;
  private BroadcastReceiver D = new BlessSelectMemberActivity.10(this);
  private ResultListener E = new BlessSelectMemberActivity.11(this);
  protected Dialog c;
  protected ArrayList<String> d;
  protected boolean e = false;
  private int m = ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_UNKNOW_Value();
  private String n = null;
  private int o = 0;
  private long q = 0L;
  private BlessSelectMemberActivity.BlessPTVUploadTask r;
  private String s;
  private int v;
  private String w;
  private String x;
  private String y;
  private MessageForPic z = null;
  
  public static int a(int paramInt)
  {
    if ((paramInt != 15) && (paramInt != 16))
    {
      if (paramInt == 32) {
        return 2;
      }
      return 0;
    }
    return 1;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    DialogUtil.a(paramContext, 232, null, paramContext.getString(paramInt), 2131887648, 2131891084, new BlessSelectMemberActivity.8(paramContext), new BlessSelectMemberActivity.9()).show();
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    DialogUtil.a(paramContext, 232, null, paramContext.getString(paramInt), new BlessSelectMemberActivity.7(paramBoolean, paramContext), null).show();
  }
  
  private void c(String paramString)
  {
    if (!b())
    {
      d();
      return;
    }
    if (!paramString.equals(""))
    {
      this.e = true;
      ((IBlessApi)QRoute.api(IBlessApi.class)).sendBlessTextMsg(this.app, paramString, this.d, null);
      return;
    }
    QLog.e("BlessSelectMemberActivity", 1, "Blesswords is null!");
    d();
  }
  
  private void m()
  {
    IBlessApi localIBlessApi = (IBlessApi)QRoute.api(IBlessApi.class);
    String str1 = this.x;
    String str2 = this.y;
    String str3 = this.w;
    boolean bool;
    if (this.v == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localIBlessApi.realStartEncode(this, str1, str2, str3, bool, this.E);
  }
  
  private void n()
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((IBlessApi)QRoute.api(IBlessApi.class)).getPtvMessage(this.app);
    MessageForBlessPTV localMessageForBlessPTV = (MessageForBlessPTV)localMessageForShortVideo;
    if (localMessageForBlessPTV != null)
    {
      boolean bool = true;
      this.e = true;
      if (this.mEntrance == 15)
      {
        if (this.d.size() > ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_UPDATE_MSGTAB_NUM_Value()) {
          bool = false;
        }
        localMessageForBlessPTV.needUpdateMsgTag = bool;
      }
      ((IBlessApi)QRoute.api(IBlessApi.class)).sendBlessMsg(this.app, localMessageForShortVideo, localMessageForBlessPTV.uinList, ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessReportParams(this.app, ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PTV_Value(), localMessageForBlessPTV.videoFileTime));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("BlessSelectMemberActivity", 2, "error case no ptv message in manager");
    }
  }
  
  private void o()
  {
    Object localObject;
    if (this.z != null)
    {
      localObject = this.d;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        boolean bool = true;
        this.e = true;
        if (this.mEntrance == 15)
        {
          localObject = this.z;
          if (this.d.size() > ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_UPDATE_MSGTAB_NUM_Value()) {
            bool = false;
          }
          ((MessageForPic)localObject).needUpdateMsgTag = bool;
        }
        ((IBlessApi)QRoute.api(IBlessApi.class)).sendBlessMsg(this.app, this.z, this.d, ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessReportParams(this.app, ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PIC_Value(), 0));
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendBlessPic failed!");
      ((StringBuilder)localObject).append(this.z);
      ((StringBuilder)localObject).append(" ,uinList:");
      ((StringBuilder)localObject).append(this.d);
      QLog.i("BlessSelectMemberActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void p()
  {
    if (this.o == 1) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      registerReceiver(this.D, localIntentFilter);
      this.o = 1;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a()
  {
    Object localObject = (MessageForShortVideo)((IBlessApi)QRoute.api(IBlessApi.class)).getPtvMessage(this.app);
    boolean bool;
    if (localObject != null)
    {
      IHttpCommunicatorListener localIHttpCommunicatorListener = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class, "")).findProcessor(((MessageForShortVideo)localObject).frienduin, ((MessageForShortVideo)localObject).uniseq);
      if ((localIHttpCommunicatorListener != null) && (IShortVideoUploadProcessor.class.isInstance(localIHttpCommunicatorListener)))
      {
        bool = ((BaseTransProcessor)localIHttpCommunicatorListener).isPause();
        int i1 = ((MessageForShortVideo)localObject).videoFileStatus;
        if ((bool) || (i1 == 1002) || (i1 == 1001)) {
          ((IBlessApi)QRoute.api(IBlessApi.class)).stopSendingShortVideo(this.app, ((MessageForShortVideo)localObject).frienduin, ((MessageForShortVideo)localObject).uniseq);
        }
      }
    }
    if (this.z != null)
    {
      localObject = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class, "")).findProcessor(this.z.frienduin, this.z.uniseq);
      if ((localObject != null) && (((IPicTransFile)this.app.getRuntimeService(IPicTransFile.class, "")).getC2CUploadProClass().isInstance(localObject)))
      {
        bool = ((BaseTransProcessor)localObject).isPause();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("stop pic upload, pause:");
          ((StringBuilder)localObject).append(bool);
          QLog.d("BlessSelectMemberActivity", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    localObject = this.r;
    if ((localObject != null) && (((BlessSelectMemberActivity.BlessPTVUploadTask)localObject).getStatus() != AsyncTask.Status.FINISHED))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "cancel the uploadTask!");
      }
      this.r.cancel(true);
    }
  }
  
  public void a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong > 300L) {
      l1 = 300L;
    }
    paramLong = l1;
    if (l1 <= 0L) {
      paramLong = 15L;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSendMsgOverloadDuration: ");
      localStringBuilder.append(paramLong);
      QLog.d("BlessSelectMemberActivity", 2, localStringBuilder.toString());
    }
    k = paramLong;
  }
  
  protected void a(String paramString)
  {
    if (this.c == null)
    {
      this.c = new ReportDialog(this, 2131953338);
      this.c.setContentView(2131624332);
      this.c.setOnKeyListener(new BlessSelectMemberActivity.5(this));
      this.c.findViewById(2131447111).setOnClickListener(new BlessSelectMemberActivity.6(this));
      this.c.show();
      localObject = getWindowManager().getDefaultDisplay();
      WindowManager.LayoutParams localLayoutParams = this.c.getWindow().getAttributes();
      localLayoutParams.width = ((Display)localObject).getWidth();
      localLayoutParams.height = ((Display)localObject).getHeight();
      this.c.getWindow().setAttributes(localLayoutParams);
      if (this.m == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PTV_Value())
      {
        localObject = this.c.getWindow();
        ((Window)localObject).getAttributes().dimAmount = 0.7F;
        ((Window)localObject).addFlags(2);
      }
    }
    Object localObject = (TextView)this.c.findViewById(2131440191);
    if (TextUtils.isEmpty(paramString)) {
      ((TextView)localObject).setText(2131916271);
    } else {
      ((TextView)localObject).setText(paramString);
    }
    if (!this.c.isShowing())
    {
      if (QLog.isColorLevel()) {
        QLog.e("BlessSelectMemberActivity", 2, "showProgressDialog");
      }
      this.c.show();
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    int i1 = (int)((System.currentTimeMillis() - this.q) / 1000L);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onSendMessageResultForWeb result:");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" ,type:");
      ((StringBuilder)localObject1).append(this.m);
      ((StringBuilder)localObject1).append(" ,cost:");
      ((StringBuilder)localObject1).append(i1);
      QLog.i("BlessSelectMemberActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramBoolean)
    {
      Object localObject2 = (IBlessApi)QRoute.api(IBlessApi.class);
      d();
      localObject1 = new Intent();
      ((Intent)localObject1).setAction(((IBlessApi)localObject2).getBlessJsApiPlugin_ACTION_StringValue());
      ((Intent)localObject1).putExtra(((IBlessApi)localObject2).getBlessJsApiPlugin_PARAM_CALLBACK_StringValue(), this.s);
      ((Intent)localObject1).putExtra(((IBlessApi)localObject2).getBlessJsApiPlugin_PARAM_BLESS_TYPE_StringValue(), this.m);
      ((Intent)localObject1).putExtra(((IBlessApi)localObject2).getBlessJsApiPlugin_PARAM_BLESS_NUM_StringValue(), this.d.size());
      if ((this.m == ((IBlessApi)localObject2).getBlessManager_TYPE_TEXT_Value()) && (!TextUtils.isEmpty(this.n)))
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(this.m), String.valueOf(this.d.size()), "", "");
      }
      else if ((this.m == ((IBlessApi)localObject2).getBlessManager_TYPE_PTV_Value()) || (this.m == ((IBlessApi)localObject2).getBlessManager_TYPE_PIC_Value()))
      {
        Object localObject3 = new Intent("tencent.video.q2v.startUploadPTV");
        ((Intent)localObject3).putExtra("broadcastType", 1);
        ((Intent)localObject3).putExtra("recordType", this.m);
        this.app.getApp().sendBroadcast((Intent)localObject3);
        MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((IBlessApi)localObject2).getPtvMessage(this.app);
        if ((this.m == ((IBlessApi)localObject2).getBlessManager_TYPE_PTV_Value()) && (localMessageForShortVideo != null))
        {
          localObject3 = ((IBlessApi)localObject2).getPtvUrlByUuid(this.app, localMessageForShortVideo.uuid, localMessageForShortVideo.md5);
          ((Intent)localObject1).putExtra(((IBlessApi)localObject2).getBlessJsApiPlugin_PARAM_PTV_URL_StringValue(), (String)localObject3);
          ((Intent)localObject1).putExtra(((IBlessApi)localObject2).getBlessJsApiPlugin_PARAM_PTV_UUID_StringValue(), localMessageForShortVideo.uuid);
          ((Intent)localObject1).putExtra(((IBlessApi)localObject2).getBlessJsApiPlugin_PARAM_PTV_MD5_StringValue(), localMessageForShortVideo.md5);
          ((Intent)localObject1).putExtra(((IBlessApi)localObject2).getBlessJsApiPlugin_PARAM_PTV_NICK_StringValue(), Base64Util.encodeToString(this.app.getCurrentNickname().getBytes(), 2));
          ((Intent)localObject1).putExtra(((IBlessApi)localObject2).getBlessJsApiPlugin_PARAM_PTV_FILE_PATH_StringValue(), localMessageForShortVideo.videoFileName);
          ((Intent)localObject1).putExtra(((IBlessApi)localObject2).getBlessJsApiPlugin_PARAM_PTV_THUMB_PATH_StringValue(), localMessageForShortVideo.mThumbFilePath);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("onSendMessageResultForWeb ptvurl:");
            ((StringBuilder)localObject2).append((String)localObject3);
            QLog.i("BlessSelectMemberActivity", 2, ((StringBuilder)localObject2).toString());
          }
        }
      }
      sendBroadcast((Intent)localObject1);
      finish();
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Send blessword failed! blessType:");
    ((StringBuilder)localObject1).append(this.m);
    QLog.e("BlessSelectMemberActivity", 1, ((StringBuilder)localObject1).toString());
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = (int)((System.currentTimeMillis() - this.q) / 1000L);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendMessageResult result:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" ,type:");
      localStringBuilder.append(this.m);
      localStringBuilder.append(" ,cost:");
      localStringBuilder.append(i1);
      QLog.i("BlessSelectMemberActivity", 2, localStringBuilder.toString());
    }
    if (paramBoolean1)
    {
      d();
      if ((this.m == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_TEXT_Value()) && (!this.n.equals("")))
      {
        ((IBlessApi)QRoute.api(IBlessApi.class)).saveSendWording(this.app, this.n);
        ((IBlessApi)QRoute.api(IBlessApi.class)).clearEditingWordings(this.app);
        b(paramBoolean2);
        ReportController.b(this.app, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(this.m), String.valueOf(this.d.size()), "", "");
        return;
      }
      if ((this.m == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PTV_Value()) || (this.m == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PIC_Value())) {
        b(paramBoolean2);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Send blessword failed! blessType:");
      localStringBuilder.append(this.m);
      QLog.e("BlessSelectMemberActivity", 1, localStringBuilder.toString());
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = new PicUploadInfo.Builder();
    ((PicUploadInfo.Builder)localObject).a(paramString);
    ((PicUploadInfo.Builder)localObject).d(1056);
    ((PicUploadInfo.Builder)localObject).c(0);
    ((PicUploadInfo.Builder)localObject).d("0");
    ((PicUploadInfo.Builder)localObject).c(this.app.getCurrentAccountUin());
    ((PicUploadInfo.Builder)localObject).e(0);
    paramString = ((PicUploadInfo.Builder)localObject).k();
    paramString.v = false;
    localObject = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(2, 1056);
    ((PicReq)localObject).a(paramString);
    ((IPicBus)QRoute.api(IPicBus.class)).launch((PicReq)localObject);
  }
  
  public void b(boolean paramBoolean)
  {
    Intent localIntent = new Intent("tencent.video.q2v.startUploadPTV");
    localIntent.putExtra("broadcastType", 1);
    localIntent.putExtra("recordType", this.m);
    this.app.getApp().sendBroadcast(localIntent);
    ((IBlessApi)QRoute.api(IBlessApi.class)).reportSendResult(this.app, this.d, a(this.mEntrance));
    if (this.mEntrance == 32)
    {
      ((IBlessApi)QRoute.api(IBlessApi.class)).gotoSplashActivity(this, paramBoolean);
      finish();
      QQToast.makeText(this, 2, 2131918003, 1).show();
    }
  }
  
  public boolean b()
  {
    if (k > 0L)
    {
      long l1 = System.currentTimeMillis() - l;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("send text overload=");
        localStringBuilder.append(l1 / 1000L);
        localStringBuilder.append(" duration=");
        localStringBuilder.append(k);
        QLog.d("BlessSelectMemberActivity", 2, localStringBuilder.toString());
      }
      if (l1 > k * 1000L)
      {
        a(0L);
        l = 0L;
        return true;
      }
      a(this, 2131887589, true);
      return false;
    }
    return true;
  }
  
  protected void c()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8006190", "0X8006190", 0, 0, String.valueOf(this.m), "", "", "");
    if ((this.B == null) || (this.C == null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.mEntrance == 15) {
        localStringBuilder.append(getString(2131887585));
      } else if (this.mEntrance == 32) {
        localStringBuilder.append(getString(2131918002));
      }
      int i1 = 0;
      while ((i1 < this.d.size()) && (i1 < 50))
      {
        localObject = CommonUtils.b(this.app, (String)this.d.get(i1));
        if (localObject != null)
        {
          localStringBuilder.append(((Friends)localObject).getFriendNick());
          localStringBuilder.append("、 ");
        }
        i1 += 1;
      }
      localStringBuilder.setLength(localStringBuilder.length() - 2);
      if (this.d.size() != 1) {
        localStringBuilder.append(String.format(getString(2131887586), new Object[] { "", Integer.valueOf(this.d.size()) }));
      }
      this.B = localStringBuilder.toString();
      this.C = DialogUtil.a(this, -1, null, this.B, 2131887648, 2131887584, new BlessSelectMemberActivity.2(this), new BlessSelectMemberActivity.3(this));
      if (this.m == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PTV_Value())
      {
        localObject = this.C.getWindow();
        ((Window)localObject).getAttributes().dimAmount = 0.7F;
        ((Window)localObject).addFlags(2);
      }
      Object localObject = (TextView)this.C.findViewById(2131431876);
      ((TextView)localObject).setMaxLines(4);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject).setGravity(3);
      ((TextView)localObject).post(new BlessSelectMemberActivity.4(this, (TextView)localObject, localStringBuilder));
    }
    if (!isFinishing()) {
      this.C.show();
    }
  }
  
  protected void d()
  {
    try
    {
      if (this.c != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BlessSelectMemberActivity", 2, "cancelProgressDialog");
        }
        this.c.dismiss();
      }
      if (t != null)
      {
        t.removeMessages(2);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BlessSelectMemberActivity", 2, "cancelProgressDialog excep!", localException);
      }
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.m = this.mIntent.getExtras().getInt("param_blesstype");
    this.n = this.mIntent.getExtras().getString("param_blessword_content");
    this.v = this.mIntent.getIntExtra("encode_type", 0);
    this.w = this.mIntent.getStringExtra("fake_id");
    this.x = this.mIntent.getStringExtra("thumbfile_send_path");
    this.y = this.mIntent.getStringExtra("thumbfile_md5");
    this.s = this.mIntent.getStringExtra("param_web_callback");
    addObserver(this.A);
    p();
    this.d = new ArrayList();
    i.set(false);
    f = 1;
    a = "";
    u = false;
    this.mIsNeedSendIsResumeBroadcast = false;
    t = new MqqWeakReferenceHandler(this);
    paramBundle = new Intent("tencent.video.q2v.startUploadPTV");
    paramBundle.putExtra("broadcastType", 2);
    this.app.getApp().sendBroadcast(paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.A);
    Object localObject = t;
    if (localObject != null) {
      ((MqqWeakReferenceHandler)localObject).removeMessages(2);
    }
    localObject = this.r;
    if ((localObject != null) && (((BlessSelectMemberActivity.BlessPTVUploadTask)localObject).getStatus() != AsyncTask.Status.FINISHED))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "destroy the uploadTask!");
      }
      this.r.cancel(true);
    }
    try
    {
      if (this.o == 1)
      {
        unregisterReceiver(this.D);
        this.o = 0;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" already unregisterReceiver");
        localStringBuilder.append(localIllegalArgumentException);
        QLog.d("BlessSelectMemberActivity", 2, localStringBuilder.toString());
      }
    }
    this.z = null;
    p = 0L;
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    removeAllFriendResult();
    ((SelectMemberInnerFrame)this.mInnerFrameManager.getCurrentView()).f();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.mSystemBarComp != null)
    {
      int i1 = getResources().getColor(2131165599);
      this.mSystemBarComp.setStatusColor(i1);
      this.mSystemBarComp.setStatusBarColor(i1);
    }
  }
  
  protected void e()
  {
    a(null);
    u = false;
    ((IBlessApi)QRoute.api(IBlessApi.class)).saveUinListToSend(this.app, this.d);
    this.q = System.currentTimeMillis();
    t.sendEmptyMessageDelayed(2, h);
    if (this.m == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_TEXT_Value())
    {
      c(this.n);
      return;
    }
    if (this.m == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PTV_Value())
    {
      if (!b())
      {
        d();
        return;
      }
      new BlessSelectMemberActivity.BlessPTVProcessTask(this.app, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      BlessSelectMemberActivity.BlessPTVUploadTask localBlessPTVUploadTask = this.r;
      if ((localBlessPTVUploadTask != null) && (localBlessPTVUploadTask.getStatus() != AsyncTask.Status.FINISHED))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessSelectMemberActivity", 2, "There is still a running uploadTask!");
        }
        this.r.cancel(true);
      }
      this.r = new BlessSelectMemberActivity.BlessPTVUploadTask(this.app, this, this.d, this.mEntrance);
      this.r.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return;
    }
    if (this.m == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PIC_Value())
    {
      if (TextUtils.isEmpty(this.x))
      {
        QQToast.makeText(this, 1, 2131896955, 1).show();
        d();
        finish();
        return;
      }
      b(this.x);
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((this.mEntrance == 15) || (this.mEntrance == 32)) {
      ((IBlessApi)QRoute.api(IBlessApi.class)).clearUinListToSend(this.app);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 == 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BlessSelectMemberActivity", 2, "handleMessage realStartEncode!");
          }
          m();
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("BlessSelectMemberActivity", 2, "handleMessage: send bless msg timeout!");
        }
        a();
        u = true;
        d();
        a(this, 2131916649);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("BlessSelectMemberActivity", 2, "handleMessage: send video cannel!");
      }
      a();
      u = true;
      d();
    }
    return false;
  }
  
  protected void initTitleBar()
  {
    super.initTitleBar();
    this.mTitleBar.setBackgroundColor(getResources().getColor(2131165599));
    this.mTitle.setTextColor(-1);
    this.mLeftBackBtn.setTextColor(getResources().getColorStateList(2131165594));
    this.mRightBtn.setTextColor(getResources().getColorStateList(2131165594));
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (((IBlessApi)QRoute.api(IBlessApi.class)).isUinListToSendChangedOnMem(this.app))
    {
      ((IBlessApi)QRoute.api(IBlessApi.class)).setUinListToSendChangedOnMen(this.app, false);
      Object localObject = ((IBlessApi)QRoute.api(IBlessApi.class)).getUinListToSend(this.app);
      if ((localObject != null) && (((ArrayList)localObject).size() >= 0))
      {
        ArrayList localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          Friends localFriends = CommonUtils.b(this.app, str);
          if (localFriends != null) {
            localArrayList.add(constructAResultRecord(str, localFriends.getFriendNick(), 0, "-1"));
          }
        }
        addFriendResults(localArrayList, true);
        ((SelectMemberInnerFrame)this.mInnerFrameManager.getCurrentView()).f();
      }
    }
  }
  
  protected void startCreateOrAdd()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().peekDecorView().getWindowToken(), 0);
    if ((this.mEntrance != 15) && (this.mEntrance != 32))
    {
      this.mIntent.putParcelableArrayListExtra("result_set", this.mResultList);
      setResult(-1, this.mIntent);
      finish();
      return;
    }
    this.d.clear();
    if (this.mResultList.size() > 0)
    {
      Iterator localIterator = this.mResultList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        this.d.add(localResultRecord.uin);
      }
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.BlessSelectMemberActivity
 * JD-Core Version:    0.7.0.1
 */