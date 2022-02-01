package dov.com.qq.im.aeeditor.view.timebar.scale.size;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class FrameSizeParam
  extends SizeParam
{
  private int jdField_a_of_type_Int = 30;
  private SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("mm:ss", Locale.US);
  
  public FrameSizeParam(float paramFloat)
  {
    super(paramFloat);
  }
  
  public float a(long paramLong)
  {
    long l = paramLong / 1000L;
    return (float)(l * this.jdField_a_of_type_Int) / this.jdField_a_of_type_Float + (float)(paramLong - 1000L * l) / (1000.0F / this.jdField_a_of_type_Int) / this.jdField_a_of_type_Float;
  }
  
  public long a(float paramFloat)
  {
    return Math.round(this.jdField_a_of_type_Float * paramFloat * 1000.0F / this.jdField_a_of_type_Int);
  }
  
  public String a(long paramLong)
  {
    int i = Math.round((float)(paramLong % 1000L) / (1000.0F / this.jdField_a_of_type_Int));
    if ((i == this.jdField_a_of_type_Int) || (i == 0)) {
      return this.jdField_a_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong));
    }
    return i + "f";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.timebar.scale.size.FrameSizeParam
 * JD-Core Version:    0.7.0.1
 */