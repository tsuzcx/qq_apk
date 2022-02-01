package com.tencent.mobileqq.listentogether.ui;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.OnJoinListenTogetherCallback;
import com.tencent.mobileqq.statistics.ReportController;

class BaseListenTogetherPanel$4
  implements OnJoinListenTogetherCallback
{
  BaseListenTogetherPanel$4(BaseListenTogetherPanel paramBaseListenTogetherPanel, int paramInt, String paramString) {}
  
  public void a()
  {
    ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 1000);
    String str1 = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_JavaLangString;
    String str2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_Int);
    localStringBuilder.append("");
    ReportController.b(null, "dc00899", str1, "", "music_tab", "clk_join", 0, 0, str2, "", localStringBuilder.toString(), "");
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.4
 * JD-Core Version:    0.7.0.1
 */