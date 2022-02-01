package dov.com.qq.im.cropvideo;

import android.graphics.RectF;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class RenderFilter
{
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF(-1.0F, 1.0F, 1.0F, -1.0F);
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(this.jdField_a_of_type_ArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.jdField_a_of_type_ArrayOfFloat);
  private final float[] jdField_a_of_type_ArrayOfFloat = { 1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F };
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF(-1.0F, 1.0F, 1.0F, -1.0F);
  private FloatBuffer jdField_b_of_type_JavaNioFloatBuffer;
  private final float[] jdField_b_of_type_ArrayOfFloat = { 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F };
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF(-1.0F, 1.0F, 1.0F, -1.0F);
  private final float[] jdField_c_of_type_ArrayOfFloat = new float[16];
  private final float[] d = new float[16];
  private float[] e = new float[16];
  private final float[] f = new float[16];
  
  public RenderFilter()
  {
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    this.jdField_b_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(this.jdField_b_of_type_ArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.jdField_b_of_type_ArrayOfFloat);
    this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.cropvideo.RenderFilter
 * JD-Core Version:    0.7.0.1
 */