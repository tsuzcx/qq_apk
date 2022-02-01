package com.tencent.mobileqq.filemanager.fileviewer.sendbar;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
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
    if (PrinterSendBarManager.a(this.a)) {
      if ((FileManagerUtil.b()) && (((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getSelectedLocalFileSize() > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize()))
      {
        FMDialogUtil.a(SplashActivity.sTopActivity, 2131889584, 2131889589, new PrinterSendBarManager.1.1(this));
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.addAll(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getLocalFiles());
        Intent localIntent = new Intent();
        localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
        PrinterSendBarManager.b(this.a, localIntent);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.sendbar.PrinterSendBarManager.1
 * JD-Core Version:    0.7.0.1
 */