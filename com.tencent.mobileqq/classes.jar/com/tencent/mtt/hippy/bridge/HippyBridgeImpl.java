package com.tencent.mtt.hippy.bridge;

import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.a.b;
import com.tencent.mtt.hippy.a.f.a;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.utils.ArgumentUtils;
import com.tencent.mtt.hippy.utils.FileUtils;
import com.tencent.mtt.hippy.utils.HippyBuffer;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class HippyBridgeImpl
  implements f.a, HippyBridge
{
  private static int TIMEOUT = 3000;
  private static volatile String mCodeCacheRootDir;
  private static volatile ThreadPoolExecutor mCodeCacheThreadExecutor;
  private static volatile int sBridgeNum;
  private static Object sBridgeSyncLock = new Object();
  private HippyBridge.a mBridgeCallback;
  private boolean mBridgeParamJson;
  private HippyEngineContext mContext;
  private String mDebugGobalConfig;
  private NativeCallback mDebugInitJSFrameworkCallback;
  private String mDebugServerHost;
  private b mDebugWebSocketClient;
  private HippyBuffer mHippyBuffer;
  private boolean mInit = false;
  private boolean mIsDevModule = false;
  private boolean mSingleThreadMode = false;
  private long mV8RuntimeId = 0L;
  
  public HippyBridgeImpl(HippyEngineContext arg1, HippyBridge.a parama, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    this.mBridgeCallback = parama;
    this.mSingleThreadMode = paramBoolean1;
    this.mBridgeParamJson = paramBoolean2;
    this.mIsDevModule = paramBoolean3;
    this.mDebugServerHost = paramString;
    this.mContext = ???;
    synchronized (sBridgeSyncLock)
    {
      sBridgeNum += 1;
      if (mCodeCacheRootDir == null)
      {
        parama = FileUtils.getHippyFile(this.mContext.getGlobalConfigs().getContext());
        if (parama != null)
        {
          paramString = new StringBuilder();
          paramString.append(parama.getAbsolutePath());
          paramString.append(File.separator);
          paramString.append("codecache");
          paramString.append(File.separator);
          mCodeCacheRootDir = paramString.toString();
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
      if (paramArrayOfByte == null) {
        paramArrayOfByte = "";
      } else {
        paramArrayOfByte = new String(paramArrayOfByte);
      }
      paramArrayOfByte = ArgumentUtils.parseToArray(paramArrayOfByte);
    }
    else
    {
      LogUtils.d("hippy_bridge", "bytesToArgument using HippyBuffer");
      paramArrayOfByte = this.mHippyBuffer.parse(paramArrayOfByte);
      if ((paramArrayOfByte instanceof HippyArray)) {
        paramArrayOfByte = (HippyArray)paramArrayOfByte;
      } else {
        paramArrayOfByte = null;
      }
    }
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      localObject = new HippyArray();
    }
    return localObject;
  }
  
  public static void deleteCodeCache(String paramString)
  {
    String[] arrayOfString = new File(mCodeCacheRootDir).list(new HippyBridgeImpl.a(paramString));
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(mCodeCacheRootDir);
      localStringBuilder.append(File.separator);
      localStringBuilder.append(arrayOfString[0]);
      new File(localStringBuilder.toString(), paramString).delete();
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
    b localb;
    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN)
    {
      paramArrayOfByte = new String(paramArrayOfByte, Charset.forName("UTF-16BE"));
      localb = this.mDebugWebSocketClient;
      if (localb == null) {
        return;
      }
    }
    else
    {
      paramArrayOfByte = new String(paramArrayOfByte, Charset.forName("UTF-16LE"));
      localb = this.mDebugWebSocketClient;
      if (localb == null) {
        return;
      }
    }
    localb.a(paramArrayOfByte);
  }
  
  public void callFunction(String paramString1, String paramString2, NativeCallback paramNativeCallback)
  {
    if ((this.mInit) && (!TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      paramString2 = paramString2.getBytes();
      callFunction(paramString1, paramString2, 0, paramString2.length, this.mV8RuntimeId, paramNativeCallback);
    }
  }
  
  public native void callFunction(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, long paramLong, NativeCallback paramNativeCallback);
  
  public void callFunction(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, NativeCallback paramNativeCallback)
  {
    if ((this.mInit) && (!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null) && (paramArrayOfByte.length != 0) && (paramInt1 >= 0) && (paramInt2 >= 0))
    {
      if (paramInt1 + paramInt2 > paramArrayOfByte.length) {
        return;
      }
      callFunction(paramString, paramArrayOfByte, paramInt1, paramInt2, this.mV8RuntimeId, paramNativeCallback);
    }
  }
  
  public void callNatives(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("callNatives [moduleName:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" , moduleFunc: ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("]");
    LogUtils.d("jni_callback", localStringBuilder.toString());
    if (this.mBridgeCallback != null)
    {
      paramArrayOfByte = bytesToArgument(paramArrayOfByte);
      this.mBridgeCallback.a(paramString1, paramString2, paramString3, paramArrayOfByte);
    }
  }
  
  public native void destroy(long paramLong, boolean paramBoolean, NativeCallback paramNativeCallback);
  
  public void destroy(NativeCallback paramNativeCallback)
  {
    destroy(this.mV8RuntimeId, this.mSingleThreadMode, paramNativeCallback);
  }
  
  public void fetchResourceWithUri(String paramString, long paramLong)
  {
    UIThreadUtils.runOnUiThread(new HippyBridgeImpl.2(this, paramString, paramLong));
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
  
  public void onDestroy()
  {
    ??? = this.mDebugWebSocketClient;
    if (??? != null)
    {
      ((b)???).a();
      this.mDebugWebSocketClient = null;
    }
    if (!this.mInit) {
      return;
    }
    this.mInit = false;
    synchronized (sBridgeSyncLock)
    {
      sBridgeNum -= 1;
      int i = sBridgeNum;
      if (i == 0)
      {
        try
        {
          if (mCodeCacheThreadExecutor != null) {
            mCodeCacheThreadExecutor.shutdownNow();
          }
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDestroy: ");
          localStringBuilder.append(localThrowable.getMessage());
          LogUtils.d("HippyBridgeImpl", localStringBuilder.toString());
        }
        mCodeCacheThreadExecutor = null;
      }
      if (!this.mBridgeParamJson)
      {
        ??? = this.mHippyBuffer;
        if (??? != null) {
          ((HippyBuffer)???).release();
        }
      }
      this.mV8RuntimeId = 0L;
      this.mBridgeCallback = null;
      return;
    }
  }
  
  public void onReceiveData(String paramString)
  {
    if (this.mIsDevModule)
    {
      paramString = paramString.getBytes();
      callFunction("onWebsocketMsg", paramString, 0, paramString.length, this.mV8RuntimeId, null);
    }
  }
  
  public native void onResourceReady(ByteBuffer paramByteBuffer, long paramLong1, long paramLong2);
  
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
    catch (Throwable paramString)
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("postCodeCacheRunnable: ");
      ((StringBuilder)???).append(paramString.getMessage());
      LogUtils.d("HippyBridgeImpl", ((StringBuilder)???).toString());
    }
  }
  
  public void reportException(String paramString1, String paramString2)
  {
    LogUtils.e("reportException", "!!!!!!!!!!!!!!!!!!!");
    LogUtils.e("reportException", paramString1);
    LogUtils.e("reportException", paramString2);
    HippyBridge.a locala = this.mBridgeCallback;
    if (locala != null) {
      locala.a(paramString1, paramString2);
    }
  }
  
  public native void runNativeRunnable(String paramString, long paramLong1, long paramLong2, NativeCallback paramNativeCallback);
  
  public native boolean runScriptFromAssets(String paramString1, AssetManager paramAssetManager, boolean paramBoolean, String paramString2, long paramLong, NativeCallback paramNativeCallback);
  
  public boolean runScriptFromAssets(String paramString1, AssetManager paramAssetManager, boolean paramBoolean, String paramString2, NativeCallback paramNativeCallback)
  {
    boolean bool = this.mInit;
    int i = 0;
    if (!bool) {
      return false;
    }
    Object localObject;
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(mCodeCacheRootDir)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("runScriptFromAssets ======core====== ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", canUseCodeCache == ");
      ((StringBuilder)localObject).append(paramBoolean);
      LogUtils.e("HippyEngineMonitor", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(mCodeCacheRootDir);
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(File.separator);
      paramString2 = ((StringBuilder)localObject).toString();
      localObject = new File(paramString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("codeCacheDir file size : ");
      if (((File)localObject).listFiles() != null) {
        i = ((File)localObject).listFiles().length;
      }
      localStringBuilder.append(i);
      LogUtils.d("HippyEngineMonitor", localStringBuilder.toString());
    }
    for (long l = this.mV8RuntimeId;; l = this.mV8RuntimeId)
    {
      return runScriptFromAssets(paramString1, paramAssetManager, paramBoolean, paramString2, l, paramNativeCallback);
      LogUtils.e("HippyEngineMonitor", "runScriptFromAssets codeCacheTag is null");
      paramBoolean = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(File.separator);
      paramString2 = ((StringBuilder)localObject).toString();
    }
  }
  
  public native boolean runScriptFromFile(String paramString1, String paramString2, boolean paramBoolean, String paramString3, long paramLong, NativeCallback paramNativeCallback);
  
  public boolean runScriptFromFile(String paramString1, String paramString2, boolean paramBoolean, String paramString3, NativeCallback paramNativeCallback)
  {
    boolean bool = this.mInit;
    int i = 0;
    if (!bool) {
      return false;
    }
    Object localObject;
    if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(mCodeCacheRootDir)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("runScriptFromFile ======core====== ");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", canUseCodeCache == ");
      ((StringBuilder)localObject).append(paramBoolean);
      LogUtils.e("HippyEngineMonitor", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(mCodeCacheRootDir);
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(File.separator);
      paramString3 = ((StringBuilder)localObject).toString();
      localObject = new File(paramString3);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("codeCacheDir file size : ");
      if (((File)localObject).listFiles() != null) {
        i = ((File)localObject).listFiles().length;
      }
      localStringBuilder.append(i);
      LogUtils.d("HippyEngineMonitor", localStringBuilder.toString());
    }
    for (long l = this.mV8RuntimeId;; l = this.mV8RuntimeId)
    {
      return runScriptFromFile(paramString1, paramString2, paramBoolean, paramString3, l, paramNativeCallback);
      LogUtils.e("HippyEngineMonitor", "runScriptFromFile codeCacheTag is null");
      paramBoolean = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(File.separator);
      paramString3 = ((StringBuilder)localObject).toString();
    }
  }
  
  public native boolean runScriptFromUri(String paramString1, AssetManager paramAssetManager, boolean paramBoolean, String paramString2, long paramLong, NativeCallback paramNativeCallback);
  
  public boolean runScriptFromUri(String paramString1, AssetManager paramAssetManager, boolean paramBoolean, String paramString2, NativeCallback paramNativeCallback)
  {
    boolean bool = this.mInit;
    int i = 0;
    if (!bool) {
      return false;
    }
    Object localObject;
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(mCodeCacheRootDir)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("runScriptFromAssets ======core====== ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", canUseCodeCache == ");
      ((StringBuilder)localObject).append(paramBoolean);
      LogUtils.d("HippyEngineMonitor", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(mCodeCacheRootDir);
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(File.separator);
      paramString2 = ((StringBuilder)localObject).toString();
      localObject = new File(paramString2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("codeCacheDir file size : ");
      if (((File)localObject).listFiles() != null) {
        i = ((File)localObject).listFiles().length;
      }
      localStringBuilder.append(i);
      LogUtils.d("HippyEngineMonitor", localStringBuilder.toString());
      return runScriptFromUri(paramString1, paramAssetManager, paramBoolean, paramString2, this.mV8RuntimeId, paramNativeCallback);
    }
    LogUtils.d("HippyEngineMonitor", "runScriptFromAssets codeCacheTag is null");
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(File.separator);
      paramBoolean = runScriptFromUri(paramString1, paramAssetManager, false, ((StringBuilder)localObject).toString(), this.mV8RuntimeId, paramNativeCallback);
      return paramBoolean;
    }
    catch (Throwable paramString1)
    {
      paramAssetManager = new StringBuilder();
      paramAssetManager.append("runScriptFromUri:");
      paramAssetManager.append(paramString1.getMessage());
      LogUtils.e("HippyBridgeImpl", paramAssetManager.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.HippyBridgeImpl
 * JD-Core Version:    0.7.0.1
 */