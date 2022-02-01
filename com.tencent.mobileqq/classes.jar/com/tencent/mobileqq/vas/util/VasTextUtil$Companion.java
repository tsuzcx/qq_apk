package com.tencent.mobileqq.vas.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/util/VasTextUtil$Companion;", "", "()V", "hideUinInShowString", "", "uin", "startShow", "", "isNumeral", "", "epId", "parseId", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public final class VasTextUtil$Companion
{
  @JvmStatic
  public final int a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "epId");
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  @JvmStatic
  @NotNull
  public final String a(@Nullable String paramString, int paramInt)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("**");
      if (paramInt >= paramString.length())
      {
        paramString = "-";
      }
      else
      {
        paramString = paramString.substring(paramInt);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).substring(startIndex)");
      }
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return "null";
  }
  
  @JvmStatic
  public final boolean a(@Nullable String paramString)
  {
    return (paramString == null) || (VasTextUtil.a.a(paramString) != -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.util.VasTextUtil.Companion
 * JD-Core Version:    0.7.0.1
 */