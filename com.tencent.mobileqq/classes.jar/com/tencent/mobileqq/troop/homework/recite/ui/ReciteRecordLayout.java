package com.tencent.mobileqq.troop.homework.recite.ui;

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
import com.qq.wx.voice.recognizer.VoiceRecognizer;
import com.qq.wx.voice.recognizer.VoiceRecognizerListener;
import com.qq.wx.voice.recognizer.VoiceRecognizerResult;
import com.qq.wx.voice.recognizer.VoiceRecordState;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelCallback;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor.ProcessData;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.troop.homework.recite.config.ReciteConfig;
import com.tencent.mobileqq.troop.homework.recite.domain.ReciteRecordBuffer;
import com.tencent.mobileqq.troop.homework.recite.utils.ReciteDetectManager;
import com.tencent.mobileqq.troop.homework.recite.utils.SoLibraryChecker;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.QQRecorder.RecorderProcessorListener;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ReciteRecordLayout
  extends LinearLayout
  implements VoiceRecognizerListener, AudioPanelCallback, QQRecorder.OnQQRecorderListener, QQRecorder.RecorderProcessorListener
{
  Context jdField_a_of_type_AndroidContentContext;
  CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  TextView jdField_a_of_type_AndroidWidgetTextView;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private ReciteRecordLayout.OnReciteListener jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout$OnReciteListener;
  VolumeVisualizerView jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiVolumeVisualizerView;
  ReciteDetectManager jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  String jdField_a_of_type_JavaLangString;
  volatile boolean jdField_a_of_type_Boolean = false;
  CountDownTimer jdField_b_of_type_AndroidOsCountDownTimer;
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
    a(paramContext);
    f();
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
    View.inflate(paramContext, 2131560818, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376799));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiVolumeVisualizerView = ((VolumeVisualizerView)findViewById(2131381764));
  }
  
  private void e()
  {
    if (b())
    {
      a();
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(2131697476).setNegativeButton(HardCodeUtil.a(2131713194), new ReciteRecordLayout.2(this)).setPositiveButton(2131697470, new ReciteRecordLayout.1(this), false);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidOsCountDownTimer = new ReciteRecordLayout.3(this, 3000L, 1000L);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ReciteRecordLayout.4(this);
    this.jdField_a_of_type_AndroidOsCountDownTimer = new ReciteRecordLayout.5(this, 10000L, 1000L);
  }
  
  private void g()
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
      i = 2131698526;
    }
    for (;;)
    {
      try
      {
        localObject = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(i));
        if (j == 0) {
          break label240;
        }
        ((SpannableString)localObject).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131165624), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131165629)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length() - 1, 33);
        DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, HardCodeUtil.a(2131713199), (CharSequence)localObject, 0, 2131720056, null, null, new ReciteRecordLayout.15(this)).show();
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
        i = 2131698528;
      }
      else if (localException.equalsIgnoreCase("vivo"))
      {
        i = 2131698527;
      }
      else
      {
        i = 2131698524;
        j = 1;
      }
    }
    label240:
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, HardCodeUtil.a(2131713193), localException.toString(), HardCodeUtil.a(2131713195), "", null, new ReciteRecordLayout.16(this)).show();
  }
  
  public String a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {
      throw new IllegalArgumentException("activity can not be null");
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReciteRecordLayout", 2, "startRecord!");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager.c();
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131697439, 0).a();
      return null;
    }
    if (!FileUtils.a())
    {
      DialogUtil.a(paramBaseActivity, 230).setMessage(2131697440).setPositiveButton(2131697430, new ReciteRecordLayout.6(this)).show();
      return null;
    }
    if ((!QQRecorder.d()) || (!QQRecorder.a(1)))
    {
      DialogUtil.a(paramBaseActivity, 230).setMessage(2131697429).setPositiveButton(2131697430, new ReciteRecordLayout.7(this)).show();
      return null;
    }
    if (paramBaseActivity.app.isVideoChatting())
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131695173, 0).a();
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(new RecordParams.RecorderParam(16000, CodecParam.mAudioChannel, 1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
    }
    QQAudioUtils.a(this.jdField_a_of_type_AndroidContentContext, true);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = BuddyTransfileProcessor.getTransferFilePath(paramBaseActivity.app.getCurrentAccountUin(), null, 65, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_Boolean = false;
    VoiceRecognizer.shareInstance().setContRes(true);
    VoiceRecognizer.shareInstance().setContReco(true);
    VoiceRecognizer.shareInstance().setResultType(0);
    VoiceRecognizer.shareInstance().setListener(this);
    paramBaseActivity = (TroopManager)paramBaseActivity.app.getManager(QQManagerFactory.TROOP_MANAGER);
    try
    {
      VoiceRecognizer.shareInstance().init(this.jdField_a_of_type_AndroidContentContext, paramBaseActivity.a.jdField_b_of_type_JavaLangString, SoLibraryChecker.a(this.jdField_a_of_type_AndroidContentContext, "libWXVoice.so"));
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
  
  public void a()
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
    }
    QQAudioUtils.a(this.jdField_a_of_type_AndroidContentContext, false);
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_b_of_type_Boolean = true;
    VoiceRecognizer.shareInstance().destroy();
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData) {}
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    if (b())
    {
      a();
      if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(2131697466).setNegativeButton(2131697477, new ReciteRecordLayout.18(this)).setPositiveButton(2131697469, new ReciteRecordLayout.17(this));
        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
      }
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
    }
  }
  
  public void b(IAudioProcessor paramIAudioProcessor, IAudioProcessor.ProcessData paramProcessData)
  {
    VoiceRecognizer.shareInstance().appendData(paramProcessData.jdField_a_of_type_ArrayOfByte, paramProcessData.b, paramProcessData.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean);
  }
  
  boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a());
  }
  
  public void c()
  {
    if (b()) {
      d();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
    VoiceRecognizer.shareInstance().destroy();
  }
  
  public void d()
  {
    this.jdField_b_of_type_Boolean = true;
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
    }
    QQAudioUtils.a(this.jdField_a_of_type_AndroidContentContext, false);
    this.jdField_a_of_type_JavaLangString = null;
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    if (this.jdField_b_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_b_of_type_AndroidOsCountDownTimer.cancel();
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    this.jdField_a_of_type_Boolean = false;
    VoiceRecognizer.shareInstance().destroy();
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    return -1;
  }
  
  public void onGetError(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteRecordLayout", 2, "onGetError = " + paramInt);
    }
    if ((paramInt == -201) || (paramInt == -202)) {
      e();
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
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    d();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReciteRecordLayout.12(this), 500L);
  }
  
  public void onInitSuccess() {}
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    d();
    this.jdField_a_of_type_AndroidOsHandler.post(new ReciteRecordLayout.14(this));
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    ReciteRecordBuffer.b(paramString);
    this.jdField_a_of_type_AndroidOsHandler.post(new ReciteRecordLayout.11(this, paramString, paramDouble));
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteRecordLayout", 2, "onRecorderError = " + paramString2);
    }
    ReciteRecordBuffer.a(paramString1);
    d();
    this.jdField_a_of_type_AndroidOsHandler.post(new ReciteRecordLayout.13(this));
  }
  
  public void onRecorderNotReady(String paramString) {}
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    ReciteRecordBuffer.a(paramString);
    File localFile = new File(paramString);
    if ((!localFile.exists()) || (localFile.length() == 0L))
    {
      paramRecorderParam = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
      ReciteRecordBuffer.a(paramString, paramRecorderParam, paramRecorderParam.length);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ReciteRecordLayout.9(this));
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
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
      this.jdField_a_of_type_AndroidOsHandler.post(new ReciteRecordLayout.8(this, paramInt2));
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public int onRecorderStart()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ReciteRecordLayout.10(this));
    return 0;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt) {}
  
  public void onVolumeChanged(int paramInt) {}
  
  public void setOnReciteListener(ReciteRecordLayout.OnReciteListener paramOnReciteListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteRecordLayout$OnReciteListener = paramOnReciteListener;
  }
  
  public void setmReciteDetectManager(ReciteDetectManager paramReciteDetectManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUtilsReciteDetectManager = paramReciteDetectManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout
 * JD-Core Version:    0.7.0.1
 */