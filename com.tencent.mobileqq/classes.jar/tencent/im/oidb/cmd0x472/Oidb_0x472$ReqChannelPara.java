package tencent.im.oidb.cmd0x472;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x472$ReqChannelPara
  extends MessageMicro<ReqChannelPara>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_channel_id", "uint32_req_channel_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqChannelPara.class);
  public final PBUInt32Field uint32_req_channel_list = PBField.initUInt32(0);
  public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x472.Oidb_0x472.ReqChannelPara
 * JD-Core Version:    0.7.0.1
 */