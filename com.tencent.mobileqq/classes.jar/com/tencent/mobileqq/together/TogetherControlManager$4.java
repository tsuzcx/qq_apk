package com.tencent.mobileqq.together;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class TogetherControlManager$4
  extends FriendListObserver
{
  TogetherControlManager$4(TogetherControlManager paramTogetherControlManager) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUpdateDelFriend isSuccess: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" object: ");
    ((StringBuilder)localObject).append(paramObject);
    QLog.i("TogetherControlManager", 1, ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      localObject = TogetherControlManager.a(this.a).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TogetherParser)((Map.Entry)((Iterator)localObject).next()).getValue()).a(paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherControlManager.4
 * JD-Core Version:    0.7.0.1
 */