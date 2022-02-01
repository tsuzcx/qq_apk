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
    if ((WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController) == null) || (WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController) == null)) {
      return false;
    }
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "click button too frequently pastTime=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
      }
      return true;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramInt1 = WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).a();
    if (paramInt1 == 1)
    {
      TogetherUtils.a(this.jdField_a_of_type_AndroidContentContext, 1, WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).getBigUrl(), null, new Bundle(), WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).getCurType());
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController.a(WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).getCurUin(), WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).getCurType(), false);
    }
    for (;;)
    {
      return true;
      if (paramInt1 == 2)
      {
        WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).a(WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).getSmallUrl());
        ReportController.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh", 0, 0, WatchFloatingWindowController.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchFloatingWindowController).getCurUin(), "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchFloatingWindowController.2
 * JD-Core Version:    0.7.0.1
 */