package com.tencent.mobileqq.cmshow.engine.resource;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloResHelper;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class AbsApolloResManager$1
  implements Runnable
{
  AbsApolloResManager$1(AbsApolloResManager paramAbsApolloResManager) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
    Object localObject1 = null;
    Object localObject3 = localSharedPreferences.getString("inner_res_md5", null);
    boolean bool1 = TextUtils.isEmpty((CharSequence)localObject3);
    boolean bool2 = true;
    Object localObject2;
    if (bool1)
    {
      QLog.i("[cmshow]cm_res", 1, "need to unzip def.zip");
      bool1 = bool2;
    }
    else
    {
      localObject2 = ApolloUtilImpl.calcMd5FromAccess("apollo_def_rsc");
      if (!((String)localObject3).equals(localObject2))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("local md5: ");
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append(", newMd5: ");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
        bool1 = bool2;
      }
      else if (!this.this$0.b(0))
      {
        localObject1 = localObject2;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("[cmshow]cm_res", 2, "role res is invalid");
          localObject1 = localObject2;
          bool1 = bool2;
        }
      }
      else
      {
        localObject3 = ((IApolloResHelper)QRoute.api(IApolloResHelper.class)).readRoleDefaultDressIds(0);
        int i;
        if ((localObject3 != null) && (localObject3.length != 0))
        {
          int j = localObject3.length;
          i = 0;
          while (i < j)
          {
            int k = localObject3[i];
            if (!this.this$0.a(k))
            {
              localObject1 = localObject2;
              bool1 = bool2;
              if (!QLog.isColorLevel()) {
                break label390;
              }
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("dress is invalid id: ");
              ((StringBuilder)localObject1).append(k);
              QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
              localObject1 = localObject2;
              bool1 = bool2;
              break label390;
            }
            i += 1;
          }
          bool1 = false;
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = localObject2;
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("dresses is invalid size:");
            if (localObject3 == null) {
              i = 0;
            } else {
              i = localObject3.length;
            }
            ((StringBuilder)localObject1).append(i);
            QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
            bool1 = bool2;
            localObject1 = localObject2;
          }
        }
      }
    }
    label390:
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("check default res cost: ");
      ((StringBuilder)localObject2).append(l2 - l1);
      ((StringBuilder)localObject2).append(" ms, unzip: ");
      ((StringBuilder)localObject2).append(bool1);
      QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject2).toString());
    }
    if ((bool1) && (AbsApolloResManager.a(this.this$0)))
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = ApolloUtilImpl.calcMd5FromAccess("apollo_def_rsc");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localSharedPreferences.edit().putString("inner_res_md5", (String)localObject2).commit();
      }
    }
    AbsApolloResManager.h().set(false);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("check default ready scene file cost: ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l2);
      QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.resource.AbsApolloResManager.1
 * JD-Core Version:    0.7.0.1
 */