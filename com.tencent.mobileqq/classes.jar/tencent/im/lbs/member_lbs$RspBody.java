package tencent.im.lbs;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class member_lbs$RspBody
  extends MessageMicro<RspBody>
{
  public static final int BOOL_SHOW_TIPS_FIELD_NUMBER = 6;
  public static final int MSG_LOCATION_FIELD_NUMBER = 3;
  public static final int MSG_MEMS_DISTANCE_FIELD_NUMBER = 5;
  public static final int MSG_NEIGHBOUR_NUMBER_FIELD_NUMBER = 4;
  public static final int RPT_MSG_NEIGHBOURS_INFO_FIELD_NUMBER = 10;
  public static final int STR_RESULT_INFO_FIELD_NUMBER = 2;
  public static final int STR_TIPS_NATIVE_URL_FIELD_NUMBER = 8;
  public static final int STR_TIPS_WEB_URL_FIELD_NUMBER = 9;
  public static final int STR_TIPS_WORDING_FIELD_NUMBER = 7;
  public static final int UINT32_RESULT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_show_tips = PBField.initBool(false);
  public member_lbs.Location msg_location = new member_lbs.Location();
  public member_lbs.MemsDistance msg_mems_distance = new member_lbs.MemsDistance();
  public member_lbs.NeighbourNumber msg_neighbour_number = new member_lbs.NeighbourNumber();
  public final PBRepeatMessageField<member_lbs.NeighbourInfo> rpt_msg_neighbours_info = PBField.initRepeatMessage(member_lbs.NeighbourInfo.class);
  public final PBBytesField str_result_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_tips_native_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_tips_web_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_tips_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 66, 74, 82 }, new String[] { "uint32_result", "str_result_info", "msg_location", "msg_neighbour_number", "msg_mems_distance", "bool_show_tips", "str_tips_wording", "str_tips_native_url", "str_tips_web_url", "rpt_msg_neighbours_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, null, null, Boolean.valueOf(false), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.lbs.member_lbs.RspBody
 * JD-Core Version:    0.7.0.1
 */