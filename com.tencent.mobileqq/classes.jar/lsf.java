import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class lsf
  extends lsc
{
  protected TextureRender a;
  private ArrayList<lsc> jdField_a_of_type_JavaUtilArrayList;
  private Comparator<lsc> jdField_a_of_type_JavaUtilComparator = new lsh(this);
  protected TextureRender b;
  private lsc jdField_b_of_type_Lsc;
  private lse jdField_b_of_type_Lse = new lsg(this);
  protected boolean b;
  
  public lsf(Context paramContext)
  {
    super(paramContext);
  }
  
  public lsc a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      throw new ArrayIndexOutOfBoundsException(paramInt);
    }
    return (lsc)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(lqo paramlqo)
  {
    paramlqo.a(b() / 2, c() / 2, 0.0F);
    c(paramlqo);
    paramlqo.a(-b() / 2, -c() / 2, 0.0F);
    e(paramlqo);
  }
  
  public void a(lqo paramlqo, lsc paramlsc)
  {
    if (!paramlsc.a()) {
      return;
    }
    int i = -this.e;
    int j = -this.d;
    paramlqo.a(i, j);
    paramlsc.a(paramlqo);
    paramlqo.a(-i, -j);
  }
  
  public void a(lsc paramlsc)
  {
    if (paramlsc.jdField_a_of_type_Lsc != null) {
      throw new IllegalStateException();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramlsc);
    paramlsc.jdField_a_of_type_Lsc = this;
    paramlsc.a(this.jdField_b_of_type_Lse);
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilComparator);
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      paramlsc.b(this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView);
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, lsc paramlsc, boolean paramBoolean)
  {
    Rect localRect = paramlsc.jdField_a_of_type_AndroidGraphicsRect;
    if ((!paramBoolean) || (localRect.contains(paramInt1, paramInt2)))
    {
      if (paramlsc.b(paramMotionEvent)) {}
      while ((this.jdField_a_of_type_Lsd != null) && (this.jdField_a_of_type_Lsd.a(paramlsc, paramMotionEvent))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(lsc paramlsc)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    while (!this.jdField_a_of_type_JavaUtilArrayList.remove(paramlsc)) {
      return false;
    }
    if (this.jdField_b_of_type_Lsc == paramlsc)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      b(localMotionEvent);
      localMotionEvent.recycle();
    }
    paramlsc.d();
    paramlsc.jdField_a_of_type_Lsc = null;
    paramlsc.a(null);
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilComparator);
    return true;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
    int i = 0;
    int j = e();
    while (i < j)
    {
      a(i).a(paramInt1, paramInt2);
      i += 1;
    }
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
    if (this.jdField_b_of_type_Lsc != null)
    {
      if (i == 0)
      {
        localObject = MotionEvent.obtain(paramMotionEvent);
        ((MotionEvent)localObject).setAction(3);
        a((MotionEvent)localObject, j, k, this.jdField_b_of_type_Lsc, false);
        this.jdField_b_of_type_Lsc = null;
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
      if (((lsc)localObject).a() == 0) {
        break label129;
      }
    }
    label129:
    while (!a(paramMotionEvent, j, k, (lsc)localObject, true))
    {
      i -= 1;
      break;
      a(paramMotionEvent, j, k, this.jdField_b_of_type_Lsc, false);
      if ((i == 3) || (i == 1)) {
        this.jdField_b_of_type_Lsc = null;
      }
      return true;
    }
    this.jdField_b_of_type_Lsc = ((lsc)localObject);
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
  
  protected void d(lqo paramlqo) {}
  
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
  
  protected void e(lqo paramlqo)
  {
    if ((this.jdField_b_of_type_Boolean) || (d())) {
      d(paramlqo);
    }
    for (;;)
    {
      return;
      int i = 0;
      int j = e();
      while (i < j)
      {
        a(paramlqo, a(i));
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
      lsc locallsc = a(i);
      if (locallsc.a() == 0) {
        locallsc.f(paramInt);
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
      lsc locallsc = (lsc)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_b_of_type_Lsc == locallsc)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        b(localMotionEvent);
        localMotionEvent.recycle();
      }
      locallsc.d();
      locallsc.jdField_a_of_type_Lsc = null;
      locallsc.a(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lsf
 * JD-Core Version:    0.7.0.1
 */