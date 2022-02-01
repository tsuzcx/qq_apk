package com.tencent.pb.hotpicmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class HotPicMsg$GetVideoInfoRsp
  extends MessageMicro<GetVideoInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_result = PBField.initInt32(0);
  public final PBRepeatMessageField<HotPicMsg.TagInfo> rpt_msg_tag_info = PBField.initRepeatMessage(HotPicMsg.TagInfo.class);
  public final PBRepeatMessageField<HotPicMsg.VideoInfo> rpt_msg_video_info = PBField.initRepeatMessage(HotPicMsg.VideoInfo.class);
  public final PBUInt32Field uint32_build_ver = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tag_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48 }, new String[] { "int32_result", "bytes_fail_msg", "uint32_build_ver", "rpt_msg_video_info", "rpt_msg_tag_info", "uint32_tag_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), null, null, Integer.valueOf(0) }, GetVideoInfoRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.hotpicmsg.HotPicMsg.GetVideoInfoRsp
 * JD-Core Version:    0.7.0.1
 */