package com.tencent.mobileqq.identification;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQIdentiferActivity;
import com.tencent.mobileqq.qqconnectface.api.ICamera;
import com.tencent.mobileqq.qqconnectface.impl.FaceCameraProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.common.YtCameraSetting;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKKitFrameworkWorkMode;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtSDKPlatformContext;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IdentificationPoseReflect
  extends IdentificationBaseModel
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private AppConf jdField_a_of_type_ComTencentMobileqqIdentificationAppConf;
  
  public IdentificationPoseReflect(Intent paramIntent, RequestListener paramRequestListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqIdentificationRequestListener = paramRequestListener;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqIdentificationAppConf = ((FaceConf)paramIntent.getSerializableExtra("faceConf")).getAppConf();
  }
  
  private int a(JSONObject paramJSONObject)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqIdentificationAppConf != null) && (this.jdField_a_of_type_ComTencentMobileqqIdentificationAppConf.actionReq != null))
      {
        if (paramJSONObject == null)
        {
          QLog.e("qq_Identification.Model", 1, "initAppConf, sdk config is null");
          return 1004;
        }
        JSONArray localJSONArray = new JSONArray();
        int[] arrayOfInt = this.jdField_a_of_type_ComTencentMobileqqIdentificationAppConf.actionReq;
        int j = arrayOfInt.length;
        int i = 0;
        while (i < j)
        {
          localJSONArray.put(arrayOfInt[i]);
          i += 1;
        }
        paramJSONObject.put("action_default_seq", localJSONArray);
        paramJSONObject.put("color_data", this.jdField_a_of_type_ComTencentMobileqqIdentificationAppConf.colorSequence);
        paramJSONObject.put("select_data", new JSONObject(this.jdField_a_of_type_ComTencentMobileqqIdentificationAppConf.selectData));
        paramJSONObject.remove("timeout_countdown_ms");
        return 0;
      }
      return 1003;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("qq_Identification.Model", 1, "initAppConf JSONException : ", paramJSONObject);
    }
    return 1005;
  }
  
  private int a(JSONObject paramJSONObject, Context paramContext)
  {
    if (paramJSONObject == null) {}
    try
    {
      QLog.e("qq_Identification.Model", 1, "initYTResPath, sdk config is null");
      return 1004;
    }
    catch (JSONException paramJSONObject)
    {
      Object localObject;
      StringBuilder localStringBuilder;
      QLog.e("qq_Identification.Model", 1, "initYTResPath JSONException : ", paramJSONObject);
      return 1005;
    }
    paramContext = paramContext.getFilesDir().getAbsolutePath();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("/YT_identify_new/identification/tmp_video_path/tmp.mp4");
    localObject = ((StringBuilder)localObject).toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append("/YT_identify_new/identification/ytd");
    paramContext = localStringBuilder.toString();
    paramJSONObject.put("video_path", localObject);
    paramJSONObject.put("resource_download_path", paramContext);
    QLog.d("qq_Identification.Model", 1, new Object[] { "video path : ", localObject, " res path  : ", paramContext });
    paramContext = new File((String)localObject);
    localObject = paramContext.getParentFile();
    boolean bool;
    if ((localObject != null) && (!((File)localObject).exists())) {
      bool = ((File)localObject).mkdirs();
    }
    for (;;)
    {
      if (!bool) {
        paramJSONObject.remove("video_path");
      }
      if (paramContext.exists()) {
        paramContext.delete();
      }
      return 0;
      bool = true;
    }
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: ldc 45
    //   2: iconst_1
    //   3: iconst_2
    //   4: anewarray 127	java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: ldc 159
    //   11: aastore
    //   12: dup
    //   13: iconst_1
    //   14: aload_1
    //   15: aastore
    //   16: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   19: aconst_null
    //   20: astore_3
    //   21: new 109	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   28: astore 4
    //   30: new 161	java/io/BufferedReader
    //   33: dup
    //   34: new 163	java/io/InputStreamReader
    //   37: dup
    //   38: new 165	java/io/FileInputStream
    //   41: dup
    //   42: new 103	java/io/File
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: invokespecial 168	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 171	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   56: invokespecial 174	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   59: astore_2
    //   60: aload_2
    //   61: astore_1
    //   62: aload_2
    //   63: invokevirtual 177	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   66: astore_3
    //   67: aload_3
    //   68: ifnull +15 -> 83
    //   71: aload_2
    //   72: astore_1
    //   73: aload 4
    //   75: aload_3
    //   76: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: goto -20 -> 60
    //   83: aload_2
    //   84: astore_1
    //   85: aload 4
    //   87: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore_3
    //   91: aload_0
    //   92: aload_2
    //   93: invokespecial 180	com/tencent/mobileqq/identification/IdentificationPoseReflect:a	(Ljava/io/Closeable;)V
    //   96: aload_3
    //   97: areturn
    //   98: astore_3
    //   99: goto +16 -> 115
    //   102: astore_3
    //   103: goto +26 -> 129
    //   106: astore_2
    //   107: aload_3
    //   108: astore_1
    //   109: goto +39 -> 148
    //   112: astore_3
    //   113: aconst_null
    //   114: astore_2
    //   115: aload_2
    //   116: astore_1
    //   117: ldc 45
    //   119: iconst_1
    //   120: ldc 182
    //   122: aload_3
    //   123: invokestatic 92	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   126: goto +14 -> 140
    //   129: aload_2
    //   130: astore_1
    //   131: ldc 45
    //   133: iconst_1
    //   134: ldc 184
    //   136: aload_3
    //   137: invokestatic 92	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   140: aload_0
    //   141: aload_2
    //   142: invokespecial 180	com/tencent/mobileqq/identification/IdentificationPoseReflect:a	(Ljava/io/Closeable;)V
    //   145: aconst_null
    //   146: areturn
    //   147: astore_2
    //   148: aload_0
    //   149: aload_1
    //   150: invokespecial 180	com/tencent/mobileqq/identification/IdentificationPoseReflect:a	(Ljava/io/Closeable;)V
    //   153: goto +5 -> 158
    //   156: aload_2
    //   157: athrow
    //   158: goto -2 -> 156
    //   161: astore_3
    //   162: aconst_null
    //   163: astore_2
    //   164: goto -35 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	IdentificationPoseReflect
    //   0	167	1	paramString	String
    //   59	34	2	localBufferedReader	java.io.BufferedReader
    //   106	1	2	localObject1	Object
    //   114	28	2	localCloseable	Closeable
    //   147	10	2	localObject2	Object
    //   163	1	2	localObject3	Object
    //   20	77	3	str	String
    //   98	1	3	localIOException1	IOException
    //   102	6	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   112	25	3	localIOException2	IOException
    //   161	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   28	58	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   62	67	98	java/io/IOException
    //   73	80	98	java/io/IOException
    //   85	91	98	java/io/IOException
    //   62	67	102	java/io/FileNotFoundException
    //   73	80	102	java/io/FileNotFoundException
    //   85	91	102	java/io/FileNotFoundException
    //   21	60	106	finally
    //   21	60	112	java/io/IOException
    //   62	67	147	finally
    //   73	80	147	finally
    //   85	91	147	finally
    //   117	126	147	finally
    //   131	140	147	finally
    //   21	60	161	java/io/FileNotFoundException
  }
  
  private void a(QQIdentiferActivity paramQQIdentiferActivity, boolean paramBoolean, int paramInt)
  {
    a(new IdentificationPoseReflect.1(this, paramQQIdentiferActivity, paramBoolean, paramInt));
  }
  
  private void a(Closeable paramCloseable)
  {
    if (paramCloseable == null)
    {
      QLog.e("qq_Identification.Model", 1, "closeCloseable, closeable is null");
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      QLog.e("qq_Identification.Model", 1, "closeCloseable error : ", paramCloseable);
    }
  }
  
  protected int a(Activity paramActivity, ICamera paramICamera)
  {
    Camera localCamera = paramICamera.a();
    int i = paramICamera.a();
    try
    {
      i = YtCameraSetting.initCamera(paramActivity.getApplicationContext(), localCamera, i);
      return i;
    }
    catch (Exception paramActivity)
    {
      QLog.d("qq_Identification.Model", 1, new Object[] { "YTCameraSetting.initCamera error : ", paramActivity.getMessage() });
    }
    return -1;
  }
  
  public int a(Context paramContext, String paramString)
  {
    int i = a(paramString);
    QLog.d("qq_Identification.Model", 1, new Object[] { "initYTConfigJson result : ", Integer.valueOf(i) });
    if (i != 0) {
      return i;
    }
    paramString = YtSDKKit.a().a(5);
    i = a(paramString);
    if (i != 0)
    {
      QLog.e("qq_Identification.Model", 1, new Object[] { "initAppConf failed : ", Integer.valueOf(i) });
      return i;
    }
    i = a(paramString, paramContext);
    if (i != 0)
    {
      QLog.e("qq_Identification.Model", 1, new Object[] { "initYTResPath failed : ", Integer.valueOf(i) });
      return i;
    }
    QLog.d("qq_Identification.Model", 1, "initFaceResMode success");
    return 0;
  }
  
  protected int a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("identification/YtSDKSettings.json");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("identification/YtSDKUIConfig.json");
    paramString = localStringBuilder.toString();
    localObject = a((String)localObject);
    if (localObject == null)
    {
      QLog.e("qq_Identification.Model", 1, "get settingConfigJson error : null");
      return 1001;
    }
    paramString = a(paramString);
    if (paramString == null)
    {
      QLog.e("qq_Identification.Model", 1, "get uiConfigJson error : null");
      return 1002;
    }
    return YtSDKKit.a().a((String)localObject, paramString);
  }
  
  public void a()
  {
    super.a();
    YtSDKKitFramework.getInstance().deInit();
  }
  
  protected void a(Activity paramActivity, int paramInt)
  {
    a(new IdentificationPoseReflect.2(this, paramInt, paramActivity));
  }
  
  protected void a(Activity paramActivity, ICamera paramICamera)
  {
    YtSDKKitFramework.YtSDKPlatformContext localYtSDKPlatformContext = YtSDKKitFramework.getInstance().getPlatformContext();
    localYtSDKPlatformContext.currentCamera = paramICamera.a();
    int i = paramICamera.a();
    localYtSDKPlatformContext.currentCameraId = i;
    localYtSDKPlatformContext.currentRotateState = YtCameraSetting.getRotate(BaseApplication.getContext(), i, 1);
    localYtSDKPlatformContext.reflectLayout = null;
    localYtSDKPlatformContext.reflectListener = new IdentificationPoseReflect.QYTReflectListener(this, null);
    localYtSDKPlatformContext.currentAppContext = paramActivity.getApplicationContext();
    paramICamera = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE;
    JSONObject localJSONObject = YtSDKKit.a().a(5);
    ArrayList localArrayList = YtSDKKitConfigHelper.getPipleStateNames(paramICamera);
    if ((localArrayList != null) && (localJSONObject != null))
    {
      QLog.d("qq_Identification.Model", 1, new Object[] { "YtSDKKitFramework init result : ", Integer.valueOf(YtSDKKitFramework.getInstance().init(localYtSDKPlatformContext, localJSONObject, paramICamera, localArrayList, new IdentificationPoseReflect.QYtSDKEventListener(this))) });
      return;
    }
    if ((paramActivity instanceof QQIdentiferActivity)) {
      a((QQIdentiferActivity)paramActivity, false, 217);
    }
    QLog.e("qq_Identification.Model", 1, "initSdkResult stateNames == null || sdkConfig == null");
  }
  
  protected void a(Runnable paramRunnable)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      paramRunnable.run();
      return;
    }
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }
  
  @RequiresApi(api=18)
  public void a(boolean paramBoolean, Activity paramActivity)
  {
    if (!paramBoolean)
    {
      QLog.e("qq_Identification.Model", 1, "initSdkResult failed");
      return;
    }
    a(paramActivity, 255);
    FaceCameraProxy localFaceCameraProxy = new FaceCameraProxy();
    int i = a(paramActivity, localFaceCameraProxy);
    QLog.d("qq_Identification.Model", 1, new Object[] { "YTCameraSetting.initCamera result : ", Integer.valueOf(i) });
    if (i != 0)
    {
      if ((paramActivity instanceof QQIdentiferActivity)) {
        a((QQIdentiferActivity)paramActivity, false, 216);
      }
      return;
    }
    a(paramActivity, localFaceCameraProxy);
  }
  
  public boolean a(String paramString, String[] paramArrayOfString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("qq_Identification.Model", 1, "initLoadSo error : so path is empty");
      return false;
    }
    try
    {
      Object localObject = new File(paramString);
      if (!((File)localObject).exists())
      {
        QLog.e("qq_Identification.Model", 1, new Object[] { "init load so, soDir is not exists, so path : ", localObject });
        return false;
      }
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localObject = paramArrayOfString[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append((String)localObject);
        System.load(localStringBuilder.toString());
        i += 1;
      }
      QLog.d("qq_Identification.Model", 1, "init load so success");
      return true;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("System.load so UnsatisfiedLinkError : ");
      paramArrayOfString.append(paramString.getMessage());
      QLog.e("qq_Identification.Model", 1, paramArrayOfString.toString());
      return false;
    }
    catch (Exception paramString)
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("System.load so Exception : ");
      paramArrayOfString.append(paramString.getMessage());
      QLog.e("qq_Identification.Model", 1, paramArrayOfString.toString());
    }
    return false;
  }
  
  public boolean a(String[] paramArrayOfString)
  {
    try
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localObject = paramArrayOfString[i];
        System.loadLibrary((String)localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init load lib");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(".so success");
        QLog.d("qq_Identification.Model", 1, localStringBuilder.toString());
        i += 1;
      }
      QLog.d("qq_Identification.Model", 1, "init load so success");
      return true;
    }
    catch (UnsatisfiedLinkError paramArrayOfString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("System.load so UnsatisfiedLinkError : ");
      ((StringBuilder)localObject).append(paramArrayOfString.getMessage());
      QLog.e("qq_Identification.Model", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    catch (Exception paramArrayOfString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("System.load so Exception : ");
      ((StringBuilder)localObject).append(paramArrayOfString.getMessage());
      QLog.e("qq_Identification.Model", 1, ((StringBuilder)localObject).toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationPoseReflect
 * JD-Core Version:    0.7.0.1
 */