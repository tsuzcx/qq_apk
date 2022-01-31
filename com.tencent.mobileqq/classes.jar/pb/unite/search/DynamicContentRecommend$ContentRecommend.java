package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicContentRecommend$ContentRecommend
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField desc_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField info_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField info_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField info_pics_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField info_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField more_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField more_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
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
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 66, 74, 82 }, new String[] { "title", "icon_url", "more_text", "more_url", "type", "info_title", "info_content", "info_pics_url", "desc_text", "info_jump_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9 }, ContentRecommend.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     pb.unite.search.DynamicContentRecommend.ContentRecommend
 * JD-Core Version:    0.7.0.1
 */