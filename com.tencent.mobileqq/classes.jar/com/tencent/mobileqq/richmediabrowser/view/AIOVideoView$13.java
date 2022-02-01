package com.tencent.mobileqq.richmediabrowser.view;

import bbrz;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import java.util.ArrayList;
import java.util.Iterator;

public class AIOVideoView$13
  implements Runnable
{
  public AIOVideoView$13(bbrz parambbrz, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
      bbrz.a(this.this$0).add(bbrz.a(this.this$0).size() - 1, localActionSheetItem);
    }
    this.this$0.a.setActionSheetItems(bbrz.b(this.this$0), bbrz.a(this.this$0));
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