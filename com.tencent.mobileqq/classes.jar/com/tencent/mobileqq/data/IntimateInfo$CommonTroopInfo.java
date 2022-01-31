package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import apei;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.OneGroupInfo;

public class IntimateInfo$CommonTroopInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CommonTroopInfo> CREATOR = new apei();
  public long recentMsgTime;
  public String troopCode;
  public String troopName;
  public String troopUin;
  
  public IntimateInfo$CommonTroopInfo() {}
  
  public IntimateInfo$CommonTroopInfo(Parcel paramParcel)
  {
    this.troopUin = paramParcel.readString();
    this.troopCode = paramParcel.readString();
    this.troopName = paramParcel.readString();
    this.recentMsgTime = paramParcel.readLong();
  }
  
  public static CommonTroopInfo copyFrom(oidb_0xcf4.OneGroupInfo paramOneGroupInfo)
  {
    if (paramOneGroupInfo == null) {
      return null;
    }
    CommonTroopInfo localCommonTroopInfo = new CommonTroopInfo();
    String str;
    if (paramOneGroupInfo.uint64_group_uin.has())
    {
      str = String.valueOf(paramOneGroupInfo.uint64_group_uin.get());
      localCommonTroopInfo.troopUin = str;
      if (!paramOneGroupInfo.uint64_group_code.has()) {
        break label130;
      }
      str = String.valueOf(paramOneGroupInfo.uint64_group_code.get());
      label63:
      localCommonTroopInfo.troopCode = str;
      if (!paramOneGroupInfo.string_group_name.has()) {
        break label136;
      }
      str = paramOneGroupInfo.string_group_name.get().toStringUtf8();
      label90:
      localCommonTroopInfo.troopName = str;
      if (!paramOneGroupInfo.uint32_cmduin_last_msg_time.has()) {
        break label142;
      }
    }
    label130:
    label136:
    label142:
    for (long l = paramOneGroupInfo.uint32_cmduin_last_msg_time.get();; l = 0L)
    {
      localCommonTroopInfo.recentMsgTime = l;
      return localCommonTroopInfo;
      str = "";
      break;
      str = "";
      break label63;
      str = "";
      break label90;
    }
  }
  
  public static CommonTroopInfo copyFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    CommonTroopInfo localCommonTroopInfo = new CommonTroopInfo();
    localCommonTroopInfo.troopUin = paramJSONObject.optString("troopUin", "");
    localCommonTroopInfo.troopCode = paramJSONObject.optString("troopCode", "");
    localCommonTroopInfo.troopName = paramJSONObject.optString("troopName", "");
    localCommonTroopInfo.recentMsgTime = paramJSONObject.optLong("recentMsgTime", 0L);
    return localCommonTroopInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public JSONObject getJSONObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!TextUtils.isEmpty(this.troopUin)) {
        localJSONObject.put("troopUin", this.troopUin);
      }
      if (!TextUtils.isEmpty(this.troopCode)) {
        localJSONObject.put("troopCode", this.troopCode);
      }
      if (!TextUtils.isEmpty(this.troopName)) {
        localJSONObject.put("troopName", this.troopName);
      }
      localJSONObject.put("recentMsgTime", this.recentMsgTime);
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
    return "CommonTroopInfo{troopUin='" + this.troopUin + '\'' + ", troopCode='" + this.troopCode + '\'' + ", troopName='" + this.troopName + '\'' + ", recentMsgTime=" + this.recentMsgTime + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.troopUin);
    paramParcel.writeString(this.troopCode);
    paramParcel.writeString(this.troopName);
    paramParcel.writeLong(this.recentMsgTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.IntimateInfo.CommonTroopInfo
 * JD-Core Version:    0.7.0.1
 */