package com.tencent.mobileqq.teamworkforgroup;

import bala;
import com.tencent.biz.widgets.ElasticHorScrView;

public class ShareUtils$2
  implements Runnable
{
  public ShareUtils$2(bala parambala, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (bala.a(this.this$0).getWidth() < this.a) {
      bala.a(this.this$0).setMove(true);
    }
    while (bala.b(this.this$0).getWidth() < this.b)
    {
      bala.b(this.this$0).setMove(true);
      return;
      bala.a(this.this$0).setMove(false);
    }
    bala.b(this.this$0).setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils.2
 * JD-Core Version:    0.7.0.1
 */