package com.tencent.qqlive.module.videoreport.dtreport.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.PlayerDTReportUtils;
import com.tencent.qqlive.tvkplayer.api.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKNetVideoInfo.DefnInfo;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.vinfo.TVKVideoInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import org.json.JSONObject;

public class DefaultTVKDataProvider
  implements IDTTVKDataProvider
{
  public static final String IS_BIZ_REPORT_READY = "is_biz_report_ready";
  public static final String IS_BIZ_REPORT_READY_VALUE_0 = "0";
  public static final String IS_BIZ_REPORT_READY_VALUE_1 = "1";
  public static final String KEY_FML_CID = "fml_cid";
  public static final String KEY_FML_VID = "fml_vid";
  public static final String KEY_PAY_STATUS = "pay_status";
  public static final String KEY_PAY_TYPE = "pay_type";
  public static final String KEY_PLAY_SOURCE = "play_source";
  public static final String KEY_PLAY_VID = "play_vid";
  public static final String KEY_VODF = "vodf";
  private static final String TAG = "DefaultTVKDataProvider";
  
  @Nullable
  private Map<String, Object> extraBizParams(@Nullable TVKProperties paramTVKProperties)
  {
    if (paramTVKProperties == null) {
      return null;
    }
    paramTVKProperties = paramTVKProperties.getProperties();
    if (paramTVKProperties == null) {
      return null;
    }
    Object localObject = fromGenericMap(paramTVKProperties);
    paramTVKProperties = (TVKProperties)localObject;
    if (localObject == null) {
      paramTVKProperties = new HashMap();
    }
    localObject = paramTVKProperties.remove("udf_kv");
    if ((localObject instanceof Map)) {
      transfer((Map)localObject, paramTVKProperties);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveBizParams: ");
    ((StringBuilder)localObject).append(new JSONObject(paramTVKProperties));
    logD(((StringBuilder)localObject).toString());
    return paramTVKProperties;
  }
  
  @Nullable
  private Map<String, Object> extraOpenParams(@Nullable TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString)
  {
    if (paramTVKPlayerVideoInfo == null) {
      return null;
    }
    paramString = new HashMap();
    putString(paramString, "fml_vid", paramTVKPlayerVideoInfo.getVid());
    putString(paramString, "fml_cid", paramTVKPlayerVideoInfo.getCid());
    putString(paramString, "play_source", Integer.valueOf(PlayerDTReportUtils.getPlaySource(paramTVKPlayerVideoInfo)));
    paramTVKPlayerVideoInfo = new StringBuilder();
    paramTVKPlayerVideoInfo.append("saveOpenParams: ");
    paramTVKPlayerVideoInfo.append(new JSONObject(paramString));
    logD(paramTVKPlayerVideoInfo.toString());
    return paramString;
  }
  
  @Nullable
  private Map<String, Object> extraStartParams(TVKNetVideoInfo paramTVKNetVideoInfo, boolean paramBoolean)
  {
    if (paramTVKNetVideoInfo == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    Object localObject = paramTVKNetVideoInfo.getVid();
    putString(localHashMap, "fml_vid", localObject);
    String str = "";
    if (paramBoolean) {
      localObject = "";
    }
    putString(localHashMap, "play_vid", localObject);
    if ((paramTVKNetVideoInfo instanceof TVKVideoInfo)) {
      localObject = Integer.valueOf(PlayerDTReportUtils.getPayType((TVKVideoInfo)paramTVKNetVideoInfo));
    } else {
      localObject = "";
    }
    putString(localHashMap, "pay_type", localObject);
    localObject = paramTVKNetVideoInfo.getCurDefinition();
    if (localObject == null) {
      localObject = str;
    } else {
      localObject = Integer.valueOf(((TVKNetVideoInfo.DefnInfo)localObject).getDefnId());
    }
    putString(localHashMap, "vodf", localObject);
    putString(localHashMap, "pay_status", Integer.valueOf(paramTVKNetVideoInfo.getMediaVideoState()));
    paramTVKNetVideoInfo = new StringBuilder();
    paramTVKNetVideoInfo.append("saveStartParams: ");
    paramTVKNetVideoInfo.append(new JSONObject(localHashMap));
    logD(paramTVKNetVideoInfo.toString());
    return localHashMap;
  }
  
  @Nullable
  private Map<String, Object> fromGenericMap(@Nullable Map<?, ?> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    transfer(paramMap, localHashMap);
    return localHashMap;
  }
  
  private void logD(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hashCode());
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    Log.d("DefaultTVKDataProvider", localStringBuilder.toString());
  }
  
  private void putString(Map<String, Object> paramMap, String paramString, Object paramObject)
  {
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = paramObject.toString();
    }
    paramMap.put(paramString, BaseUtils.emptyAs(paramObject, ""));
  }
  
  private void transfer(@NonNull Map<?, ?> paramMap, @NonNull Map<String, Object> paramMap1)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      paramMap = ((Map.Entry)localObject1).getKey();
      if (paramMap == null) {
        paramMap = null;
      } else {
        paramMap = paramMap.toString();
      }
      if (!TextUtils.isEmpty(paramMap))
      {
        Object localObject2 = ((Map.Entry)localObject1).getValue();
        localObject1 = localObject2;
        if ((localObject2 instanceof Properties)) {
          localObject1 = fromGenericMap((Properties)localObject2);
        }
        paramMap1.put(paramMap, localObject1);
      }
    }
  }
  
  public boolean active(TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    return true;
  }
  
  public Map<String, Object> formatBizParams(TVKProperties paramTVKProperties)
  {
    return extraBizParams(paramTVKProperties);
  }
  
  public Map<String, Object> formatOpenParams(TVKPlayerVideoInfo paramTVKPlayerVideoInfo, String paramString)
  {
    return extraOpenParams(paramTVKPlayerVideoInfo, paramString);
  }
  
  public Map<String, Object> formatStartParams(TVKNetVideoInfo paramTVKNetVideoInfo, boolean paramBoolean)
  {
    return extraStartParams(paramTVKNetVideoInfo, paramBoolean);
  }
  
  public String getContentId(TVKPlayerVideoInfo paramTVKPlayerVideoInfo)
  {
    return paramTVKPlayerVideoInfo.getFlowId();
  }
  
  public int getContentType(TVKPlayerVideoInfo paramTVKPlayerVideoInfo, int paramInt)
  {
    return paramInt;
  }
  
  public boolean isBizReady(TVKProperties paramTVKProperties)
  {
    if (paramTVKProperties == null) {
      return true;
    }
    paramTVKProperties = paramTVKProperties.getProperties();
    if (paramTVKProperties == null) {
      return true;
    }
    return "0".equals(paramTVKProperties.getProperty("is_biz_report_ready")) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider
 * JD-Core Version:    0.7.0.1
 */