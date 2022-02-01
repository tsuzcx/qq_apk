package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.ScanParams;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class QfileLocalFileAppTabView$2
  implements Runnable
{
  QfileLocalFileAppTabView$2(QfileLocalFileAppTabView paramQfileLocalFileAppTabView) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (this.this$0.n)
    {
      FileCategoryUtil.a(this.this$0.C, this.this$0);
      FileCategoryUtil.a(true, AppConstants.SDCARD_FILE_SAVE_PATH, ".apk", "", localHashMap, this.this$0);
    }
    else
    {
      Iterator localIterator = this.this$0.m.iterator();
      while (localIterator.hasNext()) {
        FileCategoryUtil.a(true, ((QfileTabBarView.ScanParams)localIterator.next()).a(), ".apk", "", localHashMap, this.this$0);
      }
    }
    FileCategoryUtil.a(localHashMap);
    QfileLocalFileAppTabView.a(this.this$0, new QfileLocalFileAppTabView.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView.2
 * JD-Core Version:    0.7.0.1
 */