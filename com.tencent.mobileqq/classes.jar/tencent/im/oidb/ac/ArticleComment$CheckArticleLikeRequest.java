package tencent.im.oidb.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ArticleComment$CheckArticleLikeRequest
  extends MessageMicro<CheckArticleLikeRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Long> uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "article_id", "uins" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, CheckArticleLikeRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.ac.ArticleComment.CheckArticleLikeRequest
 * JD-Core Version:    0.7.0.1
 */