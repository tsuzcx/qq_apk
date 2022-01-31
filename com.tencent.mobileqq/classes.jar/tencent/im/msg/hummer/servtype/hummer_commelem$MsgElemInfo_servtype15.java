package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hummer_commelem$MsgElemInfo_servtype15
  extends MessageMicro<MsgElemInfo_servtype15>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field author = PBField.initUInt64(0L);
  public final PBBytesField comment_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field createTime = PBField.initUInt64(0L);
  public final PBUInt32Field ctr_version = PBField.initUInt32(0);
  public final PBBytesField summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 56, 64 }, new String[] { "vid", "cover", "title", "summary", "createTime", "comment_content", "author", "ctr_version" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), localByteStringMicro5, Long.valueOf(0L), Integer.valueOf(0) }, MsgElemInfo_servtype15.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype15
 * JD-Core Version:    0.7.0.1
 */