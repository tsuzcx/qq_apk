package com.tencent.mobileqq.safe;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.identity.IQSafeConfigCallback;
import com.tencent.mobileqq.manager.QSafeManagerBean;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginInfoSafeEntrance
  implements IQSafeConfigCallback
{
  public void a(@NonNull QSafeManagerBean paramQSafeManagerBean) {}
  
  public void a(@NonNull QSafeManagerBean paramQSafeManagerBean, String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("anti_theft_url");
      localObject = ((JSONObject)localObject).optString("safe_protect_url");
      paramQSafeManagerBean.a(paramString);
      paramQSafeManagerBean.b((String)localObject);
      return;
    }
    catch (JSONException paramQSafeManagerBean)
    {
      QLog.d("LoginInfoSafeEntrance", 1, "onParsed JSONException : ", paramQSafeManagerBean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.safe.LoginInfoSafeEntrance
 * JD-Core Version:    0.7.0.1
 */