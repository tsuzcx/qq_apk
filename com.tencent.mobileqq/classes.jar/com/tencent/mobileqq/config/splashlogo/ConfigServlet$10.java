package com.tencent.mobileqq.config.splashlogo;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

class ConfigServlet$10
  implements Runnable
{
  ConfigServlet$10(ConfigServlet paramConfigServlet, QQAppInterface paramQQAppInterface, ConfigurationService.Config paramConfig) {}
  
  public void run()
  {
    IPasswdRedBagService localIPasswdRedBagService = (IPasswdRedBagService)this.a.getRuntimeService(IPasswdRedBagService.class);
    HashSet localHashSet = new HashSet();
    int j = SharedPreUtils.N(this.a.getApp(), ConfigServlet.a);
    int i = this.b.version.get();
    int m;
    StringBuilder localStringBuilder;
    if (i != j)
    {
      if (i == j) {
        i = j;
      }
      if ((this.b.content_list != null) && (this.b.content_list.size() > 0))
      {
        int n = this.b.content_list.size();
        int k = 0;
        for (;;)
        {
          m = i;
          if (k >= n) {
            break;
          }
          Object localObject1 = (String)this.b.content_list.get(k);
          Object localObject2;
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("receiveAllConfigs|type: 56,content: ");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(",version: ");
            ((StringBuilder)localObject2).append(this.b.version.get());
            QLog.d("SPLASH_ConfigServlet", 2, ((StringBuilder)localObject2).toString());
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            try
            {
              localObject1 = new JSONObject((String)localObject1);
              localObject2 = ((JSONObject)localObject1).keys();
              while (((Iterator)localObject2).hasNext())
              {
                Object localObject3 = (String)((Iterator)localObject2).next();
                if ("passwordPlaceholder".equals(localObject3))
                {
                  localObject3 = ((JSONObject)localObject1).optJSONArray((String)localObject3);
                  if (localObject3 != null)
                  {
                    int i1 = ((JSONArray)localObject3).length();
                    m = 0;
                    while (m < i1)
                    {
                      String str = ((JSONArray)localObject3).optString(m);
                      if ((!TextUtils.isEmpty(str)) && (!localHashSet.contains(str))) {
                        localHashSet.add(str);
                      }
                      m += 1;
                    }
                  }
                }
              }
              k += 1;
            }
            catch (Exception localException2)
            {
              if (QLog.isColorLevel()) {
                QLog.e("SPLASH_ConfigServlet", 2, "received PASSWD_RED_BAG__SETTING_CONFIG error", localException2);
              }
            }
          }
        }
      }
      m = i;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("receiveAllConfigs|type: 56,content_list is empty ,version: ");
        localStringBuilder.append(this.b.version.get());
        QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
        m = i;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("received PASSWD_RED_BAG__SETTING_CONFIG remote version: ");
        localStringBuilder.append(i);
        localStringBuilder.append(" | localVersion: ");
        localStringBuilder.append(j);
        QLog.d("SPLASH_ConfigServlet", 2, localStringBuilder.toString());
      }
      m = j;
    }
    if (m != j) {
      try
      {
        SharedPreUtils.l(this.a.getApp(), ConfigServlet.a, m);
        localIPasswdRedBagService.updatePasswdConfig(localHashSet);
        i = 1;
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SPLASH_ConfigServlet", 2, "received PASSWD_RED_BAG__SETTING_CONFIG error", localException1);
        }
        i = 0;
      }
    } else {
      i = 0;
    }
    if (i == 0) {
      localIPasswdRedBagService.loadConfigs();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.10
 * JD-Core Version:    0.7.0.1
 */