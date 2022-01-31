package tencent.im.oidb.cmd0xbbd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbbd$ReqFeedsInfo
  extends MessageMicro<ReqFeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_feeds_id", "uint32_feeds_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqFeedsInfo.class);
  public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbbd.oidb_cmd0xbbd.ReqFeedsInfo
 * JD-Core Version:    0.7.0.1
 */