package com.tencent.mobileqq.listentogether.ui;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;

public class C2CListenTogetherPanel
  extends BaseListenTogetherPanel
{
  public C2CListenTogetherPanel(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof FriendChatPie)) {
      ((FriendChatPie)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie).bi();
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.b();
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString == null) {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.jdField_a_of_type_JavaLangString = "";
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo = new BaseListenTogetherPanel.ReportInfo();
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_JavaLangString = "c2c_AIO";
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$ReportInfo.b = "";
  }
  
  public String getTag()
  {
    return "BaseListenTogetherPanel_C2C";
  }
  
  public void k()
  {
    if ((AIOMusicSkin.a().m_()) && (!QQTheme.e())) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("BaseListenTogetherPanel_C2C", 1, String.format("[music-panel] onVasSkinStateChange mutualLevel=%d vasSkinShowing [%b-->%b]", new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData.f), Boolean.valueOf(this.e), Boolean.valueOf(bool) }));
      if (bool != this.e)
      {
        this.e = bool;
        a(this.jdField_a_of_type_ComTencentMobileqqListentogetherUiBaseListenTogetherPanel$UiData);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ui.C2CListenTogetherPanel
 * JD-Core Version:    0.7.0.1
 */