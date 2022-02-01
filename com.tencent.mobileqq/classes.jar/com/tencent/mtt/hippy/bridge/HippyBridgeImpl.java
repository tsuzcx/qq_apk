package com.tencent.mtt.hippy.bridge;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.mtt.hippy.a.b;
import com.tencent.mtt.hippy.a.f.a;
import com.tencent.mtt.hippy.bridge.a.a;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.utils.ArgumentUtils;
import com.tencent.mtt.hippy.utils.FileUtils;
import com.tencent.mtt.hippy.utils.HippyBuffer;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.io.File;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HippyBridgeImpl
  implements f.a, HippyBridge
{
  private static volatile String mCodeCacheRootDir;
  private static volatile ThreadPoolExecutor mCodeCacheThreadExecutor = null;
  private static volatile int sBridgeNum = 0;
  private static Object sBridgeSyncLock = new Object();
  private HippyBridge.a mBridgeCallback;
  private boolean mBridgeParamJson;
  private String mDebugGobalConfig;
  private NativeCallback mDebugInitJSFrameworkCallback;
  private String mDebugServerHost;
  private b mDebugWebSocketClient;
  private HippyBuffer mHippyBuffer;
  private boolean mInit = false;
  private boolean mIsDevModule = false;
  private boolean mSingleThreadMode = false;
  private long mV8RuntimeId = 0L;
  
  static
  {
    a.a("hippybridge");
  }
  
  public HippyBridgeImpl(Context paramContext, HippyBridge.a arg2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    this.mBridgeCallback = ???;
    this.mSingleThreadMode = paramBoolean1;
    this.mBridgeParamJson = paramBoolean2;
    this.mIsDevModule = paramBoolean3;
    this.mDebugServerHost = paramString;
    synchronized (sBridgeSyncLock)
    {
      sBridgeNum += 1;
      if (mCodeCacheRootDir == null)
      {
        paramContext = FileUtils.getHippyFile(paramContext);
        if (paramContext != null) {
          mCodeCacheRootDir = paramContext.getAbsolutePath() + File.separator + "codecache" + File.separator;
        }
      }
      if (mCodeCacheThreadExecutor == null)
      {
        mCodeCacheThreadExecutor = new ThreadPoolExecutor(1, 1, 120L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        mCodeCacheThreadExecutor.allowCoreThreadTimeOut(true);
      }
      if (!this.mBridgeParamJson) {
        this.mHippyBuffer = new HippyBuffer();
      }
      return;
    }
  }
  
  private HippyArray bytesToArgument(byte[] paramArrayOfByte)
  {
    if (this.mBridgeParamJson)
    {
      LogUtils.d("hippy_bridge", "bytesToArgument using JSON");
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = "";
        paramArrayOfByte = ArgumentUtils.parseToArray(paramArrayOfByte);
      }
    }
    for (;;)
    {
      Object localObject = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        localObject = new HippyArray();
      }
      return localObject;
      paramArrayOfByte = new String(paramArrayOfByte);
      break;
      LogUtils.d("hippy_bridge", "bytesToArgument using HippyBuffer");
      paramArrayOfByte = this.mHippyBuffer.parse(paramArrayOfByte);
      if ((paramArrayOfByte instanceof HippyArray)) {
        paramArrayOfByte = (HippyArray)paramArrayOfByte;
      } else {
        paramArrayOfByte = null;
      }
    }
  }
  
  public static void deleteCodeCache(String paramString)
  {
    String[] arrayOfString = new File(mCodeCacheRootDir).list(new HippyBridgeImpl.a(paramString));
    if ((arrayOfString != null) && (arrayOfString.length > 0)) {
      new File(mCodeCacheRootDir + File.separator + arrayOfString[0], paramString).delete();
    }
  }
  
  private void initJSEngine(int paramInt)
  {
    try
    {
      this.mV8RuntimeId = initJSFramework(this.mDebugGobalConfig.getBytes(), this.mSingleThreadMode, this.mBridgeParamJson, this.mIsDevModule, this.mDebugInitJSFrameworkCallback, paramInt);
      this.mInit = true;
      return;
    }
    finally {}
  }
  
  public void InspectorChannel(byte[] paramArrayOfByte)
  {
    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN)
    {
      paramArrayOfByte = new String(paramArrayOfByte, Charset.forName("UTF-16BE"));
      if (this.mDebugWebSocketClient != null) {
        this.mDebugWebSocketClient.a(paramArrayOfByte);
      }
    }
    do
    {
      return;
      paramArrayOfByte = new String(paramArrayOfByte, Charset.forName("UTF-16LE"));
    } while (this.mDebugWebSocketClient == null);
    this.mDebugWebSocketClient.a(paramArrayOfByte);
  }
  
  public void callFunction(String paramString1, String paramString2, NativeCallback paramNativeCallback)
  {
    if ((!this.mInit) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    paramString2 = paramString2.getBytes();
    callFunction(paramString1, paramString2, 0, paramString2.length, this.mV8RuntimeId, paramNativeCallback);
  }
  
  public native void callFunction(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, NativeCallback paramNativeCallback);
  
  public void callFunction(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, NativeCallback paramNativeCallback)
  {
    if ((!this.mInit) || (TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 + paramInt2 > paramArrayOfByte.length)) {
      return;
    }
    callFunction(paramString, paramArrayOfByte, paramInt1, paramInt2, this.mV8RuntimeId, paramNativeCallback);
  }
  
  public void callNatives(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    LogUtils.d("jni_callback", "callNatives [moduleName:" + paramString1 + " , moduleFunc: " + paramString2 + "]");
    if (this.mBridgeCallback != null)
    {
      paramArrayOfByte = bytesToArgument(paramArrayOfByte);
      this.mBridgeCallback.a(paramString1, paramString2, paramString3, paramArrayOfByte);
    }
  }
  
  public native void destroy(long paramLong, boolean paramBoolean, NativeCallback paramNativeCallback);
  
  public void destroy(NativeCallback paramNativeCallback)
  {
    if (this.mDebugWebSocketClient != null) {
      this.mDebugWebSocketClient.a();
    }
    if (!this.mInit) {
      return;
    }
    this.mInit = false;
    synchronized (sBridgeSyncLock)
    {
      sBridgeNum -= 1;
      int i = sBridgeNum;
      if (i != 0) {}
    }
    try
    {
      if (mCodeCacheThreadExecutor != null) {
        mCodeCacheThreadExecutor.shutdownNow();
      }
      label62:
      mCodeCacheThreadExecutor = null;
      if ((!this.mBridgeParamJson) && (this.mHippyBuffer != null)) {
        this.mHippyBuffer.release();
      }
      destroy(this.mV8RuntimeId, this.mSingleThreadMode, paramNativeCallback);
      this.mBridgeCallback = null;
      return;
      paramNativeCallback = finally;
      throw paramNativeCallback;
    }
    catch (Throwable localThrowable)
    {
      break label62;
    }
  }
  
  public native String getCrashMessage();
  
  public void initJSBridge(String paramString, NativeCallback paramNativeCallback, int paramInt)
  {
    this.mDebugGobalConfig = paramString;
    this.mDebugInitJSFrameworkCallback = paramNativeCallback;
    if (this.mIsDevModule)
    {
      this.mDebugWebSocketClient = new b();
      this.mDebugWebSocketClient.a(this);
      if (TextUtils.isEmpty(this.mDebugServerHost)) {
        this.mDebugServerHost = "localhost:38989";
      }
      this.mDebugWebSocketClient.a(String.format(Locale.US, "ws://%s/debugger-proxy?role=android_client", new Object[] { this.mDebugServerHost }), new HippyBridgeImpl.1(this, paramInt));
      return;
    }
    initJSEngine(paramInt);
  }
  
  public native long initJSFramework(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, NativeCallback paramNativeCallback, long paramLong);
  
  public void onReceiveData(String paramString)
  {
    if (this.mIsDevModule)
    {
      paramString = paramString.getBytes();
      callFunction("onWebsocketMsg", paramString, 0, paramString.length, this.mV8RuntimeId, null);
    }
  }
  
  public void postCodeCacheRunnable(String paramString, long paramLong)
  {
    try
    {
      synchronized (sBridgeSyncLock)
      {
        if (mCodeCacheThreadExecutor != null) {
          mCodeCacheThreadExecutor.execute(new HippyBridgeImpl.b(this, paramString, paramLong));
        }
        return;
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public void reportException(String paramString1, String paramString2)
  {
    LogUtils.e("reportException", "!!!!!!!!!!!!!!!!!!!");
    LogUtils.e("reportException", paramString1);
    LogUtils.e("reportException", paramString2);
    if (this.mBridgeCallback != null) {
      this.mBridgeCallback.a(paramString1, paramString2);
    }
  }
  
  public native void runNativeRunnable(String paramString, long paramLong1, long paramLong2, NativeCallback paramNativeCallback);
  
  public native boolean runScriptFromAssets(String paramString1, AssetManager paramAssetManager, boolean paramBoolean, String paramString2, long paramLong, NativeCallback paramNativeCallback);
  
  public boolean runScriptFromAssets(String paramString1, AssetManager paramAssetManager, boolean paramBoolean, String paramString2, NativeCallback paramNativeCallback)
  {
    int i = 0;
    if (!this.mInit) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(mCodeCacheRootDir)))
    {
      LogUtils.e("HippyEngineMonitor", "runScriptFromAssets ======core====== " + paramString2 + ", canUseCodeCache == " + paramBoolean);
      paramString2 = mCodeCacheRootDir + paramString2 + File.separator;
      File localFile = new File(paramString2);
      StringBuilder localStringBuilder = new StringBuilder().append("codeCacheDir file size : ");
      if (localFile.listFiles() != null) {
        i = localFile.listFiles().length;
      }
      LogUtils.d("HippyEngineMonitor", i);
      return runScriptFromAssets(paramString1, paramAssetManager, paramBoolean, paramString2, this.mV8RuntimeId, paramNativeCallback);
    }
    LogUtils.e("HippyEngineMonitor", "runScriptFromAssets codeCacheTag is null");
    return runScriptFromAssets(paramString1, paramAssetManager, false, "" + paramString2 + File.separator, this.mV8RuntimeId, paramNativeCallback);
  }
  
  public native boolean runScriptFromFile(String paramString1, String paramString2, boolean paramBoolean, String paramString3, long paramLong, NativeCallback paramNativeCallback);
  
  public boolean runScriptFromFile(String paramString1, String paramString2, boolean paramBoolean, String paramString3, NativeCallback paramNativeCallback)
  {
    int i = 0;
    if (!this.mInit) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(mCodeCacheRootDir)))
    {
      LogUtils.e("HippyEngineMonitor", "runScriptFromFile ======core====== " + paramString3 + ", canUseCodeCache == " + paramBoolean);
      paramString3 = mCodeCacheRootDir + paramString3 + File.separator;
      File localFile = new File(paramString3);
      StringBuilder localStringBuilder = new StringBuilder().append("codeCacheDir file size : ");
      if (localFile.listFiles() != null) {
        i = localFile.listFiles().length;
      }
      LogUtils.d("HippyEngineMonitor", i);
      return runScriptFromFile(paramString1, paramString2, paramBoolean, paramString3, this.mV8RuntimeId, paramNativeCallback);
    }
    LogUtils.e("HippyEngineMonitor", "runScriptFromFile codeCacheTag is null");
    return runScriptFromFile(paramString1, paramString2, false, "" + paramString3 + File.separator, this.mV8RuntimeId, paramNativeCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.HippyBridgeImpl
 * JD-Core Version:    0.7.0.1
 */