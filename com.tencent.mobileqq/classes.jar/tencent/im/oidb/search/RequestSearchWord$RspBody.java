package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class RequestSearchWord$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_search_keywords" }, new Object[] { null }, RspBody.class);
  public RequestSearchWord.SearchKeywords msg_search_keywords = new RequestSearchWord.SearchKeywords();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.search.RequestSearchWord.RspBody
 * JD-Core Version:    0.7.0.1
 */