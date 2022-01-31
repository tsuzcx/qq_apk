package com.tencent.pb.getpreload;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class PreloadInfoCheckUpdate$FirstShowReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "head", "appid" }, new Object[] { null, Integer.valueOf(0) }, FirstShowReq.class);
  public final PBInt32Field appid = PBField.initInt32(0);
  public PreloadInfoCheckUpdate.ControlReqHead head = new PreloadInfoCheckUpdate.ControlReqHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.getpreload.PreloadInfoCheckUpdate.FirstShowReq
 * JD-Core Version:    0.7.0.1
 */