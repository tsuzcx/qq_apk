package com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.impl;

import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManager;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IUiApiPlugin;
import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/impl/UiApiPluginImpl;", "Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/IUiApiPlugin;", "()V", "handleInfoAndRequestForWeb", "", "intent", "Landroid/content/Intent;", "dataManager", "Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/IRIJBiuAndCommentMixDataManager;", "callBackId", "", "callCommentJs", "Lcom/tencent/mobileqq/kandian/biz/fastweb/CallCommentJs;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UiApiPluginImpl
  implements IUiApiPlugin
{
  public void handleInfoAndRequestForWeb(@Nullable Intent paramIntent, @Nullable IRIJBiuAndCommentMixDataManager paramIRIJBiuAndCommentMixDataManager, @Nullable String paramString, @Nullable CallCommentJs paramCallCommentJs)
  {
    this.$$delegate_0.handleInfoAndRequestForWeb(paramIntent, paramIRIJBiuAndCommentMixDataManager, paramString, paramCallCommentJs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.impl.UiApiPluginImpl
 * JD-Core Version:    0.7.0.1
 */