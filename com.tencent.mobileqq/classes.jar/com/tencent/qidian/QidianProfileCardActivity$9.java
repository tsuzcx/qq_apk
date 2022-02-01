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
    int j = 1;
    int i = j;
    if (this.jdField_a_of_type_ComTencentQidianDataPublicAccountItem.jdField_a_of_type_Int != 1)
    {
      if (this.jdField_a_of_type_ComTencentQidianDataPublicAccountItem.jdField_a_of_type_Int == 2) {
        i = j;
      }
    }
    else {
      if (i == 0) {
        break label103;
      }
    }
    label103:
    for (String str = this.jdField_a_of_type_ComTencentQidianDataPublicAccountItem.c;; str = this.jdField_a_of_type_ComTencentQidianDataPublicAccountItem.jdField_a_of_type_JavaLangString)
    {
      this.this$0.a.put(this.jdField_a_of_type_ComTencentQidianDataPublicAccountItem.jdField_a_of_type_JavaLangString, new QidianProfileCardActivity.PaGroupStruct(this.jdField_a_of_type_ComTencentImageURLImageView, this.jdField_a_of_type_ComTencentQidianDataPublicAccountItem.jdField_a_of_type_Int, str));
      this.this$0.a(this.jdField_a_of_type_ComTencentQidianDataPublicAccountItem.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentImageURLImageView, str, false);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.9
 * JD-Core Version:    0.7.0.1
 */