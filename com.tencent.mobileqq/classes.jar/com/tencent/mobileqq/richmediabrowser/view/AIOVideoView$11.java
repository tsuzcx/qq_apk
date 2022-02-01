package com.tencent.mobileqq.richmediabrowser.view;

import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class AIOVideoView$11
  implements Runnable
{
  AIOVideoView$11(AIOVideoView paramAIOVideoView, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
      AIOVideoView.d(this.this$0).add(AIOVideoView.d(this.this$0).size() - 1, localActionSheetItem);
    }
    this.this$0.b.setActionSheetItems(AIOVideoView.e(this.this$0), AIOVideoView.d(this.this$0));
    if (this.this$0.b.isShowing())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 2, "onVideoFrameCallBack, refresh share menu");
      }
      this.this$0.b.refresh();
      return;
    }
    this.this$0.b.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.11
 * JD-Core Version:    0.7.0.1
 */