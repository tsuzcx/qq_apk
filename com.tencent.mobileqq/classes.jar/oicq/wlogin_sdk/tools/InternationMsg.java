package oicq.wlogin_sdk.tools;

import oicq.wlogin_sdk.request.t;

public class InternationMsg
{
  static a[] a = { new a(2052, MSG_TYPE.MSG_0, "登录失败"), new a(1028, MSG_TYPE.MSG_0, "登錄失敗"), new a(1033, MSG_TYPE.MSG_0, "Unable to login"), new a(2052, MSG_TYPE.MSG_1, "请你稍后重试。"), new a(1028, MSG_TYPE.MSG_1, "請你稍後重試。"), new a(1033, MSG_TYPE.MSG_1, "Please try again later."), new a(2052, MSG_TYPE.MSG_2, "手机存储异常，请删除帐号重试。"), new a(1028, MSG_TYPE.MSG_2, "手機存儲異常，請刪除帳號重試。"), new a(1033, MSG_TYPE.MSG_2, "Phone memory error, please delete the account and try again."), new a(2052, MSG_TYPE.MSG_3, "请求失败，请你稍后重试。"), new a(1028, MSG_TYPE.MSG_3, "請求失敗，請你稍後重試。"), new a(1033, MSG_TYPE.MSG_3, "Request failed, please try again later."), new a(2052, MSG_TYPE.MSG_4, "网络超时，请你稍后重试。"), new a(1028, MSG_TYPE.MSG_4, "網絡超時，請你稍後重試。"), new a(1033, MSG_TYPE.MSG_4, "Network timeout, please try again later."), new a(2052, MSG_TYPE.MSG_5, "登录设备保护"), new a(1028, MSG_TYPE.MSG_5, "登錄設備保護"), new a(1033, MSG_TYPE.MSG_5, "Device Protection") };
  
  public static String a(MSG_TYPE paramMSG_TYPE)
  {
    int i = 0;
    while (i < a.length)
    {
      if ((paramMSG_TYPE == a[i].b) && (t.u == a[i].a)) {
        return a[i].c;
      }
      i += 1;
    }
    return "";
  }
  
  public static enum MSG_TYPE
  {
    MSG_0,  MSG_1,  MSG_2,  MSG_3,  MSG_4,  MSG_5;
    
    private MSG_TYPE() {}
  }
  
  static class a
  {
    int a;
    InternationMsg.MSG_TYPE b;
    String c;
    
    public a(int paramInt, InternationMsg.MSG_TYPE paramMSG_TYPE, String paramString)
    {
      this.a = paramInt;
      this.b = paramMSG_TYPE;
      this.c = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.InternationMsg
 * JD-Core Version:    0.7.0.1
 */