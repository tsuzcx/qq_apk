package tencent.im.groupvideo.memposinfo;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class memposinfo$CommonInfo
  extends MessageMicro<CommonInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_account = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt64Field uint64_account = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_account", "bytes_account", "uint32_source" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, CommonInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.groupvideo.memposinfo.memposinfo.CommonInfo
 * JD-Core Version:    0.7.0.1
 */