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
  private static int jdField_a_of_type_Int = 1;
  private static long jdField_a_of_type_Long = 60000L;
  private static MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
  public static String a = "";
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static long jdField_b_of_type_Long = 60000L;
  public static String b = "";
  private static AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private static boolean jdField_b_of_type_Boolean = false;
  private static long jdField_c_of_type_Long = 0L;
  private static long jdField_d_of_type_Long = 0L;
  private static long jdField_e_of_type_Long = 0L;
  protected Dialog a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new BlessSelectMemberActivity.10(this);
  private BaseMessageObserver jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver = new BlessSelectMemberActivity.1(this);
  private MessageForPic jdField_a_of_type_ComTencentMobileqqDataMessageForPic = null;
  private BlessSelectMemberActivity.BlessPTVUploadTask jdField_a_of_type_ComTencentMobileqqSelectmemberBlessSelectMemberActivity$BlessPTVUploadTask;
  private ResultListener jdField_a_of_type_ComTencentMobileqqShortvideoResultListener = new BlessSelectMemberActivity.11(this);
  protected ArrayList<String> a;
  protected boolean a;
  private int jdField_b_of_type_Int = ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_UNKNOW_Value();
  private Dialog jdField_b_of_type_AndroidAppDialog = null;
  private int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString = null;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private String jdField_e_of_type_JavaLangString;
  private long jdField_f_of_type_Long = 0L;
  private String jdField_f_of_type_JavaLangString;
  private String g;
  private String h = null;
  
  public BlessSelectMemberActivity()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
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
    DialogUtil.a(paramContext, 232, null, paramContext.getString(paramInt), 2131690728, 2131693528, new BlessSelectMemberActivity.8(paramContext), new BlessSelectMemberActivity.9()).show();
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    DialogUtil.a(paramContext, 232, null, paramContext.getString(paramInt), new BlessSelectMemberActivity.7(paramBoolean, paramContext), null).show();
  }
  
  private void c(String paramString)
  {
    if (!a())
    {
      c();
      return;
    }
    if (!paramString.equals(""))
    {
      this.jdField_a_of_type_Boolean = true;
      ((IBlessApi)QRoute.api(IBlessApi.class)).sendBlessTextMsg(this.app, paramString, this.jdField_a_of_type_JavaUtilArrayList, null);
      return;
    }
    QLog.e("BlessSelectMemberActivity", 1, "Blesswords is null!");
    c();
  }
  
  private void e()
  {
    IBlessApi localIBlessApi = (IBlessApi)QRoute.api(IBlessApi.class);
    String str1 = this.jdField_f_of_type_JavaLangString;
    String str2 = this.g;
    String str3 = this.jdField_e_of_type_JavaLangString;
    boolean bool;
    if (this.jdField_d_of_type_Int == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localIBlessApi.realStartEncode(this, str1, str2, str3, bool, this.jdField_a_of_type_ComTencentMobileqqShortvideoResultListener);
  }
  
  private void f()
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((IBlessApi)QRoute.api(IBlessApi.class)).getPtvMessage(this.app);
    MessageForBlessPTV localMessageForBlessPTV = (MessageForBlessPTV)localMessageForShortVideo;
    if (localMessageForBlessPTV != null)
    {
      boolean bool = true;
      this.jdField_a_of_type_Boolean = true;
      if (this.mEntrance == 15)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() > ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_UPDATE_MSGTAB_NUM_Value()) {
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
  
  private void g()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        boolean bool = true;
        this.jdField_a_of_type_Boolean = true;
        if (this.mEntrance == 15)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_UPDATE_MSGTAB_NUM_Value()) {
            bool = false;
          }
          ((MessageForPic)localObject).needUpdateMsgTag = bool;
        }
        ((IBlessApi)QRoute.api(IBlessApi.class)).sendBlessMsg(this.app, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic, this.jdField_a_of_type_JavaUtilArrayList, ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessReportParams(this.app, ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PIC_Value(), 0));
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendBlessPic failed!");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic);
      ((StringBuilder)localObject).append(" ,uinList:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilArrayList);
      QLog.i("BlessSelectMemberActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void h()
  {
    if (this.jdField_c_of_type_Int == 1) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.jdField_c_of_type_Int = 1;
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
        int i = ((MessageForShortVideo)localObject).videoFileStatus;
        if ((bool) || (i == 1002) || (i == 1001)) {
          ((IBlessApi)QRoute.api(IBlessApi.class)).stopSendingShortVideo(this.app, ((MessageForShortVideo)localObject).frienduin, ((MessageForShortVideo)localObject).uniseq);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)
    {
      localObject = ((ITransFileController)this.app.getRuntimeService(ITransFileController.class, "")).findProcessor(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.uniseq);
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqSelectmemberBlessSelectMemberActivity$BlessPTVUploadTask;
    if ((localObject != null) && (((BlessSelectMemberActivity.BlessPTVUploadTask)localObject).getStatus() != AsyncTask.Status.FINISHED))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "cancel the uploadTask!");
      }
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberBlessSelectMemberActivity$BlessPTVUploadTask.cancel(true);
    }
  }
  
  public void a(long paramLong)
  {
    long l = paramLong;
    if (paramLong > 300L) {
      l = 300L;
    }
    paramLong = l;
    if (l <= 0L) {
      paramLong = 15L;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSendMsgOverloadDuration: ");
      localStringBuilder.append(paramLong);
      QLog.d("BlessSelectMemberActivity", 2, localStringBuilder.toString());
    }
    jdField_c_of_type_Long = paramLong;
  }
  
  protected void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this, 2131756189);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558715);
      this.jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new BlessSelectMemberActivity.5(this));
      this.jdField_a_of_type_AndroidAppDialog.findViewById(2131378496).setOnClickListener(new BlessSelectMemberActivity.6(this));
      this.jdField_a_of_type_AndroidAppDialog.show();
      localObject = getWindowManager().getDefaultDisplay();
      WindowManager.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidAppDialog.getWindow().getAttributes();
      localLayoutParams.width = ((Display)localObject).getWidth();
      localLayoutParams.height = ((Display)localObject).getHeight();
      this.jdField_a_of_type_AndroidAppDialog.getWindow().setAttributes(localLayoutParams);
      if (this.jdField_b_of_type_Int == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PTV_Value())
      {
        localObject = this.jdField_a_of_type_AndroidAppDialog.getWindow();
        ((Window)localObject).getAttributes().dimAmount = 0.7F;
        ((Window)localObject).addFlags(2);
      }
    }
    Object localObject = (TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372646);
    if (TextUtils.isEmpty(paramString)) {
      ((TextView)localObject).setText(2131718765);
    } else {
      ((TextView)localObject).setText(paramString);
    }
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
    {
      if (QLog.isColorLevel()) {
        QLog.e("BlessSelectMemberActivity", 2, "showProgressDialog");
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    int i = (int)((System.currentTimeMillis() - this.jdField_f_of_type_Long) / 1000L);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onSendMessageResultForWeb result:");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" ,type:");
      ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject1).append(" ,cost:");
      ((StringBuilder)localObject1).append(i);
      QLog.i("BlessSelectMemberActivity", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramBoolean)
    {
      Object localObject2 = (IBlessApi)QRoute.api(IBlessApi.class);
      c();
      localObject1 = new Intent();
      ((Intent)localObject1).setAction(((IBlessApi)localObject2).getBlessJsApiPlugin_ACTION_StringValue());
      ((Intent)localObject1).putExtra(((IBlessApi)localObject2).getBlessJsApiPlugin_PARAM_CALLBACK_StringValue(), this.jdField_d_of_type_JavaLangString);
      ((Intent)localObject1).putExtra(((IBlessApi)localObject2).getBlessJsApiPlugin_PARAM_BLESS_TYPE_StringValue(), this.jdField_b_of_type_Int);
      ((Intent)localObject1).putExtra(((IBlessApi)localObject2).getBlessJsApiPlugin_PARAM_BLESS_NUM_StringValue(), this.jdField_a_of_type_JavaUtilArrayList.size());
      if ((this.jdField_b_of_type_Int == ((IBlessApi)localObject2).getBlessManager_TYPE_TEXT_Value()) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)))
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(this.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), "", "");
      }
      else if ((this.jdField_b_of_type_Int == ((IBlessApi)localObject2).getBlessManager_TYPE_PTV_Value()) || (this.jdField_b_of_type_Int == ((IBlessApi)localObject2).getBlessManager_TYPE_PIC_Value()))
      {
        Object localObject3 = new Intent("tencent.video.q2v.startUploadPTV");
        ((Intent)localObject3).putExtra("broadcastType", 1);
        ((Intent)localObject3).putExtra("recordType", this.jdField_b_of_type_Int);
        this.app.getApp().sendBroadcast((Intent)localObject3);
        MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((IBlessApi)localObject2).getPtvMessage(this.app);
        if ((this.jdField_b_of_type_Int == ((IBlessApi)localObject2).getBlessManager_TYPE_PTV_Value()) && (localMessageForShortVideo != null))
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
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_Int);
    QLog.e("BlessSelectMemberActivity", 1, ((StringBuilder)localObject1).toString());
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = (int)((System.currentTimeMillis() - this.jdField_f_of_type_Long) / 1000L);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendMessageResult result:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" ,type:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append(" ,cost:");
      localStringBuilder.append(i);
      QLog.i("BlessSelectMemberActivity", 2, localStringBuilder.toString());
    }
    if (paramBoolean1)
    {
      c();
      if ((this.jdField_b_of_type_Int == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_TEXT_Value()) && (!this.jdField_c_of_type_JavaLangString.equals("")))
      {
        ((IBlessApi)QRoute.api(IBlessApi.class)).saveSendWording(this.app, this.jdField_c_of_type_JavaLangString);
        ((IBlessApi)QRoute.api(IBlessApi.class)).clearEditingWordings(this.app);
        b(paramBoolean2);
        ReportController.b(this.app, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(this.jdField_b_of_type_Int), String.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()), "", "");
        return;
      }
      if ((this.jdField_b_of_type_Int == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PTV_Value()) || (this.jdField_b_of_type_Int == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PIC_Value())) {
        b(paramBoolean2);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Send blessword failed! blessType:");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      QLog.e("BlessSelectMemberActivity", 1, localStringBuilder.toString());
    }
  }
  
  public boolean a()
  {
    if (jdField_c_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - jdField_d_of_type_Long;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("send text overload=");
        localStringBuilder.append(l / 1000L);
        localStringBuilder.append(" duration=");
        localStringBuilder.append(jdField_c_of_type_Long);
        QLog.d("BlessSelectMemberActivity", 2, localStringBuilder.toString());
      }
      if (l > jdField_c_of_type_Long * 1000L)
      {
        a(0L);
        jdField_d_of_type_Long = 0L;
        return true;
      }
      a(this, 2131690674, true);
      return false;
    }
    return true;
  }
  
  protected void b()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X8006190", "0X8006190", 0, 0, String.valueOf(this.jdField_b_of_type_Int), "", "", "");
    if ((this.h == null) || (this.jdField_b_of_type_AndroidAppDialog == null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.mEntrance == 15) {
        localStringBuilder.append(getString(2131690670));
      } else if (this.mEntrance == 32) {
        localStringBuilder.append(getString(2131720364));
      }
      int i = 0;
      while ((i < this.jdField_a_of_type_JavaUtilArrayList.size()) && (i < 50))
      {
        localObject = CommonUtils.a(this.app, (String)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        if (localObject != null)
        {
          localStringBuilder.append(((Friends)localObject).getFriendNick());
          localStringBuilder.append("、 ");
        }
        i += 1;
      }
      localStringBuilder.setLength(localStringBuilder.length() - 2);
      if (this.jdField_a_of_type_JavaUtilArrayList.size() != 1) {
        localStringBuilder.append(String.format(getString(2131690671), new Object[] { "", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) }));
      }
      this.h = localStringBuilder.toString();
      this.jdField_b_of_type_AndroidAppDialog = DialogUtil.a(this, -1, null, this.h, 2131690728, 2131690669, new BlessSelectMemberActivity.2(this), new BlessSelectMemberActivity.3(this));
      if (this.jdField_b_of_type_Int == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PTV_Value())
      {
        localObject = this.jdField_b_of_type_AndroidAppDialog.getWindow();
        ((Window)localObject).getAttributes().dimAmount = 0.7F;
        ((Window)localObject).addFlags(2);
      }
      Object localObject = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365644);
      ((TextView)localObject).setMaxLines(4);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.MIDDLE);
      ((TextView)localObject).setGravity(3);
      ((TextView)localObject).post(new BlessSelectMemberActivity.4(this, (TextView)localObject, localStringBuilder));
    }
    if (!isFinishing()) {
      this.jdField_b_of_type_AndroidAppDialog.show();
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
    paramString = ((PicUploadInfo.Builder)localObject).a();
    paramString.jdField_b_of_type_Boolean = false;
    localObject = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(2, 1056);
    ((PicReq)localObject).a(paramString);
    ((IPicBus)QRoute.api(IPicBus.class)).launch((PicReq)localObject);
  }
  
  public void b(boolean paramBoolean)
  {
    Intent localIntent = new Intent("tencent.video.q2v.startUploadPTV");
    localIntent.putExtra("broadcastType", 1);
    localIntent.putExtra("recordType", this.jdField_b_of_type_Int);
    this.app.getApp().sendBroadcast(localIntent);
    ((IBlessApi)QRoute.api(IBlessApi.class)).reportSendResult(this.app, this.jdField_a_of_type_JavaUtilArrayList, a(this.mEntrance));
    if (this.mEntrance == 32)
    {
      ((IBlessApi)QRoute.api(IBlessApi.class)).gotoSplashActivity(this, paramBoolean);
      finish();
      QQToast.a(this, 2, 2131720365, 1).a();
    }
  }
  
  protected void c()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidAppDialog != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("BlessSelectMemberActivity", 2, "cancelProgressDialog");
        }
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      if (jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler != null)
      {
        jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(2);
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
  
  protected void d()
  {
    a(null);
    jdField_b_of_type_Boolean = false;
    ((IBlessApi)QRoute.api(IBlessApi.class)).saveUinListToSend(this.app, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(2, jdField_b_of_type_Long);
    if (this.jdField_b_of_type_Int == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_TEXT_Value())
    {
      c(this.jdField_c_of_type_JavaLangString);
      return;
    }
    if (this.jdField_b_of_type_Int == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PTV_Value())
    {
      if (!a())
      {
        c();
        return;
      }
      new BlessSelectMemberActivity.BlessPTVProcessTask(this.app, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      BlessSelectMemberActivity.BlessPTVUploadTask localBlessPTVUploadTask = this.jdField_a_of_type_ComTencentMobileqqSelectmemberBlessSelectMemberActivity$BlessPTVUploadTask;
      if ((localBlessPTVUploadTask != null) && (localBlessPTVUploadTask.getStatus() != AsyncTask.Status.FINISHED))
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessSelectMemberActivity", 2, "There is still a running uploadTask!");
        }
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberBlessSelectMemberActivity$BlessPTVUploadTask.cancel(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberBlessSelectMemberActivity$BlessPTVUploadTask = new BlessSelectMemberActivity.BlessPTVUploadTask(this.app, this, this.jdField_a_of_type_JavaUtilArrayList, this.mEntrance);
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberBlessSelectMemberActivity$BlessPTVUploadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return;
    }
    if (this.jdField_b_of_type_Int == ((IBlessApi)QRoute.api(IBlessApi.class)).getBlessManager_TYPE_PIC_Value())
    {
      if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
      {
        QQToast.a(this, 1, 2131698963, 1).a();
        c();
        finish();
        return;
      }
      b(this.jdField_f_of_type_JavaLangString);
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
    this.jdField_b_of_type_Int = this.mIntent.getExtras().getInt("param_blesstype");
    this.jdField_c_of_type_JavaLangString = this.mIntent.getExtras().getString("param_blessword_content");
    this.jdField_d_of_type_Int = this.mIntent.getIntExtra("encode_type", 0);
    this.jdField_e_of_type_JavaLangString = this.mIntent.getStringExtra("fake_id");
    this.jdField_f_of_type_JavaLangString = this.mIntent.getStringExtra("thumbfile_send_path");
    this.g = this.mIntent.getStringExtra("thumbfile_md5");
    this.jdField_d_of_type_JavaLangString = this.mIntent.getStringExtra("param_web_callback");
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver);
    h();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_Boolean = false;
    this.mIsNeedSendIsResumeBroadcast = false;
    jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    paramBundle = new Intent("tencent.video.q2v.startUploadPTV");
    paramBundle.putExtra("broadcastType", 2);
    this.app.getApp().sendBroadcast(paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver);
    Object localObject = jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler;
    if (localObject != null) {
      ((MqqWeakReferenceHandler)localObject).removeMessages(2);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqSelectmemberBlessSelectMemberActivity$BlessPTVUploadTask;
    if ((localObject != null) && (((BlessSelectMemberActivity.BlessPTVUploadTask)localObject).getStatus() != AsyncTask.Status.FINISHED))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessSelectMemberActivity", 2, "destroy the uploadTask!");
      }
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberBlessSelectMemberActivity$BlessPTVUploadTask.cancel(true);
    }
    try
    {
      if (this.jdField_c_of_type_Int == 1)
      {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_c_of_type_Int = 0;
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
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = null;
    jdField_e_of_type_Long = 0L;
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
      int i = getResources().getColor(2131165357);
      this.mSystemBarComp.setStatusColor(i);
      this.mSystemBarComp.setStatusBarColor(i);
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
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3)
        {
          if (QLog.isColorLevel()) {
            QLog.i("BlessSelectMemberActivity", 2, "handleMessage realStartEncode!");
          }
          e();
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("BlessSelectMemberActivity", 2, "handleMessage: send bless msg timeout!");
        }
        a();
        jdField_b_of_type_Boolean = true;
        c();
        a(this, 2131719113);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("BlessSelectMemberActivity", 2, "handleMessage: send video cannel!");
      }
      a();
      jdField_b_of_type_Boolean = true;
      c();
    }
    return false;
  }
  
  protected void initTitleBar()
  {
    super.initTitleBar();
    this.mTitleBar.setBackgroundColor(getResources().getColor(2131165357));
    this.mTitle.setTextColor(-1);
    this.mLeftBackBtn.setTextColor(getResources().getColorStateList(2131165352));
    this.mRightBtn.setTextColor(getResources().getColorStateList(2131165352));
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
          Friends localFriends = CommonUtils.a(this.app, str);
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
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (this.mResultList.size() > 0)
    {
      Iterator localIterator = this.mResultList.iterator();
      while (localIterator.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)localIterator.next();
        this.jdField_a_of_type_JavaUtilArrayList.add(localResultRecord.uin);
      }
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.BlessSelectMemberActivity
 * JD-Core Version:    0.7.0.1
 */