package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.content.Intent;
import com.tencent.tkd.topicsdk.framework.eventdispatch.IEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/ClickActionEvent;", "Lcom/tencent/tkd/topicsdk/framework/eventdispatch/IEvent;", "requestCode", "", "data", "Landroid/content/Intent;", "(ILandroid/content/Intent;)V", "getData", "()Landroid/content/Intent;", "setData", "(Landroid/content/Intent;)V", "getRequestCode", "()I", "setRequestCode", "(I)V", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ClickActionEvent
  implements IEvent
{
  private int a;
  @NotNull
  private Intent b;
  
  public ClickActionEvent(int paramInt, @NotNull Intent paramIntent)
  {
    this.a = paramInt;
    this.b = paramIntent;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  @NotNull
  public final Intent b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.ClickActionEvent
 * JD-Core Version:    0.7.0.1
 */