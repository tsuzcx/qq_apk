package cooperation.qzone.sim;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.internal.telephony.ISub;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Method;

class SimManagerDefault
  extends SimManager
{
  static final int INVOKE_TYPE_DATA = 3;
  static final int INVOKE_TYPE_IMSI = 1;
  static final int INVOKE_TYPE_PHONE_NUM = 2;
  static final int METHOD_NONE = -1;
  protected static final String TAG = "UniKingCardHelper/SimManager";
  static int mMethodDataIndex = -1;
  static int mMethodIMSIIndex = -1;
  static int mMethodPhoneNumIndex = -1;
  
  public int initAllDataByAIDL(ISub paramISub)
  {
    if (paramISub == null) {
      return -2;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = paramISub.d();
        if (j >= 0)
        {
          i = 0;
          bool = true;
          if (i <= 10)
          {
            paramISub = getSimInfo(i);
            if (paramISub == null) {
              break label159;
            }
            if (i != j) {
              break label153;
            }
            paramISub.setIsDataTrafficSim(bool);
            break label159;
          }
          paramISub = getSimInfo(j);
          if ((paramISub != null) && (!TextUtils.isEmpty(paramISub.getIMSI())))
          {
            localObject = getSimInfo(10);
            if ((localObject != null) && (paramISub.getIMSI().equals(((SimInfo)localObject).getIMSI()))) {
              ((SimInfo)localObject).setIsDataTrafficSim(true);
            }
          }
          return 0;
        }
      }
      catch (Throwable paramISub)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initAllDataByAIDL 1 error:");
        ((StringBuilder)localObject).append(paramISub.getMessage());
        QZLog.e("UniKingCardHelper/SimManager", ((StringBuilder)localObject).toString());
      }
      return -3;
      label153:
      boolean bool = false;
      continue;
      label159:
      i += 1;
    }
  }
  
  protected int initAllDataByAPI(Context paramContext, int[] paramArrayOfInt)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    Class localClass = localTelephonyManager.getClass();
    int i = mMethodDataIndex;
    boolean bool3 = false;
    paramContext = null;
    Method localMethod = null;
    if ((i == -1) || (i == 1))
    {
      paramContext = localMethod;
      try
      {
        localMethod = localClass.getDeclaredMethod("initAllDataByAPI", new Class[] { Integer.TYPE });
        paramContext = localMethod;
        mMethodDataIndex = 1;
        paramContext = localMethod;
      }
      catch (Throwable localThrowable1)
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("initAllDataByAPI 1 error:");
        localStringBuilder1.append(localThrowable1.getMessage());
        QZLog.e("UniKingCardHelper/SimManager", localStringBuilder1.toString());
      }
    }
    i = mMethodDataIndex;
    boolean bool2;
    Object localObject1;
    if ((i != -1) && (i != 2))
    {
      bool2 = true;
      localObject1 = paramContext;
    }
    else
    {
      try
      {
        localObject1 = localClass.getDeclaredMethod("initAllDataByAPI", new Class[] { Long.TYPE });
        try
        {
          mMethodDataIndex = 2;
          bool2 = false;
        }
        catch (Throwable localThrowable4)
        {
          bool2 = false;
          paramContext = (Context)localObject1;
        }
        localObject1 = new StringBuilder();
      }
      catch (Throwable localThrowable5)
      {
        bool2 = true;
      }
      ((StringBuilder)localObject1).append("initAllDataByAPI 2 error:");
      ((StringBuilder)localObject1).append(localThrowable5.getMessage());
      QZLog.e("UniKingCardHelper/SimManager", ((StringBuilder)localObject1).toString());
      localObject1 = paramContext;
    }
    i = mMethodDataIndex;
    boolean bool1;
    Object localObject2;
    if (i != -1)
    {
      bool1 = bool2;
      paramContext = (Context)localObject1;
      if (i != 3) {}
    }
    else
    {
      try
      {
        paramContext = localClass.getDeclaredMethod("getDataEnabled", new Class[] { Integer.TYPE });
        try
        {
          mMethodDataIndex = 3;
          bool1 = true;
        }
        catch (Throwable localThrowable2)
        {
          bool1 = true;
        }
        localStringBuilder2 = new StringBuilder();
      }
      catch (Throwable localThrowable6)
      {
        paramContext = localThrowable2;
        bool1 = bool2;
        localObject2 = localThrowable6;
      }
      StringBuilder localStringBuilder2;
      localStringBuilder2.append("initAllDataByAPI 3 error:");
      localStringBuilder2.append(((Throwable)localObject2).getMessage());
      QZLog.e("UniKingCardHelper/SimManager", localStringBuilder2.toString());
    }
    i = mMethodDataIndex;
    if (i != -1)
    {
      bool2 = bool1;
      localObject2 = paramContext;
      if (i == 4) {}
    }
    Context localContext;
    for (;;)
    {
      break;
      try
      {
        localObject2 = localClass.getDeclaredMethod("getDataEnabled", new Class[] { Long.TYPE });
        try
        {
          mMethodDataIndex = 4;
          bool2 = bool3;
        }
        catch (Throwable localThrowable7)
        {
          bool1 = false;
          paramContext = (Context)localObject2;
          localObject2 = localThrowable7;
        }
        localStringBuilder3 = new StringBuilder();
      }
      catch (Throwable localThrowable3) {}
      StringBuilder localStringBuilder3;
      localStringBuilder3.append("initAllDataByAPI 4 error:");
      localStringBuilder3.append(localThrowable3.getMessage());
      QZLog.e("UniKingCardHelper/SimManager", localStringBuilder3.toString());
      bool2 = bool1;
      localContext = paramContext;
    }
    if ((mMethodDataIndex != -1) && (localContext != null)) {
      return invokeMethod(3, localTelephonyManager, paramArrayOfInt, localContext, bool2);
    }
    return -2;
  }
  
  public int initAllIMSI(Context paramContext, int[] paramArrayOfInt)
  {
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    Class localClass = localTelephonyManager.getClass();
    int i = mMethodIMSIIndex;
    boolean bool1 = true;
    boolean bool2 = true;
    paramContext = null;
    Method localMethod = null;
    if ((i == -1) || (i == 1))
    {
      paramContext = localMethod;
      try
      {
        localMethod = localClass.getDeclaredMethod("getSubscriberId", new Class[] { Integer.TYPE });
        paramContext = localMethod;
        mMethodIMSIIndex = 1;
        paramContext = localMethod;
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
    }
    i = mMethodIMSIIndex;
    Object localObject;
    Context localContext;
    if (i != -1)
    {
      localObject = paramContext;
      if (i != 2) {}
    }
    else
    {
      try
      {
        localObject = localClass.getDeclaredMethod("getSubscriberId", new Class[] { Long.TYPE });
        try
        {
          mMethodIMSIIndex = 2;
          bool1 = false;
        }
        catch (Throwable localThrowable3)
        {
          bool1 = false;
          paramContext = (Context)localObject;
          localObject = localThrowable3;
        }
        localStringBuilder = new StringBuilder();
      }
      catch (Throwable localThrowable2)
      {
        bool1 = bool2;
      }
      StringBuilder localStringBuilder;
      localStringBuilder.append("initAllIMSI error:");
      localStringBuilder.append(localThrowable2.getMessage());
      QZLog.e("UniKingCardHelper/SimManager", localStringBuilder.toString());
      localContext = paramContext;
    }
    if ((mMethodIMSIIndex != -1) && (localContext != null)) {
      return invokeMethod(1, localTelephonyManager, paramArrayOfInt, localContext, bool1);
    }
    return -2;
  }
  
  protected int initAllPhoneNum(Context paramContext, int[] paramArrayOfInt)
  {
    return -3;
  }
  
  int invokeMethod(int paramInt, TelephonyManager paramTelephonyManager, int[] paramArrayOfInt, Method paramMethod, boolean paramBoolean)
  {
    int i = 0;
    while (i < 9)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
      {
        int k = paramArrayOfInt.length;
        int j = 0;
        while (j < k)
        {
          if (paramArrayOfInt[j] == i)
          {
            j = 1;
            break label60;
          }
          j += 1;
        }
        j = 0;
        label60:
        if (j == 0) {}
      }
      else
      {
        Object localObject;
        if (paramBoolean) {
          localObject = paramMethod.invoke(paramTelephonyManager, new Object[] { Integer.valueOf(i) });
        } else {
          localObject = paramMethod.invoke(paramTelephonyManager, new Object[] { Long.valueOf(i) });
        }
        if (localObject != null) {
          if (paramInt != 1)
          {
            if (paramInt != 2)
            {
              if (paramInt == 3) {
                updataSimDataEnable(i, (Boolean)localObject);
              }
            }
            else {
              updataSimPhoneNum(i, localObject.toString());
            }
          }
          else {
            updataSimImsi(i, localObject.toString());
          }
        }
      }
      i += 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.sim.SimManagerDefault
 * JD-Core Version:    0.7.0.1
 */