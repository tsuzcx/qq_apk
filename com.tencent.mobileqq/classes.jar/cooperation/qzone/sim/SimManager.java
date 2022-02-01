package cooperation.qzone.sim;

import android.content.Context;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.internal.telephony.ISub;
import com.android.internal.telephony.ISub.Stub;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Method;
import java.util.HashMap;

public abstract class SimManager
{
  static final int MAIN_SIM_INDEX = 10;
  static final int RET_IS_MUTI_SIM = 10;
  static final int RET_IS_NOT_MUTI_SIM = 11;
  static final int RET_NO_SUCH_METHOD = -2;
  static final int RET_OTHER_WORNG = -3;
  static final int RET_SUCCESS = 0;
  private static final String TAG = "UniKingCardHelper/SimManager";
  static final int TRY_SIM_INDEX = 9;
  private static SimManager mInstance;
  SimManager.DeviceMoreInfo mDeviceMoreInfo = new SimManager.DeviceMoreInfo(this);
  HashMap<Integer, SimInfo> mSinInfos = new HashMap();
  
  private void addSimInfo(int paramInt, SimInfo paramSimInfo)
  {
    HashMap localHashMap = this.mSinInfos;
    if (localHashMap != null) {
      localHashMap.put(Integer.valueOf(paramInt), paramSimInfo);
    }
  }
  
  private void clear()
  {
    HashMap localHashMap = this.mSinInfos;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public static SimManager getInstance(String paramString, int paramInt)
  {
    if (mInstance == null) {
      mInstance = SimManagerFectory.createProduct(paramString, paramInt);
    }
    return mInstance;
  }
  
  private ISub getIsub()
  {
    try
    {
      ISub localISub = ISub.Stub.a((IBinder)Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "isub" }));
      return localISub;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIsub error:");
      localStringBuilder.append(localThrowable.getMessage());
      QZLog.e("UniKingCardHelper/SimManager", localStringBuilder.toString());
    }
    return null;
  }
  
  private int initMainIMSI(Context paramContext)
  {
    try
    {
      localObject = DeviceInfoUtil.getIMSI(paramContext);
      paramContext = (Context)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramContext = PlatformInfor.g().getIMSI();
      }
      updataSimImsi(10, paramContext);
      updataSimDataEnable(10, Boolean.valueOf(true));
      return 0;
    }
    catch (Throwable paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initMainIMSI error:");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      QZLog.e("UniKingCardHelper/SimManager", ((StringBuilder)localObject).toString());
    }
    return -3;
  }
  
  private int initMainPhoneNum(Context paramContext)
  {
    try
    {
      updataSimPhoneNum(10, DeviceInfoUtil.getPhoneNum(paramContext));
      return 0;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initMainPhoneNum error:");
      localStringBuilder.append(paramContext.getMessage());
      QZLog.e("UniKingCardHelper/SimManager", localStringBuilder.toString());
    }
    return -3;
  }
  
  public SimInfo getDataSimInfo()
  {
    Object localObject = this.mSinInfos;
    int j = 0;
    int i;
    if (localObject != null)
    {
      i = 0;
      while (i <= 10)
      {
        localObject = getSimInfo(i);
        if ((localObject != null) && (((SimInfo)localObject).isIseDataTrafficSim()) && (!TextUtils.isEmpty(((SimInfo)localObject).getPhoneNum()))) {
          return localObject;
        }
        i += 1;
      }
    }
    if (this.mSinInfos != null)
    {
      i = 0;
      while (i <= 10)
      {
        localObject = getSimInfo(i);
        if ((localObject != null) && (((SimInfo)localObject).isIseDataTrafficSim())) {
          return localObject;
        }
        i += 1;
      }
    }
    if (this.mSinInfos != null)
    {
      localObject = getSimInfo(10);
      if ((localObject != null) && (!TextUtils.isEmpty(((SimInfo)localObject).getPhoneNum()))) {
        return localObject;
      }
    }
    if (this.mSinInfos != null)
    {
      i = j;
      while (i <= 10)
      {
        localObject = getSimInfo(i);
        if (localObject != null) {
          return localObject;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public SimManager.DeviceMoreInfo getDeviceMoreInfo()
  {
    return this.mDeviceMoreInfo;
  }
  
  public SimInfo getSencodarySimInfo()
  {
    if (this.mSinInfos != null)
    {
      SimInfo localSimInfo1 = getDataSimInfo();
      if (localSimInfo1 == null) {
        return null;
      }
      int k = 0;
      int i = 0;
      SimInfo localSimInfo2;
      while (i <= 10)
      {
        localSimInfo2 = getSimInfo(i);
        if ((localSimInfo2 != null) && (!TextUtils.isEmpty(localSimInfo2.getIMSI())) && (!TextUtils.isEmpty(localSimInfo2.getPhoneNum())) && (!localSimInfo2.getIMSI().equals(localSimInfo1.getIMSI())) && (!localSimInfo2.getPhoneNum().equals(localSimInfo1.getPhoneNum()))) {
          return localSimInfo2;
        }
        i += 1;
      }
      i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i > 10) {
          break;
        }
        localSimInfo2 = getSimInfo(i);
        if ((localSimInfo2 != null) && (!TextUtils.isEmpty(localSimInfo2.getPhoneNum())) && (!localSimInfo2.getPhoneNum().equals(localSimInfo1.getPhoneNum()))) {
          return localSimInfo2;
        }
        i += 1;
      }
      while (j <= 10)
      {
        localSimInfo2 = getSimInfo(j);
        if ((localSimInfo2 != null) && (!TextUtils.isEmpty(localSimInfo2.getIMSI())) && (!localSimInfo2.getIMSI().equals(localSimInfo1.getIMSI()))) {
          return localSimInfo2;
        }
        j += 1;
      }
    }
    return null;
  }
  
  SimInfo getSimInfo(int paramInt)
  {
    HashMap localHashMap = this.mSinInfos;
    if ((localHashMap != null) && (localHashMap.containsKey(Integer.valueOf(paramInt)))) {
      return (SimInfo)this.mSinInfos.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public SimInfo getSimInfoOfIMSI(String paramString)
  {
    if ((this.mSinInfos != null) && (!TextUtils.isEmpty(paramString)))
    {
      int k = 0;
      int i = 0;
      int j;
      SimInfo localSimInfo;
      for (;;)
      {
        j = k;
        if (i >= 10) {
          break;
        }
        localSimInfo = getSimInfo(i);
        if ((localSimInfo != null) && (paramString.equals(localSimInfo.getIMSI())) && (!TextUtils.isEmpty(localSimInfo.getPhoneNum()))) {
          return localSimInfo;
        }
        i += 1;
      }
      while (j <= 10)
      {
        localSimInfo = getSimInfo(j);
        if ((localSimInfo != null) && (paramString.equals(localSimInfo.getIMSI()))) {
          return localSimInfo;
        }
        j += 1;
      }
    }
    return null;
  }
  
  abstract int initAllDataByAIDL(ISub paramISub);
  
  abstract int initAllDataByAPI(Context paramContext, int[] paramArrayOfInt);
  
  abstract int initAllIMSI(Context paramContext, int[] paramArrayOfInt);
  
  /* Error */
  public void initAllInfo(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: invokestatic 220	java/lang/System:currentTimeMillis	()J
    //   8: lstore 4
    //   10: aload_0
    //   11: invokespecial 221	cooperation/qzone/sim/SimManager:clear	()V
    //   14: aload_0
    //   15: aload_1
    //   16: invokespecial 223	cooperation/qzone/sim/SimManager:initMainIMSI	(Landroid/content/Context;)I
    //   19: pop
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial 225	cooperation/qzone/sim/SimManager:initMainPhoneNum	(Landroid/content/Context;)I
    //   25: pop
    //   26: aload_0
    //   27: invokespecial 227	cooperation/qzone/sim/SimManager:getIsub	()Lcom/android/internal/telephony/ISub;
    //   30: astore 8
    //   32: iconst_2
    //   33: istore_3
    //   34: aconst_null
    //   35: astore 6
    //   37: aconst_null
    //   38: astore 7
    //   40: iload_3
    //   41: istore_2
    //   42: aload 8
    //   44: ifnull +84 -> 128
    //   47: aload 7
    //   49: astore 6
    //   51: aload 8
    //   53: invokeinterface 233 1 0
    //   58: astore 7
    //   60: iload_3
    //   61: istore_2
    //   62: aload 7
    //   64: astore 6
    //   66: aload 7
    //   68: ifnull +60 -> 128
    //   71: aload 7
    //   73: astore 6
    //   75: aload 7
    //   77: arraylength
    //   78: istore_2
    //   79: aload 7
    //   81: astore 6
    //   83: goto +45 -> 128
    //   86: astore 7
    //   88: new 108	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   95: astore 9
    //   97: aload 9
    //   99: ldc 235
    //   101: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 9
    //   107: aload 7
    //   109: invokevirtual 119	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   112: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: ldc 20
    //   118: aload 9
    //   120: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 128	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: iload_3
    //   127: istore_2
    //   128: aload_0
    //   129: getfield 45	cooperation/qzone/sim/SimManager:mDeviceMoreInfo	Lcooperation/qzone/sim/SimManager$DeviceMoreInfo;
    //   132: iload_2
    //   133: putfield 238	cooperation/qzone/sim/SimManager$DeviceMoreInfo:mSubCount	I
    //   136: iload_2
    //   137: iconst_1
    //   138: if_icmple +54 -> 192
    //   141: aload_0
    //   142: aload_1
    //   143: invokevirtual 241	cooperation/qzone/sim/SimManager:isMultiSimEnabled	(Landroid/content/Context;)I
    //   146: bipush 11
    //   148: if_icmpeq +44 -> 192
    //   151: aload_0
    //   152: getfield 45	cooperation/qzone/sim/SimManager:mDeviceMoreInfo	Lcooperation/qzone/sim/SimManager$DeviceMoreInfo;
    //   155: iconst_1
    //   156: putfield 245	cooperation/qzone/sim/SimManager$DeviceMoreInfo:mIsMultiSimEnabled	Z
    //   159: aload_0
    //   160: aload_1
    //   161: aload 6
    //   163: invokevirtual 247	cooperation/qzone/sim/SimManager:initAllIMSI	(Landroid/content/Context;[I)I
    //   166: pop
    //   167: aload_0
    //   168: aload_1
    //   169: aload 6
    //   171: invokevirtual 250	cooperation/qzone/sim/SimManager:initAllPhoneNum	(Landroid/content/Context;[I)I
    //   174: pop
    //   175: aload_0
    //   176: aload 8
    //   178: invokevirtual 252	cooperation/qzone/sim/SimManager:initAllDataByAIDL	(Lcom/android/internal/telephony/ISub;)I
    //   181: ifeq +11 -> 192
    //   184: aload_0
    //   185: aload_1
    //   186: aload 6
    //   188: invokevirtual 254	cooperation/qzone/sim/SimManager:initAllDataByAPI	(Landroid/content/Context;[I)I
    //   191: pop
    //   192: aload_0
    //   193: getfield 45	cooperation/qzone/sim/SimManager:mDeviceMoreInfo	Lcooperation/qzone/sim/SimManager$DeviceMoreInfo;
    //   196: invokestatic 220	java/lang/System:currentTimeMillis	()J
    //   199: lload 4
    //   201: lsub
    //   202: putfield 258	cooperation/qzone/sim/SimManager$DeviceMoreInfo:mGetInfoCostTime	J
    //   205: return
    //   206: astore_1
    //   207: goto +45 -> 252
    //   210: astore_1
    //   211: new 108	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   218: astore 6
    //   220: aload 6
    //   222: ldc_w 260
    //   225: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 6
    //   231: aload_1
    //   232: invokevirtual 119	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   235: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: ldc 20
    //   241: aload 6
    //   243: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 128	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: goto -57 -> 192
    //   252: aload_0
    //   253: getfield 45	cooperation/qzone/sim/SimManager:mDeviceMoreInfo	Lcooperation/qzone/sim/SimManager$DeviceMoreInfo;
    //   256: invokestatic 220	java/lang/System:currentTimeMillis	()J
    //   259: lload 4
    //   261: lsub
    //   262: putfield 258	cooperation/qzone/sim/SimManager$DeviceMoreInfo:mGetInfoCostTime	J
    //   265: goto +5 -> 270
    //   268: aload_1
    //   269: athrow
    //   270: goto -2 -> 268
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	this	SimManager
    //   0	273	1	paramContext	Context
    //   41	98	2	i	int
    //   33	94	3	j	int
    //   8	252	4	l	long
    //   35	207	6	localObject	Object
    //   38	42	7	arrayOfInt	int[]
    //   86	22	7	localThrowable	Throwable
    //   30	147	8	localISub	ISub
    //   95	24	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   51	60	86	java/lang/Throwable
    //   75	79	86	java/lang/Throwable
    //   10	32	206	finally
    //   51	60	206	finally
    //   75	79	206	finally
    //   88	126	206	finally
    //   128	136	206	finally
    //   141	192	206	finally
    //   211	249	206	finally
    //   10	32	210	java/lang/Throwable
    //   88	126	210	java/lang/Throwable
    //   128	136	210	java/lang/Throwable
    //   141	192	210	java/lang/Throwable
  }
  
  abstract int initAllPhoneNum(Context paramContext, int[] paramArrayOfInt);
  
  int isMultiSimEnabled(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      localObject = TelephonyManager.class.getMethod("isMultiSimEnabled", new Class[0]);
      if (localObject != null)
      {
        boolean bool = ((Boolean)((Method)localObject).invoke(paramContext, new Object[0])).booleanValue();
        if (bool) {
          return 10;
        }
        return 11;
      }
    }
    catch (Throwable paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isMultiSimEnabled error:");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      QZLog.e("UniKingCardHelper/SimManager", ((StringBuilder)localObject).toString());
    }
    return -3;
  }
  
  void updataSimDataEnable(int paramInt, Boolean paramBoolean)
  {
    SimInfo localSimInfo2 = getSimInfo(paramInt);
    SimInfo localSimInfo1 = localSimInfo2;
    if (localSimInfo2 == null) {
      localSimInfo1 = new SimInfo();
    }
    localSimInfo1.setIsDataTrafficSim(paramBoolean.booleanValue());
    addSimInfo(paramInt, localSimInfo1);
  }
  
  void updataSimImsi(int paramInt, String paramString)
  {
    SimInfo localSimInfo2 = getSimInfo(paramInt);
    SimInfo localSimInfo1 = localSimInfo2;
    if (localSimInfo2 == null) {
      localSimInfo1 = new SimInfo();
    }
    localSimInfo1.setIMSI(paramString);
    addSimInfo(paramInt, localSimInfo1);
  }
  
  void updataSimPhoneNum(int paramInt, String paramString)
  {
    SimInfo localSimInfo2 = getSimInfo(paramInt);
    SimInfo localSimInfo1 = localSimInfo2;
    if (localSimInfo2 == null) {
      localSimInfo1 = new SimInfo();
    }
    localSimInfo1.setPhoneNum(paramString);
    addSimInfo(paramInt, localSimInfo1);
  }
  
  public void updateAllSimInfo()
  {
    try
    {
      if (this.mSinInfos != null)
      {
        this.mDeviceMoreInfo.mDataSimInfo = getDataSimInfo();
        this.mDeviceMoreInfo.mSencondarySimInfo = getSencodarySimInfo();
        if ((this.mDeviceMoreInfo.mDataSimInfo != null) && (this.mDeviceMoreInfo.mSencondarySimInfo != null))
        {
          this.mDeviceMoreInfo.mUseSimCount = 2;
          return;
        }
        if ((this.mDeviceMoreInfo.mDataSimInfo == null) && (this.mDeviceMoreInfo.mSencondarySimInfo == null))
        {
          this.mDeviceMoreInfo.mUseSimCount = 0;
          return;
        }
        this.mDeviceMoreInfo.mUseSimCount = 1;
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error:");
      localStringBuilder.append(localException.getMessage());
      QZLog.e("UniKingCardHelper/SimManager", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.sim.SimManager
 * JD-Core Version:    0.7.0.1
 */