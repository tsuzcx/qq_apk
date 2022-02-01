package com.tencent.mobileqq.kandian.biz.feeds;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.kandian.repo.push.api.MessageObserver;

class ReadInJoyProteusFamilyListViewGroup$6
  implements MessageObserver
{
  ReadInJoyProteusFamilyListViewGroup$6(ReadInJoyProteusFamilyListViewGroup paramReadInJoyProteusFamilyListViewGroup) {}
  
  public void a(MessageRecord paramMessageRecord) {}
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    this.a.a().runOnUiThread(new ReadInJoyProteusFamilyListViewGroup.6.2(this));
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    this.a.a().runOnUiThread(new ReadInJoyProteusFamilyListViewGroup.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyProteusFamilyListViewGroup.6
 * JD-Core Version:    0.7.0.1
 */