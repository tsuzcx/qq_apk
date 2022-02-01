package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.SystemFaceHandler;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.util.HashMap;
import mqq.app.MobileQQ;
import org.apache.http.Header;

public class EmotionDownloader
  extends AbsDownloader
  implements EmotionConstants
{
  public static final String REPORT_CODE = "system_face_decode_copyfile";
  private static final String TAG = "EmotionDownloader";
  static File emotionDir;
  static File rootFile;
  BaseApplicationImpl application;
  public final int exceptionErrorcode = 89500;
  public final int fileNotExistErrorcode = 89501;
  
  public EmotionDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.application = paramBaseApplicationImpl;
    rootFile = paramBaseApplicationImpl.getDir("", 0);
  }
  
  public static String getCurrentUin()
  {
    Object localObject = MobileQQ.sMobileQQ.getApplicationContext();
    int i;
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    } else {
      i = 0;
    }
    localObject = ((Context)localObject).getSharedPreferences("Last_Login", i).getString("uin", "");
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      return localObject;
    }
    return "10000";
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    try
    {
      if (paramFile.equals(rootFile))
      {
        paramFile = paramDownloadParams.getHeader("KEY_STATIC_DRAWABLE_ID");
        if (paramFile != null)
        {
          paramFile = paramFile.getValue();
          if (paramFile != null)
          {
            int i = Integer.valueOf(paramFile).intValue();
            return BitmapFactory.decodeResource(this.application.getResources(), i);
          }
        }
      }
      else
      {
        if (GifDrawable.isGifFile(paramFile)) {
          return NativeGifFactory.getNativeGifObject(paramFile, false);
        }
        paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
        return paramFile;
      }
    }
    catch (OutOfMemoryError paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmotionDownloader", 2, "decode file", paramFile);
      }
    }
    catch (Exception paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmotionDownloader", 2, "decode file", paramFile);
      }
    }
    return null;
  }
  
  /* Error */
  protected File downloadEmoticonImage(DownloadParams paramDownloadParams, SystemFaceHandler paramSystemFaceHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 166	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   4: invokevirtual 171	java/net/URL:getHost	()Ljava/lang/String;
    //   7: astore 7
    //   9: new 173	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   16: astore 8
    //   18: aload 8
    //   20: getstatic 176	com/tencent/mobileqq/transfile/EmotionDownloader:emotionDir	Ljava/io/File;
    //   23: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 8
    //   29: ldc 182
    //   31: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 8
    //   37: aload 7
    //   39: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: new 94	java/io/File
    //   46: dup
    //   47: aload 8
    //   49: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokespecial 191	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore 9
    //   57: aload 9
    //   59: invokevirtual 194	java/io/File:exists	()Z
    //   62: istore 6
    //   64: iconst_1
    //   65: istore 4
    //   67: iload 6
    //   69: ifeq +28 -> 97
    //   72: aload 9
    //   74: invokevirtual 197	java/io/File:length	()J
    //   77: lconst_0
    //   78: lcmp
    //   79: ifne +6 -> 85
    //   82: goto +15 -> 97
    //   85: aload_2
    //   86: ifnull +448 -> 534
    //   89: aload_2
    //   90: iconst_1
    //   91: invokevirtual 203	com/tencent/mobileqq/earlydownload/handler/SystemFaceHandler:d	(Z)V
    //   94: aload 9
    //   96: areturn
    //   97: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +76 -> 176
    //   103: new 173	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   110: astore 8
    //   112: aload 8
    //   114: ldc 205
    //   116: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 8
    //   122: aload_1
    //   123: getfield 208	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   126: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 8
    //   132: ldc 210
    //   134: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 8
    //   140: aload 7
    //   142: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 8
    //   148: ldc 212
    //   150: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 8
    //   156: aload 9
    //   158: invokevirtual 145	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   161: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: ldc 13
    //   167: iconst_2
    //   168: aload 8
    //   170: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 216	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: getstatic 222	com/tencent/mobileqq/text/EmotcationConstants:IN_APK_SYS_GIF	[Ljava/lang/String;
    //   179: astore 8
    //   181: aload 8
    //   183: arraylength
    //   184: istore 5
    //   186: iconst_0
    //   187: istore_3
    //   188: iload_3
    //   189: iload 5
    //   191: if_icmpge +28 -> 219
    //   194: aload 8
    //   196: iload_3
    //   197: aaload
    //   198: aload 7
    //   200: invokevirtual 223	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   203: ifeq +9 -> 212
    //   206: iload 4
    //   208: istore_3
    //   209: goto +12 -> 221
    //   212: iload_3
    //   213: iconst_1
    //   214: iadd
    //   215: istore_3
    //   216: goto -28 -> 188
    //   219: iconst_0
    //   220: istore_3
    //   221: iload_3
    //   222: ifeq +276 -> 498
    //   225: new 173	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   232: astore_1
    //   233: aload_1
    //   234: getstatic 176	com/tencent/mobileqq/transfile/EmotionDownloader:emotionDir	Ljava/io/File;
    //   237: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_1
    //   242: ldc 182
    //   244: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_1
    //   249: aload 7
    //   251: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: aload_1
    //   256: ldc 225
    //   258: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: new 94	java/io/File
    //   265: dup
    //   266: aload_1
    //   267: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokespecial 191	java/io/File:<init>	(Ljava/lang/String;)V
    //   273: astore 10
    //   275: aload 10
    //   277: invokevirtual 194	java/io/File:exists	()Z
    //   280: ifeq +9 -> 289
    //   283: aload 10
    //   285: invokevirtual 228	java/io/File:delete	()Z
    //   288: pop
    //   289: aconst_null
    //   290: astore 8
    //   292: aconst_null
    //   293: astore_2
    //   294: aload_0
    //   295: getfield 34	com/tencent/mobileqq/transfile/EmotionDownloader:application	Lcom/tencent/common/app/BaseApplicationImpl;
    //   298: invokevirtual 232	com/tencent/common/app/BaseApplicationImpl:getAssets	()Landroid/content/res/AssetManager;
    //   301: astore_1
    //   302: new 173	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   309: astore 11
    //   311: aload 11
    //   313: ldc 234
    //   315: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 11
    //   321: aload 7
    //   323: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload 11
    //   329: ldc 236
    //   331: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_1
    //   336: aload 11
    //   338: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokevirtual 242	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   344: astore 7
    //   346: sipush 4096
    //   349: newarray byte
    //   351: astore_2
    //   352: new 244	java/io/FileOutputStream
    //   355: dup
    //   356: aload 10
    //   358: invokespecial 247	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   361: astore_1
    //   362: aload 7
    //   364: aload_2
    //   365: invokevirtual 253	java/io/InputStream:read	([B)I
    //   368: iconst_m1
    //   369: if_icmpeq +15 -> 384
    //   372: aload_1
    //   373: aload_2
    //   374: invokevirtual 257	java/io/FileOutputStream:write	([B)V
    //   377: aload_1
    //   378: invokevirtual 260	java/io/FileOutputStream:flush	()V
    //   381: goto -19 -> 362
    //   384: aload 7
    //   386: ifnull +8 -> 394
    //   389: aload 7
    //   391: invokevirtual 263	java/io/InputStream:close	()V
    //   394: aload_1
    //   395: invokevirtual 264	java/io/FileOutputStream:close	()V
    //   398: aload 10
    //   400: aload 9
    //   402: invokevirtual 267	java/io/File:renameTo	(Ljava/io/File;)Z
    //   405: pop
    //   406: invokestatic 273	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   409: invokestatic 279	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   412: aconst_null
    //   413: ldc 10
    //   415: iconst_1
    //   416: lconst_0
    //   417: lconst_0
    //   418: aconst_null
    //   419: ldc 36
    //   421: invokevirtual 283	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   424: aload 9
    //   426: areturn
    //   427: astore_2
    //   428: goto +10 -> 438
    //   431: astore_2
    //   432: goto +12 -> 444
    //   435: astore_2
    //   436: aconst_null
    //   437: astore_1
    //   438: goto +40 -> 478
    //   441: astore_2
    //   442: aconst_null
    //   443: astore_1
    //   444: aload_2
    //   445: astore 8
    //   447: aload 7
    //   449: astore_2
    //   450: goto +17 -> 467
    //   453: astore_2
    //   454: aconst_null
    //   455: astore_1
    //   456: aload 8
    //   458: astore 7
    //   460: goto +18 -> 478
    //   463: astore 8
    //   465: aconst_null
    //   466: astore_1
    //   467: aload 8
    //   469: athrow
    //   470: astore 8
    //   472: aload_2
    //   473: astore 7
    //   475: aload 8
    //   477: astore_2
    //   478: aload 7
    //   480: ifnull +8 -> 488
    //   483: aload 7
    //   485: invokevirtual 263	java/io/InputStream:close	()V
    //   488: aload_1
    //   489: ifnull +7 -> 496
    //   492: aload_1
    //   493: invokevirtual 264	java/io/FileOutputStream:close	()V
    //   496: aload_2
    //   497: athrow
    //   498: aload_2
    //   499: ifnull +35 -> 534
    //   502: aload_1
    //   503: ldc_w 285
    //   506: invokevirtual 106	com/tencent/image/DownloadParams:getHeader	(Ljava/lang/String;)Lorg/apache/http/Header;
    //   509: astore_1
    //   510: aload_1
    //   511: ifnull +13 -> 524
    //   514: aload_2
    //   515: aload_1
    //   516: invokeinterface 111 1 0
    //   521: invokevirtual 288	com/tencent/mobileqq/earlydownload/handler/SystemFaceHandler:c	(Ljava/lang/String;)V
    //   524: aload_2
    //   525: iconst_0
    //   526: invokevirtual 290	com/tencent/mobileqq/earlydownload/handler/SystemFaceHandler:c	(Z)V
    //   529: aload_2
    //   530: iconst_0
    //   531: invokevirtual 203	com/tencent/mobileqq/earlydownload/handler/SystemFaceHandler:d	(Z)V
    //   534: aload 9
    //   536: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	this	EmotionDownloader
    //   0	537	1	paramDownloadParams	DownloadParams
    //   0	537	2	paramSystemFaceHandler	SystemFaceHandler
    //   187	35	3	i	int
    //   65	142	4	j	int
    //   184	8	5	k	int
    //   62	6	6	bool	boolean
    //   7	477	7	localObject1	Object
    //   16	441	8	localObject2	Object
    //   463	5	8	localException	Exception
    //   470	6	8	localObject3	Object
    //   55	480	9	localFile1	File
    //   273	126	10	localFile2	File
    //   309	28	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   362	381	427	finally
    //   362	381	431	java/lang/Exception
    //   346	362	435	finally
    //   346	362	441	java/lang/Exception
    //   294	346	453	finally
    //   294	346	463	java/lang/Exception
    //   467	470	470	finally
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    for (;;)
    {
      try
      {
        if ((emotionDir == null) || (!emotionDir.exists()))
        {
          emotionDir = this.application.getDir("systemface", 0);
          paramOutputStream = this.application.getDir("sysface", 0);
          if (paramOutputStream.exists()) {
            paramOutputStream.delete();
          }
          if (!emotionDir.exists()) {
            emotionDir.mkdirs();
          }
        }
        localObject = null;
        try
        {
          paramOutputStream = getCurrentUin();
          paramURLDrawableHandler = (QQAppInterface)this.application.getAppRuntime(paramOutputStream);
        }
        catch (Exception paramOutputStream)
        {
          if (!QLog.isColorLevel()) {
            break label309;
          }
        }
        paramURLDrawableHandler = new StringBuilder();
        paramURLDrawableHandler.append("getting QQApp throws a Exception:");
        paramURLDrawableHandler.append(paramOutputStream.getMessage());
        QLog.d("EmotionDownloader", 2, paramURLDrawableHandler.toString());
      }
      catch (Exception paramOutputStream)
      {
        Object localObject;
        paramDownloadParams = new HashMap();
        paramDownloadParams.put("param_FailCode", Integer.toString(89500));
        paramDownloadParams.put("param_FailMsg", ProcessorReport.getExceptionMessage(paramOutputStream));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "system_face_decode_copyfile", false, 0L, 0L, paramDownloadParams, "");
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EmotionDownloader", 2, "downloadImage", paramOutputStream);
        return rootFile;
      }
      paramOutputStream = localObject;
      if (paramURLDrawableHandler != null)
      {
        paramURLDrawableHandler = (IEarlyDownloadService)paramURLDrawableHandler.getRuntimeService(IEarlyDownloadService.class, "");
        paramOutputStream = localObject;
        if (paramURLDrawableHandler != null) {
          paramOutputStream = (SystemFaceHandler)paramURLDrawableHandler.getEarlyHandler("qq.android.system.face.gifv14");
        }
      }
      paramOutputStream = downloadEmoticonImage(paramDownloadParams, paramOutputStream);
      if (paramOutputStream.exists()) {
        return paramOutputStream;
      }
      paramOutputStream = new HashMap();
      paramOutputStream.put("param_FailCode", Integer.toString(89501));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "system_face_decode_copyfile", false, 0L, 0L, paramOutputStream, "");
      paramOutputStream = rootFile;
      return paramOutputStream;
      label309:
      paramURLDrawableHandler = null;
    }
  }
  
  public boolean useDiskCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.EmotionDownloader
 * JD-Core Version:    0.7.0.1
 */