package com.tencent.mobileqq.config.splashlogo;

import agvz;
import ando;
import android.text.TextUtils;
import bbjn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConfigServlet$12
  implements Runnable
{
  public ConfigServlet$12(ando paramando, ConfigurationService.Config paramConfig) {}
  
  public void run()
  {
    int n = 0;
    QQAppInterface localQQAppInterface = (QQAppInterface)this.this$0.getAppRuntime();
    agvz localagvz = (agvz)localQQAppInterface.getManager(125);
    HashSet localHashSet = new HashSet();
    int j = bbjn.G(localQQAppInterface.getApp(), ando.a);
    int i = this.a.version.get();
    if (i != j) {
      if (i == j) {
        break label504;
      }
    }
    for (;;)
    {
      int m;
      if ((this.a.content_list != null) && (this.a.content_list.size() > 0))
      {
        int i1 = this.a.content_list.size();
        int k = 0;
        m = i;
        if (k < i1)
        {
          Object localObject1 = (String)this.a.content_list.get(k);
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 56,content: " + (String)localObject1 + ",version: " + this.a.version.get());
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {}
          for (;;)
          {
            k += 1;
            break;
            try
            {
              localObject1 = new JSONObject((String)localObject1);
              Iterator localIterator = ((JSONObject)localObject1).keys();
              while (localIterator.hasNext())
              {
                Object localObject2 = (String)localIterator.next();
                if ("passwordPlaceholder".equals(localObject2))
                {
                  localObject2 = ((JSONObject)localObject1).optJSONArray((String)localObject2);
                  if (localObject2 != null)
                  {
                    int i2 = ((JSONArray)localObject2).length();
                    m = 0;
                    while (m < i2)
                    {
                      String str = ((JSONArray)localObject2).optString(m);
                      if ((!TextUtils.isEmpty(str)) && (!localHashSet.contains(str))) {
                        localHashSet.add(str);
                      }
                      m += 1;
                    }
                  }
                }
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
            }
            catch (Exception localException2) {}
            QLog.e("SPLASH_ConfigServlet", 2, "received PASSWD_RED_BAG__SETTING_CONFIG error", localException2);
          }
        }
      }
      else
      {
        m = i;
        if (QLog.isColorLevel())
        {
          QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 56,content_list is empty ,version: " + this.a.version.get());
          m = i;
        }
      }
      if (m != j) {}
      for (;;)
      {
        try
        {
          bbjn.o(localQQAppInterface.getApp(), ando.a, m);
          localagvz.a(localHashSet);
          i = 1;
        }
        catch (Exception localException1)
        {
          i = n;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("SPLASH_ConfigServlet", 2, "received PASSWD_RED_BAG__SETTING_CONFIG error", localException1);
          i = n;
          continue;
        }
        if (i == 0) {
          localagvz.f();
        }
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SPLASH_ConfigServlet", 2, "received PASSWD_RED_BAG__SETTING_CONFIG remote version: " + i + " | localVersion: " + j);
        }
        m = j;
        break;
        i = 0;
      }
      label504:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.12
 * JD-Core Version:    0.7.0.1
 */