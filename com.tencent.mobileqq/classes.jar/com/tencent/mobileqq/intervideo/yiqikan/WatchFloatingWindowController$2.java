package com.tencent.mobileqq.intervideo.yiqikan;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qqfloatingwindow.listener.IWindowClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.together.TogetherUtils;
import com.tencent.qphone.base.util.QLog;

class WatchFloatingWindowController$2
  implements IWindowClickListener
{
  private long jdField_a_of_type_Long = 0L;
  
  WatchFloatingWindowController$2(WatchFloatingWindowController paramWatchFloatingWindowController, Context paramContext) {}
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "onCloseClick");
    }
    if (WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController) == null) {
      return true;
    }
    if (WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).isIsAdm())
    {
      TogetherWatchFloatingUtil.a(this.jdField_a_of_type_AndroidContentContext, 5, WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).getCurUin());
      return true;
    }
    ReportController.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_quit_member", 0, 0, WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).getCurUin(), "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController.b();
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    if (WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController) != null)
    {
      if (WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController) == null) {
        return false;
      }
      Object localObject;
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("click button too frequently pastTime=");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
          QLog.d("WatchFloatingWindowController", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramInt1 = WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).a();
      if (paramInt1 == 1)
      {
        TogetherUtils.a(this.jdField_a_of_type_AndroidContentContext, 1, WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).getBigUrl(), null, new Bundle(), WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).getCurType());
        localObject = this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController;
        ((WatchFloatingWindowController)localObject).a(WatchFloatingWindowController.a((WatchFloatingWindowController)localObject).getCurUin(), WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).getCurType(), false);
        return true;
      }
      if (paramInt1 == 2)
      {
        WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).a(WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).getSmallUrl());
        ReportController.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh", 0, 0, WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).getCurUin(), "", "", "");
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchFloatingWindowController.2
 * JD-Core Version:    0.7.0.1
 */