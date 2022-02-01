package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ArticleComment$GetPhotoCollectionInfoRequest
  extends MessageMicro<GetPhotoCollectionInfoRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field click_source = PBField.initUInt32(0);
  public final PBUInt64Field cuin = PBField.initUInt64(0L);
  public final PBUInt32Field recommend_position = PBField.initUInt32(0);
  public final PBStringField recommend_source = PBField.initString("");
  public final PBStringField versionInfo = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48 }, new String[] { "versionInfo", "cuin", "article_id", "recommend_source", "recommend_position", "click_source" }, new Object[] { "", Long.valueOf(0L), localByteStringMicro, "", localInteger, localInteger }, GetPhotoCollectionInfoRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.ac.ArticleComment.GetPhotoCollectionInfoRequest
 * JD-Core Version:    0.7.0.1
 */