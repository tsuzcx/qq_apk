package com.tencent.mobileqq.teamworkforgroup;

import bcyq;
import com.tencent.biz.widgets.ElasticHorScrView;

public class ShareUtils$2
  implements Runnable
{
  public ShareUtils$2(bcyq parambcyq, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (bcyq.a(this.this$0).getWidth() < this.a) {
      bcyq.a(this.this$0).setMove(true);
    }
    while (bcyq.b(this.this$0).getWidth() < this.b)
    {
      bcyq.b(this.this$0).setMove(true);
      return;
      bcyq.a(this.this$0).setMove(false);
    }
    bcyq.b(this.this$0).setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils.2
 * JD-Core Version:    0.7.0.1
 */