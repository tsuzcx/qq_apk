package com.tencent.mobileqq.kandian.biz.framework;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.account.api.IRIJUserProtoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;

final class RIJUGCDianDian$1
  implements PopupMenuDialog.OnClickActionListener
{
  RIJUGCDianDian$1(BaseActivity paramBaseActivity) {}
  
  public void onClickAction(PopupMenuDialog.MenuItem paramMenuItem)
  {
    int i = paramMenuItem.id;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      ((IRIJUserProtoUtils)QRoute.api(IRIJUserProtoUtils.class)).check(this.a, new RIJUGCDianDian.1.2(this));
      return;
    }
    ((IRIJUserProtoUtils)QRoute.api(IRIJUserProtoUtils.class)).check(this.a, new RIJUGCDianDian.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJUGCDianDian.1
 * JD-Core Version:    0.7.0.1
 */