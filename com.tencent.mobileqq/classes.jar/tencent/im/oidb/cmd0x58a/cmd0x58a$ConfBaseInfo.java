package tencent.im.oidb.cmd0x58a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x58a$ConfBaseInfo
  extends MessageMicro<ConfBaseInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_info_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_favorite = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
  public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_conf_uin", "uint32_is_favorite", "uint32_info_seq", "uint32_member_num" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger }, ConfBaseInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x58a.cmd0x58a.ConfBaseInfo
 * JD-Core Version:    0.7.0.1
 */