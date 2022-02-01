package com.tencent.mobileqq.confess;

import com.tencent.mobileqq.util.Utils;
import java.io.Serializable;
import org.json.JSONObject;

public class ConfessInfo
  implements Serializable
{
  public static final String KEY_CONFESSOR_FRIEND_SEX = "key_confessor_friend_sex";
  public static final String KEY_CONFESSOR_NICK = "key_confessor_nick";
  public static final String KEY_CONFESSOR_NUM = "key_confessor_num";
  public static final String KEY_CONFESSOR_SEX = "key_confessor_sex";
  public static final String KEY_CONFESSOR_UIN = "key_confessor_uin";
  public static final String KEY_CONFESS_BG_TYPE = "key_confess_bg_type";
  public static final String KEY_CONFESS_DESC = "key_confess_desc";
  public static final String KEY_CONFESS_REC_NICK_NAME = "key_confess_rec_nick_name";
  public static final String KEY_CONFESS_REC_NICK_TYPE = "key_confess_rec_nick_type";
  public static final String KEY_CONFESS_REC_UIN = "key_confess_rec_uin";
  public static final String KEY_CONFESS_SYSMSG = "key_confess_sysmsg";
  public static final String KEY_CONFESS_TIME = "key_confess_time";
  public static final String KEY_CONFESS_TOPICID = "key_confess_topicid";
  private static final long serialVersionUID = 0L;
  public long confessTime;
  public String confessorNick;
  public int confessorSex;
  public long confessorUin;
  public String confessorUinStr;
  public int isSysMsg;
  public String topic;
  public int topicId;
  
  public static String toJsonStr(int paramInt1, long paramLong1, int paramInt2, String paramString1, int paramInt3, String paramString2, long paramLong2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("key_confess_topicid", paramInt1);
      localJSONObject.put("key_confessor_uin", paramLong1);
      localJSONObject.put("key_confessor_nick", paramString1);
      localJSONObject.put("key_confessor_sex", paramInt2);
      localJSONObject.put("key_confess_sysmsg", paramInt3);
      localJSONObject.put("key_confess_desc", paramString2);
      localJSONObject.put("key_confess_time", paramLong2);
      paramString1 = localJSONObject.toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if (!(paramObject instanceof ConfessInfo)) {
        return false;
      }
      paramObject = (ConfessInfo)paramObject;
      bool1 = bool2;
      if (this.topicId == paramObject.topicId)
      {
        bool1 = bool2;
        if (this.confessorSex == paramObject.confessorSex)
        {
          bool1 = bool2;
          if (this.confessorUin == paramObject.confessorUin)
          {
            bool1 = bool2;
            if (Utils.a(this.confessorNick, paramObject.confessorNick))
            {
              bool1 = bool2;
              if (Utils.a(this.topic, paramObject.topic)) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public void parseFromJsonStr(String paramString)
  {
    reset();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("key_confess_topicid")) {
        this.topicId = paramString.getInt("key_confess_topicid");
      }
      if (paramString.has("key_confessor_sex")) {
        this.confessorSex = paramString.getInt("key_confessor_sex");
      }
      if (paramString.has("key_confess_sysmsg")) {
        this.isSysMsg = paramString.getInt("key_confess_sysmsg");
      }
      if (paramString.has("key_confessor_uin")) {
        this.confessorUin = paramString.getLong("key_confessor_uin");
      }
      if (paramString.has("key_confessor_nick")) {
        this.confessorNick = paramString.getString("key_confessor_nick");
      }
      if (paramString.has("key_confess_desc")) {
        this.topic = paramString.getString("key_confess_desc");
      }
      if (paramString.has("key_confess_time")) {
        this.confessTime = paramString.getLong("key_confess_time");
      }
      this.confessorUinStr = String.valueOf(this.confessorUin);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void reset()
  {
    this.topicId = 0;
    this.confessorSex = 0;
    this.isSysMsg = 0;
    this.confessorUin = 0L;
    this.confessorNick = "";
    this.confessorUinStr = "";
    this.topic = "";
    this.confessTime = 0L;
  }
  
  public String toJsonStr()
  {
    return toJsonStr(this.topicId, this.confessorUin, this.confessorSex, this.confessorNick, this.isSysMsg, this.topic, this.confessTime);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append("topicId");
    localStringBuilder.append("=");
    localStringBuilder.append(this.topicId);
    localStringBuilder.append(" ");
    localStringBuilder.append("topic");
    localStringBuilder.append("=");
    localStringBuilder.append(this.topic);
    localStringBuilder.append(" ");
    localStringBuilder.append("confessorUin");
    localStringBuilder.append("=");
    localStringBuilder.append(this.confessorUin);
    localStringBuilder.append(" ");
    localStringBuilder.append("confessorNick");
    localStringBuilder.append("=");
    localStringBuilder.append(this.confessorNick);
    localStringBuilder.append(" ");
    localStringBuilder.append("confessorSex");
    localStringBuilder.append("=");
    localStringBuilder.append(this.confessorSex);
    localStringBuilder.append(" ");
    localStringBuilder.append("confessTime");
    localStringBuilder.append("=");
    localStringBuilder.append(this.confessTime);
    localStringBuilder.append(" ");
    localStringBuilder.append("isSysMsg");
    localStringBuilder.append("=");
    localStringBuilder.append(this.isSysMsg);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessInfo
 * JD-Core Version:    0.7.0.1
 */