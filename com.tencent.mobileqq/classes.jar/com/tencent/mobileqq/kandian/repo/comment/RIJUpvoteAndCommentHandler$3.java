package com.tencent.mobileqq.kandian.repo.comment;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.FeedsInfo;
import tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.SocializeFeedsInfo;

class RIJUpvoteAndCommentHandler$3
  implements Runnable
{
  RIJUpvoteAndCommentHandler$3(RIJUpvoteAndCommentHandler paramRIJUpvoteAndCommentHandler, List paramList, ConcurrentHashMap paramConcurrentHashMap) {}
  
  public void run()
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (oidb_cmd0x8c8.FeedsInfo)localIterator.next();
      if ((((oidb_cmd0x8c8.FeedsInfo)localObject).feeds_type.has()) && (((oidb_cmd0x8c8.FeedsInfo)localObject).msg_social_fees_info.has()) && (((oidb_cmd0x8c8.FeedsInfo)localObject).msg_social_fees_info.uint64_feeds_id.has()))
      {
        long l = ((oidb_cmd0x8c8.FeedsInfo)localObject).msg_social_fees_info.uint64_feeds_id.get();
        int i = ((oidb_cmd0x8c8.FeedsInfo)localObject).feeds_type.get();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(i);
        localObject = ((StringBuilder)localObject).toString();
        localObject = (AbsBaseArticleInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if (localObject != null)
        {
          RIJUpvoteAndCommentHandler.b(this.this$0).removeEntityIfExistsInDB((Entity)localObject);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("remove artileinfo cache is null while feedid = ");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append("feedtype");
          ((StringBuilder)localObject).append(i);
          QLog.d("RIJUpvoteAndCommentHandler", 1, ((StringBuilder)localObject).toString());
        }
        localObject = RIJUpvoteAndCommentHandler.c(this.this$0).a().c(0);
        RIJUpvoteAndCommentHandler.a(this.this$0, (ConcurrentMap)localObject, l, i, localArrayList2);
        localObject = RIJUpvoteAndCommentHandler.d(this.this$0).a().c(70);
        RIJUpvoteAndCommentHandler.b(this.this$0, (ConcurrentMap)localObject, l, i, localArrayList2);
      }
    }
    localArrayList2 = new ArrayList(localArrayList2);
    localArrayList1 = new ArrayList(localArrayList1);
    ThreadManager.getUIHandler().post(new RIJUpvoteAndCommentHandler.3.1(this, localArrayList2, localArrayList1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.comment.RIJUpvoteAndCommentHandler.3
 * JD-Core Version:    0.7.0.1
 */