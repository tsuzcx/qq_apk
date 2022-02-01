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
  private int jdField_a_of_type_Int = -1;
  private DiamondIconDrawable.DiamondState jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState;
  private int b = -1;
  
  public DiamondIconDrawable()
  {
    this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState = new DiamondIconDrawable.DiamondState();
  }
  
  public DiamondIconDrawable(DiamondIconDrawable.DiamondState paramDiamondState)
  {
    this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState = paramDiamondState;
    if (paramDiamondState != null)
    {
      h(paramDiamondState.d);
      h(paramDiamondState.b);
      h(paramDiamondState.c);
      h(paramDiamondState.e);
      h(paramDiamondState.f);
      h(paramDiamondState.g);
      h(paramDiamondState.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
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
        this.jdField_a_of_type_Int = Math.max(this.jdField_a_of_type_Int, localRect.right - localRect.left);
        this.b = Math.max(this.b, localRect.bottom - localRect.top);
      }
    }
  }
  
  public int a()
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState;
    if ((localDiamondState != null) && (localDiamondState.b != null)) {
      return Math.abs(this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState.b.getBounds().left - getBounds().left);
    }
    return 0;
  }
  
  public Drawable.ConstantState a()
  {
    return this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState;
  }
  
  public void a(Drawable paramDrawable)
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState;
    if (localDiamondState != null)
    {
      localDiamondState.b = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public boolean a()
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState;
    if ((localDiamondState != null) && (localDiamondState.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
      return false;
    }
    localDiamondState = this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState;
    return (localDiamondState == null) || ((localDiamondState.d == null) && (this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState.f == null) && (this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState.e == null) && (this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState.c == null));
  }
  
  public int b()
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState;
    if ((localDiamondState != null) && (localDiamondState.b != null)) {
      return Math.abs(this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState.b.getBounds().top - getBounds().top);
    }
    return 0;
  }
  
  public void b(Drawable paramDrawable)
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState;
    if (localDiamondState != null)
    {
      localDiamondState.c = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void c(Drawable paramDrawable)
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState;
    if (localDiamondState != null)
    {
      localDiamondState.d = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void d(Drawable paramDrawable)
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState;
    if (localDiamondState != null)
    {
      localDiamondState.e = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState;
    if (localDiamondState != null)
    {
      if (localDiamondState.d != null) {
        localDiamondState.d.draw(paramCanvas);
      }
      if (localDiamondState.f != null) {
        localDiamondState.f.draw(paramCanvas);
      }
      if (localDiamondState.g != null) {
        localDiamondState.g.draw(paramCanvas);
      }
      if (localDiamondState.e != null) {
        localDiamondState.e.draw(paramCanvas);
      }
      if (localDiamondState.b != null) {
        localDiamondState.b.draw(paramCanvas);
      }
      if (localDiamondState.c != null) {
        localDiamondState.c.draw(paramCanvas);
      }
      if (localDiamondState.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        localDiamondState.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
  
  public void e(Drawable paramDrawable)
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState;
    if (localDiamondState != null)
    {
      localDiamondState.f = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void f(Drawable paramDrawable)
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState;
    if (localDiamondState != null)
    {
      localDiamondState.g = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public void g(Drawable paramDrawable)
  {
    DiamondIconDrawable.DiamondState localDiamondState = this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState;
    if (localDiamondState != null)
    {
      localDiamondState.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      h(paramDrawable);
    }
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState.jdField_a_of_type_Int;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState.jdField_a_of_type_Int = getChangingConfigurations();
    return this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState;
  }
  
  public int getIntrinsicHeight()
  {
    return this.b;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_Int;
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
        Drawable localDrawable = this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState.d;
        j = paramInt1 - j;
        i = paramInt2 - i;
        a(localDrawable, j, i);
        a(this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState.e, j, i);
        a(this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState.f, j, i);
        a(this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState.b, j, i);
        a(this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState.c, j, i);
        a(this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState.g, j, i);
        a(this.jdField_a_of_type_CooperationVipVipcomponentUiDiamondIconDrawable$DiamondState.jdField_a_of_type_AndroidGraphicsDrawableDrawable, j, i);
      }
    }
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.vipcomponent.ui.DiamondIconDrawable
 * JD-Core Version:    0.7.0.1
 */