package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class VipLongMsgShareDomainHelper
{
  private static VipLongMsgShareDomainHelper c;
  private List<String> a = new CopyOnWriteArrayList();
  private List<String> b = new CopyOnWriteArrayList();
  
  public VipLongMsgShareDomainHelper()
  {
    this.a.add("vip.qq.com");
  }
  
  public static VipLongMsgShareDomainHelper a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new VipLongMsgShareDomainHelper();
        }
      }
      finally {}
    }
    return c;
  }
  
  public void a(JSONArray paramJSONArray)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setConfigData data = ");
      ((StringBuilder)localObject).append(paramJSONArray);
      QLog.d("VipLongMsgShareDomainHelper", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramJSONArray != null) && (paramJSONArray.length() > 0))
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        try
        {
          localObject = paramJSONArray.getJSONObject(i);
          if (localObject != null)
          {
            localObject = ((JSONObject)localObject).optString("domain", "");
            this.b.add(localObject);
          }
        }
        catch (Exception localException)
        {
          QLog.e("VipLongMsgShareDomainHelper", 1, "setConfigData exception ", localException);
        }
        i += 1;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject2 = this.b;
    Object localObject1 = localObject2;
    if (((List)localObject2).isEmpty()) {
      localObject1 = this.a;
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (paramString.endsWith((String)localObject2))) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VipLongMsgShareDomainHelper
 * JD-Core Version:    0.7.0.1
 */