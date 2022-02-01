package com.tencent.qapmsdk.base.listener;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/listener/IWebViewBreadCrumbListener;", "Lcom/tencent/qapmsdk/base/listener/IBaseListener;", "saveWebView", "", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract interface IWebViewBreadCrumbListener
  extends IBaseListener
{
  @NotNull
  public abstract Object saveWebView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.listener.IWebViewBreadCrumbListener
 * JD-Core Version:    0.7.0.1
 */