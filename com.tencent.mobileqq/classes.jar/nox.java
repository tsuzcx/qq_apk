import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PhoneInfo;

public class nox
{
  public static String a()
  {
    Object localObject = "";
    try
    {
      String str = befc.a("d059d4");
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AdDeviceInfoUtil", 2, "getIMEI: exception" + localException.getMessage());
    }
    return localObject;
    return "";
  }
  
  public static oidb_0x6cf.PhoneInfo a()
  {
    oidb_0x6cf.PhoneInfo localPhoneInfo = new oidb_0x6cf.PhoneInfo();
    Object localObject1 = new yoz();
    ((yoz)localObject1).a = "ce2d9f";
    Object localObject2 = yoy.a(BaseApplication.getContext(), (yoz)localObject1);
    if (localObject2 != null) {}
    for (localObject1 = ((ypa)localObject2).a;; localObject1 = null)
    {
      if ((localObject2 != null) && (((ypa)localObject2).a != null) && (((ypa)localObject2).a.muid != null) && (((ypa)localObject2).a.muid_type != null))
      {
        localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(((ypa)localObject2).a.muid.get()));
        localPhoneInfo.uint32_muid_type.set(((ypa)localObject2).a.muid_type.get());
      }
      localObject2 = b();
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localPhoneInfo.string_imei.set((String)localObject2);
      }
      int i = myn.a();
      localPhoneInfo.uint32_conn.set(i);
      i = 0;
      try
      {
        int j = babp.e();
        i = j;
      }
      catch (Exception localException)
      {
        label158:
        break label158;
      }
      localPhoneInfo.uint32_carrier.set(i);
      localObject2 = babp.e();
      localPhoneInfo.bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject2 = babp.c();
      localPhoneInfo.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      i = AppSetting.a();
      localPhoneInfo.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      localObject2 = dp.a(dp.a());
      localPhoneInfo.bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localPhoneInfo.uint32_os_type.set(2);
      localPhoneInfo.uint64_func_flag.set(1L);
      localPhoneInfo.bytes_ads_context.set(ByteStringMicro.copyFromUtf8(nbe.a()));
      localPhoneInfo.bytes_manufacturer.set(ByteStringMicro.copyFromUtf8(Build.BRAND));
      localPhoneInfo.bytes_device_brand_and_model.set(ByteStringMicro.copyFromUtf8(Build.MODEL));
      if (localObject1 != null)
      {
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.has()) {
          localPhoneInfo.string_qadid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.has()) {
          localPhoneInfo.string_androidid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.has()) {
          localPhoneInfo.string_mac.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.has()) {
          localPhoneInfo.string_oaid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.has()) {
          localPhoneInfo.string_taid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
        }
        if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.has()) {
          localPhoneInfo.string_client_ipv4.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
        }
        if (QLog.isColorLevel()) {
          QLog.i("AdDeviceInfoUtil", 2, "makePhoneInfo0x6cf: deviceInfo: ma=" + localPhoneInfo.string_androidid.get() + ", mm=" + localPhoneInfo.string_mac.get() + ", oa=" + localPhoneInfo.string_oaid.get() + ", ta=" + localPhoneInfo.string_taid.get());
        }
      }
      return localPhoneInfo;
    }
  }
  
  public static String b()
  {
    for (Object localObject1 = "";; localObject1 = "")
    {
      try
      {
        Object localObject2 = (TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone");
        if (Build.VERSION.SDK_INT > 28) {
          continue;
        }
        localObject2 = ((TelephonyManager)localObject2).getDeviceId();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("AdDeviceInfoUtil", 2, "getGdtIMEI: exception" + localException.getMessage());
        return "";
      }
      return localObject1;
    }
  }
  
  public static String c()
  {
    Object localObject = "";
    try
    {
      String str = befc.c("d059d4");
      localObject = str;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AdDeviceInfoUtil", 2, "getIMEI: exception" + localException.getMessage());
    }
    return localObject;
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nox
 * JD-Core Version:    0.7.0.1
 */