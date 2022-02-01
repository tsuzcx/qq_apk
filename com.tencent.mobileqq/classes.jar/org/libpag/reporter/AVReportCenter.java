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
import java.util.Map<Ljava.lang.String;Ljava.lang.Object;>;
import java.util.Random;
import java.util.Set;

public class AVReportCenter
{
  private static final String TAG = "AVReportCenter-" + Integer.toHexString(AVReportCenter.class.hashCode());
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
    if ((this.dir == null) || (this.dir.length() == 0))
    {
      Log.d(TAG, "hibernate: dir is empty");
      return;
    }
    try
    {
      File localFile = new File(this.tmpDir + File.separator + paramString2 + "." + System.nanoTime());
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      paramString1 = paramString1.getBytes();
      int i = 0;
      while (i < paramString1.length)
      {
        paramString1[i] = ((byte)(paramString1[i] ^ 0xFFFFFFE9));
        i += 1;
      }
      localFileOutputStream.write(paramString1);
      localFileOutputStream.close();
      localFile.renameTo(new File(this.dir + File.separator + paramString2 + "." + System.nanoTime()));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void hibernateMap(Map<String, Object> paramMap)
  {
    hibernate(toUrlParams(paramMap));
  }
  
  private String md5(String paramString)
  {
    try
    {
      for (String str = new BigInteger(1, MessageDigest.getInstance("MD5").digest(paramString.getBytes(Charset.forName("UTF-8")))).toString(16); str.length() < 32; str = "0" + str) {}
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
    paramMap.put("device", DeviceInfo.getBrand() + DeviceInfo.getDeviceName());
    paramMap.put("device_id", this.imei);
    paramMap.put("platform", "and");
    paramMap.put("os", this.os);
    paramMap.put("appid", this.app);
    paramMap.put("_dc", Integer.valueOf(Math.abs(new Random().nextInt())));
  }
  
  private static String toUrlParams(Map<String, Object> paramMap)
  {
    Object localObject1 = "attaid=06400000136&token=3598698434";
    Iterator localIterator = paramMap.entrySet().iterator();
    paramMap = (Map<String, Object>)localObject1;
    if (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      localObject1 = ((Map.Entry)localObject2).getValue();
      localObject2 = (String)((Map.Entry)localObject2).getKey();
      if ((localObject1 instanceof Number)) {
        paramMap = paramMap + "&" + (String)localObject2 + "=" + localObject1.toString();
      }
      for (;;)
      {
        break;
        if ((localObject1 instanceof String)) {
          try
          {
            localObject1 = paramMap + "&" + (String)localObject2 + "=" + URLEncoder.encode(localObject1.toString(), "UTF-8");
            paramMap = (Map<String, Object>)localObject1;
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
      }
    }
    return paramMap;
  }
  
  public void commit(Map<String, String> paramMap)
  {
    if ((!this.enable) || (paramMap == null) || (this.ioHandler == null)) {
      return;
    }
    this.ioHandler.post(new AVReportCenter.2(this, paramMap));
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
    //   4: ifnonnull +16 -> 20
    //   7: ldc 2
    //   9: monitorenter
    //   10: aload_0
    //   11: getfield 91	org/libpag/reporter/AVReportCenter:ioHandler	Landroid/os/Handler;
    //   14: ifnull +7 -> 21
    //   17: ldc 2
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: new 28	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   29: aload_1
    //   30: invokestatic 329	org/libpag/reporter/DeviceInfo:getRomFingerprint	(Landroid/content/Context;)Ljava/lang/String;
    //   33: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokestatic 332	org/libpag/reporter/DeviceInfo:getApiLevelInt	()I
    //   39: invokevirtual 335	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: putfield 234	org/libpag/reporter/AVReportCenter:os	Ljava/lang/String;
    //   48: aload_0
    //   49: ldc_w 337
    //   52: putfield 238	org/libpag/reporter/AVReportCenter:app	Ljava/lang/String;
    //   55: aload_0
    //   56: aload_1
    //   57: invokevirtual 342	android/content/Context:getPackageName	()Ljava/lang/String;
    //   60: putfield 238	org/libpag/reporter/AVReportCenter:app	Ljava/lang/String;
    //   63: aload_1
    //   64: invokevirtual 346	android/content/Context:getExternalCacheDir	()Ljava/io/File;
    //   67: astore_2
    //   68: aload_2
    //   69: ifnonnull +13 -> 82
    //   72: ldc 2
    //   74: monitorexit
    //   75: return
    //   76: astore_1
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: new 28	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   89: aload_2
    //   90: invokevirtual 349	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   93: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: getstatic 130	java/io/File:separator	Ljava/lang/String;
    //   99: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: aload_0
    //   104: invokevirtual 353	java/lang/Object:getClass	()Ljava/lang/Class;
    //   107: invokevirtual 358	java/lang/Class:getName	()Ljava/lang/String;
    //   110: invokespecial 360	org/libpag/reporter/AVReportCenter:md5	(Ljava/lang/String;)Ljava/lang/String;
    //   113: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: astore_2
    //   120: aload_0
    //   121: new 28	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   128: aload_2
    //   129: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 362
    //   135: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: putfield 74	org/libpag/reporter/AVReportCenter:dir	Ljava/lang/String;
    //   144: new 127	java/io/File
    //   147: dup
    //   148: aload_0
    //   149: getfield 74	org/libpag/reporter/AVReportCenter:dir	Ljava/lang/String;
    //   152: invokespecial 143	java/io/File:<init>	(Ljava/lang/String;)V
    //   155: astore_3
    //   156: aload_3
    //   157: invokevirtual 365	java/io/File:exists	()Z
    //   160: ifne +8 -> 168
    //   163: aload_3
    //   164: invokevirtual 368	java/io/File:mkdirs	()Z
    //   167: pop
    //   168: aload_0
    //   169: new 28	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   176: aload_2
    //   177: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 370
    //   183: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: putfield 77	org/libpag/reporter/AVReportCenter:tmpDir	Ljava/lang/String;
    //   192: new 127	java/io/File
    //   195: dup
    //   196: aload_0
    //   197: getfield 77	org/libpag/reporter/AVReportCenter:tmpDir	Ljava/lang/String;
    //   200: invokespecial 143	java/io/File:<init>	(Ljava/lang/String;)V
    //   203: astore_2
    //   204: aload_2
    //   205: invokevirtual 365	java/io/File:exists	()Z
    //   208: ifne +8 -> 216
    //   211: aload_2
    //   212: invokevirtual 368	java/io/File:mkdirs	()Z
    //   215: pop
    //   216: getstatic 376	android/os/Build$VERSION:SDK_INT	I
    //   219: bipush 26
    //   221: if_icmplt +94 -> 315
    //   224: aload_0
    //   225: aload_1
    //   226: invokevirtual 380	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   229: ldc_w 382
    //   232: invokestatic 388	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   235: putfield 227	org/libpag/reporter/AVReportCenter:imei	Ljava/lang/String;
    //   238: aload_0
    //   239: new 390	android/os/HandlerThread
    //   242: dup
    //   243: getstatic 53	org/libpag/reporter/AVReportCenter:TAG	Ljava/lang/String;
    //   246: invokespecial 391	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
    //   249: putfield 393	org/libpag/reporter/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   252: aload_0
    //   253: getfield 393	org/libpag/reporter/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   256: iconst_1
    //   257: invokevirtual 397	android/os/HandlerThread:setDaemon	(Z)V
    //   260: aload_0
    //   261: getfield 393	org/libpag/reporter/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   264: invokevirtual 400	android/os/HandlerThread:start	()V
    //   267: aload_0
    //   268: getfield 393	org/libpag/reporter/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   271: invokevirtual 403	android/os/HandlerThread:isAlive	()Z
    //   274: ifeq -7 -> 267
    //   277: aload_0
    //   278: new 309	android/os/Handler
    //   281: dup
    //   282: aload_0
    //   283: getfield 393	org/libpag/reporter/AVReportCenter:ioThread	Landroid/os/HandlerThread;
    //   286: invokevirtual 407	android/os/HandlerThread:getLooper	()Landroid/os/Looper;
    //   289: invokespecial 410	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   292: putfield 91	org/libpag/reporter/AVReportCenter:ioHandler	Landroid/os/Handler;
    //   295: aload_0
    //   296: getfield 91	org/libpag/reporter/AVReportCenter:ioHandler	Landroid/os/Handler;
    //   299: new 412	org/libpag/reporter/AVReportCenter$1
    //   302: dup
    //   303: aload_0
    //   304: invokespecial 413	org/libpag/reporter/AVReportCenter$1:<init>	(Lorg/libpag/reporter/AVReportCenter;)V
    //   307: invokevirtual 313	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   310: pop
    //   311: ldc 2
    //   313: monitorexit
    //   314: return
    //   315: aload_0
    //   316: aload_1
    //   317: ldc_w 415
    //   320: invokevirtual 419	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   323: checkcast 421	android/telephony/TelephonyManager
    //   326: invokevirtual 424	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   329: putfield 227	org/libpag/reporter/AVReportCenter:imei	Ljava/lang/String;
    //   332: goto -94 -> 238
    //   335: astore_1
    //   336: aload_1
    //   337: invokevirtual 166	java/lang/Exception:printStackTrace	()V
    //   340: aload_0
    //   341: ldc 207
    //   343: putfield 227	org/libpag/reporter/AVReportCenter:imei	Ljava/lang/String;
    //   346: goto -108 -> 238
    //   349: astore_1
    //   350: aload_1
    //   351: invokevirtual 166	java/lang/Exception:printStackTrace	()V
    //   354: ldc 2
    //   356: monitorexit
    //   357: return
    //   358: astore_2
    //   359: goto -296 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	AVReportCenter
    //   0	362	1	paramContext	android.content.Context
    //   67	145	2	localObject	Object
    //   358	1	2	localException	Exception
    //   155	9	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   10	20	76	finally
    //   21	55	76	finally
    //   55	63	76	finally
    //   63	68	76	finally
    //   72	75	76	finally
    //   77	80	76	finally
    //   82	168	76	finally
    //   168	216	76	finally
    //   216	238	76	finally
    //   238	267	76	finally
    //   267	314	76	finally
    //   315	332	76	finally
    //   336	346	76	finally
    //   350	357	76	finally
    //   216	238	335	java/lang/Exception
    //   315	332	335	java/lang/Exception
    //   21	55	349	java/lang/Exception
    //   63	68	349	java/lang/Exception
    //   82	168	349	java/lang/Exception
    //   168	216	349	java/lang/Exception
    //   336	346	349	java/lang/Exception
    //   55	63	358	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.libpag.reporter.AVReportCenter
 * JD-Core Version:    0.7.0.1
 */