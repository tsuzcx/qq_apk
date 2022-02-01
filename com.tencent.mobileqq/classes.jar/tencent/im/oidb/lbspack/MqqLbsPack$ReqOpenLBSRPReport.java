package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MqqLbsPack$ReqOpenLBSRPReport
  extends MessageMicro<ReqOpenLBSRPReport>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_poi_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_poi_id", "bytes_pid", "uint32_status" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, ReqOpenLBSRPReport.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.lbspack.MqqLbsPack.ReqOpenLBSRPReport
 * JD-Core Version:    0.7.0.1
 */