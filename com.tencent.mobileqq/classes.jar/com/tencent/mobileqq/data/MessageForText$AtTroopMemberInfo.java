package com.tencent.mobileqq.data;

import com.tencent.mobileqq.utils.httputils.PkgTools;
import org.json.JSONObject;

public class MessageForText$AtTroopMemberInfo
{
  public byte flag;
  public short startPos;
  public short textLen;
  public long uin;
  public short wExtBufLen;
  
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
    if ((paramArrayOfByte == null) || (paramInt < 0) || (paramArrayOfByte.length < paramInt + 11)) {
      return false;
    }
    this.startPos = PkgTools.a(paramArrayOfByte, paramInt + 0);
    this.textLen = PkgTools.a(paramArrayOfByte, paramInt + 2);
    this.flag = paramArrayOfByte[(paramInt + 4)];
    this.uin = PkgTools.a(paramArrayOfByte, paramInt + 5);
    this.wExtBufLen = PkgTools.a(paramArrayOfByte, paramInt + 9);
    return true;
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
    return "flag:" + this.flag + " uin:" + this.uin + " startPos:" + this.startPos + " textLen:" + this.textLen + "\n";
  }
  
  public boolean writeTo(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt < 0) || (paramArrayOfByte.length < paramInt + 11)) {
      return false;
    }
    PkgTools.a(paramArrayOfByte, paramInt + 0, this.startPos);
    PkgTools.a(paramArrayOfByte, paramInt + 2, this.textLen);
    paramArrayOfByte[(paramInt + 4)] = this.flag;
    PkgTools.a(paramArrayOfByte, paramInt + 5, this.uin);
    PkgTools.a(paramArrayOfByte, paramInt + 9, (short)0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo
 * JD-Core Version:    0.7.0.1
 */