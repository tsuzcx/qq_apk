package com.tencent.mobileqq.nearby;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;
import mqq.app.NewIntent;

public class NearbyAlumniServletUtils
{
  static final Object jdField_a_of_type_JavaLangObject = new Object();
  static HashMap<String, Object> jdField_a_of_type_JavaUtilHashMap;
  
  public static void a(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString1, Object paramObject, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(String.valueOf(SystemClock.elapsedRealtime()));
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(paramString1);
      localObject1 = ((StringBuilder)localObject1).toString();
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_JavaUtilHashMap == null) {
          jdField_a_of_type_JavaUtilHashMap = new HashMap(1);
        }
        jdField_a_of_type_JavaUtilHashMap.put(localObject1, paramObject);
        paramObject = new NewIntent(paramAppInterface.getApplication(), QQNearbyManager.e());
        paramObject.putExtra("param_cmd", paramInt1);
        paramObject.putExtra("param_subcmd", paramInt2);
        paramObject.putExtra("param_uin", Long.parseLong(paramAppInterface.getCurrentAccountUin()));
        paramObject.putExtra("param_req_json_string", paramString1);
        paramObject.putExtra("param_callback_key", (String)localObject1);
        paramObject.putExtra("param_callback_id", paramString2);
        paramAppInterface.startServlet(paramObject);
        return;
      }
    }
    throw new IllegalArgumentException("reqJsonStr can not be null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyAlumniServletUtils
 * JD-Core Version:    0.7.0.1
 */