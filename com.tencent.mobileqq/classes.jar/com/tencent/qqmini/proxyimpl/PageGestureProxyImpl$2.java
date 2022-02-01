package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.colornote.OnColorNoteCurdListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.launch.MiniSdkLauncher;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;

class PageGestureProxyImpl$2
  extends OnColorNoteCurdListener
{
  PageGestureProxyImpl$2(PageGestureProxyImpl paramPageGestureProxyImpl, Activity paramActivity) {}
  
  public void onAddColorNote(Bundle paramBundle, boolean paramBoolean)
  {
    super.onAddColorNote(paramBundle, paramBoolean);
    paramBundle = this.jdField_a_of_type_AndroidAppActivity;
    if (paramBundle != null) {
      paramBundle.moveTaskToBack(true);
    }
  }
  
  public void onDeleteColorNote(int paramInt, String paramString, boolean paramBoolean)
  {
    super.onDeleteColorNote(paramInt, paramString, paramBoolean);
    if (PageGestureProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplPageGestureProxyImpl) != null) {
      paramString = new MiniAppConfig(MiniSdkLauncher.convert(PageGestureProxyImpl.a(this.jdField_a_of_type_ComTencentQqminiProxyimplPageGestureProxyImpl)));
    } else {
      paramString = null;
    }
    if ((paramInt & 0x80000000) != 0)
    {
      if (paramString != null)
      {
        MiniProgramLpReportDC04239.reportAsync(paramString, "addRecentColorSign", "recentColorSign_enter", "remove_ColorSign", null);
        return;
      }
      MiniProgramLpReportDC04239.reportAsync("addRecentColorSign", "recentColorSign_enter", "remove_ColorSign", null);
      return;
    }
    if (paramString != null)
    {
      MiniProgramLpReportDC04239.reportAsync(paramString, "addColorSign", "colorSign_enter", "remove_ColorSign", null);
      return;
    }
    MiniProgramLpReportDC04239.reportAsync("addColorSign", "colorSign_enter", "remove_ColorSign", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.PageGestureProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */