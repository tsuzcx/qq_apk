package cooperation.qzone.report.lp;

import NS_MOBILE_CLIENT_UPDATE.REPORT_INFO;
import android.util.Log;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class LpReportInfos
{
  private static final String TAG = "LpReport.LpReportInfos";
  private Map<Integer, REPORT_INFO> infos = new ConcurrentHashMap();
  
  private void checkParams(int paramInt, Map<String, String> paramMap, LpReportInfo paramLpReportInfo)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if ((str == null) || (localObject == null))
      {
        paramMap.remove();
        QZLog.e("LpReport.LpReportInfos", 1, new Object[] { "lpReport error, type=", Integer.valueOf(paramInt), ", kye:", str, ", value:", localObject, ", lpReportInfo:", paramLpReportInfo.getSimpleInfo() });
        QZLog.e("LpReport.LpReportInfos", Log.getStackTraceString(new Throwable()));
      }
    }
  }
  
  public void addInfo(int paramInt, LpReportInfo paramLpReportInfo)
  {
    if (paramLpReportInfo == null) {
      return;
    }
    Map localMap = paramLpReportInfo.toMap();
    if (localMap != null)
    {
      if (localMap.size() == 0) {
        return;
      }
      checkParams(paramInt, localMap, paramLpReportInfo);
      if (this.infos.containsKey(Integer.valueOf(paramInt)))
      {
        ((REPORT_INFO)this.infos.get(Integer.valueOf(paramInt))).info.add(localMap);
        return;
      }
      paramLpReportInfo = new ArrayList();
      paramLpReportInfo.add(localMap);
      paramLpReportInfo = new REPORT_INFO(paramInt, paramLpReportInfo);
      this.infos.put(Integer.valueOf(paramInt), paramLpReportInfo);
    }
  }
  
  public void clear()
  {
    this.infos.clear();
  }
  
  public ArrayList<REPORT_INFO> getInfos()
  {
    return new ArrayList(this.infos.values());
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public int size()
  {
    Iterator localIterator = this.infos.values().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      REPORT_INFO localREPORT_INFO = (REPORT_INFO)localIterator.next();
      if ((localREPORT_INFO != null) && (localREPORT_INFO.info != null)) {
        i += localREPORT_INFO.info.size();
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfos
 * JD-Core Version:    0.7.0.1
 */