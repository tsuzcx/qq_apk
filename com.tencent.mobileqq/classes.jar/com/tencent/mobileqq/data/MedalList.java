package com.tencent.mobileqq.data;

import MQQ.VipMedalInfo;
import MQQ.VipMedalList;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class MedalList
{
  public ArrayList<MedalList.Info> infoList = new ArrayList();
  public String jumpUrl;
  
  public static MedalList parse(@NonNull VipMedalList paramVipMedalList)
  {
    MedalList localMedalList = new MedalList();
    int i = 0;
    while (i < paramVipMedalList.medalInfo.size())
    {
      MedalList.Info localInfo = new MedalList.Info();
      localInfo.type = ((VipMedalInfo)paramVipMedalList.medalInfo.get(i)).type;
      localInfo.value = ((VipMedalInfo)paramVipMedalList.medalInfo.get(i)).value;
      localInfo.isRemind = ((VipMedalInfo)paramVipMedalList.medalInfo.get(i)).is_remind;
      localInfo.tipsTimes = ((VipMedalInfo)paramVipMedalList.medalInfo.get(i)).tips_times;
      localMedalList.infoList.add(localInfo);
      i += 1;
    }
    localMedalList.jumpUrl = paramVipMedalList.jumpUrl;
    return localMedalList;
  }
  
  public static MedalList parse(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new JSONObject(paramString);
    JSONArray localJSONArray = paramString.optJSONArray("l");
    MedalList localMedalList = new MedalList();
    if (localJSONArray != null)
    {
      int i = 0;
      while (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        MedalList.Info localInfo = new MedalList.Info();
        localInfo.type = localJSONObject.optInt("t");
        localInfo.value = localJSONObject.getString("v");
        localInfo.isRemind = localJSONObject.optInt("i");
        localInfo.tipsTimes = localJSONObject.optInt("ti");
        localMedalList.infoList.add(localInfo);
        i += 1;
      }
    }
    localMedalList.jumpUrl = paramString.optString("j");
    return localMedalList;
  }
  
  public String convert()
  {
    if (this.infoList.size() == 0) {
      return "";
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < this.infoList.size())
    {
      MedalList.Info localInfo = (MedalList.Info)this.infoList.get(i);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("t", localInfo.type);
      localJSONObject2.put("v", localInfo.value);
      localJSONObject2.put("i", localInfo.isRemind);
      localJSONObject2.put("ti", localInfo.tipsTimes);
      localJSONArray.put(localJSONObject2);
      i += 1;
    }
    localJSONObject1.put("l", localJSONArray);
    if (!TextUtils.isEmpty(this.jumpUrl)) {
      localJSONObject1.put("j", this.jumpUrl);
    }
    return localJSONObject1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MedalList
 * JD-Core Version:    0.7.0.1
 */