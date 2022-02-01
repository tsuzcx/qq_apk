package cooperation.qzone;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import bjms;
import com.tencent.TMG.utils.QLog;
import com.tencent.beacon.event.UserAction;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.NetworkState;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class PlatformInfor
{
  private static final String BUSI_ID = "52b7f2";
  private static final String NAME_2G = "2g";
  private static final String NAME_3G = "3g";
  private static final String NAME_4G = "4g";
  private static final String NAME_5G = "5g";
  private static final String NAME_WIFI = "wifi";
  private static final int NOT_INIT = -1;
  private static final String TAG = "PlatformInfor";
  private static PlatformInfor instance;
  private static Object lock = new Object();
  private static String versionName = "";
  private Context mContext = BaseApplication.getContext();
  private String mDeviceId;
  private String mDeviceInfo;
  private String mImsi;
  private String mMacAddress;
  private int mSupportSharpP = -1;
  private TelephonyManager mTelephonyMgr = (TelephonyManager)this.mContext.getSystemService("phone");
  
  private PlatformInfor()
  {
    try
    {
      versionName = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void appendGdtDeviceInfo(StringBuilder paramStringBuilder)
  {
    if ((this.mContext == null) || (paramStringBuilder == null)) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = new GdtDeviceInfoHelper.Params();
        ((GdtDeviceInfoHelper.Params)localObject).businessIdForAidTicketAndTaidTicket = "23c763";
        localObject = GdtDeviceInfoHelper.create(this.mContext, (GdtDeviceInfoHelper.Params)localObject);
        if ((localObject != null) && (((GdtDeviceInfoHelper.Result)localObject).deviceInfo != null))
        {
          localObject = ((GdtDeviceInfoHelper.Result)localObject).deviceInfo;
          if (localObject != null)
          {
            paramStringBuilder.append("qadid=").append(((qq_ad_get.QQAdGet.DeviceInfo)localObject).qadid.get());
            paramStringBuilder.append('&').append("md5_android_id=").append(((qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_android_id.get());
            paramStringBuilder.append('&').append("md5_mac=").append(((qq_ad_get.QQAdGet.DeviceInfo)localObject).md5_mac.get());
            paramStringBuilder.append('&').append("client_ipv4=").append(((qq_ad_get.QQAdGet.DeviceInfo)localObject).client_ipv4.get());
            paramStringBuilder.append('&').append("aid_ticket=").append(((qq_ad_get.QQAdGet.DeviceInfo)localObject).aid_ticket.get());
            paramStringBuilder.append('&').append("taid_ticket=").append(((qq_ad_get.QQAdGet.DeviceInfo)localObject).taid_ticket.get());
            paramStringBuilder.append('&');
            QLog.e("PlatformInfor", 1, "wesley: userip:" + ((qq_ad_get.QQAdGet.DeviceInfo)localObject).client_ipv4.get());
            return;
          }
        }
      }
      catch (Exception paramStringBuilder)
      {
        QLog.e("PlatformInfor", 1, "appendGdtDeviceInfo exception", paramStringBuilder);
      }
    }
  }
  
  public static PlatformInfor g()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new PlatformInfor();
      }
      return instance;
    }
  }
  
  private String getDeviceName()
  {
    String str2 = Build.MODEL;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = SystemUtil.getSystemProperty("ro.product.marketname");
    }
    return str1;
  }
  
  private void getVersion()
  {
    try
    {
      versionName = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionName;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private int isSupportSharpP(Context paramContext)
  {
    if (this.mSupportSharpP == -1)
    {
      ThreadManager.executeOnSubThread(new PlatformInfor.1(this, paramContext));
      return 0;
    }
    return this.mSupportSharpP;
  }
  
  public String getAPNString()
  {
    String str2 = NetworkState.getAPN();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public String getDeviceInfor()
  {
    if ((this.mDeviceInfo != null) && (this.mDeviceInfo.length() > 0))
    {
      localObject1 = new StringBuilder(this.mDeviceInfo);
      ((StringBuilder)localObject1).append("sharpP=").append(isSupportSharpP(this.mContext)).append('&');
      ((StringBuilder)localObject1).append("n=").append(getNetworkType());
      return ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = (WindowManager)this.mContext.getSystemService("window");
    Object localObject1 = new DisplayMetrics();
    ((WindowManager)localObject2).getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("i=").append(getIMEI()).append('&');
    ((StringBuilder)localObject2).append("imsi=").append(getIMSI()).append('&');
    ((StringBuilder)localObject2).append("mac=").append(getLocalMacAddress()).append('&');
    ((StringBuilder)localObject2).append("m=").append(getDeviceName()).append('&');
    ((StringBuilder)localObject2).append("o=").append(Build.VERSION.RELEASE).append('&');
    ((StringBuilder)localObject2).append("a=").append(Build.VERSION.SDK_INT).append('&');
    StringBuilder localStringBuilder = ((StringBuilder)localObject2).append("sc=");
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (int i = 1;; i = 0)
    {
      localStringBuilder.append(i).append('&');
      ((StringBuilder)localObject2).append("sd=").append("0").append('&');
      ((StringBuilder)localObject2).append("p=").append(((DisplayMetrics)localObject1).widthPixels).append('*').append(((DisplayMetrics)localObject1).heightPixels).append('&');
      ((StringBuilder)localObject2).append("f=").append(Build.MANUFACTURER).append('&');
      ((StringBuilder)localObject2).append("mm=").append(DeviceInfoUtil.getSystemTotalMemory() / 1048576L).append('&');
      ((StringBuilder)localObject2).append("cf=").append(DeviceInfoUtil.getCpuFrequency()).append('&');
      ((StringBuilder)localObject2).append("cc=").append(DeviceInfoUtil.getCpuNumber()).append('&');
      ((StringBuilder)localObject2).append("aid=").append(DeviceInfoUtil.getAndroidID()).append('&');
      ((StringBuilder)localObject2).append("qimei=").append(UserAction.getQIMEI()).append('&');
      this.mDeviceInfo = ((StringBuilder)localObject2).toString();
      ((StringBuilder)localObject2).append("sharpP=").append(isSupportSharpP(this.mContext)).append('&');
      ((StringBuilder)localObject2).append("n=").append(getNetworkType());
      return ((StringBuilder)localObject2).toString();
    }
  }
  
  public String getIMEI()
  {
    if (TextUtils.isEmpty(this.mDeviceId)) {
      this.mDeviceId = bjms.a("52b7f2");
    }
    return this.mDeviceId;
  }
  
  public String getIMSI()
  {
    if (TextUtils.isEmpty(this.mImsi)) {
      this.mImsi = bjms.b("52b7f2");
    }
    return this.mImsi;
  }
  
  public String getLocalMacAddress()
  {
    if (TextUtils.isEmpty(this.mMacAddress)) {
      this.mMacAddress = bjms.c("52b7f2");
    }
    return this.mMacAddress;
  }
  
  public String getMachineInfor()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("MANUFACTURER=" + Build.MANUFACTURER + ",SDK=" + Build.VERSION.SDK_INT + ",board=" + Build.BOARD);
    localStringBuffer.append(",device=" + Build.DEVICE);
    localStringBuffer.append(",brand=" + Build.BRAND);
    localStringBuffer.append(",display=" + Build.DISPLAY);
    localStringBuffer.append(",model=" + Build.MODEL);
    localStringBuffer.append(",product=" + Build.PRODUCT);
    return localStringBuffer.toString();
  }
  
  public String getNetworkType()
  {
    switch ()
    {
    default: 
      return "wan";
    case 1: 
      return "wifi";
    case 3: 
      return "3g";
    case 2: 
      return "2g";
    case 4: 
      return "4g";
    }
    return "5g";
  }
  
  public String getSimpleDeviceInfor()
  {
    Object localObject = (WindowManager)this.mContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("m=").append(Build.MODEL).append('&');
    ((StringBuilder)localObject).append("o=").append(Build.VERSION.RELEASE).append('&');
    ((StringBuilder)localObject).append("a=").append(Build.VERSION.SDK_INT).append('&');
    ((StringBuilder)localObject).append("p=").append(localDisplayMetrics.widthPixels).append('*').append(localDisplayMetrics.heightPixels).append('&');
    ((StringBuilder)localObject).append("f=").append(Build.MANUFACTURER).append('&');
    ((StringBuilder)localObject).append("mm=").append(DeviceInfoUtil.getSystemTotalMemory() / 1048576L).append('&');
    ((StringBuilder)localObject).append("cf=").append(DeviceInfoUtil.getCpuFrequency()).append('&');
    ((StringBuilder)localObject).append("cc=").append(DeviceInfoUtil.getCpuNumber()).append('&');
    ((StringBuilder)localObject).append("qqversion=").append("8.4.8");
    return ((StringBuilder)localObject).toString();
  }
  
  public String getVersionName()
  {
    if ((versionName == null) || (versionName.length() == 0)) {
      getVersion();
    }
    return versionName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.PlatformInfor
 * JD-Core Version:    0.7.0.1
 */