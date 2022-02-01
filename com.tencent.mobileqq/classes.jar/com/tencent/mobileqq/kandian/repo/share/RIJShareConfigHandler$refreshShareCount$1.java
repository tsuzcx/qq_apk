package com.tencent.mobileqq.kandian.repo.share;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJShareConfigHandler$refreshShareCount$1
  implements Runnable
{
  RIJShareConfigHandler$refreshShareCount$1(AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public final void run()
  {
    this.a.invalidateProteusTemplateBean();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshShareCount | shareCount ");
      localStringBuilder.append(this.a.mShareCount);
      QLog.d("ReadInJoyShareConfigUtil", 2, localStringBuilder.toString());
    }
    ReadInJoyLogicEngineEventDispatcher.a().c();
    ReadInJoyLogicEngineEventDispatcher.a().d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.share.RIJShareConfigHandler.refreshShareCount.1
 * JD-Core Version:    0.7.0.1
 */