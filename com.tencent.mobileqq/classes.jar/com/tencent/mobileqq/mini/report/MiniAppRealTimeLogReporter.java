package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MiniAppRealTimeLogReporter
{
  public static final int MAX_PAGE_COUNT = 10;
  private static final String TAG = "[mini] MiniAppRealTimeLogReporter";
  public static MiniAppRealTimeLogReporter instance;
  private static byte[] lock = new byte[0];
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
    localObject = this.allLogs;
    if ((localObject != null) && (((List)localObject).size() <= 10))
    {
      localObject = new MiniAppRealTimeLogReporter.RealTimeLog(this, paramInt);
      this.allLogs.add(localObject);
      return localObject;
    }
    return null;
  }
  
  public static MiniAppRealTimeLogReporter getInstance()
  {
    if (instance == null) {
      synchronized (lock)
      {
        if (instance == null) {
          instance = new MiniAppRealTimeLogReporter();
        }
      }
    }
    return instance;
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
      QLog.e("[mini] MiniAppRealTimeLogReporter", 1, "current log has reached its max size");
      return false;
    }
    paramInt1 = QzoneConfig.getInstance().getConfig("qqminiapp", "RealTimeLogMaxContentSize", 5120);
    int i = QzoneConfig.getInstance().getConfig("qqminiapp", "RealTimeLogMaxCallNum", 200);
    if (localRealTimeLog.curLogContentSize >= paramInt1)
    {
      QLog.e("[mini] MiniAppRealTimeLogReporter", 1, "current log content has reached its current max size");
      return false;
    }
    if (localRealTimeLog.logitems.size() >= i)
    {
      QLog.e("[mini] MiniAppRealTimeLogReporter", 1, "current log item size has reached its current max size");
      return false;
    }
    localRealTimeLog.filterMsg = paramJSONArray;
    if (localRealTimeLog.curLogContentSize + paramString.length() > paramInt1)
    {
      i = localRealTimeLog.curLogContentSize;
      int j = paramString.length();
      paramJSONArray = localRealTimeLog.logitems;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UserLog:fail Log Size ");
      localStringBuilder.append(i + j - paramInt1);
      localStringBuilder.append(" Exceed");
      paramJSONArray.add(new RealTimeLogItem(paramLong, paramInt2, localStringBuilder.toString()));
    }
    localRealTimeLog.logitems.add(new RealTimeLogItem(paramLong, paramInt2, paramString));
    localRealTimeLog.curLogContentSize += paramString.length();
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
        MiniAppCmdUtil.getInstance().realTimeLogReport(paramString1, paramString2, paramString3, localObject, localRealTimeLog.logitems, new MiniAppRealTimeLogReporter.1(this));
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
    QLog.e("[mini] MiniAppRealTimeLogReporter", 1, ((StringBuilder)localObject).toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppRealTimeLogReporter
 * JD-Core Version:    0.7.0.1
 */