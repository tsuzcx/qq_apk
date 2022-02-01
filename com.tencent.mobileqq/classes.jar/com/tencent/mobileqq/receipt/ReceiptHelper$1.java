package com.tencent.mobileqq.receipt;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.qroute.QRoute;

class ReceiptHelper$1
  implements Runnable
{
  ReceiptHelper$1(ReceiptHelper paramReceiptHelper) {}
  
  public void run()
  {
    AIOShortcutBarHelper localAIOShortcutBarHelper = (AIOShortcutBarHelper)ReceiptHelper.a(this.this$0).a(52);
    if (localAIOShortcutBarHelper != null) {
      localAIOShortcutBarHelper.c(12);
    }
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(ReceiptHelper.a(this.this$0).a(), "receipt_msg", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.receipt.ReceiptHelper.1
 * JD-Core Version:    0.7.0.1
 */