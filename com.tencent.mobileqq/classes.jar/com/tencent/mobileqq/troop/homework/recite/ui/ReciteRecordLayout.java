package com.tencent.mobileqq.troop.homework.recite.ui;

import agnw;
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
import anzj;
import bamu;
import bamv;
import bdbt;
import berv;
import bgbq;
import bgbr;
import bgck;
import bgcl;
import bgcm;
import bgcn;
import bgco;
import bgcp;
import bgcq;
import bgcr;
import bgcs;
import bgcv;
import bgcw;
import bgcx;
import bgdn;
import bgds;
import bhkm;
import bhlq;
import bhmi;
import bhnv;
import bhpc;
import bhrh;
import bhrj;
import bhrp;
import com.qq.wx.voice.recognizer.VoiceRecognizer;
import com.qq.wx.voice.recognizer.VoiceRecognizerListener;
import com.qq.wx.voice.recognizer.VoiceRecognizerResult;
import com.qq.wx.voice.recognizer.VoiceRecordState;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ReciteRecordLayout
  extends LinearLayout
  implements agnw, bhrh, bhrj, VoiceRecognizerListener
{
  public Context a;
  CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  public TextView a;
  private bgcx jdField_a_of_type_Bgcx;
  bgdn jdField_a_of_type_Bgdn;
  public bhpc a;
  public BaseActivity a;
  INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  VolumeVisualizerView jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiVolumeVisualizerView;
  QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  String jdField_a_of_type_JavaLangString;
  public volatile boolean a;
  public CountDownTimer b;
  bhpc jdField_b_of_type_Bhpc;
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
    View.inflate(paramContext, 2131560664, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376391));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiVolumeVisualizerView = ((VolumeVisualizerView)findViewById(2131381227));
  }
  
  private void f()
  {
    if (b())
    {
      d();
      if (this.jdField_a_of_type_Bhpc == null)
      {
        this.jdField_a_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(2131696807).setNegativeButton(anzj.a(2131712119), new bgcp(this)).setPositiveButton(2131696801, new bgck(this), false);
        this.jdField_a_of_type_Bhpc.setCancelable(false);
      }
      this.jdField_a_of_type_Bhpc.show();
    }
  }
  
  private void g()
  {
    this.jdField_b_of_type_AndroidOsCountDownTimer = new bgcq(this, 3000L, 1000L);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new bgcr(this);
    this.jdField_a_of_type_AndroidOsCountDownTimer = new bgcs(this, 10000L, 1000L);
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
      i = 2131697819;
    }
    for (;;)
    {
      try
      {
        localObject = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(i));
        if (j == 0) {
          break label240;
        }
        ((SpannableString)localObject).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131165608), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131165613)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length() - 1, 33);
        bhlq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, anzj.a(2131712124), (CharSequence)localObject, 0, 2131718838, null, null, new bgcl(this)).show();
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
        i = 2131697821;
      }
      else if (localException.equalsIgnoreCase("vivo"))
      {
        i = 2131697820;
      }
      else
      {
        i = 2131697818;
        j = 1;
      }
    }
    label240:
    bhlq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, anzj.a(2131712118), localException.toString(), anzj.a(2131712120), "", null, new bgcm(this)).show();
  }
  
  public int a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ReciteRecordLayout.10(this));
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
    if (QLog.isColorLevel()) {
      QLog.d("ReciteRecordLayout", 2, "startRecord!");
    }
    if (this.jdField_a_of_type_Bgdn != null) {
      this.jdField_a_of_type_Bgdn.c();
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    if (!bhnv.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131696770, 0).a();
      return null;
    }
    if (!bhmi.a())
    {
      bhlq.a(paramBaseActivity, 230).setMessage(2131696771).setPositiveButton(2131696761, new bgcv(this)).show();
      return null;
    }
    if ((!QQRecorder.d()) || (!QQRecorder.a(1)))
    {
      bhlq.a(paramBaseActivity, 230).setMessage(2131696760).setPositiveButton(2131696761, new bgcw(this)).show();
      return null;
    }
    if (paramBaseActivity.app.d())
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694616, 0).a();
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(new QQRecorder.RecorderParam(16000, bdbt.o, 1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
    }
    bhkm.a(this.jdField_a_of_type_AndroidContentContext, true);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = berv.a(paramBaseActivity.app.getCurrentAccountUin(), null, 65, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b(this.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_Boolean = false;
    VoiceRecognizer.shareInstance().setContRes(true);
    VoiceRecognizer.shareInstance().setContReco(true);
    VoiceRecognizer.shareInstance().setResultType(0);
    VoiceRecognizer.shareInstance().setListener(this);
    paramBaseActivity = (TroopManager)paramBaseActivity.app.getManager(52);
    try
    {
      VoiceRecognizer.shareInstance().init(this.jdField_a_of_type_AndroidContentContext, paramBaseActivity.a.jdField_b_of_type_JavaLangString, bgds.a(this.jdField_a_of_type_AndroidContentContext, "libWXVoice.so"));
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
  
  public void a(bamu parambamu, bamv parambamv) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    bgbr.a(paramString);
    File localFile = new File(paramString);
    if ((!localFile.exists()) || (localFile.length() == 0L))
    {
      paramRecorderParam = bhrp.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
      bgbr.a(paramString, paramRecorderParam, paramRecorderParam.length);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ReciteRecordLayout.9(this));
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    bgbr.b(paramString);
    this.jdField_a_of_type_AndroidOsHandler.post(new ReciteRecordLayout.11(this, paramString, paramDouble));
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteRecordLayout", 2, "onRecorderError = " + paramString2);
    }
    bgbr.a(paramString1);
    e();
    this.jdField_a_of_type_AndroidOsHandler.post(new ReciteRecordLayout.13(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    bgbr.a(paramString, paramArrayOfByte, paramInt1);
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
  
  public boolean a()
  {
    return true;
  }
  
  public void b()
  {
    if (b())
    {
      d();
      if (this.jdField_b_of_type_Bhpc == null)
      {
        this.jdField_b_of_type_Bhpc = bhlq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(2131696797).setNegativeButton(2131696808, new bgco(this)).setPositiveButton(2131696800, new bgcn(this));
        this.jdField_b_of_type_Bhpc.setCancelable(false);
      }
      this.jdField_b_of_type_Bhpc.show();
    }
  }
  
  public void b(bamu parambamu, bamv parambamv)
  {
    VoiceRecognizer.shareInstance().appendData(parambamv.jdField_a_of_type_ArrayOfByte, parambamv.b, parambamv.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean);
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    e();
    this.jdField_a_of_type_AndroidOsHandler.post(new ReciteRecordLayout.14(this));
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a());
  }
  
  public void c()
  {
    if (b()) {
      e();
    }
    if ((this.jdField_a_of_type_Bhpc != null) && (this.jdField_a_of_type_Bhpc.isShowing())) {
      this.jdField_a_of_type_Bhpc.dismiss();
    }
    if ((this.jdField_b_of_type_Bhpc != null) && (this.jdField_b_of_type_Bhpc.isShowing())) {
      this.jdField_b_of_type_Bhpc.dismiss();
    }
    VoiceRecognizer.shareInstance().destroy();
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    e();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReciteRecordLayout.12(this), 500L);
  }
  
  public void d()
  {
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
    }
    bhkm.a(this.jdField_a_of_type_AndroidContentContext, false);
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_b_of_type_Boolean = true;
    VoiceRecognizer.shareInstance().destroy();
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void e()
  {
    this.jdField_b_of_type_Boolean = true;
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
    }
    bhkm.a(this.jdField_a_of_type_AndroidContentContext, false);
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
    if ((this.jdField_a_of_type_Bgcx != null) && (!TextUtils.isEmpty(paramVoiceRecognizerResult.text)) && (!paramVoiceRecognizerResult.text.equals(this.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_b_of_type_JavaLangString = paramVoiceRecognizerResult.text;
      if (QLog.isColorLevel()) {
        QLog.e("ReciteRecordLayout", 2, "onGetResult2 text ==" + paramVoiceRecognizerResult.text + " startTime = " + paramVoiceRecognizerResult.startTime);
      }
      this.jdField_a_of_type_Bgcx.a(paramVoiceRecognizerResult.text, ChnToSpell.a(a(paramVoiceRecognizerResult.text), 1), paramVoiceRecognizerResult.startTime, paramVoiceRecognizerResult.stopTime, paramVoiceRecognizerResult.isAllEnd);
    }
  }
  
  public void onGetVoicePackage(byte[] paramArrayOfByte, String paramString) {}
  
  public void onGetVoiceRecordState(VoiceRecordState paramVoiceRecordState) {}
  
  public void onVolumeChanged(int paramInt) {}
  
  public void setOnReciteListener(bgcx parambgcx)
  {
    this.jdField_a_of_type_Bgcx = parambgcx;
  }
  
  public void setmReciteDetectManager(bgdn parambgdn)
  {
    this.jdField_a_of_type_Bgdn = parambgdn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout
 * JD-Core Version:    0.7.0.1
 */