package com.tencent.pb.qid;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QidProfile$SetProfileRsp
  extends MessageMicro<SetProfileRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "index" }, new Object[] { Long.valueOf(0L) }, SetProfileRsp.class);
  public final PBUInt64Field index = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.qid.QidProfile.SetProfileRsp
 * JD-Core Version:    0.7.0.1
 */