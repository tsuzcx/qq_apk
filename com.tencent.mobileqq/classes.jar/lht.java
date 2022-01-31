import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class lht
  extends lhq
{
  protected TextureRender a;
  private ArrayList<lhq> jdField_a_of_type_JavaUtilArrayList;
  private Comparator<lhq> jdField_a_of_type_JavaUtilComparator = new lhv(this);
  protected TextureRender b;
  private lhq jdField_b_of_type_Lhq;
  private lhs jdField_b_of_type_Lhs = new lhu(this);
  protected boolean b;
  
  public lht(Context paramContext)
  {
    super(paramContext);
  }
  
  public lhq a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      throw new ArrayIndexOutOfBoundsException(paramInt);
    }
    return (lhq)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(lgc paramlgc)
  {
    paramlgc.a(b() / 2, c() / 2, 0.0F);
    c(paramlgc);
    paramlgc.a(-b() / 2, -c() / 2, 0.0F);
    e(paramlgc);
  }
  
  public void a(lgc paramlgc, lhq paramlhq)
  {
    if (!paramlhq.a()) {
      return;
    }
    int i = -this.e;
    int j = -this.d;
    paramlgc.a(i, j);
    paramlhq.a(paramlgc);
    paramlgc.a(-i, -j);
  }
  
  public void a(lhq paramlhq)
  {
    if (paramlhq.jdField_a_of_type_Lhq != null) {
      throw new IllegalStateException();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramlhq);
    paramlhq.jdField_a_of_type_Lhq = this;
    paramlhq.a(this.jdField_b_of_type_Lhs);
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilComparator);
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      paramlhq.b(this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView);
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, lhq paramlhq, boolean paramBoolean)
  {
    Rect localRect = paramlhq.jdField_a_of_type_AndroidGraphicsRect;
    if ((!paramBoolean) || (localRect.contains(paramInt1, paramInt2)))
    {
      if (paramlhq.b(paramMotionEvent)) {}
      while ((this.jdField_a_of_type_Lhr != null) && (this.jdField_a_of_type_Lhr.a(paramlhq, paramMotionEvent))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(lhq paramlhq)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    while (!this.jdField_a_of_type_JavaUtilArrayList.remove(paramlhq)) {
      return false;
    }
    if (this.jdField_b_of_type_Lhq == paramlhq)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      b(localMotionEvent);
      localMotionEvent.recycle();
    }
    paramlhq.d();
    paramlhq.jdField_a_of_type_Lhq = null;
    paramlhq.a(null);
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
    if (this.jdField_b_of_type_Lhq != null)
    {
      if (i == 0)
      {
        localObject = MotionEvent.obtain(paramMotionEvent);
        ((MotionEvent)localObject).setAction(3);
        a((MotionEvent)localObject, j, k, this.jdField_b_of_type_Lhq, false);
        this.jdField_b_of_type_Lhq = null;
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
      if (((lhq)localObject).a() == 0) {
        break label129;
      }
    }
    label129:
    while (!a(paramMotionEvent, j, k, (lhq)localObject, true))
    {
      i -= 1;
      break;
      a(paramMotionEvent, j, k, this.jdField_b_of_type_Lhq, false);
      if ((i == 3) || (i == 1)) {
        this.jdField_b_of_type_Lhq = null;
      }
      return true;
    }
    this.jdField_b_of_type_Lhq = ((lhq)localObject);
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
  
  protected void d(lgc paramlgc) {}
  
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
  
  protected void e(lgc paramlgc)
  {
    if ((this.jdField_b_of_type_Boolean) || (d())) {
      d(paramlgc);
    }
    for (;;)
    {
      return;
      int i = 0;
      int j = e();
      while (i < j)
      {
        a(paramlgc, a(i));
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
      lhq locallhq = a(i);
      if (locallhq.a() == 0) {
        locallhq.f(paramInt);
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
      lhq locallhq = (lhq)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_b_of_type_Lhq == locallhq)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        b(localMotionEvent);
        localMotionEvent.recycle();
      }
      locallhq.d();
      locallhq.jdField_a_of_type_Lhq = null;
      locallhq.a(null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lht
 * JD-Core Version:    0.7.0.1
 */