package tencent.im.group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x2dc$VisitorJoinInfo
  extends MessageMicro<VisitorJoinInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_visitor_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_face_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_join_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_visitor_uin", "uint32_join_time", "bytes_visitor_name", "uint32_face_id" }, new Object[] { Long.valueOf(0L), localInteger, localByteStringMicro, localInteger }, VisitorJoinInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group.cmd0x2dc.VisitorJoinInfo
 * JD-Core Version:    0.7.0.1
 */