package com.tencent.mobileqq.pluspanel.appinfo;

import android.view.View;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ShareScreenAppInfo$6
  implements ActionSheet.OnButtonClickListener
{
  ShareScreenAppInfo$6(ShareScreenAppInfo paramShareScreenAppInfo, PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        ShareScreenAppInfo.access$200(this.e, this.b, this.c);
        ScreenShareReportHelper.a("0X800B89F", 1);
      }
    }
    else
    {
      ShareScreenAppInfo.access$100(this.e, this.a, this.b, this.c);
      ScreenShareReportHelper.a("0X800AD8E", 1);
    }
    this.d.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.ShareScreenAppInfo.6
 * JD-Core Version:    0.7.0.1
 */