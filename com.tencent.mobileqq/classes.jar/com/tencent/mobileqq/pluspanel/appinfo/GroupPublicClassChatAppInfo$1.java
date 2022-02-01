package com.tencent.mobileqq.pluspanel.appinfo;

import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GroupPublicClassChatAppInfo$1
  implements ActionSheet.OnButtonClickListener
{
  GroupPublicClassChatAppInfo$1(GroupPublicClassChatAppInfo paramGroupPublicClassChatAppInfo, ActionSheet paramActionSheet, PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      GroupPublicClassChatAppInfo.access$100(this.d, this.c);
      return;
    }
    GroupPublicClassChatAppInfo.access$000(this.d, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.GroupPublicClassChatAppInfo.1
 * JD-Core Version:    0.7.0.1
 */