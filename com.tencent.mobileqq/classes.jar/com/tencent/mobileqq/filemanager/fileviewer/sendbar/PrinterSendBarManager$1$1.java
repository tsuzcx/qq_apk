package com.tencent.mobileqq.filemanager.fileviewer.sendbar;

import android.content.Intent;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import java.util.ArrayList;

class PrinterSendBarManager$1$1
  implements FMDialogUtil.FMDialogInterface
{
  PrinterSendBarManager$1$1(PrinterSendBarManager.1 param1) {}
  
  public void a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(FMDataCache.a());
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("sFilesSelected", localArrayList);
    PrinterSendBarManager.a(this.a.a, localIntent);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.sendbar.PrinterSendBarManager.1.1
 * JD-Core Version:    0.7.0.1
 */