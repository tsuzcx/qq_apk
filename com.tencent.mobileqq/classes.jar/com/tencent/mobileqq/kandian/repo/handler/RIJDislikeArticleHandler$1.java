package com.tencent.mobileqq.kandian.repo.handler;

import com.tencent.mobileqq.kandian.repo.db.struct.DislikeResult;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class RIJDislikeArticleHandler$1
  implements Runnable
{
  RIJDislikeArticleHandler$1(RIJDislikeArticleHandler paramRIJDislikeArticleHandler, int paramInt, List paramList) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    ((RIJDislikeArticleHandler)localObject1).g = this.a;
    Object localObject2 = this.b;
    ((RIJDislikeArticleHandler)localObject1).h = ((List)localObject2);
    if (localObject2 != null)
    {
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DislikeResult)((Iterator)localObject1).next();
        if (((DislikeResult)localObject2).b != 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("dislike fail ,articleID : ");
          localStringBuilder.append(((DislikeResult)localObject2).a);
          localStringBuilder.append(", failCode : ");
          localStringBuilder.append(((DislikeResult)localObject2).b);
          localStringBuilder.append(",fialMessage : ");
          localStringBuilder.append(((DislikeResult)localObject2).c);
          QLog.e("RIJDislikeArticleHandler", 2, localStringBuilder.toString());
        }
      }
    }
    if (this.this$0.g == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("dislike upload successful ! count : ");
      localObject2 = this.b;
      int i;
      if (localObject2 != null) {
        i = ((List)localObject2).size();
      } else {
        i = 0;
      }
      ((StringBuilder)localObject1).append(i);
      QLog.d("RIJDislikeArticleHandler", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJDislikeArticleHandler.1
 * JD-Core Version:    0.7.0.1
 */