package com.tencent.mobileqq.kandian.glue.viola.view;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.viola.utils.ViolaUtils;

class ViolaBaseView$23
  implements Runnable
{
  ViolaBaseView$23(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547");
    ((StringBuilder)localObject1).append(RIJQQAppInterfaceUtil.a());
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = Long.valueOf(0L);
    if (l - ((Long)RIJSPUtils.a((String)localObject2, localObject1)).longValue() > 18000000L)
    {
      ViolaBaseView.d(this.this$0, false);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547");
      ((StringBuilder)localObject2).append(RIJQQAppInterfaceUtil.a());
      RIJSPUtils.a(((StringBuilder)localObject2).toString(), Long.valueOf(System.currentTimeMillis()));
    }
    l = System.currentTimeMillis();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(ViolaUtils.getPageName(this.this$0.a));
    ((StringBuilder)localObject2).append(RIJQQAppInterfaceUtil.a());
    if ((l - ((Long)RIJSPUtils.a(((StringBuilder)localObject2).toString(), localObject1)).longValue() > 7200000L) && (!ViolaBaseView.b(this.this$0)))
    {
      ViolaBaseView.e(this.this$0, false);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ViolaUtils.getPageName(this.this$0.a));
      ((StringBuilder)localObject1).append(RIJQQAppInterfaceUtil.a());
      RIJSPUtils.a(((StringBuilder)localObject1).toString(), Long.valueOf(System.currentTimeMillis()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.23
 * JD-Core Version:    0.7.0.1
 */