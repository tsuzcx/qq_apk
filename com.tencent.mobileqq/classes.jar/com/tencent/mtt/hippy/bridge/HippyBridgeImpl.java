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

public class HippyBridgeImpl
  implements f.a, HippyBridge
{
  private static volatile String mCodeCacheRootDir;
  private static final Object sBridgeSyncLock = new Object();
  private HippyBridge.a mBridgeCallback;
  private final boolean mBridgeParamJson;
  private final HippyEngineContext mContext;
  private String mDebugGobalConfig;
  private NativeCallback mDebugInitJSFrameworkCallback;
  private String mDebugServerHost;
  private b mDebugWebSocketClient;
  private HippyBuffer mHippyBuffer;
  private boolean mInit = false;
  private boolean mIsDevModule;
  private boolean mSingleThreadMode;
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
    Object localObject = this.mDebugWebSocketClient;
    if (localObject != null)
    {
      ((b)localObject).a();
      this.mDebugWebSocketClient = null;
    }
    if (!this.mInit) {
      return;
    }
    this.mInit = false;
    if (!this.mBridgeParamJson)
    {
      localObject = this.mHippyBuffer;
      if (localObject != null) {
        ((HippyBuffer)localObject).release();
      }
    }
    this.mV8RuntimeId = 0L;
    this.mBridgeCallback = null;
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
  
  public native boolean runScriptFromUri(String paramString1, AssetManager paramAssetManager, boolean paramBoolean, String paramString2, long paramLong, NativeCallback paramNativeCallback);
  
  public boolean runScriptFromUri(String paramString1, AssetManager paramAssetManager, boolean paramBoolean, String paramString2, NativeCallback paramNativeCallback)
  {
    if (!this.mInit) {
      return false;
    }
    StringBuilder localStringBuilder;
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(mCodeCacheRootDir)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(mCodeCacheRootDir);
      localStringBuilder.append(paramString2);
      localStringBuilder.append(File.separator);
      return runScriptFromUri(paramString1, paramAssetManager, paramBoolean, localStringBuilder.toString(), this.mV8RuntimeId, paramNativeCallback);
    }
    LogUtils.d("HippyEngineMonitor", "runScriptFromAssets codeCacheTag is null");
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(File.separator);
      paramBoolean = runScriptFromUri(paramString1, paramAssetManager, false, localStringBuilder.toString(), this.mV8RuntimeId, paramNativeCallback);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.HippyBridgeImpl
 * JD-Core Version:    0.7.0.1
 */