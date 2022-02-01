package com.tencent.xaction.api.util;

import android.text.TextUtils;
import com.tencent.xaction.api.IRuleManager;
import com.tencent.xaction.impl.XAEngine;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/FilePathUtil$Companion;", "", "()V", "getAbsPath", "", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "path", "rootPath", "getAbsPathWithParent", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class FilePathUtil$Companion
{
  @JvmStatic
  @Nullable
  public final String a(@NotNull String paramString, @NotNull XAEngine paramXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    if (!StringsKt.contains$default((CharSequence)paramString, (CharSequence)"$PARENT_ROOT", false, 2, null)) {}
    do
    {
      return paramString;
      paramXAEngine = String.valueOf(paramXAEngine.getRuleManager().a("$PARENT_ROOT"));
    } while (TextUtils.isEmpty((CharSequence)paramXAEngine));
    return StringsKt.replace$default(paramString, "$PARENT_ROOT", paramXAEngine, false, 4, null);
  }
  
  @JvmStatic
  @NotNull
  public final String a(@NotNull String paramString1, @Nullable String paramString2, @Nullable XAEngine paramXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "path");
    String str = paramString1;
    if (StringsKt.indexOf$default((CharSequence)paramString1, "./", 0, false, 6, null) == 0)
    {
      str = paramString1;
      if (!TextUtils.isEmpty((CharSequence)paramString2))
      {
        if (paramString2 == null) {
          Intrinsics.throwNpe();
        }
        if ((StringsKt.indexOf$default((CharSequence)paramString2, "$", 0, false, 6, null) <= -1) || (paramXAEngine == null)) {
          break label115;
        }
        paramString2 = String.valueOf(paramXAEngine.getRuleManager().a(paramString2));
      }
    }
    label115:
    for (;;)
    {
      str = paramString1;
      if (!TextUtils.isEmpty((CharSequence)paramString2)) {
        str = Intrinsics.stringPlus(paramString2, StringsKt.replace$default(paramString1, "./", "/", false, 4, null));
      }
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.util.FilePathUtil.Companion
 * JD-Core Version:    0.7.0.1
 */