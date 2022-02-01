package cooperation.weiyun.channel.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class WeiyunPB$AioPicAndVideoCopyToWeiyunMsgReq
  extends MessageMicro<AioPicAndVideoCopyToWeiyunMsgReq>
{
  public static final int PIC_VIDEO_2QCLOUD_LIST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "pic_video_2qcloud_list" }, new Object[] { null }, AioPicAndVideoCopyToWeiyunMsgReq.class);
  public final PBRepeatMessageField<WeiyunPB.PicVideo2QcloudItem> pic_video_2qcloud_list = PBField.initRepeatMessage(WeiyunPB.PicVideo2QcloudItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.weiyun.channel.pb.WeiyunPB.AioPicAndVideoCopyToWeiyunMsgReq
 * JD-Core Version:    0.7.0.1
 */