package com.tencent.xweb.xwalk;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.xweb.JsRuntime.JsRuntimeType;
import com.tencent.xweb.v;
import org.xwalk.core.Log;

class d$2
  implements RadioGroup.OnCheckedChangeListener
{
  d$2(d paramd) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    JsRuntime.JsRuntimeType localJsRuntimeType = JsRuntime.JsRuntimeType.a;
    if (paramInt == 2131449291) {
      localJsRuntimeType = JsRuntime.JsRuntimeType.a;
    } else if (paramInt == 2131449295) {
      localJsRuntimeType = JsRuntime.JsRuntimeType.b;
    } else if (paramInt == 2131449296) {
      localJsRuntimeType = JsRuntime.JsRuntimeType.f;
    } else if (paramInt == 2131449293) {
      localJsRuntimeType = JsRuntime.JsRuntimeType.h;
    } else if (paramInt == 2131449292) {
      localJsRuntimeType = JsRuntime.JsRuntimeType.i;
    }
    v.a().a(localJsRuntimeType);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("v8 type change to=");
    localStringBuilder.append(localJsRuntimeType);
    Log.d("WebDebugPage", localStringBuilder.toString());
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.2
 * JD-Core Version:    0.7.0.1
 */