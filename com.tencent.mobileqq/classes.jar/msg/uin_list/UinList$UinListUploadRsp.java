package msg.uin_list;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UinList$UinListUploadRsp
  extends MessageMicro<UinListUploadRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_store_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBUInt32Field silence_period = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "int32_result", "bytes_store_key", "silence_period" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, UinListUploadRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     msg.uin_list.UinList.UinListUploadRsp
 * JD-Core Version:    0.7.0.1
 */