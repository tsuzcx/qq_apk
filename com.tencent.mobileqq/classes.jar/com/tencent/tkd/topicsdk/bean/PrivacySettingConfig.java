package com.tencent.tkd.topicsdk.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/PrivacySettingConfig;", "Ljava/io/Serializable;", "()V", "extraDesc", "", "getExtraDesc", "()Ljava/lang/String;", "setExtraDesc", "(Ljava/lang/String;)V", "extraTitle", "getExtraTitle", "setExtraTitle", "privacyDesc", "getPrivacyDesc", "setPrivacyDesc", "privacySetting", "", "getPrivacySetting", "()I", "setPrivacySetting", "(I)V", "privateTitle", "getPrivateTitle", "setPrivateTitle", "publicDesc", "getPublicDesc", "setPublicDesc", "publicTitle", "getPublicTitle", "setPublicTitle", "title", "getTitle", "setTitle", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PrivacySettingConfig
  implements Serializable
{
  public static final PrivacySettingConfig.Companion Companion = new PrivacySettingConfig.Companion(null);
  public static final int PRIVACY_PRIVATE = 3;
  public static final int PRIVACY_PUBLIC = 2;
  public static final int PRIVACY_PUBLIC_AND_REMIND = 1;
  @NotNull
  private String extraDesc = "在平台内有机会被推荐且通知好友";
  @NotNull
  private String extraTitle = "公开且通知好友";
  @NotNull
  private String privacyDesc = "仅获得内容链接用户可查看";
  private int privacySetting = 2;
  @NotNull
  private String privateTitle = "不公开";
  @NotNull
  private String publicDesc = "在平台内有机会被推荐";
  @NotNull
  private String publicTitle = "公开";
  @NotNull
  private String title = "隐私设置";
  
  @NotNull
  public final String getExtraDesc()
  {
    return this.extraDesc;
  }
  
  @NotNull
  public final String getExtraTitle()
  {
    return this.extraTitle;
  }
  
  @NotNull
  public final String getPrivacyDesc()
  {
    return this.privacyDesc;
  }
  
  public final int getPrivacySetting()
  {
    return this.privacySetting;
  }
  
  @NotNull
  public final String getPrivateTitle()
  {
    return this.privateTitle;
  }
  
  @NotNull
  public final String getPublicDesc()
  {
    return this.publicDesc;
  }
  
  @NotNull
  public final String getPublicTitle()
  {
    return this.publicTitle;
  }
  
  @NotNull
  public final String getTitle()
  {
    return this.title;
  }
  
  public final void setExtraDesc(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.extraDesc = paramString;
  }
  
  public final void setExtraTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.extraTitle = paramString;
  }
  
  public final void setPrivacyDesc(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.privacyDesc = paramString;
  }
  
  public final void setPrivacySetting(int paramInt)
  {
    this.privacySetting = paramInt;
  }
  
  public final void setPrivateTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.privateTitle = paramString;
  }
  
  public final void setPublicDesc(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.publicDesc = paramString;
  }
  
  public final void setPublicTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.publicTitle = paramString;
  }
  
  public final void setTitle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.title = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.PrivacySettingConfig
 * JD-Core Version:    0.7.0.1
 */