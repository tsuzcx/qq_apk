package com.tencent.mobileqq.servlet;

import com.dataline.util.DBNetworkUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.identity.Proto2JsonUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.Executor;
import tencent.im.login.GetLocalPhone.GetPhoneReq;
import tencent.im.login.GetLocalPhone.GetPhoneReqBody;
import tencent.im.login.GetLocalPhone.GetUrlReq;
import tencent.im.login.GetLocalPhone.GetUrlReqBody;
import tencent.im.login.GetLocalPhone.Head;
import tencent.im.login.GetLocalPhone.LocalPhoneCodeData;

public class LocalPhoneServlet
{
  private static int a()
  {
    try
    {
      int i = DeviceInfoUtil.g(BaseApplication.getContext());
      return i;
    }
    catch (Exception localException)
    {
      QLog.e("LocalPhoneServlet", 1, new Object[] { "getCarrier error : ", localException.getMessage() });
    }
    return 0;
  }
  
  public static GetLocalPhone.GetPhoneReq a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, int paramInt3, String paramString7, int paramInt4, String paramString8, String paramString9, long paramLong, String paramString10, String paramString11, String paramString12, List<GetLocalPhone.LocalPhoneCodeData> paramList)
  {
    GetLocalPhone.GetPhoneReq localGetPhoneReq = new GetLocalPhone.GetPhoneReq();
    GetLocalPhone.GetPhoneReqBody localGetPhoneReqBody = new GetLocalPhone.GetPhoneReqBody();
    localGetPhoneReqBody.str_app_class.set(paramString1);
    localGetPhoneReqBody.str_app_sub_id.set(paramString2);
    localGetPhoneReqBody.str_app_sub_id_ext.set(paramString3);
    localGetPhoneReqBody.str_msg_id.set(paramString4);
    localGetPhoneReqBody.str_seq_no.set(paramString5);
    localGetPhoneReqBody.int_user_id_type.set(paramInt2);
    localGetPhoneReqBody.str_user_id.set(paramString6);
    localGetPhoneReqBody.int_device_id_type.set(paramInt3);
    localGetPhoneReqBody.str_device_id.set(paramString7);
    localGetPhoneReqBody.int32_phone_data_type.set(paramInt4);
    localGetPhoneReqBody.rpt_local_code_data.set(paramList);
    localGetPhoneReqBody.str_cell_ip.set(paramString8);
    localGetPhoneReqBody.str_user_ip.set(paramString9);
    localGetPhoneReqBody.int64_timestamp.set(paramLong);
    localGetPhoneReqBody.str_process_cookies.set(paramString10);
    localGetPhoneReqBody.str_mask_phone.set(paramString11);
    localGetPhoneReqBody.setHasFlag(true);
    paramString1 = new GetLocalPhone.Head();
    paramString1.uint32_appid.set(paramInt1);
    paramString1.str_guid.set(paramString12);
    paramString1.str_account.set(String.valueOf(paramString12.hashCode()));
    localGetPhoneReq.msg_head.set(paramString1);
    localGetPhoneReq.msg_get_phone_req_body.set(localGetPhoneReqBody);
    return localGetPhoneReq;
  }
  
  public static GetLocalPhone.GetPhoneReq a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, List<GetLocalPhone.LocalPhoneCodeData> paramList)
  {
    return a(paramInt, "TENCENT", paramString2, "", paramString1, String.valueOf(System.currentTimeMillis()), 0, "", 3, paramString3, 3, DBNetworkUtil.a(false), DBNetworkUtil.a(false), b(), paramString4, paramString5, paramString6, paramList);
  }
  
  public static GetLocalPhone.GetPhoneReq a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, List<GetLocalPhone.LocalPhoneCodeData> paramList)
  {
    return a(paramInt, "TENCENT", paramString2, "", paramString1, String.valueOf(System.currentTimeMillis()), 0, "", 3, paramString3, 1, DBNetworkUtil.a(false), DBNetworkUtil.a(false), b(), "", "", paramString4, paramList);
  }
  
  public static GetLocalPhone.GetUrlReq a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    GetLocalPhone.GetUrlReqBody localGetUrlReqBody = new GetLocalPhone.GetUrlReqBody();
    GetLocalPhone.GetUrlReq localGetUrlReq = new GetLocalPhone.GetUrlReq();
    localGetUrlReqBody.str_app_class.set("TENCENT");
    localGetUrlReqBody.str_app_sub_id.set(paramString1);
    localGetUrlReqBody.int_client_type.set(30100);
    localGetUrlReqBody.str_seq_no.set(String.valueOf(System.currentTimeMillis()));
    localGetUrlReqBody.str_mobile_phone.set(paramString4);
    localGetUrlReqBody.int_isp_type.set(a());
    localGetUrlReqBody.int_business_type.set(1);
    localGetUrlReqBody.int_user_id_type.set(0);
    localGetUrlReqBody.str_user_id.set("");
    localGetUrlReqBody.int_device_id_type.set(3);
    localGetUrlReqBody.str_device_id.set(paramString2);
    localGetUrlReqBody.str_cell_ip.set(DBNetworkUtil.a(false));
    localGetUrlReqBody.str_user_ip.set(DBNetworkUtil.a(false));
    localGetUrlReqBody.int64_timestamp.set(b());
    localGetUrlReqBody.setHasFlag(true);
    paramString1 = new GetLocalPhone.Head();
    paramString1.uint32_appid.set(paramInt);
    paramString1.str_account.set(String.valueOf(paramString3.hashCode()));
    paramString1.str_guid.set(paramString3);
    localGetUrlReq.msg_get_url_req_body.set(localGetUrlReqBody);
    localGetUrlReq.msg_head.set(paramString1);
    return localGetUrlReq;
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, LocalPhoneServlet.IHttpsCallback paramIHttpsCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocalPhoneServlet", 2, new Object[] { "body : ", paramString3 });
    }
    ThreadManager.getNetExcutor().execute(new LocalPhoneServlet.1(paramString1, paramInt1, paramInt2, paramString2, paramString3, paramIHttpsCallback));
  }
  
  public static void a(String paramString, GetLocalPhone.GetPhoneReq paramGetPhoneReq, LocalPhoneServlet.IHttpsCallback paramIHttpsCallback)
  {
    a(paramString, "application/json", Proto2JsonUtil.a(paramGetPhoneReq), 15000, 15000, paramIHttpsCallback);
  }
  
  public static void a(String paramString, GetLocalPhone.GetUrlReq paramGetUrlReq, LocalPhoneServlet.IHttpsCallback paramIHttpsCallback)
  {
    a(paramString, "application/json", Proto2JsonUtil.a(paramGetUrlReq), 15000, 15000, paramIHttpsCallback);
  }
  
  private static long b()
  {
    return System.currentTimeMillis() / 1000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.LocalPhoneServlet
 * JD-Core Version:    0.7.0.1
 */