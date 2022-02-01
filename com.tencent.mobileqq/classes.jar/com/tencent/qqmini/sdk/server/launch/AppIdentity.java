package com.tencent.qqmini.sdk.server.launch;

import android.net.Uri;
import android.support.annotation.VisibleForTesting;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/server/launch/AppIdentity;", "", "appId", "", "verType", "", "version", "name", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "uri$delegate", "Lkotlin/Lazy;", "getVerType", "()I", "equals", "", "other", "hashCode", "toSimpleString", "toString", "lib_miniserver_internalRelease"}, k=1, mv={1, 1, 16})
@VisibleForTesting
public final class AppIdentity
{
  @NotNull
  private final String appId;
  private final String name;
  @NotNull
  private final Lazy uri$delegate;
  private final int verType;
  private final String version;
  
  public AppIdentity(@NotNull String paramString1, int paramInt, @Nullable String paramString2, @Nullable String paramString3)
  {
    this.appId = paramString1;
    this.verType = paramInt;
    this.version = paramString2;
    this.name = paramString3;
    this.uri$delegate = LazyKt.lazy((Function0)new AppIdentity.uri.2(this));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((AppIdentity)this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof AppIdentity)) {
      return false;
    }
    String str = this.appId;
    paramObject = (AppIdentity)paramObject;
    if ((Intrinsics.areEqual(str, paramObject.appId) ^ true)) {
      return false;
    }
    return this.verType == paramObject.verType;
  }
  
  @NotNull
  public final String getAppId()
  {
    return this.appId;
  }
  
  @NotNull
  public final Uri getUri()
  {
    return (Uri)this.uri$delegate.getValue();
  }
  
  public final int getVerType()
  {
    return this.verType;
  }
  
  public int hashCode()
  {
    return this.appId.hashCode() * 31 + this.verType;
  }
  
  @NotNull
  public final String toSimpleString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(appId='");
    localStringBuilder.append(this.appId);
    localStringBuilder.append("', name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append("')");
    return localStringBuilder.toString();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppIdentity(appId='");
    localStringBuilder.append(this.appId);
    localStringBuilder.append("', name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append("', verType=");
    localStringBuilder.append(this.verType);
    localStringBuilder.append(", version='");
    localStringBuilder.append(this.version);
    localStringBuilder.append("')");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.server.launch.AppIdentity
 * JD-Core Version:    0.7.0.1
 */