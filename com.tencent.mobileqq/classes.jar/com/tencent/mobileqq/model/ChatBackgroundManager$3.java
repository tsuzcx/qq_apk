package com.tencent.mobileqq.model;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.Vector;

class ChatBackgroundManager$3
  implements ChatBackgroundManager.BgThemeColorExtractListener
{
  ChatBackgroundManager$3(ChatBackgroundManager paramChatBackgroundManager, Context paramContext) {}
  
  public void a(boolean paramBoolean, Vector<Integer> paramVector)
  {
    if (paramBoolean)
    {
      paramVector = this.a;
      if ((paramVector != null) && ((paramVector instanceof BaseActivity)))
      {
        paramVector = ((BaseActivity)paramVector).getChatFragment();
        if ((paramVector != null) && (paramVector.k() != null) && (paramVector.k().U != null))
        {
          ChatXListView localChatXListView = paramVector.k().U;
          int i = localChatXListView.getFirstVisiblePosition();
          int j = localChatXListView.getLastVisiblePosition();
          while (i <= j)
          {
            Object localObject = AIOUtils.a(localChatXListView, i);
            if ((localObject != null) && (((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof BaseBubbleBuilder.ViewHolder)))
            {
              localObject = (BaseBubbleBuilder.ViewHolder)((View)localObject).getTag();
              if ((((BaseBubbleBuilder.ViewHolder)localObject).i != null) && (!((BaseBubbleBuilder.ViewHolder)localObject).i.o) && (((BaseBubbleBuilder.ViewHolder)localObject).i.p))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("ChatBackgroundManager", 2, "BgThemeColorExtractListener.onBgThemeColorExtracted: success=true, refresh AIO.");
                }
                paramVector.k().a(((BaseBubbleBuilder.ViewHolder)localObject).q, 1);
              }
            }
            i += 1;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.model.ChatBackgroundManager.3
 * JD-Core Version:    0.7.0.1
 */