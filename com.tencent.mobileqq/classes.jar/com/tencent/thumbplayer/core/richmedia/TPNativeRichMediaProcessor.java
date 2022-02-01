package com.tencent.thumbplayer.core.richmedia;

import android.content.Context;
import com.tencent.thumbplayer.core.common.TPFieldCalledByNative;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPNativeLog;

public class TPNativeRichMediaProcessor
  implements ITPNativeRichMediaProcessor
{
  @TPFieldCalledByNative
  private long mNativeContext = 0L;
  
  public TPNativeRichMediaProcessor(Context paramContext)
  {
    TPNativeLibraryLoader.loadLibIfNeeded(paramContext.getApplicationContext());
    try
    {
      _nativeSetup();
      return;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to create native rich media:");
      localStringBuilder.append(paramContext.getMessage());
      TPNativeLog.printLog(4, localStringBuilder.toString());
      throw new UnsupportedOperationException("Failed to create rich media");
    }
  }
  
  private native int _deselectFeatureAsync(int paramInt);
  
  private native int _getCurrentPositionMsFeatureData(long paramLong, int[] paramArrayOfInt, TPNativeRichMediaFeatureData paramTPNativeRichMediaFeatureData);
  
  private native TPNativeRichMediaFeature[] _getFeatures();
  
  private native void _nativeSetup();
  
  private native int _prepareAsync();
  
  private native void _release();
  
  private native int _reset();
  
  private native int _seek(long paramLong);
  
  private native int _selectFeatureAsync(int paramInt, TPNativeRichMediaRequestExtraInfo paramTPNativeRichMediaRequestExtraInfo);
  
  private native void _setInnerProcessorCallback(ITPNativeRichMediaInnerProcessorCallback paramITPNativeRichMediaInnerProcessorCallback);
  
  private native int _setPlaybackRate(float paramFloat);
  
  private native void _setProcessorCallback(ITPNativeRichMediaProcessorCallback paramITPNativeRichMediaProcessorCallback);
  
  private native int _setRichMediaSource(String paramString);
  
  public void deselectFeatureAsync(int paramInt)
  {
    try
    {
      paramInt = _deselectFeatureAsync(paramInt);
      if (paramInt == 0) {
        return;
      }
      if (paramInt == 1000012) {
        throw new IllegalArgumentException();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deSelectAsync:");
      localStringBuilder.append(paramInt);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
  }
  
  public TPNativeRichMediaFeatureData getCurrentPositionMsFeatureData(long paramLong, int[] paramArrayOfInt)
  {
    TPNativeRichMediaFeatureData localTPNativeRichMediaFeatureData = new TPNativeRichMediaFeatureData();
    try
    {
      int i = _getCurrentPositionMsFeatureData(paramLong, paramArrayOfInt, localTPNativeRichMediaFeatureData);
      if (i == 0) {
        return localTPNativeRichMediaFeatureData;
      }
      if (i == 1000012) {
        throw new IllegalArgumentException();
      }
      paramArrayOfInt = new StringBuilder();
      paramArrayOfInt.append("getCurrentTimeContent:");
      paramArrayOfInt.append(i);
      throw new IllegalStateException(paramArrayOfInt.toString());
    }
    catch (Throwable paramArrayOfInt)
    {
      TPNativeLog.printLog(4, paramArrayOfInt.getMessage());
    }
    return null;
  }
  
  public TPNativeRichMediaFeature[] getFeatures()
  {
    try
    {
      TPNativeRichMediaFeature[] arrayOfTPNativeRichMediaFeature = _getFeatures();
      return arrayOfTPNativeRichMediaFeature;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
    return new TPNativeRichMediaFeature[0];
  }
  
  public void prepareAsync()
  {
    try
    {
      int i = _prepareAsync();
      if (i == 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("prepareAsync:");
      localStringBuilder.append(i);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
  }
  
  public void release()
  {
    try
    {
      _release();
      return;
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
  }
  
  public void reset()
  {
    try
    {
      int i = _reset();
      if (i == 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reset:");
      localStringBuilder.append(i);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
  }
  
  public void seek(long paramLong)
  {
    try
    {
      int i = _seek(paramLong);
      if (i == 0) {
        return;
      }
      if (i == 1000012) {
        throw new IllegalArgumentException();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seek:");
      localStringBuilder.append(i);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
  }
  
  public void selectFeatureAsync(int paramInt, TPNativeRichMediaRequestExtraInfo paramTPNativeRichMediaRequestExtraInfo)
  {
    try
    {
      paramInt = _selectFeatureAsync(paramInt, paramTPNativeRichMediaRequestExtraInfo);
      if (paramInt == 0) {
        return;
      }
      if (paramInt == 1000012) {
        throw new IllegalArgumentException();
      }
      paramTPNativeRichMediaRequestExtraInfo = new StringBuilder();
      paramTPNativeRichMediaRequestExtraInfo.append("selectAsync:");
      paramTPNativeRichMediaRequestExtraInfo.append(paramInt);
      throw new IllegalStateException(paramTPNativeRichMediaRequestExtraInfo.toString());
    }
    catch (Throwable paramTPNativeRichMediaRequestExtraInfo)
    {
      TPNativeLog.printLog(4, paramTPNativeRichMediaRequestExtraInfo.getMessage());
    }
  }
  
  public void setInnerProcessorCallback(ITPNativeRichMediaInnerProcessorCallback paramITPNativeRichMediaInnerProcessorCallback)
  {
    try
    {
      _setInnerProcessorCallback(paramITPNativeRichMediaInnerProcessorCallback);
      return;
    }
    catch (Throwable paramITPNativeRichMediaInnerProcessorCallback)
    {
      TPNativeLog.printLog(4, paramITPNativeRichMediaInnerProcessorCallback.getMessage());
    }
  }
  
  public void setPlaybackRate(float paramFloat)
  {
    try
    {
      int i = _setPlaybackRate(paramFloat);
      if (i == 0) {
        return;
      }
      if (i == 1000012) {
        throw new IllegalArgumentException();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPlaybackRate:");
      localStringBuilder.append(i);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    catch (Throwable localThrowable)
    {
      TPNativeLog.printLog(4, localThrowable.getMessage());
    }
  }
  
  public void setProcessorCallback(ITPNativeRichMediaProcessorCallback paramITPNativeRichMediaProcessorCallback)
  {
    try
    {
      _setProcessorCallback(paramITPNativeRichMediaProcessorCallback);
      return;
    }
    catch (Throwable paramITPNativeRichMediaProcessorCallback)
    {
      TPNativeLog.printLog(4, paramITPNativeRichMediaProcessorCallback.getMessage());
    }
  }
  
  public void setRichMediaSource(String paramString)
  {
    try
    {
      int i = _setRichMediaSource(paramString);
      if (i == 0) {
        return;
      }
      if (i == 1000012) {
        throw new IllegalArgumentException();
      }
      paramString = new StringBuilder();
      paramString.append("setRichMediaSource:");
      paramString.append(i);
      throw new IllegalStateException(paramString.toString());
    }
    catch (Throwable paramString)
    {
      TPNativeLog.printLog(4, paramString.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.richmedia.TPNativeRichMediaProcessor
 * JD-Core Version:    0.7.0.1
 */