package com.tencent.xaction.openapi.api;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/openapi/api/IXAEngine;", "", "destroy", "", "findById", "Lcom/tencent/xaction/openapi/api/IPublicView;", "id", "", "findDrawableById", "Lcom/tencent/xaction/openapi/api/IPublicDrawable;", "getAbsPath", "", "path", "root", "getLayout", "Landroid/view/ViewGroup;", "getRuleManager", "Lcom/tencent/xaction/openapi/api/IPublicRuleManager;", "init", "data", "initAsync", "callback", "Lkotlin/Function0;", "initFromFile", "filePath", "initFromFileAsync", "initFromUrlAsync", "url", "initRoot", "rootPath", "initRootAsync", "initZipAsync", "zipFilePath", "notifyMonitor", "", "rule", "value", "setContentLayout", "framelayout", "setProxy", "view", "Landroid/view/View;", "isStyle", "setProxyMore", "setTag", "tag", "start", "XAApi_release"}, k=1, mv={1, 1, 16})
public abstract interface IXAEngine
{
  public abstract void destroy();
  
  @Nullable
  public abstract IPublicView findById(int paramInt);
  
  @Nullable
  public abstract IPublicDrawable findDrawableById(int paramInt);
  
  @Nullable
  public abstract String getAbsPath(@Nullable String paramString1, @Nullable String paramString2);
  
  @Nullable
  public abstract ViewGroup getLayout();
  
  @NotNull
  public abstract IPublicRuleManager getRuleManager();
  
  @NotNull
  public abstract IXAEngine init(@NotNull String paramString);
  
  @NotNull
  public abstract IXAEngine initAsync(@NotNull String paramString, @NotNull Function0<Unit> paramFunction0);
  
  @NotNull
  public abstract IXAEngine initFromFile(@NotNull String paramString);
  
  @NotNull
  public abstract IXAEngine initFromFileAsync(@NotNull String paramString, @NotNull Function0<Unit> paramFunction0);
  
  @NotNull
  public abstract IXAEngine initFromUrlAsync(@NotNull String paramString, @NotNull Function0<Unit> paramFunction0);
  
  @NotNull
  public abstract IXAEngine initRoot(@NotNull String paramString);
  
  @NotNull
  public abstract IXAEngine initRootAsync(@NotNull String paramString, @NotNull Function0<Unit> paramFunction0);
  
  @NotNull
  public abstract IXAEngine initZipAsync(@NotNull String paramString, @NotNull Function0<Unit> paramFunction0);
  
  public abstract boolean notifyMonitor(@NotNull String paramString, @NotNull Object paramObject);
  
  @NotNull
  public abstract IXAEngine setContentLayout(@NotNull ViewGroup paramViewGroup);
  
  @NotNull
  public abstract IXAEngine setProxy(int paramInt, @NotNull View paramView, boolean paramBoolean);
  
  @NotNull
  public abstract IXAEngine setProxyMore(int paramInt, @NotNull View paramView, boolean paramBoolean);
  
  @NotNull
  public abstract IXAEngine setTag(@NotNull String paramString);
  
  public abstract void start();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.openapi.api.IXAEngine
 * JD-Core Version:    0.7.0.1
 */