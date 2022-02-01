package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xb77$ExtInfo
  extends MessageMicro<ExtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField apns_wording = PBField.initString("");
  public final PBBytesField message_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
  public final PBUInt32Field receiver_appid = PBField.initUInt32(0);
  public final PBRepeatField<Integer> rpt_custom_featureid = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBBytesField tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_group_savedb_flag = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 88, 98, 104, 112, 120, 138, 146 }, new String[] { "rpt_custom_featureid", "apns_wording", "uint32_group_savedb_flag", "receiver_appid", "msg_seq", "tag_name", "message_ext" }, new Object[] { localInteger, "", localInteger, localInteger, Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, ExtInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ExtInfo
 * JD-Core Version:    0.7.0.1
 */