package tencent.im.oidb.cmd0xe31;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.kandian.ugc.topic_info.TopicInfo;

public final class oidb_0xe31$TopicListRsp
  extends MessageMicro<TopicListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field create_limit = PBField.initUInt32(0);
  public final PBBoolField is_end = PBField.initBool(false);
  public final PBRepeatMessageField<topic_info.TopicInfo> topics = PBField.initRepeatMessage(topic_info.TopicInfo.class);
  public final PBUInt32Field total = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40 }, new String[] { "cookie", "is_end", "total", "topics", "create_limit" }, new Object[] { localByteStringMicro, Boolean.valueOf(false), Integer.valueOf(0), null, Integer.valueOf(0) }, TopicListRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe31.oidb_0xe31.TopicListRsp
 * JD-Core Version:    0.7.0.1
 */