package com.tencent.mobileqq.kandian.biz.ugc;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo.Builder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadInJoyUgcSearchTopicFragment$2
  extends ReadInJoyObserver
{
  ReadInJoyUgcSearchTopicFragment$2(ReadInJoyUgcSearchTopicFragment paramReadInJoyUgcSearchTopicFragment) {}
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    if ((0L != paramLong) && (!TextUtils.isEmpty(paramString)))
    {
      if ((ReadInJoyUgcSearchTopicFragment.a(this.a) != null) && (ReadInJoyUgcSearchTopicFragment.a(this.a).size() == 1))
      {
        Object localObject2 = (TopicInfo)ReadInJoyUgcSearchTopicFragment.a(this.a).get(0);
        long l = ((TopicInfo)localObject2).a();
        localObject1 = ((TopicInfo)localObject2).a();
        String str1 = ((TopicInfo)localObject2).b();
        String str2 = ((TopicInfo)localObject2).c();
        ((TopicInfo)localObject2).d();
        localObject2 = TopicInfo.a().a(l);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("#");
        localStringBuilder.append((String)localObject1);
        localObject1 = ((TopicInfo.Builder)localObject2).a(localStringBuilder.toString()).b(str1).c(str2).d(paramString).a();
        ReadInJoyUgcSearchTopicFragment.a(this.a, (TopicInfo)localObject1);
        ReadInJoyUtils.a("0X800980A", ReadInJoyUgcSearchTopicFragment.a(this.a), paramLong, "1");
        RIJDeliverUGCReportUtil.a(String.valueOf(paramLong), "1");
      }
    }
    else
    {
      localObject1 = this.a;
      ((ReadInJoyUgcSearchTopicFragment)localObject1).a(1, ((ReadInJoyUgcSearchTopicFragment)localObject1).getString(2131717834));
    }
    ReadInJoyUgcSearchTopicFragment.a(this.a, false);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handle0xc16CreateTopic, topicID:");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append("  topicUrl:");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(" result:");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.d("ReadInJoyUgcSearchTopicFragment", 1, ((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyUgcSearchTopicFragment.2
 * JD-Core Version:    0.7.0.1
 */