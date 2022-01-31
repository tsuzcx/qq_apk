package com.tencent.mobileqq.shortvideo.dancemachine.tempDir;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.Vec3f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

public class DebugModeLine
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = GLES20.glCreateProgram();
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private float jdField_b_of_type_Float;
  private FloatBuffer jdField_b_of_type_JavaNioFloatBuffer;
  
  public DebugModeLine()
  {
    int i = GlUtil.a(35633, "precision highp float;\nattribute vec4 position;\nvoid main()\n{\ngl_Position = vec4(position.xy,0,1);\n}\n");
    int j = GlUtil.a(35632, "precision mediump float;uniform vec4 color;\nvoid main()\n{\ngl_FragColor = color;\n}\n");
    GLES20.glAttachShader(this.jdField_a_of_type_Int, i);
    GLES20.glAttachShader(this.jdField_a_of_type_Int, j);
    GLES20.glLinkProgram(this.jdField_a_of_type_Int);
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    GLES20.glUseProgram(this.jdField_a_of_type_Int);
    int i = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "position");
    GLES20.glEnableVertexAttribArray(i);
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 0, this.jdField_a_of_type_JavaNioFloatBuffer);
    int j = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "color");
    GLES20.glUniform4f(j, 0.0F, 1.0F, 0.0F, 1.0F);
    GLES20.glDrawArrays(1, 0, 40);
    this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 0, this.jdField_b_of_type_JavaNioFloatBuffer);
    GLES20.glUniform4f(j, 0.0F, 0.0F, 1.0F, 1.0F);
    GLES20.glLineWidth(8.0F);
    GLES20.glDrawArrays(1, 0, 2);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Float = paramInt1;
    this.jdField_b_of_type_Float = paramInt2;
  }
  
  void a(List paramList)
  {
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      Vec3f localVec3f = (Vec3f)paramList.get(i);
      localArrayList.add(new Vec3f(-(this.jdField_a_of_type_Float - 2.0F * localVec3f.jdField_a_of_type_Float) / this.jdField_a_of_type_Float, (this.jdField_b_of_type_Float - 2.0F * localVec3f.jdField_b_of_type_Float) / this.jdField_b_of_type_Float, localVec3f.c));
      i += 1;
    }
    this.jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(320).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    if ((((Vec3f)localArrayList.get(17)).c > 0.0F) && (((Vec3f)localArrayList.get(16)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(17)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(17)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(16)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(16)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(14)).c > 0.0F) && (((Vec3f)localArrayList.get(16)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(14)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(14)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(16)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(16)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(14)).c > 0.0F) && (((Vec3f)localArrayList.get(0)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(0)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(0)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(14)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(14)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(15)).c > 0.0F) && (((Vec3f)localArrayList.get(0)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(0)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(0)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(15)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(15)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(15)).c > 0.0F) && (((Vec3f)localArrayList.get(17)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(17)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(17)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(15)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(15)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(0)).c > 0.0F) && (((Vec3f)localArrayList.get(1)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(0)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(0)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(1)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(1)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(2)).c > 0.0F) && (((Vec3f)localArrayList.get(1)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(2)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(2)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(1)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(1)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(5)).c > 0.0F) && (((Vec3f)localArrayList.get(1)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(5)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(5)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(1)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(1)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(2)).c > 0.0F) && (((Vec3f)localArrayList.get(3)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(2)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(2)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(3)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(3)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(3)).c > 0.0F) && (((Vec3f)localArrayList.get(4)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(3)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(3)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(4)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(4)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(5)).c > 0.0F) && (((Vec3f)localArrayList.get(6)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(5)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(5)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(6)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(6)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(6)).c > 0.0F) && (((Vec3f)localArrayList.get(7)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(6)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(6)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(7)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(7)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(1)).c > 0.0F) && (((Vec3f)localArrayList.get(8)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(1)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(1)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(8)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(8)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(1)).c > 0.0F) && (((Vec3f)localArrayList.get(11)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(1)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(1)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(11)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(11)).jdField_b_of_type_Float);
    }
    float f;
    if ((((Vec3f)localArrayList.get(1)).c > 0.0F) && (((Vec3f)localArrayList.get(8)).c > 0.0F) && (((Vec3f)localArrayList.get(11)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(1)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(1)).jdField_b_of_type_Float);
      paramList = this.jdField_a_of_type_JavaNioFloatBuffer;
      f = ((Vec3f)localArrayList.get(11)).jdField_a_of_type_Float;
      paramList.put((((Vec3f)localArrayList.get(8)).jdField_a_of_type_Float + f) / 2.0F);
      paramList = this.jdField_a_of_type_JavaNioFloatBuffer;
      f = ((Vec3f)localArrayList.get(11)).jdField_b_of_type_Float;
      paramList.put((((Vec3f)localArrayList.get(8)).jdField_b_of_type_Float + f) / 2.0F);
    }
    if ((((Vec3f)localArrayList.get(8)).c > 0.0F) && (((Vec3f)localArrayList.get(11)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(8)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(8)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(11)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(11)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(8)).c > 0.0F) && (((Vec3f)localArrayList.get(9)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(8)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(8)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(9)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(9)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(10)).c > 0.0F) && (((Vec3f)localArrayList.get(9)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(10)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(10)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(9)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(9)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(11)).c > 0.0F) && (((Vec3f)localArrayList.get(12)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(11)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(11)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(12)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(12)).jdField_b_of_type_Float);
    }
    if ((((Vec3f)localArrayList.get(13)).c > 0.0F) && (((Vec3f)localArrayList.get(12)).c > 0.0F))
    {
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(13)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(13)).jdField_b_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(12)).jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(12)).jdField_b_of_type_Float);
    }
    this.jdField_b_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
    if ((((Vec3f)localArrayList.get(2)).c > 0.0F) && (((Vec3f)localArrayList.get(3)).c > 0.0F))
    {
      this.jdField_b_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(2)).jdField_a_of_type_Float);
      this.jdField_b_of_type_JavaNioFloatBuffer.put(((Vec3f)localArrayList.get(2)).jdField_b_of_type_Float);
      paramList = this.jdField_b_of_type_JavaNioFloatBuffer;
      f = ((Vec3f)localArrayList.get(2)).jdField_a_of_type_Float;
      paramList.put((((Vec3f)localArrayList.get(3)).jdField_a_of_type_Float + f) / 2.0F);
      paramList = this.jdField_b_of_type_JavaNioFloatBuffer;
      f = ((Vec3f)localArrayList.get(2)).jdField_b_of_type_Float;
      paramList.put((((Vec3f)localArrayList.get(3)).jdField_b_of_type_Float + f) / 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.tempDir.DebugModeLine
 * JD-Core Version:    0.7.0.1
 */