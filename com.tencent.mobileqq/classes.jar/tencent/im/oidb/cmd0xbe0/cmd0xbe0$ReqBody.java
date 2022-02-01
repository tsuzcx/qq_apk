package tencent.im.oidb.cmd0xbe0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0xbe0$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_imsi = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_req_advertise_para = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field comic_id = PBField.initUInt32(0);
  public cmd0xbe0.StackInfo msg_stack_info = new cmd0xbe0.StackInfo();
  public cmd0xbe0.UserInfo msg_user_info = new cmd0xbe0.UserInfo();
  public final PBUInt32Field uint32_current_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_data_page_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_data_page_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_wifi = PBField.initUInt32(0);
  public final PBUInt32Field uint32_more_gallery = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_attch_comments = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_social_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_gallery = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_req_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_os = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_style = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58, 64, 72, 80, 88, 96, 104, 112, 122, 130, 800, 808, 816 }, new String[] { "uint32_more_gallery", "uint32_next_gallery", "msg_stack_info", "msg_user_info", "bytes_version", "uint32_os", "bytes_imsi", "uint32_is_wifi", "uint32_next_req_size", "uint32_need_social_info", "uint32_need_attch_comments", "uint32_current_index", "uint32_source", "uint32_style", "bytes_context", "bytes_req_advertise_para", "comic_id", "uint32_data_page_num", "uint32_data_page_index" }, new Object[] { localInteger, localInteger, null, null, localByteStringMicro1, localInteger, localByteStringMicro2, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro3, localByteStringMicro4, localInteger, localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe0.cmd0xbe0.ReqBody
 * JD-Core Version:    0.7.0.1
 */