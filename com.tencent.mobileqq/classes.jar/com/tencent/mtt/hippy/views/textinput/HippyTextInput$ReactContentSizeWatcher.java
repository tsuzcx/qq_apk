package com.tencent.mtt.hippy.views.textinput;

import android.text.Layout;
import android.widget.EditText;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;

public class HippyTextInput$ReactContentSizeWatcher
{
  private final EditText mEditText;
  final HippyEngineContext mHippyContext;
  private int mPreviousContentHeight = 0;
  private int mPreviousContentWidth = 0;
  
  public HippyTextInput$ReactContentSizeWatcher(HippyTextInput paramHippyTextInput, EditText paramEditText, HippyEngineContext paramHippyEngineContext)
  {
    this.mEditText = paramEditText;
    this.mHippyContext = paramHippyEngineContext;
  }
  
  public void onLayout()
  {
    int i = this.mEditText.getWidth();
    int j = this.mEditText.getHeight();
    if (this.mEditText.getLayout() != null)
    {
      i = this.mEditText.getCompoundPaddingLeft();
      int k = this.mEditText.getLayout().getWidth();
      j = 0;
      if (i + k < 0) {
        i = 0;
      } else {
        i = this.mEditText.getLayout().getWidth() + this.mEditText.getCompoundPaddingRight();
      }
      if (this.mEditText.getCompoundPaddingTop() + this.mEditText.getLayout().getHeight() >= 0) {
        j = this.mEditText.getLayout().getHeight() + this.mEditText.getCompoundPaddingBottom();
      }
    }
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.textinput.HippyTextInput.ReactContentSizeWatcher
 * JD-Core Version:    0.7.0.1
 */