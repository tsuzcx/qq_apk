package com.tencent.mobileqq.search.rich;

import com.tencent.ark.ark.Application;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.api.module.ArkAppQQModuleBase;
import com.tencent.mobileqq.ark.module.ArkModuleMethod;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.report.UniteSearchReportController;
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
  
  protected boolean a(ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localQQAppInterface == null) {
      return false;
    }
    String str2 = localQQAppInterface.getCurrentAccountUin();
    Object localObject1 = paramArrayOfVariantWrapper[0].GetString();
    paramVariantWrapper = paramArrayOfVariantWrapper[1].GetString();
    String str1 = "";
    Object localObject2 = str1;
    int j = 0;
    int i = 0;
    long l2 = 0L;
    long l1 = 0L;
    int k = 0;
    while (k < paramArrayOfVariantWrapper.length)
    {
      if (k == 0) {
        localObject1 = paramArrayOfVariantWrapper[0].GetString();
      }
      Object localObject3;
      ark.VariantWrapper localVariantWrapper;
      int m;
      int n;
      long l3;
      long l4;
      Object localObject4;
      for (;;)
      {
        localObject3 = localObject1;
        localVariantWrapper = paramVariantWrapper;
        m = j;
        n = i;
        l3 = l2;
        l4 = l1;
        localObject4 = localObject2;
        break label355;
        if (k == 1)
        {
          paramVariantWrapper = paramArrayOfVariantWrapper[1].GetString();
        }
        else if (k == 2)
        {
          j = a(paramArrayOfVariantWrapper[2], 0);
        }
        else
        {
          if (k != 3) {
            break;
          }
          i = a(paramArrayOfVariantWrapper[3], 0);
        }
      }
      if (k == 4)
      {
        l3 = a(paramArrayOfVariantWrapper[4], 0L);
        localObject3 = localObject1;
        localVariantWrapper = paramVariantWrapper;
        m = j;
        n = i;
        l4 = l1;
        localObject4 = localObject2;
      }
      else if (k == 5)
      {
        l4 = a(paramArrayOfVariantWrapper[5], 0L);
        localObject3 = localObject1;
        localVariantWrapper = paramVariantWrapper;
        m = j;
        n = i;
        l3 = l2;
        localObject4 = localObject2;
      }
      else if (k == 6)
      {
        localObject4 = paramArrayOfVariantWrapper[6].GetString();
        localObject3 = localObject1;
        localVariantWrapper = paramVariantWrapper;
        m = j;
        n = i;
        l3 = l2;
        l4 = l1;
      }
      else
      {
        localObject3 = localObject1;
        localVariantWrapper = paramVariantWrapper;
        m = j;
        n = i;
        l3 = l2;
        l4 = l1;
        localObject4 = localObject2;
        if (k == 7)
        {
          str1 = paramArrayOfVariantWrapper[7].GetString();
          localObject4 = localObject2;
          l4 = l1;
          l3 = l2;
          n = i;
          m = j;
          localVariantWrapper = paramVariantWrapper;
          localObject3 = localObject1;
        }
      }
      label355:
      k += 1;
      localObject1 = localObject3;
      paramVariantWrapper = localVariantWrapper;
      j = m;
      i = n;
      l2 = l3;
      l1 = l4;
      localObject2 = localObject4;
    }
    if ((!"0X8009D41".equals(paramVariantWrapper)) && (!"0X8009D2D".equals(paramVariantWrapper))) {
      break label419;
    }
    str1 = UniteSearchReportController.b();
    label419:
    ReportController.b(localQQAppInterface, "CliOper", "", str2, (String)localObject1, paramVariantWrapper, j, i, String.valueOf(l2), String.valueOf(l1), (String)localObject2, str1);
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
  
  public boolean c()
  {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkAppModule
 * JD-Core Version:    0.7.0.1
 */