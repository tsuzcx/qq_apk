package com.tencent.mobileqq.weiyun.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class WeiyunPB$DiskAlbumStatusReportReq
  extends MessageMicro<DiskAlbumStatusReportReq>
{
  public static final int DURING_DAYS_FIELD_NUMBER = 2;
  public static final int NEW_PIC_NUMBER_FIELD_NUMBER = 1;
  public static final int NEW_USER_FIELD_NUMBER = 3;
  public static final int UNBAKED_PIC_NUMBER_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field during_days = PBField.initUInt32(0);
  public final PBUInt32Field new_pic_number = PBField.initUInt32(0);
  public final PBBoolField new_user = PBField.initBool(false);
  public final PBUInt32Field unbaked_pic_number = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "new_pic_number", "during_days", "new_user", "unbaked_pic_number" }, new Object[] { localInteger, localInteger, Boolean.valueOf(false), localInteger }, DiskAlbumStatusReportReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskAlbumStatusReportReq
 * JD-Core Version:    0.7.0.1
 */