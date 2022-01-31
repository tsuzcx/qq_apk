package feedcloud;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FeedCloudQwebcal$StQWebReq
  extends MessageMicro<StQWebReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField Cmdname = PBField.initString("");
  public FeedCloudQwebcal.StEncryption Crypto = new FeedCloudQwebcal.StEncryption();
  public final PBRepeatMessageField<FeedCloudCommon.Entry> Extinfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  public final PBStringField Module = PBField.initString("");
  public final PBUInt64Field Seq = PBField.initUInt64(0L);
  public final PBBytesField busiBuff = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField deviceInfo = PBField.initString("");
  public FeedCloudQwebcal.StAuthInfo loginSig = new FeedCloudQwebcal.StAuthInfo();
  public final PBStringField qua = PBField.initString("");
  public final PBStringField traceid = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "Seq", "qua", "deviceInfo", "busiBuff", "traceid", "Module", "Cmdname", "loginSig", "Crypto", "Extinfo" }, new Object[] { Long.valueOf(0L), "", "", localByteStringMicro, "", "", "", null, null, null }, StQWebReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     feedcloud.FeedCloudQwebcal.StQWebReq
 * JD-Core Version:    0.7.0.1
 */