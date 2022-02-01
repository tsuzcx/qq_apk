package com.tencent.mobileqq.colornote.smallscreen;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UpComingMsgModel
  implements Serializable
{
  public boolean exposed;
  public String frienduin;
  public int istroop;
  public String nickName;
  public int reportType;
  public String troopUin;
  public int type;
  public List<Long> uniseq;
  
  public UpComingMsgModel() {}
  
  public UpComingMsgModel(String paramString1, String paramString2, List<Long> paramList, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    this.frienduin = paramString1;
    this.uniseq = new ArrayList(paramList);
    this.istroop = paramInt1;
    this.type = paramInt2;
    this.reportType = paramInt3;
    this.nickName = paramString3;
    this.troopUin = paramString2;
  }
  
  public UpComingMsgModel parseFromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.frienduin = paramString.optString("key_uin");
      this.istroop = paramString.optInt("key_session_type");
      this.reportType = paramString.optInt("key_report_type");
      this.nickName = paramString.optString("key_nick_name");
      this.troopUin = paramString.optString("key_troop_uin");
      JSONArray localJSONArray = paramString.optJSONArray("key_uniseq");
      this.uniseq = new ArrayList(localJSONArray.length());
      int i = 0;
      while (i < localJSONArray.length())
      {
        this.uniseq.add(Long.valueOf(localJSONArray.optLong(i)));
        i += 1;
      }
      this.type = paramString.optInt("key_from_type");
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("parseFromJson info: ");
        paramString.append(toString());
        QLog.d("UpComingMsgLogic.UpComingMsgModel", 2, paramString.toString());
        return this;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public String toJson()
  {
    String str2 = "";
    String str1 = str2;
    Object localObject;
    try
    {
      localObject = new JSONObject();
      str1 = str2;
      ((JSONObject)localObject).put("key_uin", this.frienduin);
      str1 = str2;
      ((JSONObject)localObject).put("key_session_type", this.istroop);
      str1 = str2;
      ((JSONObject)localObject).put("key_report_type", this.reportType);
      str1 = str2;
      ((JSONObject)localObject).put("key_nick_name", this.nickName);
      str1 = str2;
      ((JSONObject)localObject).put("key_troop_uin", this.troopUin);
      str1 = str2;
      JSONArray localJSONArray = new JSONArray();
      str1 = str2;
      Iterator localIterator = this.uniseq.iterator();
      for (;;)
      {
        str1 = str2;
        if (!localIterator.hasNext()) {
          break;
        }
        str1 = str2;
        localJSONArray.put((Long)localIterator.next());
      }
      str1 = str2;
      ((JSONObject)localObject).put("key_uniseq", localJSONArray);
      str1 = str2;
      ((JSONObject)localObject).put("key_from_type", this.type);
      str1 = str2;
      str2 = ((JSONObject)localObject).toString();
      str1 = str2;
      localObject = str2;
      if (QLog.isColorLevel())
      {
        str1 = str2;
        localObject = new StringBuilder();
        str1 = str2;
        ((StringBuilder)localObject).append("toJsonStr json: ");
        str1 = str2;
        ((StringBuilder)localObject).append(str2);
        str1 = str2;
        QLog.d("UpComingMsgLogic.UpComingMsgModel", 2, ((StringBuilder)localObject).toString());
        return str2;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject = str1;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.UpComingMsgModel
 * JD-Core Version:    0.7.0.1
 */