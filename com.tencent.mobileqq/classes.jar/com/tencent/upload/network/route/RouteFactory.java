package com.tencent.upload.network.route;

import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RouteFactory
{
  private static final IRouteIPProvider LOG_IP_PROVIDER;
  public static final ServerRouteTable LOG_ROUTE_TABLE;
  private static final IRouteIPProvider OTHER_IP_PROVIDER;
  public static final ServerRouteTable OTHER_ROUTE_TABLE;
  public static final ServerRouteTable PICTURE_ROUTE_TABLE;
  private static final IRouteIPProvider PIC_IP_PROVIDER = new RouteFactory.1();
  private static Map<Const.FileType, ServerRouteTable> ServerRouteTableMap;
  private static final String TAG = "RouteFactory";
  private static final IRouteIPProvider VIDEO_IP_PROVIDER = new RouteFactory.2();
  public static final ServerRouteTable VIDEO_ROUTE_TABLE;
  private static DebugServerRoute sDebugServerRoute = null;
  
  static
  {
    OTHER_IP_PROVIDER = new RouteFactory.3();
    LOG_IP_PROVIDER = new RouteFactory.4();
    PICTURE_ROUTE_TABLE = new ServerRouteTable(0, PIC_IP_PROVIDER, "pic.upqzfile.com", "pic.upqzfilebk.com", Const.FileType.Photo);
    VIDEO_ROUTE_TABLE = new ServerRouteTable(1, VIDEO_IP_PROVIDER, "video.upqzfile.com", "video.upqzfilebk.com", Const.FileType.Video);
    OTHER_ROUTE_TABLE = new ServerRouteTable(2, OTHER_IP_PROVIDER, "other.upqzfile.com", "other.upqzfilebk.com", Const.FileType.Other);
    LOG_ROUTE_TABLE = new ServerRouteTable(3, LOG_IP_PROVIDER, "mobilelog.upqzfile.com", "mobilelog.upqzfilebk.com", Const.FileType.Log);
    ServerRouteTableMap = new HashMap();
    ServerRouteTableMap.put(PICTURE_ROUTE_TABLE.supportFileType, PICTURE_ROUTE_TABLE);
    ServerRouteTableMap.put(VIDEO_ROUTE_TABLE.supportFileType, VIDEO_ROUTE_TABLE);
    ServerRouteTableMap.put(OTHER_ROUTE_TABLE.supportFileType, OTHER_ROUTE_TABLE);
    ServerRouteTableMap.put(LOG_ROUTE_TABLE.supportFileType, LOG_ROUTE_TABLE);
  }
  
  public static final IUploadRouteStrategy createRouteStrategy(Const.FileType paramFileType)
  {
    if (isDebugEnable()) {
      return new DebugRouteStrategy();
    }
    return new RouteStrategy((ServerRouteTable)ServerRouteTableMap.get(paramFileType));
  }
  
  public static UploadRoute getDebugRoute()
  {
    if (sDebugServerRoute == null) {
      return null;
    }
    return sDebugServerRoute.getUploadRoute();
  }
  
  public static Map<Const.FileType, ServerRouteTable> getServerRouteTableMap()
  {
    return ServerRouteTableMap;
  }
  
  public static final List<Integer> getUploadRoutePorts()
  {
    Object localObject1 = UploadGlobalConfig.getConfig();
    Object localObject3 = ((IUploadConfig)localObject1).getUploadPort();
    if ((localObject1 == null) || (localObject3 == null)) {
      localObject1 = UploadConfiguration.DEF_PORTS;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        localObject3 = ((String)localObject3).split(",");
        if (localObject3 == null) {
          return UploadConfiguration.DEF_PORTS;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          UploadLog.w("RouteFactory", localException1.toString());
          localObject3 = null;
        }
        ArrayList localArrayList = new ArrayList(localObject3.length);
        try
        {
          int j = localObject3.length;
          int i = 0;
          for (;;)
          {
            Object localObject2 = localArrayList;
            if (i >= j) {
              break;
            }
            localArrayList.add(Integer.valueOf(Integer.parseInt(localObject3[i])));
            i += 1;
          }
          return UploadConfiguration.DEF_PORTS;
        }
        catch (Exception localException2)
        {
          UploadLog.w("RouteFactory", localException2.toString());
        }
      }
    }
  }
  
  public static boolean isDebugEnable()
  {
    return sDebugServerRoute != null;
  }
  
  public static void setDebugRoute(DebugServerRoute paramDebugServerRoute)
  {
    sDebugServerRoute = paramDebugServerRoute;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.upload.network.route.RouteFactory
 * JD-Core Version:    0.7.0.1
 */