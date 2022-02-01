package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class WeiyunPB$DiskAlbumStatusReportRsp
  extends MessageMicro<DiskAlbumStatusReportRsp>
{
  public static final int NEED_RED_TOUCH_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "need_red_touch" }, new Object[] { Boolean.valueOf(false) }, DiskAlbumStatusReportRsp.class);
  public final PBBoolField need_red_touch = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskAlbumStatusReportRsp
 * JD-Core Version:    0.7.0.1
 */