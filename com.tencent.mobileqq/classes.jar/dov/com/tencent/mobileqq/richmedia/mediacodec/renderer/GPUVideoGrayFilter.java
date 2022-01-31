package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.nio.FloatBuffer;

public class GPUVideoGrayFilter
{
  private static final FloatBuffer a;
  public static float[] a;
  private static final FloatBuffer b;
  public static final float[] b;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    jdField_b_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
    jdField_a_of_type_JavaNioFloatBuffer = GlUtil.a(jdField_a_of_type_ArrayOfFloat);
    jdField_b_of_type_JavaNioFloatBuffer = GlUtil.a(jdField_b_of_type_ArrayOfFloat);
  }
  
  public String toString()
  {
    return String.format("GPUVideoGreyFilter", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUVideoGrayFilter
 * JD-Core Version:    0.7.0.1
 */