package com.tencent.mobileqq.troop.troopnotification.ui;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;

class TroopNotificationFragment$1$1
  implements Runnable
{
  TroopNotificationFragment$1$1(TroopNotificationFragment.1 param1, int paramInt) {}
  
  public void run()
  {
    if (TroopNotificationFragment.a(this.b.this$0) != null)
    {
      if (this.a > 0)
      {
        Object localObject = TroopNotificationFragment.a(this.b.this$0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.a);
        ((TextView)localObject).setText(localStringBuilder.toString());
        boolean bool = ThemeUtil.isDefaultOrDIYTheme(false);
        localObject = (RelativeLayout.LayoutParams)TroopNotificationFragment.a(this.b.this$0).getLayoutParams();
        if (bool) {
          TroopNotificationFragment.b(this.b.this$0).setVisibility(0);
        } else if ((localObject != null) && (TroopNotificationFragment.a(this.b.this$0).getContext() != null)) {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = Utils.a(35.0F, TroopNotificationFragment.a(this.b.this$0).getContext().getResources());
        }
        TroopNotificationFragment.a(this.b.this$0).setVisibility(0);
        return;
      }
      TroopNotificationFragment.a(this.b.this$0).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment.1.1
 * JD-Core Version:    0.7.0.1
 */