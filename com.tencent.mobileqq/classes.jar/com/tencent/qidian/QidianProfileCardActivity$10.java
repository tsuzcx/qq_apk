package com.tencent.qidian;

import com.tencent.image.URLImageView;
import com.tencent.qidian.data.GroupItem;
import java.util.concurrent.ConcurrentHashMap;

class QidianProfileCardActivity$10
  implements Runnable
{
  QidianProfileCardActivity$10(QidianProfileCardActivity paramQidianProfileCardActivity, GroupItem paramGroupItem, URLImageView paramURLImageView) {}
  
  public void run()
  {
    String str = String.valueOf(this.jdField_a_of_type_ComTencentQidianDataGroupItem.a);
    this.this$0.a.put(str, new QidianProfileCardActivity.PaGroupStruct(this.jdField_a_of_type_ComTencentImageURLImageView, 3, str));
    this.this$0.a(3, this.jdField_a_of_type_ComTencentImageURLImageView, str, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.10
 * JD-Core Version:    0.7.0.1
 */