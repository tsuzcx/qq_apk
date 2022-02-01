package com.tencent.mobileqq.kandian.biz.comment.base.model;

import android.content.Intent;
import com.tencent.tkd.comment.publisher.qq.bridge.QQReportBridge;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/base/model/IPublishScene;", "Lcom/tencent/tkd/comment/publisher/qq/bridge/QQReportBridge;", "enableLink", "", "getInputHint", "", "getQQDraftId", "init", "", "commentArgumentModel", "Lcom/tencent/mobileqq/kandian/biz/comment/base/model/CommentArgumentModel;", "intent", "Landroid/content/Intent;", "onDeliver", "result", "packageDataInfo", "resultJson", "Lorg/json/JSONObject;", "text", "reportCommon", "actionCode", "jsonObject", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IPublishScene
  extends QQReportBridge
{
  @Nullable
  public abstract String a();
  
  public abstract void a(@NotNull Intent paramIntent, @Nullable String paramString);
  
  public abstract void a(@NotNull CommentArgumentModel paramCommentArgumentModel, @NotNull Intent paramIntent);
  
  public abstract void a(@Nullable String paramString, @Nullable JSONObject paramJSONObject);
  
  public abstract void a(@NotNull JSONObject paramJSONObject, @Nullable String paramString);
  
  public abstract boolean b();
  
  @Nullable
  public abstract String c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.base.model.IPublishScene
 * JD-Core Version:    0.7.0.1
 */