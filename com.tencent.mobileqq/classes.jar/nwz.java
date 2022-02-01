import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class nwz
{
  private static final Map<String, Map<Long, Long>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private static nwz jdField_a_of_type_Nwz;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private int jdField_b_of_type_Int;
  private Map<Long, Long> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  
  private nwz()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(373);
    this.jdField_a_of_type_Long = (localAladdinConfig.getIntegerFromString("over_time", 300) * 1000L);
    this.jdField_a_of_type_Int = localAladdinConfig.getIntegerFromString("max_size", 5);
    this.jdField_b_of_type_Int = localAladdinConfig.getIntegerFromString("expose_rate", 20);
  }
  
  private static String a(Set<Long> paramSet)
  {
    if ((paramSet == null) || (paramSet.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      localStringBuilder.append((Long)paramSet.next()).append(",");
    }
    return localStringBuilder.deleteCharAt(localStringBuilder.length() - 1).toString();
  }
  
  private static Map<Long, Long> a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "DEFAULT_EMPTY";
    }
    Map localMap = (Map)jdField_a_of_type_JavaUtilMap.get(str);
    paramString = localMap;
    if (localMap == null) {
      paramString = new ConcurrentHashMap();
    }
    jdField_a_of_type_JavaUtilMap.put(str, paramString);
    return paramString;
  }
  
  public static nwz a()
  {
    if (jdField_a_of_type_Nwz == null) {}
    try
    {
      if (jdField_a_of_type_Nwz == null) {
        jdField_a_of_type_Nwz = new nwz();
      }
      return jdField_a_of_type_Nwz;
    }
    finally {}
  }
  
  private void a()
  {
    if (this.jdField_b_of_type_JavaUtilMap.isEmpty()) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (l > ((Long)localEntry.getValue()).longValue() + this.jdField_a_of_type_Long)
        {
          QLog.i("AdFreshManager", 3, "removeExpiredAd,adId:" + localEntry.getKey());
          localIterator.remove();
        }
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_JavaUtilMap.isEmpty()) {}
    label139:
    for (;;)
    {
      return;
      Iterator localIterator1 = this.jdField_b_of_type_JavaUtilMap.entrySet().iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label139;
        }
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        Iterator localIterator2 = jdField_a_of_type_JavaUtilMap.values().iterator();
        if (localIterator2.hasNext())
        {
          Map localMap = (Map)localIterator2.next();
          if ((localMap == null) || (!localMap.containsKey(localEntry.getKey()))) {
            break;
          }
          QLog.i("AdFreshManager", 3, "removeRepeatAd,adId:" + localEntry.getKey());
          localIterator1.remove();
        }
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_JavaUtilMap.size() <= this.jdField_a_of_type_Int) {}
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilMap.entrySet());
      Collections.sort(localArrayList, new nxa(this));
      int i = this.jdField_a_of_type_Int;
      while (i < localArrayList.size())
      {
        QLog.i("AdFreshManager", 3, "removeRedundantAd,adId:" + ((Map.Entry)localArrayList.get(i)).getKey());
        this.jdField_b_of_type_JavaUtilMap.remove(((Map.Entry)localArrayList.get(i)).getKey());
        i += 1;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String a()
  {
    return a(a());
  }
  
  public Set<Long> a()
  {
    try
    {
      a();
      b();
      c();
      Set localSet = this.jdField_b_of_type_JavaUtilMap.keySet();
      QLog.i("AdFreshManager", 3, "getRequestAdIds,result:" + a(localSet));
      return localSet;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("AdFreshManager", 0, "getRequestAdIds,", localException);
      }
    }
  }
  
  public void a(Long paramLong)
  {
    if (paramLong.longValue() == 0L) {
      return;
    }
    Iterator localIterator = jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      Map localMap = (Map)localIterator.next();
      if (localMap != null) {
        localMap.remove(paramLong);
      }
    }
    QLog.i("AdFreshManager", 3, "removeAdFromAllScene,adId:" + paramLong);
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.jdField_b_of_type_JavaUtilMap.putAll(a(paramString));
    a(paramString).clear();
    QLog.i("AdFreshManager", 3, "flushSceneAds,scene:" + paramString);
  }
  
  public void a(String paramString, Long paramLong)
  {
    a(paramString).put(paramLong, Long.valueOf(System.currentTimeMillis()));
    QLog.i("AdFreshManager", 3, "addAdId,adId:" + paramLong);
  }
  
  public void a(String paramString, Set<Long> paramSet)
  {
    if ((paramString == null) || (paramSet == null) || (paramSet.isEmpty())) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        Long localLong = (Long)paramSet.next();
        QLog.i("AdFreshManager", 3, "addAdIds,scene:" + paramString + ",adId:" + localLong);
        a(paramString).put(localLong, Long.valueOf(l));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nwz
 * JD-Core Version:    0.7.0.1
 */