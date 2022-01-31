import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class lrr
{
  private static ThreadLocal<Class<lrr>> jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  private static WeakHashMap<lrr, Object> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  protected int a;
  protected lqo a;
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
  
  protected lrr()
  {
    this(null, 0);
  }
  
  protected lrr(lqo arg1, int paramInt)
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
        ((lrr)localIterator.next()).b();
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
        lrr locallrr = (lrr)localIterator.next();
        locallrr.b = 0;
        locallrr.a(null);
      }
    }
  }
  
  public static boolean d()
  {
    return jdField_a_of_type_JavaLangThreadLocal.get() != null;
  }
  
  private void e()
  {
    lqo locallqo = this.jdField_a_of_type_Lqo;
    if ((locallqo != null) && (this.jdField_a_of_type_ArrayOfInt != null))
    {
      locallqo.a(this);
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
    return lrn.a(this.jdField_a_of_type_Int);
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
  
  protected void a(lqo paramlqo)
  {
    this.jdField_a_of_type_Lqo = paramlqo;
  }
  
  public void a(lqo paramlqo, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramlqo.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public abstract boolean a(lqo paramlqo);
  
  public byte[] a()
  {
    return null;
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public int[] a(lqo paramlqo)
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public lrp[] a(lqo paramlqo)
  {
    int k = 0;
    TextureProgram localTextureProgram = a();
    GLES20.glUseProgram(localTextureProgram.a());
    lsq.a();
    if ((!b()) || (paramlqo.a() < 0.95F)) {}
    for (boolean bool = true;; bool = false)
    {
      lqp.a(bool);
      if (!a(paramlqo)) {
        break;
      }
      int[] arrayOfInt = a();
      while (k < arrayOfInt.length)
      {
        GLES20.glActiveTexture(33984 + k);
        lsq.a();
        GLES20.glBindTexture(g(), arrayOfInt[k]);
        lsq.a();
        GLES20.glUniform1i(localTextureProgram.a()[(k + 4)].jdField_a_of_type_Int, k);
        lsq.a();
        k += 1;
      }
    }
    GLES20.glUniform1f(localTextureProgram.a()[2].jdField_a_of_type_Int, paramlqo.a());
    lsq.a();
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
      jdField_a_of_type_JavaLangThreadLocal.set(lrr.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lrr
 * JD-Core Version:    0.7.0.1
 */