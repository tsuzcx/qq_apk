package com.tencent.mobileqq.newfriend.ui.activity;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class NewFriendActivity$UiHandler
  extends Handler
{
  private WeakReference<NewFriendActivity> a;
  
  public NewFriendActivity$UiHandler(NewFriendActivity paramNewFriendActivity)
  {
    this.a = new WeakReference(paramNewFriendActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (NewFriendActivity)this.a.get();
    if (localObject == null) {
      return;
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i == 2)
      {
        ((NewFriendActivity)localObject).finish();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Unknown message: ");
      ((StringBuilder)localObject).append(paramMessage.what);
      throw new RuntimeException(((StringBuilder)localObject).toString());
    }
    ((NewFriendActivity)localObject).b(paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.activity.NewFriendActivity.UiHandler
 * JD-Core Version:    0.7.0.1
 */