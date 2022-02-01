package tencent.im.oidb.cmd0xb54;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb54$ArticleBusiness
  extends MessageMicro<ArticleBusiness>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_business_cash_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xb54.SentimentEntityData msg_sentiment_entity_data = new oidb_cmd0xb54.SentimentEntityData();
  public oidb_cmd0xb54.UnionNlpInfo msg_union_nlp_info = new oidb_cmd0xb54.UnionNlpInfo();
  public final PBUInt32Field uint32_business_cash_flag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 82, 90 }, new String[] { "uint32_business_cash_flag", "bytes_business_cash_info", "msg_sentiment_entity_data", "msg_union_nlp_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null }, ArticleBusiness.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ArticleBusiness
 * JD-Core Version:    0.7.0.1
 */