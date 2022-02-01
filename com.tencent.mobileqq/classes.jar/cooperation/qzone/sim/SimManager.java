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
    if (this.mSinInfos != null) {
      this.mSinInfos.put(Integer.valueOf(paramInt), paramSimInfo);
    }
  }
  
  private void clear()
  {
    if (this.mSinInfos != null) {
      this.mSinInfos.clear();
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
      QZLog.e("UniKingCardHelper/SimManager", "getIsub error:" + localThrowable.getMessage());
    }
    return null;
  }
  
  private int initMainIMSI(Context paramContext)
  {
    try
    {
      String str = DeviceInfoUtil.getIMSI(paramContext);
      paramContext = str;
      if (TextUtils.isEmpty(str)) {
        paramContext = PlatformInfor.g().getIMSI();
      }
      updataSimImsi(10, paramContext);
      updataSimDataEnable(10, Boolean.valueOf(true));
      return 0;
    }
    catch (Throwable paramContext)
    {
      QZLog.e("UniKingCardHelper/SimManager", "initMainIMSI error:" + paramContext.getMessage());
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
      QZLog.e("UniKingCardHelper/SimManager", "initMainPhoneNum error:" + paramContext.getMessage());
    }
    return -3;
  }
  
  public SimInfo getDataSimInfo()
  {
    int j = 0;
    int i;
    Object localObject;
    if (this.mSinInfos != null)
    {
      i = 0;
      if (i <= 10)
      {
        localObject = getSimInfo(i);
        if ((localObject == null) || (!((SimInfo)localObject).isIseDataTrafficSim()) || (TextUtils.isEmpty(((SimInfo)localObject).getPhoneNum()))) {}
      }
    }
    SimInfo localSimInfo;
    label98:
    do
    {
      return localObject;
      i += 1;
      break;
      if (this.mSinInfos != null)
      {
        i = 0;
        for (;;)
        {
          if (i > 10) {
            break label98;
          }
          localSimInfo = getSimInfo(i);
          if (localSimInfo != null)
          {
            localObject = localSimInfo;
            if (localSimInfo.isIseDataTrafficSim()) {
              break;
            }
          }
          i += 1;
        }
      }
      if (this.mSinInfos == null) {
        break label132;
      }
      localSimInfo = getSimInfo(10);
      if (localSimInfo == null) {
        break label132;
      }
      localObject = localSimInfo;
    } while (!TextUtils.isEmpty(localSimInfo.getPhoneNum()));
    label132:
    if (this.mSinInfos != null)
    {
      i = j;
      for (;;)
      {
        if (i > 10) {
          break label169;
        }
        localSimInfo = getSimInfo(i);
        localObject = localSimInfo;
        if (localSimInfo != null) {
          break;
        }
        i += 1;
      }
    }
    label169:
    return null;
  }
  
  public SimManager.DeviceMoreInfo getDeviceMoreInfo()
  {
    return this.mDeviceMoreInfo;
  }
  
  public SimInfo getSencodarySimInfo()
  {
    int k = 0;
    SimInfo localSimInfo1;
    if (this.mSinInfos != null)
    {
      localSimInfo1 = getDataSimInfo();
      if (localSimInfo1 != null) {}
    }
    else
    {
      return null;
    }
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
    do
    {
      j += 1;
      if (j > 10) {
        break;
      }
      localSimInfo2 = getSimInfo(j);
    } while ((localSimInfo2 == null) || (TextUtils.isEmpty(localSimInfo2.getIMSI())) || (localSimInfo2.getIMSI().equals(localSimInfo1.getIMSI())));
    return localSimInfo2;
  }
  
  SimInfo getSimInfo(int paramInt)
  {
    if ((this.mSinInfos != null) && (this.mSinInfos.containsKey(Integer.valueOf(paramInt)))) {
      return (SimInfo)this.mSinInfos.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public SimInfo getSimInfoOfIMSI(String paramString)
  {
    int k = 0;
    if ((this.mSinInfos != null) && (!TextUtils.isEmpty(paramString)))
    {
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
      do
      {
        j += 1;
        if (j > 10) {
          break;
        }
        localSimInfo = getSimInfo(j);
      } while ((localSimInfo == null) || (!paramString.equals(localSimInfo.getIMSI())));
      return localSimInfo;
    }
    return null;
  }
  
  abstract int initAllDataByAIDL(ISub paramISub);
  
  abstract int initAllDataByAPI(Context paramContext, int[] paramArrayOfInt);
  
  abstract int initAllIMSI(Context paramContext, int[] paramArrayOfInt);
  
  public void initAllInfo(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    long l = System.currentTimeMillis();
    try
    {
      clear();
      initMainIMSI(paramContext);
      initMainPhoneNum(paramContext);
      ISub localISub = getIsub();
      j = 2;
      int[] arrayOfInt2 = null;
      int[] arrayOfInt1 = null;
      i = j;
      if (localISub != null) {
        arrayOfInt1 = arrayOfInt2;
      }
      try
      {
        arrayOfInt2 = localISub.a();
        i = j;
        arrayOfInt1 = arrayOfInt2;
        if (arrayOfInt2 != null)
        {
          arrayOfInt1 = arrayOfInt2;
          i = arrayOfInt2.length;
          arrayOfInt1 = arrayOfInt2;
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QZLog.e("UniKingCardHelper/SimManager", "getActiveSubIdList error:" + localThrowable.getMessage());
          i = j;
        }
      }
      this.mDeviceMoreInfo.mSubCount = i;
      if ((i > 1) && (isMultiSimEnabled(paramContext) != 11))
      {
        this.mDeviceMoreInfo.mIsMultiSimEnabled = true;
        initAllIMSI(paramContext, arrayOfInt1);
        initAllPhoneNum(paramContext, arrayOfInt1);
        if (initAllDataByAIDL(localISub) != 0) {
          initAllDataByAPI(paramContext, arrayOfInt1);
        }
      }
      return;
    }
    catch (Throwable paramContext)
    {
      int j;
      int i;
      QZLog.e("UniKingCardHelper/SimManager", "initAllInfo error:" + paramContext.getMessage());
      return;
    }
    finally
    {
      this.mDeviceMoreInfo.mGetInfoCostTime = (System.currentTimeMillis() - l);
    }
  }
  
  abstract int initAllPhoneNum(Context paramContext, int[] paramArrayOfInt);
  
  int isMultiSimEnabled(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      Method localMethod = TelephonyManager.class.getMethod("isMultiSimEnabled", new Class[0]);
      if (localMethod != null)
      {
        boolean bool = ((Boolean)localMethod.invoke(paramContext, new Object[0])).booleanValue();
        if (bool) {
          return 10;
        }
        return 11;
      }
    }
    catch (Throwable paramContext)
    {
      QZLog.e("UniKingCardHelper/SimManager", "isMultiSimEnabled error:" + paramContext.getMessage());
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
      if (this.mSinInfos == null) {
        return;
      }
      this.mDeviceMoreInfo.mDataSimInfo = getDataSimInfo();
      this.mDeviceMoreInfo.mSencondarySimInfo = getSencodarySimInfo();
      if ((this.mDeviceMoreInfo.mDataSimInfo != null) && (this.mDeviceMoreInfo.mSencondarySimInfo != null))
      {
        this.mDeviceMoreInfo.mUseSimCount = 2;
        return;
      }
      if ((this.mDeviceMoreInfo.mDataSimInfo != null) || (this.mDeviceMoreInfo.mSencondarySimInfo != null))
      {
        this.mDeviceMoreInfo.mUseSimCount = 1;
        return;
      }
    }
    catch (Exception localException)
    {
      QZLog.e("UniKingCardHelper/SimManager", "error:" + localException.getMessage());
      return;
    }
    this.mDeviceMoreInfo.mUseSimCount = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.sim.SimManager
 * JD-Core Version:    0.7.0.1
 */