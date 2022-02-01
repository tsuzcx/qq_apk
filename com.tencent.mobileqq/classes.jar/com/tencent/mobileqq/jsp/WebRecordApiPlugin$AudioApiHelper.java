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
  private double jdField_a_of_type_Double;
  int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler = new WebRecordApiPlugin.AudioApiHelper.1(this, Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  protected WebRecordApiPlugin.AudioUploadTask a;
  private IQQRecorder jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private int b = 1;
  private int c = 60000;
  
  public WebRecordApiPlugin$AudioApiHelper(WebRecordApiPlugin paramWebRecordApiPlugin, AppInterface paramAppInterface, QBaseActivity paramQBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioUploadTask = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
  }
  
  private int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  /* Error */
  private String a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: lconst_1
    //   3: invokestatic 71	java/lang/Thread:sleep	(J)V
    //   6: goto +12 -> 18
    //   9: astore_3
    //   10: goto +37 -> 47
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 74	java/lang/InterruptedException:printStackTrace	()V
    //   18: invokestatic 80	java/lang/System:currentTimeMillis	()J
    //   21: lstore_1
    //   22: new 82	java/text/SimpleDateFormat
    //   25: dup
    //   26: ldc 84
    //   28: invokespecial 87	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   31: new 89	java/util/Date
    //   34: dup
    //   35: lload_1
    //   36: invokespecial 91	java/util/Date:<init>	(J)V
    //   39: invokevirtual 95	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
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
    //   21	15	1	l	long
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
    Object localObject3 = a();
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
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void d(String paramString)
  {
    Object localObject = new Time();
    ((Time)localObject).setToNow();
    if (((Time)localObject).hour < 3) {
      return;
    }
    localObject = SharePreferenceUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "LAST_DELETE_TIME");
    String str = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
    if ((localObject != null) && (str.equals(localObject))) {
      return;
    }
    ThreadManager.post(new WebRecordApiPlugin.AudioApiHelper.2(this, paramString), 8, null, false);
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    if ((localObject != null) && (!((IQQRecorder)localObject).b()) && (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(16711687);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("stopRecord() is called,time is:");
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        QLog.d("WebRecordApiPlugin", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder != null)
      {
        localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(16711686);
        this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 200L);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) || (paramInt1 == 0)) {
      this.b = paramInt1;
    }
    if (paramInt2 > 0)
    {
      paramInt1 = paramInt2 * 1000;
      if (paramInt1 < this.c) {
        this.c = paramInt1;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    if ((localObject != null) && (((IQQRecorder)localObject).a()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
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
      localObject = DeviceInfoUtil.b();
      if ((new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1) && (localObject != null) && (localObject[1] > 2L))
      {
        if (AudioUtil.a(1))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
          str = WebRecordApiPlugin.b((WebRecordApiPlugin)localObject);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("{'code':-1,'recordID':'-1','msg':'");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131698521));
          localStringBuilder.append(",");
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131698522));
          localStringBuilder.append("'}");
          ((WebRecordApiPlugin)localObject).callJs(str, new String[] { localStringBuilder.toString() });
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("WebRecordApiPlugin", 2, "startRecord() is called");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder == null) {
          this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).createQQRecorder(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
        ((StringBuilder)localObject).append("webrecord/");
        d(((StringBuilder)localObject).toString());
        if (this.b == 0)
        {
          localObject = new RecordParams.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
          this.jdField_a_of_type_JavaLangString = a(2, true);
        }
        else
        {
          localObject = new RecordParams.RecorderParam(RecordParams.b, 16000, 1);
          this.jdField_a_of_type_JavaLangString = a(25, true);
        }
        this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a((RecordParams.RecorderParam)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("path: ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
          QLog.i("QQRecorder", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.a(this);
        QQAudioUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, true);
        this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder.b(this.jdField_a_of_type_JavaLangString);
        b(0);
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
      str = WebRecordApiPlugin.b((WebRecordApiPlugin)localObject);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("{'code':-1,'recordID':'-1','msg':'");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131718577));
      localStringBuilder.append("'}");
      ((WebRecordApiPlugin)localObject).callJs(str, new String[] { localStringBuilder.toString() });
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
    String str = WebRecordApiPlugin.b((WebRecordApiPlugin)localObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{'code':-1,'recordID':'-1','msg':'");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131694487));
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
    if ((((File)localObject1).exists()) && (SharePreferenceUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramString) != null))
    {
      double d = Double.valueOf(SharePreferenceUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramString)).doubleValue();
      long l;
      if (((File)localObject1).exists()) {
        l = ((File)localObject1).length();
      } else {
        l = 0L;
      }
      localObject1 = new AudioInfo(paramString, (int)d, l);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
      if (localObject2 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(((AudioInfo)localObject1).path, new Handler(), ((AudioInfo)localObject1).getAudioType());
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
      }
      else
      {
        ((VoicePlayer)localObject2).c();
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
      localObject2 = WebRecordApiPlugin.c((WebRecordApiPlugin)localObject1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("{'code':0,'recordID':'");
      localStringBuilder.append(paramString);
      localStringBuilder.append("'}");
      ((WebRecordApiPlugin)localObject1).callJs((String)localObject2, new String[] { localStringBuilder.toString() });
      return;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
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
    int i = 0;
    while (i < paramJSONArray.length())
    {
      Object localObject1 = paramJSONArray.optString(i, "");
      Object localObject2 = new File((String)localObject1);
      String str = SharePreferenceUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, (String)localObject1);
      if ((((File)localObject2).exists()) && (!TextUtils.isEmpty(str)))
      {
        double d = Double.valueOf(str).doubleValue();
        localObject2 = new File((String)localObject1);
        long l;
        if (((File)localObject2).exists()) {
          l = ((File)localObject2).length();
        } else {
          l = 0L;
        }
        localObject1 = new AudioInfo((String)localObject1, (int)d, l);
        this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioUploadTask = new WebRecordApiPlugin.AudioUploadTask(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_AndroidOsHandler, paramString1, paramString2, (AudioInfo)localObject1);
        ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin$AudioUploadTask, 5, null, true);
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
        str = WebRecordApiPlugin.a((WebRecordApiPlugin)localObject2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{'code':1,'recordID':'");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("','msg':'record not found or its duration is 0'}");
        ((WebRecordApiPlugin)localObject2).callJs(str, new String[] { localStringBuilder.toString() });
      }
      i += 1;
    }
  }
  
  public boolean a()
  {
    IQQRecorder localIQQRecorder = this.jdField_a_of_type_ComTencentMobileqqPttIQQRecorder;
    return (localIQQRecorder != null) && (localIQQRecorder.a());
  }
  
  public void b(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
    if (localObject != null)
    {
      ((VoicePlayer)localObject).e();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
      localObject = this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
    if (localObject != null)
    {
      ((VoicePlayer)localObject).d();
      localObject = this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
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
    this.c -= 200;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711687, this.c);
    return this.c + 200;
  }
  
  public void onInitFailed(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onInitFailed() is called");
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
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
    paramString = this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
    paramString.callJs(WebRecordApiPlugin.b(paramString), new String[] { "{'code':-1,'recordID':'-1','msg':'onRecorderAbnormal is called'}" });
  }
  
  public void onRecorderEnd(String paramString, RecordParams.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderEnd() is called");
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    int i = a();
    if (QLog.isColorLevel())
    {
      paramRecorderParam = new StringBuilder();
      paramRecorderParam.append("fateOfRecorder is:");
      paramRecorderParam.append(i);
      QLog.d("AIOAudioPanel", 2, paramRecorderParam.toString());
    }
    byte[] arrayOfByte;
    Object localObject;
    if (i == 0)
    {
      ((IPttBuffer)QRoute.api(IPttBuffer.class)).flush(paramString);
      SharePreferenceUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_JavaLangString, Double.toString(this.jdField_a_of_type_Double));
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
      paramRecorderParam = this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
      paramRecorderParam.callJs(WebRecordApiPlugin.b(paramRecorderParam), new String[] { paramString });
      return;
      if (i == 1) {
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
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
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
    paramString = this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
    paramString.callJs(WebRecordApiPlugin.b(paramString), new String[] { "{'code':-1,'recordID':'-1','msg':'onRecorderNotReady is called'}" });
  }
  
  public void onRecorderPrepare(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderPrepare() is called");
    }
    paramRecorderParam = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).createBufferTask(paramString);
    ((IPttBuffer)QRoute.api(IPttBuffer.class)).appendBuffer(paramString, paramRecorderParam, paramRecorderParam.length);
    AudioUtil.b(2131230749, false);
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
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public int onRecorderStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "AudioApiHelper.onRecorderStart() is called");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 2000L);
    this.jdField_a_of_type_Boolean = true;
    WebRecordApiPlugin localWebRecordApiPlugin = this.jdField_a_of_type_ComTencentMobileqqJspWebRecordApiPlugin;
    String str = WebRecordApiPlugin.b(localWebRecordApiPlugin);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{'code':0,'recordID':'");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.WebRecordApiPlugin.AudioApiHelper
 * JD-Core Version:    0.7.0.1
 */