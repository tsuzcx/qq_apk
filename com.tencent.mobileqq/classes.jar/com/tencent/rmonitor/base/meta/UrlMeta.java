package com.tencent.rmonitor.base.meta;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/meta/UrlMeta;", "", "rmonitorDomain", "", "authorizationUrl", "jsonUploadUrl", "fileUploadUrl", "configUrl", "attaUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttaUrl", "()Ljava/lang/String;", "setAttaUrl", "(Ljava/lang/String;)V", "getAuthorizationUrl", "setAuthorizationUrl", "getConfigUrl", "setConfigUrl", "getFileUploadUrl", "setFileUploadUrl", "getJsonUploadUrl", "setJsonUploadUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class UrlMeta
{
  @NotNull
  private String attaUrl;
  @NotNull
  private String authorizationUrl;
  @NotNull
  private String configUrl;
  @NotNull
  private String fileUploadUrl;
  @NotNull
  private String jsonUploadUrl;
  @JvmField
  @NotNull
  public String rmonitorDomain;
  
  public UrlMeta()
  {
    this(null, null, null, null, null, null, 63, null);
  }
  
  public UrlMeta(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6)
  {
    this.rmonitorDomain = paramString1;
    this.authorizationUrl = paramString2;
    this.jsonUploadUrl = paramString3;
    this.fileUploadUrl = paramString4;
    this.configUrl = paramString5;
    this.attaUrl = paramString6;
  }
  
  @NotNull
  public final String component1()
  {
    return this.rmonitorDomain;
  }
  
  @NotNull
  public final String component2()
  {
    return this.authorizationUrl;
  }
  
  @NotNull
  public final String component3()
  {
    return this.jsonUploadUrl;
  }
  
  @NotNull
  public final String component4()
  {
    return this.fileUploadUrl;
  }
  
  @NotNull
  public final String component5()
  {
    return this.configUrl;
  }
  
  @NotNull
  public final String component6()
  {
    return this.attaUrl;
  }
  
  @NotNull
  public final UrlMeta copy(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "rmonitorDomain");
    Intrinsics.checkParameterIsNotNull(paramString2, "authorizationUrl");
    Intrinsics.checkParameterIsNotNull(paramString3, "jsonUploadUrl");
    Intrinsics.checkParameterIsNotNull(paramString4, "fileUploadUrl");
    Intrinsics.checkParameterIsNotNull(paramString5, "configUrl");
    Intrinsics.checkParameterIsNotNull(paramString6, "attaUrl");
    return new UrlMeta(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof UrlMeta))
      {
        paramObject = (UrlMeta)paramObject;
        if ((Intrinsics.areEqual(this.rmonitorDomain, paramObject.rmonitorDomain)) && (Intrinsics.areEqual(this.authorizationUrl, paramObject.authorizationUrl)) && (Intrinsics.areEqual(this.jsonUploadUrl, paramObject.jsonUploadUrl)) && (Intrinsics.areEqual(this.fileUploadUrl, paramObject.fileUploadUrl)) && (Intrinsics.areEqual(this.configUrl, paramObject.configUrl)) && (Intrinsics.areEqual(this.attaUrl, paramObject.attaUrl))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getAttaUrl()
  {
    return this.attaUrl;
  }
  
  @NotNull
  public final String getAuthorizationUrl()
  {
    return this.authorizationUrl;
  }
  
  @NotNull
  public final String getConfigUrl()
  {
    return this.configUrl;
  }
  
  @NotNull
  public final String getFileUploadUrl()
  {
    return this.fileUploadUrl;
  }
  
  @NotNull
  public final String getJsonUploadUrl()
  {
    return this.jsonUploadUrl;
  }
  
  public int hashCode()
  {
    String str = this.rmonitorDomain;
    int i1 = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.authorizationUrl;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.jsonUploadUrl;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.fileUploadUrl;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.configUrl;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.attaUrl;
    if (str != null) {
      i1 = str.hashCode();
    }
    return ((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
  }
  
  public final void setAttaUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.attaUrl = paramString;
  }
  
  public final void setAuthorizationUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.authorizationUrl = paramString;
  }
  
  public final void setConfigUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.configUrl = paramString;
  }
  
  public final void setFileUploadUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.fileUploadUrl = paramString;
  }
  
  public final void setJsonUploadUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jsonUploadUrl = paramString;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UrlMeta(rmonitorDomain=");
    localStringBuilder.append(this.rmonitorDomain);
    localStringBuilder.append(", authorizationUrl=");
    localStringBuilder.append(this.authorizationUrl);
    localStringBuilder.append(", jsonUploadUrl=");
    localStringBuilder.append(this.jsonUploadUrl);
    localStringBuilder.append(", fileUploadUrl=");
    localStringBuilder.append(this.fileUploadUrl);
    localStringBuilder.append(", configUrl=");
    localStringBuilder.append(this.configUrl);
    localStringBuilder.append(", attaUrl=");
    localStringBuilder.append(this.attaUrl);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.meta.UrlMeta
 * JD-Core Version:    0.7.0.1
 */