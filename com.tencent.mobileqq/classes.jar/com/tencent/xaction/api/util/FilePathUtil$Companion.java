package com.tencent.xaction.api.util;

import android.text.TextUtils;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.openapi.api.IPublicRuleManager;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/util/FilePathUtil$Companion;", "", "()V", "PARENT_ROOT", "", "getAbsPath", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "path", "rootPath", "getAbsPathWithParent", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class FilePathUtil$Companion
{
  @JvmStatic
  private final String a(String paramString, IXAEngine paramIXAEngine)
  {
    CharSequence localCharSequence = (CharSequence)paramString;
    String str = paramString;
    if (!TextUtils.isEmpty(localCharSequence))
    {
      if (!StringsKt.contains$default(localCharSequence, (CharSequence)"$PARENT_ROOT", false, 2, null)) {
        return paramString;
      }
      if (paramIXAEngine == null) {
        return paramString;
      }
      paramIXAEngine = String.valueOf(paramIXAEngine.getRuleManager().getRuleValue("$PARENT_ROOT"));
      if (TextUtils.isEmpty((CharSequence)paramIXAEngine)) {
        return paramString;
      }
      str = StringsKt.replace$default(paramString, "$PARENT_ROOT", paramIXAEngine, false, 4, null);
    }
    return str;
  }
  
  @JvmStatic
  @Nullable
  public final String a(@NotNull ViewData paramViewData, @NotNull IXAEngine paramIXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "engine");
    if (paramViewData.getExts() == null) {
      return null;
    }
    Object localObject = paramViewData.getExts();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((HashMap)localObject).get("path");
    String str = "";
    if (localObject != null)
    {
      localObject = paramViewData.getExts();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((HashMap)localObject).get("path");
      if (localObject != null) {
        localObject = (String)localObject;
      } else {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      }
    }
    else
    {
      localObject = "";
    }
    HashMap localHashMap = paramViewData.getExts();
    if (localHashMap == null) {
      Intrinsics.throwNpe();
    }
    if (localHashMap.get("root") != null)
    {
      paramViewData = paramViewData.getExts();
      if (paramViewData == null) {
        Intrinsics.throwNpe();
      }
      paramViewData = paramViewData.get("root");
      if (paramViewData != null) {
        str = (String)paramViewData;
      } else {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      }
    }
    return ((Companion)this).a((String)localObject, str, paramIXAEngine);
  }
  
  @JvmStatic
  @NotNull
  public final String a(@NotNull String paramString1, @Nullable String paramString2, @Nullable IXAEngine paramIXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "path");
    Object localObject = (CharSequence)paramString1;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!StringsKt.contains$default((CharSequence)localObject, (CharSequence)"../", false, 2, null)))
    {
      if (FileUtil.a.b(paramString1)) {
        return paramString1;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.util.FilePathUtil.Companion
 * JD-Core Version:    0.7.0.1
 */