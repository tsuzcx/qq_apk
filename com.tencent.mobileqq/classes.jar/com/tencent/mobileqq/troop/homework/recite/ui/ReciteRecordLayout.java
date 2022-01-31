package com.tencent.mobileqq.troop.homework.recite.ui;

import aiur;
import aius;
import aiut;
import aiuu;
import aiuv;
import aiuw;
import aiux;
import aiuy;
import aiuz;
import aiva;
import aivb;
import aivc;
import aivd;
import aive;
import aivh;
import aivi;
import aivj;
import aivk;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.wx.voice.data.recognizer.VoiceRecognizer;
import com.qq.wx.voice.data.recognizer.VoiceRecognizerListener;
import com.qq.wx.voice.data.recognizer.VoiceRecognizerResult;
import com.qq.wx.voice.data.recognizer.VoiceRecordState;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelCallback;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.ptt.processor.IPttProcessor;
import com.tencent.mobileqq.ptt.processor.IPttProcessor.ProcessData;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.troop.homework.recite.config.ReciteConfig;
import com.tencent.mobileqq.troop.homework.recite.domain.ReciteRecordBuffer;
import com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQRecorder.RecorderProcessorListener;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ReciteRecordLayout
  extends LinearLayout
  implements VoiceRecognizerListener, AudioPanelCallback, QQRecorder.OnQQRecorderListener, QQRecorder.RecorderProcessorListener
{
  public Context a;
  CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  public TextView a;
  public BaseActivity a;
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private ReciteRecordLayout.OnReciteListener jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout$OnReciteListener;
  public VolumeVisualizerView a;
  public QQCustomDialog a;
  QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  String jdField_a_of_type_JavaLangString;
  public volatile boolean a;
  public CountDownTimer b;
  QQCustomDialog jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  String jdField_b_of_type_JavaLangString;
  volatile boolean jdField_b_of_type_Boolean = false;
  
  public ReciteRecordLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReciteRecordLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReciteRecordLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    a(paramContext);
    g();
  }
  
  private String a(String paramString)
  {
    int i = 0;
    int k = paramString.length();
    char[] arrayOfChar = new char[k << 1];
    int j = 0;
    while (j < k)
    {
      arrayOfChar[i] = paramString.charAt(j);
      arrayOfChar[(i + 1)] = ' ';
      j += 1;
      i = j << 1;
    }
    return new String(arrayOfChar);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    View.inflate(paramContext, 2130969932, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368465));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiVolumeVisualizerView = ((VolumeVisualizerView)findViewById(2131368464));
  }
  
  private void f()
  {
    if (b())
    {
      b();
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(2131431534).setNegativeButton("退出", new aivb(this)).setPositiveButton(2131431533, new aiur(this), false);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  private void g()
  {
    this.jdField_b_of_type_AndroidOsCountDownTimer = new aivc(this, 3000L, 1000L);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new aivd(this);
    this.jdField_a_of_type_AndroidOsCountDownTimer = new aive(this, 10000L, 1000L);
  }
  
  private void h()
  {
    int j = 0;
    if (((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof Activity)) && ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReciteRecordLayout", 2, "showNoRecordPermissionDlg failed, mActivity not valid");
      }
      return;
    }
    Object localObject = Build.MANUFACTURER;
    int i;
    if (((String)localObject).equalsIgnoreCase("meizu")) {
      i = 2131433373;
    }
    for (;;)
    {
      try
      {
        localObject = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(i));
        if (j == 0) {
          break label237;
        }
        ((SpannableString)localObject).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131493061), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131493062)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length() - 1, 33);
        DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "权限提示", (CharSequence)localObject, 0, 2131435179, null, null, new aiux(this)).show();
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReciteRecordLayout", 2, "show noPermission error : " + localException.getMessage());
      return;
      if (localException.equalsIgnoreCase("xiaomi"))
      {
        i = 2131433374;
      }
      else if (localException.equalsIgnoreCase("vivo"))
      {
        i = 2131433375;
      }
      else
      {
        i = 2131433372;
        j = 1;
      }
    }
    label237:
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, "权限提示", localException.toString(), "我知道了", "", null, new aiuy(this)).show();
  }
  
  public int a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new aius(this));
    return 0;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    return -1;
  }
  
  public String a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {
      throw new IllegalArgumentException("activity can not be null");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131431540, 0).a();
      return null;
    }
    if (!FileUtils.a())
    {
      DialogUtil.a(paramBaseActivity, 230).setMessage(2131431542).setPositiveButton(2131431541, new aivh(this)).show();
      return null;
    }
    if ((!QQRecorder.d()) || (!QQRecorder.a(1)))
    {
      DialogUtil.a(paramBaseActivity, 230).setMessage(2131431543).setPositiveButton(2131431541, new aivi(this)).show();
      return null;
    }
    if (paramBaseActivity.app.c())
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131433771, 0).a();
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(new QQRecorder.RecorderParam(16000, CodecParam.o, 1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
    }
    AudioUtil.a(this.jdField_a_of_type_AndroidContentContext, true);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = BuddyTransfileProcessor.a(paramBaseActivity.app.getCurrentAccountUin(), null, 65, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_Boolean = false;
    VoiceRecognizer.shareInstance().setContRes(true);
    VoiceRecognizer.shareInstance().setContReco(true);
    VoiceRecognizer.shareInstance().setResultType(0);
    VoiceRecognizer.shareInstance().setListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqAppTroopManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager = ((TroopManager)paramBaseActivity.app.getManager(51));
    }
    try
    {
      VoiceRecognizer.shareInstance().init(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a.jdField_b_of_type_JavaLangString, SoLibraryChecker.a(this.jdField_a_of_type_AndroidContentContext, "libWXVoice.so"));
      VoiceRecognizer.shareInstance().start();
      AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      return this.jdField_a_of_type_JavaLangString;
    }
    catch (Exception paramBaseActivity)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReciteRecordLayout", 2, "VoiceRecognizer init error = " + paramBaseActivity);
        }
      }
    }
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(IPttProcessor paramIPttProcessor, IPttProcessor.ProcessData paramProcessData) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    ReciteRecordBuffer.a(paramString);
    File localFile = new File(paramString);
    if ((!localFile.exists()) || (localFile.length() == 0L))
    {
      paramRecorderParam = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
      ReciteRecordBuffer.a(paramString, paramRecorderParam, paramRecorderParam.length);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new aivk(this));
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    ReciteRecordBuffer.b(paramString);
    this.jdField_a_of_type_AndroidOsHandler.post(new aiut(this, paramString, paramDouble));
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteRecordLayout", 2, "onRecorderError = " + paramString2);
    }
    ReciteRecordBuffer.a(paramString1);
    c();
    this.jdField_a_of_type_AndroidOsHandler.post(new aiuv(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    ReciteRecordBuffer.a(paramString, paramArrayOfByte, paramInt1);
    if (paramInt2 < 500) {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsCountDownTimer.start();
        this.jdField_a_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.post(new aivj(this, paramInt2));
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
    }
    AudioUtil.a(this.jdField_a_of_type_AndroidContentContext, false);
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void b(IPttProcessor paramIPttProcessor, IPttProcessor.ProcessData paramProcessData)
  {
    VoiceRecognizer.shareInstance().appendData(paramProcessData.jdField_a_of_type_ArrayOfByte, paramProcessData.b, paramProcessData.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean);
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    c();
    this.jdField_a_of_type_AndroidOsHandler.post(new aiuw(this));
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a());
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
    }
    AudioUtil.a(this.jdField_a_of_type_AndroidContentContext, false);
    this.jdField_a_of_type_JavaLangString = null;
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (this.jdField_b_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_b_of_type_AndroidOsCountDownTimer.cancel();
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    c();
    this.jdField_a_of_type_AndroidOsHandler.post(new aiuu(this));
  }
  
  public void d()
  {
    if (b())
    {
      b();
      if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(2131431537).setNegativeButton(2131431535, new aiva(this)).setPositiveButton(2131431536, new aiuz(this));
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
      }
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  public void e()
  {
    if (b()) {
      c();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    VoiceRecognizer.shareInstance().destroy();
  }
  
  public void onGetError(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteRecordLayout", 2, "onGetError = " + paramInt);
    }
    if ((paramInt == -201) || (paramInt == -202)) {
      f();
    }
  }
  
  public void onGetResult(VoiceRecognizerResult paramVoiceRecognizerResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteRecordLayout", 2, "onGetResult text ==" + paramVoiceRecognizerResult.text + " startTime = " + paramVoiceRecognizerResult.startTime);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout$OnReciteListener != null) && (!TextUtils.isEmpty(paramVoiceRecognizerResult.text)) && (!paramVoiceRecognizerResult.text.equals(this.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_b_of_type_JavaLangString = paramVoiceRecognizerResult.text;
      if (QLog.isColorLevel()) {
        QLog.e("ReciteRecordLayout", 2, "onGetResult2 text ==" + paramVoiceRecognizerResult.text + " startTime = " + paramVoiceRecognizerResult.startTime);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout$OnReciteListener.a(paramVoiceRecognizerResult.text, ChnToSpell.a(a(paramVoiceRecognizerResult.text), 1), paramVoiceRecognizerResult.startTime, paramVoiceRecognizerResult.stopTime, paramVoiceRecognizerResult.isAllEnd);
    }
  }
  
  public void onGetVoicePackage(byte[] paramArrayOfByte, String paramString) {}
  
  public void onGetVoiceRecordState(VoiceRecordState paramVoiceRecordState) {}
  
  public void onVolumeChanged(int paramInt) {}
  
  public void setOnReciteListener(ReciteRecordLayout.OnReciteListener paramOnReciteListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout$OnReciteListener = paramOnReciteListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout
 * JD-Core Version:    0.7.0.1
 */