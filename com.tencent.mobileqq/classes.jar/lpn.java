import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class lpn
{
  protected int a;
  public final String a;
  protected FloatBuffer a;
  private float[] a;
  protected int b;
  private final String jdField_b_of_type_JavaLangString = "precision highp float;\nprecision highp int;\n\nvarying vec2 vTextureCo;\nuniform sampler2D uTexture;\n\nuniform float uWidth;\nuniform float uHeight;\n\nfloat cY(float x,float y){\n    vec4 c=texture2D(uTexture,vec2(x,y));\n    return c.r*0.257+c.g*0.504+c.b*0.098+0.0625;\n}\n\nvec4 cC(float x,float y,float dx,float dy){\n    vec4 c0=texture2D(uTexture,vec2(x,y));\n    vec4 c1=texture2D(uTexture,vec2(x+dx,y));\n    vec4 c2=texture2D(uTexture,vec2(x,y+dy));\n    vec4 c3=texture2D(uTexture,vec2(x+dx,y+dy));\n    return (c0+c1+c2+c3)/4.;\n}\n\nfloat cU(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return -0.148*c.r - 0.291*c.g + 0.439*c.b+0.5000;\n}\n\nfloat cV(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return 0.439*c.r - 0.368*c.g - 0.071*c.b+0.5000;\n}\n\nvec2 cPos(float t,float shiftx,float gy){\n    vec2 pos=vec2(floor(uWidth*vTextureCo.x),floor(uHeight*gy));\n    return vec2(mod(pos.x*shiftx,uWidth),(pos.y*shiftx+floor(pos.x*shiftx/uWidth))*t);\n}\n\nvec4 calculateY(){\n    vec2 pos=cPos(1.,4.,vTextureCo.y);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cY(pos.x/uWidth,textureYPos);\n    oColor[1]=cY((pos.x+1.)/uWidth,textureYPos);\n    oColor[2]=cY((pos.x+2.)/uWidth,textureYPos);\n    oColor[3]=cY((pos.x+3.)/uWidth,textureYPos);\n    return oColor;\n}\nvec4 calculateU(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateV(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]=cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]=cV((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]=cV((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateUV(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateVU(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvoid main() {\n    if(vTextureCo.y<0.2500){\n        gl_FragColor=calculateY();\n    }else if(vTextureCo.y<0.3125){\n        gl_FragColor=calculateU(0.2500,1./uWidth,1./uHeight);\n    }else if(vTextureCo.y<0.3750){\n        gl_FragColor=calculateV(0.3125,1./uWidth,1./uHeight);\n    }else{\n        gl_FragColor=vec4(0,0,0,0);\n    }\n}";
  protected FloatBuffer b;
  private float[] jdField_b_of_type_ArrayOfFloat = { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
  protected int c;
  private String c;
  protected int d;
  private String d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  private int i;
  private int j;
  
  public lpn()
  {
    this.jdField_a_of_type_JavaLangString = "attribute vec4 aVertexCo;\nattribute vec2 aTextureCo;\n\nuniform mat4 uVertexMatrix;\nuniform mat4 uTextureMatrix;\n\nvarying vec2 vTextureCo;\n\nvoid main(){\n    gl_Position = uVertexMatrix*aVertexCo;\n    vTextureCo = (uTextureMatrix*vec4(aTextureCo,0,1)).xy;\n}";
    this.jdField_a_of_type_ArrayOfFloat = new float[] { 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F };
    this.jdField_c_of_type_JavaLangString = "attribute vec4 aVertexCo;\nattribute vec2 aTextureCo;\n\nuniform mat4 uVertexMatrix;\nuniform mat4 uTextureMatrix;\n\nvarying vec2 vTextureCo;\n\nvoid main(){\n    gl_Position = uVertexMatrix*aVertexCo;\n    vTextureCo = (uTextureMatrix*vec4(aTextureCo,0,1)).xy;\n}";
    this.jdField_d_of_type_JavaLangString = "precision highp float;\nprecision highp int;\n\nvarying vec2 vTextureCo;\nuniform sampler2D uTexture;\n\nuniform float uWidth;\nuniform float uHeight;\n\nfloat cY(float x,float y){\n    vec4 c=texture2D(uTexture,vec2(x,y));\n    return c.r*0.257+c.g*0.504+c.b*0.098+0.0625;\n}\n\nvec4 cC(float x,float y,float dx,float dy){\n    vec4 c0=texture2D(uTexture,vec2(x,y));\n    vec4 c1=texture2D(uTexture,vec2(x+dx,y));\n    vec4 c2=texture2D(uTexture,vec2(x,y+dy));\n    vec4 c3=texture2D(uTexture,vec2(x+dx,y+dy));\n    return (c0+c1+c2+c3)/4.;\n}\n\nfloat cU(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return -0.148*c.r - 0.291*c.g + 0.439*c.b+0.5000;\n}\n\nfloat cV(float x,float y,float dx,float dy){\n    vec4 c=cC(x,y,dx,dy);\n    return 0.439*c.r - 0.368*c.g - 0.071*c.b+0.5000;\n}\n\nvec2 cPos(float t,float shiftx,float gy){\n    vec2 pos=vec2(floor(uWidth*vTextureCo.x),floor(uHeight*gy));\n    return vec2(mod(pos.x*shiftx,uWidth),(pos.y*shiftx+floor(pos.x*shiftx/uWidth))*t);\n}\n\nvec4 calculateY(){\n    vec2 pos=cPos(1.,4.,vTextureCo.y);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cY(pos.x/uWidth,textureYPos);\n    oColor[1]=cY((pos.x+1.)/uWidth,textureYPos);\n    oColor[2]=cY((pos.x+2.)/uWidth,textureYPos);\n    oColor[3]=cY((pos.x+3.)/uWidth,textureYPos);\n    return oColor;\n}\nvec4 calculateU(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateV(float gy,float dx,float dy){\n    vec2 pos=cPos(2.,8.,vTextureCo.y-gy);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]=cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]=cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[2]=cV((pos.x+4.)/uWidth,textureYPos,dx,dy);\n    oColor[3]=cV((pos.x+6.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateUV(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvec4 calculateVU(float dx,float dy){\n    vec2 pos=cPos(2.,4.,vTextureCo.y-0.2500);\n    vec4 oColor=vec4(0);\n    float textureYPos=pos.y/uHeight;\n    oColor[0]= cV(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[1]= cU(pos.x/uWidth,textureYPos,dx,dy);\n    oColor[2]= cV((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    oColor[3]= cU((pos.x+2.)/uWidth,textureYPos,dx,dy);\n    return oColor;\n}\nvoid main() {\n    if(vTextureCo.y<0.2500){\n        gl_FragColor=calculateY();\n    }else if(vTextureCo.y<0.3125){\n        gl_FragColor=calculateU(0.2500,1./uWidth,1./uHeight);\n    }else if(vTextureCo.y<0.3750){\n        gl_FragColor=calculateV(0.3125,1./uWidth,1./uHeight);\n    }else{\n        gl_FragColor=vec4(0,0,0,0);\n    }\n}";
    a();
  }
  
  public static int a(int paramInt, String paramString)
  {
    if (paramString == null)
    {
      a(1, "Shader source ==null : shaderType =" + paramInt);
      return 0;
    }
    int k = GLES20.glCreateShader(paramInt);
    if (k != 0)
    {
      GLES20.glShaderSource(k, paramString);
      GLES20.glCompileShader(k);
      paramString = new int[1];
      GLES20.glGetShaderiv(k, 35713, paramString, 0);
      if (paramString[0] == 0)
      {
        a(1, "Could not compile shader:" + paramInt);
        a(1, "GLES20 Error:" + GLES20.glGetShaderInfoLog(k));
        GLES20.glDeleteShader(k);
        return 0;
      }
    }
    return k;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int k = a(35633, paramString1);
    if (k == 0) {}
    int m;
    do
    {
      return 0;
      m = a(35632, paramString2);
    } while (m == 0);
    int n = GLES20.glCreateProgram();
    if (n != 0)
    {
      GLES20.glAttachShader(n, k);
      GLES20.glAttachShader(n, m);
      GLES20.glLinkProgram(n);
      paramString1 = new int[1];
      GLES20.glGetProgramiv(n, 35714, paramString1, 0);
      if (paramString1[0] != 1)
      {
        a(1, "Could not link program:" + GLES20.glGetProgramInfoLog(n));
        GLES20.glDeleteProgram(n);
        return 0;
      }
    }
    return n;
  }
  
  private static void a(int paramInt, Object paramObject)
  {
    QLog.e("RGBToI420Filter", 1, "glError:" + paramInt + "---" + paramObject);
  }
  
  protected void a()
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(32);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.put(new float[] { -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, -1.0F, 1.0F, 1.0F });
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
    localByteBuffer = ByteBuffer.allocateDirect(32);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_b_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_b_of_type_JavaNioFloatBuffer.put(new float[] { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F });
    this.jdField_b_of_type_JavaNioFloatBuffer.position(0);
  }
  
  public void a(int paramInt)
  {
    f();
    d();
    g();
    b(paramInt);
    e();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void b()
  {
    this.jdField_c_of_type_Int = a(this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString);
    this.jdField_d_of_type_Int = GLES20.glGetAttribLocation(this.jdField_c_of_type_Int, "aVertexCo");
    this.e = GLES20.glGetAttribLocation(this.jdField_c_of_type_Int, "aTextureCo");
    this.f = GLES20.glGetUniformLocation(this.jdField_c_of_type_Int, "uVertexMatrix");
    this.g = GLES20.glGetUniformLocation(this.jdField_c_of_type_Int, "uTextureMatrix");
    this.h = GLES20.glGetUniformLocation(this.jdField_c_of_type_Int, "uTexture");
    this.i = GLES20.glGetUniformLocation(this.jdField_c_of_type_Int, "uWidth");
    this.j = GLES20.glGetUniformLocation(this.jdField_c_of_type_Int, "uHeight");
  }
  
  protected void b(int paramInt)
  {
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt);
    GLES20.glUniform1i(this.h, 0);
  }
  
  public void c()
  {
    GLES20.glDeleteProgram(this.jdField_c_of_type_Int);
  }
  
  protected void d()
  {
    GLES20.glUseProgram(this.jdField_c_of_type_Int);
  }
  
  protected void e()
  {
    GLES20.glEnableVertexAttribArray(this.jdField_d_of_type_Int);
    GLES20.glVertexAttribPointer(this.jdField_d_of_type_Int, 2, 5126, false, 0, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glEnableVertexAttribArray(this.e);
    GLES20.glVertexAttribPointer(this.e, 2, 5126, false, 0, this.jdField_b_of_type_JavaNioFloatBuffer);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.jdField_d_of_type_Int);
    GLES20.glDisableVertexAttribArray(this.e);
  }
  
  protected void f()
  {
    GLES20.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
    GLES20.glClear(16640);
  }
  
  protected void g()
  {
    GLES20.glUniformMatrix4fv(this.f, 1, false, this.jdField_a_of_type_ArrayOfFloat, 0);
    GLES20.glUniformMatrix4fv(this.g, 1, false, this.jdField_b_of_type_ArrayOfFloat, 0);
    GLES20.glUniform1f(this.i, this.jdField_a_of_type_Int);
    GLES20.glUniform1f(this.j, this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpn
 * JD-Core Version:    0.7.0.1
 */