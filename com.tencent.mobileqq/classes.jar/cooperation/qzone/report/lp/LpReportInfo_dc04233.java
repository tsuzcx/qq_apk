package cooperation.qzone.report.lp;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LpReportInfo_dc04233
  implements LpReportInfo
{
  private static final String KIND_CARD_SP = "king_card_sp";
  private static final String SP_KEY = "lastReportTime";
  private static final String TAG = "LpReportInfo_dc04233";
  public int isKingCard;
  public String qua;
  public long uin;
  
  public LpReportInfo_dc04233(long paramLong, int paramInt)
  {
    this.uin = paramLong;
    this.isKingCard = paramInt;
  }
  
  private boolean isNeedReport()
  {
    SharedPreferences localSharedPreferences = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getSharedPreferences("king_card_sp");
    Object localObject = localSharedPreferences.getString("lastReportTime", "");
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date localDate = new Date();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localSharedPreferences.edit().putString("lastReportTime", localSimpleDateFormat.format(localDate)).apply();
      return true;
    }
    try
    {
      localObject = localSimpleDateFormat.parse((String)localObject);
      long l1 = localDate.getTime();
      long l2 = ((Date)localObject).getTime();
      double d = l1 - l2;
      Double.isNaN(d);
      d = d * 1.0D / 3600000.0D;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("dc04233 offest time = ");
        ((StringBuilder)localObject).append(d);
        QLog.i("LpReportInfo_dc04233", 2, ((StringBuilder)localObject).toString());
      }
      if (d >= 24.0D)
      {
        localSharedPreferences.edit().putString("lastReportTime", localSimpleDateFormat.format(localDate)).apply();
        return true;
      }
      return false;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
      localSharedPreferences.edit().putString("lastReportTime", localSimpleDateFormat.format(localDate)).apply();
    }
    return true;
  }
  
  public String getSimpleInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dc04233 uin: ");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(" isKingCard: ");
    localStringBuilder.append(this.isKingCard);
    return localStringBuilder.toString();
  }
  
  public void report()
  {
    if (isNeedReport())
    {
      LpReportManager.getInstance().reportToDC04233(this, false, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LpReportInfo_dc04233", 2, "dc04233 has report");
    }
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uin", String.valueOf(this.uin));
    localHashMap.put("is_kingcard", String.valueOf(this.isKingCard));
    LpReportUtils.safePut(localHashMap, "qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc04233
 * JD-Core Version:    0.7.0.1
 */