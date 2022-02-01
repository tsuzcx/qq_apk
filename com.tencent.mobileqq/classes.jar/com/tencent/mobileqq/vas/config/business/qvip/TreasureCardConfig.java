package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TreasureCardConfig
{
  public long a = 86400L;
  public long b = 21600L;
  public long c = 21600L;
  public int d = 1;
  
  @NonNull
  public static TreasureCardConfig a()
  {
    return new TreasureCardConfig();
  }
  
  @NonNull
  public static TreasureCardConfig a(@Nullable String paramString)
  {
    TreasureCardConfig localTreasureCardConfig = new TreasureCardConfig();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localTreasureCardConfig.d = paramString.optInt("enableTCard", 1);
        localTreasureCardConfig.a = paramString.optLong("phoneNumberCacheInterval", 86400L);
        localTreasureCardConfig.b = paramString.optLong("tcardMessageInterval", 21600L);
        localTreasureCardConfig.c = paramString.optLong("tcardIF4ReqInterval", 21600L);
        return localTreasureCardConfig;
      }
    }
    catch (JSONException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("json parse error:");
      localStringBuilder.append(paramString);
      QLog.e("TreasureCardProcessor", 1, localStringBuilder.toString());
    }
    return localTreasureCardConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.TreasureCardConfig
 * JD-Core Version:    0.7.0.1
 */