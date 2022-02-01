package com.tencent.mobileqq.troop.utils;

import android.graphics.Color;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.GroupBusinessMsg;

public class TroopBusinessUtil$TroopBusinessMessage
{
  public int a = 1;
  public String b;
  public String c;
  public String d;
  public int e;
  public String f;
  public int g;
  public int h;
  
  public static TroopBusinessMessage a(im_msg_body.GroupBusinessMsg paramGroupBusinessMsg)
  {
    TroopBusinessMessage localTroopBusinessMessage = new TroopBusinessMessage();
    localTroopBusinessMessage.a = paramGroupBusinessMsg.uint32_flags.get();
    localTroopBusinessMessage.b = paramGroupBusinessMsg.bytes_head_url.get().toStringUtf8();
    localTroopBusinessMessage.c = paramGroupBusinessMsg.bytes_head_clk_url.get().toStringUtf8();
    localTroopBusinessMessage.d = paramGroupBusinessMsg.bytes_nick.get().toStringUtf8();
    localTroopBusinessMessage.f = paramGroupBusinessMsg.bytes_rank.get().toStringUtf8();
    try
    {
      localTroopBusinessMessage.e = Color.parseColor(paramGroupBusinessMsg.bytes_nick_color.get().toStringUtf8());
      localTroopBusinessMessage.g = Color.parseColor(paramGroupBusinessMsg.bytes_rank_color.get().toStringUtf8());
      localTroopBusinessMessage.h = Color.parseColor(paramGroupBusinessMsg.bytes_rank_bgcolor.get().toStringUtf8());
      return localTroopBusinessMessage;
    }
    catch (Exception paramGroupBusinessMsg)
    {
      String str = TroopBusinessUtil.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("the color string cannot parse to color. ");
      localStringBuilder.append(paramGroupBusinessMsg.getMessage());
      QLog.e(str, 2, localStringBuilder.toString());
    }
    return localTroopBusinessMessage;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopBusinessMessage");
    localStringBuilder.append(",");
    localStringBuilder.append("nick");
    localStringBuilder.append("=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",");
    localStringBuilder.append("flag");
    localStringBuilder.append("=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append("clk");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",");
    localStringBuilder.append("head");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage
 * JD-Core Version:    0.7.0.1
 */