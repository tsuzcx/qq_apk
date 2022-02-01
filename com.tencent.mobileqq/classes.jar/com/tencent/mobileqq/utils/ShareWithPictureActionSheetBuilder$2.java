package com.tencent.mobileqq.utils;

import bfyx;
import com.tencent.biz.widgets.ElasticHorScrView;

public class ShareWithPictureActionSheetBuilder$2
  implements Runnable
{
  public ShareWithPictureActionSheetBuilder$2(bfyx parambfyx) {}
  
  public void run()
  {
    if (this.this$0.mScrollView1.getWidth() < this.this$0.mGridView1Length) {
      this.this$0.mScrollView1.setMove(true);
    }
    while (this.this$0.mScrollView2.getWidth() < this.this$0.mGridView2Length)
    {
      this.this$0.mScrollView2.setMove(true);
      return;
      this.this$0.mScrollView1.setMove(false);
    }
    this.this$0.mScrollView2.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareWithPictureActionSheetBuilder.2
 * JD-Core Version:    0.7.0.1
 */