package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class articlesummary$PackTopicExtraInfo
  extends MessageMicro<PackTopicExtraInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_join_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_topic_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_adtag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_join_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40 }, new String[] { "uint32_join_count", "bytes_join_wording", "uint32_topic_id", "bytes_topic_name", "uint32_adtag" }, new Object[] { localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, localInteger }, PackTopicExtraInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.PackTopicExtraInfo
 * JD-Core Version:    0.7.0.1
 */