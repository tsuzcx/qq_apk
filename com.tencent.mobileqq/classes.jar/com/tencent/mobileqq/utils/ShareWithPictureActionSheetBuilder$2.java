package com.tencent.mobileqq.utils;

import com.tencent.biz.widgets.ElasticHorScrView;

class ShareWithPictureActionSheetBuilder$2
  implements Runnable
{
  ShareWithPictureActionSheetBuilder$2(ShareWithPictureActionSheetBuilder paramShareWithPictureActionSheetBuilder) {}
  
  public void run()
  {
    if (this.this$0.e.getWidth() < this.this$0.j) {
      this.this$0.e.setMove(true);
    } else {
      this.this$0.e.setMove(false);
    }
    if (this.this$0.f.getWidth() < this.this$0.k)
    {
      this.this$0.f.setMove(true);
      return;
    }
    this.this$0.f.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ShareWithPictureActionSheetBuilder.2
 * JD-Core Version:    0.7.0.1
 */