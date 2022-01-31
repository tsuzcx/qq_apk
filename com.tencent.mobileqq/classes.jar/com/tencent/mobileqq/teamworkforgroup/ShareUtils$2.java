package com.tencent.mobileqq.teamworkforgroup;

import ayit;
import com.tencent.biz.widgets.ElasticHorScrView;

public class ShareUtils$2
  implements Runnable
{
  public ShareUtils$2(ayit paramayit, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (ayit.a(this.this$0).getWidth() < this.a) {
      ayit.a(this.this$0).setMove(true);
    }
    while (ayit.b(this.this$0).getWidth() < this.b)
    {
      ayit.b(this.this$0).setMove(true);
      return;
      ayit.a(this.this$0).setMove(false);
    }
    ayit.b(this.this$0).setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils.2
 * JD-Core Version:    0.7.0.1
 */