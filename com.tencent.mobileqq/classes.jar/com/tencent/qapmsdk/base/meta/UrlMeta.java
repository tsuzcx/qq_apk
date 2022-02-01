package com.tencent.qapmsdk.base.meta;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/meta/UrlMeta;", "", "qapmDomain", "", "athenaDomain", "authorizationUrl", "jsonUploadUrl", "fileUploadUrl", "athenaJsonUploadUrl", "athenaFileUploadUrl", "configUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAthenaFileUploadUrl", "()Ljava/lang/String;", "setAthenaFileUploadUrl", "(Ljava/lang/String;)V", "getAthenaJsonUploadUrl", "setAthenaJsonUploadUrl", "getAuthorizationUrl", "setAuthorizationUrl", "getConfigUrl", "setConfigUrl", "getFileUploadUrl", "setFileUploadUrl", "getJsonUploadUrl", "setJsonUploadUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class UrlMeta
{
  @JvmField
  @NotNull
  public String athenaDomain;
  @NotNull
  private String athenaFileUploadUrl;
  @NotNull
  private String athenaJsonUploadUrl;
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
  public String qapmDomain;
  
  public UrlMeta()
  {
    this(null, null, null, null, null, null, null, null, 255, null);
  }
  
  public UrlMeta(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, @NotNull String paramString7, @NotNull String paramString8)
  {
    this.qapmDomain = paramString1;
    this.athenaDomain = paramString2;
    this.authorizationUrl = paramString3;
    this.jsonUploadUrl = paramString4;
    this.fileUploadUrl = paramString5;
    this.athenaJsonUploadUrl = paramString6;
    this.athenaFileUploadUrl = paramString7;
    this.configUrl = paramString8;
  }
  
  @NotNull
  public final String component1()
  {
    return this.qapmDomain;
  }
  
  @NotNull
  public final String component2()
  {
    return this.athenaDomain;
  }
  
  @NotNull
  public final String component3()
  {
    return this.authorizationUrl;
  }
  
  @NotNull
  public final String component4()
  {
    return this.jsonUploadUrl;
  }
  
  @NotNull
  public final String component5()
  {
    return this.fileUploadUrl;
  }
  
  @NotNull
  public final String component6()
  {
    return this.athenaJsonUploadUrl;
  }
  
  @NotNull
  public final String component7()
  {
    return this.athenaFileUploadUrl;
  }
  
  @NotNull
  public final String component8()
  {
    return this.configUrl;
  }
  
  @NotNull
  public final UrlMeta copy(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, @NotNull String paramString7, @NotNull String paramString8)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "qapmDomain");
    Intrinsics.checkParameterIsNotNull(paramString2, "athenaDomain");
    Intrinsics.checkParameterIsNotNull(paramString3, "authorizationUrl");
    Intrinsics.checkParameterIsNotNull(paramString4, "jsonUploadUrl");
    Intrinsics.checkParameterIsNotNull(paramString5, "fileUploadUrl");
    Intrinsics.checkParameterIsNotNull(paramString6, "athenaJsonUploadUrl");
    Intrinsics.checkParameterIsNotNull(paramString7, "athenaFileUploadUrl");
    Intrinsics.checkParameterIsNotNull(paramString8, "configUrl");
    return new UrlMeta(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof UrlMeta))
      {
        paramObject = (UrlMeta)paramObject;
        if ((Intrinsics.areEqual(this.qapmDomain, paramObject.qapmDomain)) && (Intrinsics.areEqual(this.athenaDomain, paramObject.athenaDomain)) && (Intrinsics.areEqual(this.authorizationUrl, paramObject.authorizationUrl)) && (Intrinsics.areEqual(this.jsonUploadUrl, paramObject.jsonUploadUrl)) && (Intrinsics.areEqual(this.fileUploadUrl, paramObject.fileUploadUrl)) && (Intrinsics.areEqual(this.athenaJsonUploadUrl, paramObject.athenaJsonUploadUrl)) && (Intrinsics.areEqual(this.athenaFileUploadUrl, paramObject.athenaFileUploadUrl)) && (Intrinsics.areEqual(this.configUrl, paramObject.configUrl))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getAthenaFileUploadUrl()
  {
    return this.athenaFileUploadUrl;
  }
  
  @NotNull
  public final String getAthenaJsonUploadUrl()
  {
    return this.athenaJsonUploadUrl;
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
    String str = this.qapmDomain;
    int i3 = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.athenaDomain;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.authorizationUrl;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.jsonUploadUrl;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.fileUploadUrl;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.athenaJsonUploadUrl;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.athenaFileUploadUrl;
    int i2;
    if (str != null) {
      i2 = str.hashCode();
    } else {
      i2 = 0;
    }
    str = this.configUrl;
    if (str != null) {
      i3 = str.hashCode();
    }
    return ((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3;
  }
  
  public final void setAthenaFileUploadUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.athenaFileUploadUrl = paramString;
  }
  
  public final void setAthenaJsonUploadUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.athenaJsonUploadUrl = paramString;
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
    localStringBuilder.append("UrlMeta(qapmDomain=");
    localStringBuilder.append(this.qapmDomain);
    localStringBuilder.append(", athenaDomain=");
    localStringBuilder.append(this.athenaDomain);
    localStringBuilder.append(", authorizationUrl=");
    localStringBuilder.append(this.authorizationUrl);
    localStringBuilder.append(", jsonUploadUrl=");
    localStringBuilder.append(this.jsonUploadUrl);
    localStringBuilder.append(", fileUploadUrl=");
    localStringBuilder.append(this.fileUploadUrl);
    localStringBuilder.append(", athenaJsonUploadUrl=");
    localStringBuilder.append(this.athenaJsonUploadUrl);
    localStringBuilder.append(", athenaFileUploadUrl=");
    localStringBuilder.append(this.athenaFileUploadUrl);
    localStringBuilder.append(", configUrl=");
    localStringBuilder.append(this.configUrl);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.meta.UrlMeta
 * JD-Core Version:    0.7.0.1
 */