package com.tencent.mobileqq.winkpublish.service.video;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants.RemoteHandleConst;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.mobileqq.winkpublish.common.UploadConstants;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.FileUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

public class PublishVideoPluginService
  extends Service
{
  private static final String a;
  private static long b = 0L;
  private static long c = 0L;
  private static volatile int d = 0;
  private static volatile boolean e = false;
  private static Messenger f = null;
  private static boolean g = false;
  private static volatile boolean h;
  private static List<Message> i = new ArrayList();
  private static String j;
  private static boolean k;
  private static String l = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "VideoGifComposeFail", "gif合成失败");
  private static String m = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "VideoComposeSuccess", "合成视频成功");
  private static String n = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "VideoComposeFail", "合成视频失败!");
  private static String o = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "VideoTrimFailMessage", "裁剪错误:");
  private static String p = QzoneConfig.getInstance().getConfig("QZoneTextSetting", "VideoTrimSuccessMessage", "裁剪视频成功");
  private static Handler q = new PublishVideoPluginService.1();
  private static PublishVideoPluginService.CPUMonitorRunnable r = new PublishVideoPluginService.CPUMonitorRunnable();
  private static Handler s = new PublishVideoPluginService.2();
  private static Messenger t = new Messenger(q);
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("[upload2]FSVideoPluginService");
    a = localStringBuilder.toString();
  }
  
  public static boolean a()
  {
    return g;
  }
  
  /* Error */
  public static int b()
  {
    // Byte code:
    //   0: ldc 159
    //   2: fstore_1
    //   3: new 161	java/io/BufferedReader
    //   6: dup
    //   7: new 163	java/io/InputStreamReader
    //   10: dup
    //   11: new 165	java/io/FileInputStream
    //   14: dup
    //   15: ldc 167
    //   17: invokespecial 170	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   20: invokespecial 173	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   23: sipush 1000
    //   26: invokespecial 176	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   29: astore 8
    //   31: fload_1
    //   32: fstore_0
    //   33: aload 8
    //   35: astore 7
    //   37: aload 8
    //   39: invokevirtual 179	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore 9
    //   44: aload 9
    //   46: ifnonnull +26 -> 72
    //   49: aload 8
    //   51: invokevirtual 182	java/io/BufferedReader:close	()V
    //   54: iconst_0
    //   55: ireturn
    //   56: astore 7
    //   58: getstatic 55	com/tencent/mobileqq/winkpublish/service/video/PublishVideoPluginService:a	Ljava/lang/String;
    //   61: iconst_1
    //   62: aload 7
    //   64: invokevirtual 183	java/lang/Exception:toString	()Ljava/lang/String;
    //   67: invokestatic 189	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: iconst_0
    //   71: ireturn
    //   72: fload_1
    //   73: fstore_0
    //   74: aload 8
    //   76: astore 7
    //   78: aload 9
    //   80: ldc 191
    //   82: invokevirtual 197	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   85: astore 9
    //   87: fload_1
    //   88: fstore_0
    //   89: aload 8
    //   91: astore 7
    //   93: aload 9
    //   95: iconst_2
    //   96: aaload
    //   97: invokestatic 203	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   100: aload 9
    //   102: iconst_3
    //   103: aaload
    //   104: invokestatic 203	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   107: ladd
    //   108: aload 9
    //   110: iconst_4
    //   111: aaload
    //   112: invokestatic 203	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   115: ladd
    //   116: lstore_3
    //   117: fload_1
    //   118: fstore_0
    //   119: aload 8
    //   121: astore 7
    //   123: aload 9
    //   125: iconst_5
    //   126: aaload
    //   127: invokestatic 203	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   130: lstore 5
    //   132: fload_1
    //   133: fstore_0
    //   134: aload 8
    //   136: astore 7
    //   138: lload_3
    //   139: getstatic 57	com/tencent/mobileqq/winkpublish/service/video/PublishVideoPluginService:b	J
    //   142: lsub
    //   143: l2f
    //   144: fstore_2
    //   145: fload_1
    //   146: fstore_0
    //   147: aload 8
    //   149: astore 7
    //   151: lload_3
    //   152: getstatic 57	com/tencent/mobileqq/winkpublish/service/video/PublishVideoPluginService:b	J
    //   155: lsub
    //   156: lload 5
    //   158: ladd
    //   159: getstatic 59	com/tencent/mobileqq/winkpublish/service/video/PublishVideoPluginService:c	J
    //   162: lsub
    //   163: l2f
    //   164: fstore_1
    //   165: fload_1
    //   166: fstore_0
    //   167: aload 8
    //   169: astore 7
    //   171: fload_2
    //   172: ldc 204
    //   174: fmul
    //   175: fload_1
    //   176: fdiv
    //   177: fstore_1
    //   178: fload_1
    //   179: fstore_0
    //   180: aload 8
    //   182: astore 7
    //   184: lload_3
    //   185: putstatic 57	com/tencent/mobileqq/winkpublish/service/video/PublishVideoPluginService:b	J
    //   188: fload_1
    //   189: fstore_0
    //   190: aload 8
    //   192: astore 7
    //   194: lload 5
    //   196: putstatic 59	com/tencent/mobileqq/winkpublish/service/video/PublishVideoPluginService:c	J
    //   199: fload_1
    //   200: fstore_2
    //   201: aload 8
    //   203: invokevirtual 182	java/io/BufferedReader:close	()V
    //   206: goto +74 -> 280
    //   209: astore 7
    //   211: getstatic 55	com/tencent/mobileqq/winkpublish/service/video/PublishVideoPluginService:a	Ljava/lang/String;
    //   214: iconst_1
    //   215: aload 7
    //   217: invokevirtual 183	java/lang/Exception:toString	()Ljava/lang/String;
    //   220: invokestatic 189	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: fload_2
    //   224: fstore_1
    //   225: goto +55 -> 280
    //   228: astore 9
    //   230: goto +18 -> 248
    //   233: astore 7
    //   235: aconst_null
    //   236: astore 8
    //   238: goto +57 -> 295
    //   241: astore 9
    //   243: aconst_null
    //   244: astore 8
    //   246: fload_1
    //   247: fstore_0
    //   248: aload 8
    //   250: astore 7
    //   252: getstatic 55	com/tencent/mobileqq/winkpublish/service/video/PublishVideoPluginService:a	Ljava/lang/String;
    //   255: iconst_1
    //   256: aload 9
    //   258: invokevirtual 205	java/io/IOException:toString	()Ljava/lang/String;
    //   261: invokestatic 189	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: fload_0
    //   265: fstore_1
    //   266: aload 8
    //   268: ifnull +12 -> 280
    //   271: fload_0
    //   272: fstore_2
    //   273: aload 8
    //   275: invokevirtual 182	java/io/BufferedReader:close	()V
    //   278: fload_0
    //   279: fstore_1
    //   280: fload_1
    //   281: invokestatic 211	java/lang/Math:round	(F)I
    //   284: ireturn
    //   285: astore 9
    //   287: aload 7
    //   289: astore 8
    //   291: aload 9
    //   293: astore 7
    //   295: aload 8
    //   297: ifnull +25 -> 322
    //   300: aload 8
    //   302: invokevirtual 182	java/io/BufferedReader:close	()V
    //   305: goto +17 -> 322
    //   308: astore 8
    //   310: getstatic 55	com/tencent/mobileqq/winkpublish/service/video/PublishVideoPluginService:a	Ljava/lang/String;
    //   313: iconst_1
    //   314: aload 8
    //   316: invokevirtual 183	java/lang/Exception:toString	()Ljava/lang/String;
    //   319: invokestatic 189	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: aload 7
    //   324: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	247	0	f1	float
    //   2	279	1	f2	float
    //   144	129	2	f3	float
    //   116	69	3	l1	long
    //   130	65	5	l2	long
    //   35	1	7	localObject1	Object
    //   56	7	7	localException1	Exception
    //   76	117	7	localObject2	Object
    //   209	7	7	localException2	Exception
    //   233	1	7	localObject3	Object
    //   250	73	7	localObject4	Object
    //   29	272	8	localObject5	Object
    //   308	7	8	localException3	Exception
    //   42	82	9	localObject6	Object
    //   228	1	9	localIOException1	java.io.IOException
    //   241	16	9	localIOException2	java.io.IOException
    //   285	7	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   49	54	56	java/lang/Exception
    //   201	206	209	java/lang/Exception
    //   273	278	209	java/lang/Exception
    //   37	44	228	java/io/IOException
    //   78	87	228	java/io/IOException
    //   93	117	228	java/io/IOException
    //   123	132	228	java/io/IOException
    //   138	145	228	java/io/IOException
    //   151	165	228	java/io/IOException
    //   171	178	228	java/io/IOException
    //   184	188	228	java/io/IOException
    //   194	199	228	java/io/IOException
    //   3	31	233	finally
    //   3	31	241	java/io/IOException
    //   37	44	285	finally
    //   78	87	285	finally
    //   93	117	285	finally
    //   123	132	285	finally
    //   138	145	285	finally
    //   151	165	285	finally
    //   171	178	285	finally
    //   184	188	285	finally
    //   194	199	285	finally
    //   252	264	285	finally
    //   300	305	308	java/lang/Exception
  }
  
  private static void b(Message paramMessage)
  {
    Object localObject1 = (Intent)paramMessage.obj;
    paramMessage = ((Intent)localObject1).getStringExtra("video_source_path");
    int i1 = ((Intent)localObject1).getIntExtra("video_type", -1);
    j = ((Intent)localObject1).getStringExtra("client_key");
    int i2 = ((Intent)localObject1).getIntExtra("retry_num", 0);
    boolean bool1 = ((Intent)localObject1).getBooleanExtra("noDeleteFile", false);
    k = ((Intent)localObject1).getBooleanExtra("video_is_generate_gif", false);
    ((Intent)localObject1).getBooleanExtra(QCircleHostConstants.RemoteHandleConst.VIDEO_PARAM_ISUPLOADORIGIN(), false);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("START BUILD_VIDEO, sourcePath=");
    ((StringBuilder)localObject2).append(paramMessage);
    ((StringBuilder)localObject2).append(", type=");
    ((StringBuilder)localObject2).append(i1);
    ((StringBuilder)localObject2).append(", cacheKey=");
    ((StringBuilder)localObject2).append(j);
    ((StringBuilder)localObject2).append(", retryNum=");
    ((StringBuilder)localObject2).append(i2);
    ((StringBuilder)localObject2).append(", isGenerateGif=");
    ((StringBuilder)localObject2).append(k);
    QLog.i("[upload2][compress]", 1, ((StringBuilder)localObject2).toString());
    if (i1 == 1)
    {
      localObject2 = Message.obtain();
      ((Message)localObject2).what = 1;
      ((Message)localObject2).getData().putString("client_key", j);
      s.sendMessage((Message)localObject2);
      long l1 = ((Intent)localObject1).getLongExtra("start_time", -1L);
      long l2 = ((Intent)localObject1).getLongExtra("end_time", -1L);
      boolean bool2 = ((Intent)localObject1).getBooleanExtra("need_origin", false);
      long l3 = ((Intent)localObject1).getLongExtra("video_total_duration", -1L);
      QCircleHostQzoneThreadHelper.postVideoThread(new TrimVideoThread(MobileQQ.sMobileQQ, s, paramMessage, l1, l2, l3, j, bool2, i2, bool1, ((Intent)localObject1).getBooleanExtra("video_is_sync_to_weishi", false), ((Intent)localObject1).getBooleanExtra("video_is_use_qcircle_rate", false)));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("START BUILD_VIDEO FOR TRIM, sourcePath=");
      ((StringBuilder)localObject1).append(paramMessage);
      ((StringBuilder)localObject1).append(", type=");
      ((StringBuilder)localObject1).append(i1);
      ((StringBuilder)localObject1).append(", cacheKey=");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append(", retryNum=");
      ((StringBuilder)localObject1).append(i2);
      ((StringBuilder)localObject1).append(", isGenerateGif=");
      ((StringBuilder)localObject1).append(k);
      QLog.i("[upload2][compress]", 1, ((StringBuilder)localObject1).toString());
    }
  }
  
  private static void b(Message paramMessage, String paramString)
  {
    paramMessage = new Intent();
    paramMessage.putExtra("client_key", paramString);
    paramString = Message.obtain();
    paramString.what = 1003;
    paramString.obj = paramMessage;
    try
    {
      f.send(paramString);
      return;
    }
    catch (Exception paramMessage)
    {
      QLog.e(a, 1, "MSG_WHAT_TRIM_START sendMessageToClient", paramMessage);
    }
  }
  
  private static void b(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sendMessageToClient, source path=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", clientKey=");
    ((StringBuilder)localObject).append(paramString4);
    ((StringBuilder)localObject).append(" dstPath=");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" errMsg=");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append(" target=");
    ((StringBuilder)localObject).append(paramString4);
    QLog.i("[upload2][compress]", 1, ((StringBuilder)localObject).toString());
    if (f == null)
    {
      QLog.e("[upload2][compress]", 1, "no connection is active");
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("video_source_path", paramString1);
    ((Intent)localObject).putExtra("video_handle_result", paramBoolean);
    ((Intent)localObject).putExtra("video_dest_path", paramString2);
    ((Intent)localObject).putExtra("video_error_msg", paramString3);
    ((Intent)localObject).putExtra("client_key", paramString4);
    long l1 = FileUtils.getFileSize(paramString1);
    long l2 = FileUtils.getFileSize(paramString2);
    paramString1 = a;
    paramString2 = new StringBuilder();
    paramString2.append("video file size srcLen=");
    paramString2.append(l1);
    paramString2.append(",dstLen=");
    paramString2.append(l2);
    QLog.i(paramString1, 1, paramString2.toString());
    paramString1 = Message.obtain();
    paramString1.what = 1000;
    paramString1.obj = localObject;
    try
    {
      f.send(paramString1);
      QLog.e("[upload2][compress]", 1, "send to client success");
    }
    catch (Exception paramString1)
    {
      QLog.e("[upload2][compress]", 1, "sendMessageToClient error", paramString1);
    }
    if (i.size() > 0)
    {
      b((Message)i.remove(0));
      return;
    }
    h = false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onBind, uin=");
    localStringBuilder.append(paramIntent.getStringExtra("qzone_uin"));
    QLog.i(str, 1, localStringBuilder.toString());
    g = true;
    return t.getBinder();
  }
  
  public void onCreate()
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCreate, thread=");
    localStringBuilder.append(Thread.currentThread().getName());
    QLog.i(str, 1, localStringBuilder.toString());
    super.onCreate();
  }
  
  public void onDestroy()
  {
    QLog.i(a, 1, "onDestroy");
    super.onDestroy();
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    QLog.i(a, 1, "onUnbind");
    f = null;
    g = false;
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.service.video.PublishVideoPluginService
 * JD-Core Version:    0.7.0.1
 */