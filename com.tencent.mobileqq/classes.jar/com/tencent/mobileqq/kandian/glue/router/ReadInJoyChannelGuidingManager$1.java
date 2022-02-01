package com.tencent.mobileqq.kandian.glue.router;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.qphone.base.util.QLog;

final class ReadInJoyChannelGuidingManager$1
  implements Runnable
{
  ReadInJoyChannelGuidingManager$1(ReadInJoyXListView paramReadInJoyXListView, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView;
    localObject = ((ReadInJoyXListView)localObject).getChildAt(((ReadInJoyXListView)localObject).getHeaderViewsCount());
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.performItemClick((View)localObject, 0, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter.getItemId(0));
      return;
    }
    QLog.i("ReadInJoyChannelGuidingManager", 1, "[openFirstInsertedArticle] view is null, open failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.router.ReadInJoyChannelGuidingManager.1
 * JD-Core Version:    0.7.0.1
 */