package com.tencent.tmediacodec.util;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.tmediacodec.codec.FormatWrapper;
import com.tencent.tmediacodec.codec.ReuseCodecWrapper;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tmediacodec/util/TUtils;", "", "()V", "CSD_0", "", "CSD_1", "CSD_2", "CSD_INDEX_ARRAY", "", "getCSD_INDEX_ARRAY", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "ceilDivide", "", "numerator", "denominator", "getCodeName", "codec", "Landroid/media/MediaCodec;", "getCodecMaxInputSize", "sampleMimeType", "width", "height", "secure", "", "getCsdBuffers", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "format", "Landroid/media/MediaFormat;", "getMaxInputSize", "codecWrapper", "Lcom/tencent/tmediacodec/codec/ReuseCodecWrapper;", "Lcom/tencent/tmediacodec/codec/FormatWrapper;", "getSurfaceTextureName", "surface", "Landroid/view/Surface;", "isAdaptive", "capabilities", "Landroid/media/MediaCodecInfo$CodecCapabilities;", "isAdaptiveV19", "isSecure", "isSecureV21", "isVideo", "nameOrType", "setCsdBuffers", "", "csdBuffers", "", "tmediacodec_lib_debug"}, k=1, mv={1, 1, 15})
public final class TUtils
{
  @NotNull
  public static final String CSD_0 = "csd-0";
  @NotNull
  public static final String CSD_1 = "csd-1";
  @NotNull
  public static final String CSD_2 = "csd-2";
  @NotNull
  private static final String[] CSD_INDEX_ARRAY = { "csd-0", "csd-1", "csd-2" };
  public static final TUtils INSTANCE = new TUtils();
  @NotNull
  public static final String TAG = "TUtils";
  
  @TargetApi(19)
  private final boolean isAdaptiveV19(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("adaptive-playback");
  }
  
  @TargetApi(21)
  private final boolean isSecureV21(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    return paramCodecCapabilities.isFeatureSupported("secure-playback");
  }
  
  public final int ceilDivide(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2 - 1) / paramInt2;
  }
  
  @NotNull
  public final String[] getCSD_INDEX_ARRAY()
  {
    return CSD_INDEX_ARRAY;
  }
  
  @NotNull
  public final String getCodeName(@NotNull MediaCodec paramMediaCodec)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaCodec, "codec");
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramMediaCodec = paramMediaCodec.getName();
      Intrinsics.checkExpressionValueIsNotNull(paramMediaCodec, "codec.name");
      return paramMediaCodec;
    }
    return "unknow-low-api-18";
  }
  
  public final int getCodecMaxInputSize(@NotNull String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = 2;
    Intrinsics.checkParameterIsNotNull(paramString, "sampleMimeType");
    if ((paramInt1 == -1) || (paramInt2 == -1)) {
      return -1;
    }
    switch (paramString.hashCode())
    {
    default: 
    case -1664118616: 
      do
      {
        return -1;
      } while (!paramString.equals("video/3gpp"));
      label95:
      paramInt1 *= paramInt2;
      paramInt2 = i;
    }
    for (;;)
    {
      label102:
      return paramInt1 * 3 / (paramInt2 * 2);
      if (!paramString.equals("video/avc")) {
        break;
      }
      if ((Intrinsics.areEqual("BRAVIA 4K 2015", Build.MODEL)) || ((Intrinsics.areEqual("Amazon", Build.MANUFACTURER)) && ((Intrinsics.areEqual("KFSOWI", Build.MODEL)) || ((Intrinsics.areEqual("AFTS", Build.MODEL)) && (paramBoolean)))))
      {
        return -1;
        if (!paramString.equals("video/x-vnd.on2.vp8")) {
          break;
        }
        paramInt1 *= paramInt2;
        paramInt2 = i;
        continue;
        if (!paramString.equals("video/hevc")) {
          break;
        }
        for (;;)
        {
          paramInt1 *= paramInt2;
          paramInt2 = 4;
          break label102;
          if (!paramString.equals("video/x-vnd.on2.vp9")) {
            break;
          }
        }
        if (!paramString.equals("video/mp4v-es")) {
          break;
        }
        break label95;
      }
      paramInt1 = ceilDivide(paramInt1, 16) * ceilDivide(paramInt2, 16) * 16 * 16;
      paramInt2 = i;
    }
  }
  
  @NotNull
  public final ArrayList<byte[]> getCsdBuffers(@NotNull MediaFormat paramMediaFormat)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaFormat, "format");
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = CSD_INDEX_ARRAY;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      ByteBuffer localByteBuffer = paramMediaFormat.getByteBuffer(arrayOfString[i]);
      if (localByteBuffer != null) {
        localArrayList.add(localByteBuffer.array());
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public final int getMaxInputSize(@NotNull ReuseCodecWrapper paramReuseCodecWrapper, @NotNull FormatWrapper paramFormatWrapper)
  {
    Intrinsics.checkParameterIsNotNull(paramReuseCodecWrapper, "codecWrapper");
    Intrinsics.checkParameterIsNotNull(paramFormatWrapper, "format");
    if (paramFormatWrapper.getMaxInputSize() != -1)
    {
      int k = paramFormatWrapper.getInitializationData().size();
      int i = 0;
      int j = 0;
      while (i < k)
      {
        j += ((byte[])paramFormatWrapper.getInitializationData().get(i)).length;
        i += 1;
      }
      return paramFormatWrapper.getMaxInputSize() + j;
    }
    return getCodecMaxInputSize(paramFormatWrapper.getSampleMimeType(), paramFormatWrapper.getWidth(), paramFormatWrapper.getHeight(), paramReuseCodecWrapper.getSecure());
  }
  
  @NotNull
  public final String getSurfaceTextureName(@NotNull Surface paramSurface)
  {
    Intrinsics.checkParameterIsNotNull(paramSurface, "surface");
    try
    {
      Field localField = ReflectUtils.getField(Surface.class, "mName");
      Intrinsics.checkExpressionValueIsNotNull(localField, "field");
      localField.setAccessible(true);
      paramSurface = String.valueOf(localField.get(paramSurface));
      return paramSurface;
    }
    catch (Throwable paramSurface)
    {
      LogUtils.INSTANCE.e("TUtils", "getSurfaceTextureName failed", paramSurface);
    }
    return "";
  }
  
  public final boolean isAdaptive(@NotNull MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    Intrinsics.checkParameterIsNotNull(paramCodecCapabilities, "capabilities");
    return (Build.VERSION.SDK_INT >= 19) && (isAdaptiveV19(paramCodecCapabilities));
  }
  
  public final boolean isSecure(@NotNull MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    Intrinsics.checkParameterIsNotNull(paramCodecCapabilities, "capabilities");
    return (Build.VERSION.SDK_INT >= 21) && (isSecureV21(paramCodecCapabilities));
  }
  
  public final boolean isVideo(@NotNull MediaFormat paramMediaFormat)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaFormat, "format");
    paramMediaFormat = paramMediaFormat.getString("mime");
    Intrinsics.checkExpressionValueIsNotNull(paramMediaFormat, "format.getString(MediaFormat.KEY_MIME)");
    return isVideo(paramMediaFormat);
  }
  
  public final boolean isVideo(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "nameOrType");
    return StringsKt.contains$default((CharSequence)paramString, (CharSequence)"video", false, 2, null);
  }
  
  public final void setCsdBuffers(@NotNull MediaFormat paramMediaFormat, @NotNull List<byte[]> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramMediaFormat, "format");
    Intrinsics.checkParameterIsNotNull(paramList, "csdBuffers");
    int i = 0;
    int j = ((Collection)paramList).size();
    while (i < j)
    {
      paramMediaFormat.setByteBuffer("csd-" + i, ByteBuffer.wrap((byte[])paramList.get(i)));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmediacodec.util.TUtils
 * JD-Core Version:    0.7.0.1
 */