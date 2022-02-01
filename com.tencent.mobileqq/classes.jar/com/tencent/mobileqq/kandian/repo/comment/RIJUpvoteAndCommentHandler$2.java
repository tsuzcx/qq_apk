package com.tencent.mobileqq.kandian.repo.comment;

import android.os.Handler;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.FeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;

class RIJUpvoteAndCommentHandler$2
  implements Runnable
{
  RIJUpvoteAndCommentHandler$2(RIJUpvoteAndCommentHandler paramRIJUpvoteAndCommentHandler, List paramList, ConcurrentHashMap paramConcurrentHashMap, boolean paramBoolean) {}
  
  public void run()
  {
    EntityTransaction localEntityTransaction = RIJUpvoteAndCommentHandler.c(this.this$0).getTransaction();
    localEntityTransaction.begin();
    Iterator localIterator = this.a.iterator();
    int i = 0;
    Object localObject1;
    if (localIterator.hasNext()) {
      localObject1 = (oidb_cmd0x8c8.FeedsInfo)localIterator.next();
    }
    for (;;)
    {
      try
      {
        if ((!((oidb_cmd0x8c8.FeedsInfo)localObject1).has()) || (((oidb_cmd0x8c8.FeedsInfo)localObject1).get() == null) || (!((oidb_cmd0x8c8.FeedsInfo)localObject1).msg_social_fees_info.has()) || (((oidb_cmd0x8c8.FeedsInfo)localObject1).msg_social_fees_info.get() == null)) {
          break;
        }
        oidb_cmd0x8c8.SocializeFeedsInfo localSocializeFeedsInfo = (oidb_cmd0x8c8.SocializeFeedsInfo)((oidb_cmd0x8c8.FeedsInfo)localObject1).msg_social_fees_info.get();
        if (!localSocializeFeedsInfo.uint64_feeds_id.has()) {
          break label539;
        }
        l = localSocializeFeedsInfo.uint64_feeds_id.get();
        if (l == 0L)
        {
          QLog.d("RIJUpvoteAndCommentHandler", 1, "convertPBToInfo failed feedsInfo feedsId == 0");
          break;
        }
        if (!((oidb_cmd0x8c8.FeedsInfo)localObject1).feeds_type.has())
        {
          QLog.d("RIJUpvoteAndCommentHandler", 1, "convertPBToInfo failed feedsInfo feeds_type == null");
          break;
        }
        int j = ((oidb_cmd0x8c8.FeedsInfo)localObject1).feeds_type.get();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(l);
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(j);
        localObject1 = ((StringBuilder)localObject1).toString();
        QLog.d("RIJUpvoteAndCommentHandler", 1, new Object[] { "handle 8c8, feedsId = ", Long.valueOf(l), ", feedsType = ", Integer.valueOf(j) });
        Object localObject2 = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(0);
        localObject2 = (AbsBaseArticleInfo)((ConcurrentHashMap)localObject2).get(localStringBuilder.toString());
        if (localObject2 != null) {
          RIJUpvoteAndCommentHandler.a(this.this$0, (AbsBaseArticleInfo)localObject2, localSocializeFeedsInfo, 0);
        }
        localObject2 = this.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(70);
        localObject2 = (AbsBaseArticleInfo)((ConcurrentHashMap)localObject2).get(localStringBuilder.toString());
        if (localObject2 != null) {
          RIJUpvoteAndCommentHandler.a(this.this$0, (AbsBaseArticleInfo)localObject2, localSocializeFeedsInfo, 70);
        }
        localObject2 = this.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(41403);
        localObject1 = (AbsBaseArticleInfo)((ConcurrentHashMap)localObject2).get(localStringBuilder.toString());
        if (localObject1 != null) {
          RIJUpvoteAndCommentHandler.a(this.this$0, (AbsBaseArticleInfo)localObject1, localSocializeFeedsInfo, 41403);
        }
        if ((this.c) && (localObject1 != null) && (((AbsBaseArticleInfo)localObject1).mSocialFeedInfo != null))
        {
          boolean bool = RIJUpvoteAndCommentHandler.a(this.this$0, (AbsBaseArticleInfo)localObject1);
          if (!bool) {
            break;
          }
        }
        i = 1;
      }
      catch (Exception localException)
      {
        QLog.d("RIJUpvoteAndCommentHandler", 1, "handle0x8c8UpdateUpvoteAndComment merge failed ", localException);
      }
      break;
      if ((i != 0) && (RIJUpvoteAndCommentHandler.d(this.this$0) != null)) {
        RIJUpvoteAndCommentHandler.e(this.this$0).post(new RIJUpvoteAndCommentHandler.2.1(this));
      }
      localEntityTransaction.commit();
      localEntityTransaction.end();
      return;
      label539:
      long l = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.comment.RIJUpvoteAndCommentHandler.2
 * JD-Core Version:    0.7.0.1
 */