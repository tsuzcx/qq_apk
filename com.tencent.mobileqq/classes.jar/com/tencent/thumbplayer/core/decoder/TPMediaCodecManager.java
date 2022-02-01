package com.tencent.thumbplayer.core.decoder;

import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.common.TPMethodCalledByNative;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import java.util.concurrent.atomic.AtomicInteger;

@RequiresApi(api=16)
public class TPMediaCodecManager
{
  private static final String TAG = "TPMediaCodecManager";
  private static AtomicInteger codecNum = new AtomicInteger(0);
  private static SparseArray<ITPMediaCodecDecoder> mCodecList = new SparseArray();
  
  private static native void _onMediaCodecException(int paramInt, String paramString);
  
  private static native void _onMediaCodecReady(int paramInt, String paramString);
  
  private static native void _onMediaDrmInfo(int paramInt, Object paramObject);
  
  private static void addCodecToList(int paramInt, ITPMediaCodecDecoder paramITPMediaCodecDecoder)
  {
    try
    {
      mCodecList.put(paramInt, paramITPMediaCodecDecoder);
      return;
    }
    finally {}
  }
  
  @TPMethodCalledByNative
  public static int createMediaCodec(boolean paramBoolean)
  {
    if (codecNum.get() >= 2147483647) {
      codecNum.set(0);
    }
    int i = codecNum.getAndIncrement();
    Object localObject;
    if (paramBoolean) {
      localObject = new TPMediaCodecAudioDecoder(i);
    } else {
      localObject = new TPMediaCodecVideoDecoder(i);
    }
    addCodecToList(i, (ITPMediaCodecDecoder)localObject);
    return i;
  }
  
  @TPMethodCalledByNative
  public static int flushMediaCodec(int paramInt)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "flushMediaCodec failed!");
      return 3;
    }
    return localITPMediaCodecDecoder.flush();
  }
  
  private static ITPMediaCodecDecoder getCodecById(int paramInt)
  {
    try
    {
      Object localObject1 = (ITPMediaCodecDecoder)mCodecList.get(paramInt);
      if (localObject1 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("No such codec by id:");
        ((StringBuilder)localObject1).append(paramInt);
        TPNativeLog.printLog(3, "TPMediaCodecManager", ((StringBuilder)localObject1).toString());
        return null;
      }
      return localObject1;
    }
    finally {}
  }
  
  @TPMethodCalledByNative
  public static int getSDKVersion()
  {
    return Build.VERSION.SDK_INT;
  }
  
  @TPMethodCalledByNative
  public static boolean initAudioMediaCodec(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "initAudioMediaCodec failed!");
      return false;
    }
    if (!localITPMediaCodecDecoder.initDecoder(paramString, paramInt2, paramInt3, paramInt4, paramInt5)) {
      return false;
    }
    return localITPMediaCodecDecoder.startDecoder();
  }
  
  @TPMethodCalledByNative
  public static boolean initVideoMediaCodec(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, Surface paramSurface, int paramInt5, int paramInt6, int paramInt7)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "initVideoMediaCodec failed!");
      return false;
    }
    if (!localITPMediaCodecDecoder.initDecoder(paramString, paramInt2, paramInt3, paramInt4, paramSurface, paramInt5, paramInt6, paramInt7)) {
      return false;
    }
    return localITPMediaCodecDecoder.startDecoder();
  }
  
  public static void onMediaCodecException(int paramInt, String paramString)
  {
    _onMediaCodecException(paramInt, paramString);
  }
  
  public static void onMediaCodecReady(int paramInt, String paramString)
  {
    _onMediaCodecReady(paramInt, paramString);
  }
  
  public static void onMediaDrmInfo(int paramInt, Object paramObject)
  {
    _onMediaDrmInfo(paramInt, paramObject);
  }
  
  @TPMethodCalledByNative
  public static TPFrameInfo receiveOneFrame(int paramInt)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "receiveOneFrame failed!");
      return null;
    }
    return localITPMediaCodecDecoder.dequeueOutputBuffer();
  }
  
  @TPMethodCalledByNative
  public static int releaseMediaCodec(int paramInt)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "releaseMediaCodec failed!");
      return 3;
    }
    removeCodecFromList(paramInt);
    return localITPMediaCodecDecoder.release();
  }
  
  @TPMethodCalledByNative
  public static int releaseVideoFrame(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "releaseVideoFrame failed!");
      return 3;
    }
    return localITPMediaCodecDecoder.releaseOutputBuffer(paramInt2, paramBoolean);
  }
  
  private static void removeCodecFromList(int paramInt)
  {
    try
    {
      mCodecList.remove(paramInt);
      return;
    }
    finally {}
  }
  
  @TPMethodCalledByNative
  public static int sendOnePacket(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "sendOnePacket failed!");
      return 3;
    }
    return localITPMediaCodecDecoder.decode(paramArrayOfByte, paramBoolean1, paramLong, paramBoolean2);
  }
  
  @TPMethodCalledByNative
  public static void setCryptoInfo(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt3)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamObject failed!");
      return;
    }
    localITPMediaCodecDecoder.setCryptoInfo(paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfByte1, paramArrayOfByte2, paramInt3);
  }
  
  @TPMethodCalledByNative
  public static int setMediaCodecOperateRate(int paramInt, float paramFloat)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecOperateRate failed!");
      return 3;
    }
    return localITPMediaCodecDecoder.setOperateRate(paramFloat);
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamBool(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamBool failed!");
      return false;
    }
    return localITPMediaCodecDecoder.setParamBool(paramInt2, paramBoolean);
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamBytes(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamBytes failed!");
      return false;
    }
    return localITPMediaCodecDecoder.setParamBytes(paramInt2, paramArrayOfByte);
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamInt(int paramInt1, int paramInt2, int paramInt3)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamInt failed!");
      return false;
    }
    return localITPMediaCodecDecoder.setParamInt(paramInt2, paramInt3);
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamLong(int paramInt1, int paramInt2, long paramLong)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamLong failed!");
      return false;
    }
    return localITPMediaCodecDecoder.setParamLong(paramInt2, paramLong);
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamObject(int paramInt1, int paramInt2, Object paramObject)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamObject failed!");
      return false;
    }
    return localITPMediaCodecDecoder.setParamObject(paramInt2, paramObject);
  }
  
  @TPMethodCalledByNative
  public static boolean setMediaCodecParamString(int paramInt1, int paramInt2, String paramString)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt1);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecParamString failed!");
      return false;
    }
    return localITPMediaCodecDecoder.setParamString(paramInt2, paramString);
  }
  
  @TPMethodCalledByNative
  public static int setMediaCodecSurface(int paramInt, Surface paramSurface)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "setMediaCodecSurface failed!");
      return 3;
    }
    return localITPMediaCodecDecoder.setOutputSurface(paramSurface);
  }
  
  @TPMethodCalledByNative
  public static int signalEndOfStream(int paramInt)
  {
    ITPMediaCodecDecoder localITPMediaCodecDecoder = getCodecById(paramInt);
    if (localITPMediaCodecDecoder == null)
    {
      TPNativeLog.printLog(3, "TPMediaCodecManager", "signalEndOfStream failed!");
      return 3;
    }
    return localITPMediaCodecDecoder.signalEndOfStream();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPMediaCodecManager
 * JD-Core Version:    0.7.0.1
 */