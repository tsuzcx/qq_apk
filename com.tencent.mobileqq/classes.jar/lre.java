import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class lre
{
  private static ThreadLocal<Class<lre>> jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  private static WeakHashMap<lre, Object> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  protected int a;
  protected lqb a;
  protected int[] a;
  protected int b;
  protected int c;
  protected int d;
  protected int e = -1;
  protected int f = -1;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  
  protected lre()
  {
    this(null, 0);
  }
  
  protected lre(lqb arg1, int paramInt)
  {
    a(???);
    this.b = paramInt;
    this.jdField_a_of_type_Int = 0;
    synchronized (jdField_a_of_type_JavaUtilWeakHashMap)
    {
      jdField_a_of_type_JavaUtilWeakHashMap.put(this, null);
      return;
    }
  }
  
  public static void c()
  {
    synchronized (jdField_a_of_type_JavaUtilWeakHashMap)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilWeakHashMap.keySet().iterator();
      if (localIterator.hasNext()) {
        ((lre)localIterator.next()).b();
      }
    }
  }
  
  public static void d()
  {
    synchronized (jdField_a_of_type_JavaUtilWeakHashMap)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilWeakHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        lre locallre = (lre)localIterator.next();
        locallre.b = 0;
        locallre.a(null);
      }
    }
  }
  
  public static boolean d()
  {
    return jdField_a_of_type_JavaLangThreadLocal.get() != null;
  }
  
  private void e()
  {
    lqb locallqb = this.jdField_a_of_type_Lqb;
    if ((locallqb != null) && (this.jdField_a_of_type_ArrayOfInt != null))
    {
      locallqb.a(this);
      this.jdField_a_of_type_ArrayOfInt = null;
    }
    this.b = 0;
    a(null);
  }
  
  public int a()
  {
    return this.i;
  }
  
  public Rect a()
  {
    return new Rect(this.c, this.d, this.c + this.e, this.d + this.f);
  }
  
  protected TextureProgram a()
  {
    return lra.a(this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    e();
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    if (((this.g > 4096) || (this.h > 4096)) && (QLog.isColorLevel())) {
      QLog.w("BasicTexture", 2, String.format("texture is too large: %d x %d", new Object[] { Integer.valueOf(this.g), Integer.valueOf(this.h) }), new Exception());
    }
    if (this.e == -1)
    {
      this.e = paramInt1;
      this.f = paramInt2;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
  }
  
  protected void a(lqb paramlqb)
  {
    this.jdField_a_of_type_Lqb = paramlqb;
  }
  
  public void a(lqb paramlqb, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramlqb.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public abstract boolean a(lqb paramlqb);
  
  public byte[] a()
  {
    return null;
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public int[] a(lqb paramlqb)
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public lrc[] a(lqb paramlqb)
  {
    int k = 0;
    TextureProgram localTextureProgram = a();
    GLES20.glUseProgram(localTextureProgram.a());
    lsd.a();
    if ((!b()) || (paramlqb.a() < 0.95F)) {}
    for (boolean bool = true;; bool = false)
    {
      lqc.a(bool);
      if (!a(paramlqb)) {
        break;
      }
      int[] arrayOfInt = a();
      while (k < arrayOfInt.length)
      {
        GLES20.glActiveTexture(33984 + k);
        lsd.a();
        GLES20.glBindTexture(g(), arrayOfInt[k]);
        lsd.a();
        GLES20.glUniform1i(localTextureProgram.a()[(k + 4)].jdField_a_of_type_Int, k);
        lsd.a();
        k += 1;
      }
    }
    GLES20.glUniform1f(localTextureProgram.a()[2].jdField_a_of_type_Int, paramlqb.a());
    lsd.a();
    return localTextureProgram.a();
  }
  
  public int b()
  {
    return this.j;
  }
  
  public void b()
  {
    e();
  }
  
  public void b(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public abstract boolean b();
  
  public byte[] b()
  {
    return null;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public boolean c()
  {
    return this.b == 1;
  }
  
  public int d()
  {
    return this.f;
  }
  
  public int e()
  {
    return this.g;
  }
  
  public int f()
  {
    return this.h;
  }
  
  protected void finalize()
  {
    try
    {
      jdField_a_of_type_JavaLangThreadLocal.set(lre.class);
      a();
      jdField_a_of_type_JavaLangThreadLocal.set(null);
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public abstract int g();
  
  public int h()
  {
    return 0;
  }
  
  public int i()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lre
 * JD-Core Version:    0.7.0.1
 */