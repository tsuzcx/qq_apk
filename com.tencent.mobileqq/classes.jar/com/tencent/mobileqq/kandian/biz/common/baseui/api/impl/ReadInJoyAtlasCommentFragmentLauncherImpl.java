package com.tencent.mobileqq.kandian.biz.common.baseui.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasCommentFragment;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.common.baseui.api.IReadInJoyAtlasCommentFragmentLauncher;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/impl/ReadInJoyAtlasCommentFragmentLauncherImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/IReadInJoyAtlasCommentFragmentLauncher;", "()V", "launch", "", "context", "Landroid/content/Context;", "rowKey", "", "title", "summary", "picUrl", "anchorData", "Lcom/tencent/mobileqq/kandian/biz/comment/entity/AnchorData;", "openCommentEdit", "", "needImmersive", "bundle", "Landroid/os/Bundle;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyAtlasCommentFragmentLauncherImpl
  implements IReadInJoyAtlasCommentFragmentLauncher
{
  public void launch(@Nullable Context paramContext, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable AnchorData paramAnchorData, boolean paramBoolean1, boolean paramBoolean2, @Nullable Bundle paramBundle)
  {
    ReadInJoyAtlasCommentFragment.a(paramContext, paramString1, paramString2, paramString3, paramString4, paramAnchorData, paramBoolean1, paramBoolean2, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.baseui.api.impl.ReadInJoyAtlasCommentFragmentLauncherImpl
 * JD-Core Version:    0.7.0.1
 */