package com.tencent.mobileqq.soload.api.impl;

import android.content.SharedPreferences;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

public class ApkSoLoader
  implements ISoLoader
{
  private SoLoaderLogic a = new SoLoaderLogic();
  private SharedPreferences b = MobileQQ.sMobileQQ.getSharedPreferences("envSwitch", 4);
  
  private boolean c(String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[doLoadSo]load local debug so succ :");
        localStringBuilder.append(paramString);
        QLog.i("SoLoadWidget.ApkSoLoader", 2, localStringBuilder.toString());
      }
      return true;
    }
    catch (Throwable paramString)
    {
      label43:
      break label43;
    }
    return false;
  }
  
  public LoadExtResult a(LoadParam paramLoadParam)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramLoadParam != null)
    {
      localObject1 = localObject2;
      if (paramLoadParam.mLoadItems != null)
      {
        if (this.b == null) {
          return null;
        }
        localObject1 = paramLoadParam.mLoadItems;
        int i = 0;
        localObject1 = (LoadParam.LoadItem)((List)localObject1).get(0);
        if ((localObject1 != null) && (this.b.getBoolean(((LoadParam.LoadItem)localObject1).name, false)))
        {
          QLog.d("SoLoadWidget.ApkSoLoader", 2, "<<<<<<<load so from local<<<<<<<");
          if (!c(((LoadParam.LoadItem)localObject1).name)) {
            i = 6;
          }
          return LoadExtResult.create(i, 1, ((LoadParam.LoadItem)localObject1).name, SoLoadInfo.sDefault, ((LoadParam.LoadItem)localObject1).lops);
        }
        QLog.d("SoLoadWidget.ApkSoLoader", 2, "<<<<<<<load so not from local<<<<<<<");
        localObject1 = this.a;
        if (localObject1 == null) {
          return null;
        }
        localObject1 = ((SoLoaderLogic)localObject1).a(paramLoadParam);
      }
    }
    return localObject1;
  }
  
  public void a(LoadParam paramLoadParam, OnLoadListener paramOnLoadListener)
  {
    if ((paramLoadParam != null) && (paramLoadParam.mLoadItems != null))
    {
      if (this.b == null) {
        return;
      }
      Object localObject = paramLoadParam.mLoadItems;
      int i = 0;
      localObject = (LoadParam.LoadItem)((List)localObject).get(0);
      if ((localObject != null) && (this.b.getBoolean(((LoadParam.LoadItem)localObject).name, false)))
      {
        QLog.d("SoLoadWidget.ApkSoLoader", 2, "<<<<<<<load so from local<<<<<<<");
        if (!c(((LoadParam.LoadItem)localObject).name)) {
          i = 6;
        }
        paramOnLoadListener.onLoadResult(i, LoadExtResult.create(i, 1, ((LoadParam.LoadItem)localObject).name, SoLoadInfo.sDefault, ((LoadParam.LoadItem)localObject).lops));
        return;
      }
      if (this.a != null)
      {
        QLog.d("SoLoadWidget.ApkSoLoader", 2, "<<<<<<<load so not from local<<<<<<<");
        this.a.a(paramLoadParam, paramOnLoadListener);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  public void b(String paramString)
  {
    SoLoaderLogic localSoLoaderLogic = this.a;
    if (localSoLoaderLogic != null) {
      localSoLoaderLogic.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.ApkSoLoader
 * JD-Core Version:    0.7.0.1
 */