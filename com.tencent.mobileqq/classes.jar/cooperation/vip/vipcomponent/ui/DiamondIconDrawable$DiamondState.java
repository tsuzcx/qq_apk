package cooperation.vip.vipcomponent.ui;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class DiamondIconDrawable$DiamondState
  extends Drawable.ConstantState
{
  int jdField_a_of_type_Int;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  Drawable b = null;
  Drawable c = null;
  Drawable d = null;
  Drawable e = null;
  Drawable f = null;
  Drawable g = null;
  
  DiamondIconDrawable$DiamondState() {}
  
  DiamondIconDrawable$DiamondState(DiamondState paramDiamondState)
  {
    if ((paramDiamondState.b != null) && (paramDiamondState.b.getConstantState() != null))
    {
      this.b = paramDiamondState.b.getConstantState().newDrawable();
      this.b.setBounds(paramDiamondState.b.getBounds());
    }
    if ((paramDiamondState.c != null) && (paramDiamondState.c.getConstantState() != null))
    {
      this.c = paramDiamondState.c.getConstantState().newDrawable();
      this.c.setBounds(paramDiamondState.c.getBounds());
    }
    if ((paramDiamondState.d != null) && (paramDiamondState.d.getConstantState() != null))
    {
      this.d = paramDiamondState.d.getConstantState().newDrawable();
      this.d.setBounds(paramDiamondState.d.getBounds());
    }
    if ((paramDiamondState.e != null) && (paramDiamondState.e.getConstantState() != null))
    {
      this.e = paramDiamondState.e.getConstantState().newDrawable();
      this.e.setBounds(paramDiamondState.e.getBounds());
    }
    if ((paramDiamondState.f != null) && (paramDiamondState.f.getConstantState() != null))
    {
      this.f = paramDiamondState.f.getConstantState().newDrawable();
      this.f.setBounds(paramDiamondState.f.getBounds());
    }
    if ((paramDiamondState.g != null) && (paramDiamondState.g.getConstantState() != null))
    {
      this.g = paramDiamondState.g.getConstantState().newDrawable();
      this.g.setBounds(paramDiamondState.g.getBounds());
    }
    if ((paramDiamondState.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (paramDiamondState.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState() != null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDiamondState.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramDiamondState.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds());
    }
    this.jdField_a_of_type_Int = paramDiamondState.jdField_a_of_type_Int;
  }
  
  public int getChangingConfigurations()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable newDrawable()
  {
    return new DiamondIconDrawable(new DiamondState(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.vipcomponent.ui.DiamondIconDrawable.DiamondState
 * JD-Core Version:    0.7.0.1
 */