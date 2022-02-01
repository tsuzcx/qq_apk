package com.tencent.mobileqq.teamworkforgroup;

import bdme;
import com.tencent.biz.widgets.ElasticHorScrView;

public class ShareUtils$2
  implements Runnable
{
  public ShareUtils$2(bdme parambdme, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (bdme.a(this.this$0).getWidth() < this.a) {
      bdme.a(this.this$0).setMove(true);
    }
    while (bdme.b(this.this$0).getWidth() < this.b)
    {
      bdme.b(this.this$0).setMove(true);
      return;
      bdme.a(this.this$0).setMove(false);
    }
    bdme.b(this.this$0).setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils.2
 * JD-Core Version:    0.7.0.1
 */