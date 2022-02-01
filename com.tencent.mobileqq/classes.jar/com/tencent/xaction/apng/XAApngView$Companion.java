package com.tencent.xaction.apng;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XAEngine.Companion;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/apng/XAApngView$Companion;", "", "()V", "initApng", "", "resources", "Landroid/content/res/Resources;", "viewData", "Lcom/tencent/xaction/api/data/ViewData;", "path", "", "callback", "Lkotlin/Function1;", "Lcom/tencent/xaction/apng/ApngDrawable;", "XAApng_release"}, k=1, mv={1, 1, 16})
public final class XAApngView$Companion
{
  @JvmStatic
  public final void a(@NotNull Resources paramResources, @NotNull ViewData paramViewData, @NotNull String paramString, @NotNull Function1<? super ApngDrawable, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramResources, "resources");
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_double_bitmap", true);
    localBundle.putIntArray("key_tagId_arr", new int[] { paramViewData.getId() });
    XAEngine.Companion.a().execute((Runnable)new XAApngView.Companion.initApng.1(paramString, localBundle, paramResources, paramViewData, paramFunction1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.apng.XAApngView.Companion
 * JD-Core Version:    0.7.0.1
 */