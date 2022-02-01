package com.tencent.mobileqq.intervideo.now.dynamic;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.bigbrother.JumpCallback;
import com.tencent.qphone.base.util.BaseApplication;

final class DynamicNowManager$11
  implements JumpCallback
{
  public void onJump(int paramInt1, int paramInt2)
  {
    if (paramInt1 == DynamicNowManager.a)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("action.now.jump");
      localIntent.putExtra("jump_action", paramInt2);
      BaseApplicationImpl.getContext().sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.11
 * JD-Core Version:    0.7.0.1
 */