package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView.OnDragListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ReadInJoyDeliverUGCActivity$4
  implements ReadInJoyNinePicDeliverDynamicGridView.OnDragListener
{
  ReadInJoyDeliverUGCActivity$4(ReadInJoyDeliverUGCActivity paramReadInJoyDeliverUGCActivity) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDeliverUGCActivity", 2, "startDrag!");
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (ReadInJoyDeliverUGCActivity.d(this.a) != 0)
    {
      Object localObject = (Integer)ReadInJoyDeliverUGCActivity.e(this.a).remove(paramInt1);
      ReadInJoyDeliverUGCActivity.e(this.a).add(paramInt2, localObject);
      PublicAccountReportUtils.a(null, "", "0X800953F", "0X800953F", 0, 0, "", "", "", RIJTransMergeKanDianReport.e(), false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("change position old position=");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(" new position");
        ((StringBuilder)localObject).append(paramInt2);
        QLog.d("ReadInJoyDeliverUGCActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity.4
 * JD-Core Version:    0.7.0.1
 */