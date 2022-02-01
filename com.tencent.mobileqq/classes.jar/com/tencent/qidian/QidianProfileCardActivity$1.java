package com.tencent.qidian;

import com.tencent.mobileqq.profilecard.utils.ProfileNameUtils;

class QidianProfileCardActivity$1
  implements Runnable
{
  QidianProfileCardActivity$1(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void run()
  {
    ProfileNameUtils.initNameArray(this.this$0.app, this.this$0.e);
    ProfileNameUtils.updateProfileName(this.this$0.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.1
 * JD-Core Version:    0.7.0.1
 */