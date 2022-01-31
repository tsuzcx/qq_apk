package cooperation.qzone;

import amyy;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.NetworkState;

public class PlatformInfor
{
  private static PlatformInfor jdField_a_of_type_CooperationQzonePlatformInfor;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static String c = "";
  private static String d = "";
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  private TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager = (TelephonyManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("phone");
  private String jdField_a_of_type_JavaLangString = "";
  private String b;
  
  private PlatformInfor()
  {
    try
    {
      c = this.jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 0).versionName;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private int a(Context paramContext)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      ThreadManager.executeOnSubThread(new amyy(this, paramContext));
      return 0;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public static PlatformInfor a()
  {
    if (jdField_a_of_type_CooperationQzonePlatformInfor == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationQzonePlatformInfor == null) {
        jdField_a_of_type_CooperationQzonePlatformInfor = new PlatformInfor();
      }
      return jdField_a_of_type_CooperationQzonePlatformInfor;
    }
  }
  
  public String a()
  {
    try
    {
      if (!TextUtils.isEmpty(d)) {
        return d;
      }
      if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager != null)
      {
        d = this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getSubscriberId();
        return d;
      }
      return "";
    }
    catch (Exception localException) {}
    return "";
  }
  
  public String b()
  {
    if ((this.b != null) && (this.b.length() > 0))
    {
      localObject1 = new StringBuilder(this.b);
      ((StringBuilder)localObject1).append("sharpP=").append(a(this.jdField_a_of_type_AndroidContentContext)).append('&');
      ((StringBuilder)localObject1).append("n=").append(c());
      return ((StringBuilder)localObject1).toString();
    }
    Object localObject1 = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)localObject1).getDefaultDisplay().getMetrics(localDisplayMetrics);
    StringBuilder localStringBuilder = new StringBuilder();
    localObject1 = "";
    try
    {
      localObject2 = this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getDeviceId();
      localObject1 = localObject2;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject2;
        localException1.printStackTrace();
      }
    }
    localObject2 = "";
    try
    {
      String str = MobileInfoUtil.d();
      localObject2 = str;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        localException2.printStackTrace();
        continue;
        int i = 0;
      }
    }
    localStringBuilder.append("i=").append((String)localObject1).append('&');
    localStringBuilder.append("imsi=").append((String)localObject2).append('&');
    localStringBuilder.append("mac=").append(d()).append('&');
    localStringBuilder.append("m=").append(Build.MODEL).append('&');
    localStringBuilder.append("o=").append(Build.VERSION.RELEASE).append('&');
    localStringBuilder.append("a=").append(Build.VERSION.SDK_INT).append('&');
    localObject1 = localStringBuilder.append("sc=");
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      i = 1;
      ((StringBuilder)localObject1).append(i).append('&');
      localStringBuilder.append("sd=").append("0").append('&');
      localStringBuilder.append("p=").append(localDisplayMetrics.widthPixels).append('*').append(localDisplayMetrics.heightPixels).append('&');
      localStringBuilder.append("f=").append(Build.MANUFACTURER).append('&');
      localStringBuilder.append("mm=").append(DeviceInfoUtil.e() / 1048576L).append('&');
      localStringBuilder.append("cf=").append(DeviceInfoUtil.a()).append('&');
      localStringBuilder.append("cc=").append(DeviceInfoUtil.b()).append('&');
      localStringBuilder.append("aid=").append(DeviceInfoUtil.g()).append('&');
      this.b = localStringBuilder.toString();
      localStringBuilder.append("sharpP=").append(a(this.jdField_a_of_type_AndroidContentContext)).append('&');
      localStringBuilder.append("n=").append(c());
      return localStringBuilder.toString();
    }
  }
  
  public String c()
  {
    switch ()
    {
    default: 
      return "wan";
    case 1: 
      return "wifi";
    case 2: 
      return "3g";
    case 3: 
      return "2g";
    }
    return "4g";
  }
  
  public String d()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return "null";
      }
      Object localObject = (WifiManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("wifi");
      if (localObject == null) {
        return "null";
      }
      localObject = ((WifiManager)localObject).getConnectionInfo();
      if (localObject == null) {
        return "null";
      }
      localObject = ((WifiInfo)localObject).getMacAddress();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "null";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.PlatformInfor
 * JD-Core Version:    0.7.0.1
 */