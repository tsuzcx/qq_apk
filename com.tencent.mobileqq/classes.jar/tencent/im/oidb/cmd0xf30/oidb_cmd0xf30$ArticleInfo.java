package tencent.im.oidb.cmd0xf30;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xf30$ArticleInfo
  extends MessageMicro<ArticleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_cmd0xf30.RecommendPUin> rpt_msg_puin = PBField.initRepeatMessage(oidb_cmd0xf30.RecommendPUin.class);
  public final PBUInt32Field uint32_article_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "bytes_rowkey", "rpt_msg_puin", "uint32_article_type" }, new Object[] { localByteStringMicro, null, Integer.valueOf(0) }, ArticleInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.ArticleInfo
 * JD-Core Version:    0.7.0.1
 */