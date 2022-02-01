package com.tencent.mobileqq.emotionintegrate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.photo.AIORichExpandInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryEmotionAdapter$1
  implements View.OnClickListener
{
  ChatHistoryEmotionAdapter$1(ChatHistoryEmotionAdapter paramChatHistoryEmotionAdapter, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (ChatHistoryEmotionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter).a(this.jdField_a_of_type_JavaLangString) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = ChatHistoryEmotionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter).a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.jdField_a_of_type_JavaUtilList);
    String str2 = ChatHistoryEmotionAdapter.a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter) + "";
    if (bool) {}
    for (String str1 = "1";; str1 = "2")
    {
      ReportController.b(null, "dc00898", "", "", "0X800AC87", "0X800AC87", 2, 0, str2, str1, "", "");
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateChatHistoryEmotionAdapter.notifyDataSetChanged();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.ChatHistoryEmotionAdapter.1
 * JD-Core Version:    0.7.0.1
 */