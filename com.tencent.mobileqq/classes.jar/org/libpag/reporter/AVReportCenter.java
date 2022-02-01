package org.libpag.reporter;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class AVReportCenter
{
  private static final String TAG;
  private static final AVReportCenter ourInstance = new AVReportCenter();
  private String app;
  private Boolean auto = Boolean.valueOf(true);
  private String dir;
  private boolean enable = true;
  private String imei;
  private volatile Handler ioHandler;
  private volatile HandlerThread ioThread;
  private String os;
  private Reporter reporter;
  private boolean shareLooper = true;
  private String tmpDir;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AVReportCenter-");
    localStringBuilder.append(Integer.toHexString(AVReportCenter.class.hashCode()));
    TAG = localStringBuilder.toString();
  }
  
  public static AVReportCenter getInstance()
  {
    return ourInstance;
  }
  
  private void hibernate(String paramString)
  {
    hibernate(paramString, "bean");
  }
  
  private void hibernate(String paramString1, String paramString2)
  {
    Object localObject = this.dir;
    if ((localObject != null) && (((String)localObject).length() != 0)) {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.tmpDir);
        ((StringBuilder)localObject).append(File.separator);
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(".");
        ((StringBuilder)localObject).append(System.nanoTime());
        localObject = new File(((StringBuilder)localObject).toString());
        FileOutputStream localFileOutputStream = new FileOutputStream((File)localObject);
        paramString1 = paramString1.getBytes();
        int i = 0;
        while (i < paramString1.length)
        {
          paramString1[i] = ((byte)(paramString1[i] ^ 0xFFFFFFE9));
          i += 1;
        }
        localFileOutputStream.write(paramString1);
        localFileOutputStream.close();
        paramString1 = new StringBuilder();
        paramString1.append(this.dir);
        paramString1.append(File.separator);
        paramString1.append(paramString2);
        paramString1.append(".");
        paramString1.append(System.nanoTime());
        ((File)localObject).renameTo(new File(paramString1.toString()));
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    Log.d(TAG, "hibernate: dir is empty");
  }
  
  private void hibernateMap(Map<String, Object> paramMap)
  {
    hibernate(toUrlParams(paramMap));
  }
  
  private String md5(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder;
      for (String str = new BigInteger(1, MessageDigest.getInstance("MD5").digest(paramString.getBytes(Charset.forName("UTF-8")))).toString(16); str.length() < 32; str = localStringBuilder.toString())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("0");
        localStringBuilder.append(str);
      }
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramString;
  }
  
  private void putCommonData(Map<String, Object> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(DeviceInfo.getBrand());
    localStringBuilder.append(DeviceInfo.getDeviceName());
    paramMap.put("device", localStringBuilder.toString());
    paramMap.put("device_id", this.imei);
    paramMap.put("platform", "and");
    paramMap.put("os", this.os);
    paramMap.put("appid", this.app);
    paramMap.put("_dc", Integer.valueOf(Math.abs(new Random().nextInt())));
  }
  
  private static String toUrlParams(Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    paramMap = "attaid=06400000136&token=3598698434";
    Map<String, Object> localMap;
    for (;;)
    {
      localMap = paramMap;
      if (!localIterator.hasNext()) {
        break;
      }
      paramMap = (Map.Entry)localIterator.next();
      Object localObject = paramMap.getValue();
      String str = (String)paramMap.getKey();
      if ((localObject instanceof Number))
      {
        paramMap = new StringBuilder();
        paramMap.append(localMap);
        paramMap.append("&");
        paramMap.append(str);
        paramMap.append("=");
        paramMap.append(localObject.toString());
        paramMap = paramMap.toString();
      }
      else
      {
        paramMap = localMap;
        if ((localObject instanceof String)) {
          try
          {
            paramMap = new StringBuilder();
            paramMap.append(localMap);
            paramMap.append("&");
            paramMap.append(str);
            paramMap.append("=");
            paramMap.append(URLEncoder.encode(localObject.toString(), "UTF-8"));
            paramMap = paramMap.toString();
          }
          catch (UnsupportedEncodingException paramMap)
          {
            paramMap.printStackTrace();
            paramMap = localMap;
          }
        }
      }
    }
    return localMap;
  }
  
  public void commit(Map<String, String> paramMap)
  {
    if ((this.enable) && (paramMap != null))
    {
      if (this.ioHandler == null) {
        return;
      }
      this.ioHandler.post(new AVReportCenter.2(this, paramMap));
    }
  }
  
  public void flush()
  {
    if (this.ioHandler == null) {
      return;
    }
    this.ioHandler.post(new AVReportCenter.3(this));
  }
  
  /* Error */
  @android.annotation.SuppressLint({"MissingPermission"})
  public void init(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 91	org/libpag/reporter/AVReportCenter:ioHandler	Landroid/os/Handler;
    //   4: ifnonnull +380 -> 384
    //   7: ldc 2
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 91	org/libpag/reporter/AVReportCenter:ioHandler	Landroid/os/Handler;
    //   14: ifnull +7 -> 21
    //   17: ldc 2
    //   19: monitorexit
    //   20: return
    //   21: new 28	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   28: astore_2
    //   29: aload_2
    //   30: aload_1
    //   31: invokestatic 329	org/libpag/reporter/DeviceInfo:getRomFingerprint	(Landroid/content/Context;)Ljava/lang/String;
    //   34: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_2
    //   39: invokestatic 332	org/libpag/reporter/DeviceInfo:getApiLevelInt	()I
    //   42: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_0
    //   47: aload_2
    //   48: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: putfield 234	org/libpag/reporter/AVReportCenter:os	Ljava/lang/String;
    //   54: aload_0
    //   55: ldc_w 337
    //   58: putfield 238	org/libpag/reporter/AVReportCenter:app	Ljava/lang/String;
    //   61: aload_0
    //   62: aload_1
    //   63: invokevirtual 342	android/content/Context:getPackageName	()Ljava/lang/String;
    //   66: putfield 238	org/libpag/reporter/AVReportCenter:app	Ljava/lang/String;
    //   69: aload_1
    //   70: invokevirtual 346	android/content/Context:getExternalCacheDir	()Ljava/io/File;
    //   73: astore_2
    //   74: aload_2
    //   75: ifnonnull +7 -> 82
    //   78: ldc 2
    //   80: monitorexit
    //   81: return
    //   82: new 28	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   89: astore_3
    //   90: aload_3
    //   91: aload_2
    //   92: invokevirtual 349	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   95: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_3
    //   100: getstatic 122	java/io/File:separator	Ljava/lang/String;
    //   103: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_3
    //   108: aload_0
    //   109: aload_0
    //   110: invokevirtual 353	java/lang/Object:getClass	()Ljava/lang/Class;
    //   113: invokevirtual 358	java/lang/Class:getName	()Ljava/lang/String;
    //   116: invokespecial 360	org/libpag/reporter/AVReportCenter:md5	(Ljava/lang/String;)Ljava/lang/String;
    //   119: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_3
    //   124: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: astore_2
    //   128: new 28	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   135: astore_3
    //   136: aload_3
    //   137: aload_2
    //   138: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_3
    //   143: ldc_w 362
    //   146: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_0
    //   151: aload_3
    //   152: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: putfield 74	org/libpag/reporter/AVReportCenter:dir	Ljava/lang/String;
    //   158: new 119	java/io/File
    //   161: dup
    //   162: aload_0
    //   163: getfield 74	org/libpag/reporter/AVReportCenter:dir	Ljava/lang/String;
    //   166: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   169: astore_3
    //   170: aload_3
    //   171: invokevirtual 365	java/io/File:exists	()Z
    //   174: ifne +8 -> 182
    //   177: aload_3
    //   178: invokevirtual 368	java/io/File:mkdirs	()Z
    //   181: pop
    //   182: new 28	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   189: astore_3
    //   190: aload_3
    //   191: aload_2
    //   192: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload_3
    //   197: ldc_w 370
    //   200: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_0
    //   205: aload_3
    //   206: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: putfield 77	org/libpag/reporter/AVReportCenter:tmpDir	Ljava/lang/String;
    //   212: new 119	java/io/File
    //   215: dup
    //   216: aload_0
    //   217: getfield 77	org/libpag/reporter/AVReportCenter:tmpDir	Ljava/lang/String;
    //   220: invokespecial 135	java/io/File:<init>	(Ljava/lang/String;)V
    //   223: astore_2
    //   224: aload_2
    //   225: invokevirtual 365	java/io/File:exists	()Z
    //   228: ifne +8 -> 236
    //   231: aload_2
    //   232: invokevirtual 368	java/io/File:mkdirs	()Z
    //   235: pop
    //   236: getstatic 376	android/os/Build$VERSION:SDK_INT	I
    //   239: bipush 26
    //   241: if_icmplt +20 -> 261
    //   244: aload_0
    //   245: aload_1
    //   246: invokevirtual 380	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   249: ldc_w 382
    //   252: invokestatic 388	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   255: putfield 227	org/libpag/reporter/AVReportCenter:imei	Ljava/lang/String;
    //   258: goto +34 -> 292
    //   261: aload_0
    //   262: aload_1
    //   263: ldc_w 390
    //   266: invokevirtual 394	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   269: checkcast 396	android/telephony/TelephonyManager
    //   272: invokevirtual 399	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   275: putfield 227	org/libpag/reporter/AVReportCenter:imei	Ljava/lang/String;
    //   278: goto +14 -> 292
    //   281: astore_1
    //   282: aload_1
    //   283: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   286: aload_0
    //   287: ldc 207
    //   289: putfield 227	org/libpag/reporter/AVReportCenter:imei	Ljava/lang/String;
    //   292: aload_0
    //   293: new 401	android/os/HandlerThread
    //   296: dup
    //   297: getstatic 53	org/libpag/reporter/AVReportCenter:TAG	Ljava/lang/String;
    //   300: invokespecial 402	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   303: putfield 404	org/libpag/reporter/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   306: aload_0
    //   307: getfield 404	org/libpag/reporter/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   310: iconst_1
    //   311: invokevirtual 408	android/os/HandlerThread:setDaemon	(Z)V
    //   314: aload_0
    //   315: getfield 404	org/libpag/reporter/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   318: invokevirtual 411	android/os/HandlerThread:start	()V
    //   321: aload_0
    //   322: getfield 404	org/libpag/reporter/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   325: invokevirtual 414	android/os/HandlerThread:isAlive	()Z
    //   328: ifeq -7 -> 321
    //   331: aload_0
    //   332: new 309	android/os/Handler
    //   335: dup
    //   336: aload_0
    //   337: getfield 404	org/libpag/reporter/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   340: invokevirtual 418	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   343: invokespecial 421	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   346: putfield 91	org/libpag/reporter/AVReportCenter:ioHandler	Landroid/os/Handler;
    //   349: aload_0
    //   350: getfield 91	org/libpag/reporter/AVReportCenter:ioHandler	Landroid/os/Handler;
    //   353: new 423	org/libpag/reporter/AVReportCenter$1
    //   356: dup
    //   357: aload_0
    //   358: invokespecial 424	org/libpag/reporter/AVReportCenter$1:<init>	(Lorg/libpag/reporter/AVReportCenter;)V
    //   361: invokevirtual 313	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   364: pop
    //   365: ldc 2
    //   367: monitorexit
    //   368: return
    //   369: astore_1
    //   370: aload_1
    //   371: invokevirtual 158	java/lang/Exception:printStackTrace	()V
    //   374: ldc 2
    //   376: monitorexit
    //   377: return
    //   378: astore_1
    //   379: ldc 2
    //   381: monitorexit
    //   382: aload_1
    //   383: athrow
    //   384: return
    //   385: astore_2
    //   386: goto -317 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	AVReportCenter
    //   0	389	1	paramContext	android.content.Context
    //   28	204	2	localObject1	Object
    //   385	1	2	localException	Exception
    //   89	117	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   236	258	281	java/lang/Exception
    //   261	278	281	java/lang/Exception
    //   21	61	369	java/lang/Exception
    //   69	74	369	java/lang/Exception
    //   82	182	369	java/lang/Exception
    //   182	236	369	java/lang/Exception
    //   282	292	369	java/lang/Exception
    //   10	20	378	finally
    //   21	61	378	finally
    //   61	69	378	finally
    //   69	74	378	finally
    //   78	81	378	finally
    //   82	182	378	finally
    //   182	236	378	finally
    //   236	258	378	finally
    //   261	278	378	finally
    //   282	292	378	finally
    //   292	321	378	finally
    //   321	368	378	finally
    //   370	377	378	finally
    //   379	382	378	finally
    //   61	69	385	java/lang/Exception
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.libpag.reporter.AVReportCenter
 * JD-Core Version:    0.7.0.1
 */