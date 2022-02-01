package com.tencent.mobileqq.intervideo.singtogether;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Set;

class FetchOpenIdManager$3
  extends FriendListObserver
{
  FetchOpenIdManager$3(FetchOpenIdManager paramFetchOpenIdManager) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUpdateDelFriend isSuccess: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" object: ");
    ((StringBuilder)localObject).append(paramObject);
    QLog.i("FetchOpenIdManager", 1, ((StringBuilder)localObject).toString());
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)paramObject).longValue();
      paramObject = FetchOpenIdManager.a(this.a).keySet().toArray();
      int i = paramObject.length - 1;
      while (i >= 0)
      {
        localObject = (Long)paramObject[i];
        this.a.a(((Long)localObject).longValue(), l);
        i -= 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.singtogether.FetchOpenIdManager.3
 * JD-Core Version:    0.7.0.1
 */