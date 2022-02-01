package com.tencent.mobileqq.filemanager.fileviewer.sendbar;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class PrinterSendBarManager$1
  implements View.OnClickListener
{
  PrinterSendBarManager$1(PrinterSendBarManager paramPrinterSendBarManager) {}
  
  public void onClick(View paramView)
  {
    if (!PrinterSendBarManager.a(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((FileManagerUtil.a()) && (FMDataCache.c() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
      {
        FMDialogUtil.a(SplashActivity.sTopActivity, 2131692609, 2131692614, new PrinterSendBarManager.1.1(this));
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(FMDataCache.a());
        Intent localIntent = new Intent();
        localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
        PrinterSendBarManager.b(this.a, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.sendbar.PrinterSendBarManager.1
 * JD-Core Version:    0.7.0.1
 */