package com.tencent.mobileqq.friend.cache;

import com.tencent.mobileqq.friend.api.callback.GetGroupListCallback;
import java.util.ArrayList;

class GroupCache$1
  implements Runnable
{
  GroupCache$1(GroupCache paramGroupCache, GetGroupListCallback paramGetGroupListCallback) {}
  
  public void run()
  {
    GroupCache.a(this.this$0);
    GetGroupListCallback localGetGroupListCallback = this.a;
    if (localGetGroupListCallback != null) {
      localGetGroupListCallback.a(new ArrayList(GroupCache.a(this.this$0)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.cache.GroupCache.1
 * JD-Core Version:    0.7.0.1
 */