package com.weibo.ssosdk;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class WeiboSsoSdk
{
  private static final String AID_FILE_NAME = "weibo_sso_sdk_aid";
  private static final String INIT_FILE_NAME = "weibo_sso_sdk_init";
  private static final String LOGIN_URL = "https://login.sina.com.cn/visitor/signin";
  private static final int SDK_ACT_UPLOAD = 2;
  private static final int SDK_ACT_VISITORLOGIN = 1;
  public static final String SDK_VERSION_CODE = "1.0";
  private static final String TAG = "WeiboSsoSdk";
  private static final int VERSION = 1;
  private static WeiboSsoSdkConfig config;
  private static WeiboSsoSdk sInstance;
  private boolean isFirstUpload = true;
  private int mCallCount;
  private volatile ReentrantLock mTaskLock = new ReentrantLock(true);
  private WeiboSsoSdk.VisitorLoginInfo mVisitorLoginInfo;
  
  static
  {
    System.loadLibrary("wind");
  }
  
  private WeiboSsoSdk()
  {
    if ((config == null) || (!config.verify())) {
      throw new Exception("config error");
    }
    this.mCallCount = 0;
    new Thread(new WeiboSsoSdk.1(this)).start();
    new Thread(new WeiboSsoSdk.2(this)).start();
  }
  
  private static void LogD(String paramString) {}
  
  private static void LogE(String paramString) {}
  
  /* Error */
  private void cacheAidInfo(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aconst_null
    //   15: astore 4
    //   17: new 125	java/io/FileOutputStream
    //   20: dup
    //   21: aload_0
    //   22: iconst_1
    //   23: invokespecial 129	com/weibo/ssosdk/WeiboSsoSdk:getAidInfoFile	(I)Ljava/io/File;
    //   26: invokespecial 132	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   29: astore_3
    //   30: aload_3
    //   31: aload_1
    //   32: invokevirtual 138	java/lang/String:getBytes	()[B
    //   35: invokevirtual 142	java/io/FileOutputStream:write	([B)V
    //   38: aload_3
    //   39: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   42: goto -31 -> 11
    //   45: astore_1
    //   46: goto -35 -> 11
    //   49: astore_1
    //   50: aconst_null
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull -42 -> 11
    //   56: aload_3
    //   57: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   60: goto -49 -> 11
    //   63: astore_1
    //   64: goto -53 -> 11
    //   67: astore_1
    //   68: aload 4
    //   70: astore_3
    //   71: aload_3
    //   72: ifnull +7 -> 79
    //   75: aload_3
    //   76: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   79: aload_1
    //   80: athrow
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: astore_3
    //   87: goto -8 -> 79
    //   90: astore_1
    //   91: goto -20 -> 71
    //   94: astore_1
    //   95: goto -43 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	WeiboSsoSdk
    //   0	98	1	paramString	String
    //   6	2	2	bool	boolean
    //   29	47	3	localObject1	Object
    //   86	1	3	localIOException	java.io.IOException
    //   15	54	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   38	42	45	java/io/IOException
    //   17	30	49	java/lang/Exception
    //   56	60	63	java/io/IOException
    //   17	30	67	finally
    //   2	7	81	finally
    //   38	42	81	finally
    //   56	60	81	finally
    //   75	79	81	finally
    //   79	81	81	finally
    //   75	79	86	java/io/IOException
    //   30	38	90	finally
    //   30	38	94	java/lang/Exception
  }
  
  private String do_post(String paramString)
  {
    try
    {
      Object localObject1 = (HttpURLConnection)new URL("https://login.sina.com.cn/visitor/signin").openConnection();
      ((HttpURLConnection)localObject1).setRequestMethod("POST");
      ((HttpURLConnection)localObject1).setReadTimeout(3000);
      ((HttpURLConnection)localObject1).setConnectTimeout(1000);
      ((HttpURLConnection)localObject1).setDoOutput(true);
      ((HttpURLConnection)localObject1).setDoInput(true);
      ((HttpURLConnection)localObject1).setUseCaches(false);
      Object localObject2 = ((HttpURLConnection)localObject1).getOutputStream();
      ((OutputStream)localObject2).write(paramString.getBytes());
      ((OutputStream)localObject2).flush();
      if (((HttpURLConnection)localObject1).getResponseCode() == 200)
      {
        paramString = ((HttpURLConnection)localObject1).getInputStream();
        localObject1 = new ByteArrayOutputStream();
        localObject2 = new byte[1024];
        for (;;)
        {
          int i = paramString.read((byte[])localObject2);
          if (i == -1) {
            break;
          }
          ((ByteArrayOutputStream)localObject1).write((byte[])localObject2, 0, i);
        }
        paramString.close();
        ((ByteArrayOutputStream)localObject1).close();
        paramString = new String(((ByteArrayOutputStream)localObject1).toByteArray());
        return paramString;
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private File getAidInfoFile(int paramInt)
  {
    return new File(config.getApplicationContext().getFilesDir(), "weibo_sso_sdk_aid" + paramInt);
  }
  
  private File getInitFile()
  {
    return new File(config.getApplicationContext().getFilesDir(), "weibo_sso_sdk_init");
  }
  
  public static WeiboSsoSdk getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new WeiboSsoSdk();
      }
      WeiboSsoSdk localWeiboSsoSdk = sInstance;
      return localWeiboSsoSdk;
    }
    finally {}
  }
  
  public static boolean initConfig(WeiboSsoSdkConfig paramWeiboSsoSdkConfig)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramWeiboSsoSdkConfig == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      try
      {
        if (!paramWeiboSsoSdkConfig.verify()) {
          continue;
        }
        bool1 = bool2;
        if (config != null) {
          continue;
        }
        paramWeiboSsoSdkConfig = (WeiboSsoSdkConfig)paramWeiboSsoSdkConfig.clone();
        config = paramWeiboSsoSdkConfig;
        MfpBuilder.init(paramWeiboSsoSdkConfig.getApplicationContext());
        bool1 = true;
      }
      finally {}
    }
  }
  
  /* Error */
  private String loadAidFromCache()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 259	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: iconst_1
    //   8: invokespecial 129	com/weibo/ssosdk/WeiboSsoSdk:getAidInfoFile	(I)Ljava/io/File;
    //   11: invokespecial 260	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_1
    //   15: aload_1
    //   16: invokevirtual 263	java/io/FileInputStream:available	()I
    //   19: newarray byte
    //   21: astore_2
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 264	java/io/FileInputStream:read	([B)I
    //   27: pop
    //   28: new 134	java/lang/String
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 214	java/lang/String:<init>	([B)V
    //   36: astore_2
    //   37: aload_1
    //   38: invokevirtual 265	java/io/FileInputStream:close	()V
    //   41: aload_2
    //   42: areturn
    //   43: astore_1
    //   44: aload_2
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +7 -> 54
    //   50: aload_1
    //   51: invokevirtual 265	java/io/FileInputStream:close	()V
    //   54: ldc_w 267
    //   57: areturn
    //   58: astore_2
    //   59: aconst_null
    //   60: astore_1
    //   61: aload_1
    //   62: ifnull +7 -> 69
    //   65: aload_1
    //   66: invokevirtual 265	java/io/FileInputStream:close	()V
    //   69: aload_2
    //   70: athrow
    //   71: astore_1
    //   72: aload_2
    //   73: areturn
    //   74: astore_1
    //   75: goto -21 -> 54
    //   78: astore_1
    //   79: goto -10 -> 69
    //   82: astore_2
    //   83: goto -22 -> 61
    //   86: astore_2
    //   87: goto -41 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	WeiboSsoSdk
    //   14	24	1	localFileInputStream	java.io.FileInputStream
    //   43	1	1	localException1	Exception
    //   45	21	1	localObject1	Object
    //   71	1	1	localIOException1	java.io.IOException
    //   74	1	1	localIOException2	java.io.IOException
    //   78	1	1	localIOException3	java.io.IOException
    //   1	44	2	localObject2	Object
    //   58	15	2	str	String
    //   82	1	2	localObject3	Object
    //   86	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	15	43	java/lang/Exception
    //   2	15	58	finally
    //   37	41	71	java/io/IOException
    //   50	54	74	java/io/IOException
    //   65	69	78	java/io/IOException
    //   15	37	82	finally
    //   15	37	86	java/lang/Exception
  }
  
  /* Error */
  private String loadInitFile()
  {
    // Byte code:
    //   0: new 259	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 270	com/weibo/ssosdk/WeiboSsoSdk:getInitFile	()Ljava/io/File;
    //   8: invokespecial 260	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual 263	java/io/FileInputStream:available	()I
    //   16: newarray byte
    //   18: astore_2
    //   19: aload_1
    //   20: aload_2
    //   21: invokevirtual 264	java/io/FileInputStream:read	([B)I
    //   24: pop
    //   25: new 134	java/lang/String
    //   28: dup
    //   29: aload_2
    //   30: invokespecial 214	java/lang/String:<init>	([B)V
    //   33: astore_2
    //   34: aload_1
    //   35: invokevirtual 265	java/io/FileInputStream:close	()V
    //   38: aload_2
    //   39: areturn
    //   40: astore_1
    //   41: aconst_null
    //   42: astore_1
    //   43: aload_1
    //   44: ifnull +7 -> 51
    //   47: aload_1
    //   48: invokevirtual 265	java/io/FileInputStream:close	()V
    //   51: aconst_null
    //   52: areturn
    //   53: astore_2
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull +7 -> 64
    //   60: aload_1
    //   61: invokevirtual 265	java/io/FileInputStream:close	()V
    //   64: aload_2
    //   65: athrow
    //   66: astore_1
    //   67: aload_2
    //   68: areturn
    //   69: astore_1
    //   70: goto -19 -> 51
    //   73: astore_1
    //   74: goto -10 -> 64
    //   77: astore_2
    //   78: goto -22 -> 56
    //   81: astore_2
    //   82: goto -39 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	WeiboSsoSdk
    //   11	24	1	localFileInputStream	java.io.FileInputStream
    //   40	1	1	localException1	Exception
    //   42	19	1	localObject1	Object
    //   66	1	1	localIOException1	java.io.IOException
    //   69	1	1	localIOException2	java.io.IOException
    //   73	1	1	localIOException3	java.io.IOException
    //   18	21	2	localObject2	Object
    //   53	15	2	str	String
    //   77	1	2	localObject3	Object
    //   81	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	12	40	java/lang/Exception
    //   0	12	53	finally
    //   34	38	66	java/io/IOException
    //   47	51	69	java/io/IOException
    //   60	64	73	java/io/IOException
    //   12	34	77	finally
    //   12	34	81	java/lang/Exception
  }
  
  private native String riseWind(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt1, int paramInt2);
  
  /* Error */
  private void saveInitFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 123	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aconst_null
    //   15: astore 4
    //   17: new 125	java/io/FileOutputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 270	com/weibo/ssosdk/WeiboSsoSdk:getInitFile	()Ljava/io/File;
    //   25: invokespecial 132	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   28: astore_3
    //   29: aload_3
    //   30: aload_1
    //   31: invokevirtual 138	java/lang/String:getBytes	()[B
    //   34: invokevirtual 142	java/io/FileOutputStream:write	([B)V
    //   37: aload_3
    //   38: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   41: goto -30 -> 11
    //   44: astore_1
    //   45: goto -34 -> 11
    //   48: astore_1
    //   49: aconst_null
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull -41 -> 11
    //   55: aload_3
    //   56: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   59: goto -48 -> 11
    //   62: astore_1
    //   63: goto -52 -> 11
    //   66: astore_1
    //   67: aload 4
    //   69: astore_3
    //   70: aload_3
    //   71: ifnull +7 -> 78
    //   74: aload_3
    //   75: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   78: aload_1
    //   79: athrow
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: astore_3
    //   86: goto -8 -> 78
    //   89: astore_1
    //   90: goto -20 -> 70
    //   93: astore_1
    //   94: goto -43 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	WeiboSsoSdk
    //   0	97	1	paramString	String
    //   6	2	2	bool	boolean
    //   28	47	3	localObject1	Object
    //   85	1	3	localIOException	java.io.IOException
    //   15	53	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   37	41	44	java/io/IOException
    //   17	29	48	java/lang/Exception
    //   55	59	62	java/io/IOException
    //   17	29	66	finally
    //   2	7	80	finally
    //   37	41	80	finally
    //   55	59	80	finally
    //   74	78	80	finally
    //   78	80	80	finally
    //   74	78	85	java/io/IOException
    //   29	37	89	finally
    //   29	37	93	java/lang/Exception
  }
  
  private void updateInfo(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(config.getAppKey(false))) {
      return;
    }
    if (!this.mTaskLock.tryLock())
    {
      this.mTaskLock.lock();
      this.mTaskLock.unlock();
      return;
    }
    this.isFirstUpload = false;
    String str1 = MfpBuilder.getMfp(config.getApplicationContext());
    try
    {
      paramString = URLEncoder.encode(paramString, "utf-8");
      String str2 = config.getApplicationContext().getPackageName();
      paramString = do_post(riseWind(config.getAppKey(true), str2, paramString, str1, config.getFrom(true), config.getOldWm(true), config.getWm(true), config.getSub(true), config.getSmid(true), config.getExtraString(true), paramInt, this.mCallCount));
      this.mCallCount += 1;
      if (paramString == null) {}
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        try
        {
          paramString = WeiboSsoSdk.VisitorLoginInfo.parseJson(paramString);
          if ((paramString != null) && (!TextUtils.isEmpty(paramString.getAid()))) {
            cacheAidInfo(paramString.getAid());
          }
          if (paramInt == 1) {
            this.mVisitorLoginInfo = paramString;
          }
          this.mTaskLock.unlock();
          return;
        }
        catch (Exception paramString)
        {
          this.mTaskLock.unlock();
          throw paramString;
        }
        paramString = paramString;
        paramString = "";
      }
    }
    this.mTaskLock.unlock();
    throw new Exception("network error.");
  }
  
  public String getAid()
  {
    Object localObject = loadAidFromCache();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    if ((this.mVisitorLoginInfo == null) || (TextUtils.isEmpty(this.mVisitorLoginInfo.getAid())))
    {
      localObject = new Thread(new WeiboSsoSdk.6(this));
      ((Thread)localObject).start();
      ((Thread)localObject).join();
      if ((this.mVisitorLoginInfo == null) || (TextUtils.isEmpty(this.mVisitorLoginInfo.getAid()))) {
        throw new Exception("visitor login failed");
      }
    }
    return this.mVisitorLoginInfo.getAid();
  }
  
  public void getAid(AidListener paramAidListener)
  {
    String str = loadAidFromCache();
    if (!TextUtils.isEmpty(str)) {
      paramAidListener.handler(str);
    }
    if ((this.mVisitorLoginInfo == null) || (TextUtils.isEmpty(this.mVisitorLoginInfo.getAid())))
    {
      Executors.newSingleThreadExecutor().execute(new WeiboSsoSdk.7(this, paramAidListener));
      return;
    }
    paramAidListener.handler(this.mVisitorLoginInfo.getAid());
  }
  
  public void updateSub(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      return;
      config.setSub(paramString);
      str = this.mVisitorLoginInfo.getVisitorSub();
    } while ((!TextUtils.isEmpty(str)) && (str.equals(paramString)));
    new Thread(new WeiboSsoSdk.3(this)).start();
  }
  
  public WeiboSsoSdk.VisitorLoginInfo visitorLogin()
  {
    if ((this.mVisitorLoginInfo == null) || (TextUtils.isEmpty(this.mVisitorLoginInfo.getAid())) || (TextUtils.isEmpty(this.mVisitorLoginInfo.getVisitorSub())))
    {
      Thread localThread = new Thread(new WeiboSsoSdk.4(this));
      localThread.start();
      localThread.join();
      if ((this.mVisitorLoginInfo == null) || (TextUtils.isEmpty(this.mVisitorLoginInfo.getAid())) || (TextUtils.isEmpty(this.mVisitorLoginInfo.getVisitorSub()))) {
        throw new Exception("visitor login failed");
      }
    }
    return this.mVisitorLoginInfo;
  }
  
  public void visitorLogin(VisitorLoginListener paramVisitorLoginListener)
  {
    if ((this.mVisitorLoginInfo == null) || (TextUtils.isEmpty(this.mVisitorLoginInfo.getAid())) || (TextUtils.isEmpty(this.mVisitorLoginInfo.getVisitorSub())))
    {
      Executors.newSingleThreadExecutor().execute(new WeiboSsoSdk.5(this, paramVisitorLoginListener));
      return;
    }
    paramVisitorLoginListener.handler(this.mVisitorLoginInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.weibo.ssosdk.WeiboSsoSdk
 * JD-Core Version:    0.7.0.1
 */