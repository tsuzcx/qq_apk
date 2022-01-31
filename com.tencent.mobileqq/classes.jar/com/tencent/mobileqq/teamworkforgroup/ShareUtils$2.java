package com.tencent.mobileqq.teamworkforgroup;

import bagr;
import com.tencent.biz.widgets.ElasticHorScrView;

public class ShareUtils$2
  implements Runnable
{
  public ShareUtils$2(bagr parambagr, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (bagr.a(this.this$0).getWidth() < this.a) {
      bagr.a(this.this$0).setMove(true);
    }
    while (bagr.b(this.this$0).getWidth() < this.b)
    {
      bagr.b(this.this$0).setMove(true);
      return;
      bagr.a(this.this$0).setMove(false);
    }
    bagr.b(this.this$0).setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils.2
 * JD-Core Version:    0.7.0.1
 */