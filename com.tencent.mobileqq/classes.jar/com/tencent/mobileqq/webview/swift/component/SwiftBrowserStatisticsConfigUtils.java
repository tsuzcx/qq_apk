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
    for (;;)
    {
      try
      {
        Object localObject = (WVStatisticsConfBean)QConfigManager.a().a(361);
        if ((localObject != null) && (!TextUtils.isEmpty(((WVStatisticsConfBean)localObject).d)))
        {
          localObject = ((WVStatisticsConfBean)localObject).d;
          localObject = ((String)localObject).split(";");
          int j = localObject.length;
          int i = 0;
          if (i < j)
          {
            localArrayList.add(localObject[i]);
            i += 1;
            continue;
          }
          return localArrayList;
        }
      }
      catch (Throwable localThrowable) {}
      String str = "QQ";
    }
  }
  
  public static final boolean a(int paramInt, boolean paramBoolean)
  {
    WVStatisticsConfBean localWVStatisticsConfBean = (WVStatisticsConfBean)QConfigManager.a().a(361);
    if (localWVStatisticsConfBean != null) {}
    switch (paramInt)
    {
    default: 
      return paramBoolean;
    case 1: 
      return localWVStatisticsConfBean.jdField_a_of_type_Boolean;
    case 2: 
      return localWVStatisticsConfBean.jdField_b_of_type_Boolean;
    }
    return localWVStatisticsConfBean.jdField_c_of_type_Boolean;
  }
  
  public static final boolean b(int paramInt, boolean paramBoolean)
  {
    WVStatisticsConfBean localWVStatisticsConfBean = (WVStatisticsConfBean)QConfigManager.a().a(361);
    if (localWVStatisticsConfBean != null) {
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return paramBoolean;
        } while (Math.random() >= Float.valueOf(localWVStatisticsConfBean.jdField_a_of_type_JavaLangString).floatValue());
        return true;
      } while (Math.random() >= Float.valueOf(localWVStatisticsConfBean.jdField_b_of_type_JavaLangString).floatValue());
      return true;
    } while (Math.random() >= Float.valueOf(localWVStatisticsConfBean.jdField_c_of_type_JavaLangString).floatValue());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatisticsConfigUtils
 * JD-Core Version:    0.7.0.1
 */