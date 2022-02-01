package cooperation.qzone;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.QQDeviceInfo;
import cooperation.qzone.util.NetworkState;

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
  private String mDeviceInfo = null;
  private String mImsi;
  private String mMacAddress;
  private int mSupportSharpP = -1;
  private TelephonyManager mTelephonyMgr = null;
  
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
  
  public static PlatformInfor g()
  {
    if (instance == null) {
      synchronized (lock)
      {
        if (instance == null) {
          instance = new PlatformInfor();
        }
      }
    }
    return instance;
  }
  
  public static String getDeviceName()
  {
    String str2 = Build.MODEL;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = SystemUtil.a("ro.product.marketname");
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
    int i = this.mSupportSharpP;
    if (i == -1)
    {
      ThreadManager.executeOnSubThread(new PlatformInfor.1(this, paramContext));
      return 0;
    }
    return i;
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public String getIMEI()
  {
    if (TextUtils.isEmpty(this.mDeviceId)) {
      this.mDeviceId = QQDeviceInfo.getIMEI("52b7f2");
    }
    return this.mDeviceId;
  }
  
  public String getIMSI()
  {
    if (TextUtils.isEmpty(this.mImsi)) {
      this.mImsi = QQDeviceInfo.getIMSI("52b7f2");
    }
    return this.mImsi;
  }
  
  public String getLocalMacAddress()
  {
    if (TextUtils.isEmpty(this.mMacAddress)) {
      this.mMacAddress = QQDeviceInfo.getMAC("52b7f2");
    }
    return this.mMacAddress;
  }
  
  public String getMachineInfor()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MANUFACTURER=");
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(",SDK=");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    localStringBuilder.append(",board=");
    localStringBuilder.append(Build.BOARD);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(",device=");
    localStringBuilder.append(Build.DEVICE);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(",brand=");
    localStringBuilder.append(Build.BRAND);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(",display=");
    localStringBuilder.append(Build.DISPLAY);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(",model=");
    localStringBuilder.append(Build.MODEL);
    localStringBuffer.append(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(",product=");
    localStringBuilder.append(Build.PRODUCT);
    localStringBuffer.append(localStringBuilder.toString());
    return localStringBuffer.toString();
  }
  
  public String getNetworkType()
  {
    int i = NetworkState.getNetworkType();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return "wan";
            }
            return "5g";
          }
          return "4g";
        }
        return "3g";
      }
      return "2g";
    }
    return "wifi";
  }
  
  public String getSimpleDeviceInfor()
  {
    Object localObject = (WindowManager)this.mContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("m=");
    ((StringBuilder)localObject).append(Build.MODEL);
    ((StringBuilder)localObject).append('&');
    ((StringBuilder)localObject).append("o=");
    ((StringBuilder)localObject).append(Build.VERSION.RELEASE);
    ((StringBuilder)localObject).append('&');
    ((StringBuilder)localObject).append("a=");
    ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
    ((StringBuilder)localObject).append('&');
    ((StringBuilder)localObject).append("p=");
    ((StringBuilder)localObject).append(localDisplayMetrics.widthPixels);
    ((StringBuilder)localObject).append('*');
    ((StringBuilder)localObject).append(localDisplayMetrics.heightPixels);
    ((StringBuilder)localObject).append('&');
    ((StringBuilder)localObject).append("f=");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append('&');
    ((StringBuilder)localObject).append("mm=");
    ((StringBuilder)localObject).append(DeviceInfoUtil.a() / 1048576L);
    ((StringBuilder)localObject).append('&');
    ((StringBuilder)localObject).append("cf=");
    ((StringBuilder)localObject).append(DeviceInfoUtil.b());
    ((StringBuilder)localObject).append('&');
    ((StringBuilder)localObject).append("cc=");
    ((StringBuilder)localObject).append(DeviceInfoUtil.b());
    ((StringBuilder)localObject).append('&');
    ((StringBuilder)localObject).append("qqversion=");
    ((StringBuilder)localObject).append("8.7.0");
    return ((StringBuilder)localObject).toString();
  }
  
  public String getVersionName()
  {
    String str = versionName;
    if ((str == null) || (str.length() == 0)) {
      getVersion();
    }
    return versionName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.PlatformInfor
 * JD-Core Version:    0.7.0.1
 */