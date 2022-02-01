package com.tencent.protofile.cmd0xe19;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0xe19$TaskRedPacket
  extends MessageMicro<TaskRedPacket>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "head", "nick", "wording" }, new Object[] { "", "", "" }, TaskRedPacket.class);
  public final PBStringField head = PBField.initString("");
  public final PBStringField nick = PBField.initString("");
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.protofile.cmd0xe19.cmd0xe19.TaskRedPacket
 * JD-Core Version:    0.7.0.1
 */