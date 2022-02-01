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
    for (;;)
    {
      int i;
      String str2;
      try
      {
        boolean bool = AndroidVersion.Companion.isL();
        Object localObject1;
        Object localObject2;
        int j;
        if (bool)
        {
          localObject1 = new MediaCodecList(1).getCodecInfos();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "MediaCodecList(MediaCode…st.ALL_CODECS).codecInfos");
          localObject2 = (Collection)new ArrayList();
          j = localObject1.length;
          i = 0;
          if (i < j)
          {
            Object localObject3 = localObject1[i];
            Intrinsics.checkExpressionValueIsNotNull(localObject3, "codec");
            if (!localObject3.isEncoder()) {
              break label341;
            }
            ((Collection)localObject2).add(localObject3);
            break label341;
          }
          localObject1 = ((Iterable)localObject2).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MediaCodecInfo)((Iterator)localObject1).next();
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
            localStringBuilder.append(((MediaCodecInfo)localObject2).getName());
            localStringBuilder.append(":");
            continue;
          }
        }
        else
        {
          j = MediaCodecList.getCodecCount();
          i = 0;
          if (i < j)
          {
            localObject1 = MediaCodecList.getCodecInfoAt(i);
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "codecInfo");
            if (((MediaCodecInfo)localObject1).isEncoder())
            {
              localStringBuilder.append(((MediaCodecInfo)localObject1).getName());
              localStringBuilder.append(":");
            }
            i += 1;
            continue;
          }
        }
        String str1;
        str2 = localStringBuilder.toString();
      }
      catch (Exception localException)
      {
        localObject2 = Logger.INSTANCE;
        str1 = localException.getMessage();
        if (str1 == null) {
          str1 = "catch Exception";
        }
        ((Logger)localObject2).d(new String[] { "QAPM_common_DeviceMedia", str1 });
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
        localObject2 = Logger.INSTANCE;
        str2 = localNoClassDefFoundError.getMessage();
        if (str2 == null) {
          str2 = "NoClassDefFoundError";
        }
        ((Logger)localObject2).d(new String[] { "QAPM_common_DeviceMedia", str2, ": can not found class" });
      }
      Intrinsics.checkExpressionValueIsNotNull(str2, "sb.toString()");
      return str2;
      label341:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.device.DeviceMedia.Companion
 * JD-Core Version:    0.7.0.1
 */