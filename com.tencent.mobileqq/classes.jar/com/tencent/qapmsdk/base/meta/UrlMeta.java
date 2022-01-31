package com.tencent.qapmsdk.base.meta;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/meta/UrlMeta;", "", "qapmDomain", "", "athenaDomain", "authorizationUrl", "jsonUploadUrl", "fileUploadUrl", "configUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthorizationUrl", "()Ljava/lang/String;", "setAuthorizationUrl", "(Ljava/lang/String;)V", "getConfigUrl", "setConfigUrl", "getFileUploadUrl", "setFileUploadUrl", "getJsonUploadUrl", "setJsonUploadUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class UrlMeta
{
  @JvmField
  @NotNull
  public String athenaDomain;
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
    this(null, null, null, null, null, null, 63, null);
  }
  
  public UrlMeta(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6)
  {
    this.qapmDomain = paramString1;
    this.athenaDomain = paramString2;
    this.authorizationUrl = paramString3;
    this.jsonUploadUrl = paramString4;
    this.fileUploadUrl = paramString5;
    this.configUrl = paramString6;
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
    return this.configUrl;
  }
  
  @NotNull
  public final UrlMeta copy(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "qapmDomain");
    Intrinsics.checkParameterIsNotNull(paramString2, "athenaDomain");
    Intrinsics.checkParameterIsNotNull(paramString3, "authorizationUrl");
    Intrinsics.checkParameterIsNotNull(paramString4, "jsonUploadUrl");
    Intrinsics.checkParameterIsNotNull(paramString5, "fileUploadUrl");
    Intrinsics.checkParameterIsNotNull(paramString6, "configUrl");
    return new UrlMeta(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof UrlMeta))
      {
        paramObject = (UrlMeta)paramObject;
        if ((!Intrinsics.areEqual(this.qapmDomain, paramObject.qapmDomain)) || (!Intrinsics.areEqual(this.athenaDomain, paramObject.athenaDomain)) || (!Intrinsics.areEqual(this.authorizationUrl, paramObject.authorizationUrl)) || (!Intrinsics.areEqual(this.jsonUploadUrl, paramObject.jsonUploadUrl)) || (!Intrinsics.areEqual(this.fileUploadUrl, paramObject.fileUploadUrl)) || (!Intrinsics.areEqual(this.configUrl, paramObject.configUrl))) {}
      }
    }
    else {
      return true;
    }
    return false;
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
    int i1 = 0;
    String str = this.qapmDomain;
    int i;
    int j;
    label37:
    int k;
    label54:
    int m;
    if (str != null)
    {
      i = str.hashCode();
      str = this.athenaDomain;
      if (str == null) {
        break label143;
      }
      j = str.hashCode();
      str = this.authorizationUrl;
      if (str == null) {
        break label148;
      }
      k = str.hashCode();
      str = this.jsonUploadUrl;
      if (str == null) {
        break label153;
      }
      m = str.hashCode();
      label72:
      str = this.fileUploadUrl;
      if (str == null) {
        break label159;
      }
    }
    label143:
    label148:
    label153:
    label159:
    for (int n = str.hashCode();; n = 0)
    {
      str = this.configUrl;
      if (str != null) {
        i1 = str.hashCode();
      }
      return (n + (m + (k + (j + i * 31) * 31) * 31) * 31) * 31 + i1;
      i = 0;
      break;
      j = 0;
      break label37;
      k = 0;
      break label54;
      m = 0;
      break label72;
    }
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
    return "UrlMeta(qapmDomain=" + this.qapmDomain + ", athenaDomain=" + this.athenaDomain + ", authorizationUrl=" + this.authorizationUrl + ", jsonUploadUrl=" + this.jsonUploadUrl + ", fileUploadUrl=" + this.fileUploadUrl + ", configUrl=" + this.configUrl + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.base.meta.UrlMeta
 * JD-Core Version:    0.7.0.1
 */