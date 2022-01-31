import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class ntv
  implements otf
{
  private Map<Integer, Double> jdField_a_of_type_JavaUtilMap = new HashMap();
  private nty jdField_a_of_type_Nty = new nty();
  private Map<Integer, List<ntx>> b = new HashMap();
  private Map<String, List<Double>> c = new HashMap();
  
  private ntv()
  {
    ota.a(this);
    bhwh.a().a(this.jdField_a_of_type_Nty);
  }
  
  private int a(String paramString)
  {
    if ("list_new_kandian".equals(paramString)) {
      return 0;
    }
    if ("list_subscript".equals(paramString)) {
      return 70;
    }
    if ((paramString != null) && (paramString.contains("list_kandian_channel_"))) {
      return Integer.parseInt(paramString.substring(paramString.indexOf("list_kandian_channel_")));
    }
    if ("list_comment_kandian".equals(paramString)) {
      return 6666;
    }
    if ("proteus_family_feeds".equals(paramString)) {
      return 8888;
    }
    if ("list_kandian_native_web".equals(paramString)) {
      return 5555;
    }
    if ("list_kandian_daily_new".equals(paramString)) {
      return 9999;
    }
    return -1;
  }
  
  public static ntv a()
  {
    return ntw.a();
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("proteus_bid", bhvy.a("default_feeds_proteus_offline_bid"));
    localJSONObject.put("cpu_type", bbdh.g());
    localJSONObject.put("cpu_frequency", bbdh.a());
    localJSONObject.put("cache_memory", bbdh.d());
    localJSONObject.put("device_model", bbdh.d());
    localJSONObject.put("os_version", bbdh.e());
    if (NetworkState.isWifiConn()) {}
    for (int i = 1;; i = 2)
    {
      localJSONObject.put("network_type", i);
      localJSONObject.put("package_name", "8.3.0.4480");
      return localJSONObject;
    }
  }
  
  private void a(String paramString, double paramDouble)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyDropFrameHelper.2(this, paramString, paramDouble));
  }
  
  public static boolean a()
  {
    boolean bool = ((Boolean)bhvy.a("sp_key_readinjoy_feeds_drop_frame_switch", Boolean.valueOf(true))).booleanValue();
    QLog.d("ReadInJoyDropFrameHelper", 1, "ReadInJoyDropFrameHelper | Report enable :" + bool);
    return bool;
  }
  
  public void a(int paramInt, ntx paramntx)
  {
    if (this.b != null) {
      if (!this.b.containsKey(Integer.valueOf(paramInt))) {
        break label74;
      }
    }
    label74:
    for (Object localObject = (List)this.b.get(Integer.valueOf(paramInt));; localObject = new ArrayList())
    {
      if (!((List)localObject).contains(paramntx)) {
        ((List)localObject).add(paramntx);
      }
      this.b.put(Integer.valueOf(paramInt), localObject);
      return;
    }
  }
  
  public void a(String paramString, long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    if (!a()) {
      return;
    }
    int i = a(paramString);
    double d = (paramArrayOfLong[0] * 16.699999999999999D + paramArrayOfLong[1] * 16.699999999999999D * 1.5D + paramArrayOfLong[2] * 16.699999999999999D * 3.0D + paramArrayOfLong[3] * 16.699999999999999D * 6.0D) / paramLong2;
    if (d < 1.0D) {}
    for (;;)
    {
      QLog.d("ReadInJoyDropFrameHelper", 1, "caculateFeedsFlunency | channelId " + i + " fluencyVal " + d);
      if (this.c != null)
      {
        if (this.c.get(String.valueOf(i)) == null) {
          this.c.put(String.valueOf(i), new ArrayList());
        }
        QLog.d("ReadInJoyDropFrameHelper", 1, "addFluency into reportMap | channelId " + i + " fluencyVal " + d);
        ((List)this.c.get(String.valueOf(i))).add(Double.valueOf(d));
      }
      if (this.jdField_a_of_type_JavaUtilMap == null) {
        break;
      }
      return;
      d = 1.0D;
    }
  }
  
  public void b(int paramInt, ntx paramntx)
  {
    if ((this.b != null) && (this.b.get(Integer.valueOf(paramInt)) != null)) {
      ((List)this.b.get(Integer.valueOf(paramInt))).remove(paramntx);
    }
  }
  
  public void l() {}
  
  public void m()
  {
    if ((this.c == null) || (this.c.isEmpty()))
    {
      QLog.d("ReadInJoyDropFrameHelper", 2, "background | reportMap is empty");
      return;
    }
    QLog.d("ReadInJoyDropFrameHelper", 2, "background | reporFeeds Fluency");
    Iterator localIterator1 = this.c.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      List localList = (List)this.c.get(str);
      if ((localList != null) && (localList.size() > 0))
      {
        Iterator localIterator2 = new ArrayList(localList).iterator();
        while (localIterator2.hasNext())
        {
          Double localDouble = (Double)localIterator2.next();
          a(str, localDouble.doubleValue());
          QLog.d("ReadInJoyDropFrameHelper", 2, "background | reportFeedsFluency channelid " + str + " fluencyVal " + localDouble);
        }
        localList.clear();
      }
    }
    saf.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntv
 * JD-Core Version:    0.7.0.1
 */