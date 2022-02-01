package com.tencent.mobileqq.vas.gldrawable;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/gldrawable/Utils;", "", "()V", "getHardwareDecodec", "Ljava/util/ArrayList;", "Landroid/media/MediaCodecInfo;", "Lkotlin/collections/ArrayList;", "mime", "", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public final class Utils
{
  public static final Utils a = new Utils();
  
  @JvmStatic
  @NotNull
  public static final ArrayList<MediaCodecInfo> a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "mime");
    ArrayList localArrayList = new ArrayList();
    if (Build.VERSION.SDK_INT < 16) {
      return localArrayList;
    }
    for (;;)
    {
      int j;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MediaCodec support list:");
        Intrinsics.checkExpressionValueIsNotNull(localStringBuilder, "append(value)");
        StringsKt.appendln(localStringBuilder);
        int k = MediaCodecList.getCodecCount();
        int i = 0;
        if (i < k)
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
          Intrinsics.checkExpressionValueIsNotNull(localMediaCodecInfo, "it");
          boolean bool = localMediaCodecInfo.isEncoder();
          Object localObject2 = null;
          if (bool) {
            localMediaCodecInfo = null;
          }
          if (localMediaCodecInfo != null)
          {
            localStringBuilder.append(localMediaCodecInfo.getName());
            Intrinsics.checkExpressionValueIsNotNull(localStringBuilder, "append(value)");
            StringsKt.appendln(localStringBuilder);
            localStringBuilder.append(Arrays.toString(localMediaCodecInfo.getSupportedTypes()));
            Intrinsics.checkExpressionValueIsNotNull(localStringBuilder, "append(value)");
            StringsKt.appendln(localStringBuilder);
            if (localMediaCodecInfo != null)
            {
              Object localObject1 = localMediaCodecInfo.getName();
              Intrinsics.checkExpressionValueIsNotNull(localObject1, "info.name");
              if (!StringsKt.contains((CharSequence)localObject1, (CharSequence)".sw.", true))
              {
                localObject1 = localMediaCodecInfo.getName();
                Intrinsics.checkExpressionValueIsNotNull(localObject1, "info.name");
                if (!StringsKt.contains((CharSequence)localObject1, (CharSequence)".google.", true))
                {
                  String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
                  Intrinsics.checkExpressionValueIsNotNull(arrayOfString, "info.supportedTypes");
                  int m = arrayOfString.length;
                  j = 0;
                  localObject1 = localObject2;
                  if (j < m)
                  {
                    localObject1 = arrayOfString[j];
                    if (!StringsKt.equals((String)localObject1, paramString, true)) {
                      break label301;
                    }
                  }
                  if (localObject1 != null) {
                    localArrayList.add(localMediaCodecInfo);
                  }
                }
              }
            }
          }
          i += 1;
        }
        else
        {
          return localArrayList;
        }
      }
      catch (Throwable paramString)
      {
        return localArrayList;
      }
      label301:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.gldrawable.Utils
 * JD-Core Version:    0.7.0.1
 */