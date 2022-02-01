package com.tencent.qqmusic.mediaplayer;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Arrays;
import java.util.Iterator;

public enum NativeLibs
{
  private static final SparseArray<String> SUFFIX;
  private static final String TAG = "NativeLibs";
  private boolean mHasLoadSoSuccess;
  private final String name;
  private final long supportedAbi;
  
  static
  {
    audioCommon = new NativeLibs("audioCommon", 1, "audio_common", 1L);
    QmNativeDataSource = new NativeLibs("QmNativeDataSource", 2, "QmNativeDataSource", 1L);
    formatDetector = new NativeLibs("formatDetector", 3, "FormatDetector", 1L);
    codecFactory = new NativeLibs("codecFactory", 4, "codec_factory", 3L);
    decoderJni = new NativeLibs("decoderJni", 5, "qqmusic_decoder_jni", 3L);
    FFmpeg = new NativeLibs("FFmpeg", 6, "FFmpeg_audio", 3L);
    cppShared = new NativeLibs("cppShared", 7, "c++_shared", 3L);
    stlportShared = new NativeLibs("stlportShared", 8, "stlport_shared", 3L);
    xlog = new NativeLibs("xlog", 9, "wechatxlog", 3L);
    $VALUES = new NativeLibs[] { nlog, audioCommon, QmNativeDataSource, formatDetector, codecFactory, decoderJni, FFmpeg, cppShared, stlportShared, xlog };
    SUFFIX = new SparseArray();
    SUFFIX.put(1, "");
    SUFFIX.put(2, "");
  }
  
  private NativeLibs(String paramString, long paramLong)
  {
    this.name = paramString;
    this.supportedAbi = paramLong;
  }
  
  public static boolean loadAll(Iterable<NativeLibs> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      if (!((NativeLibs)paramIterable.next()).load()) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean loadAll(NativeLibs... paramVarArgs)
  {
    return loadAll(Arrays.asList(paramVarArgs));
  }
  
  private boolean loadLibrary(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[loadLibrary] loading: ");
      localStringBuilder1.append(paramString);
      Logger.i("NativeLibs", localStringBuilder1.toString());
      bool2 = AudioPlayerConfigure.getSoLibraryLoader().load(paramString);
      bool1 = bool2;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder3 = new StringBuilder();
      localStringBuilder3.append("[loadLibrary] failed: ");
      localStringBuilder3.append(paramString);
      Logger.e("NativeLibs", localStringBuilder3.toString(), localThrowable);
    }
    if (bool1)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[loadLibrary] succeed: ");
      localStringBuilder2.append(paramString);
      Logger.i("NativeLibs", localStringBuilder2.toString());
      return bool1;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("[loadLibrary] failed: ");
    localStringBuilder2.append(paramString);
    Logger.e("NativeLibs", localStringBuilder2.toString());
    return bool1;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public boolean load()
  {
    if (this.mHasLoadSoSuccess) {
      return true;
    }
    this.mHasLoadSoSuccess = loadLibrary(getName());
    return this.mHasLoadSoSuccess;
  }
  
  public boolean supportAbi(int paramInt)
  {
    long l1 = this.supportedAbi;
    long l2 = paramInt;
    return (l1 & l2) == l2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.NativeLibs
 * JD-Core Version:    0.7.0.1
 */