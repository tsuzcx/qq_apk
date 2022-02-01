package com.tencent.mobileqq.kandian.biz.debug;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyDataProviderObserver;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.pts.network.ReadInJoyPTSCostHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.mobileqq.kandian.repo.feeds.IForeBackGroundCallback;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class ReadInJoyDropFrameHelper
  implements IForeBackGroundCallback
{
  private ReadInJoyDropFrameHelper.ReadInJoyFluencyObserver jdField_a_of_type_ComTencentMobileqqKandianBizDebugReadInJoyDropFrameHelper$ReadInJoyFluencyObserver = new ReadInJoyDropFrameHelper.ReadInJoyFluencyObserver();
  private Map<Integer, Double> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Map<Integer, List<ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener>> b = new HashMap();
  private Map<String, List<Double>> c = new HashMap();
  
  private ReadInJoyDropFrameHelper()
  {
    ReadinjoySPEventReport.ForeBackGround.a(this);
    ReadInJoyDataProviderObserver.getInstance().setFluencyObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizDebugReadInJoyDropFrameHelper$ReadInJoyFluencyObserver);
  }
  
  private int a(String paramString)
  {
    if ("list_new_kandian".equals(paramString)) {
      return 0;
    }
    if ("list_subscript".equals(paramString)) {
      return 70;
    }
    if ((paramString != null) && (paramString.startsWith("list_kandian_channel_")))
    {
      if (21 < paramString.length()) {
        return Integer.parseInt(paramString.substring(21));
      }
      return -1;
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
  
  public static ReadInJoyDropFrameHelper a()
  {
    return ReadInJoyDropFrameHelper.DropFrameHelperHolder.a();
  }
  
  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("proteus_bid", RIJProteusOfflineBidSp.a("default_feeds_proteus_offline_bid"));
    localJSONObject.put("cpu_type", DeviceInfoUtil.g());
    localJSONObject.put("cpu_frequency", DeviceInfoUtil.b());
    localJSONObject.put("cache_memory", DeviceInfoUtil.a());
    localJSONObject.put("device_model", DeviceInfoUtil.d());
    localJSONObject.put("os_version", DeviceInfoUtil.e());
    int i;
    if (NetworkState.isWifiConn()) {
      i = 1;
    } else {
      i = 2;
    }
    localJSONObject.put("network_type", i);
    localJSONObject.put("package_name", "8.7.0.5295");
    return localJSONObject;
  }
  
  private void a(String paramString, double paramDouble)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyDropFrameHelper.2(this, paramString, paramDouble));
  }
  
  public static boolean a()
  {
    boolean bool = ((Boolean)RIJSPUtils.a("sp_key_readinjoy_feeds_drop_frame_switch", Boolean.valueOf(true))).booleanValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadInJoyDropFrameHelper | Report enable :");
    localStringBuilder.append(bool);
    QLog.d("ReadInJoyDropFrameHelper", 1, localStringBuilder.toString());
    return bool;
  }
  
  public void a() {}
  
  public void a(int paramInt, ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener paramOnFeedsFluencyResultListener)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((Map)localObject).containsKey(Integer.valueOf(paramInt))) {
        localObject = (List)this.b.get(Integer.valueOf(paramInt));
      } else {
        localObject = new ArrayList();
      }
      if (!((List)localObject).contains(paramOnFeedsFluencyResultListener)) {
        ((List)localObject).add(paramOnFeedsFluencyResultListener);
      }
      this.b.put(Integer.valueOf(paramInt), localObject);
    }
  }
  
  public void a(String paramString, long paramLong1, long[] paramArrayOfLong, long paramLong2)
  {
    if (!a()) {
      return;
    }
    int i = a(paramString);
    double d1 = paramArrayOfLong[0];
    Double.isNaN(d1);
    double d2 = paramArrayOfLong[1];
    Double.isNaN(d2);
    double d3 = paramArrayOfLong[2];
    Double.isNaN(d3);
    double d4 = paramArrayOfLong[3];
    Double.isNaN(d4);
    double d5 = paramLong2;
    Double.isNaN(d5);
    d1 = (d1 * 16.699999999999999D + d2 * 16.699999999999999D * 1.5D + d3 * 16.699999999999999D * 3.0D + d4 * 16.699999999999999D * 6.0D) / d5;
    if (d1 >= 1.0D) {
      d1 = 1.0D;
    }
    paramString = new StringBuilder();
    paramString.append("caculateFeedsFlunency | channelId ");
    paramString.append(i);
    paramString.append(" fluencyVal ");
    paramString.append(d1);
    QLog.d("ReadInJoyDropFrameHelper", 1, paramString.toString());
    paramString = this.c;
    if (paramString != null)
    {
      if (paramString.get(String.valueOf(i)) == null) {
        this.c.put(String.valueOf(i), new ArrayList());
      }
      paramString = new StringBuilder();
      paramString.append("addFluency into reportMap | channelId ");
      paramString.append(i);
      paramString.append(" fluencyVal ");
      paramString.append(d1);
      QLog.d("ReadInJoyDropFrameHelper", 1, paramString.toString());
      ((List)this.c.get(String.valueOf(i))).add(Double.valueOf(d1));
    }
    paramString = this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void ax_()
  {
    Object localObject = this.c;
    if ((localObject != null) && (!((Map)localObject).isEmpty()))
    {
      QLog.d("ReadInJoyDropFrameHelper", 2, "background | reporFeeds Fluency");
      localObject = this.c.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        List localList = (List)this.c.get(str);
        if ((localList != null) && (localList.size() > 0))
        {
          Iterator localIterator = new ArrayList(localList).iterator();
          while (localIterator.hasNext())
          {
            Double localDouble = (Double)localIterator.next();
            a(str, localDouble.doubleValue());
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("background | reportFeedsFluency channelid ");
            localStringBuilder.append(str);
            localStringBuilder.append(" fluencyVal ");
            localStringBuilder.append(localDouble);
            QLog.d("ReadInJoyDropFrameHelper", 2, localStringBuilder.toString());
          }
          localList.clear();
        }
      }
      ReadInJoyPTSCostHelper.a();
      return;
    }
    QLog.d("ReadInJoyDropFrameHelper", 2, "background | reportMap is empty");
  }
  
  public void b(int paramInt, ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener paramOnFeedsFluencyResultListener)
  {
    Map localMap = this.b;
    if ((localMap != null) && (localMap.get(Integer.valueOf(paramInt)) != null)) {
      ((List)this.b.get(Integer.valueOf(paramInt))).remove(paramOnFeedsFluencyResultListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.debug.ReadInJoyDropFrameHelper
 * JD-Core Version:    0.7.0.1
 */