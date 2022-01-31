import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.animation.Animation;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class lsc
{
  protected float a;
  protected int a;
  protected final Rect a;
  private SparseArray<Object> a;
  protected Animation a;
  protected GLRootView a;
  protected RenderBuffer a;
  protected Object a;
  protected WeakReference<Context> a;
  protected List<lsn> a;
  protected lrr a;
  protected lsc a;
  protected lsd a;
  protected lse a;
  protected med a;
  protected boolean a;
  protected float b;
  protected int b;
  protected final Rect b;
  protected lrr b;
  protected float c;
  protected int c;
  protected final Rect c;
  protected float d;
  protected int d;
  protected float e = 1.0F;
  protected int e;
  protected float f;
  protected int f;
  protected float g;
  protected int g;
  protected int h;
  
  public lsc(Context paramContext)
  {
    this.jdField_a_of_type_Med = new med();
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
    this.jdField_c_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_g_of_type_Int = -16777216;
    this.jdField_f_of_type_Float = 1.0F;
    this.jdField_g_of_type_Float = 1.0F;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_Int & 0x1) == 0) {
      return 0;
    }
    return 1;
  }
  
  public Rect a()
  {
    return this.jdField_c_of_type_AndroidGraphicsRect;
  }
  
  public GLRootView a()
  {
    return this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public Object a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    }
    return null;
  }
  
  public List<lsn> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public med a(lqo paramlqo)
  {
    return null;
  }
  
  public void a()
  {
    d();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == a()) {
      return;
    }
    if (paramInt == 0) {}
    for (this.jdField_a_of_type_Int &= 0xFFFFFFFE;; this.jdField_a_of_type_Int |= 0x1)
    {
      f(paramInt);
      b();
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_c_of_type_AndroidGraphicsRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramObject);
  }
  
  public void a(long paramLong)
  {
    label101:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          b();
          int i = 0;
          int j = this.jdField_a_of_type_JavaUtilList.size();
          if (i < j) {
            try
            {
              boolean bool = ((lsn)this.jdField_a_of_type_JavaUtilList.get(i)).a(paramLong);
              if (!bool) {
                break label101;
              }
              i -= 1;
              i += 1;
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              break label101;
            }
          }
        }
        return;
      }
    }
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Lrr != null)
    {
      this.jdField_a_of_type_Lrr.a();
      this.jdField_a_of_type_Lrr = null;
    }
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_Lrr = new lrs(paramBitmap);
      this.jdField_f_of_type_Int = 0;
    }
  }
  
  public void a(GLRootView paramGLRootView)
  {
    b(paramGLRootView);
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void a(Runnable paramRunnable)
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.post(paramRunnable);
    }
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.postDelayed(paramRunnable, paramLong);
    }
  }
  
  public void a(lqo paramlqo)
  {
    a(System.currentTimeMillis());
    int i = this.jdField_a_of_type_AndroidGraphicsRect.left;
    int j = this.jdField_a_of_type_AndroidGraphicsRect.top;
    paramlqo.b();
    lsn locallsn = null;
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      locallsn = (lsn)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    if ((locallsn != null) && (locallsn.a()))
    {
      paramlqo.a(locallsn.a(), locallsn.b(), locallsn.c());
      float f1 = this.e;
      f1 = this.jdField_f_of_type_Float;
      f1 = this.jdField_g_of_type_Float;
      if ((locallsn != null) && (locallsn.b()))
      {
        f1 = locallsn.d();
        float f2 = locallsn.e();
        a(i, j, (int)(f1 + i), (int)(f2 + j));
      }
      paramlqo.a(b() / 2, c() / 2, 0.0F);
      if ((locallsn == null) || (!locallsn.c())) {
        break label268;
      }
      paramlqo.a(locallsn.f(), 1.0F, 0.0F, 0.0F);
      paramlqo.a(locallsn.g(), 0.0F, 1.0F, 0.0F);
      paramlqo.a(locallsn.h(), 0.0F, 0.0F, 1.0F);
    }
    for (;;)
    {
      c(paramlqo);
      b(paramlqo);
      paramlqo.c();
      return;
      paramlqo.a(i, j, this.jdField_a_of_type_Float);
      break;
      label268:
      if (this.jdField_b_of_type_Float != 0.0F) {
        paramlqo.a(this.jdField_b_of_type_Float, 1.0F, 0.0F, 0.0F);
      }
      if (this.jdField_c_of_type_Float != 0.0F) {
        paramlqo.a(this.jdField_c_of_type_Float, 0.0F, 1.0F, 0.0F);
      }
      if (this.d != 0.0F) {
        paramlqo.a(this.d, 0.0F, 0.0F, 1.0F);
      }
    }
  }
  
  public void a(lrs paramlrs)
  {
    if (this.jdField_a_of_type_Lrr != null)
    {
      this.jdField_a_of_type_Lrr.a();
      this.jdField_a_of_type_Lrr = null;
    }
    if (paramlrs != null)
    {
      this.jdField_a_of_type_Lrr = paramlrs;
      this.jdField_f_of_type_Int = 0;
    }
  }
  
  public void a(lsd paramlsd)
  {
    this.jdField_a_of_type_Lsd = paramlsd;
  }
  
  protected void a(lse paramlse)
  {
    this.jdField_a_of_type_Lse = paramlse;
  }
  
  public void a(lsn paramlsn)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (paramlsn != null) {}
    try
    {
      paramlsn.a(this);
      paramlsn.a();
      this.jdField_a_of_type_JavaUtilList.add(paramlsn);
      b();
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public boolean a()
  {
    return (a() == 0) || (this.jdField_a_of_type_AndroidViewAnimationAnimation != null);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 - paramInt1 != this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.left) || (paramInt4 - paramInt2 != this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_AndroidGraphicsRect.set(paramInt1, paramInt2, paramInt3, paramInt4);
      return bool;
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_AndroidGraphicsRect.left;
  }
  
  public Rect b()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  public void b()
  {
    GLRootView localGLRootView = a();
    if (localGLRootView != null) {
      localGLRootView.requestRender();
    }
  }
  
  public void b(int paramInt) {}
  
  @SuppressLint({"WrongCall"})
  public void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int &= 0xFFFFFFFB;
    a(bool, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void b(GLRootView paramGLRootView)
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = paramGLRootView;
  }
  
  protected void b(lqo paramlqo)
  {
    if (this.jdField_b_of_type_Lrr == null) {
      return;
    }
    int i = b();
    int j = c();
    Rect localRect = a();
    int k = localRect.left;
    int m = localRect.right;
    int n = localRect.top;
    int i1 = localRect.bottom;
    int i2 = localRect.left;
    int i3 = localRect.top;
    paramlqo.a(2);
    this.jdField_b_of_type_Lrr.a(paramlqo, i2, i3, i - k - m, j - n - i1);
    paramlqo.c();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if ((a() == 0) && (this.jdField_a_of_type_Lsd != null) && (this.jdField_a_of_type_Lsd.a(this, paramMotionEvent))) {
      return true;
    }
    return a(paramMotionEvent);
  }
  
  public int c()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_AndroidGraphicsRect.top;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int |= 0x4;
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    if (this.jdField_a_of_type_Lsc != null) {
      this.jdField_a_of_type_Lsc.c();
    }
    GLRootView localGLRootView;
    do
    {
      return;
      localGLRootView = a();
    } while (localGLRootView == null);
    localGLRootView.a();
  }
  
  public void c(int paramInt)
  {
    if (this.h != paramInt)
    {
      int i = this.h;
      this.h = paramInt;
      if (this.jdField_a_of_type_Lse != null) {
        this.jdField_a_of_type_Lse.a(this, paramInt, i);
      }
    }
  }
  
  protected void c(lqo paramlqo)
  {
    if (this.jdField_a_of_type_Lrr != null)
    {
      i = b();
      j = c();
      this.jdField_a_of_type_Lrr.a(paramlqo, 0, 0, i, j);
      return;
    }
    int i = b();
    int j = c();
    paramlqo.a(0.0F, 0.0F, i, j, this.jdField_g_of_type_Int);
  }
  
  public boolean c()
  {
    return false;
  }
  
  public int d()
  {
    return this.h;
  }
  
  protected void d()
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = null;
  }
  
  public void d(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public void e() {}
  
  public void e(int paramInt)
  {
    lrv locallrv = null;
    if ((paramInt != 0) && (paramInt == this.jdField_f_of_type_Int)) {
      return;
    }
    Object localObject = a();
    if (localObject == null) {
      throw new RuntimeException("Cannot set resource background before attach to GLRootView!");
    }
    if (this.jdField_a_of_type_Lrr != null)
    {
      this.jdField_a_of_type_Lrr.a();
      this.jdField_a_of_type_Lrr = null;
    }
    localObject = ((GLRootView)localObject).getContext();
    if (paramInt == 0) {}
    for (;;)
    {
      this.jdField_a_of_type_Lrr = locallrv;
      this.jdField_f_of_type_Int = paramInt;
      return;
      locallrv = new lrv((Context)localObject, paramInt);
    }
  }
  
  protected void f() {}
  
  protected void f(int paramInt) {}
  
  protected void finalize()
  {
    try
    {
      if (this.jdField_b_of_type_Lrr != null)
      {
        this.jdField_b_of_type_Lrr.a();
        this.jdField_b_of_type_Lrr = null;
      }
      if (this.jdField_a_of_type_Lrr != null)
      {
        this.jdField_a_of_type_Lrr.a();
        this.jdField_a_of_type_Lrr = null;
        this.jdField_f_of_type_Int = 0;
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  protected void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lsc
 * JD-Core Version:    0.7.0.1
 */