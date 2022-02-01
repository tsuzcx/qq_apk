package com.tencent.mobileqq.profilecard.vas.component.header;

import android.util.Pair;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.util.WeakReferenceHandler;

class AbsVasProfileHeaderComponent$4
  extends CardObserver
{
  AbsVasProfileHeaderComponent$4(AbsVasProfileHeaderComponent paramAbsVasProfileHeaderComponent) {}
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    try
    {
      if (!AbsVasProfileHeaderComponent.access$600(this.this$0).isFinishing())
      {
        AbsVasProfileHeaderComponent.access$800(this.this$0).removeCallbacks(AbsVasProfileHeaderComponent.access$700(this.this$0));
        AbsVasProfileHeaderComponent.access$000(this.this$0);
        if ((paramBoolean) && (paramObject != null))
        {
          if ((paramObject instanceof Card))
          {
            ThreadManager.post(new AbsVasProfileHeaderComponent.4.1(this, (Card)paramObject), 5, null, true);
            return;
          }
          if ((paramObject instanceof Pair))
          {
            if (AbsVasProfileHeaderComponent.access$1300(this.this$0, (Pair)paramObject)) {
              return;
            }
            AbsVasProfileHeaderComponent.access$1400(this.this$0);
          }
        }
      }
      return;
    }
    catch (Exception paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.4
 * JD-Core Version:    0.7.0.1
 */