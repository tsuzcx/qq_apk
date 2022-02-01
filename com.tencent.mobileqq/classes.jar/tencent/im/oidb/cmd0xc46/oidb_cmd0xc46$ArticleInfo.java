package tencent.im.oidb.cmd0xc46;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xc46$ArticleInfo
  extends MessageMicro<ArticleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "comment_count", "forbidden", "use_black_menu", "has_anchor" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ArticleInfo.class);
  public final PBUInt64Field comment_count = PBField.initUInt64(0L);
  public final PBUInt32Field forbidden = PBField.initUInt32(0);
  public final PBInt32Field has_anchor = PBField.initInt32(0);
  public final PBInt32Field use_black_menu = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ArticleInfo
 * JD-Core Version:    0.7.0.1
 */