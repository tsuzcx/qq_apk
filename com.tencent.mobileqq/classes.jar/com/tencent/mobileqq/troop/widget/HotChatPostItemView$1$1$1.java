package com.tencent.mobileqq.troop.widget;

import android.graphics.Bitmap;
import android.util.Pair;
import android.widget.ImageView;
import bcmt;

class HotChatPostItemView$1$1$1
  implements Runnable
{
  HotChatPostItemView$1$1$1(HotChatPostItemView.1.1 param1, Pair paramPair) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetHotChatPostItemView$1$1.this$0.jdField_a_of_type_AndroidWidgetImageView.getTag() instanceof String))
    {
      String str = (String)this.jdField_a_of_type_ComTencentMobileqqTroopWidgetHotChatPostItemView$1$1.this$0.jdField_a_of_type_AndroidWidgetImageView.getTag();
      if ((this.jdField_a_of_type_AndroidUtilPair != null) && (str.endsWith(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetHotChatPostItemView$1$1.this$0.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetHotChatPostItemView$1$1.this$0.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)this.jdField_a_of_type_AndroidUtilPair.first);
        HotChatPostItemView.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetHotChatPostItemView$1$1.this$0.jdField_a_of_type_JavaLangString, (Bitmap)this.jdField_a_of_type_AndroidUtilPair.first);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.HotChatPostItemView.1.1.1
 * JD-Core Version:    0.7.0.1
 */