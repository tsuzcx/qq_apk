package tencent.im.oidb.cmd0x6d9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.cs.group_file_common.group_file_common.FeedsInfo;

public final class oidb_0x6d9$FeedsReqBody
  extends MessageMicro<FeedsReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field multi_send_seq = PBField.initUInt32(0);
  public final PBRepeatMessageField<group_file_common.FeedsInfo> rpt_feeds_info_list = PBField.initRepeatMessage(group_file_common.FeedsInfo.class);
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_group_code", "uint32_app_id", "rpt_feeds_info_list", "multi_send_seq" }, new Object[] { Long.valueOf(0L), localInteger, null, localInteger }, FeedsReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d9.oidb_0x6d9.FeedsReqBody
 * JD-Core Version:    0.7.0.1
 */