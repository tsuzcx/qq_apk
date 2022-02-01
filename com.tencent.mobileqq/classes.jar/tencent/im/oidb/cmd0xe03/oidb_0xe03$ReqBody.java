package tencent.im.oidb.cmd0xe03;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xe03$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField enum_matchopcode = PBField.initEnum(1);
  public oidb_0xe03.LBSInfo msg_lbs_info = new oidb_0xe03.LBSInfo();
  public final PBUInt32Field uint32_sex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tag_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_client_version = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_match_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "uint64_uin", "enum_matchopcode", "uint64_match_uin", "uint32_tag_id", "uint32_sex", "uint32_switch", "uint64_client_version", "msg_lbs_info" }, new Object[] { localLong, Integer.valueOf(1), localLong, localInteger, localInteger, localInteger, localLong, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe03.oidb_0xe03.ReqBody
 * JD-Core Version:    0.7.0.1
 */