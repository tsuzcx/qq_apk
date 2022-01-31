import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.utils.SignalStrengthReport.1;
import com.tencent.av.utils.SignalStrengthReport.2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import org.json.JSONObject;

public class mip
{
  static volatile mip jdField_a_of_type_Mip;
  public int a;
  WifiManager jdField_a_of_type_AndroidNetWifiWifiManager;
  public Handler a;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager;
  Runnable jdField_a_of_type_JavaLangRunnable = new SignalStrengthReport.1(this);
  public String a;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  mir jdField_a_of_type_Mir;
  public int b;
  Runnable b;
  int c = 0;
  int d = -1;
  
  private mip(Context paramContext)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangRunnable = new SignalStrengthReport.2(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    if (Looper.myLooper() != null) {
      this.jdField_a_of_type_Mir = new mir(this);
    }
    if (paramContext != null)
    {
      this.jdField_a_of_type_AndroidNetWifiWifiManager = ((WifiManager)paramContext.getSystemService("wifi"));
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)paramContext.getSystemService("phone"));
    }
  }
  
  private String a(long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(String.valueOf((int)(paramLong & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 8 & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 16 & 0xFF)));
    localStringBuffer.append('.');
    localStringBuffer.append(String.valueOf((int)(paramLong >> 24 & 0xFF)));
    return localStringBuffer.toString();
  }
  
  public static mip a(Context paramContext)
  {
    if (jdField_a_of_type_Mip == null) {}
    try
    {
      if (jdField_a_of_type_Mip == null) {
        jdField_a_of_type_Mip = new mip(paramContext);
      }
      return jdField_a_of_type_Mip;
    }
    finally {}
  }
  
  private String b()
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      if (this.jdField_a_of_type_AndroidNetWifiWifiManager != null)
      {
        DhcpInfo localDhcpInfo = this.jdField_a_of_type_AndroidNetWifiWifiManager.getDhcpInfo();
        str1 = str2;
        if (localDhcpInfo != null) {
          str1 = a(localDhcpInfo.gateway);
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      krx.c("SignalStrengthReport", "getGateway e:" + localException);
    }
    return "";
  }
  
  private static int f()
  {
    int i = 0;
    if (AppNetConnInfo.isWifiConn()) {
      i = 1;
    }
    while (!AppNetConnInfo.isMobileConn()) {
      return i;
    }
    switch (AppNetConnInfo.getMobileInfo())
    {
    default: 
      return 0;
    case 1: 
      return 2;
    case 2: 
      return 3;
    case 3: 
      return 4;
    }
    return 5;
  }
  
  private int g()
  {
    int j = -1;
    int i = j;
    try
    {
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
      {
        i = j;
        if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
        {
          Object localObject = EffectConfigBase.b(218, EffectConfigBase.d);
          i = j;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            krx.c("SignalStrengthReport", "getPingInterval config:" + (String)localObject);
            localObject = new JSONObject((String)localObject);
            i = j;
            if (((JSONObject)localObject).has("pingInterval"))
            {
              i = ((JSONObject)localObject).getInt("pingInterval");
              j = i;
              i = j;
              if (j >= 0)
              {
                i = j;
                if (j < 2000) {
                  return 2000;
                }
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      krx.c("SignalStrengthReport", "getPingInterval e:" + localException);
      i = j;
    }
    return i;
  }
  
  public int a()
  {
    return this.d;
  }
  
  int a(SignalStrength paramSignalStrength)
  {
    int j = 100;
    int k = 0;
    int i = 0;
    if (paramSignalStrength != null) {
      i = k;
    }
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          i = Integer.parseInt(Class.forName(SignalStrength.class.getName()).getDeclaredMethod("getLevel", new Class[0]).invoke(paramSignalStrength, new Object[0]).toString());
          k = i * 25;
          i = k;
          if (k > 100)
          {
            i = j;
            return i;
          }
        }
      }
      catch (Exception paramSignalStrength)
      {
        krx.c("SignalStrengthReport", "getLevelPercentBySignalStrength reflect getLevel e:" + paramSignalStrength);
        return 0;
      }
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidOsHandlerThread != null) && (this.jdField_a_of_type_AndroidOsHandlerThread.isAlive())) {}
    do
    {
      return;
      krx.c("SignalStrengthReport", "report start");
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("SignalStrengthReportThread" + (int)(Math.random() * 100.0D));
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      this.jdField_a_of_type_Int = g();
      this.jdField_a_of_type_JavaLangString = "";
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_b_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_b_of_type_JavaLangRunnable);
      }
    } while ((this.jdField_a_of_type_Mir == null) || (this.jdField_a_of_type_AndroidTelephonyTelephonyManager == null));
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_Mir, 256);
  }
  
  public int b()
  {
    return this.c;
  }
  
  /* Error */
  int b(SignalStrength paramSignalStrength)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 4
    //   3: iload 4
    //   5: istore_2
    //   6: aload_1
    //   7: ifnull +78 -> 85
    //   10: ldc 210
    //   12: invokevirtual 215	java/lang/Class:getName	()Ljava/lang/String;
    //   15: invokestatic 219	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   18: ldc_w 287
    //   21: iconst_0
    //   22: anewarray 212	java/lang/Class
    //   25: invokevirtual 225	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   28: aload_1
    //   29: iconst_0
    //   30: anewarray 4	java/lang/Object
    //   33: invokevirtual 231	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   36: invokevirtual 232	java/lang/Object:toString	()Ljava/lang/String;
    //   39: invokestatic 237	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   42: istore_2
    //   43: iload_2
    //   44: iconst_m1
    //   45: if_icmpne +143 -> 188
    //   48: aload_1
    //   49: invokevirtual 290	android/telephony/SignalStrength:isGsm	()Z
    //   52: ifeq +68 -> 120
    //   55: aload_1
    //   56: invokevirtual 293	android/telephony/SignalStrength:getGsmSignalStrength	()I
    //   59: istore_2
    //   60: iload_2
    //   61: istore_3
    //   62: iload_2
    //   63: bipush 99
    //   65: if_icmpne +5 -> 70
    //   68: iconst_m1
    //   69: istore_3
    //   70: iload 4
    //   72: istore_2
    //   73: iload_3
    //   74: iconst_m1
    //   75: if_icmpeq +10 -> 85
    //   78: iload_3
    //   79: iconst_2
    //   80: imul
    //   81: bipush 113
    //   83: isub
    //   84: istore_2
    //   85: iload_2
    //   86: ireturn
    //   87: astore 5
    //   89: ldc 131
    //   91: new 133	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 295
    //   101: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload 5
    //   106: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 148	krx:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: iconst_m1
    //   116: istore_2
    //   117: goto -74 -> 43
    //   120: aload_1
    //   121: invokevirtual 298	android/telephony/SignalStrength:getCdmaDbm	()I
    //   124: istore 4
    //   126: aload_1
    //   127: invokevirtual 301	android/telephony/SignalStrength:getEvdoDbm	()I
    //   130: istore_3
    //   131: iload_3
    //   132: bipush 136
    //   134: if_icmpne +6 -> 140
    //   137: iload 4
    //   139: ireturn
    //   140: iload_3
    //   141: istore_2
    //   142: iload 4
    //   144: bipush 136
    //   146: if_icmpeq -61 -> 85
    //   149: iload_3
    //   150: istore_2
    //   151: iload 4
    //   153: iload_3
    //   154: if_icmpge -69 -> 85
    //   157: iload 4
    //   159: ireturn
    //   160: astore_1
    //   161: ldc 131
    //   163: new 133	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 303
    //   173: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_1
    //   177: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 148	krx:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: iconst_m1
    //   187: ireturn
    //   188: iload_2
    //   189: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	mip
    //   0	190	1	paramSignalStrength	SignalStrength
    //   5	184	2	i	int
    //   61	94	3	j	int
    //   1	157	4	k	int
    //   87	18	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   10	43	87	java/lang/Exception
    //   48	60	160	java/lang/Exception
    //   120	131	160	java/lang/Exception
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      if (this.jdField_b_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      }
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    this.jdField_a_of_type_Int = -1;
    if ((this.jdField_a_of_type_Mir != null) && (this.jdField_a_of_type_AndroidTelephonyTelephonyManager != null)) {
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_Mir, 0);
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    this.jdField_a_of_type_JavaLangString = "";
    krx.c("SignalStrengthReport", "report stop");
  }
  
  public int c()
  {
    int j = 0;
    int i = j;
    try
    {
      if (this.jdField_a_of_type_AndroidNetWifiWifiManager != null)
      {
        WifiInfo localWifiInfo = this.jdField_a_of_type_AndroidNetWifiWifiManager.getConnectionInfo();
        i = j;
        if (localWifiInfo.getBSSID() != null)
        {
          i = WifiManager.calculateSignalLevel(localWifiInfo.getRssi(), 5);
          j = i * 25;
          i = j;
          if (j > 100) {
            return 100;
          }
        }
      }
    }
    catch (Exception localException)
    {
      krx.c("SignalStrengthReport", "getWifiLevelPercent e:" + localException);
      i = j;
    }
    return i;
  }
  
  public int d()
  {
    int j = -1;
    int i = j;
    try
    {
      if (this.jdField_a_of_type_AndroidNetWifiWifiManager != null)
      {
        WifiInfo localWifiInfo = this.jdField_a_of_type_AndroidNetWifiWifiManager.getConnectionInfo();
        i = j;
        if (localWifiInfo != null)
        {
          i = j;
          if (localWifiInfo.getBSSID() != null) {
            i = localWifiInfo.getRssi();
          }
        }
      }
      return i;
    }
    catch (Exception localException)
    {
      krx.c("SignalStrengthReport", "getWifiDbm e:" + localException);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mip
 * JD-Core Version:    0.7.0.1
 */