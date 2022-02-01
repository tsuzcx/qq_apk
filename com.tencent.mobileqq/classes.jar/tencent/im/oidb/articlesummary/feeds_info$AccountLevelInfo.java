package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class feeds_info$AccountLevelInfo
  extends MessageMicro<AccountLevelInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 40, 50, 58 }, new String[] { "uint32_account_cc_level", "account_cc_level_icon_s", "account_cc_level_icon_l" }, new Object[] { Integer.valueOf(0), "", "" }, AccountLevelInfo.class);
  public final PBStringField account_cc_level_icon_l = PBField.initString("");
  public final PBStringField account_cc_level_icon_s = PBField.initString("");
  public final PBUInt32Field uint32_account_cc_level = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.AccountLevelInfo
 * JD-Core Version:    0.7.0.1
 */