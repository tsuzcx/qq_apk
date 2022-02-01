package com.tencent.tkd.weibo.tweetTopic.searchTopic;

import android.os.Handler;
import android.os.Looper;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.weibo.data.DataTransferManager;
import com.tencent.tkd.weibo.framework.mvp.ListModel;
import com.tencent.tkd.weibo.tweetTopic.hotTopic.TweetHotTopicListModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/tweetTopic/searchTopic/SearchTopicListModel;", "Lcom/tencent/tkd/weibo/framework/mvp/ListModel;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "", "allowCreateNewTopic", "", "(Z)V", "getAllowCreateNewTopic", "()Z", "setAllowCreateNewTopic", "invalidCharPattern", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "uiHandler", "Landroid/os/Handler;", "getUiHandler", "()Landroid/os/Handler;", "wording", "", "getWording", "()Ljava/lang/String;", "setWording", "(Ljava/lang/String;)V", "getCreateTopicItemList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "loadDataFromDB", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "list", "loadDataFromNetwork", "cookie", "Lkotlin/Function7;", "isSuccess", "isEnd", "", "totalSize", "errorCode", "errorMsg", "Lcom/tencent/tkd/weibo/framework/mvp/LoadDataFromNetworkCallback;", "onEmptyTopicLoaded", "onTopicListLoadFailed", "onTopicLoadSuccess", "topicList", "retCookie", "saveDataToDB", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class SearchTopicListModel
  extends ListModel<TweetTopicItem, byte[]>
{
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  private final Pattern jdField_a_of_type_JavaUtilRegexPattern;
  private boolean jdField_a_of_type_Boolean;
  
  public SearchTopicListModel()
  {
    this(false, 1, null);
  }
  
  public SearchTopicListModel(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("\\W");
  }
  
  private final Handler a()
  {
    return new Handler(Looper.getMainLooper());
  }
  
  private final ArrayList<TweetTopicItem> a()
  {
    TweetTopicItem localTweetTopicItem1 = new TweetTopicItem(null, null, null, 0L, null, 31, null);
    localTweetTopicItem1.a("title");
    localTweetTopicItem1.c("创建此话题");
    TweetTopicItem localTweetTopicItem2 = new TweetTopicItem(null, null, null, 0L, null, 31, null);
    localTweetTopicItem2.c(this.jdField_a_of_type_JavaLangString);
    return CollectionsKt.arrayListOf(new TweetTopicItem[] { localTweetTopicItem1, localTweetTopicItem2 });
  }
  
  private final void a(List<TweetTopicItem> paramList, Function7<? super Boolean, ? super Boolean, ? super Integer, ? super ArrayList<TweetTopicItem>, ? super byte[], ? super Integer, ? super String, Unit> paramFunction7, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = new ArrayList((Collection)paramList);
    Iterator localIterator = ((Iterable)localArrayList).iterator();
    while (localIterator.hasNext())
    {
      TweetTopicItem localTweetTopicItem = (TweetTopicItem)localIterator.next();
      String str2 = localTweetTopicItem.c();
      int i;
      if (((CharSequence)str2).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      String str1 = str2;
      if (i != 0)
      {
        str1 = str2;
        if (str2.charAt(0) == '#') {
          if (str2 != null)
          {
            str1 = str2.substring(1);
            Intrinsics.checkExpressionValueIsNotNull(str1, "(this as java.lang.String).substring(startIndex)");
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
          }
        }
      }
      localTweetTopicItem.c(str1);
    }
    if ((this.jdField_a_of_type_Boolean) && ((Intrinsics.areEqual(((TweetTopicItem)paramList.get(0)).c(), this.jdField_a_of_type_JavaLangString) ^ true)))
    {
      paramList = a();
      paramList.addAll((Collection)localArrayList);
    }
    else
    {
      paramList = localArrayList;
    }
    a().post((Runnable)new SearchTopicListModel.onTopicLoadSuccess.1(paramFunction7, paramBoolean, paramList, paramArrayOfByte));
  }
  
  private final void a(Function7<? super Boolean, ? super Boolean, ? super Integer, ? super ArrayList<TweetTopicItem>, ? super byte[], ? super Integer, ? super String, Unit> paramFunction7)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ArrayList localArrayList = a();
      new TweetHotTopicListModel("推荐话题").a(null, (Function7)new SearchTopicListModel.onEmptyTopicLoaded.1(this, localArrayList, paramFunction7));
      return;
    }
    a().post((Runnable)new SearchTopicListModel.onEmptyTopicLoaded.2(paramFunction7));
  }
  
  private final void a(Function7<? super Boolean, ? super Boolean, ? super Integer, ? super ArrayList<TweetTopicItem>, ? super byte[], ? super Integer, ? super String, Unit> paramFunction7, int paramInt, String paramString)
  {
    a().post((Runnable)new SearchTopicListModel.onTopicListLoadFailed.1(paramFunction7, paramInt, paramString));
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
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
    int k = ((CharSequence)this.jdField_a_of_type_JavaLangString).length();
    int i = 0;
    Integer localInteger = Integer.valueOf(0);
    int j = 1;
    Boolean localBoolean = Boolean.valueOf(true);
    if (k == 0) {
      i = 1;
    }
    if ((i == 0) && (!this.jdField_a_of_type_JavaUtilRegexPattern.matcher((CharSequence)this.jdField_a_of_type_JavaLangString).find()))
    {
      i = j;
      if (paramArrayOfByte != null) {
        i = Integer.parseInt(new String(paramArrayOfByte, Charsets.UTF_8));
      }
      DataTransferManager.a.a(i, this.jdField_a_of_type_JavaLangString, (Function5)new SearchTopicListModel.loadDataFromNetwork.1(this, paramFunction7));
      return;
    }
    paramFunction7.invoke(localBoolean, localBoolean, localInteger, new ArrayList(), null, localInteger, "");
  }
  
  public final void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.searchTopic.SearchTopicListModel
 * JD-Core Version:    0.7.0.1
 */