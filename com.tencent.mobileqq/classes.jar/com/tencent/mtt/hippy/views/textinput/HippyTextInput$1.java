package com.tencent.mtt.hippy.views.textinput;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;

class HippyTextInput$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  HippyTextInput$1(HippyTextInput paramHippyTextInput) {}
  
  public void onGlobalLayout()
  {
    int i = HippyTextInput.access$000(this.this$0);
    int j = HippyTextInput.access$100(this.this$0);
    if ((i != -1) && (j != -1))
    {
      if (HippyTextInput.access$200(this.this$0) == -1) {
        if (i <= j * 0.8F) {}
      }
      HippyMap localHippyMap;
      for (;;)
      {
        HippyTextInput.access$302(this.this$0, false);
        break label284;
        if (HippyTextInput.access$300(this.this$0)) {
          break label275;
        }
        localHippyMap = new HippyMap();
        localHippyMap.pushInt("keyboardHeight", Math.abs(j - i));
        ((EventDispatcher)this.this$0.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(this.this$0.getId(), "onKeyboardWillShow", localHippyMap);
        break label275;
        if (i <= j * 0.8F) {
          break;
        }
        if (HippyTextInput.access$300(this.this$0))
        {
          localHippyMap = new HippyMap();
          ((EventDispatcher)this.this$0.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(this.this$0.getId(), "onKeyboardWillHide", localHippyMap);
        }
      }
      if (!HippyTextInput.access$300(this.this$0))
      {
        localHippyMap = new HippyMap();
        localHippyMap.pushInt("keyboardHeight", Math.abs(HippyTextInput.access$200(this.this$0) - i));
        ((EventDispatcher)this.this$0.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(this.this$0.getId(), "onKeyboardWillShow", localHippyMap);
      }
      label275:
      HippyTextInput.access$302(this.this$0, true);
    }
    label284:
    HippyTextInput.access$202(this.this$0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.textinput.HippyTextInput.1
 * JD-Core Version:    0.7.0.1
 */