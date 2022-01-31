package com.tencent.mobileqq.search.activity;

import ahsg;
import ahsh;
import ahsi;
import ahsj;
import ahsk;
import ahsl;
import ahsm;
import ahsn;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.QQVoiceResult;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.ptt.processor.IPttProcessor;
import com.tencent.mobileqq.ptt.processor.IPttProcessor.ProcessData;
import com.tencent.mobileqq.search.model.IContactSearchModel;
import com.tencent.mobileqq.search.searchengine.ApproximateSearchEngine;
import com.tencent.mobileqq.search.searchengine.ISearchEngine;
import com.tencent.mobileqq.search.searchengine.SearchRequest;
import com.tencent.mobileqq.search.util.SearchMatchResult;
import com.tencent.mobileqq.search.util.VADHelper;
import com.tencent.mobileqq.search.view.SearchVoiceView;
import com.tencent.mobileqq.search.view.SearchVoiceView.OnStateEndListener;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQRecorder.RecorderProcessorListener;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.mobileqq.utils.WechatNsWrapper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class VADActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, SearchVoiceView.OnStateEndListener, QQRecorder.OnQQRecorderListener, QQRecorder.RecorderProcessorListener
{
  public static AtomicBoolean a;
  private static int h;
  private int jdField_a_of_type_Int = 640;
  private long jdField_a_of_type_Long;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AVObserver jdField_a_of_type_ComTencentAvGaudioAVObserver;
  private ApproximateSearchEngine jdField_a_of_type_ComTencentMobileqqSearchSearchengineApproximateSearchEngine;
  private ISearchEngine jdField_a_of_type_ComTencentMobileqqSearchSearchengineISearchEngine;
  private VADHelper jdField_a_of_type_ComTencentMobileqqSearchUtilVADHelper;
  private SearchVoiceView jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView;
  private final TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new ahsm(this, ThreadManager.getSubThreadLooper());
  private QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  private String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private Animation jdField_c_of_type_AndroidViewAnimationAnimation;
  private String jdField_c_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir().getParent() + "/txlib/libtraeimp-armeabi-v7a.so";
  private int d;
  private int e;
  private int f;
  private int g;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VADActivity", 2, "launch---fight  ");
    }
    h = paramInt;
    ReportController.b(paramBaseActivity.app, "dc00898", "", "", "0X8007E2A", "0X8007E2A", paramInt, 1, "", "", "", "");
    if (!a()) {
      ThreadManager.post(new ahsh(new ahsg(Looper.getMainLooper(), paramBaseActivity, paramInt)), 8, null, false);
    }
    while (!a(paramBaseActivity)) {
      return;
    }
    Intent localIntent = new Intent(paramBaseActivity, VADActivity.class);
    localIntent.putExtra("fromType", paramInt);
    paramBaseActivity.startActivityForResult(localIntent, 561253);
    paramBaseActivity.overridePendingTransition(0, 0);
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public static boolean a(BaseActivity paramBaseActivity)
  {
    String str = null;
    if (!NetworkUtil.d(paramBaseActivity)) {
      str = paramBaseActivity.getString(2131433009);
    }
    while (str != null)
    {
      QQToast.a(paramBaseActivity, str, 0).b(paramBaseActivity.getTitleBarHeight());
      return false;
      if (!a()) {
        str = " 正在初始化，请稍候...";
      } else if (!FileUtils.a()) {
        str = paramBaseActivity.getResources().getString(2131433437);
      } else if (!QQRecorder.d()) {
        str = paramBaseActivity.getResources().getString(2131433438);
      } else if (!QQRecorder.a(1)) {
        str = paramBaseActivity.getResources().getString(2131433441);
      } else if (paramBaseActivity.app.c()) {
        str = paramBaseActivity.getResources().getString(2131433788);
      } else if (AudioHelper.b(1)) {
        str = paramBaseActivity.getResources().getString(2131433409);
      } else if (paramBaseActivity.isInMultiWindow()) {
        str = "该功能无法在分屏模式下使用。";
      }
    }
    return true;
  }
  
  public static void b()
  {
    for (;;)
    {
      try
      {
        boolean bool1 = SoLoadUtil.a(BaseApplicationImpl.getContext(), "traeimp-armeabi-v7a", 0, false);
        if (!bool1)
        {
          UpdateAvSo.b(BaseApplicationImpl.getContext(), "stlport_shared", true);
          UpdateAvSo.b(BaseApplicationImpl.getContext(), "traeimp-armeabi-v7a", true);
          if (QLog.isColorLevel()) {
            QLog.i("VADActivity", 2, "isLoadSo extractLibraryFromAssert ");
          }
          SoLoadUtil.a(BaseApplicationImpl.getContext(), "stlport_shared", 0, false);
          bool1 = SoLoadUtil.a(BaseApplicationImpl.getContext(), "traeimp-armeabi-v7a", 0, false);
          boolean bool3 = SoLoadUtil.a(BaseApplicationImpl.getContext(), "VADHelper_jni", 0, false);
          boolean bool2 = bool3;
          if (!bool3)
          {
            if (QLog.isColorLevel()) {
              QLog.i("VADActivity", 2, "isLoadSo extractLibraryFromAssert VADHelper_jni ");
            }
            UpdateAvSo.b(BaseApplicationImpl.getContext(), "VADHelper_jni", true);
            bool2 = SoLoadUtil.a(BaseApplicationImpl.getContext(), "VADHelper_jni", 0, false);
          }
          jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(bool2 & bool1);
          return;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("VADActivity", 2, "libstlport_shared.so load failed error = " + localUnsatisfiedLinkError.getMessage());
          return;
        }
      }
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(BaseApplicationImpl.sApplication);
      localObject = new QQRecorder.RecorderParam(16000, 16000, 1);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a((QQRecorder.RecorderParam)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(-1, -1, 640);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineApproximateSearchEngine == null) {
      ThreadManager.post(new ahsj(this), 8, null, true);
    }
    Object localObject = BuddyTransfileProcessor.a(this.app.getCurrentAccountUin(), null, 53, null);
    if (QLog.isDevelopLevel()) {
      QLog.i("VADActivity", 2, "path: " + (String)localObject);
    }
    AudioUtil.a(BaseApplicationImpl.getContext(), true);
    this.jdField_a_of_type_JavaLangString = ((String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a((String)localObject, true);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView.a(0);
    if (QLog.isDevelopLevel()) {
      QLog.i("VADActivity", 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
    }
  }
  
  public int a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VADActivity", 2, "onRecorderStart ");
    }
    return -1;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VADActivity", 2, "onBeginReceiveData ");
    }
    return 10000;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, float[] paramArrayOfFloat, VADHelper paramVADHelper)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    int k = paramInt1 / paramInt2;
    paramInt1 = 0;
    int i = 0;
    int j = 0;
    while (paramInt1 < k)
    {
      System.arraycopy(paramArrayOfByte, i, arrayOfByte, 0, paramInt2);
      if (paramVADHelper.a(arrayOfByte, paramInt2, paramArrayOfFloat) == 1) {
        j = 1;
      }
      i += paramInt2;
      paramInt1 += 1;
    }
    return j;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(IPttProcessor paramIPttProcessor, IPttProcessor.ProcessData paramProcessData)
  {
    if ((paramIPttProcessor instanceof WechatNsWrapper))
    {
      if (this.e < 2) {
        this.e += 1;
      }
    }
    else {
      return;
    }
    int i = paramProcessData.jdField_a_of_type_Int;
    System.arraycopy(paramProcessData.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, i);
    this.jdField_b_of_type_Int = (i + this.jdField_b_of_type_Int);
    if (a(this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfFloat, this.jdField_a_of_type_ComTencentMobileqqSearchUtilVADHelper) == 0) {
      this.jdField_c_of_type_Int += 1;
    }
    for (;;)
    {
      this.jdField_b_of_type_Int = 0;
      if ((this.jdField_c_of_type_Int < 50) || (!this.jdField_a_of_type_Boolean)) {
        break;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("VADActivity", 2, "afterProcess result: 1s no valid voice data .end record");
      }
      paramIPttProcessor = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramIPttProcessor);
      return;
      this.jdField_c_of_type_Int = 0;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(4);
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VADActivity", 2, "onRecorderNotReady path: " + paramString);
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VADActivity", 2, "onRecorderPrepare path: " + paramString);
    }
    paramRecorderParam = RecordParams.a(paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.jdField_a_of_type_Int);
    PttBuffer.a(paramString);
    PttBuffer.a(paramString, paramRecorderParam, paramRecorderParam.length);
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VADActivity", 2, "onRecorderEnd ");
    }
    PttBuffer.b(paramString);
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if ((NetworkUtil.d(BaseApplicationImpl.getContext())) && (this.jdField_a_of_type_Boolean))
    {
      VADHelper.b();
      VADHelper.a("voice_search_all_cost");
      VADHelper.a("voice_search_server_cost");
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqSearchUtilVADHelper.a(paramString, this.app);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(6, 15000L);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(8);
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VADActivity", 2, "onRecorderError = " + paramString2);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(7);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (this.f < 2)
    {
      this.f += 1;
      if (this.g < paramInt2) {
        this.g = paramInt2;
      }
    }
    if (this.f >= 2)
    {
      paramRecorderParam = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
      paramRecorderParam.arg1 = ((int)(20.0D * Math.log10(this.g / 32768.0F)));
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramRecorderParam);
      this.f = 0;
      this.g = 0;
    }
    PttBuffer.a(paramString, paramArrayOfByte, paramInt1);
  }
  
  public String[] a(List paramList)
  {
    String[] arrayOfString = new String[2];
    ApproximateSearchEngine localApproximateSearchEngine;
    SearchRequest localSearchRequest;
    Object localObject2;
    Object localObject1;
    label62:
    Object localObject3;
    Object localObject4;
    if ((paramList != null) && (paramList.size() > 0))
    {
      if ((!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineApproximateSearchEngine == null)) {
        break label620;
      }
      localApproximateSearchEngine = this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineApproximateSearchEngine;
      localSearchRequest = new SearchRequest("");
      localObject2 = paramList.iterator();
      localObject1 = null;
      if (!((Iterator)localObject2).hasNext()) {
        break label715;
      }
      localObject3 = (Bdh_extinfo.QQVoiceResult)((Iterator)localObject2).next();
      localObject1 = ((Bdh_extinfo.QQVoiceResult)localObject3).bytes_text.get().toStringUtf8();
      localSearchRequest.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localObject4 = localApproximateSearchEngine.b(localSearchRequest);
      if ((localObject4 == null) || (((List)localObject4).size() <= 0)) {
        break label660;
      }
      arrayOfString[0] = localObject1;
      this.d = ((Bdh_extinfo.QQVoiceResult)localObject3).uint32_source.get();
    }
    label164:
    label707:
    label715:
    for (;;)
    {
      if (TextUtils.isEmpty(arrayOfString[0]))
      {
        localObject4 = paramList.iterator();
        localObject2 = null;
        localObject3 = localObject1;
        localObject1 = localObject3;
        if (((Iterator)localObject4).hasNext())
        {
          localObject3 = (Bdh_extinfo.QQVoiceResult)((Iterator)localObject4).next();
          localObject2 = ((Bdh_extinfo.QQVoiceResult)localObject3).bytes_text.get().toStringUtf8();
          localObject1 = ((Bdh_extinfo.QQVoiceResult)localObject3).bytes_pinyin.get().toStringUtf8();
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label707;
          }
          localObject1 = ChnToSpell.a((String)localObject2, 1).jdField_a_of_type_JavaLangString;
          label229:
          localSearchRequest.jdField_a_of_type_JavaLangString = ((String)localObject1);
          Object localObject5 = localApproximateSearchEngine.b(localSearchRequest);
          if ((localObject5 != null) && (((List)localObject5).size() > 0))
          {
            localObject5 = ((IContactSearchModel)((List)localObject5).get(0)).a();
            if ((localObject5 != null) && ((localObject5 instanceof SpannableStringBuilder)))
            {
              localObject5 = (SpannableStringBuilder)localObject5;
              ForegroundColorSpan[] arrayOfForegroundColorSpan = (ForegroundColorSpan[])((SpannableStringBuilder)localObject5).getSpans(0, ((SpannableStringBuilder)localObject5).length(), ForegroundColorSpan.class);
              if ((arrayOfForegroundColorSpan != null) && (arrayOfForegroundColorSpan.length > 0)) {
                arrayOfString[0] = ((SpannableStringBuilder)localObject5).subSequence(((SpannableStringBuilder)localObject5).getSpanStart(arrayOfForegroundColorSpan[0]), ((SpannableStringBuilder)localObject5).getSpanEnd(arrayOfForegroundColorSpan[0])).toString();
              }
            }
          }
          if (TextUtils.isEmpty(arrayOfString[0])) {
            break label663;
          }
          this.d = ((Bdh_extinfo.QQVoiceResult)localObject3).uint32_source.get();
          localObject3 = localObject2;
          localObject2 = localObject1;
          localObject1 = localObject3;
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty(arrayOfString[0]))
        {
          localSearchRequest.jdField_a_of_type_JavaLangString = ((Bdh_extinfo.QQVoiceResult)paramList.get(0)).bytes_text.get().toStringUtf8();
          this.d = ((Bdh_extinfo.QQVoiceResult)paramList.get(0)).uint32_source.get();
          localObject2 = localApproximateSearchEngine.a(localSearchRequest);
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject2 = (IContactSearchModel)((List)localObject2).get(0);
            if (((IContactSearchModel)localObject2).a != null) {
              arrayOfString[0] = ((IContactSearchModel)localObject2).a.a();
            }
          }
        }
        for (;;)
        {
          if (TextUtils.isEmpty(arrayOfString[0]))
          {
            arrayOfString[0] = ((Bdh_extinfo.QQVoiceResult)paramList.get(0)).bytes_text.get().toStringUtf8();
            this.d = ((Bdh_extinfo.QQVoiceResult)paramList.get(0)).uint32_source.get();
          }
          if (QLog.isColorLevel()) {
            QLog.i("VADActivity", 2, "server result.size = " + paramList.size() + " AILab.result = " + (String)localObject1 + " finalShow.result = " + arrayOfString[0] + " mResultSource = " + this.d);
          }
          return arrayOfString;
          label620:
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
          localApproximateSearchEngine = new ApproximateSearchEngine(this.app, 2, 793, null);
          localApproximateSearchEngine.a();
          this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineApproximateSearchEngine = localApproximateSearchEngine;
          break;
          break label62;
          localObject3 = localObject2;
          localObject2 = localObject1;
          break label164;
          localSearchRequest.jdField_a_of_type_JavaLangString = arrayOfString[0];
          ThreadManager.post(new ahsn(this, localApproximateSearchEngine, localSearchRequest), 8, null, true);
          arrayOfString[1] = localObject2;
        }
        break label229;
        localObject2 = null;
      }
    }
  }
  
  public void b(IPttProcessor paramIPttProcessor, IPttProcessor.ProcessData paramProcessData) {}
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VADActivity", 2, "onRecorderAbnormal ");
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView.a(5);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setText("再试一次");
    this.jdField_a_of_type_AndroidWidgetTextView.setText("听不见你在说什么？");
    this.jdField_a_of_type_AndroidViewAnimationAnimation.reset();
    this.jdField_b_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.reset();
    this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VADActivity", 2, "onInitFailed ");
    }
    paramString = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(7);
    paramString.obj = Boolean.valueOf(true);
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(paramString);
  }
  
  public void d()
  {
    int j = 0;
    if (((this instanceof Activity)) && ((this == null) || (isFinishing())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VADActivity", 2, "showAbnormalRecordDlg failed, VADActivity.this not valid");
      }
      return;
    }
    Object localObject = Build.MANUFACTURER;
    int i;
    if (((String)localObject).equalsIgnoreCase("meizu")) {
      i = 2131433390;
    }
    for (;;)
    {
      try
      {
        localObject = new SpannableString(getString(i));
        if (j == 0) {
          break label230;
        }
        ((SpannableString)localObject).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(getResources().getColor(2131493062), getResources().getColor(2131493063)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length() - 1, 33);
        DialogUtil.a(this, "权限提示", (CharSequence)localObject, 0, 2131435196, null, new ahsk(this), new ahsl(this)).show();
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VADActivity", 2, "show showAbnormalRecordDlg error : " + localException.getMessage());
      return;
      if (localException.equalsIgnoreCase("xiaomi"))
      {
        i = 2131433391;
      }
      else if (localException.equalsIgnoreCase("vivo"))
      {
        i = 2131433392;
      }
      else
      {
        i = 2131433389;
        j = 1;
      }
    }
    label230:
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle("权限提示");
    localQQCustomDialog.setMessage(i);
    localQQCustomDialog.setPositiveButton(2131435196, new DialogUtil.DialogOnClickAdapter(), true);
    localQQCustomDialog.show();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      finish();
      return false;
    }
    super.setContentView(2130970601);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.a(new Class[] { BDHCommonUploadProcessor.class });
    this.jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView = ((SearchVoiceView)findViewById(2131371274));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView.setOnStateEndListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371276));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("请问你要找谁？");
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371275));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    findViewById(2131371277).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSearchUtilVADHelper = new VADHelper(this.jdField_c_of_type_JavaLangString);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.app.a().a(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    int i = this.jdField_a_of_type_ComTencentMobileqqSearchUtilVADHelper.calcOneFrameBytes(16000, 1);
    if (i > 0) {
      this.jdField_a_of_type_Int = i;
    }
    this.jdField_a_of_type_ArrayOfByte = new byte[this.jdField_a_of_type_Int];
    this.jdField_a_of_type_ArrayOfFloat = new float[1];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[2];
    this.jdField_a_of_type_ComTencentAvGaudioAVObserver = new ahsi(this);
    this.app.a().addObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
    float f1 = getResources().getDisplayMetrics().density;
    i = (int)(20.0F * f1 + 0.5D);
    int j = (int)(40.0F * f1 + 0.5D);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, (int)(f1 * 25.0F + 0.5D), 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(500L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setInterpolator(new DecelerateInterpolator(2.0F));
    this.jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, i, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(600L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setInterpolator(new DecelerateInterpolator(2.0F));
    this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    this.jdField_c_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, j, 0.0F);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setDuration(500L);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setInterpolator(new DecelerateInterpolator(2.0F));
    findViewById(2131371277).startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.a().deleteObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchUtilVADHelper != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchUtilVADHelper.a();
      this.app.a().b(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineApproximateSearchEngine != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineApproximateSearchEngine.b();
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineApproximateSearchEngine = null;
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView.a(5);
    }
    finish();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    f();
  }
  
  public void e()
  {
    String str;
    if ((!this.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_ArrayOfJavaLangString[0])))
    {
      str = this.jdField_a_of_type_ArrayOfJavaLangString[0];
      if ((h != 1) && (h != 2) && (h != 21)) {
        break label99;
      }
      if (h != 1) {
        break label81;
      }
      UniteSearchActivity.a(this, str, h, this.jdField_b_of_type_JavaLangString, this.d, true, this.jdField_a_of_type_Long);
    }
    for (;;)
    {
      finish();
      return;
      label81:
      if ((h == 2) || (h != 21)) {
        break;
      }
      break;
      label99:
      Intent localIntent = new Intent();
      localIntent.putExtra("keyword", str);
      localIntent.putExtra("vsKey", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("vsSource", this.d);
      localIntent.putExtra("fromType", h);
      localIntent.putExtra("isApproximate", true);
      setResult(-1, localIntent);
    }
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
    case 2: 
    case 4: 
    case 3: 
      do
      {
        return true;
        this.jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView.setAmplitude(paramMessage.arg1);
        return true;
        g();
        return true;
        this.jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView.a(2);
        this.jdField_a_of_type_AndroidWidgetTextView.setText("猜你想找");
        this.jdField_b_of_type_AndroidViewAnimationAnimation.reset();
        this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        return true;
        this.jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView.a(1);
        this.jdField_a_of_type_AndroidWidgetTextView.setText("请问你要找谁？");
        this.jdField_b_of_type_AndroidViewAnimationAnimation.reset();
        this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        return true;
      } while (paramMessage.obj == null);
      System.arraycopy((String[])paramMessage.obj, 0, this.jdField_a_of_type_ArrayOfJavaLangString, 0, 2);
      if (TextUtils.isEmpty(this.jdField_a_of_type_ArrayOfJavaLangString[0]))
      {
        c();
        return true;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("猜你想找 \n “" + this.jdField_a_of_type_ArrayOfJavaLangString[0] + "”");
      this.jdField_b_of_type_AndroidViewAnimationAnimation.reset();
      this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      this.jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView.a(4);
      return true;
    case 6: 
      if (!NetworkUtil.d(this)) {
        QQToast.a(BaseApplicationImpl.getContext(), 2131433009, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
      }
      c();
      return true;
    case 7: 
      if (paramMessage.obj == null) {
        break;
      }
    }
    for (boolean bool = ((Boolean)paramMessage.obj).booleanValue();; bool = false)
    {
      if (bool) {
        d();
      }
      for (;;)
      {
        c();
        return true;
        QQToast.a(this.app.getApp(), 2131433787, 1).b(getResources().getDimensionPixelSize(2131558448));
      }
      if (!NetworkUtil.d(this)) {
        QQToast.a(BaseApplicationImpl.getContext(), 2131433009, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
      }
      c();
      return true;
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      finish();
      return true;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131371276: 
    default: 
      return;
    case 2131371277: 
      ReportController.b(this.app, "dc00898", "", "", "0X8007E2B", "0X8007E2B", 0, 1, "", "", "", "");
      finish();
      return;
    }
    if (!NetworkUtil.d(this))
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131433009, 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
      return;
    }
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = "";
    this.jdField_a_of_type_ArrayOfJavaLangString[1] = "";
    this.jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView.a();
    paramView.setAnimation(null);
    paramView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("请问你要找谁？");
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewAnimationAnimation.reset();
    this.jdField_a_of_type_ComTencentMobileqqSearchViewSearchVoiceView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.VADActivity
 * JD-Core Version:    0.7.0.1
 */