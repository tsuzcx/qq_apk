package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import cooperation.qzone.LbsDataV2.GpsInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
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
  public static final int VIDEO_PLAY_SCENE_WEISHI = 29;
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
  public Map<String, String> infos;
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
      double d = paramGpsInfo.lat;
      Double.isNaN(d);
      this.longitude = String.valueOf(d * 1.0D / 1000000.0D);
      d = paramGpsInfo.lon;
      Double.isNaN(d);
      this.latitude = String.valueOf(d * 1.0D / 1000000.0D);
    }
  }
  
  public LpReportInfo_dc00321(int paramInt1, int paramInt2, int paramInt3, Map<String, String> paramMap, LbsDataV2.GpsInfo paramGpsInfo)
  {
    this.actiontype = paramInt1;
    this.subactiontype = paramInt2;
    this.reserves = paramInt3;
    this.infos = paramMap;
    if (paramGpsInfo != null)
    {
      double d = paramGpsInfo.lat;
      Double.isNaN(d);
      this.longitude = String.valueOf(d * 1.0D / 1000000.0D);
      d = paramGpsInfo.lon;
      Double.isNaN(d);
      this.latitude = String.valueOf(d * 1.0D / 1000000.0D);
    }
  }
  
  public LpReportInfo_dc00321(LbsDataV2.GpsInfo paramGpsInfo)
  {
    if (paramGpsInfo != null)
    {
      double d = paramGpsInfo.lat;
      Double.isNaN(d);
      this.longitude = String.valueOf(d * 1.0D / 1000000.0D);
      d = paramGpsInfo.lon;
      Double.isNaN(d);
      this.latitude = String.valueOf(d * 1.0D / 1000000.0D);
    }
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
  
  public static void report(int paramInt1, int paramInt2, int paramInt3, Map<String, String> paramMap, LbsDataV2.GpsInfo paramGpsInfo)
  {
    paramMap = new LpReportInfo_dc00321(paramInt1, paramInt2, paramInt3, paramMap, paramGpsInfo);
    LpReportManager.getInstance().reportToDC00321(paramMap, false, true);
  }
  
  public static void report(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, LbsDataV2.GpsInfo paramGpsInfo)
  {
    paramGpsInfo = new LpReportInfo_dc00321(paramInt1, paramInt2, paramInt3, paramGpsInfo);
    LpReportManager.getInstance().reportToDC00321(paramGpsInfo, paramBoolean1, paramBoolean2);
  }
  
  public static void weishiReport(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LpReportInfo_dc00321 localLpReportInfo_dc00321 = new LpReportInfo_dc00321(paramInt1, paramInt2, paramInt3, null);
    localLpReportInfo_dc00321.reserves3 = Integer.toString(paramInt4);
    localLpReportInfo_dc00321.video_play_scene = 29;
    LpReportManager.getInstance().reportToDC00321(localLpReportInfo_dc00321, false, true);
  }
  
  public String getSimpleInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dc00321:");
    localStringBuilder.append(this.actiontype);
    localStringBuilder.append(",");
    localStringBuilder.append(this.subactiontype);
    localStringBuilder.append(",");
    localStringBuilder.append(this.reserves);
    return localStringBuilder.toString();
  }
  
  public Map<String, String> toMap()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.infos;
    Object localObject2;
    String str;
    if (localObject1 != null)
    {
      localObject1 = ((Map)localObject1).keySet().iterator();
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
      } else {
        localObject1 = new JSONObject();
      }
      if (((JSONObject)localObject1).length() > 0)
      {
        localObject2 = ((JSONObject)localObject1).keys();
        while (((Iterator)localObject2).hasNext())
        {
          str = (String)((Iterator)localObject2).next();
          localHashMap.put(str, ((JSONObject)localObject1).optString(str));
        }
      }
    }
    catch (Exception localException1)
    {
      label173:
      break label173;
    }
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
      localHashMap.put("uin", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getAccount());
    }
    if (localHashMap.containsKey("network_type")) {}
    try
    {
      i = Integer.parseInt((String)localHashMap.get("network_type"));
    }
    catch (Exception localException2)
    {
      int i;
      label321:
      break label321;
    }
    i = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getNetworkType();
    break label354;
    i = ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getNetworkType();
    label354:
    localHashMap.put("network_type", String.valueOf(((ILpReportUtils)QRoute.api(ILpReportUtils.class)).convertNetworkTypeToFitInDc00518(i)));
    localHashMap.put("qua", ((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getQUA3());
    localHashMap.put("device", "2");
    localHashMap.put("p_x", this.longitude);
    localHashMap.put("p_y", this.latitude);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.report.lp.LpReportInfo_dc00321
 * JD-Core Version:    0.7.0.1
 */