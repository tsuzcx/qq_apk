package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LpReportInfo_dc02467
  implements LpReportInfo
{
  public static final String ERROR_CODE = "error_code";
  public static final String FACE_FEATURE_SIZE = "face_feature_size";
  public static final String REQUEST_TIME = "request_time";
  public static final String RESPONSE_FAIL_SIZE = "response_fail_size";
  public static final String RESPONSE_SIZE = "response_size";
  public static final String RESPONSE_SUCCESS_SIZE = "response_success_size";
  public static final String RESPONSE_TIME = "response_time";
  public static final String UIN = "uin";
  public int errorCode;
  public int faceFeatureSize;
  public String requestTime;
  public int responseFailSize;
  public int responseSize;
  public int responseSuccessSize;
  public String responseTime;
  public long uin;
  
  public String getCurrentDate(Date paramDate)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    if (paramDate != null) {
      return localSimpleDateFormat.format(paramDate);
    }
    return null;
  }
  
  public String getSimpleInfo()
  {
    return "dc02467";
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    long l = this.uin;
    String str;
    if (l <= 1000L) {
      str = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount();
    } else {
      str = String.valueOf(l);
    }
    localHashMap.put("uin", str);
    localHashMap.put("face_feature_size", String.valueOf(this.faceFeatureSize));
    localHashMap.put("error_code", String.valueOf(this.errorCode));
    localHashMap.put("response_success_size", String.valueOf(this.responseSuccessSize));
    localHashMap.put("response_fail_size", String.valueOf(this.responseFailSize));
    localHashMap.put("response_size", String.valueOf(this.responseSize));
    localHashMap.put("request_time", this.requestTime);
    localHashMap.put("response_time", this.responseTime);
    return localHashMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin = xxx faceSize = ");
    localStringBuilder.append(this.faceFeatureSize);
    localStringBuilder.append(" reqtime = ");
    localStringBuilder.append(this.requestTime);
    localStringBuilder.append(" restime = ");
    localStringBuilder.append(this.responseTime);
    localStringBuilder.append("resSusSize = ");
    localStringBuilder.append(this.responseSuccessSize);
    localStringBuilder.append(" error = ");
    localStringBuilder.append(this.errorCode);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc02467
 * JD-Core Version:    0.7.0.1
 */