package cooperation.qzone.sim;

import android.content.Context;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.internal.telephony.ISub;
import com.android.internal.telephony.ISub.Stub;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Method;
import java.util.HashMap;

public abstract class SimManager
{
  SimManager.DeviceMoreInfo jdField_a_of_type_CooperationQzoneSimSimManager$DeviceMoreInfo = new SimManager.DeviceMoreInfo(this);
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private ISub a()
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
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  private void a(int paramInt, SimInfo paramSimInfo)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramSimInfo);
    }
  }
  
  private int b(Context paramContext)
  {
    try
    {
      a(10, DeviceInfoUtil.a(paramContext));
      a(10, Boolean.valueOf(true));
      return 0;
    }
    catch (Throwable paramContext)
    {
      QZLog.e("UniKingCardHelper/SimManager", "initMainIMSI error:" + paramContext.getMessage());
    }
    return -3;
  }
  
  private int c(Context paramContext)
  {
    try
    {
      b(10, DeviceInfoUtil.b(paramContext));
      return 0;
    }
    catch (Throwable paramContext)
    {
      QZLog.e("UniKingCardHelper/SimManager", "initMainPhoneNum error:" + paramContext.getMessage());
    }
    return -3;
  }
  
  int a(Context paramContext)
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
  
  public abstract int a(Context paramContext, int[] paramArrayOfInt);
  
  public abstract int a(ISub paramISub);
  
  public SimInfo a()
  {
    int j = 0;
    int i;
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      i = 0;
      if (i <= 10)
      {
        localObject = a(i);
        if ((localObject == null) || (!((SimInfo)localObject).a()) || (TextUtils.isEmpty(((SimInfo)localObject).b()))) {}
      }
    }
    SimInfo localSimInfo;
    label98:
    do
    {
      return localObject;
      i += 1;
      break;
      if (this.jdField_a_of_type_JavaUtilHashMap != null)
      {
        i = 0;
        for (;;)
        {
          if (i > 10) {
            break label98;
          }
          localSimInfo = a(i);
          if (localSimInfo != null)
          {
            localObject = localSimInfo;
            if (localSimInfo.a()) {
              break;
            }
          }
          i += 1;
        }
      }
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {
        break label132;
      }
      localSimInfo = a(10);
      if (localSimInfo == null) {
        break label132;
      }
      localObject = localSimInfo;
    } while (!TextUtils.isEmpty(localSimInfo.b()));
    label132:
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      i = j;
      for (;;)
      {
        if (i > 10) {
          break label169;
        }
        localSimInfo = a(i);
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
  
  public SimInfo a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))) {
      return (SimInfo)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public void a(int paramInt, Boolean paramBoolean)
  {
    SimInfo localSimInfo2 = a(paramInt);
    SimInfo localSimInfo1 = localSimInfo2;
    if (localSimInfo2 == null) {
      localSimInfo1 = new SimInfo();
    }
    localSimInfo1.a(paramBoolean.booleanValue());
    a(paramInt, localSimInfo1);
  }
  
  public void a(int paramInt, String paramString)
  {
    SimInfo localSimInfo2 = a(paramInt);
    SimInfo localSimInfo1 = localSimInfo2;
    if (localSimInfo2 == null) {
      localSimInfo1 = new SimInfo();
    }
    localSimInfo1.a(paramString);
    a(paramInt, localSimInfo1);
  }
  
  public void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    long l = System.currentTimeMillis();
    try
    {
      a();
      b(paramContext);
      c(paramContext);
      ISub localISub = a();
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
      this.jdField_a_of_type_CooperationQzoneSimSimManager$DeviceMoreInfo.jdField_a_of_type_Int = i;
      if ((i > 1) && (a(paramContext) != 11))
      {
        this.jdField_a_of_type_CooperationQzoneSimSimManager$DeviceMoreInfo.jdField_a_of_type_Boolean = true;
        a(paramContext, arrayOfInt1);
        b(paramContext, arrayOfInt1);
        if (a(localISub) != 0) {
          c(paramContext, arrayOfInt1);
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
      this.jdField_a_of_type_CooperationQzoneSimSimManager$DeviceMoreInfo.jdField_a_of_type_Long = (System.currentTimeMillis() - l);
    }
  }
  
  public abstract int b(Context paramContext, int[] paramArrayOfInt);
  
  public void b(int paramInt, String paramString)
  {
    SimInfo localSimInfo2 = a(paramInt);
    SimInfo localSimInfo1 = localSimInfo2;
    if (localSimInfo2 == null) {
      localSimInfo1 = new SimInfo();
    }
    localSimInfo1.b(paramString);
    a(paramInt, localSimInfo1);
  }
  
  public abstract int c(Context paramContext, int[] paramArrayOfInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.sim.SimManager
 * JD-Core Version:    0.7.0.1
 */