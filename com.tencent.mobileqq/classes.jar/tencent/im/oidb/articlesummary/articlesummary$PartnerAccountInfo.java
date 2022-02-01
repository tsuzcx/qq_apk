package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$PartnerAccountInfo
  extends MessageMicro<PartnerAccountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_head_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_v_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_account_display = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_voila = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_wechat_video = PBField.initUInt32(0);
  public final PBUInt32Field uint32_watch_see_later = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 58, 8192, 8200 }, new String[] { "uint64_uin", "uint32_account_type", "bytes_recommend_reason", "uint32_is_account_display", "bytes_head_jump_url", "uint32_is_voila", "bytes_v_icon_url", "uint32_is_wechat_video", "uint32_watch_see_later" }, new Object[] { Long.valueOf(0L), localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, localInteger, localByteStringMicro3, localInteger, localInteger }, PartnerAccountInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo
 * JD-Core Version:    0.7.0.1
 */