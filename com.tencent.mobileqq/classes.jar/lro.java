import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class lro
  extends lrl
{
  protected TextureRender a;
  private ArrayList<lrl> jdField_a_of_type_JavaUtilArrayList;
  private Comparator<lrl> jdField_a_of_type_JavaUtilComparator = new lrq(this);
  protected TextureRender b;
  private lrl jdField_b_of_type_Lrl;
  private lrn jdField_b_of_type_Lrn = new lrp(this);
  protected boolean b;
  
  public lro(Context paramContext)
  {
    super(paramContext);
  }
  
  public lrl a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      throw new ArrayIndexOutOfBoundsException(paramInt);
    }
    return (lrl)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(lpx paramlpx)
  {
    paramlpx.a(b() / 2, c() / 2, 0.0F);
    c(paramlpx);
    paramlpx.a(-b() / 2, -c() / 2, 0.0F);
    e(paramlpx);
  }
  
  public void a(lpx paramlpx, lrl paramlrl)
  {
    if (!paramlrl.a()) {
      return;
    }
    int i = -this.e;
    int j = -this.d;
    paramlpx.a(i, j);
    paramlrl.a(paramlpx);
    paramlpx.a(-i, -j);
  }
  
  public void a(lrl paramlrl)
  {
    if (paramlrl.jdField_a_of_type_Lrl != null) {
      throw new IllegalStateException();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramlrl);
    paramlrl.jdField_a_of_type_Lrl = this;
    paramlrl.a(this.jdField_b_of_type_Lrn);
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilComparator);
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      paramlrl.b(this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView);
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, lrl paramlrl, boolean paramBoolean)
  {
    Rect localRect = paramlrl.jdField_a_of_type_AndroidGraphicsRect;
    if ((!paramBoolean) || (localRect.contains(paramInt1, paramInt2)))
    {
      if (paramlrl.b(paramMotionEvent)) {}
      while ((this.jdField_a_of_type_Lrm != null) && (this.jdField_a_of_type_Lrm.a(paramlrl, paramMotionEvent))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(lrl paramlrl)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    while (!this.jdField_a_of_type_JavaUtilArrayList.remove(paramlrl)) {
      return false;
    }
    if (this.jdField_b_of_type_Lrl == paramlrl)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      b(localMotionEvent);
      localMotionEvent.recycle();
    }
    paramlrl.d();
    paramlrl.jdField_a_of_type_Lrl = null;
    paramlrl.a(null);
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
    if (this.jdField_b_of_type_Lrl != null)
    {
      if (i == 0)
      {
        localObject = MotionEvent.obtain(paramMotionEvent);
        ((MotionEvent)localObject).setAction(3);
        a((MotionEvent)localObject, j, k, this.jdField_b_of_type_Lrl, false);
        this.jdField_b_of_type_Lrl = null;
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
      if (((lrl)localObject).a() == 0) {
        break label129;
      }
    }
    label129:
    while (!a(paramMotionEvent, j, k, (lrl)localObject, true))
    {
      i -= 1;
      break;
      a(paramMotionEvent, j, k, this.jdField_b_of_type_Lrl, false);
      if ((i == 3) || (i == 1)) {
        this.jdField_b_of_type_Lrl = null;
      }
      return true;
    }
    this.jdField_b_of_type_Lrl = ((lrl)localObject);
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
  
  protected void d(lpx paramlpx) {}
  
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
  
  protected void e(lpx paramlpx)
  {
    if ((this.jdField_b_of_type_Boolean) || (d())) {
      d(paramlpx);
    }
    for (;;)
    {
      return;
      int i = 0;
      int j = e();
      while (i < j)
      {
        a(paramlpx, a(i));
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
      lrl locallrl = a(i);
      if (locallrl.a() == 0) {
        locallrl.f(paramInt);
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
      lrl locallrl = (lrl)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_b_of_type_Lrl == locallrl)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        b(localMotionEvent);
        localMotionEvent.recycle();
      }
      locallrl.d();
      locallrl.jdField_a_of_type_Lrl = null;
      locallrl.a(null);
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
 * Qualified Name:     lro
 * JD-Core Version:    0.7.0.1
 */