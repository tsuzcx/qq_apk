package com.tencent.mobileqq.config;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.ServerConfigObserver;
import protocol.KQQConfig.GetResourceRespInfoV2;
import protocol.KQQConfig.GetResourceRespV2;

class AboutConfig$2
  extends ServerConfigObserver
{
  AboutConfig$2(AboutConfig paramAboutConfig) {}
  
  public void onGetPluginConfig(boolean paramBoolean, int paramInt, GetResourceRespV2 paramGetResourceRespV2)
  {
    if ((paramInt & 0x20) == 0) {
      return;
    }
    int i = 0;
    int k = 0;
    paramInt = i;
    if (paramBoolean)
    {
      paramInt = i;
      if (paramGetResourceRespV2 != null)
      {
        Object localObject1 = AboutConfig.a(this.a).getEntityManagerFactory().createEntityManager();
        Object localObject2 = paramGetResourceRespV2.vecAddedResInfo.iterator();
        paramInt = 0;
        i = 0;
        int j = 0;
        GetResourceRespInfoV2 localGetResourceRespInfoV2;
        while (((Iterator)localObject2).hasNext())
        {
          localGetResourceRespInfoV2 = (GetResourceRespInfoV2)((Iterator)localObject2).next();
          if ((localGetResourceRespInfoV2.iPluginType == 32) && ((localGetResourceRespInfoV2.sResSubType == 0) || (localGetResourceRespInfoV2.sResSubType == 2))) {
            if (ConfigManager.a((EntityManager)localObject1, AboutConfig.a(this.a), localGetResourceRespInfoV2).cDefaultState == 0)
            {
              paramInt = 1;
              i = 1;
              j = 1;
            }
            else
            {
              paramInt = 1;
              i = 1;
            }
          }
        }
        localObject2 = paramGetResourceRespV2.vecDeletedResInfo.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localGetResourceRespInfoV2 = (GetResourceRespInfoV2)((Iterator)localObject2).next();
          if ((localGetResourceRespInfoV2.iPluginType == 32) && ((localGetResourceRespInfoV2.sResSubType == 0) || (localGetResourceRespInfoV2.sResSubType == 2)))
          {
            ResourcePluginInfo.remove((EntityManager)localObject1, localGetResourceRespInfoV2.strPkgName);
            paramInt = 1;
          }
        }
        paramGetResourceRespV2 = paramGetResourceRespV2.vecUpdatedResInfo.iterator();
        while (paramGetResourceRespV2.hasNext())
        {
          localObject2 = (GetResourceRespInfoV2)paramGetResourceRespV2.next();
          if ((((GetResourceRespInfoV2)localObject2).iPluginType == 32) && ((((GetResourceRespInfoV2)localObject2).sResSubType == 0) || (((GetResourceRespInfoV2)localObject2).sResSubType == 2)))
          {
            ConfigManager.a((EntityManager)localObject1, AboutConfig.a(this.a), (GetResourceRespInfoV2)localObject2);
            paramInt = 1;
          }
        }
        ((EntityManager)localObject1).close();
        this.a.a(true, false);
        if (paramInt != 0)
        {
          paramGetResourceRespV2 = new ArrayList(AboutConfig.a(this.a)).iterator();
          while (paramGetResourceRespV2.hasNext())
          {
            localObject1 = (ResourcePluginListener)paramGetResourceRespV2.next();
            if (i != 0)
            {
              ResourcePluginListener.a((ResourcePluginListener)localObject1, (byte)3, 2);
              if (j != 0)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("AboutConfig", 2, "inform STATE_NEW_OPEN_PLUGIN");
                }
                ResourcePluginListener.a((ResourcePluginListener)localObject1, (byte)4, 2);
              }
            }
            else
            {
              ResourcePluginListener.a((ResourcePluginListener)localObject1, (byte)2, 2);
            }
          }
        }
      }
    }
    for (;;)
    {
      if (k < AboutConfig.a(this.a).size()) {}
      try
      {
        ResourcePluginListener.a((ResourcePluginListener)AboutConfig.a(this.a).get(k), (byte)1, 2);
        k += 1;
        continue;
        if (paramInt >= AboutConfig.a(this.a).size()) {}
      }
      catch (Exception paramGetResourceRespV2)
      {
        try
        {
          for (;;)
          {
            ResourcePluginListener.a((ResourcePluginListener)AboutConfig.a(this.a).get(paramInt), (byte)-1, 2);
            label499:
            paramInt += 1;
          }
          return;
          paramGetResourceRespV2 = paramGetResourceRespV2;
        }
        catch (Exception paramGetResourceRespV2)
        {
          break label499;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.AboutConfig.2
 * JD-Core Version:    0.7.0.1
 */