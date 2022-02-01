package pb.unite.search;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class RequestSearchWord$SearchKeywords
  extends MessageMicro<SearchKeywords>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<RequestSearchWord.Rcmd> rcmds = PBField.initRepeatMessage(RequestSearchWord.Rcmd.class);
  public final PBStringField sessionid = PBField.initString("");
  public final PBBytesField sid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 26, 34, 42 }, new String[] { "rcmds", "sid", "sessionid" }, new Object[] { null, localByteStringMicro, "" }, SearchKeywords.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     pb.unite.search.RequestSearchWord.SearchKeywords
 * JD-Core Version:    0.7.0.1
 */