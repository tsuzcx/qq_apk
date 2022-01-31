package com.tencent.qqmini.nativePlugins;

import android.content.Context;
import bgho;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;

public class LaunchCameraPlugin
  extends BaseJsPlugin
{
  private static final String APP_ID = "appId";
  private static final String DATA = "data";
  public static final String FILE_PATH = "file_path";
  private static final String FROM_TYPE = "from";
  public static final String IS_VIDEO = "is_video";
  public static final String MINI_BACK_FROM_NATIVE = "com.tencent.mobileqq.mini.out.nativePlugins.native_back";
  public static final String MINI_LAUNCH_AE_APP_ID = "mini_launch_ae_app_id";
  public static final String MINI_LAUNCH_CAMERA = "com.tencent.mobileqq.mini.out.nativePlugins.mini_launch_camera";
  public static final String MINI_LAUNCH_TAG = "mini_launch_ae_tag";
  public static final String TAG = "LaunchCameraPlugin";
  public static final String THUMB_PATH = "video_thumb_path";
  public static final String VIDEO_DURATION = "video_duration";
  private LaunchCameraPlugin.NativeBackBroadCast broadCast;
  
  /* Error */
  public void checkinInvokeGYCamera(bgkd parambgkd)
  {
    // Byte code:
    //   0: new 68	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: getfield 73	bgkd:b	Ljava/lang/String;
    //   8: invokespecial 76	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 54	com/tencent/qqmini/nativePlugins/LaunchCameraPlugin:mMiniAppContext	Lbgho;
    //   16: invokeinterface 82 1 0
    //   21: ifnull +293 -> 314
    //   24: aload_0
    //   25: getfield 84	com/tencent/qqmini/nativePlugins/LaunchCameraPlugin:broadCast	Lcom/tencent/qqmini/nativePlugins/LaunchCameraPlugin$NativeBackBroadCast;
    //   28: ifnull +19 -> 47
    //   31: aload_0
    //   32: getfield 54	com/tencent/qqmini/nativePlugins/LaunchCameraPlugin:mMiniAppContext	Lbgho;
    //   35: invokeinterface 82 1 0
    //   40: aload_0
    //   41: getfield 84	com/tencent/qqmini/nativePlugins/LaunchCameraPlugin:broadCast	Lcom/tencent/qqmini/nativePlugins/LaunchCameraPlugin$NativeBackBroadCast;
    //   44: invokevirtual 90	android/content/Context:unregisterReceiver	(Landroid/content/BroadcastReceiver;)V
    //   47: aload_3
    //   48: ldc 11
    //   50: invokevirtual 94	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   53: astore 6
    //   55: new 96	android/os/Bundle
    //   58: dup
    //   59: invokespecial 97	android/os/Bundle:<init>	()V
    //   62: astore 5
    //   64: aload 6
    //   66: ifnonnull +27 -> 93
    //   69: ldc 35
    //   71: iconst_1
    //   72: ldc 99
    //   74: invokestatic 105	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_1
    //   78: invokevirtual 108	bgkd:b	()Ljava/lang/String;
    //   81: pop
    //   82: return
    //   83: astore_1
    //   84: ldc 35
    //   86: ldc 110
    //   88: aload_1
    //   89: invokestatic 115	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   92: return
    //   93: ldc 35
    //   95: iconst_1
    //   96: new 117	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   103: ldc 120
    //   105: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload 6
    //   110: invokevirtual 127	org/json/JSONObject:toString	()Ljava/lang/String;
    //   113: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 131	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: ldc 133
    //   124: astore_3
    //   125: getstatic 138	bkwm:a	Lbkwm;
    //   128: invokevirtual 141	bkwm:a	()I
    //   131: istore_2
    //   132: ldc 133
    //   134: astore 4
    //   136: aload 6
    //   138: ldc 8
    //   140: invokevirtual 145	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   143: ifeq +11 -> 154
    //   146: aload 6
    //   148: ldc 8
    //   150: invokevirtual 149	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   153: astore_3
    //   154: aload 6
    //   156: ldc 17
    //   158: invokevirtual 145	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   161: ifeq +17 -> 178
    //   164: aload 6
    //   166: ldc 17
    //   168: invokevirtual 149	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   171: invokestatic 152	bkwm:a	(Ljava/lang/String;)Lbkwm;
    //   174: invokevirtual 141	bkwm:a	()I
    //   177: istore_2
    //   178: aload 6
    //   180: ldc 154
    //   182: invokevirtual 145	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   185: ifeq +12 -> 197
    //   188: aload 6
    //   190: ldc 154
    //   192: invokevirtual 149	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   195: astore 4
    //   197: aload 5
    //   199: ldc 156
    //   201: iload_2
    //   202: invokevirtual 160	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   205: aload 5
    //   207: ldc 154
    //   209: aload 4
    //   211: invokevirtual 163	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: aload_0
    //   215: getfield 54	com/tencent/qqmini/nativePlugins/LaunchCameraPlugin:mMiniAppContext	Lbgho;
    //   218: invokeinterface 82 1 0
    //   223: ldc 32
    //   225: iconst_0
    //   226: invokevirtual 167	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   229: invokeinterface 173 1 0
    //   234: ldc 26
    //   236: aload_3
    //   237: invokeinterface 178 3 0
    //   242: invokeinterface 181 1 0
    //   247: invokestatic 187	com/tencent/mobileqq/qipc/QIPCClientHelper:getInstance	()Lcom/tencent/mobileqq/qipc/QIPCClientHelper;
    //   250: ldc 189
    //   252: ldc 29
    //   254: aload 5
    //   256: aconst_null
    //   257: invokevirtual 193	com/tencent/mobileqq/qipc/QIPCClientHelper:callServer	(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Leipc/EIPCResultCallback;)V
    //   260: aload_1
    //   261: invokevirtual 195	bgkd:a	()Ljava/lang/String;
    //   264: pop
    //   265: aload_0
    //   266: getfield 54	com/tencent/qqmini/nativePlugins/LaunchCameraPlugin:mMiniAppContext	Lbgho;
    //   269: invokeinterface 82 1 0
    //   274: astore_1
    //   275: new 197	com/tencent/qqmini/nativePlugins/LaunchCameraPlugin$NativeBackBroadCast
    //   278: dup
    //   279: aload_0
    //   280: aconst_null
    //   281: invokespecial 200	com/tencent/qqmini/nativePlugins/LaunchCameraPlugin$NativeBackBroadCast:<init>	(Lcom/tencent/qqmini/nativePlugins/LaunchCameraPlugin;Lcom/tencent/qqmini/nativePlugins/LaunchCameraPlugin$1;)V
    //   284: astore_3
    //   285: aload_0
    //   286: aload_3
    //   287: putfield 84	com/tencent/qqmini/nativePlugins/LaunchCameraPlugin:broadCast	Lcom/tencent/qqmini/nativePlugins/LaunchCameraPlugin$NativeBackBroadCast;
    //   290: aload_1
    //   291: aload_3
    //   292: new 202	android/content/IntentFilter
    //   295: dup
    //   296: ldc 23
    //   298: invokespecial 203	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   301: invokevirtual 207	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   304: pop
    //   305: return
    //   306: astore_3
    //   307: aload_3
    //   308: invokevirtual 210	org/json/JSONException:printStackTrace	()V
    //   311: goto -64 -> 247
    //   314: ldc 35
    //   316: ldc 212
    //   318: invokestatic 214	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: return
    //   322: astore 4
    //   324: goto -277 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	LaunchCameraPlugin
    //   0	327	1	parambgkd	bgkd
    //   131	71	2	i	int
    //   11	281	3	localObject	java.lang.Object
    //   306	2	3	localJSONException	org.json.JSONException
    //   134	76	4	str	String
    //   322	1	4	localThrowable	Throwable
    //   62	193	5	localBundle	android.os.Bundle
    //   53	136	6	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	12	83	org/json/JSONException
    //   69	82	306	org/json/JSONException
    //   93	122	306	org/json/JSONException
    //   125	132	306	org/json/JSONException
    //   136	154	306	org/json/JSONException
    //   154	178	306	org/json/JSONException
    //   178	197	306	org/json/JSONException
    //   197	247	306	org/json/JSONException
    //   31	47	322	java/lang/Throwable
  }
  
  public void onDestroy()
  {
    if ((this.mMiniAppContext.a() != null) && (this.broadCast != null)) {}
    try
    {
      this.mMiniAppContext.a().unregisterReceiver(this.broadCast);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.nativePlugins.LaunchCameraPlugin
 * JD-Core Version:    0.7.0.1
 */