package tencent.im.oidb.cmd0xb2d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xb2d$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_gallery_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> bytes_gallery_rowkey_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBInt32Field int32_source = PBField.initInt32(0);
  public cmd0xb2d.PageReq msg_page_req = new cmd0xb2d.PageReq();
  public final PBUInt32Field uint32_need_attch_comments = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_social_info = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 56 }, new String[] { "bytes_gallery_rowkey", "bytes_gallery_rowkey_list", "int32_source", "msg_page_req", "bytes_context", "uint32_need_social_info", "uint32_need_attch_comments" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localInteger, null, localByteStringMicro3, localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb2d.cmd0xb2d.ReqBody
 * JD-Core Version:    0.7.0.1
 */