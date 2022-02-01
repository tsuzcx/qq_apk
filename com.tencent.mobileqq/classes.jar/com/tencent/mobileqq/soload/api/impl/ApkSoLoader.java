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
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("envSwitch", 4);
  private SoLoaderLogic jdField_a_of_type_ComTencentMobileqqSoloadApiImplSoLoaderLogic = new SoLoaderLogic();
  
  private boolean b(String paramString)
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
        if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
          return null;
        }
        localObject1 = paramLoadParam.mLoadItems;
        int i = 0;
        localObject1 = (LoadParam.LoadItem)((List)localObject1).get(0);
        if ((localObject1 != null) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(((LoadParam.LoadItem)localObject1).name, false)))
        {
          QLog.d("SoLoadWidget.ApkSoLoader", 2, "<<<<<<<load so from local<<<<<<<");
          if (!b(((LoadParam.LoadItem)localObject1).name)) {
            i = 6;
          }
          return LoadExtResult.create(i, 1, ((LoadParam.LoadItem)localObject1).name, SoLoadInfo.sDefault, ((LoadParam.LoadItem)localObject1).lops);
        }
        QLog.d("SoLoadWidget.ApkSoLoader", 2, "<<<<<<<load so not from local<<<<<<<");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplSoLoaderLogic;
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
      if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
        return;
      }
      Object localObject = paramLoadParam.mLoadItems;
      int i = 0;
      localObject = (LoadParam.LoadItem)((List)localObject).get(0);
      if ((localObject != null) && (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(((LoadParam.LoadItem)localObject).name, false)))
      {
        QLog.d("SoLoadWidget.ApkSoLoader", 2, "<<<<<<<load so from local<<<<<<<");
        if (!b(((LoadParam.LoadItem)localObject).name)) {
          i = 6;
        }
        paramOnLoadListener.onLoadResult(i, LoadExtResult.create(i, 1, ((LoadParam.LoadItem)localObject).name, SoLoadInfo.sDefault, ((LoadParam.LoadItem)localObject).lops));
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplSoLoaderLogic != null)
      {
        QLog.d("SoLoadWidget.ApkSoLoader", 2, "<<<<<<<load so not from local<<<<<<<");
        this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplSoLoaderLogic.a(paramLoadParam, paramOnLoadListener);
      }
    }
  }
  
  public void a(String paramString)
  {
    SoLoaderLogic localSoLoaderLogic = this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplSoLoaderLogic;
    if (localSoLoaderLogic != null) {
      localSoLoaderLogic.a(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.ApkSoLoader
 * JD-Core Version:    0.7.0.1
 */