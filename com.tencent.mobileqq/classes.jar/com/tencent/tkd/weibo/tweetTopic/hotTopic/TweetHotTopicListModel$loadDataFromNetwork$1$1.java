package com.tencent.tkd.weibo.tweetTopic.hotTopic;

import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TweetHotTopicListModel$loadDataFromNetwork$1$1
  implements Runnable
{
  TweetHotTopicListModel$loadDataFromNetwork$1$1(TweetHotTopicListModel.loadDataFromNetwork.1 param1, int paramInt, List paramList, boolean paramBoolean, byte[] paramArrayOfByte, String paramString) {}
  
  public final void run()
  {
    int i = this.jdField_a_of_type_Int;
    Boolean localBoolean = Boolean.valueOf(true);
    Integer localInteger = Integer.valueOf(0);
    if (i == 0)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject == null) {
        localObject = new ArrayList();
      }
      ArrayList localArrayList = new ArrayList((Collection)localObject);
      Iterator localIterator = ((Iterable)localArrayList).iterator();
      while (localIterator.hasNext())
      {
        TweetTopicItem localTweetTopicItem = (TweetTopicItem)localIterator.next();
        String str = localTweetTopicItem.c();
        if (((CharSequence)str).length() > 0) {
          i = 1;
        } else {
          i = 0;
        }
        localObject = str;
        if (i != 0)
        {
          localObject = str;
          if (str.charAt(0) == '#') {
            if (str != null)
            {
              localObject = str.substring(1);
              Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).substring(startIndex)");
            }
            else
            {
              throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
          }
        }
        localTweetTopicItem.c((String)localObject);
      }
      if (((CharSequence)this.this$0.this$0.a()).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && ((((Collection)localArrayList).isEmpty() ^ true)))
      {
        localObject = new TweetTopicItem(null, null, null, 0L, null, 31, null);
        ((TweetTopicItem)localObject).a("title");
        ((TweetTopicItem)localObject).c(this.this$0.this$0.a());
        localArrayList.add(0, localObject);
      }
      this.this$0.$callback.invoke(localBoolean, Boolean.valueOf(this.jdField_a_of_type_Boolean), localInteger, localArrayList, this.jdField_a_of_type_ArrayOfByte, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
      return;
    }
    this.this$0.$callback.invoke(Boolean.valueOf(false), localBoolean, localInteger, new ArrayList(), null, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.tweetTopic.hotTopic.TweetHotTopicListModel.loadDataFromNetwork.1.1
 * JD-Core Version:    0.7.0.1
 */