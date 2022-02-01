package tencent.im.oidb.cmd0xe3b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xe3b$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie_for_req_type_1 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cookie_for_req_type_2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_graybar_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wording_for_empty_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0xe3b.HighlightTitle> rpt_msg_highlight_title = PBField.initRepeatMessage(oidb_0xe3b.HighlightTitle.class);
  public final PBRepeatMessageField<oidb_0xe3b.RecommendPerson> rpt_msg_person = PBField.initRepeatMessage(oidb_0xe3b.RecommendPerson.class);
  public final PBUInt32Field uint32_graybar_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66 }, new String[] { "uint32_graybar_type", "bytes_graybar_title", "rpt_msg_highlight_title", "uint32_sub_id", "rpt_msg_person", "bytes_cookie_for_req_type_1", "bytes_cookie_for_req_type_2", "bytes_wording_for_empty_data" }, new Object[] { localInteger, localByteStringMicro1, null, localInteger, null, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe3b.oidb_0xe3b.RspBody
 * JD-Core Version:    0.7.0.1
 */