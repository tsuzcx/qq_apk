package com.tencent.mtt.hippy.views.textinput;

import android.text.Layout;
import android.widget.EditText;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;

public class HippyTextInput$ReactContentSizeWatcher
{
  private EditText mEditText;
  HippyEngineContext mHippyContext;
  private int mPreviousContentHeight = 0;
  private int mPreviousContentWidth = 0;
  
  public HippyTextInput$ReactContentSizeWatcher(HippyTextInput paramHippyTextInput, EditText paramEditText, HippyEngineContext paramHippyEngineContext)
  {
    this.mEditText = paramEditText;
    this.mHippyContext = paramHippyEngineContext;
  }
  
  public void onLayout()
  {
    int j = 0;
    int i = this.mEditText.getWidth();
    int k = this.mEditText.getHeight();
    if (this.mEditText.getLayout() != null) {
      if (this.mEditText.getCompoundPaddingLeft() + this.mEditText.getLayout().getWidth() < 0)
      {
        i = 0;
        if (this.mEditText.getCompoundPaddingTop() + this.mEditText.getLayout().getHeight() >= 0) {
          break label207;
        }
      }
    }
    for (;;)
    {
      if ((i != this.mPreviousContentWidth) || (j != this.mPreviousContentHeight))
      {
        this.mPreviousContentHeight = j;
        this.mPreviousContentWidth = i;
        HippyMap localHippyMap1 = new HippyMap();
        localHippyMap1.pushDouble("width", this.mPreviousContentWidth);
        localHippyMap1.pushDouble("height", this.mPreviousContentWidth);
        HippyMap localHippyMap2 = new HippyMap();
        localHippyMap2.pushMap("contentSize", localHippyMap1);
        ((EventDispatcher)this.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(this.this$0.getId(), "onContentSizeChange", localHippyMap2);
      }
      return;
      i = this.mEditText.getLayout().getWidth() + this.mEditText.getCompoundPaddingRight();
      break;
      label207:
      j = this.mEditText.getLayout().getHeight() + this.mEditText.getCompoundPaddingBottom();
      continue;
      j = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.textinput.HippyTextInput.ReactContentSizeWatcher
 * JD-Core Version:    0.7.0.1
 */