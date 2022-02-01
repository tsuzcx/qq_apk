package face.qqlogin;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class faceproto$Request
  extends MessageMicro<Request>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 56, 66 }, new String[] { "SrcApp", "AppID", "UserInfo", "FaceInfo", "TmpKey", "Session", "CurRetryCnt", "plt" }, new Object[] { null, Integer.valueOf(0), null, null, "", "", Integer.valueOf(0), "" }, Request.class);
  public final PBUInt32Field AppID = PBField.initUInt32(0);
  public final PBUInt32Field CurRetryCnt = PBField.initUInt32(0);
  public faceproto.FaceInfo FaceInfo = new faceproto.FaceInfo();
  public final PBStringField Session = PBField.initString("");
  public faceproto.App SrcApp = new faceproto.App();
  public final PBStringField TmpKey = PBField.initString("");
  public faceproto.UserInfo UserInfo = new faceproto.UserInfo();
  public final PBStringField plt = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     face.qqlogin.faceproto.Request
 * JD-Core Version:    0.7.0.1
 */