package com.tencent.mobileqq.richmediabrowser.view;

import bakr;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class AIOFileVideoView$6
  implements Runnable
{
  public AIOFileVideoView$6(bakr parambakr, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
      this.this$0.c.add(this.this$0.c.size() - 1, localActionSheetItem);
    }
    this.this$0.a.setActionSheetItems(this.this$0.b, this.this$0.c);
    if (this.this$0.a.isShowing())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onVideoFrameCallBack, refresh share menu");
      }
      this.this$0.a.refresh();
      return;
    }
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.6
 * JD-Core Version:    0.7.0.1
 */