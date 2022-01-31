package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class subcmd0x51b$DelSingleClusterMsgReq
  extends MessageMicro<DelSingleClusterMsgReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cluster_id = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
  public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8("");
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_puin", "bytes_cluster_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, DelSingleClusterMsgReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x51b.DelSingleClusterMsgReq
 * JD-Core Version:    0.7.0.1
 */