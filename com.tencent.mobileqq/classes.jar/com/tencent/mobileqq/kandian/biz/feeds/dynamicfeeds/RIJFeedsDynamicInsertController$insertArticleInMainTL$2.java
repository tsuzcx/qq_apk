package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.api.IInsertArticleCallback;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJFeedsDynamicInsertController$insertArticleInMainTL$2
  implements Runnable
{
  RIJFeedsDynamicInsertController$insertArticleInMainTL$2(int paramInt, String paramString, List paramList) {}
  
  public final void run()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, (IInsertArticleCallback)new RIJFeedsDynamicInsertController.insertArticleInMainTL.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController.insertArticleInMainTL.2
 * JD-Core Version:    0.7.0.1
 */