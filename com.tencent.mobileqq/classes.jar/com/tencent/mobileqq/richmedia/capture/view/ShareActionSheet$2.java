package com.tencent.mobileqq.richmedia.capture.view;

import axsj;
import com.tencent.biz.widgets.ElasticHorScrView;

public class ShareActionSheet$2
  implements Runnable
{
  public ShareActionSheet$2(axsj paramaxsj) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.getWidth() < this.this$0.jdField_a_of_type_Int) {
      this.this$0.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
    }
    while (this.this$0.b.getWidth() < axsj.a(this.this$0))
    {
      this.this$0.b.setMove(true);
      return;
      this.this$0.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
    }
    this.this$0.b.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.ShareActionSheet.2
 * JD-Core Version:    0.7.0.1
 */