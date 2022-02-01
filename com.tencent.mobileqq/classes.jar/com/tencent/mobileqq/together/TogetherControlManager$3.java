package com.tencent.mobileqq.together;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class TogetherControlManager$3
  extends FriendListObserver
{
  TogetherControlManager$3(TogetherControlManager paramTogetherControlManager) {}
  
  public void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    QLog.i("TogetherControlManager", 1, "onUpdateDelFriend isSuccess: " + paramBoolean + " object: " + paramObject);
    if (paramBoolean)
    {
      Iterator localIterator = TogetherControlManager.a(this.a).entrySet().iterator();
      while (localIterator.hasNext()) {
        ((TogetherParser)((Map.Entry)localIterator.next()).getValue()).a(paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherControlManager.3
 * JD-Core Version:    0.7.0.1
 */