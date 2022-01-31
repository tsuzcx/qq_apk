package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.module.common.NetworkState;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.QUA;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class LpReportInfo_dc00321
  implements LpReportInfo
{
  public static final int DC00321_NETWORK_TYPE_2G = 2;
  public static final int DC00321_NETWORK_TYPE_3G = 3;
  public static final int DC00321_NETWORK_TYPE_4G = 4;
  public static final int DC00321_NETWORK_TYPE_5G = 5;
  public static final int DC00321_NETWORK_TYPE_CABLE = 6;
  public static final int DC00321_NETWORK_TYPE_UNKNOWN = 9;
  public static final int DC00321_NETWORK_TYPE_WIFI = 1;
  public int actiontype;
  public long author_uin;
  public long client_video_play_time;
  public long client_video_solo_time;
  public int device;
  public long emotion_use_time;
  public String extraInfo;
  public int feeds_type;
  public String feeds_url;
  public String gateway_ip;
  public String gift_id;
  public int gift_num;
  public int gift_to_type;
  public String h265_url;
  public int height;
  public String imei;
  public Map infos;
  public int is_auto_play;
  public int is_original;
  public long is_video_seek;
  public String latitude = "";
  public String like_id;
  public String live_name;
  public long live_online_time;
  public int live_page;
  public int live_source;
  public int live_state;
  public int live_user_type;
  public String longitude = "";
  public String mobile_type;
  public int network_type;
  public int photocubage;
  public String play_id;
  public String qua;
  public String refer;
  public long repost_uin;
  public int reserves;
  public String reserves2;
  public String reserves3;
  public String reserves4;
  public String reserves5;
  public String reserves6;
  public String s_vid;
  public long seq;
  public String shuoshuoid;
  public long stay_time;
  public int subactiontype;
  public String tag;
  public long to_uin;
  public long uin;
  public int upway;
  public String vid;
  public long vid_play_id;
  public long video_equipment;
  public int video_floating_from_scenes;
  public int video_floating_from_types;
  public int video_play_scene;
  public int video_play_source;
  public long video_play_time;
  public long video_solo_time;
  public int video_sources;
  public long video_total_time;
  public int width;
  public int write_from;
  
  public LpReportInfo_dc00321(int paramInt1, int paramInt2, int paramInt3, LbsDataV2.GpsInfo paramGpsInfo)
  {
    this.actiontype = paramInt1;
    this.subactiontype = paramInt2;
    this.reserves = paramInt3;
    if (paramGpsInfo != null)
    {
      this.longitude = String.valueOf(paramGpsInfo.lat * 1.0D / 1000000.0D);
      this.latitude = String.valueOf(paramGpsInfo.lon * 1.0D / 1000000.0D);
    }
  }
  
  public LpReportInfo_dc00321(int paramInt1, int paramInt2, int paramInt3, Map paramMap, LbsDataV2.GpsInfo paramGpsInfo)
  {
    this.actiontype = paramInt1;
    this.subactiontype = paramInt2;
    this.reserves = paramInt3;
    this.infos = paramMap;
    if (paramGpsInfo != null)
    {
      this.longitude = String.valueOf(paramGpsInfo.lat * 1.0D / 1000000.0D);
      this.latitude = String.valueOf(paramGpsInfo.lon * 1.0D / 1000000.0D);
    }
  }
  
  public LpReportInfo_dc00321(LbsDataV2.GpsInfo paramGpsInfo)
  {
    if (paramGpsInfo != null)
    {
      this.longitude = String.valueOf(paramGpsInfo.lat * 1.0D / 1000000.0D);
      this.latitude = String.valueOf(paramGpsInfo.lon * 1.0D / 1000000.0D);
    }
  }
  
  public static int convertNetworkTypeToFitInDc00321(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
      return 9;
    case 1: 
      return 1;
    case 3: 
      return 2;
    case 2: 
      return 3;
    }
    return 4;
  }
  
  public static void report(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, LbsDataV2.GpsInfo paramGpsInfo)
  {
    paramGpsInfo = new LpReportInfo_dc00321(paramInt1, paramInt2, paramInt3, paramGpsInfo);
    paramGpsInfo.reserves3 = Integer.toString(paramInt4);
    LpReportManager.getInstance().reportToDC00321(paramGpsInfo, paramBoolean1, paramBoolean2);
  }
  
  public static void report(int paramInt1, int paramInt2, int paramInt3, LbsDataV2.GpsInfo paramGpsInfo)
  {
    paramGpsInfo = new LpReportInfo_dc00321(paramInt1, paramInt2, paramInt3, paramGpsInfo);
    LpReportManager.getInstance().reportToDC00321(paramGpsInfo, false, true);
  }
  
  public static void report(int paramInt1, int paramInt2, int paramInt3, Map paramMap, LbsDataV2.GpsInfo paramGpsInfo)
  {
    paramMap = new LpReportInfo_dc00321(paramInt1, paramInt2, paramInt3, paramMap, paramGpsInfo);
    LpReportManager.getInstance().reportToDC00321(paramMap, false, true);
  }
  
  public static void report(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, LbsDataV2.GpsInfo paramGpsInfo)
  {
    paramGpsInfo = new LpReportInfo_dc00321(paramInt1, paramInt2, paramInt3, paramGpsInfo);
    LpReportManager.getInstance().reportToDC00321(paramGpsInfo, paramBoolean1, paramBoolean2);
  }
  
  public String getSimpleInfo()
  {
    return "dc00321:" + this.actiontype + "," + this.subactiontype + "," + this.reserves;
  }
  
  public Map toMap()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1;
    Object localObject2;
    String str;
    if (this.infos != null)
    {
      localObject1 = this.infos.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        str = (String)this.infos.get(localObject2);
        if (!TextUtils.isEmpty(str)) {
          localHashMap.put(localObject2, str);
        }
      }
    }
    try
    {
      if (!TextUtils.isEmpty(this.extraInfo)) {
        localObject1 = new JSONObject(this.extraInfo);
      }
      for (;;)
      {
        if (((JSONObject)localObject1).length() > 0)
        {
          localObject2 = ((JSONObject)localObject1).keys();
          while (((Iterator)localObject2).hasNext())
          {
            str = (String)((Iterator)localObject2).next();
            localHashMap.put(str, ((JSONObject)localObject1).optString(str));
          }
        }
        try
        {
          i = Integer.parseInt((String)localHashMap.get("network_type"));
          localHashMap.put("network_type", String.valueOf(convertNetworkTypeToFitInDc00321(i)));
          localHashMap.put("qua", QUA.a());
          localHashMap.put("device", "2");
          localHashMap.put("p_x", this.longitude);
          localHashMap.put("p_y", this.latitude);
          return localHashMap;
          localJSONObject = new JSONObject();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            i = NetworkState.g().getNetworkType();
          }
        }
      }
    }
    catch (Exception localException1)
    {
      if (!localHashMap.containsKey("actiontype")) {
        localHashMap.put("actiontype", String.valueOf(this.actiontype));
      }
      if (!localHashMap.containsKey("subactiontype")) {
        localHashMap.put("subactiontype", String.valueOf(this.subactiontype));
      }
      if (!localHashMap.containsKey("reserves")) {
        localHashMap.put("reserves", String.valueOf(this.reserves));
      }
      if (!localHashMap.containsKey("uin")) {
        localHashMap.put("uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
      }
      if (!localHashMap.containsKey("network_type")) {}
    }
    for (;;)
    {
      JSONObject localJSONObject;
      int i = NetworkState.g().getNetworkType();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc00321
 * JD-Core Version:    0.7.0.1
 */