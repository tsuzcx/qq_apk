package com.tencent.mobileqq.emoticonview;

import aoai;
import aoaj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonPackage;
import java.util.List;
import mqq.os.MqqHandler;

public class EmotionPanelDataBuilder$1
  implements Runnable
{
  public EmotionPanelDataBuilder$1(aoai paramaoai, QQAppInterface paramQQAppInterface, int paramInt1, EmoticonPackage paramEmoticonPackage, int paramInt2, int paramInt3, boolean paramBoolean, aoaj paramaoaj) {}
  
  public void run()
  {
    List localList = this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, this.b, this.c, this.jdField_a_of_type_Boolean);
    ThreadManager.getUIHandler().post(new EmotionPanelDataBuilder.1.1(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelDataBuilder.1
 * JD-Core Version:    0.7.0.1
 */