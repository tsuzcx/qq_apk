package com.tencent.mobileqq.ptt;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qqaudio.audioprocessor.AudioCompositeProcessor;
import com.tencent.mobileqq.qqaudio.audioprocessor.IAudioProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import com.tencent.mobileqq.utils.WechatNsWrapper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.HashMap;
import java.util.Random;

public class QQRecorder
  implements IQQRecorder
{
  public static int f = 60000;
  protected int a;
  private Context a;
  protected AudioManager a;
  protected AudioRecord a;
  protected IQQRecorder.OnQQRecorderListener a;
  protected IQQRecorder.RecorderProcessorListener a;
  public QQRecorder.RecordThread a;
  protected AudioCompositeProcessor a;
  public RecordParams.RecorderParam a;
  protected String a;
  protected boolean a;
  protected int b;
  public boolean b;
  protected int c;
  protected boolean c;
  protected int d = -1;
  protected int e = -1;
  
  public QQRecorder()
  {
    this.jdField_a_of_type_AndroidMediaAudioRecord = null;
    this.jdField_a_of_type_Int = 20480;
    this.jdField_b_of_type_Int = 800;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
  }
  
  public QQRecorder(Context paramContext)
  {
    this.jdField_a_of_type_AndroidMediaAudioRecord = null;
    this.jdField_a_of_type_Int = 20480;
    this.jdField_b_of_type_Int = 800;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)paramContext.getSystemService("audio"));
    this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam = new RecordParams.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
    paramContext = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.qq_audio_record.name());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Init | dpc config = ");
      localStringBuilder.append(paramContext);
      QLog.d("QQRecorder", 2, localStringBuilder.toString());
    }
    if (!TextUtils.isEmpty(paramContext)) {
      try
      {
        paramContext = paramContext.split("\\|");
        this.d = Integer.parseInt(paramContext[0]);
        this.e = Integer.parseInt(paramContext[1]);
        if (paramContext.length > 4) {
          a(Integer.parseInt(paramContext[2]), Integer.parseInt(paramContext[3]), Integer.parseInt(paramContext[4]));
        }
        if ((!VersionUtils.e()) && ((this.d == 3) || (this.e == 7))) {
          throw new RuntimeException("Illegal dpc config");
        }
      }
      catch (Exception paramContext)
      {
        this.d = -1;
        this.e = -1;
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "QQRecord init error.", paramContext);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("mMode = ");
      paramContext.append(this.d);
      paramContext.append(" | mAudioSource = ");
      paramContext.append(this.e);
      paramContext.append(" | recorderBufSize = ");
      paramContext.append(this.jdField_a_of_type_Int);
      paramContext.append(" | readLength = ");
      paramContext.append(this.jdField_b_of_type_Int);
      QLog.d("QQRecorder", 2, paramContext.toString());
    }
  }
  
  public static int a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    String str = Build.MANUFACTURER;
    int i;
    if ((!((String)localObject).equalsIgnoreCase("Xiaomi-MI NOTE Pro")) && (!str.equalsIgnoreCase("OPPO")))
    {
      i = paramInt;
      if (str.equalsIgnoreCase("vivo")) {
        return paramInt + 130;
      }
    }
    else
    {
      i = paramInt + 100;
    }
    return i;
  }
  
  protected static void a(String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    if (new Random().nextInt(1000) == 521)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "real do report");
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", paramString, paramBoolean, 0L, 0L, paramHashMap, "");
    }
  }
  
  private boolean a(long paramLong1, int paramInt, long paramLong2, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (System.currentTimeMillis() - paramLong2 > 1000L)
    {
      bool = paramBoolean;
      if (!paramBoolean)
      {
        bool = true;
        if ((paramLong1 == 0L) || (paramInt == 0))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("record abnormal: data size = ");
            localStringBuilder.append(paramLong1);
            localStringBuilder.append(", max volume = ");
            localStringBuilder.append(paramInt);
            QLog.d("QQRecorder", 2, localStringBuilder.toString());
          }
          throw new QQRecorder.RecordNoPermissonException("no permission");
        }
      }
    }
    return bool;
  }
  
  private boolean a(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "record Exception: ", paramThrowable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder$OnQQRecorderListener != null)
    {
      AudioManager localAudioManager = this.jdField_a_of_type_AndroidMediaAudioManager;
      if ((localAudioManager != null) && (this.d != -1)) {
        localAudioManager.setMode(0);
      }
      if ((!(paramThrowable instanceof QQRecorder.RecordInitException)) && (!(paramThrowable instanceof IllegalArgumentException)))
      {
        if ((paramThrowable instanceof QQRecorder.RecordNoPermissonException)) {
          this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder$OnQQRecorderListener.onRecorderAbnormal(paramString, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder$OnQQRecorderListener.onRecorderError(paramString, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam, paramThrowable.getMessage());
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder$OnQQRecorderListener.onInitFailed(paramString, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam);
      }
    }
    a(paramThrowable);
    return true;
  }
  
  protected int a()
  {
    return AudioRecord.getMinBufferSize(this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_a_of_type_Int, 2, 2);
  }
  
  public void a()
  {
    ??? = this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread;
    if ((??? != null) && (???.a())) {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread)
      {
        this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread.jdField_b_of_type_Boolean = false;
        try
        {
          notifyAll();
          if (QLog.isColorLevel())
          {
            QLog.d("QQRecorder", 2, "RecordThread.release");
            return;
          }
        }
        finally {}
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != -1)
    {
      paramInt2 = a();
      if ((paramInt2 != -2) && (paramInt2 != -1)) {
        this.jdField_a_of_type_Int = (paramInt2 * paramInt1);
      }
    }
    else if (paramInt2 != -1)
    {
      this.jdField_a_of_type_Int = paramInt2;
    }
    if (paramInt3 != -1) {
      this.jdField_b_of_type_Int = paramInt3;
    }
  }
  
  public void a(IQQRecorder.OnQQRecorderListener paramOnQQRecorderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder$OnQQRecorderListener = paramOnQQRecorderListener;
  }
  
  public void a(IQQRecorder.RecorderProcessorListener paramRecorderProcessorListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder$RecorderProcessorListener = paramRecorderProcessorListener;
  }
  
  public void a(RecordParams.RecorderParam paramRecorderParam)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_a_of_type_Int != paramRecorderParam.jdField_a_of_type_Int) {
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam = paramRecorderParam;
    ThreadManager.excute(new QQRecorder.1(this), 16, null, false);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("thread is:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread);
      ((StringBuilder)localObject).append(", time is:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("ChatActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localObject != null) {
      try
      {
        if (((AudioManager)localObject).isMicrophoneMute())
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "mic is mute, set mute false.");
          }
          this.jdField_a_of_type_AndroidMediaAudioManager.setMicrophoneMute(false);
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQRecorder", 2, "setMicrophoneMute error.", localException);
        }
      }
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).setLastRecorderPath(paramString);
    ??? = this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread;
    if ((??? != null) && (???.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "start, RecordThread exist , notify ");
      }
      synchronized (this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread)
      {
        this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread.jdField_a_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread.a();
        try
        {
          notifyAll();
          return;
        }
        finally {}
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "QQRecorder.start, new RecordThread ");
    }
    this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread = new QQRecorder.RecordThread(this);
    ??? = this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread;
    ???.jdField_a_of_type_JavaLangString = paramString;
    ???.a();
    this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread.start();
  }
  
  void a(Throwable paramThrowable)
  {
    for (int i = 7;; i = 6)
    {
      try
      {
        String str = paramThrowable.toString();
        if ((paramThrowable instanceof RuntimeException))
        {
          if (str.contains("STATE_INITIALIZED")) {
            i = 2;
          }
        }
        else if ((paramThrowable instanceof UnsatisfiedLinkError)) {
          if (str.contains("Native method not found"))
          {
            i = 4;
          }
          else
          {
            if (!str.contains("Library not found")) {
              continue;
            }
            i = 5;
          }
        }
        paramThrowable = new HashMap();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append("");
        paramThrowable.put("exceptionType", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(Build.VERSION.SDK_INT);
        localStringBuilder.append("");
        paramThrowable.put("osVersion", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(Build.MANUFACTURER);
        localStringBuilder.append("_");
        localStringBuilder.append(Build.MODEL);
        paramThrowable.put("deviceName", localStringBuilder.toString());
        paramThrowable.put("exceptionMsg", str);
        a("actPttRecordException", false, paramThrowable);
        if (QLog.isColorLevel())
        {
          paramThrowable = new StringBuilder();
          paramThrowable.append("report exception(catch exception) | exceptionType = ");
          paramThrowable.append(i);
          paramThrowable.append(" | exceptionMessage = ");
          paramThrowable.append(str);
          QLog.d("QQRecorder", 2, paramThrowable.toString());
          return;
        }
      }
      catch (Exception paramThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "Report exception error.", paramThrowable);
        }
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public boolean a()
  {
    QQRecorder.RecordThread localRecordThread = this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread;
    return (localRecordThread != null) && (localRecordThread.jdField_a_of_type_Boolean);
  }
  
  @SuppressLint({"WrongConstant"})
  protected void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidMediaAudioManager;
    int i;
    if (localObject != null) {
      i = ((AudioManager)localObject).getMode();
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startRecording | audio mode = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("QQRecorder", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.jdField_a_of_type_AndroidMediaAudioManager;
    if (localObject != null)
    {
      i = this.d;
      if (i != -1) {
        ((AudioManager)localObject).setMode(i);
      }
    }
    localObject = this.jdField_a_of_type_AndroidMediaAudioRecord;
    if ((localObject == null) || (((AudioRecord)localObject).getState() == 0) || (this.jdField_a_of_type_Boolean))
    {
      i = this.e;
      if (i == -1) {
        i = 0;
      }
      this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(i, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_a_of_type_Int, 2, 2, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_AndroidMediaAudioRecord.getState() != 1)
    {
      i = this.jdField_a_of_type_AndroidMediaAudioRecord.getState();
      localObject = this.jdField_a_of_type_AndroidMediaAudioRecord;
      if (localObject != null) {
        ((AudioRecord)localObject).release();
      }
      this.jdField_a_of_type_AndroidMediaAudioRecord = null;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mRecorder.getState is not STATE_INITIALIZED, state = ");
      ((StringBuilder)localObject).append(i);
      throw new QQRecorder.RecordInitException(((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_AndroidMediaAudioRecord.startRecording();
    localObject = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder$OnQQRecorderListener;
    if (localObject != null) {
      ((IQQRecorder.OnQQRecorderListener)localObject).onInitSuccess();
    }
  }
  
  public void b(String paramString)
  {
    a(paramString, true);
  }
  
  public boolean b()
  {
    QQRecorder.RecordThread localRecordThread = this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread;
    if (localRecordThread != null) {
      return localRecordThread.jdField_a_of_type_Boolean ^ true;
    }
    return true;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor = new AudioCompositeProcessor();
    Object localObject = new WechatNsWrapper(this.jdField_a_of_type_AndroidContentContext);
    if (WechatNsWrapper.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a((IAudioProcessor)localObject);
    }
    if (this.jdField_c_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_c_of_type_Int == 0) {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a(new AmrInputStreamWrapper(this.jdField_a_of_type_AndroidContentContext));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a(new SilkCodecWrapper(this.jdField_a_of_type_AndroidContentContext));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor.a(this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_c_of_type_Int);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mAudioType=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_c_of_type_Int);
      localStringBuilder.append(", mSampleRate=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_a_of_type_Int);
      localStringBuilder.append(" ,mBitRate=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam.jdField_b_of_type_Int);
      localStringBuilder.append(" ,Codec=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor);
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      ((StringBuilder)localObject).append(" ,processor = ");
      ((StringBuilder)localObject).append(" ,time is :");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("QQRecorder", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("thread is:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread);
      ((StringBuilder)localObject).append(",time is:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("ChatActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread;
    if (localObject != null)
    {
      boolean bool = ((QQRecorder.RecordThread)localObject).jdField_a_of_type_Boolean;
      this.jdField_a_of_type_ComTencentMobileqqPttQQRecorder$RecordThread.jdField_a_of_type_Boolean = false;
      return bool;
    }
    return false;
  }
  
  protected void d()
  {
    AudioCompositeProcessor localAudioCompositeProcessor = this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor;
    if (localAudioCompositeProcessor != null)
    {
      localAudioCompositeProcessor.a();
      this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioprocessorAudioCompositeProcessor = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.QQRecorder
 * JD-Core Version:    0.7.0.1
 */