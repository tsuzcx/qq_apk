package com.tencent.mobileqq.troop.activity;

import asyu;
import aszd;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

class MediaPreviewActivity$4
  implements Runnable
{
  MediaPreviewActivity$4(MediaPreviewActivity paramMediaPreviewActivity) {}
  
  public void run()
  {
    int i;
    String str1;
    if (this.this$0.app != null)
    {
      int j = ((aszd)this.this$0.app.getManager(106)).b();
      if ((this.this$0.b <= 0) || (((MediaPreviewInfo)this.this$0.a.get(0)).a != 2)) {
        break label108;
      }
      i = 1;
      if (j != 0) {
        break label113;
      }
      str1 = "1";
      label69:
      if (i == 0) {
        break label119;
      }
    }
    label108:
    label113:
    label119:
    for (String str2 = "2";; str2 = "1")
    {
      asyu.a("clk_detail", "", new String[] { "", str1, "", str2 });
      return;
      i = 0;
      break;
      str1 = "2";
      break label69;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */