package com.tencent.mobileqq.profilecard.vas.component.header;

import SummaryCardTaf.SSummaryCardRsp;
import android.util.Pair;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
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
            paramObject = (Pair)paramObject;
            if (((Integer)paramObject.first).intValue() == 101107) {
              AbsVasProfileHeaderComponent.access$102(this.this$0, 1);
            }
            for (;;)
            {
              AbsVasProfileHeaderComponent.access$1400(this.this$0);
              return;
              if (((Integer)paramObject.first).intValue() == 101108)
              {
                AbsVasProfileHeaderComponent.access$102(this.this$0, 2);
              }
              else if (((Integer)paramObject.first).intValue() == 101111)
              {
                AbsVasProfileHeaderComponent.access$102(this.this$0, 3);
              }
              else
              {
                if (((Integer)paramObject.first).intValue() != 12002) {
                  break;
                }
                AbsVasProfileHeaderComponent.access$102(this.this$0, 4);
              }
            }
            AbsVasProfileHeaderComponent.access$102(this.this$0, 5);
            AbsVasProfileHeaderComponent.access$1300(this.this$0, (SSummaryCardRsp)paramObject.second);
          }
        }
      }
      return;
    }
    catch (Exception paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.header.AbsVasProfileHeaderComponent.4
 * JD-Core Version:    0.7.0.1
 */