package com.tencent.tmediacodec.codec;

import com.tencent.tmediacodec.util.TUtils;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/codec/FormatWrapper;", "", "sampleMimeType", "", "(Ljava/lang/String;)V", "channelCount", "", "getChannelCount", "()I", "setChannelCount", "(I)V", "codecs", "getCodecs", "()Ljava/lang/String;", "setCodecs", "height", "getHeight", "setHeight", "initializationData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getInitializationData", "()Ljava/util/ArrayList;", "setInitializationData", "(Ljava/util/ArrayList;)V", "<set-?>", "", "isVideo", "()Z", "isVideoFieldInit", "maxHeight", "getMaxHeight", "setMaxHeight", "maxInputSize", "getMaxInputSize", "setMaxInputSize", "maxWidth", "getMaxWidth", "setMaxWidth", "rotationDegrees", "getRotationDegrees", "setRotationDegrees", "getSampleMimeType", "sampleRate", "getSampleRate", "setSampleRate", "width", "getWidth", "setWidth", "initializationDataEquals", "other", "Companion", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class FormatWrapper
{
  public static final FormatWrapper.Companion Companion = new FormatWrapper.Companion(null);
  public static final int NO_VALUE = -1;
  @NotNull
  public static final String TAG = "FormatWrapper";
  private int channelCount;
  @NotNull
  private String codecs;
  private int height;
  @NotNull
  private ArrayList<byte[]> initializationData;
  private boolean isVideo;
  private boolean isVideoFieldInit;
  private int maxHeight;
  private int maxInputSize;
  private int maxWidth;
  private int rotationDegrees;
  @NotNull
  private final String sampleMimeType;
  private int sampleRate;
  private int width;
  
  public FormatWrapper(@NotNull String paramString)
  {
    this.sampleMimeType = paramString;
    this.codecs = "";
    this.initializationData = new ArrayList();
    this.width = -1;
    this.height = -1;
    this.maxWidth = -1;
    this.maxHeight = -1;
    this.maxInputSize = -1;
  }
  
  public final int getChannelCount()
  {
    return this.channelCount;
  }
  
  @NotNull
  public final String getCodecs()
  {
    return this.codecs;
  }
  
  public final int getHeight()
  {
    return this.height;
  }
  
  @NotNull
  public final ArrayList<byte[]> getInitializationData()
  {
    return this.initializationData;
  }
  
  public final int getMaxHeight()
  {
    return this.maxHeight;
  }
  
  public final int getMaxInputSize()
  {
    return this.maxInputSize;
  }
  
  public final int getMaxWidth()
  {
    return this.maxWidth;
  }
  
  public final int getRotationDegrees()
  {
    return this.rotationDegrees;
  }
  
  @NotNull
  public final String getSampleMimeType()
  {
    return this.sampleMimeType;
  }
  
  public final int getSampleRate()
  {
    return this.sampleRate;
  }
  
  public final int getWidth()
  {
    return this.width;
  }
  
  public final boolean initializationDataEquals(@NotNull FormatWrapper paramFormatWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramFormatWrapper, "other");
    if (this.initializationData.size() != paramFormatWrapper.initializationData.size()) {
      return false;
    }
    int j = this.initializationData.size();
    int i = 0;
    while (i < j)
    {
      Object localObject1 = this.initializationData.get(i);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "initializationData[i]");
      localObject1 = (byte[])localObject1;
      Object localObject2 = paramFormatWrapper.initializationData.get(i);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "other.initializationData[i]");
      if (!Arrays.equals((byte[])localObject1, (byte[])localObject2)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final boolean isVideo()
  {
    if (!this.isVideoFieldInit)
    {
      this.isVideoFieldInit = true;
      this.isVideo = TUtils.INSTANCE.isVideo(this.sampleMimeType);
    }
    return this.isVideo;
  }
  
  public final void setChannelCount(int paramInt)
  {
    this.channelCount = paramInt;
  }
  
  public final void setCodecs(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.codecs = paramString;
  }
  
  public final void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public final void setInitializationData(@NotNull ArrayList<byte[]> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "<set-?>");
    this.initializationData = paramArrayList;
  }
  
  public final void setMaxHeight(int paramInt)
  {
    this.maxHeight = paramInt;
  }
  
  public final void setMaxInputSize(int paramInt)
  {
    this.maxInputSize = paramInt;
  }
  
  public final void setMaxWidth(int paramInt)
  {
    this.maxWidth = paramInt;
  }
  
  public final void setRotationDegrees(int paramInt)
  {
    this.rotationDegrees = paramInt;
  }
  
  public final void setSampleRate(int paramInt)
  {
    this.sampleRate = paramInt;
  }
  
  public final void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.FormatWrapper
 * JD-Core Version:    0.7.0.1
 */