package com.tencent.mobileqq.troop.data;

import java.util.List;

class TroopAioKeywordTipManager$6
  implements Runnable
{
  TroopAioKeywordTipManager$6(TroopAioKeywordTipManager paramTroopAioKeywordTipManager, String paramString1, String paramString2, Integer paramInteger) {}
  
  public void run()
  {
    String str = TroopAioKeywordTipManager.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_JavaLangInteger);
    synchronized (this.this$0.b)
    {
      if (!this.this$0.b.contains(str)) {
        this.this$0.b.add(str);
      }
      TroopAioKeywordHelper.a(this.this$0.a, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.6
 * JD-Core Version:    0.7.0.1
 */