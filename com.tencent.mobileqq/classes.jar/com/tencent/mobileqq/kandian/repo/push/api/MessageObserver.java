package com.tencent.mobileqq.kandian.repo.push.api;

import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;

public abstract interface MessageObserver
{
  public abstract void a(MessageRecord paramMessageRecord);
  
  public abstract void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle);
  
  public abstract void b(MessageRecord paramMessageRecord);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.push.api.MessageObserver
 * JD-Core Version:    0.7.0.1
 */