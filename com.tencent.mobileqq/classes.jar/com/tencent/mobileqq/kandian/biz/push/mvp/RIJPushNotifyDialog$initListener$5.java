package com.tencent.mobileqq.kandian.biz.push.mvp;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyParam;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class RIJPushNotifyDialog$initListener$5
  implements View.OnClickListener
{
  RIJPushNotifyDialog$initListener$5(RIJPushNotifyDialog paramRIJPushNotifyDialog) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.a;
    RIJPushNotifyDialog.a(paramView, RIJPushNotifyDialog.c(paramView) ^ true);
    if (RIJPushNotifyDialog.c(this.a))
    {
      if (RIJPushNotifyDialog.b(this.a).b())
      {
        RIJPushNotifyDialog.d(this.a).setCompoundDrawablesWithIntrinsicBounds(2130851430, 0, 0, 0);
        return;
      }
      RIJPushNotifyDialog.d(this.a).setCompoundDrawablesWithIntrinsicBounds(2130851431, 0, 0, 0);
      return;
    }
    if (RIJPushNotifyDialog.b(this.a).b())
    {
      RIJPushNotifyDialog.d(this.a).setCompoundDrawablesWithIntrinsicBounds(2130851436, 0, 0, 0);
      return;
    }
    RIJPushNotifyDialog.d(this.a).setCompoundDrawablesWithIntrinsicBounds(2130851437, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.mvp.RIJPushNotifyDialog.initListener.5
 * JD-Core Version:    0.7.0.1
 */