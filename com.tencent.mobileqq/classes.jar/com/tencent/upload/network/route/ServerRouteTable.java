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
    if (!TextUtils.isEmpty(paramString1)) {
      this.defHostRoute = new UploadRoute(paramString1, 80, IUploadRouteStrategy.RouteCategoryType.HOST);
    } else {
      this.defHostRoute = null;
    }
    if (!TextUtils.isEmpty(paramString1)) {
      this.defBakHostRoute = new UploadRoute(paramString2, 80, IUploadRouteStrategy.RouteCategoryType.BACKUP);
    } else {
      this.defBakHostRoute = null;
    }
    this.supportFileType = paramFileType;
    this.ipProvider = paramIRouteIPProvider;
  }
  
  private final UploadRoute getBackupRoute()
  {
    Object localObject = this.ipProvider.getBakIps();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getBackupRoute:");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" return null!!");
      UploadLog.e("ServerRouteTable", ((StringBuilder)localObject).toString());
      return null;
    }
    int i = UploadConfiguration.getCurrentOperatorCategory();
    if (i == 4)
    {
      int j = UploadConfiguration.getWifiOperatorCategory();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBackupRoute:");
      localStringBuilder.append(this);
      localStringBuilder.append(" currentOperatorCategory:");
      localStringBuilder.append(i);
      localStringBuilder.append(" wifiOperatorCategory:");
      localStringBuilder.append(j);
      localStringBuilder.append(" ");
      localStringBuilder.append((String)localObject);
      UploadLog.i("[iplist] ServerRouteTable", localStringBuilder.toString());
      localObject = jsonToUploadRoute((String)localObject, j, 2);
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBackupRoute:");
      localStringBuilder.append(this);
      localStringBuilder.append(" currentOperatorCategory:");
      localStringBuilder.append(i);
      localStringBuilder.append(" ");
      localStringBuilder.append((String)localObject);
      UploadLog.i("[iplist] ServerRouteTable", localStringBuilder.toString());
      localObject = jsonToUploadRoute((String)localObject, i, 2);
    }
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getBackupRoute:");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" return null!!");
      UploadLog.w("[iplist] ServerRouteTable", ((StringBuilder)localObject).toString());
      return null;
    }
    ((UploadRoute)localObject).setRouteCategory(IUploadRouteStrategy.RouteCategoryType.BACKUP);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getBackupRoute:");
    localStringBuilder.append(this);
    localStringBuilder.append(" ");
    localStringBuilder.append(((UploadRoute)localObject).toString());
    UploadLog.i("[iplist] ServerRouteTable", localStringBuilder.toString());
    return localObject;
  }
  
  private final UploadRoute getHostRoute()
  {
    Object localObject = this.ipProvider.getHostUrl();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getHostRoute:");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" return null!!");
      UploadLog.w("[iplist] ServerRouteTable", ((StringBuilder)localObject).toString());
      return null;
    }
    localObject = new UploadRoute((String)localObject, 80, IUploadRouteStrategy.RouteCategoryType.HOST);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getHostRoute:");
    localStringBuilder.append(this);
    localStringBuilder.append(" ");
    localStringBuilder.append(((UploadRoute)localObject).toString());
    UploadLog.i("[iplist] ServerRouteTable", localStringBuilder.toString());
    return localObject;
  }
  
  private final UploadRoute getOptimumRoute()
  {
    Object localObject = this.ipProvider;
    if (localObject == null) {
      return null;
    }
    localObject = ((IRouteIPProvider)localObject).getOptIps();
    if (localObject == null) {
      return null;
    }
    int i = UploadConfiguration.getCurrentOperatorCategory();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getOptimumRoute:");
    localStringBuilder.append(this);
    localStringBuilder.append(" currentOperatorCategory:");
    localStringBuilder.append(i);
    localStringBuilder.append(" OptimumJsonString:");
    localStringBuilder.append((String)localObject);
    UploadLog.i("[iplist] ServerRouteTable", localStringBuilder.toString());
    localObject = jsonToUploadRoute((String)localObject, i, 0);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getOptimumRoute:");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" return null!!");
      UploadLog.w("[iplist] ServerRouteTable", ((StringBuilder)localObject).toString());
      return null;
    }
    ((UploadRoute)localObject).setRouteCategory(IUploadRouteStrategy.RouteCategoryType.OPTIMUM);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getOptimumRoute:");
    localStringBuilder.append(this);
    localStringBuilder.append(" ");
    localStringBuilder.append(((UploadRoute)localObject).toString());
    UploadLog.i("[iplist] ServerRouteTable", localStringBuilder.toString());
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
    if (localUploadRoute2 != null)
    {
      localArrayList.add(localUploadRoute2);
    }
    else
    {
      localUploadRoute2 = this.defHostRoute;
      if (localUploadRoute2 != null) {
        localArrayList.add(localUploadRoute2);
      }
    }
    localUploadRoute2 = getBackupRoute();
    if ((localUploadRoute2 != null) && ((localUploadRoute1 == null) || (!localUploadRoute1.getIp().equals(localUploadRoute2.getIp())) || (!StringUtils.isIpv4String(localUploadRoute1.getIp())))) {
      localArrayList.add(localUploadRoute2);
    }
    if (localArrayList.size() == 0)
    {
      localUploadRoute1 = this.defHostRoute;
      if (localUploadRoute1 != null) {
        localArrayList.add(localUploadRoute1);
      }
      localUploadRoute1 = this.defBakHostRoute;
      if (localUploadRoute1 != null) {
        localArrayList.add(localUploadRoute1);
      }
    }
    return localArrayList;
  }
  
  private final UploadRoute getV6HostRoute()
  {
    Object localObject = this.ipProvider.getV6HostUrl();
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getHostRoute:");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" return null!!");
      UploadLog.w("[iplist] ServerRouteTable", ((StringBuilder)localObject).toString());
      return null;
    }
    localObject = new UploadRoute((String)localObject, 80, IUploadRouteStrategy.RouteCategoryType.HOST);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getHostRoute:");
    localStringBuilder.append(this);
    localStringBuilder.append(" ");
    localStringBuilder.append(((UploadRoute)localObject).toString());
    UploadLog.i("[iplist] ServerRouteTable", localStringBuilder.toString());
    return localObject;
  }
  
  private final UploadRoute getV6OptimumRoute()
  {
    Object localObject = this.ipProvider;
    if (localObject == null) {
      return null;
    }
    localObject = ((IRouteIPProvider)localObject).getV6OptIps();
    if (localObject == null) {
      return null;
    }
    int i = UploadConfiguration.getCurrentOperatorCategory();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getV6OptimumRoute:");
    localStringBuilder.append(this);
    localStringBuilder.append(" currentOperatorCategory:");
    localStringBuilder.append(i);
    localStringBuilder.append(" OptimumJsonString:");
    localStringBuilder.append((String)localObject);
    UploadLog.i("[iplist] ServerRouteTable", localStringBuilder.toString());
    localObject = jsonToUploadRoute((String)localObject, i, 1);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getV6OptimumRoute:");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" return null!!");
      UploadLog.w("[iplist] ServerRouteTable", ((StringBuilder)localObject).toString());
      return null;
    }
    ((UploadRoute)localObject).setRouteCategory(IUploadRouteStrategy.RouteCategoryType.OPTIMUM);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("getV6OptimumRoute:");
    localStringBuilder.append(this);
    localStringBuilder.append(" ");
    localStringBuilder.append(((UploadRoute)localObject).toString());
    UploadLog.i("[iplist] ServerRouteTable", localStringBuilder.toString());
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
    if (paramString != null)
    {
      if (paramString.length() < 1) {
        return null;
      }
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray("ips");
        int j = localJSONArray.length();
        int i = 0;
        Object localObject;
        for (paramString = null; i < j; paramString = (String)localObject)
        {
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          int k = Integer.parseInt(localJSONObject.getString("apn"));
          if (paramInt1 == k) {
            return new UploadRoute(localJSONObject.getString("ip"), localJSONObject.getInt("port"), IUploadRouteStrategy.RouteCategoryType.OPTIMUM);
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
        }
        return paramString;
      }
      catch (Exception paramString)
      {
        UploadLog.w("ServerRouteTable", paramString.toString());
      }
    }
    return null;
  }
  
  List<UploadRoute> getUploadRoutes()
  {
    int i = NetworkState.getNetworkStackTypeInner();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getUploadRoutes stackType:");
    ((StringBuilder)localObject).append(i);
    UploadLog.d("ServerRouteTable", ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    if ((i == 2) || (i == 3)) {
      ((ArrayList)localObject).addAll(getV6UploadRoutes());
    }
    if (i != 2) {
      ((ArrayList)localObject).addAll(getV4UploadRoutes());
    }
    return localObject;
  }
  
  public final String getV6HostString()
  {
    Object localObject = this.ipProvider;
    if (localObject == null) {
      return null;
    }
    localObject = ((IRouteIPProvider)localObject).getV6HostUrl();
    if (localObject == null)
    {
      UploadLog.w("ServerRouteTable", "host == null!!!");
      return null;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.route.ServerRouteTable
 * JD-Core Version:    0.7.0.1
 */