package com.tencent.mobileqq.filemanager.fileviewer.sendbar;

import android.content.Intent;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

class PrinterSendBarManager$1$1
  implements FMDialogUtil.FMDialogInterface
{
  PrinterSendBarManager$1$1(PrinterSendBarManager.1 param1) {}
  
  public void a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getLocalFiles());
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
    PrinterSendBarManager.a(this.a.a, localIntent);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.sendbar.PrinterSendBarManager.1.1
 * JD-Core Version:    0.7.0.1
 */