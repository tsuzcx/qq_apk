package com.tencent.qidian;

import com.tencent.mobileqq.profilecard.utils.ProfileNameUtils;

class QidianProfileCardActivity$1
  implements Runnable
{
  QidianProfileCardActivity$1(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void run()
  {
    ProfileNameUtils.initNameArray(this.this$0.app, this.this$0.a);
    ProfileNameUtils.updateProfileName(this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.1
 * JD-Core Version:    0.7.0.1
 */