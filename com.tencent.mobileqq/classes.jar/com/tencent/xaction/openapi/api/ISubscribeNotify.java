package com.tencent.xaction.openapi.api;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/openapi/api/ISubscribeNotify;", "", "notify", "", "tag", "", "status", "view", "Landroid/view/View;", "XAApi_release"}, k=1, mv={1, 1, 16})
public abstract interface ISubscribeNotify
{
  public abstract void notify(@NotNull String paramString1, @NotNull String paramString2, @NotNull View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.openapi.api.ISubscribeNotify
 * JD-Core Version:    0.7.0.1
 */