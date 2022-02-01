package com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api;

import android.content.Intent;
import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/IUiApiPlugin;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "handleInfoAndRequestForWeb", "", "intent", "Landroid/content/Intent;", "dataManager", "Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/IRIJBiuAndCommentMixDataManager;", "callBackId", "", "callCommentJs", "Lcom/tencent/mobileqq/kandian/biz/fastweb/CallCommentJs;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IUiApiPlugin
  extends QRouteApi
{
  public abstract void handleInfoAndRequestForWeb(@Nullable Intent paramIntent, @Nullable IRIJBiuAndCommentMixDataManager paramIRIJBiuAndCommentMixDataManager, @Nullable String paramString, @Nullable CallCommentJs paramCallCommentJs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IUiApiPlugin
 * JD-Core Version:    0.7.0.1
 */