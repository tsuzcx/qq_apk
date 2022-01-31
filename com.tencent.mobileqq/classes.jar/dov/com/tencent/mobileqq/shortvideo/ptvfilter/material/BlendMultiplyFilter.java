package dov.com.tencent.mobileqq.shortvideo.ptvfilter.material;

import android.annotation.TargetApi;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@TargetApi(9)
public class BlendMultiplyFilter
{
  private static final int jdField_a_of_type_Int = jdField_a_of_type_ArrayOfFloat.length * 4 + b.length * 4 * 2;
  private static final float[] jdField_a_of_type_ArrayOfFloat = { -1.0F, -1.0F, 1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F };
  private static final float[] b = { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
  private static float[] c = { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F };
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(jdField_a_of_type_Int).order(ByteOrder.nativeOrder()).asFloatBuffer();
  private boolean jdField_a_of_type_Boolean = false;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ptvfilter.material.BlendMultiplyFilter
 * JD-Core Version:    0.7.0.1
 */