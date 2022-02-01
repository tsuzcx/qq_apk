package com.tencent.mobileqq.minigame.publicaccount.config;

import com.tencent.mobileqq.jsonconverter.Alias;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/publicaccount/config/OpenHippyParam;", "", "()V", "bundleName", "", "getBundleName", "()Ljava/lang/String;", "setBundleName", "(Ljava/lang/String;)V", "domain", "getDomain", "setDomain", "errorUrl", "getErrorUrl", "setErrorUrl", "isAnimated", "", "()Z", "setAnimated", "(Z)V", "isInToolProcess", "setInToolProcess", "isPredraw", "setPredraw", "isPredrawWhenClosed", "setPredrawWhenClosed", "isPreload", "setPreload", "isPreloadWhenClosed", "setPreloadWhenClosed", "url", "getUrl", "setUrl", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class OpenHippyParam
{
  @Alias(a="bundleName")
  @Nullable
  private String bundleName;
  @Alias(a="domain")
  @Nullable
  private String domain;
  @Alias(a="errorUrl")
  @Nullable
  private String errorUrl;
  @Alias(a="isAnimated")
  private boolean isAnimated = true;
  @Alias(a="isInToolProcess")
  private boolean isInToolProcess = true;
  @Alias(a="isPredraw")
  private boolean isPredraw;
  @Alias(a="isPredrawWhenClosed")
  private boolean isPredrawWhenClosed;
  @Alias(a="isPreload")
  private boolean isPreload;
  @Alias(a="isPreloadWhenClosed")
  private boolean isPreloadWhenClosed;
  @Alias(a="url")
  @Nullable
  private String url;
  
  @Nullable
  public final String getBundleName()
  {
    return this.bundleName;
  }
  
  @Nullable
  public final String getDomain()
  {
    return this.domain;
  }
  
  @Nullable
  public final String getErrorUrl()
  {
    return this.errorUrl;
  }
  
  @Nullable
  public final String getUrl()
  {
    return this.url;
  }
  
  public final boolean isAnimated()
  {
    return this.isAnimated;
  }
  
  public final boolean isInToolProcess()
  {
    return this.isInToolProcess;
  }
  
  public final boolean isPredraw()
  {
    return this.isPredraw;
  }
  
  public final boolean isPredrawWhenClosed()
  {
    return this.isPredrawWhenClosed;
  }
  
  public final boolean isPreload()
  {
    return this.isPreload;
  }
  
  public final boolean isPreloadWhenClosed()
  {
    return this.isPreloadWhenClosed;
  }
  
  public final void setAnimated(boolean paramBoolean)
  {
    this.isAnimated = paramBoolean;
  }
  
  public final void setBundleName(@Nullable String paramString)
  {
    this.bundleName = paramString;
  }
  
  public final void setDomain(@Nullable String paramString)
  {
    this.domain = paramString;
  }
  
  public final void setErrorUrl(@Nullable String paramString)
  {
    this.errorUrl = paramString;
  }
  
  public final void setInToolProcess(boolean paramBoolean)
  {
    this.isInToolProcess = paramBoolean;
  }
  
  public final void setPredraw(boolean paramBoolean)
  {
    this.isPredraw = paramBoolean;
  }
  
  public final void setPredrawWhenClosed(boolean paramBoolean)
  {
    this.isPredrawWhenClosed = paramBoolean;
  }
  
  public final void setPreload(boolean paramBoolean)
  {
    this.isPreload = paramBoolean;
  }
  
  public final void setPreloadWhenClosed(boolean paramBoolean)
  {
    this.isPreloadWhenClosed = paramBoolean;
  }
  
  public final void setUrl(@Nullable String paramString)
  {
    this.url = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.config.OpenHippyParam
 * JD-Core Version:    0.7.0.1
 */