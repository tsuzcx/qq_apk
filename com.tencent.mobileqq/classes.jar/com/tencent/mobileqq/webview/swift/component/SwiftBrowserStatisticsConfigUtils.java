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
      Object localObject = (WVStatisticsConfBean)QConfigManager.b().b(361);
      if ((localObject != null) && (!TextUtils.isEmpty(((WVStatisticsConfBean)localObject).g))) {
        localObject = ((WVStatisticsConfBean)localObject).g;
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
    WVStatisticsConfBean localWVStatisticsConfBean = (WVStatisticsConfBean)QConfigManager.b().b(361);
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
          return localWVStatisticsConfBean.c;
        }
        return localWVStatisticsConfBean.b;
      }
      bool = localWVStatisticsConfBean.a;
    }
    return bool;
  }
  
  public static final boolean b(int paramInt, boolean paramBoolean)
  {
    WVStatisticsConfBean localWVStatisticsConfBean = (WVStatisticsConfBean)QConfigManager.b().b(361);
    if (localWVStatisticsConfBean != null) {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if ((paramInt == 4) && (Math.random() < Float.valueOf(localWVStatisticsConfBean.f).floatValue())) {
            return true;
          }
        }
        else if (Math.random() < Float.valueOf(localWVStatisticsConfBean.e).floatValue()) {
          return true;
        }
      }
      else if (Math.random() < Float.valueOf(localWVStatisticsConfBean.d).floatValue()) {
        return true;
      }
    }
    return paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatisticsConfigUtils
 * JD-Core Version:    0.7.0.1
 */