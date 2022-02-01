package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class PreloadInfoCheckUpdate$FirstShowRsp
  extends MessageMicro<FirstShowRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "head", "data" }, new Object[] { null, "" }, FirstShowRsp.class);
  public final PBStringField data = PBField.initString("");
  public PreloadInfoCheckUpdate.ControlRspHead head = new PreloadInfoCheckUpdate.ControlRspHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.getpreload.PreloadInfoCheckUpdate.FirstShowRsp
 * JD-Core Version:    0.7.0.1
 */