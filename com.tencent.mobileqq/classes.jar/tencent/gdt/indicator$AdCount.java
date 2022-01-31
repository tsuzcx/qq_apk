package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class indicator$AdCount
  extends MessageMicro<AdCount>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "index", "scoring", "fillad", "reranking_docwash", "reranking_input", "reranking_output", "mixer_filter", "adinfo", "mixer", "display" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, AdCount.class);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.gdt.indicator.AdCount
 * JD-Core Version:    0.7.0.1
 */