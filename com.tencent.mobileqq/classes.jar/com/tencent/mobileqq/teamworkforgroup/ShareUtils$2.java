package com.tencent.mobileqq.teamworkforgroup;

import beez;
import com.tencent.biz.widgets.ElasticHorScrView;

public class ShareUtils$2
  implements Runnable
{
  public ShareUtils$2(beez parambeez, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (beez.a(this.this$0).getWidth() < this.a) {
      beez.a(this.this$0).setMove(true);
    }
    while (beez.b(this.this$0).getWidth() < this.b)
    {
      beez.b(this.this$0).setMove(true);
      return;
      beez.a(this.this$0).setMove(false);
    }
    beez.b(this.this$0).setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils.2
 * JD-Core Version:    0.7.0.1
 */