package com.tencent.mobileqq.troop.homework.recite.ui;

import acqp;
import ajjy;
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
import audl;
import audm;
import awje;
import axoy;
import ayxk;
import ayxl;
import ayye;
import ayyf;
import ayyg;
import ayyh;
import ayyi;
import ayyj;
import ayyk;
import ayyl;
import ayym;
import ayyp;
import ayyq;
import ayyr;
import ayzh;
import ayzm;
import baan;
import babr;
import bace;
import badq;
import bafb;
import bahf;
import bahh;
import bahn;
import bbmy;
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
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ReciteRecordLayout
  extends LinearLayout
  implements acqp, bahf, bahh, VoiceRecognizerListener
{
  public Context a;
  CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  public TextView a;
  private ayyr jdField_a_of_type_Ayyr;
  ayzh jdField_a_of_type_Ayzh;
  public bafb a;
  public BaseActivity a;
  INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  VolumeVisualizerView jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiVolumeVisualizerView;
  QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  String jdField_a_of_type_JavaLangString;
  public volatile boolean a;
  public CountDownTimer b;
  bafb jdField_b_of_type_Bafb;
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
    View.inflate(paramContext, 2131494817, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131309261));
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiVolumeVisualizerView = ((VolumeVisualizerView)findViewById(2131313485));
  }
  
  private void f()
  {
    if (b())
    {
      b();
      if (this.jdField_a_of_type_Bafb == null)
      {
        this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(2131632006).setNegativeButton(ajjy.a(2131647448), new ayyj(this)).setPositiveButton(2131632004, new ayye(this), false);
        this.jdField_a_of_type_Bafb.setCancelable(false);
      }
      this.jdField_a_of_type_Bafb.show();
    }
  }
  
  private void g()
  {
    this.jdField_b_of_type_AndroidOsCountDownTimer = new ayyk(this, 3000L, 1000L);
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ayyl(this);
    this.jdField_a_of_type_AndroidOsCountDownTimer = new ayym(this, 10000L, 1000L);
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
      i = 2131632810;
    }
    for (;;)
    {
      try
      {
        localObject = new SpannableString(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(i));
        if (j == 0) {
          break label240;
        }
        ((SpannableString)localObject).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131099950), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getColor(2131099955)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length() - 1, 33);
        babr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ajjy.a(2131647453), (CharSequence)localObject, 0, 2131654515, null, null, new ayyf(this)).show();
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
        i = 2131632812;
      }
      else if (localException.equalsIgnoreCase("vivo"))
      {
        i = 2131632811;
      }
      else
      {
        i = 2131632809;
        j = 1;
      }
    }
    label240:
    babr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230, ajjy.a(2131647447), localException.toString(), ajjy.a(2131647449), "", null, new ayyg(this)).show();
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
    if (this.jdField_a_of_type_Ayzh != null) {
      this.jdField_a_of_type_Ayzh.c();
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    if (!badq.g(this.jdField_a_of_type_AndroidContentContext))
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131631977, 0).a();
      return null;
    }
    if (!bace.a())
    {
      babr.a(paramBaseActivity, 230).setMessage(2131631978).setPositiveButton(2131631972, new ayyp(this)).show();
      return null;
    }
    if ((!QQRecorder.d()) || (!QQRecorder.a(1)))
    {
      babr.a(paramBaseActivity, 230).setMessage(2131631971).setPositiveButton(2131631972, new ayyq(this)).show();
      return null;
    }
    if (paramBaseActivity.app.c())
    {
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, 2131629840, 0).a();
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(new QQRecorder.RecorderParam(16000, awje.o, 1));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
    }
    baan.a(this.jdField_a_of_type_AndroidContentContext, true);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = axoy.a(paramBaseActivity.app.getCurrentAccountUin(), null, 65, null);
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
      VoiceRecognizer.shareInstance().init(this.jdField_a_of_type_AndroidContentContext, paramBaseActivity.a.jdField_b_of_type_JavaLangString, ayzm.a(this.jdField_a_of_type_AndroidContentContext, "libWXVoice.so"));
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
  
  public void a(audl paramaudl, audm paramaudm) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    ayxl.a(paramString);
    File localFile = new File(paramString);
    if ((!localFile.exists()) || (localFile.length() == 0L))
    {
      paramRecorderParam = bahn.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
      ayxl.a(paramString, paramRecorderParam, paramRecorderParam.length);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ReciteRecordLayout.9(this));
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    ayxl.b(paramString);
    this.jdField_a_of_type_AndroidOsHandler.post(new ReciteRecordLayout.11(this, paramString, paramDouble));
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReciteRecordLayout", 2, "onRecorderError = " + paramString2);
    }
    ayxl.a(paramString1);
    c();
    this.jdField_a_of_type_AndroidOsHandler.post(new ReciteRecordLayout.13(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    ayxl.a(paramString, paramArrayOfByte, paramInt1);
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
    if (b()) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
    }
    baan.a(this.jdField_a_of_type_AndroidContentContext, false);
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_b_of_type_Boolean = true;
    VoiceRecognizer.shareInstance().destroy();
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(audl paramaudl, audm paramaudm)
  {
    VoiceRecognizer.shareInstance().appendData(paramaudm.jdField_a_of_type_ArrayOfByte, paramaudm.b, paramaudm.jdField_a_of_type_Int, this.jdField_b_of_type_Boolean);
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    c();
    this.jdField_a_of_type_AndroidOsHandler.post(new ReciteRecordLayout.14(this));
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
    baan.a(this.jdField_a_of_type_AndroidContentContext, false);
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
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    c();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ReciteRecordLayout.12(this), 500L);
  }
  
  public void d()
  {
    if (b())
    {
      b();
      if (this.jdField_b_of_type_Bafb == null)
      {
        this.jdField_b_of_type_Bafb = babr.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setMessage(2131632000).setNegativeButton(2131632007, new ayyi(this)).setPositiveButton(2131632003, new ayyh(this));
        this.jdField_b_of_type_Bafb.setCancelable(false);
      }
      this.jdField_b_of_type_Bafb.show();
    }
  }
  
  public void e()
  {
    if (b()) {
      c();
    }
    if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
      this.jdField_a_of_type_Bafb.dismiss();
    }
    if ((this.jdField_b_of_type_Bafb != null) && (this.jdField_b_of_type_Bafb.isShowing())) {
      this.jdField_b_of_type_Bafb.dismiss();
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
    if ((this.jdField_a_of_type_Ayyr != null) && (!TextUtils.isEmpty(paramVoiceRecognizerResult.text)) && (!paramVoiceRecognizerResult.text.equals(this.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_b_of_type_JavaLangString = paramVoiceRecognizerResult.text;
      if (QLog.isColorLevel()) {
        QLog.e("ReciteRecordLayout", 2, "onGetResult2 text ==" + paramVoiceRecognizerResult.text + " startTime = " + paramVoiceRecognizerResult.startTime);
      }
      this.jdField_a_of_type_Ayyr.a(paramVoiceRecognizerResult.text, ChnToSpell.a(a(paramVoiceRecognizerResult.text), 1), paramVoiceRecognizerResult.startTime, paramVoiceRecognizerResult.stopTime, paramVoiceRecognizerResult.isAllEnd);
    }
  }
  
  public void onGetVoicePackage(byte[] paramArrayOfByte, String paramString) {}
  
  public void onGetVoiceRecordState(VoiceRecordState paramVoiceRecordState) {}
  
  public void onVolumeChanged(int paramInt) {}
  
  public void setOnReciteListener(ayyr paramayyr)
  {
    this.jdField_a_of_type_Ayyr = paramayyr;
  }
  
  public void setmReciteDetectManager(ayzh paramayzh)
  {
    this.jdField_a_of_type_Ayzh = paramayzh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteRecordLayout
 * JD-Core Version:    0.7.0.1
 */