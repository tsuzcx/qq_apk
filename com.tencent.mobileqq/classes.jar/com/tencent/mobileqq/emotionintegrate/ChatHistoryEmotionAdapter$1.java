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
    if (ChatHistoryEmotionAdapter.a(this.b).b(this.a) != null)
    {
      boolean bool = ChatHistoryEmotionAdapter.a(this.b).a(this.a, this.b.e, this.b.d);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ChatHistoryEmotionAdapter.b(this.b));
      ((StringBuilder)localObject).append("");
      String str = ((StringBuilder)localObject).toString();
      if (bool) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      ReportController.b(null, "dc00898", "", "", "0X800AC87", "0X800AC87", 2, 0, str, (String)localObject, "", "");
      this.b.notifyDataSetChanged();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.ChatHistoryEmotionAdapter.1
 * JD-Core Version:    0.7.0.1
 */