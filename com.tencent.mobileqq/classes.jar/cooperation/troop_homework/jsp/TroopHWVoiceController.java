package cooperation.troop_homework.jsp;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.av.utils.api.IVideoProcessMonitor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ptt.IQQRecorder;
import com.tencent.mobileqq.ptt.IQQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class TroopHWVoiceController
  implements IQQRecorder.OnQQRecorderListener, VoicePlayer.VoicePlayerListener
{
  public static String a = "record_status";
  public static String b = "record_url";
  public static String c = "record_local_path";
  public static String d = "shard_pref_name";
  public int e = 360000;
  protected WeakReference<Context> f;
  private SharedPreferences g;
  private String h;
  private int i = 0;
  private TroopHWVoiceController.RecordCallback j;
  private VoicePlayer k = null;
  private IQQRecorder l;
  private Handler m = new TroopHWVoiceController.2(this);
  
  public TroopHWVoiceController(Context paramContext, TroopHWVoiceController.RecordCallback paramRecordCallback)
  {
    this.f = new WeakReference(paramContext);
    this.j = paramRecordCallback;
  }
  
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences(d, 0);
  }
  
  private boolean c()
  {
    if (((IVideoProcessMonitor)QRoute.api(IVideoProcessMonitor.class)).isVideoProcessAlive())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHWVoiceController", 2, "VideoProcessAlive");
      }
      return true;
    }
    Object localObject = this.f;
    if (localObject == null) {
      return false;
    }
    localObject = (Context)((WeakReference)localObject).get();
    if (localObject == null) {
      return false;
    }
    localObject = ((ActivityManager)((Context)localObject).getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals("com.tencent.mobileqq:video")) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void f(String paramString)
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    localObject = (Context)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    this.g = a((Context)localObject);
    localObject = this.g.edit();
    ((SharedPreferences.Editor)localObject).remove(paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.k == null)
    {
      this.k = new VoicePlayer(paramString, new Handler(), paramString.endsWith("amr") ^ true);
      this.k.a(BaseApplication.getContext());
      this.k.h();
      this.k.a(this);
      this.i = paramInt;
      this.k.c();
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a();
    TroopHWVoiceController.RecordCallback localRecordCallback = this.j;
    if (localRecordCallback == null) {
      return;
    }
    paramInt1 = this.i;
    if (paramInt1 > 0)
    {
      localRecordCallback.b(paramInt1, paramString);
      this.i = 0;
      return;
    }
    localRecordCallback.a(3, this.h);
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
    String str2 = c(paramString);
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!new File(str2).exists())
      {
        f(paramString);
        str1 = null;
      }
    }
    if ((this.j != null) && (!TextUtils.isEmpty(str1)))
    {
      this.j.a(1, paramString);
      d(str1);
      return;
    }
    ThreadManager.postImmediately(new TroopHWVoiceController.1(this), null, false);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public boolean a()
  {
    VoicePlayer localVoicePlayer = this.k;
    if (localVoicePlayer != null)
    {
      localVoicePlayer.f();
      this.k = null;
      return true;
    }
    return false;
  }
  
  public void b()
  {
    IQQRecorder localIQQRecorder = this.l;
    if ((localIQQRecorder != null) && (!localIQQRecorder.b()))
    {
      this.m.removeMessages(3);
      this.m.removeMessages(2);
      this.m.sendEmptyMessageDelayed(3, 200L);
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    localObject = (Context)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    this.g = a((Context)localObject);
    localObject = this.g.edit();
    ((SharedPreferences.Editor)localObject).putString(this.h, paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public String c(String paramString)
  {
    Object localObject = this.f;
    if (localObject == null) {
      return null;
    }
    localObject = (Context)((WeakReference)localObject).get();
    if (localObject == null) {
      return null;
    }
    this.g = a((Context)localObject);
    return this.g.getString(paramString, null);
  }
  
  public void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.k == null)
    {
      this.k = new VoicePlayer(paramString, new Handler(), paramString.endsWith("amr") ^ true);
      this.k.a(BaseApplication.getContext());
      this.k.h();
      this.k.a(this);
      this.k.c();
    }
  }
  
  public void e(String paramString)
  {
    Object localObject1 = this.f;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (Context)((WeakReference)localObject1).get();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = Environment.getExternalStorageDirectory();
    int n;
    if ((((File)localObject2).exists()) && (((File)localObject2).canWrite())) {
      n = 1;
    } else {
      n = 0;
    }
    if ((Environment.getExternalStorageState().equals("mounted")) && (n != 0)) {
      n = 1;
    } else {
      n = 0;
    }
    if (n != 0)
    {
      if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1)
      {
        if (c())
        {
          QQToast.makeText(BaseApplication.getContext(), 2131892896, 0).show();
          return;
        }
        if (AudioUtil.b(1))
        {
          ((IPttUtils)QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission((Context)localObject1);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopHWVoiceController", 2, "startRecord() is called");
        }
        if (this.l == null) {
          this.l = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).createQQRecorder((Context)localObject1);
        }
        localObject2 = new RecordParams.RecorderParam(RecordParams.a, 0, 0);
        paramString = TransFileUtil.getTransferFilePath(paramString, null, 2, null);
        this.l.a((RecordParams.RecorderParam)localObject2);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("path: ");
          ((StringBuilder)localObject2).append(paramString);
          QLog.i("QQRecorder", 2, ((StringBuilder)localObject2).toString());
        }
        this.l.a(this);
        QQAudioUtils.a((Context)localObject1, true);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("QQRecorder start() is called,time is:");
          ((StringBuilder)localObject1).append(System.currentTimeMillis());
          QLog.d("TroopHWVoiceController", 2, ((StringBuilder)localObject1).toString());
        }
        this.l.b(paramString);
        return;
      }
      QQToast.makeText(BaseApplication.getContext(), 2131916078, 0).show();
      return;
    }
    QQToast.makeText(BaseApplication.getContext(), 2131892169, 0).show();
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    this.e -= 200;
    this.m.sendEmptyMessageDelayed(2, this.e);
    return this.e + 200;
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam) {}
  
  public void onInitSuccess() {}
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam) {}
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(paramString);
    this.j.a(paramString, paramDouble);
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).cancelBufferTask(paramString1);
    this.j.b();
  }
  
  public void onRecorderNotReady(String paramString) {}
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    paramRecorderParam = RecordParams.a(paramRecorderParam.c, paramRecorderParam.a);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).createBufferTask(paramString);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramRecorderParam, paramRecorderParam.length);
    AudioUtil.b(2131230817, false);
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramArrayOfByte, paramInt1);
  }
  
  public int onRecorderStart()
  {
    this.j.a();
    return 250;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWVoiceController
 * JD-Core Version:    0.7.0.1
 */