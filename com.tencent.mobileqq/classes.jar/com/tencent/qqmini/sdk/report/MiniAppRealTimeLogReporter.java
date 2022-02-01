package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MiniAppRealTimeLogReporter
{
  public static final int MAX_CONTENT_SIZE = 5120;
  public static final int MAX_LOG_ITEM_COUNT = 200;
  public static final int MAX_PAGE_COUNT = 10;
  private static final String TAG = "MiniAppRealTimeLogReporter";
  private List<MiniAppRealTimeLogReporter.RealTimeLog> allLogs = new LinkedList();
  
  private MiniAppRealTimeLogReporter.RealTimeLog findLogByPage(int paramInt)
  {
    Object localObject = this.allLogs;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MiniAppRealTimeLogReporter.RealTimeLog localRealTimeLog = (MiniAppRealTimeLogReporter.RealTimeLog)((Iterator)localObject).next();
        if (localRealTimeLog.page == paramInt) {
          return localRealTimeLog;
        }
      }
    }
    if (this.allLogs.size() <= 10)
    {
      localObject = new MiniAppRealTimeLogReporter.RealTimeLog(paramInt);
      this.allLogs.add(localObject);
      return localObject;
    }
    return null;
  }
  
  private MiniAppRealTimeLogReporter.RealTimeLog getLogById(int paramInt)
  {
    Iterator localIterator = this.allLogs.iterator();
    while (localIterator.hasNext())
    {
      MiniAppRealTimeLogReporter.RealTimeLog localRealTimeLog = (MiniAppRealTimeLogReporter.RealTimeLog)localIterator.next();
      if (localRealTimeLog.page == paramInt) {
        return localRealTimeLog;
      }
    }
    return null;
  }
  
  private boolean report(int paramInt1, JSONArray paramJSONArray, int paramInt2, long paramLong, String paramString)
  {
    MiniAppRealTimeLogReporter.RealTimeLog localRealTimeLog = findLogByPage(paramInt1);
    if (localRealTimeLog == null)
    {
      QMLog.e("MiniAppRealTimeLogReporter", "current log has reached its max size");
      return false;
    }
    if (localRealTimeLog.curLogContentSize >= 5120)
    {
      QMLog.e("MiniAppRealTimeLogReporter", "current log content has reached its current max size");
      return false;
    }
    if (localRealTimeLog.logitems.size() >= 200)
    {
      QMLog.e("MiniAppRealTimeLogReporter", "current log item size has reached its current max size");
      return false;
    }
    localRealTimeLog.filterMsg = paramJSONArray;
    paramJSONArray = paramString;
    if (localRealTimeLog.curLogContentSize + paramString.length() > 5120) {
      paramJSONArray = paramString.substring(0, 5120 - localRealTimeLog.curLogContentSize);
    }
    localRealTimeLog.logitems.add(new RealTimeLogItem(paramLong, paramInt2, paramJSONArray));
    localRealTimeLog.curLogContentSize += paramJSONArray.length();
    return true;
  }
  
  public boolean flush(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    MiniAppRealTimeLogReporter.RealTimeLog localRealTimeLog = getLogById(paramInt);
    if (localRealTimeLog != null)
    {
      Object localObject = null;
      if (localRealTimeLog.filterMsg != null)
      {
        String[] arrayOfString = new String[localRealTimeLog.filterMsg.length()];
        paramInt = 0;
        for (;;)
        {
          localObject = arrayOfString;
          if (paramInt >= localRealTimeLog.filterMsg.length()) {
            break;
          }
          arrayOfString[paramInt] = localRealTimeLog.filterMsg.optString(paramInt, "");
          paramInt += 1;
        }
      }
      if (localRealTimeLog.logitems.size() > 0) {
        ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).realTimeLogReport(paramString1, paramString2, paramString3, localObject, localRealTimeLog.logitems, new MiniAppRealTimeLogReporter.1(this));
      }
      this.allLogs.remove(localRealTimeLog);
    }
    return true;
  }
  
  public boolean report(String paramString)
  {
    try
    {
      localObject = new JSONObject(paramString);
      int i = ((JSONObject)localObject).getInt("page");
      JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("filterMsg");
      String str = ((JSONObject)localObject).getString("content");
      boolean bool = report(i, localJSONArray, ((JSONObject)localObject).getInt("level"), ((JSONObject)localObject).getLong("time"), str);
      return bool;
    }
    catch (Exception localException)
    {
      Object localObject;
      label62:
      break label62;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MiniAppRealTimeLogReporter.report failed:");
    ((StringBuilder)localObject).append(paramString);
    QMLog.e("MiniAppRealTimeLogReporter", ((StringBuilder)localObject).toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter
 * JD-Core Version:    0.7.0.1
 */