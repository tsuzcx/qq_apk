package com.tencent.mobileqq.vip;

import android.text.TextUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

public class LhHelper
{
  public static Map<String, Long> a;
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private int b = -1;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap(10);
  }
  
  public LhHelper(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cmd=rsp&key=a4d7ea5belhtimecard&uin=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    return MD5.toMD5(localStringBuilder.toString());
  }
  
  private String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cmd=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("&key=");
    localStringBuilder.append("a4d7ea5belhtimecard");
    localStringBuilder.append("&uin=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    return MD5.toMD5(localStringBuilder.toString());
  }
  
  private OkHttpClient a()
  {
    return new OkHttpClient().newBuilder().connectTimeout(5L, TimeUnit.SECONDS).readTimeout(5L, TimeUnit.SECONDS).build();
  }
  
  private JSONObject a(int paramInt)
  {
    try
    {
      Object localObject1 = b(paramInt);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return null;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("reqCgi cmd = ");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.d("LhHelper", 1, ((StringBuilder)localObject2).toString());
      localObject1 = new Request.Builder().url((String)localObject1).build();
      localObject1 = a().newCall((Request)localObject1).execute();
      int i = ((Response)localObject1).code();
      if (i == 200)
      {
        localObject1 = new JSONObject(((Response)localObject1).body().string()).optJSONObject("12042");
        if (localObject1 == null) {
          return null;
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("data");
        if (localObject1 == null) {
          return null;
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("rsp");
        if (localObject1 == null) {
          return null;
        }
        i = ((JSONObject)localObject1).optInt("ret");
        localObject2 = ((JSONObject)localObject1).optString("sign");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reqCgi retCode = ");
        localStringBuilder.append(i);
        QLog.d("LhHelper", 1, localStringBuilder.toString());
        if ((i == 0) && (a().equalsIgnoreCase((String)localObject2))) {
          return localObject1;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reqCgi rsp sign error, cmd = ");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.e("LhHelper", 1, ((StringBuilder)localObject1).toString());
        return null;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reqCgi http errorCode = ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(" ,cmd = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.e("LhHelper", 1, ((StringBuilder)localObject1).toString());
      return null;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("reqCgi exception cmd =");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(", e = ");
      QLog.e("LhHelper", 1, ((StringBuilder)localObject2).toString(), localThrowable);
    }
    return null;
  }
  
  private JSONObject a(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("req", paramJSONObject);
      localJSONObject1.put("12042", localJSONObject2);
      return localJSONObject1;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("LhHelper", 1, "buildReqData exception e = ", paramJSONObject);
    }
    return null;
  }
  
  private String b(int paramInt)
  {
    try
    {
      localObject2 = a(paramInt);
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("cmd", paramInt);
      ((JSONObject)localObject1).put("sign", localObject2);
      ((JSONObject)localObject1).put("uin", this.jdField_a_of_type_JavaLangString);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("https://proxy.vip.qq.com/cgi-bin/srfentry.fcgi?data=");
      ((StringBuilder)localObject2).append(a((JSONObject)localObject1));
      localObject1 = ((StringBuilder)localObject2).toString();
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("buildReqUrl cmd = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("exception e = ");
      QLog.e("LhHelper", 1, ((StringBuilder)localObject2).toString(), localThrowable);
    }
    return null;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean a()
  {
    try
    {
      if (a(2) != null) {
        return true;
      }
      QLog.e("LhHelper", 1, "receiveReq rsp data is error");
    }
    catch (Throwable localThrowable)
    {
      QLog.e("LhHelper", 1, "receiveReq exception e = ", localThrowable);
    }
    return false;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public boolean b()
  {
    try
    {
      Object localObject = a(3);
      if (localObject != null)
      {
        int i = ((JSONObject)localObject).optInt("lhState", -1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reqLhStatus lhState = ");
        ((StringBuilder)localObject).append(i);
        QLog.d("LhHelper", 1, ((StringBuilder)localObject).toString());
        if (i == 2) {
          return true;
        }
      }
      else
      {
        QLog.e("LhHelper", 1, "reqLhStatus rsp data is error");
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("LhHelper", 1, "reqLhStatus exception e = ", localThrowable);
    }
    return false;
  }
  
  public int c()
  {
    try
    {
      JSONObject localJSONObject = a(1);
      if (localJSONObject != null)
      {
        this.jdField_a_of_type_Int = localJSONObject.optInt("buyoutMonth", -1);
        this.b = localJSONObject.optInt("buyoutType", -1);
        int i = localJSONObject.optInt("cardState", -1);
        if ((this.jdField_a_of_type_Int != -1) && (this.b != -1))
        {
          if (i != 0) {
            break label98;
          }
          return 1;
        }
        QLog.e("LhHelper", 1, "checkUserStatus buyoutData is error");
      }
      else
      {
        QLog.e("LhHelper", 1, "checkUserStatus rsp data is empty");
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("LhHelper", 1, "checkUserStatus exception e = ", localThrowable);
    }
    return 3;
    label98:
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.LhHelper
 * JD-Core Version:    0.7.0.1
 */