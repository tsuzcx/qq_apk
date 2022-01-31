import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class oyz
{
  private long a(String paramString)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      return -1L;
      localObject = bhvy.a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    return ((SharedPreferences)localObject).getLong("event_simple_g_info_" + oza.a(paramString), -1L);
  }
  
  private String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return bflg.a(paramString);
  }
  
  private void a(String paramString, long paramLong)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      return;
      localObject = bhvy.a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("event_simple_g_info_" + oza.a(paramString), paramLong);
    bhvy.a((SharedPreferences.Editor)localObject, true);
  }
  
  private void a(String paramString, TroopInfo paramTroopInfo)
  {
    if (paramTroopInfo == null) {}
    while ((paramTroopInfo.timeSec == a(paramTroopInfo.troopuin)) && (!oyy.a().a)) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(b("g_ui"), b(a(paramTroopInfo.troopuin)));
    localHashMap.put(b("g_code"), b(a(paramTroopInfo.troopcode)));
    localHashMap.put(b("g_oui"), b(a(paramTroopInfo.troopowneruin)));
    localHashMap.put(b("g_name"), b(paramTroopInfo.troopname));
    localHashMap.put(b("g_mem"), b(paramTroopInfo.troopmemo));
    localHashMap.put(b("g_ind"), b(paramTroopInfo.fingertroopmemo));
    localHashMap.put(b("g_create_time"), b(paramTroopInfo.troopCreateTime + ""));
    localHashMap.put(b("g_mem_num"), b(paramTroopInfo.wMemberNum + ""));
    localHashMap.put(b("g_adm"), b(c(paramTroopInfo.Administrator)));
    localHashMap.put(b("g_class"), b(paramTroopInfo.mGroupClassExtText));
    localHashMap.put(b("g_grade"), b(paramTroopInfo.nTroopGrade + ""));
    localHashMap.put(b("g_type"), b(paramTroopInfo.troopTypeExt + ""));
    axrn.a(null).a(paramString, "event_simple_g_info", false, 1000L, 1000L, localHashMap, null);
    a(paramTroopInfo.troopuin, paramTroopInfo.timeSec);
  }
  
  private String b(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return Base64.encodeToString(paramString.getBytes(), 3);
  }
  
  private String c(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = paramString.split("\\|");
    int i = 0;
    while (i < paramString.length)
    {
      if (!TextUtils.isEmpty(paramString[i])) {
        localStringBuilder.append(a(paramString[i])).append('^');
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    for (;;)
    {
      return;
      Object localObject = (TroopManager)paramQQAppInterface.getManager(52);
      if (localObject != null)
      {
        localObject = ((TroopManager)localObject).a();
        if (localObject != null)
        {
          paramQQAppInterface = paramQQAppInterface.c();
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            a(paramQQAppInterface, (TroopInfo)((Iterator)localObject).next());
            try
            {
              Thread.sleep(1000L);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyz
 * JD-Core Version:    0.7.0.1
 */