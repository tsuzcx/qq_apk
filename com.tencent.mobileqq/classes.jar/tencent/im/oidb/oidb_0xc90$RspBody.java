package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xc90$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_community_title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_community_channel_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_concern_community_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_more_url_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_0xc90.CommunityConfigInfo> rpt_community_info_item = PBField.initRepeatMessage(oidb_0xc90.CommunityConfigInfo.class);
  public oidb_0xc90.CommunityWebInfo rpt_web_community_info = new oidb_0xc90.CommunityWebInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "rpt_community_info_item", "bytes_jump_concern_community_url", "bytes_community_title_wording", "bytes_more_url_wording", "rpt_web_community_info", "bytes_jump_community_channel_url" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, localByteStringMicro4 }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc90.RspBody
 * JD-Core Version:    0.7.0.1
 */