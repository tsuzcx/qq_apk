package com.tencent.mobileqq.richmediabrowser.view;

import ayao;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import java.util.ArrayList;
import java.util.Iterator;

public class AIOVideoView$10
  implements Runnable
{
  public AIOVideoView$10(ayao paramayao, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localIterator.next();
      ayao.a(this.this$0).add(ayao.a(this.this$0).size() - 1, localActionSheetItem);
    }
    this.this$0.a.setActionSheetItems(ayao.b(this.this$0), ayao.a(this.this$0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.view.AIOVideoView.10
 * JD-Core Version:    0.7.0.1
 */