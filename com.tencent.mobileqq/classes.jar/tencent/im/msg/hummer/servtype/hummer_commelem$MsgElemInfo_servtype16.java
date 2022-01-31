package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hummer_commelem$MsgElemInfo_servtype16
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field ctr_version = PBField.initUInt32(0);
  public final PBBytesField doodleUrl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField sourceActionData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField sourceActionType = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField sourceName = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField storyID = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField thumbUrl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBBytesField unionID = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field videoHeight = PBField.initUInt32(0);
  public final PBUInt32Field videoWidth = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 74, 82, 90, 96 }, new String[] { "uid", "unionID", "storyID", "md5", "thumbUrl", "doodleUrl", "videoWidth", "videoHeight", "sourceName", "sourceActionType", "sourceActionData", "ctr_version" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0) }, MsgElemInfo_servtype16.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype16
 * JD-Core Version:    0.7.0.1
 */