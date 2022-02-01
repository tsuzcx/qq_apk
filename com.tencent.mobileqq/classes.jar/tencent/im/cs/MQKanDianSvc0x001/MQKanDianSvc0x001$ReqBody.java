package tencent.im.cs.MQKanDianSvc0x001;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MQKanDianSvc0x001$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int CUT_ALL = 1;
  public static final int CUT_FOR_SEARCH = 2;
  public static final int CUT_PRECISE = 0;
  public static final int CUT_WORD = 0;
  public static final int CUT_WORD_AND_GET_ARTICLES = 2;
  public static final int GET_ARTICLES = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_use_hmm = PBField.initBool(false);
  public final PBEnumField enum_cut_mode = PBField.initEnum(0);
  public final PBEnumField enum_request_mode = PBField.initEnum(0);
  public final PBRepeatField<String> rpt_str_sentences = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field uint32_request_article_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "enum_cut_mode", "enum_request_mode", "rpt_str_sentences", "bool_use_hmm", "uint32_request_article_num" }, new Object[] { localInteger, localInteger, "", Boolean.valueOf(false), localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.MQKanDianSvc0x001.MQKanDianSvc0x001.ReqBody
 * JD-Core Version:    0.7.0.1
 */