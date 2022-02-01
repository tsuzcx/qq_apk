package com.tencent.mobileqq.config.business.tendoc;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TencentDocConfigBean
{
  private boolean a = false;
  private boolean b = false;
  
  public static TencentDocConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
      return null;
    }
    TencentDocConfigBean localTencentDocConfigBean = new TencentDocConfigBean();
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfQConfItem.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfQConfItem[i].a);
      i += 1;
    }
    if (localArrayList.size() > 0)
    {
      paramArrayOfQConfItem = new HashMap();
      i = 0;
      if (i < localArrayList.size())
      {
        Object localObject = (String)localArrayList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd receiveAllConfigs |type: 294,content: " + (String)localObject);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((String)localObject).split("=");
          if (localObject.length == 2)
          {
            if (!TextUtils.isEmpty(localObject[1])) {
              localObject[1] = localObject[1].trim();
            }
            paramArrayOfQConfItem.put(localObject[0], localObject[1]);
            if (QLog.isColorLevel()) {
              QLog.i("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd, name=" + localObject[0] + ", val=" + localObject[1]);
            }
          }
        }
      }
      localTencentDocConfigBean.a = "1".equals(paramArrayOfQConfItem.get("enable_tencent_docs_assistant"));
      localTencentDocConfigBean.b = "1".equals(paramArrayOfQConfItem.get("preload_tool_process"));
      paramArrayOfQConfItem = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramArrayOfQConfItem instanceof QQAppInterface))
      {
        paramArrayOfQConfItem = (QQAppInterface)paramArrayOfQConfItem;
        TeamWorkUtils.b(paramArrayOfQConfItem, localTencentDocConfigBean.b);
        TeamWorkUtils.a(paramArrayOfQConfItem, localTencentDocConfigBean.a);
      }
    }
    for (;;)
    {
      return localTencentDocConfigBean;
      if (QLog.isColorLevel()) {
        QLog.d("TencentDocConfigBean", 2, "handleTencentDocsConfigCmd receiveAllConfigs|type: 294,content_list is empty ");
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.tendoc.TencentDocConfigBean
 * JD-Core Version:    0.7.0.1
 */