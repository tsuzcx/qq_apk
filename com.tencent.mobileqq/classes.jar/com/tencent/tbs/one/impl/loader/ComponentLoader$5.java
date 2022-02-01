package com.tencent.tbs.one.impl.loader;

import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.common.DEPSConfig;
import com.tencent.tbs.one.impl.common.DEPSConfig.ComponentConfig;
import com.tencent.tbs.one.impl.common.Statistics;
import com.tencent.tbs.one.impl.policy.PolicyManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;

class ComponentLoader$5
  implements Runnable
{
  ComponentLoader$5(ComponentLoader paramComponentLoader, String paramString) {}
  
  public void run()
  {
    Object localObject;
    int i;
    if (ComponentLoader.access$400(this.this$0) == null)
    {
      localObject = ComponentLoader.access$500(this.this$0);
      Logging.e("[%s] {%s} Unknown error, finished installing component and dependencies but config is null, last error: [%d] %s", new Object[] { ComponentLoader.access$300(this.this$0).getCategory(), localObject, Integer.valueOf(ComponentLoader.access$600(this.this$0)), ComponentLoader.access$700(this.this$0) });
      DEPSConfig localDEPSConfig = ComponentLoader.access$300(this.this$0).getDEPSConfig();
      if (localDEPSConfig != null)
      {
        i = localDEPSConfig.getVersionCode();
        Statistics.reportError(i, (String)localObject, -1, 101, String.format(Locale.US, "ComponentConfig is null, last error: [%d] %s", new Object[] { Integer.valueOf(ComponentLoader.access$600(this.this$0)), ComponentLoader.access$700(this.this$0) }), null);
      }
    }
    do
    {
      return;
      i = -1;
      break;
      ComponentLoader.access$800(this.this$0, 90);
      localObject = ComponentLoader.access$300(this.this$0).getInstallationDirectory(this.val$name, ComponentLoader.access$400(this.this$0).getVersionCode());
      ComponentLoader.access$900(this.this$0, (File)localObject);
    } while (ComponentLoader.access$1000(this.this$0).size() <= 0);
    ComponentLoader.access$1100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.ComponentLoader.5
 * JD-Core Version:    0.7.0.1
 */