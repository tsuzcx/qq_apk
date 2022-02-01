package com.tencent.mobileqq.troop.activity;

import axno;
import axny;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
      int j = ((axny)this.this$0.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).b();
      if ((this.this$0.b <= 0) || (((MediaPreviewInfo)this.this$0.a.get(0)).a != 2)) {
        break label109;
      }
      i = 1;
      if (j != 0) {
        break label114;
      }
      str1 = "1";
      label70:
      if (i == 0) {
        break label120;
      }
    }
    label109:
    label114:
    label120:
    for (String str2 = "2";; str2 = "1")
    {
      axno.a("clk_detail", "", new String[] { "", str1, "", str2 });
      return;
      i = 0;
      break;
      str1 = "2";
      break label70;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.MediaPreviewActivity.4
 * JD-Core Version:    0.7.0.1
 */