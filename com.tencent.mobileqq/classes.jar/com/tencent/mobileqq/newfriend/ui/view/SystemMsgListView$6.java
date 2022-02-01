package com.tencent.mobileqq.newfriend.ui.view;

import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

class SystemMsgListView$6
  extends DiscussionObserver
{
  SystemMsgListView$6(SystemMsgListView paramSystemMsgListView) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (paramBoolean) {
      SystemMsgListView.a(this.a).b(paramLong);
    }
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      Object localObject = null;
      if ((paramObject instanceof ArrayList)) {
        localObject = (ArrayList)paramObject;
      }
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        paramObject = ((ArrayList)localObject).iterator();
        while (paramObject.hasNext())
        {
          localObject = paramObject.next();
          if ((localObject instanceof Long)) {
            SystemMsgListView.a(this.a).b(((Long)localObject).longValue());
          }
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      try
      {
        long l = Long.parseLong(paramString);
        SystemMsgListView.a(this.a).b(l);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView.6
 * JD-Core Version:    0.7.0.1
 */