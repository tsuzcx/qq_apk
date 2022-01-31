package com.tencent.mobileqq.utils;

import bahv;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.qphone.base.util.QLog;

public class ShareActionSheetBuilder$2
  implements Runnable
{
  public ShareActionSheetBuilder$2(bahv parambahv) {}
  
  public void run()
  {
    int i = this.this$0.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.getWidth();
    StringBuilder localStringBuilder;
    if (i < this.this$0.jdField_a_of_type_Int)
    {
      this.this$0.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("setMove, scrollView1Length = ").append(i).append("; mGridView1Length = ").append(this.this$0.jdField_a_of_type_Int).append("; move = ");
        if (i >= this.this$0.jdField_a_of_type_Int) {
          break label149;
        }
      }
    }
    label149:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ShareActionSheetBuilder", 2, bool);
      if (this.this$0.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.getWidth() >= this.this$0.jdField_b_of_type_Int) {
        break label154;
      }
      this.this$0.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      return;
      this.this$0.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
      break;
    }
    label154:
    this.this$0.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder.2
 * JD-Core Version:    0.7.0.1
 */