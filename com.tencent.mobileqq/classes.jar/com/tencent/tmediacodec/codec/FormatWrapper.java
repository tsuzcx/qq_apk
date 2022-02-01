package com.tencent.tmediacodec.codec;

import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import java.util.ArrayList;

public final class FormatWrapper
{
  public static final int NO_VALUE = -1;
  public static final String TAG = "FormatWrapper";
  public int channelCount;
  @NonNull
  private String codecs = "";
  public int height = -1;
  @NonNull
  public ArrayList<byte[]> initializationData = new ArrayList();
  private boolean isVideo;
  private boolean isVideoFieldInit;
  public int maxHeight = -1;
  public int maxInputSize = -1;
  public int maxWidth = -1;
  public int rotationDegrees;
  @NonNull
  public final String sampleMimeType;
  public int sampleRate;
  public int width = -1;
  
  public FormatWrapper(@NonNull String paramString)
  {
    this.sampleMimeType = paramString;
  }
  
  private static String configCsdArray(String paramString, byte[] paramArrayOfByte)
  {
    paramString = new StringBuilder(paramString);
    paramString.append(", length:");
    paramString.append(paramArrayOfByte.length);
    paramString.append("  [");
    int i = 0;
    while (i < Math.min(paramArrayOfByte.length, 20))
    {
      if (i != 0) {
        paramString.append(" ,");
      }
      paramString.append(paramArrayOfByte[i]);
      i += 1;
    }
    paramString.append("]");
    return paramString.toString();
  }
  
  public static FormatWrapper create(@NonNull MediaFormat paramMediaFormat)
  {
    FormatWrapper localFormatWrapper = new FormatWrapper(paramMediaFormat.getString("mime"));
    try
    {
      localFormatWrapper.sampleRate = getInteger(paramMediaFormat, "sample-rate");
      localFormatWrapper.maxInputSize = getInteger(paramMediaFormat, "max-input-size");
      localFormatWrapper.initializationData = TUtils.getCsdBuffers(paramMediaFormat);
      if (localFormatWrapper.isVideo())
      {
        localFormatWrapper.rotationDegrees = getInteger(paramMediaFormat, "rotation-degrees");
        localFormatWrapper.width = getInteger(paramMediaFormat, "width");
        localFormatWrapper.height = getInteger(paramMediaFormat, "height");
        if (Build.VERSION.SDK_INT >= 19)
        {
          localFormatWrapper.maxWidth = getInteger(paramMediaFormat, "max-width");
          localFormatWrapper.maxHeight = getInteger(paramMediaFormat, "max-height");
          return localFormatWrapper;
        }
      }
      else
      {
        localFormatWrapper.channelCount = getInteger(paramMediaFormat, "channel-count");
        return localFormatWrapper;
      }
    }
    catch (Throwable paramMediaFormat)
    {
      LogUtils.e("FormatWrapper", "create format error", paramMediaFormat);
    }
    return localFormatWrapper;
  }
  
  public static void dumpCsdArray(ArrayList<byte[]> paramArrayList)
  {
    if (paramArrayList == null) {}
    while (!LogUtils.isLogEnable()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayList.size())
    {
      localStringBuilder.append(configCsdArray(TUtils.CSD_INDEX_ARRAY[i], (byte[])paramArrayList.get(i)));
      localStringBuilder.append("\n");
      i += 1;
    }
    LogUtils.d("FormatWrapper", "csdData size:" + paramArrayList.size() + "    " + localStringBuilder.toString());
  }
  
  public static int getInteger(@NonNull MediaFormat paramMediaFormat, @NonNull String paramString)
  {
    return getInteger(paramMediaFormat, paramString, -1);
  }
  
  public static int getInteger(@NonNull MediaFormat paramMediaFormat, @NonNull String paramString, int paramInt)
  {
    if (paramMediaFormat.containsKey(paramString)) {
      paramInt = paramMediaFormat.getInteger(paramString);
    }
    return paramInt;
  }
  
  public final boolean initializationDataEquals(@NonNull FormatWrapper paramFormatWrapper)
  {
    if (this.initializationData.size() != paramFormatWrapper.initializationData.size()) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.initializationData.size()) {
        break label64;
      }
      if (!((byte[])this.initializationData.get(i)).equals(paramFormatWrapper.initializationData.get(i))) {
        break;
      }
      i += 1;
    }
    label64:
    return true;
  }
  
  public final boolean isVideo()
  {
    if (!this.isVideoFieldInit)
    {
      this.isVideoFieldInit = true;
      this.isVideo = TUtils.isVideo(this.sampleMimeType);
    }
    return this.isVideo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.FormatWrapper
 * JD-Core Version:    0.7.0.1
 */