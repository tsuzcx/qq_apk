package com.tencent.mobileqq.filemanager.aioitem;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileBubblePauseHandler$1
  implements View.OnClickListener
{
  QFileBubblePauseHandler$1(QFileBubblePauseHandler paramQFileBubblePauseHandler) {}
  
  public void onClick(View paramView)
  {
    BaseBubbleBuilder.ViewHolder localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramView);
    if (localViewHolder != null)
    {
      int i = -1;
      ChatMessage localChatMessage = FileManagerUtil.a(localViewHolder.a);
      if (this.a.a(localChatMessage)) {
        i = 0;
      } else if (this.a.b(localChatMessage)) {
        i = 1;
      }
      this.a.a(paramView, localViewHolder, localChatMessage, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.QFileBubblePauseHandler.1
 * JD-Core Version:    0.7.0.1
 */