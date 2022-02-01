package com.tencent.mobileqq.kandian.biz.tab;

import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.kandian.biz.account.api.impl.RIJUserProtoUtils;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

final class RIJTabFrameDeliverPopupUtil$1
  implements PopupMenuDialog.OnClickActionListener
{
  RIJTabFrameDeliverPopupUtil$1(Frame paramFrame) {}
  
  public void onClickAction(PopupMenuDialog.MenuItem paramMenuItem)
  {
    int i = paramMenuItem.id;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("popupMenuDialog click, not support id, id=");
          localStringBuilder.append(paramMenuItem.id);
          QLog.e("RIJTabFrameDeliverPopupUtil", 1, localStringBuilder.toString());
          return;
        }
        RIJUgcUtils.c(this.a.P());
        return;
      }
      RIJUserProtoUtils.INSTANCE.check(this.a.P(), new RIJTabFrameDeliverPopupUtil.1.1(this));
      return;
    }
    RIJUgcUtils.b(this.a.P());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.RIJTabFrameDeliverPopupUtil.1
 * JD-Core Version:    0.7.0.1
 */