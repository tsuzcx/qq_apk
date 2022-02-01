package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Bdh_extinfo$ShortVideoSureReqInfo
  extends MessageMicro<ShortVideoSureReqInfo>
{
  public static final int MSG_THUMBINFO_FIELD_NUMBER = 6;
  public static final int RPT_MSG_DROP_VIDEOINFO_FIELD_NUMBER = 8;
  public static final int RPT_MSG_MERGE_VIDEOINFO_FIELD_NUMBER = 7;
  public static final int UINT32_BUSINESS_TYPE_FIELD_NUMBER = 9;
  public static final int UINT32_CHAT_TYPE_FIELD_NUMBER = 2;
  public static final int UINT32_CLIENT_TYPE_FIELD_NUMBER = 5;
  public static final int UINT32_SUB_BUSINESS_TYPE_FIELD_NUMBER = 10;
  public static final int UINT64_FROMUIN_FIELD_NUMBER = 1;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 4;
  public static final int UINT64_TOUIN_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public Bdh_extinfo.PicInfo msg_thumbinfo = new Bdh_extinfo.PicInfo();
  public final PBRepeatMessageField<Bdh_extinfo.VideoInfo> rpt_msg_drop_videoinfo = PBField.initRepeatMessage(Bdh_extinfo.VideoInfo.class);
  public final PBRepeatMessageField<Bdh_extinfo.VideoInfo> rpt_msg_merge_videoinfo = PBField.initRepeatMessage(Bdh_extinfo.VideoInfo.class);
  public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_business_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66, 72, 80 }, new String[] { "uint64_fromuin", "uint32_chat_type", "uint64_touin", "uint64_group_code", "uint32_client_type", "msg_thumbinfo", "rpt_msg_merge_videoinfo", "rpt_msg_drop_videoinfo", "uint32_business_type", "uint32_sub_business_type" }, new Object[] { localLong, localInteger, localLong, localLong, localInteger, null, null, null, localInteger, localInteger }, ShortVideoSureReqInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoSureReqInfo
 * JD-Core Version:    0.7.0.1
 */