package com.tencent.mobileqq.config.business.qflutter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/ExpandModuleKey$Companion;", "", "()V", "parse", "Lcom/tencent/mobileqq/config/business/qflutter/ExpandModuleKey;", "engine", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandModuleKey$Companion
{
  @NotNull
  public final ExpandModuleKey a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "engine");
    ExpandModuleKey[] arrayOfExpandModuleKey = ExpandModuleKey.values();
    Collection localCollection = (Collection)new ArrayList();
    int j = arrayOfExpandModuleKey.length;
    int i = 0;
    while (i < j)
    {
      ExpandModuleKey localExpandModuleKey = arrayOfExpandModuleKey[i];
      if (StringsKt.equals(localExpandModuleKey.getDesc(), paramString, true)) {
        localCollection.add(localExpandModuleKey);
      }
      i += 1;
    }
    paramString = (ExpandModuleKey)CollectionsKt.firstOrNull((List)localCollection);
    if (paramString != null) {
      return paramString;
    }
    return ExpandModuleKey.Unknown;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.ExpandModuleKey.Companion
 * JD-Core Version:    0.7.0.1
 */