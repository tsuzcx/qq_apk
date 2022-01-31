package com.tencent.tvkbeacon.l;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.tvkbeacon.core.b;
import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.upload.UploadStrategy;
import java.util.Map;

public class ModuleImpl
  extends b
{
  private static ModuleImpl mInstance;
  private boolean enableModule = UploadStrategy.DEFAULT_PAGE_PATH_ENABLE;
  
  public ModuleImpl(Context paramContext)
  {
    super(paramContext);
  }
  
  public static ModuleImpl getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new ModuleImpl(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  public void onModuleStarted()
  {
    super.onModuleStarted();
    if ((this.enableModule) && (Build.VERSION.SDK_INT >= 14)) {}
    for (boolean bool = true;; bool = false)
    {
      this.enableModule = bool;
      c.a("[module] pagePath module > %S", new Object[] { this.enableModule });
      if (this.enableModule) {
        ((Application)this.mContext).registerActivityLifecycleCallbacks(new a());
      }
      return;
    }
  }
  
  public void onModuleStrategyUpdated(int paramInt, Map<String, String> paramMap)
  {
    super.onModuleStrategyUpdated(paramInt, paramMap);
    if (paramInt == 1)
    {
      this.enableModule = com.tencent.tvkbeacon.core.c.a.a((String)paramMap.get("isPagePath"), this.enableModule);
      c.b("[module] get isPagePath: " + this.enableModule, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.l.ModuleImpl
 * JD-Core Version:    0.7.0.1
 */