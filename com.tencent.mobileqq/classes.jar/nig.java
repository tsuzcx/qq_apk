import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class nig
{
  public static final float[] a;
  public static final float[] b;
  protected int a;
  private final String jdField_a_of_type_JavaLangString;
  protected FloatBuffer a;
  private final LinkedList<Runnable> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  private final String b;
  protected FloatBuffer b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
    jdField_b_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  }
  
  public nig()
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision mediump float;\nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
  }
  
  public nig(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(jdField_a_of_type_ArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.put(jdField_a_of_type_ArrayOfFloat);
    this.jdField_b_of_type_JavaNioFloatBuffer = ByteBuffer.allocateDirect(jdField_b_of_type_ArrayOfFloat.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    this.jdField_b_of_type_JavaNioFloatBuffer.put(jdField_b_of_type_ArrayOfFloat).position(0);
  }
  
  public static int c()
  {
    int i = GLES20.glGetError();
    if (i != 0) {
      bkdp.a("GPUImageFilter", "error:" + i);
    }
    return i;
  }
  
  public int a()
  {
    return this.e;
  }
  
  public final void a()
  {
    b();
    this.jdField_a_of_type_Boolean = true;
    c();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    if (!a()) {
      a();
    }
    GLES20.glUseProgram(this.jdField_a_of_type_Int);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    g();
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.jdField_b_of_type_Int, 2, 5126, false, 0, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.jdField_b_of_type_Int);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.d);
    if (paramInt != -1)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt);
      GLES20.glUniform1i(this.c, 0);
    }
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.jdField_b_of_type_Int);
    GLES20.glDisableVertexAttribArray(this.d);
    GLES20.glBindTexture(3553, 0);
    c();
  }
  
  protected void a(Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.addLast(paramRunnable);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.f;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = niu.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    this.jdField_b_of_type_Int = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "position");
    this.c = GLES20.glGetUniformLocation(this.jdField_a_of_type_Int, "inputImageTexture");
    this.d = GLES20.glGetAttribLocation(this.jdField_a_of_type_Int, "inputTextureCoordinate");
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c() {}
  
  public final void d()
  {
    this.jdField_a_of_type_Boolean = false;
    GLES20.glDeleteProgram(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    e();
  }
  
  public void e() {}
  
  protected void f()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      return;
    }
  }
  
  protected void g()
  {
    while (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      ((Runnable)this.jdField_a_of_type_JavaUtilLinkedList.removeFirst()).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nig
 * JD-Core Version:    0.7.0.1
 */