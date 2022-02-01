package com.tencent.mobileqq.kandian.biz.fastweb;

import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class FastWebActivity$1$1
  implements InvocationHandler
{
  FastWebActivity$1$1(FastWebActivity.1 param1) {}
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    this.a.this$0.getWindow().setBackgroundDrawable(new ColorDrawable(0));
    FastWebActivity.a(this.a.this$0).setMaskBackGroundDrawable(new ColorDrawable(0));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.1.1
 * JD-Core Version:    0.7.0.1
 */