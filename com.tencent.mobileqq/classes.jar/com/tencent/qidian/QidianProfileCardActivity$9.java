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
    int k = this.jdField_a_of_type_ComTencentQidianDataPublicAccountItem.jdField_a_of_type_Int;
    int j = 1;
    int i = j;
    if (k != 1) {
      if (this.jdField_a_of_type_ComTencentQidianDataPublicAccountItem.jdField_a_of_type_Int == 2) {
        i = j;
      } else {
        i = 0;
      }
    }
    String str;
    if (i != 0) {
      str = this.jdField_a_of_type_ComTencentQidianDataPublicAccountItem.c;
    } else {
      str = this.jdField_a_of_type_ComTencentQidianDataPublicAccountItem.jdField_a_of_type_JavaLangString;
    }
    this.this$0.a.put(this.jdField_a_of_type_ComTencentQidianDataPublicAccountItem.jdField_a_of_type_JavaLangString, new QidianProfileCardActivity.PaGroupStruct(this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_ComTencentQidianDataPublicAccountItem.jdField_a_of_type_Int, str));
    this.this$0.a(this.jdField_a_of_type_ComTencentQidianDataPublicAccountItem.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentImageURLImageView, str, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.9
 * JD-Core Version:    0.7.0.1
 */