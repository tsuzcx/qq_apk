package com.tencent.mobileqq.flashshow.part;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.flashshow.events.FSShowFeedDebugEvent;
import com.tencent.richframework.common.RFWLauncher;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class FSDebugPart$2$1
  implements ActionSheet.OnButtonClickListener
{
  FSDebugPart$2$1(FSDebugPart.2 param2, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = this.a.getContent(paramInt);
    if (TextUtils.isEmpty(paramView)) {
      return;
    }
    if (paramView.equals(this.b.b.g().getString(2131889704))) {
      RFWLauncher.a(this.b.b.g());
    } else if (paramView.equals(this.b.b.g().getString(2131889706))) {
      FSDebugPart.b(this.b.b, this.b.a);
    } else if (paramView.equals(this.b.b.g().getString(2131889743))) {
      SimpleEventBus.getInstance().dispatchEvent(new FSShowFeedDebugEvent(true));
    } else if (paramView.equals(this.b.b.g().getString(2131889708))) {
      SimpleEventBus.getInstance().dispatchEvent(new FSShowFeedDebugEvent(false));
    }
    FSDebugPart.b(this.b.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSDebugPart.2.1
 * JD-Core Version:    0.7.0.1
 */