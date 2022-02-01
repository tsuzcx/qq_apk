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
    WeiboSsoSdkConfig localWeiboSsoSdkConfig = config;
    if ((localWeiboSsoSdkConfig != null) && (localWeiboSsoSdkConfig.verify()))
    {
      this.mCallCount = 0;
      new Thread(new WeiboSsoSdk.1(this)).start();
      new Thread(new WeiboSsoSdk.2(this)).start();
      return;
    }
    throw new Exception("config error");
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
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 4
    //   20: new 125	java/io/FileOutputStream
    //   23: dup
    //   24: aload_0
    //   25: iconst_1
    //   26: invokespecial 129	com/weibo/ssosdk/WeiboSsoSdk:getAidInfoFile	(I)Ljava/io/File;
    //   29: invokespecial 132	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   32: astore_3
    //   33: aload_3
    //   34: aload_1
    //   35: invokevirtual 138	java/lang/String:getBytes	()[B
    //   38: invokevirtual 142	java/io/FileOutputStream:write	([B)V
    //   41: aload_3
    //   42: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: astore_1
    //   52: goto +10 -> 62
    //   55: goto +17 -> 72
    //   58: astore_1
    //   59: aload 4
    //   61: astore_3
    //   62: aload_3
    //   63: ifnull +7 -> 70
    //   66: aload_3
    //   67: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   70: aload_1
    //   71: athrow
    //   72: aload_3
    //   73: ifnull +13 -> 86
    //   76: aload_3
    //   77: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   80: aload_0
    //   81: monitorexit
    //   82: return
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: aload_0
    //   87: monitorexit
    //   88: return
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    //   94: astore_1
    //   95: aload 5
    //   97: astore_3
    //   98: goto -26 -> 72
    //   101: astore_1
    //   102: goto -47 -> 55
    //   105: astore_1
    //   106: goto -58 -> 48
    //   109: astore_3
    //   110: goto -40 -> 70
    //   113: astore_1
    //   114: goto -31 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	WeiboSsoSdk
    //   0	117	1	paramString	String
    //   6	2	2	bool	boolean
    //   32	66	3	localObject1	Object
    //   109	1	3	localIOException	java.io.IOException
    //   18	42	4	localObject2	Object
    //   15	81	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   33	41	51	finally
    //   20	33	58	finally
    //   2	7	89	finally
    //   41	45	89	finally
    //   66	70	89	finally
    //   70	72	89	finally
    //   76	80	89	finally
    //   20	33	94	java/lang/Exception
    //   33	41	101	java/lang/Exception
    //   41	45	105	java/io/IOException
    //   66	70	109	java/io/IOException
    //   76	80	113	java/io/IOException
  }
  
  private String do_post(String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = null;
    try
    {
      Object localObject = (HttpURLConnection)new URL("https://login.sina.com.cn/visitor/signin").openConnection();
      ((HttpURLConnection)localObject).setRequestMethod("POST");
      ((HttpURLConnection)localObject).setReadTimeout(3000);
      ((HttpURLConnection)localObject).setConnectTimeout(1000);
      ((HttpURLConnection)localObject).setDoOutput(true);
      ((HttpURLConnection)localObject).setDoInput(true);
      ((HttpURLConnection)localObject).setUseCaches(false);
      OutputStream localOutputStream = ((HttpURLConnection)localObject).getOutputStream();
      localOutputStream.write(paramString.getBytes());
      localOutputStream.flush();
      paramString = localByteArrayOutputStream;
      if (((HttpURLConnection)localObject).getResponseCode() == 200)
      {
        paramString = ((HttpURLConnection)localObject).getInputStream();
        localByteArrayOutputStream = new ByteArrayOutputStream();
        localObject = new byte[1024];
        for (;;)
        {
          int i = paramString.read((byte[])localObject);
          if (i == -1) {
            break;
          }
          localByteArrayOutputStream.write((byte[])localObject, 0, i);
        }
        paramString.close();
        localByteArrayOutputStream.close();
        paramString = new String(localByteArrayOutputStream.toByteArray());
      }
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  private File getAidInfoFile(int paramInt)
  {
    File localFile = config.getApplicationContext().getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder("weibo_sso_sdk_aid");
    localStringBuilder.append(paramInt);
    return new File(localFile, localStringBuilder.toString());
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
    if (paramWeiboSsoSdkConfig == null) {
      return false;
    }
    try
    {
      boolean bool = paramWeiboSsoSdkConfig.verify();
      if (!bool) {
        return false;
      }
      if (config == null)
      {
        paramWeiboSsoSdkConfig = (WeiboSsoSdkConfig)paramWeiboSsoSdkConfig.clone();
        config = paramWeiboSsoSdkConfig;
        MfpBuilder.init(paramWeiboSsoSdkConfig.getApplicationContext());
        return true;
      }
      return false;
    }
    finally {}
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
    //   43: astore_2
    //   44: goto +9 -> 53
    //   47: goto +16 -> 63
    //   50: astore_2
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_1
    //   54: ifnull +7 -> 61
    //   57: aload_1
    //   58: invokevirtual 265	java/io/FileInputStream:close	()V
    //   61: aload_2
    //   62: athrow
    //   63: aload_1
    //   64: ifnull +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 265	java/io/FileInputStream:close	()V
    //   71: ldc_w 267
    //   74: areturn
    //   75: astore_1
    //   76: aload_2
    //   77: astore_1
    //   78: goto -15 -> 63
    //   81: astore_2
    //   82: goto -35 -> 47
    //   85: astore_1
    //   86: aload_2
    //   87: areturn
    //   88: astore_1
    //   89: goto -28 -> 61
    //   92: astore_1
    //   93: goto -22 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	WeiboSsoSdk
    //   14	54	1	localFileInputStream	java.io.FileInputStream
    //   75	1	1	localException1	Exception
    //   77	1	1	localObject1	Object
    //   85	1	1	localIOException1	java.io.IOException
    //   88	1	1	localIOException2	java.io.IOException
    //   92	1	1	localIOException3	java.io.IOException
    //   1	41	2	localObject2	Object
    //   43	1	2	localObject3	Object
    //   50	27	2	localObject4	Object
    //   81	6	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   15	37	43	finally
    //   2	15	50	finally
    //   2	15	75	java/lang/Exception
    //   15	37	81	java/lang/Exception
    //   37	41	85	java/io/IOException
    //   57	61	88	java/io/IOException
    //   67	71	92	java/io/IOException
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
    //   40: astore_2
    //   41: goto +6 -> 47
    //   44: astore_2
    //   45: aconst_null
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +7 -> 55
    //   51: aload_1
    //   52: invokevirtual 265	java/io/FileInputStream:close	()V
    //   55: aload_2
    //   56: athrow
    //   57: aconst_null
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +7 -> 67
    //   63: aload_1
    //   64: invokevirtual 265	java/io/FileInputStream:close	()V
    //   67: aconst_null
    //   68: areturn
    //   69: astore_1
    //   70: goto -13 -> 57
    //   73: astore_2
    //   74: goto -15 -> 59
    //   77: astore_1
    //   78: aload_2
    //   79: areturn
    //   80: astore_1
    //   81: goto -26 -> 55
    //   84: astore_1
    //   85: aconst_null
    //   86: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	WeiboSsoSdk
    //   11	53	1	localFileInputStream	java.io.FileInputStream
    //   69	1	1	localException1	Exception
    //   77	1	1	localIOException1	java.io.IOException
    //   80	1	1	localIOException2	java.io.IOException
    //   84	1	1	localIOException3	java.io.IOException
    //   18	21	2	localObject1	Object
    //   40	1	2	localObject2	Object
    //   44	12	2	localObject3	Object
    //   73	6	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   12	34	40	finally
    //   0	12	44	finally
    //   0	12	69	java/lang/Exception
    //   12	34	73	java/lang/Exception
    //   34	38	77	java/io/IOException
    //   51	55	80	java/io/IOException
    //   63	67	84	java/io/IOException
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
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 4
    //   20: new 125	java/io/FileOutputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 270	com/weibo/ssosdk/WeiboSsoSdk:getInitFile	()Ljava/io/File;
    //   28: invokespecial 132	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: astore_3
    //   32: aload_3
    //   33: aload_1
    //   34: invokevirtual 138	java/lang/String:getBytes	()[B
    //   37: invokevirtual 142	java/io/FileOutputStream:write	([B)V
    //   40: aload_3
    //   41: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: astore_1
    //   51: goto +10 -> 61
    //   54: goto +17 -> 71
    //   57: astore_1
    //   58: aload 4
    //   60: astore_3
    //   61: aload_3
    //   62: ifnull +7 -> 69
    //   65: aload_3
    //   66: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   69: aload_1
    //   70: athrow
    //   71: aload_3
    //   72: ifnull +13 -> 85
    //   75: aload_3
    //   76: invokevirtual 145	java/io/FileOutputStream:close	()V
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: monitorexit
    //   87: return
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    //   93: astore_1
    //   94: aload 5
    //   96: astore_3
    //   97: goto -26 -> 71
    //   100: astore_1
    //   101: goto -47 -> 54
    //   104: astore_1
    //   105: goto -58 -> 47
    //   108: astore_3
    //   109: goto -40 -> 69
    //   112: astore_1
    //   113: goto -31 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	WeiboSsoSdk
    //   0	116	1	paramString	String
    //   6	2	2	bool	boolean
    //   31	66	3	localObject1	Object
    //   108	1	3	localIOException	java.io.IOException
    //   18	41	4	localObject2	Object
    //   15	80	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   32	40	50	finally
    //   20	32	57	finally
    //   2	7	88	finally
    //   40	44	88	finally
    //   65	69	88	finally
    //   69	71	88	finally
    //   75	79	88	finally
    //   20	32	93	java/lang/Exception
    //   32	40	100	java/lang/Exception
    //   40	44	104	java/io/IOException
    //   65	69	108	java/io/IOException
    //   75	79	112	java/io/IOException
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
    }
    catch (UnsupportedEncodingException paramString)
    {
      label65:
      String str2;
      break label65;
    }
    paramString = "";
    str2 = config.getApplicationContext().getPackageName();
    paramString = do_post(riseWind(config.getAppKey(true), str2, paramString, str1, config.getFrom(true), config.getOldWm(true), config.getWm(true), config.getSub(true), config.getSmid(true), config.getExtraString(true), paramInt, this.mCallCount));
    this.mCallCount += 1;
    if (paramString != null) {
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
    localObject = this.mVisitorLoginInfo;
    if ((localObject == null) || (TextUtils.isEmpty(((WeiboSsoSdk.VisitorLoginInfo)localObject).getAid())))
    {
      localObject = new Thread(new WeiboSsoSdk.6(this));
      ((Thread)localObject).start();
      ((Thread)localObject).join();
      localObject = this.mVisitorLoginInfo;
      if ((localObject == null) || (TextUtils.isEmpty(((WeiboSsoSdk.VisitorLoginInfo)localObject).getAid()))) {}
    }
    else
    {
      return this.mVisitorLoginInfo.getAid();
    }
    throw new Exception("visitor login failed");
  }
  
  public void getAid(AidListener paramAidListener)
  {
    Object localObject = loadAidFromCache();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramAidListener.handler((String)localObject);
    }
    localObject = this.mVisitorLoginInfo;
    if ((localObject != null) && (!TextUtils.isEmpty(((WeiboSsoSdk.VisitorLoginInfo)localObject).getAid())))
    {
      paramAidListener.handler(this.mVisitorLoginInfo.getAid());
      return;
    }
    Executors.newSingleThreadExecutor().execute(new WeiboSsoSdk.7(this, paramAidListener));
  }
  
  public void updateSub(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    config.setSub(paramString);
    String str = this.mVisitorLoginInfo.getVisitorSub();
    if ((TextUtils.isEmpty(str)) || (!str.equals(paramString))) {
      new Thread(new WeiboSsoSdk.3(this)).start();
    }
  }
  
  public WeiboSsoSdk.VisitorLoginInfo visitorLogin()
  {
    Object localObject = this.mVisitorLoginInfo;
    if ((localObject == null) || (TextUtils.isEmpty(((WeiboSsoSdk.VisitorLoginInfo)localObject).getAid())) || (TextUtils.isEmpty(this.mVisitorLoginInfo.getVisitorSub())))
    {
      localObject = new Thread(new WeiboSsoSdk.4(this));
      ((Thread)localObject).start();
      ((Thread)localObject).join();
      localObject = this.mVisitorLoginInfo;
      if ((localObject == null) || (TextUtils.isEmpty(((WeiboSsoSdk.VisitorLoginInfo)localObject).getAid())) || (TextUtils.isEmpty(this.mVisitorLoginInfo.getVisitorSub()))) {}
    }
    else
    {
      return this.mVisitorLoginInfo;
    }
    throw new Exception("visitor login failed");
  }
  
  public void visitorLogin(VisitorLoginListener paramVisitorLoginListener)
  {
    WeiboSsoSdk.VisitorLoginInfo localVisitorLoginInfo = this.mVisitorLoginInfo;
    if ((localVisitorLoginInfo != null) && (!TextUtils.isEmpty(localVisitorLoginInfo.getAid())) && (!TextUtils.isEmpty(this.mVisitorLoginInfo.getVisitorSub())))
    {
      paramVisitorLoginListener.handler(this.mVisitorLoginInfo);
      return;
    }
    Executors.newSingleThreadExecutor().execute(new WeiboSsoSdk.5(this, paramVisitorLoginListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.weibo.ssosdk.WeiboSsoSdk
 * JD-Core Version:    0.7.0.1
 */