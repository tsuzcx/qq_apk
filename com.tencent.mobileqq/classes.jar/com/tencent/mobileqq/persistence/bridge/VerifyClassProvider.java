package com.tencent.mobileqq.persistence.bridge;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.entitymanager.Provider;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class VerifyClassProvider
  implements Provider<Class[]>
{
  private Class[] a = { MessageRecord.class, RecentUser.class, Friends.class, TroopInfo.class };
  
  @NonNull
  public Class[] a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.bridge.VerifyClassProvider
 * JD-Core Version:    0.7.0.1
 */