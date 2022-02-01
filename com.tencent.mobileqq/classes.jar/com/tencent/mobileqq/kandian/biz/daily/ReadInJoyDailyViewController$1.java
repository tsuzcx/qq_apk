package com.tencent.mobileqq.kandian.biz.daily;

import com.tencent.mobileqq.kandian.repo.account.RIJUserLevelModule.UserLevelInfoUpdateListener;
import com.tencent.mobileqq.kandian.repo.account.UserLevelInfo;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class ReadInJoyDailyViewController$1
  implements RIJUserLevelModule.UserLevelInfoUpdateListener
{
  ReadInJoyDailyViewController$1(ReadInJoyDailyViewController paramReadInJoyDailyViewController) {}
  
  public void a(@NotNull UserLevelInfo paramUserLevelInfo)
  {
    if ((ReadInJoyDailyViewController.a(this.a)) && (paramUserLevelInfo.level > 0L))
    {
      ReadInJoyDailyViewController.b(this.a);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("userLevelInfoOnUpdate, hasPublisherEntryConfig=");
    localStringBuilder.append(ReadInJoyDailyViewController.a(this.a));
    localStringBuilder.append(", level=");
    localStringBuilder.append(paramUserLevelInfo.level);
    QLog.i("ReadInJoyDailyViewController", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyViewController.1
 * JD-Core Version:    0.7.0.1
 */