package com.tencent.mobileqq.kandian.biz.share;

import com.tencent.biz.widgets.ElasticHorScrView;

class TopicShareHelper$4
  implements Runnable
{
  TopicShareHelper$4(TopicShareHelper paramTopicShareHelper, ElasticHorScrView paramElasticHorScrView1, int paramInt1, ElasticHorScrView paramElasticHorScrView2, int paramInt2) {}
  
  public void run()
  {
    if (this.a.getWidth() < this.b) {
      this.a.setMove(true);
    } else {
      this.a.setMove(false);
    }
    if (this.c.getWidth() < this.d)
    {
      this.c.setMove(true);
      return;
    }
    this.c.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.TopicShareHelper.4
 * JD-Core Version:    0.7.0.1
 */