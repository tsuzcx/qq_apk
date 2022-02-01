package com.tencent.mobileqq.utils;

import bgse;
import com.tencent.biz.widgets.ElasticHorScrView;

public class ShareWithPictureActionSheetBuilder$2
  implements Runnable
{
  public ShareWithPictureActionSheetBuilder$2(bgse parambgse) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.getWidth() < this.this$0.jdField_a_of_type_Int) {
      this.this$0.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
    }
    while (this.this$0.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.getWidth() < this.this$0.jdField_b_of_type_Int)
    {
      this.this$0.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      return;
      this.this$0.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
    }
    this.this$0.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareWithPictureActionSheetBuilder.2
 * JD-Core Version:    0.7.0.1
 */