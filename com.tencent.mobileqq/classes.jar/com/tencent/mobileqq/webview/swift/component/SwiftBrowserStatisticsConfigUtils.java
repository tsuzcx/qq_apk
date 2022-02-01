package com.tencent.mobileqq.webview.swift.component;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.WVStatisticsConfBean;
import java.util.ArrayList;

public class SwiftBrowserStatisticsConfigUtils
{
  public static final ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject = (WVStatisticsConfBean)QConfigManager.a().a(361);
      if ((localObject != null) && (!TextUtils.isEmpty(((WVStatisticsConfBean)localObject).d))) {
        localObject = ((WVStatisticsConfBean)localObject).d;
      } else {
        localObject = "QQ";
      }
      localObject = ((String)localObject).split(";");
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(localObject[i]);
        i += 1;
      }
      return localArrayList;
    }
    catch (Throwable localThrowable) {}
    return localArrayList;
  }
  
  public static final boolean a(int paramInt, boolean paramBoolean)
  {
    WVStatisticsConfBean localWVStatisticsConfBean = (WVStatisticsConfBean)QConfigManager.a().a(361);
    boolean bool = paramBoolean;
    if (localWVStatisticsConfBean != null)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return paramBoolean;
          }
          return localWVStatisticsConfBean.jdField_c_of_type_Boolean;
        }
        return localWVStatisticsConfBean.jdField_b_of_type_Boolean;
      }
      bool = localWVStatisticsConfBean.jdField_a_of_type_Boolean;
    }
    return bool;
  }
  
  public static final boolean b(int paramInt, boolean paramBoolean)
  {
    WVStatisticsConfBean localWVStatisticsConfBean = (WVStatisticsConfBean)QConfigManager.a().a(361);
    if (localWVStatisticsConfBean != null) {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if ((paramInt == 4) && (Math.random() < Float.valueOf(localWVStatisticsConfBean.jdField_c_of_type_JavaLangString).floatValue())) {
            return true;
          }
        }
        else if (Math.random() < Float.valueOf(localWVStatisticsConfBean.jdField_b_of_type_JavaLangString).floatValue()) {
          return true;
        }
      }
      else if (Math.random() < Float.valueOf(localWVStatisticsConfBean.jdField_a_of_type_JavaLangString).floatValue()) {
        return true;
      }
    }
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatisticsConfigUtils
 * JD-Core Version:    0.7.0.1
 */