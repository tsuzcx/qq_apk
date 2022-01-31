package com.tencent.ttpic.filter;

import android.annotation.TargetApi;
import android.opengl.GLES30;
import android.util.Log;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.ProgramTools;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@TargetApi(18)
public class TransformFeedback
{
  private final String TAG = "TransformFeedback";
  private final String fragmentShaderCode = "#version 300 es \nprecision mediump float;\nout vec4 fragColor;\nvoid main() {\n  fragColor = vec4(1.0,1.0,1.0,1.0);\n}";
  private final int mProgram;
  private final String vertexShaderSrc = "#version 300 es \nin float inValue;\nout float outValue;\nvoid main() {\n    outValue = sqrt(inValue);\n}";
  
  public TransformFeedback()
  {
    int i = ProgramTools.loadShader(35633, "#version 300 es \nin float inValue;\nout float outValue;\nvoid main() {\n    outValue = sqrt(inValue);\n}");
    int j = ProgramTools.loadShader(35632, "#version 300 es \nprecision mediump float;\nout vec4 fragColor;\nvoid main() {\n  fragColor = vec4(1.0,1.0,1.0,1.0);\n}");
    this.mProgram = GLES30.glCreateProgram();
    GLES30.glAttachShader(this.mProgram, i);
    GLES30.glAttachShader(this.mProgram, j);
    GLES30.glTransformFeedbackVaryings(this.mProgram, new String[] { "outValue" }, 35980);
    GlUtil.checkGlError("TransformFeedback glTransformFeedbackVaryings");
    GLES30.glLinkProgram(this.mProgram);
    int[] arrayOfInt = new int[1];
    GLES30.glGetProgramiv(this.mProgram, 35714, arrayOfInt, 0);
    if (arrayOfInt[0] != 1) {
      Log.d("TransformFeedback", "glLinkProgram failed");
    }
    GlUtil.checkGlError("TransformFeedback glLinkProgram");
    GLES30.glUseProgram(this.mProgram);
    GlUtil.checkGlError("TransformFeedback glUseProgram");
    Object localObject1 = ByteBuffer.allocateDirect(20).order(ByteOrder.nativeOrder()).asFloatBuffer();
    ((FloatBuffer)localObject1).put(new float[] { 1.0F, 4.0F, 9.0F, 16.0F, 25.0F }).position(0);
    arrayOfInt = new int[1];
    GLES30.glGenBuffers(1, arrayOfInt, 0);
    GLES30.glBindBuffer(34962, arrayOfInt[0]);
    GLES30.glBufferData(34962, 20, (Buffer)localObject1, 35045);
    GlUtil.checkGlError("TransformFeedback glBufferData GL_ARRAY_BUFFER");
    int k = GLES30.glGetAttribLocation(this.mProgram, "inValue");
    GLES30.glEnableVertexAttribArray(k);
    GLES30.glVertexAttribPointer(k, 1, 5126, false, 4, 0);
    GlUtil.checkGlError("TransformFeedback glVertexAttribPointer");
    localObject1 = new int[1];
    GLES30.glGenBuffers(1, (int[])localObject1, 0);
    GLES30.glBindBuffer(35982, localObject1[0]);
    GLES30.glBufferData(35982, 20, null, 35045);
    GLES30.glBindBufferBase(35982, 0, localObject1[0]);
    GlUtil.checkGlError("TransformFeedback glBindBufferBase");
    GLES30.glEnable(35977);
    GLES30.glBeginTransformFeedback(0);
    GLES30.glDrawArrays(0, 0, 5);
    GlUtil.checkGlError("TransformFeedback glDrawArrays");
    GLES30.glEndTransformFeedback();
    GLES30.glDisable(35977);
    GLES30.glFlush();
    GlUtil.checkGlError("TransformFeedback pre-glMapBufferRange ");
    Object localObject2 = GLES30.glMapBufferRange(35982, 0, 20, 1);
    GlUtil.checkGlError("TransformFeedback glMapBufferRange");
    if (localObject2 != null)
    {
      localObject2 = (ByteBuffer)localObject2;
      ((ByteBuffer)localObject2).order(ByteOrder.nativeOrder());
      localObject2 = ((ByteBuffer)localObject2).asFloatBuffer();
      Log.d("TransformFeedback", String.format("output values = %f %f %f %f %f\n", new Object[] { Float.valueOf(((FloatBuffer)localObject2).get()), Float.valueOf(((FloatBuffer)localObject2).get()), Float.valueOf(((FloatBuffer)localObject2).get()), Float.valueOf(((FloatBuffer)localObject2).get()), Float.valueOf(((FloatBuffer)localObject2).get()) }));
    }
    GLES30.glUnmapBuffer(35982);
    GLES30.glDeleteProgram(this.mProgram);
    GLES30.glDeleteShader(i);
    GLES30.glDeleteShader(j);
    GLES30.glDeleteBuffers(1, (int[])localObject1, 0);
    GLES30.glDeleteBuffers(1, arrayOfInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransformFeedback
 * JD-Core Version:    0.7.0.1
 */