package cooperation.vip.vipcomponent.ui;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class DiamondIconDrawable$DiamondState
  extends Drawable.ConstantState
{
  int a;
  Drawable b = null;
  Drawable c = null;
  Drawable d = null;
  Drawable e = null;
  Drawable f = null;
  Drawable g = null;
  Drawable h = null;
  
  DiamondIconDrawable$DiamondState() {}
  
  DiamondIconDrawable$DiamondState(DiamondState paramDiamondState)
  {
    Drawable localDrawable = paramDiamondState.c;
    if ((localDrawable != null) && (localDrawable.getConstantState() != null))
    {
      this.c = paramDiamondState.c.getConstantState().newDrawable();
      this.c.setBounds(paramDiamondState.c.getBounds());
    }
    localDrawable = paramDiamondState.d;
    if ((localDrawable != null) && (localDrawable.getConstantState() != null))
    {
      this.d = paramDiamondState.d.getConstantState().newDrawable();
      this.d.setBounds(paramDiamondState.d.getBounds());
    }
    localDrawable = paramDiamondState.e;
    if ((localDrawable != null) && (localDrawable.getConstantState() != null))
    {
      this.e = paramDiamondState.e.getConstantState().newDrawable();
      this.e.setBounds(paramDiamondState.e.getBounds());
    }
    localDrawable = paramDiamondState.f;
    if ((localDrawable != null) && (localDrawable.getConstantState() != null))
    {
      this.f = paramDiamondState.f.getConstantState().newDrawable();
      this.f.setBounds(paramDiamondState.f.getBounds());
    }
    localDrawable = paramDiamondState.g;
    if ((localDrawable != null) && (localDrawable.getConstantState() != null))
    {
      this.g = paramDiamondState.g.getConstantState().newDrawable();
      this.g.setBounds(paramDiamondState.g.getBounds());
    }
    localDrawable = paramDiamondState.h;
    if ((localDrawable != null) && (localDrawable.getConstantState() != null))
    {
      this.h = paramDiamondState.h.getConstantState().newDrawable();
      this.h.setBounds(paramDiamondState.h.getBounds());
    }
    localDrawable = paramDiamondState.b;
    if ((localDrawable != null) && (localDrawable.getConstantState() != null))
    {
      this.b = paramDiamondState.b.getConstantState().newDrawable();
      this.b.setBounds(paramDiamondState.b.getBounds());
    }
    this.a = paramDiamondState.a;
  }
  
  public int getChangingConfigurations()
  {
    return this.a;
  }
  
  public Drawable newDrawable()
  {
    return new DiamondIconDrawable(new DiamondState(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.vipcomponent.ui.DiamondIconDrawable.DiamondState
 * JD-Core Version:    0.7.0.1
 */