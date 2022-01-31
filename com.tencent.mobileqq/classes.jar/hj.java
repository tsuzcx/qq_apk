import android.opengl.GLES20;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class hj
{
  public static int a(int paramInt, String paramString)
  {
    int i = GLES20.glCreateShader(paramInt);
    a("glCreateShader type=" + paramInt);
    GLES20.glShaderSource(i, paramString);
    GLES20.glCompileShader(i);
    paramString = new int[1];
    GLES20.glGetShaderiv(i, 35713, paramString, 0);
    if (paramString[0] == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GlUtil", 2, "Could not compile shader " + paramInt + ":" + GLES20.glGetShaderInfoLog(i));
      }
      GLES20.glDeleteShader(i);
      return 0;
    }
    return i;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    int i = a(35633, paramString1);
    if (i == 0) {}
    int j;
    do
    {
      return 0;
      j = a(35632, paramString2);
    } while (j == 0);
    int k = GLES20.glCreateProgram();
    a("glCreateProgram");
    if ((k == 0) && (QLog.isColorLevel())) {
      QLog.e("GlUtil", 2, "Could not create program");
    }
    GLES20.glAttachShader(k, i);
    a("glAttachShader");
    GLES20.glAttachShader(k, j);
    a("glAttachShader");
    GLES20.glLinkProgram(k);
    paramString1 = new int[1];
    GLES20.glGetProgramiv(k, 35714, paramString1, 0);
    if (paramString1[0] != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GlUtil", 2, "Could not link program:" + GLES20.glGetProgramInfoLog(k));
      }
      GLES20.glDeleteProgram(k);
      return 0;
    }
    return k;
  }
  
  public static FloatBuffer a(float[] paramArrayOfFloat)
  {
    Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramArrayOfFloat);
    ((FloatBuffer)localObject).position(0);
    return localObject;
  }
  
  public static void a(String paramString)
  {
    int i = GLES20.glGetError();
    if (i != 0)
    {
      paramString = paramString + ": glError 0x" + Integer.toHexString(i);
      if (QLog.isColorLevel()) {
        QLog.e("GlUtil", 2, paramString);
      }
      throw new RuntimeException(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     hj
 * JD-Core Version:    0.7.0.1
 */