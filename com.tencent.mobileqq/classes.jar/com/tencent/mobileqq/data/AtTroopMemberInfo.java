package com.tencent.mobileqq.data;

import com.tencent.imcore.message.InitMsgModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class AtTroopMemberInfo
{
  public static AtTroopMemberInfo.Callback sCallback = new AtTroopMemberInfoDummyCallback();
  public byte flag = 0;
  public short startPos = 0;
  public short textLen = 0;
  public long uin = 0L;
  public short wExtBufLen = 0;
  
  static
  {
    InitMsgModule.a();
  }
  
  public static void dWord2Byte(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    sCallback.a(paramArrayOfByte, paramInt, paramLong);
  }
  
  public static long getLongData(byte[] paramArrayOfByte, int paramInt)
  {
    return sCallback.a(paramArrayOfByte, paramInt);
  }
  
  public static short getShortData(byte[] paramArrayOfByte, int paramInt)
  {
    return sCallback.a(paramArrayOfByte, paramInt);
  }
  
  public static void setCallback(AtTroopMemberInfo.Callback paramCallback)
  {
    sCallback = paramCallback;
  }
  
  public static AtTroopMemberInfo setFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    AtTroopMemberInfo localAtTroopMemberInfo = new AtTroopMemberInfo();
    try
    {
      localAtTroopMemberInfo.flag = ((byte)((Integer)paramJSONObject.get("flag")).intValue());
      localAtTroopMemberInfo.uin = paramJSONObject.getLong("uin");
      localAtTroopMemberInfo.startPos = ((short)((Integer)paramJSONObject.get("startPos")).intValue());
      localAtTroopMemberInfo.textLen = ((short)((Integer)paramJSONObject.get("textLen")).intValue());
      return localAtTroopMemberInfo;
    }
    catch (ClassCastException paramJSONObject)
    {
      QLog.e("AtTroopMemberInfo", 1, paramJSONObject, new Object[0]);
      return null;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("AtTroopMemberInfo", 1, paramJSONObject, new Object[0]);
    }
    return null;
  }
  
  public static void word2Byte(byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    sCallback.a(paramArrayOfByte, paramInt, paramShort);
  }
  
  public boolean isIncludingAll()
  {
    return (this.flag == 1) && (this.uin == 0L);
  }
  
  public boolean isIncludingMe(long paramLong)
  {
    return (this.flag == 0) && (this.uin == paramLong);
  }
  
  public boolean isValid()
  {
    return (this.startPos >= 0) && (this.textLen > 0);
  }
  
  public int length()
  {
    return this.wExtBufLen + 11;
  }
  
  public boolean readFrom(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramInt >= 0) && (paramArrayOfByte.length >= paramInt + 11))
    {
      this.startPos = getShortData(paramArrayOfByte, paramInt + 0);
      this.textLen = getShortData(paramArrayOfByte, paramInt + 2);
      this.flag = paramArrayOfByte[(paramInt + 4)];
      this.uin = getLongData(paramArrayOfByte, paramInt + 5);
      this.wExtBufLen = getShortData(paramArrayOfByte, paramInt + 9);
      return true;
    }
    return false;
  }
  
  public JSONObject toJsonObject()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("flag", this.flag);
    localJSONObject.put("uin", this.uin);
    localJSONObject.put("startPos", this.startPos);
    localJSONObject.put("textLen", this.textLen);
    return localJSONObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("flag:");
    localStringBuilder.append(this.flag);
    localStringBuilder.append(" uin:");
    localStringBuilder.append(this.uin);
    localStringBuilder.append(" startPos:");
    localStringBuilder.append(this.startPos);
    localStringBuilder.append(" textLen:");
    localStringBuilder.append(this.textLen);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
  
  public boolean writeTo(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte != null) && (paramInt >= 0))
    {
      if (paramArrayOfByte.length < paramInt + 11) {
        return false;
      }
      word2Byte(paramArrayOfByte, paramInt + 0, this.startPos);
      word2Byte(paramArrayOfByte, paramInt + 2, this.textLen);
      paramArrayOfByte[(paramInt + 4)] = this.flag;
      dWord2Byte(paramArrayOfByte, paramInt + 5, this.uin);
      word2Byte(paramArrayOfByte, paramInt + 9, (short)0);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.AtTroopMemberInfo
 * JD-Core Version:    0.7.0.1
 */