package com.tencent.upload.network.route;

import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.utils.Const.FailureCode;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RouteStrategy
  implements IUploadRouteStrategy
{
  protected final String TAG;
  @Deprecated
  protected boolean mCausedByApnChanged;
  protected List<Integer> mPorts;
  protected Iterator<Integer> mPortsIterator;
  protected RecentRouteRecord mRecentRouteRecord;
  protected List<UploadRoute> mRoutes;
  protected Iterator<UploadRoute> mRoutesIterator;
  private ServerRouteTable mServerRouteTable;
  protected String mUsedApn;
  @Deprecated
  protected List<RouteStrategy.UsedRouteInfo> mUsedRouteInfos;
  
  public RouteStrategy(ServerRouteTable paramServerRouteTable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RouteStrategy[");
    localStringBuilder.append(hashCode());
    localStringBuilder.append("]");
    this.TAG = localStringBuilder.toString();
    this.mCausedByApnChanged = false;
    this.mUsedRouteInfos = new ArrayList();
    this.mServerRouteTable = paramServerRouteTable;
  }
  
  private void doInitParams()
  {
    this.mRoutes = getServerRouteTable().getUploadRoutes();
    Object localObject1 = this.mRoutes;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      this.mPorts = RouteFactory.getUploadRoutePorts();
      localObject1 = this.mPorts;
      if ((localObject1 != null) && (((List)localObject1).size() != 0))
      {
        this.mRoutesIterator = this.mRoutes.iterator();
        this.mPortsIterator = this.mPorts.iterator();
        localObject1 = new StringBuffer(this.mRoutes.size());
        Object localObject2 = this.mRoutes.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (UploadRoute)((Iterator)localObject2).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((UploadRoute)localObject3).toString());
          localStringBuilder.append(" ");
          ((StringBuffer)localObject1).append(localStringBuilder.toString());
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[iplist] ");
        ((StringBuilder)localObject2).append(this.TAG);
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(" doInitParams, all Route List:");
        ((StringBuilder)localObject3).append(((StringBuffer)localObject1).toString());
        ((StringBuilder)localObject3).append(", all Port List:");
        ((StringBuilder)localObject3).append(this.mPorts.toString());
        UploadLog.d((String)localObject2, ((StringBuilder)localObject3).toString());
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.TAG);
      ((StringBuilder)localObject1).append(" doInitParams, getUploadRoutePorts illegal");
      throw new RuntimeException(((StringBuilder)localObject1).toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.TAG);
    ((StringBuilder)localObject1).append(" doInitParams, getUploadRoutes illegal");
    localObject1 = new RuntimeException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  private UploadRoute getAvailableRoute()
  {
    if ((this.mRoutesIterator.hasNext()) && (this.mPortsIterator.hasNext()))
    {
      UploadRoute localUploadRoute = (UploadRoute)this.mRoutesIterator.next();
      localUploadRoute.setPort(((Integer)this.mPortsIterator.next()).intValue());
      Object localObject = getRecentRoute();
      if ((localObject != null) && (((UploadRoute)localObject).isDuplicate(localUploadRoute)))
      {
        localObject = this.TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" getAvailableRoute isDuplicate with recent, matchNextRouteFormRouteTable:");
        localStringBuilder.append(localUploadRoute.toString());
        UploadLog.d((String)localObject, localStringBuilder.toString());
        return matchNextRouteFormRouteTable(localUploadRoute);
      }
      localObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getAvailableRoute return:");
      localStringBuilder.append(localUploadRoute.toString());
      UploadLog.d((String)localObject, localStringBuilder.toString());
      return localUploadRoute;
    }
    UploadLog.d(this.TAG, " getAvailableRoute return null");
    return null;
  }
  
  private UploadRoute getRecentRoute()
  {
    Object localObject = this.mRecentRouteRecord;
    if (localObject == null) {
      return null;
    }
    localObject = ((RecentRouteRecord)localObject).getRecentRoute();
    if (localObject != null)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" getRecentRoute: ");
      localStringBuilder.append(((UploadRoute)localObject).toString());
      UploadLog.d(str, localStringBuilder.toString());
      return localObject;
    }
    return null;
  }
  
  private boolean isApnChanged()
  {
    String str = this.mUsedApn;
    if (str == null) {
      return UploadConfiguration.getCurrentApn() != null;
    }
    return str.compareToIgnoreCase(UploadConfiguration.getCurrentApn()) != 0;
  }
  
  private void loadRecentRouteRecord()
  {
    String str = UploadConfiguration.getRecentRouteApnKey();
    if (str == null)
    {
      UploadLog.d(this.TAG, " loadRecentRouteRecord, unknown key");
      return;
    }
    this.mRecentRouteRecord = new RecentRouteRecordStorage(getServerRouteTable()).getData(str);
  }
  
  private UploadRoute matchNextRouteFormRouteTable(UploadRoute paramUploadRoute)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramUploadRoute == null)
    {
      paramUploadRoute = (UploadRoute)localObject2;
      if (this.mRoutesIterator.hasNext()) {
        paramUploadRoute = (UploadRoute)this.mRoutesIterator.next();
      }
      localObject1 = this.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("matchNextRouteFormRouteTable: lastRoute == null now = ");
      ((StringBuilder)localObject2).append(paramUploadRoute);
      UploadLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
      return paramUploadRoute;
    }
    paramUploadRoute = paramUploadRoute.clone();
    localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("matchNextRouteFormRouteTable: currentRoute:");
    localStringBuilder.append(paramUploadRoute);
    UploadLog.d((String)localObject2, localStringBuilder.toString());
    if (this.mPortsIterator.hasNext())
    {
      paramUploadRoute.setPort(((Integer)this.mPortsIterator.next()).intValue());
      localObject1 = this.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("matchNextRouteFormRouteTable: to next port");
      ((StringBuilder)localObject2).append(paramUploadRoute);
      UploadLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    else if (this.mRoutesIterator.hasNext())
    {
      this.mPortsIterator = this.mPorts.iterator();
      if (this.mPortsIterator.hasNext())
      {
        paramUploadRoute = ((UploadRoute)this.mRoutesIterator.next()).clone();
        paramUploadRoute.setPort(((Integer)this.mPortsIterator.next()).intValue());
        localObject1 = this.TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("matchNextRouteFormRouteTable: to next ip");
        ((StringBuilder)localObject2).append(paramUploadRoute);
        UploadLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
      }
      else
      {
        UploadLog.w(this.TAG, "matchNextRouteFormRouteTable: to next ip, but no port. exception");
        paramUploadRoute = (UploadRoute)localObject1;
      }
    }
    else
    {
      UploadLog.d(this.TAG, "matchNextRouteFormRouteTable: finish, return null");
      paramUploadRoute = (UploadRoute)localObject1;
    }
    localObject1 = getRecentRoute();
    if ((localObject1 != null) && (((UploadRoute)localObject1).isDuplicate(paramUploadRoute)))
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("matchNextRouteFormRouteTable: isDuplicate with recent");
      ((StringBuilder)localObject2).append(paramUploadRoute.toString());
      UploadLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
      return matchNextRouteFormRouteTable(paramUploadRoute);
    }
    return paramUploadRoute;
  }
  
  public ServerRouteTable getServerRouteTable()
  {
    return this.mServerRouteTable;
  }
  
  public UploadRoute next(UploadRoute paramUploadRoute, int paramInt)
  {
    Object localObject1 = null;
    if (paramUploadRoute == null)
    {
      UploadLog.d(this.TAG, " next: null, route == null");
      return null;
    }
    this.mUsedRouteInfos.add(new RouteStrategy.UsedRouteInfo(paramUploadRoute.clone(), paramInt));
    boolean bool = UploadConfiguration.isNetworkAvailable();
    this.mCausedByApnChanged = (bool ^ true);
    if (!bool)
    {
      UploadLog.d(this.TAG, " next: null, !isNetworkAvailable");
      return null;
    }
    bool = isApnChanged();
    this.mCausedByApnChanged = bool;
    if (bool)
    {
      paramUploadRoute = this.TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" next: null, isApnChanged:");
      ((StringBuilder)localObject1).append(bool);
      UploadLog.d(paramUploadRoute, ((StringBuilder)localObject1).toString());
      return null;
    }
    if ((paramInt != 4) && (paramUploadRoute.getRouteCategory() == IUploadRouteStrategy.RouteCategoryType.RECENT))
    {
      localObject2 = getAvailableRoute();
      if (localObject2 != null)
      {
        paramUploadRoute = this.TAG;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" next: return");
        ((StringBuilder)localObject1).append(localObject2);
        UploadLog.d(paramUploadRoute, ((StringBuilder)localObject1).toString());
        return localObject2;
      }
    }
    bool = UploadConfiguration.isWapSetting();
    Object localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" next start: ");
    localStringBuilder.append(Const.FailureCode.print(paramInt));
    localStringBuilder.append(" failureCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" wap:");
    localStringBuilder.append(bool);
    UploadLog.d((String)localObject2, localStringBuilder.toString());
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2)) {
      if (paramInt != 3)
      {
        if ((paramInt != 4) && (paramInt != 6)) {
          break label366;
        }
      }
      else
      {
        while (this.mPortsIterator.hasNext()) {
          this.mPortsIterator.next();
        }
        localObject2 = matchNextRouteFormRouteTable(paramUploadRoute);
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label366;
        }
        ((UploadRoute)localObject2).setRouteCategory(paramUploadRoute.getRouteCategory());
        localObject1 = localObject2;
        break label366;
      }
    }
    localObject1 = matchNextRouteFormRouteTable(paramUploadRoute);
    label366:
    localObject2 = this.TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(" next return: ");
    if (localObject1 == null) {
      paramUploadRoute = "null";
    } else {
      paramUploadRoute = ((UploadRoute)localObject1).toString();
    }
    localStringBuilder.append(paramUploadRoute);
    UploadLog.d((String)localObject2, localStringBuilder.toString());
    return localObject1;
  }
  
  public UploadRoute reset()
  {
    this.mCausedByApnChanged = false;
    doInitParams();
    if (isApnChanged())
    {
      this.mUsedApn = UploadConfiguration.getCurrentApn();
      loadRecentRouteRecord();
    }
    UploadRoute localUploadRoute = getRecentRoute();
    String str;
    StringBuilder localStringBuilder;
    if (localUploadRoute != null)
    {
      str = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" reset, return recentRoute: ");
      localStringBuilder.append(localUploadRoute.toString());
      UploadLog.d(str, localStringBuilder.toString());
      return localUploadRoute;
    }
    localUploadRoute = getAvailableRoute();
    if (localUploadRoute != null)
    {
      str = this.TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" reset, return firstRoute:");
      localStringBuilder.append(localUploadRoute);
      UploadLog.d(str, localStringBuilder.toString());
      return localUploadRoute;
    }
    UploadLog.d(this.TAG, " reset, return null");
    return null;
  }
  
  public boolean save(UploadRoute paramUploadRoute)
  {
    String str1 = UploadConfiguration.getRecentRouteApnKey();
    if (str1 == null)
    {
      UploadLog.d(this.TAG, "save, unknown key");
      return false;
    }
    if ((str1 != null) && (str1.length() > 0))
    {
      if (!paramUploadRoute.getIp().endsWith(".com"))
      {
        this.mRecentRouteRecord = UploadConfiguration.saveAsRecentIp(getServerRouteTable(), str1, paramUploadRoute);
        String str2 = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" save: as recent:");
        localStringBuilder.append(paramUploadRoute);
        localStringBuilder.append(" recentApnKey:");
        localStringBuilder.append(str1);
        UploadLog.d(str2, localStringBuilder.toString());
      }
      return true;
    }
    UploadLog.d(this.TAG, " save: apnKey isNullOrEmpty");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.route.RouteStrategy
 * JD-Core Version:    0.7.0.1
 */