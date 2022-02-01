package com.tribe.async.dispatch;

import android.text.TextUtils;
import com.tribe.async.objectpool.ObjectPool;
import com.tribe.async.objectpool.ObjectPoolBuilder;
import com.tribe.async.utils.AssertUtils;

final class PendingPost
{
  private static final ObjectPool<PendingPost> PENDING_POST_POOL;
  public Dispatcher.Dispatchable dispatchable;
  public String group;
  public PendingPost next;
  public Object tag;
  
  static
  {
    ObjectPoolBuilder localObjectPoolBuilder = new ObjectPoolBuilder(PendingPost.class, new PendingPost.1());
    localObjectPoolBuilder.setAllocator(new PendingPost.2(PendingPost.class));
    PENDING_POST_POOL = localObjectPoolBuilder.build();
  }
  
  static PendingPost obtainPendingPost(Object paramObject, String paramString, Dispatcher.Dispatchable paramDispatchable)
  {
    AssertUtils.checkNotNull(paramObject);
    AssertUtils.checkNotNull(paramString);
    AssertUtils.checkNotNull(paramDispatchable);
    PendingPost localPendingPost = (PendingPost)PENDING_POST_POOL.allocate();
    localPendingPost.dispatchable = paramDispatchable;
    localPendingPost.group = paramString;
    localPendingPost.tag = paramObject;
    localPendingPost.next = null;
    return localPendingPost;
  }
  
  static void releasePendingPost(PendingPost paramPendingPost)
  {
    AssertUtils.checkNotNull(paramPendingPost);
    paramPendingPost.dispatchable = null;
    paramPendingPost.group = null;
    paramPendingPost.tag = null;
    paramPendingPost.next = null;
    PENDING_POST_POOL.release(paramPendingPost);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof PendingPost;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (PendingPost)paramObject;
    bool1 = bool2;
    if (paramObject.dispatchable.equals(this.dispatchable))
    {
      bool1 = bool2;
      if (TextUtils.equals(this.group, paramObject.group))
      {
        bool1 = bool2;
        if (paramObject.tag.equals(this.tag)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    Dispatcher.Dispatchable localDispatchable = this.dispatchable;
    if (localDispatchable == null) {
      return 0;
    }
    return localDispatchable.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.dispatch.PendingPost
 * JD-Core Version:    0.7.0.1
 */