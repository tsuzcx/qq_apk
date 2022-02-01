package com.tencent.mobileqq.util;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.richstatus.ActionInfo;
import com.tencent.mobileqq.richstatus.StatusManager;
import java.util.ArrayList;
import java.util.Iterator;

public class IPCIconHelper
{
  QQAppInterface a;
  StatusManager b;
  
  public IPCIconHelper(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public Bundle a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getStringArrayList("key");
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("key", paramBundle);
    if (paramBundle != null)
    {
      if (paramBundle.size() == 0) {
        return localBundle;
      }
      if (this.b == null) {
        this.b = ((StatusManager)this.a.getManager(QQManagerFactory.STATUS_MANAGER));
      }
      if (this.b == null) {
        return localBundle;
      }
      ArrayList localArrayList = new ArrayList(paramBundle.size());
      Iterator localIterator = paramBundle.iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        String str1 = "";
        Object localObject;
        if (str2 == null) {
          localObject = null;
        } else {
          localObject = str2.split("_s_");
        }
        paramBundle = str1;
        if (localObject != null)
        {
          paramBundle = str1;
          if (localObject.length == 3) {
            try
            {
              int j = Integer.parseInt(localObject[0]);
              String str3 = localObject[1];
              int i = Integer.parseInt(localObject[2]);
              paramBundle = str1;
              if (j == 1)
              {
                j = Integer.parseInt(str3);
                localObject = this.b.a(j);
                paramBundle = str1;
                if (localObject != null) {
                  if (i == 201) {
                    paramBundle = ((ActionInfo)localObject).c;
                  } else {
                    paramBundle = ((ActionInfo)localObject).d;
                  }
                }
              }
            }
            catch (Exception paramBundle)
            {
              paramBundle.printStackTrace();
              paramBundle = str1;
            }
          }
        }
        NearbyUtils.a("getIconUrl", "getIconUrl", new Object[] { str2, paramBundle });
        localArrayList.add(paramBundle);
      }
      localBundle.putStringArrayList("path", localArrayList);
    }
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.IPCIconHelper
 * JD-Core Version:    0.7.0.1
 */