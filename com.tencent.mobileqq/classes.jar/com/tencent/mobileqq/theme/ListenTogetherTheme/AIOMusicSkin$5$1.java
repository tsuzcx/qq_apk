package com.tencent.mobileqq.theme.ListenTogetherTheme;

import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.vas.quickupdate.MusicThemeCallback;
import java.util.concurrent.ConcurrentHashMap;

class AIOMusicSkin$5$1
  implements Runnable
{
  AIOMusicSkin$5$1(AIOMusicSkin.5 param5, boolean paramBoolean) {}
  
  public void run()
  {
    AIOMusicSkin.a(this.jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin$5.this$0, this.jdField_a_of_type_Boolean);
    if ((AIOMusicSkin.a(this.jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin$5.this$0) != null) && (AIOMusicSkin.a(this.jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin$5.this$0).jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) && (AIOMusicSkin.a(this.jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin$5.this$0).jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        Object localObject = MusicThemeCallback.sInstance;
        localObject = ((MusicThemeCallback)localObject).getDir(AIOMusicSkin.a(this.jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin$5.this$0).getBaseActivity(), ((MusicThemeCallback)localObject).getScid(AIOMusicSkin.b(this.jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin$5.this$0)));
        this.jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin$5.this$0.a((String)localObject);
        AIOMusicSkin.a(this.jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin$5.this$0).put(Integer.valueOf(AIOMusicSkin.b(this.jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin$5.this$0)), localObject);
      }
      AIOMusicSkin.a(this.jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin$5.this$0, AIOMusicSkin.a(this.jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin$5.this$0).jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
      this.jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin$5.this$0.a(AIOMusicSkin.a(this.jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin$5.this$0).jdField_a_of_type_AndroidContentContext, AIOMusicSkin.a(this.jdField_a_of_type_ComTencentMobileqqThemeListenTogetherThemeAIOMusicSkin$5.this$0).jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin.5.1
 * JD-Core Version:    0.7.0.1
 */