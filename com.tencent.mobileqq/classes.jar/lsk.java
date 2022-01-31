import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.ttpic.openapi.filter.TextureRender;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class lsk
  extends lsh
{
  protected TextureRender a;
  private ArrayList<lsh> jdField_a_of_type_JavaUtilArrayList;
  private Comparator<lsh> jdField_a_of_type_JavaUtilComparator = new lsm(this);
  protected TextureRender b;
  private lsh jdField_b_of_type_Lsh;
  private lsj jdField_b_of_type_Lsj = new lsl(this);
  protected boolean b;
  
  public lsk(Context paramContext)
  {
    super(paramContext);
  }
  
  public lsh a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())) {
      throw new ArrayIndexOutOfBoundsException(paramInt);
    }
    return (lsh)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(lqt paramlqt)
  {
    paramlqt.a(b() / 2, c() / 2, 0.0F);
    c(paramlqt);
    paramlqt.a(-b() / 2, -c() / 2, 0.0F);
    e(paramlqt);
  }
  
  public void a(lqt paramlqt, lsh paramlsh)
  {
    if (!paramlsh.a()) {
      return;
    }
    int i = -this.e;
    int j = -this.d;
    paramlqt.a(i, j);
    paramlsh.a(paramlqt);
    paramlqt.a(-i, -j);
  }
  
  public void a(lsh paramlsh)
  {
    if (paramlsh.jdField_a_of_type_Lsh != null) {
      throw new IllegalStateException();
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramlsh);
    paramlsh.jdField_a_of_type_Lsh = this;
    paramlsh.a(this.jdField_b_of_type_Lsj);
    Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_JavaUtilComparator);
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      paramlsh.b(this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView);
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2, lsh paramlsh, boolean paramBoolean)
  {
    Rect localRect = paramlsh.jdField_a_of_type_AndroidGraphicsRect;
    if ((!paramBoolean) || (localRect.contains(paramInt1, paramInt2)))
    {
      if (paramlsh.b(paramMotionEvent)) {}
      while ((this.jdField_a_of_type_Lsi != null) && (this.jdField_a_of_type_Lsi.a(paramlsh, paramMotionEvent))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(lsh paramlsh)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    while (!this.jdField_a_of_type_JavaUtilArrayList.remove(paramlsh)) {
      return false;
    }
    if (this.jdField_b_of_type_Lsh == paramlsh)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      b(localMotionEvent);
      localMotionEvent.recycle();
    }
    paramlsh.d();
    paramlsh.jdField_a_of_type_Lsh = null;
    paramlsh.a(null);
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
    if (this.jdField_b_of_type_Lsh != null)
    {
      if (i == 0)
      {
        localObject = MotionEvent.obtain(paramMotionEvent);
        ((MotionEvent)localObject).setAction(3);
        a((MotionEvent)localObject, j, k, this.jdField_b_of_type_Lsh, false);
        this.jdField_b_of_type_Lsh = null;
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
      if (((lsh)localObject).a() == 0) {
        break label129;
      }
    }
    label129:
    while (!a(paramMotionEvent, j, k, (lsh)localObject, true))
    {
      i -= 1;
      break;
      a(paramMotionEvent, j, k, this.jdField_b_of_type_Lsh, false);
      if ((i == 3) || (i == 1)) {
        this.jdField_b_of_type_Lsh = null;
      }
      return true;
    }
    this.jdField_b_of_type_Lsh = ((lsh)localObject);
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
  
  protected void d(lqt paramlqt) {}
  
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
  
  protected void e(lqt paramlqt)
  {
    if ((this.jdField_b_of_type_Boolean) || (d())) {
      d(paramlqt);
    }
    for (;;)
    {
      return;
      int i = 0;
      int j = e();
      while (i < j)
      {
        a(paramlqt, a(i));
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
      lsh locallsh = a(i);
      if (locallsh.a() == 0) {
        locallsh.f(paramInt);
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
      lsh locallsh = (lsh)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_b_of_type_Lsh == locallsh)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        b(localMotionEvent);
        localMotionEvent.recycle();
      }
      locallsh.d();
      locallsh.jdField_a_of_type_Lsh = null;
      locallsh.a(null);
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
 * Qualified Name:     lsk
 * JD-Core Version:    0.7.0.1
 */