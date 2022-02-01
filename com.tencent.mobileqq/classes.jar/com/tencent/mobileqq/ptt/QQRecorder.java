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
  public static int j = 60000;
  protected AudioRecord a = null;
  protected AudioManager b;
  protected int c = 20480;
  protected int d = 800;
  protected AudioCompositeProcessor e;
  protected int f = 0;
  protected int g = -1;
  protected int h = -1;
  public RecordParams.RecorderParam i;
  protected IQQRecorder.RecorderProcessorListener k;
  protected String l;
  public QQRecorder.RecordThread m;
  protected boolean n = false;
  public boolean o;
  protected IQQRecorder.OnQQRecorderListener p;
  protected boolean q = true;
  private Context r;
  
  public QQRecorder() {}
  
  public QQRecorder(Context paramContext)
  {
    this.r = paramContext;
    this.b = ((AudioManager)paramContext.getSystemService("audio"));
    this.i = new RecordParams.RecorderParam(RecordParams.a, 0, 0);
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
        this.g = Integer.parseInt(paramContext[0]);
        this.h = Integer.parseInt(paramContext[1]);
        if (paramContext.length > 4) {
          a(Integer.parseInt(paramContext[2]), Integer.parseInt(paramContext[3]), Integer.parseInt(paramContext[4]));
        }
        if ((!VersionUtils.e()) && ((this.g == 3) || (this.h == 7))) {
          throw new RuntimeException("Illegal dpc config");
        }
      }
      catch (Exception paramContext)
      {
        this.g = -1;
        this.h = -1;
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "QQRecord init error.", paramContext);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("mMode = ");
      paramContext.append(this.g);
      paramContext.append(" | mAudioSource = ");
      paramContext.append(this.h);
      paramContext.append(" | recorderBufSize = ");
      paramContext.append(this.c);
      paramContext.append(" | readLength = ");
      paramContext.append(this.d);
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
    int i1;
    if ((!((String)localObject).equalsIgnoreCase("Xiaomi-MI NOTE Pro")) && (!str.equalsIgnoreCase("OPPO")))
    {
      i1 = paramInt;
      if (str.equalsIgnoreCase("vivo")) {
        return paramInt + 130;
      }
    }
    else
    {
      i1 = paramInt + 100;
    }
    return i1;
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
    if (this.p != null)
    {
      AudioManager localAudioManager = this.b;
      if ((localAudioManager != null) && (this.g != -1)) {
        localAudioManager.setMode(0);
      }
      if ((!(paramThrowable instanceof QQRecorder.RecordInitException)) && (!(paramThrowable instanceof IllegalArgumentException)))
      {
        if ((paramThrowable instanceof QQRecorder.RecordNoPermissonException)) {
          this.p.onRecorderAbnormal(paramString, this.i);
        } else {
          this.p.onRecorderError(paramString, this.i, paramThrowable.getMessage());
        }
      }
      else {
        this.p.onInitFailed(paramString, this.i);
      }
    }
    a(paramThrowable);
    return true;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != -1)
    {
      paramInt2 = e();
      if ((paramInt2 != -2) && (paramInt2 != -1)) {
        this.c = (paramInt2 * paramInt1);
      }
    }
    else if (paramInt2 != -1)
    {
      this.c = paramInt2;
    }
    if (paramInt3 != -1) {
      this.d = paramInt3;
    }
  }
  
  public void a(IQQRecorder.OnQQRecorderListener paramOnQQRecorderListener)
  {
    this.p = paramOnQQRecorderListener;
  }
  
  public void a(IQQRecorder.RecorderProcessorListener paramRecorderProcessorListener)
  {
    this.k = paramRecorderProcessorListener;
  }
  
  public void a(RecordParams.RecorderParam paramRecorderParam)
  {
    if (this.i.a != paramRecorderParam.a) {
      this.n = true;
    }
    this.i = paramRecorderParam;
    ThreadManager.excute(new QQRecorder.1(this), 16, null, false);
  }
  
  public void a(String paramString)
  {
    this.l = paramString;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("thread is:");
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append(", time is:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("ChatActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b;
    if (localObject != null) {
      try
      {
        if (((AudioManager)localObject).isMicrophoneMute())
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "mic is mute, set mute false.");
          }
          this.b.setMicrophoneMute(false);
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQRecorder", 2, "setMicrophoneMute error.", localException);
        }
      }
    }
    this.q = paramBoolean;
    ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).setLastRecorderPath(paramString);
    ??? = this.m;
    if ((??? != null) && (???.c()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "start, RecordThread exist , notify ");
      }
      synchronized (this.m)
      {
        this.m.c = true;
        this.m.b = paramString;
        this.m.a();
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
    this.m = new QQRecorder.RecordThread(this);
    ??? = this.m;
    ???.b = paramString;
    ???.a();
    this.m.start();
  }
  
  void a(Throwable paramThrowable)
  {
    for (int i1 = 7;; i1 = 6)
    {
      try
      {
        String str = paramThrowable.toString();
        if ((paramThrowable instanceof RuntimeException))
        {
          if (str.contains("STATE_INITIALIZED")) {
            i1 = 2;
          }
        }
        else if ((paramThrowable instanceof UnsatisfiedLinkError)) {
          if (str.contains("Native method not found"))
          {
            i1 = 4;
          }
          else
          {
            if (!str.contains("Library not found")) {
              continue;
            }
            i1 = 5;
          }
        }
        paramThrowable = new HashMap();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(i1);
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
          paramThrowable.append(i1);
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
    if (this.o != paramBoolean)
    {
      this.o = paramBoolean;
      this.n = true;
    }
  }
  
  public boolean a()
  {
    QQRecorder.RecordThread localRecordThread = this.m;
    return (localRecordThread != null) && (localRecordThread.a);
  }
  
  public void b(String paramString)
  {
    a(paramString, true);
  }
  
  public boolean b()
  {
    QQRecorder.RecordThread localRecordThread = this.m;
    if (localRecordThread != null) {
      return localRecordThread.a ^ true;
    }
    return true;
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("thread is:");
      ((StringBuilder)localObject).append(this.m);
      ((StringBuilder)localObject).append(",time is:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("ChatActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.m;
    if (localObject != null)
    {
      boolean bool = ((QQRecorder.RecordThread)localObject).a;
      this.m.a = false;
      return bool;
    }
    return false;
  }
  
  public void d()
  {
    ??? = this.m;
    if ((??? != null) && (???.c())) {
      synchronized (this.m)
      {
        this.m.c = false;
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
  
  protected int e()
  {
    return AudioRecord.getMinBufferSize(this.i.a, 2, 2);
  }
  
  @SuppressLint({"WrongConstant"})
  protected void f()
  {
    Object localObject = this.b;
    int i1;
    if (localObject != null) {
      i1 = ((AudioManager)localObject).getMode();
    } else {
      i1 = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startRecording | audio mode = ");
      ((StringBuilder)localObject).append(i1);
      QLog.d("QQRecorder", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.b;
    if (localObject != null)
    {
      i1 = this.g;
      if (i1 != -1) {
        ((AudioManager)localObject).setMode(i1);
      }
    }
    localObject = this.a;
    if ((localObject == null) || (((AudioRecord)localObject).getState() == 0) || (this.n))
    {
      i1 = this.h;
      if (i1 == -1) {
        i1 = 0;
      }
      this.a = new AudioRecord(i1, this.i.a, 2, 2, this.c);
      this.n = false;
    }
    if (this.a.getState() != 1)
    {
      i1 = this.a.getState();
      localObject = this.a;
      if (localObject != null) {
        ((AudioRecord)localObject).release();
      }
      this.a = null;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mRecorder.getState is not STATE_INITIALIZED, state = ");
      ((StringBuilder)localObject).append(i1);
      throw new QQRecorder.RecordInitException(((StringBuilder)localObject).toString());
    }
    this.a.startRecording();
    localObject = this.p;
    if (localObject != null) {
      ((IQQRecorder.OnQQRecorderListener)localObject).onInitSuccess();
    }
  }
  
  protected void g()
  {
    this.e = new AudioCompositeProcessor();
    Object localObject = new WechatNsWrapper(this.r);
    if (WechatNsWrapper.j) {
      this.e.a((IAudioProcessor)localObject);
    }
    if (this.q) {
      if (this.i.c == 0) {
        this.e.a(new AmrInputStreamWrapper(this.r));
      } else {
        this.e.a(new SilkCodecWrapper(this.r));
      }
    }
    this.e.a(this.i.a, this.i.b, this.i.c);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mAudioType=");
      localStringBuilder.append(this.i.c);
      localStringBuilder.append(", mSampleRate=");
      localStringBuilder.append(this.i.a);
      localStringBuilder.append(" ,mBitRate=");
      localStringBuilder.append(this.i.b);
      localStringBuilder.append(" ,Codec=");
      localStringBuilder.append(this.e);
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      ((StringBuilder)localObject).append(" ,processor = ");
      ((StringBuilder)localObject).append(" ,time is :");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("QQRecorder", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void h()
  {
    AudioCompositeProcessor localAudioCompositeProcessor = this.e;
    if (localAudioCompositeProcessor != null)
    {
      localAudioCompositeProcessor.a();
      this.e = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.QQRecorder
 * JD-Core Version:    0.7.0.1
 */