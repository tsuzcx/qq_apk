package com.tencent.tkd.topicsdk.bean;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/PermissionInfo$Companion;", "", "()V", "FLAG_HAS_LIVE_PERMISSION", "", "FLAG_HAS_NO_PERMISSION", "FLAG_HAS_PUBLISH_PERMISSION", "FLAG_IS_FORBIDDEN_PUBLISH", "STYLE_SHOW_DIALOG", "STYLE_SHOW_RICH_TOAST", "hasLivePermission", "", "flag", "hasPublishPermission", "isForbidden", "isNoPermission", "setForbidden", "setNoPermission", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PermissionInfo$Companion
{
  public final int a(int paramInt)
  {
    if (((Companion)this).b(paramInt)) {
      return 4;
    }
    return 0;
  }
  
  public final boolean b(int paramInt)
  {
    return (paramInt & 0x4) > 0;
  }
  
  public final int c(int paramInt)
  {
    return paramInt | 0x4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.PermissionInfo.Companion
 * JD-Core Version:    0.7.0.1
 */