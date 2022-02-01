package com.tencent.mobileqq.hiboom;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class SetFontBubble
{
  private static AtomicInteger a;
  public int a;
  public FontBubble a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
  }
  
  public SetFontBubble(FontBubble paramFontBubble)
  {
    this.jdField_a_of_type_Int = jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
    this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble = paramFontBubble;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setFontBubble: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.fontId);
      localStringBuilder.append(",");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.bubbleId);
      QLog.e("FontBubbleManager", 1, localStringBuilder.toString());
    }
    ((ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.fontId, this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubble.bubbleId, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.SetFontBubble
 * JD-Core Version:    0.7.0.1
 */