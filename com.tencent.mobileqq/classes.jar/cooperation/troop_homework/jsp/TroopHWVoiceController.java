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
  public int a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler = new TroopHWVoiceController.2(this);
  private IQQRecorder jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
  private TroopHWVoiceController.RecordCallback jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController$RecordCallback;
  protected WeakReference<Context> a;
  private int b = 0;
  private String e;
  
  public TroopHWVoiceController(Context paramContext, TroopHWVoiceController.RecordCallback paramRecordCallback)
  {
    this.jdField_a_of_type_Int = 360000;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController$RecordCallback = paramRecordCallback;
  }
  
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences(d, 0);
  }
  
  private boolean b()
  {
    if (((IVideoProcessMonitor)QRoute.api(IVideoProcessMonitor.class)).isVideoProcessAlive())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHWVoiceController", 2, "VideoProcessAlive");
      }
      return true;
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
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
  
  private void e(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (Context)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = a((Context)localObject);
    localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).remove(paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public String a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return null;
    }
    localObject = (Context)((WeakReference)localObject).get();
    if (localObject == null) {
      return null;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = a((Context)localObject);
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, null);
  }
  
  public void a()
  {
    IQQRecorder localIQQRecorder = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    if ((localIQQRecorder != null) && (!localIQQRecorder.b()))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 200L);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(paramString, new Handler(), paramString.endsWith("amr") ^ true);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(BaseApplication.getContext());
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
      this.b = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a();
    TroopHWVoiceController.RecordCallback localRecordCallback = this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController$RecordCallback;
    if (localRecordCallback == null) {
      return;
    }
    paramInt1 = this.b;
    if (paramInt1 > 0)
    {
      localRecordCallback.b(paramInt1, paramString);
      this.b = 0;
      return;
    }
    localRecordCallback.a(3, this.e);
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
    String str2 = a(paramString);
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!new File(str2).exists())
      {
        e(paramString);
        str1 = null;
      }
    }
    if ((this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController$RecordCallback != null) && (!TextUtils.isEmpty(str1)))
    {
      this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController$RecordCallback.a(1, paramString);
      c(str1);
      return;
    }
    ThreadManager.postImmediately(new TroopHWVoiceController.1(this), null, false);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public boolean a()
  {
    VoicePlayer localVoicePlayer = this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
    if (localVoicePlayer != null)
    {
      localVoicePlayer.e();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
      return true;
    }
    return false;
  }
  
  public void b(String paramString)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (Context)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = a((Context)localObject);
    localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).putString(this.e, paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(paramString, new Handler(), paramString.endsWith("amr") ^ true);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(BaseApplication.getContext());
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
    }
  }
  
  public void d(String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (Context)((WeakReference)localObject1).get();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = Environment.getExternalStorageDirectory();
    int i;
    if ((((File)localObject2).exists()) && (((File)localObject2).canWrite())) {
      i = 1;
    } else {
      i = 0;
    }
    if ((Environment.getExternalStorageState().equals("mounted")) && (i != 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1)
      {
        if (b())
        {
          QQToast.a(BaseApplication.getContext(), 2131695163, 0).a();
          return;
        }
        if (AudioUtil.a(1))
        {
          ((IPttUtils)QRoute.api(IPttUtils.class)).showDialogAboutMeizuRecordPermission((Context)localObject1);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopHWVoiceController", 2, "startRecord() is called");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder == null) {
          this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).createQQRecorder((Context)localObject1);
        }
        localObject2 = new RecordParams.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
        paramString = TransFileUtil.getTransferFilePath(paramString, null, 2, null);
        this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a((RecordParams.RecorderParam)localObject2);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("path: ");
          ((StringBuilder)localObject2).append(paramString);
          QLog.i("QQRecorder", 2, ((StringBuilder)localObject2).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a(this);
        QQAudioUtils.a((Context)localObject1, true);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("QQRecorder start() is called,time is:");
          ((StringBuilder)localObject1).append(System.currentTimeMillis());
          QLog.d("TroopHWVoiceController", 2, ((StringBuilder)localObject1).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.b(paramString);
        return;
      }
      QQToast.a(BaseApplication.getContext(), 2131718577, 0).a();
      return;
    }
    QQToast.a(BaseApplication.getContext(), 2131694487, 0).a();
  }
  
  public int onBeginReceiveData(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_Int -= 200;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, this.jdField_a_of_type_Int);
    return this.jdField_a_of_type_Int + 200;
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam) {}
  
  public void onInitSuccess() {}
  
  public void onRecorderAbnormal(String paramString, RecordParams.RecorderParam paramRecorderParam) {}
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(paramString);
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController$RecordCallback.a(paramString, paramDouble);
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).cancelBufferTask(paramString1);
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController$RecordCallback.b();
  }
  
  public void onRecorderNotReady(String paramString) {}
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    paramRecorderParam = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).createBufferTask(paramString);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramRecorderParam, paramRecorderParam.length);
    AudioUtil.b(2131230749, false);
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramArrayOfByte, paramInt1);
  }
  
  public int onRecorderStart()
  {
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController$RecordCallback.a();
    return 250;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWVoiceController
 * JD-Core Version:    0.7.0.1
 */