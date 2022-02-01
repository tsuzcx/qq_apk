package com.tencent.videocut.utils;

import com.tencent.videocut.utils.log.Logger;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/ColorUtils;", "", "()V", "ALPHA_END_POSITION", "", "ALPHA_START_POSITION", "ARGB_COUNT", "COLOR_PREFIX", "", "OPAQUE", "", "RGB_COUNT", "RGB_END_POSITION", "RGB_START_POSITION", "TAG", "convertARGBToRGBA", "color", "isInvalidColor", "", "argbColor", "parseColor", "parseColorToStr", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class ColorUtils
{
  @NotNull
  public static final ColorUtils a = new ColorUtils();
  
  private final boolean b(String paramString)
  {
    if ((paramString.length() == 9) || (paramString.length() == 7)) {
      paramString = StringsKt.firstOrNull((CharSequence)paramString);
    }
    return (paramString == null) || ('#' != paramString.charValue());
  }
  
  @NotNull
  public final String a(int paramInt)
  {
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = new Object[1];
    localObject[0] = Integer.valueOf(paramInt & 0xFFFFFF);
    localObject = String.format("#%06X", Arrays.copyOf((Object[])localObject, localObject.length));
    Intrinsics.checkNotNullExpressionValue(localObject, "java.lang.String.format(format, *args)");
    return localObject;
  }
  
  @NotNull
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkNotNullParameter(paramString, "color");
    if (b(paramString))
    {
      Logger.a("ColorUtils", "Unknown color");
      return "";
    }
    if (paramString.length() == 7)
    {
      localStringBuilder = new StringBuilder();
      str = paramString.substring(0, 1);
      Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localStringBuilder.append(str);
      paramString = paramString.substring(1, 7);
      Intrinsics.checkNotNullExpressionValue(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localStringBuilder.append(paramString);
      localStringBuilder.append("ff");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = paramString.substring(0, 1);
    Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localStringBuilder.append(str);
    localStringBuilder.append(paramString.subSequence(3, 9));
    paramString = paramString.substring(1, 3);
    Intrinsics.checkNotNullExpressionValue(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.ColorUtils
 * JD-Core Version:    0.7.0.1
 */