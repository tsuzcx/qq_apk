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
import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
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
  implements QQRecorder.OnQQRecorderListener, VoicePlayer.VoicePlayerListener
{
  public static String a;
  public static String b;
  public static String c = "record_local_path";
  public static String d = "shard_pref_name";
  public int a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler = new TroopHWVoiceController.2(this);
  private QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
  private TroopHWVoiceController.RecordCallback jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController$RecordCallback;
  protected WeakReference<Context> a;
  private int b;
  private String e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "record_status";
    jdField_b_of_type_JavaLangString = "record_url";
  }
  
  public TroopHWVoiceController(Context paramContext, TroopHWVoiceController.RecordCallback paramRecordCallback)
  {
    this.jdField_a_of_type_Int = 360000;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController$RecordCallback = paramRecordCallback;
  }
  
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences(d, 0);
  }
  
  private boolean b()
  {
    if (QQServiceForAV.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHWVoiceController", 2, "VideoProcessAlive");
      }
      return true;
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return false;
    }
    Object localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    do
    {
      return;
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localObject == null);
    this.jdField_a_of_type_AndroidContentSharedPreferences = a((Context)localObject);
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).remove(paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    Context localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext == null) {
      return null;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = a(localContext);
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getString(paramString, null);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 200L);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) {
      return;
    }
    Handler localHandler = new Handler();
    if (paramString.endsWith("amr")) {}
    for (int i = 0;; i = 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(paramString, localHandler, i);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(BaseApplication.getContext());
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
      return;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    a();
    if (this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController$RecordCallback == null) {
      return;
    }
    if (this.jdField_b_of_type_Int > 0)
    {
      this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController$RecordCallback.b(this.jdField_b_of_type_Int, paramString);
      this.jdField_b_of_type_Int = 0;
      return;
    }
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController$RecordCallback.a(3, this.e);
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
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.f();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
      return true;
    }
    return false;
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    do
    {
      return;
      localObject = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localObject == null);
    this.jdField_a_of_type_AndroidContentSharedPreferences = a((Context)localObject);
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    ((SharedPreferences.Editor)localObject).putString(this.e, paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null) {
      return;
    }
    Handler localHandler = new Handler();
    if (paramString.endsWith("amr")) {}
    for (int i = 0;; i = 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(paramString, localHandler, i);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(BaseApplication.getContext());
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
      return;
    }
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    Context localContext;
    do
    {
      return;
      localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localContext == null);
    Object localObject = Environment.getExternalStorageDirectory();
    int i;
    if ((((File)localObject).exists()) && (((File)localObject).canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label115;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1)
        {
          if (b())
          {
            QQToast.a(BaseApplication.getContext(), 2131695173, 0).a();
            return;
            i = 0;
            break;
            label115:
            i = 0;
            continue;
          }
          if (AudioHelper.b(1))
          {
            ChatActivityUtils.a(localContext);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopHWVoiceController", 2, "startRecord() is called");
          }
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
            this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(localContext);
          }
          localObject = new RecordParams.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
          paramString = BuddyTransfileProcessor.getTransferFilePath(paramString, null, 2, null);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a((RecordParams.RecorderParam)localObject);
          if (QLog.isColorLevel()) {
            QLog.i("QQRecorder", 2, "path: " + paramString);
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this);
          QQAudioUtils.a(localContext, true);
          if (QLog.isColorLevel()) {
            QLog.d("TroopHWVoiceController", 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b(paramString);
          return;
        }
        QQToast.a(BaseApplication.getContext(), 2131718862, 0).a();
        return;
      }
    }
    QQToast.a(BaseApplication.getContext(), 2131694522, 0).a();
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
    PttBuffer.b(paramString);
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController$RecordCallback.a(paramString, paramDouble);
  }
  
  public void onRecorderError(String paramString1, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    PttBuffer.a(paramString1);
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController$RecordCallback.c();
  }
  
  public void onRecorderNotReady(String paramString) {}
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    paramRecorderParam = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
    PttBuffer.a(paramString);
    PttBuffer.a(paramString, paramRecorderParam, paramRecorderParam.length);
    AudioUtil.b(2131230745, false);
  }
  
  public void onRecorderSilceEnd(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    PttBuffer.a(paramString, paramArrayOfByte, paramInt1);
  }
  
  public int onRecorderStart()
  {
    this.jdField_a_of_type_CooperationTroop_homeworkJspTroopHWVoiceController$RecordCallback.b();
    return 250;
  }
  
  public void onRecorderVolumeStateChanged(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.troop_homework.jsp.TroopHWVoiceController
 * JD-Core Version:    0.7.0.1
 */