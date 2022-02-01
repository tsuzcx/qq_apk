package com.tencent.mobileqq.kandian.biz.common.baseui.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/IReadInJoyAtlasCommentFragmentLauncher;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "launch", "", "context", "Landroid/content/Context;", "rowKey", "", "title", "summary", "picUrl", "anchorData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/AnchorData;", "openCommentEdit", "", "needImmersive", "bundle", "Landroid/os/Bundle;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyAtlasCommentFragmentLauncher
  extends QRouteApi
{
  public abstract void launch(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable AnchorData paramAnchorData, boolean paramBoolean1, boolean paramBoolean2, @Nullable Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.baseui.api.IReadInJoyAtlasCommentFragmentLauncher
 * JD-Core Version:    0.7.0.1
 */