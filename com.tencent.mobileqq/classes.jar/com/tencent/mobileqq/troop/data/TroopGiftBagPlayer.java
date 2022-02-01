package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2.Player;

public class TroopGiftBagPlayer
{
  public long a;
  public long b;
  public int c;
  public int d;
  public String e;
  
  public TroopGiftBagPlayer() {}
  
  public TroopGiftBagPlayer(long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramString;
  }
  
  public TroopGiftBagPlayer(oidb_0x6c2.Player paramPlayer)
  {
    this.a = paramPlayer.uint64_uin.get();
    this.b = paramPlayer.uint64_time.get();
    this.c = paramPlayer.int32_amount.get();
    this.d = paramPlayer.int32_index.get();
    this.e = paramPlayer.bytes_tips.get().toStringUtf8();
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", this.a);
      localJSONObject.put("time", this.b);
      localJSONObject.put("amount", this.c);
      localJSONObject.put("index", this.d);
      localJSONObject.put("tips", this.e);
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" toJson error. e=");
      localStringBuilder.append(localJSONException);
      QLog.e(".troop.send_gift", 2, localStringBuilder.toString());
    }
    return localJSONObject.toString();
  }
  
  public void a(String paramString)
  {
    paramString = new String(paramString);
    try
    {
      paramString = new JSONObject(paramString);
      this.a = paramString.optLong("uin");
      this.b = paramString.optLong("time");
      this.c = paramString.optInt("amount");
      this.d = paramString.optInt("index");
      this.e = paramString.optString("tips");
      return;
    }
    catch (JSONException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getClass().getSimpleName());
      localStringBuilder.append(" fromJson error. e=");
      localStringBuilder.append(paramString);
      QLog.e(".troop.send_gift", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopGiftBagPlayer
 * JD-Core Version:    0.7.0.1
 */