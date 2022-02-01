package com.tencent.mobileqq.richmediabrowser.view;

import bbrp;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import java.util.ArrayList;
import java.util.Iterator;

public class AIOVideoView$13
  implements Runnable
{
  public AIOVideoView$13(bbrp parambbrp, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
      bbrp.a(this.this$0).add(bbrp.a(this.this$0).size() - 1, localActionSheetItem);
    }
    this.this$0.a.setActionSheetItems(bbrp.b(this.this$0), bbrp.a(this.this$0));
    if (this.this$0.a.isShowing())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AIOVideoView", 0, "onVideoFrameCallBack, refresh share menu");
      }
      this.this$0.a.refresh();
      return;
    }
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.13
 * JD-Core Version:    0.7.0.1
 */