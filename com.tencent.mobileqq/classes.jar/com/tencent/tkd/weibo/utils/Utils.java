package com.tencent.tkd.weibo.utils;

import com.tencent.tkd.topicsdk.bean.AtPersonItem;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.weibo.bean.EditObject;
import com.tencent.tkd.weibo.bean.EditObject.EditObjectType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/utils/Utils;", "", "()V", "toEditObject", "Lcom/tencent/tkd/weibo/bean/EditObject;", "Lcom/tencent/tkd/topicsdk/bean/AtPersonItem;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "tkd-weibo-richtext_release"}, k=1, mv={1, 1, 16})
public final class Utils
{
  public static final Utils a = new Utils();
  
  @NotNull
  public final EditObject a(@NotNull AtPersonItem paramAtPersonItem)
  {
    Intrinsics.checkParameterIsNotNull(paramAtPersonItem, "$this$toEditObject");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('@');
    ((StringBuilder)localObject).append(paramAtPersonItem.b());
    localObject = new EditObject(((StringBuilder)localObject).toString(), EditObject.EditObjectType.TYPE_AT);
    ((EditObject)localObject).setKey(paramAtPersonItem.c());
    ((EditObject)localObject).setHref(paramAtPersonItem.d());
    ((EditObject)localObject).setAvatarUrl(paramAtPersonItem.a());
    return localObject;
  }
  
  @NotNull
  public final EditObject a(@NotNull TweetTopicItem paramTweetTopicItem)
  {
    Intrinsics.checkParameterIsNotNull(paramTweetTopicItem, "$this$toEditObject");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append('#');
    ((StringBuilder)localObject).append(paramTweetTopicItem.c());
    localObject = new EditObject(((StringBuilder)localObject).toString(), EditObject.EditObjectType.TYPE_TOPIC);
    ((EditObject)localObject).setKey(paramTweetTopicItem.a());
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.utils.Utils
 * JD-Core Version:    0.7.0.1
 */