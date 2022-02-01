package com.tencent.mobileqq.listentogether.ui;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.OnExistListenTogetherCallback;
import com.tencent.mobileqq.statistics.ReportController;

class BaseListenTogetherPanel$3
  implements OnExistListenTogetherCallback
{
  BaseListenTogetherPanel$3(BaseListenTogetherPanel paramBaseListenTogetherPanel) {}
  
  public void a() {}
  
  public void a(boolean paramBoolean)
  {
    ListenTogetherManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a).a(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString, paramBoolean);
    String str1 = this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_JavaLangString;
    String str2 = this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append("");
    ReportController.b(null, "dc00899", str1, "", "music_tab", "clk_quit", 0, 0, str2, "", ((StringBuilder)localObject).toString(), "");
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getCurrentAccountUin().equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.c))
    {
      str2 = this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_JavaLangString;
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.b;
      if (paramBoolean) {
        str1 = "1";
      } else {
        str1 = "0";
      }
      ReportController.b(null, "dc00899", str2, "", "music_tab", "clk_quit_opener", 0, 0, (String)localObject, "", str1, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel.3
 * JD-Core Version:    0.7.0.1
 */