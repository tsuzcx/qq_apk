package com.tencent.mobileqq.filemanager.widget;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListenerV2;

class SendBottomBar$6
  implements ActionSheet.OnButtonClickListenerV2
{
  SendBottomBar$6(SendBottomBar paramSendBottomBar) {}
  
  public void OnClick(View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(HardCodeUtil.a(2131713733)))
    {
      paramView = FileManagerUtil.a("排序方式:\n时间", HardCodeUtil.a(2131713742), null);
      SendBottomBar.a(this.a).setText(paramView);
      if (SendBottomBar.a(this.a).g() == 0) {
        return;
      }
      SendBottomBar.a(this.a).d(0);
    }
    for (;;)
    {
      this.a.a.dismiss();
      return;
      if (paramString.equals(HardCodeUtil.a(2131713762)))
      {
        paramView = FileManagerUtil.a("排序方式:\n大小", HardCodeUtil.a(2131713736), null);
        SendBottomBar.a(this.a).setText(paramView);
        if (SendBottomBar.a(this.a).g() == 1) {
          break;
        }
        SendBottomBar.a(this.a).d(1);
        continue;
      }
      if (paramString.equals(HardCodeUtil.a(2131713735)))
      {
        paramView = FileManagerUtil.a("排序方式:\n类型", HardCodeUtil.a(2131713758), null);
        SendBottomBar.a(this.a).setText(paramView);
        if (SendBottomBar.a(this.a).g() == 2) {
          break;
        }
        SendBottomBar.a(this.a).d(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.6
 * JD-Core Version:    0.7.0.1
 */