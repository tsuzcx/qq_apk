package tencent.im.oidb.cmd0xecf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xecf$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_quest_id = PBField.initString("");
  public final PBUInt64Field uint64_comment_num = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_no_cache = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_quest_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uint64_uin", "uint64_comment_num", "uint64_quest_time", "str_quest_id", "uint64_no_cache" }, new Object[] { localLong, localLong, localLong, "", localLong }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xecf.oidb_0xecf.ReqBody
 * JD-Core Version:    0.7.0.1
 */