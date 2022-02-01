package com.tencent.mobileqq.kandian.biz.share;

import com.tencent.biz.widgets.ElasticHorScrView;

class TopicShareHelper$4
  implements Runnable
{
  TopicShareHelper$4(TopicShareHelper paramTopicShareHelper, ElasticHorScrView paramElasticHorScrView1, int paramInt1, ElasticHorScrView paramElasticHorScrView2, int paramInt2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.getWidth() < this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
    } else {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
    }
    if (this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.getWidth() < this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      return;
    }
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.TopicShareHelper.4
 * JD-Core Version:    0.7.0.1
 */