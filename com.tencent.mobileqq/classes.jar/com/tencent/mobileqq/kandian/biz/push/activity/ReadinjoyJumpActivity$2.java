package com.tencent.mobileqq.kandian.biz.push.activity;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.ReadinjoyJumpUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ReadinjoyJumpActivity$2
  extends ReadInJoyObserver
{
  ReadinjoyJumpActivity$2(ReadinjoyJumpActivity paramReadinjoyJumpActivity) {}
  
  public void a(boolean paramBoolean, List<Long> paramList, List<AbsBaseArticleInfo> paramList1)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("68b resp, succ : ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", ids : ");
    ((StringBuilder)localObject).append(paramList);
    ((StringBuilder)localObject).append(", articles : ");
    ((StringBuilder)localObject).append(paramList1);
    QLog.d("ReadinjoyJumpActivity", 1, ((StringBuilder)localObject).toString());
    if (paramList != null)
    {
      if (!paramList.contains(Long.valueOf(ReadinjoyJumpActivity.a(this.a)))) {
        return;
      }
      ThreadManager.getUIHandler().removeCallbacks(ReadinjoyJumpActivity.a(this.a));
      if (!ReadinjoyJumpActivity.a(this.a))
      {
        if (ReadinjoyJumpActivity.b(this.a)) {
          return;
        }
        if ((paramBoolean) && (paramList1 != null) && (!paramList1.isEmpty()))
        {
          int i = 0;
          while (i < paramList1.size())
          {
            paramList = (AbsBaseArticleInfo)paramList1.get(i);
            if (paramList.mArticleID == ReadinjoyJumpActivity.a(this.a))
            {
              ReadinjoyJumpActivity.a(this.a, paramList);
              if ((ReadinjoyJumpUtils.a(ReadinjoyJumpActivity.a(this.a)) == 0) && (RIJFeedsType.a(ReadinjoyJumpActivity.a(this.a).mArticleContentUrl, 0L, ReadinjoyJumpActivity.a(this.a))))
              {
                paramList = ReadInJoyLogicEngine.a().a();
                if (paramList != null)
                {
                  paramList1 = ReadinjoyJumpActivity.a(this.a).mArticleContentUrl;
                  localObject = ReadinjoyJumpActivity.a(this.a).innerUniqueID;
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append(ReadinjoyJumpActivity.a(this.a).publishUin);
                  localStringBuilder.append("");
                  paramList.a(paramList1, (String)localObject, localStringBuilder.toString(), 1, this.a);
                  return;
                }
              }
              ReadinjoyJumpActivity.b(this.a);
              return;
            }
            i += 1;
          }
        }
        ReadinjoyJumpActivity.a(this.a);
      }
    }
  }
  
  public void d_(String paramString)
  {
    super.d_(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("webCallback : ");
    localStringBuilder.append(paramString);
    QLog.d("ReadinjoyJumpActivity", 1, localStringBuilder.toString());
    ThreadManager.getUIHandler().post(new ReadinjoyJumpActivity.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.activity.ReadinjoyJumpActivity.2
 * JD-Core Version:    0.7.0.1
 */