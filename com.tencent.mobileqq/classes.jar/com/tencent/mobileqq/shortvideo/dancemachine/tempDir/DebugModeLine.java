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
  private FloatBuffer bb;
  private float height;
  private int mProgram = GLES20.glCreateProgram();
  private FloatBuffer testBuffer;
  private float width;
  
  public DebugModeLine()
  {
    int i = GlUtil.loadShader(35633, "precision highp float;\nattribute vec4 position;\nvoid main()\n{\ngl_Position = vec4(position.xy,0,1);\n}\n");
    int j = GlUtil.loadShader(35632, "precision mediump float;uniform vec4 color;\nvoid main()\n{\ngl_FragColor = color;\n}\n");
    GLES20.glAttachShader(this.mProgram, i);
    GLES20.glAttachShader(this.mProgram, j);
    GLES20.glLinkProgram(this.mProgram);
  }
  
  void draw()
  {
    this.bb.position(0);
    GLES20.glUseProgram(this.mProgram);
    int i = GLES20.glGetAttribLocation(this.mProgram, "position");
    GLES20.glEnableVertexAttribArray(i);
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 0, this.bb);
    int j = GLES20.glGetUniformLocation(this.mProgram, "color");
    GLES20.glUniform4f(j, 0.0F, 1.0F, 0.0F, 1.0F);
    GLES20.glDrawArrays(1, 0, 40);
    this.testBuffer.position(0);
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 0, this.testBuffer);
    GLES20.glUniform4f(j, 0.0F, 0.0F, 1.0F, 1.0F);
    GLES20.glLineWidth(8.0F);
    GLES20.glDrawArrays(1, 0, 2);
  }
  
  public void updateFboSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  void updateParams(List<Vec3f> paramList)
  {
    int j = paramList.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      Vec3f localVec3f = (Vec3f)paramList.get(i);
      localArrayList.add(new Vec3f(-(this.width - 2.0F * localVec3f.x) / this.width, (this.height - 2.0F * localVec3f.y) / this.height, localVec3f.z));
      i += 1;
    }
    this.bb = ByteBuffer.allocateDirect(320).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.bb.position(0);
    if ((((Vec3f)localArrayList.get(17)).z > 0.0F) && (((Vec3f)localArrayList.get(16)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(17)).x);
      this.bb.put(((Vec3f)localArrayList.get(17)).y);
      this.bb.put(((Vec3f)localArrayList.get(16)).x);
      this.bb.put(((Vec3f)localArrayList.get(16)).y);
    }
    if ((((Vec3f)localArrayList.get(14)).z > 0.0F) && (((Vec3f)localArrayList.get(16)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(14)).x);
      this.bb.put(((Vec3f)localArrayList.get(14)).y);
      this.bb.put(((Vec3f)localArrayList.get(16)).x);
      this.bb.put(((Vec3f)localArrayList.get(16)).y);
    }
    if ((((Vec3f)localArrayList.get(14)).z > 0.0F) && (((Vec3f)localArrayList.get(0)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(0)).x);
      this.bb.put(((Vec3f)localArrayList.get(0)).y);
      this.bb.put(((Vec3f)localArrayList.get(14)).x);
      this.bb.put(((Vec3f)localArrayList.get(14)).y);
    }
    if ((((Vec3f)localArrayList.get(15)).z > 0.0F) && (((Vec3f)localArrayList.get(0)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(0)).x);
      this.bb.put(((Vec3f)localArrayList.get(0)).y);
      this.bb.put(((Vec3f)localArrayList.get(15)).x);
      this.bb.put(((Vec3f)localArrayList.get(15)).y);
    }
    if ((((Vec3f)localArrayList.get(15)).z > 0.0F) && (((Vec3f)localArrayList.get(17)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(17)).x);
      this.bb.put(((Vec3f)localArrayList.get(17)).y);
      this.bb.put(((Vec3f)localArrayList.get(15)).x);
      this.bb.put(((Vec3f)localArrayList.get(15)).y);
    }
    if ((((Vec3f)localArrayList.get(0)).z > 0.0F) && (((Vec3f)localArrayList.get(1)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(0)).x);
      this.bb.put(((Vec3f)localArrayList.get(0)).y);
      this.bb.put(((Vec3f)localArrayList.get(1)).x);
      this.bb.put(((Vec3f)localArrayList.get(1)).y);
    }
    if ((((Vec3f)localArrayList.get(2)).z > 0.0F) && (((Vec3f)localArrayList.get(1)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(2)).x);
      this.bb.put(((Vec3f)localArrayList.get(2)).y);
      this.bb.put(((Vec3f)localArrayList.get(1)).x);
      this.bb.put(((Vec3f)localArrayList.get(1)).y);
    }
    if ((((Vec3f)localArrayList.get(5)).z > 0.0F) && (((Vec3f)localArrayList.get(1)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(5)).x);
      this.bb.put(((Vec3f)localArrayList.get(5)).y);
      this.bb.put(((Vec3f)localArrayList.get(1)).x);
      this.bb.put(((Vec3f)localArrayList.get(1)).y);
    }
    if ((((Vec3f)localArrayList.get(2)).z > 0.0F) && (((Vec3f)localArrayList.get(3)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(2)).x);
      this.bb.put(((Vec3f)localArrayList.get(2)).y);
      this.bb.put(((Vec3f)localArrayList.get(3)).x);
      this.bb.put(((Vec3f)localArrayList.get(3)).y);
    }
    if ((((Vec3f)localArrayList.get(3)).z > 0.0F) && (((Vec3f)localArrayList.get(4)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(3)).x);
      this.bb.put(((Vec3f)localArrayList.get(3)).y);
      this.bb.put(((Vec3f)localArrayList.get(4)).x);
      this.bb.put(((Vec3f)localArrayList.get(4)).y);
    }
    if ((((Vec3f)localArrayList.get(5)).z > 0.0F) && (((Vec3f)localArrayList.get(6)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(5)).x);
      this.bb.put(((Vec3f)localArrayList.get(5)).y);
      this.bb.put(((Vec3f)localArrayList.get(6)).x);
      this.bb.put(((Vec3f)localArrayList.get(6)).y);
    }
    if ((((Vec3f)localArrayList.get(6)).z > 0.0F) && (((Vec3f)localArrayList.get(7)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(6)).x);
      this.bb.put(((Vec3f)localArrayList.get(6)).y);
      this.bb.put(((Vec3f)localArrayList.get(7)).x);
      this.bb.put(((Vec3f)localArrayList.get(7)).y);
    }
    if ((((Vec3f)localArrayList.get(1)).z > 0.0F) && (((Vec3f)localArrayList.get(8)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(1)).x);
      this.bb.put(((Vec3f)localArrayList.get(1)).y);
      this.bb.put(((Vec3f)localArrayList.get(8)).x);
      this.bb.put(((Vec3f)localArrayList.get(8)).y);
    }
    if ((((Vec3f)localArrayList.get(1)).z > 0.0F) && (((Vec3f)localArrayList.get(11)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(1)).x);
      this.bb.put(((Vec3f)localArrayList.get(1)).y);
      this.bb.put(((Vec3f)localArrayList.get(11)).x);
      this.bb.put(((Vec3f)localArrayList.get(11)).y);
    }
    float f;
    if ((((Vec3f)localArrayList.get(1)).z > 0.0F) && (((Vec3f)localArrayList.get(8)).z > 0.0F) && (((Vec3f)localArrayList.get(11)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(1)).x);
      this.bb.put(((Vec3f)localArrayList.get(1)).y);
      paramList = this.bb;
      f = ((Vec3f)localArrayList.get(11)).x;
      paramList.put((((Vec3f)localArrayList.get(8)).x + f) / 2.0F);
      paramList = this.bb;
      f = ((Vec3f)localArrayList.get(11)).y;
      paramList.put((((Vec3f)localArrayList.get(8)).y + f) / 2.0F);
    }
    if ((((Vec3f)localArrayList.get(8)).z > 0.0F) && (((Vec3f)localArrayList.get(11)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(8)).x);
      this.bb.put(((Vec3f)localArrayList.get(8)).y);
      this.bb.put(((Vec3f)localArrayList.get(11)).x);
      this.bb.put(((Vec3f)localArrayList.get(11)).y);
    }
    if ((((Vec3f)localArrayList.get(8)).z > 0.0F) && (((Vec3f)localArrayList.get(9)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(8)).x);
      this.bb.put(((Vec3f)localArrayList.get(8)).y);
      this.bb.put(((Vec3f)localArrayList.get(9)).x);
      this.bb.put(((Vec3f)localArrayList.get(9)).y);
    }
    if ((((Vec3f)localArrayList.get(10)).z > 0.0F) && (((Vec3f)localArrayList.get(9)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(10)).x);
      this.bb.put(((Vec3f)localArrayList.get(10)).y);
      this.bb.put(((Vec3f)localArrayList.get(9)).x);
      this.bb.put(((Vec3f)localArrayList.get(9)).y);
    }
    if ((((Vec3f)localArrayList.get(11)).z > 0.0F) && (((Vec3f)localArrayList.get(12)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(11)).x);
      this.bb.put(((Vec3f)localArrayList.get(11)).y);
      this.bb.put(((Vec3f)localArrayList.get(12)).x);
      this.bb.put(((Vec3f)localArrayList.get(12)).y);
    }
    if ((((Vec3f)localArrayList.get(13)).z > 0.0F) && (((Vec3f)localArrayList.get(12)).z > 0.0F))
    {
      this.bb.put(((Vec3f)localArrayList.get(13)).x);
      this.bb.put(((Vec3f)localArrayList.get(13)).y);
      this.bb.put(((Vec3f)localArrayList.get(12)).x);
      this.bb.put(((Vec3f)localArrayList.get(12)).y);
    }
    this.testBuffer = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.testBuffer.position(0);
    if ((((Vec3f)localArrayList.get(2)).z > 0.0F) && (((Vec3f)localArrayList.get(3)).z > 0.0F))
    {
      this.testBuffer.put(((Vec3f)localArrayList.get(2)).x);
      this.testBuffer.put(((Vec3f)localArrayList.get(2)).y);
      paramList = this.testBuffer;
      f = ((Vec3f)localArrayList.get(2)).x;
      paramList.put((((Vec3f)localArrayList.get(3)).x + f) / 2.0F);
      paramList = this.testBuffer;
      f = ((Vec3f)localArrayList.get(2)).y;
      paramList.put((((Vec3f)localArrayList.get(3)).y + f) / 2.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.tempDir.DebugModeLine
 * JD-Core Version:    0.7.0.1
 */