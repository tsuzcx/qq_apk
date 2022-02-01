package com.tencent.mobileqq.config.business.tendoc;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;

public class TencentDocConfigBean
{
  private boolean a = false;
  private boolean b = false;
  
  public static TencentDocConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (paramArrayOfQConfItem != null)
    {
      if (paramArrayOfQConfItem.length <= 0) {
        return null;
      }
      TencentDocConfigBean localTencentDocConfigBean = new TencentDocConfigBean();
      ArrayList localArrayList = new ArrayList();
      int j = paramArrayOfQConfItem.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramArrayOfQConfItem[i].b);
        i += 1;
      }
      if (localArrayList.size() > 0)
      {
        paramArrayOfQConfItem = new HashMap();
        i = 0;
        while (i < localArrayList.size())
        {
          Object localObject = (String)localArrayList.get(i);
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleTencentDocsConfigCmd receiveAllConfigs |type: 294,content: ");
            localStringBuilder.append((String)localObject);
            QLog.d("TencentDocConfigBean", 2, localStringBuilder.toString());
          }
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = ((String)localObject).split("=");
            if (localObject.length == 2)
            {
              if (!TextUtils.isEmpty(localObject[1])) {
                localObject[1] = localObject[1].trim();
              }
              paramArrayOfQConfItem.put(localObject[0], localObject[1]);
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("handleTencentDocsConfigCmd, name=");
                localStringBuilder.append(localObject[0]);
                localStringBuilder.append(", val=");
                localStringBuilder.append(localObject[1]);
                QLog.i("TencentDocConfigBean", 2, localStringBuilder.toString());
              }
            }
          }
          i += 1;
        }
        localTencentDocConfigBean.a = "1".equals(paramArrayOfQConfItem.get("enable_tencent_docs_assistant"));
        localTencentDocConfigBean.b = "1".equals(paramArrayOfQConfItem.get("preload_tool_process"));
        paramArrayOfQConfItem = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if ((paramArrayOfQConfItem instanceof AppInterface))
        {
          paramArrayOfQConfItem = (AppInterface)paramArrayOfQConfItem;
          ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).setPreloadToolProcess(paramArrayOfQConfItem, localTencentDocConfigBean.b);
          ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).setTencentDocsAssitantEnable(paramArrayOfQConfItem, localTencentDocConfigBean.a);
          return localTencentDocConfigBean;
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd receiveAllConfigs|type: 294,content_list is empty ");
      }
      return localTencentDocConfigBean;
    }
    return null;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocConfigBean
 * JD-Core Version:    0.7.0.1
 */