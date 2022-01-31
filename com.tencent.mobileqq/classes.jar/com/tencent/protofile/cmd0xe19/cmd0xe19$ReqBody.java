package com.tencent.protofile.cmd0xe19;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.protofile.terminal_info.terminal_info.TerminalInfo;

public final class cmd0xe19$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50 }, new String[] { "source", "id", "rowkey", "task_idx", "skey", "terminal_info" }, new Object[] { Integer.valueOf(1), "", "", Integer.valueOf(0), "", null }, ReqBody.class);
  public final PBStringField id = PBField.initString("");
  public final PBStringField rowkey = PBField.initString("");
  public final PBStringField skey = PBField.initString("");
  public final PBEnumField source = PBField.initEnum(1);
  public final PBInt32Field task_idx = PBField.initInt32(0);
  public terminal_info.TerminalInfo terminal_info = new terminal_info.TerminalInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.protofile.cmd0xe19.cmd0xe19.ReqBody
 * JD-Core Version:    0.7.0.1
 */