package com.tencent.tbs.one.impl.policy;

import android.content.SharedPreferences;
import com.tencent.tbs.one.impl.base.GlobalUtils;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.loader.ComponentLoader;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class PolicyManagerImpl$1
  implements Runnable
{
  PolicyManagerImpl$1(PolicyManagerImpl paramPolicyManagerImpl) {}
  
  public void run()
  {
    String str = this.this$0.getCategory();
    Logging.i("[%s] Running idle task", new Object[] { str });
    if ((PolicyManagerImpl.access$000(this.this$0) != null) && (PolicyManagerImpl.access$000(this.this$0).isUpdating()))
    {
      Logging.i("[%s] %s in updating", new Object[] { str, "Early out for idle task," });
      PolicyManagerImpl.access$100(this.this$0);
      return;
    }
    Iterator localIterator = this.this$0.getAllLoaders().values().iterator();
    while (localIterator.hasNext()) {
      if (((ComponentLoader)localIterator.next()).isLoading())
      {
        Logging.i("[%s] %s in loading component", new Object[] { str, "Early out for idle task," });
        PolicyManagerImpl.access$100(this.this$0);
        return;
      }
    }
    InstallationUtils.cleanProcDirectory(this.this$0.getCallerContext());
    InstallationUtils.cleanUselessComponents(this.this$0.getCategoryDirectory());
    if (!this.this$0.isAutoUpdateEnabled())
    {
      Logging.i("[%s] %s disabled", new Object[] { str, "Early out for auto update," });
      return;
    }
    if (!this.this$0.useOnlineService())
    {
      Logging.i("[%s] %s not use online service", new Object[] { str, "Early out for auto update," });
      return;
    }
    long l = PolicyManagerImpl.access$200(this.this$0).getLong("last_update_time", 0L);
    if (System.currentTimeMillis() - l < 86400000L)
    {
      Logging.i("[%s] %s the interval is not reached, last update time: %s", new Object[] { str, "Early out for auto update,", GlobalUtils.formatDateTime(l) });
      return;
    }
    this.this$0.doUpdate(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.PolicyManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */