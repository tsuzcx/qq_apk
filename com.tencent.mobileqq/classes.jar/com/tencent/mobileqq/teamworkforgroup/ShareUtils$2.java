package com.tencent.mobileqq.teamworkforgroup;

import axip;
import com.tencent.biz.widgets.ElasticHorScrView;

public class ShareUtils$2
  implements Runnable
{
  public ShareUtils$2(axip paramaxip, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (axip.a(this.this$0).getWidth() < this.a) {
      axip.a(this.this$0).setMove(true);
    }
    while (axip.b(this.this$0).getWidth() < this.b)
    {
      axip.b(this.this$0).setMove(true);
      return;
      axip.a(this.this$0).setMove(false);
    }
    axip.b(this.this$0).setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils.2
 * JD-Core Version:    0.7.0.1
 */