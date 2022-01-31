package tencent.intimate_relation;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class intimate_relation$IntimateLadybro
  extends MessageMicro<IntimateLadybro>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field chat_days = PBField.initUInt32(0);
  public final PBUInt64Field ladybro_uin = PBField.initUInt64(0L);
  public final PBUInt32Field level = PBField.initUInt32(0);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBUInt32Field time = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 802 }, new String[] { "ladybro_uin", "time", "source", "level", "chat_days", "buffer" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, IntimateLadybro.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.intimate_relation.intimate_relation.IntimateLadybro
 * JD-Core Version:    0.7.0.1
 */