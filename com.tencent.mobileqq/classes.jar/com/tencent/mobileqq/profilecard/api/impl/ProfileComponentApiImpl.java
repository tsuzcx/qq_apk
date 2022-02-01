package com.tencent.mobileqq.profilecard.api.impl;

import android.util.SparseArray;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileComponentApi;
import com.tencent.mobileqq.profilecard.base.component.AbsProfileComponent;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.collector.IProfileComponentCollector;
import com.tencent.mobileqq.profilecard.collector.ProfileComponentCollector;
import com.tencent.mobileqq.profilecard.collector.TempProfileComponentCollector;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qqexpand.profilecard.ExpandComponentCollector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProfileComponentApiImpl
  implements IProfileComponentApi
{
  private static final String TAG = "ProfileComponentApiImpl";
  @ConfigInject(configPath="Business/profilecard-impl/src/main/resources/Inject_ProfileComponentCollector.yml", version=1)
  public static ArrayList<Class<? extends IProfileComponentCollector>> sInjectCollectorClasses = new ArrayList();
  private final AtomicBoolean componentArrayInit = new AtomicBoolean(false);
  private final SparseArray<Class<? extends AbsProfileComponent>> profileComponentArray = new SparseArray();
  
  static
  {
    sInjectCollectorClasses.add(ProfileComponentCollector.class);
    sInjectCollectorClasses.add(TempProfileComponentCollector.class);
    sInjectCollectorClasses.add(ExpandComponentCollector.class);
  }
  
  private AbsProfileComponent createInner(int paramInt, IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo, IProfileActivityDelegate paramIProfileActivityDelegate)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileComponentApiImpl", 2, String.format("create componentType=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    AbsProfileComponent localAbsProfileComponent = ((IProfileCardBusinessApi)QRoute.api(IProfileCardBusinessApi.class)).createVasProfileComponent(paramInt, paramIComponentCenter, paramProfileCardInfo);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileComponentApiImpl", 2, String.format("create from vas component factory. component=%s", new Object[] { localAbsProfileComponent }));
    }
    Object localObject = localAbsProfileComponent;
    if (localAbsProfileComponent == null)
    {
      try
      {
        paramIComponentCenter = (AbsProfileComponent)((Class)this.profileComponentArray.get(paramInt)).getConstructor(new Class[] { IComponentCenter.class, ProfileCardInfo.class }).newInstance(new Object[] { paramIComponentCenter, paramProfileCardInfo });
      }
      catch (Exception paramIComponentCenter)
      {
        QLog.e("ProfileComponentApiImpl", 1, "create component fail.", paramIComponentCenter);
        paramIComponentCenter = localAbsProfileComponent;
      }
      localObject = paramIComponentCenter;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileComponentApiImpl", 2, String.format("create from base component factory. component=%s", new Object[] { paramIComponentCenter }));
        localObject = paramIComponentCenter;
      }
    }
    if (localObject != null) {
      ((AbsProfileComponent)localObject).setProfileActivityDelegate(paramIProfileActivityDelegate);
    }
    return localObject;
  }
  
  private void initProfileComponentArray()
  {
    this.profileComponentArray.clear();
    Iterator localIterator = sInjectCollectorClasses.iterator();
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      int i = 0;
      if (!bool) {
        break;
      }
      Object localObject = (Class)localIterator.next();
      SparseArray localSparseArray;
      try
      {
        localObject = (IProfileComponentCollector)((Class)localObject).getConstructor(new Class[0]).newInstance(new Object[0]);
      }
      catch (Exception localException)
      {
        QLog.d("ProfileComponentApiImpl", 1, "initProfileComponentMap create collector fail.", localException);
        localSparseArray = null;
      }
      if (localSparseArray != null)
      {
        localSparseArray = localSparseArray.collect();
        if ((localSparseArray != null) && (localSparseArray.size() > 0))
        {
          int j = localSparseArray.size();
          while (i < j)
          {
            int k = localSparseArray.keyAt(i);
            this.profileComponentArray.put(k, localSparseArray.get(k));
            i += 1;
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileComponentApiImpl", 2, String.format("initProfileComponentArray size=%s", new Object[] { Integer.valueOf(this.profileComponentArray.size()) }));
    }
  }
  
  public AbsProfileComponent create(int paramInt, IComponentCenter paramIComponentCenter, ProfileCardInfo paramProfileCardInfo, IProfileActivityDelegate paramIProfileActivityDelegate)
  {
    if (!this.componentArrayInit.get())
    {
      this.componentArrayInit.set(true);
      initProfileComponentArray();
    }
    return createInner(paramInt, paramIComponentCenter, paramProfileCardInfo, paramIProfileActivityDelegate);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.api.impl.ProfileComponentApiImpl
 * JD-Core Version:    0.7.0.1
 */