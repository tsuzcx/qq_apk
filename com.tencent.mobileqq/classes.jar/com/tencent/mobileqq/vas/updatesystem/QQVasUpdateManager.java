package com.tencent.mobileqq.vas.updatesystem;

import com.tencent.mobileqq.qqgift.updatasystem.QQGiftResourceBusiness;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.vas.updatesystem.business.GameNamePlateBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.NativeUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.QQValueViewBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.TestUpdateBusinessV2;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.XAResBusiness;
import com.tencent.mobileqq.vas.updatesystem.impl.VasUpdateFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.business.VasBusinessManager;
import com.tencent.vas.update.factory.api.IVasUpdateFactory;
import cooperation.qzone.util.JarReflectUtil;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.manager.Manager;

public class QQVasUpdateManager
  extends VasBusinessManager
  implements Manager
{
  @ConfigInject(configPath="Business/vas-temp-api/src/main/resources/Inject_QQVasUpdateBusiness.yml", version=1)
  public static ArrayList<Class<? extends BaseUpdateBusiness>> a = new ArrayList();
  private VasUpdateFactory d;
  
  static
  {
    a.add(TroopNickNameBusiness.class);
    a.add(QQValueViewBusiness.class);
    a.add(XAResBusiness.class);
    a.add(TestUpdateBusinessV2.class);
    a.add(QQGiftResourceBusiness.class);
    a.add(GameNamePlateBusiness.class);
  }
  
  public static BaseUpdateBusiness[] a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getInjectArray size = ");
    ((StringBuilder)localObject1).append(a.size());
    QLog.i("VasUpdate_QQVasUpdateManager", 1, ((StringBuilder)localObject1).toString());
    if (a.isEmpty()) {
      return new BaseUpdateBusiness[] { new TroopNickNameBusiness(), new QQValueViewBusiness(), new XAResBusiness(), new TestUpdateBusinessV2(), new GameNamePlateBusiness(), new QQGiftResourceBusiness() };
    }
    localObject1 = new ArrayList();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      Class localClass = (Class)localIterator.next();
      if (localClass != null)
      {
        Object localObject2 = JarReflectUtil.creatSpecifiedObject(localClass.getName(), null, null);
        if (localObject2 != null)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("inject class name = ");
            localStringBuilder.append(localClass.getName());
            QLog.i("VasUpdate_QQVasUpdateManager", 2, localStringBuilder.toString());
          }
          ((ArrayList)localObject1).add((BaseUpdateBusiness)localObject2);
        }
        else
        {
          QLog.e("VasUpdate_QQVasUpdateManager", 1, "current inject clsss get static field fail ， object = null");
        }
      }
    }
    return (BaseUpdateBusiness[])((ArrayList)localObject1).toArray(new BaseUpdateBusiness[((ArrayList)localObject1).size()]);
  }
  
  protected BaseUpdateBusiness b()
  {
    return new NativeUpdateBusiness();
  }
  
  public BaseUpdateBusiness[] c()
  {
    return a();
  }
  
  protected IVasUpdateFactory d()
  {
    this.d = new VasUpdateFactory();
    return this.d;
  }
  
  public VasUpdateFactory e()
  {
    return this.d;
  }
  
  public void onDestroy()
  {
    QLog.e("VasUpdate_QQVasUpdateManager", 1, "onDestroy");
    super.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.QQVasUpdateManager
 * JD-Core Version:    0.7.0.1
 */