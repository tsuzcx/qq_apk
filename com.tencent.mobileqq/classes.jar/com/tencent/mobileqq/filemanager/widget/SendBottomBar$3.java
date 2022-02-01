package com.tencent.mobileqq.filemanager.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SendBottomBar$3
  implements View.OnClickListener
{
  SendBottomBar$3(SendBottomBar paramSendBottomBar) {}
  
  public void onClick(View paramView)
  {
    String str2 = HardCodeUtil.a(2131713739) + FMDataCache.b() + HardCodeUtil.a(2131713745);
    String str1 = null;
    String str3 = HardCodeUtil.a(2131713757);
    if (SendBottomBar.a(this.a).g() != -1)
    {
      str2 = HardCodeUtil.a(2131713763);
      str1 = HardCodeUtil.a(2131713759);
      str3 = HardCodeUtil.a(2131713756);
    }
    this.a.a = DialogUtil.a(SendBottomBar.a(this.a), 230, str1, str2, HardCodeUtil.a(2131713755), str3, new SendBottomBar.3.1(this), new SendBottomBar.3.2(this));
    this.a.a.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.3
 * JD-Core Version:    0.7.0.1
 */