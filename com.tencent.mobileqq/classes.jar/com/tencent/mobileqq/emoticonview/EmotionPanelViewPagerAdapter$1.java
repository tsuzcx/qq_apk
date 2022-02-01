package com.tencent.mobileqq.emoticonview;

import aslt;
import aspr;
import aspt;
import assj;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.widget.ListView;
import java.util.List;

class EmotionPanelViewPagerAdapter$1
  implements Runnable
{
  EmotionPanelViewPagerAdapter$1(EmotionPanelViewPagerAdapter paramEmotionPanelViewPagerAdapter, int paramInt, aslt paramaslt, aspt paramaspt, ListView paramListView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      if (this.this$0.c) {}
      for (localObject = assj.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aslt.jdField_a_of_type_Int, this.this$0.jdField_a_of_type_ArrayOfInt);; localObject = assj.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.d, this.jdField_a_of_type_Aslt.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Int))
      {
        EmotionPanelViewPagerAdapter.a(this.this$0, this.jdField_a_of_type_Aspt.a, this.jdField_a_of_type_Aslt, (List)localObject);
        this.this$0.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Aspt, this.jdField_a_of_type_Aslt, this.jdField_a_of_type_ComTencentWidgetListView, (List)localObject);
        return;
      }
    }
    Object localObject = aspr.a();
    QQAppInterface localQQAppInterface = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int j = this.jdField_a_of_type_Int;
    EmoticonPackage localEmoticonPackage = this.jdField_a_of_type_Aspt.a;
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) {}
    for (int i = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().jdField_a_of_type_Int;; i = -1)
    {
      localObject = ((aspr)localObject).a(localQQAppInterface, j, localEmoticonPackage, i, this.this$0.jdField_b_of_type_Int, this.this$0.jdField_b_of_type_Boolean);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionPanelViewPagerAdapter.1
 * JD-Core Version:    0.7.0.1
 */