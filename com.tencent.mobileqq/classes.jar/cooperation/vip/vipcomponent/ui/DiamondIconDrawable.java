package cooperation.vip.vipcomponent.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;

public class DiamondIconDrawable
  extends Drawable
{
  private DiamondIconDrawable.DiamondState a;
  private int b = -1;
  private int c = -1;
  
  public DiamondIconDrawable()
  {
    this.a = new DiamondIconDrawable.DiamondState();
  }
  
  public DiamondIconDrawable(DiamondIconDrawable.DiamondState paramDiamondState)
  {
    this.a = paramDiamondState;
    if (paramDiamondState != null)
    {
      h(paramDiamondState.e);
      h(paramDiamondState.c);
      h(paramDiamondState.d);
      h(paramDiamondState.f);
      h(paramDiamondState.g);
      h(paramDiamondState.h);
      h(paramDiamondState.b);
    }
  }
  
  private void a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if (paramDrawable != null) {
      paramDrawable.setBounds(paramDrawable.getBounds().left + paramInt1, paramDrawable.getBounds().top + paramInt2, paramDrawable.getBounds().right + paramInt1, paramDrawable.getBounds().bottom + paramInt2);
    }
  }
  
  private void h(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      paramDrawable = paramDrawable.getBounds();
      Rect localRect = getBounds();
      if ((localRect != null) && (paramDrawable != null))
      {
        localRect.left = Math.min(paramDrawable.left, localRect.left);
        localRect.right = Math.max(paramDrawable.right, localRect.right);
        localRect.top = Math.min(paramDrawable.top, localRect.top);
        localRect.bottom = Math.max(paramDrawable.bottom, localRect.bottom);
        setBounds(localRect);
        this.b = Math.max(this.b, localRect.right - localRect.left);
        this.c = Math.max(this.c, localRect.bottom - localRect.top);
      }
    }
  }
  
  public int a()
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.a;
    if ((localDiamondState != null) && (localDiamondState.c != null)) {
      return Math.abs(this.a.c.getBounds().left - getBounds().left);
    }
    return 0;
  }
  
  public void a(Drawable paramDrawable)
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.a;
    if (localDiamondState != null)
    {
      localDiamondState.c = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public int b()
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.a;
    if ((localDiamondState != null) && (localDiamondState.c != null)) {
      return Math.abs(this.a.c.getBounds().top - getBounds().top);
    }
    return 0;
  }
  
  public void b(Drawable paramDrawable)
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.a;
    if (localDiamondState != null)
    {
      localDiamondState.d = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void c(Drawable paramDrawable)
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.a;
    if (localDiamondState != null)
    {
      localDiamondState.e = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public boolean c()
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.a;
    if ((localDiamondState != null) && (localDiamondState.b != null)) {
      return false;
    }
    localDiamondState = this.a;
    return (localDiamondState == null) || ((localDiamondState.e == null) && (this.a.g == null) && (this.a.f == null) && (this.a.d == null));
  }
  
  public Drawable.ConstantState d()
  {
    return this.a;
  }
  
  public void d(Drawable paramDrawable)
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.a;
    if (localDiamondState != null)
    {
      localDiamondState.f = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.a;
    if (localDiamondState != null)
    {
      if (localDiamondState.e != null) {
        localDiamondState.e.draw(paramCanvas);
      }
      if (localDiamondState.g != null) {
        localDiamondState.g.draw(paramCanvas);
      }
      if (localDiamondState.h != null) {
        localDiamondState.h.draw(paramCanvas);
      }
      if (localDiamondState.f != null) {
        localDiamondState.f.draw(paramCanvas);
      }
      if (localDiamondState.c != null) {
        localDiamondState.c.draw(paramCanvas);
      }
      if (localDiamondState.d != null) {
        localDiamondState.d.draw(paramCanvas);
      }
      if (localDiamondState.b != null) {
        localDiamondState.b.draw(paramCanvas);
      }
    }
  }
  
  public void e(Drawable paramDrawable)
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.a;
    if (localDiamondState != null)
    {
      localDiamondState.g = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void f(Drawable paramDrawable)
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.a;
    if (localDiamondState != null)
    {
      localDiamondState.h = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void g(Drawable paramDrawable)
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.a;
    if (localDiamondState != null)
    {
      localDiamondState.b = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.a.a;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.a.a = getChangingConfigurations();
    return this.a;
  }
  
  public int getIntrinsicHeight()
  {
    return this.c;
  }
  
  public int getIntrinsicWidth()
  {
    return this.b;
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getBounds() != null)
    {
      int j = getBounds().left;
      int i = getBounds().top;
      if ((j != paramInt1) || (i != paramInt2))
      {
        Drawable localDrawable = this.a.e;
        j = paramInt1 - j;
        i = paramInt2 - i;
        a(localDrawable, j, i);
        a(this.a.f, j, i);
        a(this.a.g, j, i);
        a(this.a.c, j, i);
        a(this.a.d, j, i);
        a(this.a.h, j, i);
        a(this.a.b, j, i);
      }
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.vipcomponent.ui.DiamondIconDrawable
 * JD-Core Version:    0.7.0.1
 */