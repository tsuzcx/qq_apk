package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;

public class FileIPv6StrateyController
{
  private static boolean a = false;
  
  public static void a(List<FileIPv6StrateyController.IPInfo> paramList, List<String> paramList1, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList != null)
    {
      if (paramList1 == null) {
        return;
      }
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        FileIPv6StrateyController.IPInfo localIPInfo = (FileIPv6StrateyController.IPInfo)paramList.get(i);
        if ((localIPInfo != null) && (!TextUtils.isEmpty(localIPInfo.a))) {
          if (paramBoolean1)
          {
            if (paramBoolean2)
            {
              if (!TextUtils.isEmpty(localIPInfo.a())) {
                paramList1.add(0, localIPInfo.a());
              }
            }
            else {
              paramList1.add(0, localIPInfo.a);
            }
          }
          else
          {
            StringBuilder localStringBuilder;
            if (paramBoolean2)
            {
              if (!TextUtils.isEmpty(localIPInfo.a()))
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(localIPInfo.a());
                localStringBuilder.append(":");
                localStringBuilder.append(localIPInfo.b);
                paramList1.add(0, localStringBuilder.toString());
              }
            }
            else
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(localIPInfo.a);
              localStringBuilder.append(":");
              localStringBuilder.append(localIPInfo.b);
              paramList1.add(0, localStringBuilder.toString());
            }
          }
        }
        i -= 1;
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static IFileIPv6StrateyController b()
  {
    return (IFileIPv6StrateyController)QRoute.api(IFileIPv6StrateyController.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController
 * JD-Core Version:    0.7.0.1
 */