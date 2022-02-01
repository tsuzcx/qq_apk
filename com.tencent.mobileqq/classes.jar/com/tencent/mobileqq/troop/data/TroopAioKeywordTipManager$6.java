package com.tencent.mobileqq.troop.data;

import java.util.List;

class TroopAioKeywordTipManager$6
  implements Runnable
{
  TroopAioKeywordTipManager$6(TroopAioKeywordTipManager paramTroopAioKeywordTipManager, String paramString1, String paramString2, Integer paramInteger) {}
  
  public void run()
  {
    String str = TroopAioKeywordTipManager.a(this.this$0, this.a, this.b, this.c);
    synchronized (this.this$0.f)
    {
      if (!this.this$0.f.contains(str)) {
        this.this$0.f.add(str);
      }
      TroopAioKeywordHelper.b(this.this$0.a, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.6
 * JD-Core Version:    0.7.0.1
 */