package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class QQCircleRead$GetUploadTmpCredentialRsp
  extends MessageMicro<GetUploadTmpCredentialRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "extInfo", "tmpSecretID", "tmpSecretKey", "sessionToken" }, new Object[] { null, "", "", "" }, GetUploadTmpCredentialRsp.class);
  public FeedCloudCommon.StCommonExt extInfo = new FeedCloudCommon.StCommonExt();
  public final PBStringField sessionToken = PBField.initString("");
  public final PBStringField tmpSecretID = PBField.initString("");
  public final PBStringField tmpSecretKey = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqcircle.QQCircleRead.GetUploadTmpCredentialRsp
 * JD-Core Version:    0.7.0.1
 */