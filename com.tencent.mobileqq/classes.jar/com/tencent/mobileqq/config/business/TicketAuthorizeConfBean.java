package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TicketAuthorizeConfBean
{
  public boolean a = false;
  private ConcurrentHashMap<String, String> b = new ConcurrentHashMap(6);
  
  public static TicketAuthorizeConfBean a()
  {
    TicketAuthorizeConfBean localTicketAuthorizeConfBean = new TicketAuthorizeConfBean();
    localTicketAuthorizeConfBean.b.put("skey", "[\"*.qq.com\",\"*.tenpay.com\"]");
    localTicketAuthorizeConfBean.b.put("pskey", "[\"qun.qq.com\",\"game.qq.com\",\"kg.qq.com\",\"id.qq.com\",\"qzone.qq.com\",\"qzone.com\",\"openmobile.qq.com\", \"tenpay.com\", \"buluo.qq.com\", \"docs.qq.com\",\"ti.qq.com\",\"accounts.qq.com\"]");
    localTicketAuthorizeConfBean.b.put("a1", "[]");
    localTicketAuthorizeConfBean.b.put("a2", "[\"aq.qq.com\",\"weloan.tenpay.com\"]");
    localTicketAuthorizeConfBean.b.put("ptlogin2", "[\"http://ptlogin2.qq.com\",\"https://ssl.ptlogin2.qq.com\", \"https://ptlogin2.qq.com\"]");
    localTicketAuthorizeConfBean.b.put("pt4_token", "[\"gamecenter.qq.com\",\"imgcache.qq.com\",\"vip.qq.com\",\"haoma.qq.com\"]");
    localTicketAuthorizeConfBean.a = false;
    return localTicketAuthorizeConfBean;
  }
  
  public static TicketAuthorizeConfBean b(String paramString)
  {
    if (paramString == null)
    {
      QLog.d("TicketAuthorizeConf", 1, "getDefaultValue");
      return a();
    }
    for (;;)
    {
      try
      {
        TicketAuthorizeConfBean localTicketAuthorizeConfBean = new TicketAuthorizeConfBean();
        paramString = new JSONObject(paramString);
        if (paramString.optInt("use_mqq_oa_config") == 1)
        {
          bool = true;
          localTicketAuthorizeConfBean.a = bool;
          JSONArray localJSONArray = paramString.optJSONArray("skey");
          localTicketAuthorizeConfBean.b.put("skey", localJSONArray.toString());
          localJSONArray = paramString.optJSONArray("pskey");
          localTicketAuthorizeConfBean.b.put("pskey", localJSONArray.toString());
          localJSONArray = paramString.optJSONArray("a1");
          localTicketAuthorizeConfBean.b.put("a1", localJSONArray.toString());
          localJSONArray = paramString.optJSONArray("a2");
          localTicketAuthorizeConfBean.b.put("a2", localJSONArray.toString());
          localJSONArray = paramString.optJSONArray("ptlogin2");
          localTicketAuthorizeConfBean.b.put("ptlogin2", localJSONArray.toString());
          paramString = paramString.optJSONArray("pt4_token");
          localTicketAuthorizeConfBean.b.put("pt4_token", paramString.toString());
          return localTicketAuthorizeConfBean;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("TicketAuthorizeConf", 1, paramString.toString());
        return a();
      }
      boolean bool = false;
    }
  }
  
  public JSONArray a(String paramString)
  {
    Object localObject1 = (String)this.b.get(paramString);
    JSONArray localJSONArray;
    if ((localObject1 != null) && (!"".equals(localObject1))) {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
      }
      catch (JSONException localJSONException)
      {
        QLog.e("TicketAuthorizeConf", 1, localJSONException.toString());
      }
    } else {
      localJSONArray = null;
    }
    Object localObject2;
    if (localJSONArray == null) {
      localObject2 = "null";
    } else {
      localObject2 = Integer.valueOf(localJSONArray.length());
    }
    QLog.d("TicketAuthorizeConf", 1, new Object[] { "key:", paramString, " config:", localObject2 });
    return localJSONArray;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TicketAuthorizeConfBean
 * JD-Core Version:    0.7.0.1
 */