import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;

public class mbe
  extends mbf
{
  WeakReference<View.OnClickListener> a = null;
  int f = 0;
  int g = 0;
  int h = -1;
  int i = -1;
  int j = -1;
  
  public mbe(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, int paramInt5, int paramInt6, View.OnClickListener paramOnClickListener)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4, paramString);
    this.f = paramInt5;
    this.g = paramInt6;
    if (paramOnClickListener != null) {
      this.a = new WeakReference(paramOnClickListener);
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public View.OnClickListener a()
  {
    if ((this.a == null) || (this.a.isEnqueued())) {
      return null;
    }
    return (View.OnClickListener)this.a.get();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      this.a = new WeakReference(paramOnClickListener);
      return;
    }
    this.a = null;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.g;
  }
  
  public int h()
  {
    return this.h;
  }
  
  public int i()
  {
    return this.i;
  }
  
  public int j()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mbe
 * JD-Core Version:    0.7.0.1
 */