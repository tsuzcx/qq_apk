package com.tencent.qidian;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;

class QidianProfileCardActivity$20
  extends ProfileCardObserver
{
  QidianProfileCardActivity$20(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  public void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    this.a.a();
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Card)))
    {
      this.a.a.a = ((Card)paramObject);
      if (QidianProfileCardActivity.b(this.a)) {
        this.a.a(this.a.a.a.vQzoneCoverInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.20
 * JD-Core Version:    0.7.0.1
 */