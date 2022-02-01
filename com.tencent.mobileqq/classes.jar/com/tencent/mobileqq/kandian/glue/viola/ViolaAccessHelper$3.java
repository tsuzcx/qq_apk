package com.tencent.mobileqq.kandian.glue.viola;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

final class ViolaAccessHelper$3
  implements ViolaAccessHelper.ViolaOfflineDownloadListener
{
  public void a()
  {
    Object localObject1 = ViolaAccessHelper.b("https://viola/viola_config.json?v_bid=3192");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject2 = (JSONArray)((JSONObject)localObject1).get("preload_bids");
        int i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          ViolaAccessHelper.a((String)((JSONArray)localObject2).get(i), null);
          i += 1;
        }
        ViolaAccessHelper.jdField_a_of_type_JavaLangString = RIJQQAppInterfaceUtil.a();
        ViolaAccessHelper.jdField_a_of_type_Long = System.currentTimeMillis();
        if (((JSONObject)localObject1).has("use_main")) {
          ViolaAccessHelper.jdField_a_of_type_Boolean = ((Boolean)((JSONObject)localObject1).get("use_main")).booleanValue();
        }
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ViolaAccessHelper", 2, "pre load all offline from offline is success!");
        return;
      }
      catch (Exception localException)
      {
        Object localObject2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("pre load all offline from offline is exception:");
          ((StringBuilder)localObject2).append(localException.getMessage());
          QLog.e("ViolaAccessHelper", 2, ((StringBuilder)localObject2).toString());
        }
        ViolaAccessHelper.b();
        return;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "pre load all offline from offline is empty!");
      }
      ViolaAccessHelper.b();
    }
  }
  
  public void a(int paramInt) {}
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper.3
 * JD-Core Version:    0.7.0.1
 */