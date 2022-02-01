package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Bdh_extinfo$ShortVideoReqExtInfo
  extends MessageMicro<ShortVideoReqExtInfo>
{
  public static final int BOOL_IS_MERGE_CMD_BEFORE_DATA_FIELD_NUMBER = 6;
  public static final int MSG_SHORTVIDEO_SURE_REQ_FIELD_NUMBER = 5;
  public static final int MSG_THUMBINFO_FIELD_NUMBER = 3;
  public static final int MSG_VIDEOINFO_FIELD_NUMBER = 4;
  public static final int UINT32_CMD_FIELD_NUMBER = 1;
  public static final int UINT64_SESSION_ID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "uint32_cmd", "uint64_session_id", "msg_thumbinfo", "msg_videoinfo", "msg_shortvideo_sure_req", "bool_is_merge_cmd_before_data" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, null, Boolean.valueOf(false) }, ShortVideoReqExtInfo.class);
  public final PBBoolField bool_is_merge_cmd_before_data = PBField.initBool(false);
  public Bdh_extinfo.ShortVideoSureReqInfo msg_shortvideo_sure_req = new Bdh_extinfo.ShortVideoSureReqInfo();
  public Bdh_extinfo.PicInfo msg_thumbinfo = new Bdh_extinfo.PicInfo();
  public Bdh_extinfo.VideoInfo msg_videoinfo = new Bdh_extinfo.VideoInfo();
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_session_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoReqExtInfo
 * JD-Core Version:    0.7.0.1
 */