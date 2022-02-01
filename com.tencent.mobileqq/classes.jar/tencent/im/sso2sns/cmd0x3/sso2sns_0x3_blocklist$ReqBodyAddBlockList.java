package tencent.im.sso2sns.cmd0x3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class sso2sns_0x3_blocklist$ReqBodyAddBlockList
  extends MessageMicro<ReqBodyAddBlockList>
{
  public static final int RPT_MSG_BLOCK_UIN_INFO_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "rpt_msg_block_uin_info" }, new Object[] { Long.valueOf(0L), null }, ReqBodyAddBlockList.class);
  public final PBRepeatMessageField<sso2sns_0x3_blocklist.BlockUinInfo> rpt_msg_block_uin_info = PBField.initRepeatMessage(sso2sns_0x3_blocklist.BlockUinInfo.class);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.sso2sns.cmd0x3.sso2sns_0x3_blocklist.ReqBodyAddBlockList
 * JD-Core Version:    0.7.0.1
 */