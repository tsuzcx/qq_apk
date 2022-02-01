package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class indicator$AdCount
  extends MessageMicro<AdCount>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field adinfo = PBField.initUInt32(0);
  public final PBUInt32Field display = PBField.initUInt32(0);
  public final PBUInt32Field fillad = PBField.initUInt32(0);
  public final PBUInt32Field index = PBField.initUInt32(0);
  public final PBUInt32Field mixer = PBField.initUInt32(0);
  public final PBUInt32Field mixer_filter = PBField.initUInt32(0);
  public final PBUInt32Field reranking_docwash = PBField.initUInt32(0);
  public final PBUInt32Field reranking_input = PBField.initUInt32(0);
  public final PBUInt32Field reranking_output = PBField.initUInt32(0);
  public final PBUInt32Field scoring = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "index", "scoring", "fillad", "reranking_docwash", "reranking_input", "reranking_output", "mixer_filter", "adinfo", "mixer", "display" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, AdCount.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.indicator.AdCount
 * JD-Core Version:    0.7.0.1
 */