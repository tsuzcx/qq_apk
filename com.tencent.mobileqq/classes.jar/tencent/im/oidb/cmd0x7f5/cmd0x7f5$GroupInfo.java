package tencent.im.oidb.cmd0x7f5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x7f5$GroupInfo
  extends MessageMicro<GroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_location = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ilat = PBField.initInt32(0);
  public final PBInt32Field int32_ilon = PBField.initInt32(0);
  public cmd0x7f5.LabelRspInfo label_info = new cmd0x7f5.LabelRspInfo();
  public final PBBytesField string_group_finger_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField string_join_auth_key = PBField.initString("");
  public final PBUInt32Field uint32_accuracy = PBField.initUInt32(0);
  public final PBUInt32Field uint32_extflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_createtime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_member_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_owner = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 64, 80, 88, 106, 114, 122, 130 }, new String[] { "uint64_group_code", "uint32_accuracy", "int32_ilat", "int32_ilon", "bytes_location", "uint32_extflag", "uint32_group_member_num", "uint64_group_owner", "uint32_group_createtime", "string_group_name", "string_group_finger_memo", "label_info", "string_join_auth_key" }, new Object[] { localLong, localInteger, localInteger, localInteger, localByteStringMicro1, localInteger, localInteger, localLong, localInteger, localByteStringMicro2, localByteStringMicro3, null, "" }, GroupInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7f5.cmd0x7f5.GroupInfo
 * JD-Core Version:    0.7.0.1
 */