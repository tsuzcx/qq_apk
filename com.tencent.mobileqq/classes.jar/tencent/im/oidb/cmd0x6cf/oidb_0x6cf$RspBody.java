package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6cf$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_inner_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x6cf.InterruptedWeishiAd msg_interrupted_ad_weishi = new oidb_0x6cf.InterruptedWeishiAd();
  public oidb_0x6cf.ArticleSummary req_article_summary = new oidb_0x6cf.ArticleSummary();
  public final PBRepeatMessageField rpt_article_list = PBField.initRepeatMessage(oidb_0x6cf.ArticleSummary.class);
  public final PBUInt64Field uint64_pos_ad_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58 }, new String[] { "uint64_uin", "rpt_article_list", "bytes_inner_id", "req_article_summary", "uint64_pos_ad_time", "bytes_cookie", "msg_interrupted_ad_weishi" }, new Object[] { Long.valueOf(0L), null, localByteStringMicro1, null, Long.valueOf(0L), localByteStringMicro2, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.RspBody
 * JD-Core Version:    0.7.0.1
 */