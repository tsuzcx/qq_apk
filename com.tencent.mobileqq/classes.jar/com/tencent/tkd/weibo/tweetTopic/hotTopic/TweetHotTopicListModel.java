package com.tencent.tkd.weibo.tweetTopic.hotTopic;

import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.topicsdk.mvp.ListModel;
import com.tencent.tkd.weibo.data.DataTransferManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/tweetTopic/hotTopic/TweetHotTopicListModel;", "Lcom/tencent/tkd/topicsdk/mvp/ListModel;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "", "title", "", "(Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "loadDataFromDB", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "list", "loadDataFromNetwork", "cookie", "Lkotlin/Function7;", "", "isSuccess", "isEnd", "", "totalSize", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "errorCode", "errorMsg", "Lcom/tencent/tkd/topicsdk/mvp/LoadDataFromNetworkCallback;", "saveDataToDB", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class TweetHotTopicListModel
  extends ListModel<TweetTopicItem, byte[]>
{
  @NotNull
  private final String b;
  
  public TweetHotTopicListModel(@NotNull String paramString)
  {
    this.b = paramString;
  }
  
  public void a(@NotNull List<TweetTopicItem> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
  }
  
  public void a(@NotNull Function1<? super List<TweetTopicItem>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
  }
  
  public void a(@Nullable byte[] paramArrayOfByte, @NotNull Function7<? super Boolean, ? super Boolean, ? super Integer, ? super ArrayList<TweetTopicItem>, ? super byte[], ? super Integer, ? super String, Unit> paramFunction7)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction7, "callback");
    int i;
    if (paramArrayOfByte != null) {
      i = Integer.parseInt(new String(paramArrayOfByte, Charsets.UTF_8));
    } else {
      i = 1;
    }
    DataTransferManager.a.a(i, (Function5)new TweetHotTopicListModel.loadDataFromNetwork.1(this, paramFunction7));
  }
  
  @NotNull
  public final String c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.hotTopic.TweetHotTopicListModel
 * JD-Core Version:    0.7.0.1
 */