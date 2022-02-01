package com.tencent.qidian;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;

class QidianProfileCardActivity$20
  extends ProfileCardObserver
{
  QidianProfileCardActivity$20(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    this.a.a();
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Card)))
    {
      this.a.a.card = ((Card)paramObject);
      if (QidianProfileCardActivity.b(this.a))
      {
        paramObject = this.a;
        paramObject.a(paramObject.a.card.vQzoneCoverInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.20
 * JD-Core Version:    0.7.0.1
 */