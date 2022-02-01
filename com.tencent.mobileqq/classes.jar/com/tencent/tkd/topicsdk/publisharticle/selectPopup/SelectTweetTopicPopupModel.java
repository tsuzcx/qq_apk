package com.tencent.tkd.topicsdk.publisharticle.selectPopup;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.tkd.R.string;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.topicsdk.interfaces.IDataTransfer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/selectPopup/SelectTweetTopicPopupModel;", "Lcom/tencent/tkd/topicsdk/publisharticle/selectPopup/ISelectPopupModel;", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "()V", "dataTransfer", "Lcom/tencent/tkd/topicsdk/interfaces/IDataTransfer;", "getDataTransfer", "()Lcom/tencent/tkd/topicsdk/interfaces/IDataTransfer;", "localDataMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getObjectFromInput", "", "wording", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "type", "getObjectFromLocal", "getPopupTitle", "context", "Landroid/content/Context;", "getTag", "", "Companion", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class SelectTweetTopicPopupModel
  implements ISelectPopupModel<TweetTopicItem>
{
  public static final SelectTweetTopicPopupModel.Companion a = new SelectTweetTopicPopupModel.Companion(null);
  private HashMap<String, TweetTopicItem> b = new HashMap(10);
  
  private final IDataTransfer b()
  {
    return TopicSDK.a.a().b().g();
  }
  
  public char a()
  {
    return '#';
  }
  
  @NotNull
  public String a(@NotNull Context paramContext, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (paramInt == 1)
    {
      paramContext = paramContext.getResources().getString(R.string.h);
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.resources.getStr…tring.click_to_add_topic)");
      return paramContext;
    }
    paramContext = paramContext.getResources().getString(R.string.i);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "context.resources.getStr…ng.click_to_create_topic)");
    return paramContext;
  }
  
  public void a(@NotNull String paramString, @NotNull Function1<? super Integer, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "wording");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    TweetTopicItem localTweetTopicItem = (TweetTopicItem)this.b.get(paramString);
    if ((this.b.containsKey(paramString)) && (localTweetTopicItem != null))
    {
      int i;
      if (((CharSequence)localTweetTopicItem.a()).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        paramFunction1.invoke(Integer.valueOf(1));
        return;
      }
    }
    b().a(0, 1, paramString, (Function4)new SelectTweetTopicPopupModel.getObjectFromInput.1(this, paramString, paramFunction1));
  }
  
  @NotNull
  public TweetTopicItem b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "wording");
    TweetTopicItem localTweetTopicItem = (TweetTopicItem)this.b.get(paramString);
    if ((this.b.containsKey(paramString)) && (localTweetTopicItem != null)) {
      return localTweetTopicItem;
    }
    localTweetTopicItem = new TweetTopicItem(null, null, null, 0L, null, 0L, null, 127, null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('#');
    localStringBuilder.append(paramString);
    localTweetTopicItem.c(localStringBuilder.toString());
    return localTweetTopicItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.selectPopup.SelectTweetTopicPopupModel
 * JD-Core Version:    0.7.0.1
 */