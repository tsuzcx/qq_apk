package com.tencent.mobileqq.intervideo.singtogether;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Set;

class FetchOpenIdManager$3
  extends FriendListObserver
{
  FetchOpenIdManager$3(FetchOpenIdManager paramFetchOpenIdManager) {}
  
  public void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    QLog.i("FetchOpenIdManager", 1, "onUpdateDelFriend isSuccess: " + paramBoolean + " object: " + paramObject);
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)paramObject).longValue();
      paramObject = FetchOpenIdManager.a(this.a).keySet().toArray();
      int i = paramObject.length - 1;
      while (i >= 0)
      {
        Long localLong = (Long)paramObject[i];
        this.a.a(localLong.longValue(), l);
        i -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.singtogether.FetchOpenIdManager.3
 * JD-Core Version:    0.7.0.1
 */