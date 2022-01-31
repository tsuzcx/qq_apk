package com.tencent.protofile.oidb_0xe21;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.terminal_info.terminal_info.TerminalInfo;

public final class oidb_0xe21$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 82, 122 }, new String[] { "rowkey", "type", "progress", "skey", "ad_report_req", "terminal_info" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", null, null }, ReqBody.class);
  public oidb_0xe21.ADReportReq ad_report_req = new oidb_0xe21.ADReportReq();
  public final PBUInt32Field progress = PBField.initUInt32(0);
  public final PBStringField rowkey = PBField.initString("");
  public final PBStringField skey = PBField.initString("");
  public terminal_info.TerminalInfo terminal_info = new terminal_info.TerminalInfo();
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.protofile.oidb_0xe21.oidb_0xe21.ReqBody
 * JD-Core Version:    0.7.0.1
 */