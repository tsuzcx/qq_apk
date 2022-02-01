package cooperation.qqcircle.report;

import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class QCircleMapReporter
{
  private static final String TAG = "AEQCircleReport";
  private static final QCircleMapReporter ourInstance = new QCircleMapReporter();
  private HashMap<String, Long> clickTimesMap = new HashMap();
  
  public static QCircleMapReporter getInstance()
  {
    return ourInstance;
  }
  
  public long endKey(String paramString)
  {
    if (this.clickTimesMap.containsKey(paramString))
    {
      long l = ((Long)this.clickTimesMap.get(paramString)).longValue();
      l = System.currentTimeMillis() - l;
      if (l < 0L)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("endKey... cost < 0 key:");
        localStringBuilder.append(paramString);
        QLog.d("AEQCircleReport", 1, localStringBuilder.toString());
        return -1L;
      }
      return l;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("endKey... clickTimesMap not contain key:");
    localStringBuilder.append(paramString);
    QLog.w("AEQCircleReport", 1, localStringBuilder.toString());
    return -1L;
  }
  
  public void reportEnd(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    long l = endKey(paramString1);
    if (l > 0L)
    {
      QCirclePublishQualityReporter.report(QCirclePublishQualityReporter.P_MATERIAL_COST_END, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("ext1", paramString1), QCircleReportHelper.newEntry("ext2", paramString2), QCircleReportHelper.newEntry("ext3", String.valueOf(l)), QCircleReportHelper.newEntry("ext4", paramString3), QCircleReportHelper.newEntry("ret_code", paramString4) }));
      return;
    }
    paramString2 = new StringBuilder();
    paramString2.append("reportEnd... cost < 0 id:");
    paramString2.append(paramString1);
    QLog.w("AEQCircleReport", 1, paramString2.toString());
  }
  
  public void reportEnd(String paramString1, String paramString2, List<FeedCloudCommon.Entry> paramList)
  {
    long l = endKey(paramString2);
    if (l > 0L)
    {
      paramList = new ArrayList(paramList);
      paramList.add(QCircleReportHelper.newEntry("ext1", String.valueOf(l)));
      QCirclePublishQualityReporter.report(paramString1, paramList);
      paramList = new StringBuilder();
      paramList.append("reportEnd... eventId:");
      paramList.append(paramString1);
      paramList.append(" missionId:");
      paramList.append(paramString2);
      paramList.append(" cost:");
      paramList.append(l);
      QLog.d("AEQCircleReport", 1, paramList.toString());
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("reportEnd... cost < 0 id:");
    paramString1.append(paramString2);
    QLog.w("AEQCircleReport", 1, paramString1.toString());
  }
  
  public void startKey(String paramString)
  {
    this.clickTimesMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.report.QCircleMapReporter
 * JD-Core Version:    0.7.0.1
 */