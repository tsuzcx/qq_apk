package com.tencent.mobileqq.teamworkforgroup;

import befp;
import com.tencent.biz.widgets.ElasticHorScrView;

public class ShareUtils$2
  implements Runnable
{
  public ShareUtils$2(befp parambefp, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (befp.a(this.this$0).getWidth() < this.a) {
      befp.a(this.this$0).setMove(true);
    }
    while (befp.b(this.this$0).getWidth() < this.b)
    {
      befp.b(this.this$0).setMove(true);
      return;
      befp.a(this.this$0).setMove(false);
    }
    befp.b(this.this$0).setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils.2
 * JD-Core Version:    0.7.0.1
 */