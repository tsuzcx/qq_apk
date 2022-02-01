package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class BaseMsgBoxActivity$1
  extends AvatarObserver
{
  BaseMsgBoxActivity$1(BaseMsgBoxActivity paramBaseMsgBoxActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (!this.a.mInitUI) {
      return;
    }
    this.a.runOnUiThread(new BaseMsgBoxActivity.1.1(this, paramBoolean, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dating.BaseMsgBoxActivity.1
 * JD-Core Version:    0.7.0.1
 */