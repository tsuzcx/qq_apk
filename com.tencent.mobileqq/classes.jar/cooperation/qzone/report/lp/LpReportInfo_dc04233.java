package cooperation.qzone.report.lp;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
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
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("king_card_sp", 0);
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
      double d = (localDate.getTime() - ((Date)localObject).getTime()) * 1.0D / 3600000.0D;
      if (QLog.isColorLevel()) {
        QLog.i("LpReportInfo_dc04233", 2, "dc04233 offest time = " + d);
      }
      if (d >= 24.0D)
      {
        localSharedPreferences.edit().putString("lastReportTime", localSimpleDateFormat.format(localDate)).apply();
        return true;
      }
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
      localSharedPreferences.edit().putString("lastReportTime", localSimpleDateFormat.format(localDate)).apply();
      return true;
    }
    return false;
  }
  
  public String getSimpleInfo()
  {
    return "dc04233 uin: " + this.uin + " isKingCard: " + this.isKingCard;
  }
  
  public void report()
  {
    if (isNeedReport()) {
      LpReportManager.getInstance().reportToDC04233(this, false, false);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("LpReportInfo_dc04233", 2, "dc04233 has report");
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uin", String.valueOf(this.uin));
    localHashMap.put("is_kingcard", String.valueOf(this.isKingCard));
    LpReportUtils.safePut(localHashMap, "qua", QUA.getQUA3());
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc04233
 * JD-Core Version:    0.7.0.1
 */