package com.tencent.mobileqq.data;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.MutualScoreCard;

public class IntimateInfo$IntimateScoreCardInfo
{
  public String buttonDescribe;
  public String buttonUrl;
  public int days;
  public int level;
  public String levelDescribe;
  public int score;
  public String title;
  public long type;
  public String typeDescribe;
  
  public static IntimateScoreCardInfo copyFrom(oidb_0xcf4.MutualScoreCard paramMutualScoreCard)
  {
    Object localObject;
    if (paramMutualScoreCard == null) {
      localObject = null;
    }
    IntimateScoreCardInfo localIntimateScoreCardInfo;
    do
    {
      return localObject;
      localIntimateScoreCardInfo = new IntimateScoreCardInfo();
      localIntimateScoreCardInfo.type = paramMutualScoreCard.eMutualMarkNewType.get();
      localIntimateScoreCardInfo.level = paramMutualScoreCard.uint32_level.get();
      localIntimateScoreCardInfo.days = paramMutualScoreCard.uint32_days.get();
      if (paramMutualScoreCard.bytes_title.has()) {
        localIntimateScoreCardInfo.title = paramMutualScoreCard.bytes_title.get().toStringUtf8();
      }
      localIntimateScoreCardInfo.score = paramMutualScoreCard.uint32_score.get();
      if (paramMutualScoreCard.bytes_type_describe.has()) {
        localIntimateScoreCardInfo.typeDescribe = paramMutualScoreCard.bytes_type_describe.get().toStringUtf8();
      }
      if (paramMutualScoreCard.bytes_level_describe.has()) {
        localIntimateScoreCardInfo.levelDescribe = paramMutualScoreCard.bytes_level_describe.get().toStringUtf8();
      }
      if (paramMutualScoreCard.bytes_button_describe.has()) {
        localIntimateScoreCardInfo.buttonDescribe = paramMutualScoreCard.bytes_button_describe.get().toStringUtf8();
      }
      localObject = localIntimateScoreCardInfo;
    } while (!paramMutualScoreCard.bytes_button_url.has());
    localIntimateScoreCardInfo.buttonUrl = paramMutualScoreCard.bytes_button_url.get().toStringUtf8();
    return localIntimateScoreCardInfo;
  }
  
  public static IntimateScoreCardInfo copyFromJson(JSONObject paramJSONObject)
  {
    IntimateScoreCardInfo localIntimateScoreCardInfo = new IntimateScoreCardInfo();
    localIntimateScoreCardInfo.type = paramJSONObject.optLong("type");
    localIntimateScoreCardInfo.level = paramJSONObject.optInt("level");
    localIntimateScoreCardInfo.days = paramJSONObject.optInt("days");
    localIntimateScoreCardInfo.title = paramJSONObject.optString("title");
    localIntimateScoreCardInfo.score = paramJSONObject.optInt("score");
    localIntimateScoreCardInfo.typeDescribe = paramJSONObject.optString("typeDescribe");
    localIntimateScoreCardInfo.levelDescribe = paramJSONObject.optString("levelDescribe");
    localIntimateScoreCardInfo.buttonDescribe = paramJSONObject.optString("buttonDescribe");
    localIntimateScoreCardInfo.buttonUrl = paramJSONObject.optString("buttonUrl");
    return localIntimateScoreCardInfo;
  }
  
  public JSONObject getJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", this.type);
      localJSONObject.put("level", this.level);
      localJSONObject.put("days", this.days);
      localJSONObject.put("title", this.title);
      localJSONObject.put("score", this.score);
      localJSONObject.put("typeDescribe", this.typeDescribe);
      localJSONObject.put("levelDescribe", this.levelDescribe);
      localJSONObject.put("buttonDescribe", this.buttonDescribe);
      localJSONObject.put("buttonUrl", this.buttonUrl);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    return "IntimateScoreCardInfo{type=" + this.type + ", level='" + this.level + '\'' + ", days='" + this.days + '\'' + ", title='" + this.title + '\'' + ", score='" + this.score + '\'' + ", typeDescribe='" + this.typeDescribe + '\'' + ", levelDescribe='" + this.levelDescribe + '\'' + ", buttonDescribe='" + this.buttonDescribe + '\'' + ", buttonUrl='" + this.buttonUrl + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo.IntimateScoreCardInfo
 * JD-Core Version:    0.7.0.1
 */