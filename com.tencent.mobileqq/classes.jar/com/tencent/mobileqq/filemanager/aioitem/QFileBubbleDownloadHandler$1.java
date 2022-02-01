package com.tencent.mobileqq.filemanager.aioitem;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFileBubbleDownloadHandler$1
  implements View.OnClickListener
{
  QFileBubbleDownloadHandler$1(QFileBubbleDownloadHandler paramQFileBubbleDownloadHandler) {}
  
  public void onClick(View paramView)
  {
    BaseBubbleBuilder.ViewHolder localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramView);
    int i;
    ChatMessage localChatMessage;
    if (localViewHolder != null)
    {
      i = -1;
      localChatMessage = FileManagerUtil.a(localViewHolder.a);
      if (!this.a.b(localChatMessage)) {
        break label83;
      }
      i = 0;
    }
    for (;;)
    {
      this.a.a(paramView, localViewHolder, localChatMessage, i);
      if (this.a.a != null) {
        this.a.a.b(localViewHolder.a);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label83:
      if (this.a.a(localChatMessage)) {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.QFileBubbleDownloadHandler.1
 * JD-Core Version:    0.7.0.1
 */