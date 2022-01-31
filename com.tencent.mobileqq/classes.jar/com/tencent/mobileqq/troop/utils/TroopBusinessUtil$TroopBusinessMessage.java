package com.tencent.mobileqq.troop.utils;

import android.graphics.Color;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.GroupBusinessMsg;

public class TroopBusinessUtil$TroopBusinessMessage
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  
  public TroopBusinessUtil$TroopBusinessMessage()
  {
    this.jdField_a_of_type_Int = 1;
  }
  
  public static TroopBusinessMessage a(im_msg_body.GroupBusinessMsg paramGroupBusinessMsg)
  {
    TroopBusinessMessage localTroopBusinessMessage = new TroopBusinessMessage();
    localTroopBusinessMessage.jdField_a_of_type_Int = paramGroupBusinessMsg.uint32_flags.get();
    localTroopBusinessMessage.jdField_a_of_type_JavaLangString = paramGroupBusinessMsg.bytes_head_url.get().toStringUtf8();
    localTroopBusinessMessage.jdField_b_of_type_JavaLangString = paramGroupBusinessMsg.bytes_head_clk_url.get().toStringUtf8();
    localTroopBusinessMessage.jdField_c_of_type_JavaLangString = paramGroupBusinessMsg.bytes_nick.get().toStringUtf8();
    localTroopBusinessMessage.jdField_d_of_type_JavaLangString = paramGroupBusinessMsg.bytes_rank.get().toStringUtf8();
    try
    {
      localTroopBusinessMessage.jdField_b_of_type_Int = Color.parseColor(paramGroupBusinessMsg.bytes_nick_color.get().toStringUtf8());
      localTroopBusinessMessage.jdField_c_of_type_Int = Color.parseColor(paramGroupBusinessMsg.bytes_rank_color.get().toStringUtf8());
      localTroopBusinessMessage.jdField_d_of_type_Int = Color.parseColor(paramGroupBusinessMsg.bytes_rank_bgcolor.get().toStringUtf8());
      return localTroopBusinessMessage;
    }
    catch (Exception paramGroupBusinessMsg)
    {
      QLog.e(TroopBusinessUtil.jdField_a_of_type_JavaLangString, 2, "the color string cannot parse to color. " + paramGroupBusinessMsg.getMessage());
    }
    return localTroopBusinessMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage
 * JD-Core Version:    0.7.0.1
 */