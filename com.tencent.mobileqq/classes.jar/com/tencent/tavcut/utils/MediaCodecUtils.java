package com.tencent.tavcut.utils;

import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import android.util.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/utils/MediaCodecUtils;", "", "()V", "CODEC_LENGTH_2K", "", "CODEC_MAX_LENGTH", "DEFAULT_ALIGNMENT", "correctSupportEncodeSize", "Landroid/util/Size;", "width", "height", "mime", "", "decoderSupportSize", "", "getHeightAlignment", "codecInfo", "Landroid/media/MediaCodecInfo;", "getWidthAlignment", "isSupported", "supportMaxLength", "length", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class MediaCodecUtils
{
  public static final MediaCodecUtils a = new MediaCodecUtils();
  
  private final int a(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    int k = Build.VERSION.SDK_INT;
    int j = 16;
    int i = j;
    if (k >= 21)
    {
      i = j;
      if (paramMediaCodecInfo != null)
      {
        paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
        i = j;
        if (paramMediaCodecInfo != null)
        {
          paramMediaCodecInfo = paramMediaCodecInfo.getVideoCapabilities();
          i = j;
          if (paramMediaCodecInfo != null) {
            i = paramMediaCodecInfo.getWidthAlignment();
          }
        }
      }
    }
    return i;
  }
  
  private final boolean a(MediaCodecInfo paramMediaCodecInfo, String paramString, int paramInt1, int paramInt2)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (paramMediaCodecInfo != null))
    {
      paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
      Intrinsics.checkExpressionValueIsNotNull(paramMediaCodecInfo, "codecInfo.getCapabilitie…           mime\n        )");
      if (paramMediaCodecInfo.getVideoCapabilities().isSizeSupported(paramInt1, paramInt2)) {
        return true;
      }
    }
    return false;
  }
  
  private final int b(MediaCodecInfo paramMediaCodecInfo, String paramString)
  {
    int k = Build.VERSION.SDK_INT;
    int j = 16;
    int i = j;
    if (k >= 21)
    {
      i = j;
      if (paramMediaCodecInfo != null)
      {
        paramMediaCodecInfo = paramMediaCodecInfo.getCapabilitiesForType(paramString);
        i = j;
        if (paramMediaCodecInfo != null)
        {
          paramMediaCodecInfo = paramMediaCodecInfo.getVideoCapabilities();
          i = j;
          if (paramMediaCodecInfo != null) {
            i = paramMediaCodecInfo.getHeightAlignment();
          }
        }
      }
    }
    return i;
  }
  
  @NotNull
  public final Size a(int paramInt1, int paramInt2, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "mime");
    int m = MediaCodecList.getCodecCount();
    Object localObject = (MediaCodecInfo)null;
    int i = 0;
    while ((i < m) && (localObject == null))
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      Intrinsics.checkExpressionValueIsNotNull(localMediaCodecInfo, "info");
      if (!localMediaCodecInfo.isEncoder()) {}
      do
      {
        i += 1;
        break;
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        j = 0;
        k = 0;
        while ((j < arrayOfString.length) && (k == 0))
        {
          if (Intrinsics.areEqual(arrayOfString[j], paramString)) {
            k = 1;
          }
          j += 1;
        }
      } while (k == 0);
      i += 1;
      localObject = localMediaCodecInfo;
    }
    int j = a((MediaCodecInfo)localObject, paramString);
    i = b((MediaCodecInfo)localObject, paramString);
    double d2 = paramInt1;
    double d1 = j;
    Double.isNaN(d2);
    Double.isNaN(d1);
    double d3 = Math.ceil(d2 / d1);
    Double.isNaN(d1);
    j = (int)(d3 * d1);
    float f1 = paramInt2;
    float f2 = i;
    int k = (int)((float)Math.ceil(f1 / f2) * f2);
    i = k;
    paramInt1 = j;
    if (!a((MediaCodecInfo)localObject, paramString, j, k))
    {
      d1 = 16;
      Double.isNaN(d2);
      Double.isNaN(d1);
      d2 = Math.ceil(d2 / d1);
      Double.isNaN(d1);
      paramInt1 = (int)(d2 * d1);
      d2 = paramInt2;
      Double.isNaN(d2);
      Double.isNaN(d1);
      d2 = Math.ceil(d2 / d1);
      Double.isNaN(d1);
      i = (int)(d2 * d1);
    }
    return new Size(paramInt1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.utils.MediaCodecUtils
 * JD-Core Version:    0.7.0.1
 */