package com.tencent.mobileqq.highway.api;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.highway.segment.RequestFinishQuery;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HighwayConfBean
{
  public static final String HIGHWAY_REQUEST_QUERY_FINISH = "sp_highway_request_query_finish";
  public static final String SP_HIGHWAY_REQUEST_QUERY_FINISH_COUNT = "sp_highway_request_query_finish_count";
  public static final String SP_HIGHWAY_REQUEST_QUERY_FINISH_INTERVAL = "sp_highway_request_query_finish_interval";
  public int requestQueryFinishCount = 3;
  public int requestQueryFinishInterval = 5000;
  
  public static void init(AppRuntime paramAppRuntime)
  {
    RequestFinishQuery.QUERY_HOLE_MAX_COUNT = paramAppRuntime.getApplication().getSharedPreferences("sp_highway_request_query_finish", 0).getInt("sp_highway_request_query_finish_count", 3);
    RequestFinishQuery.QUERY_HOLE_INTERVAL = paramAppRuntime.getApplication().getSharedPreferences("sp_highway_request_query_finish", 0).getInt("sp_highway_request_query_finish_interval", 5000);
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("init: QUERY_HOLE_MAX_COUNT:");
    paramAppRuntime.append(RequestFinishQuery.QUERY_HOLE_MAX_COUNT);
    paramAppRuntime.append(" QUERY_HOLE_INTERVAL:");
    paramAppRuntime.append(RequestFinishQuery.QUERY_HOLE_INTERVAL);
    BdhLogUtil.LogEvent("E", paramAppRuntime.toString());
  }
  
  public static HighwayConfBean parse(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      Object localObject = paramString.getElementsByTagName("bdh_config");
      if ((localObject != null) && (((NodeList)localObject).getLength() > 0))
      {
        localObject = new HighwayConfBean();
        ((HighwayConfBean)localObject).requestQueryFinishCount = Integer.parseInt(paramString.getElementsByTagName("max_finish_query_hole_time").item(0).getFirstChild().getNodeValue());
        ((HighwayConfBean)localObject).requestQueryFinishInterval = Integer.parseInt(paramString.getElementsByTagName("finish_query_hole_interval").item(0).getFirstChild().getNodeValue());
        return localObject;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void updateHighwayConf(AppRuntime paramAppRuntime, HighwayConfBean paramHighwayConfBean)
  {
    paramAppRuntime.getApplication().getSharedPreferences("sp_highway_request_query_finish", 0).edit().putInt("sp_highway_request_query_finish_count", paramHighwayConfBean.requestQueryFinishCount).commit();
    paramAppRuntime.getApplication().getSharedPreferences("sp_highway_request_query_finish", 0).edit().putInt("sp_highway_request_query_finish_interval", paramHighwayConfBean.requestQueryFinishInterval).commit();
    RequestFinishQuery.QUERY_HOLE_MAX_COUNT = paramHighwayConfBean.requestQueryFinishCount;
    RequestFinishQuery.QUERY_HOLE_INTERVAL = paramHighwayConfBean.requestQueryFinishInterval;
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("updateHighwayConf: QUERY_HOLE_MAX_COUNT:");
    paramAppRuntime.append(RequestFinishQuery.QUERY_HOLE_MAX_COUNT);
    paramAppRuntime.append(" QUERY_HOLE_INTERVAL:");
    paramAppRuntime.append(RequestFinishQuery.QUERY_HOLE_INTERVAL);
    BdhLogUtil.LogEvent("E", paramAppRuntime.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.api.HighwayConfBean
 * JD-Core Version:    0.7.0.1
 */