package tencent.im.oidb.cmd0xaef;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import tencent.im.oidb.cmd0xae9.group_online_docs.DocInfo;

public final class Oidb_0xaef$SearchItem
  extends MessageMicro<SearchItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public group_online_docs.DocInfo doc_info = new group_online_docs.DocInfo();
  public final PBRepeatField<ByteStringMicro> match_word = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "doc_info", "match_word" }, new Object[] { null, localByteStringMicro }, SearchItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xaef.Oidb_0xaef.SearchItem
 * JD-Core Version:    0.7.0.1
 */