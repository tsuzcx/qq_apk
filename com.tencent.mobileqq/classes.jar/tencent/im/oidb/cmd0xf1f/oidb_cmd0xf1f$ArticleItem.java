package tencent.im.oidb.cmd0xf1f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xf1f$ArticleItem
  extends MessageMicro<ArticleItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
  public final PBUInt32Field uint32_play_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "bytes_rowkey", "uint64_feeds_id", "uint32_play_time", "uint32_is_end", "uint32_duration" }, new Object[] { localByteStringMicro, Long.valueOf(0L), localInteger, localInteger, localInteger }, ArticleItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf1f.oidb_cmd0xf1f.ArticleItem
 * JD-Core Version:    0.7.0.1
 */