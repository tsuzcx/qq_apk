package tencent.im.oidb.cmd0xe89;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xe89$RspGetDocContent
  extends MessageMicro<RspGetDocContent>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_global_padid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_meta = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_owner_appid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_cmd0xe89.Atext> msg_atext = PBField.initRepeatMessage(oidb_cmd0xe89.Atext.class);
  public final PBRepeatMessageField<oidb_cmd0xe89.EditUinInfo> rpt_edit_uin_list = PBField.initRepeatMessage(oidb_cmd0xe89.EditUinInfo.class);
  public final PBUInt32Field uint32_baseLen = PBField.initUInt32(0);
  public final PBUInt32Field uint32_baseRev = PBField.initUInt32(0);
  public final PBUInt32Field uint32_doc_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_len = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sheetPosLen = PBField.initUInt32(0);
  public final PBUInt64Field uint64_baseLen = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sheetPosLen = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 130, 136, 144, 242, 248, 274, 280, 288, 296, 306, 312 }, new String[] { "bytes_global_padid", "uint32_doc_type", "bytes_title", "msg_atext", "bytes_subid", "uint32_baseRev", "uint32_baseLen", "bytes_meta", "uint32_sheetPosLen", "bytes_owner_appid", "uint64_baseLen", "uint64_sheetPosLen", "uint64_owner_uin", "rpt_edit_uin_list", "uint32_max_len" }, new Object[] { localByteStringMicro1, localInteger, localByteStringMicro2, null, localByteStringMicro3, localInteger, localInteger, localByteStringMicro4, localInteger, localByteStringMicro5, localLong, localLong, localLong, null, localInteger }, RspGetDocContent.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe89.oidb_cmd0xe89.RspGetDocContent
 * JD-Core Version:    0.7.0.1
 */