package tencent.im.oidb.cmd0xaef;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0xaef$SearchDocRsp
  extends MessageMicro<SearchDocRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<Oidb_0xaef.SearchItem> doc_list = PBField.initRepeatMessage(Oidb_0xaef.SearchItem.class);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBBytesField key_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field match_count = PBField.initUInt32(0);
  public final PBUInt32Field next = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "next", "is_end", "key_word", "match_count", "doc_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), null }, SearchDocRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaef.Oidb_0xaef.SearchDocRsp
 * JD-Core Version:    0.7.0.1
 */