import android.graphics.Rect;
import android.opengl.GLES20;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class lhf
{
  private static ThreadLocal<Class<lhf>> jdField_a_of_type_JavaLangThreadLocal = new ThreadLocal();
  private static WeakHashMap<lhf, Object> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  protected int a;
  protected lgc a;
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
  
  protected lhf()
  {
    this(null, 0);
  }
  
  protected lhf(lgc arg1, int paramInt)
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
        ((lhf)localIterator.next()).b();
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
        lhf locallhf = (lhf)localIterator.next();
        locallhf.b = 0;
        locallhf.a(null);
      }
    }
  }
  
  public static boolean d()
  {
    return jdField_a_of_type_JavaLangThreadLocal.get() != null;
  }
  
  private void e()
  {
    lgc locallgc = this.jdField_a_of_type_Lgc;
    if ((locallgc != null) && (this.jdField_a_of_type_ArrayOfInt != null))
    {
      locallgc.a(this);
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
    return lhb.a(this.jdField_a_of_type_Int);
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
  
  protected void a(lgc paramlgc)
  {
    this.jdField_a_of_type_Lgc = paramlgc;
  }
  
  public void a(lgc paramlgc, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramlgc.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public abstract boolean a(lgc paramlgc);
  
  public byte[] a()
  {
    return null;
  }
  
  public int[] a()
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public int[] a(lgc paramlgc)
  {
    return this.jdField_a_of_type_ArrayOfInt;
  }
  
  public lhd[] a(lgc paramlgc)
  {
    int k = 0;
    TextureProgram localTextureProgram = a();
    GLES20.glUseProgram(localTextureProgram.a());
    lie.a();
    if ((!b()) || (paramlgc.a() < 0.95F)) {}
    for (boolean bool = true;; bool = false)
    {
      lgd.a(bool);
      if (!a(paramlgc)) {
        break;
      }
      int[] arrayOfInt = a();
      while (k < arrayOfInt.length)
      {
        GLES20.glActiveTexture(33984 + k);
        lie.a();
        GLES20.glBindTexture(g(), arrayOfInt[k]);
        lie.a();
        GLES20.glUniform1i(localTextureProgram.a()[(k + 4)].jdField_a_of_type_Int, k);
        lie.a();
        k += 1;
      }
    }
    GLES20.glUniform1f(localTextureProgram.a()[2].jdField_a_of_type_Int, paramlgc.a());
    lie.a();
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
      jdField_a_of_type_JavaLangThreadLocal.set(lhf.class);
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
 * Qualified Name:     lhf
 * JD-Core Version:    0.7.0.1
 */