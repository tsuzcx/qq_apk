package com.tencent.qidian;

import com.tencent.image.URLImageView;
import com.tencent.qidian.data.PublicAccountItem;
import java.util.concurrent.ConcurrentHashMap;

class QidianProfileCardActivity$9
  implements Runnable
{
  QidianProfileCardActivity$9(QidianProfileCardActivity paramQidianProfileCardActivity, PublicAccountItem paramPublicAccountItem, URLImageView paramURLImageView) {}
  
  public void run()
  {
    int k = this.a.c;
    int j = 1;
    int i = j;
    if (k != 1) {
      if (this.a.c == 2) {
        i = j;
      } else {
        i = 0;
      }
    }
    String str;
    if (i != 0) {
      str = this.a.f;
    } else {
      str = this.a.a;
    }
    this.this$0.h.put(this.a.a, new QidianProfileCardActivity.PaGroupStruct(this.b, this.a.c, str));
    this.this$0.a(this.a.c, this.b, str, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.9
 * JD-Core Version:    0.7.0.1
 */