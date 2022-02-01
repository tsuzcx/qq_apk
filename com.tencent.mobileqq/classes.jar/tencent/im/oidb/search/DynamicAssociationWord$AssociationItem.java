package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class DynamicAssociationWord$AssociationItem
  extends MessageMicro<AssociationItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field group_mask = PBField.initUInt32(0);
  public final PBBytesField jmp_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField subWord = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48 }, new String[] { "word", "jmp_url", "pic_url", "subWord", "type", "group_mask" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localInteger, localInteger }, AssociationItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.search.DynamicAssociationWord.AssociationItem
 * JD-Core Version:    0.7.0.1
 */