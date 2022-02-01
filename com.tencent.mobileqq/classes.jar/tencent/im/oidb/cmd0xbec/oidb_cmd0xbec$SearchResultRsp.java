package tencent.im.oidb.cmd0xbec;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xbec$SearchResultRsp
  extends MessageMicro<SearchResultRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_is_end = PBField.initBool(false);
  public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_cmd0xbec.QuestionInfo> rpt_question_info = PBField.initRepeatMessage(oidb_cmd0xbec.QuestionInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "rpt_question_info", "bytes_cookies", "bool_is_end" }, new Object[] { null, localByteStringMicro, Boolean.valueOf(false) }, SearchResultRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbec.oidb_cmd0xbec.SearchResultRsp
 * JD-Core Version:    0.7.0.1
 */