package com.tencent.tavcut.utils;

import android.util.Size;
import com.tencent.tavcut.render.log.TavLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/utils/ResolutionUtils;", "", "()V", "MAX_EDGE_LENGTH", "", "MAX_PIXEL_COUNT", "ORIGIN_VIDEO_EXPORT_MAX_LENGTH", "TAG", "", "VIDEO_MIME", "getFixedResolution", "Landroid/util/Size;", "res", "preferMaxLength", "isResolutionInvalid", "", "resolution", "needCompress", "width", "height", "mimeType", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class ResolutionUtils
{
  public static final ResolutionUtils a = new ResolutionUtils();
  
  @NotNull
  public final Size a(@NotNull Size paramSize, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSize, "res");
    int k = paramSize.getWidth();
    int m = paramSize.getHeight();
    paramSize = new StringBuilder();
    paramSize.append("getFixedResolution(), input resolution，");
    paramSize.append(k);
    paramSize.append("x");
    paramSize.append(m);
    TavLogger.c("ResolutionUtils", paramSize.toString());
    int i = Math.max(k, m);
    if (i <= paramInt) {
      paramInt = i;
    }
    int j;
    if ((m >= k) && (m != paramInt))
    {
      i = (int)(k * paramInt / m);
      j = paramInt;
    }
    else
    {
      i = k;
      j = m;
      if (k > m)
      {
        i = k;
        j = m;
        if (k != paramInt)
        {
          j = (int)(m * paramInt / k);
          i = paramInt;
        }
      }
    }
    paramSize = MediaCodecUtils.a.a(i, j, "video/avc");
    return new Size(paramSize.getWidth(), paramSize.getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.utils.ResolutionUtils
 * JD-Core Version:    0.7.0.1
 */