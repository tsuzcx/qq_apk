package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$ApplyListDownloadReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 240 }, new String[] { "uint64_uin", "uint32_begin_index", "uint32_req_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ApplyListDownloadReq.class);
  public final PBUInt32Field uint32_begin_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ApplyListDownloadReq
 * JD-Core Version:    0.7.0.1
 */