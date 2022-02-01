package com.tencent.mtt.hippy.views.textinput;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.utils.LogUtils;

class HippyTextInput$2
  implements TextWatcher
{
  HippyTextInput$2(HippyTextInput paramHippyTextInput) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    Object localObject = this.this$0;
    ((HippyTextInput)localObject).layout(((HippyTextInput)localObject).getLeft(), this.this$0.getTop(), this.this$0.getRight(), this.this$0.getBottom());
    if (TextUtils.isEmpty(HippyTextInput.access$700(this.this$0)))
    {
      if ((HippyTextInput.access$800(this.this$0)) && (TextUtils.equals(paramEditable.toString(), HippyTextInput.access$900(this.this$0)))) {
        return;
      }
      HippyTextInput.access$902(this.this$0, paramEditable.toString());
      HippyTextInput.access$802(this.this$0, true);
      if (this.this$0.bUserSetValue) {
        break label508;
      }
      localObject = new HippyMap();
      ((HippyMap)localObject).pushString("text", paramEditable.toString());
      ((EventDispatcher)this.this$0.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(this.this$0.getId(), "onChangeText", localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("afterTextChanged 通知前端文本变化=");
      ((StringBuilder)localObject).append(paramEditable.toString());
      LogUtils.d("robinsli", ((StringBuilder)localObject).toString());
    }
    try
    {
      boolean bool = paramEditable.toString().matches(HippyTextInput.access$700(this.this$0));
      if ((!bool) && (!"".equals(paramEditable.toString())))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("afterTextChanged 不符合正则表达式,需要设置回去=");
        ((StringBuilder)localObject).append(paramEditable.toString());
        LogUtils.d("robinsli", ((StringBuilder)localObject).toString());
        this.this$0.setText(HippyTextInput.access$600(this.this$0));
        HippyTextInput.access$1002(this.this$0, HippyTextInput.access$600(this.this$0));
        this.this$0.setSelection(this.this$0.getText().toString().length());
        HippyTextInput.access$802(this.this$0, true);
        return;
      }
      if ((HippyTextInput.access$800(this.this$0)) && (TextUtils.equals(paramEditable.toString(), HippyTextInput.access$900(this.this$0)))) {
        return;
      }
      HippyTextInput.access$802(this.this$0, true);
      HippyTextInput.access$902(this.this$0, paramEditable.toString());
      if ((!this.this$0.bUserSetValue) && ((TextUtils.isEmpty(HippyTextInput.access$1000(this.this$0))) || (!TextUtils.equals(HippyTextInput.access$1000(this.this$0), HippyTextInput.access$900(this.this$0)))))
      {
        localObject = new HippyMap();
        ((HippyMap)localObject).pushString("text", paramEditable.toString());
        ((EventDispatcher)this.this$0.mHippyContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(this.this$0.getId(), "onChangeText", localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("afterTextChanged 通知前端文本变化=");
        ((StringBuilder)localObject).append(paramEditable.toString());
        LogUtils.d("robinsli", ((StringBuilder)localObject).toString());
        HippyTextInput.access$1002(this.this$0, "");
      }
      label508:
      return;
    }
    catch (Throwable paramEditable) {}
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    HippyTextInput.access$602(this.this$0, paramCharSequence.toString());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.textinput.HippyTextInput.2
 * JD-Core Version:    0.7.0.1
 */