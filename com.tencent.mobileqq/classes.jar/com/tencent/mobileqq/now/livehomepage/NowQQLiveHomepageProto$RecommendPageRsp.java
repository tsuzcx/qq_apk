package com.tencent.mobileqq.now.livehomepage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class NowQQLiveHomepageProto$RecommendPageRsp
  extends MessageMicro<RecommendPageRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 66 }, new String[] { "uint32_new_timestamp", "rpt_msg_rcmd", "retInfo", "uint32_endFlag", "uint32_next_index", "uint32_total_num", "rcmd_col_mode", "union_channel" }, new Object[] { Integer.valueOf(0), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, RecommendPageRsp.class);
  public final PBUInt32Field rcmd_col_mode = PBField.initUInt32(0);
  public NowQQLiveHomepageProto.RetInfo retInfo = new NowQQLiveHomepageProto.RetInfo();
  public final PBRepeatMessageField<NowQQLiveHomepageProto.RecommendItem> rpt_msg_rcmd = PBField.initRepeatMessage(NowQQLiveHomepageProto.RecommendItem.class);
  public final PBUInt32Field uint32_endFlag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_new_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_next_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_num = PBField.initUInt32(0);
  public final PBStringField union_channel = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.livehomepage.NowQQLiveHomepageProto.RecommendPageRsp
 * JD-Core Version:    0.7.0.1
 */