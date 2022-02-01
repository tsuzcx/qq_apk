package com.tencent.mobileqq.search.rich;

import com.tencent.ark.ark;
import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.ark.Container;
import com.tencent.ark.ark.ModuleRegister;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppDataReport;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.api.IArkAppLifeEvent;
import com.tencent.mobileqq.ark.api.IArkSecureReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ArkAppCallBackHandler
  implements ark.ApplicationCallback, ArkAppModule.ArkAppModuleEvent
{
  private ArrayList<WeakReference<IRichNode>> a = new ArrayList();
  
  private IRichNode a(long paramLong)
  {
    ark.Container localContainer = ark.arkGetContainer(paramLong);
    if (localContainer == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkNodeContainer", 2, "getArkNode, arkcontainer is null");
      }
      return null;
    }
    if (this.a.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkNodeContainer", 2, "getArkNode, list is null");
      }
      return null;
    }
    int i = 0;
    while (i < this.a.size())
    {
      IRichNode localIRichNode = (IRichNode)((WeakReference)this.a.get(i)).get();
      ArkNodeContainer localArkNodeContainer;
      if ((localIRichNode != null) && ((localIRichNode instanceof ArkRichNode))) {
        localArkNodeContainer = ((ArkRichNode)localIRichNode).b();
      } else {
        localArkNodeContainer = null;
      }
      if ((localArkNodeContainer != null) && (localArkNodeContainer.getContainer() == localContainer)) {
        return localIRichNode;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkNodeContainer", 2, "getArkNode, not found");
    }
    return null;
  }
  
  public void AppCreate(ark.Application paramApplication)
  {
    paramApplication = paramApplication.GetSpecific("appName");
    ((IArkAppLifeEvent)QRoute.api(IArkAppLifeEvent.class)).doAction(0, paramApplication, null);
  }
  
  public void AppDestroy(ark.Application paramApplication)
  {
    paramApplication = paramApplication.GetSpecific("appName");
    ((IArkAppLifeEvent)QRoute.api(IArkAppLifeEvent.class)).doAction(1, paramApplication, null);
    ((IArkSecureReport)QRoute.api(IArkSecureReport.class)).reportAccumulatedValidURL(paramApplication);
  }
  
  public boolean CheckUrlLegalityCallback(ark.Application paramApplication, String paramString)
  {
    paramApplication = paramApplication.GetSpecific("appName");
    ArkAppUrlChecker localArkAppUrlChecker = ArkAppConfigMgr.getInstance().getUrlChecker(paramApplication);
    boolean bool;
    if (localArkAppUrlChecker != null)
    {
      int j = localArkAppUrlChecker.checkUrlIsValidByAppResouceList(paramString);
      if (j == 0) {
        bool = true;
      } else {
        bool = false;
      }
      int i;
      if (!bool)
      {
        if (!ArkAppConfigMgr.getInstance().isUrlCheckEnable(paramApplication))
        {
          QLog.e("ArkNodeContainer", 1, new Object[] { "ArkSafe.UrlCheck.setDisable.EngineCallback seach appName=", paramApplication, ",url=", Util.b(paramString, new String[0]), ", isValid set=true" });
          i = 2;
          bool = true;
        }
        else
        {
          i = 1;
        }
      }
      else {
        i = 0;
      }
      ((IArkSecureReport)QRoute.api(IArkSecureReport.class)).reportResourceURLAccess(paramApplication, paramString, j, i, "");
    }
    else
    {
      bool = true;
    }
    QLog.e("ArkNodeContainer", 1, new Object[] { "ArkSafe.EngineCallback search appName=", paramApplication, ",url=", Util.b(paramString, new String[0]), ", isValid=", Boolean.valueOf(bool) });
    return bool;
  }
  
  public void OutputScriptError(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    if (paramString2 == null) {
      paramString2 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.e("ArkNodeContainer", 2, String.format("%s.script error: %s", new Object[] { paramString1, paramString2 }));
    }
    ArkAppDataReport.a(null, paramString1, "ScriptError", 0, 0, 0L, 0L, 0L, paramString2, "");
  }
  
  public void RegisterModules(ark.ModuleRegister paramModuleRegister, ark.Application paramApplication)
  {
    ((IArkAPIService)QRoute.api(IArkAPIService.class)).registerModules(paramModuleRegister, paramApplication);
    paramApplication = new ArkAppModule(paramApplication, 0);
    paramApplication.a(this);
    paramApplication.a((List)ArkAiAppCenter.d.get(paramApplication.GetTypeName()));
    paramModuleRegister.RegCallbackWrapper(paramApplication);
  }
  
  public void a(long paramLong, String paramString)
  {
    IRichNode localIRichNode = a(paramLong);
    if ((localIRichNode != null) && ((localIRichNode instanceof ArkRichNode))) {
      ((ArkRichNode)localIRichNode).a(paramString);
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onNotify, KEY：");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" VALUE:");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("ArkNodeContainer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramLong);
    if ((localObject != null) && ((localObject instanceof ArkRichNode))) {
      ((ArkRichNode)localObject).a(paramString1, paramString2);
    }
  }
  
  public void a(ArkRichNode paramArkRichNode)
  {
    if (paramArkRichNode == null) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((WeakReference)localIterator.next()).get() == paramArkRichNode) {
        return;
      }
    }
    this.a.add(new WeakReference(paramArkRichNode));
  }
  
  public void b(ArkRichNode paramArkRichNode)
  {
    if (paramArkRichNode == null) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() == paramArkRichNode) {
        this.a.remove(localWeakReference);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkAppCallBackHandler
 * JD-Core Version:    0.7.0.1
 */