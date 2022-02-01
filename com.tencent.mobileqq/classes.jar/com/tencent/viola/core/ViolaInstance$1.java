package com.tencent.viola.core;

import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.utils.ViolaLogUtils;

class ViolaInstance$1
  implements Runnable
{
  ViolaInstance$1(ViolaInstance paramViolaInstance, VComponentContainer paramVComponentContainer, boolean paramBoolean) {}
  
  public void run()
  {
    ViolaLogUtils.e("ViolaInstance", "violaInstance pageEndMonitor start!");
    ViolaInstance.access$002(this.this$0, this.val$root);
    if (ViolaInstance.access$100(this.this$0))
    {
      ViolaInstance.access$200(this.this$0, this.val$root, this.val$createFromNativeVue);
      return;
    }
    ViolaInstance.access$300(this.this$0, this.val$root);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.core.ViolaInstance.1
 * JD-Core Version:    0.7.0.1
 */