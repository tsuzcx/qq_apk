package com.tencent.mobileqq.qwallet.hb.emoji.impl;

import com.tencent.qphone.base.util.QLog;

class HandRecognizer$1
  implements Runnable
{
  HandRecognizer$1(HandRecognizer paramHandRecognizer) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplYtHandBox.e < 0.5D)
    {
      Object localObject = this.this$0;
      int i = ((HandRecognizer)localObject).doHandDetection(((HandRecognizer)localObject).jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplYtHandBox);
      if (QLog.isColorLevel())
      {
        localObject = HandRecognizer.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doHandDetection return ");
        localStringBuilder.append(i);
        localStringBuilder.append("---");
        localStringBuilder.append(this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletHbEmojiImplYtHandBox.e);
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
    }
    this.this$0.b = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.emoji.impl.HandRecognizer.1
 * JD-Core Version:    0.7.0.1
 */