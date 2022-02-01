package com.tencent.xaction.api.util;

import android.text.TextUtils;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/FilePathUtil$Companion;", "", "()V", "getAbsPath", "", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "path", "rootPath", "getAbsPathWithParent", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class FilePathUtil$Companion
{
  @JvmStatic
  private final String a(String paramString, IXAEngine paramIXAEngine)
  {
    if (!StringsKt.contains$default((CharSequence)paramString, (CharSequence)"$PARENT_ROOT", false, 2, null)) {
      return paramString;
    }
    if (paramIXAEngine == null) {
      return paramString;
    }
    paramIXAEngine = String.valueOf(paramIXAEngine.getRuleManager().getRuleValue("$PARENT_ROOT"));
    if (TextUtils.isEmpty((CharSequence)paramIXAEngine)) {
      return paramString;
    }
    return StringsKt.replace$default(paramString, "$PARENT_ROOT", paramIXAEngine, false, 4, null);
  }
  
  @JvmStatic
  @NotNull
  public final String a(@NotNull String paramString1, @Nullable String paramString2, @Nullable IXAEngine paramIXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "path");
    Object localObject = (CharSequence)paramString1;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!StringsKt.contains$default((CharSequence)localObject, (CharSequence)"../", false, 2, null)))
    {
      String str = paramString1;
      if (StringsKt.indexOf$default((CharSequence)localObject, "./", 0, false, 6, null) == 0)
      {
        CharSequence localCharSequence = (CharSequence)paramString2;
        str = paramString1;
        if (!TextUtils.isEmpty(localCharSequence))
        {
          if (paramString2 == null) {
            Intrinsics.throwNpe();
          }
          localObject = paramString2;
          if (StringsKt.indexOf$default(localCharSequence, "$", 0, false, 6, null) > -1)
          {
            localObject = paramString2;
            if (paramIXAEngine != null) {
              localObject = String.valueOf(paramIXAEngine.getRuleManager().getRuleValue(paramString2));
            }
          }
          str = paramString1;
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            str = Intrinsics.stringPlus((String)localObject, StringsKt.replace$default(paramString1, "./", "/", false, 4, null));
          }
        }
      }
      return ((Companion)this).a(str, paramIXAEngine);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.util.FilePathUtil.Companion
 * JD-Core Version:    0.7.0.1
 */