package com.tencent.mobileqq.kandian.biz.push.mvp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.push.RIJPushNotifyParam;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class RIJPushNotifyDialog$initListener$3
  implements View.OnClickListener
{
  RIJPushNotifyDialog$initListener$3(RIJPushNotifyDialog paramRIJPushNotifyDialog) {}
  
  public final void onClick(View paramView)
  {
    RIJPushNotifyDialog.a(this.a).a().invoke(Boolean.valueOf(false), Boolean.valueOf(RIJPushNotifyDialog.a(this.a)), Integer.valueOf(3));
    this.a.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.mvp.RIJPushNotifyDialog.initListener.3
 * JD-Core Version:    0.7.0.1
 */