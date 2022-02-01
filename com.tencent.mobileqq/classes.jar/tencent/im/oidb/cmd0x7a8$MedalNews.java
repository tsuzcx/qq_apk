package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.medal.common.MedalInfo;

public final class cmd0x7a8$MedalNews
  extends MessageMicro<MedalNews>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_fri_uin", "str_fri_nick", "msg_medal" }, new Object[] { Long.valueOf(0L), "", null }, MedalNews.class);
  public common.MedalInfo msg_medal = new common.MedalInfo();
  public final PBStringField str_fri_nick = PBField.initString("");
  public final PBUInt64Field uint64_fri_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7a8.MedalNews
 * JD-Core Version:    0.7.0.1
 */