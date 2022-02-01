package com.tencent.mobileqq.kandian.biz.ugc.selectmember;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.ugc.ResultRecord;
import java.util.ArrayList;
import java.util.Iterator;

class ReadInJoySelectMemberAQFragment$3
  implements Runnable
{
  ReadInJoySelectMemberAQFragment$3(ReadInJoySelectMemberAQFragment paramReadInJoySelectMemberAQFragment, ArrayList paramArrayList, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)localIterator.next();
      PublicAccountReportUtils.a(null, "", "0X8009543", "0X8009543", 0, 0, "", "", "", ReadInJoySelectMemberAQFragment.a(this.this$0, localResultRecord, this.b), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selectmember.ReadInJoySelectMemberAQFragment.3
 * JD-Core Version:    0.7.0.1
 */