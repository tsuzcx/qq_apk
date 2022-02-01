package com.tencent.mobileqq.jsp;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ptt.IQQRecorder;
import com.tencent.mobileqq.ptt.IQQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.AudioInfo;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class WebRecordApiPlugin$AudioApiHelper
  implements IQQRecorder.OnQQRecorderListener, VoicePlayer.VoicePlayerListener
{
  QBaseActivity a;
  protected WebRecordApiPlugin.AudioUploadTask b = null;
  int c = 0;
  private IQQRecorder e;
  private AppInterface f;
  private int g = 1;
  private int h = 60000;
  private boolean i = true;
  private VoicePlayer j;
  private double k;
  private String l;
  private Handler m = new WebRecordApiPlugin.AudioApiHelper.1(this, Looper.getMainLooper());
  
  public WebRecordApiPlugin$AudioApiHelper(WebRecordApiPlugin paramWebRecordApiPlugin, AppInterface paramAppInterface, QBaseActivity paramQBaseActivity)
  {
    this.f = paramAppInterface;
    this.a = paramQBaseActivity;
  }
  
  private String a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject1).append("webrecord/");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    if (paramInt != 2)
    {
      if (paramInt != 25) {
        localObject1 = null;
      } else {
        localObject1 = ".slk";
      }
    }
    else {
      localObject1 = ".amr";
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("getTransferFilePath dir: ");
      ((StringBuilder)localObject3).append((String)localObject2);
      QLog.d("WebRecordApiPlugin", 2, ((StringBuilder)localObject3).toString());
    }
    Object localObject3 = c();
    Object localObject4 = new File((String)localObject2);
    if (!((File)localObject4).exists()) {
      ((File)localObject4).mkdirs();
    }
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject2);
    ((StringBuilder)localObject4).append((String)localObject3);
    ((StringBuilder)localObject4).append((String)localObject1);
    localObject1 = new File(((StringBuilder)localObject4).toString());
    if ((paramBoolean) && (!((File)localObject1).exists())) {}
    try
    {
      ((File)localObject1).createNewFile();
    }
    catch (IOException localIOException)
    {
      label191:
      break label191;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getTransferFilePath : ");
      ((StringBuilder)localObject2).append(((File)localObject1).getAbsoluteFile().toString());
      QLog.d("WebRecordApiPlugin", 2, ((StringBuilder)localObject2).toString());
    }
    return ((File)localObject1).getAbsoluteFile().toString();
  }
  
  private int b()
  {
    return this.c;
  }
  
  private void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  /* Error */
  private String c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: lconst_1
    //   3: invokestatic 142	java/lang/Thread:sleep	(J)V
    //   6: goto +12 -> 18
    //   9: astore_3
    //   10: goto +37 -> 47
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 145	java/lang/InterruptedException:printStackTrace	()V
    //   18: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   21: lstore_1
    //   22: new 153	java/text/SimpleDateFormat
    //   25: dup
    //   26: ldc 155
    //   28: invokespecial 156	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   31: new 158	java/util/Date
    //   34: dup
    //   35: lload_1
    //   36: invokespecial 160	java/util/Date:<init>	(J)V
    //   39: invokevirtual 164	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   42: astore_3
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_3
    //   46: areturn
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_3
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	AudioApiHelper
    //   21	15	1	l1	long
    //   9	1	3	localObject	Object
    //   13	2	3	localInterruptedException	java.lang.InterruptedException
    //   42	8	3	str	String
    // Exception table:
    //   from	to	target	type
    //   2	6	9	finally
    //   14	18	9	finally
    //   18	43	9	finally
    //   2	6	13	java/lang/InterruptedException
  }
  
  private void d(String paramString)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    if (((Time)localObject).hour < 3) {
      return;
    }
    localObject = SharePreferenceUtils.a(this.a, "LAST_DELETE_TIME");
    String str = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    if ((localObject != null) && (str.equals(localObject))) {
      return;
    }
    ThreadManager.post(new WebRecordApiPlugin.AudioApiHelper.2(this, paramString), 8, null, false);
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.e;
    if ((localObject != null) && (!((IQQRecorder)localObject).b()) && (!this.m.hasMessages(16711686)))
    {
      this.m.removeMessages(16711688);
      this.m.removeMessages(16711686);
      this.m.removeMessages(16711687);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("stopRecord() is called,time is:");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("WebRecordApiPlugin", 2, ((StringBuilder)localObject).toString());
      }
      this.c = paramInt;
      if (this.e != null)
      {
        localObject = this.m.obtainMessage(16711686);
        this.m.sendMessageDelayed((Message)localObject, 200L);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) || (paramInt1 == 0)) {
      this.g = paramInt1;
    }
    if (paramInt2 > 0)
    {
      paramInt1 = paramInt2 * 1000;
      if (paramInt1 < this.h) {
        this.h = paramInt1;
      }
    }
    Object localObject = this.e;
    if ((localObject != null) && (((IQQRecorder)localObject).a()))
    {
      localObject = this.d;
      ((WebRecordApiPlugin)localObject).callJs(WebRecordApiPlugin.b((WebRecordApiPlugin)localObject), new String[] { "{'code':-1,'recordID':'-1','msg':'is recording now'}" });
      return;
    }
    localObject = Environment.getExternalStorageDirectory();
    if ((((File)localObject).exists()) && (((File)localObject).canWrite())) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if ((Environment.getExternalStorageState().equals("mounted")) && (paramInt1 != 0)) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (paramInt1 != 0)
    {
      localObject = DeviceInfoUtil.q();
      if ((new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) && (localObject != null) && (localObject[1] > 2L))
      {
        if (AudioUtil.b(1))
        {
          localObject = this.d;
          str = WebRecordApiPlugin.b((WebRecordApiPlugin)localObject);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("{'code':-1,'recordID':'-1','msg':'");
          localStringBuilder.append(this.a.getString(2131896467));
          localStringBuilder.append(",");
          localStringBuilder.append(this.a.getString(2131896468));
          localStringBuilder.append("'}");
          ((WebRecordApiPlugin)localObject).callJs(str, new String[] { localStringBuilder.toString() });
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WebRecordApiPlugin", 2, "startRecord() is called");
        }
        if (this.e == null) {
          this.e = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).createQQRecorder(this.a);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
        ((StringBuilder)localObject).append("webrecord/");
        d(((StringBuilder)localObject).toString());
        if (this.g == 0)
        {
          localObject = new RecordParams.RecorderParam(RecordParams.a, 0, 0);
          this.l = a(2, true);
        }
        else
        {
          localObject = new RecordParams.RecorderParam(RecordParams.b, 16000, 1);
          this.l = a(25, true);
        }
        this.e.a((RecordParams.RecorderParam)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("path: ");
          ((StringBuilder)localObject).append(this.l);
          QLog.i("QQRecorder", 2, ((StringBuilder)localObject).toString());
        }
        this.e.a(this);
        QQAudioUtils.a(this.a, true);
        this.e.b(this.l);
        b(0);
        return;
      }
      localObject = this.d;
      str = WebRecordApiPlugin.b((WebRecordApiPlugin)localObject);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("{'code':-1,'recordID':'-1','msg':'");
      localStringBuilder.append(this.a.getString(2131916078));
      localStringBuilder.append("'}");
      ((WebRecordApiPlugin)localObject).callJs(str, new String[] { localStringBuilder.toString() });
      return;
    }
    localObject = this.d;
    String str = WebRecordApiPlugin.b((WebRecordApiPlugin)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{'code':-1,'recordID':'-1','msg':'");
    localStringBuilder.append(this.a.getString(2131892169));
    localStringBuilder.append("'}");
    ((WebRecordApiPlugin)localObject).callJs(str, new String[] { localStringBuilder.toString() });
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    b(paramString);
  }
  
  public void a(String paramString)
  {
    Object localObject1 = new File(paramString);
    if ((((File)localObject1).exists()) && (SharePreferenceUtils.a(this.a, paramString) != null))
    {
      double d1 = Double.valueOf(SharePreferenceUtils.a(this.a, paramString)).doubleValue();
      long l1;
      if (((File)localObject1).exists()) {
        l1 = ((File)localObject1).length();
      } else {
        l1 = 0L;
      }
      localObject1 = new AudioInfo(paramString, (int)d1, l1);
      localObject2 = this.j;
      if (localObject2 == null)
      {
        this.j = new VoicePlayer(((AudioInfo)localObject1).path, new Handler(), ((AudioInfo)localObject1).getAudioType());
        this.j.a(this.a);
        this.j.h();
        this.j.a(this);
        this.j.c();
      }
      else
      {
        ((VoicePlayer)localObject2).d();
      }
      localObject1 = this.d;
      localObject2 = WebRecordApiPlugin.c((WebRecordApiPlugin)localObject1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("{'code':0,'recordID':'");
      localStringBuilder.append(paramString);
      localStringBuilder.append("'}");
      ((WebRecordApiPlugin)localObject1).callJs((String)localObject2, new String[] { localStringBuilder.toString() });
      return;
    }
    localObject1 = this.d;
    Object localObject2 = WebRecordApiPlugin.c((WebRecordApiPlugin)localObject1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{'code':3,'recordID':'");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'}");
    ((WebRecordApiPlugin)localObject1).callJs((String)localObject2, new String[] { localStringBuilder.toString() });
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(JSONArray paramJSONArray, String paramString1, String paramString2)
  {
    int n = 0;
    while (n < paramJSONArray.length())
    {
      Object localObject1 = paramJSONArray.optString(n, "");
      Object localObject2 = new File((String)localObject1);
      String str = SharePreferenceUtils.a(this.a, (String)localObject1);
      if ((((File)localObject2).exists()) && (!TextUtils.isEmpty(str)))
      {
        double d1 = Double.valueOf(str).doubleValue();
        localObject2 = new File((String)localObject1);
        long l1;
        if (((File)localObject2).exists()) {
          l1 = ((File)localObject2).length();
        } else {
          l1 = 0L;
        }
        localObject1 = new AudioInfo((String)localObject1, (int)d1, l1);
        this.b = new WebRecordApiPlugin.AudioUploadTask(this.d, this.a, this.m, paramString1, paramString2, (AudioInfo)localObject1);
        ThreadManager.post(this.b, 5, null, true);
      }
      else
      {
        localObject2 = this.d;
        str = WebRecordApiPlugin.a((WebRecordApiPlugin)localObject2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{'code':1,'recordID':'");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("','msg':'record not found or its duration is 0'}");
        ((WebRecordApiPlugin)localObject2).callJs(str, new String[] { localStringBuilder.toString() });
      }
      n += 1;
    }
  }
  
  public boolean a()
  {
    IQQRecorder localIQQRecorder = this.e;
    return (localIQQRecorder != null) && (localIQQRecorder.a());
  }
  
  public void b(String paramString)
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      ((VoicePlayer)localObject).f();
      this.j = null;
      localObject = this.d;
      String str = WebRecordApiPlugin.c((WebRecordApiPlugin)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{'code':2,'recordID':'");
      localStringBuilder.append(paramString);
      localStringBuilder.append("'}");
      ((WebRecordApiPlugin)localObject).callJs(str, new String[] { localStringBuilder.toString() });
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c(String paramString)
  {
    Object localObject = this.j;
    if (localObject != null)
    {
      ((VoicePlayer)localObject).e();
      localObject = this.d;
      String str = WebRecordApiPlugin.c((WebRecordApiPlugin)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{'code':1,'recordID':'");
      localStringBuilder.append(paramString);
      localStringBuilder.append("'}");
      ((WebRecordApiPlugin)localObject).callJs(str, new String[] { localStringBuilder.toString() });
    }
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onBeginReceiveData() is called");
    }
    this.h -= 200;
    this.m.sendEmptyMessageDelayed(16711687, this.h);
    return this.h + 200;
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onInitFailed() is called");
    }
    paramString = this.d;
    paramString.callJs(WebRecordApiPlugin.b(paramString), new String[] { "{'code':-1,'recordID':'-1','msg':'onInitFailed is called'}" });
  }
  
  public void onInitSuccess()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onInitSuccess() is called");
    }
  }
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderAbnormal() is called");
    }
    paramString = this.d;
    paramString.callJs(WebRecordApiPlugin.b(paramString), new String[] { "{'code':-1,'recordID':'-1','msg':'onRecorderAbnormal is called'}" });
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderEnd() is called");
    }
    if (this.i)
    {
      this.i = false;
      this.m.removeMessages(1);
    }
    int n = b();
    if (QLog.isColorLevel())
    {
      paramRecorderParam = new StringBuilder();
      paramRecorderParam.append("fateOfRecorder is:");
      paramRecorderParam.append(n);
      QLog.d("AIOAudioPanel", 2, paramRecorderParam.toString());
    }
    byte[] arrayOfByte;
    Object localObject;
    if (n == 0)
    {
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(paramString);
      SharePreferenceUtils.a(this.a, this.l, Double.toString(this.k));
      arrayOfByte = FileUtils.readFile(paramString);
      localObject = null;
      paramRecorderParam = (RecordParams.RecorderParam)localObject;
      if (arrayOfByte == null) {}
    }
    try
    {
      paramRecorderParam = Base64.encodeToString(arrayOfByte, 0);
      localObject = paramRecorderParam;
      if (TextUtils.isEmpty(paramRecorderParam)) {
        localObject = "";
      }
      paramRecorderParam = new JSONObject();
      try
      {
        paramRecorderParam.put("code", 1);
        paramRecorderParam.put("recordID", paramString);
        paramRecorderParam.put("msg", localObject);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      paramString = paramRecorderParam.toString();
      if (QLog.isColorLevel())
      {
        paramRecorderParam = new StringBuilder();
        paramRecorderParam.append("onRecorderEnd result=");
        paramRecorderParam.append(paramString);
        QLog.d("WebRecordApiPlugin", 2, paramRecorderParam.toString());
      }
      paramRecorderParam = this.d;
      paramRecorderParam.callJs(WebRecordApiPlugin.b(paramRecorderParam), new String[] { paramString });
      return;
      if (n == 1) {
        ((IPttBuffer)QRoute.api(IPttBuffer.class)).cancelBufferTask(paramString);
      }
      return;
    }
    catch (Exception paramRecorderParam)
    {
      for (;;)
      {
        paramRecorderParam = (RecordParams.RecorderParam)localObject;
      }
    }
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderError() is called");
    }
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).cancelBufferTask(paramString1);
    this.m.removeMessages(1);
    paramString1 = this.d;
    paramString1.callJs(WebRecordApiPlugin.b(paramString1), new String[] { "{'code':-1,'recordID':'-1','msg':'onRecorderError is called'}" });
  }
  
  public void onRecorderNotReady(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AudioApiHelper.onRecorderNotReady() is called,path is:");
      localStringBuilder.append(paramString);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    paramString = this.d;
    paramString.callJs(WebRecordApiPlugin.b(paramString), new String[] { "{'code':-1,'recordID':'-1','msg':'onRecorderNotReady is called'}" });
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderPrepare() is called");
    }
    paramRecorderParam = RecordParams.a(paramRecorderParam.c, paramRecorderParam.a);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).createBufferTask(paramString);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramRecorderParam, paramRecorderParam.length);
    AudioUtil.b(2131230817, false);
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel())
    {
      paramRecorderParam = new StringBuilder();
      paramRecorderParam.append("AudioApiHelper.onRecorderSilceEnd() is called maxAmplitude=");
      paramRecorderParam.append(paramInt2);
      QLog.d("AIOAudioPanel", 2, paramRecorderParam.toString());
    }
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramArrayOfByte, paramInt1);
    if (this.i)
    {
      this.i = false;
      this.m.removeMessages(1);
    }
    this.k = paramDouble;
  }
  
  public int onRecorderStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderStart() is called");
    }
    this.m.removeMessages(1);
    this.m.sendEmptyMessageDelayed(1, 2000L);
    this.i = true;
    WebRecordApiPlugin localWebRecordApiPlugin = this.d;
    String str = WebRecordApiPlugin.b(localWebRecordApiPlugin);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{'code':0,'recordID':'");
    localStringBuilder.append(this.l);
    localStringBuilder.append("','msg':''}");
    localWebRecordApiPlugin.callJs(str, new String[] { localStringBuilder.toString() });
    return 250;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderVolumeStateChanged() is called");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.WebRecordApiPlugin.AudioApiHelper
 * JD-Core Version:    0.7.0.1
 */