package com.tencent.mobileqq.portal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

class PortalManager$PortalJSReceiver
  extends BroadcastReceiver
{
  private PortalManager$PortalJSReceiver(PortalManager paramPortalManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int k = paramIntent.getIntExtra("portal_type_key", -1);
    int m = paramIntent.getIntExtra("bc_seq", -1);
    paramContext = paramIntent.getStringExtra("portal_agrs");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PortalSwictherReceiver, ");
      ((StringBuilder)localObject).append(paramIntent.getExtras());
      QLog.i("PortalManager", 2, ((StringBuilder)localObject).toString());
    }
    int j = 1;
    int i = 1;
    switch (k)
    {
    default: 
      return;
    }
    try
    {
      if (TextUtils.isEmpty(paramContext))
      {
        PortalManager.a(this.a, k, m, null, -1, "params is null");
        return;
      }
      paramContext = new JSONObject(paramContext);
      paramIntent = paramContext.getString("key");
      localObject = PortalUtils.b(paramIntent);
      localObject = ContactUtils.f(PortalManager.a(this.a), (String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramContext.put("errorCode", 0).put("result", localObject).put("key", paramIntent);
      } else {
        paramContext.put("errorCode", -1).put("key", paramIntent);
      }
      PortalManager.a(this.a, k, paramContext.toString(), m);
      return;
    }
    catch (Exception paramContext)
    {
      int i1;
      int n;
      if (!QLog.isColorLevel()) {
        break label709;
      }
      QLog.e("PortalManager", 2, "", paramContext);
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
      try
      {
        paramContext = new JSONObject();
        paramContext.put("errorCode", -1);
        PortalManager.a(this.a, k, paramContext.toString(), m);
        return;
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    paramContext = new JSONObject();
    paramIntent = paramContext.put("errorCode", 0);
    if (this.a.a() != -1)
    {
      paramIntent.put("result", i);
      PortalManager.a(this.a, k, paramContext.toString(), m);
      return;
      if (TextUtils.isEmpty(paramContext))
      {
        PortalManager.a(this.a, k, m, null, -1, "params is null");
        return;
      }
      paramContext = new JSONObject(paramContext).getString("key");
      if (!TextUtils.isEmpty(paramContext))
      {
        paramIntent = PortalUtils.b(paramContext);
        localObject = PortalManager.a(this.a).getFaceBitmap(paramIntent, false);
        if (localObject != null)
        {
          paramIntent = PortalUtils.a((Bitmap)localObject);
          localObject = new JSONObject();
          ((JSONObject)localObject).put("errorCode", 0);
          ((JSONObject)localObject).put("key", paramContext);
          ((JSONObject)localObject).put("result", paramIntent);
          PortalManager.a(this.a, k, ((JSONObject)localObject).toString(), m);
          return;
        }
        localObject = new PortalManager.IconReqDetails();
        ((PortalManager.IconReqDetails)localObject).jdField_a_of_type_JavaLangString = paramContext;
        ((PortalManager.IconReqDetails)localObject).b = k;
        ((PortalManager.IconReqDetails)localObject).jdField_a_of_type_Int = m;
        this.a.a.put(paramIntent, localObject);
        if ((PortalManager.a(this.a).getFaceBitmap(paramIntent, true) == null) && (QLog.isColorLevel()))
        {
          paramIntent = ContactUtils.d(PortalManager.a(this.a), String.valueOf(paramIntent));
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("昵称为");
          ((StringBuilder)localObject).append(paramIntent);
          ((StringBuilder)localObject).append("，本地不存在头像，key = ");
          ((StringBuilder)localObject).append(paramContext);
          QLog.d("PortalManager", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        PortalManager.a(this.a, k, m, null, -1, "key is null");
        return;
        if (TextUtils.isEmpty(paramContext))
        {
          PortalManager.a(this.a, k, m, null, -1, "params is null");
          return;
        }
        paramContext = new JSONObject(paramContext);
        i1 = paramContext.getInt("type");
        n = paramContext.getInt("count");
        i = j;
        if (i1 != 1)
        {
          if (i1 == 2) {
            break label720;
          }
          if (i1 == 3) {
            break label715;
          }
          i = j;
        }
      }
    }
    for (;;)
    {
      RedPacketServlet.a(PortalManager.a(this.a), i, n, k, m);
      return;
      label709:
      return;
      i = 0;
      break;
      label715:
      i = 3;
      continue;
      label720:
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.PortalJSReceiver
 * JD-Core Version:    0.7.0.1
 */