package com.tencent.upload.network.route;

import android.text.TextUtils;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.network.NetworkState;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.StringUtils;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ServerRouteTable
{
  private static final String TAG = "ServerRouteTable";
  public final int code;
  private final UploadRoute defBakHostRoute;
  private final UploadRoute defHostRoute;
  private final IRouteIPProvider ipProvider;
  public final Const.FileType supportFileType;
  
  public ServerRouteTable(int paramInt, IRouteIPProvider paramIRouteIPProvider, String paramString1, String paramString2, Const.FileType paramFileType)
  {
    this.code = paramInt;
    if (!TextUtils.isEmpty(paramString1))
    {
      this.defHostRoute = new UploadRoute(paramString1, 80, IUploadRouteStrategy.RouteCategoryType.HOST);
      if (TextUtils.isEmpty(paramString1)) {
        break label78;
      }
    }
    label78:
    for (this.defBakHostRoute = new UploadRoute(paramString2, 80, IUploadRouteStrategy.RouteCategoryType.BACKUP);; this.defBakHostRoute = null)
    {
      this.supportFileType = paramFileType;
      this.ipProvider = paramIRouteIPProvider;
      return;
      this.defHostRoute = null;
      break;
    }
  }
  
  private final UploadRoute getBackupRoute()
  {
    Object localObject = this.ipProvider.getBakIps();
    if (localObject == null)
    {
      UploadLog.e("ServerRouteTable", "getBackupRoute:" + this + " return null!!");
      return null;
    }
    int i = UploadConfiguration.getCurrentOperatorCategory();
    int j;
    if (i == 4)
    {
      j = UploadConfiguration.getWifiOperatorCategory();
      UploadLog.i("[iplist] ServerRouteTable", "getBackupRoute:" + this + " currentOperatorCategory:" + i + " wifiOperatorCategory:" + j + " " + (String)localObject);
    }
    for (localObject = jsonToUploadRoute((String)localObject, j, 2); localObject == null; localObject = jsonToUploadRoute((String)localObject, i, 2))
    {
      UploadLog.w("[iplist] ServerRouteTable", "getBackupRoute:" + this + " return null!!");
      return null;
      UploadLog.i("[iplist] ServerRouteTable", "getBackupRoute:" + this + " currentOperatorCategory:" + i + " " + (String)localObject);
    }
    ((UploadRoute)localObject).setRouteCategory(IUploadRouteStrategy.RouteCategoryType.BACKUP);
    UploadLog.i("[iplist] ServerRouteTable", "getBackupRoute:" + this + " " + ((UploadRoute)localObject).toString());
    return localObject;
  }
  
  private final UploadRoute getHostRoute()
  {
    Object localObject = this.ipProvider.getHostUrl();
    if (localObject == null)
    {
      UploadLog.w("[iplist] ServerRouteTable", "getHostRoute:" + this + " return null!!");
      return null;
    }
    localObject = new UploadRoute((String)localObject, 80, IUploadRouteStrategy.RouteCategoryType.HOST);
    UploadLog.i("[iplist] ServerRouteTable", "getHostRoute:" + this + " " + ((UploadRoute)localObject).toString());
    return localObject;
  }
  
  private final UploadRoute getOptimumRoute()
  {
    if (this.ipProvider == null) {}
    do
    {
      return null;
      localObject = this.ipProvider.getOptIps();
    } while (localObject == null);
    int i = UploadConfiguration.getCurrentOperatorCategory();
    UploadLog.i("[iplist] ServerRouteTable", "getOptimumRoute:" + this + " currentOperatorCategory:" + i + " OptimumJsonString:" + (String)localObject);
    Object localObject = jsonToUploadRoute((String)localObject, i, 0);
    if (localObject == null)
    {
      UploadLog.w("[iplist] ServerRouteTable", "getOptimumRoute:" + this + " return null!!");
      return null;
    }
    ((UploadRoute)localObject).setRouteCategory(IUploadRouteStrategy.RouteCategoryType.OPTIMUM);
    UploadLog.i("[iplist] ServerRouteTable", "getOptimumRoute:" + this + " " + ((UploadRoute)localObject).toString());
    return localObject;
  }
  
  private List<UploadRoute> getV4UploadRoutes()
  {
    ArrayList localArrayList = new ArrayList();
    UploadRoute localUploadRoute1 = getOptimumRoute();
    if (localUploadRoute1 != null) {
      localArrayList.add(localUploadRoute1);
    }
    UploadRoute localUploadRoute2 = getHostRoute();
    if (localUploadRoute2 != null) {
      localArrayList.add(localUploadRoute2);
    }
    for (;;)
    {
      localUploadRoute2 = getBackupRoute();
      if ((localUploadRoute2 != null) && ((localUploadRoute1 == null) || (!localUploadRoute1.getIp().equals(localUploadRoute2.getIp())) || (!StringUtils.isIpv4String(localUploadRoute1.getIp())))) {
        localArrayList.add(localUploadRoute2);
      }
      if (localArrayList.size() == 0)
      {
        if (this.defHostRoute != null) {
          localArrayList.add(this.defHostRoute);
        }
        if (this.defBakHostRoute != null) {
          localArrayList.add(this.defBakHostRoute);
        }
      }
      return localArrayList;
      if (this.defHostRoute != null) {
        localArrayList.add(this.defHostRoute);
      }
    }
  }
  
  private final UploadRoute getV6HostRoute()
  {
    Object localObject = this.ipProvider.getV6HostUrl();
    if (localObject == null)
    {
      UploadLog.w("[iplist] ServerRouteTable", "getHostRoute:" + this + " return null!!");
      return null;
    }
    localObject = new UploadRoute((String)localObject, 80, IUploadRouteStrategy.RouteCategoryType.HOST);
    UploadLog.i("[iplist] ServerRouteTable", "getHostRoute:" + this + " " + ((UploadRoute)localObject).toString());
    return localObject;
  }
  
  private final UploadRoute getV6OptimumRoute()
  {
    if (this.ipProvider == null) {}
    do
    {
      return null;
      localObject = this.ipProvider.getV6OptIps();
    } while (localObject == null);
    int i = UploadConfiguration.getCurrentOperatorCategory();
    UploadLog.i("[iplist] ServerRouteTable", "getV6OptimumRoute:" + this + " currentOperatorCategory:" + i + " OptimumJsonString:" + (String)localObject);
    Object localObject = jsonToUploadRoute((String)localObject, i, 1);
    if (localObject == null)
    {
      UploadLog.w("[iplist] ServerRouteTable", "getV6OptimumRoute:" + this + " return null!!");
      return null;
    }
    ((UploadRoute)localObject).setRouteCategory(IUploadRouteStrategy.RouteCategoryType.OPTIMUM);
    UploadLog.i("[iplist] ServerRouteTable", "getV6OptimumRoute:" + this + " " + ((UploadRoute)localObject).toString());
    return localObject;
  }
  
  private List<UploadRoute> getV6UploadRoutes()
  {
    ArrayList localArrayList = new ArrayList();
    UploadRoute localUploadRoute = getV6OptimumRoute();
    if (localUploadRoute != null) {
      localArrayList.add(localUploadRoute);
    }
    localUploadRoute = getV6HostRoute();
    if (localUploadRoute != null) {
      localArrayList.add(localUploadRoute);
    }
    return localArrayList;
  }
  
  private static final UploadRoute jsonToUploadRoute(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject;
    if ((paramString == null) || (paramString.length() < 1))
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int i;
      JSONObject localJSONObject;
      int k;
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("ips");
        int j = localJSONArray.length();
        i = 0;
        paramString = null;
        localObject = paramString;
        if (i >= j) {
          break;
        }
        localJSONObject = localJSONArray.getJSONObject(i);
        k = Integer.parseInt(localJSONObject.getString("apn"));
        if (paramInt1 == k)
        {
          paramString = new UploadRoute(localJSONObject.getString("ip"), localJSONObject.getInt("port"), IUploadRouteStrategy.RouteCategoryType.OPTIMUM);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        UploadLog.w("ServerRouteTable", paramString.toString());
        return null;
      }
      localObject = paramString;
      if (paramInt2 == k)
      {
        localObject = paramString;
        if (paramString == null) {
          localObject = new UploadRoute(localJSONObject.getString("ip"), localJSONObject.getInt("port"), IUploadRouteStrategy.RouteCategoryType.OPTIMUM);
        }
      }
      i += 1;
      paramString = (String)localObject;
    }
  }
  
  List<UploadRoute> getUploadRoutes()
  {
    int i = NetworkState.getNetworkStackTypeInner();
    UploadLog.d("ServerRouteTable", "getUploadRoutes stackType:" + i);
    ArrayList localArrayList = new ArrayList();
    if ((i == 2) || (i == 3)) {
      localArrayList.addAll(getV6UploadRoutes());
    }
    if (i != 2) {
      localArrayList.addAll(getV4UploadRoutes());
    }
    return localArrayList;
  }
  
  public final String getV6HostString()
  {
    if (this.ipProvider == null) {
      return null;
    }
    String str = this.ipProvider.getV6HostUrl();
    if (str == null)
    {
      UploadLog.w("ServerRouteTable", "host == null!!!");
      return null;
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.network.route.ServerRouteTable
 * JD-Core Version:    0.7.0.1
 */