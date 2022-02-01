package com.tencent.tkd.weibo.tweetTopic.hotTopic;

import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function7;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TweetHotTopicListModel$loadDataFromNetwork$1$1
  implements Runnable
{
  TweetHotTopicListModel$loadDataFromNetwork$1$1(TweetHotTopicListModel.loadDataFromNetwork.1 param1, int paramInt, List paramList, boolean paramBoolean, byte[] paramArrayOfByte, String paramString) {}
  
  public final void run()
  {
    int i = this.a;
    int j = 1;
    Boolean localBoolean = Boolean.valueOf(true);
    Integer localInteger = Integer.valueOf(0);
    if (i == 0)
    {
      Object localObject = this.b;
      if (localObject == null) {
        localObject = new ArrayList();
      }
      ArrayList localArrayList = new ArrayList((Collection)localObject);
      if (((CharSequence)this.this$0.this$0.c()).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && ((((Collection)localArrayList).isEmpty() ^ true)))
      {
        TweetTopicItem localTweetTopicItem = new TweetTopicItem(null, null, null, 0L, null, 0L, null, 127, null);
        localTweetTopicItem.a("title");
        String str = this.this$0.this$0.c();
        localTweetTopicItem.c(this.this$0.this$0.c());
        if (((CharSequence)str).length() > 0) {
          i = j;
        } else {
          i = 0;
        }
        localObject = str;
        if (i != 0)
        {
          localObject = str;
          if (str.charAt(0) != '#')
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append('#');
            ((StringBuilder)localObject).append(str);
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        localTweetTopicItem.c((String)localObject);
        localArrayList.add(0, localTweetTopicItem);
      }
      this.this$0.$callback.invoke(localBoolean, Boolean.valueOf(this.c), localInteger, localArrayList, this.d, Integer.valueOf(this.a), this.e);
      return;
    }
    this.this$0.$callback.invoke(Boolean.valueOf(false), localBoolean, localInteger, new ArrayList(), null, Integer.valueOf(this.a), this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.hotTopic.TweetHotTopicListModel.loadDataFromNetwork.1.1
 * JD-Core Version:    0.7.0.1
 */