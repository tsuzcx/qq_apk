package com.tencent.xaction.openapi.api;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/openapi/api/IDownload;", "", "requestFile", "", "url", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "status", "filepath", "XAApi_release"}, k=1, mv={1, 1, 16})
public abstract interface IDownload
{
  public abstract void requestFile(@NotNull String paramString, @NotNull Function2<? super String, ? super String, Unit> paramFunction2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.openapi.api.IDownload
 * JD-Core Version:    0.7.0.1
 */