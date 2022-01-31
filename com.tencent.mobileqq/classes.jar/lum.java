import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class lum
  extends luj
{
  protected TextureRender a;
  private ArrayList<luj> jdField_a_of_type_JavaUtilArrayList;
  private Comparator<luj> jdField_a_of_type_JavaUtilComparator = new luo(this);
  protected TextureRender b;
  private luj jdField_b_of_type_Luj;
  private lul jdField_b_of_type_Lul = new lun(this);
  protected boolean b;
  
  public lum(Context paramContext)
  {
    super(paramContext);
  }
  
  public luj a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      throw new ArrayIndexOutOfBoundsException(paramInt);
    }
    return (luj)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(lsv paramlsv)
  {
    paramlsv.a(b() / 2, c() / 2, 0.0F);
    c(paramlsv);
    paramlsv.a(-b() / 2, -c() / 2, 0.0F);
    e(paramlsv);
  }
  
  public void a(lsv paramlsv, luj paramluj)
  {
    if (!paramluj.a()) {
      return;
    }
    int i = -this.e;
    int j = -this.d;
    paramlsv.a(i, j);
    paramluj.a(paramlsv);
    paramlsv.a(-i, -j);
  }
  
  public void a(luj paramluj)
  {
    if (paramluj.jdField_a_of_type_Luj != null) {
      throw new IllegalStateException();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramluj);
    paramluj.jdField_a_of_type_Luj = this;
    paramluj.a(this.jdField_b_of_type_Lul);
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilComparator);
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      paramluj.b(this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView);
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, luj paramluj, boolean paramBoolean)
  {
    Rect localRect = paramluj.jdField_a_of_type_AndroidGraphicsRect;
    if ((!paramBoolean) || (localRect.contains(paramInt1, paramInt2)))
    {
      if (paramluj.b(paramMotionEvent)) {}
      while ((this.jdField_a_of_type_Luk != null) && (this.jdField_a_of_type_Luk.a(paramluj, paramMotionEvent))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(luj paramluj)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    while (!this.jdField_a_of_type_JavaUtilArrayList.remove(paramluj)) {
      return false;
    }
    if (this.jdField_b_of_type_Luj == paramluj)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      b(localMotionEvent);
      localMotionEvent.recycle();
    }
    paramluj.d();
    paramluj.jdField_a_of_type_Luj = null;
    paramluj.a(null);
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilComparator);
    return true;
  }
  
  protected void b(GLRootView paramGLRootView)
  {
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = paramGLRootView;
    int i = 0;
    int j = e();
    while (i < j)
    {
      a(i).b(paramGLRootView);
      i += 1;
    }
  }
  
  protected void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  protected boolean b(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    int i = paramMotionEvent.getAction();
    Object localObject;
    if (this.jdField_b_of_type_Luj != null)
    {
      if (i == 0)
      {
        localObject = MotionEvent.obtain(paramMotionEvent);
        ((MotionEvent)localObject).setAction(3);
        a((MotionEvent)localObject, j, k, this.jdField_b_of_type_Luj, false);
        this.jdField_b_of_type_Luj = null;
      }
    }
    else
    {
      if (i != 0) {
        break label151;
      }
      i = e() - 1;
      if (i < 0) {
        break label151;
      }
      localObject = a(i);
      if (((luj)localObject).a() == 0) {
        break label129;
      }
    }
    label129:
    while (!a(paramMotionEvent, j, k, (luj)localObject, true))
    {
      i -= 1;
      break;
      a(paramMotionEvent, j, k, this.jdField_b_of_type_Luj, false);
      if ((i == 3) || (i == 1)) {
        this.jdField_b_of_type_Luj = null;
      }
      return true;
    }
    this.jdField_b_of_type_Luj = ((luj)localObject);
    return true;
    label151:
    return super.b(paramMotionEvent);
  }
  
  protected void d()
  {
    int i = 0;
    int j = e();
    while (i < j)
    {
      a(i).d();
      i += 1;
    }
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = null;
  }
  
  protected void d(lsv paramlsv) {}
  
  protected boolean d()
  {
    return false;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  protected void e()
  {
    int i = 0;
    int j = e();
    while (i < j)
    {
      a(i).e();
      i += 1;
    }
  }
  
  protected void e(lsv paramlsv)
  {
    if ((this.jdField_b_of_type_Boolean) || (d())) {
      d(paramlsv);
    }
    for (;;)
    {
      return;
      int i = 0;
      int j = e();
      while (i < j)
      {
        a(paramlsv, a(i));
        i += 1;
      }
    }
  }
  
  protected void f(int paramInt)
  {
    int i = 0;
    int j = e();
    while (i < j)
    {
      luj localluj = a(i);
      if (localluj.a() == 0) {
        localluj.f(paramInt);
      }
      i += 1;
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilComparator);
    }
  }
  
  public void i()
  {
    int j = e();
    int i = 0;
    while (i < j)
    {
      luj localluj = (luj)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_b_of_type_Luj == localluj)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        b(localMotionEvent);
        localMotionEvent.recycle();
      }
      localluj.d();
      localluj.jdField_a_of_type_Luj = null;
      localluj.a(null);
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void j()
  {
    f();
    int i = 0;
    int j = e();
    while (i < j)
    {
      a(i).f();
      i += 1;
    }
  }
  
  public void k()
  {
    g();
    int i = 0;
    int j = e();
    while (i < j)
    {
      a(i).g();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lum
 * JD-Core Version:    0.7.0.1
 */