package com.tencent.mobileqq.mini.entry.desktop;

import android.util.Log;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.qphone.base.util.QLog;

class MiniAppDesktopAdapter$6
  implements View.OnAttachStateChangeListener
{
  MiniAppDesktopAdapter$6(MiniAppDesktopAdapter paramMiniAppDesktopAdapter, MiniAppInfo paramMiniAppInfo, int paramInt) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    try
    {
      ((DesktopDataManager)MiniAppUtils.getAppInterface().getManager(336)).checkMiniAppAdReport(this.val$miniAppInfo, this.val$position);
      return;
    }
    catch (Exception paramView)
    {
      QLog.e("MiniAppDesktopAdapter", 1, "collectAdReport, exception: " + Log.getStackTraceString(paramView));
    }
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.MiniAppDesktopAdapter.6
 * JD-Core Version:    0.7.0.1
 */