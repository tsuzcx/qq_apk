package com.tencent.mobileqq.logic;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import mqq.util.WeakReference;

class TabDataHandler$LoadTabDataRunnable
  implements Runnable
{
  private final WeakReference<TabDataHandler> a;
  
  public TabDataHandler$LoadTabDataRunnable(TabDataHandler paramTabDataHandler)
  {
    this.a = new WeakReference(paramTabDataHandler);
  }
  
  public void run()
  {
    TabDataHandler localTabDataHandler = (TabDataHandler)this.a.get();
    if (localTabDataHandler == null)
    {
      QLog.i("TabDataHandler", 1, "LoadTabDataRunnable handler is null");
      return;
    }
    Object localObject = localTabDataHandler.b;
    if (localObject == null)
    {
      QLog.i("TabDataHandler", 1, "LoadTabDataRunnable app is null");
      return;
    }
    QLog.i("TabDataHandler", 1, "loadTabData");
    localObject = ((AppInterface)localObject).getCurrentAccountUin();
    localObject = TabDataHelper.getTabLocalSwitch(BaseApplication.getContext(), (String)localObject);
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      localTabDataHandler.a((Map)localObject, true);
      return;
    }
    localTabDataHandler.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.logic.TabDataHandler.LoadTabDataRunnable
 * JD-Core Version:    0.7.0.1
 */