package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class ExtendFriendBaseFragment$1
  implements Runnable
{
  ExtendFriendBaseFragment$1(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  public void run()
  {
    if ((this.this$0.m != null) && (this.this$0.m.b() > 0) && (this.this$0.h != null) && (this.this$0.o != null) && (this.this$0.i != null))
    {
      if (this.this$0.h.isFinishing()) {
        return;
      }
      Object localObject1 = ExtendFriendBaseFragment.a(this.this$0);
      Object localObject2 = new ArrayList();
      Object localObject3 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((ArrayList)localObject2).add(((ExtendFriendBaseFragment.ExposureFeedInfo)((Iterator)localObject3).next()).d.mUin);
      }
      localObject3 = ExtendFriendBaseFragment.b(this.this$0).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if (!((ArrayList)localObject2).contains(str)) {
          ExtendFriendBaseFragment.b(this.this$0).remove(str);
        }
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ExtendFriendBaseFragment.ExposureFeedInfo)((Iterator)localObject1).next();
        localObject3 = ((ExtendFriendBaseFragment.ExposureFeedInfo)localObject2).d.mUin;
        if (!ExtendFriendBaseFragment.b(this.this$0).containsKey(localObject3))
        {
          ((ExtendFriendBaseFragment.ExposureFeedInfo)localObject2).a = System.currentTimeMillis();
          ExtendFriendBaseFragment.b(this.this$0).put(localObject3, localObject2);
        }
      }
      QLog.d("ExtendFriendBaseFragment", 2, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */