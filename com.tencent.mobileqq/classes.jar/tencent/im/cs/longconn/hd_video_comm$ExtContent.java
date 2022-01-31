package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_comm$ExtContent
  extends MessageMicro<ExtContent>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ext_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_ext_content_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_ext_content = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_ext_content_type", "uint64_ext_content", "bytes_ext_content" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, ExtContent.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.longconn.hd_video_comm.ExtContent
 * JD-Core Version:    0.7.0.1
 */