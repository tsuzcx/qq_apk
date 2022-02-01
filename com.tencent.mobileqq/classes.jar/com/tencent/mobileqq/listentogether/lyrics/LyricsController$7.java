package com.tencent.mobileqq.listentogether.lyrics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class LyricsController$7
  extends BroadcastReceiver
{
  LyricsController$7(LyricsController paramLyricsController) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    paramIntent = paramIntent.getStringExtra("process_name");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive action: ");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("  process_name:");
      localStringBuilder.append(paramIntent);
      QLog.d("LyricsController", 2, localStringBuilder.toString());
    }
    int i;
    if ((paramIntent != null) && (paramIntent.contains("openSdk"))) {
      i = 1;
    } else {
      i = 0;
    }
    if ("mqq.intent.action.QQ_BACKGROUND".equals(paramContext))
    {
      if ((this.a.b) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) && (this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_h_of_type_Boolean))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a.setAlign(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.a);
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_h_of_type_Int, this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.g());
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.i, this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.g());
        this.a.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_h_of_type_Boolean = false;
      }
      this.a.a(false);
      paramContext = this.a;
      paramContext.jdField_a_of_type_Boolean = false;
      LyricsController.a(paramContext, false);
      return;
    }
    if ("mqq.intent.action.QQ_FOREGROUND".equals(paramContext))
    {
      if (i == 0)
      {
        paramContext = this.a;
        paramContext.jdField_a_of_type_Boolean = true;
        paramContext.a(true);
        LyricsController.a(this.a, false);
        return;
      }
      if (this.a.b)
      {
        LyricsController.a(this.a, true);
        return;
      }
      paramContext = this.a;
      paramContext.jdField_a_of_type_Boolean = true;
      paramContext.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.f = true;
      LyricsController.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.7
 * JD-Core Version:    0.7.0.1
 */