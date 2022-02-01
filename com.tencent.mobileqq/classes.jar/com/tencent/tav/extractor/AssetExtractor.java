package com.tencent.tav.extractor;

import android.media.MediaFormat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.tav.ResourceLoadUtil;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.wrapper.ExtractorLoader;
import com.tencent.tav.extractor.wrapper.ExtractorWrapperPool;
import java.io.FileDescriptor;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Map;

public class AssetExtractor
  implements Cloneable
{
  public static boolean DOWNGRADING = false;
  public static final int SAMPLE_FLAG_ENCRYPTED = 2;
  public static final int SAMPLE_FLAG_SYNC = 1;
  public static final int SEEK_TO_CLOSEST_SYNC = 2;
  public static final int SEEK_TO_NEXT_SYNC = 1;
  public static final int SEEK_TO_PREVIOUS_SYNC = 0;
  private final String TAG;
  @Nullable
  private IExtractorDelegate delegate;
  private long duration;
  private long mNativeContext;
  private int preferRotation;
  private boolean released;
  private CGSize size;
  private String sourcePath;
  
  static
  {
    if (ResourceLoadUtil.isLoaded())
    {
      nativeInit();
    }
    else
    {
      System.out.println("loadlibrary : tav start");
      try
      {
        System.loadLibrary("tav");
        ResourceLoadUtil.setLoaded(true);
        nativeInit();
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public AssetExtractor()
  {
    this(DOWNGRADING);
  }
  
  public AssetExtractor(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AssetExtractor@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.TAG = localStringBuilder.toString();
    this.released = false;
    this.mNativeContext = 0L;
    this.sourcePath = "";
    this.duration = 0L;
    this.size = null;
    this.preferRotation = -1;
    if (paramBoolean) {
      this.delegate = ExtractorDelegateFactory.createDelegate();
    }
  }
  
  private synchronized native boolean advanceNative();
  
  private synchronized native long getSampleTimeNative();
  
  private synchronized native int getSampleTrackIndexNative();
  
  private final synchronized native int getTrackCountNative();
  
  @NonNull
  private synchronized native Map<String, Object> getTrackFormatNative(int paramInt);
  
  private final synchronized native void nativeFinalize();
  
  private static final synchronized native void nativeInit();
  
  private synchronized native int readSampleDataNative(@NonNull ByteBuffer paramByteBuffer, int paramInt);
  
  private final synchronized native void releaseNative();
  
  private native void seekToNative(long paramLong, int paramInt);
  
  private synchronized native void selectTrackNative(int paramInt);
  
  private synchronized native void unselectTrackNative(int paramInt);
  
  public boolean advance()
  {
    try
    {
      boolean bool;
      if (this.delegate != null)
      {
        bool = this.delegate.advance();
        return bool;
      }
      if (!this.released)
      {
        bool = advanceNative();
        return bool;
      }
      return false;
    }
    finally {}
  }
  
  public AssetExtractor clone()
  {
    AssetExtractor localAssetExtractor = new AssetExtractor();
    localAssetExtractor.setSize(getSize());
    localAssetExtractor.setPreferRotation(getPreferRotation());
    localAssetExtractor.setDuration(getDuration());
    localAssetExtractor.setDataSource(this.sourcePath);
    return localAssetExtractor;
  }
  
  public void dispose()
  {
    try
    {
      boolean bool = this.sourcePath.isEmpty();
      if (bool) {
        return;
      }
      if ((!this.released) && (this.delegate == null))
      {
        String str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("dispose: sourcePath = ");
        localStringBuilder.append(this.sourcePath);
        Logger.i(str, localStringBuilder.toString());
        releaseNative();
      }
      return;
    }
    finally {}
  }
  
  protected void finalize()
  {
    if (this.delegate != null) {
      return;
    }
    if (this.released) {
      return;
    }
    try
    {
      if (!this.released)
      {
        this.released = true;
        nativeFinalize();
      }
      return;
    }
    finally {}
  }
  
  public long getAudioDuration()
  {
    try
    {
      long l = ExtractorUtils.getAudioDuration(this);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getDuration()
  {
    try
    {
      if (this.duration == 0L) {
        this.duration = ExtractorUtils.getDuration(this);
      }
      long l = this.duration;
      return l;
    }
    finally {}
  }
  
  public int getPreferRotation()
  {
    try
    {
      if (this.preferRotation == -1) {
        this.preferRotation = ExtractorUtils.getPreferRotation(this);
      }
      int i = this.preferRotation;
      return i;
    }
    finally {}
  }
  
  public native int getSampleFlags();
  
  public long getSampleTime()
  {
    try
    {
      long l;
      String str;
      StringBuilder localStringBuilder;
      if (this.delegate != null)
      {
        l = this.delegate.getSampleTime();
        str = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSampleTime(delegate) :");
        localStringBuilder.append(l);
        Logger.v(str, localStringBuilder.toString());
        return l;
      }
      if (!this.released)
      {
        l = getSampleTimeNative();
        str = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSampleTime: ");
        localStringBuilder.append(l);
        Logger.v(str, localStringBuilder.toString());
        return l;
      }
      return -1L;
    }
    finally {}
  }
  
  public int getSampleTrackIndex()
  {
    try
    {
      int i;
      if (this.delegate != null)
      {
        i = this.delegate.getSampleTrackIndex();
        return i;
      }
      if (!this.released)
      {
        i = getSampleTrackIndexNative();
        return i;
      }
      return -1;
    }
    finally {}
  }
  
  public CGSize getSize()
  {
    try
    {
      if (this.size == null) {
        this.size = ExtractorUtils.getVideoSize(this);
      }
      CGSize localCGSize = this.size;
      return localCGSize;
    }
    finally {}
  }
  
  public String getSourcePath()
  {
    return this.sourcePath;
  }
  
  public final int getTrackCount()
  {
    try
    {
      int i;
      if (this.delegate != null)
      {
        i = this.delegate.getTrackCount();
        return i;
      }
      if (!this.released)
      {
        i = getTrackCountNative();
        return i;
      }
      return 0;
    }
    finally {}
  }
  
  @NonNull
  public MediaFormat getTrackFormat(int paramInt)
  {
    try
    {
      Object localObject1 = this.delegate;
      if (localObject1 != null) {
        try
        {
          localObject1 = this.delegate.getTrackFormat(paramInt);
          localObject3 = this.TAG;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("getTrackFormat(delegate): index = ");
          ((StringBuilder)localObject4).append(paramInt);
          ((StringBuilder)localObject4).append(", format = ");
          ((StringBuilder)localObject4).append(localObject1);
          Logger.v((String)localObject3, ((StringBuilder)localObject4).toString());
          return localObject1;
        }
        catch (Exception localException1)
        {
          localObject3 = this.TAG;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("delegate.getTrackFormat: ");
          ((StringBuilder)localObject4).append(localException1.getMessage());
          Logger.w((String)localObject3, ((StringBuilder)localObject4).toString());
        }
      }
      MediaFormat localMediaFormat = new MediaFormat();
      boolean bool = this.released;
      if (bool) {
        return localMediaFormat;
      }
      Object localObject3 = getTrackFormatNative(paramInt);
      try
      {
        localObject4 = MediaFormat.class.getDeclaredField("mMap");
        ((Field)localObject4).setAccessible(true);
        ((Field)localObject4).set(localMediaFormat, localObject3);
      }
      catch (Exception localException2)
      {
        Log.e("VideoCore", localException2.getMessage());
      }
      String str = this.TAG;
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("getTrackFormat: index = ");
      ((StringBuilder)localObject4).append(paramInt);
      ((StringBuilder)localObject4).append(", format = ");
      ((StringBuilder)localObject4).append(localMediaFormat);
      Logger.v(str, ((StringBuilder)localObject4).toString());
      return localMediaFormat;
    }
    finally {}
  }
  
  public boolean isReleased()
  {
    return this.released;
  }
  
  public boolean needMirror()
  {
    IExtractorDelegate localIExtractorDelegate = this.delegate;
    if (localIExtractorDelegate != null) {
      return localIExtractorDelegate.needMirror();
    }
    return true;
  }
  
  public int readSampleData(@NonNull ByteBuffer paramByteBuffer, int paramInt)
  {
    try
    {
      String str;
      StringBuilder localStringBuilder;
      if (this.delegate != null)
      {
        paramInt = this.delegate.readSampleData(paramByteBuffer, paramInt);
        str = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("readSampleData(delegate): ret = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", buf = ");
        localStringBuilder.append(paramByteBuffer);
        Logger.v(str, localStringBuilder.toString());
        return paramInt;
      }
      if (!this.released)
      {
        paramInt = readSampleDataNative(paramByteBuffer, paramInt);
        str = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("readSampleData: ret = ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", buf = ");
        localStringBuilder.append(paramByteBuffer);
        Logger.v(str, localStringBuilder.toString());
        return paramInt;
      }
      return -1;
    }
    finally {}
  }
  
  public final void release()
  {
    try
    {
      if (this.delegate != null)
      {
        this.delegate.release();
        this.delegate = null;
        return;
      }
      if (!this.released)
      {
        releaseNative();
        this.released = true;
      }
      return;
    }
    finally {}
  }
  
  public void seekTo(long paramLong, int paramInt)
  {
    try
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seekTo() called with: timeUs = [");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], mode = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      Logger.v(str, localStringBuilder.toString());
      if (this.delegate != null)
      {
        this.delegate.seekTo(paramLong, paramInt);
        return;
      }
      if (!this.released) {
        seekToNative(paramLong, paramInt);
      }
      return;
    }
    finally {}
  }
  
  public void selectTrack(int paramInt)
  {
    try
    {
      IExtractorDelegate localIExtractorDelegate = this.delegate;
      if (localIExtractorDelegate != null) {
        try
        {
          this.delegate.selectTrack(paramInt);
          return;
        }
        catch (Exception localException)
        {
          String str = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("delegate.selectTrack: ");
          localStringBuilder.append(localException.getMessage());
          Logger.w(str, localStringBuilder.toString());
          this.delegate = null;
        }
      }
      if (!this.released) {
        selectTrackNative(paramInt);
      }
      return;
    }
    finally {}
  }
  
  public final native void setDataSource(@NonNull FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2);
  
  public final void setDataSource(@NonNull String paramString)
  {
    try
    {
      IExtractorDelegate localIExtractorDelegate = this.delegate;
      if (localIExtractorDelegate != null) {
        try
        {
          this.delegate.setDataSource(paramString);
        }
        catch (Exception localException)
        {
          String str = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("delegate.setDataSource: ");
          localStringBuilder.append(localException.getMessage());
          Logger.w(str, localStringBuilder.toString());
          this.delegate = null;
        }
      }
      this.sourcePath = paramString;
      if (ExtractorWrapperPool.contains(paramString)) {
        ExtractorWrapperPool.fillIn(this.sourcePath, this);
      } else {
        ExtractorLoader.cacheExtractor(paramString);
      }
      return;
    }
    finally {}
  }
  
  public void setDuration(long paramLong)
  {
    this.duration = paramLong;
  }
  
  public void setPreferRotation(int paramInt)
  {
    this.preferRotation = paramInt;
  }
  
  public void setSize(CGSize paramCGSize)
  {
    this.size = paramCGSize;
  }
  
  public void unselectTrack(int paramInt)
  {
    try
    {
      if (this.delegate != null)
      {
        this.delegate.unselectTrack(paramInt);
        return;
      }
      if (!this.released) {
        unselectTrackNative(paramInt);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.extractor.AssetExtractor
 * JD-Core Version:    0.7.0.1
 */