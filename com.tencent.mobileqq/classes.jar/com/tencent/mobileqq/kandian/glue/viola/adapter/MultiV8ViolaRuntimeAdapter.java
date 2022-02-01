package com.tencent.mobileqq.kandian.glue.viola.adapter;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.IMultiV8ViolaRuntimeAdapter;

public class MultiV8ViolaRuntimeAdapter
  implements IMultiV8ViolaRuntimeAdapter
{
  private boolean a;
  private volatile boolean b;
  private volatile boolean c;
  
  public MultiV8ViolaRuntimeAdapter()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(519);
    boolean bool2 = true;
    boolean bool1;
    if (localAladdinConfig.getIntegerFromString("need_keep_global_var", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    if (Aladdin.getConfig(519).getIntegerFromString("need_preload_runtime", 1) == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.c = bool1;
  }
  
  public boolean needKeepGlobalVar(String paramString)
  {
    return (this.b) && ("video".equals(paramString));
  }
  
  public boolean needPreloadRuntime(String paramString)
  {
    return (this.c) && ("video".equals(paramString));
  }
  
  public void onViolaRuntimeReady()
  {
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.b();
        if (!this.a)
        {
          bool = true;
          ViolaAccessHelper.a(localQQAppInterface, bool);
          this.a = true;
          return;
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("error: ");
        localStringBuilder.append(localException.getMessage());
        QLog.e("MultiV8ViolaRuntimeAdapter", 1, localStringBuilder.toString());
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.MultiV8ViolaRuntimeAdapter
 * JD-Core Version:    0.7.0.1
 */