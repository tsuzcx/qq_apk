package com.tencent.mobileqq.vas.util;

import android.text.TextUtils;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/util/VersionUtil$Companion;", "", "()V", "isLaterVersion", "", "compareVersion", "", "targetVersion", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public final class VersionUtil$Companion
{
  @JvmStatic
  public final boolean a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "compareVersion");
    Intrinsics.checkParameterIsNotNull(paramString2, "targetVersion");
    paramString1 = (CharSequence)paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = (CharSequence)paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      paramString1 = ((Collection)new Regex("\\.").split(paramString1, 0)).toArray(new String[0]);
      if (paramString1 != null)
      {
        paramString1 = (String[])paramString1;
        paramString2 = ((Collection)new Regex("\\.").split(paramString2, 0)).toArray(new String[0]);
        if (paramString2 != null)
        {
          paramString2 = (String[])paramString2;
          int m = Math.max(paramString1.length, paramString2.length);
          int i = 0;
          for (;;)
          {
            if ((i >= m) || (i < paramString1.length)) {}
            try
            {
              j = Integer.parseInt(paramString1[i]);
            }
            catch (Exception localException1)
            {
              int j;
              label144:
              break label144;
            }
            j = 0;
            if (i < paramString2.length) {}
            try
            {
              k = Integer.parseInt(paramString2[i]);
            }
            catch (Exception localException2)
            {
              int k;
              label164:
              break label164;
            }
            k = 0;
            if (i != m - 1)
            {
              if (k > j) {
                return true;
              }
              if (k < j) {
                return false;
              }
            }
            else
            {
              if (k >= j) {
                return true;
              }
              if (k < j) {
                return false;
              }
            }
            i += 1;
          }
          return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.util.VersionUtil.Companion
 * JD-Core Version:    0.7.0.1
 */