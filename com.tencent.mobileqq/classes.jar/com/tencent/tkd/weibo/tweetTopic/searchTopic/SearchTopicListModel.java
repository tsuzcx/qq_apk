package com.tencent.tkd.weibo.tweetTopic.searchTopic;

import com.tencent.tkd.weibo.bean.TweetTopicItem;
import com.tencent.tkd.weibo.data.DataTransferManager;
import com.tencent.tkd.weibo.framework.mvp.ListModel;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/tweetTopic/searchTopic/SearchTopicListModel;", "Lcom/tencent/tkd/weibo/framework/mvp/ListModel;", "Lcom/tencent/tkd/weibo/bean/TweetTopicItem;", "", "()V", "wording", "", "getWording", "()Ljava/lang/String;", "setWording", "(Ljava/lang/String;)V", "loadDataFromDB", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "list", "loadDataFromNetwork", "cookie", "Lkotlin/Function7;", "", "isSuccess", "isEnd", "", "totalSize", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "errorCode", "errorMsg", "Lcom/tencent/tkd/weibo/framework/mvp/LoadDataFromNetworkCallback;", "saveDataToDB", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class SearchTopicListModel
  extends ListModel<TweetTopicItem, byte[]>
{
  @NotNull
  private String a = "";
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.a = paramString;
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
    if (((CharSequence)this.a).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramFunction7.invoke(Boolean.valueOf(true), Boolean.valueOf(true), Integer.valueOf(0), new ArrayList(), null, Integer.valueOf(0), "");
      return;
    }
    if (paramArrayOfByte != null) {}
    for (i = Integer.parseInt(new String(paramArrayOfByte, Charsets.UTF_8));; i = 1)
    {
      DataTransferManager.a.a(i, this.a, (Function5)new SearchTopicListModel.loadDataFromNetwork.1(paramFunction7));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.searchTopic.SearchTopicListModel
 * JD-Core Version:    0.7.0.1
 */