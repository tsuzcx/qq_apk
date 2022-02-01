package com.tencent.mobileqq.kandian.glue.viola;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.LoadAsyBack;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

final class ViolaAccessHelper$8
  implements ViolaBaseView.LoadAsyBack
{
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaAccessHelper", 2, "pre load all offline from net is fail");
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        localObject = (JSONArray)paramString.get("preload_bids");
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          ViolaAccessHelper.a((String)((JSONArray)localObject).get(i), null);
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ViolaAccessHelper", 2, "pre load all offline from net is success");
        }
        ViolaAccessHelper.jdField_a_of_type_JavaLangString = RIJQQAppInterfaceUtil.a();
        ViolaAccessHelper.jdField_a_of_type_Long = System.currentTimeMillis();
        if (paramString.has("use_main"))
        {
          ViolaAccessHelper.jdField_a_of_type_Boolean = ((Boolean)paramString.get("use_main")).booleanValue();
          return;
        }
      }
      catch (Exception paramString)
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("pre load all offline from net is exception:");
          ((StringBuilder)localObject).append(paramString.getMessage());
          QLog.e("ViolaAccessHelper", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper.8
 * JD-Core Version:    0.7.0.1
 */