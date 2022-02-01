import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class lrs
  extends lrp
{
  protected TextureRender a;
  private ArrayList<lrp> jdField_a_of_type_JavaUtilArrayList;
  private Comparator<lrp> jdField_a_of_type_JavaUtilComparator = new lru(this);
  protected TextureRender b;
  private lrp jdField_b_of_type_Lrp;
  private lrr jdField_b_of_type_Lrr = new lrt(this);
  protected boolean b;
  
  public lrs(Context paramContext)
  {
    super(paramContext);
  }
  
  public lrp a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      throw new ArrayIndexOutOfBoundsException(paramInt);
    }
    return (lrp)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(lqb paramlqb)
  {
    paramlqb.a(b() / 2, c() / 2, 0.0F);
    c(paramlqb);
    paramlqb.a(-b() / 2, -c() / 2, 0.0F);
    e(paramlqb);
  }
  
  public void a(lqb paramlqb, lrp paramlrp)
  {
    if (!paramlrp.a()) {
      return;
    }
    int i = -this.e;
    int j = -this.d;
    paramlqb.a(i, j);
    paramlrp.a(paramlqb);
    paramlqb.a(-i, -j);
  }
  
  public void a(lrp paramlrp)
  {
    if (paramlrp.jdField_a_of_type_Lrp != null) {
      throw new IllegalStateException();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramlrp);
    paramlrp.jdField_a_of_type_Lrp = this;
    paramlrp.a(this.jdField_b_of_type_Lrr);
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilComparator);
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      paramlrp.b(this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView);
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, lrp paramlrp, boolean paramBoolean)
  {
    Rect localRect = paramlrp.jdField_a_of_type_AndroidGraphicsRect;
    if ((!paramBoolean) || (localRect.contains(paramInt1, paramInt2)))
    {
      if (paramlrp.b(paramMotionEvent)) {}
      while ((this.jdField_a_of_type_Lrq != null) && (this.jdField_a_of_type_Lrq.a(paramlrp, paramMotionEvent))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(lrp paramlrp)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    while (!this.jdField_a_of_type_JavaUtilArrayList.remove(paramlrp)) {
      return false;
    }
    if (this.jdField_b_of_type_Lrp == paramlrp)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      b(localMotionEvent);
      localMotionEvent.recycle();
    }
    paramlrp.d();
    paramlrp.jdField_a_of_type_Lrp = null;
    paramlrp.a(null);
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
    if (this.jdField_b_of_type_Lrp != null)
    {
      if (i == 0)
      {
        localObject = MotionEvent.obtain(paramMotionEvent);
        ((MotionEvent)localObject).setAction(3);
        a((MotionEvent)localObject, j, k, this.jdField_b_of_type_Lrp, false);
        this.jdField_b_of_type_Lrp = null;
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
      if (((lrp)localObject).a() == 0) {
        break label129;
      }
    }
    label129:
    while (!a(paramMotionEvent, j, k, (lrp)localObject, true))
    {
      i -= 1;
      break;
      a(paramMotionEvent, j, k, this.jdField_b_of_type_Lrp, false);
      if ((i == 3) || (i == 1)) {
        this.jdField_b_of_type_Lrp = null;
      }
      return true;
    }
    this.jdField_b_of_type_Lrp = ((lrp)localObject);
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
  
  protected void d(lqb paramlqb) {}
  
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
  
  protected void e(lqb paramlqb)
  {
    if ((this.jdField_b_of_type_Boolean) || (d())) {
      d(paramlqb);
    }
    for (;;)
    {
      return;
      int i = 0;
      int j = e();
      while (i < j)
      {
        a(paramlqb, a(i));
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
      lrp locallrp = a(i);
      if (locallrp.a() == 0) {
        locallrp.f(paramInt);
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
      lrp locallrp = (lrp)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_b_of_type_Lrp == locallrp)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        b(localMotionEvent);
        localMotionEvent.recycle();
      }
      locallrp.d();
      locallrp.jdField_a_of_type_Lrp = null;
      locallrp.a(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lrs
 * JD-Core Version:    0.7.0.1
 */