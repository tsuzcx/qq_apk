package com.tencent.mobileqq.troop.data;

import bbpl;
import bbpw;
import java.util.List;

public class TroopAioKeywordTipManager$6
  implements Runnable
{
  public TroopAioKeywordTipManager$6(bbpw parambbpw, String paramString1, String paramString2, Integer paramInteger) {}
  
  public void run()
  {
    String str = bbpw.a(this.this$0, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_JavaLangInteger);
    synchronized (this.this$0.b)
    {
      if (!this.this$0.b.contains(str)) {
        this.this$0.b.add(str);
      }
      bbpl.a(this.this$0.a, str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipManager.6
 * JD-Core Version:    0.7.0.1
 */