package com.tencent.mobileqq.profilecard.vas.component.header;

import android.os.Message;
import com.tencent.mobileqq.data.Card;
import com.tencent.util.WeakReferenceHandler;

class AbsVasProfileHeaderComponent$4$1
  implements Runnable
{
  AbsVasProfileHeaderComponent$4$1(AbsVasProfileHeaderComponent.4 param4, Card paramCard) {}
  
  public void run()
  {
    if (AbsVasProfileHeaderComponent.access$900(this.this$1.this$0) == null) {
      return;
    }
    boolean bool = AbsVasProfileHeaderComponent.access$1000(this.this$1.this$0, (int)this.val$card.lCurrentStyleId, (int)this.val$card.lCurrentBgId, this.val$card.backgroundUrl, (int)this.val$card.backgroundColor, this.val$card.templateRet, this.val$card.diyComplicatedInfo, this.val$card.cardId);
    Message localMessage = AbsVasProfileHeaderComponent.access$1100(this.this$1.this$0).obtainMessage(13, Boolean.valueOf(bool));
    AbsVasProfileHeaderComponent.access$1200(this.this$1.this$0).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.4.1
 * JD-Core Version:    0.7.0.1
 */