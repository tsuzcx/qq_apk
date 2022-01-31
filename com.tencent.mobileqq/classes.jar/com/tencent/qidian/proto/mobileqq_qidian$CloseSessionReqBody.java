package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$CloseSessionReqBody
  extends MessageMicro<CloseSessionReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "msg_corp_report_info", "msg_ext_report_info", "uint32_close_session_time", "uint64_cqq_uin" }, new Object[] { null, null, Integer.valueOf(0), Long.valueOf(0L) }, CloseSessionReqBody.class);
  public mobileqq_qidian.CorpReportInfo msg_corp_report_info = new mobileqq_qidian.CorpReportInfo();
  public mobileqq_qidian.ExtReportInfo msg_ext_report_info = new mobileqq_qidian.ExtReportInfo();
  public final PBUInt32Field uint32_close_session_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_cqq_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.CloseSessionReqBody
 * JD-Core Version:    0.7.0.1
 */