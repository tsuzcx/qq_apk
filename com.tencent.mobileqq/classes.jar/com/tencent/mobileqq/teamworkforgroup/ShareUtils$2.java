package com.tencent.mobileqq.teamworkforgroup;

import com.tencent.biz.widgets.ElasticHorScrView;

class ShareUtils$2
  implements Runnable
{
  ShareUtils$2(ShareUtils paramShareUtils, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (ShareUtils.a(this.this$0).getWidth() < this.a) {
      ShareUtils.a(this.this$0).setMove(true);
    } else {
      ShareUtils.a(this.this$0).setMove(false);
    }
    if (ShareUtils.b(this.this$0).getWidth() < this.b)
    {
      ShareUtils.b(this.this$0).setMove(true);
      return;
    }
    ShareUtils.b(this.this$0).setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils.2
 * JD-Core Version:    0.7.0.1
 */