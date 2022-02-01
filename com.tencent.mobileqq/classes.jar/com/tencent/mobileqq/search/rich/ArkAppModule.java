package com.tencent.mobileqq.search.rich;

import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.api.module.ArkAppQQModuleBase;
import com.tencent.mobileqq.ark.module.ArkModuleMethod;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;

public class ArkAppModule
  extends ArkAppQQModuleBase
{
  private WeakReference<ArkAppModule.ArkAppModuleEvent> a;
  
  public ArkAppModule(ark.Application paramApplication, int paramInt)
  {
    super(paramApplication, paramInt);
  }
  
  private int a(ark.VariantWrapper paramVariantWrapper, int paramInt)
  {
    if (paramVariantWrapper == null) {
      return paramInt;
    }
    int i = paramVariantWrapper.GetType();
    if (i == 4) {
      return (int)paramVariantWrapper.GetDouble();
    }
    if (i == 3) {
      return paramVariantWrapper.GetInt();
    }
    return paramInt;
  }
  
  private long a(ark.VariantWrapper paramVariantWrapper, long paramLong)
  {
    if (paramVariantWrapper == null) {
      return paramLong;
    }
    int i = paramVariantWrapper.GetType();
    if (i == 4) {
      return paramVariantWrapper.GetDouble();
    }
    if (i == 3) {
      return paramVariantWrapper.GetInt();
    }
    return paramLong;
  }
  
  private String a(ark.VariantWrapper paramVariantWrapper, String paramString)
  {
    if (paramVariantWrapper == null) {
      return paramString;
    }
    int i = paramVariantWrapper.GetType();
    if (i == 5) {
      return paramVariantWrapper.GetString();
    }
    if (i == 6) {
      return paramVariantWrapper.GetTableAsJsonString();
    }
    return paramString;
  }
  
  public void Destruct()
  {
    super.Destruct();
  }
  
  public String GetTypeName()
  {
    return "QQSearch";
  }
  
  public boolean HasMethod(String paramString)
  {
    if (paramString.equals("Report")) {
      return true;
    }
    if (paramString.equals("GetContainerInfo")) {
      return false;
    }
    if (paramString.equals("SetTalkBackText")) {
      return true;
    }
    return paramString.equals("Notify");
  }
  
  public boolean Invoke(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    boolean bool2 = a(paramString);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (paramString.equals("Report")) {
      return a(paramArrayOfVariantWrapper, paramVariantWrapper);
    }
    if (paramString.equals("SetTalkBackText")) {
      return b(paramArrayOfVariantWrapper, paramVariantWrapper);
    }
    if (paramString.equals("Notify")) {
      bool1 = c(paramArrayOfVariantWrapper, paramVariantWrapper);
    }
    return bool1;
  }
  
  public void a(ArkAppModule.ArkAppModuleEvent paramArkAppModuleEvent)
  {
    this.a = new WeakReference(paramArkAppModuleEvent);
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected boolean a(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localQQAppInterface == null) {
      return false;
    }
    String str = localQQAppInterface.getCurrentAccountUin();
    Object localObject3 = paramArrayOfVariantWrapper[0].GetString();
    Object localObject2 = paramArrayOfVariantWrapper[1].GetString();
    paramVariantWrapper = "";
    Object localObject1 = paramVariantWrapper;
    long l2 = 0L;
    long l1 = l2;
    int k = 0;
    int i = 0;
    int j = 0;
    while (j < paramArrayOfVariantWrapper.length)
    {
      Object localObject4;
      Object localObject5;
      int m;
      int n;
      long l3;
      long l4;
      Object localObject6;
      if (j == 0)
      {
        localObject4 = paramArrayOfVariantWrapper[0].GetString();
        localObject5 = localObject2;
        m = k;
        n = i;
        l3 = l2;
        l4 = l1;
        localObject6 = paramVariantWrapper;
      }
      else if (j == 1)
      {
        localObject5 = paramArrayOfVariantWrapper[1].GetString();
        localObject4 = localObject3;
        m = k;
        n = i;
        l3 = l2;
        l4 = l1;
        localObject6 = paramVariantWrapper;
      }
      else if (j == 2)
      {
        m = a(paramArrayOfVariantWrapper[2], 0);
        localObject4 = localObject3;
        localObject5 = localObject2;
        n = i;
        l3 = l2;
        l4 = l1;
        localObject6 = paramVariantWrapper;
      }
      else if (j == 3)
      {
        n = a(paramArrayOfVariantWrapper[3], 0);
        localObject4 = localObject3;
        localObject5 = localObject2;
        m = k;
        l3 = l2;
        l4 = l1;
        localObject6 = paramVariantWrapper;
      }
      else if (j == 4)
      {
        l3 = a(paramArrayOfVariantWrapper[4], 0L);
        localObject4 = localObject3;
        localObject5 = localObject2;
        m = k;
        n = i;
        l4 = l1;
        localObject6 = paramVariantWrapper;
      }
      else if (j == 5)
      {
        l4 = a(paramArrayOfVariantWrapper[5], 0L);
        localObject4 = localObject3;
        localObject5 = localObject2;
        m = k;
        n = i;
        l3 = l2;
        localObject6 = paramVariantWrapper;
      }
      else if (j == 6)
      {
        localObject6 = paramArrayOfVariantWrapper[6].GetString();
        localObject4 = localObject3;
        localObject5 = localObject2;
        m = k;
        n = i;
        l3 = l2;
        l4 = l1;
      }
      else
      {
        localObject4 = localObject3;
        localObject5 = localObject2;
        m = k;
        n = i;
        l3 = l2;
        l4 = l1;
        localObject6 = paramVariantWrapper;
        if (j == 7)
        {
          localObject1 = paramArrayOfVariantWrapper[7].GetString();
          localObject6 = paramVariantWrapper;
          l4 = l1;
          l3 = l2;
          n = i;
          m = k;
          localObject5 = localObject2;
          localObject4 = localObject3;
        }
      }
      j += 1;
      localObject3 = localObject4;
      localObject2 = localObject5;
      k = m;
      i = n;
      l2 = l3;
      l1 = l4;
      paramVariantWrapper = (ark.VariantWrapper)localObject6;
    }
    ReportController.b(localQQAppInterface, "CliOper", "", str, (String)localObject3, (String)localObject2, k, i, String.valueOf(l2), String.valueOf(l1), paramVariantWrapper, (String)localObject1);
    return true;
  }
  
  protected ArkModuleMethod[] a()
  {
    return null;
  }
  
  public boolean b()
  {
    return true;
  }
  
  protected boolean b(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()) && (paramArrayOfVariantWrapper[1].IsView()))
    {
      paramVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
      long l = paramArrayOfVariantWrapper[1].GetView();
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppModule.1(this, l, paramVariantWrapper));
    }
    return true;
  }
  
  protected boolean c(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length > 3) && (paramArrayOfVariantWrapper[1].IsString()) && (paramArrayOfVariantWrapper[3].IsView()))
    {
      paramVariantWrapper = paramArrayOfVariantWrapper[1].GetString();
      String str = a(paramArrayOfVariantWrapper[2], null);
      long l = paramArrayOfVariantWrapper[3].GetView();
      ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkAppModule.2(this, l, paramVariantWrapper, str));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkAppModule
 * JD-Core Version:    0.7.0.1
 */