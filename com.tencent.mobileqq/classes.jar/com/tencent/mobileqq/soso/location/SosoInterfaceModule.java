package com.tencent.mobileqq.soso.location;

import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class SosoInterfaceModule
  extends QIPCModule
{
  public static final String ACTION_GET_LBS_INFO = "get_lbs_info";
  public static final String ACTION_SET_LBS_INFO = "set_lbs_info";
  public static final String NAME = "soso_interface";
  private static final String TAG = "SOSO.LBS.SosoInterfaceModule";
  private static Object sLock = new Object();
  private static volatile SosoInterfaceModule sSosoInterfaceModule;
  
  private SosoInterfaceModule(String paramString)
  {
    super(paramString);
  }
  
  public static SosoInterfaceModule getInterface()
  {
    if (sSosoInterfaceModule != null) {
      return sSosoInterfaceModule;
    }
    synchronized (sLock)
    {
      if (sSosoInterfaceModule != null)
      {
        localSosoInterfaceModule = sSosoInterfaceModule;
        return localSosoInterfaceModule;
      }
      sSosoInterfaceModule = new SosoInterfaceModule("soso_interface");
      SosoInterfaceModule localSosoInterfaceModule = sSosoInterfaceModule;
      return localSosoInterfaceModule;
    }
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCall s: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("SOSO.LBS.SosoInterfaceModule", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1;
    if ("get_lbs_info".equals(paramString))
    {
      bool1 = paramBundle.getBoolean("req_location");
      long l = paramBundle.getLong("max_cache_interval");
      boolean bool2 = paramBundle.getBoolean("goon");
      paramInt = paramBundle.getInt("level");
      try
      {
        paramString = (ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class);
        try
        {
          paramString = paramString.getCanUsedLbsInfoCache(l, bool2, paramInt, bool1);
        }
        catch (Exception paramString) {}
        if (!QLog.isColorLevel()) {
          break label128;
        }
      }
      catch (Exception paramString) {}
      QLog.i("SOSO.LBS.SosoInterfaceModule", 2, Log.getStackTraceString(paramString));
      label128:
      paramString = null;
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onCall action on get lbs info : maxCacheInterval: ");
        paramBundle.append(l);
        paramBundle.append(" goonListener: ");
        paramBundle.append(bool2);
        paramBundle.append(" level: ");
        paramBundle.append(paramInt);
        paramBundle.append(" reqLocation:");
        paramBundle.append(bool1);
        paramBundle.append(" lbsInfo is null: ");
        if (paramString == null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        paramBundle.append(bool1);
        QLog.i("SOSO.LBS.SosoInterfaceModule", 2, paramBundle.toString());
      }
      paramBundle = new Bundle();
      localObject = new EIPCResult();
      ((EIPCResult)localObject).data = paramBundle;
      if (paramString != null)
      {
        ((EIPCResult)localObject).code = 0;
        paramBundle.putParcelable("soso_lbs_info", paramString);
        return localObject;
      }
      ((EIPCResult)localObject).code = -102;
      return localObject;
    }
    if ("set_lbs_info".equals(paramString))
    {
      paramBundle.setClassLoader(((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getSosoInterfaceClassLoader());
      bool1 = paramBundle.getBoolean("req_location");
      localObject = new Bundle();
      paramString = new EIPCResult();
      paramString.data = ((Bundle)localObject);
      if (bool1) {}
      try
      {
        ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).updateMainProcessCachedLocation(paramBundle.getInt("level"), (SosoLbsInfo)paramBundle.getParcelable("soso_lbs_info"));
      }
      catch (Exception paramBundle)
      {
        if (!QLog.isColorLevel()) {
          break label427;
        }
        QLog.i("SOSO.LBS.SosoInterfaceModule", 2, Log.getStackTraceString(paramBundle));
      }
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).updateRawData(paramBundle.getString("prodiver"), paramBundle.getByteArray("raw_data"));
      label427:
      paramString.code = 0;
      return paramString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.SosoInterfaceModule
 * JD-Core Version:    0.7.0.1
 */