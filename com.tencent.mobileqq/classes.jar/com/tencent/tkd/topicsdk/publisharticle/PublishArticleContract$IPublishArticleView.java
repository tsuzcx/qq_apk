package com.tencent.tkd.topicsdk.publisharticle;

import com.tencent.tkd.weibo.bean.TweetTopicItem;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/PublishArticleContract$IPublishArticleView;", "", "changeBottomLayoutEnabled", "", "enablePic", "", "enableVideo", "handlePublishErrCode", "errCode", "", "jumpRealNameConfirmPage", "needJumpRealNameConfirmPage", "needShowBindAccountDialog", "onBindAccount", "isSuccess", "onGetBindAccountInfo", "bindAccountInfo", "Lcom/tencent/tkd/topicsdk/publisharticle/BindAccountInfo;", "onGetRealNameStatus", "needRealNameConfirm", "realNameConfirmUrl", "", "showBindAccountDialog", "showUserProtocol", "url", "updateAndShowRecentTopic", "topicList", "", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface PublishArticleContract$IPublishArticleView
{
  public abstract void a(int paramInt);
  
  public abstract void a(@NotNull BindAccountInfo paramBindAccountInfo);
  
  public abstract void a(@NotNull String paramString);
  
  public abstract void a(@NotNull List<TweetTopicItem> paramList);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, @NotNull String paramString);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void aG_();
  
  public abstract void aH_();
  
  public abstract boolean o_();
  
  public abstract boolean p_();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.PublishArticleContract.IPublishArticleView
 * JD-Core Version:    0.7.0.1
 */