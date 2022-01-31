package com.tencent.mobileqq.startup.step;

import android.os.Debug;
import android.widget.Toast;
import aszd;
import atdh;
import azoa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.dynamic.host.DynamicRuntime;
import com.tencent.shadow.dynamic.host.PluginProcessService;
import java.io.File;

public class HuayangPluginContainer
  extends Step
{
  private static final int a = Runtime.getRuntime().availableProcessors();
  private static final int b = a + 1;
  private static final int c = a * 2 + 1;
  
  protected boolean doStep()
  {
    if (new File("/data/local/tmp/troophomework.debug").exists())
    {
      Toast.makeText(BaseApplicationImpl.getContext(), "waitForDebugger", 1).show();
      Debug.waitForDebugger();
    }
    LoggerFactory.setILoggerFactory(aszd.a());
    BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(PluginProcessService.getActivityHolder());
    DynamicRuntime.recoveryRuntime(BaseApplicationImpl.getContext());
    atdh.d();
    azoa localazoa = new azoa(BaseApplicationImpl.getApplication());
    URLDrawable.init(BaseApplicationImpl.getApplication(), localazoa);
    new InitUrlDrawable().step();
    new InitMemoryCache().step();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.HuayangPluginContainer
 * JD-Core Version:    0.7.0.1
 */