package expand.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetMatchSrcRsp
  extends MessageMicro<GetMatchSrcRsp>
{
  public static final int MasterUinNotExist = 2;
  public static final int Ok = 0;
  public static final int ReqNumberLimitExceeded = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "MatchedInfoList", "Code", "ErrMsg" }, new Object[] { null, Integer.valueOf(0), "" }, GetMatchSrcRsp.class);
  public final PBEnumField Code = PBField.initEnum(0);
  public final PBStringField ErrMsg = PBField.initString("");
  public final PBRepeatMessageField<MatchedInfo> MatchedInfoList = PBField.initRepeatMessage(MatchedInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     expand.common.GetMatchSrcRsp
 * JD-Core Version:    0.7.0.1
 */