package com.tencent.tav.extractor;

import android.content.res.AssetFileDescriptor;
import android.media.MediaFormat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.tencent.tav.ResourceLoadUtil;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.DecoderUtils;
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
  @Nullable
  private IAssetExtractorDelegate delegate;
  private long duration = 0L;
  private long mNativeContext = 0L;
  private int preferRotation = -1;
  private boolean released = false;
  private CGSize size = null;
  private String sourcePath = "";
  
  static
  {
    if (ResourceLoadUtil.isLoaded())
    {
      nativeInit();
      return;
    }
    System.out.println("loadlibrary : tav start");
    try
    {
      System.loadLibrary("tav");
      ResourceLoadUtil.setLoaded(true);
      nativeInit();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public AssetExtractor()
  {
    this(DOWNGRADING);
  }
  
  public AssetExtractor(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.delegate = new ApiAssetExtractorDelegate();
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
      if ((!this.released) && (this.delegate == null)) {
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
      long l = DecoderUtils.getAudioDuration(this);
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
        this.duration = DecoderUtils.getDuration(this);
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
      if (this.delegate != null)
      {
        l = this.delegate.getSampleTime();
        return l;
      }
      if (!this.released)
      {
        l = getSampleTimeNative();
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
      if (this.delegate != null)
      {
        localMediaFormat = this.delegate.getTrackFormat(paramInt);
        return localMediaFormat;
      }
      MediaFormat localMediaFormat = new MediaFormat();
      boolean bool = this.released;
      if (bool) {
        return localMediaFormat;
      }
      Map localMap = getTrackFormatNative(paramInt);
      try
      {
        Field localField = MediaFormat.class.getDeclaredField("mMap");
        localField.setAccessible(true);
        localField.set(localMediaFormat, localMap);
      }
      catch (Exception localException)
      {
        Log.e("VideoCore", localException.getMessage());
      }
      return localMediaFormat;
    }
    finally {}
  }
  
  public boolean isReleased()
  {
    return this.released;
  }
  
  public int readSampleData(@NonNull ByteBuffer paramByteBuffer, int paramInt)
  {
    try
    {
      if (this.delegate != null)
      {
        paramInt = this.delegate.readSampleData(paramByteBuffer, paramInt);
        return paramInt;
      }
      if (!this.released)
      {
        paramInt = readSampleDataNative(paramByteBuffer, paramInt);
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
      if (this.delegate != null)
      {
        this.delegate.selectTrack(paramInt);
        return;
      }
      if (!this.released) {
        selectTrackNative(paramInt);
      }
      return;
    }
    finally {}
  }
  
  public final void setDataSource(@NonNull AssetFileDescriptor paramAssetFileDescriptor)
  {
    try
    {
      if (this.delegate != null)
      {
        this.delegate.setDataSource(paramAssetFileDescriptor);
        return;
      }
      if (paramAssetFileDescriptor.getDeclaredLength() < 0L) {
        setDataSource(paramAssetFileDescriptor.getFileDescriptor());
      } else {
        setDataSource(paramAssetFileDescriptor.getFileDescriptor(), paramAssetFileDescriptor.getStartOffset(), paramAssetFileDescriptor.getDeclaredLength());
      }
      return;
    }
    finally {}
  }
  
  public final void setDataSource(@NonNull FileDescriptor paramFileDescriptor)
  {
    try
    {
      if (this.delegate != null)
      {
        this.delegate.setDataSource(paramFileDescriptor);
        return;
      }
      setDataSource(paramFileDescriptor, 0L, 576460752303423487L);
      return;
    }
    finally {}
  }
  
  public final native void setDataSource(@NonNull FileDescriptor paramFileDescriptor, long paramLong1, long paramLong2);
  
  public final void setDataSource(@NonNull String paramString)
  {
    try
    {
      if (this.delegate != null) {
        this.delegate.setDataSource(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.extractor.AssetExtractor
 * JD-Core Version:    0.7.0.1
 */