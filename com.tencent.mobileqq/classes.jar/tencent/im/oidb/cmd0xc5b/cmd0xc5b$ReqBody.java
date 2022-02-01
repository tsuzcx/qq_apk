package tencent.im.oidb.cmd0xc5b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.feeds_info.FeedsInfo;

public final class cmd0xc5b$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_feeds_id", "msg_feeds_info" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
  public feeds_info.FeedsInfo msg_feeds_info = new feeds_info.FeedsInfo();
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc5b.cmd0xc5b.ReqBody
 * JD-Core Version:    0.7.0.1
 */