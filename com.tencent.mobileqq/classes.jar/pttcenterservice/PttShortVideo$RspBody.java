package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PttShortVideo$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 800, 808 }, new String[] { "uint32_cmd", "uint32_seq", "msg_PttShortVideoUpload_Resp", "msg_PttShortVideoDownload_Resp", "rpt_msg_short_video_retweet_resp", "rpt_msg_short_video_delete_resp", "uint32_change_channel", "uint32_allow_retry" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  public PttShortVideo.PttShortVideoDownloadResp msg_PttShortVideoDownload_Resp = new PttShortVideo.PttShortVideoDownloadResp();
  public PttShortVideo.PttShortVideoUploadResp msg_PttShortVideoUpload_Resp = new PttShortVideo.PttShortVideoUploadResp();
  public final PBRepeatMessageField<PttShortVideo.PttShortVideoDeleteResp> rpt_msg_short_video_delete_resp = PBField.initRepeatMessage(PttShortVideo.PttShortVideoDeleteResp.class);
  public final PBRepeatMessageField<PttShortVideo.PttShortVideoRetweetResp> rpt_msg_short_video_retweet_resp = PBField.initRepeatMessage(PttShortVideo.PttShortVideoRetweetResp.class);
  public final PBUInt32Field uint32_allow_retry = PBField.initUInt32(0);
  public final PBUInt32Field uint32_change_channel = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pttcenterservice.PttShortVideo.RspBody
 * JD-Core Version:    0.7.0.1
 */