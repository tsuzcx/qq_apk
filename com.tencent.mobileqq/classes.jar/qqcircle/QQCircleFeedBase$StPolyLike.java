package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQCircleFeedBase$StPolyLike
  extends MessageMicro<StPolyLike>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField articleType = PBField.initEnum(0);
  public final PBBytesField busiData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBoolField clicked = PBField.initBool(false);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBStringField fullScreenURL = PBField.initString("");
  public final PBStringField fullScreenURLAND = PBField.initString("");
  public final PBStringField polyIconUrl = PBField.initString("");
  public final PBStringField polyLikeID = PBField.initString("");
  public final PBStringField polyName = PBField.initString("");
  public final PBStringField polyPreviewSource = PBField.initString("");
  public final PBStringField polySource = PBField.initString("");
  public final PBStringField polyTxtColor = PBField.initString("");
  public final PBStringField polyUnderColor = PBField.initString("");
  public final PBStringField polyUnderPicUrl = PBField.initString("");
  public final PBUInt32Field price = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 64, 72, 80, 90, 98, 106, 114, 122 }, new String[] { "polyLikeID", "polyName", "polySource", "polyIconUrl", "count", "polyUnderPicUrl", "polyPreviewSource", "articleType", "price", "clicked", "busiData", "fullScreenURL", "fullScreenURLAND", "polyTxtColor", "polyUnderColor" }, new Object[] { "", "", "", "", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), localByteStringMicro, "", "", "", "" }, StPolyLike.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqcircle.QQCircleFeedBase.StPolyLike
 * JD-Core Version:    0.7.0.1
 */