package com.tencent.vbox;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

class VboxUtils$1
  implements Runnable
{
  VboxUtils$1(VboxUtils paramVboxUtils, int paramInt1, int paramInt2, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Object localObject1 = EGL14.eglGetDisplay(0);
    Object localObject2 = new int[2];
    EGL14.eglInitialize((EGLDisplay)localObject1, (int[])localObject2, 0, (int[])localObject2, 1);
    localObject2 = new EGLConfig[1];
    int[] arrayOfInt = new int[1];
    int i = localObject2.length;
    EGL14.eglChooseConfig((EGLDisplay)localObject1, new int[] { 12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344 }, 0, (EGLConfig[])localObject2, 0, i, arrayOfInt, 0);
    EGL14.eglCreateContext((EGLDisplay)localObject1, localObject2[0], EGL14.EGL_NO_CONTEXT, new int[] { 12440, 2, 12344 }, 0);
    VboxUtils.access$002(this.this$0, VboxUtils.access$100(this.this$0, "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 textureCoordinate;\n\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  textureCoordinate = (uSTMatrix * aTextureCoord).xy;\n}", "precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n\n const mat4 conversion = mat4(1.0, 0.0, 1.402, -0.701, 1.0, -0.344, -0.714, 0.529, 1.0, 1.772, 0.0, -0.886, 0.0, 0.0, 0.0, 0.0);\n void main()\n {\n     vec4 yuv = texture2D(inputImageTexture, textureCoordinate);\n     vec3 rgba = (yuv * conversion).xyz;\n     gl_FragColor = vec4(rgba, 1.0);\n }\n"));
    VboxUtils.access$200(this.this$0, "glCreateProgram");
    VboxUtils.access$300(this.this$0, VboxUtils.access$000(this.this$0));
    VboxUtils.access$200(this.this$0, "gl get aProgram Handler");
    VboxUtils.access$402(this.this$0, ByteBuffer.allocateDirect(VboxUtils.access$500(this.this$0).length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer());
    VboxUtils.access$400(this.this$0).put(VboxUtils.access$500(this.this$0)).position(0);
    Matrix.setIdentityM(VboxUtils.access$600(this.this$0), 0);
    localObject1 = new int[2];
    GLES20.glGenTextures(2, (int[])localObject1, 0);
    VboxUtils.access$702(this.this$0, localObject1[0]);
    VboxUtils.access$802(this.this$0, localObject1[1]);
    VboxUtils.access$900(this.this$0, this.val$width, this.val$height);
    GLES20.glBindTexture(3553, VboxUtils.access$700(this.this$0));
    GLES20.glTexImage2D(3553, 0, 6407, this.val$width, this.val$height, 0, 6407, 5121, ByteBuffer.wrap(this.val$yuv24));
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    VboxUtils.access$1000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.VboxUtils.1
 * JD-Core Version:    0.7.0.1
 */