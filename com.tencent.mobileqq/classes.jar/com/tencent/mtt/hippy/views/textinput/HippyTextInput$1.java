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
    if ((i == -1) || (j == -1))
    {
      HippyTextInput.access$202(this.this$0, i);
      HippyTextInput.access$302(this.this$0, HippyTextInput.access$400(this.this$0));
      return;
    }
    if (HippyTextInput.access$200(this.this$0) == -1) {
      if (i > j * 0.8F) {
        HippyTextInput.access$502(this.this$0, false);
      }
    }
    for (;;)
    {
      HippyTextInput.access$202(this.this$0, i);
      HippyTextInput.access$302(this.this$0, HippyTextInput.access$400(this.this$0));
      return;
      HippyMap localHippyMap;
      if (!HippyTextInput.access$500(this.this$0))
      {
        localHippyMap = new HippyMap();
        localHippyMap.pushInt("keyboardHeight", Math.abs(j - i));
        ((EventDispatcher)this.this$0.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(this.this$0.getId(), "onKeyboardWillShow", localHippyMap);
      }
      HippyTextInput.access$502(this.this$0, true);
      continue;
      if (i > j * 0.8F)
      {
        if (HippyTextInput.access$500(this.this$0) == true)
        {
          localHippyMap = new HippyMap();
          ((EventDispatcher)this.this$0.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(this.this$0.getId(), "onKeyboardWillHide", localHippyMap);
        }
        HippyTextInput.access$502(this.this$0, false);
      }
      else
      {
        if (!HippyTextInput.access$500(this.this$0))
        {
          localHippyMap = new HippyMap();
          localHippyMap.pushInt("keyboardHeight", Math.abs(HippyTextInput.access$200(this.this$0) - i));
          ((EventDispatcher)this.this$0.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(this.this$0.getId(), "onKeyboardWillShow", localHippyMap);
        }
        HippyTextInput.access$502(this.this$0, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.textinput.HippyTextInput.1
 * JD-Core Version:    0.7.0.1
 */