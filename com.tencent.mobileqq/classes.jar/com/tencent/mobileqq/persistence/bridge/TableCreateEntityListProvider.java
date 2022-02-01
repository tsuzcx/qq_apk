package com.tencent.mobileqq.persistence.bridge;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.service.message.MessageRecordFactory;

public class TableCreateEntityListProvider
  implements Provider<Entity[]>
{
  private Entity[] a = { new DataLineMsgRecord(1), a() };
  
  private MessageRecord a()
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.frienduin = AppConstants.LBS_HELLO_UIN;
    localMessageRecord.istroop = 1001;
    return localMessageRecord;
  }
  
  @NonNull
  public Entity[] a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.TableCreateEntityListProvider
 * JD-Core Version:    0.7.0.1
 */