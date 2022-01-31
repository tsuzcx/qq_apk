package tencent.im.oidb.cmd0xbec;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbec$SearchByKeyWordsReq
  extends MessageMicro<SearchByKeyWordsReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_keywords = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xbec.Cookies msg_cookies = new oidb_cmd0xbec.Cookies();
  public final PBUInt32Field uint32_page_size = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "bytes_keywords", "msg_cookies", "uint32_page_size" }, new Object[] { localByteStringMicro, null, Integer.valueOf(0) }, SearchByKeyWordsReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbec.oidb_cmd0xbec.SearchByKeyWordsReq
 * JD-Core Version:    0.7.0.1
 */