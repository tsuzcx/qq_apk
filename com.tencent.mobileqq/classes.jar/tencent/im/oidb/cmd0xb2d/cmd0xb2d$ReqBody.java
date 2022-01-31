package tencent.im.oidb.cmd0xb2d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class cmd0xb2d$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_gallery_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField bytes_gallery_rowkey_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBInt32Field int32_source = PBField.initInt32(0);
  public cmd0xb2d.PageReq msg_page_req = new cmd0xb2d.PageReq();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "bytes_gallery_rowkey", "bytes_gallery_rowkey_list", "int32_source", "msg_page_req" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb2d.cmd0xb2d.ReqBody
 * JD-Core Version:    0.7.0.1
 */