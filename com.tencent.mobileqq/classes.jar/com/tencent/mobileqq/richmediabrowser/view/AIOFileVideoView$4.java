package com.tencent.mobileqq.richmediabrowser.view;

import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class AIOFileVideoView$4
  implements Runnable
{
  AIOFileVideoView$4(AIOFileVideoView paramAIOFileVideoView, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
      this.this$0.w.add(this.this$0.w.size() - 1, localActionSheetItem);
    }
    this.this$0.b.setActionSheetItems(this.this$0.v, this.this$0.w);
    if (this.this$0.b.isShowing())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOFileVideoView<FileAssistant>XOXO", 2, "onVideoFrameCallBack, refresh share menu");
      }
      this.this$0.b.refresh();
      return;
    }
    this.this$0.b.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOFileVideoView.4
 * JD-Core Version:    0.7.0.1
 */