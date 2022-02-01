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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131896106));
    ((StringBuilder)localObject).append(FMDataCache.e());
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131896107));
    localObject = ((StringBuilder)localObject).toString();
    String str2 = HardCodeUtil.a(2131896078);
    String str1;
    if (SendBottomBar.c(this.a).L() != -1)
    {
      localObject = HardCodeUtil.a(2131896079);
      str1 = HardCodeUtil.a(2131896081);
      str2 = HardCodeUtil.a(2131896080);
    }
    else
    {
      str1 = null;
    }
    SendBottomBar localSendBottomBar = this.a;
    localSendBottomBar.c = DialogUtil.a(SendBottomBar.c(localSendBottomBar), 230, str1, (CharSequence)localObject, HardCodeUtil.a(2131887648), str2, new SendBottomBar.3.1(this), new SendBottomBar.3.2(this));
    this.a.c.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SendBottomBar.3
 * JD-Core Version:    0.7.0.1
 */