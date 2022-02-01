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
    if (paramString.equals(HardCodeUtil.a(2131692344)))
    {
      paramView = QQFileManagerUtil.a("排序方式:\n时间", HardCodeUtil.a(2131692362), null);
      SendBottomBar.a(this.a).setText(paramView);
      if (SendBottomBar.a(this.a).g() == 0) {
        return;
      }
      SendBottomBar.a(this.a).d(0);
    }
    else if (paramString.equals(HardCodeUtil.a(2131692343)))
    {
      paramView = QQFileManagerUtil.a("排序方式:\n大小", HardCodeUtil.a(2131692342), null);
      SendBottomBar.a(this.a).setText(paramView);
      if (SendBottomBar.a(this.a).g() == 1) {
        return;
      }
      SendBottomBar.a(this.a).d(1);
    }
    else if (paramString.equals(HardCodeUtil.a(2131692345)))
    {
      paramView = QQFileManagerUtil.a("排序方式:\n类型", HardCodeUtil.a(2131692366), null);
      SendBottomBar.a(this.a).setText(paramView);
      if (SendBottomBar.a(this.a).g() == 2) {
        return;
      }
      SendBottomBar.a(this.a).d(2);
    }
    this.a.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.6
 * JD-Core Version:    0.7.0.1
 */