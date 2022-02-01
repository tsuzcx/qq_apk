package com.tencent.mobileqq.kandian.glue.viola.reward;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.viola.ui.view.IVView;
import java.lang.ref.WeakReference;

public class VKdRewardTaskLayout
  extends FrameLayout
  implements IVView<VKdRewardTaskVideoTimer>
{
  private WeakReference<VKdRewardTaskVideoTimer> a;
  
  public VKdRewardTaskLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(VKdRewardTaskVideoTimer paramVKdRewardTaskVideoTimer)
  {
    this.a = new WeakReference(paramVKdRewardTaskVideoTimer);
  }
  
  public VKdRewardTaskVideoTimer getComponent()
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference != null) {
      return (VKdRewardTaskVideoTimer)localWeakReference.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.reward.VKdRewardTaskLayout
 * JD-Core Version:    0.7.0.1
 */