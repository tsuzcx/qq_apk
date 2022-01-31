package com.tencent.tmediacodec.codec;

import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.tmediacodec.util.LogUtils;
import com.tencent.tmediacodec.util.TUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/codec/FormatWrapper$Companion;", "", "()V", "NO_VALUE", "", "TAG", "", "create", "Lcom/tencent/tmediacodec/codec/FormatWrapper;", "mediaFormat", "Landroid/media/MediaFormat;", "getInteger", "key", "defaultValue", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class FormatWrapper$Companion
{
  @NotNull
  public final FormatWrapper create(@NotNull MediaFormat paramMediaFormat)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaFormat, "mediaFormat");
    Object localObject = paramMediaFormat.getString("mime");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mimeType");
    localObject = new FormatWrapper((String)localObject);
    try
    {
      ((FormatWrapper)localObject).setSampleRate(getInteger$default(FormatWrapper.Companion, paramMediaFormat, "sample-rate", 0, 4, null));
      ((FormatWrapper)localObject).setMaxInputSize(getInteger$default(FormatWrapper.Companion, paramMediaFormat, "max-input-size", 0, 4, null));
      ((FormatWrapper)localObject).setInitializationData(TUtils.INSTANCE.getCsdBuffers(paramMediaFormat));
      if (((FormatWrapper)localObject).isVideo())
      {
        ((FormatWrapper)localObject).setRotationDegrees(getInteger$default(FormatWrapper.Companion, paramMediaFormat, "rotation-degrees", 0, 4, null));
        ((FormatWrapper)localObject).setWidth(getInteger$default(FormatWrapper.Companion, paramMediaFormat, "width", 0, 4, null));
        ((FormatWrapper)localObject).setHeight(getInteger$default(FormatWrapper.Companion, paramMediaFormat, "height", 0, 4, null));
        if (Build.VERSION.SDK_INT >= 19)
        {
          ((FormatWrapper)localObject).setMaxWidth(getInteger$default(FormatWrapper.Companion, paramMediaFormat, "max-width", 0, 4, null));
          ((FormatWrapper)localObject).setMaxHeight(getInteger$default(FormatWrapper.Companion, paramMediaFormat, "max-height", 0, 4, null));
        }
      }
      else
      {
        ((FormatWrapper)localObject).setChannelCount(getInteger$default(FormatWrapper.Companion, paramMediaFormat, "channel-count", 0, 4, null));
      }
    }
    catch (Throwable paramMediaFormat)
    {
      LogUtils.INSTANCE.e("FormatWrapper", "create format error", paramMediaFormat);
      return localObject;
    }
    return localObject;
  }
  
  public final int getInteger(@NotNull MediaFormat paramMediaFormat, @NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaFormat, "mediaFormat");
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    if (paramMediaFormat.containsKey(paramString)) {
      paramInt = paramMediaFormat.getInteger(paramString);
    }
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.FormatWrapper.Companion
 * JD-Core Version:    0.7.0.1
 */