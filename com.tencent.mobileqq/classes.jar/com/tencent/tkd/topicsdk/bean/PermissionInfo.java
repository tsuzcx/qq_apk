package com.tencent.tkd.topicsdk.bean;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/PermissionInfo;", "Ljava/io/Serializable;", "()V", "dialogInfo", "Lcom/tencent/tkd/topicsdk/bean/DialogInfo;", "getDialogInfo", "()Lcom/tencent/tkd/topicsdk/bean/DialogInfo;", "setDialogInfo", "(Lcom/tencent/tkd/topicsdk/bean/DialogInfo;)V", "forbidHighLightText", "", "getForbidHighLightText", "()Ljava/lang/String;", "setForbidHighLightText", "(Ljava/lang/String;)V", "forbidJumpUrl", "getForbidJumpUrl", "setForbidJumpUrl", "forbidToastText", "getForbidToastText", "setForbidToastText", "permissionFlag", "", "getPermissionFlag", "()I", "setPermissionFlag", "(I)V", "permissionStyle", "getPermissionStyle", "setPermissionStyle", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PermissionInfo
  implements Serializable
{
  public static final PermissionInfo.Companion Companion = new PermissionInfo.Companion(null);
  public static final int FLAG_HAS_PUBLISH_PERMISSION = 1;
  public static final int STYLE_SHOW_DIALOG = 2;
  public static final int STYLE_SHOW_RICH_TOAST = 1;
  @Nullable
  private DialogInfo dialogInfo;
  @NotNull
  private String forbidHighLightText = "";
  @NotNull
  private String forbidJumpUrl = "";
  @NotNull
  private String forbidToastText = "";
  private int permissionFlag = 1;
  private int permissionStyle = 1;
  
  @Nullable
  public final DialogInfo getDialogInfo()
  {
    return this.dialogInfo;
  }
  
  @NotNull
  public final String getForbidHighLightText()
  {
    return this.forbidHighLightText;
  }
  
  @NotNull
  public final String getForbidJumpUrl()
  {
    return this.forbidJumpUrl;
  }
  
  @NotNull
  public final String getForbidToastText()
  {
    return this.forbidToastText;
  }
  
  public final int getPermissionFlag()
  {
    return this.permissionFlag;
  }
  
  public final int getPermissionStyle()
  {
    return this.permissionStyle;
  }
  
  public final void setDialogInfo(@Nullable DialogInfo paramDialogInfo)
  {
    this.dialogInfo = paramDialogInfo;
  }
  
  public final void setForbidHighLightText(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.forbidHighLightText = paramString;
  }
  
  public final void setForbidJumpUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.forbidJumpUrl = paramString;
  }
  
  public final void setForbidToastText(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.forbidToastText = paramString;
  }
  
  public final void setPermissionFlag(int paramInt)
  {
    this.permissionFlag = paramInt;
  }
  
  public final void setPermissionStyle(int paramInt)
  {
    this.permissionStyle = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.PermissionInfo
 * JD-Core Version:    0.7.0.1
 */