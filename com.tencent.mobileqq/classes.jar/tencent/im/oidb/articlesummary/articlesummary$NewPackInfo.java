package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class articlesummary$NewPackInfo
  extends MessageMicro<NewPackInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_more_href = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_more_tips = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sub_head_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_top_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_top_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public articlesummary.UrlJumpInfo msg_head_url_jump_info = new articlesummary.UrlJumpInfo();
  public articlesummary.UrlJumpInfo msg_right_more_url_jump_info = new articlesummary.UrlJumpInfo();
  public final PBEnumField pack_type = PBField.initEnum(1);
  public final PBRepeatMessageField<articlesummary.PackArticleInfo> rpt_pack_article_list = PBField.initRepeatMessage(articlesummary.PackArticleInfo.class);
  public final PBUInt32Field uin32_head_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_follow_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_size_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 64, 72, 80, 90, 98, 104 }, new String[] { "pack_type", "rpt_pack_article_list", "bytes_top_icon_url", "bytes_top_title", "bytes_more_tips", "bytes_more_href", "bytes_sub_head_icon_url", "uint32_follow_status", "uin32_head_type", "uint32_video_size_type", "msg_head_url_jump_info", "msg_right_more_url_jump_info", "uint32_column_id" }, new Object[] { Integer.valueOf(1), null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0) }, NewPackInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.NewPackInfo
 * JD-Core Version:    0.7.0.1
 */