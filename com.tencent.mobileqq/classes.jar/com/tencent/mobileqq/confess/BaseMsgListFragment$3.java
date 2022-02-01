package com.tencent.mobileqq.confess;

import com.tencent.mobileqq.app.FriendListObserver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class BaseMsgListFragment$3
  extends FriendListObserver
{
  BaseMsgListFragment$3(BaseMsgListFragment paramBaseMsgListFragment) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof HashMap))) {
      j = 0;
    }
    try
    {
      paramObject = ((HashMap)paramObject).entrySet().iterator();
      do
      {
        Map.Entry localEntry;
        do
        {
          i = j;
          if (!paramObject.hasNext()) {
            break;
          }
          localEntry = (Map.Entry)paramObject.next();
        } while (localEntry == null);
        paramBoolean = this.a.a((String)localEntry.getKey(), 2);
      } while (!paramBoolean);
      i = 1;
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        int i = j;
      }
    }
    if (i != 0) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.confess.BaseMsgListFragment.3
 * JD-Core Version:    0.7.0.1
 */