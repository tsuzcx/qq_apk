package com.tencent.qapmsdk.common.device;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.common.util.AndroidVersion.Companion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/device/DeviceMedia$Companion;", "", "()V", "TAG", "", "getMediaCodec", "common_release"}, k=1, mv={1, 1, 15})
public final class DeviceMedia$Companion
{
  @NotNull
  public final String getMediaCodec()
  {
    StringBuilder localStringBuilder = new StringBuilder(50);
    int i;
    try
    {
      if (!AndroidVersion.Companion.isL()) {
        break label153;
      }
      localObject1 = new MediaCodecList(1).getCodecInfos();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "MediaCodecList(MediaCode…st.ALL_CODECS).codecInfos");
      localObject2 = (Collection)new ArrayList();
      j = localObject1.length;
      i = 0;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      Object localObject1;
      int j;
      Object localObject3;
      localObject2 = Logger.INSTANCE;
      str1 = localNoClassDefFoundError.getMessage();
      if (str1 == null) {
        break label255;
      }
      for (;;)
      {
        ((Logger)localObject2).d(new String[] { "QAPM_common_DeviceMedia", str1, ": can not found class" });
        str1 = localStringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(str1, "sb.toString()");
        return str1;
        str1 = "NoClassDefFoundError";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label153:
        label255:
        Object localObject2 = Logger.INSTANCE;
        str2 = localException.getMessage();
        if (str2 != null) {}
        for (;;)
        {
          ((Logger)localObject2).d(new String[] { "QAPM_common_DeviceMedia", str2 });
          break;
          str2 = "catch Exception";
        }
        i += 1;
      }
    }
    if (i < j)
    {
      localObject3 = localObject1[i];
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "codec");
      if (localObject3.isEncoder()) {
        ((Collection)localObject2).add(localObject3);
      }
    }
    else
    {
      localObject1 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MediaCodecInfo)((Iterator)localObject1).next();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
        localStringBuilder.append(((MediaCodecInfo)localObject2).getName()).append(":");
        continue;
        j = MediaCodecList.getCodecCount();
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        localObject1 = MediaCodecList.getCodecInfoAt(i);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "codecInfo");
        if (!((MediaCodecInfo)localObject1).isEncoder()) {
          break label310;
        }
        localStringBuilder.append(((MediaCodecInfo)localObject1).getName()).append(":");
      }
      String str1;
      String str2;
      label310:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.common.device.DeviceMedia.Companion
 * JD-Core Version:    0.7.0.1
 */