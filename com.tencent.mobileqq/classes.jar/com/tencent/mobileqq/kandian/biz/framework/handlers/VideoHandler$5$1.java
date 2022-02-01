package com.tencent.mobileqq.kandian.biz.framework.handlers;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.video.viewholder.ViewHolder.VideoUIHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

class VideoHandler$5$1
  implements Runnable
{
  VideoHandler$5$1(VideoHandler.5 param5, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scroll ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" to top");
      QLog.d("VideoHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = VideoHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler$5.this$0).getChildAt(this.jdField_a_of_type_Int - VideoHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler$5.this$0).getFirstVisiblePosition());
    if (localObject != null)
    {
      VideoHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler$5.this$0).removeMessages(1001);
      VideoHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler$5.this$0).smoothScrollBy(((View)localObject).getBottom() - AIOUtils.b(175.0F, VideoHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler$5.this$0).getResources()), 800);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersVideoHandler$5.this$0.a().c(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler.5.1
 * JD-Core Version:    0.7.0.1
 */