package com.tencent.mobileqq.startup.step;

import android.os.Debug;
import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.intervideo.IVLoggerFactory;
import com.tencent.mobileqq.intervideo.now.dynamic.IDynamicNowManagerApi;
import com.tencent.mobileqq.pic.URLDrawableDepWrapInit;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicRuntime;
import com.tencent.shadow.dynamic.host.PluginProcessService;
import java.io.File;

public class HuayangPluginContainer
  extends Step
{
  private static final int a = Runtime.getRuntime().availableProcessors();
  private static final int b;
  private static final int c;
  
  static
  {
    int i = a;
    b = i + 1;
    c = i * 2 + 1;
  }
  
  protected boolean doStep()
  {
    if (new File("/data/local/tmp/troophomework.debug").exists())
    {
      Toast.makeText(BaseApplicationImpl.getContext(), "waitForDebugger", 1).show();
      Debug.waitForDebugger();
    }
    LoggerFactory.setILoggerFactory(IVLoggerFactory.a());
    BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(PluginProcessService.getActivityHolder());
    DynamicRuntime.recoveryRuntime(BaseApplicationImpl.getContext());
    ((IDynamicNowManagerApi)QRoute.api(IDynamicNowManagerApi.class)).addJumpCallback();
    HuayangPluginContainer.URLDrawableFactory localURLDrawableFactory = new HuayangPluginContainer.URLDrawableFactory(BaseApplicationImpl.getApplication());
    URLDrawable.init(URLDrawableDepWrapInit.a(), localURLDrawableFactory);
    new InitUrlDrawable().step();
    new InitMemoryCache().step();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.HuayangPluginContainer
 * JD-Core Version:    0.7.0.1
 */