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
  private long c = 0L;
  
  WatchFloatingWindowController$2(WatchFloatingWindowController paramWatchFloatingWindowController, Context paramContext) {}
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "onCloseClick");
    }
    if (WatchFloatingWindowController.b(this.b) == null) {
      return true;
    }
    if (WatchFloatingWindowController.b(this.b).isIsAdm())
    {
      TogetherWatchFloatingUtil.a(this.a, 5, WatchFloatingWindowController.b(this.b).getCurUin());
      return true;
    }
    ReportController.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_quit_member", 0, 0, WatchFloatingWindowController.b(this.b).getCurUin(), "", "", "");
    this.b.b();
    return true;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, new Object[] { "onEnterClick: invoked. ", " centerX: ", Integer.valueOf(paramInt1), " centerY: ", Integer.valueOf(paramInt2) });
    }
    if (WatchFloatingWindowController.b(this.b) != null)
    {
      if (WatchFloatingWindowController.c(this.b) == null) {
        return false;
      }
      Object localObject;
      if (System.currentTimeMillis() - this.c < 1000L)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("click button too frequently pastTime=");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - this.c);
          QLog.d("WatchFloatingWindowController", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      this.c = System.currentTimeMillis();
      paramInt1 = WatchFloatingWindowController.c(this.b).getLoadingState();
      if (paramInt1 == 1)
      {
        TogetherUtils.a(this.a, 1, WatchFloatingWindowController.b(this.b).getBigUrl(), null, new Bundle(), WatchFloatingWindowController.b(this.b).getCurType());
        localObject = this.b;
        ((WatchFloatingWindowController)localObject).a(WatchFloatingWindowController.b((WatchFloatingWindowController)localObject).getCurUin(), WatchFloatingWindowController.b(this.b).getCurType(), false);
        return true;
      }
      if (paramInt1 == 2)
      {
        WatchFloatingWindowController.c(this.b).a(WatchFloatingWindowController.b(this.b).getSmallUrl());
        ReportController.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh", 0, 0, WatchFloatingWindowController.b(this.b).getCurUin(), "", "", "");
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchFloatingWindowController.2
 * JD-Core Version:    0.7.0.1
 */