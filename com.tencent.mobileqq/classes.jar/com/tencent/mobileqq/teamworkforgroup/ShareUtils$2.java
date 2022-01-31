package com.tencent.mobileqq.teamworkforgroup;

import ayiv;
import com.tencent.biz.widgets.ElasticHorScrView;

public class ShareUtils$2
  implements Runnable
{
  public ShareUtils$2(ayiv paramayiv, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (ayiv.a(this.this$0).getWidth() < this.a) {
      ayiv.a(this.this$0).setMove(true);
    }
    while (ayiv.b(this.this$0).getWidth() < this.b)
    {
      ayiv.b(this.this$0).setMove(true);
      return;
      ayiv.a(this.this$0).setMove(false);
    }
    ayiv.b(this.this$0).setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils.2
 * JD-Core Version:    0.7.0.1
 */