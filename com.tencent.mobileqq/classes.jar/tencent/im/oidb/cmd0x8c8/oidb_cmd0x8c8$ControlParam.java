package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0x8c8$ControlParam
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "uint32_need_basic_info", "uint32_need_like_count", "uint32_need_biu_count", "uint32_need_comment_count", "uint32_need_origin_feed_info", "uint32_need_follow_status", "uint32_need_topic_info", "uint32_need_article_info", "uint32_need_userinfo", "uint32_need_account_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ControlParam.class);
  public final PBUInt32Field uint32_need_account_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_article_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_basic_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_biu_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_comment_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_follow_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_like_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_origin_feed_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_topic_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_userinfo = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.ControlParam
 * JD-Core Version:    0.7.0.1
 */