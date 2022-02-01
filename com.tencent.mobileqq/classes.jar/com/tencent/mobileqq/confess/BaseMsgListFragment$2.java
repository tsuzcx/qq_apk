package com.tencent.mobileqq.confess;

import android.text.TextUtils;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class BaseMsgListFragment$2
  extends AvatarObserver
{
  BaseMsgListFragment$2(BaseMsgListFragment paramBaseMsgListFragment) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.a.a(paramString, 1))) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.BaseMsgListFragment.2
 * JD-Core Version:    0.7.0.1
 */