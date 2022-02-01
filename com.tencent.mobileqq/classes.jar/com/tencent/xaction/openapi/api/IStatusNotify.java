package com.tencent.xaction.openapi.api;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/openapi/api/IStatusNotify;", "", "notify", "", "status", "", "view", "Landroid/view/View;", "callback", "Lkotlin/Function1;", "XAApi_release"}, k=1, mv={1, 1, 16})
public abstract interface IStatusNotify
{
  public abstract void notify(@NotNull String paramString, @NotNull View paramView, @NotNull Function1<? super String, Unit> paramFunction1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.openapi.api.IStatusNotify
 * JD-Core Version:    0.7.0.1
 */