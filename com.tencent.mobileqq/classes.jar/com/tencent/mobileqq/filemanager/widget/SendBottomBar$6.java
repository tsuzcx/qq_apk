package com.tencent.mobileqq.filemanager.widget;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListenerV2;

class SendBottomBar$6
  implements ActionSheet.OnButtonClickListenerV2
{
  SendBottomBar$6(SendBottomBar paramSendBottomBar) {}
  
  public void OnClick(View paramView, int paramInt, String paramString)
  {
    if (paramString.equals(HardCodeUtil.a(2131889332)))
    {
      paramView = QQFileManagerUtil.a("排序方式:\n时间", HardCodeUtil.a(2131889350), null);
      SendBottomBar.p(this.a).setText(paramView);
      if (SendBottomBar.c(this.a).L() == 0) {
        return;
      }
      SendBottomBar.c(this.a).d(0);
    }
    else if (paramString.equals(HardCodeUtil.a(2131889331)))
    {
      paramView = QQFileManagerUtil.a("排序方式:\n大小", HardCodeUtil.a(2131889330), null);
      SendBottomBar.p(this.a).setText(paramView);
      if (SendBottomBar.c(this.a).L() == 1) {
        return;
      }
      SendBottomBar.c(this.a).d(1);
    }
    else if (paramString.equals(HardCodeUtil.a(2131889333)))
    {
      paramView = QQFileManagerUtil.a("排序方式:\n类型", HardCodeUtil.a(2131889354), null);
      SendBottomBar.p(this.a).setText(paramView);
      if (SendBottomBar.c(this.a).L() == 2) {
        return;
      }
      SendBottomBar.c(this.a).d(2);
    }
    this.a.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.6
 * JD-Core Version:    0.7.0.1
 */