package com.tencent.mobileqq.mini.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/model/DetainConfigMatchHelper;", "", "()V", "find", "Lcom/tencent/mobileqq/mini/model/AppDetainConfig;", "curPageUrl", "", "list", "", "isItemMatch", "", "pageUrl", "itemPath", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class DetainConfigMatchHelper
{
  private final boolean isItemMatch(String paramString1, String paramString2)
  {
    CharSequence localCharSequence = (CharSequence)paramString2;
    int i;
    if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    if (Intrinsics.areEqual(paramString2, "*")) {
      return true;
    }
    if (StringsKt.endsWith$default(paramString2, "/*", false, 2, null)) {
      return StringsKt.startsWith$default(paramString1, StringsKt.substringBeforeLast$default(paramString2, "*", null, 2, null), false, 2, null);
    }
    return Intrinsics.areEqual(StringsKt.removePrefix(StringsKt.substringBefore$default(paramString1, ".html", null, 2, null), (CharSequence)"/"), StringsKt.removePrefix(paramString2, (CharSequence)"/"));
  }
  
  @Nullable
  public final AppDetainConfig find(@NotNull String paramString, @NotNull List<AppDetainConfig> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "curPageUrl");
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    Object localObject1 = (Iterable)paramList;
    paramList = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (isItemMatch(paramString, ((AppDetainConfig)localObject2).getExitPage())) {
        paramList.add(localObject2);
      }
    }
    Object localObject2 = ((Iterable)paramList).iterator();
    if (!((Iterator)localObject2).hasNext())
    {
      paramString = null;
    }
    else
    {
      paramString = ((Iterator)localObject2).next();
      if (((Iterator)localObject2).hasNext())
      {
        paramList = ((AppDetainConfig)paramString).getExitPage();
        int i;
        if (paramList != null)
        {
          i = paramList.length();
          paramList = paramString;
        }
        else
        {
          i = 0;
          paramList = paramString;
        }
        do
        {
          localObject1 = ((Iterator)localObject2).next();
          paramString = ((AppDetainConfig)localObject1).getExitPage();
          int j;
          if (paramString != null) {
            j = paramString.length();
          } else {
            j = 0;
          }
          int k = i;
          paramString = paramList;
          if (i < j)
          {
            paramString = (String)localObject1;
            k = j;
          }
          i = k;
          paramList = paramString;
        } while (((Iterator)localObject2).hasNext());
      }
    }
    return (AppDetainConfig)paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.model.DetainConfigMatchHelper
 * JD-Core Version:    0.7.0.1
 */